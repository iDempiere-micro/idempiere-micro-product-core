package org.compiere.product;

import static software.hsharp.core.orm.POKt.I_ZERO;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Discount Break Schema (Model)
 *
 * @author Jorg Janke
 * @author Teo Sarca, SC ARHIPAC SERVICE SRL
 *     <li>BF [ 2012439 ] DiscountSchemaBreak: setting product & category is allowed
 * @version $Id: MDiscountSchemaBreak.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MDiscountSchemaBreak extends X_M_DiscountSchemaBreak {

  /** */
  private static final long serialVersionUID = 6413962940750128351L;

  /**
   * Standard Constructor
   *
   * @param ctx context
   * @param M_DiscountSchemaBreak_ID id
   * @param trxName transaction
   */
  public MDiscountSchemaBreak(Properties ctx, int M_DiscountSchemaBreak_ID) {
    super(ctx, M_DiscountSchemaBreak_ID);
  } //	MDiscountSchemaBreak

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   * @param trxName transaction
   */
  public MDiscountSchemaBreak(Properties ctx, ResultSet rs) {
    super(ctx, rs);
  } //	MDiscountSchemaBreak

  /**
   * Criteria apply
   *
   * @param Value amt or qty
   * @param M_Product_ID product
   * @param M_Product_Category_ID category
   * @return true if criteria met
   */
  public boolean applies(BigDecimal Value, int M_Product_ID, int M_Product_Category_ID) {
    if (!isActive()) return false;

    //	below break value
    if (Value.compareTo(getBreakValue()) < 0) return false;

    //	No Product / Category
    if (getM_Product_ID() == 0 && getM_Product_Category_ID() == 0) return true;

    //	Product
    if (getM_Product_ID() == M_Product_ID) return true;

    //	Category
    if (M_Product_Category_ID != 0) return getM_Product_Category_ID() == M_Product_Category_ID;

    //	Look up Category of Product
    return MProductCategory.isCategory(getM_Product_Category_ID(), M_Product_ID);
  } //	applies

  @Override
  protected boolean beforeSave(boolean newRecord) {
    // If M_Product_ID and M_Product_Category_ID is set, M_Product_ID has priority - teo_sarca [
    // 2012439 ]
    if (getM_Product_ID() > 0 && getM_Product_Category_ID() > 0) setM_Product_Category_ID(I_ZERO);
    //
    return true;
  }

  /**
   * String Representation
   *
   * @return info
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("MDiscountSchemaBreak[");
    sb.append(getId()).append("-Seq=").append(getSeqNo());
    if (getM_Product_Category_ID() != 0)
      sb.append(",M_Product_Category_ID=").append(getM_Product_Category_ID());
    if (getM_Product_ID() != 0) sb.append(",M_Product_ID=").append(getM_Product_ID());
    sb.append(",Break=").append(getBreakValue());
    if (isBPartnerFlatDiscount()) sb.append(",FlatDiscount");
    else sb.append(",Discount=").append(getBreakDiscount());
    sb.append("]");
    return sb.toString();
  } //	toString
} //	MDiscountSchemaBreak
