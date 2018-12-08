package org.compiere.product;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.I_S_ResourceType;
import org.compiere.orm.BasePONameValue;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for S_ResourceType
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_S_ResourceType extends BasePONameValue implements I_S_ResourceType, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_S_ResourceType(Properties ctx, int S_ResourceType_ID, String trxName) {
    super(ctx, S_ResourceType_ID, trxName);
    /**
     * if (S_ResourceType_ID == 0) { setAllowUoMFractions (false); // N setC_TaxCategory_ID (0);
     * setC_UOM_ID (0); setIsDateSlot (false); setIsSingleAssignment (false); setIsTimeSlot (false);
     * setM_Product_Category_ID (0); setName (null); setOnFriday (true); // Y setOnMonday (true); //
     * Y setOnSaturday (false); setOnSunday (false); setOnThursday (true); // Y setOnTuesday (true);
     * // Y setOnWednesday (true); // Y setS_ResourceType_ID (0); setValue (null); }
     */
  }

  /** Load Constructor */
  public X_S_ResourceType(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_S_ResourceType[").append(getId()).append("]");
    return sb.toString();
  }

  /**
   * Get Allow UoM Fractions.
   *
   * @return Allow Unit of Measure Fractions
   */
  public boolean isAllowUoMFractions() {
    Object oo = get_Value(COLUMNNAME_AllowUoMFractions);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Allow UoM Fractions.
   *
   * @param AllowUoMFractions Allow Unit of Measure Fractions
   */
  public void setAllowUoMFractions(boolean AllowUoMFractions) {
    set_Value(COLUMNNAME_AllowUoMFractions, Boolean.valueOf(AllowUoMFractions));
  }

  /**
   * Get Chargeable Quantity.
   *
   * @return Chargeable Quantity
   */
  public int getChargeableQty() {
    Integer ii = (Integer) get_Value(COLUMNNAME_ChargeableQty);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Chargeable Quantity.
   *
   * @param ChargeableQty Chargeable Quantity
   */
  public void setChargeableQty(int ChargeableQty) {
    set_Value(COLUMNNAME_ChargeableQty, Integer.valueOf(ChargeableQty));
  }

  public org.compiere.model.I_C_TaxCategory getC_TaxCategory() throws RuntimeException {
    return (org.compiere.model.I_C_TaxCategory)
        MTable.get(getCtx(), org.compiere.model.I_C_TaxCategory.Table_Name)
            .getPO(getC_TaxCategory_ID(), get_TrxName());
  }

  /**
   * Get Tax Category.
   *
   * @return Tax Category
   */
  public int getC_TaxCategory_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_TaxCategory_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Tax Category.
   *
   * @param C_TaxCategory_ID Tax Category
   */
  public void setC_TaxCategory_ID(int C_TaxCategory_ID) {
    if (C_TaxCategory_ID < 1) set_Value(COLUMNNAME_C_TaxCategory_ID, null);
    else set_Value(COLUMNNAME_C_TaxCategory_ID, Integer.valueOf(C_TaxCategory_ID));
  }

  public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException {
    return (org.compiere.model.I_C_UOM)
        MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
            .getPO(getC_UOM_ID(), get_TrxName());
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
    if (C_UOM_ID < 1) set_Value(COLUMNNAME_C_UOM_ID, null);
    else set_Value(COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
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
   * Set Day Slot.
   *
   * @param IsDateSlot Resource has day slot availability
   */
  public void setIsDateSlot(boolean IsDateSlot) {
    set_Value(COLUMNNAME_IsDateSlot, Boolean.valueOf(IsDateSlot));
  }

  /**
   * Get Day Slot.
   *
   * @return Resource has day slot availability
   */
  public boolean isDateSlot() {
    Object oo = get_Value(COLUMNNAME_IsDateSlot);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Single Assignment only.
   *
   * @param IsSingleAssignment Only one assignment at a time (no double-booking or overlapping)
   */
  public void setIsSingleAssignment(boolean IsSingleAssignment) {
    set_Value(COLUMNNAME_IsSingleAssignment, Boolean.valueOf(IsSingleAssignment));
  }

  /**
   * Get Single Assignment only.
   *
   * @return Only one assignment at a time (no double-booking or overlapping)
   */
  public boolean isSingleAssignment() {
    Object oo = get_Value(COLUMNNAME_IsSingleAssignment);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Time Slot.
   *
   * @param IsTimeSlot Resource has time slot availability
   */
  public void setIsTimeSlot(boolean IsTimeSlot) {
    set_Value(COLUMNNAME_IsTimeSlot, Boolean.valueOf(IsTimeSlot));
  }

  /**
   * Get Time Slot.
   *
   * @return Resource has time slot availability
   */
  public boolean isTimeSlot() {
    Object oo = get_Value(COLUMNNAME_IsTimeSlot);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  public org.compiere.model.I_M_Product_Category getM_Product_Category() throws RuntimeException {
    return (org.compiere.model.I_M_Product_Category)
        MTable.get(getCtx(), org.compiere.model.I_M_Product_Category.Table_Name)
            .getPO(getM_Product_Category_ID(), get_TrxName());
  }

  /**
   * Get Product Category.
   *
   * @return Category of a Product
   */
  public int getM_Product_Category_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Product_Category_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Product Category.
   *
   * @param M_Product_Category_ID Category of a Product
   */
  public void setM_Product_Category_ID(int M_Product_Category_ID) {
    if (M_Product_Category_ID < 1) set_Value(COLUMNNAME_M_Product_Category_ID, null);
    else set_Value(COLUMNNAME_M_Product_Category_ID, Integer.valueOf(M_Product_Category_ID));
  }

  /**
   * Get Friday.
   *
   * @return Available on Fridays
   */
  public boolean isOnFriday() {
    Object oo = get_Value(COLUMNNAME_OnFriday);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Friday.
   *
   * @param OnFriday Available on Fridays
   */
  public void setOnFriday(boolean OnFriday) {
    set_Value(COLUMNNAME_OnFriday, Boolean.valueOf(OnFriday));
  }

  /**
   * Get Monday.
   *
   * @return Available on Mondays
   */
  public boolean isOnMonday() {
    Object oo = get_Value(COLUMNNAME_OnMonday);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Monday.
   *
   * @param OnMonday Available on Mondays
   */
  public void setOnMonday(boolean OnMonday) {
    set_Value(COLUMNNAME_OnMonday, Boolean.valueOf(OnMonday));
  }

  /**
   * Get Saturday.
   *
   * @return Available on Saturday
   */
  public boolean isOnSaturday() {
    Object oo = get_Value(COLUMNNAME_OnSaturday);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Saturday.
   *
   * @param OnSaturday Available on Saturday
   */
  public void setOnSaturday(boolean OnSaturday) {
    set_Value(COLUMNNAME_OnSaturday, Boolean.valueOf(OnSaturday));
  }

  /**
   * Get Sunday.
   *
   * @return Available on Sundays
   */
  public boolean isOnSunday() {
    Object oo = get_Value(COLUMNNAME_OnSunday);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Sunday.
   *
   * @param OnSunday Available on Sundays
   */
  public void setOnSunday(boolean OnSunday) {
    set_Value(COLUMNNAME_OnSunday, Boolean.valueOf(OnSunday));
  }

  /**
   * Get Thursday.
   *
   * @return Available on Thursdays
   */
  public boolean isOnThursday() {
    Object oo = get_Value(COLUMNNAME_OnThursday);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Thursday.
   *
   * @param OnThursday Available on Thursdays
   */
  public void setOnThursday(boolean OnThursday) {
    set_Value(COLUMNNAME_OnThursday, Boolean.valueOf(OnThursday));
  }

  /**
   * Get Tuesday.
   *
   * @return Available on Tuesdays
   */
  public boolean isOnTuesday() {
    Object oo = get_Value(COLUMNNAME_OnTuesday);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Tuesday.
   *
   * @param OnTuesday Available on Tuesdays
   */
  public void setOnTuesday(boolean OnTuesday) {
    set_Value(COLUMNNAME_OnTuesday, Boolean.valueOf(OnTuesday));
  }

  /**
   * Get Wednesday.
   *
   * @return Available on Wednesdays
   */
  public boolean isOnWednesday() {
    Object oo = get_Value(COLUMNNAME_OnWednesday);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Wednesday.
   *
   * @param OnWednesday Available on Wednesdays
   */
  public void setOnWednesday(boolean OnWednesday) {
    set_Value(COLUMNNAME_OnWednesday, Boolean.valueOf(OnWednesday));
  }

  /**
   * Get Resource Type.
   *
   * @return Resource Type
   */
  public int getS_ResourceType_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_S_ResourceType_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Resource Type.
   *
   * @param S_ResourceType_ID Resource Type
   */
  public void setS_ResourceType_ID(int S_ResourceType_ID) {
    if (S_ResourceType_ID < 1) set_ValueNoCheck(COLUMNNAME_S_ResourceType_ID, null);
    else set_ValueNoCheck(COLUMNNAME_S_ResourceType_ID, Integer.valueOf(S_ResourceType_ID));
  }

  /**
   * Get S_ResourceType_UU.
   *
   * @return S_ResourceType_UU
   */
  public String getS_ResourceType_UU() {
    return (String) get_Value(COLUMNNAME_S_ResourceType_UU);
  }

  /**
   * Set S_ResourceType_UU.
   *
   * @param S_ResourceType_UU S_ResourceType_UU
   */
  public void setS_ResourceType_UU(String S_ResourceType_UU) {
    set_Value(COLUMNNAME_S_ResourceType_UU, S_ResourceType_UU);
  }

  /**
   * Get Slot End.
   *
   * @return Time when timeslot ends
   */
  public Timestamp getTimeSlotEnd() {
    return (Timestamp) get_Value(COLUMNNAME_TimeSlotEnd);
  }

  /**
   * Set Slot End.
   *
   * @param TimeSlotEnd Time when timeslot ends
   */
  public void setTimeSlotEnd(Timestamp TimeSlotEnd) {
    set_Value(COLUMNNAME_TimeSlotEnd, TimeSlotEnd);
  }

  /**
   * Get Slot Start.
   *
   * @return Time when timeslot starts
   */
  public Timestamp getTimeSlotStart() {
    return (Timestamp) get_Value(COLUMNNAME_TimeSlotStart);
  }

  /**
   * Set Slot Start.
   *
   * @param TimeSlotStart Time when timeslot starts
   */
  public void setTimeSlotStart(Timestamp TimeSlotStart) {
    set_Value(COLUMNNAME_TimeSlotStart, TimeSlotStart);
  }

  @Override
  public int getTableId() {
    return I_S_ResourceType.Table_ID;
  }
}
