package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_A_Asset_Group;
import org.compiere.model.SetGetModel;
import org.compiere.orm.SetGetUtil;
import org.idempiere.common.util.CCache;

import static software.hsharp.core.util.DBKt.getSQLValueEx;

/**
 * Asset Group Model
 *
 * @author Teo Sarca, SC ARHIPAC SERVICE SRL
 */
public class MAssetGroup extends X_A_Asset_Group {

    /**
     *
     */
    private static final long serialVersionUID = -173157506404569463L;
    /**
     * Cache: ID -> MAssetGroup
     */
    private static CCache<Integer, MAssetGroup> s_cache =
            new CCache<>(I_A_Asset_Group.Table_Name, 10, 0);

    /**
     * Default Constructor
     *
     * @param A_Asset_Group_ID
     */
    public MAssetGroup(int A_Asset_Group_ID) {
        super(A_Asset_Group_ID);
    } //	MAssetGroup

    /**
     * Load Constructor
     *
     * @param ctx context
     */
    public MAssetGroup(Row row) {
        super(row);
    } //	MAssetGroup

    /**
     * Get Asset Group [CACHE]
     *
     * @param A_Asset_Group_ID asset group id
     * @return asset group or null
     */
    public static MAssetGroup get(int A_Asset_Group_ID) {
        if (A_Asset_Group_ID <= 0) return null;
        // Try cache
        MAssetGroup ag = s_cache.get(A_Asset_Group_ID);
        if (ag != null) return ag;
        // Load
        ag = new MAssetGroup(A_Asset_Group_ID);
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
    public static int getDefaultId(SetGetModel m) {
        int AD_Client_ID = SetGetUtil.get_AttrValueAsInt(m, "AD_Client_ID");
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
        return getSQLValueEx(sql, AD_Client_ID);
    }

    protected boolean beforeSave(boolean newRecord) {
        return true;
    }

    protected boolean afterSave(boolean newRecord, boolean success) {
        return success;//
        //
    }
} //	MAssetGroup
