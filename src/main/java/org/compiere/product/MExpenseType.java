package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_Product;

/**
 * Expense Type Model
 *
 * @author Jorg Janke
 * @version $Id: MExpenseType.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MExpenseType extends X_S_ExpenseType {

    /**
     *
     */
    private static final long serialVersionUID = -5721855125106737886L;
    /**
     * Cached Product
     */
    private I_M_Product m_product = null;

    /**
     * Default Constructor
     *
     * @param S_ExpenseType_ID id
     */
    public MExpenseType(int S_ExpenseType_ID) {
        super(S_ExpenseType_ID);
    } //	MExpenseType

    /**
     * MExpenseType
     *
     */
    public MExpenseType(Row row) {
        super(row);
    } //	MExpenseType

    /**
     * Get Product
     *
     * @return product
     */
    public I_M_Product getProduct() {
        if (m_product == null) {
            I_M_Product[] products = MProduct.get("S_ExpenseType_ID=" + getExpenseTypeId());
            if (products.length > 0) m_product = products[0];
        }
        return m_product;
    } //	getProduct

    /**
     * beforeSave
     *
     * @param newRecord
     * @return true
     * @see PO#beforeSave(boolean)
     */
    protected boolean beforeSave(boolean newRecord) {
        if (newRecord) {
            if (getSearchKey() == null || getSearchKey().length() == 0) setSearchKey(getName());
            m_product = new MProduct(this);
            return m_product.save();
        }
        return true;
    } //	beforeSave

    /**
     * After Save
     *
     * @param newRecord new
     * @param success   success
     * @return success
     */
    protected boolean afterSave(boolean newRecord, boolean success) {
        if (!success) return success;

        I_M_Product prod = getProduct();
        if (prod.setExpenseType(this)) prod.saveEx();

        return success;
    } //	afterSave
} //	MExpenseType
