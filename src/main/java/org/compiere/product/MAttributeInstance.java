package org.compiere.product;

import kotliquery.Row;

import java.math.BigDecimal;

/**
 * Product Attribute Set
 *
 * @author Jorg Janke
 * @version $Id: MAttributeInstance.java,v 1.3 2006/07/30 00:51:02 jjanke Exp $
 */
public class MAttributeInstance extends X_M_AttributeInstance {
    /**
     *
     */
    private static final long serialVersionUID = 6154044437449512042L;

    /**
     * Persistency Constructor
     *
     * @param ctx     context
     * @param ignored ignored
     */
    public MAttributeInstance(int ignored) {
        super(0);
        if (ignored != 0) throw new IllegalArgumentException("Multi-Key");
    } //	MAttributeInstance

    /**
     * Load Cosntructor
     *
     * @param ctx context
     */
    public MAttributeInstance(Row row) {
        super(row);
    } //	MAttributeInstance

    /**
     * String Value Constructior
     *
     * @param ctx                       context
     * @param M_Attribute_ID            attribute
     * @param M_AttributeSetInstance_ID instance
     * @param Value                     string value
     * @param trxName                   transaction
     */
    public MAttributeInstance(

            int M_Attribute_ID,
            int M_AttributeSetInstance_ID,
            String Value,
            String trxName) {
        super(0);
        setMAttributeID(M_Attribute_ID);
        setAttributeSetInstanceId(M_AttributeSetInstance_ID);
        setValue(Value);
    } //	MAttributeInstance

    /**
     * Number Value Constructior
     *
     * @param ctx                       context
     * @param M_Attribute_ID            attribute
     * @param M_AttributeSetInstance_ID instance
     * @param BDValue                   number value
     * @param trxName                   transaction
     */
    public MAttributeInstance(

            int M_Attribute_ID,
            int M_AttributeSetInstance_ID,
            BigDecimal BDValue,
            String trxName) {
        super(0);
        setMAttributeID(M_Attribute_ID);
        setAttributeSetInstanceId(M_AttributeSetInstance_ID);
        setValueNumber(BDValue);
    } //	MAttributeInstance

    /**
     * Selection Value Constructior
     *
     * @param ctx                       context
     * @param M_Attribute_ID            attribute
     * @param M_AttributeSetInstance_ID instance
     * @param M_AttributeValue_ID       selection
     * @param Value                     String representation for fast display
     * @param trxName                   transaction
     */
    public MAttributeInstance(

            int M_Attribute_ID,
            int M_AttributeSetInstance_ID,
            int M_AttributeValue_ID,
            String Value,
            String trxName) {
        super(0);
        setMAttributeID(M_Attribute_ID);
        setAttributeSetInstanceId(M_AttributeSetInstance_ID);
        setAttributeValueId(M_AttributeValue_ID);
        setValue(Value);
    } //	MAttributeInstance

    /**
     * Set ValueNumber
     *
     * @param ValueNumber number
     */
    public void setValueNumber(BigDecimal ValueNumber) {
        super.setValueNumber(ValueNumber);
        if (ValueNumber == null) {
            setValue(null);
            return;
        }
        if (ValueNumber.signum() == 0) {
            setValue("0");
            return;
        }
        //	Display number w/o decimal 0
        char[] chars = ValueNumber.toString().toCharArray();
        StringBuilder display = new StringBuilder();
        boolean add = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (add) display.insert(0, c);
            else {
                if (c == '0') continue;
                else if (c == '.') // 	decimal point
                    add = true;
                else {
                    display.insert(0, c);
                    add = true;
                }
            }
        }
        setValue(display.toString());
    } //	setValueNumber

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        return getValue();
    } //	toString
} //	MAttributeInstance
