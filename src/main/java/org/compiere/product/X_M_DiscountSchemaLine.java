package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_DiscountSchemaLine;
import org.compiere.orm.PO;

/**
 * Generated Model for M_DiscountSchemaLine
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_DiscountSchemaLine extends PO implements I_M_DiscountSchemaLine {

    /**
     * Product Cost = P
     */
    public static final String LIMIT_BASE_ProductCost = "P";
    /**
     * Product Cost = P
     */
    public static final String LIST_BASE_ProductCost = "P";
    /**
     * Product Cost = P
     */
    public static final String STD_BASE_ProductCost = "P";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_DiscountSchemaLine(int M_DiscountSchemaLine_ID) {
        super(M_DiscountSchemaLine_ID);
        /**
         * if (M_DiscountSchemaLine_ID == 0) { setConversionTypeId (0); setConversionDate (new
         * Timestamp( System.currentTimeMillis() )); // @#Date@ setLimit_AddAmt (Env.ZERO);
         * setLimit_Base (null); // X setLimit_Discount (Env.ZERO); setLimit_MaxAmt (Env.ZERO);
         * setLimit_MinAmt (Env.ZERO); setLimit_Rounding (null); // C setList_AddAmt (Env.ZERO);
         * setList_Base (null); // L setList_Discount (Env.ZERO); setList_MaxAmt (Env.ZERO);
         * setList_MinAmt (Env.ZERO); setList_Rounding (null); // C setDiscountSchemaId (0);
         * setDiscountSchemaLine_ID (0); setSeqNo (0); // @SQL=SELECT NVL(MAX(SeqNo),0)+10 AS
         * DefaultValue FROM M_DiscountSchemaLine WHERE M_DiscountSchema_ID=@M_DiscountSchema_ID@
         * setStd_AddAmt (Env.ZERO); setStd_Base (null); // S setStd_Discount (Env.ZERO); setStd_MaxAmt
         * (Env.ZERO); setStd_MinAmt (Env.ZERO); setStd_Rounding (null); // C }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_DiscountSchemaLine(Row row) {
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
        return "X_M_DiscountSchemaLine[" + getId() + "]";
    }

    /**
     * Get Sequence.
     *
     * @return Method of ordering records; lowest number comes first
     */
    public int getSeqNo() {
        Integer ii = (Integer) getValue(COLUMNNAME_SeqNo);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Sequence.
     *
     * @param SeqNo Method of ordering records; lowest number comes first
     */
    public void setSeqNo(int SeqNo) {
        setValue(COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
    }

    @Override
    public int getTableId() {
        return I_M_DiscountSchemaLine.Table_ID;
    }
}
