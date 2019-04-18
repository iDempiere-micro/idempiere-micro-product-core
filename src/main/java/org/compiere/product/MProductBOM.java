package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_Product;
import org.compiere.model.I_M_Product_BOM;
import org.compiere.orm.Query;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.Env;

import java.util.List;

import static software.hsharp.core.util.DBKt.getSQLValue;

/**
 * Product BOM Model (old). M_Product_ID = the parent M_Product_BOM_ID = the BOM line
 * M_ProductBOM_ID = the BOM line product
 *
 * @author Jorg Janke
 * @version $Id: MProductBOM.java,v 1.5 2006/07/30 00:51:02 jjanke Exp $
 */
public class MProductBOM extends X_M_Product_BOM {
    /**
     *
     */
    private static final long serialVersionUID = 2615029184168566124L;
    /**
     * Static Logger
     */
    @SuppressWarnings("unused")
    private static CLogger s_log = CLogger.getCLogger(MProductBOM.class);
    /**
     * Included Product
     */
    private MProduct m_product = null;

    /**
     * ************************************************************************ Standard Constructor
     *
     * @param ctx              context
     * @param M_Product_BOM_ID id
     */
    public MProductBOM(int M_Product_BOM_ID) {
        super(M_Product_BOM_ID);
        if (M_Product_BOM_ID == 0) {
            setBOMQty(Env.ZERO); // 1
        }
    } //	MProductBOM

    /**
     * Load Constructor
     *
     * @param ctx context
     */
    public MProductBOM(Row row) {
        super(row);
    } //	MProductBOM

    /**
     * Get BOM Lines for Product
     *
     * @param product product
     * @return array of BOMs
     */
    public static MProductBOM[] getBOMLines(I_M_Product product) {
        return getBOMLines(product.getProductId());
    } //	getBOMLines

    /**
     * Get BOM Lines for Product
     *
     * @param ctx          context
     * @param M_Product_ID product
     * @return array of BOMs
     */
    public static MProductBOM[] getBOMLines(int M_Product_ID) {
        // FR: [ 2214883 ] Remove SQL code and Replace for Query - red1
        final String whereClause = "M_Product_ID=?";
        List<I_M_Product_BOM> list =
                new Query<I_M_Product_BOM>(I_M_Product_BOM.Table_Name, whereClause)
                        .setParameters(M_Product_ID)
                        .setOrderBy("Line")
                        .list();

        //	s_log.fine("getBOMLines - #" + list.size() + " - M_Product_ID=" + M_Product_ID);
        MProductBOM[] retValue = new MProductBOM[list.size()];
        list.toArray(retValue);
        return retValue;
    } //	getBOMLines

    /**
     * Set included Product
     *
     * @param M_ProductBOM_ID product ID
     */
    public void setBOMProductId(int M_ProductBOM_ID) {
        super.setBOMProductId(M_ProductBOM_ID);
        m_product = null;
    } //	setProductBOM_ID

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("MProductBOM[");
        sb.append(getId())
                .append(",Line=")
                .append(getLine())
                .append(",Type=")
                .append(getBOMType())
                .append(",Qty=")
                .append(getBOMQty());
        if (m_product == null) sb.append(",M_Product_ID=").append(getBOMProductId());
        else sb.append(",").append(m_product);
        sb.append("]");
        return sb.toString();
    } //	toString

    /**
     * After Save
     *
     * @param newRecord new
     * @param success   success
     * @return success
     */
    protected boolean afterSave(boolean newRecord, boolean success) {
        if (!success) return success;
        MProduct product = new MProduct(getProductId());
        if (product.isVerified()) {
            if (newRecord
                    || isValueChanged("M_ProductBOM_ID") // 	Product Line was changed
                    || (isValueChanged("IsActive") && isActive())) // line was activated
            {
                //	Invalidate BOM
                product.setIsVerified(false);
                product.saveEx();
            }
            if (product.isVerified()
                    && isValueChanged("IsActive")
                    && !isActive()) { // line was inactivated
                if (!hasActiveComponents(getProductId())) {
                    product.setIsVerified(false);
                    product.saveEx();
                }
            }
        }
        return success;
    } //	afterSave

    @Override
    protected boolean afterDelete(boolean success) {
        if (!success) return success;
        MProduct product = new MProduct(getProductId());
        if (product.isVerified()) {
            if (!hasActiveComponents(getProductId())) {
                product.setIsVerified(false);
                product.saveEx();
            }
        }
        return success;
    }

    private boolean hasActiveComponents(int productID) {
        int cnt =
                getSQLValue(
                        null,
                        "SELECT COUNT(*) FROM M_Product_BOM WHERE IsActive='Y' AND M_Product_ID=? AND M_Product_BOM_ID!=?",
                        productID,
                        getBOMLineId());
        return cnt > 0;
    }
} //	MProductBOM
