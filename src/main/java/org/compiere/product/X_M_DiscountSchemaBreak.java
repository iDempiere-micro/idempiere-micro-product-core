package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_DiscountSchemaBreak;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.util.Properties;

/**
 * Generated Model for M_DiscountSchemaBreak
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_DiscountSchemaBreak extends PO implements I_M_DiscountSchemaBreak {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_DiscountSchemaBreak(Properties ctx, int M_DiscountSchemaBreak_ID) {
        super(ctx, M_DiscountSchemaBreak_ID);
        /**
         * if (M_DiscountSchemaBreak_ID == 0) { setBreakDiscount (Env.ZERO); setBreakValue (Env.ZERO);
         * setIsBPartnerFlatDiscount (false); // N setDiscountSchemaBreak_ID (0);
         * setDiscountSchemaId (0); setSeqNo (0); // @SQL=SELECT NVL(MAX(SeqNo),0)+10 AS DefaultValue
         * FROM M_DiscountSchemaBreak WHERE M_DiscountSchema_ID=@M_DiscountSchema_ID@ }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_DiscountSchemaBreak(Properties ctx, Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_DiscountSchemaBreak[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Break Discount %.
     *
     * @return Trade Discount in Percent for the break level
     */
    public BigDecimal getBreakDiscount() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_BreakDiscount);
        if (bd == null) return Env.ZERO;
        return bd;
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
     * Get B.Partner Flat Discount.
     *
     * @return Use flat discount defined on Business Partner Level
     */
    public boolean isBPartnerFlatDiscount() {
        Object oo = getValue(COLUMNNAME_IsBPartnerFlatDiscount);
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
     * Set Product Category.
     *
     * @param M_Product_Category_ID Category of a Product
     */
    public void setProductCategoryId(int M_Product_Category_ID) {
        if (M_Product_Category_ID < 1) setValue(COLUMNNAME_M_Product_Category_ID, null);
        else setValue(COLUMNNAME_M_Product_Category_ID, Integer.valueOf(M_Product_Category_ID));
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
     * Get Sequence.
     *
     * @return Method of ordering records; lowest number comes first
     */
    public int getSeqNo() {
        Integer ii = (Integer) getValue(COLUMNNAME_SeqNo);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Sequence.
     *
     * @param SeqNo Method of ordering records; lowest number comes first
     */
    public void setSeqNo(int SeqNo) {
        setValue(COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
    }

    @Override
    public int getTableId() {
        return I_M_DiscountSchemaBreak.Table_ID;
    }
}
