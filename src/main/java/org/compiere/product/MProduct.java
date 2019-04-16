package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_C_UOM;
import org.compiere.model.I_M_Product;
import org.compiere.model.I_M_StorageOnHand;
import org.compiere.orm.MClientKt;
import org.compiere.orm.MTable;
import org.compiere.orm.Query;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.util.AdempiereSystemError;
import org.idempiere.common.util.CCache;

import java.util.List;
import java.util.logging.Level;

import static org.compiere.orm.MTree_Base.TREETYPE_Product;
import static software.hsharp.core.util.DBKt.executeUpdate;
import static software.hsharp.core.util.DBKt.getSQLValueEx;

/**
 * Product Model
 *
 * @author Jorg Janke
 * @author Teo Sarca, SC ARHIPAC SERVICE SRL
 * <li>FR [ 1885153 ] Refactor: getMMPolicy code
 * <li>BF [ 1885414 ] ASI should be always mandatory if CostingLevel is Batch/Lot
 * <li>FR [ 2093551 ] Refactor/Add MProduct.getCostingLevel
 * <li>FR [ 2093569 ] Refactor/Add MProduct.getCostingMethod
 * <li>BF [ 2824795 ] Deleting Resource product should be forbidden
 * https://sourceforge.net/tracker/?func=detail&aid=2824795&group_id=176962&atid=879332
 * @author Mark Ostermann (mark_o), metas consult GmbH
 * <li>BF [ 2814628 ] Wrong evaluation of Product inactive in beforeSave()
 * @version $Id: MProduct.java,v 1.5 2006/07/30 00:51:05 jjanke Exp $
 */
public class MProduct extends X_M_Product implements I_M_Product {
    /**
     *
     */
    private static final long serialVersionUID = 285926961771269935L;
    /**
     * Cache
     */
    private static CCache<Integer, MProduct> s_cache =
            new CCache<>(I_M_Product.Table_Name, 40, 5); // 	5 minutes
    /**
     * UOM Precision
     */
    protected Integer m_precision = null;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param M_Product_ID id
     */
    public MProduct(int M_Product_ID) {
        super(M_Product_ID);
        if (M_Product_ID == 0) {
            setProductType(I_M_Product.PRODUCTTYPE_Item); // I
            setIsBOM(false); // N
            setIsInvoicePrintDetails(false);
            setIsPickListPrintDetails(false);
            setIsPurchased(true); // Y
            setIsSold(true); // Y
            setIsStocked(true); // Y
            setIsSummary(false);
            setIsVerified(false); // N
            setIsWebStoreFeatured(false);
            setIsSelfService(true);
            setIsExcludeAutoDelivery(false);
            setProcessing(false); // N
            setLowLevel(0);
        }
    } //	MProduct

    /**
     * Load constructor
     */
    public MProduct(Row row) {
        super(row);
    } //	MProduct

    /**
     * Parent Constructor
     *
     * @param et parent
     */
    public MProduct(MExpenseType et) {
        this(0);
        setProductType(I_M_Product.PRODUCTTYPE_ExpenseType);
        setExpenseType(et);
    } //	MProduct

    /**
     * Parent Constructor
     *
     * @param resource     parent
     * @param resourceType resource type
     */
    public MProduct(MResource resource, MResourceType resourceType) {
        this(0);
        setOrgId(resource.getOrgId());
        setProductType(I_M_Product.PRODUCTTYPE_Resource);
        setResource(resource);
        setResource(resourceType);
    } //	MProduct

    /**
     * Import Constructor
     *
     * @param impP import
     */
    public MProduct(X_I_Product impP) {
        this(0);
        setClientOrg(impP);
        setUpdatedBy(impP.getUpdatedBy());
        //
        setSearchKey(impP.getSearchKey());
        setName(impP.getName());
        setDescription(impP.getDescription());
        setDocumentNote(impP.getDocumentNote());
        setHelp(impP.getHelp());
        setUPC(impP.getUPC());
        setSKU(impP.getSKU());
        setUOMId(impP.getUOMId());
        setProductCategoryId(impP.getProductCategoryId());
        setProductType(impP.getProductType());
        setImageURL(impP.getImageURL());
        setDescriptionURL(impP.getDescriptionURL());
        setVolume(impP.getVolume());
        setWeight(impP.getWeight());
    } //	MProduct

