package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_AttributeSet;
import org.compiere.model.I_M_AttributeSetInstance;
import org.compiere.orm.PO;
import software.hsharp.core.orm.MBaseTableKt;

import java.sql.Timestamp;

/**
 * Generated Model for M_AttributeSetInstance
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeSetInstance extends PO implements I_M_AttributeSetInstance {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_AttributeSetInstance(int M_AttributeSetInstance_ID) {
        super(M_AttributeSetInstance_ID);
        /**
         * if (M_AttributeSetInstance_ID == 0) { setAttributeSetId (0); setAttributeSetInstanceId
         * (0); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_AttributeSetInstance(Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_AttributeSetInstance[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return getValue(COLUMNNAME_Description);
    }

    /**
     * Set Description.
     *
     * @param Description Optional short description of the record
     */
    public void setDescription(String Description) {
        setValue(COLUMNNAME_Description, Description);
    }

    /**
     * Get Guarantee Date.
     *
     * @return Date when guarantee expires
     */
    public Timestamp getGuaranteeDate() {
        return (Timestamp) getValue(COLUMNNAME_GuaranteeDate);
    }

    /**
     * Set Guarantee Date.
     *
     * @param GuaranteeDate Date when guarantee expires
     */
    public void setGuaranteeDate(Timestamp GuaranteeDate) {
        setValue(COLUMNNAME_GuaranteeDate, GuaranteeDate);
    }

    /**
     * Get Lot No.
     *
     * @return Lot number (alphanumeric)
     */
    public String getLot() {
        return getValue(COLUMNNAME_Lot);
    }

    /**
     * Set Lot No.
     *
     * @param Lot Lot number (alphanumeric)
     */
    public void setLot(String Lot) {
        setValue(COLUMNNAME_Lot, Lot);
    }

    public I_M_AttributeSet getMAttributeSet() throws RuntimeException {
        return (I_M_AttributeSet)
                MBaseTableKt.getTable(I_M_AttributeSet.Table_Name)
                        .getPO(getAttributeSetId());
    }

    /**
     * Get Attribute Set.
     *
     * @return Product Attribute Set
     */
    public int getAttributeSetId() {
        Integer ii = getValue(COLUMNNAME_M_AttributeSet_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Attribute Set.
     *
     * @param M_AttributeSet_ID Product Attribute Set
     */
    public void setAttributeSetId(int M_AttributeSet_ID) {
        if (M_AttributeSet_ID < 0) setValue(COLUMNNAME_M_AttributeSet_ID, null);
        else setValue(COLUMNNAME_M_AttributeSet_ID, M_AttributeSet_ID);
    }

    /**
     * Get Attribute Set Instance.
     *
     * @return Product Attribute Set Instance
     */
    public int getAttributeSetInstanceId() {
        Integer ii = getValue(COLUMNNAME_M_AttributeSetInstance_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Lot.
     *
     * @param M_Lot_ID Product Lot Definition
     */
    public void setLotId(int M_Lot_ID) {
        if (M_Lot_ID < 1) setValue(COLUMNNAME_M_Lot_ID, null);
        else setValue(COLUMNNAME_M_Lot_ID, M_Lot_ID);
    }

    /**
     * Get Serial No.
     *
     * @return Product Serial Number
     */
    public String getSerNo() {
        return getValue(COLUMNNAME_SerNo);
    }

    /**
     * Set Serial No.
     *
     * @param SerNo Product Serial Number
     */
    public void setSerNo(String SerNo) {
        setValue(COLUMNNAME_SerNo, SerNo);
    }

    @Override
    public int getTableId() {
        return I_M_AttributeSetInstance.Table_ID;
    }
}
