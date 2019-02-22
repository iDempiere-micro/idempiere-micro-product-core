package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_Product;
import org.compiere.orm.MClient;
import org.compiere.orm.MTree_Base;
import org.compiere.orm.Query;
import org.compiere.orm.X_AD_Tree;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.util.CCache;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

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
            new CCache<Integer, MProduct>(I_M_Product.Table_Name, 40, 5); // 	5 minutes
    /**
     * UOM Precision
     */
    protected Integer m_precision = null;
    /**
     * Additional Downloads
     */
    private MProductDownload[] m_downloads = null;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param ctx          context
     * @param M_Product_ID id
     * @param trxName      transaction
     */
    public MProduct(Properties ctx, int M_Product_ID) {
        super(ctx, M_Product_ID);
        if (M_Product_ID == 0) {
            //	setValue (null);
            //	setName (null);
            //	setM_Product_Category_ID (0);
            //	setC_TaxCategory_ID (0);
            //	setC_UOM_ID (0);
            //
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
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MProduct(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    } //	MProduct

    public MProduct(Properties ctx, Row row) {
        super(ctx, row);
    } //	MProduct

    /**
     * Parent Constructor
     *
     * @param et parent
     */
    public MProduct(MExpenseType et) {
        this(et.getCtx(), 0);
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
        this(resource.getCtx(), 0);
        setAD_Org_ID(resource.getOrgId());
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
        this(impP.getCtx(), 0);
        setClientOrg(impP);
        setUpdatedBy(impP.getUpdatedBy());
        //
        setValue(impP.getValue());
        setName(impP.getName());
        setDescription(impP.getDescription());
        setDocumentNote(impP.getDocumentNote());
        setHelp(impP.getHelp());
        setUPC(impP.getUPC());
        setSKU(impP.getSKU());
        setC_UOM_ID(impP.getC_UOM_ID());
        setM_Product_Category_ID(impP.getM_Product_Category_ID());
        setProductType(impP.getProductType());
        setImageURL(impP.getImageURL());
        setDescriptionURL(impP.getDescriptionURL());
        setVolume(impP.getVolume());
        setWeight(impP.getWeight());
    } //	MProduct

    /**
     * Get MProduct from Cache
     *
     * @param ctx          context
     * @param M_Product_ID id
     * @return MProduct or null
     */
    public static MProduct get(Properties ctx, int M_Product_ID) {
        if (M_Product_ID <= 0) {
            return null;
        }
        Integer key = new Integer(M_Product_ID);
        MProduct retValue = (MProduct) s_cache.get(key);
        if (retValue != null) {
            return retValue;
        }
        retValue = new MProduct(ctx, M_Product_ID);
        if (retValue.getId() != 0) {
            s_cache.put(key, retValue);
        }
        return retValue;
    } //	get

    /**
     * Get MProduct from Cache
     *
     * @param ctx         context
     * @param whereClause sql where clause
     * @param trxName     trx
     * @return MProduct
     */
    public static MProduct[] get(Properties ctx, String whereClause) {
        List<MProduct> list =
                new Query(ctx, I_M_Product.Table_Name, whereClause).setClient_ID().list();
        return list.toArray(new MProduct[list.size()]);
    } //	get

    /**
     * Get Product from Cache
     *
     * @param ctx           context
     * @param S_Resource_ID resource ID
     * @param trxName
     * @return MProduct or null if not found
     */
    public static MProduct forS_Resource_ID(Properties ctx, int S_Resource_ID) {
        if (S_Resource_ID <= 0) {
            return null;
        }

        for (MProduct p : s_cache.values()) {
            if (p.getS_Resource_ID() == S_Resource_ID) {
                return p;
            }
        }
        // Load from DB
        MProduct p =
                new Query(ctx, I_M_Product.Table_Name, I_M_Product.COLUMNNAME_S_Resource_ID + "=?")
                        .setParameters(new Object[]{S_Resource_ID})
                        .firstOnly();
        if (p != null) {
            s_cache.put(p.getM_Product_ID(), p);
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
        if (parent.getS_ExpenseType_ID() != getS_ExpenseType_ID()) {
            setS_ExpenseType_ID(parent.getS_ExpenseType_ID());
            changed = true;
        }
        if (parent.isActive() != isActive()) {
            setIsActive(parent.isActive());
            changed = true;
        }
        //
        if (!parent.getValue().equals(getValue())) {
            setValue(parent.getValue());
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
        if (parent.getC_UOM_ID() != getC_UOM_ID()) {
            setC_UOM_ID(parent.getC_UOM_ID());
            changed = true;
        }
        if (parent.getM_Product_Category_ID() != getM_Product_Category_ID()) {
            setM_Product_Category_ID(parent.getM_Product_Category_ID());
            changed = true;
        }
        if (parent.getC_TaxCategory_ID() != getC_TaxCategory_ID()) {
            setC_TaxCategory_ID(parent.getC_TaxCategory_ID());
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
        if (parent.getS_Resource_ID() != getS_Resource_ID()) {
            setS_Resource_ID(parent.getS_Resource_ID());
            changed = true;
        }
        if (parent.isActive() != isActive()) {
            setIsActive(parent.isActive());
            changed = true;
        }
        //
        if (!parent.getValue().equals(getValue())) {
            setValue(parent.getValue());
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
        if (parent.getC_UOM_ID() != getC_UOM_ID()) {
            setC_UOM_ID(parent.getC_UOM_ID());
            changed = true;
        }
        if (parent.getM_Product_Category_ID() != getM_Product_Category_ID()) {
            setM_Product_Category_ID(parent.getM_Product_Category_ID());
            changed = true;
        }
        if (parent.getC_TaxCategory_ID() != getC_TaxCategory_ID()) {
            setC_TaxCategory_ID(parent.getC_TaxCategory_ID());
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
            int C_UOM_ID = getC_UOM_ID();
            if (C_UOM_ID == 0) return 0; // 	EA
            m_precision = new Integer(MUOM.getPrecision(getCtx(), C_UOM_ID));
        }
        return m_precision.intValue();
    } //	getUOMPrecision

    /**
     * Create Asset Group for this product
     *
     * @return asset group id
     */
    public int getA_Asset_Group_ID() {
        MProductCategory pc = MProductCategory.get(getCtx(), getM_Product_Category_ID());
        return pc.getA_Asset_Group_ID();
    } //	getA_Asset_Group_ID

    /**
     * Create Asset for this product
     *
     * @return true if asset is created
     */
    public boolean isCreateAsset() {
        MProductCategory pc = MProductCategory.get(getCtx(), getM_Product_Category_ID());
        return pc.getA_Asset_Group_ID() != 0;
    } //	isCreated

    /**
     * Get Attribute Set
     *
     * @return set or null
     */
    public MAttributeSet getAttributeSet() {
        if (getMAttributeSet_ID() != 0) return MAttributeSet.get(getCtx(), getMAttributeSet_ID());
        return null;
    } //	getAttributeSet

    /**
     * Has the Product Instance Attribute
     *
     * @return true if instance attributes
     */
    public boolean isInstanceAttribute() {
        if (getMAttributeSet_ID() == 0) return false;
        MAttributeSet mas = MAttributeSet.get(getCtx(), getMAttributeSet_ID());
        return mas.isInstanceAttribute();
    } //	isInstanceAttribute

    /**
     * Create One Asset Per UOM
     *
     * @return individual asset
     */
    public boolean isOneAssetPerUOM() {
        MProductCategory pc = MProductCategory.get(getCtx(), getM_Product_Category_ID());
        if (pc.getA_Asset_Group_ID() == 0) return false;
        MAssetGroup ag = MAssetGroup.get(getCtx(), pc.getA_Asset_Group_ID());
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
        StringBuilder sb = new StringBuilder("MProduct[");
        sb.append(getId()).append("-").append(getValue()).append("]");
        return sb.toString();
    } //	toString

    @Override
    protected boolean beforeSave(boolean newRecord) {

        //	Reset Stocked if not Item
        // AZ Goodwill: Bug Fix isStocked always return false
        // if (isStocked() && !PRODUCTTYPE_Item.equals(getProductType()))
        if (!I_M_Product.PRODUCTTYPE_Item.equals(getProductType())) setIsStocked(false);

        //	UOM reset
        if (m_precision != null && is_ValueChanged("C_UOM_ID")) m_precision = null;

        // AttributeSetInstance reset
        if (getMAttributeSetInstance_ID() > 0
                && is_ValueChanged(I_M_Product.COLUMNNAME_M_AttributeSet_ID)) {
            MAttributeSetInstance asi =
                    new MAttributeSetInstance(getCtx(), getMAttributeSetInstance_ID());
            if (asi.getMAttributeSet_ID() != getMAttributeSet_ID()) setM_AttributeSetInstance_ID(0);
        }
        if (!newRecord && is_ValueChanged(I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID)) {
            // IDEMPIERE-2752 check if the ASI is referenced in other products before trying to delete it
            int oldasiid = get_ValueOldAsInt(I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID);
            if (oldasiid > 0) {
                MAttributeSetInstance oldasi =
                        new MAttributeSetInstance(
                                getCtx(),
                                get_ValueOldAsInt(I_M_Product.COLUMNNAME_M_AttributeSetInstance_ID));
                int cnt =
                        getSQLValueEx(
                                null,
                                "SELECT COUNT(*) FROM M_Product WHERE M_AttributeSetInstance_ID=?",
                                oldasi.getMAttributeSetInstance_ID());
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
        if (!newRecord && (is_ValueChanged("Name") || is_ValueChanged("Description"))) {
            String sql =
                    "UPDATE A_Asset a "
                            + "SET (Name, Description)="
                            + "(SELECT SUBSTR((SELECT bp.Name FROM C_BPartner bp WHERE bp.C_BPartner_ID=a.C_BPartner_ID) || ' - ' || p.Name,1,60), p.Description "
                            + "FROM M_Product p "
                            + "WHERE p.M_Product_ID=a.M_Product_ID) "
                            + "WHERE IsActive='Y'"
                            //	+ " AND GuaranteeDate > SysDate"
                            + "  AND M_Product_ID="
                            + getM_Product_ID();
            int no = executeUpdate(sql);
            if (log.isLoggable(Level.FINE)) log.fine("Asset Description updated #" + no);
        }

        //	New - Acct, Tree, Old Costing
        if (newRecord) {
            insert_Accounting(
                    "M_Product_Acct",
                    "M_Product_Category_Acct",
                    "p.M_Product_Category_ID=" + getM_Product_Category_ID());
            insert_Tree(X_AD_Tree.TREETYPE_Product);
        }
        if (newRecord || is_ValueChanged(I_M_Product.COLUMNNAME_Value))
            update_Tree(MTree_Base.TREETYPE_Product);

        return success;
    } //	afterSave

    @Override
    protected boolean beforeDelete() {
        if (I_M_Product.PRODUCTTYPE_Resource.equals(getProductType()) && getS_Resource_ID() > 0) {
            throw new AdempiereException("@S_Resource_ID@<>0");
        }

        // [ 1674225 ] Delete Product: Costing deletion error
    /*MAcctSchema[] mass = MAcctSchema.getClientAcctSchema(getCtx(),getADClientID(), null);
    for(int i=0; i<mass.length; i++)
    {
    	// Get Cost Elements
    	MCostElement[] ces = MCostElement.getMaterialWithCostingMethods(this);
    	MCostElement ce = null;
    	for(int j=0; j<ces.length; j++)
    	{
    		if(MCostElement.COSTINGMETHOD_StandardCosting.equals(ces[i].getCostingMethod()))
    		{
    			ce = ces[i];
    			break;
    		}
    	}

    	if(ce == null)
    		continue;

    	MCost mcost = MCost.get(this, 0, mass[i], 0, ce.getM_CostElement_ID());
    	mcost.delete(true, null);
    }*/

        //
        return true;
    } //	beforeDelete

    @Override
    protected boolean afterDelete(boolean success) {
        if (success) delete_Tree(X_AD_Tree.TREETYPE_Product);
        return success;
    } //	afterDelete

    /**
     * Gets Material Management Policy. Tries: Product Category, Client (in this order)
     *
     * @return Material Management Policy
     */
    public String getMMPolicy() {
        MProductCategory pc = MProductCategory.get(getCtx(), getM_Product_Category_ID());
        String MMPolicy = pc.getMMPolicy();
        if (MMPolicy == null || MMPolicy.length() == 0) MMPolicy = MClient.get(getCtx()).getMMPolicy();
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
} //	MProduct
