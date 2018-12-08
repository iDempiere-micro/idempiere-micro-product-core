package org.compiere.product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.HasName;
import org.compiere.model.I_M_AttributeSetInstance;
import org.compiere.model.I_M_Locator;
import org.compiere.model.I_M_Product;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;
import org.idempiere.common.util.KeyNamePair;
import org.idempiere.orm.I_Persistent;

/**
 * Generated Model for M_Product
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Product extends PO implements I_Persistent {

  /** ProductType AD_Reference_ID=270 */
  public static final int PRODUCTTYPE_AD_Reference_ID = 270;
  /** */
  private static final long serialVersionUID = 20171031L;

  /** Standard Constructor */
  public X_M_Product(Properties ctx, int M_Product_ID, String trxName) {
    super(ctx, M_Product_ID, trxName);
    /**
     * if (M_Product_ID == 0) { setC_TaxCategory_ID (0); setC_UOM_ID (0); setIsBOM (false); // N
     * setIsDropShip (false); setIsExcludeAutoDelivery (false); // N setIsInvoicePrintDetails
     * (false); setIsKanban (false); // N setIsManufactured (false); // N setIsOwnBox (false); // N
     * setIsPhantom (false); // N setIsPickListPrintDetails (false); setIsPurchased (true); // Y
     * setIsSelfService (true); // Y setIsSold (true); // Y setIsStocked (true); // Y setIsSummary
     * (false); setIsVerified (false); // N setIsWebStoreFeatured (false); setLowLevel (0); // 0
     * setM_AttributeSetInstance_ID (0); setM_Product_Category_ID (0); setM_Product_ID (0); setName
     * (null); setProductType (null); // I setValue (null); }
     */
  }

  /** Load Constructor */
  public X_M_Product(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  }

  /**
   * AccessLevel
   *
   * @return 3 - Client - Org
   */
  protected int getAccessLevel() {
    return I_M_Product.accessLevel.intValue();
  }

  public String toString() {
    return "X_M_Product[" + getId() + "]";
  }

  /**
   * Get Classification.
   *
   * @return Classification for grouping
   */
  public String getClassification() {
    return (String) get_Value(I_M_Product.COLUMNNAME_Classification);
  }

  /**
   * Set Classification.
   *
   * @param Classification Classification for grouping
   */
  public void setClassification(String Classification) {
    set_Value(I_M_Product.COLUMNNAME_Classification, Classification);
  }

  /**
   * Get Copy From.
   *
   * @return Copy From Record
   */
  public String getCopyFrom() {
    return (String) get_Value(I_M_Product.COLUMNNAME_CopyFrom);
  }

  /**
   * Set Copy From.
   *
   * @param CopyFrom Copy From Record
   */
  public void setCopyFrom(String CopyFrom) {
    set_Value(I_M_Product.COLUMNNAME_CopyFrom, CopyFrom);
  }

  public org.compiere.model.I_C_RevenueRecognition getC_RevenueRecognition()
      throws RuntimeException {
    return (org.compiere.model.I_C_RevenueRecognition)
        MTable.get(getCtx(), org.compiere.model.I_C_RevenueRecognition.Table_Name)
            .getPO(getC_RevenueRecognition_ID(), get_TrxName());
  }

  /**
   * Get Revenue Recognition.
   *
   * @return Method for recording revenue
   */
  public int getC_RevenueRecognition_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_C_RevenueRecognition_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Revenue Recognition.
   *
   * @param C_RevenueRecognition_ID Method for recording revenue
   */
  public void setC_RevenueRecognition_ID(int C_RevenueRecognition_ID) {
    if (C_RevenueRecognition_ID < 1)
      set_Value(I_M_Product.COLUMNNAME_C_RevenueRecognition_ID, null);
    else
      set_Value(
          I_M_Product.COLUMNNAME_C_RevenueRecognition_ID, Integer.valueOf(C_RevenueRecognition_ID));
  }

  public org.compiere.model.I_C_SubscriptionType getC_SubscriptionType() throws RuntimeException {
    return (org.compiere.model.I_C_SubscriptionType)
        MTable.get(getCtx(), org.compiere.model.I_C_SubscriptionType.Table_Name)
            .getPO(getC_SubscriptionType_ID(), get_TrxName());
  }

  /**
   * Get Subscription Type.
   *
   * @return Type of subscription
   */
  public int getC_SubscriptionType_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_C_SubscriptionType_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Subscription Type.
   *
   * @param C_SubscriptionType_ID Type of subscription
   */
  public void setC_SubscriptionType_ID(int C_SubscriptionType_ID) {
    if (C_SubscriptionType_ID < 1) set_Value(I_M_Product.COLUMNNAME_C_SubscriptionType_ID, null);
    else
      set_Value(
          I_M_Product.COLUMNNAME_C_SubscriptionType_ID, Integer.valueOf(C_SubscriptionType_ID));
  }

  public org.compiere.model.I_C_TaxCategory getC_TaxCategory() throws RuntimeException {
    return (org.compiere.model.I_C_TaxCategory)
        MTable.get(getCtx(), org.compiere.model.I_C_TaxCategory.Table_Name)
            .getPO(getC_TaxCategory_ID(), get_TrxName());
  }

  /**
   * Get Tax Category.
   *
   * @return Tax Category
   */
  public int getC_TaxCategory_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_C_TaxCategory_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Tax Category.
   *
   * @param C_TaxCategory_ID Tax Category
   */
  public void setC_TaxCategory_ID(int C_TaxCategory_ID) {
    if (C_TaxCategory_ID < 1) set_Value(I_M_Product.COLUMNNAME_C_TaxCategory_ID, null);
    else set_Value(I_M_Product.COLUMNNAME_C_TaxCategory_ID, Integer.valueOf(C_TaxCategory_ID));
  }

  public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException {
    return (org.compiere.model.I_C_UOM)
        MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
            .getPO(getC_UOM_ID(), get_TrxName());
  }

  /**
   * Get UOM.
   *
   * @return Unit of Measure
   */
  public int getC_UOM_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_C_UOM_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set UOM.
   *
   * @param C_UOM_ID Unit of Measure
   */
  public void setC_UOM_ID(int C_UOM_ID) {
    if (C_UOM_ID < 1) set_Value(I_M_Product.COLUMNNAME_C_UOM_ID, null);
    else set_Value(I_M_Product.COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
  }

  /**
   * Get Description.
   *
   * @return Optional short description of the record
   */
  public String getDescription() {
    return (String) get_Value(I_M_Product.COLUMNNAME_Description);
  }

  /**
   * Set Description.
   *
   * @param Description Optional short description of the record
   */
  public void setDescription(String Description) {
    set_Value(I_M_Product.COLUMNNAME_Description, Description);
  }

  /**
   * Get Description URL.
   *
   * @return URL for the description
   */
  public String getDescriptionURL() {
    return (String) get_Value(I_M_Product.COLUMNNAME_DescriptionURL);
  }

  /**
   * Set Description URL.
   *
   * @param DescriptionURL URL for the description
   */
  public void setDescriptionURL(String DescriptionURL) {
    set_Value(I_M_Product.COLUMNNAME_DescriptionURL, DescriptionURL);
  }

  /**
   * Get Discontinued.
   *
   * @return This product is no longer available
   */
  public boolean isDiscontinued() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_Discontinued);
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
    set_Value(I_M_Product.COLUMNNAME_Discontinued, Boolean.valueOf(Discontinued));
  }

  /**
   * Get Discontinued At.
   *
   * @return Discontinued At indicates Date when product was discontinued
   */
  public Timestamp getDiscontinuedAt() {
    return (Timestamp) get_Value(I_M_Product.COLUMNNAME_DiscontinuedAt);
  }

  /**
   * Set Discontinued At.
   *
   * @param DiscontinuedAt Discontinued At indicates Date when product was discontinued
   */
  public void setDiscontinuedAt(Timestamp DiscontinuedAt) {
    set_Value(I_M_Product.COLUMNNAME_DiscontinuedAt, DiscontinuedAt);
  }

  /**
   * Get Document Note.
   *
   * @return Additional information for a Document
   */
  public String getDocumentNote() {
    return (String) get_Value(I_M_Product.COLUMNNAME_DocumentNote);
  }

  /**
   * Set Document Note.
   *
   * @param DocumentNote Additional information for a Document
   */
  public void setDocumentNote(String DocumentNote) {
    set_Value(I_M_Product.COLUMNNAME_DocumentNote, DocumentNote);
  }

  /**
   * Get Group1.
   *
   * @return Group1
   */
  public String getGroup1() {
    return (String) get_Value(I_M_Product.COLUMNNAME_Group1);
  }

  /**
   * Set Group1.
   *
   * @param Group1 Group1
   */
  public void setGroup1(String Group1) {
    set_Value(I_M_Product.COLUMNNAME_Group1, Group1);
  }

  /**
   * Get Group2.
   *
   * @return Group2
   */
  public String getGroup2() {
    return (String) get_Value(I_M_Product.COLUMNNAME_Group2);
  }

  /**
   * Set Group2.
   *
   * @param Group2 Group2
   */
  public void setGroup2(String Group2) {
    set_Value(I_M_Product.COLUMNNAME_Group2, Group2);
  }

  /**
   * Get Guarantee Days.
   *
   * @return Number of days the product is guaranteed or available
   */
  public int getGuaranteeDays() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_GuaranteeDays);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Guarantee Days.
   *
   * @param GuaranteeDays Number of days the product is guaranteed or available
   */
  public void setGuaranteeDays(int GuaranteeDays) {
    set_Value(I_M_Product.COLUMNNAME_GuaranteeDays, Integer.valueOf(GuaranteeDays));
  }

  /**
   * Get Min Guarantee Days.
   *
   * @return Minimum number of guarantee days
   */
  public int getGuaranteeDaysMin() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_GuaranteeDaysMin);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Min Guarantee Days.
   *
   * @param GuaranteeDaysMin Minimum number of guarantee days
   */
  public void setGuaranteeDaysMin(int GuaranteeDaysMin) {
    set_Value(I_M_Product.COLUMNNAME_GuaranteeDaysMin, Integer.valueOf(GuaranteeDaysMin));
  }

  /**
   * Get Comment/Help.
   *
   * @return Comment or Hint
   */
  public String getHelp() {
    return (String) get_Value(I_M_Product.COLUMNNAME_Help);
  }

  /**
   * Set Comment/Help.
   *
   * @param Help Comment or Hint
   */
  public void setHelp(String Help) {
    set_Value(I_M_Product.COLUMNNAME_Help, Help);
  }

  /**
   * Get Image URL.
   *
   * @return URL of image
   */
  public String getImageURL() {
    return (String) get_Value(I_M_Product.COLUMNNAME_ImageURL);
  }

  /**
   * Set Image URL.
   *
   * @param ImageURL URL of image
   */
  public void setImageURL(String ImageURL) {
    set_Value(I_M_Product.COLUMNNAME_ImageURL, ImageURL);
  }

  /**
   * Set Bill of Materials.
   *
   * @param IsBOM Bill of Materials
   */
  public void setIsBOM(boolean IsBOM) {
    set_Value(I_M_Product.COLUMNNAME_IsBOM, Boolean.valueOf(IsBOM));
  }

  /**
   * Get Bill of Materials.
   *
   * @return Bill of Materials
   */
  public boolean isBOM() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsBOM);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Drop Shipment.
   *
   * @param IsDropShip Drop Shipments are sent from the Vendor directly to the Customer
   */
  public void setIsDropShip(boolean IsDropShip) {
    set_Value(I_M_Product.COLUMNNAME_IsDropShip, Boolean.valueOf(IsDropShip));
  }

  /**
   * Get Drop Shipment.
   *
   * @return Drop Shipments are sent from the Vendor directly to the Customer
   */
  public boolean isDropShip() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsDropShip);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Exclude Auto Delivery.
   *
   * @param IsExcludeAutoDelivery Exclude from automatic Delivery
   */
  public void setIsExcludeAutoDelivery(boolean IsExcludeAutoDelivery) {
    set_Value(I_M_Product.COLUMNNAME_IsExcludeAutoDelivery, Boolean.valueOf(IsExcludeAutoDelivery));
  }

  /**
   * Get Exclude Auto Delivery.
   *
   * @return Exclude from automatic Delivery
   */
  public boolean isExcludeAutoDelivery() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsExcludeAutoDelivery);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Print detail records on invoice .
   *
   * @param IsInvoicePrintDetails Print detail BOM elements on the invoice
   */
  public void setIsInvoicePrintDetails(boolean IsInvoicePrintDetails) {
    set_Value(I_M_Product.COLUMNNAME_IsInvoicePrintDetails, Boolean.valueOf(IsInvoicePrintDetails));
  }

  /**
   * Get Print detail records on invoice .
   *
   * @return Print detail BOM elements on the invoice
   */
  public boolean isInvoicePrintDetails() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsInvoicePrintDetails);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Kanban controlled.
   *
   * @param IsKanban This part is Kanban controlled
   */
  public void setIsKanban(boolean IsKanban) {
    set_Value(I_M_Product.COLUMNNAME_IsKanban, Boolean.valueOf(IsKanban));
  }

  /**
   * Get Kanban controlled.
   *
   * @return This part is Kanban controlled
   */
  public boolean isKanban() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsKanban);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Manufactured.
   *
   * @param IsManufactured This product is manufactured
   */
  public void setIsManufactured(boolean IsManufactured) {
    set_Value(I_M_Product.COLUMNNAME_IsManufactured, Boolean.valueOf(IsManufactured));
  }

  /**
   * Get Manufactured.
   *
   * @return This product is manufactured
   */
  public boolean isManufactured() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsManufactured);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Own Box.
   *
   * @param IsOwnBox Own Box
   */
  public void setIsOwnBox(boolean IsOwnBox) {
    set_Value(I_M_Product.COLUMNNAME_IsOwnBox, Boolean.valueOf(IsOwnBox));
  }

  /**
   * Get Own Box.
   *
   * @return Own Box
   */
  public boolean isOwnBox() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsOwnBox);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Phantom.
   *
   * @param IsPhantom Phantom Component
   */
  public void setIsPhantom(boolean IsPhantom) {
    set_Value(I_M_Product.COLUMNNAME_IsPhantom, Boolean.valueOf(IsPhantom));
  }

  /**
   * Get Phantom.
   *
   * @return Phantom Component
   */
  public boolean isPhantom() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsPhantom);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Print detail records on pick list.
   *
   * @param IsPickListPrintDetails Print detail BOM elements on the pick list
   */
  public void setIsPickListPrintDetails(boolean IsPickListPrintDetails) {
    set_Value(
        I_M_Product.COLUMNNAME_IsPickListPrintDetails, Boolean.valueOf(IsPickListPrintDetails));
  }

  /**
   * Get Print detail records on pick list.
   *
   * @return Print detail BOM elements on the pick list
   */
  public boolean isPickListPrintDetails() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsPickListPrintDetails);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Purchased.
   *
   * @param IsPurchased Organization purchases this product
   */
  public void setIsPurchased(boolean IsPurchased) {
    set_Value(I_M_Product.COLUMNNAME_IsPurchased, Boolean.valueOf(IsPurchased));
  }

  /**
   * Get Purchased.
   *
   * @return Organization purchases this product
   */
  public boolean isPurchased() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsPurchased);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Self-Service.
   *
   * @param IsSelfService This is a Self-Service entry or this entry can be changed via Self-Service
   */
  public void setIsSelfService(boolean IsSelfService) {
    set_Value(I_M_Product.COLUMNNAME_IsSelfService, Boolean.valueOf(IsSelfService));
  }

  /**
   * Get Self-Service.
   *
   * @return This is a Self-Service entry or this entry can be changed via Self-Service
   */
  public boolean isSelfService() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsSelfService);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Sold.
   *
   * @param IsSold Organization sells this product
   */
  public void setIsSold(boolean IsSold) {
    set_Value(I_M_Product.COLUMNNAME_IsSold, Boolean.valueOf(IsSold));
  }

  /**
   * Get Sold.
   *
   * @return Organization sells this product
   */
  public boolean isSold() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsSold);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Stocked.
   *
   * @param IsStocked Organization stocks this product
   */
  public void setIsStocked(boolean IsStocked) {
    set_Value(I_M_Product.COLUMNNAME_IsStocked, Boolean.valueOf(IsStocked));
  }

  /**
   * Get Stocked.
   *
   * @return Organization stocks this product
   */
  public boolean isStocked() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsStocked);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Summary Level.
   *
   * @param IsSummary This is a summary entity
   */
  public void setIsSummary(boolean IsSummary) {
    set_Value(I_M_Product.COLUMNNAME_IsSummary, Boolean.valueOf(IsSummary));
  }

  /**
   * Get Summary Level.
   *
   * @return This is a summary entity
   */
  public boolean isSummary() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsSummary);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Verified.
   *
   * @param IsVerified The BOM configuration has been verified
   */
  public void setIsVerified(boolean IsVerified) {
    set_ValueNoCheck(I_M_Product.COLUMNNAME_IsVerified, Boolean.valueOf(IsVerified));
  }

  /**
   * Get Verified.
   *
   * @return The BOM configuration has been verified
   */
  public boolean isVerified() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsVerified);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Set Featured in Web Store.
   *
   * @param IsWebStoreFeatured If selected, the product is displayed in the initial or any empty
   *     search
   */
  public void setIsWebStoreFeatured(boolean IsWebStoreFeatured) {
    set_Value(I_M_Product.COLUMNNAME_IsWebStoreFeatured, Boolean.valueOf(IsWebStoreFeatured));
  }

  /**
   * Get Featured in Web Store.
   *
   * @return If selected, the product is displayed in the initial or any empty search
   */
  public boolean isWebStoreFeatured() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_IsWebStoreFeatured);
    if (oo != null) {
      if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
      return "Y".equals(oo);
    }
    return false;
  }

  /**
   * Get Low Level.
   *
   * @return The Low Level is used to calculate the material plan and determines if a net
   *     requirement should be exploited
   */
  public int getLowLevel() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_LowLevel);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Low Level.
   *
   * @param LowLevel The Low Level is used to calculate the material plan and determines if a net
   *     requirement should be exploited
   */
  public void setLowLevel(int LowLevel) {
    set_Value(I_M_Product.COLUMNNAME_LowLevel, Integer.valueOf(LowLevel));
  }

  public org.compiere.model.I_M_AttributeSet getMAttributeSet() throws RuntimeException {
    return (org.compiere.model.I_M_AttributeSet)
        MTable.get(getCtx(), org.compiere.model.I_M_AttributeSet.Table_Name)
            .getPO(getMAttributeSet_ID(), get_TrxName());
  }

  /**
   * Set Attribute Set.
   *
   * @param M_AttributeSet_ID Product Attribute Set
   */
  public void setM_AttributeSet_ID(int M_AttributeSet_ID) {
    if (M_AttributeSet_ID < 0) set_Value(I_M_Product.COLUMNNAME_M_AttributeSet_ID, null);
    else set_Value(I_M_Product.COLUMNNAME_M_AttributeSet_ID, Integer.valueOf(M_AttributeSet_ID));
  }

  /**
   * Get Attribute Set.
   *
   * @return Product Attribute Set
   */
  public int getMAttributeSet_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_M_AttributeSet_ID);
    if (ii == null) return 0;
    return ii;
  }

  public I_M_AttributeSetInstance getMAttributeSetInstance() throws RuntimeException {
    return (I_M_AttributeSetInstance)
        MTable.get(getCtx(), I_M_AttributeSetInstance.Table_Name)
            .getPO(getMAttributeSetInstance_ID(), get_TrxName());
  }

  /**
   * Set Attribute Set Instance.
   *
   * @param M_AttributeSetInstance_ID Product Attribute Set Instance
   */
  public void setM_AttributeSetInstance_ID(int M_AttributeSetInstance_ID) {
    if (M_AttributeSetInstance_ID < 0)
      set_Value(I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID, null);
    else
      set_Value(
          I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID,
          Integer.valueOf(M_AttributeSetInstance_ID));
  }

  /**
   * Get Attribute Set Instance.
   *
   * @return Product Attribute Set Instance
   */
  public int getMAttributeSetInstance_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID);
    if (ii == null) return 0;
    return ii;
  }

  public org.compiere.model.I_M_FreightCategory getM_FreightCategory() throws RuntimeException {
    return (org.compiere.model.I_M_FreightCategory)
        MTable.get(getCtx(), org.compiere.model.I_M_FreightCategory.Table_Name)
            .getPO(getM_FreightCategory_ID(), get_TrxName());
  }

  /**
   * Get Freight Category.
   *
   * @return Category of the Freight
   */
  public int getM_FreightCategory_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_M_FreightCategory_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Freight Category.
   *
   * @param M_FreightCategory_ID Category of the Freight
   */
  public void setM_FreightCategory_ID(int M_FreightCategory_ID) {
    if (M_FreightCategory_ID < 1) set_Value(I_M_Product.COLUMNNAME_M_FreightCategory_ID, null);
    else
      set_Value(I_M_Product.COLUMNNAME_M_FreightCategory_ID, Integer.valueOf(M_FreightCategory_ID));
  }

  public I_M_Locator getM_Locator() throws RuntimeException {
    return (I_M_Locator)
        MTable.get(getCtx(), I_M_Locator.Table_Name).getPO(getM_Locator_ID(), get_TrxName());
  }

  /**
   * Get Locator.
   *
   * @return Warehouse Locator
   */
  public int getM_Locator_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_M_Locator_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Locator.
   *
   * @param M_Locator_ID Warehouse Locator
   */
  public void setM_Locator_ID(int M_Locator_ID) {
    if (M_Locator_ID < 1) set_Value(I_M_Product.COLUMNNAME_M_Locator_ID, null);
    else set_Value(I_M_Product.COLUMNNAME_M_Locator_ID, Integer.valueOf(M_Locator_ID));
  }

  public org.compiere.model.I_M_PartType getM_PartType() throws RuntimeException {
    return (org.compiere.model.I_M_PartType)
        MTable.get(getCtx(), org.compiere.model.I_M_PartType.Table_Name)
            .getPO(getM_PartType_ID(), get_TrxName());
  }

  /**
   * Get Part Type.
   *
   * @return Part Type
   */
  public int getM_PartType_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_M_PartType_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Part Type.
   *
   * @param M_PartType_ID Part Type
   */
  public void setM_PartType_ID(int M_PartType_ID) {
    if (M_PartType_ID < 1) set_Value(I_M_Product.COLUMNNAME_M_PartType_ID, null);
    else set_Value(I_M_Product.COLUMNNAME_M_PartType_ID, Integer.valueOf(M_PartType_ID));
  }

  public org.compiere.model.I_M_Product_Category getM_Product_Category() throws RuntimeException {
    return (org.compiere.model.I_M_Product_Category)
        MTable.get(getCtx(), org.compiere.model.I_M_Product_Category.Table_Name)
            .getPO(getM_Product_Category_ID(), get_TrxName());
  }

  /**
   * Get Product Category.
   *
   * @return Category of a Product
   */
  public int getM_Product_Category_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_M_Product_Category_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Product Category.
   *
   * @param M_Product_Category_ID Category of a Product
   */
  public void setM_Product_Category_ID(int M_Product_Category_ID) {
    if (M_Product_Category_ID < 1) set_Value(I_M_Product.COLUMNNAME_M_Product_Category_ID, null);
    else
      set_Value(
          I_M_Product.COLUMNNAME_M_Product_Category_ID, Integer.valueOf(M_Product_Category_ID));
  }

  /**
   * Get Product.
   *
   * @return Product, Service, Item
   */
  public int getM_Product_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_M_Product_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Product.
   *
   * @param M_Product_ID Product, Service, Item
   */
  public void setM_Product_ID(int M_Product_ID) {
    if (M_Product_ID < 1) set_ValueNoCheck(I_M_Product.COLUMNNAME_M_Product_ID, null);
    else set_ValueNoCheck(I_M_Product.COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
  }

  /**
   * Get M_Product_UU.
   *
   * @return M_Product_UU
   */
  public String getM_Product_UU() {
    return (String) get_Value(I_M_Product.COLUMNNAME_M_Product_UU);
  }

  /**
   * Set M_Product_UU.
   *
   * @param M_Product_UU M_Product_UU
   */
  public void setM_Product_UU(String M_Product_UU) {
    set_Value(I_M_Product.COLUMNNAME_M_Product_UU, M_Product_UU);
  }

  /**
   * Get Name.
   *
   * @return Alphanumeric identifier of the entity
   */
  public String getName() {
    return (String) get_Value(HasName.Companion.getCOLUMNNAME_Name());
  }

  /**
   * Set Name.
   *
   * @param Name Alphanumeric identifier of the entity
   */
  public void setName(String Name) {
    set_Value(HasName.Companion.getCOLUMNNAME_Name(), Name);
  }

  /**
   * Get Process Now.
   *
   * @return Process Now
   */
  public boolean isProcessing() {
    Object oo = get_Value(I_M_Product.COLUMNNAME_Processing);
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
    set_Value(I_M_Product.COLUMNNAME_Processing, Boolean.valueOf(Processing));
  }

  /**
   * Get Product Type.
   *
   * @return Type of product
   */
  public String getProductType() {
    return (String) get_Value(I_M_Product.COLUMNNAME_ProductType);
  }

  /**
   * Set Product Type.
   *
   * @param ProductType Type of product
   */
  public void setProductType(String ProductType) {

    set_Value(I_M_Product.COLUMNNAME_ProductType, ProductType);
  }

  public org.compiere.model.I_R_MailText getR_MailText() throws RuntimeException {
    return (org.compiere.model.I_R_MailText)
        MTable.get(getCtx(), org.compiere.model.I_R_MailText.Table_Name)
            .getPO(getR_MailText_ID(), get_TrxName());
  }

  /**
   * Get Mail Template.
   *
   * @return Text templates for mailings
   */
  public int getR_MailText_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_R_MailText_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Mail Template.
   *
   * @param R_MailText_ID Text templates for mailings
   */
  public void setR_MailText_ID(int R_MailText_ID) {
    if (R_MailText_ID < 1) set_Value(I_M_Product.COLUMNNAME_R_MailText_ID, null);
    else set_Value(I_M_Product.COLUMNNAME_R_MailText_ID, Integer.valueOf(R_MailText_ID));
  }

  public org.compiere.model.I_AD_User getSalesRep() throws RuntimeException {
    return (org.compiere.model.I_AD_User)
        MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
            .getPO(getSalesRep_ID(), get_TrxName());
  }

  /**
   * Get Sales Representative.
   *
   * @return Sales Representative or Company Agent
   */
  public int getSalesRep_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_SalesRep_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Sales Representative.
   *
   * @param SalesRep_ID Sales Representative or Company Agent
   */
  public void setSalesRep_ID(int SalesRep_ID) {
    if (SalesRep_ID < 1) set_Value(I_M_Product.COLUMNNAME_SalesRep_ID, null);
    else set_Value(I_M_Product.COLUMNNAME_SalesRep_ID, Integer.valueOf(SalesRep_ID));
  }

  public org.compiere.model.I_S_ExpenseType getS_ExpenseType() throws RuntimeException {
    return (org.compiere.model.I_S_ExpenseType)
        MTable.get(getCtx(), org.compiere.model.I_S_ExpenseType.Table_Name)
            .getPO(getS_ExpenseType_ID(), get_TrxName());
  }

  /**
   * Get Expense Type.
   *
   * @return Expense report type
   */
  public int getS_ExpenseType_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_S_ExpenseType_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Expense Type.
   *
   * @param S_ExpenseType_ID Expense report type
   */
  public void setS_ExpenseType_ID(int S_ExpenseType_ID) {
    if (S_ExpenseType_ID < 1) set_ValueNoCheck(I_M_Product.COLUMNNAME_S_ExpenseType_ID, null);
    else
      set_ValueNoCheck(I_M_Product.COLUMNNAME_S_ExpenseType_ID, Integer.valueOf(S_ExpenseType_ID));
  }

  /**
   * Get Shelf Depth.
   *
   * @return Shelf depth required
   */
  public int getShelfDepth() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_ShelfDepth);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shelf Depth.
   *
   * @param ShelfDepth Shelf depth required
   */
  public void setShelfDepth(int ShelfDepth) {
    set_Value(I_M_Product.COLUMNNAME_ShelfDepth, Integer.valueOf(ShelfDepth));
  }

  /**
   * Get Shelf Height.
   *
   * @return Shelf height required
   */
  public BigDecimal getShelfHeight() {
    BigDecimal bd = (BigDecimal) get_Value(I_M_Product.COLUMNNAME_ShelfHeight);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Shelf Height.
   *
   * @param ShelfHeight Shelf height required
   */
  public void setShelfHeight(BigDecimal ShelfHeight) {
    set_Value(I_M_Product.COLUMNNAME_ShelfHeight, ShelfHeight);
  }

  /**
   * Get Shelf Width.
   *
   * @return Shelf width required
   */
  public int getShelfWidth() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_ShelfWidth);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Shelf Width.
   *
   * @param ShelfWidth Shelf width required
   */
  public void setShelfWidth(int ShelfWidth) {
    set_Value(I_M_Product.COLUMNNAME_ShelfWidth, Integer.valueOf(ShelfWidth));
  }

  /**
   * Get SKU.
   *
   * @return Stock Keeping Unit
   */
  public String getSKU() {
    return (String) get_Value(I_M_Product.COLUMNNAME_SKU);
  }

  /**
   * Set SKU.
   *
   * @param SKU Stock Keeping Unit
   */
  public void setSKU(String SKU) {
    set_Value(I_M_Product.COLUMNNAME_SKU, SKU);
  }

  public org.compiere.model.I_S_Resource getS_Resource() throws RuntimeException {
    return (org.compiere.model.I_S_Resource)
        MTable.get(getCtx(), org.compiere.model.I_S_Resource.Table_Name)
            .getPO(getS_Resource_ID(), get_TrxName());
  }

  /**
   * Get Resource.
   *
   * @return Resource
   */
  public int getS_Resource_ID() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_S_Resource_ID);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set Resource.
   *
   * @param S_Resource_ID Resource
   */
  public void setS_Resource_ID(int S_Resource_ID) {
    if (S_Resource_ID < 1) set_ValueNoCheck(I_M_Product.COLUMNNAME_S_Resource_ID, null);
    else set_ValueNoCheck(I_M_Product.COLUMNNAME_S_Resource_ID, Integer.valueOf(S_Resource_ID));
  }

  /**
   * Get UnitsPerPack.
   *
   * @return The Units Per Pack indicates the no of units of a product packed together.
   */
  public int getUnitsPerPack() {
    Integer ii = (Integer) get_Value(I_M_Product.COLUMNNAME_UnitsPerPack);
    if (ii == null) return 0;
    return ii;
  }

  /**
   * Set UnitsPerPack.
   *
   * @param UnitsPerPack The Units Per Pack indicates the no of units of a product packed together.
   */
  public void setUnitsPerPack(int UnitsPerPack) {
    set_Value(I_M_Product.COLUMNNAME_UnitsPerPack, Integer.valueOf(UnitsPerPack));
  }

  /**
   * Get Units Per Pallet.
   *
   * @return Units Per Pallet
   */
  public BigDecimal getUnitsPerPallet() {
    BigDecimal bd = (BigDecimal) get_Value(I_M_Product.COLUMNNAME_UnitsPerPallet);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Units Per Pallet.
   *
   * @param UnitsPerPallet Units Per Pallet
   */
  public void setUnitsPerPallet(BigDecimal UnitsPerPallet) {
    set_Value(I_M_Product.COLUMNNAME_UnitsPerPallet, UnitsPerPallet);
  }

  /**
   * Get UPC/EAN.
   *
   * @return Bar Code (Universal Product Code or its superset European Article Number)
   */
  public String getUPC() {
    return (String) get_Value(I_M_Product.COLUMNNAME_UPC);
  }

  /**
   * Set UPC/EAN.
   *
   * @param UPC Bar Code (Universal Product Code or its superset European Article Number)
   */
  public void setUPC(String UPC) {
    set_Value(I_M_Product.COLUMNNAME_UPC, UPC);
  }

  /**
   * Get Search Key.
   *
   * @return Search key for the record in the format required - must be unique
   */
  public String getValue() {
    return (String) get_Value(I_M_Product.COLUMNNAME_Value);
  }

  /**
   * Set Search Key.
   *
   * @param Value Search key for the record in the format required - must be unique
   */
  public void setValue(String Value) {
    set_Value(I_M_Product.COLUMNNAME_Value, Value);
  }

  /**
   * Get Record ID/ColumnName
   *
   * @return ID/ColumnName pair
   */
  public KeyNamePair getKeyNamePair() {
    return new KeyNamePair(getId(), getValue());
  }

  /**
   * Get Version No.
   *
   * @return Version Number
   */
  public String getVersionNo() {
    return (String) get_Value(I_M_Product.COLUMNNAME_VersionNo);
  }

  /**
   * Set Version No.
   *
   * @param VersionNo Version Number
   */
  public void setVersionNo(String VersionNo) {
    set_Value(I_M_Product.COLUMNNAME_VersionNo, VersionNo);
  }

  /**
   * Get Volume.
   *
   * @return Volume of a product
   */
  public BigDecimal getVolume() {
    BigDecimal bd = (BigDecimal) get_Value(I_M_Product.COLUMNNAME_Volume);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Volume.
   *
   * @param Volume Volume of a product
   */
  public void setVolume(BigDecimal Volume) {
    set_Value(I_M_Product.COLUMNNAME_Volume, Volume);
  }

  /**
   * Get Weight.
   *
   * @return Weight of a product
   */
  public BigDecimal getWeight() {
    BigDecimal bd = (BigDecimal) get_Value(I_M_Product.COLUMNNAME_Weight);
    if (bd == null) return Env.ZERO;
    return bd;
  }

  /**
   * Set Weight.
   *
   * @param Weight Weight of a product
   */
  public void setWeight(BigDecimal Weight) {
    set_Value(I_M_Product.COLUMNNAME_Weight, Weight);
  }

  @Override
  public int getTableId() {
    return I_M_Product.Table_ID;
  }
}
