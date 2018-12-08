package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Discount Schema Line (Price List) Model
 *
 * @author Jorg Janke
 * @version $Id: MDiscountSchemaLine.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 */
public class MDiscountSchemaLine extends X_M_DiscountSchemaLine {

  /** */
  private static final long serialVersionUID = 1632154004024021493L;

  /**
   * Standard Constructor
   *
   * @param ctx context
   * @param M_DiscountSchemaLine_ID id
   * @param trxName transaction
   */
  public MDiscountSchemaLine(Properties ctx, int M_DiscountSchemaLine_ID, String trxName) {
    super(ctx, M_DiscountSchemaLine_ID, trxName);
  } //	MDiscountSchemaLine

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   * @param trxName transaction
   */
  public MDiscountSchemaLine(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  } //	MDiscountSchemaLine
} //	MDiscountSchemaLine
