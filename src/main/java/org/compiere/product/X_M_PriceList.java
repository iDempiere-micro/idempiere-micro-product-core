package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.HasName;
import org.compiere.model.I_C_Currency;
import org.compiere.model.I_M_PriceList;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for M_PriceList
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public abstract class X_M_PriceList extends PO implements I_M_PriceList, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_PriceList(Properties ctx, int M_PriceList_ID, String trxName) {
    super(ctx, M_PriceList_ID, trxName);
    /**
     * if (M_PriceList_ID == 0) { setC_Currency_ID (0); setEnforcePriceLimit (false); setIsDefault
     * (false); setIsSOPriceList (false); setIsTaxIncluded (false); setM_PriceList_ID (0); setName
     * (null); setPricePrecision (0); // 2 }
     */
  }

  /** Load Constructor */
  public X_M_PriceList(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }
  public X_M_PriceList(Properties ctx, Row row) {
    super(ctx, row);
  } //	MPriceList

  /**
   * AccessLevel
   *
   * @return 3 - Client - Org
   */
  protected int getAccessLevel() {
    return accessLevel.intValue();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("X_M_PriceList[").append(getId()).append("]");
    return sb.toString();
  }

  public I_M_PriceList getBasePriceList() throws RuntimeException {
    return (I_M_PriceList)
        MTable.get(getCtx(), I_M_PriceList.Table_Name).getPO(getBasePriceList_ID(), null);
  }

  /**
   * Get Base Pricelist.
   *
   * @return Pricelist to be used, if product not found on this pricelist
   */
  public int getBasePriceList_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_BasePriceList_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Base Pricelist.
   *
   * @param BasePriceList_ID Pricelist to be used, if product not found on this pricelist
   */
  public void setBasePriceList_ID(int BasePriceList_ID) {
    if (BasePriceList_ID < 1) set_Value(COLUMNNAME_BasePriceList_ID, null);
    else set_Value(COLUMNNAME_BasePriceList_ID, Integer.valueOf(BasePriceList_ID));
  }

  public I_C_Currency getC_Currency() throws RuntimeException {
    return (I_C_Currency)
        MTable.get(getCtx(), I_C_Currency.Table_Name).getPO(getC_Currency_ID(), null);
  }

  /**
   * Get Currency.
   *
   * @return The Currency for this record
   */
  public int getC_Currency_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Currency_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Currency.
   *
   * @param C_Currency_ID The Currency for this record
   */
  public void setC_Currency_ID(int C_Currency_ID) {
    if (C_Currency_ID < 1) set_Value(COLUMNNAME_C_Currency_ID, null);
    else set_Value(COLUMNNAME_C_Currency_ID, C_Currency_ID);
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
   * Get Enforce price limit.
   *
   * @return Do not allow prices below the limit price
   */
  public boolean isEnforcePriceLimit() {
    Object oo = get_Value(COLUMNNAME_EnforcePriceLimit);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Enforce price limit.
   *
   * @param EnforcePriceLimit Do not allow prices below the limit price
   */
  public void setEnforcePriceLimit(boolean EnforcePriceLimit) {
    set_Value(COLUMNNAME_EnforcePriceLimit, Boolean.valueOf(EnforcePriceLimit));
  }

  /**
   * Set Default.
   *
   * @param IsDefault Default value
   */
  public void setIsDefault(boolean IsDefault) {
    set_Value(COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
  }

  /**
   * Get Default.
   *
   * @return Default value
   */
  public boolean isDefault() {
    Object oo = get_Value(COLUMNNAME_IsDefault);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Mandatory.
   *
   * @param IsMandatory Data entry is required in this column
   */
  public void setIsMandatory(boolean IsMandatory) {
    set_Value(COLUMNNAME_IsMandatory, Boolean.valueOf(IsMandatory));
  }

  /**
   * Get Mandatory.
   *
   * @return Data entry is required in this column
   */
  public boolean isMandatory() {
    Object oo = get_Value(COLUMNNAME_IsMandatory);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set isPresentForProduct.
   *
   * @param isPresentForProduct isPresentForProduct
   */
  public void setisPresentForProduct(boolean isPresentForProduct) {
    set_Value(COLUMNNAME_isPresentForProduct, Boolean.valueOf(isPresentForProduct));
  }

  /**
   * Get isPresentForProduct.
   *
   * @return isPresentForProduct
   */
  public boolean isPresentForProduct() {
    Object oo = get_Value(COLUMNNAME_isPresentForProduct);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Sales Price list.
   *
   * @param IsSOPriceList This is a Sales Price List
   */
  public void setIsSOPriceList(boolean IsSOPriceList) {
    set_Value(COLUMNNAME_IsSOPriceList, Boolean.valueOf(IsSOPriceList));
  }

  /**
   * Get Sales Price list.
   *
   * @return This is a Sales Price List
   */
  public boolean isSOPriceList() {
    Object oo = get_Value(COLUMNNAME_IsSOPriceList);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Price includes Tax.
   *
   * @param IsTaxIncluded Tax is included in the price
   */
  public void setIsTaxIncluded(boolean IsTaxIncluded) {
    set_Value(COLUMNNAME_IsTaxIncluded, Boolean.valueOf(IsTaxIncluded));
  }

  /**
   * Get Price includes Tax.
   *
   * @return Tax is included in the price
   */
  public boolean isTaxIncluded() {
    Object oo = get_Value(COLUMNNAME_IsTaxIncluded);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Get Price List.
   *
   * @return Unique identifier of a Price List
   */
  public int getM_PriceList_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_PriceList_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Price List.
   *
   * @param M_PriceList_ID Unique identifier of a Price List
   */
  public void setM_PriceList_ID(int M_PriceList_ID) {
    if (M_PriceList_ID < 1) set_ValueNoCheck(COLUMNNAME_M_PriceList_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_PriceList_ID, Integer.valueOf(M_PriceList_ID));
  }

  /**
   * Get M_PriceList_UU.
   *
   * @return M_PriceList_UU
   */
  public String getM_PriceList_UU() {
    return (String) get_Value(COLUMNNAME_M_PriceList_UU);
  }

  /**
   * Set M_PriceList_UU.
   *
   * @param M_PriceList_UU M_PriceList_UU
   */
  public void setM_PriceList_UU(String M_PriceList_UU) {
    set_Value(COLUMNNAME_M_PriceList_UU, M_PriceList_UU);
  }

  /**
   * Get Name.
   *
   * @return Alphanumeric identifier of the entity
   */
  public String getName() {
    return (String) get_Value(HasName.Companion.getCOLUMNNAME_Name());
  }

  /**
   * Set Name.
   *
   * @param Name Alphanumeric identifier of the entity
   */
  public void setName(String Name) {
    set_Value(HasName.Companion.getCOLUMNNAME_Name(), Name);
  }

  /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), getName());
  }

  /**
   * Get Price Precision.
   *
   * @return Precision (number of decimals) for the Price
   */
  public int getPricePrecision() {
    Integer ii = (Integer) get_Value(COLUMNNAME_PricePrecision);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Price Precision.
   *
   * @param PricePrecision Precision (number of decimals) for the Price
   */
  public void setPricePrecision(int PricePrecision) {
    set_Value(COLUMNNAME_PricePrecision, Integer.valueOf(PricePrecision));
  }
}