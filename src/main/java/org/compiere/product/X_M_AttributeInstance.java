package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_AttributeInstance;
import org.compiere.model.I_M_AttributeSetInstance;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_AttributeInstance
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeInstance extends PO implements I_M_AttributeInstance, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_AttributeInstance(Properties ctx, int M_AttributeInstance_ID, String trxName) {
    super(ctx, M_AttributeInstance_ID, trxName);
    /**
     * if (M_AttributeInstance_ID == 0) { setMAttributeID (0); setM_AttributeSetInstance_ID (0); }
     */
  }

  /** Load Constructor */
  public X_M_AttributeInstance(Properties ctx, ResultSet rs, String trxName) {
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
    return "X_M_AttributeInstance[" + getId() + "]";
  }

  public org.compiere.model.I_M_Attribute getMAttribute() throws RuntimeException {
    return (org.compiere.model.I_M_Attribute)
        MTable.get(getCtx(), org.compiere.model.I_M_Attribute.Table_Name)
            .getPO(getMAttribute_ID(), null);
  }

  /**
   * Set Attribute.
   *
   * @param M_Attribute_ID Product Attribute
   */
  public void setMAttributeID(int M_Attribute_ID) {
    if (M_Attribute_ID < 1) set_ValueNoCheck(COLUMNNAME_M_Attribute_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_Attribute_ID, Integer.valueOf(M_Attribute_ID));
  }

  /**
   * Get Attribute.
   *
   * @return Product Attribute
   */
  public int getMAttribute_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Attribute_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set M_AttributeInstance_UU.
   *
   * @param M_AttributeInstance_UU M_AttributeInstance_UU
   */
  public void setM_AttributeInstance_UU(String M_AttributeInstance_UU) {
    set_Value(COLUMNNAME_M_AttributeInstance_UU, M_AttributeInstance_UU);
  }

  /**
   * Get M_AttributeInstance_UU.
   *
   * @return M_AttributeInstance_UU
   */
  public String getMAttributeInstance_UU() {
    return (String) get_Value(COLUMNNAME_M_AttributeInstance_UU);
  }

  public I_M_AttributeSetInstance getMAttributeSetInstance() throws RuntimeException {
    return (I_M_AttributeSetInstance)
        MTable.get(getCtx(), I_M_AttributeSetInstance.Table_Name)
            .getPO(getMAttributeSetInstance_ID(), null);
  }

  /**
   * Set Attribute Set Instance.
   *
   * @param M_AttributeSetInstance_ID Product Attribute Set Instance
   */
  public void setM_AttributeSetInstance_ID(int M_AttributeSetInstance_ID) {
    if (M_AttributeSetInstance_ID < 0) set_ValueNoCheck(COLUMNNAME_M_AttributeSetInstance_ID, null);
    else
      set_ValueNoCheck(
          COLUMNNAME_M_AttributeSetInstance_ID, Integer.valueOf(M_AttributeSetInstance_ID));
  }

  /**
   * Get Attribute Set Instance.
   *
   * @return Product Attribute Set Instance
   */
  public int getMAttributeSetInstance_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_AttributeSetInstance_ID);
    if (ii == null) return 0;
    return ii;
  }

  public org.compiere.model.I_M_AttributeValue getMAttributeValue() throws RuntimeException {
    return (org.compiere.model.I_M_AttributeValue)
        MTable.get(getCtx(), org.compiere.model.I_M_AttributeValue.Table_Name)
            .getPO(getMAttributeValue_ID(), null);
  }

  /**
   * Set Attribute Value.
   *
   * @param M_AttributeValue_ID Product Attribute Value
   */
  public void setM_AttributeValue_ID(int M_AttributeValue_ID) {
    if (M_AttributeValue_ID < 1) set_Value(COLUMNNAME_M_AttributeValue_ID, null);
    else set_Value(COLUMNNAME_M_AttributeValue_ID, Integer.valueOf(M_AttributeValue_ID));
  }

  /**
   * Get Attribute Value.
   *
   * @return Product Attribute Value
   */
  public int getMAttributeValue_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_AttributeValue_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), String.valueOf(getMAttributeValue_ID()));
  }

  /**
   * Get Search Key.
   *
   * @return Search key for the record in the format required - must be unique
   */
  public String getValue() {
    return (String) get_Value(COLUMNNAME_Value);
  }

  /**
   * Set Search Key.
   *
   * @param Value Search key for the record in the format required - must be unique
   */
  public void setValue(String Value) {
    set_Value(COLUMNNAME_Value, Value);
  }

  /**
   * Get Value.
   *
   * @return Numeric Value
   */
  public BigDecimal getValueNumber() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_ValueNumber);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Value.
   *
   * @param ValueNumber Numeric Value
   */
  public void setValueNumber(BigDecimal ValueNumber) {
    set_Value(COLUMNNAME_ValueNumber, ValueNumber);
  }

  @Override
  public int getTableId() {
    return I_M_AttributeInstance.Table_ID;
  }
}
