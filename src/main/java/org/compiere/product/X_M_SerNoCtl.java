package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_SerNoCtl;
import org.compiere.orm.BasePOName;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_SerNoCtl
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_SerNoCtl extends BasePOName implements I_M_SerNoCtl, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_SerNoCtl(Properties ctx, int M_SerNoCtl_ID) {
    super(ctx, M_SerNoCtl_ID);
    /**
     * if (M_SerNoCtl_ID == 0) { setCurrentNext (0); // 100 setIncrementNo (0); // 1
     * setM_SerNoCtl_ID (0); setName (null); setStartNo (0); // 100 }
     */
  }

  /** Load Constructor */
  public X_M_SerNoCtl(Properties ctx, ResultSet rs) {
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
    StringBuffer sb = new StringBuffer("X_M_SerNoCtl[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Get Current Next.
   *
   * @return The next number to be used
   */
  public int getCurrentNext() {
    Integer ii = (Integer) get_Value(COLUMNNAME_CurrentNext);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Current Next.
   *
   * @param CurrentNext The next number to be used
   */
  public void setCurrentNext(int CurrentNext) {
    set_Value(COLUMNNAME_CurrentNext, Integer.valueOf(CurrentNext));
  }

    /**
   * Get Increment.
   *
   * @return The number to increment the last document number by
   */
  public int getIncrementNo() {
    Integer ii = (Integer) get_Value(COLUMNNAME_IncrementNo);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Increment.
   *
   * @param IncrementNo The number to increment the last document number by
   */
  public void setIncrementNo(int IncrementNo) {
    set_Value(COLUMNNAME_IncrementNo, Integer.valueOf(IncrementNo));
  }

    /**
   * Get Prefix.
   *
   * @return Prefix before the sequence number
   */
  public String getPrefix() {
    return (String) get_Value(COLUMNNAME_Prefix);
  }

    /**
   * Set Start No.
   *
   * @param StartNo Starting number/position
   */
  public void setStartNo(int StartNo) {
    set_Value(COLUMNNAME_StartNo, Integer.valueOf(StartNo));
  }

  /**
   * Get Suffix.
   *
   * @return Suffix after the number
   */
  public String getSuffix() {
    return (String) get_Value(COLUMNNAME_Suffix);
  }

    @Override
  public int getTableId() {
    return I_M_SerNoCtl.Table_ID;
  }
}
