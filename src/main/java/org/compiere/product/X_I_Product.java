package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.I_I_Product;
import org.compiere.orm.BasePONameValue;
import org.compiere.orm.MTable;
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
   * Get Business Partner Key.
   *
   * @return The Key of the Business Partner
   */
  public String getBPartner_Value() {
    return (String) get_Value(COLUMNNAME_BPartner_Value);
  }

  /**
   * Set Business Partner Key.
   *
   * @param BPartner_Value The Key of the Business Partner
   */
  public void setBPartner_Value(String BPartner_Value) {
    set_Value(COLUMNNAME_BPartner_Value, BPartner_Value);
  }

  public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException {
    return (org.compiere.model.I_C_BPartner)
        MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
            .getPO(getC_BPartner_ID(), null);
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
   * Set Business Partner .
   *
   * @param C_BPartner_ID Identifies a Business Partner
   */
  public void setC_BPartner_ID(int C_BPartner_ID) {
    if (C_BPartner_ID < 1) set_Value(COLUMNNAME_C_BPartner_ID, null);
    else set_Value(COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
  }

  public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException {
    return (org.compiere.model.I_C_Currency)
        MTable.get(getCtx(), org.compiere.model.I_C_Currency.Table_Name)
            .getPO(getC_Currency_ID(), null);
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
   * Set Currency.
   *
   * @param C_Currency_ID The Currency for this record
   */
  public void setC_Currency_ID(int C_Currency_ID) {
    if (C_Currency_ID < 1) set_Value(COLUMNNAME_C_Currency_ID, null);
    else set_Value(COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
  }

  /**
   * Get Classification.
   *
   * @return Classification for grouping
   */
  public String getClassification() {
    return (String) get_Value(COLUMNNAME_Classification);
  }

  /**
   * Set Classification.
   *
   * @param Classification Classification for grouping
   */
  public void setClassification(String Classification) {
    set_Value(COLUMNNAME_Classification, Classification);
  }

  /**
   * Get Cost per Order.
   *
   * @return Fixed Cost Per Order
   */
  public BigDecimal getCostPerOrder() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_CostPerOrder);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Cost per Order.
   *
   * @param CostPerOrder Fixed Cost Per Order
   */
  public void setCostPerOrder(BigDecimal CostPerOrder) {
    set_Value(COLUMNNAME_CostPerOrder, CostPerOrder);
  }

  public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException {
    return (org.compiere.model.I_C_UOM)
        MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
            .getPO(getC_UOM_ID(), null);
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
   * Set UOM.
   *
   * @param C_UOM_ID Unit of Measure
   */
  public void setC_UOM_ID(int C_UOM_ID) {
    if (C_UOM_ID < 1) set_Value(COLUMNNAME_C_UOM_ID, null);
    else set_Value(COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
  }

  /**
   * Get Promised Delivery Time.
   *
   * @return Promised days between order and delivery
   */
  public int getDeliveryTime_Promised() {
    Integer ii = (Integer) get_Value(COLUMNNAME_DeliveryTime_Promised);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Promised Delivery Time.
   *
   * @param DeliveryTime_Promised Promised days between order and delivery
   */
  public void setDeliveryTime_Promised(int DeliveryTime_Promised) {
    set_Value(COLUMNNAME_DeliveryTime_Promised, Integer.valueOf(DeliveryTime_Promised));
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

  /**
   * Get Description URL.
   *
   * @return URL for the description
   */
  public String getDescriptionURL() {
    return (String) get_Value(COLUMNNAME_DescriptionURL);
  }

  /**
   * Set Description URL.
   *
   * @param DescriptionURL URL for the description
   */
  public void setDescriptionURL(String DescriptionURL) {
    set_Value(COLUMNNAME_DescriptionURL, DescriptionURL);
  }

  /**
   * Get Discontinued.
   *
   * @return This product is no longer available
   */
  public boolean isDiscontinued() {
    Object oo = get_Value(COLUMNNAME_Discontinued);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Discontinued.
   *
   * @param Discontinued This product is no longer available
   */
  public void setDiscontinued(boolean Discontinued) {
    set_Value(COLUMNNAME_Discontinued, Boolean.valueOf(Discontinued));
  }

  /**
   * Get Discontinued At.
   *
   * @return Discontinued At indicates Date when product was discontinued
   */
  public Timestamp getDiscontinuedAt() {
    return (Timestamp) get_Value(COLUMNNAME_DiscontinuedAt);
  }

  /**
   * Set Discontinued At.
   *
   * @param DiscontinuedAt Discontinued At indicates Date when product was discontinued
   */
  public void setDiscontinuedAt(Timestamp DiscontinuedAt) {
    set_Value(COLUMNNAME_DiscontinuedAt, DiscontinuedAt);
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
   * Set Document Note.
   *
   * @param DocumentNote Additional information for a Document
   */
  public void setDocumentNote(String DocumentNote) {
    set_Value(COLUMNNAME_DocumentNote, DocumentNote);
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
   * Set Comment/Help.
   *
   * @param Help Comment or Hint
   */
  public void setHelp(String Help) {
    set_Value(COLUMNNAME_Help, Help);
  }

  /**
   * Get Import Error Message.
   *
   * @return Messages generated from import process
   */
  public String getI_ErrorMsg() {
    return (String) get_Value(COLUMNNAME_I_ErrorMsg);
  }

  /**
   * Set Import Error Message.
   *
   * @param I_ErrorMsg Messages generated from import process
   */
  public void setI_ErrorMsg(String I_ErrorMsg) {
    set_Value(COLUMNNAME_I_ErrorMsg, I_ErrorMsg);
  }

  /**
   * Get Imported.
   *
   * @return Has this import been processed
   */
  public boolean isI_IsImported() {
    Object oo = get_Value(COLUMNNAME_I_IsImported);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Imported.
   *
   * @param I_IsImported Has this import been processed
   */
  public void setI_IsImported(boolean I_IsImported) {
    set_Value(COLUMNNAME_I_IsImported, Boolean.valueOf(I_IsImported));
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
   * Set Image URL.
   *
   * @param ImageURL URL of image
   */
  public void setImageURL(String ImageURL) {
    set_Value(COLUMNNAME_ImageURL, ImageURL);
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
   * Set Import Product.
   *
   * @param I_Product_ID Import Item or Service
   */
  public void setI_Product_ID(int I_Product_ID) {
    if (I_Product_ID < 1) set_ValueNoCheck(COLUMNNAME_I_Product_ID, null);
    else set_ValueNoCheck(COLUMNNAME_I_Product_ID, Integer.valueOf(I_Product_ID));
  }

  /**
   * Get I_Product_UU.
   *
   * @return I_Product_UU
   */
  public String getI_Product_UU() {
    return (String) get_Value(COLUMNNAME_I_Product_UU);
  }

  /**
   * Set I_Product_UU.
   *
   * @param I_Product_UU I_Product_UU
   */
  public void setI_Product_UU(String I_Product_UU) {
    set_Value(COLUMNNAME_I_Product_UU, I_Product_UU);
  }

  /**
   * Get ISO Currency Code.
   *
   * @return Three letter ISO 4217 Code of the Currency
   */
  public String getISO_Code() {
    return (String) get_Value(COLUMNNAME_ISO_Code);
  }

  /**
   * Set ISO Currency Code.
   *
   * @param ISO_Code Three letter ISO 4217 Code of the Currency
   */
  public void setISO_Code(String ISO_Code) {
    set_Value(COLUMNNAME_ISO_Code, ISO_Code);
  }

  /**
   * Get Manufacturer.
   *
   * @return Manufacturer of the Product
   */
  public String getManufacturer() {
    return (String) get_Value(COLUMNNAME_Manufacturer);
  }

  /**
   * Set Manufacturer.
   *
   * @param Manufacturer Manufacturer of the Product
   */
  public void setManufacturer(String Manufacturer) {
    set_Value(COLUMNNAME_Manufacturer, Manufacturer);
  }

  public org.compiere.model.I_M_Product_Category getM_Product_Category() throws RuntimeException {
    return (org.compiere.model.I_M_Product_Category)
        MTable.get(getCtx(), org.compiere.model.I_M_Product_Category.Table_Name)
            .getPO(getM_Product_Category_ID(), null);
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
   * Set Product Category.
   *
   * @param M_Product_Category_ID Category of a Product
   */
  public void setM_Product_Category_ID(int M_Product_Category_ID) {
    if (M_Product_Category_ID < 1) set_Value(COLUMNNAME_M_Product_Category_ID, null);
    else set_Value(COLUMNNAME_M_Product_Category_ID, Integer.valueOf(M_Product_Category_ID));
  }

  public org.compiere.model.I_M_Product getM_Product() throws RuntimeException {
    return (org.compiere.model.I_M_Product)
        MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
            .getPO(getM_Product_ID(), null);
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
   * Set Product.
   *
   * @param M_Product_ID Product, Service, Item
   */
  public void setM_Product_ID(int M_Product_ID) {
    if (M_Product_ID < 1) set_Value(COLUMNNAME_M_Product_ID, null);
    else set_Value(COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
  }

  /**
   * Get Minimum Order Qty.
   *
   * @return Minimum order quantity in UOM
   */
  public int getOrder_Min() {
    Integer ii = (Integer) get_Value(COLUMNNAME_Order_Min);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Minimum Order Qty.
   *
   * @param Order_Min Minimum order quantity in UOM
   */
  public void setOrder_Min(int Order_Min) {
    set_Value(COLUMNNAME_Order_Min, Integer.valueOf(Order_Min));
  }

  /**
   * Get Order Pack Qty.
   *
   * @return Package order size in UOM (e.g. order set of 5 units)
   */
  public int getOrder_Pack() {
    Integer ii = (Integer) get_Value(COLUMNNAME_Order_Pack);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Order Pack Qty.
   *
   * @param Order_Pack Package order size in UOM (e.g. order set of 5 units)
   */
  public void setOrder_Pack(int Order_Pack) {
    set_Value(COLUMNNAME_Order_Pack, Integer.valueOf(Order_Pack));
  }

  /**
   * Get Price effective.
   *
   * @return Effective Date of Price
   */
  public Timestamp getPriceEffective() {
    return (Timestamp) get_Value(COLUMNNAME_PriceEffective);
  }

  /**
   * Set Price effective.
   *
   * @param PriceEffective Effective Date of Price
   */
  public void setPriceEffective(Timestamp PriceEffective) {
    set_Value(COLUMNNAME_PriceEffective, PriceEffective);
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
   * Set Limit Price.
   *
   * @param PriceLimit Lowest price for a product
   */
  public void setPriceLimit(BigDecimal PriceLimit) {
    set_Value(COLUMNNAME_PriceLimit, PriceLimit);
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
   * Set List Price.
   *
   * @param PriceList List Price
   */
  public void setPriceList(BigDecimal PriceList) {
    set_Value(COLUMNNAME_PriceList, PriceList);
  }

  /**
   * Get PO Price.
   *
   * @return Price based on a purchase order
   */
  public BigDecimal getPricePO() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_PricePO);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set PO Price.
   *
   * @param PricePO Price based on a purchase order
   */
  public void setPricePO(BigDecimal PricePO) {
    set_Value(COLUMNNAME_PricePO, PricePO);
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
   * Set Standard Price.
   *
   * @param PriceStd Standard Price
   */
  public void setPriceStd(BigDecimal PriceStd) {
    set_Value(COLUMNNAME_PriceStd, PriceStd);
  }

  /**
   * Get Processed.
   *
   * @return The document has been processed
   */
  public boolean isProcessed() {
    Object oo = get_Value(COLUMNNAME_Processed);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Processed.
   *
   * @param Processed The document has been processed
   */
  public void setProcessed(boolean Processed) {
    set_Value(COLUMNNAME_Processed, Boolean.valueOf(Processed));
  }

  /**
   * Get Process Now.
   *
   * @return Process Now
   */
  public boolean isProcessing() {
    Object oo = get_Value(COLUMNNAME_Processing);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Process Now.
   *
   * @param Processing Process Now
   */
  public void setProcessing(boolean Processing) {
    set_Value(COLUMNNAME_Processing, Boolean.valueOf(Processing));
  }

  /**
   * Get Product Category Key.
   *
   * @return Product Category Key
   */
  public String getProductCategory_Value() {
    return (String) get_Value(COLUMNNAME_ProductCategory_Value);
  }

  /**
   * Set Product Category Key.
   *
   * @param ProductCategory_Value Product Category Key
   */
  public void setProductCategory_Value(String ProductCategory_Value) {
    set_Value(COLUMNNAME_ProductCategory_Value, ProductCategory_Value);
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
   * Set Product Type.
   *
   * @param ProductType Type of product
   */
  public void setProductType(String ProductType) {

    set_Value(COLUMNNAME_ProductType, ProductType);
  }

  /**
   * Get Royalty Amount.
   *
   * @return (Included) Amount for copyright, etc.
   */
  public BigDecimal getRoyaltyAmt() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_RoyaltyAmt);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Royalty Amount.
   *
   * @param RoyaltyAmt (Included) Amount for copyright, etc.
   */
  public void setRoyaltyAmt(BigDecimal RoyaltyAmt) {
    set_Value(COLUMNNAME_RoyaltyAmt, RoyaltyAmt);
  }

  /**
   * Get Shelf Depth.
   *
   * @return Shelf depth required
   */
  public int getShelfDepth() {
    Integer ii = (Integer) get_Value(COLUMNNAME_ShelfDepth);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shelf Depth.
   *
   * @param ShelfDepth Shelf depth required
   */
  public void setShelfDepth(int ShelfDepth) {
    set_Value(COLUMNNAME_ShelfDepth, Integer.valueOf(ShelfDepth));
  }

  /**
   * Get Shelf Height.
   *
   * @return Shelf height required
   */
  public BigDecimal getShelfHeight() {
    BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_ShelfHeight);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Shelf Height.
   *
   * @param ShelfHeight Shelf height required
   */
  public void setShelfHeight(BigDecimal ShelfHeight) {
    set_Value(COLUMNNAME_ShelfHeight, ShelfHeight);
  }

  /**
   * Get Shelf Width.
   *
   * @return Shelf width required
   */
  public int getShelfWidth() {
    Integer ii = (Integer) get_Value(COLUMNNAME_ShelfWidth);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shelf Width.
   *
   * @param ShelfWidth Shelf width required
   */
  public void setShelfWidth(int ShelfWidth) {
    set_Value(COLUMNNAME_ShelfWidth, Integer.valueOf(ShelfWidth));
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
   * Set SKU.
   *
   * @param SKU Stock Keeping Unit
   */
  public void setSKU(String SKU) {
    set_Value(COLUMNNAME_SKU, SKU);
  }

  /**
   * Get Units Per Pallet.
   *
   * @return Units Per Pallet
   */
  public int getUnitsPerPallet() {
    Integer ii = (Integer) get_Value(COLUMNNAME_UnitsPerPallet);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Units Per Pallet.
   *
   * @param UnitsPerPallet Units Per Pallet
   */
  public void setUnitsPerPallet(int UnitsPerPallet) {
    set_Value(COLUMNNAME_UnitsPerPallet, Integer.valueOf(UnitsPerPallet));
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
   * Set UPC/EAN.
   *
   * @param UPC Bar Code (Universal Product Code or its superset European Article Number)
   */
  public void setUPC(String UPC) {
    set_Value(COLUMNNAME_UPC, UPC);
  }

  /**
   * Get Partner Category.
   *
   * @return Product Category of the Business Partner
   */
  public String getVendorCategory() {
    return (String) get_Value(COLUMNNAME_VendorCategory);
  }

  /**
   * Set Partner Category.
   *
   * @param VendorCategory Product Category of the Business Partner
   */
  public void setVendorCategory(String VendorCategory) {
    set_Value(COLUMNNAME_VendorCategory, VendorCategory);
  }

  /**
   * Get Partner Product Key.
   *
   * @return Product Key of the Business Partner
   */
  public String getVendorProductNo() {
    return (String) get_Value(COLUMNNAME_VendorProductNo);
  }

  /**
   * Set Partner Product Key.
   *
   * @param VendorProductNo Product Key of the Business Partner
   */
  public void setVendorProductNo(String VendorProductNo) {
    set_Value(COLUMNNAME_VendorProductNo, VendorProductNo);
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
   * Set Volume.
   *
   * @param Volume Volume of a product
   */
  public void setVolume(BigDecimal Volume) {
    set_Value(COLUMNNAME_Volume, Volume);
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

  /**
   * Set Weight.
   *
   * @param Weight Weight of a product
   */
  public void setWeight(BigDecimal Weight) {
    set_Value(COLUMNNAME_Weight, Weight);
  }

  /**
   * Get UOM Code.
   *
   * @return UOM EDI X12 Code
   */
  public String getX12DE355() {
    return (String) get_Value(COLUMNNAME_X12DE355);
  }

  /**
   * Set UOM Code.
   *
   * @param X12DE355 UOM EDI X12 Code
   */
  public void setX12DE355(String X12DE355) {
    set_Value(COLUMNNAME_X12DE355, X12DE355);
  }

  @Override
  public int getTableId() {
    return I_I_Product.Table_ID;
  }
}
