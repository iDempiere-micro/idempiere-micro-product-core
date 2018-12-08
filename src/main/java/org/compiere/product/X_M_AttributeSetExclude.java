package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_AttributeSetExclude;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_AttributeSetExclude
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeSetExclude extends PO implements I_M_AttributeSetExclude, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_AttributeSetExclude(Properties ctx, int M_AttributeSetExclude_ID, String trxName) {
    super(ctx, M_AttributeSetExclude_ID, trxName);
    /**
     * if (M_AttributeSetExclude_ID == 0) { setAD_Table_ID (0); setIsSOTrx (false);
     * setM_AttributeSetExclude_ID (0); setM_AttributeSet_ID (0); }
     */
  }

  /** Load Constructor */
  public X_M_AttributeSetExclude(Properties ctx, ResultSet rs, String trxName) {
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
    return "X_M_AttributeSetExclude[" + getId() + "]";
  }

  public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException {
    return (org.compiere.model.I_AD_Table)
        MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_Name)
            .getPO(getAD_Table_ID(), get_TrxName());
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
    else set_Value(COLUMNNAME_AD_Table_ID, AD_Table_ID);
  }

  /**
   * Set Sales Transaction.
   *
   * @param IsSOTrx This is a Sales Transaction
   */
  public void setIsSOTrx(boolean IsSOTrx) {
    set_Value(COLUMNNAME_IsSOTrx, IsSOTrx);
  }

  /**
   * Get Sales Transaction.
   *
   * @return This is a Sales Transaction
   */
  public boolean isSOTrx() {
    Object oo = get_Value(COLUMNNAME_IsSOTrx);
    if (oo != null) {
      if (oo instanceof Boolean) return (Boolean) oo;
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Exclude Attribute Set.
   *
   * @param M_AttributeSetExclude_ID Exclude the ability to enter Attribute Sets
   */
  public void setM_AttributeSetExclude_ID(int M_AttributeSetExclude_ID) {
    if (M_AttributeSetExclude_ID < 1) set_ValueNoCheck(COLUMNNAME_M_AttributeSetExclude_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_AttributeSetExclude_ID, M_AttributeSetExclude_ID);
  }

  /**
   * Get Exclude Attribute Set.
   *
   * @return Exclude the ability to enter Attribute Sets
   */
  public int getMAttributeSetExclude_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_AttributeSetExclude_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set M_AttributeSetExclude_UU.
   *
   * @param M_AttributeSetExclude_UU M_AttributeSetExclude_UU
   */
  public void setM_AttributeSetExclude_UU(String M_AttributeSetExclude_UU) {
    set_Value(COLUMNNAME_M_AttributeSetExclude_UU, M_AttributeSetExclude_UU);
  }

  /**
   * Get M_AttributeSetExclude_UU.
   *
   * @return M_AttributeSetExclude_UU
   */
  public String getMAttributeSetExclude_UU() {
    return (String) get_Value(COLUMNNAME_M_AttributeSetExclude_UU);
  }

  public org.compiere.model.I_M_AttributeSet getMAttributeSet() throws RuntimeException {
    return (org.compiere.model.I_M_AttributeSet)
        MTable.get(getCtx(), org.compiere.model.I_M_AttributeSet.Table_Name)
            .getPO(getMAttributeSet_ID(), get_TrxName());
  }

  /**
   * Set Attribute Set.
   *
   * @param M_AttributeSet_ID Product Attribute Set
   */
  public void setM_AttributeSet_ID(int M_AttributeSet_ID) {
    if (M_AttributeSet_ID < 0) set_ValueNoCheck(COLUMNNAME_M_AttributeSet_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_AttributeSet_ID, M_AttributeSet_ID);
  }

  /**
   * Get Attribute Set.
   *
   * @return Product Attribute Set
   */
  public int getMAttributeSet_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_AttributeSet_ID);
    if (ii == null) return 0;
    return ii;
  }

  @Override
  public int getTableId() {
    return I_M_AttributeSetExclude.Table_ID;
  }
}
