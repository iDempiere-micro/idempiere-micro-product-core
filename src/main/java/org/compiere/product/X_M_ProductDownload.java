package org.compiere.product;

import org.compiere.model.I_M_ProductDownload;
import org.compiere.orm.BasePOName;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Generated Model for M_ProductDownload
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_ProductDownload extends BasePOName implements I_M_ProductDownload, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_ProductDownload(Properties ctx, int M_ProductDownload_ID, String trxName) {
    super(ctx, M_ProductDownload_ID, trxName);
    /**
     * if (M_ProductDownload_ID == 0) { setDownloadURL (null); setM_ProductDownload_ID (0);
     * setM_Product_ID (0); setName (null); }
     */
  }

  /** Load Constructor */
  public X_M_ProductDownload(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
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
   * Set Download URL.
   *
   * @param DownloadURL URL of the Download files
   */
  public void setDownloadURL(String DownloadURL) {
    set_Value(COLUMNNAME_DownloadURL, DownloadURL);
  }

  /**
   * Get Download URL.
   *
   * @return URL of the Download files
   */
  public String getDownloadURL() {
    return (String) get_Value(COLUMNNAME_DownloadURL);
  }

  /**
   * Set Product Download.
   *
   * @param M_ProductDownload_ID Product downloads
   */
  public void setM_ProductDownload_ID(int M_ProductDownload_ID) {
    if (M_ProductDownload_ID < 1) set_ValueNoCheck(COLUMNNAME_M_ProductDownload_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_ProductDownload_ID, Integer.valueOf(M_ProductDownload_ID));
  }

  /**
   * Get Product Download.
   *
   * @return Product downloads
   */
  public int getM_ProductDownload_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_ProductDownload_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set M_ProductDownload_UU.
   *
   * @param M_ProductDownload_UU M_ProductDownload_UU
   */
  public void setM_ProductDownload_UU(String M_ProductDownload_UU) {
    set_Value(COLUMNNAME_M_ProductDownload_UU, M_ProductDownload_UU);
  }

  /**
   * Get M_ProductDownload_UU.
   *
   * @return M_ProductDownload_UU
   */
  public String getM_ProductDownload_UU() {
    return (String) get_Value(COLUMNNAME_M_ProductDownload_UU);
  }

  public org.compiere.model.I_M_Product getM_Product() throws RuntimeException {
    return (org.compiere.model.I_M_Product)
        MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
            .getPO(getM_Product_ID(), get_TrxName());
  }

  /**
   * Set Product.
   *
   * @param M_Product_ID Product, Service, Item
   */
  public void setM_Product_ID(int M_Product_ID) {
    if (M_Product_ID < 1) set_ValueNoCheck(COLUMNNAME_M_Product_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
  }

  /**
   * Get Product.
   *
   * @return Product, Service, Item
   */
  public int getM_Product_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Product_ID);
    if (ii == null) return 0;
    return ii;
  }

  @Override
  public int getTableId() {
    return I_M_ProductDownload.Table_ID;
  }
}
