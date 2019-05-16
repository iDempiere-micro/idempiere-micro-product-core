package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_PriceList_Version;
import org.compiere.model.I_M_ProductPrice;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import software.hsharp.core.orm.MBaseTableKt;

import java.math.BigDecimal;

/**
 * Generated Model for M_ProductPrice
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ProductPrice extends PO implements I_M_ProductPrice {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_ProductPrice(int M_ProductPrice_ID) {
        super(M_ProductPrice_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_ProductPrice(Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_ProductPrice[").append(getId()).append("]");
        return sb.toString();
    }

    public I_M_PriceList_Version getPriceListVersion() throws RuntimeException {
        return (I_M_PriceList_Version)
                MBaseTableKt.getTable(I_M_PriceList_Version.Table_Name)
                        .getPO(getPriceListVersionId());
    }

    /**
     * Get Price List Version.
     *
     * @return Identifies a unique instance of a Price List
     */
    public int getPriceListVersionId() {
        Integer ii = getValue(COLUMNNAME_M_PriceList_Version_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Price List Version.
     *
     * @param M_PriceList_Version_ID Identifies a unique instance of a Price List
     */
    public void setPriceListVersionId(int M_PriceList_Version_ID) {
        if (M_PriceList_Version_ID < 1) setValueNoCheck(COLUMNNAME_M_PriceList_Version_ID, null);
        else
            setValueNoCheck(COLUMNNAME_M_PriceList_Version_ID, M_PriceList_Version_ID);
    }

    /**
     * Get Product.
     *
     * @return Product, Service, Item
     */
    public int getProductId() {
        Integer ii = getValue(COLUMNNAME_M_Product_ID);
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
        else setValueNoCheck(COLUMNNAME_M_Product_ID, M_Product_ID);
    }

    /**
     * Get Limit Price.
     *
     * @return Lowest price for a product
     */
    public BigDecimal getPriceLimit() {
        BigDecimal bd = getValue(COLUMNNAME_PriceLimit);
        if (bd == null) return Env.ZERO;
        return bd;
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
     * Get List Price.
     *
     * @return List Price
     */
    public BigDecimal getPriceList() {
        BigDecimal bd = getValue(COLUMNNAME_PriceList);
        if (bd == null) return Env.ZERO;
        return bd;
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
     * Get Standard Price.
     *
     * @return Standard Price
     */
    public BigDecimal getPriceStd() {
        BigDecimal bd = getValue(COLUMNNAME_PriceStd);
        if (bd == null) return Env.ZERO;
        return bd;
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
        return I_M_ProductPrice.Table_ID;
    }
}
