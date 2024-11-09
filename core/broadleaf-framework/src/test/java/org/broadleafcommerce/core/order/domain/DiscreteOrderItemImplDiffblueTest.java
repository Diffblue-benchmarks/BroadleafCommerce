/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
   * Test {@link DiscreteOrderItemImpl#getSku()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getSku()}
   */
  @Test
  public void testGetSku_givenDiscreteOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).getSku());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getSku()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor)
   * addCandidateItemOffer {@link CandidateItemOfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getSku()}
   */
  @Test
  public void testGetSku_givenDiscreteOrderItemImplAddCandidateItemOfferCandidateItemOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertNull(discreteOrderItemImpl.getSku());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor)
   * {@link DiscreteOrderItemImpl#baseSalePrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku_givenMoney_thenDiscreteOrderItemImplBaseSalePriceIsBigDecimalWith000() {
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
   * Test {@link DiscreteOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor)
   * {@link DiscreteOrderItemImpl#baseRetailPrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku_thenDiscreteOrderItemImplBaseRetailPriceIsBigDecimalWith000() {
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
   * Test {@link DiscreteOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor)
   * {@link DiscreteOrderItemImpl#baseSalePrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku_thenDiscreteOrderItemImplBaseSalePriceIsBigDecimalWith23() {
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
   * Test {@link DiscreteOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku_thenThrowIllegalStateException() {
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
   * Test {@link DiscreteOrderItemImpl#isTaxable()}.
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new DiscreteOrderItemImpl()).isTaxable());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getProduct()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getProduct()}
   */
  @Test
  public void testGetProduct_givenDiscreteOrderItemImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).getProduct());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getProduct()}.
   * <ul>
   *   <li>Then return {@link DiscreteOrderItemImpl} (default constructor)
   * {@link DiscreteOrderItemImpl#product}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getProduct()}
   */
  @Test
  public void testGetProduct_thenReturnDiscreteOrderItemImplProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setProduct(mock(Product.class));

    // Act and Assert
    assertSame(discreteOrderItemImpl.product, discreteOrderItemImpl.getProduct());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getProduct()}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getProduct()}
   */
  @Test
  public void testGetProduct_thenReturnProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    discreteOrderItemImpl.setProduct(product);

    // Act and Assert
    assertSame(product, discreteOrderItemImpl.getProduct());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}.
   * <p>
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
   * Test {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}.
   * <p>
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
   * Test {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}
   */
  @Test
  public void testSetBundleOrderItem_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> discreteOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl()));
  }

  /**
   * Test {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor) BundleOrderItem
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}
   */
  @Test
  public void testSetBundleOrderItem_whenNull_thenDiscreteOrderItemImplBundleOrderItemIsNull() {
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
   * Test {@link DiscreteOrderItemImpl#setOrder(Order)}.
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setOrder(Order)}
   */
  @Test
  public void testSetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act
    discreteOrderItemImpl.setOrder(order);

    // Assert
    Money futureCreditTotalAdjustmentValue = discreteOrderItemImpl.getFutureCreditTotalAdjustmentValue();
    Currency currency = futureCreditTotalAdjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(discreteOrderItemImpl.getCurrencyCode());
    assertNull(discreteOrderItemImpl.getTaxablePrice());
    assertNull(discreteOrderItemImpl.findParentItem());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, futureCreditTotalAdjustmentValue.getAmount());
    assertEquals(futureCreditTotalAdjustmentValue, futureCreditTotalAdjustmentValue.abs());
    assertEquals(futureCreditTotalAdjustmentValue, futureCreditTotalAdjustmentValue.zero());
    assertEquals(futureCreditTotalAdjustmentValue, discreteOrderItemImpl.getTotalAdjustmentValue());
    assertSame(order, discreteOrderItemImpl.getOrder());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#setOrder(Order)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setOrder(Order)}
   */
  @Test
  public void testSetOrder_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER));
  }

  /**
   * Test {@link DiscreteOrderItemImpl#setOrder(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor) Order is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setOrder(Order)}
   */
  @Test
  public void testSetOrder_whenNull_thenDiscreteOrderItemImplOrderIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();

    // Act
    discreteOrderItemImpl.setOrder(null);

    // Assert
    assertNull(discreteOrderItemImpl.getOrder());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getName()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Name is
   * {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getName()}
   */
  @Test
  public void testGetName_givenDiscreteOrderItemImplNameIsName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setName("Name");

    // Act and Assert
    assertEquals("Name", discreteOrderItemImpl.getName());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getOrder()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) BundleOrderItem
   * is {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getOrder()}
   */
  @Test
  public void testGetOrder_givenDiscreteOrderItemImplBundleOrderItemIsBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setBundleOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNull(discreteOrderItemImpl.getOrder());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getOrder()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getOrder()}
   */
  @Test
  public void testGetOrder_givenDiscreteOrderItemImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).getOrder());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getOrder()}.
   * <ul>
   *   <li>Then return {@link DiscreteOrderItemImpl} (default constructor)
   * {@link OrderItemImpl#order}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getOrder()}
   */
  @Test
  public void testGetOrder_thenReturnDiscreteOrderItemImplOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertSame(discreteOrderItemImpl.order, discreteOrderItemImpl.getOrder());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getOrder()}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getOrder()}
   */
  @Test
  public void testGetOrder_thenReturnNullOrderImpl() {
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
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
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
    assertEquals(826, currency.getNumericCode());
    assertFalse(actualOrder.getHasOrderAdjustments());
    assertFalse(actualOrder.getTaxOverride());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, orderAdjustmentsValue.getAmount());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualOrder.getSubTotal());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getOrder()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getOrder()}
   */
  @Test
  public void testGetOrder_thenThrowIllegalStateException() {
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
   * Test {@link DiscreteOrderItemImpl#updateSalePrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#updateSalePrice()}
   */
  @Test
  public void testUpdateSalePrice_givenDiscreteOrderItemImplPriceIsMoney_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateSalePrice());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#updateSalePrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is
   * {@link Money}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#updateSalePrice()}
   */
  @Test
  public void testUpdateSalePrice_givenDiscreteOrderItemImplPriceIsMoney_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(mock(Money.class));

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateSalePrice());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#updateRetailPrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#updateRetailPrice()}
   */
  @Test
  public void testUpdateRetailPrice_givenDiscreteOrderItemImplPriceIsMoney_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateRetailPrice());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#updateRetailPrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is
   * {@link Money}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#updateRetailPrice()}
   */
  @Test
  public void testUpdateRetailPrice_givenDiscreteOrderItemImplPriceIsMoney_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(mock(Money.class));

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateRetailPrice());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#updateSaleAndRetailPrices()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices_givenDiscreteOrderItemImplPriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#updateSaleAndRetailPrices()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices_givenDiscreteOrderItemImplPriceIsMoney2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(mock(Money.class));

    // Act and Assert
    assertFalse(discreteOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test getters and setters.
   * <p>
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
   * Test {@link DiscreteOrderItemImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Order is
   * {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_givenDiscreteOrderItemImplOrderIsNull_order() {
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
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualBaseRetailPrice.getAmount());
    assertEquals(actualBaseRetailPrice, actualBaseRetailPrice.abs());
    Money expectedZeroResult = actualBaseRetailPrice.ZERO;
    assertEquals(expectedZeroResult, actualBaseRetailPrice.zero());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_givenDiscreteOrderItemImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).getBaseRetailPrice());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_thenCallsGetCurrencyCode() {
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
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualBaseRetailPrice.getAmount());
    assertEquals(actualBaseRetailPrice, actualBaseRetailPrice.abs());
    Money expectedZeroResult = actualBaseRetailPrice.ZERO;
    assertEquals(expectedZeroResult, actualBaseRetailPrice.zero());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#setBaseRetailPrice(Money)}.
   * <p>
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
    assertEquals(new BigDecimal("0.00"), discreteOrderItemImpl.baseRetailPrice);
    BigDecimal bigDecimal = discreteOrderItemImpl.baseRetailPrice;
    Money absResult = baseRetailPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    Money absResult3 = absResult2.abs();
    assertSame(bigDecimal, absResult3.getAmount());
    Money absResult4 = absResult3.abs();
    assertSame(bigDecimal, absResult4.getAmount());
    Money absResult5 = absResult4.abs();
    assertSame(bigDecimal, absResult5.getAmount());
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = baseRetailPrice.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult12 = zeroResult2.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(bigDecimal, absResult15.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(bigDecimal, absResult19.abs().getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(bigDecimal, absResult22.abs().getAmount());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertSame(bigDecimal, absResult25.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(bigDecimal, absResult28.abs().getAmount());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    Money zeroResult60 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#setBaseRetailPrice(Money)}.
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  public void testSetBaseRetailPrice2() {
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
   * Test {@link DiscreteOrderItemImpl#setBaseRetailPrice(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor)
   * {@link DiscreteOrderItemImpl#baseRetailPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  public void testSetBaseRetailPrice_whenNull_thenDiscreteOrderItemImplBaseRetailPriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();

    // Act
    discreteOrderItemImpl.setBaseRetailPrice(null);

    // Assert
    assertNull(discreteOrderItemImpl.baseRetailPrice);
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Order is
   * {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_givenDiscreteOrderItemImplOrderIsNull_order() {
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
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualBaseSalePrice.getAmount());
    assertEquals(actualBaseSalePrice, actualBaseSalePrice.abs());
    Money expectedZeroResult = actualBaseSalePrice.ZERO;
    assertEquals(expectedZeroResult, actualBaseSalePrice.zero());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_givenDiscreteOrderItemImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).getBaseSalePrice());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_thenCallsGetCurrencyCode() {
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
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualBaseSalePrice.getAmount());
    assertEquals(actualBaseSalePrice, actualBaseSalePrice.abs());
    Money expectedZeroResult = actualBaseSalePrice.ZERO;
    assertEquals(expectedZeroResult, actualBaseSalePrice.zero());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#setBaseSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor)
   * {@link DiscreteOrderItemImpl#baseSalePrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  public void testSetBaseSalePrice_thenDiscreteOrderItemImplBaseSalePriceIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    Money baseSalePrice = new Money();

    // Act
    discreteOrderItemImpl.setBaseSalePrice(baseSalePrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), discreteOrderItemImpl.baseSalePrice);
    BigDecimal bigDecimal = discreteOrderItemImpl.baseSalePrice;
    Money absResult = baseSalePrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    Money absResult3 = absResult2.abs();
    assertSame(bigDecimal, absResult3.getAmount());
    Money absResult4 = absResult3.abs();
    assertSame(bigDecimal, absResult4.getAmount());
    Money absResult5 = absResult4.abs();
    assertSame(bigDecimal, absResult5.getAmount());
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = baseSalePrice.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult12 = zeroResult2.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(bigDecimal, absResult15.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(bigDecimal, absResult19.abs().getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(bigDecimal, absResult22.abs().getAmount());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertSame(bigDecimal, absResult25.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(bigDecimal, absResult28.abs().getAmount());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    Money zeroResult60 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#setBaseSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor)
   * {@link DiscreteOrderItemImpl#baseSalePrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  public void testSetBaseSalePrice_thenDiscreteOrderItemImplBaseSalePriceIsBigDecimalWith23() {
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
   * Test {@link DiscreteOrderItemImpl#setBaseSalePrice(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link DiscreteOrderItemImpl} (default constructor)
   * {@link DiscreteOrderItemImpl#baseSalePrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  public void testSetBaseSalePrice_whenNull_thenDiscreteOrderItemImplBaseSalePriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();

    // Act
    discreteOrderItemImpl.setBaseSalePrice(null);

    // Assert
    assertNull(discreteOrderItemImpl.baseSalePrice);
  }

  /**
   * Test {@link DiscreteOrderItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Order is
   * {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_givenDiscreteOrderItemImplOrderIsNull_order() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualConvertToMoneyResult = discreteOrderItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualConvertToMoneyResult.getAmount());
    assertEquals(actualConvertToMoneyResult, actualConvertToMoneyResult.abs());
    Money expectedZeroResult = actualConvertToMoneyResult.ZERO;
    assertEquals(expectedZeroResult, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_givenDiscreteOrderItemImpl_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DiscreteOrderItemImpl()).convertToMoney(null));
  }

  /**
   * Test {@link DiscreteOrderItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_thenCallsGetCurrencyCode() {
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
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualConvertToMoneyResult.getAmount());
    assertEquals(actualConvertToMoneyResult, actualConvertToMoneyResult.abs());
    Money expectedZeroResult = actualConvertToMoneyResult.ZERO;
    assertEquals(expectedZeroResult, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#isDiscountingAllowed()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  public void testIsDiscountingAllowed_givenDiscreteOrderItemImplPriceIsMoney_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(discreteOrderItemImpl.isDiscountingAllowed());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#isDiscountingAllowed()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} (default constructor) Price is
   * {@link Money}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  public void testIsDiscountingAllowed_givenDiscreteOrderItemImplPriceIsMoney_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setPrice(mock(Money.class));

    // Act and Assert
    assertFalse(discreteOrderItemImpl.isDiscountingAllowed());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#isDiscountingAllowed()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  public void testIsDiscountingAllowed_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    discreteOrderItemImpl.setDiscountingAllowed(true);

    // Act and Assert
    assertTrue(discreteOrderItemImpl.isDiscountingAllowed());
  }

  /**
   * Test {@link DiscreteOrderItemImpl#findParentItem()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl}
   * (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#findParentItem()}
   */
  @Test
  public void testFindParentItem_givenArrayListAddBundleOrderItemImpl_thenReturnNull() {
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
   * Test {@link DiscreteOrderItemImpl#findParentItem()}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getOrderItems()} return
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#findParentItem()}
   */
  @Test
  public void testFindParentItem_givenNullOrderImplGetOrderItemsReturnArrayList_thenReturnNull() {
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
   * Test {@link DiscreteOrderItemImpl#findParentItem()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) AdditionalOfferInformation
   * is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#findParentItem()}
   */
  @Test
  public void testFindParentItem_givenOrderImplAdditionalOfferInformationIsHashMap() {
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
   * Test {@link DiscreteOrderItemImpl#findParentItem()}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#findParentItem()}
   */
  @Test
  public void testFindParentItem_givenOrderItemImplAuditableIsAuditable_thenReturnNull() {
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
   * Test {@link DiscreteOrderItemImpl#findParentItem()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiscreteOrderItemImpl#findParentItem()}
   */
  @Test
  public void testFindParentItem_thenThrowIllegalStateException() {
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
   * Test
   * {@link DiscreteOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
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
   * Test new {@link DiscreteOrderItemImpl} (default constructor).
   * <p>
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
