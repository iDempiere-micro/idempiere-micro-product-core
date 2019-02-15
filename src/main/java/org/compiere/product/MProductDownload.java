package org.compiere.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import org.idempiere.common.util.CLogger;

/**
 * Product Download Model
 *
 * @author Jorg Janke
 * @author Michael Judd BF [ 2736995 ] - toURL() in java.io.File has been deprecated
 * @version $Id: MProductDownload.java,v 1.2 2006/07/30 00:51:03 jjanke Exp $
 */
public class MProductDownload extends X_M_ProductDownload {
  /** */
  private static final long serialVersionUID = -2388247976802030211L;

    /**
   * ************************************************************************ Standard Constructor
   *
   * @param ctx context
   * @param M_ProductDownload_ID id
   * @param trxName trx
   */
  public MProductDownload(Properties ctx, int M_ProductDownload_ID) {
    super(ctx, M_ProductDownload_ID);
    if (M_ProductDownload_ID == 0) {
      //	setM_Product_ID (0);
      //	setName (null);
      //	setDownloadURL (null);
    }
  } //	MProductDownload

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   * @param trxName trx
   */
  public MProductDownload(Properties ctx, ResultSet rs) {
    super(ctx, rs);
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
            .append(getM_Product_ID())
            .append(",")
            .append(getDownloadURL())
            .append("]");
    return sb.toString();
  } //	toString

    /**
   * Find download url
   *
   * @param directory optional directory
   * @return file or null
   */
  public File getDownloadFile(String directory) {
    File file = new File(getDownloadURL()); // 	absolute file
    if (file.exists()) return file;
    if (directory == null || directory.length() == 0) {
      log.log(Level.SEVERE, "Not found " + getDownloadURL());
      return null;
    }
    String downloadURL2 = directory;
    if (!downloadURL2.endsWith(File.separator)) downloadURL2 += File.separator;
    downloadURL2 += getDownloadURL();
    file = new File(downloadURL2);
    if (file.exists()) return file;

    log.log(Level.SEVERE, "Not found " + getDownloadURL() + " + " + downloadURL2);
    return null;
  } //	getDownloadFile

} //	MProductDownload
