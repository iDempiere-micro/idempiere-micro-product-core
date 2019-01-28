package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.I_M_DiscountSchema;
import org.compiere.orm.BasePOName;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_DiscountSchema
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_DiscountSchema extends BasePOName implements I_M_DiscountSchema, I_Persistent {

    /** Line = L */
  public static final String CUMULATIVELEVEL_Line = "L";
    /** Flat Percent = F */
  public static final String DISCOUNTTYPE_FlatPercent = "F";
  /** Formula = S */
  public static final String DISCOUNTTYPE_Formula = "S";
  /** Breaks = B */
  public static final String DISCOUNTTYPE_Breaks = "B";
  /** Pricelist = P */
  public static final String DISCOUNTTYPE_Pricelist = "P";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_DiscountSchema(Properties ctx, int M_DiscountSchema_ID, String trxName) {
    super(ctx, M_DiscountSchema_ID, trxName);
  }

  /** Load Constructor */
  public X_M_DiscountSchema(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_DiscountSchema[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Get Accumulation Level.
   *
   * @return Level for accumulative calculations
   */
  public String getCumulativeLevel() {
    return (String) get_Value(COLUMNNAME_CumulativeLevel);
  }

  /**
   * Set Accumulation Level.
   *
   * @param CumulativeLevel Level for accumulative calculations
   */
  public void setCumulativeLevel(String CumulativeLevel) {

    set_Value(COLUMNNAME_CumulativeLevel, CumulativeLevel);
  }

    /**
   * Get Discount Type.
   *
   * @return Type of trade discount calculation
   */
  public String getDiscountType() {
    return (String) get_Value(COLUMNNAME_DiscountType);
  }

  /**
   * Set Discount Type.
   *
   * @param DiscountType Type of trade discount calculation
   */
  public void setDiscountType(String DiscountType) {

    set_Value(COLUMNNAME_DiscountType, DiscountType);
  }

  /**
   * Get Flat Discount %.
   *
   * @return Flat discount percentage
   */
  public BigDecimal getFlatDiscount() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_FlatDiscount);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Flat Discount %.
   *
   * @param FlatDiscount Flat discount percentage
   */
  public void setFlatDiscount(BigDecimal FlatDiscount) {
    set_Value(COLUMNNAME_FlatDiscount, FlatDiscount);
  }

  /**
   * Set B.Partner Flat Discount.
   *
   * @param IsBPartnerFlatDiscount Use flat discount defined on Business Partner Level
   */
  public void setIsBPartnerFlatDiscount(boolean IsBPartnerFlatDiscount) {
    set_Value(COLUMNNAME_IsBPartnerFlatDiscount, Boolean.valueOf(IsBPartnerFlatDiscount));
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
   * Set Quantity based.
   *
   * @param IsQuantityBased Trade discount break level based on Quantity (not value)
   */
  public void setIsQuantityBased(boolean IsQuantityBased) {
    set_Value(COLUMNNAME_IsQuantityBased, Boolean.valueOf(IsQuantityBased));
  }

  /**
   * Get Quantity based.
   *
   * @return Trade discount break level based on Quantity (not value)
   */
  public boolean isQuantityBased() {
    Object oo = get_Value(COLUMNNAME_IsQuantityBased);
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
   * Get Valid from.
   *
   * @return Valid from including this date (first day)
   */
  public Timestamp getValidFrom() {
    return (Timestamp) get_Value(COLUMNNAME_ValidFrom);
  }

  /**
   * Set Valid from.
   *
   * @param ValidFrom Valid from including this date (first day)
   */
  public void setValidFrom(Timestamp ValidFrom) {
    set_Value(COLUMNNAME_ValidFrom, ValidFrom);
  }

  @Override
  public int getTableId() {
    return I_M_DiscountSchema.Table_ID;
  }
}
