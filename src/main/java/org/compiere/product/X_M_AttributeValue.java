package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_AttributeValue;
import org.compiere.orm.BasePONameValue;

/**
 * Generated Model for M_AttributeValue
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeValue extends BasePONameValue
        implements I_M_AttributeValue {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_AttributeValue(int M_AttributeValue_ID) {
        super(M_AttributeValue_ID);
        /**
         * if (M_AttributeValue_ID == 0) { setMAttributeID (0); setAttributeValue_ID (0); setName
         * (null); setValue (null); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_AttributeValue(Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_AttributeValue[").append(getId()).append("]");
        return sb.toString();
    }

    @Override
    public int getTableId() {
        return I_M_AttributeValue.Table_ID;
    }
}
