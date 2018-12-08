package org.compiere.product;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.I_M_Lot;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_Lot
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Lot extends BasePOName implements I_M_Lot, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_Lot(Properties ctx, int M_Lot_ID, String trxName) {
    super(ctx, M_Lot_ID, trxName);
  }

  /** Load Constructor */
  public X_M_Lot(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_Lot[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Get Date From.
   *
   * @return Starting date for a range
   */
  public Timestamp getDateFrom() {
    return (Timestamp) get_Value(COLUMNNAME_DateFrom);
  }

  /**
   * Set Date From.
   *
   * @param DateFrom Starting date for a range
   */
  public void setDateFrom(Timestamp DateFrom) {
    set_Value(COLUMNNAME_DateFrom, DateFrom);
  }

  /**
   * Get Date To.
   *
   * @return End date of a date range
   */
  public Timestamp getDateTo() {
    return (Timestamp) get_Value(COLUMNNAME_DateTo);
  }

  /**
   * Set Date To.
   *
   * @param DateTo End date of a date range
   */
  public void setDateTo(Timestamp DateTo) {
    set_Value(COLUMNNAME_DateTo, DateTo);
  }

  /**
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
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
   * Get Comment/Help.
   *
   * @return Comment or Hint
   */
  public String getHelp() {
    return (String) get_Value(COLUMNNAME_Help);
  }

  /**
   * Set Comment/Help.
   *
   * @param Help Comment or Hint
   */
  public void setHelp(String Help) {
    set_Value(COLUMNNAME_Help, Help);
  }

  public org.compiere.model.I_M_LotCtl getM_LotCtl() throws RuntimeException {
    return (org.compiere.model.I_M_LotCtl)
        MTable.get(getCtx(), org.compiere.model.I_M_LotCtl.Table_Name)
            .getPO(getM_LotCtl_ID(), get_TrxName());
  }

  /**
   * Get Lot Control.
   *
   * @return Product Lot Control
   */
  public int getM_LotCtl_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_LotCtl_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Lot Control.
   *
   * @param M_LotCtl_ID Product Lot Control
   */
  public void setM_LotCtl_ID(int M_LotCtl_ID) {
    if (M_LotCtl_ID < 1) set_ValueNoCheck(COLUMNNAME_M_LotCtl_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_LotCtl_ID, Integer.valueOf(M_LotCtl_ID));
  }

  /**
   * Get Lot.
   *
   * @return Product Lot Definition
   */
  public int getM_Lot_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Lot_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Lot.
   *
   * @param M_Lot_ID Product Lot Definition
   */
  public void setM_Lot_ID(int M_Lot_ID) {
    if (M_Lot_ID < 1) set_ValueNoCheck(COLUMNNAME_M_Lot_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_Lot_ID, Integer.valueOf(M_Lot_ID));
  }

  /**
   * Get M_Lot_UU.
   *
   * @return M_Lot_UU
   */
  public String getM_Lot_UU() {
    return (String) get_Value(COLUMNNAME_M_Lot_UU);
  }

  /**
   * Set M_Lot_UU.
   *
   * @param M_Lot_UU M_Lot_UU
   */
  public void setM_Lot_UU(String M_Lot_UU) {
    set_Value(COLUMNNAME_M_Lot_UU, M_Lot_UU);
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

  @Override
  public int getTableId() {
    return I_M_Lot.Table_ID;
  }
}
