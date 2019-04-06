package org.compiere.product;

import kotliquery.Row;

/**
 * Lot Control Model
 *
 * @author Jorg Janke
 * @version $Id: MLotCtl.java,v 1.3 2006/07/30 00:51:02 jjanke Exp $
 */
public class MLotCtl extends X_M_LotCtl {
    /**
     *
     */
    private static final long serialVersionUID = -1020114756336617138L;

    /**
     * Standard Constructor
     *
     * @param M_LotCtl_ID id
     */
    public MLotCtl(int M_LotCtl_ID) {
        super(M_LotCtl_ID);
        if (M_LotCtl_ID == 0) {
            setStartNo(1);
            setCurrentNext(1);
            setIncrementNo(1);
        }
    } //	MLotCtl

    /**
     * Load Constructor
     *
     * @param ctx context
     */
    public MLotCtl(Row row) {
        super(row);
    } //	MLotCtl

    /**
     * Create new Lot. Increments Current Next and Commits
     *
     * @param M_Product_ID product
     * @return saved Lot
     */
    public MLot createLot(int M_Product_ID) {
        StringBuilder name = new StringBuilder();
        if (getPrefix() != null) name.append(getPrefix());
        int no = getCurrentNext();
        name.append(no);
        if (getSuffix() != null) name.append(getSuffix());
        //
        no += getIncrementNo();
        setCurrentNext(no);
        saveEx();
        //
        MLot retValue = new MLot(this, M_Product_ID, name.toString());
        retValue.saveEx();
        return retValue;
    } //	createLot
} //	MLotCtl
