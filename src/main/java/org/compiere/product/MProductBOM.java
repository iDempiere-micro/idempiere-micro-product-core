package org.compiere.product;

import org.compiere.model.I_M_Product_BOM;
import org.compiere.orm.Query;
import org.idempiere.common.util.CLogger;
import org.idempiere.common.util.Env;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

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
     * @param trxName          transaction
     */
    public MProductBOM(Properties ctx, int M_Product_BOM_ID) {
        super(ctx, M_Product_BOM_ID);
        if (M_Product_BOM_ID == 0) {
            //	setM_Product_ID (0);	//	parent
            //	setLine (0);	// @SQL=SELECT NVL(MAX(Line),0)+10 AS DefaultValue FROM M_Product_BOM WHERE
            // M_Product_ID=@M_Product_ID@
            //	setM_ProductBOM_ID(0);
            setBOMQty(Env.ZERO); // 1
        }
    } //	MProductBOM

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MProductBOM(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    } //	MProductBOM

    /**
     * Get BOM Lines for Product
     *
     * @param product product
     * @return array of BOMs
     */
    public static MProductBOM[] getBOMLines(MProduct product) {
        return getBOMLines(product.getCtx(), product.getM_Product_ID());
    } //	getBOMLines

    /**
     * Get BOM Lines for Product
     *
     * @param ctx          context
     * @param M_Product_ID product
     * @param trxName      transaction
     * @return array of BOMs
     */
    public static MProductBOM[] getBOMLines(Properties ctx, int M_Product_ID) {
        // FR: [ 2214883 ] Remove SQL code and Replace for Query - red1
        final String whereClause = "M_Product_ID=?";
        List<MProductBOM> list =
                new Query(ctx, I_M_Product_BOM.Table_Name, whereClause)
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
    public void setM_ProductBOM_ID(int M_ProductBOM_ID) {
        super.setM_ProductBOM_ID(M_ProductBOM_ID);
        m_product = null;
    } //	setM_ProductBOM_ID

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
        if (m_product == null) sb.append(",M_Product_ID=").append(getM_ProductBOM_ID());
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
        MProduct product = new MProduct(getCtx(), getM_Product_ID());
        if (product.isVerified()) {
            if (newRecord
                    || is_ValueChanged("M_ProductBOM_ID") // 	Product Line was changed
                    || (is_ValueChanged("IsActive") && isActive())) // line was activated
            {
                //	Invalidate BOM
                product.setIsVerified(false);
                product.saveEx();
            }
            if (product.isVerified()
                    && is_ValueChanged("IsActive")
                    && !isActive()) { // line was inactivated
                if (!hasActiveComponents(getM_Product_ID())) {
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
        MProduct product = new MProduct(getCtx(), getM_Product_ID());
        if (product.isVerified()) {
            if (!hasActiveComponents(getM_Product_ID())) {
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
                        getM_Product_BOM_ID());
        return cnt > 0;
    }
} //	MProductBOM
