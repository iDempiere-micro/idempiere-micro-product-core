package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_AttributeSet;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_AttributeSet
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeSet extends BasePOName implements I_M_AttributeSet, I_Persistent {

  /** MandatoryType AD_Reference_ID=324 */
  public static final int MANDATORYTYPE_AD_Reference_ID = 324;
  /** Not Mandatory = N */
  public static final String MANDATORYTYPE_NotMandatory = "N";
  /** Always Mandatory = Y */
  public static final String MANDATORYTYPE_AlwaysMandatory = "Y";
  /** When Shipping = S */
  public static final String MANDATORYTYPE_WhenShipping = "S";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_AttributeSet(Properties ctx, int M_AttributeSet_ID, String trxName) {
    super(ctx, M_AttributeSet_ID, trxName);
  }

  /** Load Constructor */
  public X_M_AttributeSet(Properties ctx, ResultSet rs, String trxName) {
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
    return "X_M_AttributeSet[" + getId() + "]";
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
   * Get Guarantee Days.
   *
   * @return Number of days the product is guaranteed or available
   */
  public int getGuaranteeDays() {
    Integer ii = (Integer) get_Value(COLUMNNAME_GuaranteeDays);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Guarantee Days.
   *
   * @param GuaranteeDays Number of days the product is guaranteed or available
   */
  public void setGuaranteeDays(int GuaranteeDays) {
    set_Value(COLUMNNAME_GuaranteeDays, GuaranteeDays);
  }

  /**
   * Set IsAutoGenerateLot.
   *
   * @param IsAutoGenerateLot IsAutoGenerateLot
   */
  public void setIsAutoGenerateLot(boolean IsAutoGenerateLot) {
    set_Value(COLUMNNAME_IsAutoGenerateLot, Boolean.valueOf(IsAutoGenerateLot));
  }

  /**
   * Get IsAutoGenerateLot.
   *
   * @return IsAutoGenerateLot
   */
  public boolean isAutoGenerateLot() {
    Object oo = get_Value(COLUMNNAME_IsAutoGenerateLot);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Guarantee Date.
   *
   * @param IsGuaranteeDate Product has Guarantee or Expiry Date
   */
  public void setIsGuaranteeDate(boolean IsGuaranteeDate) {
    set_Value(COLUMNNAME_IsGuaranteeDate, Boolean.valueOf(IsGuaranteeDate));
  }

  /**
   * Get Guarantee Date.
   *
   * @return Product has Guarantee or Expiry Date
   */
  public boolean isGuaranteeDate() {
    Object oo = get_Value(COLUMNNAME_IsGuaranteeDate);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Mandatory Guarantee Date.
   *
   * @param IsGuaranteeDateMandatory The entry of a Guarantee Date is mandatory when creating a
   *     Product Instance
   */
  public void setIsGuaranteeDateMandatory(boolean IsGuaranteeDateMandatory) {
    set_Value(COLUMNNAME_IsGuaranteeDateMandatory, Boolean.valueOf(IsGuaranteeDateMandatory));
  }

  /**
   * Get Mandatory Guarantee Date.
   *
   * @return The entry of a Guarantee Date is mandatory when creating a Product Instance
   */
  public boolean isGuaranteeDateMandatory() {
    Object oo = get_Value(COLUMNNAME_IsGuaranteeDateMandatory);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Instance Attribute.
   *
   * @param IsInstanceAttribute The product attribute is specific to the instance (like Serial No,
   *     Lot or Guarantee Date)
   */
  public void setIsInstanceAttribute(boolean IsInstanceAttribute) {
    set_Value(COLUMNNAME_IsInstanceAttribute, Boolean.valueOf(IsInstanceAttribute));
  }

  /**
   * Get Instance Attribute.
   *
   * @return The product attribute is specific to the instance (like Serial No, Lot or Guarantee
   *     Date)
   */
  public boolean isInstanceAttribute() {
    Object oo = get_Value(COLUMNNAME_IsInstanceAttribute);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Lot.
   *
   * @param IsLot The product instances have a Lot Number
   */
  public void setIsLot(boolean IsLot) {
    set_Value(COLUMNNAME_IsLot, Boolean.valueOf(IsLot));
  }

  /**
   * Get Lot.
   *
   * @return The product instances have a Lot Number
   */
  public boolean isLot() {
    Object oo = get_Value(COLUMNNAME_IsLot);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Mandatory Lot.
   *
   * @param IsLotMandatory The entry of Lot info is mandatory when creating a Product Instance
   */
  public void setIsLotMandatory(boolean IsLotMandatory) {
    set_Value(COLUMNNAME_IsLotMandatory, Boolean.valueOf(IsLotMandatory));
  }

  /**
   * Get Mandatory Lot.
   *
   * @return The entry of Lot info is mandatory when creating a Product Instance
   */
  public boolean isLotMandatory() {
    Object oo = get_Value(COLUMNNAME_IsLotMandatory);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Serial No.
   *
   * @param IsSerNo The product instances have Serial Numbers
   */
  public void setIsSerNo(boolean IsSerNo) {
    set_Value(COLUMNNAME_IsSerNo, Boolean.valueOf(IsSerNo));
  }

  /**
   * Get Serial No.
   *
   * @return The product instances have Serial Numbers
   */
  public boolean isSerNo() {
    Object oo = get_Value(COLUMNNAME_IsSerNo);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Mandatory Serial No.
   *
   * @param IsSerNoMandatory The entry of a Serial No is mandatory when creating a Product Instance
   */
  public void setIsSerNoMandatory(boolean IsSerNoMandatory) {
    set_Value(COLUMNNAME_IsSerNoMandatory, Boolean.valueOf(IsSerNoMandatory));
  }

  /**
   * Get Mandatory Serial No.
   *
   * @return The entry of a Serial No is mandatory when creating a Product Instance
   */
  public boolean isSerNoMandatory() {
    Object oo = get_Value(COLUMNNAME_IsSerNoMandatory);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Get Lot Char End Overwrite.
   *
   * @return Lot/Batch End Indicator overwrite - default »
   */
  public String getLotCharEOverwrite() {
    return (String) get_Value(COLUMNNAME_LotCharEOverwrite);
  }

  /**
   * Set Lot Char End Overwrite.
   *
   * @param LotCharEOverwrite Lot/Batch End Indicator overwrite - default »
   */
  public void setLotCharEOverwrite(String LotCharEOverwrite) {
    set_Value(COLUMNNAME_LotCharEOverwrite, LotCharEOverwrite);
  }

  /**
   * Get Lot Char Start Overwrite.
   *
   * @return Lot/Batch Start Indicator overwrite - default «
   */
  public String getLotCharSOverwrite() {
    return (String) get_Value(COLUMNNAME_LotCharSOverwrite);
  }

  /**
   * Set Lot Char Start Overwrite.
   *
   * @param LotCharSOverwrite Lot/Batch Start Indicator overwrite - default «
   */
  public void setLotCharSOverwrite(String LotCharSOverwrite) {
    set_Value(COLUMNNAME_LotCharSOverwrite, LotCharSOverwrite);
  }

  /**
   * Get Mandatory Type.
   *
   * @return The specification of a Product Attribute Instance is mandatory
   */
  public String getMandatoryType() {
    return (String) get_Value(COLUMNNAME_MandatoryType);
  }

  /**
   * Set Mandatory Type.
   *
   * @param MandatoryType The specification of a Product Attribute Instance is mandatory
   */
  public void setMandatoryType(String MandatoryType) {

    set_Value(COLUMNNAME_MandatoryType, MandatoryType);
  }

  /**
   * Set Attribute Set.
   *
   * @param M_AttributeSet_ID Product Attribute Set
   */
  public void setM_AttributeSet_ID(int M_AttributeSet_ID) {
    if (M_AttributeSet_ID < 0) set_ValueNoCheck(COLUMNNAME_M_AttributeSet_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_AttributeSet_ID, Integer.valueOf(M_AttributeSet_ID));
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

  /**
   * Set M_AttributeSet_UU.
   *
   * @param M_AttributeSet_UU M_AttributeSet_UU
   */
  public void setM_AttributeSet_UU(String M_AttributeSet_UU) {
    set_Value(COLUMNNAME_M_AttributeSet_UU, M_AttributeSet_UU);
  }

  /**
   * Get M_AttributeSet_UU.
   *
   * @return M_AttributeSet_UU
   */
  public String getMAttributeSet_UU() {
    return (String) get_Value(COLUMNNAME_M_AttributeSet_UU);
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
    if (M_LotCtl_ID < 1) set_Value(COLUMNNAME_M_LotCtl_ID, null);
    else set_Value(COLUMNNAME_M_LotCtl_ID, Integer.valueOf(M_LotCtl_ID));
  }

  public org.compiere.model.I_M_SerNoCtl getM_SerNoCtl() throws RuntimeException {
    return (org.compiere.model.I_M_SerNoCtl)
        MTable.get(getCtx(), org.compiere.model.I_M_SerNoCtl.Table_Name)
            .getPO(getM_SerNoCtl_ID(), null);
  }

  /**
   * Get Serial No Control.
   *
   * @return Product Serial Number Control
   */
  public int getM_SerNoCtl_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_SerNoCtl_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Serial No Control.
   *
   * @param M_SerNoCtl_ID Product Serial Number Control
   */
  public void setM_SerNoCtl_ID(int M_SerNoCtl_ID) {
    if (M_SerNoCtl_ID < 1) set_Value(COLUMNNAME_M_SerNoCtl_ID, null);
    else set_Value(COLUMNNAME_M_SerNoCtl_ID, Integer.valueOf(M_SerNoCtl_ID));
  }

  /**
   * Get SerNo Char End Overwrite.
   *
   * @return Serial Number End Indicator overwrite - default empty
   */
  public String getSerNoCharEOverwrite() {
    return (String) get_Value(COLUMNNAME_SerNoCharEOverwrite);
  }

  /**
   * Set SerNo Char End Overwrite.
   *
   * @param SerNoCharEOverwrite Serial Number End Indicator overwrite - default empty
   */
  public void setSerNoCharEOverwrite(String SerNoCharEOverwrite) {
    set_Value(COLUMNNAME_SerNoCharEOverwrite, SerNoCharEOverwrite);
  }

  /**
   * Get SerNo Char Start Overwrite.
   *
   * @return Serial Number Start Indicator overwrite - default #
   */
  public String getSerNoCharSOverwrite() {
    return (String) get_Value(COLUMNNAME_SerNoCharSOverwrite);
  }

  /**
   * Set SerNo Char Start Overwrite.
   *
   * @param SerNoCharSOverwrite Serial Number Start Indicator overwrite - default #
   */
  public void setSerNoCharSOverwrite(String SerNoCharSOverwrite) {
    set_Value(COLUMNNAME_SerNoCharSOverwrite, SerNoCharSOverwrite);
  }

  /**
   * Get Use Guarantee Date for Material Policy.
   *
   * @return Use Guarantee Date for Material Policy
   */
  public boolean isUseGuaranteeDateForMPolicy() {
    Object oo = get_Value(COLUMNNAME_UseGuaranteeDateForMPolicy);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo);
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Use Guarantee Date for Material Policy.
   *
   * @param UseGuaranteeDateForMPolicy Use Guarantee Date for Material Policy
   */
  public void setUseGuaranteeDateForMPolicy(boolean UseGuaranteeDateForMPolicy) {
    set_Value(COLUMNNAME_UseGuaranteeDateForMPolicy, UseGuaranteeDateForMPolicy);
  }

  @Override
  public int getTableId() {
    return I_M_AttributeSet.Table_ID;
  }
}