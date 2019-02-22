package org.compiere.product;

import org.compiere.model.I_M_AttributeInstance;
import org.compiere.orm.Query;

import java.sql.ResultSet;
import java.util.Properties;
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
     * @param ctx            context
     * @param M_Attribute_ID id
     * @param trxName        transaction
     */
    public MAttribute(Properties ctx, int M_Attribute_ID) {
        super(ctx, M_Attribute_ID);
        if (M_Attribute_ID == 0) {
            setAttributeValueType(X_M_Attribute.ATTRIBUTEVALUETYPE_StringMax40);
            setIsInstanceAttribute(false);
            setIsMandatory(false);
        }
    } //	MAttribute

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MAttribute(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    } //	MAttribute

    /**
     * ************************************************************************ Get Attribute Instance
     *
     * @param M_AttributeSetInstance_ID attribute set instance
     * @return Attribute Instance or null
     */
    public MAttributeInstance getMAttributeInstance(int M_AttributeSetInstance_ID) {
        final String whereClause =
                I_M_AttributeInstance.COLUMNNAME_M_Attribute_ID
                        + "=? AND "
                        + I_M_AttributeInstance.COLUMNNAME_M_AttributeSetInstance_ID
                        + "=?";
        MAttributeInstance retValue =
                new Query(getCtx(), I_M_AttributeInstance.Table_Name, whereClause)
                        .setParameters(getMAttribute_ID(), M_AttributeSetInstance_ID)
                        .first();

        return retValue;
    } //	getAttributeInstance

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("MAttribute[");
        sb.append(getId())
                .append("-")
                .append(getName())
                .append(",Type=")
                .append(getAttributeValueType())
                .append(",Instance=")
                .append(isInstanceAttribute())
                .append("]");
        return sb.toString();
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
        if (!newRecord && is_ValueChanged("IsInstanceAttribute") && isInstanceAttribute()) {
            StringBuilder sql =
                    new StringBuilder("UPDATE M_AttributeSet mas ")
                            .append("SET IsInstanceAttribute='Y' ")
                            .append("WHERE IsInstanceAttribute='N'")
                            .append(" AND EXISTS (SELECT * FROM M_AttributeUse mau ")
                            .append("WHERE mas.M_AttributeSet_ID=mau.M_AttributeSet_ID")
                            .append(" AND mau.M_Attribute_ID=")
                            .append(getMAttribute_ID())
                            .append(")");
            int no = executeUpdate(sql.toString());
            if (log.isLoggable(Level.FINE)) log.fine("AttributeSet Instance set #" + no);
        }
        return success;
    } //	afterSave
} //	MAttribute
