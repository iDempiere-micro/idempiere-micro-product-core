package org.compiere.product;

import kotliquery.Row;

/**
 * Product Attribute Value
 *
 * @author Jorg Janke
 * @version $Id: MAttributeValue.java,v 1.3 2006/07/30 00:51:02 jjanke Exp $
 */
public class MAttributeValue extends X_M_AttributeValue {
    /**
     *
     */
    private static final long serialVersionUID = 4105427429027399512L;

    /**
     * Constructor
     *
     * @param M_AttributeValue_ID id
     */
    public MAttributeValue(int M_AttributeValue_ID) {
        super(M_AttributeValue_ID);
    } //	MAttributeValue

    /**
     * Load Constructor
     */
    public MAttributeValue(Row row) {
        super(row);
    } //	MAttributeValue

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        return getName();
    } //	toString
} //	MAttributeValue
