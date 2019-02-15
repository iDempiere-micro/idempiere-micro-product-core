package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_DiscountSchemaLine;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_DiscountSchemaLine
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_DiscountSchemaLine extends PO implements I_M_DiscountSchemaLine, I_Persistent {

    /** Product Cost = P */
  public static final String LIMIT_BASE_ProductCost = "P";
    /** Product Cost = P */
  public static final String LIST_BASE_ProductCost = "P";
    /** Product Cost = P */
  public static final String STD_BASE_ProductCost = "P";
    /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_DiscountSchemaLine(Properties ctx, int M_DiscountSchemaLine_ID) {
    super(ctx, M_DiscountSchemaLine_ID);
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
  public X_M_DiscountSchemaLine(Properties ctx, ResultSet rs) {
    super(ctx, rs);
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

    @Override
  public int getTableId() {
    return I_M_DiscountSchemaLine.Table_ID;
  }
}
