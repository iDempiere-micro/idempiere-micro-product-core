package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_A_Asset_Change;
import org.compiere.orm.PO;

import java.util.Properties;

/**
 * Generated Model for A_Asset_Change
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_A_Asset_Change extends PO implements I_A_Asset_Change {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_A_Asset_Change(Properties ctx, int A_Asset_Change_ID) {
        super(ctx, A_Asset_Change_ID);
        /**
         * if (A_Asset_Change_ID == 0) { setA_Asset_Change_ID (0); setA_Asset_ID (0); setAssetValueAmt
         * (Env.ZERO); // 0 setChangeType (null); setTextDetails (null); }
         */
    }

    /**
     * Load Constructor
     */
    public X_A_Asset_Change(Properties ctx, Row row) {
        super(ctx, row);
    }

    /**
     * AccessLevel
     *
     * @return 7 - System - Client - Org
     */
    protected int getAccessLevel() {
        return accessLevel.intValue();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("X_A_Asset_Change[").append(getId()).append("]");
        return sb.toString();
    }

    @Override
    public int getTableId() {
        return I_A_Asset_Change.Table_ID;
    }
}
