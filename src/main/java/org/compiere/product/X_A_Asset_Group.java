package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_A_Asset_Group;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for A_Asset_Group
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_A_Asset_Group extends BasePOName implements I_A_Asset_Group, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_A_Asset_Group(Properties ctx, int A_Asset_Group_ID, String trxName) {
    super(ctx, A_Asset_Group_ID, trxName);
  }

  /** Load Constructor */
  public X_A_Asset_Group(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_A_Asset_Group[").append(getId()).append("]");
    return sb.toString();
  }

  public org.compiere.model.I_A_Asset_Class getA_Asset_Class() throws RuntimeException {
    return (org.compiere.model.I_A_Asset_Class)
        MTable.get(getCtx(), org.compiere.model.I_A_Asset_Class.Table_Name)
            .getPO(getA_Asset_Class_ID(), get_TrxName());
  }

  /**
   * Get Asset class.
   *
   * @return Asset class
   */
  public int getA_Asset_Class_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Asset_Class_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Asset class.
   *
   * @param A_Asset_Class_ID Asset class
   */
  public void setA_Asset_Class_ID(int A_Asset_Class_ID) {
    if (A_Asset_Class_ID < 1) set_Value(COLUMNNAME_A_Asset_Class_ID, null);
    else set_Value(COLUMNNAME_A_Asset_Class_ID, Integer.valueOf(A_Asset_Class_ID));
  }

  /**
   * Get Asset Group.
   *
   * @return Group of Assets
   */
  public int getA_Asset_Group_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Asset_Group_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Asset Group.
   *
   * @param A_Asset_Group_ID Group of Assets
   */
  public void setA_Asset_Group_ID(int A_Asset_Group_ID) {
    if (A_Asset_Group_ID < 1) set_ValueNoCheck(COLUMNNAME_A_Asset_Group_ID, null);
    else set_ValueNoCheck(COLUMNNAME_A_Asset_Group_ID, Integer.valueOf(A_Asset_Group_ID));
  }

  /**
   * Get A_Asset_Group_UU.
   *
   * @return A_Asset_Group_UU
   */
  public String getA_Asset_Group_UU() {
    return (String) get_Value(COLUMNNAME_A_Asset_Group_UU);
  }

  /**
   * Set A_Asset_Group_UU.
   *
   * @param A_Asset_Group_UU A_Asset_Group_UU
   */
  public void setA_Asset_Group_UU(String A_Asset_Group_UU) {
    set_Value(COLUMNNAME_A_Asset_Group_UU, A_Asset_Group_UU);
  }

  public org.compiere.model.I_A_Asset_Type getA_Asset_Type() throws RuntimeException {
    return (org.compiere.model.I_A_Asset_Type)
        MTable.get(getCtx(), org.compiere.model.I_A_Asset_Type.Table_Name)
            .getPO(getA_Asset_Type_ID(), get_TrxName());
  }

  /**
   * Get Asset Type.
   *
   * @return Asset Type
   */
  public int getA_Asset_Type_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Asset_Type_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Asset Type.
   *
   * @param A_Asset_Type_ID Asset Type
   */
  public void setA_Asset_Type_ID(int A_Asset_Type_ID) {
    if (A_Asset_Type_ID < 1) set_Value(COLUMNNAME_A_Asset_Type_ID, null);
    else set_Value(COLUMNNAME_A_Asset_Type_ID, Integer.valueOf(A_Asset_Type_ID));
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

  /**
   * Set Create As Active.
   *
   * @param IsCreateAsActive Create Asset and activate it
   */
  public void setIsCreateAsActive(boolean IsCreateAsActive) {
    set_Value(COLUMNNAME_IsCreateAsActive, Boolean.valueOf(IsCreateAsActive));
  }

  /**
   * Get Create As Active.
   *
   * @return Create Asset and activate it
   */
  public boolean isCreateAsActive() {
    Object oo = get_Value(COLUMNNAME_IsCreateAsActive);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
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
   * Set Depreciate.
   *
   * @param IsDepreciated The asset will be depreciated
   */
  public void setIsDepreciated(boolean IsDepreciated) {
    set_Value(COLUMNNAME_IsDepreciated, Boolean.valueOf(IsDepreciated));
  }

  /**
   * Get Depreciate.
   *
   * @return The asset will be depreciated
   */
  public boolean isDepreciated() {
    Object oo = get_Value(COLUMNNAME_IsDepreciated);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set IsFixedAsset.
   *
   * @param IsFixedAsset IsFixedAsset
   */
  public void setIsFixedAsset(boolean IsFixedAsset) {
    set_Value(COLUMNNAME_IsFixedAsset, Boolean.valueOf(IsFixedAsset));
  }

  /**
   * Get IsFixedAsset.
   *
   * @return IsFixedAsset
   */
  public boolean isFixedAsset() {
    Object oo = get_Value(COLUMNNAME_IsFixedAsset);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set One Asset Per UOM.
   *
   * @param IsOneAssetPerUOM Create one asset per UOM
   */
  public void setIsOneAssetPerUOM(boolean IsOneAssetPerUOM) {
    set_Value(COLUMNNAME_IsOneAssetPerUOM, Boolean.valueOf(IsOneAssetPerUOM));
  }

  /**
   * Get One Asset Per UOM.
   *
   * @return Create one asset per UOM
   */
  public boolean isOneAssetPerUOM() {
    Object oo = get_Value(COLUMNNAME_IsOneAssetPerUOM);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Owned.
   *
   * @param IsOwned The asset is owned by the organization
   */
  public void setIsOwned(boolean IsOwned) {
    set_Value(COLUMNNAME_IsOwned, Boolean.valueOf(IsOwned));
  }

  /**
   * Get Owned.
   *
   * @return The asset is owned by the organization
   */
  public boolean isOwned() {
    Object oo = get_Value(COLUMNNAME_IsOwned);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Track Issues.
   *
   * @param IsTrackIssues Enable tracking issues for this asset
   */
  public void setIsTrackIssues(boolean IsTrackIssues) {
    set_Value(COLUMNNAME_IsTrackIssues, Boolean.valueOf(IsTrackIssues));
  }

  /**
   * Get Track Issues.
   *
   * @return Enable tracking issues for this asset
   */
  public boolean isTrackIssues() {
    Object oo = get_Value(COLUMNNAME_IsTrackIssues);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  @Override
  public int getTableId() {
    return I_A_Asset_Group.Table_ID;
  }
}
