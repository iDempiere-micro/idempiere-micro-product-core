package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_A_Asset_Group;
import org.compiere.orm.BasePOName;

/**
 * Generated Model for A_Asset_Group
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_A_Asset_Group extends BasePOName implements I_A_Asset_Group {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_A_Asset_Group(int A_Asset_Group_ID) {
        super(A_Asset_Group_ID);
    }

    /**
     * Load Constructor
     */
    public X_A_Asset_Group(Row row) {
        super(row);
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

    /**
     * Get Asset Group.
     *
     * @return Group of Assets
     */
    public int getAssetGroupId() {
        Integer ii = (Integer) getValue(COLUMNNAME_A_Asset_Group_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Depreciate.
     *
     * @return The asset will be depreciated
     */
    public boolean isDepreciated() {
        Object oo = getValue(COLUMNNAME_IsDepreciated);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get IsFixedAsset.
     *
     * @return IsFixedAsset
     */
    public boolean isFixedAsset() {
        Object oo = getValue(COLUMNNAME_IsFixedAsset);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get One Asset Per UOM.
     *
     * @return Create one asset per UOM
     */
    public boolean isOneAssetPerUOM() {
        Object oo = getValue(COLUMNNAME_IsOneAssetPerUOM);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Owned.
     *
     * @return The asset is owned by the organization
     */
    public boolean isOwned() {
        Object oo = getValue(COLUMNNAME_IsOwned);
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
