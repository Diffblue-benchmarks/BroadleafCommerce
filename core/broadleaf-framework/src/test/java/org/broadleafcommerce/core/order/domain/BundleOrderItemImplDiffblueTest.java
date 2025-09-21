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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.offer.domain.CandidateItemOffer;
import org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class BundleOrderItemImplDiffblueTest {
  @Autowired private BundleOrderItemImpl bundleOrderItemImpl;

  /**
   * Test {@link BundleOrderItemImpl#getSku()}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getSku()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku BundleOrderItemImpl.getSku()"})
  public void testGetSku() {
    // Arrange, Act and Assert
    assertNull(bundleOrderItemImpl.getSku());
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setRetailPrice(new Money());

    // Act
    bundleOrderItemImpl.setSku(sku);

    // Assert
    BigDecimal bigDecimal = bundleOrderItemImpl.baseRetailPrice;
    Money baseRetailPrice = sku.getBaseRetailPrice();
    assertSame(bigDecimal, baseRetailPrice.abs().getAmount());
    Money listPrice = sku.getListPrice();
    assertSame(bigDecimal, listPrice.abs().getAmount());
    Money margin = sku.getMargin();
    assertSame(bigDecimal, margin.abs().getAmount());
    Money price = sku.getPrice();
    assertSame(bigDecimal, price.abs().getAmount());
    Money retailPrice = sku.getRetailPrice();
    assertSame(bigDecimal, retailPrice.abs().getAmount());
    assertSame(bigDecimal, baseRetailPrice.zero().getAmount());
    assertSame(bigDecimal, listPrice.zero().getAmount());
    assertSame(bigDecimal, margin.zero().getAmount());
    assertSame(bigDecimal, price.zero().getAmount());
    assertSame(bigDecimal, retailPrice.zero().getAmount());
    assertSame(bigDecimal, listPrice.getAmount());
    assertSame(bigDecimal, margin.getAmount());
    assertSame(bigDecimal, price.getAmount());
    assertSame(bigDecimal, retailPrice.getAmount());
    assertSame(bigDecimal, sku.getPriceData().getPrice().getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Sku} {@link Sku#getRetailPrice()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku_givenNull_whenSkuGetRetailPriceReturnNull() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getRetailPrice()).thenReturn(null);
    when(sku.getSalePrice()).thenReturn(null);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getName()).thenReturn("Name");

    // Act
    bundleOrderItemImpl.setSku(sku);

    // Assert
    verify(sku).getName();
    verify(sku).getRetailPrice();
    verify(sku).getSalePrice();
    verify(sku).isTaxable();
    assertEquals("Name", bundleOrderItemImpl.getMainEntityName());
    assertEquals("Name", bundleOrderItemImpl.getName());
    assertFalse(bundleOrderItemImpl.isSkuActive());
    assertTrue(bundleOrderItemImpl.itemTaxable);
    assertSame(sku, bundleOrderItemImpl.getSku());
    assertSame(sku, bundleOrderItemImpl.deproxiedSku);
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   *
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#baseRetailPrice} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku_thenBundleOrderItemImplBaseRetailPriceIsBigDecimalWith000() {
    // Arrange
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
   *
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#baseSalePrice} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku_thenBundleOrderItemImplBaseSalePriceIsBigDecimalWith000() {
    // Arrange
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
   *
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#baseSalePrice} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku_thenBundleOrderItemImplBaseSalePriceIsBigDecimalWith23() {
    // Arrange
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
   *
   * <ul>
   *   <li>Then {@link SkuImpl} (default constructor) BaseSalePrice abs Amount is {@link
   *       BundleOrderItemImpl} {@link BundleOrderItemImpl#baseSalePrice}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku_thenSkuImplBaseSalePriceAbsAmountIsBundleOrderItemImplBaseSalePrice() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setSalePrice(new Money());

    // Act
    bundleOrderItemImpl.setSku(sku);

    // Assert
    BigDecimal bigDecimal = bundleOrderItemImpl.baseSalePrice;
    Money baseSalePrice = sku.getBaseSalePrice();
    assertSame(bigDecimal, baseSalePrice.abs().getAmount());
    Money margin = sku.getMargin();
    assertSame(bigDecimal, margin.abs().getAmount());
    Money salePrice = sku.getSalePrice();
    assertSame(bigDecimal, salePrice.abs().getAmount());
    assertSame(bigDecimal, baseSalePrice.zero().getAmount());
    assertSame(bigDecimal, margin.zero().getAmount());
    assertSame(bigDecimal, salePrice.zero().getAmount());
    assertSame(bigDecimal, margin.getAmount());
    assertSame(bigDecimal, salePrice.getAmount());
    assertSame(bigDecimal, sku.getPriceData().getPrice().getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#setSku(Sku)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#deproxiedSku} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setSku(Sku)"})
  public void testSetSku_whenNull_thenBundleOrderItemImplDeproxiedSkuIsNull() {
    // Arrange and Act
    bundleOrderItemImpl.setSku(null);

    // Assert that nothing has changed
    assertNull(bundleOrderItemImpl.itemTaxable);
    assertNull(bundleOrderItemImpl.baseRetailPrice);
    assertNull(bundleOrderItemImpl.baseSalePrice);
    assertNull(bundleOrderItemImpl.deproxiedSku);
    assertNull(bundleOrderItemImpl.sku);
  }

  /**
   * Test {@link BundleOrderItemImpl#getProductBundle()}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getProductBundle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.ProductBundle BundleOrderItemImpl.getProductBundle()"
  })
  public void testGetProductBundle() {
    // Arrange, Act and Assert
    assertNull(bundleOrderItemImpl.getProductBundle());
  }

  /**
   * Test {@link BundleOrderItemImpl#getAllowDiscountsOnChildItems()}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getAllowDiscountsOnChildItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleOrderItemImpl.getAllowDiscountsOnChildItems()"})
  public void testGetAllowDiscountsOnChildItems() {
    // Arrange, Act and Assert
    assertTrue(bundleOrderItemImpl.getAllowDiscountsOnChildItems());
  }

  /**
   * Test {@link BundleOrderItemImpl#isPricingAtContainerLevel()}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#isPricingAtContainerLevel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleOrderItemImpl.isPricingAtContainerLevel()"})
  public void testIsPricingAtContainerLevel() {
    // Arrange, Act and Assert
    assertFalse(bundleOrderItemImpl.isPricingAtContainerLevel());
  }

  /**
   * Test {@link BundleOrderItemImpl#isDiscountingAllowed()}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#isDiscountingAllowed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleOrderItemImpl.isDiscountingAllowed()"})
  public void testIsDiscountingAllowed() {
    // Arrange, Act and Assert
    assertFalse(bundleOrderItemImpl.isDiscountingAllowed());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BundleOrderItemImpl.getBundleOrderItemFeePrices()",
    "List BundleOrderItemImpl.getDiscreteOrderItems()",
    "List BundleOrderItemImpl.getOrderItems()",
    "boolean BundleOrderItemImpl.hasAdjustedItems()",
    "void BundleOrderItemImpl.setBundleOrderItemFeePrices(List)",
    "void BundleOrderItemImpl.setDiscreteOrderItems(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    ArrayList<BundleOrderItemFeePrice> bundleOrderItemFeePrices = new ArrayList<>();

    // Act
    bundleOrderItemImpl.setBundleOrderItemFeePrices(bundleOrderItemFeePrices);
    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    List<BundleOrderItemFeePrice> actualBundleOrderItemFeePrices =
        bundleOrderItemImpl.getBundleOrderItemFeePrices();
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
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link NullOrderImpl}
   *       (default constructor).
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_givenBundleOrderItemImplOrderIsNullOrderImpl_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertEquals(Money.ZERO, bundleOrderItemImpl.getTaxablePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertEquals(Money.ZERO, bundleOrderItemImpl.getTaxablePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getTaxablePrice()}
   *       return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_givenDiscreteOrderItemImplGetTaxablePriceReturnMoney() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getTaxablePrice()).thenReturn(new Money());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = bundleOrderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getTaxablePrice();
    Money absResult = actualTaxablePrice.abs();
    assertEquals(actualTaxablePrice, absResult.abs().zero());
    assertEquals(actualTaxablePrice, absResult.zero());
    Money actualZeroResult = actualTaxablePrice.zero();
    assertEquals(actualTaxablePrice, actualZeroResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTaxablePrice = bundleOrderItemImpl.getTaxablePrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money absResult = actualTaxablePrice.abs();
    assertEquals(actualTaxablePrice, absResult.abs().zero());
    assertEquals(actualTaxablePrice, absResult.zero());
    Money actualZeroResult = actualTaxablePrice.zero();
    assertEquals(actualTaxablePrice, actualZeroResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTaxablePrice()}.
   *
   * <ul>
   *   <li>Then return zero Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTaxablePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTaxablePrice()"})
  public void testGetTaxablePrice_thenReturnZeroAmountIsBigDecimalWith000() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

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
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getTaxablePrice();
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualTaxablePrice.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    assertEquals(new BigDecimal("2.30"), actualTaxablePrice.getAmount());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = actualTaxablePrice.abs().zero();
    assertEquals(zeroResult2, zeroResult3.abs());
    assertEquals(zeroResult2, zeroResult3.zero());
    assertEquals(zeroResult2, zeroResult2);
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#isTaxable()}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#isTaxable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean BundleOrderItemImpl.isTaxable()"})
  public void testIsTaxable() {
    // Arrange, Act and Assert
    assertTrue(bundleOrderItemImpl.isTaxable());
  }

  /**
   * Test {@link BundleOrderItemImpl#shouldSumItems()}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#shouldSumItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleOrderItemImpl.shouldSumItems()"})
  public void testShouldSumItems() {
    // Arrange, Act and Assert
    assertTrue(bundleOrderItemImpl.shouldSumItems());
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link NullOrderImpl}
   *       (default constructor).
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenBundleOrderItemImplOrderIsNullOrderImpl_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertEquals(Money.ZERO, bundleOrderItemImpl.getRetailPrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertEquals(Money.ZERO, bundleOrderItemImpl.getRetailPrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getRetailPrice()} return
   *       {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenDiscreteOrderItemImplGetRetailPriceReturnMoney() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getRetailPrice()).thenReturn(new Money());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualRetailPrice = bundleOrderItemImpl.getRetailPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getRetailPrice();
    Money absResult = actualRetailPrice.abs();
    assertEquals(actualRetailPrice, absResult.abs().zero());
    assertEquals(actualRetailPrice, absResult.zero());
    Money actualZeroResult = actualRetailPrice.zero();
    assertEquals(actualRetailPrice, actualZeroResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualRetailPrice = bundleOrderItemImpl.getRetailPrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Money absResult = actualRetailPrice.abs();
    assertEquals(actualRetailPrice, absResult.abs().zero());
    assertEquals(actualRetailPrice, absResult.zero());
    Money actualZeroResult = actualRetailPrice.zero();
    assertEquals(actualRetailPrice, actualZeroResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Then return zero Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenReturnZeroAmountIsBigDecimalWith000() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

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
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl).getRetailPrice();
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualRetailPrice.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    assertEquals(new BigDecimal("2.30"), actualRetailPrice.getAmount());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = actualRetailPrice.abs().zero();
    assertEquals(zeroResult2, zeroResult3.abs());
    assertEquals(zeroResult2, zeroResult3.zero());
    assertEquals(zeroResult2, zeroResult2);
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DynamicPriceDiscreteOrderItemImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenArrayListAddDynamicPriceDiscreteOrderItemImpl() {
    // Arrange
    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DynamicPriceDiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    // Act and Assert
    assertNull(bundleOrderItemImpl.getSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenBundleOrderItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(bundleOrderItemImpl.getSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then return abs abs zero is {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenReturnAbsAbsZeroIsZero() {
    // Arrange
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(money);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    // Act
    Money actualSalePrice = bundleOrderItemImpl.getSalePrice();

    // Assert
    verify(money).getAmount();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl, atLeast(1)).getSalePrice();
    Money money2 = Money.ZERO;
    Money absResult = actualSalePrice.abs();
    assertEquals(money2, absResult.abs().zero());
    assertEquals(money2, absResult.zero());
    assertEquals(money2, actualSalePrice.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSalePrice()).thenReturn(money);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(order);
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    // Act
    Money actualSalePrice = bundleOrderItemImpl.getSalePrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(money).getAmount();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl, atLeast(1)).getSalePrice();
    Currency currency = actualSalePrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money zeroResult = actualSalePrice.zero();
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = actualSalePrice.abs().zero();
    assertEquals(zeroResult2, zeroResult3.abs());
    assertEquals(zeroResult2, zeroResult3.zero());
    assertEquals(zeroResult2, zeroResult2);
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenReturnMoney() {
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
   * Test {@link BundleOrderItemImpl#getBaseRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_givenBundleOrderItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(bundleOrderItemImpl.getBaseRetailPrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money baseRetailPrice = new Money();
    bundleOrderItemImpl.setBaseRetailPrice(baseRetailPrice);
    bundleOrderItemImpl.setOrder(order);

    // Act and Assert
    assertEquals(baseRetailPrice, bundleOrderItemImpl.getBaseRetailPrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseRetailPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getBaseRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualBaseRetailPrice = bundleOrderItemImpl.getBaseRetailPrice();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualBaseRetailPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualBaseRetailPrice.abs();
    assertEquals(actualBaseRetailPrice, actualAbsResult);
    Money actualZeroResult = actualBaseRetailPrice.zero();
    assertEquals(actualBaseRetailPrice, actualZeroResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}.
   *
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#baseRetailPrice} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseRetailPrice(Money)"})
  public void testSetBaseRetailPrice_thenBundleOrderItemImplBaseRetailPriceIsBigDecimalWith000() {
    // Arrange
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
   *
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#baseRetailPrice} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseRetailPrice(Money)"})
  public void testSetBaseRetailPrice_thenBundleOrderItemImplBaseRetailPriceIsBigDecimalWith23() {
    // Arrange
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#baseRetailPrice} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setBaseRetailPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseRetailPrice(Money)"})
  public void testSetBaseRetailPrice_whenNull_thenBundleOrderItemImplBaseRetailPriceIsNull() {
    // Arrange and Act
    bundleOrderItemImpl.setBaseRetailPrice(null);

    // Assert that nothing has changed
    assertNull(bundleOrderItemImpl.baseRetailPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_givenBundleOrderItemImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(bundleOrderItemImpl.getBaseSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money baseSalePrice = new Money();
    bundleOrderItemImpl.setBaseSalePrice(baseSalePrice);
    bundleOrderItemImpl.setOrder(order);

    // Act and Assert
    assertEquals(baseSalePrice, bundleOrderItemImpl.getBaseSalePrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getBaseSalePrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getBaseSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualBaseSalePrice = bundleOrderItemImpl.getBaseSalePrice();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualBaseSalePrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualBaseSalePrice.abs();
    assertEquals(actualBaseSalePrice, actualAbsResult);
    Money actualZeroResult = actualBaseSalePrice.zero();
    assertEquals(actualBaseSalePrice, actualZeroResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#setBaseSalePrice(Money)}.
   *
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#baseSalePrice} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseSalePrice(Money)"})
  public void testSetBaseSalePrice_thenBundleOrderItemImplBaseSalePriceIsBigDecimalWith000() {
    // Arrange
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
   *
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#baseSalePrice} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseSalePrice(Money)"})
  public void testSetBaseSalePrice_thenBundleOrderItemImplBaseSalePriceIsBigDecimalWith23() {
    // Arrange
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#baseSalePrice} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#setBaseSalePrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemImpl.setBaseSalePrice(Money)"})
  public void testSetBaseSalePrice_whenNull_thenBundleOrderItemImplBaseSalePriceIsNull() {
    // Arrange and Act
    bundleOrderItemImpl.setBaseSalePrice(null);

    // Assert that nothing has changed
    assertNull(bundleOrderItemImpl.baseSalePrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link
   *       OrderItemQualifierImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleOrderItemImpl.updateSaleAndRetailPrices()"})
  public void testUpdateSaleAndRetailPrices_givenAuditableCreatedByIsSerialVersionUID() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    // Act and Assert
    assertFalse(bundleOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleOrderItemImpl.updateSaleAndRetailPrices()"})
  public void testUpdateSaleAndRetailPrices_givenBundleOrderItemImpl() {
    // Arrange, Act and Assert
    assertFalse(bundleOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}, and {@link BundleOrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemImpl#equals(Object)}
   *   <li>{@link BundleOrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemImpl.equals(Object)",
    "int BundleOrderItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setPrice(new Money());
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
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl2.setPrice(new Money());
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
    assertEquals(bundleOrderItemImpl.hashCode(), bundleOrderItemImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}, and {@link BundleOrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemImpl#equals(Object)}
   *   <li>{@link BundleOrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemImpl.equals(Object)",
    "int BundleOrderItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setPrice(new Money());
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
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl2.setPrice(new Money());
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
    assertEquals(bundleOrderItemImpl.hashCode(), bundleOrderItemImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}, and {@link BundleOrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemImpl#equals(Object)}
   *   <li>{@link BundleOrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemImpl.equals(Object)",
    "int BundleOrderItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setPrice(new Money());
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
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl2.setPrice(new Money());
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
    assertEquals(bundleOrderItemImpl.hashCode(), bundleOrderItemImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemImpl#equals(Object)}, and {@link BundleOrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemImpl#equals(Object)}
   *   <li>{@link BundleOrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemImpl.equals(Object)",
    "int BundleOrderItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setPrice(new Money());
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemImpl.equals(Object)",
    "int BundleOrderItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setPrice(new Money());
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
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl2.setPrice(new Money());
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemImpl.equals(Object)",
    "int BundleOrderItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setName("org.broadleafcommerce.core.order.domain.OrderItem");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
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
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl2.setPrice(new Money());
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemImpl.equals(Object)",
    "int BundleOrderItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setName(null);
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
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
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl2.setPrice(new Money());
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemImpl.equals(Object)",
    "int BundleOrderItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setPrice(new Money());
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemImpl.equals(Object)",
    "int BundleOrderItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setPrice(new Money());
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
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getProduct()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Product BundleOrderItemImpl.getProduct()"
  })
  public void testGetProduct() {
    // Arrange, Act and Assert
    assertNull(bundleOrderItemImpl.getProduct());
  }

  /**
   * Test {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_givenOrderImplCurrencyIsNull_whenNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    bundleOrderItemImpl.setOrder(order);

    // Act and Assert
    assertNull(bundleOrderItemImpl.convertToMoney(null));
  }

  /**
   * Test {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualConvertToMoneyResult = bundleOrderItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualConvertToMoneyResult.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money zeroResult = actualConvertToMoneyResult.zero();
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = actualConvertToMoneyResult.abs().zero();
    assertEquals(zeroResult2, zeroResult3.abs());
    assertEquals(zeroResult2, zeroResult3.zero());
    assertEquals(zeroResult2, zeroResult2);
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return Currency Symbol is {@code $}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnCurrencySymbolIsDollarSign() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
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
    Money subTotal = new Money();
    order.setSubTotal(subTotal);
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualConvertToMoneyResult = bundleOrderItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(840, currency.getNumericCode());
    assertEquals(subTotal, actualConvertToMoneyResult.abs().zero());
    assertEquals(subTotal, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("USD");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl =
        new DynamicPriceDiscreteOrderItemImpl();
    dynamicPriceDiscreteOrderItemImpl.setSalePrice(new Money());
    dynamicPriceDiscreteOrderItemImpl.setRetailPrice(new Money());
    dynamicPriceDiscreteOrderItemImpl.setOrder(new NullOrderImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(dynamicPriceDiscreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    BigDecimal bigDecimal = dynamicPriceDiscreteOrderItemImpl.salePrice;
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("USD");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl =
        new DynamicPriceDiscreteOrderItemImpl();
    dynamicPriceDiscreteOrderItemImpl.setPrice(new Money());
    dynamicPriceDiscreteOrderItemImpl.setRetailPrice(new Money());
    dynamicPriceDiscreteOrderItemImpl.setOrder(new NullOrderImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(dynamicPriceDiscreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    BigDecimal bigDecimal = dynamicPriceDiscreteOrderItemImpl.price;
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice3() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("USD");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl =
        new DynamicPriceDiscreteOrderItemImpl();
    dynamicPriceDiscreteOrderItemImpl.setSalePrice(new Money(10.0d));
    dynamicPriceDiscreteOrderItemImpl.setRetailPrice(new Money());
    dynamicPriceDiscreteOrderItemImpl.setOrder(new NullOrderImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(dynamicPriceDiscreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(Money.ZERO, actualTotalPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCurrency} {@link BroadleafCurrency#getCurrencyCode()} return {@code
   *       USD}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_givenBroadleafCurrencyGetCurrencyCodeReturnUsd_thenReturnMoney() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("USD");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl =
        new DynamicPriceDiscreteOrderItemImpl();
    Money retailPrice = new Money();
    dynamicPriceDiscreteOrderItemImpl.setRetailPrice(retailPrice);
    dynamicPriceDiscreteOrderItemImpl.setOrder(new NullOrderImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(dynamicPriceDiscreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(retailPrice, actualTotalPrice);
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link NullOrderImpl}
   *       (default constructor).
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_givenBundleOrderItemImplOrderIsNullOrderImpl_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertEquals(Money.ZERO, bundleOrderItemImpl.getTotalPrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertEquals(Money.ZERO, bundleOrderItemImpl.getTotalPrice());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   *
   * <ul>
   *   <li>Given {@link DynamicPriceDiscreteOrderItemImpl} (default constructor) RetailPrice is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_givenDynamicPriceDiscreteOrderItemImplRetailPriceIsNull() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("USD");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl =
        new DynamicPriceDiscreteOrderItemImpl();
    dynamicPriceDiscreteOrderItemImpl.setSalePrice(new Money());
    dynamicPriceDiscreteOrderItemImpl.setRetailPrice(null);
    dynamicPriceDiscreteOrderItemImpl.setOrder(new NullOrderImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(dynamicPriceDiscreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    BigDecimal bigDecimal = dynamicPriceDiscreteOrderItemImpl.salePrice;
    Money absResult = actualTotalPrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualTotalPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#getTotalPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#getTotalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemImpl.getTotalPrice()"})
  public void testGetTotalPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrder(order);

    // Act
    Money actualTotalPrice = bundleOrderItemImpl.getTotalPrice();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualTotalPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualTotalPrice.abs();
    assertEquals(actualTotalPrice, actualAbsResult);
    Money actualZeroResult = actualTotalPrice.zero();
    assertEquals(actualTotalPrice, actualZeroResult);
  }

  /**
   * Test {@link BundleOrderItemImpl#isSkuActive()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#isSkuActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleOrderItemImpl.isSkuActive()"})
  public void testIsSkuActive_givenBundleOrderItemImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(bundleOrderItemImpl.isSkuActive());
  }

  /**
   * Test {@link BundleOrderItemImpl#isSkuActive()}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#isSkuActive()} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#isSkuActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleOrderItemImpl.isSkuActive()"})
  public void testIsSkuActive_givenDiscreteOrderItemImplIsSkuActiveReturnFalse_thenReturnFalse() {
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
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#isSkuActive()} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#isSkuActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleOrderItemImpl.isSkuActive()"})
  public void testIsSkuActive_givenDiscreteOrderItemImplIsSkuActiveReturnTrue_thenReturnTrue() {
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
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Name is {@code Name}.
   *   <li>Then Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem BundleOrderItemImpl.clone()"})
  public void testClone_givenOrderItemImplNameIsName_thenOrderReturnNullOrderImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    CandidateItemOfferImpl candidateItemOfferImpl = mock(CandidateItemOfferImpl.class);
    when(candidateItemOfferImpl.clone()).thenReturn(new CandidateItemOfferImpl());

    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    candidateItemOffers.add(candidateItemOfferImpl);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
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
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(orderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setCandidateItemOffers(candidateItemOffers);
    bundleOrderItemImpl.setOrderItemAttributes(null);
    bundleOrderItemImpl.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = bundleOrderItemImpl.clone();

    // Assert
    verify(candidateItemOfferImpl).clone();
    assertTrue(actualCloneResult instanceof BundleOrderItemImpl);
    assertTrue(actualCloneResult.getOrder() instanceof NullOrderImpl);
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(
        bigDecimal, ((BundleOrderItemImpl) actualCloneResult).getBaseRetailPrice().getAmount());
    assertSame(
        bigDecimal, ((BundleOrderItemImpl) actualCloneResult).getBaseSalePrice().getAmount());
    assertSame(bigDecimal, actualCloneResult.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, actualCloneResult.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, actualCloneResult.getAveragePrice().getAmount());
    assertSame(bigDecimal, actualCloneResult.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, actualCloneResult.getPrice().getAmount());
    assertSame(bigDecimal, actualCloneResult.getRetailPrice().getAmount());
    assertSame(bigDecimal, actualCloneResult.getTaxablePrice().getAmount());
    assertSame(bigDecimal, actualCloneResult.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, actualCloneResult.getTotalPrice().getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then ChildOrderItems first return {@link OrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem BundleOrderItemImpl.clone()"})
  public void testClone_thenChildOrderItemsFirstReturnOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("clone");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(orderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setCandidateItemOffers(null);
    bundleOrderItemImpl.setOrderItemAttributes(null);
    bundleOrderItemImpl.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = bundleOrderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof BundleOrderItemImpl);
    List<OrderItem> childOrderItems2 = actualCloneResult.getChildOrderItems();
    assertEquals(1, childOrderItems2.size());
    OrderItem getResult = childOrderItems2.get(0);
    assertTrue(getResult instanceof OrderItemImpl);
    assertEquals("clone", getResult.getName());
    assertEquals("clone", ((OrderItemImpl) getResult).getMainEntityName());
    BigDecimal expectedAmount = orderItemImpl.salePrice;
    assertSame(
        expectedAmount, actualCloneResult.getTotalAdjustmentValue().zero().abs().abs().getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return AverageAdjustmentValue abs abs abs abs abs is AdjustmentValue.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem BundleOrderItemImpl.clone()"})
  public void testClone_thenReturnAverageAdjustmentValueAbsAbsAbsAbsAbsIsAdjustmentValue() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    doNothing().when(discreteOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());

    DiscreteOrderItemImpl discreteOrderItemImpl2 = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl2.clone()).thenReturn(discreteOrderItemImpl);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(discreteOrderItemImpl2);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(order);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setCandidateItemOffers(null);
    bundleOrderItemImpl.setOrderItemAttributes(null);
    bundleOrderItemImpl.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = bundleOrderItemImpl.clone();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(discreteOrderItemImpl2).clone();
    verify(order, atLeast(1)).getCurrency();
    verify(discreteOrderItemImpl).setParentOrderItem(isA(OrderItem.class));
    assertTrue(actualCloneResult instanceof BundleOrderItemImpl);
    Money adjustmentValue = actualCloneResult.getAdjustmentValue();
    Money averageAdjustmentValue = actualCloneResult.getAverageAdjustmentValue();
    Money absResult = averageAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    assertEquals(adjustmentValue, absResult4.abs());
    Money absResult5 = averageAdjustmentValue.zero().abs();
    Money absResult6 = absResult5.abs();
    Money absResult7 = absResult6.abs();
    assertEquals(adjustmentValue, absResult7.abs());
    Money zeroResult = absResult.zero();
    Money absResult8 = zeroResult.abs();
    Money absResult9 = absResult8.abs();
    assertEquals(adjustmentValue, absResult9.abs());
    Money zeroResult2 = absResult2.zero();
    Money absResult10 = zeroResult2.abs();
    assertEquals(adjustmentValue, absResult10.abs());
    Money absResult11 = absResult5.zero().abs();
    assertEquals(adjustmentValue, absResult11.abs());
    Money zeroResult3 = zeroResult.zero();
    Money absResult12 = zeroResult3.abs();
    assertEquals(adjustmentValue, absResult12.abs());
    Money zeroResult4 = adjustmentValue.zero().zero();
    Money zeroResult5 = zeroResult4.zero();
    Money absResult13 = zeroResult5.abs();
    assertEquals(adjustmentValue, absResult13.abs());
    Money zeroResult6 = absResult3.zero();
    assertEquals(adjustmentValue, zeroResult6.abs());
    Money zeroResult7 = absResult6.zero();
    assertEquals(adjustmentValue, zeroResult7.abs());
    Money zeroResult8 = absResult8.zero();
    assertEquals(adjustmentValue, zeroResult8.abs());
    Money absResult14 = zeroResult4.abs();
    Money zeroResult9 = absResult14.zero();
    assertEquals(adjustmentValue, zeroResult9.abs());
    Money zeroResult10 = zeroResult2.zero();
    assertEquals(adjustmentValue, zeroResult10.abs());
    Money zeroResult11 = zeroResult3.zero();
    assertEquals(adjustmentValue, zeroResult11.abs());
    Money zeroResult12 = zeroResult5.zero();
    assertEquals(adjustmentValue, zeroResult12.abs());
    assertEquals(adjustmentValue, absResult4.zero());
    assertEquals(adjustmentValue, absResult7.zero());
    assertEquals(adjustmentValue, absResult9.zero());
    Money absResult15 = absResult14.abs();
    assertEquals(adjustmentValue, absResult15.zero());
    assertEquals(adjustmentValue, absResult10.zero());
    assertEquals(adjustmentValue, absResult12.zero());
    assertEquals(adjustmentValue, absResult13.zero());
    assertEquals(adjustmentValue, zeroResult6.zero());
    assertEquals(adjustmentValue, zeroResult7.zero());
    assertEquals(adjustmentValue, zeroResult8.zero());
    assertEquals(adjustmentValue, zeroResult9.zero());
    assertEquals(adjustmentValue, zeroResult10.zero());
    assertEquals(adjustmentValue, zeroResult11.zero());
    assertEquals(adjustmentValue, zeroResult12.zero());
    BigDecimal bigDecimal = ((OrderItemImpl) actualCloneResult).salePrice;
    assertSame(bigDecimal, absResult4.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
  }

  /**
   * Test {@link BundleOrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return BundleOrderItemFeePrices size is one.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem BundleOrderItemImpl.clone()"})
  public void testClone_thenReturnBundleOrderItemFeePricesSizeIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<BundleOrderItemFeePrice> bundleOrderItemFeePrices = new ArrayList<>();
    bundleOrderItemFeePrices.add(new BundleOrderItemFeePriceImpl());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.clone()).thenReturn(new BundleOrderItemImpl());

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(bundleOrderItemFeePrices);
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setCandidateItemOffers(null);
    bundleOrderItemImpl.setOrderItemAttributes(null);
    bundleOrderItemImpl.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = bundleOrderItemImpl.clone();

    // Assert
    verify(discreteOrderItemImpl).clone();
    List<BundleOrderItemFeePrice> bundleOrderItemFeePrices2 =
        ((BundleOrderItemImpl) actualCloneResult).getBundleOrderItemFeePrices();
    assertEquals(1, bundleOrderItemFeePrices2.size());
    BundleOrderItemFeePrice getResult = bundleOrderItemFeePrices2.get(0);
    assertTrue(getResult instanceof BundleOrderItemFeePriceImpl);
    assertTrue(actualCloneResult instanceof BundleOrderItemImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getName());
    assertNull(getResult.getReportingCode());
    assertNull(((BundleOrderItemFeePriceImpl) getResult).amount);
    assertNull(getResult.getAmount());
    assertFalse(getResult.isTaxable());
    assertSame(actualCloneResult, getResult.getBundleOrderItem());
  }

  /**
   * Test {@link BundleOrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return {@link BundleOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem BundleOrderItemImpl.clone()"})
  public void testClone_thenReturnBundleOrderItemImpl() {
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
   * Test {@link BundleOrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return CandidateItemOffers size is one.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem BundleOrderItemImpl.clone()"})
  public void testClone_thenReturnCandidateItemOffersSizeIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    CandidateItemOfferImpl candidateItemOfferImpl = mock(CandidateItemOfferImpl.class);
    when(candidateItemOfferImpl.clone()).thenReturn(new CandidateItemOfferImpl());

    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    candidateItemOffers.add(candidateItemOfferImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setPrice(new Money());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setCandidateItemOffers(candidateItemOffers);
    bundleOrderItemImpl2.setOrderItemAttributes(null);
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = bundleOrderItemImpl2.clone();

    // Assert
    verify(candidateItemOfferImpl).clone();
    List<CandidateItemOffer> candidateItemOffers2 = actualCloneResult.getCandidateItemOffers();
    assertEquals(1, candidateItemOffers2.size());
    CandidateItemOffer getResult = candidateItemOffers2.get(0);
    assertTrue(getResult instanceof CandidateItemOfferImpl);
    assertTrue(actualCloneResult instanceof BundleOrderItemImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getDiscountedPrice());
    assertNull(getResult.getOffer());
    assertSame(actualCloneResult, getResult.getOrderItem());
  }

  /**
   * Test {@link BundleOrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return ChildOrderItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem BundleOrderItemImpl.clone()"})
  public void testClone_thenReturnChildOrderItemsEmpty() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();

    // Act
    OrderItem actualCloneResult = bundleOrderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof BundleOrderItemImpl);
    assertTrue(actualCloneResult.getChildOrderItems().isEmpty());
    Money totalPrice = actualCloneResult.getTotalPrice();
    Money zeroResult = totalPrice.zero();
    Money absResult = zeroResult.abs();
    Money absResult2 = absResult.abs();
    assertEquals(baseRetailPrice, absResult2.abs());
    Money zeroResult2 = zeroResult.zero();
    Money absResult3 = zeroResult2.abs();
    assertEquals(baseRetailPrice, absResult3.abs());
    Money zeroResult3 = absResult.zero();
    assertEquals(baseRetailPrice, zeroResult3.abs());
    Money zeroResult4 = zeroResult2.zero();
    assertEquals(baseRetailPrice, zeroResult4.abs());
    assertEquals(baseRetailPrice, absResult2.zero());
    assertEquals(baseRetailPrice, absResult3.zero());
    assertEquals(baseRetailPrice, zeroResult3.zero());
    assertEquals(baseRetailPrice, totalPrice.abs().zero().zero().zero());
    assertEquals(baseRetailPrice, zeroResult4.zero());
  }

  /**
   * Test {@link BundleOrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return CurrencyCode is {@code GBP}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem BundleOrderItemImpl.clone()"})
  public void testClone_thenReturnCurrencyCodeIsGbp() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.clone()).thenReturn(new BundleOrderItemImpl());

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(order);
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setCandidateItemOffers(null);
    bundleOrderItemImpl.setOrderItemAttributes(null);
    bundleOrderItemImpl.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = bundleOrderItemImpl.clone();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(discreteOrderItemImpl).clone();
    verify(order, atLeast(1)).getCurrency();
    assertTrue(actualCloneResult instanceof BundleOrderItemImpl);
    assertEquals("GBP", ((BundleOrderItemImpl) actualCloneResult).getCurrencyCode());
  }

  /**
   * Test {@link BundleOrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return TotalPrice abs zero zero abs is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem BundleOrderItemImpl.clone()"})
  public void testClone_thenReturnTotalPriceAbsZeroZeroAbsIsMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(discreteOrderItemImpl.clone()).thenReturn(bundleOrderItemImpl);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    bundleOrderItemImpl2.setBaseRetailPrice(baseRetailPrice);
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setPrice(new Money());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setCandidateItemOffers(null);
    bundleOrderItemImpl2.setOrderItemAttributes(null);
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = bundleOrderItemImpl2.clone();

    // Assert
    verify(discreteOrderItemImpl).clone();
    assertTrue(actualCloneResult instanceof BundleOrderItemImpl);
    List<OrderItem> childOrderItems2 = actualCloneResult.getChildOrderItems();
    assertEquals(1, childOrderItems2.size());
    Money zeroResult = actualCloneResult.getTotalPrice().abs().zero();
    assertEquals(baseRetailPrice, zeroResult.zero().abs());
    assertEquals(baseRetailPrice, zeroResult.abs().zero());
    assertSame(bundleOrderItemImpl, childOrderItems2.get(0));
  }

  /**
   * Test {@link BundleOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * BundleOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse BundleOrderItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new BundleOrderItemImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<BundleOrderItem> actualCreateOrRetrieveCopyInstanceResult =
        bundleOrderItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link BundleOrderItemImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BundleOrderItemImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
