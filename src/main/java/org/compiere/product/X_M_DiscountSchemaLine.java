package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_DiscountSchemaLine;
import org.compiere.orm.PO;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_DiscountSchemaLine
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_DiscountSchemaLine extends PO implements I_M_DiscountSchemaLine, I_Persistent {

  /** Limit_Base AD_Reference_ID=194 */
  public static final int LIMIT_BASE_AD_Reference_ID = 194;
  /** List Price = L */
  public static final String LIMIT_BASE_ListPrice = "L";
  /** Standard Price = S */
  public static final String LIMIT_BASE_StandardPrice = "S";
  /** Limit (PO) Price = X */
  public static final String LIMIT_BASE_LimitPOPrice = "X";
  /** Fixed Price = F */
  public static final String LIMIT_BASE_FixedPrice = "F";
  /** Product Cost = P */
  public static final String LIMIT_BASE_ProductCost = "P";
  /** Limit_Rounding AD_Reference_ID=155 */
  public static final int LIMIT_ROUNDING_AD_Reference_ID = 155;
  /** Whole Number .00 = 0 */
  public static final String LIMIT_ROUNDING_WholeNumber00 = "0";
  /** No Rounding = N */
  public static final String LIMIT_ROUNDING_NoRounding = "N";
  /** Quarter .25 .50 .75 = Q */
  public static final String LIMIT_ROUNDING_Quarter255075 = "Q";
  /** Dime .10, .20, .30, ... = D */
  public static final String LIMIT_ROUNDING_Dime102030 = "D";
  /** Nickel .05, .10, .15, ... = 5 */
  public static final String LIMIT_ROUNDING_Nickel051015 = "5";
  /** Ten 10.00, 20.00, .. = T */
  public static final String LIMIT_ROUNDING_Ten10002000 = "T";
  /** Currency Precision = C */
  public static final String LIMIT_ROUNDING_CurrencyPrecision = "C";
  /** Ending in 9/5 = 9 */
  public static final String LIMIT_ROUNDING_EndingIn95 = "9";
  /** List_Base AD_Reference_ID=194 */
  public static final int LIST_BASE_AD_Reference_ID = 194;
  /** List Price = L */
  public static final String LIST_BASE_ListPrice = "L";
  /** Standard Price = S */
  public static final String LIST_BASE_StandardPrice = "S";
  /** Limit (PO) Price = X */
  public static final String LIST_BASE_LimitPOPrice = "X";
  /** Fixed Price = F */
  public static final String LIST_BASE_FixedPrice = "F";
  /** Product Cost = P */
  public static final String LIST_BASE_ProductCost = "P";
  /** List_Rounding AD_Reference_ID=155 */
  public static final int LIST_ROUNDING_AD_Reference_ID = 155;
  /** Whole Number .00 = 0 */
  public static final String LIST_ROUNDING_WholeNumber00 = "0";
  /** No Rounding = N */
  public static final String LIST_ROUNDING_NoRounding = "N";
  /** Quarter .25 .50 .75 = Q */
  public static final String LIST_ROUNDING_Quarter255075 = "Q";
  /** Dime .10, .20, .30, ... = D */
  public static final String LIST_ROUNDING_Dime102030 = "D";
  /** Nickel .05, .10, .15, ... = 5 */
  public static final String LIST_ROUNDING_Nickel051015 = "5";
  /** Ten 10.00, 20.00, .. = T */
  public static final String LIST_ROUNDING_Ten10002000 = "T";
  /** Currency Precision = C */
  public static final String LIST_ROUNDING_CurrencyPrecision = "C";
  /** Ending in 9/5 = 9 */
  public static final String LIST_ROUNDING_EndingIn95 = "9";
  /** Std_Base AD_Reference_ID=194 */
  public static final int STD_BASE_AD_Reference_ID = 194;
  /** List Price = L */
  public static final String STD_BASE_ListPrice = "L";
  /** Standard Price = S */
  public static final String STD_BASE_StandardPrice = "S";
  /** Limit (PO) Price = X */
  public static final String STD_BASE_LimitPOPrice = "X";
  /** Fixed Price = F */
  public static final String STD_BASE_FixedPrice = "F";
  /** Product Cost = P */
  public static final String STD_BASE_ProductCost = "P";
  /** Std_Rounding AD_Reference_ID=155 */
  public static final int STD_ROUNDING_AD_Reference_ID = 155;
  /** Whole Number .00 = 0 */
  public static final String STD_ROUNDING_WholeNumber00 = "0";
  /** No Rounding = N */
  public static final String STD_ROUNDING_NoRounding = "N";
  /** Quarter .25 .50 .75 = Q */
  public static final String STD_ROUNDING_Quarter255075 = "Q";
  /** Dime .10, .20, .30, ... = D */
  public static final String STD_ROUNDING_Dime102030 = "D";
  /** Nickel .05, .10, .15, ... = 5 */
  public static final String STD_ROUNDING_Nickel051015 = "5";
  /** Ten 10.00, 20.00, .. = T */
  public static final String STD_ROUNDING_Ten10002000 = "T";
  /** Currency Precision = C */
  public static final String STD_ROUNDING_CurrencyPrecision = "C";
  /** Ending in 9/5 = 9 */
  public static final String STD_ROUNDING_EndingIn95 = "9";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_DiscountSchemaLine(Properties ctx, int M_DiscountSchemaLine_ID, String trxName) {
    super(ctx, M_DiscountSchemaLine_ID, trxName);
    /**
     * if (M_DiscountSchemaLine_ID == 0) { setC_ConversionType_ID (0); setConversionDate (new
     * Timestamp( System.currentTimeMillis() )); // @#Date@ setLimit_AddAmt (Env.ZERO);
     * setLimit_Base (null); // X setLimit_Discount (Env.ZERO); setLimit_MaxAmt (Env.ZERO);
     * setLimit_MinAmt (Env.ZERO); setLimit_Rounding (null); // C setList_AddAmt (Env.ZERO);
     * setList_Base (null); // L setList_Discount (Env.ZERO); setList_MaxAmt (Env.ZERO);
     * setList_MinAmt (Env.ZERO); setList_Rounding (null); // C setM_DiscountSchema_ID (0);
     * setM_DiscountSchemaLine_ID (0); setSeqNo (0); // @SQL=SELECT NVL(MAX(SeqNo),0)+10 AS
     * DefaultValue FROM M_DiscountSchemaLine WHERE M_DiscountSchema_ID=@M_DiscountSchema_ID@
     * setStd_AddAmt (Env.ZERO); setStd_Base (null); // S setStd_Discount (Env.ZERO); setStd_MaxAmt
     * (Env.ZERO); setStd_MinAmt (Env.ZERO); setStd_Rounding (null); // C }
     */
  }

  /** Load Constructor */
  public X_M_DiscountSchemaLine(Properties ctx, ResultSet rs, String trxName) {
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
    return "X_M_DiscountSchemaLine[" + getId() + "]";
  }

    /**
   * Get Business Partner .
   *
   * @return Identifies a Business Partner
   */
  public int getC_BPartner_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_BPartner_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Currency Type.
   *
   * @return Currency Conversion Rate Type
   */
  public int getC_ConversionType_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_ConversionType_ID);
    if (ii == null) return 0;
    return ii;
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
    return I_M_DiscountSchemaLine.Table_ID;
  }
}
