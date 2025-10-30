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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BundleOrderItemImplDiffblueTest {
  @Autowired
  private BundleOrderItemImpl bundleOrderItemImpl;

  /**
   * Test {@link BundleOrderItemImpl#getSku()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSku()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku BundleOrderItemImpl.getSku()"})
  public void testGetSku() {
    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getSku());
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When {@link Sku} {@link Sku#getRetailPrice()} return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku_givenMoney_whenSkuGetRetailPriceReturnMoney() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getName()).thenReturn("Name");
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());

    // Act
    bundleOrderItemImpl2.setSku(sku);

    // Assert
    verify(sku).getName();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
    verify(sku).isTaxable();
    assertEquals("Name", bundleOrderItemImpl2.getMainEntityName());
    assertEquals("Name", bundleOrderItemImpl2.getName());
    assertFalse(bundleOrderItemImpl2.isSkuActive());
    assertTrue(bundleOrderItemImpl2.itemTaxable);
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl2.baseRetailPrice);
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl2.baseSalePrice);
    assertSame(sku, bundleOrderItemImpl2.getSku());
    assertSame(sku, bundleOrderItemImpl2.deproxiedSku);
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) {@link BundleOrderItemImpl#baseRetailPrice} is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku_thenBundleOrderItemImplBaseRetailPriceIsBigDecimalWith23() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getName()).thenReturn("Name");
    when(sku.getRetailPrice()).thenReturn(money);
    when(sku.getSalePrice()).thenReturn(new Money());

    // Act
    bundleOrderItemImpl2.setSku(sku);

    // Assert
    verify(money).getAmount();
    verify(sku).getName();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
    verify(sku).isTaxable();
    assertEquals("Name", bundleOrderItemImpl2.getMainEntityName());
    assertEquals("Name", bundleOrderItemImpl2.getName());
    assertFalse(bundleOrderItemImpl2.isSkuActive());
    assertTrue(bundleOrderItemImpl2.itemTaxable);
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl2.baseSalePrice);
    assertEquals(new BigDecimal("2.3"), bundleOrderItemImpl2.baseRetailPrice);
    assertSame(sku, bundleOrderItemImpl2.getSku());
    assertSame(sku, bundleOrderItemImpl2.deproxiedSku);
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) {@link BundleOrderItemImpl#baseSalePrice} is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku_thenBundleOrderItemImplBaseSalePriceIsBigDecimalWith23() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
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
    bundleOrderItemImpl2.setSku(sku);

    // Assert
    verify(money).getAmount();
    verify(money2).getAmount();
    verify(sku).getName();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
    verify(sku).isTaxable();
    assertEquals("Name", bundleOrderItemImpl2.getMainEntityName());
    assertEquals("Name", bundleOrderItemImpl2.getName());
    assertFalse(bundleOrderItemImpl2.isSkuActive());
    assertTrue(bundleOrderItemImpl2.itemTaxable);
    assertEquals(new BigDecimal("2.3"), bundleOrderItemImpl2.baseRetailPrice);
    assertEquals(new BigDecimal("2.3"), bundleOrderItemImpl2.baseSalePrice);
    assertSame(sku, bundleOrderItemImpl2.getSku());
    assertSame(sku, bundleOrderItemImpl2.deproxiedSku);
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) SkuActive.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku_whenNull_thenBundleOrderItemImplSkuActive() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
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

    // Act
    bundleOrderItemImpl2.setSku(null);

    // Assert that nothing has changed
    assertEquals("Name", bundleOrderItemImpl2.getMainEntityName());
    assertEquals("Name", bundleOrderItemImpl2.getName());
    assertTrue(bundleOrderItemImpl2.isSkuActive());
    assertTrue(bundleOrderItemImpl2.itemTaxable);
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl2.baseRetailPrice);
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl2.baseSalePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getProductBundle()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getProductBundle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.ProductBundle BundleOrderItemImpl.getProductBundle()"})
  public void testGetProductBundle() {
    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getProductBundle());
  }

  /**
   * Test {@link BundleOrderItemImpl#getAllowDiscountsOnChildItems()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getAllowDiscountsOnChildItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.getAllowDiscountsOnChildItems()"})
  public void testGetAllowDiscountsOnChildItems() {
    // Arrange, Act and Assert
    assertTrue((new BundleOrderItemImpl()).getAllowDiscountsOnChildItems());
  }

  /**
   * Test {@link BundleOrderItemImpl#isPricingAtContainerLevel()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isPricingAtContainerLevel()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.isPricingAtContainerLevel()"})
  public void testIsPricingAtContainerLevel() {
    // Arrange, Act and Assert
    assertFalse((new BundleOrderItemImpl()).isPricingAtContainerLevel());
  }

  /**
   * Test {@link BundleOrderItemImpl#isDiscountingAllowed()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.isDiscountingAllowed()"})
  public void testIsDiscountingAllowed() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BundleOrderItemImpl.getBundleOrderItemFeePrices()",
      "List BundleOrderItemImpl.getDiscreteOrderItems()", "List BundleOrderItemImpl.getOrderItems()",
      "boolean BundleOrderItemImpl.hasAdjustedItems()", "void BundleOrderItemImpl.setBundleOrderItemFeePrices(List)",
      "void BundleOrderItemImpl.setDiscreteOrderItems(List)"})
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

    // Assert
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
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualTaxablePrice = bundleOrderItemImpl2.getTaxablePrice();

    // Assert
    assertEquals(actualTaxablePrice.ZERO, actualTaxablePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link OrderItemImpl#getTaxablePrice()} return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_givenDiscreteOrderItemImplGetTaxablePriceReturnMoney() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getTaxablePrice()).thenReturn(new Money());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl2.setOrder(order);

    // Act
    Money actualTaxablePrice = bundleOrderItemImpl2.getTaxablePrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getTaxablePrice();
    Money absResult = actualTaxablePrice.abs();
    assertEquals(actualTaxablePrice, absResult.abs().zero());
    assertEquals(actualTaxablePrice, absResult.zero());
    assertEquals(actualTaxablePrice, actualTaxablePrice.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(order);

    // Act
    Money actualTaxablePrice = bundleOrderItemImpl2.getTaxablePrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Money absResult = actualTaxablePrice.abs();
    assertEquals(actualTaxablePrice, absResult.abs().zero());
    assertEquals(actualTaxablePrice, absResult.zero());
    assertEquals(actualTaxablePrice, actualTaxablePrice.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   * <ul>
   *   <li>Then return zero Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenReturnZeroAmountIsBigDecimalWith000() {
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

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl2.setOrder(order);

    // Act
    Money actualTaxablePrice = bundleOrderItemImpl2.getTaxablePrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getTaxablePrice();
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualTaxablePrice.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualTaxablePrice.getAmount());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = actualTaxablePrice.abs().zero();
    assertEquals(zeroResult2, zeroResult3.abs());
    assertEquals(zeroResult2, zeroResult3.zero());
    assertEquals(zeroResult2, zeroResult2);
    assertEquals(zeroResult, zeroResult.abs());
  }

  /**
   * Test {@link BundleOrderItemImpl#isTaxable()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isTaxable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean BundleOrderItemImpl.isTaxable()"})
  public void testIsTaxable() {
    // Arrange, Act and Assert
    assertTrue((new BundleOrderItemImpl()).isTaxable());
  }

  /**
   * Test {@link BundleOrderItemImpl#shouldSumItems()}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#shouldSumItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.shouldSumItems()"})
  public void testShouldSumItems() {
    // Arrange, Act and Assert
    assertTrue((new BundleOrderItemImpl()).shouldSumItems());
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualRetailPrice = bundleOrderItemImpl2.getRetailPrice();

    // Assert
    assertEquals(actualRetailPrice.ZERO, actualRetailPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link OrderItemImpl#getRetailPrice()} return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenDiscreteOrderItemImplGetRetailPriceReturnMoney() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getRetailPrice()).thenReturn(new Money());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl2.setOrder(order);

    // Act
    Money actualRetailPrice = bundleOrderItemImpl2.getRetailPrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getRetailPrice();
    Money absResult = actualRetailPrice.abs();
    assertEquals(actualRetailPrice, absResult.abs().zero());
    assertEquals(actualRetailPrice, absResult.zero());
    assertEquals(actualRetailPrice, actualRetailPrice.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(order);

    // Act
    Money actualRetailPrice = bundleOrderItemImpl2.getRetailPrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Money absResult = actualRetailPrice.abs();
    assertEquals(actualRetailPrice, absResult.abs().zero());
    assertEquals(actualRetailPrice, absResult.zero());
    assertEquals(actualRetailPrice, actualRetailPrice.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then return zero Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenReturnZeroAmountIsBigDecimalWith000() {
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

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl2.setOrder(order);

    // Act
    Money actualRetailPrice = bundleOrderItemImpl2.getRetailPrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getRetailPrice();
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualRetailPrice.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualRetailPrice.getAmount());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = actualRetailPrice.abs().zero();
    assertEquals(zeroResult2, zeroResult3.abs());
    assertEquals(zeroResult2, zeroResult3.zero());
    assertEquals(zeroResult2, zeroResult2);
    assertEquals(zeroResult, zeroResult.abs());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnMoney() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    Money money = new Money();
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(money);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);

    // Act
    Money actualSalePrice = bundleOrderItemImpl2.getSalePrice();

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenBundleOrderItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link OrderItemImpl#getSalePrice()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenDiscreteOrderItemImplGetSalePriceReturnNull_thenReturnNull() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(null);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(mock(Order.class));
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);

    // Act
    Money actualSalePrice = bundleOrderItemImpl2.getSalePrice();

    // Assert
    verify(discreteOrderItemImpl).getSalePrice();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenCallsGetCurrencyCode() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(new Money());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(order);
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);

    // Act
    Money actualSalePrice = bundleOrderItemImpl2.getSalePrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl, atLeast(1)).getSalePrice();
    Money absResult = actualSalePrice.abs();
    assertEquals(actualSalePrice, absResult.abs().zero());
    assertEquals(actualSalePrice, absResult.zero());
    assertEquals(actualSalePrice, actualSalePrice.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Then return zero Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenReturnZeroAmountIsBigDecimalWith000() {
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

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(order);
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);

    // Act
    Money actualSalePrice = bundleOrderItemImpl2.getSalePrice();

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl, atLeast(1)).getSalePrice();
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualSalePrice.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualSalePrice.getAmount());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = actualSalePrice.abs().zero();
    assertEquals(zeroResult2, zeroResult3.abs());
    assertEquals(zeroResult2, zeroResult3.zero());
    assertEquals(zeroResult2, zeroResult2);
    assertEquals(zeroResult, zeroResult.abs());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_givenBundleOrderItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getBaseRetailPrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
    Money baseSalePrice = new Money();
    bundleOrderItemImpl2.setBaseSalePrice(baseSalePrice);
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
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setOrder(order);

    // Act and Assert
    assertEquals(baseSalePrice, bundleOrderItemImpl2.getBaseRetailPrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) {@link BundleOrderItemImpl#baseRetailPrice} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseRetailPrice(Money)"})
  public void testSetBaseRetailPrice_thenBundleOrderItemImplBaseRetailPriceIsBigDecimalWith000() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    Money baseRetailPrice = new Money();

    // Act
    bundleOrderItemImpl2.setBaseRetailPrice(baseRetailPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl2.baseRetailPrice);
    BigDecimal bigDecimal = bundleOrderItemImpl2.baseRetailPrice;
    Money absResult = baseRetailPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = baseRetailPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) {@link BundleOrderItemImpl#baseRetailPrice} is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseRetailPrice(Money)"})
  public void testSetBaseRetailPrice_thenBundleOrderItemImplBaseRetailPriceIsBigDecimalWith23() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    Money baseRetailPrice = mock(Money.class);
    when(baseRetailPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    bundleOrderItemImpl2.setBaseRetailPrice(baseRetailPrice);

    // Assert
    verify(baseRetailPrice).getAmount();
    assertEquals(new BigDecimal("2.3"), bundleOrderItemImpl2.baseRetailPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) {@link BundleOrderItemImpl#baseRetailPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseRetailPrice(Money)"})
  public void testSetBaseRetailPrice_thenBundleOrderItemImplBaseRetailPriceIsNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
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

    // Act
    bundleOrderItemImpl2.setBaseRetailPrice(null);

    // Assert
    assertNull(bundleOrderItemImpl2.baseRetailPrice);
    assertNull(bundleOrderItemImpl2.getBaseRetailPrice());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_givenBundleOrderItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getBaseSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    bundleOrderItemImpl2.setBaseRetailPrice(baseRetailPrice);
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
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setOrder(order);

    // Act and Assert
    assertEquals(baseRetailPrice, bundleOrderItemImpl2.getBaseSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) {@link BundleOrderItemImpl#baseSalePrice} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseSalePrice(Money)"})
  public void testSetBaseSalePrice_thenBundleOrderItemImplBaseSalePriceIsBigDecimalWith000() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    Money baseSalePrice = new Money();

    // Act
    bundleOrderItemImpl2.setBaseSalePrice(baseSalePrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), bundleOrderItemImpl2.baseSalePrice);
    BigDecimal bigDecimal = bundleOrderItemImpl2.baseSalePrice;
    Money absResult = baseSalePrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = baseSalePrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) {@link BundleOrderItemImpl#baseSalePrice} is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseSalePrice(Money)"})
  public void testSetBaseSalePrice_thenBundleOrderItemImplBaseSalePriceIsBigDecimalWith23() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    Money baseSalePrice = mock(Money.class);
    when(baseSalePrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    bundleOrderItemImpl2.setBaseSalePrice(baseSalePrice);

    // Assert
    verify(baseSalePrice).getAmount();
    assertEquals(new BigDecimal("2.3"), bundleOrderItemImpl2.baseSalePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) {@link BundleOrderItemImpl#baseSalePrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseSalePrice(Money)"})
  public void testSetBaseSalePrice_thenBundleOrderItemImplBaseSalePriceIsNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
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

    // Act
    bundleOrderItemImpl2.setBaseSalePrice(null);

    // Assert
    assertNull(bundleOrderItemImpl2.baseSalePrice);
    assertNull(bundleOrderItemImpl2.getBaseSalePrice());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.updateSaleAndRetailPrices()"})
  public void testUpdateSaleAndRetailPrices_givenBundleOrderItemImpl() {
    // Arrange, Act and Assert
    assertFalse((new BundleOrderItemImpl()).updateSaleAndRetailPrices());
  }

  /**
   * Test {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Price is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.updateSaleAndRetailPrices()"})
  public void testUpdateSaleAndRetailPrices_givenBundleOrderItemImplPriceIsMoney() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setPrice(new Money());

    // Act and Assert
    assertFalse(bundleOrderItemImpl2.updateSaleAndRetailPrices());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}, and {@link BundleOrderItemImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.equals(Object)", "int BundleOrderItemImpl.hashCode()"})
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
   * Test {@link BundleOrderItemImpl#equals(Object)}, and {@link BundleOrderItemImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.equals(Object)", "int BundleOrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
   * Test {@link BundleOrderItemImpl#equals(Object)}, and {@link BundleOrderItemImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.equals(Object)", "int BundleOrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
   * Test {@link BundleOrderItemImpl#equals(Object)}, and {@link BundleOrderItemImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.equals(Object)", "int BundleOrderItemImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.equals(Object)", "int BundleOrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.equals(Object)", "int BundleOrderItemImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.equals(Object)", "int BundleOrderItemImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.core.catalog.domain.Product BundleOrderItemImpl.getProduct()"})
  public void testGetProduct() {
    // Arrange, Act and Assert
    assertNull((new BundleOrderItemImpl()).getProduct());
  }

  /**
   * Test {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return abs abs zero is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_givenOrderImplCurrencyIsNull_thenReturnAbsAbsZeroIsMoney() {
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

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    bundleOrderItemImpl2.setBaseRetailPrice(baseRetailPrice);
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
    bundleOrderItemImpl2.setOrder(order);

    // Act
    Money actualConvertToMoneyResult = bundleOrderItemImpl2.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Money absResult = actualConvertToMoneyResult.abs();
    assertEquals(baseRetailPrice, absResult.abs().zero());
    assertEquals(baseRetailPrice, absResult.zero());
    assertEquals(baseRetailPrice, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_givenOrderImplCurrencyIsNull_whenNull_thenReturnNull() {
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

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
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
    bundleOrderItemImpl2.setOrder(order);

    // Act and Assert
    assertNull(bundleOrderItemImpl2.convertToMoney(null));
  }

  /**
   * Test {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs zero is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnAbsAbsZeroIsZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualConvertToMoneyResult = bundleOrderItemImpl2.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Money money = actualConvertToMoneyResult.ZERO;
    Money absResult = actualConvertToMoneyResult.abs();
    assertEquals(money, absResult.abs().zero());
    assertEquals(money, absResult.zero());
    assertEquals(money, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl2.getTotalPrice();

    // Assert
    assertEquals(actualTotalPrice.ZERO, actualTotalPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrder(order);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl2.getTotalPrice();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualTotalPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    assertEquals(actualTotalPrice, actualTotalPrice.abs());
    assertEquals(actualTotalPrice, actualTotalPrice.zero());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.isSkuActive()"})
  public void testIsSkuActive_givenBundleOrderItemImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BundleOrderItemImpl()).isSkuActive());
  }

  /**
   * Test {@link BundleOrderItemImpl#isSkuActive()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#isSkuActive()} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isSkuActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.isSkuActive()"})
  public void testIsSkuActive_givenDiscreteOrderItemImplIsSkuActiveReturnFalse_thenReturnFalse() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.isSkuActive()).thenReturn(false);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);

    // Act
    boolean actualIsSkuActiveResult = bundleOrderItemImpl2.isSkuActive();

    // Assert
    verify(discreteOrderItemImpl).isSkuActive();
    assertFalse(actualIsSkuActiveResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#isSkuActive()}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#isSkuActive()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemImpl#isSkuActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BundleOrderItemImpl.isSkuActive()"})
  public void testIsSkuActive_givenDiscreteOrderItemImplIsSkuActiveReturnTrue_thenReturnTrue() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.isSkuActive()).thenReturn(true);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);

    // Act
    boolean actualIsSkuActiveResult = bundleOrderItemImpl2.isSkuActive();

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItem BundleOrderItemImpl.clone()"})
  public void testClone_thenReturnBundleOrderItemImpl() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);

    // Act
    OrderItem actualCloneResult = bundleOrderItemImpl2.clone();

    // Assert
    assertTrue(actualCloneResult instanceof BundleOrderItemImpl);
    assertEquals(bundleOrderItemImpl2, actualCloneResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link BundleOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse BundleOrderItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<BundleOrderItem> actualCreateOrRetrieveCopyInstanceResult = bundleOrderItemImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link BundleOrderItemImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BundleOrderItemImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemImpl.<init>()"})
  public void testNewBundleOrderItemImpl() {
    // Arrange and Act
    BundleOrderItemImpl actualBundleOrderItemImpl = new BundleOrderItemImpl();

    // Assert
    assertNull(actualBundleOrderItemImpl.discountsAllowed);
    assertNull(actualBundleOrderItemImpl.hasValidationError);
    assertNull(actualBundleOrderItemImpl.itemTaxable);
    assertNull(actualBundleOrderItemImpl.retailPriceOverride);
    assertNull(actualBundleOrderItemImpl.salePriceOverride);
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
