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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductBundle;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class BundleOrderItemImplDiffblueTest {
  /**
   * Test {@link BundleOrderItemImpl#getSku()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSku()}
   */
  @Test
  public void testGetSku_givenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getSku());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSku()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor)
   * addCandidateItemOffer {@link CandidateItemOfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSku()}
   */
  @Test
  public void testGetSku_givenBundleOrderItemImplAddCandidateItemOfferCandidateItemOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertNull(bundleOrderItemImpl.getSku());
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When {@link Sku} {@link Sku#getRetailPrice()} return
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku_givenMoney_whenSkuGetRetailPriceReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getName()).thenReturn("Name");
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());

    // Act
    bundleOrderItemImpl.setSku(sku);

    // Assert
    verify(sku).getName();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
    verify(sku).isTaxable();
    assertEquals("Name", bundleOrderItemImpl.getMainEntityName());
    assertEquals("Name", bundleOrderItemImpl.getName());
    assertFalse(bundleOrderItemImpl.isSkuActive());
    assertTrue(bundleOrderItemImpl.itemTaxable);
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl.baseRetailPrice);
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl.baseSalePrice);
    assertSame(sku, bundleOrderItemImpl.getSku());
    assertSame(sku, bundleOrderItemImpl.deproxiedSku);
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor)
   * {@link BundleOrderItemImpl#baseRetailPrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku_thenBundleOrderItemImplBaseRetailPriceIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getName()).thenReturn("Name");
    when(sku.getRetailPrice()).thenReturn(money);
    when(sku.getSalePrice()).thenReturn(new Money());

    // Act
    bundleOrderItemImpl.setSku(sku);

    // Assert
    verify(money).getAmount();
    verify(sku).getName();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
    verify(sku).isTaxable();
    assertEquals("Name", bundleOrderItemImpl.getMainEntityName());
    assertEquals("Name", bundleOrderItemImpl.getName());
    assertFalse(bundleOrderItemImpl.isSkuActive());
    assertTrue(bundleOrderItemImpl.itemTaxable);
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl.baseSalePrice);
    assertEquals(new BigDecimal("2.3"), bundleOrderItemImpl.baseRetailPrice);
    assertSame(sku, bundleOrderItemImpl.getSku());
    assertSame(sku, bundleOrderItemImpl.deproxiedSku);
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor)
   * {@link BundleOrderItemImpl#baseSalePrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku_thenBundleOrderItemImplBaseSalePriceIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money money2 = mock(Money.class);
    when(money2.getAmount()).thenReturn(new BigDecimal("2.3"));
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getName()).thenReturn("Name");
    when(sku.getRetailPrice()).thenReturn(money);
    when(sku.getSalePrice()).thenReturn(money2);

    // Act
    bundleOrderItemImpl.setSku(sku);

    // Assert
    verify(money).getAmount();
    verify(money2).getAmount();
    verify(sku).getName();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
    verify(sku).isTaxable();
    assertEquals("Name", bundleOrderItemImpl.getMainEntityName());
    assertEquals("Name", bundleOrderItemImpl.getName());
    assertFalse(bundleOrderItemImpl.isSkuActive());
    assertTrue(bundleOrderItemImpl.itemTaxable);
    assertEquals(new BigDecimal("2.3"), bundleOrderItemImpl.baseRetailPrice);
    assertEquals(new BigDecimal("2.3"), bundleOrderItemImpl.baseSalePrice);
    assertSame(sku, bundleOrderItemImpl.getSku());
    assertSame(sku, bundleOrderItemImpl.deproxiedSku);
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) Sku is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku_whenNull_thenBundleOrderItemImplSkuIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    // Act
    bundleOrderItemImpl.setSku(null);

    // Assert
    assertEquals("Name", bundleOrderItemImpl.getMainEntityName());
    assertEquals("Name", bundleOrderItemImpl.getName());
    assertNull(bundleOrderItemImpl.getSku());
    assertNull(bundleOrderItemImpl.deproxiedSku);
    assertNull(bundleOrderItemImpl.sku);
    assertTrue(bundleOrderItemImpl.isSkuActive());
    assertTrue(bundleOrderItemImpl.itemTaxable);
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl.baseRetailPrice);
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl.baseSalePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getProductBundle()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getProductBundle()}
   */
  @Test
  public void testGetProductBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertNull(bundleOrderItemImpl.getProductBundle());
  }

  /**
   * Test {@link BundleOrderItemImpl#getProductBundle()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getProductBundle()}
   */
  @Test
  public void testGetProductBundle_givenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getProductBundle());
  }

  /**
   * Test {@link BundleOrderItemImpl#setProductBundle(ProductBundle)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) RetailPrice is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BundleOrderItemImpl#setProductBundle(ProductBundle)}
   */
  @Test
  public void testSetProductBundle_thenBundleOrderItemImplRetailPriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    ProductBundleImpl productBundle = mock(ProductBundleImpl.class);

    // Act
    bundleOrderItemImpl.setProductBundle(productBundle);

    // Assert
    assertNull(bundleOrderItemImpl.getRetailPrice());
    assertFalse(bundleOrderItemImpl.getAllowDiscountsOnChildItems());
    assertSame(productBundle, bundleOrderItemImpl.getProduct());
    assertSame(productBundle, bundleOrderItemImpl.getProductBundle());
    assertSame(productBundle, bundleOrderItemImpl.deproxiedProductBundle);
  }

  /**
   * Test {@link BundleOrderItemImpl#getAllowDiscountsOnChildItems()}.
   * <p>
   * Method under test:
   * {@link BundleOrderItemImpl#getAllowDiscountsOnChildItems()}
   */
  @Test
  public void testGetAllowDiscountsOnChildItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertTrue(bundleOrderItemImpl.getAllowDiscountsOnChildItems());
  }

  /**
   * Test {@link BundleOrderItemImpl#getAllowDiscountsOnChildItems()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BundleOrderItemImpl#getAllowDiscountsOnChildItems()}
   */
  @Test
  public void testGetAllowDiscountsOnChildItems_givenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BundleOrderItemImpl()).getAllowDiscountsOnChildItems());
  }

  /**
   * Test {@link BundleOrderItemImpl#isPricingAtContainerLevel()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isPricingAtContainerLevel()}
   */
  @Test
  public void testIsPricingAtContainerLevel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertFalse(bundleOrderItemImpl.isPricingAtContainerLevel());
  }

  /**
   * Test {@link BundleOrderItemImpl#isPricingAtContainerLevel()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isPricingAtContainerLevel()}
   */
  @Test
  public void testIsPricingAtContainerLevel_givenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BundleOrderItemImpl()).isPricingAtContainerLevel());
  }

  /**
   * Test {@link BundleOrderItemImpl#isDiscountingAllowed()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  public void testIsDiscountingAllowed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertFalse(bundleOrderItemImpl.isDiscountingAllowed());
  }

  /**
   * Test {@link BundleOrderItemImpl#isDiscountingAllowed()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  public void testIsDiscountingAllowed_givenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BundleOrderItemImpl()).isDiscountingAllowed());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemImpl#setBundleOrderItemFeePrices(List)}
   *   <li>{@link BundleOrderItemImpl#setDiscreteOrderItems(List)}
   *   <li>{@link BundleOrderItemImpl#getBundleOrderItemFeePrices()}
   *   <li>{@link BundleOrderItemImpl#getDiscreteOrderItems()}
   *   <li>{@link BundleOrderItemImpl#getOrderItems()}
   *   <li>{@link BundleOrderItemImpl#hasAdjustedItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    ArrayList<BundleOrderItemFeePrice> bundleOrderItemFeePrices = new ArrayList<>();

    // Act
    bundleOrderItemImpl.setBundleOrderItemFeePrices(bundleOrderItemFeePrices);
    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    List<BundleOrderItemFeePrice> actualBundleOrderItemFeePrices = bundleOrderItemImpl.getBundleOrderItemFeePrices();
    List<DiscreteOrderItem> actualDiscreteOrderItems = bundleOrderItemImpl.getDiscreteOrderItems();
    List<? extends OrderItem> actualOrderItems = bundleOrderItemImpl.getOrderItems();

    // Assert that nothing has changed
    assertFalse(bundleOrderItemImpl.hasAdjustedItems());
    assertTrue(actualBundleOrderItemFeePrices.isEmpty());
    assertTrue(actualDiscreteOrderItems.isEmpty());
    assertSame(bundleOrderItemFeePrices, actualBundleOrderItemFeePrices);
    assertSame(discreteOrderItems, actualDiscreteOrderItems);
    assertSame(discreteOrderItems, actualOrderItems);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  public void testGetTaxablePrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualTaxablePrice = bundleOrderItemImpl.getTaxablePrice();

    // Assert
    assertEquals(actualTaxablePrice.ZERO, actualTaxablePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  public void testGetTaxablePrice_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    Money money = new Money();
    when(discreteOrderItemImpl.getTaxablePrice()).thenReturn(money);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = bundleOrderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getTaxablePrice();
    assertEquals(money, actualTaxablePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  public void testGetTaxablePrice_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = bundleOrderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualTaxablePrice.ZERO, actualTaxablePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   * <ul>
   *   <li>Then return zero Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  public void testGetTaxablePrice_thenReturnZeroAmountIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getTaxablePrice()).thenReturn(money);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = bundleOrderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getTaxablePrice();
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualTaxablePrice.zero();
    BigDecimal amount = zeroResult.getAmount();
    assertEquals(expectedAmount, amount);
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualTaxablePrice.getAmount());
    assertEquals(actualTaxablePrice, actualTaxablePrice.abs());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = zeroResult2.zero();
    Money zeroResult4 = zeroResult3.zero();
    Money zeroResult5 = zeroResult4.zero();
    BigDecimal amount2 = zeroResult5.zero().getAmount();
    Money absResult = zeroResult.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    assertSame(amount2, absResult5.abs().getAmount());
    assertSame(amount2, absResult5.getAmount());
    Money zeroResult6 = absResult.zero();
    Money absResult6 = zeroResult6.abs();
    Money absResult7 = absResult6.abs();
    Money absResult8 = absResult7.abs();
    assertSame(amount2, absResult8.abs().getAmount());
    assertSame(amount2, absResult4.getAmount());
    Money zeroResult7 = absResult2.zero();
    Money absResult9 = zeroResult7.abs();
    Money absResult10 = absResult9.abs();
    assertSame(amount2, absResult10.abs().getAmount());
    assertSame(amount2, absResult8.getAmount());
    Money zeroResult8 = zeroResult6.zero();
    Money absResult11 = zeroResult8.abs();
    Money absResult12 = absResult11.abs();
    assertSame(amount2, absResult12.abs().getAmount());
    assertSame(amount2, absResult3.getAmount());
    Money zeroResult9 = absResult3.zero();
    Money absResult13 = zeroResult9.abs();
    assertSame(amount2, absResult13.abs().getAmount());
    assertSame(amount2, absResult10.getAmount());
    Money zeroResult10 = absResult6.zero();
    Money absResult14 = zeroResult10.abs();
    assertSame(amount2, absResult14.abs().getAmount());
    assertSame(amount2, absResult7.getAmount());
    Money zeroResult11 = zeroResult7.zero();
    Money absResult15 = zeroResult11.abs();
    assertSame(amount2, absResult15.abs().getAmount());
    assertSame(amount2, absResult12.getAmount());
    Money zeroResult12 = zeroResult8.zero();
    Money absResult16 = zeroResult12.abs();
    assertSame(amount2, absResult16.abs().getAmount());
    assertSame(amount2, absResult2.getAmount());
    Money zeroResult13 = absResult4.zero();
    assertSame(amount2, zeroResult13.abs().getAmount());
    assertSame(amount2, absResult13.getAmount());
    Money zeroResult14 = absResult7.zero();
    assertSame(amount2, zeroResult14.abs().getAmount());
    assertSame(amount2, absResult9.getAmount());
    Money zeroResult15 = absResult9.zero();
    assertSame(amount2, zeroResult15.abs().getAmount());
    assertSame(amount2, absResult14.getAmount());
    Money zeroResult16 = absResult11.zero();
    assertSame(amount2, zeroResult16.abs().getAmount());
    assertSame(amount2, absResult6.getAmount());
    Money zeroResult17 = zeroResult9.zero();
    assertSame(amount2, zeroResult17.abs().getAmount());
    assertSame(amount2, absResult15.getAmount());
    Money zeroResult18 = zeroResult10.zero();
    assertSame(amount2, zeroResult18.abs().getAmount());
    assertSame(amount2, absResult11.getAmount());
    Money zeroResult19 = zeroResult11.zero();
    assertSame(amount2, zeroResult19.abs().getAmount());
    assertSame(amount2, absResult16.getAmount());
    Money zeroResult20 = zeroResult12.zero();
    assertSame(amount2, zeroResult20.abs().getAmount());
    assertSame(amount2, absResult.getAmount());
    assertSame(amount2, absResult5.zero().getAmount());
    assertSame(amount2, zeroResult13.getAmount());
    assertSame(amount2, absResult8.zero().getAmount());
    assertSame(amount2, zeroResult9.getAmount());
    assertSame(amount2, absResult10.zero().getAmount());
    assertSame(amount2, zeroResult14.getAmount());
    assertSame(amount2, absResult12.zero().getAmount());
    assertSame(amount2, zeroResult7.getAmount());
    assertSame(amount2, absResult13.zero().getAmount());
    assertSame(amount2, zeroResult15.getAmount());
    assertSame(amount2, absResult14.zero().getAmount());
    assertSame(amount2, zeroResult10.getAmount());
    assertSame(amount2, absResult15.zero().getAmount());
    assertSame(amount2, zeroResult16.getAmount());
    assertSame(amount2, absResult16.zero().getAmount());
    assertSame(amount2, zeroResult6.getAmount());
    assertSame(amount2, zeroResult13.zero().getAmount());
    assertSame(amount2, zeroResult17.getAmount());
    assertSame(amount2, zeroResult14.zero().getAmount());
    assertSame(amount2, zeroResult11.getAmount());
    assertSame(amount2, zeroResult15.zero().getAmount());
    assertSame(amount2, zeroResult18.getAmount());
    assertSame(amount2, zeroResult16.zero().getAmount());
    assertSame(amount2, zeroResult8.getAmount());
    assertSame(amount2, zeroResult17.zero().getAmount());
    assertSame(amount2, zeroResult19.getAmount());
    assertSame(amount2, zeroResult18.zero().getAmount());
    assertSame(amount2, zeroResult12.getAmount());
    assertSame(amount2, zeroResult19.zero().getAmount());
    assertSame(amount2, zeroResult20.getAmount());
    assertSame(amount2, zeroResult20.zero().getAmount());
    assertSame(amount2, amount2);
    assertSame(zeroResult5.getAmount(), zeroResult5.getAmount());
    BigDecimal amount3 = zeroResult4.getAmount();
    assertSame(amount3, zeroResult5.abs().getAmount());
    assertSame(amount3, amount3);
    BigDecimal amount4 = zeroResult3.getAmount();
    Money absResult17 = zeroResult4.abs();
    Money absResult18 = absResult17.abs();
    assertSame(amount4, absResult18.abs().getAmount());
    assertSame(amount4, absResult18.getAmount());
    assertSame(amount4, absResult17.getAmount());
    assertSame(amount4, absResult18.zero().getAmount());
    assertSame(amount4, absResult17.zero().getAmount());
    assertSame(amount4, amount4);
    BigDecimal amount5 = zeroResult2.getAmount();
    Money absResult19 = zeroResult3.abs();
    Money absResult20 = absResult19.abs();
    Money absResult21 = absResult20.abs();
    assertSame(amount5, absResult21.abs().getAmount());
    assertSame(amount5, absResult21.getAmount());
    Money zeroResult21 = absResult19.zero();
    Money absResult22 = zeroResult21.abs();
    assertSame(amount5, absResult22.abs().getAmount());
    assertSame(amount5, absResult20.getAmount());
    Money zeroResult22 = absResult20.zero();
    assertSame(amount5, zeroResult22.abs().getAmount());
    assertSame(amount5, absResult22.getAmount());
    Money zeroResult23 = zeroResult21.zero();
    assertSame(amount5, zeroResult23.abs().getAmount());
    assertSame(amount5, absResult19.getAmount());
    assertSame(amount5, absResult21.zero().getAmount());
    assertSame(amount5, zeroResult22.getAmount());
    assertSame(amount5, absResult22.zero().getAmount());
    assertSame(amount5, zeroResult21.getAmount());
    assertSame(amount5, zeroResult22.zero().getAmount());
    assertSame(amount5, zeroResult23.getAmount());
    assertSame(amount5, zeroResult23.zero().getAmount());
    assertSame(amount5, amount5);
    Money absResult23 = zeroResult2.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertSame(amount, absResult26.abs().getAmount());
    assertSame(amount, absResult26.getAmount());
    Money zeroResult24 = absResult23.zero();
    Money absResult27 = zeroResult24.abs();
    Money absResult28 = absResult27.abs();
    assertSame(amount, absResult28.abs().getAmount());
    assertSame(amount, absResult25.getAmount());
    Money zeroResult25 = absResult24.zero();
    Money absResult29 = zeroResult25.abs();
    assertSame(amount, absResult29.abs().getAmount());
    assertSame(amount, absResult28.getAmount());
    Money zeroResult26 = zeroResult24.zero();
    Money absResult30 = zeroResult26.abs();
    assertSame(amount, absResult30.abs().getAmount());
    assertSame(amount, absResult24.getAmount());
    Money zeroResult27 = absResult25.zero();
    assertSame(amount, zeroResult27.abs().getAmount());
    assertSame(amount, absResult29.getAmount());
    Money zeroResult28 = absResult27.zero();
    assertSame(amount, zeroResult28.abs().getAmount());
    assertSame(amount, absResult27.getAmount());
    Money zeroResult29 = zeroResult25.zero();
    assertSame(amount, zeroResult29.abs().getAmount());
    assertSame(amount, absResult30.getAmount());
    Money zeroResult30 = zeroResult26.zero();
    assertSame(amount, zeroResult30.abs().getAmount());
    assertSame(amount, absResult23.getAmount());
    assertSame(amount, absResult26.zero().getAmount());
    assertSame(amount, zeroResult27.getAmount());
    assertSame(amount, absResult28.zero().getAmount());
    assertSame(amount, zeroResult25.getAmount());
    assertSame(amount, absResult29.zero().getAmount());
    assertSame(amount, zeroResult28.getAmount());
    assertSame(amount, absResult30.zero().getAmount());
    assertSame(amount, zeroResult24.getAmount());
    assertSame(amount, zeroResult27.zero().getAmount());
    assertSame(amount, zeroResult29.getAmount());
    assertSame(amount, zeroResult28.zero().getAmount());
    assertSame(amount, zeroResult26.getAmount());
    assertSame(amount, zeroResult29.zero().getAmount());
    assertSame(amount, zeroResult30.getAmount());
    assertSame(amount, zeroResult30.zero().getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#isTaxable()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertTrue(bundleOrderItemImpl.isTaxable());
  }

  /**
   * Test {@link BundleOrderItemImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable_givenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BundleOrderItemImpl()).isTaxable());
  }

  /**
   * Test {@link BundleOrderItemImpl#shouldSumItems()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#shouldSumItems()}
   */
  @Test
  public void testShouldSumItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertTrue(bundleOrderItemImpl.shouldSumItems());
  }

  /**
   * Test {@link BundleOrderItemImpl#shouldSumItems()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#shouldSumItems()}
   */
  @Test
  public void testShouldSumItems_givenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BundleOrderItemImpl()).shouldSumItems());
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualRetailPrice = bundleOrderItemImpl.getRetailPrice();

    // Assert
    assertEquals(actualRetailPrice.ZERO, actualRetailPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    Money money = new Money();
    when(discreteOrderItemImpl.getRetailPrice()).thenReturn(money);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualRetailPrice = bundleOrderItemImpl.getRetailPrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getRetailPrice();
    assertEquals(money, actualRetailPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualRetailPrice = bundleOrderItemImpl.getRetailPrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualRetailPrice.ZERO, actualRetailPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then return zero Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_thenReturnZeroAmountIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getRetailPrice()).thenReturn(money);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualRetailPrice = bundleOrderItemImpl.getRetailPrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getRetailPrice();
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualRetailPrice.zero();
    BigDecimal amount = zeroResult.getAmount();
    assertEquals(expectedAmount, amount);
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualRetailPrice.getAmount());
    assertEquals(actualRetailPrice, actualRetailPrice.abs());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = zeroResult2.zero();
    Money zeroResult4 = zeroResult3.zero();
    Money zeroResult5 = zeroResult4.zero();
    BigDecimal amount2 = zeroResult5.zero().getAmount();
    Money absResult = zeroResult.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    assertSame(amount2, absResult5.abs().getAmount());
    assertSame(amount2, absResult5.getAmount());
    Money zeroResult6 = absResult.zero();
    Money absResult6 = zeroResult6.abs();
    Money absResult7 = absResult6.abs();
    Money absResult8 = absResult7.abs();
    assertSame(amount2, absResult8.abs().getAmount());
    assertSame(amount2, absResult4.getAmount());
    Money zeroResult7 = absResult2.zero();
    Money absResult9 = zeroResult7.abs();
    Money absResult10 = absResult9.abs();
    assertSame(amount2, absResult10.abs().getAmount());
    assertSame(amount2, absResult8.getAmount());
    Money zeroResult8 = zeroResult6.zero();
    Money absResult11 = zeroResult8.abs();
    Money absResult12 = absResult11.abs();
    assertSame(amount2, absResult12.abs().getAmount());
    assertSame(amount2, absResult3.getAmount());
    Money zeroResult9 = absResult3.zero();
    Money absResult13 = zeroResult9.abs();
    assertSame(amount2, absResult13.abs().getAmount());
    assertSame(amount2, absResult10.getAmount());
    Money zeroResult10 = absResult6.zero();
    Money absResult14 = zeroResult10.abs();
    assertSame(amount2, absResult14.abs().getAmount());
    assertSame(amount2, absResult7.getAmount());
    Money zeroResult11 = zeroResult7.zero();
    Money absResult15 = zeroResult11.abs();
    assertSame(amount2, absResult15.abs().getAmount());
    assertSame(amount2, absResult12.getAmount());
    Money zeroResult12 = zeroResult8.zero();
    Money absResult16 = zeroResult12.abs();
    assertSame(amount2, absResult16.abs().getAmount());
    assertSame(amount2, absResult2.getAmount());
    Money zeroResult13 = absResult4.zero();
    assertSame(amount2, zeroResult13.abs().getAmount());
    assertSame(amount2, absResult13.getAmount());
    Money zeroResult14 = absResult7.zero();
    assertSame(amount2, zeroResult14.abs().getAmount());
    assertSame(amount2, absResult9.getAmount());
    Money zeroResult15 = absResult9.zero();
    assertSame(amount2, zeroResult15.abs().getAmount());
    assertSame(amount2, absResult14.getAmount());
    Money zeroResult16 = absResult11.zero();
    assertSame(amount2, zeroResult16.abs().getAmount());
    assertSame(amount2, absResult6.getAmount());
    Money zeroResult17 = zeroResult9.zero();
    assertSame(amount2, zeroResult17.abs().getAmount());
    assertSame(amount2, absResult15.getAmount());
    Money zeroResult18 = zeroResult10.zero();
    assertSame(amount2, zeroResult18.abs().getAmount());
    assertSame(amount2, absResult11.getAmount());
    Money zeroResult19 = zeroResult11.zero();
    assertSame(amount2, zeroResult19.abs().getAmount());
    assertSame(amount2, absResult16.getAmount());
    Money zeroResult20 = zeroResult12.zero();
    assertSame(amount2, zeroResult20.abs().getAmount());
    assertSame(amount2, absResult.getAmount());
    assertSame(amount2, absResult5.zero().getAmount());
    assertSame(amount2, zeroResult13.getAmount());
    assertSame(amount2, absResult8.zero().getAmount());
    assertSame(amount2, zeroResult9.getAmount());
    assertSame(amount2, absResult10.zero().getAmount());
    assertSame(amount2, zeroResult14.getAmount());
    assertSame(amount2, absResult12.zero().getAmount());
    assertSame(amount2, zeroResult7.getAmount());
    assertSame(amount2, absResult13.zero().getAmount());
    assertSame(amount2, zeroResult15.getAmount());
    assertSame(amount2, absResult14.zero().getAmount());
    assertSame(amount2, zeroResult10.getAmount());
    assertSame(amount2, absResult15.zero().getAmount());
    assertSame(amount2, zeroResult16.getAmount());
    assertSame(amount2, absResult16.zero().getAmount());
    assertSame(amount2, zeroResult6.getAmount());
    assertSame(amount2, zeroResult13.zero().getAmount());
    assertSame(amount2, zeroResult17.getAmount());
    assertSame(amount2, zeroResult14.zero().getAmount());
    assertSame(amount2, zeroResult11.getAmount());
    assertSame(amount2, zeroResult15.zero().getAmount());
    assertSame(amount2, zeroResult18.getAmount());
    assertSame(amount2, zeroResult16.zero().getAmount());
    assertSame(amount2, zeroResult8.getAmount());
    assertSame(amount2, zeroResult17.zero().getAmount());
    assertSame(amount2, zeroResult19.getAmount());
    assertSame(amount2, zeroResult18.zero().getAmount());
    assertSame(amount2, zeroResult12.getAmount());
    assertSame(amount2, zeroResult19.zero().getAmount());
    assertSame(amount2, zeroResult20.getAmount());
    assertSame(amount2, zeroResult20.zero().getAmount());
    assertSame(amount2, amount2);
    assertSame(zeroResult5.getAmount(), zeroResult5.getAmount());
    BigDecimal amount3 = zeroResult4.getAmount();
    assertSame(amount3, zeroResult5.abs().getAmount());
    assertSame(amount3, amount3);
    BigDecimal amount4 = zeroResult3.getAmount();
    Money absResult17 = zeroResult4.abs();
    Money absResult18 = absResult17.abs();
    assertSame(amount4, absResult18.abs().getAmount());
    assertSame(amount4, absResult18.getAmount());
    assertSame(amount4, absResult17.getAmount());
    assertSame(amount4, absResult18.zero().getAmount());
    assertSame(amount4, absResult17.zero().getAmount());
    assertSame(amount4, amount4);
    BigDecimal amount5 = zeroResult2.getAmount();
    Money absResult19 = zeroResult3.abs();
    Money absResult20 = absResult19.abs();
    Money absResult21 = absResult20.abs();
    assertSame(amount5, absResult21.abs().getAmount());
    assertSame(amount5, absResult21.getAmount());
    Money zeroResult21 = absResult19.zero();
    Money absResult22 = zeroResult21.abs();
    assertSame(amount5, absResult22.abs().getAmount());
    assertSame(amount5, absResult20.getAmount());
    Money zeroResult22 = absResult20.zero();
    assertSame(amount5, zeroResult22.abs().getAmount());
    assertSame(amount5, absResult22.getAmount());
    Money zeroResult23 = zeroResult21.zero();
    assertSame(amount5, zeroResult23.abs().getAmount());
    assertSame(amount5, absResult19.getAmount());
    assertSame(amount5, absResult21.zero().getAmount());
    assertSame(amount5, zeroResult22.getAmount());
    assertSame(amount5, absResult22.zero().getAmount());
    assertSame(amount5, zeroResult21.getAmount());
    assertSame(amount5, zeroResult22.zero().getAmount());
    assertSame(amount5, zeroResult23.getAmount());
    assertSame(amount5, zeroResult23.zero().getAmount());
    assertSame(amount5, amount5);
    Money absResult23 = zeroResult2.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertSame(amount, absResult26.abs().getAmount());
    assertSame(amount, absResult26.getAmount());
    Money zeroResult24 = absResult23.zero();
    Money absResult27 = zeroResult24.abs();
    Money absResult28 = absResult27.abs();
    assertSame(amount, absResult28.abs().getAmount());
    assertSame(amount, absResult25.getAmount());
    Money zeroResult25 = absResult24.zero();
    Money absResult29 = zeroResult25.abs();
    assertSame(amount, absResult29.abs().getAmount());
    assertSame(amount, absResult28.getAmount());
    Money zeroResult26 = zeroResult24.zero();
    Money absResult30 = zeroResult26.abs();
    assertSame(amount, absResult30.abs().getAmount());
    assertSame(amount, absResult24.getAmount());
    Money zeroResult27 = absResult25.zero();
    assertSame(amount, zeroResult27.abs().getAmount());
    assertSame(amount, absResult29.getAmount());
    Money zeroResult28 = absResult27.zero();
    assertSame(amount, zeroResult28.abs().getAmount());
    assertSame(amount, absResult27.getAmount());
    Money zeroResult29 = zeroResult25.zero();
    assertSame(amount, zeroResult29.abs().getAmount());
    assertSame(amount, absResult30.getAmount());
    Money zeroResult30 = zeroResult26.zero();
    assertSame(amount, zeroResult30.abs().getAmount());
    assertSame(amount, absResult23.getAmount());
    assertSame(amount, absResult26.zero().getAmount());
    assertSame(amount, zeroResult27.getAmount());
    assertSame(amount, absResult28.zero().getAmount());
    assertSame(amount, zeroResult25.getAmount());
    assertSame(amount, absResult29.zero().getAmount());
    assertSame(amount, zeroResult28.getAmount());
    assertSame(amount, absResult30.zero().getAmount());
    assertSame(amount, zeroResult24.getAmount());
    assertSame(amount, zeroResult27.zero().getAmount());
    assertSame(amount, zeroResult29.getAmount());
    assertSame(amount, zeroResult28.zero().getAmount());
    assertSame(amount, zeroResult26.getAmount());
    assertSame(amount, zeroResult29.zero().getAmount());
    assertSame(amount, zeroResult30.getAmount());
    assertSame(amount, zeroResult30.zero().getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertNull(bundleOrderItemImpl.getSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    Money money = new Money();
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(money);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    // Act
    Money actualSalePrice = bundleOrderItemImpl.getSalePrice();

    // Assert
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl, atLeast(1)).getSalePrice();
    assertEquals(money, actualSalePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenBundleOrderItemImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link OrderItemImpl#getSalePrice()}
   * return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenDiscreteOrderItemImplGetSalePriceReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(null);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(mock(Order.class));
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    // Act
    Money actualSalePrice = bundleOrderItemImpl.getSalePrice();

    // Assert
    verify(discreteOrderItemImpl).getSalePrice();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 2.30}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_thenReturnAmountIsBigDecimalWith230() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(money);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(order);
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    // Act
    Money actualSalePrice = bundleOrderItemImpl.getSalePrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl, atLeast(1)).getSalePrice();
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualSalePrice.getAmount());
    assertEquals(actualSalePrice, actualSalePrice.abs());
    Money expectedZeroResult = actualSalePrice.ZERO;
    assertEquals(expectedZeroResult, actualSalePrice.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    Money money = new Money();
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(money);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(order);
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    // Act
    Money actualSalePrice = bundleOrderItemImpl.getSalePrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl, atLeast(1)).getSalePrice();
    assertEquals(money, actualSalePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_givenBundleOrderItemImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getBaseRetailPrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
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
    order.setCurrency(null);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    Money baseSalePrice = new Money();
    bundleOrderItemImpl.setBaseSalePrice(baseSalePrice);
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setOrder(order);

    // Act and Assert
    assertEquals(baseSalePrice, bundleOrderItemImpl.getBaseRetailPrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 2.30}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_thenReturnAmountIsBigDecimalWith230() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money baseRetailPrice = mock(Money.class);
    when(baseRetailPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setBaseRetailPrice(baseRetailPrice);

    // Act
    Money actualBaseRetailPrice = bundleOrderItemImpl.getBaseRetailPrice();

    // Assert
    verify(baseRetailPrice).getAmount();
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualBaseRetailPrice.getAmount());
    assertEquals(actualBaseRetailPrice, actualBaseRetailPrice.abs());
    Money expectedZeroResult = actualBaseRetailPrice.ZERO;
    assertEquals(expectedZeroResult, actualBaseRetailPrice.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor)
   * {@link BundleOrderItemImpl#baseRetailPrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  public void testSetBaseRetailPrice_thenBundleOrderItemImplBaseRetailPriceIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    Money baseRetailPrice = new Money();

    // Act
    bundleOrderItemImpl.setBaseRetailPrice(baseRetailPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl.baseRetailPrice);
    BigDecimal bigDecimal = bundleOrderItemImpl.baseRetailPrice;
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
   * Test {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor)
   * {@link BundleOrderItemImpl#baseRetailPrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  public void testSetBaseRetailPrice_thenBundleOrderItemImplBaseRetailPriceIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    Money baseRetailPrice = mock(Money.class);
    when(baseRetailPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    bundleOrderItemImpl.setBaseRetailPrice(baseRetailPrice);

    // Assert
    verify(baseRetailPrice).getAmount();
    assertEquals(new BigDecimal("2.3"), bundleOrderItemImpl.baseRetailPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor)
   * {@link BundleOrderItemImpl#baseRetailPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  public void testSetBaseRetailPrice_thenBundleOrderItemImplBaseRetailPriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    bundleOrderItemImpl.setBaseRetailPrice(baseRetailPrice);
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    // Act
    bundleOrderItemImpl.setBaseRetailPrice(null);

    // Assert
    assertNull(bundleOrderItemImpl.baseRetailPrice);
    assertNull(bundleOrderItemImpl.getBaseRetailPrice());
    Money averageAdjustmentValue = bundleOrderItemImpl.getAverageAdjustmentValue();
    Money absResult = averageAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    assertEquals(baseRetailPrice, absResult4.abs());
    Money absResult5 = averageAdjustmentValue.zero().abs().abs().abs();
    assertEquals(baseRetailPrice, absResult5.abs());
    Money zeroResult = absResult.zero();
    Money absResult6 = zeroResult.abs();
    Money absResult7 = absResult6.abs();
    assertEquals(baseRetailPrice, absResult7.abs());
    Money zeroResult2 = bundleOrderItemImpl.getAdjustmentValue().zero();
    Money zeroResult3 = zeroResult2.zero();
    Money absResult8 = zeroResult3.abs();
    Money absResult9 = absResult8.abs();
    assertEquals(baseRetailPrice, absResult9.abs());
    Money zeroResult4 = absResult2.zero();
    Money absResult10 = zeroResult4.abs();
    assertEquals(baseRetailPrice, absResult10.abs());
    Money zeroResult5 = zeroResult2.abs().zero();
    Money absResult11 = zeroResult5.abs();
    assertEquals(baseRetailPrice, absResult11.abs());
    Money zeroResult6 = zeroResult.zero();
    Money absResult12 = zeroResult6.abs();
    assertEquals(baseRetailPrice, absResult12.abs());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult13 = zeroResult7.abs();
    assertEquals(baseRetailPrice, absResult13.abs());
    Money zeroResult8 = absResult3.zero();
    assertEquals(baseRetailPrice, zeroResult8.abs());
    Money zeroResult9 = absResult6.zero();
    assertEquals(baseRetailPrice, zeroResult9.abs());
    Money zeroResult10 = absResult8.zero();
    assertEquals(baseRetailPrice, zeroResult10.abs());
    Money zeroResult11 = zeroResult4.zero();
    assertEquals(baseRetailPrice, zeroResult11.abs());
    Money zeroResult12 = zeroResult5.zero();
    assertEquals(baseRetailPrice, zeroResult12.abs());
    Money zeroResult13 = zeroResult6.zero();
    assertEquals(baseRetailPrice, zeroResult13.abs());
    Money zeroResult14 = zeroResult7.zero();
    assertEquals(baseRetailPrice, zeroResult14.abs());
    assertEquals(baseRetailPrice, absResult4.zero());
    assertEquals(baseRetailPrice, absResult5.zero());
    assertEquals(baseRetailPrice, absResult7.zero());
    assertEquals(baseRetailPrice, absResult9.zero());
    assertEquals(baseRetailPrice, absResult10.zero());
    assertEquals(baseRetailPrice, absResult11.zero());
    assertEquals(baseRetailPrice, absResult12.zero());
    assertEquals(baseRetailPrice, absResult13.zero());
    assertEquals(baseRetailPrice, zeroResult8.zero());
    assertEquals(baseRetailPrice, zeroResult9.zero());
    assertEquals(baseRetailPrice, zeroResult10.zero());
    assertEquals(baseRetailPrice, zeroResult11.zero());
    assertEquals(baseRetailPrice, zeroResult12.zero());
    assertEquals(baseRetailPrice, zeroResult13.zero());
    assertEquals(baseRetailPrice, zeroResult14.zero());
    BigDecimal bigDecimal = bundleOrderItemImpl.salePrice;
    assertSame(bigDecimal, absResult4.getAmount());
    assertSame(bigDecimal, absResult5.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_givenBundleOrderItemImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getBaseSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
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
    order.setCurrency(null);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    bundleOrderItemImpl.setBaseRetailPrice(baseRetailPrice);
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setOrder(order);

    // Act and Assert
    assertEquals(baseRetailPrice, bundleOrderItemImpl.getBaseSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 2.30}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_thenReturnAmountIsBigDecimalWith230() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money baseSalePrice = mock(Money.class);
    when(baseSalePrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setBaseSalePrice(baseSalePrice);

    // Act
    Money actualBaseSalePrice = bundleOrderItemImpl.getBaseSalePrice();

    // Assert
    verify(baseSalePrice).getAmount();
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualBaseSalePrice.getAmount());
    assertEquals(actualBaseSalePrice, actualBaseSalePrice.abs());
    Money expectedZeroResult = actualBaseSalePrice.ZERO;
    assertEquals(expectedZeroResult, actualBaseSalePrice.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor)
   * {@link BundleOrderItemImpl#baseSalePrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  public void testSetBaseSalePrice_thenBundleOrderItemImplBaseSalePriceIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    Money baseSalePrice = new Money();

    // Act
    bundleOrderItemImpl.setBaseSalePrice(baseSalePrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl.baseSalePrice);
    BigDecimal bigDecimal = bundleOrderItemImpl.baseSalePrice;
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
   * Test {@link BundleOrderItemImpl#setBaseSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor)
   * {@link BundleOrderItemImpl#baseSalePrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  public void testSetBaseSalePrice_thenBundleOrderItemImplBaseSalePriceIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    Money baseSalePrice = mock(Money.class);
    when(baseSalePrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    bundleOrderItemImpl.setBaseSalePrice(baseSalePrice);

    // Assert
    verify(baseSalePrice).getAmount();
    assertEquals(new BigDecimal("2.3"), bundleOrderItemImpl.baseSalePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor)
   * {@link BundleOrderItemImpl#baseSalePrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  public void testSetBaseSalePrice_thenBundleOrderItemImplBaseSalePriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    bundleOrderItemImpl.setBaseRetailPrice(baseRetailPrice);
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    // Act
    bundleOrderItemImpl.setBaseSalePrice(null);

    // Assert
    assertNull(bundleOrderItemImpl.baseSalePrice);
    assertNull(bundleOrderItemImpl.getBaseSalePrice());
    Money averageAdjustmentValue = bundleOrderItemImpl.getAverageAdjustmentValue();
    Money absResult = averageAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    assertEquals(baseRetailPrice, absResult4.abs());
    Money absResult5 = averageAdjustmentValue.zero().abs().abs().abs();
    assertEquals(baseRetailPrice, absResult5.abs());
    Money zeroResult = absResult.zero();
    Money absResult6 = zeroResult.abs();
    Money absResult7 = absResult6.abs();
    assertEquals(baseRetailPrice, absResult7.abs());
    Money zeroResult2 = bundleOrderItemImpl.getAdjustmentValue().zero();
    Money zeroResult3 = zeroResult2.zero();
    Money absResult8 = zeroResult3.abs();
    Money absResult9 = absResult8.abs();
    assertEquals(baseRetailPrice, absResult9.abs());
    Money zeroResult4 = absResult2.zero();
    Money absResult10 = zeroResult4.abs();
    assertEquals(baseRetailPrice, absResult10.abs());
    Money zeroResult5 = zeroResult2.abs().zero();
    Money absResult11 = zeroResult5.abs();
    assertEquals(baseRetailPrice, absResult11.abs());
    Money zeroResult6 = zeroResult.zero();
    Money absResult12 = zeroResult6.abs();
    assertEquals(baseRetailPrice, absResult12.abs());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult13 = zeroResult7.abs();
    assertEquals(baseRetailPrice, absResult13.abs());
    Money zeroResult8 = absResult3.zero();
    assertEquals(baseRetailPrice, zeroResult8.abs());
    Money zeroResult9 = absResult6.zero();
    assertEquals(baseRetailPrice, zeroResult9.abs());
    Money zeroResult10 = absResult8.zero();
    assertEquals(baseRetailPrice, zeroResult10.abs());
    Money zeroResult11 = zeroResult4.zero();
    assertEquals(baseRetailPrice, zeroResult11.abs());
    Money zeroResult12 = zeroResult5.zero();
    assertEquals(baseRetailPrice, zeroResult12.abs());
    Money zeroResult13 = zeroResult6.zero();
    assertEquals(baseRetailPrice, zeroResult13.abs());
    Money zeroResult14 = zeroResult7.zero();
    assertEquals(baseRetailPrice, zeroResult14.abs());
    assertEquals(baseRetailPrice, absResult4.zero());
    assertEquals(baseRetailPrice, absResult5.zero());
    assertEquals(baseRetailPrice, absResult7.zero());
    assertEquals(baseRetailPrice, absResult9.zero());
    assertEquals(baseRetailPrice, absResult10.zero());
    assertEquals(baseRetailPrice, absResult11.zero());
    assertEquals(baseRetailPrice, absResult12.zero());
    assertEquals(baseRetailPrice, absResult13.zero());
    assertEquals(baseRetailPrice, zeroResult8.zero());
    assertEquals(baseRetailPrice, zeroResult9.zero());
    assertEquals(baseRetailPrice, zeroResult10.zero());
    assertEquals(baseRetailPrice, zeroResult11.zero());
    assertEquals(baseRetailPrice, zeroResult12.zero());
    assertEquals(baseRetailPrice, zeroResult13.zero());
    assertEquals(baseRetailPrice, zeroResult14.zero());
    BigDecimal bigDecimal = bundleOrderItemImpl.salePrice;
    assertSame(bigDecimal, absResult4.getAmount());
    assertSame(bigDecimal, absResult5.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices_givenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BundleOrderItemImpl()).updateSaleAndRetailPrices());
  }

  /**
   * Test {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Price is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices_givenBundleOrderItemImplPriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setPrice(new Money());

    // Act and Assert
    assertFalse(bundleOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Price is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices_givenBundleOrderItemImplPriceIsMoney2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setPrice(mock(Money.class));

    // Act and Assert
    assertFalse(bundleOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}, and
   * {@link BundleOrderItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemImpl#equals(Object)}
   *   <li>{@link BundleOrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable2);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(bundleOrderItemImpl, bundleOrderItemImpl2);
    int expectedHashCodeResult = bundleOrderItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}, and
   * {@link BundleOrderItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemImpl#equals(Object)}
   *   <li>{@link BundleOrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable2);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(bundleOrderItemImpl, bundleOrderItemImpl2);
    int expectedHashCodeResult = bundleOrderItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}, and
   * {@link BundleOrderItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemImpl#equals(Object)}
   *   <li>{@link BundleOrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(null);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable2);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(bundleOrderItemImpl, bundleOrderItemImpl2);
    int expectedHashCodeResult = bundleOrderItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}, and
   * {@link BundleOrderItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemImpl#equals(Object)}
   *   <li>{@link BundleOrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable2);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(null);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(bundleOrderItemImpl, bundleOrderItemImpl2);
    int expectedHashCodeResult = bundleOrderItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}, and
   * {@link BundleOrderItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemImpl#equals(Object)}
   *   <li>{@link BundleOrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(bundleOrderItemImpl, bundleOrderItemImpl);
    int expectedHashCodeResult = bundleOrderItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemImpl.hashCode());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(2L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable2);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(bundleOrderItemImpl, bundleOrderItemImpl2);
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(bundleOrderItemImpl, null);
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(bundleOrderItemImpl, "Different type to BundleOrderItemImpl");
  }

  /**
   * Test {@link BundleOrderItemImpl#getProduct()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getProduct()}
   */
  @Test
  public void testGetProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertNull(bundleOrderItemImpl.getProduct());
  }

  /**
   * Test {@link BundleOrderItemImpl#getProduct()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getProduct()}
   */
  @Test
  public void testGetProduct_givenBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getProduct());
  }

  /**
   * Test {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_givenOrderImplCurrencyIsNull_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
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
    order.setCurrency(null);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrder(order);

    // Act and Assert
    assertNull(bundleOrderItemImpl.convertToMoney(null));
  }

  /**
   * Test {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs zero is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_thenReturnAbsAbsAbsAbsAbsAbsAbsZeroIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
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
    order.setCurrency(null);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    bundleOrderItemImpl.setBaseRetailPrice(baseRetailPrice);
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualConvertToMoneyResult = bundleOrderItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Money absResult = actualConvertToMoneyResult.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(baseRetailPrice, absResult6.abs().zero());
    assertEquals(baseRetailPrice, absResult6.zero());
    assertEquals(baseRetailPrice, absResult5.zero());
    assertEquals(baseRetailPrice, absResult4.zero());
    assertEquals(baseRetailPrice, absResult3.zero());
    assertEquals(baseRetailPrice, absResult2.zero());
    assertEquals(baseRetailPrice, absResult.zero());
    assertEquals(baseRetailPrice, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs zero is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_thenReturnAbsAbsAbsAbsAbsAbsAbsZeroIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualConvertToMoneyResult = bundleOrderItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Money money = actualConvertToMoneyResult.ZERO;
    Money absResult = actualConvertToMoneyResult.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(money, absResult6.abs().zero());
    assertEquals(money, absResult6.zero());
    assertEquals(money, absResult5.zero());
    assertEquals(money, absResult4.zero());
    assertEquals(money, absResult3.zero());
    assertEquals(money, absResult2.zero());
    assertEquals(money, absResult.zero());
    assertEquals(money, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  public void testGetTotalPrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl.getTotalPrice();

    // Assert
    assertEquals(actualTotalPrice.ZERO, actualTotalPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  public void testGetTotalPrice_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    Money money = new Money();
    when(discreteOrderItemImpl.getTotalPrice()).thenReturn(money);
    doNothing().when(discreteOrderItemImpl).setOrder(Mockito.<Order>any());
    discreteOrderItemImpl.setOrder(new NullOrderImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(discreteOrderItemImpl).setOrder(isA(Order.class));
    verify(order).getCurrency();
    verify(discreteOrderItemImpl).getTotalPrice();
    assertEquals(money, actualTotalPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  public void testGetTotalPrice_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualTotalPrice.ZERO, actualTotalPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#isSkuActive()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isSkuActive()}
   */
  @Test
  public void testIsSkuActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertTrue(bundleOrderItemImpl.isSkuActive());
  }

  /**
   * Test {@link BundleOrderItemImpl#isSkuActive()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isSkuActive()}
   */
  @Test
  public void testIsSkuActive_givenBundleOrderItemImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BundleOrderItemImpl()).isSkuActive());
  }

  /**
   * Test {@link BundleOrderItemImpl#isSkuActive()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl}
   * {@link DiscreteOrderItemImpl#isSkuActive()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isSkuActive()}
   */
  @Test
  public void testIsSkuActive_givenDiscreteOrderItemImplIsSkuActiveReturnFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.isSkuActive()).thenReturn(false);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    // Act
    boolean actualIsSkuActiveResult = bundleOrderItemImpl.isSkuActive();

    // Assert
    verify(discreteOrderItemImpl).isSkuActive();
    assertFalse(actualIsSkuActiveResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#isSkuActive()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl}
   * {@link DiscreteOrderItemImpl#isSkuActive()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isSkuActive()}
   */
  @Test
  public void testIsSkuActive_givenDiscreteOrderItemImplIsSkuActiveReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.isSkuActive()).thenReturn(true);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    // Act
    boolean actualIsSkuActiveResult = bundleOrderItemImpl.isSkuActive();

    // Assert
    verify(discreteOrderItemImpl).isSkuActive();
    assertTrue(actualIsSkuActiveResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#clone()}.
   * <ul>
   *   <li>Then return {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#clone()}
   */
  @Test
  public void testClone_thenReturnBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);

    // Act
    OrderItem actualCloneResult = bundleOrderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof BundleOrderItemImpl);
    assertEquals(bundleOrderItemImpl, actualCloneResult);
  }

  /**
   * Test
   * {@link BundleOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link BundleOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<BundleOrderItem> actualCreateOrRetrieveCopyInstanceResult = bundleOrderItemImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link BundleOrderItemImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BundleOrderItemImpl}
   */
  @Test
  public void testNewBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BundleOrderItemImpl actualBundleOrderItemImpl = new BundleOrderItemImpl();

    // Assert
    assertNull(actualBundleOrderItemImpl.discountsAllowed);
    assertNull(actualBundleOrderItemImpl.hasValidationError);
    assertNull(actualBundleOrderItemImpl.itemTaxable);
    assertNull(actualBundleOrderItemImpl.retailPriceOverride);
    assertNull(actualBundleOrderItemImpl.salePriceOverride);
    Auditable auditable = actualBundleOrderItemImpl.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(actualBundleOrderItemImpl.getId());
    assertNull(actualBundleOrderItemImpl.getMainEntityName());
    assertNull(actualBundleOrderItemImpl.getName());
    assertNull(actualBundleOrderItemImpl.orderItemType);
    assertNull(actualBundleOrderItemImpl.baseRetailPrice);
    assertNull(actualBundleOrderItemImpl.baseSalePrice);
    assertNull(actualBundleOrderItemImpl.price);
    assertNull(actualBundleOrderItemImpl.retailPrice);
    assertNull(actualBundleOrderItemImpl.salePrice);
    assertNull(actualBundleOrderItemImpl.totalTax);
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(actualBundleOrderItemImpl.getCartMessages());
    assertNull(actualBundleOrderItemImpl.getBaseRetailPrice());
    assertNull(actualBundleOrderItemImpl.getBaseSalePrice());
    assertNull(actualBundleOrderItemImpl.getSalePrice());
    assertNull(actualBundleOrderItemImpl.getAdjustmentValue());
    assertNull(actualBundleOrderItemImpl.getAverageAdjustmentValue());
    assertNull(actualBundleOrderItemImpl.getAveragePrice());
    assertNull(actualBundleOrderItemImpl.getPrice());
    assertNull(actualBundleOrderItemImpl.getCategory());
    assertNull(actualBundleOrderItemImpl.category);
    assertNull(actualBundleOrderItemImpl.deproxiedCategory);
    assertNull(actualBundleOrderItemImpl.getProduct());
    assertNull(actualBundleOrderItemImpl.getProductBundle());
    assertNull(actualBundleOrderItemImpl.deproxiedProductBundle);
    assertNull(actualBundleOrderItemImpl.productBundle);
    assertNull(actualBundleOrderItemImpl.getSku());
    assertNull(actualBundleOrderItemImpl.deproxiedSku);
    assertNull(actualBundleOrderItemImpl.sku);
    assertNull(actualBundleOrderItemImpl.getGiftWrapOrderItem());
    assertNull(actualBundleOrderItemImpl.giftWrapOrderItem);
    assertNull(actualBundleOrderItemImpl.getOrder());
    assertNull(actualBundleOrderItemImpl.getParentOrderItem());
    assertNull(actualBundleOrderItemImpl.getPersonalMessage());
    assertNull(actualBundleOrderItemImpl.getOrderItemType());
    assertEquals(0, actualBundleOrderItemImpl.getQuantity());
    assertFalse(actualBundleOrderItemImpl.hasAdjustedItems());
    assertFalse(actualBundleOrderItemImpl.getHasValidationError());
    assertFalse(actualBundleOrderItemImpl.getIsDiscounted());
    assertFalse(actualBundleOrderItemImpl.getIsOnSale());
    assertFalse(actualBundleOrderItemImpl.isChildOrderItem());
    assertTrue(actualBundleOrderItemImpl.getBundleOrderItemFeePrices().isEmpty());
    List<DiscreteOrderItem> discreteOrderItems = actualBundleOrderItemImpl.getDiscreteOrderItems();
    assertTrue(discreteOrderItems.isEmpty());
    assertTrue(actualBundleOrderItemImpl.getCandidateItemOffers().isEmpty());
    assertTrue(actualBundleOrderItemImpl.getChildOrderItems().isEmpty());
    assertTrue(actualBundleOrderItemImpl.getOrderItemAdjustments().isEmpty());
    assertTrue(actualBundleOrderItemImpl.getOrderItemPriceDetails().isEmpty());
    assertTrue(actualBundleOrderItemImpl.getOrderItemQualifiers().isEmpty());
    assertTrue(actualBundleOrderItemImpl.getProratedOrderItemAdjustments().isEmpty());
    assertTrue(actualBundleOrderItemImpl.getOrderItemAttributes().isEmpty());
    assertTrue(actualBundleOrderItemImpl.getAllowDiscountsOnChildItems());
    assertTrue(actualBundleOrderItemImpl.isSkuActive());
    assertSame(discreteOrderItems, actualBundleOrderItemImpl.getOrderItems());
  }
}