    /**
     * Get MProduct from Cache
     *
     * @param M_Product_ID id
     * @return MProduct or null
     */
    public static MProduct get(int M_Product_ID) {
        if (M_Product_ID <= 0) {
            return null;
        }
        Integer key = M_Product_ID;
        MProduct retValue = s_cache.get(key);
        if (retValue != null) {
            return retValue;
        }
        retValue = new MProduct(M_Product_ID);
        if (retValue.getId() != 0) {
            s_cache.put(key, retValue);
        }
        return retValue;
    } //	get

    /**
     * Get MProduct from Cache
     *
     * @param whereClause sql where clause
     * @return MProduct
     */
    public static MProduct[] get(String whereClause) {
        List<MProduct> list =
                new Query(I_M_Product.Table_Name, whereClause).setClientId().list();
        return list.toArray(new MProduct[0]);
    } //	get

    /**
     * Get Product from Cache
     *
     * @param S_Resource_ID resource ID
     * @return MProduct or null if not found
     */
    public static MProduct forS_ResourceId(int S_Resource_ID) {
        if (S_Resource_ID <= 0) {
            return null;
        }

        for (MProduct p : s_cache.values()) {
            if (p.getResourceID() == S_Resource_ID) {
                return p;
            }
        }
        // Load from DB
        MProduct p =
                new Query(I_M_Product.Table_Name, I_M_Product.COLUMNNAME_S_Resource_ID + "=?")
                        .setParameters(S_Resource_ID)
                        .firstOnly();
        if (p != null) {
            s_cache.put(p.getProductId(), p);
        }
        return p;
    }

    /**
     * get ProductPricing instance
     *
     * @return instance of the IProductPricing or null
     */
    public static IProductPricing getProductPricing() {
        return new DefaultProductPricingFactory().newProductPricingInstance();
    }

    /**
     * Set Expense Type
     *
     * @param parent expense type
     * @return true if changed
     */
    public boolean setExpenseType(MExpenseType parent) {
        boolean changed = false;
        if (!I_M_Product.PRODUCTTYPE_ExpenseType.equals(getProductType())) {
            setProductType(I_M_Product.PRODUCTTYPE_ExpenseType);
            changed = true;
        }
        if (parent.getExpenseTypeId() != getExpenseTypeId()) {
            setExpenseTypeId(parent.getExpenseTypeId());
            changed = true;
        }
        if (parent.isActive() != isActive()) {
            setIsActive(parent.isActive());
            changed = true;
        }
        //
        if (!parent.getSearchKey().equals(getSearchKey())) {
            setSearchKey(parent.getSearchKey());
            changed = true;
        }
        if (!parent.getName().equals(getName())) {
            setName(parent.getName());
            changed = true;
        }
        if ((parent.getDescription() == null && getDescription() != null)
                || (parent.getDescription() != null && !parent.getDescription().equals(getDescription()))) {
            setDescription(parent.getDescription());
            changed = true;
        }
        if (parent.getUOMId() != getUOMId()) {
            setUOMId(parent.getUOMId());
            changed = true;
        }
        if (parent.getProductCategoryId() != getProductCategoryId()) {
            setProductCategoryId(parent.getProductCategoryId());
            changed = true;
        }
        if (parent.getTaxCategoryId() != getTaxCategoryId()) {
            setTaxCategoryId(parent.getTaxCategoryId());
            changed = true;
        }
        //
        return changed;
    } //	setExpenseType

    /**
     * Set Resource
     *
     * @param parent resource
     * @return true if changed
     */
    public boolean setResource(MResource parent) {
        boolean changed = false;
        if (!I_M_Product.PRODUCTTYPE_Resource.equals(getProductType())) {
            setProductType(I_M_Product.PRODUCTTYPE_Resource);
            changed = true;
        }
        if (parent.getResourceId() != getResourceID()) {
            setResourceID(parent.getResourceId());
            changed = true;
        }
        if (parent.isActive() != isActive()) {
            setIsActive(parent.isActive());
            changed = true;
        }
        //
        if (!parent.getValue().equals(getSearchKey())) {
            setSearchKey(parent.getValue());
            changed = true;
        }
        if (!parent.getName().equals(getName())) {
            setName(parent.getName());
            changed = true;
        }
        if ((parent.getDescription() == null && getDescription() != null)
                || (parent.getDescription() != null && !parent.getDescription().equals(getDescription()))) {
            setDescription(parent.getDescription());
            changed = true;
        }
        //
        return changed;
    } //	setResource

