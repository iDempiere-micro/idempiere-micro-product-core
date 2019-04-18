package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_AttributeInstance;
import org.compiere.orm.Query;

import java.util.logging.Level;

import static software.hsharp.core.util.DBKt.executeUpdate;

/**
 * Product Attribute
 *
 * @author Jorg Janke
 * @version $Id: MAttribute.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 */
public class MAttribute extends X_M_Attribute {
    /**
     *
     */
    private static final long serialVersionUID = 7869800574413317999L;

    /**
     * Standard Constructor
     *
     * @param M_Attribute_ID id
     */
    public MAttribute(int M_Attribute_ID) {
        super(M_Attribute_ID);
        if (M_Attribute_ID == 0) {
            setAttributeValueType(X_M_Attribute.ATTRIBUTEVALUETYPE_StringMax40);
            setIsInstanceAttribute(false);
            setIsMandatory(false);
        }
    } //	MAttribute

    /**
     * Load Constructor
     *
     */
    public MAttribute(Row row) {
        super(row);
    } //	MAttribute

    /**
     * ************************************************************************ Get Attribute Instance
     *
     * @param M_AttributeSetInstance_ID attribute set instance
     * @return Attribute Instance or null
     */
    public I_M_AttributeInstance getMAttributeInstance(int M_AttributeSetInstance_ID) {
        final String whereClause =
                I_M_AttributeInstance.COLUMNNAME_M_Attribute_ID
                        + "=? AND "
                        + I_M_AttributeInstance.COLUMNNAME_M_AttributeSetInstance_ID
                        + "=?";

        return new Query<I_M_AttributeInstance>(I_M_AttributeInstance.Table_Name, whereClause)
                .setParameters(getProductAttributeId(), M_AttributeSetInstance_ID)
                .first();
    } //	getAttributeInstance

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        return "MAttribute[" + getId() +
                "-" +
                getName() +
                ",Type=" +
                getAttributeValueType() +
                ",Instance=" +
                isInstanceAttribute() +
                "]";
    } //	toString

    /**
     * AfterSave
     *
     * @param newRecord new
     * @param success   success
     * @return success
     */
    protected boolean afterSave(boolean newRecord, boolean success) {
        if (!success) return success;
        //	Changed to Instance Attribute
        if (!newRecord && isValueChanged("IsInstanceAttribute") && isInstanceAttribute()) {
            String sql = "UPDATE M_AttributeSet mas " +
                    "SET IsInstanceAttribute='Y' " +
                    "WHERE IsInstanceAttribute='N'" +
                    " AND EXISTS (SELECT * FROM M_AttributeUse mau " +
                    "WHERE mas.M_AttributeSet_ID=mau.M_AttributeSet_ID" +
                    " AND mau.M_Attribute_ID=" +
                    getProductAttributeId() +
                    ")";
            int no = executeUpdate(sql);
            if (log.isLoggable(Level.FINE)) log.fine("AttributeSet Instance set #" + no);
        }
        return success;
    } //	afterSave
} //	MAttribute
