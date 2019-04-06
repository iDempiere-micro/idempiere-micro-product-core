package org.compiere.product;

import kotliquery.Row;

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
    private MProduct m_product = null;

    /**
     * Default Constructor
     *
     * @param ctx              context
     * @param S_ExpenseType_ID id
     * @param trxName          transaction
     */
    public MExpenseType(int S_ExpenseType_ID) {
        super(S_ExpenseType_ID);
    } //	MExpenseType

    /**
     * MExpenseType
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MExpenseType(Row row) {
        super(row);
    } //	MExpenseType

    /**
     * Get Product
     *
     * @return product
     */
    public MProduct getProduct() {
        if (m_product == null) {
            StringBuilder msgmp = new StringBuilder("S_ExpenseType_ID=").append(getExpenseTypeId());
            MProduct[] products = MProduct.get(msgmp.toString());
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

        MProduct prod = getProduct();
        if (prod.setExpenseType(this)) prod.saveEx();

        return success;
    } //	afterSave
} //	MExpenseType
