package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.Asset;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.model.I_M_Product;
import org.compiere.orm.PO;
import org.compiere.orm.SetGetUtil;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.logging.Level;

import static software.hsharp.core.util.DBKt.convertString;
import static software.hsharp.core.util.DBKt.executeUpdateEx;

/**
 * Asset Model
 *
 * @author Teo Sarca, SC ARHIPAC SERVICE SRL
 */
@SuppressWarnings("serial")
public class MAsset extends X_A_Asset
// implements MAssetType.Model //commented by @win
{
    /**
     *
     */
    private int m_UseLifeMonths_F = 0;
    /**
     *
     */
    private int m_A_Current_Period = 0;
    /**
     *
     */
    private Timestamp m_DateAcct = null;
    /**
     *
     */
    private int m_A_Depreciation_ID = 0;
    /**
     *
     */
    private int m_A_Depreciation_F_ID = 0;
    /**
     *
     */
    private BigDecimal m_A_Asset_Cost = Env.ZERO;

    private BigDecimal m_A_Accumulated_Depr = Env.ZERO;
    private BigDecimal m_A_Accumulated_Depr_F = Env.ZERO;

    /**
     * Create constructor
     */
    public MAsset(int A_Asset_ID) {
        super(A_Asset_ID);
        if (A_Asset_ID == 0) {
            setAssetStatus(X_A_Asset.A_ASSET_STATUS_New);
        }
    } //	MAsset

    /**
     * Load Constructor
     */
    public MAsset(Row row) {
        super(row);
    } //	MAsset

    // Temporary used variables:

    /**
     * Set Asset Group; also it sets other default fields
     *
     * @param assetGroup
     */
    public void setAssetGroup(MAssetGroup assetGroup) {
        setAssetGroupId(assetGroup.getAssetGroupId());
    }

    /**
     * Set ASI Info (M_AttributeSetInstance_ID, Lot, SerNo)
     *
     * @param asi
     */
    public void setASI(MAttributeSetInstance asi) {
        setAttributeSetInstanceId(asi.getAttributeSetInstanceId());
        setLot(asi.getLot());
        setSerNo(asi.getSerNo());
    }

    /**
     * Before Save
     *
     * @param newRecord new
     * @return true
     */
    protected boolean beforeSave(boolean newRecord) {
        // Set parent asset:
        if (getParentAssetId() <= 0) {
            setParentAssetId(getAssetId());
        }
        // Fix inventory number:
        String invNo = getInventoryNo();
        if (invNo != null) {
            setInventoryNo(invNo.trim());
        }
        // If no asset group, than set the default one:
        if (getAssetGroupId() <= 0) {
            setAssetGroupId(MAssetGroup.getDefaultId(SetGetUtil.wrap(this)));
        }

        // Copy fields from C_BPartner_Location
        if (isValueChanged(Asset.COLUMNNAME_C_BPartner_Location_ID)
                && getBPartnerLocationId() > 0) {
            // Goodwill BF: Error: MAsset cannot be cast to SetGetModel
            SetGetUtil.copyValues(
                    SetGetUtil.wrap(this),
                    I_C_BPartner_Location.Table_Name,
                    getBPartnerLocationId(),
                    new String[]{I_C_BPartner_Location.COLUMNNAME_C_Location_ID});
        }
        //
        // Create ASI if not exist:
        if (getProductId() > 0 && getAttributeSetInstanceId() <= 0) {
            I_M_Product product = MProduct.get(getProductId());
            MAttributeSetInstance asi =
                    new MAttributeSetInstance(0, product.getAttributeSetId());
            asi.setSerNo(getSerNo());
            asi.setDescription();
            asi.saveEx();
            setAttributeSetInstanceId(asi.getAttributeSetInstanceId());
        }

        // Update status
        updateStatus();

        return true;
    } //	beforeSave

    protected boolean afterSave(boolean newRecord, boolean success) {
        if (!success) {
            return success;
        }

        //
        // Set parent
        if (getParentAssetId() <= 0) {
            int A_Asset_ID = getAssetId();
            setParentAssetId(A_Asset_ID);
            executeUpdateEx(
                    "UPDATE A_Asset SET A_Parent_Asset_ID=A_Asset_ID WHERE A_Asset_ID=" + A_Asset_ID);
            if (log.isLoggable(Level.FINE)) log.fine("A_Parent_Asset_ID=" + getParentAssetId());
        }

        //
        // Set inventory number:
        String invNo = getInventoryNo();
        if (invNo == null || invNo.trim().length() == 0) {
            invNo = "" + getId();
            setInventoryNo(invNo);
            executeUpdateEx(
                    "UPDATE A_Asset SET InventoryNo="
                            + convertString(invNo)
                            + " WHERE A_Asset_ID="
                            + getAssetId());
            if (log.isLoggable(Level.FINE)) log.fine("InventoryNo=" + getInventoryNo());
        }

        // If new record, create accounting and workfile
        if (newRecord) {
            // @win: set value at asset group as default value for asset
            MAssetGroup assetgroup = new MAssetGroup(getAssetGroupId());
            String isDepreciated = (assetgroup.isDepreciated()) ? "Y" : "N";
            String isOwned = (assetgroup.isOwned()) ? "Y" : "N";
            setIsDepreciated(assetgroup.isDepreciated());
            setIsOwned(assetgroup.isOwned());
            executeUpdateEx(
                    "UPDATE A_Asset SET IsDepreciated='"
                            + isDepreciated
                            + "', isOwned ='"
                            + isOwned
                            + "' WHERE A_Asset_ID="
                            + getAssetId());
            // end @win

        } else {
            MAssetChange.createAndSave("UPD", new PO[]{this});
        }

        return true;
    } //	afterSave

    protected boolean beforeDelete() {
        return true;
    } //      beforeDelete

    /**
     * @see #beforeSave(boolean)
     */
    public void updateStatus() {
        String status = getAssetStatus();
        setProcessed(!status.equals(X_A_Asset.A_ASSET_STATUS_New));
        setIsDisposed(status.equals(X_A_Asset.A_ASSET_STATUS_Disposed));
        setIsFullyDepreciated(status.equals(X_A_Asset.A_ASSET_STATUS_Depreciated));
        if (isFullyDepreciated() || status.equals(X_A_Asset.A_ASSET_STATUS_Disposed)) {
            setIsDepreciated(false);
        }
        if (status.equals(X_A_Asset.A_ASSET_STATUS_Activated) || getAssetActivationDate() == null) {
            setAssetActivationDate(getAssetServiceDate());
        }
    }

    /**
     * Change asset status to newStatus
     *
     * @param newStatus see A_ASSET_STATUS_
     * @param date      state change date; if null context "#Date" will be used
     */
    public void changeStatus(String newStatus, Timestamp date) {
        String status = getAssetStatus();
        if (log.isLoggable(Level.FINEST))
            log.finest("Entering: " + status + "->" + newStatus + ", date=" + date);

        //
        // If date is null, use context #Date
        if (date == null) {
            date = Env.getContextAsDate();
        }

        //
        //	Activation/Addition
        if (newStatus.equals(X_A_Asset.A_ASSET_STATUS_Activated)) {
            setAssetActivationDate(date);
        }
        //

        // Disposal
        if (newStatus.equals(X_A_Asset.A_ASSET_STATUS_Disposed)) { // casat, vandut
            setAssetDisposalDate(date);
        }

        // Set new status
        setAssetStatus(newStatus);
    } //	changeStatus

    public int getUseLifeMonthsFiscal() {
        return m_UseLifeMonths_F;
    }

    public int getA_Current_Period() {
        return m_A_Current_Period;
    }

    public Timestamp getDateAcct() {
        return m_DateAcct;
    }

    public void setDateAcct(Timestamp DateAcct) {
        m_DateAcct = DateAcct;
    }

    public int getA_DepreciationId() {
        return m_A_Depreciation_ID;
    }

    public int getA_Depreciation_FId() {
        return m_A_Depreciation_F_ID;
    }

    public BigDecimal getA_Asset_Cost() {
        return m_A_Asset_Cost;
    }

    public BigDecimal getA_Accumulated_Depr() {
        return m_A_Accumulated_Depr;
    }

    public BigDecimal getA_Accumulated_Depr_F() {
        return m_A_Accumulated_Depr_F;
    }

}
