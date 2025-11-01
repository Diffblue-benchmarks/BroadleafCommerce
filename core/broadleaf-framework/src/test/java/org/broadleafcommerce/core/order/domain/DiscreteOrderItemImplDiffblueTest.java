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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItem;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl;
import org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class DiscreteOrderItemImplDiffblueTest {
  /**
   * Method under test: {@link DiscreteOrderItemImpl#getSku()}
   */
  @Test
  public void testGetSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).getSku());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getSku()}
   */
  @Test
  public void testGetSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertNull(discreteOrderItemImpl.getSku());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getName()).thenReturn("Name");
    when(sku.getBaseRetailPrice()).thenReturn(new Money());
    when(sku.getBaseSalePrice()).thenReturn(new Money());

    // Act
    discreteOrderItemImpl.setSku(sku);

    // Assert
    verify(sku).getBaseRetailPrice();
    verify(sku).getBaseSalePrice();
    verify(sku).getName();
    verify(sku).isTaxable();
    assertEquals("Name", discreteOrderItemImpl.getName());
    assertEquals("Name", discreteOrderItemImpl.getMainEntityName());
    assertNull(discreteOrderItemImpl.getRetailPrice());
    assertNull(discreteOrderItemImpl.getSalePrice());
    assertFalse(discreteOrderItemImpl.isSkuActive());
    assertFalse(discreteOrderItemImpl.getIsOnSale());
    assertTrue(discreteOrderItemImpl.itemTaxable);
    assertEquals(new BigDecimal("0.00"), discreteOrderItemImpl.baseRetailPrice);
    assertEquals(new BigDecimal("0.00"), discreteOrderItemImpl.baseSalePrice);
    assertSame(sku, discreteOrderItemImpl.getSku());
    assertSame(sku, discreteOrderItemImpl.deproxiedSku);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getName()).thenReturn("Name");
    when(sku.getBaseRetailPrice()).thenReturn(money);
    when(sku.getBaseSalePrice()).thenReturn(new Money());

    // Act
    discreteOrderItemImpl.setSku(sku);

    // Assert
    verify(money).getAmount();
    verify(sku).getBaseRetailPrice();
    verify(sku).getBaseSalePrice();
    verify(sku).getName();
    verify(sku).isTaxable();
    assertEquals("Name", discreteOrderItemImpl.getName());
    assertEquals("Name", discreteOrderItemImpl.getMainEntityName());
    assertNull(discreteOrderItemImpl.getRetailPrice());
    assertNull(discreteOrderItemImpl.getSalePrice());
    assertFalse(discreteOrderItemImpl.isSkuActive());
    assertFalse(discreteOrderItemImpl.getIsOnSale());
    assertTrue(discreteOrderItemImpl.itemTaxable);
    assertEquals(new BigDecimal("0.00"), discreteOrderItemImpl.baseSalePrice);
    assertEquals(new BigDecimal("2.3"), discreteOrderItemImpl.baseRetailPrice);
    assertSame(sku, discreteOrderItemImpl.getSku());
    assertSame(sku, discreteOrderItemImpl.deproxiedSku);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money money2 = mock(Money.class);
    when(money2.getAmount()).thenReturn(new BigDecimal("2.3"));
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getName()).thenReturn("Name");
    when(sku.getBaseRetailPrice()).thenReturn(money);
    when(sku.getBaseSalePrice()).thenReturn(money2);

    // Act
    discreteOrderItemImpl.setSku(sku);

    // Assert
    verify(money).getAmount();
    verify(money2).getAmount();
    verify(sku).getBaseRetailPrice();
    verify(sku).getBaseSalePrice();
    verify(sku).getName();
    verify(sku).isTaxable();
    assertEquals("Name", discreteOrderItemImpl.getName());
    assertEquals("Name", discreteOrderItemImpl.getMainEntityName());
    assertNull(discreteOrderItemImpl.getRetailPrice());
    assertNull(discreteOrderItemImpl.getSalePrice());
    assertFalse(discreteOrderItemImpl.isSkuActive());
    assertFalse(discreteOrderItemImpl.getIsOnSale());
    assertTrue(discreteOrderItemImpl.itemTaxable);
    assertEquals(new BigDecimal("2.3"), discreteOrderItemImpl.baseRetailPrice);
    assertEquals(new BigDecimal("2.3"), discreteOrderItemImpl.baseSalePrice);
    assertSame(sku, discreteOrderItemImpl.getSku());
    assertSame(sku, discreteOrderItemImpl.deproxiedSku);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money money2 = mock(Money.class);
    when(money2.getAmount()).thenThrow(new IllegalStateException("foo"));
    Sku sku = mock(Sku.class);
    when(sku.getBaseRetailPrice()).thenReturn(money);
    when(sku.getBaseSalePrice()).thenReturn(money2);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> discreteOrderItemImpl.setSku(sku));
    verify(money).getAmount();
    verify(money2).getAmount();
    verify(sku).getBaseRetailPrice();
    verify(sku).getBaseSalePrice();
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new DiscreteOrderItemImpl()).isTaxable());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getProduct()}
   */
  @Test
  public void testGetProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).getProduct());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getProduct()}
   */
  @Test
  public void testGetProduct2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    discreteOrderItemImpl.setProduct(product);

    // Act and Assert
    assertSame(product, discreteOrderItemImpl.getProduct());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getProduct()}
   */
  @Test
  public void testGetProduct3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setProduct(mock(Product.class));

    // Act and Assert
    assertSame(discreteOrderItemImpl.product, discreteOrderItemImpl.getProduct());
  }

  /**
   * Method under test:
   * {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}
   */
  @Test
  public void testSetBundleOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();

    // Act
    discreteOrderItemImpl.setBundleOrderItem(bundleOrderItem);

    // Assert
    assertSame(bundleOrderItem, discreteOrderItemImpl.getBundleOrderItem());
  }

  /**
   * Method under test:
   * {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}
   */
  @Test
  public void testSetBundleOrderItem2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    BundleOrderItemImpl bundleOrderItem = mock(BundleOrderItemImpl.class);

    // Act
    discreteOrderItemImpl.setBundleOrderItem(bundleOrderItem);

    // Assert
    assertSame(bundleOrderItem, discreteOrderItemImpl.getBundleOrderItem());
  }

  /**
   * Method under test:
   * {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}
   */
  @Test
  public void testSetBundleOrderItem3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> discreteOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl()));
  }

  /**
   * Method under test:
   * {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}
   */
  @Test
  public void testSetBundleOrderItem4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    discreteOrderItemImpl.setBundleOrderItem(null);

    // Assert
    assertNull(discreteOrderItemImpl.getBundleOrderItem());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setOrder(Order)}
   */
  @Test
  public void testSetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();

    // Act
    discreteOrderItemImpl.setOrder(null);

    // Assert
    assertNull(discreteOrderItemImpl.getOrder());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setOrder(Order)}
   */
  @Test
  public void testSetOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act
    discreteOrderItemImpl.setOrder(order);

    // Assert
    Money futureCreditTotalAdjustmentValue = discreteOrderItemImpl.getFutureCreditTotalAdjustmentValue();
    Currency currency = futureCreditTotalAdjustmentValue.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertNull(discreteOrderItemImpl.getCurrencyCode());
    assertNull(discreteOrderItemImpl.getTaxablePrice());
    assertNull(discreteOrderItemImpl.findParentItem());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, futureCreditTotalAdjustmentValue.getAmount());
    assertEquals(futureCreditTotalAdjustmentValue, futureCreditTotalAdjustmentValue.abs());
    assertEquals(futureCreditTotalAdjustmentValue, futureCreditTotalAdjustmentValue.zero());
    assertEquals(futureCreditTotalAdjustmentValue, discreteOrderItemImpl.getTotalAdjustmentValue());
    assertSame(order, discreteOrderItemImpl.getOrder());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setOrder(Order)}
   */
  @Test
  public void testSetOrder3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER));
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setName("Name");

    // Act and Assert
    assertEquals("Name", discreteOrderItemImpl.getName());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).getOrder());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getOrder()}
   */
  @Test
  public void testGetOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNull(discreteOrderItemImpl.getOrder());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getOrder()}
   */
  @Test
  public void testGetOrder3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertSame(discreteOrderItemImpl.order, discreteOrderItemImpl.getOrder());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getOrder()}
   */
  @Test
  public void testGetOrder4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItem = mock(BundleOrderItemImpl.class);
    when(bundleOrderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setBundleOrderItem(bundleOrderItem);

    // Act
    Order actualOrder = discreteOrderItemImpl.getOrder();

    // Assert
    verify(bundleOrderItem).getOrder();
    assertTrue(actualOrder instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualOrder.getOrderAdjustmentsValue();
    Currency currency = orderAdjustmentsValue.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertNull(actualOrder.getBroadleafAccountId());
    assertNull(actualOrder.getId());
    assertNull(actualOrder.getEmailAddress());
    assertNull(actualOrder.getFulfillmentStatus());
    assertNull(actualOrder.getName());
    assertNull(actualOrder.getOrderNumber());
    assertNull(actualOrder.getSubmitDate());
    assertNull(actualOrder.getAllFutureCreditAdjustments());
    assertNull(actualOrder.getCandidateOrderOffers());
    assertNull(actualOrder.getAddedOfferCodes());
    assertNull(actualOrder.getFutureCreditOrderAdjustments());
    assertNull(actualOrder.getOrderAdjustments());
    assertNull(actualOrder.getDiscreteOrderItems());
    assertNull(actualOrder.getFulfillmentGroups());
    assertNull(actualOrder.getNonDiscreteOrderItems());
    assertNull(actualOrder.getOrderItems());
    assertNull(actualOrder.getOrderMessages());
    assertNull(actualOrder.getPayments());
    assertNull(actualOrder.getOrderAttributes());
    assertNull(actualOrder.getAdditionalOfferInformation());
    assertNull(actualOrder.getAuditable());
    assertNull(actualOrder.getCurrency());
    assertNull(actualOrder.getLocale());
    assertNull(actualOrder.getFulfillmentGroupAdjustmentsValue());
    assertNull(actualOrder.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertNull(actualOrder.getFutureCreditItemAdjustmentsValue());
    assertNull(actualOrder.getFutureCreditOrderAdjustmentsValue());
    assertNull(actualOrder.getItemAdjustmentsValue());
    assertNull(actualOrder.getTotal());
    assertNull(actualOrder.getTotalAdjustmentsValue());
    assertNull(actualOrder.getTotalAfterAppliedPayments());
    assertNull(actualOrder.getTotalFulfillmentCharges());
    assertNull(actualOrder.getTotalFutureCreditAdjustmentsValue());
    assertNull(actualOrder.getTotalShipping());
    assertNull(actualOrder.getTotalTax());
    assertNull(actualOrder.getStatus());
    assertNull(actualOrder.getCustomer());
    assertEquals(0, actualOrder.getItemCount());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertFalse(actualOrder.getHasOrderAdjustments());
    assertFalse(actualOrder.getTaxOverride());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, orderAdjustmentsValue.getAmount());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualOrder.getSubTotal());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getOrder()}
   */
  @Test
  public void testGetOrder5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItem = mock(BundleOrderItemImpl.class);
    when(bundleOrderItem.getOrder()).thenThrow(new IllegalStateException("foo"));

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setBundleOrderItem(bundleOrderItem);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> discreteOrderItemImpl.getOrder());
    verify(bundleOrderItem).getOrder();
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#updateSalePrice()}
   */
  @Test
  public void testUpdateSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateSalePrice());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#updateSalePrice()}
   */
  @Test
  public void testUpdateSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(mock(Money.class));

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateSalePrice());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#updateRetailPrice()}
   */
  @Test
  public void testUpdateRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateRetailPrice());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#updateRetailPrice()}
   */
  @Test
  public void testUpdateRetailPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(mock(Money.class));

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateRetailPrice());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(mock(Money.class));

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).getBaseRetailPrice());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money baseRetailPrice = mock(Money.class);
    when(baseRetailPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    discreteOrderItemImpl.setBaseRetailPrice(baseRetailPrice);

    // Act
    Money actualBaseRetailPrice = discreteOrderItemImpl.getBaseRetailPrice();

    // Assert
    verify(baseRetailPrice).getAmount();
    Currency currency = actualBaseRetailPrice.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualBaseRetailPrice.getAmount());
    assertEquals(actualBaseRetailPrice, actualBaseRetailPrice.abs());
    Money expectedZeroResult = actualBaseRetailPrice.ZERO;
    assertEquals(expectedZeroResult, actualBaseRetailPrice.zero());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money baseRetailPrice = mock(Money.class);
    when(baseRetailPrice.getAmount()).thenReturn(new BigDecimal("2.3"));
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(order);
    discreteOrderItemImpl.setBaseRetailPrice(baseRetailPrice);

    // Act
    Money actualBaseRetailPrice = discreteOrderItemImpl.getBaseRetailPrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(baseRetailPrice).getAmount();
    verify(order).getCurrency();
    Currency currency = actualBaseRetailPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualBaseRetailPrice.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualBaseRetailPrice.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(actualBaseRetailPrice, actualBaseRetailPrice.abs());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  public void testSetBaseRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    Money baseRetailPrice = new Money();

    // Act
    discreteOrderItemImpl.setBaseRetailPrice(baseRetailPrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = baseRetailPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), discreteOrderItemImpl.baseRetailPrice);
    assertEquals(baseRetailPrice, baseRetailPrice.abs());
    assertEquals(baseRetailPrice, baseRetailPrice.zero());
    assertSame(discreteOrderItemImpl.baseRetailPrice, amount);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  public void testSetBaseRetailPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();

    // Act
    discreteOrderItemImpl.setBaseRetailPrice(null);

    // Assert
    assertNull(discreteOrderItemImpl.baseRetailPrice);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  public void testSetBaseRetailPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    Money baseRetailPrice = mock(Money.class);
    when(baseRetailPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    discreteOrderItemImpl.setBaseRetailPrice(baseRetailPrice);

    // Assert
    verify(baseRetailPrice).getAmount();
    assertEquals(new BigDecimal("2.3"), discreteOrderItemImpl.baseRetailPrice);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).getBaseSalePrice());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money baseSalePrice = mock(Money.class);
    when(baseSalePrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    discreteOrderItemImpl.setBaseSalePrice(baseSalePrice);

    // Act
    Money actualBaseSalePrice = discreteOrderItemImpl.getBaseSalePrice();

    // Assert
    verify(baseSalePrice).getAmount();
    Currency currency = actualBaseSalePrice.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualBaseSalePrice.getAmount());
    assertEquals(actualBaseSalePrice, actualBaseSalePrice.abs());
    Money expectedZeroResult = actualBaseSalePrice.ZERO;
    assertEquals(expectedZeroResult, actualBaseSalePrice.zero());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money baseSalePrice = mock(Money.class);
    when(baseSalePrice.getAmount()).thenReturn(new BigDecimal("2.3"));
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(order);
    discreteOrderItemImpl.setBaseSalePrice(baseSalePrice);

    // Act
    Money actualBaseSalePrice = discreteOrderItemImpl.getBaseSalePrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(baseSalePrice).getAmount();
    verify(order).getCurrency();
    Currency currency = actualBaseSalePrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualBaseSalePrice.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualBaseSalePrice.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(actualBaseSalePrice, actualBaseSalePrice.abs());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  public void testSetBaseSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    Money baseSalePrice = new Money();

    // Act
    discreteOrderItemImpl.setBaseSalePrice(baseSalePrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = baseSalePrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), discreteOrderItemImpl.baseSalePrice);
    assertEquals(baseSalePrice, baseSalePrice.abs());
    assertEquals(baseSalePrice, baseSalePrice.zero());
    assertSame(discreteOrderItemImpl.baseSalePrice, amount);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  public void testSetBaseSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();

    // Act
    discreteOrderItemImpl.setBaseSalePrice(null);

    // Assert
    assertNull(discreteOrderItemImpl.baseSalePrice);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  public void testSetBaseSalePrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    Money baseSalePrice = mock(Money.class);
    when(baseSalePrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    discreteOrderItemImpl.setBaseSalePrice(baseSalePrice);

    // Assert
    verify(baseSalePrice).getAmount();
    assertEquals(new BigDecimal("2.3"), discreteOrderItemImpl.baseSalePrice);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualConvertToMoneyResult = discreteOrderItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualConvertToMoneyResult.getAmount());
    assertEquals(actualConvertToMoneyResult, actualConvertToMoneyResult.abs());
    Money expectedZeroResult = actualConvertToMoneyResult.ZERO;
    assertEquals(expectedZeroResult, actualConvertToMoneyResult.zero());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).convertToMoney(null));
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(order);

    // Act
    Money actualConvertToMoneyResult = discreteOrderItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualConvertToMoneyResult.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualConvertToMoneyResult.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(actualConvertToMoneyResult, actualConvertToMoneyResult.abs());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  public void testIsDiscountingAllowed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.isDiscountingAllowed());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  public void testIsDiscountingAllowed2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setDiscountingAllowed(true);

    // Act and Assert
    assertTrue(discreteOrderItemImpl.isDiscountingAllowed());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  public void testIsDiscountingAllowed3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(mock(Money.class));

    // Act and Assert
    assertFalse(discreteOrderItemImpl.isDiscountingAllowed());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#findParentItem()}
   */
  @Test
  public void testFindParentItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(order);

    // Act and Assert
    assertNull(discreteOrderItemImpl.findParentItem());
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#findParentItem()}
   */
  @Test
  public void testFindParentItem2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(order);

    // Act
    BundleOrderItem actualFindParentItemResult = discreteOrderItemImpl.findParentItem();

    // Assert
    verify(order).getOrderItems();
    assertNull(actualFindParentItemResult);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#findParentItem()}
   */
  @Test
  public void testFindParentItem3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(order);

    // Act
    BundleOrderItem actualFindParentItemResult = discreteOrderItemImpl.findParentItem();

    // Assert
    verify(order).getOrderItems();
    assertNull(actualFindParentItemResult);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#findParentItem()}
   */
  @Test
  public void testFindParentItem4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(orderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(order);

    // Act
    BundleOrderItem actualFindParentItemResult = discreteOrderItemImpl.findParentItem();

    // Assert
    verify(order).getOrderItems();
    assertNull(actualFindParentItemResult);
  }

  /**
   * Method under test: {@link DiscreteOrderItemImpl#findParentItem()}
   */
  @Test
  public void testFindParentItem5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    Mockito.<List<? extends OrderItem>>when(bundleOrderItemImpl.getOrderItems())
        .thenThrow(new IllegalStateException("foo"));

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(order);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> discreteOrderItemImpl.findParentItem());
    verify(bundleOrderItemImpl).getOrderItems();
    verify(order).getOrderItems();
  }

  /**
   * Method under test:
   * {@link DiscreteOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DiscreteOrderItem> actualCreateOrRetrieveCopyInstanceResult = discreteOrderItemImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DiscreteOrderItemImpl#setAdditionalAttributes(Map)}
   *   <li>{@link DiscreteOrderItemImpl#setDiscreteOrderItemFeePrices(List)}
   *   <li>{@link DiscreteOrderItemImpl#setProduct(Product)}
   *   <li>{@link DiscreteOrderItemImpl#setSkuBundleItem(SkuBundleItem)}
   *   <li>{@link DiscreteOrderItemImpl#getAdditionalAttributes()}
   *   <li>{@link DiscreteOrderItemImpl#getBundleOrderItem()}
   *   <li>{@link DiscreteOrderItemImpl#getDiscreteOrderItemFeePrices()}
   *   <li>{@link DiscreteOrderItemImpl#getSkuBundleItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    HashMap<String, String> additionalAttributes = new HashMap<>();

    // Act
    discreteOrderItemImpl.setAdditionalAttributes(additionalAttributes);
    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePrices = new ArrayList<>();
    discreteOrderItemImpl.setDiscreteOrderItemFeePrices(discreteOrderItemFeePrices);
    discreteOrderItemImpl.setProduct(new ProductBundleImpl());
    SkuBundleItemImpl SkuBundleItem = new SkuBundleItemImpl();
    discreteOrderItemImpl.setSkuBundleItem(SkuBundleItem);
    Map<String, String> actualAdditionalAttributes = discreteOrderItemImpl.getAdditionalAttributes();
    discreteOrderItemImpl.getBundleOrderItem();
    List<DiscreteOrderItemFeePrice> actualDiscreteOrderItemFeePrices = discreteOrderItemImpl
        .getDiscreteOrderItemFeePrices();
    SkuBundleItem actualSkuBundleItem = discreteOrderItemImpl.getSkuBundleItem();

    // Assert that nothing has changed
    assertTrue(actualDiscreteOrderItemFeePrices.isEmpty());
    assertTrue(actualAdditionalAttributes.isEmpty());
    assertSame(discreteOrderItemFeePrices, actualDiscreteOrderItemFeePrices);
    assertSame(additionalAttributes, actualAdditionalAttributes);
    assertSame(SkuBundleItem, actualSkuBundleItem);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DiscreteOrderItemImpl}
   */
  @Test
  public void testNewDiscreteOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    DiscreteOrderItemImpl actualDiscreteOrderItemImpl = new DiscreteOrderItemImpl();

    // Assert
    assertNull(actualDiscreteOrderItemImpl.discountsAllowed);
    assertNull(actualDiscreteOrderItemImpl.hasValidationError);
    assertNull(actualDiscreteOrderItemImpl.itemTaxable);
    assertNull(actualDiscreteOrderItemImpl.retailPriceOverride);
    assertNull(actualDiscreteOrderItemImpl.salePriceOverride);
    Auditable auditable = actualDiscreteOrderItemImpl.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(actualDiscreteOrderItemImpl.getId());
    assertNull(actualDiscreteOrderItemImpl.orderItemType);
    assertNull(actualDiscreteOrderItemImpl.baseRetailPrice);
    assertNull(actualDiscreteOrderItemImpl.baseSalePrice);
    assertNull(actualDiscreteOrderItemImpl.price);
    assertNull(actualDiscreteOrderItemImpl.retailPrice);
    assertNull(actualDiscreteOrderItemImpl.salePrice);
    assertNull(actualDiscreteOrderItemImpl.totalTax);
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(actualDiscreteOrderItemImpl.getCartMessages());
    assertNull(actualDiscreteOrderItemImpl.getBaseRetailPrice());
    assertNull(actualDiscreteOrderItemImpl.getBaseSalePrice());
    assertNull(actualDiscreteOrderItemImpl.getAdjustmentValue());
    assertNull(actualDiscreteOrderItemImpl.getAverageAdjustmentValue());
    assertNull(actualDiscreteOrderItemImpl.getAveragePrice());
    assertNull(actualDiscreteOrderItemImpl.getPrice());
    assertNull(actualDiscreteOrderItemImpl.getCategory());
    assertNull(actualDiscreteOrderItemImpl.category);
    assertNull(actualDiscreteOrderItemImpl.deproxiedCategory);
    assertNull(actualDiscreteOrderItemImpl.getProduct());
    assertNull(actualDiscreteOrderItemImpl.deproxiedProduct);
    assertNull(actualDiscreteOrderItemImpl.product);
    assertNull(actualDiscreteOrderItemImpl.getSku());
    assertNull(actualDiscreteOrderItemImpl.deproxiedSku);
    assertNull(actualDiscreteOrderItemImpl.sku);
    assertNull(actualDiscreteOrderItemImpl.getSkuBundleItem());
    assertNull(actualDiscreteOrderItemImpl.getBundleOrderItem());
    assertNull(actualDiscreteOrderItemImpl.getGiftWrapOrderItem());
    assertNull(actualDiscreteOrderItemImpl.giftWrapOrderItem);
    assertNull(actualDiscreteOrderItemImpl.getOrder());
    assertNull(actualDiscreteOrderItemImpl.getParentOrderItem());
    assertNull(actualDiscreteOrderItemImpl.getPersonalMessage());
    assertNull(actualDiscreteOrderItemImpl.getOrderItemType());
    assertEquals(0, actualDiscreteOrderItemImpl.getQuantity());
    assertFalse(actualDiscreteOrderItemImpl.getHasValidationError());
    assertFalse(actualDiscreteOrderItemImpl.getIsDiscounted());
    assertFalse(actualDiscreteOrderItemImpl.isChildOrderItem());
    assertTrue(actualDiscreteOrderItemImpl.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getCandidateItemOffers().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getChildOrderItems().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getOrderItemAdjustments().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getOrderItemPriceDetails().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getOrderItemQualifiers().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getProratedOrderItemAdjustments().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getAdditionalAttributes().isEmpty());
    assertTrue(actualDiscreteOrderItemImpl.getOrderItemAttributes().isEmpty());
  }
}
