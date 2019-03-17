package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_Attribute;
import org.compiere.orm.BasePOName;

import java.util.Properties;

/**
 * Generated Model for M_Attribute
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Attribute extends BasePOName implements I_M_Attribute {

    /**
     * String (max 40) = S
     */
    public static final String ATTRIBUTEVALUETYPE_StringMax40 = "S";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_Attribute(Properties ctx, int M_Attribute_ID) {
        super(ctx, M_Attribute_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_Attribute(Properties ctx, Row row) {
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
        return "X_M_Attribute[" + getId() + "]";
    }

    /**
     * Get Attribute Value Type.
     *
     * @return Type of Attribute Value
     */
    public String getAttributeValueType() {
        return (String) getValue(COLUMNNAME_AttributeValueType);
    }

    /**
     * Set Attribute Value Type.
     *
     * @param AttributeValueType Type of Attribute Value
     */
    public void setAttributeValueType(String AttributeValueType) {

        setValue(COLUMNNAME_AttributeValueType, AttributeValueType);
    }

    /**
     * Set Instance Attribute.
     *
     * @param IsInstanceAttribute The product attribute is specific to the instance (like Serial No,
     *                            Lot or Guarantee Date)
     */
    public void setIsInstanceAttribute(boolean IsInstanceAttribute) {
        setValue(COLUMNNAME_IsInstanceAttribute, IsInstanceAttribute);
    }

    /**
     * Get Instance Attribute.
     *
     * @return The product attribute is specific to the instance (like Serial No, Lot or Guarantee
     * Date)
     */
    public boolean isInstanceAttribute() {
        Object oo = getValue(COLUMNNAME_IsInstanceAttribute);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Mandatory.
     *
     * @param IsMandatory Data entry is required in this column
     */
    public void setIsMandatory(boolean IsMandatory) {
        setValue(COLUMNNAME_IsMandatory, IsMandatory);
    }

    /**
     * Get Attribute.
     *
     * @return Product Attribute
     */
    public int getProductAttributeId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Attribute_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_M_Attribute.Table_ID;
    }
}
