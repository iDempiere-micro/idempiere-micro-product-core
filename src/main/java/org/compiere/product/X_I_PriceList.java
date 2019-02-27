package org.compiere.product;

import org.compiere.model.HasName;
import org.compiere.model.I_I_PriceList;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Generated Model for I_PriceList
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_I_PriceList extends PO implements I_I_PriceList {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_I_PriceList(Properties ctx, int I_PriceList_ID) {
        super(ctx, I_PriceList_ID);
        /** if (I_PriceList_ID == 0) { setI_IsImported (false); // N setI_PriceList_ID (0); } */
    }

    /**
     * Load Constructor
     */
    public X_I_PriceList(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    }

    /**
     * AccessLevel
     *
     * @return 2 - Client
     */
    protected int getAccessLevel() {
        return accessLevel.intValue();
    }

    public String toString() {
        return "X_I_PriceList[" + getId() + "]";
    }

    /**
     * Get Break Value.
     *
     * @return Low Value of trade discount break level
     */
    public BigDecimal getBreakValue() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_BreakValue);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Get Business Partner .
     *
     * @return Identifies a Business Partner
     */
    public int getBusinessPartnerId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_BPartner_ID);
        if (ii == null) return 0;
        return ii;
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
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return (String) getValue(COLUMNNAME_Description);
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
     * Get Import Price List.
     *
     * @return Import Price List
     */
    public int getI_PriceList_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_I_PriceList_ID);
        if (ii == null) return 0;
        return ii;
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
     * Get Price List Version.
     *
     * @return Identifies a unique instance of a Price List
     */
    public int getM_PriceList_Version_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_PriceList_Version_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Product.
     *
     * @return Product, Service, Item
     */
    public int getM_Product_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Product_ID);
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
     * Get Limit Price.
     *
     * @return Lowest price for a product
     */
    public BigDecimal getPriceLimit() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_PriceLimit);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Get List Price.
     *
     * @return List Price
     */
    public BigDecimal getPriceList() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_PriceList);
        if (bd == null) return Env.ZERO;
        return bd;
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
     * Get Standard Price.
     *
     * @return Standard Price
     */
    public BigDecimal getPriceStd() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_PriceStd);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Get Valid from.
     *
     * @return Valid from including this date (first day)
     */
    public Timestamp getValidFrom() {
        return (Timestamp) getValue(COLUMNNAME_ValidFrom);
    }

    @Override
    public int getTableId() {
        return I_I_PriceList.Table_ID;
    }
}
