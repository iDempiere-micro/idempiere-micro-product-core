package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_LotCtlExclude;
import org.compiere.orm.PO;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_LotCtlExclude
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_LotCtlExclude extends PO implements I_M_LotCtlExclude, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_LotCtlExclude(Properties ctx, int M_LotCtlExclude_ID, String trxName) {
    super(ctx, M_LotCtlExclude_ID, trxName);
    /**
     * if (M_LotCtlExclude_ID == 0) { setAD_Table_ID (0); setIsSOTrx (false); setM_LotCtlExclude_ID
     * (0); setM_LotCtl_ID (0); }
     */
  }

  /** Load Constructor */
  public X_M_LotCtlExclude(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_LotCtlExclude[").append(getId()).append("]");
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
   * Get Lot Control.
   *
   * @return Product Lot Control
   */
  public int getM_LotCtl_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_LotCtl_ID);
    if (ii == null) return 0;
    return ii;
  }

    @Override
  public int getTableId() {
    return I_M_LotCtlExclude.Table_ID;
  }
}
