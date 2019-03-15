package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_PriceList;
import org.compiere.orm.TimeUtil;
import org.compiere.util.DisplayType;

import java.util.Properties;

/**
 * Price List Version Model
 *
 * @author Jorg Janke
 * @version $Id: MPriceListVersion.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 */
public class MPriceListVersion extends X_M_PriceList_Version {
    /**
     *
     */
    private static final long serialVersionUID = -3607494586575155059L;

    /**
     * Standard Constructor
     *
     * @param ctx                    context
     * @param M_PriceList_Version_ID id
     * @param trxName                transaction
     */
    public MPriceListVersion(Properties ctx, int M_PriceList_Version_ID) {
        super(ctx, M_PriceList_Version_ID);
        if (M_PriceList_Version_ID == 0) {
            //	setName (null);	// @#Date@
            //	setPriceListId (0);
            //	setValidFrom (TimeUtil.getDay(null));	// @#Date@
            //	setM_DiscountSchema_ID (0);
        }
    } //	MPriceListVersion

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MPriceListVersion(Properties ctx, Row row) {
        super(ctx, row);
    } //	MPriceListVersion

    /**
     * Parent Constructor
     *
     * @param pl parent
     */
    public MPriceListVersion(I_M_PriceList pl) {
        this(pl.getCtx(), 0);
        setClientOrg(pl);
        setPriceListId(pl.getPriceListId());
    } //	MPriceListVersion

    /**
     * Set Name to Valid From Date. If valid from not set, use today
     */
    public void setName() {
        if (getValidFrom() == null) setValidFrom(TimeUtil.getDay(null));
        if (getName() == null) {
            String name = DisplayType.getDateFormat(DisplayType.Date).format(getValidFrom());
            setName(name);
        }
    } //	setName

    /**
     * Before Save
     *
     * @param newRecord new
     * @return true
     */
    protected boolean beforeSave(boolean newRecord) {
        setName();

        return true;
    } //	beforeSave
} //	MPriceListVersion
