package org.compiere.product;

import kotliquery.Row;

/**
 * Product Download Model
 *
 * @author Jorg Janke
 * @author Michael Judd BF [ 2736995 ] - toURL() in java.io.File has been deprecated
 * @version $Id: MProductDownload.java,v 1.2 2006/07/30 00:51:03 jjanke Exp $
 */
public class MProductDownload extends X_M_ProductDownload {
    /**
     *
     */
    private static final long serialVersionUID = -2388247976802030211L;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param ctx                  context
     * @param M_ProductDownload_ID id
     * @param trxName              trx
     */
    public MProductDownload(int M_ProductDownload_ID) {
        super(M_ProductDownload_ID);
        if (M_ProductDownload_ID == 0) {
            //	setProductId (0);
            //	setName (null);
            //	setDownloadURL (null);
        }
    } //	MProductDownload

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName trx
     */
    public MProductDownload(Row row) {
        super(row);
    } //	MProductDownload

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        StringBuffer sb =
                new StringBuffer("MProductDownload[")
                        .append(getId())
                        .append(",M_Product_ID=")
                        .append(getProductId())
                        .append(",")
                        .append(getDownloadURL())
                        .append("]");
        return sb.toString();
    } //	toString

} //	MProductDownload
