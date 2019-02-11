package org.compiere.product;

import static software.hsharp.core.util.DBKt.TO_STRING;
import static software.hsharp.core.util.DBKt.executeUpdateEx;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import org.compiere.model.I_A_Asset;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.compiere.orm.Query;
import org.compiere.orm.SetGetUtil;
import org.idempiere.common.util.Env;

/**
 * Asset Model
 *
 * @author Teo Sarca, SC ARHIPAC SERVICE SRL
 */
@SuppressWarnings("serial")
public class MAsset extends X_A_Asset
// implements MAssetType.Model //commented by @win
{
    /** */
  private int m_UseLifeMonths_F = 0;
  /** */
  private int m_A_Current_Period = 0;
  /** */
  private Timestamp m_DateAcct = null;
  /** */
  private int m_A_Depreciation_ID = 0;
  /** */
  private int m_A_Depreciation_F_ID = 0;
  /** */
  private BigDecimal m_A_Asset_Cost = Env.ZERO;

  private BigDecimal m_A_Accumulated_Depr = Env.ZERO;
  private BigDecimal m_A_Accumulated_Depr_F = Env.ZERO;

  /** Create constructor */
  public MAsset(Properties ctx, int A_Asset_ID, String trxName) {
    super(ctx, A_Asset_ID, trxName);
    if (A_Asset_ID == 0) {
      setA_Asset_Status(X_A_Asset.A_ASSET_STATUS_New);
      // commented out by @win
      /*
      setA_Asset_Type("MFX");
      setA_Asset_Type_ID(1); // MFX
      */
      // end comment by @win
    }
  } //	MAsset

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set record
   */
  public MAsset(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  } //	MAsset

    // Temporary used variables:

    /**
   * Set Asset Group; also it sets other default fields
   *
   * @param assetGroup
   */
  public void setAssetGroup(MAssetGroup assetGroup) {
    setA_Asset_Group_ID(assetGroup.getA_Asset_Group_ID());

    /* commented out by @win
    setA_Asset_Type_ID(assetGroup.getA_Asset_Type_ID());
    setGZ_TipComponenta(assetGroup.getGZ_TipComponenta()); // TODO: move to GZ
    MAssetType assetType = MAssetType.get(getCtx(), assetGroup.getA_Asset_Type_ID());
    assetType.update(SetGetUtil.wrap(this), true);
    */
    // end commet by @win
  }

  /**
   * Set ASI Info (M_AttributeSetInstance_ID, Lot, SerNo)
   *
   * @param asi
   */
  public void setASI(MAttributeSetInstance asi) {
    setM_AttributeSetInstance_ID(asi.getMAttributeSetInstance_ID());
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
    if (getA_Parent_Asset_ID() <= 0) {
      setA_Parent_Asset_ID(getA_Asset_ID());
    }
    // Fix inventory number:
    String invNo = getInventoryNo();
    if (invNo != null) {
      setInventoryNo(invNo.trim());
    }
    // If no asset group, than set the default one:
    if (getA_Asset_Group_ID() <= 0) {
      setA_Asset_Group_ID(MAssetGroup.getDefault_ID(SetGetUtil.wrap(this)));
    }
    /* @win temporary commented out

    if (getA_Asset_Class_ID() <= 0 && getA_Asset_Group_ID() > 0)
    {
    	MAssetGroup.updateAsset(SetGetUtil.wrap(this), getA_Asset_Group_ID());
    }
    */
    // end @win comment

    // Copy fields from C_BPartner_Location
    if (is_ValueChanged(I_A_Asset.COLUMNNAME_C_BPartner_Location_ID)
        && getC_BPartner_Location_ID() > 0) {
      // Goodwill BF: Error: MAsset cannot be cast to SetGetModel
      SetGetUtil.copyValues(
          SetGetUtil.wrap(this),
          I_C_BPartner_Location.Table_Name,
          getC_BPartner_Location_ID(),
          new String[] {I_C_BPartner_Location.COLUMNNAME_C_Location_ID});
    }
    //
    // Create ASI if not exist:
    if (getM_Product_ID() > 0 && getMAttributeSetInstance_ID() <= 0) {
      MProduct product = MProduct.get(getCtx(), getM_Product_ID());
      MAttributeSetInstance asi =
          new MAttributeSetInstance(getCtx(), 0, product.getMAttributeSet_ID(), null);
      asi.setSerNo(getSerNo());
      asi.setDescription();
      asi.saveEx();
      setM_AttributeSetInstance_ID(asi.getMAttributeSetInstance_ID());
    }
    // TODO: With the lines below, after creating the asset, the whole system goes much slower ???
    //		else if (is_ValueChanged(COLUMNNAME_SerNo) && getMAttributeSetInstance_ID() > 0) {
    //			asi = new MAttributeSetInstance(getCtx(), getMAttributeSetInstance_ID(), null);
    //			asi.setSerNo(getSerNo());
    //			asi.setDescription();
    //			asi.saveEx();
    //		}
    //		else if ((newRecord || is_ValueChanged(COLUMNNAME_M_AttributeSetInstance_ID)) &&
    // getMAttributeSetInstance_ID() > 0) {
    //			asi = new MAttributeSetInstance(getCtx(), getMAttributeSetInstance_ID(), null);
    //			setASI(asi);
    //		}
    //

    // Update status
    updateStatus();

    // Validate AssetType
    // @win commented out
    // MAssetType.validate(this);
    // @win end
    //

    return true;
  } //	beforeSave

  protected boolean afterSave(boolean newRecord, boolean success) {
    if (!success) {
      return success;
    }

    //
    // Set parent
    if (getA_Parent_Asset_ID() <= 0) {
      int A_Asset_ID = getA_Asset_ID();
      setA_Parent_Asset_ID(A_Asset_ID);
      executeUpdateEx(
          "UPDATE A_Asset SET A_Parent_Asset_ID=A_Asset_ID WHERE A_Asset_ID=" + A_Asset_ID);
      if (log.isLoggable(Level.FINE)) log.fine("A_Parent_Asset_ID=" + getA_Parent_Asset_ID());
    }

    //
    // Set inventory number:
    String invNo = getInventoryNo();
    if (invNo == null || invNo.trim().length() == 0) {
      invNo = "" + getId();
      setInventoryNo(invNo);
      executeUpdateEx(
          "UPDATE A_Asset SET InventoryNo="
              + TO_STRING(invNo)
              + " WHERE A_Asset_ID="
              + getA_Asset_ID());
      if (log.isLoggable(Level.FINE)) log.fine("InventoryNo=" + getInventoryNo());
    }

    // If new record, create accounting and workfile
    if (newRecord) {
      // @win: set value at asset group as default value for asset
      MAssetGroup assetgroup = new MAssetGroup(getCtx(), getA_Asset_Group_ID(), null);
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
              + getA_Asset_ID());
      // end @win

    } else {
      MAssetChange.createAndSave(getCtx(), "UPD", new PO[] {this}, null);
    }

    return true;
  } //	afterSave

  protected boolean beforeDelete() {
    return true;
  } //      beforeDelete

  /** @see #beforeSave(boolean) */
  public void updateStatus() {
    String status = getA_Asset_Status();
    setProcessed(!status.equals(X_A_Asset.A_ASSET_STATUS_New));
    //		setIsDisposed(!status.equals(A_ASSET_STATUS_New) &&
    // !status.equals(A_ASSET_STATUS_Activated));
    setIsDisposed(status.equals(X_A_Asset.A_ASSET_STATUS_Disposed));
    setIsFullyDepreciated(status.equals(X_A_Asset.A_ASSET_STATUS_Depreciated));
    if (isFullyDepreciated() || status.equals(X_A_Asset.A_ASSET_STATUS_Disposed)) {
      setIsDepreciated(false);
    }
    /* commented by @win
    MAssetClass assetClass = MAssetClass.get(getCtx(), getA_Asset_Class_ID());
    if (assetClass != null && assetClass.isDepreciated())
    {
    	setIsDepreciated(true);
    }
    */
    // end comment by @win
    if (status.equals(X_A_Asset.A_ASSET_STATUS_Activated) || getAssetActivationDate() == null) {
      setAssetActivationDate(getAssetServiceDate());
    }
  }

  /**
   * Change asset status to newStatus
   *
   * @param newStatus see A_ASSET_STATUS_
   * @param date state change date; if null context "#Date" will be used
   */
  public void changeStatus(String newStatus, Timestamp date) {
    String status = getA_Asset_Status();
    if (log.isLoggable(Level.FINEST))
      log.finest("Entering: " + status + "->" + newStatus + ", date=" + date);

    //
    // If date is null, use context #Date
    if (date == null) {
      date = Env.getContextAsDate(getCtx(), "#Date");
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
    setA_Asset_Status(newStatus);
  } //	changeStatus

  public int getUseLifeMonths_F() {
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

  public int getA_Depreciation_ID() {
    return m_A_Depreciation_ID;
  }

    public int getA_Depreciation_F_ID() {
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
