package org.compiere.product;

import org.compiere.model.HasName;
import org.compiere.util.DisplayType;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.util.Env;

import java.text.DateFormat;

/**
 * Throw when product price is not found in price list
 *
 * @author teo.sarca@gmail.com
 * <li>FR [ 2872255 ] Introduce ProductNotOnPriceListException
 * https://sourceforge.net/tracker/?func=detail&aid=2872255&group_id=176962&atid=879335
 */
public class ProductNotOnPriceListException extends AdempiereException {
    public static final String AD_Message = "ProductNotOnPriceList";
    /**
     *
     */
    private static final long serialVersionUID = -3505579126676698444L;

    public ProductNotOnPriceListException(IProductPricing productPricing, int documentLineNo) {
        super(buildMessage(productPricing, documentLineNo));
    }

    private static final String buildMessage(IProductPricing pp, int documentLineNo) {
        StringBuilder sb = new StringBuilder();
        if (documentLineNo > 0) {
            if (sb.length() > 0) sb.append(", ");
            sb.append("@Line@:").append(documentLineNo);
        }
        if (pp.getM_Product_ID() > 0) {
            MProduct p = MProduct.get(Env.getCtx(), pp.getM_Product_ID());
            if (sb.length() > 0) sb.append(", ");
            sb.append("@M_Product_ID@:")
                    .append(p == null ? "?" : p.get_Translation(HasName.Companion.getCOLUMNNAME_Name()));
        }
        if (pp.getPriceListId() > 0) {
            MPriceList pl = MPriceList.get(Env.getCtx(), pp.getPriceListId());
            if (sb.length() > 0) sb.append(", ");
            sb.append("@M_PriceList_ID@:")
                    .append(pl == null ? "?" : pl.get_Translation(HasName.Companion.getCOLUMNNAME_Name()));
        }
        if (pp.getPriceDate() != null) {
            DateFormat df = DisplayType.getDateFormat(DisplayType.Date);
            if (sb.length() > 0) sb.append(", ");
            sb.append("@Date@:").append(df.format(pp.getPriceDate()));
        }
        //
        sb.insert(0, "@" + AD_Message + "@ - ");
        return sb.toString();
    }
}