    /**
     * Set Resource Type
     *
     * @param parent resource type
     * @return true if changed
     */
    public boolean setResource(MResourceType parent) {
        boolean changed = false;
        if (I_M_Product.PRODUCTTYPE_Resource.equals(getProductType())) {
            setProductType(I_M_Product.PRODUCTTYPE_Resource);
            changed = true;
        }
        //
        if (parent.getUOMId() != getUOMId()) {
            setUOMId(parent.getUOMId());
            changed = true;
        }
        if (parent.getProductCategoryId() != getProductCategoryId()) {
            setProductCategoryId(parent.getProductCategoryId());
            changed = true;
        }
        if (parent.getTaxCategoryId() != getTaxCategoryId()) {
            setTaxCategoryId(parent.getTaxCategoryId());
            changed = true;
        }
        //
        return changed;
    } //	setResource

    /**
     * Get UOM Standard Precision
     *
     * @return UOM Standard Precision
     */
    public int getUOMPrecision() {
        if (m_precision == null) {
            int C_UOM_ID = getUOMId();
            if (C_UOM_ID == 0) return 0; // 	EA
            m_precision = MUOM.getPrecision(C_UOM_ID);
        }
        return m_precision;
    } //	getUOMPrecision

    /**
     * Create Asset Group for this product
     *
     * @return asset group id
     */
    public int getAssetGroupId() {
        MProductCategory pc = MProductCategory.get(getProductCategoryId());
        return pc.getAssetGroupId();
    } //	getAssetGroupId

    /**
     * Create Asset for this product
     *
     * @return true if asset is created
     */
    public boolean isCreateAsset() {
        MProductCategory pc = MProductCategory.get(getProductCategoryId());
        return pc.getAssetGroupId() != 0;
    } //	isCreated

    /**
     * Get Attribute Set
     *
     * @return set or null
     */
    public MAttributeSet getAttributeSet() {
        if (getAttributeSetId() != 0) return MAttributeSet.get(getAttributeSetId());
        return null;
    } //	getAttributeSet

    /**
     * Has the Product Instance Attribute
     *
     * @return true if instance attributes
     */
    public boolean isInstanceAttribute() {
        if (getAttributeSetId() == 0) return false;
        MAttributeSet mas = MAttributeSet.get(getAttributeSetId());
        return mas.isInstanceAttribute();
    } //	isInstanceAttribute

    /**
     * Create One Asset Per UOM
     *
     * @return individual asset
     */
    public boolean isOneAssetPerUOM() {
        MProductCategory pc = MProductCategory.get(getProductCategoryId());
        if (pc.getAssetGroupId() == 0) return false;
        MAssetGroup ag = MAssetGroup.get(pc.getAssetGroupId());
        return ag.isOneAssetPerUOM();
    } //	isOneAssetPerUOM

    /**
     * Product is Item
     *
     * @return true if item
     */
    public boolean isItem() {
        return I_M_Product.PRODUCTTYPE_Item.equals(getProductType());
    } //	isItem

    @Override
    public List<I_M_StorageOnHand> getStorageOnHand() {
        return null;
    }

    @Override
    public boolean isASIMandatory(boolean soTrx) {
        throw new Error("Do not know, use org.compiere.accounting.MProduct if you need this");
    }

    /**
     * Product is an Item and Stocked
     *
     * @return true if stocked and item
     */
    @Override
    public boolean isStocked() {
        return super.isStocked() && isItem();
    } //	isStocked

    /**
     * Is Service
     *
     * @return true if service (resource, online)
     */
    public boolean isService() {
        //	PRODUCTTYPE_Service, PRODUCTTYPE_Resource, PRODUCTTYPE_Online
        return !isItem(); //
    } //	isService

    @Override
    public String toString() {
        return "MProduct[" + getId() + "-" + getSearchKey() + "]";
    } //	toString

