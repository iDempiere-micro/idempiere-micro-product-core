package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_S_Resource;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.util.CCache;

/**
 * Resource Model
 *
 * @author Jorg Janke
 * @author Teo Sarca, www.arhipac.ro
 *     <li>FR [ 2051056 ] MResource[Type] should be cached
 *     <li>BF [ 2227901 ] MRP (Calculate Material Plan) fails if resource is empty
 *     <li>BF [ 2824795 ] Deleting Resource product should be forbidden
 *         https://sourceforge.net/tracker/?func=detail&aid=2824795&group_id=176962&atid=879332
 * @version $Id: MResource.java,v 1.2 2006/07/30 00:51:05 jjanke Exp $
 */
public class MResource extends X_S_Resource {
  /** */
  private static final long serialVersionUID = 6799272062821593975L;
  /** Cache */
  private static CCache<Integer, MResource> s_cache =
      new CCache<Integer, MResource>(I_S_Resource.Table_Name, 20);
  /** Cached Resource Type */
  private MResourceType m_resourceType = null;
  /** Cached Product */
  private MProduct m_product = null;

  /**
   * Standard Constructor
   *
   * @param ctx context
   * @param S_Resource_ID id
   */
  public MResource(Properties ctx, int S_Resource_ID, String trxName) {
    super(ctx, S_Resource_ID, trxName);
  } //	MResource

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   */
  public MResource(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  } //	MResource

  /**
   * Get from Cache
   *
   * @param ctx
   * @param S_Resource_ID
   * @return MResource
   */
  public static MResource get(Properties ctx, int S_Resource_ID) {
    if (S_Resource_ID <= 0) return null;
    MResource r = s_cache.get(S_Resource_ID);
    if (r == null) {
      r = new MResource(ctx, S_Resource_ID, null);
      if (r.getId() == S_Resource_ID) {
        s_cache.put(S_Resource_ID, r);
      }
    }
    return r;
  }

  /**
   * Get cached Resource Type
   *
   * @return Resource Type
   */
  public MResourceType getResourceType() {
    // Use cache if we are outside transaction:
    if (null == null && getS_ResourceType_ID() > 0)
      return MResourceType.get(getCtx(), getS_ResourceType_ID());
    //
    if (m_resourceType == null && getS_ResourceType_ID() != 0) {
      m_resourceType = new MResourceType(getCtx(), getS_ResourceType_ID(), null);
    }
    return m_resourceType;
  } //	getResourceType

  /**
   * Get Product (use cache)
   *
   * @return product
   */
  public MProduct getProduct() {
    if (m_product == null) {
      m_product = MProduct.forS_Resource_ID(getCtx(), getS_Resource_ID(), null);
    } else {
      m_product.set_TrxName(null);
    }
    return m_product;
  } //	getProduct

  public int getC_UOM_ID() {
    return getProduct().getC_UOM_ID();
  }

  @Override
  protected boolean beforeSave(boolean newRecord) {
    if (newRecord) {
      if (getValue() == null || getValue().length() == 0) setValue(getName());
      m_product = new MProduct(this, getResourceType());
      m_product.saveEx(null);
    }
    //
    // Validate Manufacturing Resource
    if (isManufacturingResource()
        && X_S_Resource.MANUFACTURINGRESOURCETYPE_Plant.equals(getManufacturingResourceType())
        && getPlanningHorizon() <= 0) {
      throw new AdempiereException("@" + I_S_Resource.COLUMNNAME_PlanningHorizon + "@ <= @0@ !");
    }
    return true;
  } //	beforeSave

  @Override
  protected boolean afterSave(boolean newRecord, boolean success) {
    if (!success) return success;

    MProduct prod = getProduct();
    if (prod.setResource(this)) prod.saveEx(null);

    return success;
  } //	afterSave

  @Override
  protected boolean beforeDelete() {
    // Delete product
    MProduct product = getProduct();
    if (product != null && product.getM_Product_ID() > 0) {
      product.setS_Resource_ID(0); // unlink resource
      product.deleteEx(true);
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuffer sb =
        new StringBuffer("MResource[")
            .append(getId())
            .append(", Value=")
            .append(getValue())
            .append(", Name=")
            .append(getName())
            .append("]");
    return sb.toString();
  }
} //	MResource