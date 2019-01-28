package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_M_Product_Category;
import org.compiere.orm.BasePONameValue;
import org.compiere.orm.MTable;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_Product_Category
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Product_Category extends BasePONameValue
    implements I_M_Product_Category, I_Persistent {

  /** MMPolicy AD_Reference_ID=335 */
  public static final int MMPOLICY_AD_Reference_ID = 335;
  /** LiFo = L */
  public static final String MMPOLICY_LiFo = "L";
  /** FiFo = F */
  public static final String MMPOLICY_FiFo = "F";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_Product_Category(Properties ctx, int M_Product_Category_ID, String trxName) {
    super(ctx, M_Product_Category_ID, trxName);
  }

  /** Load Constructor */
  public X_M_Product_Category(Properties ctx, ResultSet rs, String trxName) {
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
    StringBuffer sb = new StringBuffer("X_M_Product_Category[").append(getId()).append("]");
    return sb.toString();
  }

  public org.compiere.model.I_A_Asset_Group getA_Asset_Group() throws RuntimeException {
    return (org.compiere.model.I_A_Asset_Group)
        MTable.get(getCtx(), org.compiere.model.I_A_Asset_Group.Table_Name)
            .getPO(getA_Asset_Group_ID(), null);
  }

  /**
   * Get Asset Group.
   *
   * @return Group of Assets
   */
  public int getA_Asset_Group_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_A_Asset_Group_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Print Color.
   *
   * @return Color used for printing and display
   */
  public int getAD_PrintColor_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_AD_PrintColor_ID);
    if (ii == null) return 0;
    return ii;
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
   * Set Self-Service.
   *
   * @param IsSelfService This is a Self-Service entry or this entry can be changed via Self-Service
   */
  public void setIsSelfService(boolean IsSelfService) {
    set_Value(COLUMNNAME_IsSelfService, Boolean.valueOf(IsSelfService));
  }

    /**
   * Get Material Policy.
   *
   * @return Material Movement Policy
   */
  public String getMMPolicy() {
    return (String) get_Value(COLUMNNAME_MMPolicy);
  }

  /**
   * Set Material Policy.
   *
   * @param MMPolicy Material Movement Policy
   */
  public void setMMPolicy(String MMPolicy) {

    set_Value(COLUMNNAME_MMPolicy, MMPolicy);
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
   * Get Parent Product Category.
   *
   * @return Parent Product Category
   */
  public int getM_Product_Category_Parent_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Product_Category_Parent_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Planned Margin %.
   *
   * @return Project's planned margin as a percentage
   */
  public BigDecimal getPlannedMargin() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PlannedMargin);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Planned Margin %.
   *
   * @param PlannedMargin Project's planned margin as a percentage
   */
  public void setPlannedMargin(BigDecimal PlannedMargin) {
    set_Value(COLUMNNAME_PlannedMargin, PlannedMargin);
  }

  @Override
  public int getTableId() {
    return I_M_Product_Category.Table_ID;
  }
}
