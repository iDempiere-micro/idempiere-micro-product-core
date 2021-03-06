package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_Product_BOM;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;

/**
 * Generated Model for M_Product_BOM
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Product_BOM extends PO implements I_M_Product_BOM {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_Product_BOM(int M_Product_BOM_ID) {
        super(M_Product_BOM_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_Product_BOM(Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_Product_BOM[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get BOM Quantity.
     *
     * @return Bill of Materials Quantity
     */
    public BigDecimal getBOMQty() {
        BigDecimal bd = getValue(COLUMNNAME_BOMQty);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set BOM Quantity.
     *
     * @param BOMQty Bill of Materials Quantity
     */
    public void setBOMQty(BigDecimal BOMQty) {
        setValue(COLUMNNAME_BOMQty, BOMQty);
    }

    /**
     * Get BOM Type.
     *
     * @return Type of BOM
     */
    public String getBOMType() {
        return getValue(COLUMNNAME_BOMType);
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
     * Get Line No.
     *
     * @return Unique line for this document
     */
    public int getLine() {
        Integer ii = getValue(COLUMNNAME_Line);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Line No.
     *
     * @param Line Unique line for this document
     */
    public void setLine(int Line) {
        setValue(COLUMNNAME_Line, Integer.valueOf(Line));
    }

    /**
     * Get BOM Line.
     *
     * @return BOM Line
     */
    public int getBOMLineId() {
        Integer ii = getValue(COLUMNNAME_M_Product_BOM_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get BOM Product.
     *
     * @return Bill of Material Component Product
     */
    public int getBOMProductId() {
        Integer ii = getValue(COLUMNNAME_M_ProductBOM_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set BOM Product.
     *
     * @param M_ProductBOM_ID Bill of Material Component Product
     */
    public void setBOMProductId(int M_ProductBOM_ID) {
        if (M_ProductBOM_ID < 1) setValue(COLUMNNAME_M_ProductBOM_ID, null);
        else setValue(COLUMNNAME_M_ProductBOM_ID, Integer.valueOf(M_ProductBOM_ID));
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
        else setValueNoCheck(COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
    }

    @Override
    public int getTableId() {
        return I_M_Product_BOM.Table_ID;
    }
}
