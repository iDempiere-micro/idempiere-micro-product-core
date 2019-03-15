package org.compiere.product;

import kotliquery.Row;
import org.compiere.model.I_M_PriceList_Version;
import org.compiere.model.I_M_ProductPrice;
import org.compiere.orm.Query;
import org.idempiere.common.util.CLogger;

import java.math.BigDecimal;
import java.util.Properties;

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
     * @param trxName           transaction
     */
    public MProductPrice(Properties ctx, int M_ProductPrice_ID) {
        super(ctx, M_ProductPrice_ID);
    } //	MProductPrice

    /**
     * Load Constructor
     *
     * @param ctx     context
     * @param rs      result set
     * @param trxName transaction
     */
    public MProductPrice(Properties ctx, Row row) {
        super(ctx, row);
    } //	MProductPrice

    /**
     * New Constructor
     *
     * @param ctx                    context
     * @param M_PriceList_Version_ID Price List Version
     * @param M_Product_ID           product
     * @param trxName                transaction
     */
    public MProductPrice(
            Properties ctx, int M_PriceList_Version_ID, int M_Product_ID) {
        this(ctx, 0);
        setM_PriceList_Version_ID(M_PriceList_Version_ID); // 	FK
        setM_Product_ID(M_Product_ID); // 	FK
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
            Properties ctx,
            int M_PriceList_Version_ID,
            int M_Product_ID,
            BigDecimal PriceList,
            BigDecimal PriceStd,
            BigDecimal PriceLimit,
            String trxName) {
        this(ctx, M_PriceList_Version_ID, M_Product_ID);
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
        this(plv.getCtx(), 0);
        setClientOrg(plv);
        setM_PriceList_Version_ID(plv.getM_PriceList_Version_ID());
        setM_Product_ID(M_Product_ID);
        setPrices(PriceList, PriceStd, PriceLimit);
    } //	MProductPrice

    /**
     * Get Product Price
     *
     * @param ctx                    ctx
     * @param M_PriceList_Version_ID id
     * @param M_Product_ID           id
     * @param trxName                trx
     * @return product price or null
     */
    public static MProductPrice get(
            Properties ctx, int M_PriceList_Version_ID, int M_Product_ID) {
        final String whereClause =
                MProductPrice.COLUMNNAME_M_PriceList_Version_ID
                        + "=? AND "
                        + MProductPrice.COLUMNNAME_M_Product_ID
                        + "=?";
        MProductPrice retValue =
                new Query(ctx, I_M_ProductPrice.Table_Name, whereClause)
                        .setParameters(M_PriceList_Version_ID, M_Product_ID)
                        .first();
        return retValue;
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
                        this.getM_PriceList_Version().getPriceList().getPricePrecision(),
                        BigDecimal.ROUND_HALF_UP));
        setPriceList(
                PriceList.setScale(
                        this.getM_PriceList_Version().getPriceList().getPricePrecision(),
                        BigDecimal.ROUND_HALF_UP));
        setPriceStd(
                PriceStd.setScale(
                        this.getM_PriceList_Version().getPriceList().getPricePrecision(),
                        BigDecimal.ROUND_HALF_UP));
    } //	setPrice

    /**
     * String Representation
     *
     * @return info
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("MProductPrice[");
        sb.append(getM_PriceList_Version_ID())
                .append(",M_Product_ID=")
                .append(getM_Product_ID())
                .append(",PriceList=")
                .append(getPriceList())
                .append("]");
        return sb.toString();
    } //	toString
} //	MProductPrice
