package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_PriceList_Version;
import org.compiere.model.I_M_ProductPrice;
import org.compiere.orm.Query;
import org.idempiere.common.util.CLogger;

import java.math.BigDecimal;

/**
 * Product Price
 *
 * @author Jorg Janke
 * @version $Id: MProductPrice.java,v 1.3 2006/07/30 00:51:02 jjanke Exp $
 */
public class MProductPrice extends X_M_ProductPrice {
    /**
     *
     */
    private static final long serialVersionUID = 9187555438223385521L;
    /**
     * Logger
     */
    @SuppressWarnings("unused")
    private static CLogger s_log = CLogger.getCLogger(MProductPrice.class);

    /**
     * Persistency Constructor
     *
     * @param ctx               context
     * @param M_ProductPrice_ID key
     */
    public MProductPrice(int M_ProductPrice_ID) {
        super(M_ProductPrice_ID);
    } //	MProductPrice

    /**
     * Load Constructor
     *
     * @param ctx context
     */
    public MProductPrice(Row row) {
        super(row);
    } //	MProductPrice

    /**
     * New Constructor
     *
     * @param ctx                    context
     * @param M_PriceList_Version_ID Price List Version
     * @param M_Product_ID           product
     */
    public MProductPrice(
            int M_PriceList_Version_ID, int M_Product_ID) {
        this(0);
        setPriceListVersionId(M_PriceList_Version_ID); // 	FK
        setProductId(M_Product_ID); // 	FK
    } //	MProductPrice

    /**
     * New Constructor
     *
     * @param ctx                    context
     * @param M_PriceList_Version_ID Price List Version
     * @param M_Product_ID           product
     * @param PriceList              list price
     * @param PriceStd               standard price
     * @param PriceLimit             limit price
     * @param trxName                transaction
     */
    public MProductPrice(

            int M_PriceList_Version_ID,
            int M_Product_ID,
            BigDecimal PriceList,
            BigDecimal PriceStd,
            BigDecimal PriceLimit,
            String trxName) {
        this(M_PriceList_Version_ID, M_Product_ID);
        setPrices(PriceList, PriceStd, PriceLimit);
    } //	MProductPrice

    /**
     * Parent Constructor
     *
     * @param plv          price list version
     * @param M_Product_ID product
     * @param PriceList    list price
     * @param PriceStd     standard price
     * @param PriceLimit   limit price
     */
    public MProductPrice(
            I_M_PriceList_Version plv,
            int M_Product_ID,
            BigDecimal PriceList,
            BigDecimal PriceStd,
            BigDecimal PriceLimit) {
        this(0);
        setClientOrg(plv);
        setPriceListVersionId(plv.getPriceListVersionId());
        setProductId(M_Product_ID);
        setPrices(PriceList, PriceStd, PriceLimit);
    } //	MProductPrice

    /**
     * Get Product Price
     *
     * @param M_PriceList_Version_ID id
     * @param M_Product_ID           id
     * @return product price or null
     */
    public static MProductPrice get(
            int M_PriceList_Version_ID, int M_Product_ID) {
        final String whereClause =
                MProductPrice.COLUMNNAME_M_PriceList_Version_ID
                        + "=? AND "
                        + MProductPrice.COLUMNNAME_M_Product_ID
                        + "=?";
        return new Query(I_M_ProductPrice.Table_Name, whereClause)
                .setParameters(M_PriceList_Version_ID, M_Product_ID)
                .first();
    } //	get

    /**
     * Set Prices
     *
     * @param PriceList  list price
     * @param PriceStd   standard price
     * @param PriceLimit limit price
     */
    public void setPrices(BigDecimal PriceList, BigDecimal PriceStd, BigDecimal PriceLimit) {
        setPriceLimit(
                PriceLimit.setScale(
                        this.getPriceListVersion().getPriceList().getPricePrecision(),
                        BigDecimal.ROUND_HALF_UP));
        setPriceList(
                PriceList.setScale(
                        this.getPriceListVersion().getPriceList().getPricePrecision(),
                        BigDecimal.ROUND_HALF_UP));
        setPriceStd(
                PriceStd.setScale(
                        this.getPriceListVersion().getPriceList().getPricePrecision(),
                        BigDecimal.ROUND_HALF_UP));
    } //	setPrice

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("MProductPrice[");
        sb.append(getPriceListVersionId())
                .append(",M_Product_ID=")
                .append(getProductId())
                .append(",PriceList=")
                .append(getPriceList())
                .append("]");
        return sb.toString();
    } //	toString
} //	MProductPrice
