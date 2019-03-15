package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.HasName;
import org.compiere.model.I_M_PriceList;
import org.compiere.orm.PO;

import java.util.Properties;

/**
 * Generated Model for M_PriceList
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public abstract class X_M_PriceList extends PO implements I_M_PriceList {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_PriceList(Properties ctx, int M_PriceList_ID) {
        super(ctx, M_PriceList_ID);
        /**
         * if (M_PriceList_ID == 0) { setCurrencyId (0); setEnforcePriceLimit (false); setIsDefault
         * (false); setIsSOPriceList (false); setIsTaxIncluded (false); setPriceListId (0); setName
         * (null); setPricePrecision (0); // 2 }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_PriceList(Properties ctx, Row row) {
        super(ctx, row);
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
        StringBuffer sb = new StringBuffer("X_M_PriceList[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Currency.
     *
     * @return The Currency for this record
     */
    public int getCurrencyId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_Currency_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Currency.
     *
     * @param C_Currency_ID The Currency for this record
     */
    public void setCurrencyId(int C_Currency_ID) {
        if (C_Currency_ID < 1) setValue(COLUMNNAME_C_Currency_ID, null);
        else setValue(COLUMNNAME_C_Currency_ID, C_Currency_ID);
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
     * Get Enforce price limit.
     *
     * @return Do not allow prices below the limit price
     */
    public boolean isEnforcePriceLimit() {
        Object oo = getValue(COLUMNNAME_EnforcePriceLimit);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Enforce price limit.
     *
     * @param EnforcePriceLimit Do not allow prices below the limit price
     */
    public void setEnforcePriceLimit(boolean EnforcePriceLimit) {
        setValue(COLUMNNAME_EnforcePriceLimit, Boolean.valueOf(EnforcePriceLimit));
    }

    /**
     * Set Default.
     *
     * @param IsDefault Default value
     */
    public void setIsDefault(boolean IsDefault) {
        setValue(COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
    }

    /**
     * Get Default.
     *
     * @return Default value
     */
    public boolean isDefault() {
        Object oo = getValue(COLUMNNAME_IsDefault);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Sales Price list.
     *
     * @param IsSOPriceList This is a Sales Price List
     */
    public void setIsSOPriceList(boolean IsSOPriceList) {
        setValue(COLUMNNAME_IsSOPriceList, Boolean.valueOf(IsSOPriceList));
    }

    /**
     * Get Sales Price list.
     *
     * @return This is a Sales Price List
     */
    public boolean isSOPriceList() {
        Object oo = getValue(COLUMNNAME_IsSOPriceList);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Price includes Tax.
     *
     * @param IsTaxIncluded Tax is included in the price
     */
    public void setIsTaxIncluded(boolean IsTaxIncluded) {
        setValue(COLUMNNAME_IsTaxIncluded, Boolean.valueOf(IsTaxIncluded));
    }

    /**
     * Get Price includes Tax.
     *
     * @return Tax is included in the price
     */
    public boolean isTaxIncluded() {
        Object oo = getValue(COLUMNNAME_IsTaxIncluded);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Price List.
     *
     * @return Unique identifier of a Price List
     */
    public int getPriceListId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_PriceList_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Name.
     *
     * @return Alphanumeric identifier of the entity
     */
    public String getName() {
        return (String) getValue(HasName.Companion.getCOLUMNNAME_Name());
    }

    /**
     * Set Name.
     *
     * @param Name Alphanumeric identifier of the entity
     */
    public void setName(String Name) {
        setValue(HasName.Companion.getCOLUMNNAME_Name(), Name);
    }

    /**
     * Get Price Precision.
     *
     * @return Precision (number of decimals) for the Price
     */
    public int getPricePrecision() {
        Integer ii = (Integer) getValue(COLUMNNAME_PricePrecision);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Price Precision.
     *
     * @param PricePrecision Precision (number of decimals) for the Price
     */
    public void setPricePrecision(int PricePrecision) {
        setValue(COLUMNNAME_PricePrecision, Integer.valueOf(PricePrecision));
    }
}
