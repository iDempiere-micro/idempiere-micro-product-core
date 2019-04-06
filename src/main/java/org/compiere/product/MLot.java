package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_Lot;
import org.compiere.orm.Query;

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
     */
    public MLot(int M_Lot_ID) {
        super(M_Lot_ID);
    } //	MLot

    /**
     * Load Constructor
     *
     * @param ctx context
     */
    public MLot(Row row) {
        super(row);
    } //	MLot

    /**
     * Parent Constructor
     *
     * @param ctl          lot control
     * @param M_Product_ID product
     * @param Name         name
     */
    public MLot(MLotCtl ctl, int M_Product_ID, String Name) {
        this(0);
        setClientOrg(ctl);
        setLotControlId(ctl.getLotControlId());
        setProductId(M_Product_ID);
        setName(Name);
    } //	MLot

    /**
     * Get Lot for Product
     *
     * @param M_Product_ID product
     * @param lot
     * @return Last Lot for Product
     */
    public static MLot getProductLot(int M_Product_ID, String lot) {
        final String whereClause = "M_Product_ID=? AND Name=?";
        return new Query(I_M_Lot.Table_Name, whereClause)
                .setParameters(M_Product_ID, lot)
                .setOrderBy(I_M_Lot.COLUMNNAME_M_Lot_ID + " DESC")
                .first();
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
