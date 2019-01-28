package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_AttributeValue;
import org.compiere.orm.BasePONameValue;
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
   * Get Attribute Value.
   *
   * @return Product Attribute Value
   */
  public int getMAttributeValue_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_AttributeValue_ID);
    if (ii == null) return 0;
    return ii;
  }

    @Override
  public int getTableId() {
    return I_M_AttributeValue.Table_ID;
  }
}
