package org.compiere.product;

import static software.hsharp.core.util.DBKt.close;
import static software.hsharp.core.util.DBKt.prepareStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import org.compiere.model.I_M_Product;
import org.compiere.util.Msg;
import org.idempiere.common.util.CCache;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.Env;

/**
 * Product Category Model
 *
 * @author Jorg Janke
 * @version $Id: MProductCategory.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MProductCategory extends X_M_Product_Category {
  /** */
  private static final long serialVersionUID = 1239249591584452179L;
  /** Categopry Cache */
  private static CCache<Integer, MProductCategory> s_cache =
      new CCache<Integer, MProductCategory>(Table_Name, 20);
  /** Product Cache */
  private static CCache<Integer, Integer> s_products =
      new CCache<Integer, Integer>(I_M_Product.Table_Name, Table_Name + ".M_Product", 100);
  /** Static Logger */
  private static CLogger s_log = CLogger.getCLogger(MProductCategory.class);
  /**
   * ************************************************************************ Default Constructor
   *
   * @param ctx context
   * @param M_Product_Category_ID id
   * @param trxName transaction
   */
  public MProductCategory(Properties ctx, int M_Product_Category_ID, String trxName) {
    super(ctx, M_Product_Category_ID, trxName);
    if (M_Product_Category_ID == 0) {
      //	setName (null);
      //	setValue (null);
      setMMPolicy(MMPOLICY_FiFo); // F
      setPlannedMargin(Env.ZERO);
      setIsDefault(false);
      setIsSelfService(true); // Y
    }
  } //	MProductCategory
  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   * @param trxName transaction
   */
  public MProductCategory(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  } //	MProductCategory

  /**
   * Get from Cache
   *
   * @param ctx context
   * @param M_Product_Category_ID id
   * @return category
   */
  public static MProductCategory get(Properties ctx, int M_Product_Category_ID) {
    Integer ii = new Integer(M_Product_Category_ID);
    MProductCategory retValue = (MProductCategory) s_cache.get(ii);
    if (retValue != null) return retValue;
    retValue = new MProductCategory(ctx, M_Product_Category_ID, null);
    if (retValue.getId() != 0) s_cache.put(M_Product_Category_ID, retValue);
    return retValue;
  } //	get

  /**
   * Is Product in Category
   *
   * @param M_Product_Category_ID category
   * @param M_Product_ID product
   * @return true if product has category
   */
  public static boolean isCategory(int M_Product_Category_ID, int M_Product_ID) {
    if (M_Product_ID == 0 || M_Product_Category_ID == 0) return false;
    //	Look up
    Integer product = new Integer(M_Product_ID);
    Integer category = (Integer) s_products.get(product);
    if (category != null) return category.intValue() == M_Product_Category_ID;

    String sql = "SELECT M_Product_Category_ID FROM M_Product WHERE M_Product_ID=?";
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      pstmt = prepareStatement(sql, null);
      pstmt.setInt(1, M_Product_ID);
      rs = pstmt.executeQuery();
      if (rs.next()) category = new Integer(rs.getInt(1));
    } catch (Exception e) {
      s_log.log(Level.SEVERE, sql, e);
    } finally {
      close(rs, pstmt);
      rs = null;
      pstmt = null;
    }
    if (category != null) {
      //	TODO: LRU logic
      s_products.put(product, category);
      //
      if (s_log.isLoggable(Level.FINE))
        s_log.fine(
            "M_Product_ID="
                + M_Product_ID
                + "("
                + category
                + ") in M_Product_Category_ID="
                + M_Product_Category_ID
                + " - "
                + (category.intValue() == M_Product_Category_ID));
      return category.intValue() == M_Product_Category_ID;
    }
    s_log.log(Level.SEVERE, "Not found M_Product_ID=" + M_Product_ID);
    return false;
  } //	isCategory

  /**
   * Before Save
   *
   * @param newRecord new
   * @return true
   */
  protected boolean beforeSave(boolean newRecord) {
    if (hasLoopInTree()) {
      log.saveError("Error", Msg.getMsg(getCtx(), "ProductCategoryLoopDetected"));
      return false;
    }

    return true;
  } //	beforeSave

  /**
   * After Save
   *
   * @param newRecord new
   * @param success success
   * @return success
   */
  protected boolean afterSave(boolean newRecord, boolean success) {
    if (newRecord && success)
      insert_Accounting("M_Product_Category_Acct", "C_AcctSchema_Default", null);

    return success;
  } //	afterSave

    /**
   * Loop detection of product category tree.
   *
   * @param productCategoryId
   * @param newParentCategoryId
   * @param newParentCategoryId New Parent Category
   * @return "" or error message
   */
  public boolean hasLoopInTree() {
    int productCategoryId = getM_Product_Category_ID();
    int newParentCategoryId = getM_Product_Category_Parent_ID();
    //	get values
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    String sql =
        " SELECT M_Product_Category_ID, M_Product_Category_Parent_ID FROM M_Product_Category";
    final Vector<SimpleTreeNode> categories = new Vector<SimpleTreeNode>(100);
    try {
      pstmt = prepareStatement(sql, null);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        if (rs.getInt(1) == productCategoryId)
          categories.add(new SimpleTreeNode(rs.getInt(1), newParentCategoryId));
        categories.add(new SimpleTreeNode(rs.getInt(1), rs.getInt(2)));
      }
      if (hasLoop(newParentCategoryId, categories, productCategoryId)) return true;
    } catch (SQLException e) {
      s_log.log(Level.SEVERE, sql, e);
      return true;
    } finally {
      close(rs, pstmt);
      rs = null;
      pstmt = null;
    }
    return false;
  } //	hasLoopInTree

  /**
   * Recursive search for parent nodes - climbs the to the root. If there is a circle there is no
   * root but it comes back to the start node.
   *
   * @param parentCategoryId
   * @param categories
   * @param loopIndicatorId
   * @return
   */
  private boolean hasLoop(
      int parentCategoryId, Vector<SimpleTreeNode> categories, int loopIndicatorId) {
    final Iterator<SimpleTreeNode> iter = categories.iterator();
    boolean ret = false;
    while (iter.hasNext()) {
      SimpleTreeNode node = (SimpleTreeNode) iter.next();
      if (node.getNodeId() == parentCategoryId) {
        if (node.getParentId() == 0) {
          // root node, all fine
          return false;
        }
        if (node.getNodeId() == loopIndicatorId) {
          // loop found
          return true;
        }
        ret = hasLoop(node.getParentId(), categories, loopIndicatorId);
      }
    }
    return ret;
  } // hasLoop

  /**
   * Simple class for tree nodes.
   *
   * @author Karsten Thiemann, kthiemann@adempiere.org
   */
  private static class SimpleTreeNode {
    /** id of the node */
    private int nodeId;
    /** id of the nodes parent */
    private int parentId;

    /**
     * Constructor.
     *
     * @param nodeId
     * @param parentId
     */
    public SimpleTreeNode(int nodeId, int parentId) {
      this.nodeId = nodeId;
      this.parentId = parentId;
    }

    public int getNodeId() {
      return nodeId;
    }

    public int getParentId() {
      return parentId;
    }
  }
} //	MProductCategory
