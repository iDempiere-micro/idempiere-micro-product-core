package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_AttributeSetExclude;
import org.compiere.orm.PO;

/**
 * Generated Model for M_AttributeSetExclude
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeSetExclude extends PO implements I_M_AttributeSetExclude {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_AttributeSetExclude(int M_AttributeSetExclude_ID) {
        super(M_AttributeSetExclude_ID);
        /**
         * if (M_AttributeSetExclude_ID == 0) { setColumnTableId (0); setIsSOTrx (false);
         * setAttributeSetExclude_ID (0); setAttributeSetId (0); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_AttributeSetExclude(Row row) {
        super(row);
    }

    /**
     * AccessLevel
     *
     * @return 2 - Client
     */
    protected int getAccessLevel() {
        return accessLevel.intValue();
    }

    public String toString() {
        return "X_M_AttributeSetExclude[" + getId() + "]";
    }

    /**
     * Get Table.
     *
     * @return Database Table information
     */
    public int getRowTableId() {
        Integer ii = getValue(COLUMNNAME_AD_Table_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Sales Transaction.
     *
     * @return This is a Sales Transaction
     */
    public boolean isSOTrx() {
        Object oo = getValue(COLUMNNAME_IsSOTrx);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
            return "Y".equals(oo);
        }
        return false;
    }

    @Override
    public int getTableId() {
        return I_M_AttributeSetExclude.Table_ID;
    }
}
