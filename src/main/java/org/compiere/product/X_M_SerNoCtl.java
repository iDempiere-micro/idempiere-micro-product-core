package org.compiere.product;

import org.compiere.model.I_M_SerNoCtl;
import org.compiere.orm.BasePOName;
import org.idempiere.orm.I_Persistent;

import java.sql.ResultSet;
import java.util.Properties;

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
  public X_M_SerNoCtl(Properties ctx, int M_SerNoCtl_ID, String trxName) {
    super(ctx, M_SerNoCtl_ID, trxName);
    /**
     * if (M_SerNoCtl_ID == 0) { setCurrentNext (0); // 100 setIncrementNo (0); // 1
     * setM_SerNoCtl_ID (0); setName (null); setStartNo (0); // 100 }
     */
  }

  /** Load Constructor */
  public X_M_SerNoCtl(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_SerNoCtl[").append(getId()).append("]");
    return sb.toString();
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
   * Set Description.
   *
   * @param Description Optional short description of the record
   */
  public void setDescription(String Description) {
    set_Value(COLUMNNAME_Description, Description);
  }

  /**
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
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
   * Set Serial No Control.
   *
   * @param M_SerNoCtl_ID Product Serial Number Control
   */
  public void setM_SerNoCtl_ID(int M_SerNoCtl_ID) {
    if (M_SerNoCtl_ID < 1) set_ValueNoCheck(COLUMNNAME_M_SerNoCtl_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_SerNoCtl_ID, Integer.valueOf(M_SerNoCtl_ID));
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

  /**
   * Set M_SerNoCtl_UU.
   *
   * @param M_SerNoCtl_UU M_SerNoCtl_UU
   */
  public void setM_SerNoCtl_UU(String M_SerNoCtl_UU) {
    set_Value(COLUMNNAME_M_SerNoCtl_UU, M_SerNoCtl_UU);
  }

  /**
   * Get M_SerNoCtl_UU.
   *
   * @return M_SerNoCtl_UU
   */
  public String getM_SerNoCtl_UU() {
    return (String) get_Value(COLUMNNAME_M_SerNoCtl_UU);
  }

  /**
   * Set Prefix.
   *
   * @param Prefix Prefix before the sequence number
   */
  public void setPrefix(String Prefix) {
    set_Value(COLUMNNAME_Prefix, Prefix);
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
   * Get Start No.
   *
   * @return Starting number/position
   */
  public int getStartNo() {
    Integer ii = (Integer) get_Value(COLUMNNAME_StartNo);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Suffix.
   *
   * @param Suffix Suffix after the number
   */
  public void setSuffix(String Suffix) {
    set_Value(COLUMNNAME_Suffix, Suffix);
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
