package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_LotCtl;
import org.compiere.orm.BasePOName;

/**
 * Generated Model for M_LotCtl
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_LotCtl extends BasePOName implements I_M_LotCtl {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_LotCtl(int M_LotCtl_ID) {
        super(M_LotCtl_ID);
        /**
         * if (M_LotCtl_ID == 0) { setCurrentNext (0); // 100 setIncrementNo (0); // 1 setLotControlId
         * (0); setName (null); setStartNo (0); // 100 }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_LotCtl(Row row) {
        super(row);
    }

    /**
     * AccessLevel
     *
     * @return 3 - Client - Org
     */
    protected int getAccessLevel() {
        return accessLevel.intValue();
    }

    public String toString() {
        return "X_M_LotCtl[" + getId() + "]";
    }

    /**
     * Get Current Next.
     *
     * @return The next number to be used
     */
    public int getCurrentNext() {
        Integer ii = getValue(COLUMNNAME_CurrentNext);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Current Next.
     *
     * @param CurrentNext The next number to be used
     */
    public void setCurrentNext(int CurrentNext) {
        setValue(COLUMNNAME_CurrentNext, Integer.valueOf(CurrentNext));
    }

    /**
     * Get Increment.
     *
     * @return The number to increment the last document number by
     */
    public int getIncrementNo() {
        Integer ii = getValue(COLUMNNAME_IncrementNo);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Increment.
     *
     * @param IncrementNo The number to increment the last document number by
     */
    public void setIncrementNo(int IncrementNo) {
        setValue(COLUMNNAME_IncrementNo, Integer.valueOf(IncrementNo));
    }

    /**
     * Get Lot Control.
     *
     * @return Product Lot Control
     */
    public int getLotControlId() {
        Integer ii = getValue(COLUMNNAME_M_LotCtl_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Prefix.
     *
     * @return Prefix before the sequence number
     */
    public String getPrefix() {
        return getValue(COLUMNNAME_Prefix);
    }

    /**
     * Set Start No.
     *
     * @param StartNo Starting number/position
     */
    public void setStartNo(int StartNo) {
        setValue(COLUMNNAME_StartNo, Integer.valueOf(StartNo));
    }

    /**
     * Get Suffix.
     *
     * @return Suffix after the number
     */
    public String getSuffix() {
        return getValue(COLUMNNAME_Suffix);
    }

    @Override
    public int getTableId() {
        return I_M_LotCtl.Table_ID;
    }
}
