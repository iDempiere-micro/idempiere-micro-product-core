package org.compiere.product;

import org.compiere.model.I_M_AttributeSetInstance;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Generated Model for M_AttributeSetInstance
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeSetInstance extends PO implements I_M_AttributeSetInstance, I_Persistent {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_AttributeSetInstance(Properties ctx, int M_AttributeSetInstance_ID) {
        super(ctx, M_AttributeSetInstance_ID);
        /**
         * if (M_AttributeSetInstance_ID == 0) { setM_AttributeSet_ID (0); setM_AttributeSetInstance_ID
         * (0); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_AttributeSetInstance(Properties ctx, ResultSet rs) {
        super(ctx, rs);
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
        StringBuffer sb = new StringBuffer("X_M_AttributeSetInstance[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return (String) get_Value(COLUMNNAME_Description);
    }

    /**
     * Set Description.
     *
     * @param Description Optional short description of the record
     */
    public void setDescription(String Description) {
        set_Value(COLUMNNAME_Description, Description);
    }

    /**
     * Get Guarantee Date.
     *
     * @return Date when guarantee expires
     */
    public Timestamp getGuaranteeDate() {
        return (Timestamp) get_Value(COLUMNNAME_GuaranteeDate);
    }

    /**
     * Set Guarantee Date.
     *
     * @param GuaranteeDate Date when guarantee expires
     */
    public void setGuaranteeDate(Timestamp GuaranteeDate) {
        set_Value(COLUMNNAME_GuaranteeDate, GuaranteeDate);
    }

    /**
     * Get Lot No.
     *
     * @return Lot number (alphanumeric)
     */
    public String getLot() {
        return (String) get_Value(COLUMNNAME_Lot);
    }

    /**
     * Set Lot No.
     *
     * @param Lot Lot number (alphanumeric)
     */
    public void setLot(String Lot) {
        set_Value(COLUMNNAME_Lot, Lot);
    }

    public org.compiere.model.I_M_AttributeSet getMAttributeSet() throws RuntimeException {
        return (org.compiere.model.I_M_AttributeSet)
                MTable.get(getCtx(), org.compiere.model.I_M_AttributeSet.Table_Name)
                        .getPO(getMAttributeSet_ID());
    }

    /**
     * Set Attribute Set.
     *
     * @param M_AttributeSet_ID Product Attribute Set
     */
    public void setM_AttributeSet_ID(int M_AttributeSet_ID) {
        if (M_AttributeSet_ID < 0) set_Value(COLUMNNAME_M_AttributeSet_ID, null);
        else set_Value(COLUMNNAME_M_AttributeSet_ID, Integer.valueOf(M_AttributeSet_ID));
    }

    /**
     * Get Attribute Set.
     *
     * @return Product Attribute Set
     */
    public int getMAttributeSet_ID() {
        Integer ii = (Integer) get_Value(COLUMNNAME_M_AttributeSet_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Attribute Set Instance.
     *
     * @return Product Attribute Set Instance
     */
    public int getMAttributeSetInstance_ID() {
        Integer ii = (Integer) get_Value(COLUMNNAME_M_AttributeSetInstance_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Lot.
     *
     * @return Product Lot Definition
     */
    public int getM_Lot_ID() {
        Integer ii = (Integer) get_Value(COLUMNNAME_M_Lot_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Lot.
     *
     * @param M_Lot_ID Product Lot Definition
     */
    public void setM_Lot_ID(int M_Lot_ID) {
        if (M_Lot_ID < 1) set_Value(COLUMNNAME_M_Lot_ID, null);
        else set_Value(COLUMNNAME_M_Lot_ID, Integer.valueOf(M_Lot_ID));
    }

    /**
     * Get Serial No.
     *
     * @return Product Serial Number
     */
    public String getSerNo() {
        return (String) get_Value(COLUMNNAME_SerNo);
    }

    /**
     * Set Serial No.
     *
     * @param SerNo Product Serial Number
     */
    public void setSerNo(String SerNo) {
        set_Value(COLUMNNAME_SerNo, SerNo);
    }

    @Override
    public int getTableId() {
        return I_M_AttributeSetInstance.Table_ID;
    }
}
