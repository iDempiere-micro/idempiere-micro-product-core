package org.compiere.product;

import kotliquery.Row;
import org.compiere.bo.MCurrency;
import org.compiere.bo.MCurrencyKt;
import org.compiere.model.I_M_PriceList;
import org.compiere.model.I_M_PriceList_Version;
import org.compiere.orm.Query;
import org.idempiere.common.util.CCache;
import org.idempiere.common.util.Env;

import java.sql.Timestamp;
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
    private static CCache<Integer, I_M_PriceList> s_cache =
            new CCache<>(I_M_PriceList.Table_Name, 5, 5);
    /**
     * Cached Precision
     */
    private Integer m_precision = null;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param M_PriceList_ID id
     */
    public MPriceList(int M_PriceList_ID) {
        super(M_PriceList_ID);
        if (M_PriceList_ID == 0) {
            setEnforcePriceLimit(false);
            setIsDefault(false);
            setIsSOPriceList(false);
            setIsTaxIncluded(false);
            setPricePrecision(2); // 2
        }
    } //	MPriceList

    /**
     * Load Constructor
     *
     */
    public MPriceList(Row row) {
        super(row);
    } //	MPriceList

    /**
     * Import Constructor
     *
     * @param impPL import
     */
    public MPriceList(X_I_PriceList impPL) {
        this(0);
        setClientOrg(impPL);
        setUpdatedBy(impPL.getUpdatedBy());
        //
        setName(impPL.getName());
        setDescription(impPL.getDescription());
        setCurrencyId(impPL.getCurrencyId());
        setPricePrecision(impPL.getPricePrecision());
        setIsSOPriceList(impPL.isSOPriceList());
        setIsTaxIncluded(impPL.isTaxIncluded());
        setEnforcePriceLimit(impPL.isEnforcePriceLimit());
    } //	MPriceList

    /**
     * Get Price List (cached)
     *
     * @param M_PriceList_ID id
     * @return PriceList
     */
    public static I_M_PriceList get(int M_PriceList_ID) {
        Integer key = M_PriceList_ID;
        I_M_PriceList retValue = s_cache.get(key);
        if (retValue == null) {
            retValue = new MPriceList(M_PriceList_ID);
            s_cache.put(key, retValue);
        }
        return retValue;
    } //	get

    /**
     * Get Default Price List for Client (cached)
     *
     * @param IsSOPriceList SO or PO
     * @return PriceList or null
     */
    public static I_M_PriceList getDefault(boolean IsSOPriceList) {
        int AD_Client_ID = Env.getClientId();
        I_M_PriceList retValue;
        //	Search for it in cache
        for (I_M_PriceList mPriceList : s_cache.values()) {
            retValue = mPriceList;
            if (retValue.isDefault()
                    && retValue.getClientId() == AD_Client_ID
                    && retValue.isSOPriceList() == IsSOPriceList) {
                return retValue;
            }
        }

        //	Get from DB
        final String whereClause = "AD_Client_ID=? AND IsDefault=? AND IsSOPriceList=?";
        retValue =
                new Query<I_M_PriceList>(I_M_PriceList.Table_Name, whereClause)
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
     * @param M_PriceList_ID price list
     * @return precision
     */
    public static int getStandardPrecision(int M_PriceList_ID) {
        I_M_PriceList pl = MPriceList.get(M_PriceList_ID);
        return pl.getStandardPrecision();
    } //	getStandardPrecision

    /**
     * Get Price Precision
     *
     * @param M_PriceList_ID price list
     * @return precision
     */
    public static int getPricePrecision(int M_PriceList_ID) {
        I_M_PriceList pl = MPriceList.get(M_PriceList_ID);
        return pl.getPricePrecision();
    } //	getPricePrecision

    /**
     * Get Price List Version
     *
     * @param valid date where PLV must be valid or today if null
     * @return PLV
     */
    public I_M_PriceList_Version getPriceListVersion(Timestamp valid) {
        if (valid == null) valid = new Timestamp(System.currentTimeMillis());

        final String whereClause = "M_PriceList_ID=? AND TRUNC(ValidFrom)<=?";
        /*
         * Cached PLV
         */
        I_M_PriceList_Version m_plv = new Query<I_M_PriceList_Version>(I_M_PriceList_Version.Table_Name, whereClause)
                .setParameters(getPriceListId(), valid)
                .setOnlyActiveRecords(true)
                .setOrderBy("ValidFrom DESC")
                .first();
        if (m_plv == null)
            log.warning("None found M_PriceList_ID=" + getPriceListId() + " - " + valid);
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
            MCurrency c = MCurrencyKt.getCurrency(getCurrencyId());
            m_precision = c.getStdPrecision();
        }
        return m_precision;
    } //	getStandardPrecision

    @Override
    public int getTableId() {
        return I_M_PriceList.Table_ID;
    }
} //	MPriceList
