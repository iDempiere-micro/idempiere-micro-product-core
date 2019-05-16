package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.HasName;
import org.compiere.model.I_S_Resource;
import org.compiere.orm.BasePOUser;

/**
 * Generated Model for S_Resource
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_S_Resource extends BasePOUser implements I_S_Resource {

    /**
     * Plant = PT
     */
    public static final String MANUFACTURINGRESOURCETYPE_Plant = "PT";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_S_Resource(int S_Resource_ID) {
        super(S_Resource_ID);
        /**
         * if (S_Resource_ID == 0) { setIsAvailable (true); // Y setWarehouseId (0); setName (null);
         * setPercentUtilization (Env.ZERO); // 100 setResourceID (0); setS_ResourceType_ID (0);
         * setValue (null); }
         */
    }

    /**
     * Load Constructor
     */
    public X_S_Resource(Row row) {
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
        return "X_S_Resource[" + getId() + "]";
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
     * Get Manufacturing Resource.
     *
     * @return Manufacturing Resource
     */
    public boolean isManufacturingResource() {
        Object oo = getValue(COLUMNNAME_IsManufacturingResource);
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
        return getValue(COLUMNNAME_ManufacturingResourceType);
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
     * Get Planning Horizon.
     *
     * @return The planning horizon is the amount of time (Days) an organisation will look into the
     * future when preparing a strategic plan.
     */
    public int getPlanningHorizon() {
        Integer ii = getValue(COLUMNNAME_PlanningHorizon);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Resource.
     *
     * @return Resource
     */
    public int getResourceId() {
        Integer ii = getValue(COLUMNNAME_S_Resource_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Resource Type.
     *
     * @return Resource Type
     */
    public int getResourceTypeId() {
        Integer ii = getValue(COLUMNNAME_S_ResourceType_ID);
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

    @Override
    public int getTableId() {
        return I_S_Resource.Table_ID;
    }
}
