package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_DiscountSchemaBreak;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_DiscountSchemaBreak
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_DiscountSchemaBreak extends PO implements I_M_DiscountSchemaBreak, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_DiscountSchemaBreak(Properties ctx, int M_DiscountSchemaBreak_ID, String trxName) {
    super(ctx, M_DiscountSchemaBreak_ID, trxName);
    /**
     * if (M_DiscountSchemaBreak_ID == 0) { setBreakDiscount (Env.ZERO); setBreakValue (Env.ZERO);
     * setIsBPartnerFlatDiscount (false); // N setM_DiscountSchemaBreak_ID (0);
     * setM_DiscountSchema_ID (0); setSeqNo (0); // @SQL=SELECT NVL(MAX(SeqNo),0)+10 AS DefaultValue
     * FROM M_DiscountSchemaBreak WHERE M_DiscountSchema_ID=@M_DiscountSchema_ID@ }
     */
  }

  /** Load Constructor */
  public X_M_DiscountSchemaBreak(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
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
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_BreakDiscount);
    if (bd == null) return Env.ZERO;
    return bd;
  }

    /**
   * Get Break Value.
   *
   * @return Low Value of trade discount break level
   */
  public BigDecimal getBreakValue() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_BreakValue);
    if (bd == null) return Env.ZERO;
    return bd;
  }

    /**
   * Get B.Partner Flat Discount.
   *
   * @return Use flat discount defined on Business Partner Level
   */
  public boolean isBPartnerFlatDiscount() {
    Object oo = get_Value(COLUMNNAME_IsBPartnerFlatDiscount);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

    /**
   * Get Discount Schema.
   *
   * @return Schema to calculate the trade discount percentage
   */
  public int getM_DiscountSchema_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_DiscountSchema_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Product Category.
   *
   * @return Category of a Product
   */
  public int getM_Product_Category_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Product_Category_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Product Category.
   *
   * @param M_Product_Category_ID Category of a Product
   */
  public void setM_Product_Category_ID(int M_Product_Category_ID) {
    if (M_Product_Category_ID < 1) set_Value(COLUMNNAME_M_Product_Category_ID, null);
    else set_Value(COLUMNNAME_M_Product_Category_ID, Integer.valueOf(M_Product_Category_ID));
  }

    /**
   * Get Product.
   *
   * @return Product, Service, Item
   */
  public int getM_Product_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Product_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Sequence.
   *
   * @return Method of ordering records; lowest number comes first
   */
  public int getSeqNo() {
    Integer ii = (Integer) get_Value(COLUMNNAME_SeqNo);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Sequence.
   *
   * @param SeqNo Method of ordering records; lowest number comes first
   */
  public void setSeqNo(int SeqNo) {
    set_Value(COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
  }

  /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), String.valueOf(getSeqNo()));
  }

  @Override
  public int getTableId() {
    return I_M_DiscountSchemaBreak.Table_ID;
  }
}
