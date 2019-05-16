package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.HasName;
import org.compiere.model.I_M_PriceList;
import org.compiere.model.I_M_PriceList_Version;
import org.compiere.orm.PO;
import software.hsharp.core.orm.MBaseTableKt;

import java.sql.Timestamp;

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
    public X_M_PriceList_Version(int M_PriceList_Version_ID) {
        super(M_PriceList_Version_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_PriceList_Version(Row row) {
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
        return "X_M_PriceList_Version[" + getId() + "]";
    }

    /**
     * Set Discount Schema.
     *
     * @param M_DiscountSchema_ID Schema to calculate the trade discount percentage
     */
    public void setDiscountSchemaId(int M_DiscountSchema_ID) {
        if (M_DiscountSchema_ID < 1) setValue(COLUMNNAME_M_DiscountSchema_ID, null);
        else setValue(COLUMNNAME_M_DiscountSchema_ID, M_DiscountSchema_ID);
    }

    public I_M_PriceList getPriceList() throws RuntimeException {
        return (I_M_PriceList)
                MBaseTableKt.getTable(I_M_PriceList.Table_Name)
                        .getPO(getPriceListId());
    }

    /**
     * Get Price List.
     *
     * @return Unique identifier of a Price List
     */
    public int getPriceListId() {
        Integer ii = getValue(COLUMNNAME_M_PriceList_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Price List.
     *
     * @param M_PriceList_ID Unique identifier of a Price List
     */
    public void setPriceListId(int M_PriceList_ID) {
        if (M_PriceList_ID < 1) setValueNoCheck(COLUMNNAME_M_PriceList_ID, null);
        else setValueNoCheck(COLUMNNAME_M_PriceList_ID, M_PriceList_ID);
    }

    /**
     * Get Price List Version.
     *
     * @return Identifies a unique instance of a Price List
     */
    public int getPriceListVersionId() {
        Integer ii = getValue(COLUMNNAME_M_PriceList_Version_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Name.
     *
     * @return Alphanumeric identifier of the entity
     */
    public String getName() {
        return getValue(HasName.COLUMNNAME_Name);
    }

    /**
     * Set Name.
     *
     * @param Name Alphanumeric identifier of the entity
     */
    public void setName(String Name) {
        setValue(HasName.COLUMNNAME_Name, Name);
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
        setValue(COLUMNNAME_ValidFrom, ValidFrom);
    }

    @Override
    public int getTableId() {
        return I_M_PriceList_Version.Table_ID;
    }
}
