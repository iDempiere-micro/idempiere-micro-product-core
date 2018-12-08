package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Product Attribute Value
 *
 * @author Jorg Janke
 * @version $Id: MAttributeValue.java,v 1.3 2006/07/30 00:51:02 jjanke Exp $
 */
public class MAttributeValue extends X_M_AttributeValue {
  /** */
  private static final long serialVersionUID = 4105427429027399512L;

  /**
   * Constructor
   *
   * @param ctx context
   * @param M_AttributeValue_ID id
   * @param trxName transaction
   */
  public MAttributeValue(Properties ctx, int M_AttributeValue_ID, String trxName) {
    super(ctx, M_AttributeValue_ID, trxName);
    /**
     * if (M_AttributeValue_ID == 0) { setM_AttributeValue_ID (0); setMAttributeID (0); setName
     * (null); setValue (null); }
     */
  } //	MAttributeValue

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   * @param trxName transaction
   */
  public MAttributeValue(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  } //	MAttributeValue

  /**
   * String Representation
   *
   * @return info
   */
  public String toString() {
    return getName();
  } //	toString
} //	MAttributeValue
