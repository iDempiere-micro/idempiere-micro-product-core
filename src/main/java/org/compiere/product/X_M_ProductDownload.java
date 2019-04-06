package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_ProductDownload;
import org.compiere.orm.BasePOName;

/**
 * Generated Model for M_ProductDownload
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ProductDownload extends BasePOName implements I_M_ProductDownload {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_ProductDownload(int M_ProductDownload_ID) {
        super(M_ProductDownload_ID);
        /**
         * if (M_ProductDownload_ID == 0) { setDownloadURL (null); setProductDownload_ID (0);
         * setProductId (0); setName (null); }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_ProductDownload(Row row) {
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
        StringBuffer sb = new StringBuffer("X_M_ProductDownload[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Get Download URL.
     *
     * @return URL of the Download files
     */
    public String getDownloadURL() {
        return (String) getValue(COLUMNNAME_DownloadURL);
    }

    /**
     * Get Product.
     *
     * @return Product, Service, Item
     */
    public int getProductId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Product_ID);
        if (ii == null) return 0;
        return ii;
    }

    @Override
    public int getTableId() {
        return I_M_ProductDownload.Table_ID;
    }
}
