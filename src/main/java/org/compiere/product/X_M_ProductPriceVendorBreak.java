package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_ProductPriceVendorBreak;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

public class X_M_ProductPriceVendorBreak extends PO
    implements I_M_ProductPriceVendorBreak, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_ProductPriceVendorBreak(
      Properties ctx, int M_ProductPriceVendorBreak_ID, String trxName) {
    super(ctx, M_ProductPriceVendorBreak_ID, trxName);
    /**
     * if (M_ProductPriceVendorBreak_ID == 0) { setBreakValue (Env.ZERO); setM_PriceList_Version_ID
     * (0); setM_Product_ID (0); setM_ProductPriceVendorBreak_ID (0); setPriceLimit (Env.ZERO);
     * setPriceList (Env.ZERO); setPriceStd (Env.ZERO); }
     */
  }

  /** Load Constructor */
  public X_M_ProductPriceVendorBreak(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_ProductPriceVendorBreak[").append(getId()).append("]");
    return sb.toString();
  }

    /**
   * Set Break Value.
   *
   * @param BreakValue Low Value of trade discount break level
   */
  public void setBreakValue(BigDecimal BreakValue) {
    set_ValueNoCheck(COLUMNNAME_BreakValue, BreakValue);
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
   * Set Business Partner .
   *
   * @param C_BPartner_ID Identifies a Business Partner
   */
  public void setC_BPartner_ID(int C_BPartner_ID) {
    if (C_BPartner_ID < 1) set_ValueNoCheck(COLUMNNAME_C_BPartner_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
  }

    /**
   * Get Price List Version.
   *
   * @return Identifies a unique instance of a Price List
   */
  public int getM_PriceList_Version_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_PriceList_Version_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Price List Version.
   *
   * @param M_PriceList_Version_ID Identifies a unique instance of a Price List
   */
  public void setM_PriceList_Version_ID(int M_PriceList_Version_ID) {
    if (M_PriceList_Version_ID < 1) set_ValueNoCheck(COLUMNNAME_M_PriceList_Version_ID, null);
    else
      set_ValueNoCheck(COLUMNNAME_M_PriceList_Version_ID, Integer.valueOf(M_PriceList_Version_ID));
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
   * Set Product.
   *
   * @param M_Product_ID Product, Service, Item
   */
  public void setM_Product_ID(int M_Product_ID) {
    if (M_Product_ID < 1) set_ValueNoCheck(COLUMNNAME_M_Product_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
  }

    /**
   * Set Limit Price.
   *
   * @param PriceLimit Lowest price for a product
   */
  public void setPriceLimit(BigDecimal PriceLimit) {
    set_Value(COLUMNNAME_PriceLimit, PriceLimit);
  }

    /**
   * Set List Price.
   *
   * @param PriceList List Price
   */
  public void setPriceList(BigDecimal PriceList) {
    set_Value(COLUMNNAME_PriceList, PriceList);
  }

    /**
   * Set Standard Price.
   *
   * @param PriceStd Standard Price
   */
  public void setPriceStd(BigDecimal PriceStd) {
    set_Value(COLUMNNAME_PriceStd, PriceStd);
  }

  @Override
  public int getTableId() {
    return I_M_ProductPriceVendorBreak.Table_ID;
  }
}
