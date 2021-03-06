package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_AttributeInstance;
import org.compiere.model.I_M_Lot;
import org.compiere.model.I_M_Product;
import org.compiere.orm.TimeUtil;
import org.compiere.util.DisplayType;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.KeyNamePair;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.logging.Level;

import static software.hsharp.core.util.DBKt.executeUpdateEx;
import static software.hsharp.core.util.DBKt.prepareStatement;

/**
 * Product Attribute Set Instance
 *
 * @author Jorg Janke
 * @author Teo Sarca, www.arhipac.ro
 * <li>BF [ 2675699 ] MAttributeSetInstance.create should create Lot/Serial/Guaran
 * @version $Id: MAttributeSetInstance.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 */
public class MAttributeSetInstance extends X_M_AttributeSetInstance {
    /**
     *
     */
    private static final long serialVersionUID = -7870720973216607658L;

    private static CLogger s_log = CLogger.getCLogger(MAttributeSetInstance.class);
    /**
     * Attribute Set
     */
    private MAttributeSet m_mas = null;
    /**
     * Date Format
     */
    private DateFormat m_dateFormat = DisplayType.getDateFormat(DisplayType.Date);

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param M_AttributeSetInstance_ID id
     */
    public MAttributeSetInstance(int M_AttributeSetInstance_ID) {
        super(M_AttributeSetInstance_ID);
    } //	MAttributeSetInstance

    /**
     * Load Constructor
     *
     */
    public MAttributeSetInstance(Row row) {
        super(row);
    } //	MAttributeSetInstance

    /**
     * Standard Constructor
     *
     * @param M_AttributeSetInstance_ID id
     * @param M_AttributeSet_ID         attribute set
     */
    public MAttributeSetInstance(
            int M_AttributeSetInstance_ID, int M_AttributeSet_ID) {
        this(M_AttributeSetInstance_ID);
        setAttributeSetId(M_AttributeSet_ID);
    } //	MAttributeSetInstance

    /**
     * Get Attribute Set Instance from ID or Product
     *
     * @param M_AttributeSetInstance_ID id or 0
     * @param M_Product_ID              required if id is 0
     * @return Attribute Set Instance or null if error
     */
    public static MAttributeSetInstance get(
            int M_AttributeSetInstance_ID, int M_Product_ID) {
        MAttributeSetInstance retValue = null;
        //	Load Instance if not 0
        if (M_AttributeSetInstance_ID != 0) {
            if (s_log.isLoggable(Level.FINE))
                s_log.fine("From M_AttributeSetInstance_ID=" + M_AttributeSetInstance_ID);
            return new MAttributeSetInstance(M_AttributeSetInstance_ID);
        }
        //	Get new from Product
        if (s_log.isLoggable(Level.FINE)) s_log.fine("From M_Product_ID=" + M_Product_ID);
        if (M_Product_ID == 0) return null;
        String sql =
                "SELECT M_AttributeSet_ID, M_AttributeSetInstance_ID "
                        + "FROM M_Product "
                        + "WHERE M_Product_ID=?";
        PreparedStatement pstmt;
        ResultSet rs = null;
        try {
            pstmt = prepareStatement(sql);
            pstmt.setInt(1, M_Product_ID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int M_AttributeSet_ID = rs.getInt(1);
                //	M_AttributeSetInstance_ID = rs.getInt(2);	//	needed ?
                //
                retValue = new MAttributeSetInstance(0, M_AttributeSet_ID);
            }
        } catch (SQLException ex) {
            s_log.log(Level.SEVERE, sql, ex);
            retValue = null;
        }
        //
        return retValue;
    } //	get

    /**
     * Create & save a new ASI for given product. Automatically creates Lot#, Serial# and Guarantee
     * Date.
     *
     * @param product
     * @return newly created ASI
     */
    public static MAttributeSetInstance create(MProduct product) {
        MAttributeSetInstance asi = new MAttributeSetInstance(0);
        asi.setClientOrg(product.getClientId(), 0);
        asi.setAttributeSetId(product.getAttributeSetId());
        // Create new Lot, Serial# and Guarantee Date
        if (asi.getAttributeSetId() > 0) {
            asi.getLot(true, product.getId());
            asi.getSerNo(true);
            asi.getGuaranteeDate(true);
        }
        //
        asi.saveEx();
        return asi;
    }

    /**
     * AutoGerate & save a new ASI for given product. Automatically creates Lot#
     *
     * @param product
     * @return newly created ASI
     */
    public static MAttributeSetInstance generateLot(
            I_M_Product product) {
        MAttributeSetInstance asi = new MAttributeSetInstance(0);
        asi.setClientOrg(product.getClientId(), 0);
        asi.setAttributeSetId(product.getAttributeSetId());
        // Create new Lot
        if (asi.getAttributeSetId() > 0) {
            asi.getLot(true, product.getId());
        }
        //
        asi.setDescription();
        asi.saveEx();
        return asi;
    }

    /**
     * Get Attribute Set
     *
     * @return Attrbute Set or null
     */
    public MAttributeSet getMAttributeSet() {
        if (m_mas == null && getAttributeSetId() != 0)
            m_mas = new MAttributeSet(getAttributeSetId());
        return m_mas;
    } //	getMAttributeSet

