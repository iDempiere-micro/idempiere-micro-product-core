package org.compiere.product;

import org.compiere.model.I_C_InvoiceLine;
import org.compiere.model.I_C_OrderLine;
import org.compiere.model.I_C_ProjectLine;
import org.compiere.model.I_M_RequisitionLine;
import org.idempiere.common.util.Env;

import java.math.BigDecimal;
import java.sql.Timestamp;

public abstract class AbstractProductPricing implements IProductPricing {

    protected int m_M_Product_ID;
    protected int m_C_BPartner_ID;
    protected BigDecimal m_Qty = Env.ONE;
    protected boolean m_isSOTrx = true;

    protected int m_M_PriceList_ID = 0;
    protected Timestamp m_PriceDate;

    public AbstractProductPricing() {
    }

    @Override
    public void setInitialValues(
            int M_Product_ID, int C_BPartner_ID, BigDecimal qty, boolean isSOTrx) {
        m_M_Product_ID = M_Product_ID;
        m_C_BPartner_ID = C_BPartner_ID;

        if (qty != null && Env.ZERO.compareTo(qty) != 0) m_Qty = qty;
        m_isSOTrx = isSOTrx;
    }

    @Override
    public int getProductId() {
        return m_M_Product_ID;
    }

    @Override
    public int getPriceListId() {
        return m_M_PriceList_ID;
    }

    @Override
    public void setPriceListId(int M_PriceList_ID) {
        m_M_PriceList_ID = M_PriceList_ID;
    }

    @Override
    public Timestamp getPriceDate() {
        return m_PriceDate;
    }

    @Override
    public void setPriceDate(Timestamp priceDate) {
        m_PriceDate = priceDate;
    }

    @Override
    public void setOrderLine(I_C_OrderLine orderLine) {
        m_M_Product_ID = orderLine.getProductId();
        m_C_BPartner_ID = orderLine.getBusinessPartnerId();
        BigDecimal qty = orderLine.getQtyOrdered();
        if (qty != null && Env.ZERO.compareTo(qty) != 0) m_Qty = qty;
        m_isSOTrx = orderLine.getOrder().isSOTrx();
        m_PriceDate = orderLine.getDateOrdered();
    }

    @Override
    public void setInvoiceLine(I_C_InvoiceLine invoiceLine) {
        m_M_Product_ID = invoiceLine.getProductId();
        m_C_BPartner_ID = invoiceLine.getInvoice().getBusinessPartnerId();
        BigDecimal qty =
                invoiceLine.getQtyInvoiced() != null
                        ? invoiceLine.getQtyInvoiced()
                        : invoiceLine.getQtyEntered();
        if (qty != null && Env.ZERO.compareTo(qty) != 0) m_Qty = qty;
        m_isSOTrx = invoiceLine.getInvoice().isSOTrx();
        m_PriceDate = invoiceLine.getInvoice().getDateInvoiced();
    }

    @Override
    public void setProjectLine(I_C_ProjectLine projectLine) {
        m_M_Product_ID = projectLine.getProductId();
        m_C_BPartner_ID = projectLine.getProject().getBusinessPartnerId();
        BigDecimal qty = projectLine.getPlannedQty();
        if (qty != null && Env.ZERO.compareTo(qty) != 0) m_Qty = qty;
        m_isSOTrx = true;
    }

    @Override
    public void setRequisitionLine(I_M_RequisitionLine reqLine) {
        m_M_Product_ID = reqLine.getProductId();
        m_C_BPartner_ID = reqLine.getBusinessPartnerId();
        BigDecimal qty = reqLine.getQty();
        if (qty != null && Env.ZERO.compareTo(qty) != 0) m_Qty = qty;
        m_isSOTrx = false;
    }

}
