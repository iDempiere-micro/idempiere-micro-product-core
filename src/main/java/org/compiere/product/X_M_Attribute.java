package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_Attribute;
import org.compiere.orm.BasePOName;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_Attribute
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Attribute extends BasePOName implements I_M_Attribute, I_Persistent {

  /** AttributeValueType AD_Reference_ID=326 */
  public static final int ATTRIBUTEVALUETYPE_AD_Reference_ID = 326;
  /** String (max 40) = S */
  public static final String ATTRIBUTEVALUETYPE_StringMax40 = "S";
  /** Number = N */
  public static final String ATTRIBUTEVALUETYPE_Number = "N";
  /** List = L */
  public static final String ATTRIBUTEVALUETYPE_List = "L";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_Attribute(Properties ctx, int M_Attribute_ID, String trxName) {
    super(ctx, M_Attribute_ID, trxName);
  }
  /** Load Constructor */
  public X_M_Attribute(Properties ctx, ResultSet rs, String trxName) {
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
    return "X_M_Attribute[" + getId() + "]";
  }

  /**
   * Get Attribute Value Type.
   *
   * @return Type of Attribute Value
   */
  public String getAttributeValueType() {
    return (String) get_Value(COLUMNNAME_AttributeValueType);
  }

  /**
   * Set Attribute Value Type.
   *
   * @param AttributeValueType Type of Attribute Value
   */
  public void setAttributeValueType(String AttributeValueType) {

    set_Value(COLUMNNAME_AttributeValueType, AttributeValueType);
  }

    /**
   * Set Instance Attribute.
   *
   * @param IsInstanceAttribute The product attribute is specific to the instance (like Serial No,
   *     Lot or Guarantee Date)
   */
  public void setIsInstanceAttribute(boolean IsInstanceAttribute) {
    set_Value(COLUMNNAME_IsInstanceAttribute, IsInstanceAttribute);
  }

  /**
   * Get Instance Attribute.
   *
   * @return The product attribute is specific to the instance (like Serial No, Lot or Guarantee
   *     Date)
   */
  public boolean isInstanceAttribute() {
    Object oo = get_Value(COLUMNNAME_IsInstanceAttribute);
    if (oo != null) {
      if (oo instanceof Boolean) return (Boolean) oo;
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Mandatory.
   *
   * @param IsMandatory Data entry is required in this column
   */
  public void setIsMandatory(boolean IsMandatory) {
    set_Value(COLUMNNAME_IsMandatory, IsMandatory);
  }

  /**
   * Get Mandatory.
   *
   * @return Data entry is required in this column
   */
  public boolean isMandatory() {
    Object oo = get_Value(COLUMNNAME_IsMandatory);
    if (oo != null) {
      if (oo instanceof Boolean) return (Boolean) oo;
      return "Y".equals(oo);
    }
    return false;
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
   * Get Attribute Search.
   *
   * @return Common Search Attribute
   */
  public int getMAttributeSearch_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_AttributeSearch_ID);
    if (ii == null) return 0;
    return ii;
  }

    @Override
  public int getTableId() {
    return I_M_Attribute.Table_ID;
  }
}
