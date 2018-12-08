package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_ProductPrice;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_ProductPrice
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ProductPrice extends PO implements I_M_ProductPrice, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_ProductPrice(Properties ctx, int M_ProductPrice_ID, String trxName) {
    super(ctx, M_ProductPrice_ID, trxName);
    /**
     * if (M_ProductPrice_ID == 0) { setM_PriceList_Version_ID (0); setM_Product_ID (0);
     * setPriceLimit (Env.ZERO); setPriceList (Env.ZERO); setPriceStd (Env.ZERO); }
     */
  }

  /** Load Constructor */
  public X_M_ProductPrice(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_ProductPrice[").append(getId()).append("]");
    return sb.toString();
  }

  public org.compiere.model.I_M_PriceList_Version getM_PriceList_Version() throws RuntimeException {
    return (org.compiere.model.I_M_PriceList_Version)
        MTable.get(getCtx(), org.compiere.model.I_M_PriceList_Version.Table_Name)
            .getPO(getM_PriceList_Version_ID(), get_TrxName());
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

  public org.compiere.model.I_M_Product getM_Product() throws RuntimeException {
    return (org.compiere.model.I_M_Product)
        MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
            .getPO(getM_Product_ID(), get_TrxName());
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
   * Get Product Price.
   *
   * @return Intersection between a Product and a Price List Version
   */
  public int getM_ProductPrice_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ProductPrice_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Product Price.
   *
   * @param M_ProductPrice_ID Intersection between a Product and a Price List Version
   */
  public void setM_ProductPrice_ID(int M_ProductPrice_ID) {
    if (M_ProductPrice_ID < 1) set_ValueNoCheck(COLUMNNAME_M_ProductPrice_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_ProductPrice_ID, Integer.valueOf(M_ProductPrice_ID));
  }

  /**
   * Get M_ProductPrice_UU.
   *
   * @return M_ProductPrice_UU
   */
  public String getM_ProductPrice_UU() {
    return (String) get_Value(COLUMNNAME_M_ProductPrice_UU);
  }

  /**
   * Set M_ProductPrice_UU.
   *
   * @param M_ProductPrice_UU M_ProductPrice_UU
   */
  public void setM_ProductPrice_UU(String M_ProductPrice_UU) {
    set_Value(COLUMNNAME_M_ProductPrice_UU, M_ProductPrice_UU);
  }

  /**
   * Get Limit Price.
   *
   * @return Lowest price for a product
   */
  public BigDecimal getPriceLimit() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PriceLimit);
    if (bd == null) return Env.ZERO;
    return bd;
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
   * Get List Price.
   *
   * @return List Price
   */
  public BigDecimal getPriceList() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PriceList);
    if (bd == null) return Env.ZERO;
    return bd;
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
   * Get Standard Price.
   *
   * @return Standard Price
   */
  public BigDecimal getPriceStd() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PriceStd);
    if (bd == null) return Env.ZERO;
    return bd;
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
    return I_M_ProductPrice.Table_ID;
  }
}
