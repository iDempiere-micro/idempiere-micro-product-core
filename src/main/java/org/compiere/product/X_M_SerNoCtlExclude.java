package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_SerNoCtlExclude;
import org.compiere.orm.PO;

/**
 * Generated Model for M_SerNoCtlExclude
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_SerNoCtlExclude extends PO implements I_M_SerNoCtlExclude {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_SerNoCtlExclude(int M_SerNoCtlExclude_ID) {
        super(M_SerNoCtlExclude_ID);
        /**
         * if (M_SerNoCtlExclude_ID == 0) { setColumnTableId (0); setIsSOTrx (false);
         * setSerNoCtlExclude_ID (0); setSerNoCtl_ID (0); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_SerNoCtlExclude(Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_SerNoCtlExclude[").append(getId()).append("]");
        return sb.toString();
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
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    @Override
    public int getTableId() {
        return I_M_SerNoCtlExclude.Table_ID;
    }
}
