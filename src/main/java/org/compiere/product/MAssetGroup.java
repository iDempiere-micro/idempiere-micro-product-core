package org.compiere.product;

import static software.hsharp.core.util.DBKt.getSQLValueEx;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_A_Asset_Group;
import org.compiere.model.SetGetModel;
import org.compiere.orm.SetGetUtil;
import org.idempiere.common.util.CCache;

/**
 * Asset Group Model
 *
 * @author Teo Sarca, SC ARHIPAC SERVICE SRL
 */
public class MAssetGroup extends X_A_Asset_Group {

  /** */
  private static final long serialVersionUID = -173157506404569463L;
  /** Cache: ID -> MAssetGroup */
  private static CCache<Integer, MAssetGroup> s_cache =
      new CCache<Integer, MAssetGroup>(I_A_Asset_Group.Table_Name, 10, 0);

  /**
   * Default Constructor
   *
   * @param ctx context
   * @param A_Asset_Group_ID
   */
  public MAssetGroup(Properties ctx, int A_Asset_Group_ID, String trxName) {
    super(ctx, A_Asset_Group_ID, trxName);
  } //	MAssetGroup

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   */
  public MAssetGroup(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  } //	MAssetGroup

  /**
   * Get Asset Group [CACHE]
   *
   * @param ctx context
   * @param A_Asset_Group_ID asset group id
   * @return asset group or null
   */
  public static MAssetGroup get(Properties ctx, int A_Asset_Group_ID) {
    if (A_Asset_Group_ID <= 0) return null;
    // Try cache
    MAssetGroup ag = s_cache.get(A_Asset_Group_ID);
    if (ag != null) return ag;
    // Load
    ag = new MAssetGroup(ctx, A_Asset_Group_ID, null);
    if (ag != null && ag.getId() != A_Asset_Group_ID) ag = null;
    else s_cache.put(A_Asset_Group_ID, ag);
    //
    return ag;
  }

  /**
   * Get default asset group ID for given model. WARNING: trxName = null.
   *
   * @param m reference model (used to get AD_Client_ID)
   * @return default asset group ID or 0 if not found
   */
  public static int getDefault_ID(SetGetModel m) {
    int AD_Client_ID = SetGetUtil.get_AttrValueAsInt(m, "AD_Client_ID");
    /* commented by @win
    int A_AssetType_ID = SetGetUtil.get_AttrValueAsInt(m, MAssetType.COLUMNNAME_A_Asset_Type_ID);
    */
    final String sql =
        "SELECT "
            + I_A_Asset_Group.COLUMNNAME_A_Asset_Group_ID
            + " FROM "
            + I_A_Asset_Group.Table_Name
            + " WHERE AD_Client_ID=?"
            //	+ " AND NVL("+COLUMNNAME_A_Asset_Type_ID+",0) IN (0,?)" //commented by @win
            + " ORDER BY "
            + I_A_Asset_Group.COLUMNNAME_IsDefault
            + " DESC"
            + ", "
            + I_A_Asset_Group.COLUMNNAME_A_Asset_Group_ID
            + " ASC" // default first, older first
        ;
    /* modify by @win
    int id = DB.getSQLValueEx(null, sql, AD_Client_ID, A_AssetType_ID);
    */
    int id = getSQLValueEx(null, sql, AD_Client_ID);
    // modify by @win

    return id;
  }

    protected boolean beforeSave(boolean newRecord) {
    /* commented by @win
    MAssetType type = MAssetType.get(getCtx(), getA_Asset_Type_ID());
    if (type != null)
    {
    	type.update(SetGetUtil.wrap(this), newRecord == true);
    }
    */
    // end commented by @win

    return true;
  }

  protected boolean afterSave(boolean newRecord, boolean success) {
    if (!success) {
      return false;
    }
    //
    //
    return true;
  }
} //	MAssetGroup
