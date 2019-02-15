package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.HasName;
import org.compiere.model.I_S_Resource;
import org.compiere.orm.BasePOUser;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for S_Resource
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_S_Resource extends BasePOUser implements I_S_Resource, I_Persistent {

    /** Plant = PT */
  public static final String MANUFACTURINGRESOURCETYPE_Plant = "PT";
    /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_S_Resource(Properties ctx, int S_Resource_ID) {
    super(ctx, S_Resource_ID);
    /**
     * if (S_Resource_ID == 0) { setIsAvailable (true); // Y setM_Warehouse_ID (0); setName (null);
     * setPercentUtilization (Env.ZERO); // 100 setS_Resource_ID (0); setS_ResourceType_ID (0);
     * setValue (null); }
     */
  }

  /** Load Constructor */
  public X_S_Resource(Properties ctx, ResultSet rs) {
    super(ctx, rs);
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
    return "X_S_Resource[" + getId() + "]";
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
   * Get Manufacturing Resource.
   *
   * @return Manufacturing Resource
   */
  public boolean isManufacturingResource() {
    Object oo = get_Value(COLUMNNAME_IsManufacturingResource);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Get Manufacturing Resource Type.
   *
   * @return Manufacturing Resource Type
   */
  public String getManufacturingResourceType() {
    return (String) get_Value(COLUMNNAME_ManufacturingResourceType);
  }

    /**
   * Get Warehouse.
   *
   * @return Storage Warehouse and Service Point
   */
  public int getM_Warehouse_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Warehouse_ID);
    if (ii == null) return 0;
    return ii;
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
   * Get Planning Horizon.
   *
   * @return The planning horizon is the amount of time (Days) an organisation will look into the
   *     future when preparing a strategic plan.
   */
  public int getPlanningHorizon() {
    Integer ii = (Integer) get_Value(COLUMNNAME_PlanningHorizon);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Resource.
   *
   * @return Resource
   */
  public int getS_Resource_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_S_Resource_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Resource Type.
   *
   * @return Resource Type
   */
  public int getS_ResourceType_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_S_ResourceType_ID);
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

    @Override
  public int getTableId() {
    return I_S_Resource.Table_ID;
  }
}
