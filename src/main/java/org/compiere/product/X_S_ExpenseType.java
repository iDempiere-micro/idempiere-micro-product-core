package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_S_ExpenseType;
import org.compiere.orm.BasePONameValue;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for S_ExpenseType
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_S_ExpenseType extends BasePONameValue implements I_S_ExpenseType, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_S_ExpenseType(Properties ctx, int S_ExpenseType_ID, String trxName) {
    super(ctx, S_ExpenseType_ID, trxName);
    /**
     * if (S_ExpenseType_ID == 0) { setC_TaxCategory_ID (0); setC_UOM_ID (0); setIsInvoiced (false);
     * setM_Product_Category_ID (0); setName (null); setS_ExpenseType_ID (0); setValue (null); }
     */
  }

  /** Load Constructor */
  public X_S_ExpenseType(Properties ctx, ResultSet rs, String trxName) {
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
    return "X_S_ExpenseType[" + getId() + "]";
  }

  public org.compiere.model.I_C_TaxCategory getC_TaxCategory() throws RuntimeException {
    return (org.compiere.model.I_C_TaxCategory)
        MTable.get(getCtx(), org.compiere.model.I_C_TaxCategory.Table_Name)
            .getPO(getC_TaxCategory_ID(), null);
  }

  /**
   * Get Tax Category.
   *
   * @return Tax Category
   */
  public int getC_TaxCategory_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_TaxCategory_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Tax Category.
   *
   * @param C_TaxCategory_ID Tax Category
   */
  public void setC_TaxCategory_ID(int C_TaxCategory_ID) {
    if (C_TaxCategory_ID < 1) set_Value(COLUMNNAME_C_TaxCategory_ID, null);
    else set_Value(COLUMNNAME_C_TaxCategory_ID, Integer.valueOf(C_TaxCategory_ID));
  }

  public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException {
    return (org.compiere.model.I_C_UOM)
        MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
            .getPO(getC_UOM_ID(), null);
  }

  /**
   * Get UOM.
   *
   * @return Unit of Measure
   */
  public int getC_UOM_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_UOM_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set UOM.
   *
   * @param C_UOM_ID Unit of Measure
   */
  public void setC_UOM_ID(int C_UOM_ID) {
    if (C_UOM_ID < 1) set_Value(COLUMNNAME_C_UOM_ID, null);
    else set_Value(COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
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
   * Set Invoiced.
   *
   * @param IsInvoiced Is this invoiced?
   */
  public void setIsInvoiced(boolean IsInvoiced) {
    set_Value(COLUMNNAME_IsInvoiced, Boolean.valueOf(IsInvoiced));
  }

  /**
   * Get Invoiced.
   *
   * @return Is this invoiced?
   */
  public boolean isInvoiced() {
    Object oo = get_Value(COLUMNNAME_IsInvoiced);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  public org.compiere.model.I_M_Product_Category getM_Product_Category() throws RuntimeException {
    return (org.compiere.model.I_M_Product_Category)
        MTable.get(getCtx(), org.compiere.model.I_M_Product_Category.Table_Name)
            .getPO(getM_Product_Category_ID(), null);
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
   * Get Expense Type.
   *
   * @return Expense report type
   */
  public int getS_ExpenseType_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_S_ExpenseType_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Expense Type.
   *
   * @param S_ExpenseType_ID Expense report type
   */
  public void setS_ExpenseType_ID(int S_ExpenseType_ID) {
    if (S_ExpenseType_ID < 1) set_ValueNoCheck(COLUMNNAME_S_ExpenseType_ID, null);
    else set_ValueNoCheck(COLUMNNAME_S_ExpenseType_ID, Integer.valueOf(S_ExpenseType_ID));
  }

  /**
   * Get S_ExpenseType_UU.
   *
   * @return S_ExpenseType_UU
   */
  public String getS_ExpenseType_UU() {
    return (String) get_Value(COLUMNNAME_S_ExpenseType_UU);
  }

  /**
   * Set S_ExpenseType_UU.
   *
   * @param S_ExpenseType_UU S_ExpenseType_UU
   */
  public void setS_ExpenseType_UU(String S_ExpenseType_UU) {
    set_Value(COLUMNNAME_S_ExpenseType_UU, S_ExpenseType_UU);
  }

  @Override
  public int getTableId() {
    return I_S_ExpenseType.Table_ID;
  }
}