    @Override
    protected boolean beforeSave(boolean newRecord) {

        //	Reset Stocked if not Item
        // AZ Goodwill: Bug Fix isStocked always return false
        // if (isStocked() && !PRODUCTTYPE_Item.equals(getProductType()))
        if (!I_M_Product.PRODUCTTYPE_Item.equals(getProductType())) setIsStocked(false);

        //	UOM reset
        if (m_precision != null && isValueChanged("C_UOM_ID")) m_precision = null;

        // AttributeSetInstance reset
        if (getAttributeSetInstanceId() > 0
                && isValueChanged(I_M_Product.COLUMNNAME_M_AttributeSet_ID)) {
            MAttributeSetInstance asi =
                    new MAttributeSetInstance(getAttributeSetInstanceId());
            if (asi.getAttributeSetId() != getAttributeSetId()) setAttributeSetInstanceId(0);
        }
        if (!newRecord && isValueChanged(I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID)) {
            // IDEMPIERE-2752 check if the ASI is referenced in other products before trying to delete it
            int oldasiid = getValueOldAsInt(I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID);
            if (oldasiid > 0) {
                MAttributeSetInstance oldasi =
                        new MAttributeSetInstance(

                                getValueOldAsInt(I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID));
                int cnt =
                        getSQLValueEx(
                                "SELECT COUNT(*) FROM M_Product WHERE M_AttributeSetInstance_ID=?",
                                oldasi.getAttributeSetInstanceId());
                if (cnt == 1) {
                    // Delete the old m_attributesetinstance
                    try {
                        oldasi.deleteEx(true);
                    } catch (AdempiereException ex) {
                        log.saveError("Error", "Error deleting the AttributeSetInstance");
                        return false;
                    }
                }
            }
        }

        return true;
    } //	beforeSave

    @Override
    protected boolean afterSave(boolean newRecord, boolean success) {
        if (!success) return success;

        //	Name/Description Change in Asset	MAsset.setValueNameDescription
        if (!newRecord && (isValueChanged("Name") || isValueChanged("Description"))) {
            String sql =
                    "UPDATE A_Asset a "
                            + "SET (Name, Description)="
                            + "(SELECT SUBSTR((SELECT bp.Name FROM C_BPartner bp WHERE bp.C_BPartner_ID=a.C_BPartner_ID) || ' - ' || p.Name,1,60), p.Description "
                            + "FROM M_Product p "
                            + "WHERE p.M_Product_ID=a.M_Product_ID) "
                            + "WHERE IsActive='Y'"
                            //	+ " AND GuaranteeDate > SysDate"
                            + "  AND M_Product_ID="
                            + getProductId();
            int no = executeUpdate(sql);
            if (log.isLoggable(Level.FINE)) log.fine("Asset Description updated #" + no);
        }

        //	New - Acct, Tree, Old Costing
        if (newRecord) {
            insert_Accounting(
                    "M_Product_Acct",
                    "M_Product_Category_Acct",
                    "p.M_Product_Category_ID=" + getProductCategoryId());
            insert_Tree(TREETYPE_Product);
        }
        if (newRecord || isValueChanged(I_M_Product.COLUMNNAME_Value))
            update_Tree(TREETYPE_Product);

        return success;
    } //	afterSave

    @Override
    protected boolean beforeDelete() {
        if (I_M_Product.PRODUCTTYPE_Resource.equals(getProductType()) && getResourceID() > 0) {
            throw new AdempiereException("@S_Resource_ID@<>0");
        }

        //
        return true;
    } //	beforeDelete

    @Override
    protected boolean afterDelete(boolean success) {
        if (success) delete_Tree(TREETYPE_Product);
        return success;
    } //	afterDelete

    /**
     * Gets Material Management Policy. Tries: Product Category, Client (in this order)
     *
     * @return Material Management Policy
     */
    public String getMMPolicy() {
        MProductCategory pc = MProductCategory.get(getProductCategoryId());
        String MMPolicy = pc.getMMPolicy();
        if (MMPolicy == null || MMPolicy.length() == 0) MMPolicy = MClientKt.getClient().getMMPolicy();
        return MMPolicy;
    }

    /**
     * Check if use GuaranteeDate for Material Policy
     *
     * @return
     */
    public boolean isUseGuaranteeDateForMPolicy() {
        MAttributeSet as = getAttributeSet();
        if (as == null) return false;
        if (!as.isGuaranteeDate()) return false;

        return as.isUseGuaranteeDateForMPolicy();
    }

    public org.compiere.model.I_C_UOM getUOM() throws RuntimeException {
        return (I_C_UOM) MTable.get(org.compiere.model.I_C_UOM.Table_Name)
                .getPO(getUOMId());
    }
} //	MProduct
