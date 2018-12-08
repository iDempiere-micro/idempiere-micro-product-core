package org.compiere.product;

import org.compiere.model.HasName;
import org.compiere.model.I_S_Resource;
import org.compiere.orm.BasePOUser;
import org.compiere.orm.MTable;
import org.idempiere.common.util.Env;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for S_Resource
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_S_Resource extends BasePOUser implements I_S_Resource, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_S_Resource(Properties ctx, int S_Resource_ID, String trxName) {
    super(ctx, S_Resource_ID, trxName);
    /**
     * if (S_Resource_ID == 0) { setIsAvailable (true); // Y setM_Warehouse_ID (0); setName (null);
     * setPercentUtilization (Env.ZERO); // 100 setS_Resource_ID (0); setS_ResourceType_ID (0);
     * setValue (null); }
     */
  }

  /** Load Constructor */
  public X_S_Resource(Properties ctx, ResultSet rs, String trxName) {
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
    return "X_S_Resource[" + getId() + "]";
  }

  /**
   * Set Chargeable Quantity.
   *
   * @param ChargeableQty Chargeable Quantity
   */
  public void setChargeableQty(BigDecimal ChargeableQty) {
    set_Value(COLUMNNAME_ChargeableQty, ChargeableQty);
  }

  /**
   * Get Chargeable Quantity.
   *
   * @return Chargeable Quantity
   */
  public BigDecimal getChargeableQty() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_ChargeableQty);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Daily Capacity.
   *
   * @param DailyCapacity Daily Capacity
   */
  public void setDailyCapacity(BigDecimal DailyCapacity) {
    set_Value(COLUMNNAME_DailyCapacity, DailyCapacity);
  }

  /**
   * Get Daily Capacity.
   *
   * @return Daily Capacity
   */
  public BigDecimal getDailyCapacity() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_DailyCapacity);
    if (bd == null) return Env.ZERO;
    return bd;
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
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
  }

  /**
   * Set Available.
   *
   * @param IsAvailable Resource is available
   */
  public void setIsAvailable(boolean IsAvailable) {
    set_Value(COLUMNNAME_IsAvailable, Boolean.valueOf(IsAvailable));
  }

  /**
   * Get Available.
   *
   * @return Resource is available
   */
  public boolean isAvailable() {
    Object oo = get_Value(COLUMNNAME_IsAvailable);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Manufacturing Resource.
   *
   * @param IsManufacturingResource Manufacturing Resource
   */
  public void setIsManufacturingResource(boolean IsManufacturingResource) {
    set_Value(COLUMNNAME_IsManufacturingResource, Boolean.valueOf(IsManufacturingResource));
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

  /** ManufacturingResourceType AD_Reference_ID=53223 */
  public static final int MANUFACTURINGRESOURCETYPE_AD_Reference_ID = 53223;
  /** Production Line = PL */
  public static final String MANUFACTURINGRESOURCETYPE_ProductionLine = "PL";
  /** Plant = PT */
  public static final String MANUFACTURINGRESOURCETYPE_Plant = "PT";
  /** Work Center = WC */
  public static final String MANUFACTURINGRESOURCETYPE_WorkCenter = "WC";
  /** Work Station = WS */
  public static final String MANUFACTURINGRESOURCETYPE_WorkStation = "WS";
  /**
   * Set Manufacturing Resource Type.
   *
   * @param ManufacturingResourceType Manufacturing Resource Type
   */
  public void setManufacturingResourceType(String ManufacturingResourceType) {

    set_Value(COLUMNNAME_ManufacturingResourceType, ManufacturingResourceType);
  }

  /**
   * Get Manufacturing Resource Type.
   *
   * @return Manufacturing Resource Type
   */
  public String getManufacturingResourceType() {
    return (String) get_Value(COLUMNNAME_ManufacturingResourceType);
  }

  public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException {
    return (org.compiere.model.I_M_Warehouse)
        MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_Name)
            .getPO(getM_Warehouse_ID(), get_TrxName());
  }

  /**
   * Set Warehouse.
   *
   * @param M_Warehouse_ID Storage Warehouse and Service Point
   */
  public void setM_Warehouse_ID(int M_Warehouse_ID) {
    if (M_Warehouse_ID < 1) set_Value(COLUMNNAME_M_Warehouse_ID, null);
    else set_Value(COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
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
   * Set Name.
   *
   * @param Name Alphanumeric identifier of the entity
   */
  public void setName(String Name) {
    set_Value(HasName.Companion.getCOLUMNNAME_Name(), Name);
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
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), getName());
  }

  /**
   * Set % Utilization.
   *
   * @param PercentUtilization % Utilization
   */
  public void setPercentUtilization(BigDecimal PercentUtilization) {
    set_Value(COLUMNNAME_PercentUtilization, PercentUtilization);
  }

  /**
   * Get % Utilization.
   *
   * @return % Utilization
   */
  public BigDecimal getPercentUtilization() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PercentUtilization);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Planning Horizon.
   *
   * @param PlanningHorizon The planning horizon is the amount of time (Days) an organisation will
   *     look into the future when preparing a strategic plan.
   */
  public void setPlanningHorizon(int PlanningHorizon) {
    set_Value(COLUMNNAME_PlanningHorizon, Integer.valueOf(PlanningHorizon));
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
   * Set Queuing Time.
   *
   * @param QueuingTime Queue time is the time a job waits at a work center before begin handled.
   */
  public void setQueuingTime(BigDecimal QueuingTime) {
    set_Value(COLUMNNAME_QueuingTime, QueuingTime);
  }

  /**
   * Get Queuing Time.
   *
   * @return Queue time is the time a job waits at a work center before begin handled.
   */
  public BigDecimal getQueuingTime() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_QueuingTime);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Resource.
   *
   * @param S_Resource_ID Resource
   */
  public void setS_Resource_ID(int S_Resource_ID) {
    if (S_Resource_ID < 1) set_ValueNoCheck(COLUMNNAME_S_Resource_ID, null);
    else set_ValueNoCheck(COLUMNNAME_S_Resource_ID, Integer.valueOf(S_Resource_ID));
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

  public org.compiere.model.I_S_ResourceType getS_ResourceType() throws RuntimeException {
    return (org.compiere.model.I_S_ResourceType)
        MTable.get(getCtx(), org.compiere.model.I_S_ResourceType.Table_Name)
            .getPO(getS_ResourceType_ID(), get_TrxName());
  }

  /**
   * Set Resource Type.
   *
   * @param S_ResourceType_ID Resource Type
   */
  public void setS_ResourceType_ID(int S_ResourceType_ID) {
    if (S_ResourceType_ID < 1) set_Value(COLUMNNAME_S_ResourceType_ID, null);
    else set_Value(COLUMNNAME_S_ResourceType_ID, Integer.valueOf(S_ResourceType_ID));
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
   * Set S_Resource_UU.
   *
   * @param S_Resource_UU S_Resource_UU
   */
  public void setS_Resource_UU(String S_Resource_UU) {
    set_Value(COLUMNNAME_S_Resource_UU, S_Resource_UU);
  }

  /**
   * Get S_Resource_UU.
   *
   * @return S_Resource_UU
   */
  public String getS_Resource_UU() {
    return (String) get_Value(COLUMNNAME_S_Resource_UU);
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
   * Get Search Key.
   *
   * @return Search key for the record in the format required - must be unique
   */
  public String getValue() {
    return (String) get_Value(COLUMNNAME_Value);
  }

  /**
   * Set Waiting Time.
   *
   * @param WaitingTime Workflow Simulation Waiting time
   */
  public void setWaitingTime(BigDecimal WaitingTime) {
    set_Value(COLUMNNAME_WaitingTime, WaitingTime);
  }

  /**
   * Get Waiting Time.
   *
   * @return Workflow Simulation Waiting time
   */
  public BigDecimal getWaitingTime() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_WaitingTime);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  @Override
  public int getTableId() {
    return I_S_Resource.Table_ID;
  }
}
