package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.HasName;
import org.compiere.model.I_C_TaxCategory;
import org.compiere.model.I_M_AttributeSet;
import org.compiere.model.I_M_Product;
import org.compiere.model.I_M_Product_Category;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;

/**
 * Generated Model for M_Product
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Product extends PO {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_Product(int M_Product_ID) {
        super(M_Product_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_Product(Row row) {
        super(row);
    } //	MProduct

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
     * Get Revenue Recognition.
     *
     * @return Method for recording revenue
     */
    public int getRevenueRecognitionId() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_C_RevenueRecognition_ID);
        if (ii == null) return 0;
        return ii;
    }

    public I_C_TaxCategory getTaxCategory() throws RuntimeException {
        return (I_C_TaxCategory)
                MTable.get(I_C_TaxCategory.Table_Name)
                        .getPO(getTaxCategoryId());
    }

    /**
     * Get Tax Category.
     *
     * @return Tax Category
     */
    public int getTaxCategoryId() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_C_TaxCategory_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Tax Category.
     *
     * @param C_TaxCategory_ID Tax Category
     */
    public void setTaxCategoryId(int C_TaxCategory_ID) {
        if (C_TaxCategory_ID < 1) setValue(I_M_Product.COLUMNNAME_C_TaxCategory_ID, null);
        else setValue(I_M_Product.COLUMNNAME_C_TaxCategory_ID, C_TaxCategory_ID);
    }

    /**
     * Get UOM.
     *
     * @return Unit of Measure
     */
    public int getUOMId() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_C_UOM_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set UOM.
     *
     * @param C_UOM_ID Unit of Measure
     */
    public void setUOMId(int C_UOM_ID) {
        if (C_UOM_ID < 1) setValue(I_M_Product.COLUMNNAME_C_UOM_ID, null);
        else setValue(I_M_Product.COLUMNNAME_C_UOM_ID, C_UOM_ID);
    }

    /**
     * Get Description.
     *
     * @return Optional short description of the record
     */
    public String getDescription() {
        return (String) getValue(I_M_Product.COLUMNNAME_Description);
    }

    /**
     * Set Description.
     *
     * @param Description Optional short description of the record
     */
    public void setDescription(String Description) {
        setValue(I_M_Product.COLUMNNAME_Description, Description);
    }

    /**
     * Set Description URL.
     *
     * @param DescriptionURL URL for the description
     */
    public void setDescriptionURL(String DescriptionURL) {
        setValue(I_M_Product.COLUMNNAME_DescriptionURL, DescriptionURL);
    }

    /**
     * Set Document Note.
     *
     * @param DocumentNote Additional information for a Document
     */
    public void setDocumentNote(String DocumentNote) {
        setValue(I_M_Product.COLUMNNAME_DocumentNote, DocumentNote);
    }

    /**
     * Set Comment/Help.
     *
     * @param Help Comment or Hint
     */
    public void setHelp(String Help) {
        setValue(I_M_Product.COLUMNNAME_Help, Help);
    }

    /**
     * Set Image URL.
     *
     * @param ImageURL URL of image
     */
    public void setImageURL(String ImageURL) {
        setValue(I_M_Product.COLUMNNAME_ImageURL, ImageURL);
    }

    /**
     * Set Bill of Materials.
     *
     * @param IsBOM Bill of Materials
     */
    public void setIsBOM(boolean IsBOM) {
        setValue(I_M_Product.COLUMNNAME_IsBOM, IsBOM);
    }

    /**
     * Get Bill of Materials.
     *
     * @return Bill of Materials
     */
    public boolean isBOM() {
        Object oo = getValue(I_M_Product.COLUMNNAME_IsBOM);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(I_M_Product.COLUMNNAME_IsExcludeAutoDelivery, IsExcludeAutoDelivery);
    }

    /**
     * Get Exclude Auto Delivery.
     *
     * @return Exclude from automatic Delivery
     */
    public boolean isExcludeAutoDelivery() {
        Object oo = getValue(I_M_Product.COLUMNNAME_IsExcludeAutoDelivery);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(I_M_Product.COLUMNNAME_IsInvoicePrintDetails, IsInvoicePrintDetails);
    }

    /**
     * Get Manufactured.
     *
     * @return This product is manufactured
     */
    public boolean isManufactured() {
        Object oo = getValue(I_M_Product.COLUMNNAME_IsManufactured);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Own Box.
     *
     * @return Own Box
     */
    public boolean isOwnBox() {
        Object oo = getValue(I_M_Product.COLUMNNAME_IsOwnBox);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Phantom.
     *
     * @return Phantom Component
     */
    public boolean isPhantom() {
        Object oo = getValue(I_M_Product.COLUMNNAME_IsPhantom);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(
                I_M_Product.COLUMNNAME_IsPickListPrintDetails, IsPickListPrintDetails);
    }

    /**
     * Set Purchased.
     *
     * @param IsPurchased Organization purchases this product
     */
    public void setIsPurchased(boolean IsPurchased) {
        setValue(I_M_Product.COLUMNNAME_IsPurchased, IsPurchased);
    }

    /**
     * Set Self-Service.
     *
     * @param IsSelfService This is a Self-Service entry or this entry can be changed via Self-Service
     */
    public void setIsSelfService(boolean IsSelfService) {
        setValue(I_M_Product.COLUMNNAME_IsSelfService, IsSelfService);
    }

    /**
     * Set Sold.
     *
     * @param IsSold Organization sells this product
     */
    public void setIsSold(boolean IsSold) {
        setValue(I_M_Product.COLUMNNAME_IsSold, IsSold);
    }

    /**
     * Set Stocked.
     *
     * @param IsStocked Organization stocks this product
     */
    public void setIsStocked(boolean IsStocked) {
        setValue(I_M_Product.COLUMNNAME_IsStocked, IsStocked);
    }

    /**
     * Get Stocked.
     *
     * @return Organization stocks this product
     */
    public boolean isStocked() {
        Object oo = getValue(I_M_Product.COLUMNNAME_IsStocked);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
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
        setValue(I_M_Product.COLUMNNAME_IsSummary, IsSummary);
    }

    /**
     * Set Verified.
     *
     * @param IsVerified The BOM configuration has been verified
     */
    public void setIsVerified(boolean IsVerified) {
        setValueNoCheck(I_M_Product.COLUMNNAME_IsVerified, IsVerified);
    }

    /**
     * Get Verified.
     *
     * @return The BOM configuration has been verified
     */
    public boolean isVerified() {
        Object oo = getValue(I_M_Product.COLUMNNAME_IsVerified);
        if (oo != null) {
            if (oo instanceof Boolean) return (Boolean) oo;
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Featured in Web Store.
     *
     * @param IsWebStoreFeatured If selected, the product is displayed in the initial or any empty
     *                           search
     */
    public void setIsWebStoreFeatured(boolean IsWebStoreFeatured) {
        setValue(I_M_Product.COLUMNNAME_IsWebStoreFeatured, IsWebStoreFeatured);
    }

    /**
     * Set Low Level.
     *
     * @param LowLevel The Low Level is used to calculate the material plan and determines if a net
     *                 requirement should be exploited
     */
    public void setLowLevel(int LowLevel) {
        setValue(I_M_Product.COLUMNNAME_LowLevel, LowLevel);
    }

    public I_M_AttributeSet getMAttributeSet() throws RuntimeException {
        return (I_M_AttributeSet)
                MTable.get(I_M_AttributeSet.Table_Name)
                        .getPO(getAttributeSetId());
    }

    /**
     * Get Attribute Set.
     *
     * @return Product Attribute Set
     */
    public int getAttributeSetId() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_M_AttributeSet_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Attribute Set Instance.
     *
     * @return Product Attribute Set Instance
     */
    public int getAttributeSetInstanceId() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Attribute Set Instance.
     *
     * @param M_AttributeSetInstance_ID Product Attribute Set Instance
     */
    public void setAttributeSetInstanceId(int M_AttributeSetInstance_ID) {
        if (M_AttributeSetInstance_ID < 0)
            setValue(I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID, null);
        else
            setValue(
                    I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID,
                    M_AttributeSetInstance_ID);
    }

    /**
     * Get Locator.
     *
     * @return Warehouse Locator
     */
    public int getLocatorId() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_M_Locator_ID);
        if (ii == null) return 0;
        return ii;
    }

    public I_M_Product_Category getProductCategory() throws RuntimeException {
        return (I_M_Product_Category)
                MTable.get(I_M_Product_Category.Table_Name)
                        .getPO(getProductCategoryId());
    }

    /**
     * Get Product Category.
     *
     * @return Category of a Product
     */
    public int getProductCategoryId() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_M_Product_Category_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Product Category.
     *
     * @param M_Product_Category_ID Category of a Product
     */
    public void setProductCategoryId(int M_Product_Category_ID) {
        if (M_Product_Category_ID < 1) setValue(I_M_Product.COLUMNNAME_M_Product_Category_ID, null);
        else
            setValue(
                    I_M_Product.COLUMNNAME_M_Product_Category_ID, M_Product_Category_ID);
    }

    /**
     * Get Product.
     *
     * @return Product, Service, Item
     */
    public int getProductId() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_M_Product_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Name.
     *
     * @return Alphanumeric identifier of the entity
     */
    public String getName() {
        return (String) getValue(HasName.COLUMNNAME_Name);
    }

    /**
     * Set Name.
     *
     * @param Name Alphanumeric identifier of the entity
     */
    public void setName(String Name) {
        setValue(HasName.COLUMNNAME_Name, Name);
    }

    /**
     * Set Process Now.
     *
     * @param Processing Process Now
     */
    public void setProcessing(boolean Processing) {
        setValue(I_M_Product.COLUMNNAME_Processing, Processing);
    }

    /**
     * Get Product Type.
     *
     * @return Type of product
     */
    public String getProductType() {
        return (String) getValue(I_M_Product.COLUMNNAME_ProductType);
    }

    /**
     * Set Product Type.
     *
     * @param ProductType Type of product
     */
    public void setProductType(String ProductType) {

        setValue(I_M_Product.COLUMNNAME_ProductType, ProductType);
    }

    /**
     * Get Expense Type.
     *
     * @return Expense report type
     */
    public int getExpenseTypeId() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_S_ExpenseType_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Expense Type.
     *
     * @param S_ExpenseType_ID Expense report type
     */
    public void setExpenseTypeId(int S_ExpenseType_ID) {
        if (S_ExpenseType_ID < 1) setValueNoCheck(I_M_Product.COLUMNNAME_S_ExpenseType_ID, null);
        else
            setValueNoCheck(I_M_Product.COLUMNNAME_S_ExpenseType_ID, S_ExpenseType_ID);
    }

    /**
     * Get Shelf Depth.
     *
     * @return Shelf depth required
     */
    public int getShelfDepth() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_ShelfDepth);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Shelf Height.
     *
     * @return Shelf height required
     */
    public BigDecimal getShelfHeight() {
        BigDecimal bd = (BigDecimal) getValue(I_M_Product.COLUMNNAME_ShelfHeight);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Get Shelf Width.
     *
     * @return Shelf width required
     */
    public int getShelfWidth() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_ShelfWidth);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set SKU.
     *
     * @param SKU Stock Keeping Unit
     */
    public void setSKU(String SKU) {
        setValue(I_M_Product.COLUMNNAME_SKU, SKU);
    }

    /**
     * Get Resource.
     *
     * @return Resource
     */
    public int getResourceID() {
        Integer ii = (Integer) getValue(I_M_Product.COLUMNNAME_S_Resource_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Resource.
     *
     * @param S_Resource_ID Resource
     */
    public void setResourceID(int S_Resource_ID) {
        if (S_Resource_ID < 1) setValueNoCheck(I_M_Product.COLUMNNAME_S_Resource_ID, null);
        else setValueNoCheck(I_M_Product.COLUMNNAME_S_Resource_ID, S_Resource_ID);
    }

    /**
     * Set UPC/EAN.
     *
     * @param UPC Bar Code (Universal Product Code or its superset European Article Number)
     */
    public void setUPC(String UPC) {
        setValue(I_M_Product.COLUMNNAME_UPC, UPC);
    }

    /**
     * Get Search Key.
     *
     * @return Search key for the record in the format required - must be unique
     */
    public String getSearchKey() {
        return (String) getValue(I_M_Product.COLUMNNAME_Value);
    }

    /**
     * Set Search Key.
     *
     * @param Value Search key for the record in the format required - must be unique
     */
    public void setSearchKey(String Value) {
        setValue(I_M_Product.COLUMNNAME_Value, Value);
    }

    /**
     * Get Version No.
     *
     * @return Version Number
     */
    public String getVersionNo() {
        return (String) getValue(I_M_Product.COLUMNNAME_VersionNo);
    }

    /**
     * Get Volume.
     *
     * @return Volume of a product
     */
    public BigDecimal getVolume() {
        BigDecimal bd = (BigDecimal) getValue(I_M_Product.COLUMNNAME_Volume);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Volume.
     *
     * @param Volume Volume of a product
     */
    public void setVolume(BigDecimal Volume) {
        setValue(I_M_Product.COLUMNNAME_Volume, Volume);
    }

    /**
     * Get Weight.
     *
     * @return Weight of a product
     */
    public BigDecimal getWeight() {
        BigDecimal bd = (BigDecimal) getValue(I_M_Product.COLUMNNAME_Weight);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Weight.
     *
     * @param Weight Weight of a product
     */
    public void setWeight(BigDecimal Weight) {
        setValue(I_M_Product.COLUMNNAME_Weight, Weight);
    }

    @Override
    public int getTableId() {
        return I_M_Product.Table_ID;
    }
}
