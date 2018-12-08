package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.orm.BasePOUser;
import org.compiere.orm.MTable;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for A_Asset
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_A_Asset extends BasePOUser implements I_A_Asset, I_Persistent {

  /** A_Asset_Action AD_Reference_ID=53360 */
  public static final int A_ASSET_ACTION_AD_Reference_ID = 53360;
  /** Dispose = DI */
  public static final String A_ASSET_ACTION_Dispose = "DI";
  /** Inbound = IB */
  public static final String A_ASSET_ACTION_Inbound = "IB";
  /** Modify = MD */
  public static final String A_ASSET_ACTION_Modify = "MD";
  /** Outbound = OB */
  public static final String A_ASSET_ACTION_Outbound = "OB";
  /** Reevaluate = RE */
  public static final String A_ASSET_ACTION_Reevaluate = "RE";
  /** Retire = RT */
  public static final String A_ASSET_ACTION_Retire = "RT";
  /** Transfer = TR */
  public static final String A_ASSET_ACTION_Transfer = "TR";
  /** A_Asset_Status AD_Reference_ID=53359 */
  public static final int A_ASSET_STATUS_AD_Reference_ID = 53359;
  /** Activated = AC */
  public static final String A_ASSET_STATUS_Activated = "AC";
  /** Disposed = DI */
  public static final String A_ASSET_STATUS_Disposed = "DI";
  /** Depreciated = DP */
  public static final String A_ASSET_STATUS_Depreciated = "DP";
  /** New = NW */
  public static final String A_ASSET_STATUS_New = "NW";
  /** Preservation = PR */
  public static final String A_ASSET_STATUS_Preservation = "PR";
  /** Retired = RE */
  public static final String A_ASSET_STATUS_Retired = "RE";
  /** Sold = SO */
  public static final String A_ASSET_STATUS_Sold = "SO";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_A_Asset(Properties ctx, int A_Asset_ID, String trxName) {
    super(ctx, A_Asset_ID, trxName);
    /**
     * if (A_Asset_ID == 0) { setA_Asset_Action (null); // 'MD' setA_Asset_Group_ID (0);
     * setA_Asset_ID (0); setA_Asset_Status (null); // 'NW' setIsDepreciated (false); setIsDisposed
     * (false); setIsFullyDepreciated (false); // N setIsInPosession (false); setIsOwned (false);
     * setM_AttributeSetInstance_ID (0); setM_Product_ID (0); setName (null); setProcessed (false);
     * // 'N' setValue (null); }
     */
  }

  /** Load Constructor */
  public X_A_Asset(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_A_Asset[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Get Asset Action.
   *
   * @return Asset Action
   */
  public String getA_Asset_Action() {
    return (String) get_Value(COLUMNNAME_A_Asset_Action);
  }

  /**
   * Set Asset Action.
   *
   * @param A_Asset_Action Asset Action
   */
  public void setA_Asset_Action(String A_Asset_Action) {

    set_Value(COLUMNNAME_A_Asset_Action, A_Asset_Action);
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
   * Get Create Date.
   *
   * @return Create Date
   */
  public Timestamp getA_Asset_CreateDate() {
    return (Timestamp) get_Value(COLUMNNAME_A_Asset_CreateDate);
  }

  /**
   * Set Create Date.
   *
   * @param A_Asset_CreateDate Create Date
   */
  public void setA_Asset_CreateDate(Timestamp A_Asset_CreateDate) {
    set_ValueNoCheck(COLUMNNAME_A_Asset_CreateDate, A_Asset_CreateDate);
  }

  public org.compiere.model.I_A_Asset_Group getA_Asset_Group() throws RuntimeException {
    return (org.compiere.model.I_A_Asset_Group)
        MTable.get(getCtx(), org.compiere.model.I_A_Asset_Group.Table_Name)
            .getPO(getA_Asset_Group_ID(), get_TrxName());
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
    if (A_Asset_Group_ID < 1) set_Value(COLUMNNAME_A_Asset_Group_ID, null);
    else set_Value(COLUMNNAME_A_Asset_Group_ID, Integer.valueOf(A_Asset_Group_ID));
  }

  /**
   * Get Asset.
   *
   * @return Asset used internally or by customers
   */
  public int getA_Asset_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Asset_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Asset.
   *
   * @param A_Asset_ID Asset used internally or by customers
   */
  public void setA_Asset_ID(int A_Asset_ID) {
    if (A_Asset_ID < 1) set_ValueNoCheck(COLUMNNAME_A_Asset_ID, null);
    else set_ValueNoCheck(COLUMNNAME_A_Asset_ID, Integer.valueOf(A_Asset_ID));
  }

  /**
   * Get Revaluation Date.
   *
   * @return Revaluation Date
   */
  public Timestamp getA_Asset_RevalDate() {
    return (Timestamp) get_Value(COLUMNNAME_A_Asset_RevalDate);
  }

  /**
   * Set Revaluation Date.
   *
   * @param A_Asset_RevalDate Revaluation Date
   */
  public void setA_Asset_RevalDate(Timestamp A_Asset_RevalDate) {
    set_Value(COLUMNNAME_A_Asset_RevalDate, A_Asset_RevalDate);
  }

  /**
   * Get Asset Status.
   *
   * @return Asset Status
   */
  public String getA_Asset_Status() {
    return (String) get_Value(COLUMNNAME_A_Asset_Status);
  }

  /**
   * Set Asset Status.
   *
   * @param A_Asset_Status Asset Status
   */
  public void setA_Asset_Status(String A_Asset_Status) {

    set_Value(COLUMNNAME_A_Asset_Status, A_Asset_Status);
  }

  /**
   * Get Asset Type.
   *
   * @return Asset Type
   */
  public String getA_AssetType() {
    return (String) get_Value(COLUMNNAME_A_AssetType);
  }

  /**
   * Set Asset Type.
   *
   * @param A_AssetType Asset Type
   */
  public void setA_AssetType(String A_AssetType) {
    set_Value(COLUMNNAME_A_AssetType, A_AssetType);
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
   * Get A_Asset_UU.
   *
   * @return A_Asset_UU
   */
  public String getA_Asset_UU() {
    return (String) get_Value(COLUMNNAME_A_Asset_UU);
  }

  /**
   * Set A_Asset_UU.
   *
   * @param A_Asset_UU A_Asset_UU
   */
  public void setA_Asset_UU(String A_Asset_UU) {
    set_Value(COLUMNNAME_A_Asset_UU, A_Asset_UU);
  }

  public org.compiere.model.I_A_Asset getA_Parent_Asset() throws RuntimeException {
    return (org.compiere.model.I_A_Asset)
        MTable.get(getCtx(), org.compiere.model.I_A_Asset.Table_Name)
            .getPO(getA_Parent_Asset_ID(), get_TrxName());
  }

  /**
   * Get Parent Asset.
   *
   * @return Parent Asset
   */
  public int getA_Parent_Asset_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Parent_Asset_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Parent Asset.
   *
   * @param A_Parent_Asset_ID Parent Asset
   */
  public void setA_Parent_Asset_ID(int A_Parent_Asset_ID) {
    if (A_Parent_Asset_ID < 1) set_Value(COLUMNNAME_A_Parent_Asset_ID, null);
    else set_Value(COLUMNNAME_A_Parent_Asset_ID, Integer.valueOf(A_Parent_Asset_ID));
  }

  /**
   * Get Current Qty.
   *
   * @return Current Qty
   */
  public BigDecimal getA_QTY_Current() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_A_QTY_Current);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Current Qty.
   *
   * @param A_QTY_Current Current Qty
   */
  public void setA_QTY_Current(BigDecimal A_QTY_Current) {
    set_Value(COLUMNNAME_A_QTY_Current, A_QTY_Current);
  }

  /**
   * Get A_QTY_Original.
   *
   * @return A_QTY_Original
   */
  public BigDecimal getA_QTY_Original() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_A_QTY_Original);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set A_QTY_Original.
   *
   * @param A_QTY_Original A_QTY_Original
   */
  public void setA_QTY_Original(BigDecimal A_QTY_Original) {
    set_Value(COLUMNNAME_A_QTY_Original, A_QTY_Original);
  }

  /**
   * Get Activation Date.
   *
   * @return Activation Date
   */
  public Timestamp getAssetActivationDate() {
    return (Timestamp) get_Value(COLUMNNAME_AssetActivationDate);
  }

  /**
   * Set Activation Date.
   *
   * @param AssetActivationDate Activation Date
   */
  public void setAssetActivationDate(Timestamp AssetActivationDate) {
    set_Value(COLUMNNAME_AssetActivationDate, AssetActivationDate);
  }

  /**
   * Get Asset Depreciation Date.
   *
   * @return Date of last depreciation
   */
  public Timestamp getAssetDepreciationDate() {
    return (Timestamp) get_Value(COLUMNNAME_AssetDepreciationDate);
  }

  /**
   * Set Asset Depreciation Date.
   *
   * @param AssetDepreciationDate Date of last depreciation
   */
  public void setAssetDepreciationDate(Timestamp AssetDepreciationDate) {
    set_Value(COLUMNNAME_AssetDepreciationDate, AssetDepreciationDate);
  }

  /**
   * Get Asset Disposal Date.
   *
   * @return Date when the asset is/was disposed
   */
  public Timestamp getAssetDisposalDate() {
    return (Timestamp) get_Value(COLUMNNAME_AssetDisposalDate);
  }

  /**
   * Set Asset Disposal Date.
   *
   * @param AssetDisposalDate Date when the asset is/was disposed
   */
  public void setAssetDisposalDate(Timestamp AssetDisposalDate) {
    set_Value(COLUMNNAME_AssetDisposalDate, AssetDisposalDate);
  }

  /**
   * Get In Service Date.
   *
   * @return Date when Asset was put into service
   */
  public Timestamp getAssetServiceDate() {
    return (Timestamp) get_Value(COLUMNNAME_AssetServiceDate);
  }

  /**
   * Set In Service Date.
   *
   * @param AssetServiceDate Date when Asset was put into service
   */
  public void setAssetServiceDate(Timestamp AssetServiceDate) {
    set_Value(COLUMNNAME_AssetServiceDate, AssetServiceDate);
  }

  public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException {
    return (org.compiere.model.I_C_Activity)
        MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_Name)
            .getPO(getC_Activity_ID(), get_TrxName());
  }

  /**
   * Get Activity.
   *
   * @return Business Activity
   */
  public int getC_Activity_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Activity_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Activity.
   *
   * @param C_Activity_ID Business Activity
   */
  public void setC_Activity_ID(int C_Activity_ID) {
    if (C_Activity_ID < 1) set_Value(COLUMNNAME_C_Activity_ID, null);
    else set_Value(COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
  }

  public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
            .getPO(getC_BPartner_ID(), get_TrxName());
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

  public org.compiere.model.I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner_Location)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner_Location.Table_Name)
            .getPO(getC_BPartner_Location_ID(), get_TrxName());
  }

  /**
   * Get Partner Location.
   *
   * @return Identifies the (ship to) address for this Business Partner
   */
  public int getC_BPartner_Location_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_BPartner_Location_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Partner Location.
   *
   * @param C_BPartner_Location_ID Identifies the (ship to) address for this Business Partner
   */
  public void setC_BPartner_Location_ID(int C_BPartner_Location_ID) {
    if (C_BPartner_Location_ID < 1) set_Value(COLUMNNAME_C_BPartner_Location_ID, null);
    else set_Value(COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
  }

  public org.compiere.model.I_C_BPartner getC_BPartnerSR() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
            .getPO(getC_BPartnerSR_ID(), get_TrxName());
  }

  /**
   * Get BPartner (Agent).
   *
   * @return Business Partner (Agent or Sales Rep)
   */
  public int getC_BPartnerSR_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_BPartnerSR_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set BPartner (Agent).
   *
   * @param C_BPartnerSR_ID Business Partner (Agent or Sales Rep)
   */
  public void setC_BPartnerSR_ID(int C_BPartnerSR_ID) {
    if (C_BPartnerSR_ID < 1) set_Value(COLUMNNAME_C_BPartnerSR_ID, null);
    else set_Value(COLUMNNAME_C_BPartnerSR_ID, Integer.valueOf(C_BPartnerSR_ID));
  }

  public I_C_Location getC_Location() throws RuntimeException {
    return (I_C_Location)
        MTable.get(getCtx(), I_C_Location.Table_Name).getPO(getC_Location_ID(), get_TrxName());
  }

  /**
   * Get Address.
   *
   * @return Location or Address
   */
  public int getC_Location_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Location_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Address.
   *
   * @param C_Location_ID Location or Address
   */
  public void setC_Location_ID(int C_Location_ID) {
    if (C_Location_ID < 1) set_Value(COLUMNNAME_C_Location_ID, null);
    else set_Value(COLUMNNAME_C_Location_ID, Integer.valueOf(C_Location_ID));
  }

  public org.compiere.model.I_C_Project getC_Project() throws RuntimeException {
    return (org.compiere.model.I_C_Project)
        MTable.get(getCtx(), org.compiere.model.I_C_Project.Table_Name)
            .getPO(getC_Project_ID(), get_TrxName());
  }

  /**
   * Get Project.
   *
   * @return Financial Project
   */
  public int getC_Project_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Project_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Project.
   *
   * @param C_Project_ID Financial Project
   */
  public void setC_Project_ID(int C_Project_ID) {
    if (C_Project_ID < 1) set_Value(COLUMNNAME_C_Project_ID, null);
    else set_Value(COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
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
   * Get Guarantee Date.
   *
   * @return Date when guarantee expires
   */
  public Timestamp getGuaranteeDate() {
    return (Timestamp) get_Value(COLUMNNAME_GuaranteeDate);
  }

  /**
   * Set Guarantee Date.
   *
   * @param GuaranteeDate Date when guarantee expires
   */
  public void setGuaranteeDate(Timestamp GuaranteeDate) {
    set_Value(COLUMNNAME_GuaranteeDate, GuaranteeDate);
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
   * Get Inventory No.
   *
   * @return Inventory No
   */
  public String getInventoryNo() {
    return (String) get_Value(COLUMNNAME_InventoryNo);
  }

  /**
   * Set Inventory No.
   *
   * @param InventoryNo Inventory No
   */
  public void setInventoryNo(String InventoryNo) {
    set_Value(COLUMNNAME_InventoryNo, InventoryNo);
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
   * Set Disposed.
   *
   * @param IsDisposed The asset is disposed
   */
  public void setIsDisposed(boolean IsDisposed) {
    set_Value(COLUMNNAME_IsDisposed, Boolean.valueOf(IsDisposed));
  }

  /**
   * Get Disposed.
   *
   * @return The asset is disposed
   */
  public boolean isDisposed() {
    Object oo = get_Value(COLUMNNAME_IsDisposed);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Fully depreciated.
   *
   * @param IsFullyDepreciated The asset is fully depreciated
   */
  public void setIsFullyDepreciated(boolean IsFullyDepreciated) {
    set_ValueNoCheck(COLUMNNAME_IsFullyDepreciated, Boolean.valueOf(IsFullyDepreciated));
  }

  /**
   * Get Fully depreciated.
   *
   * @return The asset is fully depreciated
   */
  public boolean isFullyDepreciated() {
    Object oo = get_Value(COLUMNNAME_IsFullyDepreciated);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set In Possession.
   *
   * @param IsInPosession The asset is in the possession of the organization
   */
  public void setIsInPosession(boolean IsInPosession) {
    set_Value(COLUMNNAME_IsInPosession, Boolean.valueOf(IsInPosession));
  }

  /**
   * Get In Possession.
   *
   * @return The asset is in the possession of the organization
   */
  public boolean isInPosession() {
    Object oo = get_Value(COLUMNNAME_IsInPosession);
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
   * Get Last Maintenance.
   *
   * @return Last Maintenance Date
   */
  public Timestamp getLastMaintenanceDate() {
    return (Timestamp) get_Value(COLUMNNAME_LastMaintenanceDate);
  }

  /**
   * Set Last Maintenance.
   *
   * @param LastMaintenanceDate Last Maintenance Date
   */
  public void setLastMaintenanceDate(Timestamp LastMaintenanceDate) {
    set_Value(COLUMNNAME_LastMaintenanceDate, LastMaintenanceDate);
  }

  /**
   * Get Last Note.
   *
   * @return Last Maintenance Note
   */
  public String getLastMaintenanceNote() {
    return (String) get_Value(COLUMNNAME_LastMaintenanceNote);
  }

  /**
   * Set Last Note.
   *
   * @param LastMaintenanceNote Last Maintenance Note
   */
  public void setLastMaintenanceNote(String LastMaintenanceNote) {
    set_Value(COLUMNNAME_LastMaintenanceNote, LastMaintenanceNote);
  }

  /**
   * Get Last Unit.
   *
   * @return Last Maintenance Unit
   */
  public int getLastMaintenanceUnit() {
    Integer ii = (Integer) get_Value(COLUMNNAME_LastMaintenanceUnit);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Last Unit.
   *
   * @param LastMaintenanceUnit Last Maintenance Unit
   */
  public void setLastMaintenanceUnit(int LastMaintenanceUnit) {
    set_Value(COLUMNNAME_LastMaintenanceUnit, Integer.valueOf(LastMaintenanceUnit));
  }

  public org.compiere.model.I_C_BPartner getLease_BPartner() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
            .getPO(getLease_BPartner_ID(), get_TrxName());
  }

  /**
   * Get Lessor.
   *
   * @return The Business Partner who rents or leases
   */
  public int getLease_BPartner_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_Lease_BPartner_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Lessor.
   *
   * @param Lease_BPartner_ID The Business Partner who rents or leases
   */
  public void setLease_BPartner_ID(int Lease_BPartner_ID) {
    if (Lease_BPartner_ID < 1) set_Value(COLUMNNAME_Lease_BPartner_ID, null);
    else set_Value(COLUMNNAME_Lease_BPartner_ID, Integer.valueOf(Lease_BPartner_ID));
  }

  /**
   * Get Lease Termination.
   *
   * @return Lease Termination Date
   */
  public Timestamp getLeaseTerminationDate() {
    return (Timestamp) get_Value(COLUMNNAME_LeaseTerminationDate);
  }

  /**
   * Set Lease Termination.
   *
   * @param LeaseTerminationDate Lease Termination Date
   */
  public void setLeaseTerminationDate(Timestamp LeaseTerminationDate) {
    set_Value(COLUMNNAME_LeaseTerminationDate, LeaseTerminationDate);
  }

  /**
   * Get Life use.
   *
   * @return Units of use until the asset is not usable anymore
   */
  public int getLifeUseUnits() {
    Integer ii = (Integer) get_Value(COLUMNNAME_LifeUseUnits);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Life use.
   *
   * @param LifeUseUnits Units of use until the asset is not usable anymore
   */
  public void setLifeUseUnits(int LifeUseUnits) {
    set_Value(COLUMNNAME_LifeUseUnits, Integer.valueOf(LifeUseUnits));
  }

  /**
   * Get Location comment.
   *
   * @return Additional comments or remarks concerning the location
   */
  public String getLocationComment() {
    return (String) get_Value(COLUMNNAME_LocationComment);
  }

  /**
   * Set Location comment.
   *
   * @param LocationComment Additional comments or remarks concerning the location
   */
  public void setLocationComment(String LocationComment) {
    set_Value(COLUMNNAME_LocationComment, LocationComment);
  }

  /**
   * Get Lot No.
   *
   * @return Lot number (alphanumeric)
   */
  public String getLot() {
    return (String) get_Value(COLUMNNAME_Lot);
  }

  /**
   * Set Lot No.
   *
   * @param Lot Lot number (alphanumeric)
   */
  public void setLot(String Lot) {
    set_Value(COLUMNNAME_Lot, Lot);
  }

  /**
   * Get Manufactured Year.
   *
   * @return Manufactured Year
   */
  public int getManufacturedYear() {
    Integer ii = (Integer) get_Value(COLUMNNAME_ManufacturedYear);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Manufactured Year.
   *
   * @param ManufacturedYear Manufactured Year
   */
  public void setManufacturedYear(int ManufacturedYear) {
    set_Value(COLUMNNAME_ManufacturedYear, Integer.valueOf(ManufacturedYear));
  }

  /**
   * Get Manufacturer.
   *
   * @return Manufacturer of the Product
   */
  public String getManufacturer() {
    return (String) get_Value(COLUMNNAME_Manufacturer);
  }

  /**
   * Set Manufacturer.
   *
   * @param Manufacturer Manufacturer of the Product
   */
  public void setManufacturer(String Manufacturer) {
    set_Value(COLUMNNAME_Manufacturer, Manufacturer);
  }

  public I_M_AttributeSetInstance getMAttributeSetInstance() throws RuntimeException {
    return (I_M_AttributeSetInstance)
        MTable.get(getCtx(), I_M_AttributeSetInstance.Table_Name)
            .getPO(getMAttributeSetInstance_ID(), get_TrxName());
  }

  /**
   * Set Attribute Set Instance.
   *
   * @param M_AttributeSetInstance_ID Product Attribute Set Instance
   */
  public void setM_AttributeSetInstance_ID(int M_AttributeSetInstance_ID) {
    if (M_AttributeSetInstance_ID < 0) set_ValueNoCheck(COLUMNNAME_M_AttributeSetInstance_ID, null);
    else
      set_ValueNoCheck(
          COLUMNNAME_M_AttributeSetInstance_ID, Integer.valueOf(M_AttributeSetInstance_ID));
  }

  /**
   * Get Attribute Set Instance.
   *
   * @return Product Attribute Set Instance
   */
  public int getMAttributeSetInstance_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_AttributeSetInstance_ID);
    if (ii == null) return 0;
    return ii;
  }

  public org.compiere.model.I_M_InOutLine getM_InOutLine() throws RuntimeException {
    return (org.compiere.model.I_M_InOutLine)
        MTable.get(getCtx(), org.compiere.model.I_M_InOutLine.Table_Name)
            .getPO(getM_InOutLine_ID(), get_TrxName());
  }

  /**
   * Get Shipment/Receipt Line.
   *
   * @return Line on Shipment or Receipt document
   */
  public int getM_InOutLine_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_InOutLine_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shipment/Receipt Line.
   *
   * @param M_InOutLine_ID Line on Shipment or Receipt document
   */
  public void setM_InOutLine_ID(int M_InOutLine_ID) {
    if (M_InOutLine_ID < 1) set_Value(COLUMNNAME_M_InOutLine_ID, null);
    else set_Value(COLUMNNAME_M_InOutLine_ID, Integer.valueOf(M_InOutLine_ID));
  }

  public I_M_Locator getM_Locator() throws RuntimeException {
    return (I_M_Locator)
        MTable.get(getCtx(), I_M_Locator.Table_Name).getPO(getM_Locator_ID(), get_TrxName());
  }

  /**
   * Get Locator.
   *
   * @return Warehouse Locator
   */
  public int getM_Locator_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Locator_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Locator.
   *
   * @param M_Locator_ID Warehouse Locator
   */
  public void setM_Locator_ID(int M_Locator_ID) {
    if (M_Locator_ID < 1) set_Value(COLUMNNAME_M_Locator_ID, null);
    else set_Value(COLUMNNAME_M_Locator_ID, Integer.valueOf(M_Locator_ID));
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
   * Get Next Maintenence.
   *
   * @return Next Maintenence Date
   */
  public Timestamp getNextMaintenenceDate() {
    return (Timestamp) get_Value(COLUMNNAME_NextMaintenenceDate);
  }

  /**
   * Set Next Maintenence.
   *
   * @param NextMaintenenceDate Next Maintenence Date
   */
  public void setNextMaintenenceDate(Timestamp NextMaintenenceDate) {
    set_Value(COLUMNNAME_NextMaintenenceDate, NextMaintenenceDate);
  }

  /**
   * Get Next Unit.
   *
   * @return Next Maintenence Unit
   */
  public int getNextMaintenenceUnit() {
    Integer ii = (Integer) get_Value(COLUMNNAME_NextMaintenenceUnit);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Next Unit.
   *
   * @param NextMaintenenceUnit Next Maintenence Unit
   */
  public void setNextMaintenenceUnit(int NextMaintenenceUnit) {
    set_Value(COLUMNNAME_NextMaintenenceUnit, Integer.valueOf(NextMaintenenceUnit));
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
   * Get Quantity.
   *
   * @return Quantity
   */
  public BigDecimal getQty() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_Qty);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Quantity.
   *
   * @param Qty Quantity
   */
  public void setQty(BigDecimal Qty) {
    set_Value(COLUMNNAME_Qty, Qty);
  }

  /**
   * Get Serial No.
   *
   * @return Product Serial Number
   */
  public String getSerNo() {
    return (String) get_Value(COLUMNNAME_SerNo);
  }

  /**
   * Set Serial No.
   *
   * @param SerNo Product Serial Number
   */
  public void setSerNo(String SerNo) {
    set_Value(COLUMNNAME_SerNo, SerNo);
  }

  /**
   * Get Usable Life - Months.
   *
   * @return Months of the usable life of the asset
   */
  public int getUseLifeMonths() {
    Integer ii = (Integer) get_Value(COLUMNNAME_UseLifeMonths);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Usable Life - Months.
   *
   * @param UseLifeMonths Months of the usable life of the asset
   */
  public void setUseLifeMonths(int UseLifeMonths) {
    set_Value(COLUMNNAME_UseLifeMonths, Integer.valueOf(UseLifeMonths));
  }

  /**
   * Get Usable Life - Years.
   *
   * @return Years of the usable life of the asset
   */
  public int getUseLifeYears() {
    Integer ii = (Integer) get_Value(COLUMNNAME_UseLifeYears);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Usable Life - Years.
   *
   * @param UseLifeYears Years of the usable life of the asset
   */
  public void setUseLifeYears(int UseLifeYears) {
    set_Value(COLUMNNAME_UseLifeYears, Integer.valueOf(UseLifeYears));
  }

  /**
   * Get Use units.
   *
   * @return Currently used units of the assets
   */
  public int getUseUnits() {
    Integer ii = (Integer) get_Value(COLUMNNAME_UseUnits);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Use units.
   *
   * @param UseUnits Currently used units of the assets
   */
  public void setUseUnits(int UseUnits) {
    set_ValueNoCheck(COLUMNNAME_UseUnits, Integer.valueOf(UseUnits));
  }

  /**
   * Get Search Key.
   *
   * @return Search key for the record in the format required - must be unique
   */
  public String getValue() {
    return (String) get_Value(COLUMNNAME_Value);
  }

  /**
   * Set Search Key.
   *
   * @param Value Search key for the record in the format required - must be unique
   */
  public void setValue(String Value) {
    set_Value(COLUMNNAME_Value, Value);
  }

  /**
   * Get Version No.
   *
   * @return Version Number
   */
  public String getVersionNo() {
    return (String) get_Value(COLUMNNAME_VersionNo);
  }

  /**
   * Set Version No.
   *
   * @param VersionNo Version Number
   */
  public void setVersionNo(String VersionNo) {
    set_Value(COLUMNNAME_VersionNo, VersionNo);
  }

  @Override
  public int getTableId() {
    return I_A_Asset.Table_ID;
  }
}
