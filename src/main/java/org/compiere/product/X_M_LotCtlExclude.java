package org.compiere.product;

import org.compiere.model.I_M_LotCtlExclude;
import org.compiere.orm.PO;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for M_LotCtlExclude
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_LotCtlExclude extends PO implements I_M_LotCtlExclude {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_LotCtlExclude(Properties ctx, int M_LotCtlExclude_ID) {
        super(ctx, M_LotCtlExclude_ID);
        /**
         * if (M_LotCtlExclude_ID == 0) { setColumnTableId (0); setIsSOTrx (false); setM_LotCtlExclude_ID
         * (0); setM_LotCtl_ID (0); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_LotCtlExclude(Properties ctx, ResultSet rs) {
        super(ctx, rs);
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
        StringBuffer sb = new StringBuffer("X_M_LotCtlExclude[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Table.
     *
     * @return Database Table information
     */
    public int getAD_Table_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_AD_Table_ID);
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
        return I_M_LotCtlExclude.Table_ID;
    }
}
