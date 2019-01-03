package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_AttributeValue;
import org.compiere.orm.BasePONameValue;
import org.compiere.orm.MTable;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_AttributeValue
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeValue extends BasePONameValue
    implements I_M_AttributeValue, I_Persistent {

  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_AttributeValue(Properties ctx, int M_AttributeValue_ID, String trxName) {
    super(ctx, M_AttributeValue_ID, trxName);
    /**
     * if (M_AttributeValue_ID == 0) { setMAttributeID (0); setM_AttributeValue_ID (0); setName
     * (null); setValue (null); }
     */
  }

  /** Load Constructor */
  public X_M_AttributeValue(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_AttributeValue[").append(getId()).append("]");
    return sb.toString();
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
   * Set Attribute Value.
   *
   * @param M_AttributeValue_ID Product Attribute Value
   */
  public void setM_AttributeValue_ID(int M_AttributeValue_ID) {
    if (M_AttributeValue_ID < 1) set_ValueNoCheck(COLUMNNAME_M_AttributeValue_ID, null);
    else set_ValueNoCheck(COLUMNNAME_M_AttributeValue_ID, Integer.valueOf(M_AttributeValue_ID));
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
   * Set M_AttributeValue_UU.
   *
   * @param M_AttributeValue_UU M_AttributeValue_UU
   */
  public void setM_AttributeValue_UU(String M_AttributeValue_UU) {
    set_Value(COLUMNNAME_M_AttributeValue_UU, M_AttributeValue_UU);
  }

  /**
   * Get M_AttributeValue_UU.
   *
   * @return M_AttributeValue_UU
   */
  public String getMAttributeValue_UU() {
    return (String) get_Value(COLUMNNAME_M_AttributeValue_UU);
  }

  @Override
  public int getTableId() {
    return I_M_AttributeValue.Table_ID;
  }
}
