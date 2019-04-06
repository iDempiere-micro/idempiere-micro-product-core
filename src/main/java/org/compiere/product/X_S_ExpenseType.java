package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_S_ExpenseType;
import org.compiere.orm.BasePONameValue;

/**
 * Generated Model for S_ExpenseType
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_S_ExpenseType extends BasePONameValue implements I_S_ExpenseType {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_S_ExpenseType(int S_ExpenseType_ID) {
        super(S_ExpenseType_ID);
        /**
         * if (S_ExpenseType_ID == 0) { setTaxCategoryId (0); setUOMId (0); setIsInvoiced (false);
         * setProductCategoryId (0); setName (null); setExpenseTypeId (0); setValue (null); }
         */
    }

    /**
     * Load Constructor
     */
    public X_S_ExpenseType(Row row) {
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
        return "X_S_ExpenseType[" + getId() + "]";
    }

    /**
     * Get Tax Category.
     *
     * @return Tax Category
     */
    public int getTaxCategoryId() {
        Integer ii = (Integer) getValue(COLUMNNAME_C_TaxCategory_ID);
        if (ii == null) return 0;
        return ii;
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
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return (String) getValue(COLUMNNAME_Description);
    }

    /**
     * Get Product Category.
     *
     * @return Category of a Product
     */
    public int getProductCategoryId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Product_Category_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Expense Type.
     *
     * @return Expense report type
     */
    public int getExpenseTypeId() {
        Integer ii = (Integer) getValue(COLUMNNAME_S_ExpenseType_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_S_ExpenseType.Table_ID;
    }
}
