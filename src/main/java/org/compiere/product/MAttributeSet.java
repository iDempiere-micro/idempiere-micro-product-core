package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_AttributeSet;
import org.compiere.orm.Query;
import org.idempiere.common.exceptions.DBException;
import org.idempiere.common.util.CCache;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static software.hsharp.core.util.DBKt.executeUpdate;
import static software.hsharp.core.util.DBKt.prepareStatement;

/**
 * Product Attribute Set
 *
 * @author Jorg Janke
 * @author Teo Sarca, www.arhipac.ro
 * <li>FR [ 2214883 ] Remove SQL code and Replace for Query
 * @version $Id: MAttributeSet.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MAttributeSet extends X_M_AttributeSet {
    /**
     *
     */
    private static final long serialVersionUID = -187568054160926817L;
    /**
     * Cache
     */
    private static CCache<Integer, MAttributeSet> s_cache =
            new CCache<Integer, MAttributeSet>(I_M_AttributeSet.Table_Name, 20);
    /**
     * Instance Attributes
     */
    private MAttribute[] m_instanceAttributes = null;
    /**
     * Instance Attributes
     */
    private MAttribute[] m_productAttributes = null;
    /**
     * Entry Exclude
     */
    private X_M_AttributeSetExclude[] m_excludes = null;

    /**
     * Standard constructor
     *
     * @param ctx               context
     * @param M_AttributeSet_ID id
     * @param trxName           transaction
     */
    public MAttributeSet(Properties ctx, int M_AttributeSet_ID) {
        super(ctx, M_AttributeSet_ID);
        if (M_AttributeSet_ID == 0) {
            //	setName (null);
            setIsGuaranteeDate(false);
            setIsGuaranteeDateMandatory(false);
            setIsLot(false);
            setIsLotMandatory(false);
            setIsSerNo(false);
            setIsSerNoMandatory(false);
            setIsInstanceAttribute(false);
            setMandatoryType(X_M_AttributeSet.MANDATORYTYPE_NotMandatory);
        }
    } //	MAttributeSet

    /**
     * Load constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MAttributeSet(Properties ctx, Row row) {
        super(ctx, row);
    } //	MAttributeSet

    /**
     * Get MAttributeSet from Cache
     *
     * @param ctx               context
     * @param M_AttributeSet_ID id
     * @return MAttributeSet
     */
    public static MAttributeSet get(Properties ctx, int M_AttributeSet_ID) {
        Integer key = new Integer(M_AttributeSet_ID);
        MAttributeSet retValue = s_cache.get(key);
        if (retValue != null) return retValue;
        retValue = new MAttributeSet(ctx, M_AttributeSet_ID);
        if (retValue.getId() != 0) s_cache.put(key, retValue);
        return retValue;
    } //	get

    /**
     * Get Attribute Array
     *
     * @param instanceAttributes true if for instance
     * @return instance or product attribute array
     */
    public MAttribute[] getMAttributes(boolean instanceAttributes) {
        if ((m_instanceAttributes == null && instanceAttributes)
                || m_productAttributes == null && !instanceAttributes) {
            String sql =
                    "SELECT mau.M_Attribute_ID "
                            + "FROM M_AttributeUse mau"
                            + " INNER JOIN M_Attribute ma ON (mau.M_Attribute_ID=ma.M_Attribute_ID) "
                            + "WHERE mau.IsActive='Y' AND ma.IsActive='Y'"
                            + " AND mau.M_AttributeSet_ID=? AND ma.IsInstanceAttribute=? " //	#1,2
                            + "ORDER BY mau.SeqNo";
            ArrayList<MAttribute> list = new ArrayList<MAttribute>();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                pstmt = prepareStatement(sql);
                pstmt.setInt(1, getAttributeSetId());
                pstmt.setString(2, instanceAttributes ? "Y" : "N");
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    MAttribute ma = new MAttribute(getCtx(), rs.getInt(1));
                    list.add(ma);
                }
            } catch (SQLException ex) {
                throw new DBException(ex, sql);
            } finally {
                rs = null;
                pstmt = null;
            }

            //	Differentiate attributes
            if (instanceAttributes) {
                m_instanceAttributes = new MAttribute[list.size()];
                list.toArray(m_instanceAttributes);
            } else {
                m_productAttributes = new MAttribute[list.size()];
                list.toArray(m_productAttributes);
            }
        }
        //
        if (instanceAttributes) {
            if (isInstanceAttribute() != m_instanceAttributes.length > 0)
                setIsInstanceAttribute(m_instanceAttributes.length > 0);
        }

        //	Return
        if (instanceAttributes) return m_instanceAttributes;
        return m_productAttributes;
    } //	getMAttributes

    /**
     * Something is Mandatory
     *
     * @return true if something is mandatory
     */
    public boolean isMandatory() {
        return !X_M_AttributeSet.MANDATORYTYPE_NotMandatory.equals(getMandatoryType())
                || isLotMandatory()
                || isSerNoMandatory()
                || isGuaranteeDateMandatory();
    } //	isMandatory

    /**
     * Is always mandatory
     *
     * @return mandatory
     */
    public boolean isMandatoryAlways() {
        return X_M_AttributeSet.MANDATORYTYPE_AlwaysMandatory.equals(getMandatoryType());
    } //	isMandatoryAlways

    /**
     * Exclude table entry
     *
     * @param AD_Table_ID column
     * @param isSOTrx     sales order
     * @return true if excluded
     */
    public boolean excludeTableEntry(int AD_Table_ID, boolean isSOTrx) {
        loadExcludes();
        //	Find it
        if (m_excludes != null && m_excludes.length > 0) {
            for (int i = 0; i < m_excludes.length; i++) {
                if (m_excludes[i].getRowTableId() == AD_Table_ID && m_excludes[i].isSOTrx() == isSOTrx)
                    return true;
            }
        }
        return false;
    } //	excludeTableEntry

    private void loadExcludes() {
        if (m_excludes == null) {
            final String whereClause = X_M_AttributeSetExclude.COLUMNNAME_M_AttributeSet_ID + "=?";
            List<X_M_AttributeSetExclude> list =
                    new Query(getCtx(), X_M_AttributeSetExclude.Table_Name, whereClause)
                            .setParameters(getId())
                            .setOnlyActiveRecords(true)
                            .list();
            m_excludes = new X_M_AttributeSetExclude[list.size()];
            list.toArray(m_excludes);
        }
    }

    /**
     * Get Lot Char Start
     *
     * @return defined or \u00ab
     */
    public String getLotCharStart() {
        String s = super.getLotCharSOverwrite();
        if (s != null && s.length() == 1 && !s.equals(" ")) return s;
        return "\u00ab";
    } //	getLotCharStart

    /**
     * Get Lot Char End
     *
     * @return defined or \u00bb
     */
    public String getLotCharEnd() {
        String s = super.getLotCharEOverwrite();
        if (s != null && s.length() == 1 && !s.equals(" ")) return s;
        return "\u00bb";
    } //	getLotCharEnd

    /**
     * Get SerNo Char Start
     *
     * @return defined or #
     */
    public String getSerNoCharStart() {
        String s = super.getSerNoCharSOverwrite();
        if (s != null && s.length() == 1 && !s.equals(" ")) return s;
        return "#";
    } //	getSerNoCharStart

    /**
     * Get SerNo Char End
     *
     * @return defined or none
     */
    public String getSerNoCharEnd() {
        String s = super.getSerNoCharEOverwrite();
        if (s != null && s.length() == 1 && !s.equals(" ")) return s;
        return "";
    } //	getSerNoCharEnd

    /**
     * Before Save. - set instance attribute flag
     *
     * @param newRecord new
     * @return true
     */
    protected boolean beforeSave(boolean newRecord) {
        if (!isInstanceAttribute() && (isSerNo() || isLot() || isGuaranteeDate()))
            setIsInstanceAttribute(true);
        return true;
    } //	beforeSave

    /**
     * After Save. - Verify Instance Attribute
     *
     * @param newRecord new
     * @param success   success
     * @return success
     */
    protected boolean afterSave(boolean newRecord, boolean success) {
        //	Set Instance Attribute
        if (!success) return success;
        if (!isInstanceAttribute()) {
            StringBuilder sql =
                    new StringBuilder("UPDATE M_AttributeSet mas")
                            .append(" SET IsInstanceAttribute='Y' ")
                            .append("WHERE M_AttributeSet_ID=")
                            .append(getAttributeSetId())
                            .append(" AND IsInstanceAttribute='N'")
                            .append(" AND (IsSerNo='Y' OR IsLot='Y' OR IsGuaranteeDate='Y'")
                            .append(" OR EXISTS (SELECT * FROM M_AttributeUse mau")
                            .append(" INNER JOIN M_Attribute ma ON (mau.M_Attribute_ID=ma.M_Attribute_ID) ")
                            .append("WHERE mau.M_AttributeSet_ID=mas.M_AttributeSet_ID")
                            .append(" AND mau.IsActive='Y' AND ma.IsActive='Y'")
                            .append(" AND ma.IsInstanceAttribute='Y')")
                            .append(")");
            int no = executeUpdate(sql.toString());
            if (no != 0) {
                log.warning("Set Instance Attribute");
                setIsInstanceAttribute(true);
            }
        }
        //	Reset Instance Attribute
        if (isInstanceAttribute() && !isSerNo() && !isLot() && !isGuaranteeDate()) {
            StringBuilder sql =
                    new StringBuilder("UPDATE M_AttributeSet mas")
                            .append(" SET IsInstanceAttribute='N' ")
                            .append("WHERE M_AttributeSet_ID=")
                            .append(getAttributeSetId())
                            .append(" AND IsInstanceAttribute='Y'")
                            .append("	AND IsSerNo='N' AND IsLot='N' AND IsGuaranteeDate='N'")
                            .append(" AND NOT EXISTS (SELECT * FROM M_AttributeUse mau")
                            .append(" INNER JOIN M_Attribute ma ON (mau.M_Attribute_ID=ma.M_Attribute_ID) ")
                            .append("WHERE mau.M_AttributeSet_ID=mas.M_AttributeSet_ID")
                            .append(" AND mau.IsActive='Y' AND ma.IsActive='Y'")
                            .append(" AND ma.IsInstanceAttribute='Y')");
            int no = executeUpdate(sql.toString());
            if (no != 0) {
                log.warning("Reset Instance Attribute");
                setIsInstanceAttribute(false);
            }
        }
        return success;
    } //	afterSave
} //	MAttributeSet
