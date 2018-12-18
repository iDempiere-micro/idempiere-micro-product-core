package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_LotCtlExclude;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_LotCtlExclude
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_LotCtlExclude extends PO implements I_M_LotCtlExclude, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_LotCtlExclude(Properties ctx, int M_LotCtlExclude_ID, String trxName) {
    super(ctx, M_LotCtlExclude_ID, trxName);
    /**
     * if (M_LotCtlExclude_ID == 0) { setAD_Table_ID (0); setIsSOTrx (false); setM_LotCtlExclude_ID
     * (0); setM_LotCtl_ID (0); }
     */
  }

  /** Load Constructor */
  public X_M_LotCtlExclude(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 2 - Client
   */
  protected int getAccessLevel() {
    return accessLevel.intValue();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("X_M_LotCtlExclude[").append(getId()).append("]");
    return sb.toString();
  }

  public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException {
    return (org.compiere.model.I_AD_Table)
        MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_Name)
            .getPO(getAD_Table_ID(), null);
  }

  /**
   * Get Table.
   *
   * @return Database Table information
   */
  public int getAD_Table_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_AD_Table_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Table.
   *
   * @param AD_Table_ID Database Table information
   */
  public void setAD_Table_ID(int AD_Table_ID) {
    if (AD_Table_ID < 1) set_Value(COLUMNNAME_AD_Table_ID, null);
    else set_Value(COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
  }

  /**
   * Set Sales Transaction.
   *
   * @param IsSOTrx This is a Sales Transaction
   */
  public void setIsSOTrx(boolean IsSOTrx) {
    set_Value(COLUMNNAME_IsSOTrx, Boolean.valueOf(IsSOTrx));
  }

  /**
   * Get Sales Transaction.
   *
   * @return This is a Sales Transaction
   */
  public boolean isSOTrx() {
    Object oo = get_Value(COLUMNNAME_IsSOTrx);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Get Exclude Lot.
   *
   * @return Exclude the ability to create Lots in Attribute Sets
   */
  public int getM_LotCtlExclude_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_LotCtlExclude_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Exclude Lot.
   *
   * @param M_LotCtlExclude_ID Exclude the ability to create Lots in Attribute Sets
   */
  public void setM_LotCtlExclude_ID(int M_LotCtlExclude_ID) {
    if (M_LotCtlExclude_ID < 1) set_ValueNoCheck(COLUMNNAME_M_LotCtlExclude_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_LotCtlExclude_ID, Integer.valueOf(M_LotCtlExclude_ID));
  }

  /**
   * Get M_LotCtlExclude_UU.
   *
   * @return M_LotCtlExclude_UU
   */
  public String getM_LotCtlExclude_UU() {
    return (String) get_Value(COLUMNNAME_M_LotCtlExclude_UU);
  }

  /**
   * Set M_LotCtlExclude_UU.
   *
   * @param M_LotCtlExclude_UU M_LotCtlExclude_UU
   */
  public void setM_LotCtlExclude_UU(String M_LotCtlExclude_UU) {
    set_Value(COLUMNNAME_M_LotCtlExclude_UU, M_LotCtlExclude_UU);
  }

  public org.compiere.model.I_M_LotCtl getM_LotCtl() throws RuntimeException {
    return (org.compiere.model.I_M_LotCtl)
        MTable.get(getCtx(), org.compiere.model.I_M_LotCtl.Table_Name)
            .getPO(getM_LotCtl_ID(), null);
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

  @Override
  public int getTableId() {
    return I_M_LotCtlExclude.Table_ID;
  }
}
