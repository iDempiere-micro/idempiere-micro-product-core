package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_Lot;
import org.compiere.orm.BasePOName;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_Lot
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Lot extends BasePOName implements I_M_Lot, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_Lot(Properties ctx, int M_Lot_ID) {
    super(ctx, M_Lot_ID);
  }

  /** Load Constructor */
  public X_M_Lot(Properties ctx, ResultSet rs) {
    super(ctx, rs);
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
    StringBuffer sb = new StringBuffer("X_M_Lot[").append(getId()).append("]");
    return sb.toString();
  }

    /**
   * Get Lot Control.
   *
   * @return Product Lot Control
   */
  public int getM_LotCtl_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_LotCtl_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Lot Control.
   *
   * @param M_LotCtl_ID Product Lot Control
   */
  public void setM_LotCtl_ID(int M_LotCtl_ID) {
    if (M_LotCtl_ID < 1) set_ValueNoCheck(COLUMNNAME_M_LotCtl_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_LotCtl_ID, Integer.valueOf(M_LotCtl_ID));
  }

  /**
   * Get Lot.
   *
   * @return Product Lot Definition
   */
  public int getM_Lot_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Lot_ID);
    if (ii == null) return 0;
    return ii;
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

  /**
   * Set Product.
   *
   * @param M_Product_ID Product, Service, Item
   */
  public void setM_Product_ID(int M_Product_ID) {
    if (M_Product_ID < 1) set_ValueNoCheck(COLUMNNAME_M_Product_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
  }

  @Override
  public int getTableId() {
    return I_M_Lot.Table_ID;
  }
}
