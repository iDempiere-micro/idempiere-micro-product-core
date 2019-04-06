package org.compiere.product;

import kotliquery.Row;

/**
 * Discount Schema Line (Price List) Model
 *
 * @author Jorg Janke
 * @version $Id: MDiscountSchemaLine.java,v 1.3 2006/07/30 00:51:03 jjanke Exp $
 */
public class MDiscountSchemaLine extends X_M_DiscountSchemaLine {

    /**
     *
     */
    private static final long serialVersionUID = 1632154004024021493L;

    /**
     * Standard Constructor
     *
     * @param ctx                     context
     * @param M_DiscountSchemaLine_ID id
     * @param trxName                 transaction
     */
    public MDiscountSchemaLine(int M_DiscountSchemaLine_ID) {
        super(M_DiscountSchemaLine_ID);
    } //	MDiscountSchemaLine

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MDiscountSchemaLine(Row row) {
        super(row);
    } //	MDiscountSchemaLine
} //	MDiscountSchemaLine
