package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_A_Asset_Group;
import org.compiere.model.I_M_Product_Category;
import org.compiere.orm.BasePONameValue;
import org.idempiere.common.util.Env;
import software.hsharp.core.orm.MBaseTableKt;

import java.math.BigDecimal;

/**
 * Generated Model for M_Product_Category
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_Product_Category extends BasePONameValue
        implements I_M_Product_Category {

    /**
     * FiFo = F
     */
    public static final String MMPOLICY_FiFo = "F";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_Product_Category(int M_Product_Category_ID) {
        super(M_Product_Category_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_Product_Category(Row row) {
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
        return "X_M_Product_Category[" + getId() + "]";
    }

    public I_A_Asset_Group getAssetGroup() throws RuntimeException {
        return (I_A_Asset_Group)
                MBaseTableKt.getTable(I_A_Asset_Group.Table_Name)
                        .getPO(getAssetGroupId());
    }

    /**
     * Get Asset Group.
     *
     * @return Group of Assets
     */
    public int getAssetGroupId() {
        Integer ii = (Integer) getValue(COLUMNNAME_A_Asset_Group_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Set Default.
     *
     * @param IsDefault Default value
     */
    public void setIsDefault(boolean IsDefault) {
        setValue(COLUMNNAME_IsDefault, IsDefault);
    }

    /**
     * Set Self-Service.
     *
     * @param IsSelfService This is a Self-Service entry or this entry can be changed via Self-Service
     */
    public void setIsSelfService(boolean IsSelfService) {
        setValue(COLUMNNAME_IsSelfService, IsSelfService);
    }

    /**
     * Get Material Policy.
     *
     * @return Material Movement Policy
     */
    public String getMMPolicy() {
        return (String) getValue(COLUMNNAME_MMPolicy);
    }

    /**
     * Set Material Policy.
     *
     * @param MMPolicy Material Movement Policy
     */
    public void setMMPolicy(String MMPolicy) {

        setValue(COLUMNNAME_MMPolicy, MMPolicy);
    }

    /**
     * Get Product Category.
     *
     * @return Category of a Product
     */
    public int getProductCategoryId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Product_Category_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Parent Product Category.
     *
     * @return Parent Product Category
     */
    public int getProductCategoryParentId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_Product_Category_Parent_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Planned Margin %.
     *
     * @return Project's planned margin as a percentage
     */
    public BigDecimal getPlannedMargin() {
        BigDecimal bd = (BigDecimal) getValue(COLUMNNAME_PlannedMargin);
        if (bd == null) return Env.ZERO;
        return bd;
    }

    /**
     * Set Planned Margin %.
     *
     * @param PlannedMargin Project's planned margin as a percentage
     */
    public void setPlannedMargin(BigDecimal PlannedMargin) {
        setValue(COLUMNNAME_PlannedMargin, PlannedMargin);
    }

    @Override
    public int getTableId() {
        return I_M_Product_Category.Table_ID;
    }
}