    /**
     * Set Description. - Product Values - Instance Values - SerNo = #123 - Lot = \u00ab123\u00bb -
     * GuaranteeDate = 10/25/2003
     */
    public void setDescription() {
        //	Make sure we have a Attribute Set
        getMAttributeSet();
        if (m_mas == null) {
            setDescription("");
            return;
        }

        StringBuilder sb = new StringBuilder();

        //	Instance Attribute Values
        MAttribute[] attributes = m_mas.getMAttributes(true);
        for (MAttribute attribute : attributes) {
            I_M_AttributeInstance mai = attribute.getMAttributeInstance(getAttributeSetInstanceId());
            if (mai != null && mai.getValue() != null) {
                if (sb.length() > 0) sb.append("_");
                sb.append(mai.getValue());
            }
        }
        //	SerNo
        if (m_mas.isSerNo() && getSerNo() != null) {
            if (sb.length() > 0) sb.append("_");
            sb.append(m_mas.getSerNoCharStart()).append(getSerNo()).append(m_mas.getSerNoCharEnd());
        }
        //	Lot
        if (m_mas.isLot() && getLot() != null) {
            if (sb.length() > 0) sb.append("_");
            sb.append(m_mas.getLotCharStart()).append(getLot()).append(m_mas.getLotCharEnd());
        }
        //	GuaranteeDate
        if (m_mas.isGuaranteeDate() && getGuaranteeDate() != null) {
            if (sb.length() > 0) sb.append("_");
            sb.append(m_dateFormat.format(getGuaranteeDate()));
        }

        //	Product Attribute Values
        attributes = m_mas.getMAttributes(false);
        for (MAttribute attribute : attributes) {
            I_M_AttributeInstance mai = attribute.getMAttributeInstance(getAttributeSetInstanceId());
            if (mai != null) {
                if (sb.length() > 0) sb.append("_");
                if (mai.getValue() != null) sb.append(mai.getValue());
            }
        }
        setDescription(sb.toString());
    } //	setDescription

    /**
     * Get Guarantee Date
     *
     * @param getNew if true calculates/sets guarantee date
     * @return guarantee date or null if days = 0
     */
    public Timestamp getGuaranteeDate(boolean getNew) {
        if (getNew) {
            int days = getMAttributeSet().getGuaranteeDays();
            if (days > 0) {
                Timestamp ts = TimeUtil.addDays(new Timestamp(System.currentTimeMillis()), days);
                setGuaranteeDate(ts);
            }
        }
        return getGuaranteeDate();
    } //	getGuaranteeDate

    /**
     * Get Lot No
     *
     * @param getNew       if true create/set new lot
     * @param M_Product_ID product used if new
     * @return lot
     */
    public String getLot(boolean getNew, int M_Product_ID) {
        if (getNew) createLot(M_Product_ID);
        return getLot();
    } //	getLot

    /**
     * Create Lot
     *
     * @param M_Product_ID product used if new
     * @return lot info
     */
    public KeyNamePair createLot(int M_Product_ID) {
        KeyNamePair retValue = null;
        int M_LotCtl_ID = getMAttributeSet().getLotControlId();
        if (M_LotCtl_ID != 0) {
            MLotCtl ctl = new MLotCtl(M_LotCtl_ID);
            MLot lot = ctl.createLot(M_Product_ID);
            setLotId(lot.getLotId());
            setLot(lot.getName());
            retValue = new KeyNamePair(lot.getLotId(), lot.getName());
        }
        return retValue;
    } //	createLot

    /**
     * To to find lot and set Lot/ID
     *
     * @param Lot          lot
     * @param M_Product_ID product
     */
    public void setLot(String Lot, int M_Product_ID) {
        //	Try to find it
        I_M_Lot mLot = MLot.getProductLot(M_Product_ID, Lot);
        if (mLot != null) setLotId(mLot.getLotId());
        setLot(Lot);
    } //	setLot

    /**
     * Get Serial No
     *
     * @param getNew if true create/set new Ser No
     * @return Serial Number
     */
    public String getSerNo(boolean getNew) {
        if (getNew) {
            int M_SerNoCtl_ID = getMAttributeSet().getSerialNoControlId();
            if (M_SerNoCtl_ID != 0) {
                MSerNoCtl ctl = new MSerNoCtl(M_SerNoCtl_ID);
                setSerNo(ctl.createSerNo());
            }
        }
        return getSerNo();
    } //	getSerNo

    @Override
    protected boolean afterSave(boolean newRecord, boolean success) {
        if (super.afterSave(newRecord, success)) {
            if (newRecord && success) {
                // use id as description when description is empty
                String desc = this.getDescription();
                if (desc == null || desc.trim().length() == 0) {
                    this.setValueNoCheck("Description", Integer.toString(getAttributeSetInstanceId()));
                    String sql =
                            "UPDATE M_AttributeSetInstance SET Description = ? WHERE M_AttributeSetInstance_ID = ?";
                    int no =
                            executeUpdateEx(
                                    sql,
                                    new Object[]{
                                            Integer.toString(getAttributeSetInstanceId()), getAttributeSetInstanceId()
                                    }
                            );
                    if (no <= 0) {
                        log.log(Level.SEVERE, "Failed to update description.");
                        return false;
                    }
                }
            }
            return true;
        }

        return false;
    }
} //	MAttributeSetInstance
