package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_Lot;
import org.compiere.orm.BasePOName;

/**
 * Generated Model for M_Lot
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Lot extends BasePOName implements I_M_Lot {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_Lot(int M_Lot_ID) {
        super(M_Lot_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_Lot(Row row) {
        super(row);
    }

    /**
     * AccessLevel
     *
     * @return 3 - Client - Org
     */
    protected int getAccessLevel() {
        return accessLevel.intValue();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("X_M_Lot[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Set Lot Control.
     *
     * @param M_LotCtl_ID Product Lot Control
     */
    public void setLotControlId(int M_LotCtl_ID) {
        if (M_LotCtl_ID < 1) setValueNoCheck(COLUMNNAME_M_LotCtl_ID, null);
        else setValueNoCheck(COLUMNNAME_M_LotCtl_ID, Integer.valueOf(M_LotCtl_ID));
    }

    /**
     * Get Lot.
     *
     * @return Product Lot Definition
     */
    public int getLotId() {
        Integer ii = getValue(COLUMNNAME_M_Lot_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Product.
     *
     * @param M_Product_ID Product, Service, Item
     */
    public void setProductId(int M_Product_ID) {
        if (M_Product_ID < 1) setValueNoCheck(COLUMNNAME_M_Product_ID, null);
        else setValueNoCheck(COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
    }

    @Override
    public int getTableId() {
        return I_M_Lot.Table_ID;
    }
}
