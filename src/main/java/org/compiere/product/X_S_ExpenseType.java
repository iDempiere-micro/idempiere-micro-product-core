package org.compiere.product;

import org.compiere.model.I_S_ExpenseType;
import org.compiere.orm.BasePONameValue;
import org.idempiere.orm.I_Persistent;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for S_ExpenseType
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_S_ExpenseType extends BasePONameValue implements I_S_ExpenseType, I_Persistent {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_S_ExpenseType(Properties ctx, int S_ExpenseType_ID) {
        super(ctx, S_ExpenseType_ID);
        /**
         * if (S_ExpenseType_ID == 0) { setC_TaxCategory_ID (0); setC_UOM_ID (0); setIsInvoiced (false);
         * setM_Product_Category_ID (0); setName (null); setS_ExpenseType_ID (0); setValue (null); }
         */
    }

    /**
     * Load Constructor
     */
    public X_S_ExpenseType(Properties ctx, ResultSet rs) {
        super(ctx, rs);
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
        return "X_S_ExpenseType[" + getId() + "]";
    }

    /**
     * Get Tax Category.
     *
     * @return Tax Category
     */
    public int getC_TaxCategory_ID() {
        Integer ii = (Integer) get_Value(COLUMNNAME_C_TaxCategory_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get UOM.
     *
     * @return Unit of Measure
     */
    public int getC_UOM_ID() {
        Integer ii = (Integer) get_Value(COLUMNNAME_C_UOM_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return (String) get_Value(COLUMNNAME_Description);
    }

    /**
     * Get Product Category.
     *
     * @return Category of a Product
     */
    public int getM_Product_Category_ID() {
        Integer ii = (Integer) get_Value(COLUMNNAME_M_Product_Category_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Expense Type.
     *
     * @return Expense report type
     */
    public int getS_ExpenseType_ID() {
        Integer ii = (Integer) get_Value(COLUMNNAME_S_ExpenseType_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_S_ExpenseType.Table_ID;
    }
}
