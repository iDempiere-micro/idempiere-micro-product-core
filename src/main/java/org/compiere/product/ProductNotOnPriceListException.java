package org.compiere.product;

import org.compiere.model.HasName;
import org.compiere.model.I_M_PriceList;
import org.compiere.model.I_M_Product;
import org.compiere.util.DisplayType;
import org.idempiere.common.exceptions.AdempiereException;

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
        if (pp.getProductId() > 0) {
            I_M_Product p = MProduct.get(pp.getProductId());
            if (sb.length() > 0) sb.append(", ");
            sb.append("@M_Product_ID@:")
                    .append(p == null ? "?" : p.getTranslation(HasName.COLUMNNAME_Name));
        }
        if (pp.getPriceListId() > 0) {
            I_M_PriceList pl = MPriceList.get(pp.getPriceListId());
            if (sb.length() > 0) sb.append(", ");
            sb.append("@M_PriceList_ID@:")
                    .append(pl == null ? "?" : pl.getTranslation(HasName.COLUMNNAME_Name));
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
