package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_I_Product;
import org.compiere.orm.BasePONameValue;
import org.idempiere.common.util.Env;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for I_Product
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_I_Product extends BasePONameValue implements I_I_Product, I_Persistent {

  /** ProductType AD_Reference_ID=270 */
  public static final int PRODUCTTYPE_AD_Reference_ID = 270;
  /** Item = I */
  public static final String PRODUCTTYPE_Item = "I";
  /** Service = S */
  public static final String PRODUCTTYPE_Service = "S";
  /** Resource = R */
  public static final String PRODUCTTYPE_Resource = "R";
  /** Expense type = E */
  public static final String PRODUCTTYPE_ExpenseType = "E";
  /** Online = O */
  public static final String PRODUCTTYPE_Online = "O";
  /** Asset = A */
  public static final String PRODUCTTYPE_Asset = "A";
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_I_Product(Properties ctx, int I_Product_ID, String trxName) {
    super(ctx, I_Product_ID, trxName);
    /** if (I_Product_ID == 0) { setI_IsImported (false); setI_Product_ID (0); } */
  }

  /** Load Constructor */
  public X_I_Product(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 2 - Client
   */
  protected int getAccessLevel() {
    return accessLevel.intValue();
  }

  public String toString() {
    return "X_I_Product[" + getId() + "]";
  }

    /**
   * Get Business Partner .
   *
   * @return Identifies a Business Partner
   */
  public int getC_BPartner_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_BPartner_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Currency.
   *
   * @return The Currency for this record
   */
  public int getC_Currency_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_C_Currency_ID);
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
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(COLUMNNAME_Description);
  }

    /**
   * Get Description URL.
   *
   * @return URL for the description
   */
  public String getDescriptionURL() {
    return (String) get_Value(COLUMNNAME_DescriptionURL);
  }

    /**
   * Get Document Note.
   *
   * @return Additional information for a Document
   */
  public String getDocumentNote() {
    return (String) get_Value(COLUMNNAME_DocumentNote);
  }

    /**
   * Get Comment/Help.
   *
   * @return Comment or Hint
   */
  public String getHelp() {
    return (String) get_Value(COLUMNNAME_Help);
  }

    /**
   * Get Image URL.
   *
   * @return URL of image
   */
  public String getImageURL() {
    return (String) get_Value(COLUMNNAME_ImageURL);
  }

    /**
   * Get Import Product.
   *
   * @return Import Item or Service
   */
  public int getI_Product_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_I_Product_ID);
    if (ii == null) return 0;
    return ii;
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
   * Get Product.
   *
   * @return Product, Service, Item
   */
  public int getM_Product_ID() {
    Integer ii = (Integer) get_Value(COLUMNNAME_M_Product_ID);
    if (ii == null) return 0;
    return ii;
  }

    /**
   * Get Limit Price.
   *
   * @return Lowest price for a product
   */
  public BigDecimal getPriceLimit() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PriceLimit);
    if (bd == null) return Env.ZERO;
    return bd;
  }

    /**
   * Get List Price.
   *
   * @return List Price
   */
  public BigDecimal getPriceList() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PriceList);
    if (bd == null) return Env.ZERO;
    return bd;
  }

    /**
   * Get Standard Price.
   *
   * @return Standard Price
   */
  public BigDecimal getPriceStd() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PriceStd);
    if (bd == null) return Env.ZERO;
    return bd;
  }

    /**
   * Get Product Type.
   *
   * @return Type of product
   */
  public String getProductType() {
    return (String) get_Value(COLUMNNAME_ProductType);
  }

    /**
   * Get SKU.
   *
   * @return Stock Keeping Unit
   */
  public String getSKU() {
    return (String) get_Value(COLUMNNAME_SKU);
  }

    /**
   * Get UPC/EAN.
   *
   * @return Bar Code (Universal Product Code or its superset European Article Number)
   */
  public String getUPC() {
    return (String) get_Value(COLUMNNAME_UPC);
  }

    /**
   * Get Volume.
   *
   * @return Volume of a product
   */
  public BigDecimal getVolume() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_Volume);
    if (bd == null) return Env.ZERO;
    return bd;
  }

    /**
   * Get Weight.
   *
   * @return Weight of a product
   */
  public BigDecimal getWeight() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_Weight);
    if (bd == null) return Env.ZERO;
    return bd;
  }

    @Override
  public int getTableId() {
    return I_I_Product.Table_ID;
  }
}
