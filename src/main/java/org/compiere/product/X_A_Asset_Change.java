package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.AssetChange;
import org.compiere.orm.PO;

/**
 * Generated Model for A_Asset_Change
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_A_Asset_Change extends PO implements AssetChange {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_A_Asset_Change(int A_Asset_Change_ID) {
        super(A_Asset_Change_ID);
        /**
         * if (A_Asset_Change_ID == 0) { setA_Asset_Change_ID (0); setA_Asset_ID (0); setAssetValueAmt
         * (Env.ZERO); // 0 setChangeType (null); setTextDetails (null); }
         */
    }

    /**
     * Load Constructor
     */
    public X_A_Asset_Change(Row row) {
        super(row);
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
        return AssetChange.Table_ID;
    }
}
