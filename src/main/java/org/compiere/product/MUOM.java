package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_C_UOM;
import org.compiere.orm.MRole;
import org.compiere.orm.Query;
import org.idempiere.common.util.CCache;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import static software.hsharp.core.util.DBKt.getSQLValue;

/**
 * Unit Of Measure Model
 *
 * @author Jorg Janke
 * @version $Id: MUOM.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MUOM extends X_C_UOM {
    /**
     * X12 Element 355 Code Minute
     */
    public static final String X12_MINUTE = "MJ";
    /**
     * X12 Element 355 Code Hour
     */
    public static final String X12_HOUR = "HR";
    /**
     * X12 Element 355 Code Day
     */
    public static final String X12_DAY = "DA";
    /**
     * X12 Element 355 Code Work Day (8 hours / 5days)
     */
    public static final String X12_DAY_WORK = "WD";
    /**
     * X12 Element 355 Code Week
     */
    public static final String X12_WEEK = "WK";
    /**
     * X12 Element 355 Code Month
     */
    public static final String X12_MONTH = "MO";
    /**
     * X12 Element 355 Code Work Month (20 days / 4 weeks)
     */
    public static final String X12_MONTH_WORK = "WM";
    /**
     * X12 Element 355 Code Year
     */
    public static final String X12_YEAR = "YR";
    /**
     *
     */
    private static final long serialVersionUID = -7248044516358949324L;
    /**
     * UOM Cache
     */
    private static CCache<Integer, MUOM> s_cache = new CCache<Integer, MUOM>(I_C_UOM.Table_Name, 30);

    /**
     * ************************************************************************ Constructor.
     *
     * @param ctx      context
     * @param C_UOM_ID UOM ID
     * @param trxName  transaction
     */
    public MUOM(Properties ctx, int C_UOM_ID) {
        super(ctx, C_UOM_ID);
        if (C_UOM_ID == 0) {
            //	setName (null);
            //	setX12DE355 (null);
            setIsDefault(false);
            setStdPrecision(2);
            setCostingPrecision(6);
        }
    } //	UOM

    /** ********************************************************************** */

    /**
     * Load Constructor.
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MUOM(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    } //	UOM

    public MUOM(Properties ctx, Row row) {
        super(ctx, row);
    } //	UOM

    /**
     * Get Default C_UOM_ID
     *
     * @param ctx context for AD_Client
     * @return C_UOM_ID
     */
    public static int getDefault_UOM_ID(Properties ctx) {
        String sql =
                "SELECT C_UOM_ID "
                        + "FROM C_UOM "
                        + "WHERE AD_Client_ID IN (0,?) "
                        + "ORDER BY IsDefault DESC, AD_Client_ID DESC, C_UOM_ID";
        return getSQLValue(sql, Env.getClientId(ctx));
    } //	getDefault_UOM_ID

    /**
     * Get UOM from Cache
     *
     * @param ctx      context
     * @param C_UOM_ID ID
     * @return UOM
     */
    public static MUOM get(Properties ctx, int C_UOM_ID) {
        if (s_cache.size() == 0) loadUOMs(ctx);
        //
        MUOM uom = s_cache.get(C_UOM_ID);
        if (uom != null) return uom;
        //
        uom = new MUOM(ctx, C_UOM_ID);
        s_cache.put(C_UOM_ID, uom);
        return uom;
    } //	get

    /**
     * Get Precision
     *
     * @param ctx      context
     * @param C_UOM_ID ID
     * @return Precision
     */
    public static int getPrecision(Properties ctx, int C_UOM_ID) {
        MUOM uom = get(ctx, C_UOM_ID);
        return uom.getStdPrecision();
    } //	getPrecision

    /**
     * Load All UOMs
     *
     * @param ctx context
     */
    private static void loadUOMs(Properties ctx) {
        List<MUOM> list =
                new Query(ctx, I_C_UOM.Table_Name, "IsActive='Y'")
                        .setApplyAccessFilter(MRole.SQL_NOTQUALIFIED, MRole.SQL_RO)
                        .list();
        //
        for (MUOM uom : list) {
            s_cache.put(uom.getId(), uom);
        }
    } //	loadUOMs

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("UOM[");
        sb.append("ID=").append(getId()).append(", Name=").append(getName());
        return sb.toString();
    } //	toString

    /**
     * Round qty
     *
     * @param qty          quantity
     * @param stdPrecision true if std precisison
     * @return rounded quantity
     */
    public BigDecimal round(BigDecimal qty, boolean stdPrecision) {
        int precision = getStdPrecision();
        if (!stdPrecision) precision = getCostingPrecision();
        if (qty.scale() > precision) return qty.setScale(getStdPrecision(), BigDecimal.ROUND_HALF_UP);
        return qty;
    } //	round

    /**
     * Minute
     *
     * @return true if UOM is minute
     */
    public boolean isMinute() {
        return X12_MINUTE.equals(getX12DE355());
    }

    /**
     * Hour
     *
     * @return true if UOM is hour
     */
    public boolean isHour() {
        return X12_HOUR.equals(getX12DE355());
    }

    /**
     * Day
     *
     * @return true if UOM is Day
     */
    public boolean isDay() {
        return X12_DAY.equals(getX12DE355());
    }

    /**
     * WorkDay
     *
     * @return true if UOM is work day
     */
    public boolean isWorkDay() {
        return X12_DAY_WORK.equals(getX12DE355());
    }

    /**
     * Week
     *
     * @return true if UOM is Week
     */
    public boolean isWeek() {
        return X12_WEEK.equals(getX12DE355());
    }

    /**
     * Month
     *
     * @return true if UOM is Month
     */
    public boolean isMonth() {
        return X12_MONTH.equals(getX12DE355());
    }

    /**
     * WorkMonth
     *
     * @return true if UOM is Work Month
     */
    public boolean isWorkMonth() {
        return X12_MONTH_WORK.equals(getX12DE355());
    }

    /**
     * Year
     *
     * @return true if UOM is year
     */
    public boolean isYear() {
        return X12_YEAR.equals(getX12DE355());
    }
} //	MUOM
