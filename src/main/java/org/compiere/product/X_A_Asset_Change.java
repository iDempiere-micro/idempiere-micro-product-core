package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_A_Asset_Change;
import org.compiere.orm.PO;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for A_Asset_Change
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_A_Asset_Change extends PO implements I_A_Asset_Change, I_Persistent {

  /** A_Depreciation_Manual_Period AD_Reference_ID=53256 */
  public static final int A_DEPRECIATION_MANUAL_PERIOD_AD_Reference_ID = 53256;
  /** Period = PR */
  public static final String A_DEPRECIATION_MANUAL_PERIOD_Period = "PR";
  /** Yearly = YR */
  public static final String A_DEPRECIATION_MANUAL_PERIOD_Yearly = "YR";
  /** A_Reval_Cal_Method AD_Reference_ID=53259 */
  public static final int A_REVAL_CAL_METHOD_AD_Reference_ID = 53259;
  /** Default = DFT */
  public static final String A_REVAL_CAL_METHOD_Default = "DFT";
  /** Inception to date = IDF */
  public static final String A_REVAL_CAL_METHOD_InceptionToDate = "IDF";
  /** Year Balances = YBF */
  public static final String A_REVAL_CAL_METHOD_YearBalances = "YBF";
  /** ChangeType AD_Reference_ID=53273 */
  public static final int CHANGETYPE_AD_Reference_ID = 53273;
  /** Addition = ADD */
  public static final String CHANGETYPE_Addition = "ADD";
  /** Balance = BAL */
  public static final String CHANGETYPE_Balance = "BAL";
  /** Create = CRT */
  public static final String CHANGETYPE_Create = "CRT";
  /** Depreciation = DEP */
  public static final String CHANGETYPE_Depreciation = "DEP";
  /** Disposal = DIS */
  public static final String CHANGETYPE_Disposal = "DIS";
  /** Expense = EXP */
  public static final String CHANGETYPE_Expense = "EXP";
  /** Forecast = FOR */
  public static final String CHANGETYPE_Forecast = "FOR";
  /** Import = IMP */
  public static final String CHANGETYPE_Import = "IMP";
  /** Revaluation = RVL */
  public static final String CHANGETYPE_Revaluation = "RVL";
  /** Setup = SET */
  public static final String CHANGETYPE_Setup = "SET";
  /** Split = SPL */
  public static final String CHANGETYPE_Split = "SPL";
  /** Transfer = TRN */
  public static final String CHANGETYPE_Transfer = "TRN";
  /** Update = UPD */
  public static final String CHANGETYPE_Update = "UPD";
  /** Usage = USE */
  public static final String CHANGETYPE_Usage = "USE";
  /** PostingType AD_Reference_ID=125 */
  public static final int POSTINGTYPE_AD_Reference_ID = 125;
  /** Actual = A */
  public static final String POSTINGTYPE_Actual = "A";
  /** Budget = B */
  public static final String POSTINGTYPE_Budget = "B";
  /** Commitment = E */
  public static final String POSTINGTYPE_Commitment = "E";
  /** Statistical = S */
  public static final String POSTINGTYPE_Statistical = "S";
  /** Reservation = R */
  public static final String POSTINGTYPE_Reservation = "R";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_A_Asset_Change(Properties ctx, int A_Asset_Change_ID, String trxName) {
    super(ctx, A_Asset_Change_ID, trxName);
    /**
     * if (A_Asset_Change_ID == 0) { setA_Asset_Change_ID (0); setA_Asset_ID (0); setAssetValueAmt
     * (Env.ZERO); // 0 setChangeType (null); setTextDetails (null); }
     */
  }

  /** Load Constructor */
  public X_A_Asset_Change(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 7 - System - Client - Org
   */
  protected int getAccessLevel() {
    return accessLevel.intValue();
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("X_A_Asset_Change[").append(getId()).append("]");
    return sb.toString();
  }

    /**
   * Get Accumulated Depreciation Account.
   *
   * @return Accumulated Depreciation Account
   */
  public int getA_Accumdepreciation_Acct() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Accumdepreciation_Acct);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Asset Acct.
   *
   * @return Asset Acct
   */
  public int getA_Asset_Acct() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Asset_Acct);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get A_Asset_Change_ID.
   *
   * @return A_Asset_Change_ID
   */
  public int getA_Asset_Change_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Asset_Change_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), String.valueOf(getA_Asset_Change_ID()));
  }

    /**
   * Get Asset.
   *
   * @return Asset used internally or by customers
   */
  public int getA_Asset_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Asset_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Spread Type.
   *
   * @return Spread Type
   */
  public int getA_Asset_Spread_Type() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Asset_Spread_Type);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Depreciation Account.
   *
   * @return Depreciation Account
   */
  public int getA_Depreciation_Acct() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Depreciation_Acct);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Calculation Type.
   *
   * @return Calculation Type
   */
  public int getA_Depreciation_Calc_Type() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Depreciation_Calc_Type);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get A_Depreciation_Table_Header_ID.
   *
   * @return A_Depreciation_Table_Header_ID
   */
  public int getA_Depreciation_Table_Header_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Depreciation_Table_Header_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Loss on Disposal.
   *
   * @return Loss on Disposal
   */
  public int getA_Disposal_Loss() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Disposal_Loss);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Disposal Loss Acct.
   *
   * @return Disposal Loss Acct
   */
  public int getA_Disposal_Loss_Acct() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Disposal_Loss_Acct);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Disposal Revenue.
   *
   * @return Disposal Revenue
   */
  public int getA_Disposal_Revenue() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Disposal_Revenue);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Disposal Revenue Acct.
   *
   * @return Disposal Revenue Acct
   */
  public int getA_Disposal_Revenue_Acct() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Disposal_Revenue_Acct);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get User/Contact.
   *
   * @return User within the system - Internal or Business Partner Contact
   */
  public int getAD_User_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_AD_User_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Parent Asset.
   *
   * @return Parent Asset
   */
  public int getA_Parent_Asset_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Parent_Asset_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Accounting Schema.
   *
   * @return Rules for accounting
   */
  public int getC_AcctSchema_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_AcctSchema_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Business Partner .
   *
   * @return Identifies a Business Partner
   */
  public int getC_BPartner_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_BPartner_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Partner Location.
   *
   * @return Identifies the (ship to) address for this Business Partner
   */
  public int getC_BPartner_Location_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_BPartner_Location_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Set ChangeType.
   *
   * @param ChangeType ChangeType
   */
  public void setChangeType(String ChangeType) {

    set_ValueNoCheck(COLUMNNAME_ChangeType, ChangeType);
  }

    /**
   * Get Address.
   *
   * @return Location or Address
   */
  public int getC_Location_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Location_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get ConventionType.
   *
   * @return ConventionType
   */
  public int getConventionType() {
    Integer ii = (Integer) get_Value(COLUMNNAME_ConventionType);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Combination.
   *
   * @return Valid Account Combination
   */
  public int getC_ValidCombination_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_ValidCombination_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get DepreciationType.
   *
   * @return DepreciationType
   */
  public int getDepreciationType() {
    Integer ii = (Integer) get_Value(COLUMNNAME_DepreciationType);
    if (ii == null) return 0;
    return ii;
  }

    @Override
  public int getTableId() {
    return I_A_Asset_Change.Table_ID;
  }
}
