package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.HasName;
import org.compiere.model.I_I_PriceList;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for I_PriceList
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_I_PriceList extends PO implements I_I_PriceList, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_I_PriceList(Properties ctx, int I_PriceList_ID, String trxName) {
    super(ctx, I_PriceList_ID, trxName);
    /** if (I_PriceList_ID == 0) { setI_IsImported (false); // N setI_PriceList_ID (0); } */
  }

  /** Load Constructor */
  public X_I_PriceList(Properties ctx, ResultSet rs, String trxName) {
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
    return "X_I_PriceList[" + getId() + "]";
  }

  /**
   * Get Business Partner Key.
   *
   * @return The Key of the Business Partner
   */
  public String getBPartner_Value() {
    return (String) get_Value(COLUMNNAME_BPartner_Value);
  }

  /**
   * Set Business Partner Key.
   *
   * @param BPartner_Value The Key of the Business Partner
   */
  public void setBPartner_Value(String BPartner_Value) {
    set_Value(COLUMNNAME_BPartner_Value, BPartner_Value);
  }

  /**
   * Get Break Value.
   *
   * @return Low Value of trade discount break level
   */
  public BigDecimal getBreakValue() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_BreakValue);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Break Value.
   *
   * @param BreakValue Low Value of trade discount break level
   */
  public void setBreakValue(BigDecimal BreakValue) {
    set_Value(COLUMNNAME_BreakValue, BreakValue);
  }

  public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
            .getPO(getC_BPartner_ID(), null);
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
    if (C_BPartner_ID < 1) set_Value(COLUMNNAME_C_BPartner_ID, null);
    else set_Value(COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
  }

  public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException {
    return (org.compiere.model.I_C_Currency)
        MTable.get(getCtx(), org.compiere.model.I_C_Currency.Table_Name)
            .getPO(getC_Currency_ID(), null);
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
    else set_Value(COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
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
   * Get Import Error Message.
   *
   * @return Messages generated from import process
   */
  public String getI_ErrorMsg() {
    return (String) get_Value(COLUMNNAME_I_ErrorMsg);
  }

  /**
   * Set Import Error Message.
   *
   * @param I_ErrorMsg Messages generated from import process
   */
  public void setI_ErrorMsg(String I_ErrorMsg) {
    set_Value(COLUMNNAME_I_ErrorMsg, I_ErrorMsg);
  }

  /**
   * Get Imported.
   *
   * @return Has this import been processed
   */
  public boolean isI_IsImported() {
    Object oo = get_Value(COLUMNNAME_I_IsImported);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Imported.
   *
   * @param I_IsImported Has this import been processed
   */
  public void setI_IsImported(boolean I_IsImported) {
    set_Value(COLUMNNAME_I_IsImported, Boolean.valueOf(I_IsImported));
  }

  /**
   * Get Import Price List.
   *
   * @return Import Price List
   */
  public int getI_PriceList_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_I_PriceList_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Import Price List.
   *
   * @param I_PriceList_ID Import Price List
   */
  public void setI_PriceList_ID(int I_PriceList_ID) {
    if (I_PriceList_ID < 1) set_ValueNoCheck(COLUMNNAME_I_PriceList_ID, null);
    else set_ValueNoCheck(COLUMNNAME_I_PriceList_ID, Integer.valueOf(I_PriceList_ID));
  }

  /**
   * Get I_PriceList_UU.
   *
   * @return I_PriceList_UU
   */
  public String getI_PriceList_UU() {
    return (String) get_Value(COLUMNNAME_I_PriceList_UU);
  }

  /**
   * Set I_PriceList_UU.
   *
   * @param I_PriceList_UU I_PriceList_UU
   */
  public void setI_PriceList_UU(String I_PriceList_UU) {
    set_Value(COLUMNNAME_I_PriceList_UU, I_PriceList_UU);
  }

  /**
   * Get ISO Currency Code.
   *
   * @return Three letter ISO 4217 Code of the Currency
   */
  public String getISO_Code() {
    return (String) get_Value(COLUMNNAME_ISO_Code);
  }

  /**
   * Set ISO Currency Code.
   *
   * @param ISO_Code Three letter ISO 4217 Code of the Currency
   */
  public void setISO_Code(String ISO_Code) {
    set_Value(COLUMNNAME_ISO_Code, ISO_Code);
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

  public org.compiere.model.I_M_PriceList getM_PriceList() throws RuntimeException {
    return (org.compiere.model.I_M_PriceList)
        MTable.get(getCtx(), org.compiere.model.I_M_PriceList.Table_Name)
            .getPO(getM_PriceList_ID(), null);
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
    if (M_PriceList_ID < 1) set_Value(COLUMNNAME_M_PriceList_ID, null);
    else set_Value(COLUMNNAME_M_PriceList_ID, Integer.valueOf(M_PriceList_ID));
  }

  public org.compiere.model.I_M_PriceList_Version getM_PriceList_Version() throws RuntimeException {
    return (org.compiere.model.I_M_PriceList_Version)
        MTable.get(getCtx(), org.compiere.model.I_M_PriceList_Version.Table_Name)
            .getPO(getM_PriceList_Version_ID(), null);
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
    if (M_PriceList_Version_ID < 1) set_Value(COLUMNNAME_M_PriceList_Version_ID, null);
    else set_Value(COLUMNNAME_M_PriceList_Version_ID, Integer.valueOf(M_PriceList_Version_ID));
  }

  public org.compiere.model.I_M_Product getM_Product() throws RuntimeException {
    return (org.compiere.model.I_M_Product)
        MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
            .getPO(getM_Product_ID(), null);
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
    if (M_Product_ID < 1) set_Value(COLUMNNAME_M_Product_ID, null);
    else set_Value(COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
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

  /**
   * Get Processed.
   *
   * @return The document has been processed
   */
  public boolean isProcessed() {
    Object oo = get_Value(COLUMNNAME_Processed);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Processed.
   *
   * @param Processed The document has been processed
   */
  public void setProcessed(boolean Processed) {
    set_Value(COLUMNNAME_Processed, Boolean.valueOf(Processed));
  }

  /**
   * Get Process Now.
   *
   * @return Process Now
   */
  public boolean isProcessing() {
    Object oo = get_Value(COLUMNNAME_Processing);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
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
   * Get Product Key.
   *
   * @return Key of the Product
   */
  public String getProductValue() {
    return (String) get_Value(COLUMNNAME_ProductValue);
  }

  /**
   * Set Product Key.
   *
   * @param ProductValue Key of the Product
   */
  public void setProductValue(String ProductValue) {
    set_Value(COLUMNNAME_ProductValue, ProductValue);
  }

  /**
   * Get Valid from.
   *
   * @return Valid from including this date (first day)
   */
  public Timestamp getValidFrom() {
    return (Timestamp) get_Value(COLUMNNAME_ValidFrom);
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
   * Get UOM Code.
   *
   * @return UOM EDI X12 Code
   */
  public String getX12DE355() {
    return (String) get_Value(COLUMNNAME_X12DE355);
  }

  /**
   * Set UOM Code.
   *
   * @param X12DE355 UOM EDI X12 Code
   */
  public void setX12DE355(String X12DE355) {
    set_Value(COLUMNNAME_X12DE355, X12DE355);
  }

  @Override
  public int getTableId() {
    return I_I_PriceList.Table_ID;
  }
}