package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_PriceList;
import org.compiere.model.I_M_PriceList_Version;
import org.compiere.orm.Query;
import org.idempiere.common.util.CCache;
import org.idempiere.common.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;

/**
 * Price List Model
 *
 * @author Jorg Janke
 * @author Teo Sarca, www.arhipac.ro
 * <li>BF [ 2073484 ] MPriceList.getDefault is not working correctly
 * @version $Id: MPriceList.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 */
public class MPriceList extends X_M_PriceList {
    /**
     *
     */
    private static final long serialVersionUID = -5096935348390226068L;
    /**
     * Cache of Price Lists
     */
    private static CCache<Integer, MPriceList> s_cache =
            new CCache<Integer, MPriceList>(I_M_PriceList.Table_Name, 5, 5);
    /**
     * Cached PLV
     */
    private MPriceListVersion m_plv = null;
    /**
     * Cached Precision
     */
    private Integer m_precision = null;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param ctx            context
     * @param M_PriceList_ID id
     * @param trxName        transaction
     */
    public MPriceList(Properties ctx, int M_PriceList_ID) {
        super(ctx, M_PriceList_ID);
        if (M_PriceList_ID == 0) {
            setEnforcePriceLimit(false);
            setIsDefault(false);
            setIsSOPriceList(false);
            setIsTaxIncluded(false);
            setPricePrecision(2); // 2
            //	setName (null);
            //	setCurrencyId (0);
        }
    } //	MPriceList

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MPriceList(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    } //	MPriceList

    public MPriceList(Properties ctx, Row row) {
        super(ctx, row);
    } //	MPriceList

    /**
     * Import Constructor
     *
     * @param impPL import
     */
    public MPriceList(X_I_PriceList impPL) {
        this(impPL.getCtx(), 0);
        setClientOrg(impPL);
        setUpdatedBy(impPL.getUpdatedBy());
        //
        setName(impPL.getName());
        setDescription(impPL.getDescription());
        setC_Currency_ID(impPL.getC_Currency_ID());
        setPricePrecision(impPL.getPricePrecision());
        setIsSOPriceList(impPL.isSOPriceList());
        setIsTaxIncluded(impPL.isTaxIncluded());
        setEnforcePriceLimit(impPL.isEnforcePriceLimit());
    } //	MPriceList

    /**
     * Get Price List (cached)
     *
     * @param ctx            context
     * @param M_PriceList_ID id
     * @param trxName        transaction
     * @return PriceList
     */
    public static MPriceList get(Properties ctx, int M_PriceList_ID) {
        Integer key = new Integer(M_PriceList_ID);
        MPriceList retValue = (MPriceList) s_cache.get(key);
        if (retValue == null) {
            retValue = new MPriceList(ctx, M_PriceList_ID);
            s_cache.put(key, retValue);
        }
        return retValue;
    } //	get

    /**
     * Get Default Price List for Client (cached)
     *
     * @param ctx           context
     * @param IsSOPriceList SO or PO
     * @return PriceList or null
     */
    public static MPriceList getDefault(Properties ctx, boolean IsSOPriceList) {
        int AD_Client_ID = Env.getClientId(ctx);
        MPriceList retValue = null;
        //	Search for it in cache
        Iterator<MPriceList> it = s_cache.values().iterator();
        while (it.hasNext()) {
            retValue = it.next();
            if (retValue.isDefault()
                    && retValue.getClientId() == AD_Client_ID
                    && retValue.isSOPriceList() == IsSOPriceList) {
                return retValue;
            }
        }

        //	Get from DB
        final String whereClause = "AD_Client_ID=? AND IsDefault=? AND IsSOPriceList=?";
        retValue =
                new Query(ctx, I_M_PriceList.Table_Name, whereClause)
                        .setParameters(AD_Client_ID, "Y", IsSOPriceList ? "Y" : "N")
                        .setOnlyActiveRecords(true)
                        .setOrderBy("M_PriceList_ID")
                        .first();

        //	Return value
        if (retValue != null) {
            s_cache.put(retValue.getId(), retValue);
        }
        return retValue;
    } //	getDefault

    /**
     * Get Standard Currency Precision
     *
     * @param ctx            context
     * @param M_PriceList_ID price list
     * @return precision
     */
    public static int getStandardPrecision(Properties ctx, int M_PriceList_ID) {
        MPriceList pl = MPriceList.get(ctx, M_PriceList_ID);
        return pl.getStandardPrecision();
    } //	getStandardPrecision

    /**
     * Get Price Precision
     *
     * @param ctx            context
     * @param M_PriceList_ID price list
     * @return precision
     */
    public static int getPricePrecision(Properties ctx, int M_PriceList_ID) {
        MPriceList pl = MPriceList.get(ctx, M_PriceList_ID);
        return pl.getPricePrecision();
    } //	getPricePrecision

    /**
     * Get Price List Version
     *
     * @param valid date where PLV must be valid or today if null
     * @return PLV
     */
    public MPriceListVersion getPriceListVersion(Timestamp valid) {
        if (valid == null) valid = new Timestamp(System.currentTimeMillis());

        final String whereClause = "M_PriceList_ID=? AND TRUNC(ValidFrom)<=?";
        m_plv =
                new Query(getCtx(), I_M_PriceList_Version.Table_Name, whereClause)
                        .setParameters(getM_PriceList_ID(), valid)
                        .setOnlyActiveRecords(true)
                        .setOrderBy("ValidFrom DESC")
                        .first();
        if (m_plv == null)
            log.warning("None found M_PriceList_ID=" + getM_PriceList_ID() + " - " + valid);
        else if (log.isLoggable(Level.FINE)) log.fine(m_plv.toString());
        return m_plv;
    } //	getPriceListVersion

    /**
     * Get Standard Currency Precision
     *
     * @return precision
     */
    public int getStandardPrecision() {
        if (m_precision == null) {
            MCurrency c = MCurrency.get(getCtx(), getC_Currency_ID());
            m_precision = new Integer(c.getStdPrecision());
        }
        return m_precision.intValue();
    } //	getStandardPrecision

    @Override
    public int getTableId() {
        return I_M_PriceList.Table_ID;
    }
} //	MPriceList
