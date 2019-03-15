package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_Lot;
import org.compiere.orm.Query;

import java.util.Properties;

/**
 * Product Lot
 *
 * @author Jorg Janke
 * @version $Id: MLot.java,v 1.3 2006/07/30 00:51:02 jjanke Exp $ FR: [ 2214883 ] Remove SQL code
 * and Replace for Query - red1
 */
public class MLot extends X_M_Lot {
    /**
     *
     */
    private static final long serialVersionUID = -2238962371935615958L;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param ctx      context
     * @param M_Lot_ID ID
     * @param trxName  transaction
     */
    public MLot(Properties ctx, int M_Lot_ID) {
        super(ctx, M_Lot_ID);
        /** if (M_Lot_ID == 0) { setM_Lot_ID (0); setM_Product_ID (0); setName (null); } */
    } //	MLot

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MLot(Properties ctx, Row row) {
        super(ctx, row);
    } //	MLot

    /**
     * Parent Constructor
     *
     * @param ctl          lot control
     * @param M_Product_ID product
     * @param Name         name
     */
    public MLot(MLotCtl ctl, int M_Product_ID, String Name) {
        this(ctl.getCtx(), 0);
        setClientOrg(ctl);
        setM_LotCtl_ID(ctl.getM_LotCtl_ID());
        setM_Product_ID(M_Product_ID);
        setName(Name);
    } //	MLot

    /**
     * Get Lot for Product
     *
     * @param ctx          context
     * @param M_Product_ID product
     * @param lot
     * @param trxName      transaction
     * @return Last Lot for Product
     */
    public static MLot getProductLot(Properties ctx, int M_Product_ID, String lot) {
        final String whereClause = "M_Product_ID=? AND Name=?";
        MLot retValue =
                new Query(ctx, I_M_Lot.Table_Name, whereClause)
                        .setParameters(M_Product_ID, lot)
                        .setOrderBy(I_M_Lot.COLUMNNAME_M_Lot_ID + " DESC")
                        .first();
        return retValue;
    } //	getProductLot

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        return getName();
    } //	toString
} //	MLot
