package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_I_Product;
import org.compiere.orm.BasePONameValue;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.util.Properties;

/**
 * Generated Model for I_Product
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_I_Product extends BasePONameValue implements I_I_Product {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_I_Product(Properties ctx, int I_Product_ID) {
        super(ctx, I_Product_ID);
        /** if (I_Product_ID == 0) { setIsImported (false); setI_Product_ID (0); } */
    }

    /**
     * Load Constructor
     */
    public X_I_Product(Properties ctx, Row row) {
        super(ctx, row);
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
        return "X_I_Product[" + getId() + "]";
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
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return (String) getValue(COLUMNNAME_Description);
    }

    /**
     * Get Description URL.
     *
     * @return URL for the description
     */
    public String getDescriptionURL() {
        return (String) getValue(COLUMNNAME_DescriptionURL);
    }

    /**
     * Get Document Note.
     *
     * @return Additional information for a Document
     */
    public String getDocumentNote() {
        return (String) getValue(COLUMNNAME_DocumentNote);
    }

    /**
     * Get Comment/Help.
     *
     * @return Comment or Hint
     */
    public String getHelp() {
        return (String) getValue(COLUMNNAME_Help);
    }

    /**
     * Get Image URL.
     *
     * @return URL of image
     */
    public String getImageURL() {
        return (String) getValue(COLUMNNAME_ImageURL);
    }

    /**
     * Get Import Product.
     *
     * @return Import Item or Service
     */
    public int getImportProductId() {
        Integer ii = (Integer) getValue(COLUMNNAME_I_Product_ID);
        if (ii == null) return 0;
        return ii;
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
     * Get Product.
     *
     * @return Product, Service, Item
     */
    public int getProductId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Product_ID);
        if (ii == null) return 0;
        return ii;
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
     * Get Product Type.
     *
     * @return Type of product
     */
    public String getProductType() {
        return (String) getValue(COLUMNNAME_ProductType);
    }

    /**
     * Get SKU.
     *
     * @return Stock Keeping Unit
     */
    public String getSKU() {
        return (String) getValue(COLUMNNAME_SKU);
    }

    /**
     * Get UPC/EAN.
     *
     * @return Bar Code (Universal Product Code or its superset European Article Number)
     */
    public String getUPC() {
        return (String) getValue(COLUMNNAME_UPC);
    }

    /**
     * Get Volume.
     *
     * @return Volume of a product
     */
    public BigDecimal getVolume() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_Volume);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Get Weight.
     *
     * @return Weight of a product
     */
    public BigDecimal getWeight() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_Weight);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    @Override
    public int getTableId() {
        return I_I_Product.Table_ID;
    }
}
