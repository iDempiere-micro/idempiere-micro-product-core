package org.compiere.product;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.I_C_InvoiceLine;
import org.compiere.model.I_C_OrderLine;
import org.compiere.model.I_C_ProjectLine;
import org.compiere.model.I_M_RMALine;
import org.compiere.model.I_M_RequisitionLine;

/** Product Price Calculations */
public interface IProductPricing {

  /**
   * Set the initial values that the old MProductPricing uses for backward compatibility
   *
   * @param M_Product_ID
   * @param C_BPartner_ID
   * @param qty
   * @param isSOTrx
   * @param trxName
   */
  void setInitialValues(
      int M_Product_ID, int C_BPartner_ID, BigDecimal qty, boolean isSOTrx, String trxName);

  /**
   * Calculate Price
   *
   * @return true if calculated
   */
  boolean calculatePrice();

  /**
   * Calculate Discount Percentage
   *
   * @return Discount
   */
  BigDecimal getDiscount();

  int getM_Product_ID();

  int getM_PriceList_ID();

  void setM_PriceList_ID(int M_PriceList_ID);

  void setM_PriceList_Version_ID(int M_PriceList_Version_ID);

  void setQty(BigDecimal qty);

  /**
   * Get Price Date
   *
   * @return date
   */
  Timestamp getPriceDate();

  /**
   * Set Price Date
   *
   * @param priceDate date
   */
  void setPriceDate(Timestamp priceDate);

  /**
   * Get C_UOM_ID
   *
   * @return uom
   */
  int getC_UOM_ID();

  /**
   * Get Price List
   *
   * @return list
   */
  BigDecimal getPriceList();

  /**
   * Get Price Std
   *
   * @return std
   */
  BigDecimal getPriceStd();

  /**
   * Get Price Limit
   *
   * @return limit
   */
  BigDecimal getPriceLimit();

  /**
   * Get Price List Currency
   *
   * @return currency
   */
  int getC_Currency_ID();

  /**
   * Is Price List enforced?
   *
   * @return enforce limit
   */
  boolean isEnforcePriceLimit();

  /**
   * Is a DiscountSchema active?
   *
   * @return active Discount Schema
   */
  boolean isDiscountSchema();

  /**
   * Is the Price Calculated (i.e. found)?
   *
   * @return calculated
   */
  boolean isCalculated();

  /**
   * Set order line and calculate the parameters from it
   *
   * @param orderLine
   * @param trxName
   */
  void setOrderLine(I_C_OrderLine orderLine, String trxName);

  /**
   * Set invoice line and calculate the parameters from it
   *
   * @param invoiceLine
   * @param trxName
   */
  void setInvoiceLine(I_C_InvoiceLine invoiceLine, String trxName);

  /**
   * Set project line and calculate the parameters from it
   *
   * @param projectLine
   * @param trxName
   */
  void setProjectLine(I_C_ProjectLine projectLine, String trxName);

  /**
   * Set requisition line and calculate the parameters from it
   *
   * @param reqLine
   * @param trxName
   */
  void setRequisitionLine(I_M_RequisitionLine reqLine, String trxName);

  /**
   * Set rma line and calculate the parameters from it
   *
   * @param rmaLine
   * @param trxName
   */
  void setRMALine(I_M_RMALine rmaLine, String trxName);
}
