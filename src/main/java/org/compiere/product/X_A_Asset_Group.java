package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_A_Asset_Group;
import org.compiere.orm.BasePOName;
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

    @Override
  public int getTableId() {
    return I_A_Asset_Group.Table_ID;
  }
}
