package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_C_UOM;
import org.compiere.orm.BasePOName;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for C_UOM
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_C_UOM extends BasePOName implements I_C_UOM, I_Persistent {

  /** UOMType AD_Reference_ID=53323 */
  public static final int UOMTYPE_AD_Reference_ID = 53323;
  /** Angle = AN */
  public static final String UOMTYPE_Angle = "AN";
  /** Area = AR */
  public static final String UOMTYPE_Area = "AR";
  /** Data Storage = DS */
  public static final String UOMTYPE_DataStorage = "DS";
  /** Density = DE */
  public static final String UOMTYPE_Density = "DE";
  /** Energy = EN */
  public static final String UOMTYPE_Energy = "EN";
  /** Force = FO */
  public static final String UOMTYPE_Force = "FO";
  /** Kitchen Measures = KI */
  public static final String UOMTYPE_KitchenMeasures = "KI";
  /** Length = LE */
  public static final String UOMTYPE_Length = "LE";
  /** Power = PO */
  public static final String UOMTYPE_Power = "PO";
  /** Pressure = PR */
  public static final String UOMTYPE_Pressure = "PR";
  /** Temperature = TE */
  public static final String UOMTYPE_Temperature = "TE";
  /** Time = TM */
  public static final String UOMTYPE_Time = "TM";
  /** Torque = TO */
  public static final String UOMTYPE_Torque = "TO";
  /** Velocity = VE */
  public static final String UOMTYPE_Velocity = "VE";
  /** Volume Liquid = VL */
  public static final String UOMTYPE_VolumeLiquid = "VL";
  /** Volume Dry = VD */
  public static final String UOMTYPE_VolumeDry = "VD";
  /** Weight = WE */
  public static final String UOMTYPE_Weight = "WE";
  /** Currency = CU */
  public static final String UOMTYPE_Currency = "CU";
  /** Data Speed = DV */
  public static final String UOMTYPE_DataSpeed = "DV";
  /** Frequency = FR */
  public static final String UOMTYPE_Frequency = "FR";
  /** Other = OT */
  public static final String UOMTYPE_Other = "OT";
  /** */
  private static final long serialVersionUID = 20171031L;
  /** Standard Constructor */
  public X_C_UOM(Properties ctx, int C_UOM_ID, String trxName) {
    super(ctx, C_UOM_ID, trxName);
  }
  /** Load Constructor */
  public X_C_UOM(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_C_UOM[").append(getId()).append("]");
    return sb.toString();
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
   * Get UOM.
   *
   * @return Unit of Measure
   */
  public int getC_UOM_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_UOM_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set UOM.
   *
   * @param C_UOM_ID Unit of Measure
   */
  public void setC_UOM_ID(int C_UOM_ID) {
    if (C_UOM_ID < 1) set_ValueNoCheck(COLUMNNAME_C_UOM_ID, null);
    else set_ValueNoCheck(COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
  }

  /**
   * Get C_UOM_UU.
   *
   * @return C_UOM_UU
   */
  public String getC_UOM_UU() {
    return (String) get_Value(COLUMNNAME_C_UOM_UU);
  }

  /**
   * Set C_UOM_UU.
   *
   * @param C_UOM_UU C_UOM_UU
   */
  public void setC_UOM_UU(String C_UOM_UU) {
    set_Value(COLUMNNAME_C_UOM_UU, C_UOM_UU);
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
   * Set Default.
   *
   * @param IsDefault Default value
   */
  public void setIsDefault(boolean IsDefault) {
    set_Value(COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
  }

  /**
   * Get Default.
   *
   * @return Default value
   */
  public boolean isDefault() {
    Object oo = get_Value(COLUMNNAME_IsDefault);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
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

  /**
   * Get Symbol.
   *
   * @return Symbol for a Unit of Measure
   */
  public String getUOMSymbol() {
    return (String) get_Value(COLUMNNAME_UOMSymbol);
  }

  /**
   * Set Symbol.
   *
   * @param UOMSymbol Symbol for a Unit of Measure
   */
  public void setUOMSymbol(String UOMSymbol) {
    set_Value(COLUMNNAME_UOMSymbol, UOMSymbol);
  }

  /**
   * Get UOM Type.
   *
   * @return UOM Type
   */
  public String getUOMType() {
    return (String) get_Value(COLUMNNAME_UOMType);
  }

  /**
   * Set UOM Type.
   *
   * @param UOMType UOM Type
   */
  public void setUOMType(String UOMType) {

    set_Value(COLUMNNAME_UOMType, UOMType);
  }

  /**
   * Get UOM Code.
   *
   * @return UOM EDI X12 Code
   */
  public String getX12DE355() {
    return (String) get_Value(COLUMNNAME_X12DE355);
  }

  /**
   * Set UOM Code.
   *
   * @param X12DE355 UOM EDI X12 Code
   */
  public void setX12DE355(String X12DE355) {
    set_Value(COLUMNNAME_X12DE355, X12DE355);
  }

  @Override
  public int getTableId() {
    return I_C_UOM.Table_ID;
  }
}
