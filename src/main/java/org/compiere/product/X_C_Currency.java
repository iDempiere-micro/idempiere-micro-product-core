package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_C_Currency;
import org.compiere.orm.PO;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for C_Currency
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_Currency extends PO implements I_C_Currency, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_C_Currency(Properties ctx, int C_Currency_ID, String trxName) {
    super(ctx, C_Currency_ID, trxName);
    /**
     * if (C_Currency_ID == 0) { setC_Currency_ID (0); setCostingPrecision (0); // 4 setDescription
     * (null); setIsEMUMember (false); // N setIsEuro (false); // N setISO_Code (null);
     * setRoundOffFactor (Env.ZERO); // 1 setStdPrecision (0); // 2 }
     */
  }

  /** Load Constructor */
  public X_C_Currency(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 6 - System - Client
   */
  protected int getAccessLevel() {
    return accessLevel.intValue();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("X_C_Currency[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Get Currency.
   *
   * @return The Currency for this record
   */
  public int getC_Currency_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Currency_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Costing Precision.
   *
   * @return Rounding used costing calculations
   */
  public int getCostingPrecision() {
    Integer ii = (Integer) get_Value(COLUMNNAME_CostingPrecision);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Costing Precision.
   *
   * @param CostingPrecision Rounding used costing calculations
   */
  public void setCostingPrecision(int CostingPrecision) {
    set_Value(COLUMNNAME_CostingPrecision, Integer.valueOf(CostingPrecision));
  }

  /**
   * Get Symbol.
   *
   * @return Symbol of the currency (opt used for printing only)
   */
  public String getCurSymbol() {
    return (String) get_Value(COLUMNNAME_CurSymbol);
  }

  /**
   * Set Symbol.
   *
   * @param CurSymbol Symbol of the currency (opt used for printing only)
   */
  public void setCurSymbol(String CurSymbol) {
    set_Value(COLUMNNAME_CurSymbol, CurSymbol);
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
   * Set Description.
   *
   * @param Description Optional short description of the record
   */
  public void setDescription(String Description) {
    set_Value(COLUMNNAME_Description, Description);
  }

    /**
   * Set EMU Member.
   *
   * @param IsEMUMember This currency is member if the European Monetary Union
   */
  public void setIsEMUMember(boolean IsEMUMember) {
    set_Value(COLUMNNAME_IsEMUMember, Boolean.valueOf(IsEMUMember));
  }

    /**
   * Set The Euro Currency.
   *
   * @param IsEuro This currency is the Euro
   */
  public void setIsEuro(boolean IsEuro) {
    set_Value(COLUMNNAME_IsEuro, Boolean.valueOf(IsEuro));
  }

    /**
   * Get ISO Currency Code.
   *
   * @return Three letter ISO 4217 Code of the Currency
   */
  public String getISO_Code() {
    return (String) get_Value(COLUMNNAME_ISO_Code);
  }

  /**
   * Set ISO Currency Code.
   *
   * @param ISO_Code Three letter ISO 4217 Code of the Currency
   */
  public void setISO_Code(String ISO_Code) {
    set_Value(COLUMNNAME_ISO_Code, ISO_Code);
  }

  /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), getISO_Code());
  }

    /**
   * Get Standard Precision.
   *
   * @return Rule for rounding calculated amounts
   */
  public int getStdPrecision() {
    Integer ii = (Integer) get_Value(COLUMNNAME_StdPrecision);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Standard Precision.
   *
   * @param StdPrecision Rule for rounding calculated amounts
   */
  public void setStdPrecision(int StdPrecision) {
    set_Value(COLUMNNAME_StdPrecision, Integer.valueOf(StdPrecision));
  }

  @Override
  public int getTableId() {
    return I_C_Currency.Table_ID;
  }
}
