package org.compiere.product;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.I_S_ResourceType;
import org.compiere.orm.BasePONameValue;
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
  public X_S_ResourceType(Properties ctx, int S_ResourceType_ID) {
    super(ctx, S_ResourceType_ID);
    /**
     * if (S_ResourceType_ID == 0) { setAllowUoMFractions (false); // N setC_TaxCategory_ID (0);
     * setC_UOM_ID (0); setIsDateSlot (false); setIsSingleAssignment (false); setIsTimeSlot (false);
     * setM_Product_Category_ID (0); setName (null); setOnFriday (true); // Y setOnMonday (true); //
     * Y setOnSaturday (false); setOnSunday (false); setOnThursday (true); // Y setOnTuesday (true);
     * // Y setOnWednesday (true); // Y setS_ResourceType_ID (0); setValue (null); }
     */
  }

  /** Load Constructor */
  public X_S_ResourceType(Properties ctx, ResultSet rs) {
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
    StringBuffer sb = new StringBuffer("X_S_ResourceType[").append(getId()).append("]");
    return sb.toString();
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
   * Get Slot End.
   *
   * @return Time when timeslot ends
   */
  public Timestamp getTimeSlotEnd() {
    return (Timestamp) get_Value(COLUMNNAME_TimeSlotEnd);
  }

    /**
   * Get Slot Start.
   *
   * @return Time when timeslot starts
   */
  public Timestamp getTimeSlotStart() {
    return (Timestamp) get_Value(COLUMNNAME_TimeSlotStart);
  }

    @Override
  public int getTableId() {
    return I_S_ResourceType.Table_ID;
  }
}
