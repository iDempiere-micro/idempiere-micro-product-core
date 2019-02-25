package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.HasName;
import org.compiere.model.I_M_PriceList_Version;
import org.compiere.orm.MTable;
import org.compiere.orm.PO;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Generated Model for M_PriceList_Version
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_PriceList_Version extends PO implements I_M_PriceList_Version {

    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_PriceList_Version(Properties ctx, int M_PriceList_Version_ID) {
        super(ctx, M_PriceList_Version_ID);
        /**
         * if (M_PriceList_Version_ID == 0) { setM_DiscountSchema_ID (0); setM_PriceList_ID (0);
         * setM_PriceList_Version_ID (0); setName (null); // @#Date@ setValidFrom (new Timestamp(
         * System.currentTimeMillis() )); // @#Date@ }
         */
    }

    /**
     * Load Constructor
     */
    public X_M_PriceList_Version(Properties ctx, ResultSet rs) {
        super(ctx, rs);
    }

    public X_M_PriceList_Version(Properties ctx, Row row) {
        super(ctx, row);
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
        StringBuffer sb = new StringBuffer("X_M_PriceList_Version[").append(getId()).append("]");
        return sb.toString();
    }

    /**
     * Set Discount Schema.
     *
     * @param M_DiscountSchema_ID Schema to calculate the trade discount percentage
     */
    public void setM_DiscountSchema_ID(int M_DiscountSchema_ID) {
        if (M_DiscountSchema_ID < 1) set_Value(COLUMNNAME_M_DiscountSchema_ID, null);
        else set_Value(COLUMNNAME_M_DiscountSchema_ID, Integer.valueOf(M_DiscountSchema_ID));
    }

    public org.compiere.model.I_M_PriceList getM_PriceList() throws RuntimeException {
        return (org.compiere.model.I_M_PriceList)
                MTable.get(getCtx(), org.compiere.model.I_M_PriceList.Table_Name)
                        .getPO(getM_PriceList_ID());
    }

    /**
     * Get Price List.
     *
     * @return Unique identifier of a Price List
     */
    public int getM_PriceList_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_PriceList_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Price List.
     *
     * @param M_PriceList_ID Unique identifier of a Price List
     */
    public void setM_PriceList_ID(int M_PriceList_ID) {
        if (M_PriceList_ID < 1) set_ValueNoCheck(COLUMNNAME_M_PriceList_ID, null);
        else set_ValueNoCheck(COLUMNNAME_M_PriceList_ID, M_PriceList_ID);
    }

    /**
     * Get Price List Version.
     *
     * @return Identifies a unique instance of a Price List
     */
    public int getM_PriceList_Version_ID() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_PriceList_Version_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Name.
     *
     * @return Alphanumeric identifier of the entity
     */
    public String getName() {
        return (String) getValue(HasName.Companion.getCOLUMNNAME_Name());
    }

    /**
     * Set Name.
     *
     * @param Name Alphanumeric identifier of the entity
     */
    public void setName(String Name) {
        set_Value(HasName.Companion.getCOLUMNNAME_Name(), Name);
    }

    /**
     * Get Valid from.
     *
     * @return Valid from including this date (first day)
     */
    public Timestamp getValidFrom() {
        return (Timestamp) getValue(COLUMNNAME_ValidFrom);
    }

    /**
     * Set Valid from.
     *
     * @param ValidFrom Valid from including this date (first day)
     */
    public void setValidFrom(Timestamp ValidFrom) {
        set_Value(COLUMNNAME_ValidFrom, ValidFrom);
    }

    @Override
    public int getTableId() {
        return I_M_PriceList_Version.Table_ID;
    }
}
