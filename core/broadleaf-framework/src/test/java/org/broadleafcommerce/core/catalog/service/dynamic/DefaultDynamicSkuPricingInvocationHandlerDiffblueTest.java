/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.catalog.service.dynamic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;

public class DefaultDynamicSkuPricingInvocationHandlerDiffblueTest {
  /**
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#unwrap()}
   */
  @Test
  public void testUnwrap() {
    // Arrange
    DefaultDynamicSkuPricingInvocationHandler defaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new BigDecimal("2.3"));

    // Act and Assert
    assertSame(defaultDynamicSkuPricingInvocationHandler.delegate, defaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new BigDecimal("2.3"));

    // Assert
    Sku sku = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Currency currency = money.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertNull(sku.getTaxable());
    DynamicSkuPrices priceData = sku.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku.getId());
    assertNull(sku.getDescription());
    assertNull(sku.getDisplayTemplate());
    assertNull(sku.getExternalId());
    assertNull(sku.getLongDescription());
    assertNull(sku.getName());
    assertNull(sku.getTaxCode());
    assertNull(sku.getUpc());
    assertNull(sku.getUrlKey());
    assertNull(sku.getActiveEndDate());
    assertNull(sku.getActiveStartDate());
    assertNull(sku.getCurrency());
    assertNull(sku.getPrimarySkuMedia());
    assertNull(sku.getBaseRetailPrice());
    assertNull(sku.getBaseSalePrice());
    assertNull(sku.getCost());
    assertNull(sku.getListPrice());
    assertNull(sku.getPrice());
    assertNull(sku.getProductOptionValueAdjustments());
    assertNull(sku.getRetailPrice());
    assertNull(sku.getSalePrice());
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(sku.getDefaultProduct());
    assertNull(sku.getProduct());
    assertNull(sku.getInventoryType());
    assertNull(sku.getFulfillmentType());
    assertEquals(0, sku.getQuantityAvailable().intValue());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertFalse(sku.getIsMachineSortable());
    assertFalse(sku.hasRetailPrice());
    assertFalse(sku.hasSalePrice());
    assertFalse(((SkuImpl) sku).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku.getProductOptionValues().isEmpty());
    assertTrue(sku.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku.getSkuAttributes().isEmpty());
    assertTrue(sku.getSkuMedia().isEmpty());
    assertTrue(sku.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku.getAvailable());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = money.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, money.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    Money expectedAbsResult = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAbsResult, money.abs());
    assertSame(currency, zeroResult.getCurrency());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#reset()}
   */
  @Test
  public void testReset() {
    // Arrange
    DefaultDynamicSkuPricingInvocationHandler defaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new BigDecimal("2.3"));

    // Act
    defaultDynamicSkuPricingInvocationHandler.reset();

    // Assert
    assertNull(defaultDynamicSkuPricingInvocationHandler.salePrice);
    assertNull(defaultDynamicSkuPricingInvocationHandler.unwrap());
    assertNull(defaultDynamicSkuPricingInvocationHandler.delegate);
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler2() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        (BigDecimal) null);

    // Assert
    Sku sku = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku instanceof SkuImpl);
    assertNull(sku.getTaxable());
    DynamicSkuPrices priceData = sku.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku.getId());
    assertNull(sku.getDescription());
    assertNull(sku.getDisplayTemplate());
    assertNull(sku.getExternalId());
    assertNull(sku.getLongDescription());
    assertNull(sku.getName());
    assertNull(sku.getTaxCode());
    assertNull(sku.getUpc());
    assertNull(sku.getUrlKey());
    assertNull(sku.getActiveEndDate());
    assertNull(sku.getActiveStartDate());
    assertNull(sku.getCurrency());
    assertNull(sku.getPrimarySkuMedia());
    assertNull(sku.getBaseRetailPrice());
    assertNull(sku.getBaseSalePrice());
    assertNull(sku.getCost());
    assertNull(sku.getListPrice());
    assertNull(sku.getPrice());
    assertNull(sku.getProductOptionValueAdjustments());
    assertNull(sku.getRetailPrice());
    assertNull(sku.getSalePrice());
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertNull(sku.getDefaultProduct());
    assertNull(sku.getProduct());
    assertNull(sku.getInventoryType());
    assertNull(sku.getFulfillmentType());
    assertEquals(0, sku.getQuantityAvailable().intValue());
    assertFalse(sku.getIsMachineSortable());
    assertFalse(sku.hasRetailPrice());
    assertFalse(sku.hasSalePrice());
    assertFalse(((SkuImpl) sku).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku.getProductOptionValues().isEmpty());
    assertTrue(sku.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku.getSkuAttributes().isEmpty());
    assertTrue(sku.getSkuMedia().isEmpty());
    assertTrue(sku.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku.getAvailable());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler3() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new SkuImpl());

    // Assert
    Sku sku = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku instanceof SkuImpl);
    assertNull(sku.getTaxable());
    DynamicSkuPrices priceData = sku.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku.getId());
    assertNull(sku.getDescription());
    assertNull(sku.getDisplayTemplate());
    assertNull(sku.getExternalId());
    assertNull(sku.getLongDescription());
    assertNull(sku.getName());
    assertNull(sku.getTaxCode());
    assertNull(sku.getUpc());
    assertNull(sku.getUrlKey());
    assertNull(sku.getActiveEndDate());
    assertNull(sku.getActiveStartDate());
    assertNull(sku.getCurrency());
    assertNull(sku.getPrimarySkuMedia());
    assertNull(sku.getBaseRetailPrice());
    assertNull(sku.getBaseSalePrice());
    assertNull(sku.getCost());
    assertNull(sku.getListPrice());
    assertNull(sku.getPrice());
    assertNull(sku.getProductOptionValueAdjustments());
    assertNull(sku.getRetailPrice());
    assertNull(sku.getSalePrice());
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertNull(sku.getDefaultProduct());
    assertNull(sku.getProduct());
    assertNull(sku.getInventoryType());
    assertNull(sku.getFulfillmentType());
    assertEquals(0, sku.getQuantityAvailable().intValue());
    assertFalse(sku.getIsMachineSortable());
    assertFalse(sku.hasRetailPrice());
    assertFalse(sku.hasSalePrice());
    assertFalse(((SkuImpl) sku).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku.getProductOptionValues().isEmpty());
    assertTrue(sku.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku.getSkuAttributes().isEmpty());
    assertTrue(sku.getSkuMedia().isEmpty());
    assertTrue(sku.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku.getAvailable());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler4() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku);

    // Assert
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertNull(sku2.getTaxable());
    DynamicSkuPrices priceData = sku2.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku2.getId());
    assertNull(sku2.getDescription());
    assertNull(sku2.getDisplayTemplate());
    assertNull(sku2.getExternalId());
    assertNull(sku2.getLongDescription());
    assertNull(sku2.getName());
    assertNull(sku2.getTaxCode());
    assertNull(sku2.getUpc());
    assertNull(sku2.getUrlKey());
    assertNull(sku2.getActiveEndDate());
    assertNull(sku2.getActiveStartDate());
    assertNull(sku2.getCurrency());
    assertNull(sku2.getPrimarySkuMedia());
    assertNull(sku2.getBaseRetailPrice());
    assertNull(sku2.getCost());
    assertNull(sku2.getListPrice());
    assertNull(sku2.getPrice());
    assertNull(sku2.getProductOptionValueAdjustments());
    assertNull(sku2.getRetailPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(sku2.getDefaultProduct());
    assertNull(sku2.getProduct());
    assertNull(sku2.getInventoryType());
    assertNull(sku2.getFulfillmentType());
    assertEquals(0, sku2.getQuantityAvailable().intValue());
    assertFalse(sku2.getIsMachineSortable());
    assertFalse(sku2.hasRetailPrice());
    assertFalse(((SkuImpl) sku2).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku2.getProductOptionValues().isEmpty());
    assertTrue(sku2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuMedia().isEmpty());
    assertTrue(sku2.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku2.getAvailable());
    assertTrue(sku2.hasSalePrice());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
    Money price = priceData.getPrice();
    assertEquals(salePrice, price);
    assertEquals(salePrice, actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertSame(price, priceData.getSalePrice());
    Money expectedMargin = salePrice.ZERO;
    assertSame(expectedMargin, sku2.getMargin());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler5() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku);

    // Assert
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertNull(sku2.getTaxable());
    DynamicSkuPrices priceData = sku2.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku2.getId());
    assertNull(sku2.getDescription());
    assertNull(sku2.getDisplayTemplate());
    assertNull(sku2.getExternalId());
    assertNull(sku2.getLongDescription());
    assertNull(sku2.getName());
    assertNull(sku2.getTaxCode());
    assertNull(sku2.getUpc());
    assertNull(sku2.getUrlKey());
    assertNull(sku2.getActiveEndDate());
    assertNull(sku2.getActiveStartDate());
    assertNull(sku2.getCurrency());
    assertNull(sku2.getPrimarySkuMedia());
    assertNull(sku2.getBaseSalePrice());
    assertNull(sku2.getCost());
    assertNull(sku2.getProductOptionValueAdjustments());
    assertNull(sku2.getSalePrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getSalePrice());
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertNull(sku2.getDefaultProduct());
    assertNull(sku2.getProduct());
    assertNull(sku2.getInventoryType());
    assertNull(sku2.getFulfillmentType());
    assertEquals(0, sku2.getQuantityAvailable().intValue());
    assertFalse(sku2.getIsMachineSortable());
    assertFalse(sku2.hasSalePrice());
    assertFalse(((SkuImpl) sku2).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku2.getProductOptionValues().isEmpty());
    assertTrue(sku2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuMedia().isEmpty());
    assertTrue(sku2.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku2.getAvailable());
    assertTrue(sku2.hasRetailPrice());
    assertEquals(retailPrice, sku2.getBaseRetailPrice());
    assertEquals(retailPrice, sku2.getListPrice());
    assertEquals(retailPrice, sku2.getPrice());
    assertEquals(retailPrice, sku2.getRetailPrice());
    Money price = priceData.getPrice();
    assertEquals(retailPrice, price);
    assertEquals(retailPrice, actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertSame(price, priceData.getRetailPrice());
    Money expectedMargin = retailPrice.ZERO;
    assertSame(expectedMargin, sku2.getMargin());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler6() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setActiveStartDate(mock(java.sql.Date.class));

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku);

    // Assert
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertNull(sku2.getTaxable());
    DynamicSkuPrices priceData = sku2.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku2.getId());
    assertNull(sku2.getDescription());
    assertNull(sku2.getDisplayTemplate());
    assertNull(sku2.getExternalId());
    assertNull(sku2.getLongDescription());
    assertNull(sku2.getName());
    assertNull(sku2.getTaxCode());
    assertNull(sku2.getUpc());
    assertNull(sku2.getUrlKey());
    assertNull(sku2.getActiveEndDate());
    assertNull(sku2.getCurrency());
    assertNull(sku2.getPrimarySkuMedia());
    assertNull(sku2.getBaseRetailPrice());
    assertNull(sku2.getBaseSalePrice());
    assertNull(sku2.getCost());
    assertNull(sku2.getListPrice());
    assertNull(sku2.getPrice());
    assertNull(sku2.getProductOptionValueAdjustments());
    assertNull(sku2.getRetailPrice());
    assertNull(sku2.getSalePrice());
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertNull(sku2.getDefaultProduct());
    assertNull(sku2.getProduct());
    assertNull(sku2.getInventoryType());
    assertNull(sku2.getFulfillmentType());
    assertEquals(0, sku2.getQuantityAvailable().intValue());
    assertFalse(sku2.getIsMachineSortable());
    assertFalse(sku2.hasRetailPrice());
    assertFalse(sku2.hasSalePrice());
    assertFalse(((SkuImpl) sku2).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku2.getProductOptionValues().isEmpty());
    assertTrue(sku2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuMedia().isEmpty());
    assertTrue(sku2.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku2.getAvailable());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler7() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new BigDecimal("2.3"));

    // Assert
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Currency currency = money.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertNull(sku2.getTaxable());
    DynamicSkuPrices priceData = sku2.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku2.getId());
    assertNull(sku2.getDescription());
    assertNull(sku2.getDisplayTemplate());
    assertNull(sku2.getExternalId());
    assertNull(sku2.getLongDescription());
    assertNull(sku2.getName());
    assertNull(sku2.getTaxCode());
    assertNull(sku2.getUpc());
    assertNull(sku2.getUrlKey());
    assertNull(sku2.getActiveEndDate());
    assertNull(sku2.getActiveStartDate());
    assertNull(sku2.getCurrency());
    assertNull(sku2.getPrimarySkuMedia());
    assertNull(sku2.getBaseRetailPrice());
    assertNull(sku2.getBaseSalePrice());
    assertNull(sku2.getCost());
    assertNull(sku2.getListPrice());
    assertNull(sku2.getPrice());
    assertNull(sku2.getProductOptionValueAdjustments());
    assertNull(sku2.getRetailPrice());
    assertNull(sku2.getSalePrice());
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(sku2.getDefaultProduct());
    assertNull(sku2.getProduct());
    assertNull(sku2.getInventoryType());
    assertNull(sku2.getFulfillmentType());
    assertEquals(0, sku2.getQuantityAvailable().intValue());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertFalse(sku2.getIsMachineSortable());
    assertFalse(sku2.hasRetailPrice());
    assertFalse(sku2.hasSalePrice());
    assertFalse(((SkuImpl) sku2).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku2.getProductOptionValues().isEmpty());
    assertTrue(sku2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuMedia().isEmpty());
    assertTrue(sku2.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku2.getAvailable());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = money.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, money.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    Money expectedAbsResult = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAbsResult, money.abs());
    assertSame(currency, zeroResult.getCurrency());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler8() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new SkuImpl(), (BigDecimal) null);

    // Assert
    Sku sku = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku instanceof SkuImpl);
    assertNull(sku.getTaxable());
    DynamicSkuPrices priceData = sku.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku.getId());
    assertNull(sku.getDescription());
    assertNull(sku.getDisplayTemplate());
    assertNull(sku.getExternalId());
    assertNull(sku.getLongDescription());
    assertNull(sku.getName());
    assertNull(sku.getTaxCode());
    assertNull(sku.getUpc());
    assertNull(sku.getUrlKey());
    assertNull(sku.getActiveEndDate());
    assertNull(sku.getActiveStartDate());
    assertNull(sku.getCurrency());
    assertNull(sku.getPrimarySkuMedia());
    assertNull(sku.getBaseRetailPrice());
    assertNull(sku.getBaseSalePrice());
    assertNull(sku.getCost());
    assertNull(sku.getListPrice());
    assertNull(sku.getPrice());
    assertNull(sku.getProductOptionValueAdjustments());
    assertNull(sku.getRetailPrice());
    assertNull(sku.getSalePrice());
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertNull(sku.getDefaultProduct());
    assertNull(sku.getProduct());
    assertNull(sku.getInventoryType());
    assertNull(sku.getFulfillmentType());
    assertEquals(0, sku.getQuantityAvailable().intValue());
    assertFalse(sku.getIsMachineSortable());
    assertFalse(sku.hasRetailPrice());
    assertFalse(sku.hasSalePrice());
    assertFalse(((SkuImpl) sku).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku.getProductOptionValues().isEmpty());
    assertTrue(sku.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku.getSkuAttributes().isEmpty());
    assertTrue(sku.getSkuMedia().isEmpty());
    assertTrue(sku.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku.getAvailable());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler9() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new BigDecimal("2.3"));

    // Assert
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Currency currency = money.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertNull(sku2.getTaxable());
    DynamicSkuPrices priceData = sku2.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku2.getId());
    assertNull(sku2.getDescription());
    assertNull(sku2.getDisplayTemplate());
    assertNull(sku2.getExternalId());
    assertNull(sku2.getLongDescription());
    assertNull(sku2.getName());
    assertNull(sku2.getTaxCode());
    assertNull(sku2.getUpc());
    assertNull(sku2.getUrlKey());
    assertNull(sku2.getActiveEndDate());
    assertNull(sku2.getActiveStartDate());
    assertNull(sku2.getCurrency());
    assertNull(sku2.getPrimarySkuMedia());
    assertNull(sku2.getBaseRetailPrice());
    assertNull(sku2.getCost());
    assertNull(sku2.getListPrice());
    assertNull(sku2.getPrice());
    assertNull(sku2.getProductOptionValueAdjustments());
    assertNull(sku2.getRetailPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(sku2.getDefaultProduct());
    assertNull(sku2.getProduct());
    assertNull(sku2.getInventoryType());
    assertNull(sku2.getFulfillmentType());
    assertEquals(0, sku2.getQuantityAvailable().intValue());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertFalse(sku2.getIsMachineSortable());
    assertFalse(sku2.hasRetailPrice());
    assertFalse(((SkuImpl) sku2).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku2.getProductOptionValues().isEmpty());
    assertTrue(sku2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuMedia().isEmpty());
    assertTrue(sku2.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku2.getAvailable());
    assertTrue(sku2.hasSalePrice());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, money.getAmount());
    assertEquals(salePrice, money.zero());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
    Money price = priceData.getPrice();
    assertEquals(salePrice, price);
    Money expectedAbsResult = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAbsResult, money.abs());
    assertSame(price, priceData.getSalePrice());
    Money expectedMargin = salePrice.ZERO;
    assertSame(expectedMargin, sku2.getMargin());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler10() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new BigDecimal("2.3"));

    // Assert
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertNull(sku2.getTaxable());
    DynamicSkuPrices priceData = sku2.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku2.getId());
    assertNull(sku2.getDescription());
    assertNull(sku2.getDisplayTemplate());
    assertNull(sku2.getExternalId());
    assertNull(sku2.getLongDescription());
    assertNull(sku2.getName());
    assertNull(sku2.getTaxCode());
    assertNull(sku2.getUpc());
    assertNull(sku2.getUrlKey());
    assertNull(sku2.getActiveEndDate());
    assertNull(sku2.getActiveStartDate());
    assertNull(sku2.getCurrency());
    assertNull(sku2.getPrimarySkuMedia());
    assertNull(sku2.getBaseSalePrice());
    assertNull(sku2.getCost());
    assertNull(sku2.getProductOptionValueAdjustments());
    assertNull(sku2.getSalePrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getSalePrice());
    assertNull(sku2.getDefaultProduct());
    assertNull(sku2.getProduct());
    assertNull(sku2.getInventoryType());
    assertNull(sku2.getFulfillmentType());
    assertEquals(0, sku2.getQuantityAvailable().intValue());
    assertFalse(sku2.getIsMachineSortable());
    assertFalse(sku2.hasSalePrice());
    assertFalse(((SkuImpl) sku2).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku2.getProductOptionValues().isEmpty());
    assertTrue(sku2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuMedia().isEmpty());
    assertTrue(sku2.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku2.getAvailable());
    assertTrue(sku2.hasRetailPrice());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAmount, money.getAmount());
    assertEquals(retailPrice, money.zero());
    assertEquals(retailPrice, sku2.getBaseRetailPrice());
    assertEquals(retailPrice, sku2.getListPrice());
    assertEquals(retailPrice, sku2.getPrice());
    assertEquals(retailPrice, sku2.getRetailPrice());
    Money price = priceData.getPrice();
    assertEquals(retailPrice, price);
    assertEquals(retailPrice, actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    Money expectedAbsResult = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAbsResult, money.abs());
    assertSame(price, priceData.getRetailPrice());
    Money expectedMargin = retailPrice.ZERO;
    assertSame(expectedMargin, sku2.getMargin());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler11() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money adjustments = new Money();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, adjustments);

    // Assert
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.retailPrice;
    Currency currency = money.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertNull(sku2.getTaxable());
    DynamicSkuPrices priceData = sku2.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku2.getId());
    assertNull(sku2.getDescription());
    assertNull(sku2.getDisplayTemplate());
    assertNull(sku2.getExternalId());
    assertNull(sku2.getLongDescription());
    assertNull(sku2.getName());
    assertNull(sku2.getTaxCode());
    assertNull(sku2.getUpc());
    assertNull(sku2.getUrlKey());
    assertNull(sku2.getActiveEndDate());
    assertNull(sku2.getActiveStartDate());
    assertNull(sku2.getCurrency());
    assertNull(sku2.getPrimarySkuMedia());
    assertNull(sku2.getBaseRetailPrice());
    assertNull(sku2.getBaseSalePrice());
    assertNull(sku2.getCost());
    assertNull(sku2.getListPrice());
    assertNull(sku2.getPrice());
    assertNull(sku2.getProductOptionValueAdjustments());
    assertNull(sku2.getRetailPrice());
    assertNull(sku2.getSalePrice());
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(sku2.getDefaultProduct());
    assertNull(sku2.getProduct());
    assertNull(sku2.getInventoryType());
    assertNull(sku2.getFulfillmentType());
    assertEquals(0, sku2.getQuantityAvailable().intValue());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertFalse(sku2.getIsMachineSortable());
    assertFalse(sku2.hasRetailPrice());
    assertFalse(sku2.hasSalePrice());
    assertFalse(((SkuImpl) sku2).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku2.getProductOptionValues().isEmpty());
    assertTrue(sku2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuMedia().isEmpty());
    assertTrue(sku2.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku2.getAvailable());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = money.getAmount();
    assertEquals(expectedAmount, amount);
    Money money2 = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(money2, money.abs());
    Money money3 = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(money2, money3.abs());
    assertEquals(money2, money.zero());
    assertEquals(money2, money3.zero());
    assertSame(amount, money3.getAmount());
    assertSame(currency, money3.getCurrency());
    Money expectedMargin = adjustments.ZERO;
    assertSame(expectedMargin, sku2.getMargin());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler12() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new SkuImpl(), (Money) null);

    // Assert
    Sku sku = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku instanceof SkuImpl);
    assertNull(sku.getTaxable());
    DynamicSkuPrices priceData = sku.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku.getId());
    assertNull(sku.getDescription());
    assertNull(sku.getDisplayTemplate());
    assertNull(sku.getExternalId());
    assertNull(sku.getLongDescription());
    assertNull(sku.getName());
    assertNull(sku.getTaxCode());
    assertNull(sku.getUpc());
    assertNull(sku.getUrlKey());
    assertNull(sku.getActiveEndDate());
    assertNull(sku.getActiveStartDate());
    assertNull(sku.getCurrency());
    assertNull(sku.getPrimarySkuMedia());
    assertNull(sku.getBaseRetailPrice());
    assertNull(sku.getBaseSalePrice());
    assertNull(sku.getCost());
    assertNull(sku.getListPrice());
    assertNull(sku.getPrice());
    assertNull(sku.getProductOptionValueAdjustments());
    assertNull(sku.getRetailPrice());
    assertNull(sku.getSalePrice());
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertNull(sku.getDefaultProduct());
    assertNull(sku.getProduct());
    assertNull(sku.getInventoryType());
    assertNull(sku.getFulfillmentType());
    assertEquals(0, sku.getQuantityAvailable().intValue());
    assertFalse(sku.getIsMachineSortable());
    assertFalse(sku.hasRetailPrice());
    assertFalse(sku.hasSalePrice());
    assertFalse(((SkuImpl) sku).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku.getProductOptionValues().isEmpty());
    assertTrue(sku.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku.getSkuAttributes().isEmpty());
    assertTrue(sku.getSkuMedia().isEmpty());
    assertTrue(sku.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku.getAvailable());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler13() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);
    Money adjustments = new Money();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, adjustments);

    // Assert
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertNull(sku2.getTaxable());
    DynamicSkuPrices priceData = sku2.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku2.getId());
    assertNull(sku2.getDescription());
    assertNull(sku2.getDisplayTemplate());
    assertNull(sku2.getExternalId());
    assertNull(sku2.getLongDescription());
    assertNull(sku2.getName());
    assertNull(sku2.getTaxCode());
    assertNull(sku2.getUpc());
    assertNull(sku2.getUrlKey());
    assertNull(sku2.getActiveEndDate());
    assertNull(sku2.getActiveStartDate());
    assertNull(sku2.getCurrency());
    assertNull(sku2.getPrimarySkuMedia());
    assertNull(sku2.getBaseRetailPrice());
    assertNull(sku2.getCost());
    assertNull(sku2.getListPrice());
    assertNull(sku2.getPrice());
    assertNull(sku2.getProductOptionValueAdjustments());
    assertNull(sku2.getRetailPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(sku2.getDefaultProduct());
    assertNull(sku2.getProduct());
    assertNull(sku2.getInventoryType());
    assertNull(sku2.getFulfillmentType());
    assertEquals(0, sku2.getQuantityAvailable().intValue());
    assertFalse(sku2.getIsMachineSortable());
    assertFalse(sku2.hasRetailPrice());
    assertFalse(((SkuImpl) sku2).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku2.getProductOptionValues().isEmpty());
    assertTrue(sku2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuMedia().isEmpty());
    assertTrue(sku2.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku2.getAvailable());
    assertTrue(sku2.hasSalePrice());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
    Money price = priceData.getPrice();
    assertEquals(salePrice, price);
    assertEquals(salePrice, actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertEquals(salePrice, actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertSame(price, priceData.getSalePrice());
    Money expectedMargin = adjustments.ZERO;
    assertSame(expectedMargin, sku2.getMargin());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler14() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);
    Money adjustments = new Money();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, adjustments);

    // Assert
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertNull(sku2.getTaxable());
    DynamicSkuPrices priceData = sku2.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku2.getId());
    assertNull(sku2.getDescription());
    assertNull(sku2.getDisplayTemplate());
    assertNull(sku2.getExternalId());
    assertNull(sku2.getLongDescription());
    assertNull(sku2.getName());
    assertNull(sku2.getTaxCode());
    assertNull(sku2.getUpc());
    assertNull(sku2.getUrlKey());
    assertNull(sku2.getActiveEndDate());
    assertNull(sku2.getActiveStartDate());
    assertNull(sku2.getCurrency());
    assertNull(sku2.getPrimarySkuMedia());
    assertNull(sku2.getBaseSalePrice());
    assertNull(sku2.getCost());
    assertNull(sku2.getProductOptionValueAdjustments());
    assertNull(sku2.getSalePrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getSalePrice());
    assertNull(sku2.getDefaultProduct());
    assertNull(sku2.getProduct());
    assertNull(sku2.getInventoryType());
    assertNull(sku2.getFulfillmentType());
    assertEquals(0, sku2.getQuantityAvailable().intValue());
    assertFalse(sku2.getIsMachineSortable());
    assertFalse(sku2.hasSalePrice());
    assertFalse(((SkuImpl) sku2).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku2.getProductOptionValues().isEmpty());
    assertTrue(sku2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuMedia().isEmpty());
    assertTrue(sku2.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku2.getAvailable());
    assertTrue(sku2.hasRetailPrice());
    assertEquals(retailPrice, sku2.getBaseRetailPrice());
    assertEquals(retailPrice, sku2.getListPrice());
    assertEquals(retailPrice, sku2.getPrice());
    assertEquals(retailPrice, sku2.getRetailPrice());
    Money price = priceData.getPrice();
    assertEquals(retailPrice, price);
    assertEquals(retailPrice, actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertEquals(retailPrice, actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertSame(price, priceData.getRetailPrice());
    Money expectedMargin = adjustments.ZERO;
    assertSame(expectedMargin, sku2.getMargin());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler15() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setActiveStartDate(mock(java.sql.Date.class));
    Money adjustments = new Money();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, adjustments);

    // Assert
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.retailPrice;
    Currency currency = money.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertNull(sku2.getTaxable());
    DynamicSkuPrices priceData = sku2.getPriceData();
    assertNull(priceData.didOverride);
    assertNull(sku2.getId());
    assertNull(sku2.getDescription());
    assertNull(sku2.getDisplayTemplate());
    assertNull(sku2.getExternalId());
    assertNull(sku2.getLongDescription());
    assertNull(sku2.getName());
    assertNull(sku2.getTaxCode());
    assertNull(sku2.getUpc());
    assertNull(sku2.getUrlKey());
    assertNull(sku2.getActiveEndDate());
    assertNull(sku2.getCurrency());
    assertNull(sku2.getPrimarySkuMedia());
    assertNull(sku2.getBaseRetailPrice());
    assertNull(sku2.getBaseSalePrice());
    assertNull(sku2.getCost());
    assertNull(sku2.getListPrice());
    assertNull(sku2.getPrice());
    assertNull(sku2.getProductOptionValueAdjustments());
    assertNull(sku2.getRetailPrice());
    assertNull(sku2.getSalePrice());
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(sku2.getDefaultProduct());
    assertNull(sku2.getProduct());
    assertNull(sku2.getInventoryType());
    assertNull(sku2.getFulfillmentType());
    assertEquals(0, sku2.getQuantityAvailable().intValue());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertFalse(sku2.getIsMachineSortable());
    assertFalse(sku2.hasRetailPrice());
    assertFalse(sku2.hasSalePrice());
    assertFalse(((SkuImpl) sku2).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku2.getProductOptionValues().isEmpty());
    assertTrue(sku2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuAttributes().isEmpty());
    assertTrue(sku2.getSkuMedia().isEmpty());
    assertTrue(sku2.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku2.getAvailable());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = money.getAmount();
    assertEquals(expectedAmount, amount);
    Money money2 = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(money2, money.abs());
    Money money3 = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(money2, money3.abs());
    assertEquals(money2, money.zero());
    assertEquals(money2, money3.zero());
    assertSame(amount, money3.getAmount());
    assertSame(currency, money3.getCurrency());
    Money expectedMargin = adjustments.ZERO;
    assertSame(expectedMargin, sku2.getMargin());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }
}
