package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_ProductPriceVendorBreak;
import org.compiere.orm.PO;

import java.math.BigDecimal;
import java.util.Properties;

public class X_M_ProductPriceVendorBreak extends PO
        implements I_M_ProductPriceVendorBreak {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_ProductPriceVendorBreak(
            Properties ctx, int M_ProductPriceVendorBreak_ID) {
        super(ctx, M_ProductPriceVendorBreak_ID);
        /**
         * if (M_ProductPriceVendorBreak_ID == 0) { setBreakValue (Env.ZERO); setM_PriceList_Version_ID
         * (0); setM_Product_ID (0); setM_ProductPriceVendorBreak_ID (0); setPriceLimit (Env.ZERO);
         * setPriceList (Env.ZERO); setPriceStd (Env.ZERO); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_ProductPriceVendorBreak(Properties ctx, Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_ProductPriceVendorBreak[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Set Break Value.
     *
     * @param BreakValue Low Value of trade discount break level
     */
    public void setBreakValue(BigDecimal BreakValue) {
        setValueNoCheck(COLUMNNAME_BreakValue, BreakValue);
    }

    /**
     * Set Business Partner .
     *
     * @param C_BPartner_ID Identifies a Business Partner
     */
    public void setBusinessPartnerId(int C_BPartner_ID) {
        if (C_BPartner_ID < 1) setValueNoCheck(COLUMNNAME_C_BPartner_ID, null);
        else setValueNoCheck(COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
    }

    /**
     * Set Price List Version.
     *
     * @param M_PriceList_Version_ID Identifies a unique instance of a Price List
     */
    public void setM_PriceList_Version_ID(int M_PriceList_Version_ID) {
        if (M_PriceList_Version_ID < 1) setValueNoCheck(COLUMNNAME_M_PriceList_Version_ID, null);
        else
            setValueNoCheck(COLUMNNAME_M_PriceList_Version_ID, Integer.valueOf(M_PriceList_Version_ID));
    }

    /**
     * Set Product.
     *
     * @param M_Product_ID Product, Service, Item
     */
    public void setM_Product_ID(int M_Product_ID) {
        if (M_Product_ID < 1) setValueNoCheck(COLUMNNAME_M_Product_ID, null);
        else setValueNoCheck(COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
    }

    /**
     * Set Limit Price.
     *
     * @param PriceLimit Lowest price for a product
     */
    public void setPriceLimit(BigDecimal PriceLimit) {
        setValue(COLUMNNAME_PriceLimit, PriceLimit);
    }

    /**
     * Set List Price.
     *
     * @param PriceList List Price
     */
    public void setPriceList(BigDecimal PriceList) {
        setValue(COLUMNNAME_PriceList, PriceList);
    }

    /**
     * Set Standard Price.
     *
     * @param PriceStd Standard Price
     */
    public void setPriceStd(BigDecimal PriceStd) {
        setValue(COLUMNNAME_PriceStd, PriceStd);
    }

    @Override
    public int getTableId() {
        return I_M_ProductPriceVendorBreak.Table_ID;
    }
}
