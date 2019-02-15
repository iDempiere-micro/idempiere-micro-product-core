package org.compiere.product;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;

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
      int M_Product_ID, int C_BPartner_ID, BigDecimal qty, boolean isSOTrx);

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
  void setOrderLine(I_C_OrderLine orderLine);

  /**
   * Set invoice line and calculate the parameters from it
   *
   * @param invoiceLine
   * @param trxName
   */
  void setInvoiceLine(I_C_InvoiceLine invoiceLine);

  /**
   * Set project line and calculate the parameters from it
   *
   * @param projectLine
   * @param trxName
   */
  void setProjectLine(I_C_ProjectLine projectLine);

  /**
   * Set requisition line and calculate the parameters from it
   *
   * @param reqLine
   * @param trxName
   */
  void setRequisitionLine(I_M_RequisitionLine reqLine);

}
