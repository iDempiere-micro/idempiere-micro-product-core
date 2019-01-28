package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_SerNoCtlExclude;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_SerNoCtlExclude
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_SerNoCtlExclude extends PO implements I_M_SerNoCtlExclude, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_SerNoCtlExclude(Properties ctx, int M_SerNoCtlExclude_ID, String trxName) {
    super(ctx, M_SerNoCtlExclude_ID, trxName);
    /**
     * if (M_SerNoCtlExclude_ID == 0) { setAD_Table_ID (0); setIsSOTrx (false);
     * setM_SerNoCtlExclude_ID (0); setM_SerNoCtl_ID (0); }
     */
  }

  /** Load Constructor */
  public X_M_SerNoCtlExclude(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
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
  public int getAD_Table_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_AD_Table_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Sales Transaction.
   *
   * @return This is a Sales Transaction
   */
  public boolean isSOTrx() {
    Object oo = get_Value(COLUMNNAME_IsSOTrx);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

    /**
   * Get Serial No Control.
   *
   * @return Product Serial Number Control
   */
  public int getM_SerNoCtl_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_SerNoCtl_ID);
    if (ii == null) return 0;
    return ii;
  }

    @Override
  public int getTableId() {
    return I_M_SerNoCtlExclude.Table_ID;
  }
}
