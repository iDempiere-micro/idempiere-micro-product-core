package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.orm.BasePOUser;
import org.compiere.orm.MTable;
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
   * Set Create Date.
   *
   * @param A_Asset_CreateDate Create Date
   */
  public void setA_Asset_CreateDate(Timestamp A_Asset_CreateDate) {
    set_ValueNoCheck(COLUMNNAME_A_Asset_CreateDate, A_Asset_CreateDate);
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

    public org.compiere.model.I_A_Asset_Type getA_Asset_Type() throws RuntimeException {
    return (org.compiere.model.I_A_Asset_Type)
        MTable.get(getCtx(), org.compiere.model.I_A_Asset_Type.Table_Name)
            .getPO(getA_Asset_Type_ID(), null);
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
   * Set Owned.
   *
   * @param IsOwned The asset is owned by the organization
   */
  public void setIsOwned(boolean IsOwned) {
    set_Value(COLUMNNAME_IsOwned, Boolean.valueOf(IsOwned));
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
   * Set Lot No.
   *
   * @param Lot Lot number (alphanumeric)
   */
  public void setLot(String Lot) {
    set_Value(COLUMNNAME_Lot, Lot);
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
   * Set Processed.
   *
   * @param Processed The document has been processed
   */
  public void setProcessed(boolean Processed) {
    set_Value(COLUMNNAME_Processed, Boolean.valueOf(Processed));
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
