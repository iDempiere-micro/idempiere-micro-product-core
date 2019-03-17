package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_AttributeSet;
import org.compiere.orm.BasePOName;

import java.util.Properties;

/**
 * Generated Model for M_AttributeSet
 *
 * @author iDempiere (generated)
 * @version Release 5.1 - $Id$
 */
public class X_M_AttributeSet extends BasePOName implements I_M_AttributeSet {

    /**
     * Not Mandatory = N
     */
    public static final String MANDATORYTYPE_NotMandatory = "N";
    /**
     * Always Mandatory = Y
     */
    public static final String MANDATORYTYPE_AlwaysMandatory = "Y";
    /**
     *
     */
    private static final long serialVersionUID = 20171031L;

    /**
     * Standard Constructor
     */
    public X_M_AttributeSet(Properties ctx, int M_AttributeSet_ID) {
        super(ctx, M_AttributeSet_ID);
    }

    /**
     * Load Constructor
     */
    public X_M_AttributeSet(Properties ctx, Row row) {
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
        return "X_M_AttributeSet[" + getId() + "]";
    }

    /**
     * Get Guarantee Days.
     *
     * @return Number of days the product is guaranteed or available
     */
    public int getGuaranteeDays() {
        Integer ii = (Integer) getValue(COLUMNNAME_GuaranteeDays);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get IsAutoGenerateLot.
     *
     * @return IsAutoGenerateLot
     */
    public boolean isAutoGenerateLot() {
        Object oo = getValue(COLUMNNAME_IsAutoGenerateLot);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Guarantee Date.
     *
     * @param IsGuaranteeDate Product has Guarantee or Expiry Date
     */
    public void setIsGuaranteeDate(boolean IsGuaranteeDate) {
        setValue(COLUMNNAME_IsGuaranteeDate, Boolean.valueOf(IsGuaranteeDate));
    }

    /**
     * Get Guarantee Date.
     *
     * @return Product has Guarantee or Expiry Date
     */
    public boolean isGuaranteeDate() {
        Object oo = getValue(COLUMNNAME_IsGuaranteeDate);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Mandatory Guarantee Date.
     *
     * @param IsGuaranteeDateMandatory The entry of a Guarantee Date is mandatory when creating a
     *                                 Product Instance
     */
    public void setIsGuaranteeDateMandatory(boolean IsGuaranteeDateMandatory) {
        setValue(COLUMNNAME_IsGuaranteeDateMandatory, Boolean.valueOf(IsGuaranteeDateMandatory));
    }

    /**
     * Get Mandatory Guarantee Date.
     *
     * @return The entry of a Guarantee Date is mandatory when creating a Product Instance
     */
    public boolean isGuaranteeDateMandatory() {
        Object oo = getValue(COLUMNNAME_IsGuaranteeDateMandatory);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Instance Attribute.
     *
     * @param IsInstanceAttribute The product attribute is specific to the instance (like Serial No,
     *                            Lot or Guarantee Date)
     */
    public void setIsInstanceAttribute(boolean IsInstanceAttribute) {
        setValue(COLUMNNAME_IsInstanceAttribute, Boolean.valueOf(IsInstanceAttribute));
    }

    /**
     * Get Instance Attribute.
     *
     * @return The product attribute is specific to the instance (like Serial No, Lot or Guarantee
     * Date)
     */
    public boolean isInstanceAttribute() {
        Object oo = getValue(COLUMNNAME_IsInstanceAttribute);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Lot.
     *
     * @param IsLot The product instances have a Lot Number
     */
    public void setIsLot(boolean IsLot) {
        setValue(COLUMNNAME_IsLot, Boolean.valueOf(IsLot));
    }

    /**
     * Get Lot.
     *
     * @return The product instances have a Lot Number
     */
    public boolean isLot() {
        Object oo = getValue(COLUMNNAME_IsLot);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Mandatory Lot.
     *
     * @param IsLotMandatory The entry of Lot info is mandatory when creating a Product Instance
     */
    public void setIsLotMandatory(boolean IsLotMandatory) {
        setValue(COLUMNNAME_IsLotMandatory, Boolean.valueOf(IsLotMandatory));
    }

    /**
     * Get Mandatory Lot.
     *
     * @return The entry of Lot info is mandatory when creating a Product Instance
     */
    public boolean isLotMandatory() {
        Object oo = getValue(COLUMNNAME_IsLotMandatory);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Serial No.
     *
     * @param IsSerNo The product instances have Serial Numbers
     */
    public void setIsSerNo(boolean IsSerNo) {
        setValue(COLUMNNAME_IsSerNo, Boolean.valueOf(IsSerNo));
    }

    /**
     * Get Serial No.
     *
     * @return The product instances have Serial Numbers
     */
    public boolean isSerNo() {
        Object oo = getValue(COLUMNNAME_IsSerNo);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Set Mandatory Serial No.
     *
     * @param IsSerNoMandatory The entry of a Serial No is mandatory when creating a Product Instance
     */
    public void setIsSerNoMandatory(boolean IsSerNoMandatory) {
        setValue(COLUMNNAME_IsSerNoMandatory, Boolean.valueOf(IsSerNoMandatory));
    }

    /**
     * Get Mandatory Serial No.
     *
     * @return The entry of a Serial No is mandatory when creating a Product Instance
     */
    public boolean isSerNoMandatory() {
        Object oo = getValue(COLUMNNAME_IsSerNoMandatory);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo).booleanValue();
            return "Y".equals(oo);
        }
        return false;
    }

    /**
     * Get Lot Char End Overwrite.
     *
     * @return Lot/Batch End Indicator overwrite - default »
     */
    public String getLotCharEOverwrite() {
        return (String) getValue(COLUMNNAME_LotCharEOverwrite);
    }

    /**
     * Get Lot Char Start Overwrite.
     *
     * @return Lot/Batch Start Indicator overwrite - default «
     */
    public String getLotCharSOverwrite() {
        return (String) getValue(COLUMNNAME_LotCharSOverwrite);
    }

    /**
     * Get Mandatory Type.
     *
     * @return The specification of a Product Attribute Instance is mandatory
     */
    public String getMandatoryType() {
        return (String) getValue(COLUMNNAME_MandatoryType);
    }

    /**
     * Set Mandatory Type.
     *
     * @param MandatoryType The specification of a Product Attribute Instance is mandatory
     */
    public void setMandatoryType(String MandatoryType) {

        setValue(COLUMNNAME_MandatoryType, MandatoryType);
    }

    /**
     * Get Attribute Set.
     *
     * @return Product Attribute Set
     */
    public int getAttributeSetId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_AttributeSet_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Lot Control.
     *
     * @return Product Lot Control
     */
    public int getLotControlId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_LotCtl_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get Serial No Control.
     *
     * @return Product Serial Number Control
     */
    public int getSerialNoControlId() {
        Integer ii = (Integer) getValue(COLUMNNAME_M_SerNoCtl_ID);
        if (ii == null) return 0;
        return ii;
    }

    /**
     * Get SerNo Char End Overwrite.
     *
     * @return Serial Number End Indicator overwrite - default empty
     */
    public String getSerNoCharEOverwrite() {
        return (String) getValue(COLUMNNAME_SerNoCharEOverwrite);
    }

    /**
     * Get SerNo Char Start Overwrite.
     *
     * @return Serial Number Start Indicator overwrite - default #
     */
    public String getSerNoCharSOverwrite() {
        return (String) getValue(COLUMNNAME_SerNoCharSOverwrite);
    }

    /**
     * Get Use Guarantee Date for Material Policy.
     *
     * @return Use Guarantee Date for Material Policy
     */
    public boolean isUseGuaranteeDateForMPolicy() {
        Object oo = getValue(COLUMNNAME_UseGuaranteeDateForMPolicy);
        if (oo != null) {
            if (oo instanceof Boolean) return ((Boolean) oo);
            return "Y".equals(oo);
        }
        return false;
    }

    @Override
    public int getTableId() {
        return I_M_AttributeSet.Table_ID;
    }
}
