package org.compiere.product;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.idempiere.common.util.Env;

public abstract class AbstractProductPricing implements IProductPricing {

  protected int m_M_Product_ID;
  protected int m_C_BPartner_ID;
  protected BigDecimal m_Qty = Env.ONE;
  protected boolean m_isSOTrx = true;

    protected int m_M_PriceList_ID = 0;
  protected Timestamp m_PriceDate;

  public AbstractProductPricing() {}

  @Override
  public void setInitialValues(
      int M_Product_ID, int C_BPartner_ID, BigDecimal qty, boolean isSOTrx, String trxName) {
      m_M_Product_ID = M_Product_ID;
    m_C_BPartner_ID = C_BPartner_ID;

    if (qty != null && Env.ZERO.compareTo(qty) != 0) m_Qty = qty;
    m_isSOTrx = isSOTrx;
  }

  @Override
  public int getM_Product_ID() {
    return m_M_Product_ID;
  }

  @Override
  public int getM_PriceList_ID() {
    return m_M_PriceList_ID;
  }

  @Override
  public void setM_PriceList_ID(int M_PriceList_ID) {
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
  public void setOrderLine(I_C_OrderLine orderLine, String trxName) {
    m_M_Product_ID = orderLine.getM_Product_ID();
    m_C_BPartner_ID = orderLine.getC_BPartner_ID();
    BigDecimal qty = orderLine.getQtyOrdered();
    if (qty != null && Env.ZERO.compareTo(qty) != 0) m_Qty = qty;
    m_isSOTrx = orderLine.getC_Order().isSOTrx();
    m_PriceDate = orderLine.getDateOrdered();
  }

  @Override
  public void setInvoiceLine(I_C_InvoiceLine invoiceLine, String trxName) {
    m_M_Product_ID = invoiceLine.getM_Product_ID();
    m_C_BPartner_ID = invoiceLine.getC_Invoice().getC_BPartner_ID();
    BigDecimal qty =
        invoiceLine.getQtyInvoiced() != null
            ? invoiceLine.getQtyInvoiced()
            : invoiceLine.getQtyEntered();
    if (qty != null && Env.ZERO.compareTo(qty) != 0) m_Qty = qty;
    m_isSOTrx = invoiceLine.getC_Invoice().isSOTrx();
    m_PriceDate = invoiceLine.getC_Invoice().getDateInvoiced();
  }

  @Override
  public void setProjectLine(I_C_ProjectLine projectLine, String trxName) {
    m_M_Product_ID = projectLine.getM_Product_ID();
    m_C_BPartner_ID = projectLine.getC_Project().getC_BPartner_ID();
    BigDecimal qty = projectLine.getPlannedQty();
    if (qty != null && Env.ZERO.compareTo(qty) != 0) m_Qty = qty;
    m_isSOTrx = true;
  }

  @Override
  public void setRequisitionLine(I_M_RequisitionLine reqLine, String trxName) {
    m_M_Product_ID = reqLine.getM_Product_ID();
    m_C_BPartner_ID = reqLine.getC_BPartner_ID();
    BigDecimal qty = reqLine.getQty();
    if (qty != null && Env.ZERO.compareTo(qty) != 0) m_Qty = qty;
    m_isSOTrx = false;
  }

}
