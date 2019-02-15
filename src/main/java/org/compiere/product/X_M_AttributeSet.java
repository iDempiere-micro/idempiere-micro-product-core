package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_AttributeSet;
import org.compiere.orm.BasePOName;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_AttributeSet
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeSet extends BasePOName implements I_M_AttributeSet, I_Persistent {

    /** Not Mandatory = N */
  public static final String MANDATORYTYPE_NotMandatory = "N";
  /** Always Mandatory = Y */
  public static final String MANDATORYTYPE_AlwaysMandatory = "Y";
  /** When Shipping = S */
  public static final String MANDATORYTYPE_WhenShipping = "S";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_AttributeSet(Properties ctx, int M_AttributeSet_ID) {
    super(ctx, M_AttributeSet_ID);
  }

  /** Load Constructor */
  public X_M_AttributeSet(Properties ctx, ResultSet rs) {
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
    return "X_M_AttributeSet[" + getId() + "]";
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
   * Get Lot Char Start Overwrite.
   *
   * @return Lot/Batch Start Indicator overwrite - default «
   */
  public String getLotCharSOverwrite() {
    return (String) get_Value(COLUMNNAME_LotCharSOverwrite);
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
   * Get SerNo Char End Overwrite.
   *
   * @return Serial Number End Indicator overwrite - default empty
   */
  public String getSerNoCharEOverwrite() {
    return (String) get_Value(COLUMNNAME_SerNoCharEOverwrite);
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

    @Override
  public int getTableId() {
    return I_M_AttributeSet.Table_ID;
  }
}
