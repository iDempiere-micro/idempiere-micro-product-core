package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_C_UOM;
import org.compiere.orm.BasePOName;

import java.util.Properties;

/**
 * Generated Model for C_UOM
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_UOM extends BasePOName implements I_C_UOM {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_C_UOM(Properties ctx, int C_UOM_ID) {
        super(ctx, C_UOM_ID);
    }

    /**
     * Load Constructor
     */
    public X_C_UOM(Properties ctx, Row row) {
        super(ctx, row);
    } //	UOM

    /**
     * AccessLevel
     *
     * @return 6 - System - Client
     */
    protected int getAccessLevel() {
        return accessLevel.intValue();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("X_C_UOM[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Costing Precision.
     *
     * @return Rounding used costing calculations
     */
    public int getCostingPrecision() {
        Integer ii = (Integer) getValue(COLUMNNAME_CostingPrecision);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Costing Precision.
     *
     * @param CostingPrecision Rounding used costing calculations
     */
    public void setCostingPrecision(int CostingPrecision) {
        setValue(COLUMNNAME_CostingPrecision, Integer.valueOf(CostingPrecision));
    }

    /**
     * Get UOM.
     *
     * @return Unit of Measure
     */
    public int getUOMId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_UOM_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Default.
     *
     * @param IsDefault Default value
     */
    public void setIsDefault(boolean IsDefault) {
        setValue(COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
    }

    /**
     * Get Standard Precision.
     *
     * @return Rule for rounding calculated amounts
     */
    public int getStdPrecision() {
        Integer ii = (Integer) getValue(COLUMNNAME_StdPrecision);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Standard Precision.
     *
     * @param StdPrecision Rule for rounding calculated amounts
     */
    public void setStdPrecision(int StdPrecision) {
        setValue(COLUMNNAME_StdPrecision, Integer.valueOf(StdPrecision));
    }

    /**
     * Get UOM Code.
     *
     * @return UOM EDI X12 Code
     */
    public String getX12DE355() {
        return (String) getValue(COLUMNNAME_X12DE355);
    }

    @Override
    public int getTableId() {
        return I_C_UOM.Table_ID;
    }
}
