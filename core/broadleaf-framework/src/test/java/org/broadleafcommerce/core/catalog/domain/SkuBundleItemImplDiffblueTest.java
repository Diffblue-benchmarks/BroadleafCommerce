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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.Money;
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
public class SkuBundleItemImplDiffblueTest {
  @Autowired private SkuBundleItemImpl skuBundleItemImpl;

  /**
   * Test {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}.
   *
   * <ul>
   *   <li>Then return Currency Symbol is {@code $}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money SkuBundleItemImpl.getDynamicSalePrice(Sku, BigDecimal)"})
  public void testGetDynamicSalePrice_thenReturnCurrencySymbolIsDollarSign() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    Money actualDynamicSalePrice =
        skuBundleItemImpl.getDynamicSalePrice(sku, new BigDecimal("2.3"));

    // Assert
    Currency currency = actualDynamicSalePrice.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertEquals(new BigDecimal("2.30"), actualDynamicSalePrice.getAmount());
    Money actualAbsResult = actualDynamicSalePrice.abs();
    assertEquals(actualDynamicSalePrice, actualAbsResult);
    assertEquals(Money.ZERO, actualDynamicSalePrice.zero());
  }

  /**
   * Test {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money SkuBundleItemImpl.getDynamicSalePrice(Sku, BigDecimal)"})
  public void testGetDynamicSalePrice_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(skuBundleItemImpl.getDynamicSalePrice(new SkuImpl(), null));
  }

  /**
   * Test {@link SkuBundleItemImpl#setSalePrice(Money)}.
   *
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} {@link SkuBundleItemImpl#itemSalePrice} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuBundleItemImpl.setSalePrice(Money)"})
  public void testSetSalePrice_thenSkuBundleItemImplItemSalePriceIsBigDecimalWith23() {
    // Arrange
    Money salePrice = mock(Money.class);
    when(salePrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    skuBundleItemImpl.setSalePrice(salePrice);

    // Assert
    verify(salePrice).getAmount();
    assertEquals(new BigDecimal("2.3"), skuBundleItemImpl.itemSalePrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#setSalePrice(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link SkuBundleItemImpl} {@link SkuBundleItemImpl#itemSalePrice} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuBundleItemImpl.setSalePrice(Money)"})
  public void testSetSalePrice_whenMoney_thenSkuBundleItemImplItemSalePriceIsBigDecimalWith000() {
    // Arrange
    Money salePrice = new Money();

    // Act
    skuBundleItemImpl.setSalePrice(salePrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuBundleItemImpl.itemSalePrice);
    BigDecimal bigDecimal = skuBundleItemImpl.itemSalePrice;
    Money absResult = salePrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = salePrice.zero();
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
   * Test {@link SkuBundleItemImpl#setSalePrice(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link SkuBundleItemImpl} {@link SkuBundleItemImpl#itemSalePrice} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuBundleItemImpl.setSalePrice(Money)"})
  public void testSetSalePrice_whenNull_thenSkuBundleItemImplItemSalePriceIsNull() {
    // Arrange and Act
    skuBundleItemImpl.setSalePrice(null);

    // Assert that nothing has changed
    assertNull(skuBundleItemImpl.itemSalePrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.
   *   <li>Then calls {@link Sku#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money SkuBundleItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getSalePrice()).thenReturn(money);

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    Money actualSalePrice = skuBundleItemImpl.getSalePrice();

    // Assert
    verify(sku).getId();
    verify(sku).getSalePrice();
    assertSame(money, actualSalePrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) {@link
   *       SkuBundleItemImpl#deproxiedSku} {@link SkuImpl#salePrice} is {@link SkuImpl} (default
   *       constructor) {@link SkuImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money SkuBundleItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenSkuBundleItemImplDeproxiedSkuSalePriceIsSkuImplSalePrice() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    Money actualSalePrice = skuBundleItemImpl.getSalePrice();

    // Assert
    Sku sku2 = skuBundleItemImpl.deproxiedSku;
    assertTrue(sku2 instanceof SkuImpl);
    assertEquals(salePrice, actualSalePrice);
    assertSame(sku.salePrice, ((SkuImpl) sku2).salePrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) Sku {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money SkuBundleItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenSkuBundleItemImplSkuSkuImpl() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    Money actualSalePrice = skuBundleItemImpl.getSalePrice();

    // Assert
    Sku sku2 = skuBundleItemImpl.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    assertNull(actualSalePrice);
    assertSame(sku, sku2);
  }

  /**
   * Test {@link SkuBundleItemImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) {@link SkuBundleItemImpl#sku} {@link
   *       SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money SkuBundleItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenSkuBundleItemImplSkuSkuImpl2() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    SkuImpl sku = new SkuImpl();
    sku.setCurrency(currency);
    sku.setSalePrice(new Money());

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    Money actualSalePrice = skuBundleItemImpl.getSalePrice();

    // Assert
    verify(currency).getCurrencyCode();
    Sku sku2 = skuBundleItemImpl.deproxiedSku;
    assertTrue(sku2 instanceof SkuImpl);
    Sku sku3 = skuBundleItemImpl.sku;
    assertTrue(sku3 instanceof SkuImpl);
    Currency currency2 = actualSalePrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    BroadleafCurrency broadleafCurrency = sku.currency;
    assertSame(broadleafCurrency, ((SkuImpl) sku2).currency);
    assertSame(broadleafCurrency, ((SkuImpl) sku3).currency);
  }

  /**
   * Test {@link SkuBundleItemImpl#clearDynamicPrices()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) {@link SkuBundleItemImpl#sku}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuBundleItemImpl.clearDynamicPrices()"})
  public void testClearDynamicPrices_givenSkuGetIdReturnOne_thenSkuBundleItemImplSku() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    doNothing().when(sku).clearDynamicPrices();

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(sku);

    // Act
    skuBundleItemImpl.clearDynamicPrices();

    // Assert
    verify(sku).clearDynamicPrices();
    verify(sku).getId();
    Sku expectedSku = skuBundleItemImpl.sku;
    assertSame(expectedSku, skuBundleItemImpl.getSku());
  }

  /**
   * Test {@link SkuBundleItemImpl#clearDynamicPrices()}.
   *
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) Sku {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuBundleItemImpl.clearDynamicPrices()"})
  public void testClearDynamicPrices_thenSkuBundleItemImplSkuSkuImpl() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    SkuImpl sku = new SkuImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    skuBundleItemImpl.clearDynamicPrices();

    // Assert
    Sku sku2 = skuBundleItemImpl.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(skuBundleItemImpl.deproxiedSku instanceof SkuImpl);
    assertSame(sku, sku2);
  }

  /**
   * Test {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuBundleItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new SkuBundleItemImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuBundleItem> actualCreateOrRetrieveCopyInstanceResult =
        skuBundleItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuBundleItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SkuImpl(), true));
    when(sku.getSalePrice()).thenReturn(new Money());

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    when(createResponse.getClone()).thenReturn(skuBundleItemImpl2);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    skuBundleItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(sku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(sku).getId();
    verify(sku).getSalePrice();
    BigDecimal bigDecimal = skuBundleItemImpl2.itemSalePrice;
    Money salePrice = skuBundleItemImpl.getSalePrice();
    Money absResult = salePrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = salePrice.zero();
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
   * Test {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuBundleItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());
    when(sku.getSalePrice()).thenReturn(new Money());

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new SkuBundleItemImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> skuBundleItemImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(sku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(sku).getId();
    verify(sku).getSalePrice();
  }

  /**
   * Test {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuBundleItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SkuImpl(), true));
    when(sku.getSalePrice()).thenReturn(money);

    ProductBundleImpl bundle = mock(ProductBundleImpl.class);
    when(bundle.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new ProductBundleImpl(), true));

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(bundle);
    skuBundleItemImpl.setSku(sku);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new SkuBundleItemImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    skuBundleItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(money).getAmount();
    verify(bundle).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(sku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(sku).getId();
    verify(sku).getSalePrice();
    Sku expectedSku = skuBundleItemImpl.sku;
    assertSame(expectedSku, skuBundleItemImpl.getSku());
  }

  /**
   * Test {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuBundleItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance5() throws CloneNotSupportedException {
    // Arrange
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SkuImpl(), true));
    when(sku.getSalePrice()).thenReturn(money);

    ProductBundleImpl bundle = mock(ProductBundleImpl.class);
    when(bundle.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(bundle);
    skuBundleItemImpl.setSku(sku);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new SkuBundleItemImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> skuBundleItemImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(money).getAmount();
    verify(bundle).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(sku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(sku).getId();
    verify(sku).getSalePrice();
  }

  /**
   * Test {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} (default constructor) SalePrice is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuBundleItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenSkuBundleItemImplSalePriceIsMoney()
      throws CloneNotSupportedException {
    // Arrange
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SkuImpl(), true));

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSku(sku);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    when(createResponse.getClone()).thenReturn(skuBundleItemImpl2);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    skuBundleItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(sku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(sku).getId();
    BigDecimal bigDecimal = skuBundleItemImpl2.itemSalePrice;
    Money salePrice = skuBundleItemImpl.getSalePrice();
    Money absResult = salePrice.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = salePrice.zero();
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
    Sku expectedSku = skuBundleItemImpl.sku;
    assertSame(expectedSku, skuBundleItemImpl.getSku());
  }

  /**
   * Test {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getSalePrice()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuBundleItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenSkuImplGetSalePriceReturnNull()
      throws CloneNotSupportedException {
    // Arrange
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SkuImpl(), true));
    when(sku.getSalePrice()).thenReturn(null);

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new SkuBundleItemImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    skuBundleItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(sku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(sku).getId();
    verify(sku).getSalePrice();
    Sku expectedSku = skuBundleItemImpl.sku;
    assertSame(expectedSku, skuBundleItemImpl.getSku());
  }

  /**
   * Test {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then calls {@link Money#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuBundleItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCallsGetAmount()
      throws CloneNotSupportedException {
    // Arrange
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SkuImpl(), true));
    when(sku.getSalePrice()).thenReturn(money);

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new SkuBundleItemImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    skuBundleItemImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(money).getAmount();
    verify(sku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(sku).getId();
    verify(sku).getSalePrice();
    Sku expectedSku = skuBundleItemImpl.sku;
    assertSame(expectedSku, skuBundleItemImpl.getSku());
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}, and {@link SkuBundleItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuBundleItemImpl#equals(Object)}
   *   <li>{@link SkuBundleItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuBundleItemImpl.equals(Object)",
    "int SkuBundleItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setBundle(new ProductBundleImpl());
    skuBundleItemImpl2.setId(1L);
    skuBundleItemImpl2.setQuantity(1);
    skuBundleItemImpl2.setSalePrice(new Money());
    skuBundleItemImpl2.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuBundleItemImpl, skuBundleItemImpl2);
    assertEquals(skuBundleItemImpl.hashCode(), skuBundleItemImpl2.hashCode());
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}, and {@link SkuBundleItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuBundleItemImpl#equals(Object)}
   *   <li>{@link SkuBundleItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuBundleItemImpl.equals(Object)",
    "int SkuBundleItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuBundleItemImpl, skuBundleItemImpl);
    int expectedHashCodeResult = skuBundleItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuBundleItemImpl.hashCode());
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuBundleItemImpl.equals(Object)",
    "int SkuBundleItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(2L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setBundle(new ProductBundleImpl());
    skuBundleItemImpl2.setId(1L);
    skuBundleItemImpl2.setQuantity(1);
    skuBundleItemImpl2.setSalePrice(new Money());
    skuBundleItemImpl2.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuBundleItemImpl, skuBundleItemImpl2);
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuBundleItemImpl.equals(Object)",
    "int SkuBundleItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuBundleItemImpl, null);
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuBundleItemImpl.equals(Object)",
    "int SkuBundleItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuBundleItemImpl, "Different type to SkuBundleItemImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SkuBundleItemImpl}
   *   <li>{@link SkuBundleItemImpl#setBundle(ProductBundle)}
   *   <li>{@link SkuBundleItemImpl#setId(Long)}
   *   <li>{@link SkuBundleItemImpl#setQuantity(Integer)}
   *   <li>{@link SkuBundleItemImpl#setSequence(BigDecimal)}
   *   <li>{@link SkuBundleItemImpl#setSku(Sku)}
   *   <li>{@link SkuBundleItemImpl#getId()}
   *   <li>{@link SkuBundleItemImpl#getQuantity()}
   *   <li>{@link SkuBundleItemImpl#getSequence()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuBundleItemImpl.<init>()",
    "Long SkuBundleItemImpl.getId()",
    "Integer SkuBundleItemImpl.getQuantity()",
    "BigDecimal SkuBundleItemImpl.getSequence()",
    "void SkuBundleItemImpl.setBundle(ProductBundle)",
    "void SkuBundleItemImpl.setId(Long)",
    "void SkuBundleItemImpl.setQuantity(Integer)",
    "void SkuBundleItemImpl.setSequence(BigDecimal)",
    "void SkuBundleItemImpl.setSku(Sku)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuBundleItemImpl actualSkuBundleItemImpl = new SkuBundleItemImpl();
    actualSkuBundleItemImpl.setBundle(new ProductBundleImpl());
    actualSkuBundleItemImpl.setId(1L);
    actualSkuBundleItemImpl.setQuantity(1);
    BigDecimal sequence = new BigDecimal("2.3");
    actualSkuBundleItemImpl.setSequence(sequence);
    actualSkuBundleItemImpl.setSku(new SkuImpl());
    Long actualId = actualSkuBundleItemImpl.getId();
    Integer actualQuantity = actualSkuBundleItemImpl.getQuantity();
    BigDecimal actualSequence = actualSkuBundleItemImpl.getSequence();

    // Assert
    assertEquals(1, actualQuantity.intValue());
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
  }
}
