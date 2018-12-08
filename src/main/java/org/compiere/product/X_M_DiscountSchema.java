package org.compiere.product;

import org.compiere.model.I_M_DiscountSchema;
import org.compiere.orm.BasePOName;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Generated Model for M_DiscountSchema
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_DiscountSchema extends BasePOName implements I_M_DiscountSchema, I_Persistent {

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

  /** CumulativeLevel AD_Reference_ID=246 */
  public static final int CUMULATIVELEVEL_AD_Reference_ID = 246;
  /** Line = L */
  public static final String CUMULATIVELEVEL_Line = "L";
  /**
   * Set Accumulation Level.
   *
   * @param CumulativeLevel Level for accumulative calculations
   */
  public void setCumulativeLevel(String CumulativeLevel) {

    set_Value(COLUMNNAME_CumulativeLevel, CumulativeLevel);
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
   * Set Description.
   *
   * @param Description Optional short description of the record
   */
  public void setDescription(String Description) {
    set_Value(COLUMNNAME_Description, Description);
  }

  /**
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
  }

  /** DiscountType AD_Reference_ID=247 */
  public static final int DISCOUNTTYPE_AD_Reference_ID = 247;
  /** Flat Percent = F */
  public static final String DISCOUNTTYPE_FlatPercent = "F";
  /** Formula = S */
  public static final String DISCOUNTTYPE_Formula = "S";
  /** Breaks = B */
  public static final String DISCOUNTTYPE_Breaks = "B";
  /** Pricelist = P */
  public static final String DISCOUNTTYPE_Pricelist = "P";
  /**
   * Set Discount Type.
   *
   * @param DiscountType Type of trade discount calculation
   */
  public void setDiscountType(String DiscountType) {

    set_Value(COLUMNNAME_DiscountType, DiscountType);
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
   * Set Flat Discount %.
   *
   * @param FlatDiscount Flat discount percentage
   */
  public void setFlatDiscount(BigDecimal FlatDiscount) {
    set_Value(COLUMNNAME_FlatDiscount, FlatDiscount);
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
   * Set Discount Schema.
   *
   * @param M_DiscountSchema_ID Schema to calculate the trade discount percentage
   */
  public void setM_DiscountSchema_ID(int M_DiscountSchema_ID) {
    if (M_DiscountSchema_ID < 1) set_ValueNoCheck(COLUMNNAME_M_DiscountSchema_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_DiscountSchema_ID, Integer.valueOf(M_DiscountSchema_ID));
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
   * Set M_DiscountSchema_UU.
   *
   * @param M_DiscountSchema_UU M_DiscountSchema_UU
   */
  public void setM_DiscountSchema_UU(String M_DiscountSchema_UU) {
    set_Value(COLUMNNAME_M_DiscountSchema_UU, M_DiscountSchema_UU);
  }

  /**
   * Get M_DiscountSchema_UU.
   *
   * @return M_DiscountSchema_UU
   */
  public String getM_DiscountSchema_UU() {
    return (String) get_Value(COLUMNNAME_M_DiscountSchema_UU);
  }

  /**
   * Set Process Now.
   *
   * @param Processing Process Now
   */
  public void setProcessing(boolean Processing) {
    set_Value(COLUMNNAME_Processing, Boolean.valueOf(Processing));
  }

  /**
   * Get Process Now.
   *
   * @return Process Now
   */
  public boolean isProcessing() {
    Object oo = get_Value(COLUMNNAME_Processing);
    if (oo != null) {
      if (oo instanceof Boolean) return (Boolean) oo;
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Script.
   *
   * @param Script Dynamic Java Language Script to calculate result
   */
  public void setScript(String Script) {
    set_Value(COLUMNNAME_Script, Script);
  }

  /**
   * Get Script.
   *
   * @return Dynamic Java Language Script to calculate result
   */
  public String getScript() {
    return (String) get_Value(COLUMNNAME_Script);
  }

  /**
   * Set Valid from.
   *
   * @param ValidFrom Valid from including this date (first day)
   */
  public void setValidFrom(Timestamp ValidFrom) {
    set_Value(COLUMNNAME_ValidFrom, ValidFrom);
  }

  /**
   * Get Valid from.
   *
   * @return Valid from including this date (first day)
   */
  public Timestamp getValidFrom() {
    return (Timestamp) get_Value(COLUMNNAME_ValidFrom);
  }

  @Override
  public int getTableId() {
    return I_M_DiscountSchema.Table_ID;
  }
}
