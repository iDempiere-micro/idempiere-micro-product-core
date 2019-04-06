package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_S_ResourceType;
import org.compiere.orm.BasePONameValue;

import java.sql.Timestamp;

/**
 * Generated Model for S_ResourceType
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_S_ResourceType extends BasePONameValue implements I_S_ResourceType {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_S_ResourceType(int S_ResourceType_ID) {
        super(S_ResourceType_ID);
        /**
         * if (S_ResourceType_ID == 0) { setAllowUoMFractions (false); // N setTaxCategoryId (0);
         * setUOMId (0); setIsDateSlot (false); setIsSingleAssignment (false); setIsTimeSlot (false);
         * setProductCategoryId (0); setName (null); setOnFriday (true); // Y setOnMonday (true); //
         * Y setOnSaturday (false); setOnSunday (false); setOnThursday (true); // Y setOnTuesday (true);
         * // Y setOnWednesday (true); // Y setS_ResourceType_ID (0); setValue (null); }
         */
    }

    /**
     * Load Constructor
     */
    public X_S_ResourceType(Row row) {
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
        StringBuffer sb = new StringBuffer("X_S_ResourceType[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Tax Category.
     *
     * @return Tax Category
     */
    public int getTaxCategoryId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_TaxCategory_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get UOM.
     *
     * @return Unit of Measure
     */
    public int getUOMId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_UOM_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Day Slot.
     *
     * @return Resource has day slot availability
     */
    public boolean isDateSlot() {
        Object oo = getValue(COLUMNNAME_IsDateSlot);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Time Slot.
     *
     * @return Resource has time slot availability
     */
    public boolean isTimeSlot() {
        Object oo = getValue(COLUMNNAME_IsTimeSlot);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Product Category.
     *
     * @return Category of a Product
     */
    public int getProductCategoryId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Product_Category_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Friday.
     *
     * @return Available on Fridays
     */
    public boolean isOnFriday() {
        Object oo = getValue(COLUMNNAME_OnFriday);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Monday.
     *
     * @return Available on Mondays
     */
    public boolean isOnMonday() {
        Object oo = getValue(COLUMNNAME_OnMonday);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Saturday.
     *
     * @return Available on Saturday
     */
    public boolean isOnSaturday() {
        Object oo = getValue(COLUMNNAME_OnSaturday);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Sunday.
     *
     * @return Available on Sundays
     */
    public boolean isOnSunday() {
        Object oo = getValue(COLUMNNAME_OnSunday);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Thursday.
     *
     * @return Available on Thursdays
     */
    public boolean isOnThursday() {
        Object oo = getValue(COLUMNNAME_OnThursday);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Tuesday.
     *
     * @return Available on Tuesdays
     */
    public boolean isOnTuesday() {
        Object oo = getValue(COLUMNNAME_OnTuesday);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Wednesday.
     *
     * @return Available on Wednesdays
     */
    public boolean isOnWednesday() {
        Object oo = getValue(COLUMNNAME_OnWednesday);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Resource Type.
     *
     * @return Resource Type
     */
    public int getResourceTypeId() {
        Integer ii = (Integer) getValue(COLUMNNAME_S_ResourceType_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Slot End.
     *
     * @return Time when timeslot ends
     */
    public Timestamp getTimeSlotEnd() {
        return (Timestamp) getValue(COLUMNNAME_TimeSlotEnd);
    }

    /**
     * Get Slot Start.
     *
     * @return Time when timeslot starts
     */
    public Timestamp getTimeSlotStart() {
        return (Timestamp) getValue(COLUMNNAME_TimeSlotStart);
    }

    @Override
    public int getTableId() {
        return I_S_ResourceType.Table_ID;
    }
}
