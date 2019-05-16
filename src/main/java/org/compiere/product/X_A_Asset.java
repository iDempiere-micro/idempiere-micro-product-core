package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.HasName;
import org.compiere.model.Asset;
import org.compiere.model.AssetType;
import software.hsharp.core.orm.MBaseTableKt;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Generated Model for A_Asset
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_A_Asset extends ProductPOUser implements Asset {

    /**
     * Activated = AC
     */
    public static final String A_ASSET_STATUS_Activated = "AC";
    /**
     * Disposed = DI
     */
    public static final String A_ASSET_STATUS_Disposed = "DI";
    /**
     * Depreciated = DP
     */
    public static final String A_ASSET_STATUS_Depreciated = "DP";
    /**
     * New = NW
     */
    public static final String A_ASSET_STATUS_New = "NW";
    /**
     * Preservation = PR
     */
    public static final String A_ASSET_STATUS_Preservation = "PR";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor/Load Constructor
     */
    public X_A_Asset(Row row, int A_Asset_ID) {
        super(row, A_Asset_ID);
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
        return "X_A_Asset[" + getId() + "]";
    }

    /**
     * Set Create Date.
     *
     * @param A_Asset_CreateDate Create Date
     */
    public void setAssetCreateDate(Timestamp A_Asset_CreateDate) {
        setValueNoCheck(COLUMNNAME_A_Asset_CreateDate, A_Asset_CreateDate);
    }

    /**
     * Get Asset Group.
     *
     * @return Group of Assets
     */
    public int getAssetGroupId() {
        Integer ii = getValue(COLUMNNAME_A_Asset_Group_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Asset Group.
     *
     * @param A_Asset_Group_ID Group of Assets
     */
    public void setAssetGroupId(int A_Asset_Group_ID) {
        if (A_Asset_Group_ID < 1) setValue(COLUMNNAME_A_Asset_Group_ID, null);
        else setValue(COLUMNNAME_A_Asset_Group_ID, A_Asset_Group_ID);
    }

    /**
     * Get Asset.
     *
     * @return Asset used internally or by customers
     */
    public int getAssetId() {
        Integer ii = getValue(COLUMNNAME_A_Asset_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Asset Status.
     *
     * @return Asset Status
     */
    public String getAssetStatus() {
        return getValue(COLUMNNAME_A_Asset_Status);
    }

    /**
     * Set Asset Status.
     *
     * @param A_Asset_Status Asset Status
     */
    public void setAssetStatus(String A_Asset_Status) {

        setValue(COLUMNNAME_A_Asset_Status, A_Asset_Status);
    }

    public AssetType getAssetType() throws RuntimeException {
        return (AssetType)
                MBaseTableKt.getTable(AssetType.Table_Name)
                        .getPO(getAssetTypeId());
    }

    /**
     * Get Asset Type.
     *
     * @return Asset Type
     */
    public int getAssetTypeId() {
        Integer ii = getValue(COLUMNNAME_A_Asset_Type_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Parent Asset.
     *
     * @return Parent Asset
     */
    public int getParentAssetId() {
        Integer ii = getValue(COLUMNNAME_A_Parent_Asset_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Parent Asset.
     *
     * @param A_Parent_Asset_ID Parent Asset
     */
    public void setParentAssetId(int A_Parent_Asset_ID) {
        if (A_Parent_Asset_ID < 1) setValue(COLUMNNAME_A_Parent_Asset_ID, null);
        else setValue(COLUMNNAME_A_Parent_Asset_ID, A_Parent_Asset_ID);
    }

    /**
     * Get Activation Date.
     *
     * @return Activation Date
     */
    public Timestamp getAssetActivationDate() {
        return (Timestamp) getValue(COLUMNNAME_AssetActivationDate);
    }

    /**
     * Set Activation Date.
     *
     * @param AssetActivationDate Activation Date
     */
    public void setAssetActivationDate(Timestamp AssetActivationDate) {
        setValue(COLUMNNAME_AssetActivationDate, AssetActivationDate);
    }

    /**
     * Set Asset Disposal Date.
     *
     * @param AssetDisposalDate Date when the asset is/was disposed
     */
    public void setAssetDisposalDate(Timestamp AssetDisposalDate) {
        setValue(COLUMNNAME_AssetDisposalDate, AssetDisposalDate);
    }

    /**
     * Get In Service Date.
     *
     * @return Date when Asset was put into service
     */
    public Timestamp getAssetServiceDate() {
        return (Timestamp) getValue(COLUMNNAME_AssetServiceDate);
    }

    /**
     * Set In Service Date.
     *
     * @param AssetServiceDate Date when Asset was put into service
     */
    public void setAssetServiceDate(Timestamp AssetServiceDate) {
        setValue(COLUMNNAME_AssetServiceDate, AssetServiceDate);
    }

    /**
     * Set Activity.
     *
     * @param C_Activity_ID Business Activity
     */
    public void setActivityId(int C_Activity_ID) {
        if (C_Activity_ID < 1) setValue(COLUMNNAME_C_Activity_ID, null);
        else setValue(COLUMNNAME_C_Activity_ID, C_Activity_ID);
    }

    /**
     * Get Partner Location.
     *
     * @return Identifies the (ship to) address for this Business Partner
     */
    public int getBPartnerLocationId() {
        Integer ii = getValue(COLUMNNAME_C_BPartner_Location_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return getValue(COLUMNNAME_Description);
    }

    /**
     * Set Description.
     *
     * @param Description Optional short description of the record
     */
    public void setDescription(String Description) {
        setValue(COLUMNNAME_Description, Description);
    }

    /**
     * Set Comment/Help.
     *
     * @param Help Comment or Hint
     */
    public void setHelp(String Help) {
        setValue(COLUMNNAME_Help, Help);
    }

    /**
     * Get Inventory No.
     *
     * @return Inventory No
     */
    public String getInventoryNo() {
        return getValue(COLUMNNAME_InventoryNo);
    }

    /**
     * Set Inventory No.
     *
     * @param InventoryNo Inventory No
     */
    public void setInventoryNo(String InventoryNo) {
        setValue(COLUMNNAME_InventoryNo, InventoryNo);
    }

    /**
     * Set Depreciate.
     *
     * @param IsDepreciated The asset will be depreciated
     */
    public void setIsDepreciated(boolean IsDepreciated) {
        setValue(COLUMNNAME_IsDepreciated, IsDepreciated);
    }

    /**
     * Get Depreciate.
     *
     * @return The asset will be depreciated
     */
    public boolean isDepreciated() {
        Object oo = getValue(COLUMNNAME_IsDepreciated);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(COLUMNNAME_IsDisposed, IsDisposed);
    }

    /**
     * Set Fully depreciated.
     *
     * @param IsFullyDepreciated The asset is fully depreciated
     */
    public void setIsFullyDepreciated(boolean IsFullyDepreciated) {
        setValueNoCheck(COLUMNNAME_IsFullyDepreciated, IsFullyDepreciated);
    }

    /**
     * Get Fully depreciated.
     *
     * @return The asset is fully depreciated
     */
    public boolean isFullyDepreciated() {
        Object oo = getValue(COLUMNNAME_IsFullyDepreciated);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(COLUMNNAME_IsInPosession, IsInPosession);
    }

    /**
     * Set Owned.
     *
     * @param IsOwned The asset is owned by the organization
     */
    public void setIsOwned(boolean IsOwned) {
        setValue(COLUMNNAME_IsOwned, IsOwned);
    }

    /**
     * Set Lot No.
     *
     * @param Lot Lot number (alphanumeric)
     */
    public void setLot(String Lot) {
        setValue(COLUMNNAME_Lot, Lot);
    }

    /**
     * Get Attribute Set Instance.
     *
     * @return Product Attribute Set Instance
     */
    public int getAttributeSetInstanceId() {
        Integer ii = getValue(COLUMNNAME_M_AttributeSetInstance_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Attribute Set Instance.
     *
     * @param M_AttributeSetInstance_ID Product Attribute Set Instance
     */
    public void setAttributeSetInstanceId(int M_AttributeSetInstance_ID) {
        if (M_AttributeSetInstance_ID < 0) setValueNoCheck(COLUMNNAME_M_AttributeSetInstance_ID, null);
        else
            setValueNoCheck(
                    COLUMNNAME_M_AttributeSetInstance_ID, M_AttributeSetInstance_ID);
    }

    /**
     * Get Product.
     *
     * @return Product, Service, Item
     */
    public int getProductId() {
        Integer ii = getValue(COLUMNNAME_M_Product_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Product.
     *
     * @param M_Product_ID Product, Service, Item
     */
    public void setProductId(int M_Product_ID) {
        if (M_Product_ID < 1) setValue(COLUMNNAME_M_Product_ID, null);
        else setValue(COLUMNNAME_M_Product_ID, M_Product_ID);
    }

    /**
     * Get Name.
     *
     * @return Alphanumeric identifier of the entity
     */
    public String getName() {
        return getValue(HasName.COLUMNNAME_Name);
    }

    /**
     * Set Name.
     *
     * @param Name Alphanumeric identifier of the entity
     */
    public void setName(String Name) {
        setValue(HasName.COLUMNNAME_Name, Name);
    }

    /**
     * Set Processed.
     *
     * @param Processed The document has been processed
     */
    public void setProcessed(boolean Processed) {
        setValue(COLUMNNAME_Processed, Processed);
    }

    /**
     * Set Quantity.
     *
     * @param Qty Quantity
     */
    public void setQty(BigDecimal Qty) {
        setValue(COLUMNNAME_Qty, Qty);
    }

    /**
     * Get Serial No.
     *
     * @return Product Serial Number
     */
    public String getSerNo() {
        return getValue(COLUMNNAME_SerNo);
    }

    /**
     * Set Serial No.
     *
     * @param SerNo Product Serial Number
     */
    public void setSerNo(String SerNo) {
        setValue(COLUMNNAME_SerNo, SerNo);
    }

    /**
     * Get Usable Life - Months.
     *
     * @return Months of the usable life of the asset
     */
    public int getUseLifeMonths() {
        Integer ii = getValue(COLUMNNAME_UseLifeMonths);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Search Key.
     *
     * @return Search key for the record in the format required - must be unique
     */
    public String getValue() {
        return getValue(COLUMNNAME_Value);
    }

    /**
     * Set Search Key.
     *
     * @param Value Search key for the record in the format required - must be unique
     */
    public void setValue(String Value) {
        setValue(COLUMNNAME_Value, Value);
    }

    /**
     * Set Version No.
     *
     * @param VersionNo Version Number
     */
    public void setVersionNo(String VersionNo) {
        setValue(COLUMNNAME_VersionNo, VersionNo);
    }

    @Override
    public int getTableId() {
        return Asset.Table_ID;
    }
}
