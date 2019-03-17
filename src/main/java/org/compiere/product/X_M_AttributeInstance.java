package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_AttributeInstance;
import org.compiere.orm.PO;

import java.math.BigDecimal;
import java.util.Properties;

/**
 * Generated Model for M_AttributeInstance
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeInstance extends PO implements I_M_AttributeInstance {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_AttributeInstance(Properties ctx, int M_AttributeInstance_ID) {
        super(ctx, M_AttributeInstance_ID);
        /**
         * if (M_AttributeInstance_ID == 0) { setMAttributeID (0); setAttributeSetInstanceId (0); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_AttributeInstance(Properties ctx, Row row) {
        super(ctx, row);
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
        return "X_M_AttributeInstance[" + getId() + "]";
    }

    /**
     * Set Attribute.
     *
     * @param M_Attribute_ID Product Attribute
     */
    public void setMAttributeID(int M_Attribute_ID) {
        if (M_Attribute_ID < 1) setValueNoCheck(COLUMNNAME_M_Attribute_ID, null);
        else setValueNoCheck(COLUMNNAME_M_Attribute_ID, Integer.valueOf(M_Attribute_ID));
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
                    COLUMNNAME_M_AttributeSetInstance_ID, Integer.valueOf(M_AttributeSetInstance_ID));
    }

    /**
     * Set Attribute Value.
     *
     * @param M_AttributeValue_ID Product Attribute Value
     */
    public void setAttributeValueId(int M_AttributeValue_ID) {
        if (M_AttributeValue_ID < 1) setValue(COLUMNNAME_M_AttributeValue_ID, null);
        else setValue(COLUMNNAME_M_AttributeValue_ID, Integer.valueOf(M_AttributeValue_ID));
    }

    /**
     * Get Search Key.
     *
     * @return Search key for the record in the format required - must be unique
     */
    public String getValue() {
        return (String) getValue(COLUMNNAME_Value);
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
     * Set Value.
     *
     * @param ValueNumber Numeric Value
     */
    public void setValueNumber(BigDecimal ValueNumber) {
        setValue(COLUMNNAME_ValueNumber, ValueNumber);
    }

    @Override
    public int getTableId() {
        return I_M_AttributeInstance.Table_ID;
    }
}
