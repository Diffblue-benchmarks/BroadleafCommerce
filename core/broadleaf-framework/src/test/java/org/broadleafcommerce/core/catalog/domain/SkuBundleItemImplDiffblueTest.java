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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPrices;
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
public class SkuBundleItemImplDiffblueTest {
  @Autowired
  private SkuBundleItemImpl skuBundleItemImpl;

  /**
   * Test {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}.
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} (default constructor).</li>
   *   <li>Then return abs abs zero is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuBundleItemImpl.getDynamicSalePrice(Sku, BigDecimal)"})
  public void testGetDynamicSalePrice_givenSkuBundleItemImpl_thenReturnAbsAbsZeroIsZero() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();

    // Act
    Money actualDynamicSalePrice = skuBundleItemImpl2.getDynamicSalePrice(sku, new BigDecimal("2.3"));

    // Assert
    Money money = actualDynamicSalePrice.ZERO;
    Money absResult = actualDynamicSalePrice.abs();
    assertEquals(money, absResult.abs().zero());
    assertEquals(money, absResult.zero());
    assertEquals(money, actualDynamicSalePrice.zero());
  }

  /**
   * Test {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}.
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuBundleItemImpl.getDynamicSalePrice(Sku, BigDecimal)"})
  public void testGetDynamicSalePrice_givenSkuBundleItemImpl_whenNull_thenReturnNull() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();

    // Act and Assert
    assertNull(skuBundleItemImpl2.getDynamicSalePrice(new SkuImpl(), null));
  }

  /**
   * Test {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs zero is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuBundleItemImpl.getDynamicSalePrice(Sku, BigDecimal)"})
  public void testGetDynamicSalePrice_thenReturnAbsAbsZeroIsMoney() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    Money salePrice = new Money();
    skuBundleItemImpl2.setSalePrice(salePrice);
    SkuImpl sku = new SkuImpl();

    // Act
    Money actualDynamicSalePrice = skuBundleItemImpl2.getDynamicSalePrice(sku, new BigDecimal("2.3"));

    // Assert
    Money absResult = actualDynamicSalePrice.abs();
    assertEquals(salePrice, absResult.abs().zero());
    assertEquals(salePrice, absResult.zero());
    assertEquals(salePrice, actualDynamicSalePrice.zero());
  }

  /**
   * Test {@link SkuBundleItemImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) Bundle {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuBundleItemImpl.setSalePrice(Money)"})
  public void testSetSalePrice_thenSkuBundleItemImplBundleProductBundleImpl() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setBundle(new ProductBundleImpl());
    skuBundleItemImpl2.setId(1L);
    skuBundleItemImpl2.setQuantity(1);
    skuBundleItemImpl2.setSalePrice(new Money());
    skuBundleItemImpl2.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl2.setSku(new SkuImpl());

    // Act
    skuBundleItemImpl2.setSalePrice(null);

    // Assert
    ProductBundle bundle = skuBundleItemImpl2.getBundle();
    assertTrue(bundle instanceof ProductBundleImpl);
    ProductBundle productBundle = skuBundleItemImpl2.bundle;
    assertTrue(productBundle instanceof ProductBundleImpl);
    assertNull(skuBundleItemImpl2.itemSalePrice);
    assertNull(skuBundleItemImpl2.getSalePrice());
    BigDecimal expectedPotentialSavings = new BigDecimal("0.00");
    BigDecimal potentialSavings = bundle.getPotentialSavings();
    assertEquals(expectedPotentialSavings, potentialSavings);
    assertSame(potentialSavings, bundle.getBundleItemsRetailPrice().getAmount());
    assertSame(potentialSavings, productBundle.getPotentialSavings());
  }

  /**
   * Test {@link SkuBundleItemImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) {@link SkuBundleItemImpl#itemSalePrice} is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuBundleItemImpl.setSalePrice(Money)"})
  public void testSetSalePrice_thenSkuBundleItemImplItemSalePriceIsBigDecimalWith23() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    Money salePrice = mock(Money.class);
    when(salePrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    skuBundleItemImpl2.setSalePrice(salePrice);

    // Assert
    verify(salePrice).getAmount();
    assertEquals(new BigDecimal("2.3"), skuBundleItemImpl2.itemSalePrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) {@link SkuBundleItemImpl#itemSalePrice} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuBundleItemImpl.setSalePrice(Money)"})
  public void testSetSalePrice_whenMoney_thenSkuBundleItemImplItemSalePriceIsBigDecimalWith000() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    Money salePrice = new Money();

    // Act
    skuBundleItemImpl2.setSalePrice(salePrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuBundleItemImpl2.itemSalePrice);
    BigDecimal bigDecimal = skuBundleItemImpl2.itemSalePrice;
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
   * Test {@link SkuBundleItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuBundleItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuGetIdReturnOne_thenReturnMoney() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    Money salePrice = new Money();
    skuBundleItemImpl2.setSalePrice(salePrice);
    skuBundleItemImpl2.setSku(sku);

    // Act
    Money actualSalePrice = skuBundleItemImpl2.getSalePrice();

    // Assert
    verify(sku).getId();
    assertEquals(salePrice, actualSalePrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuBundleItemImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuGetSalePriceReturnMoney_thenCallsGetSalePrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getSalePrice()).thenReturn(money);

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setSku(sku);

    // Act
    Money actualSalePrice = skuBundleItemImpl2.getSalePrice();

    // Assert
    verify(sku).getId();
    verify(sku).getSalePrice();
    assertSame(money, actualSalePrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) Sku {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuBundleItemImpl.getSalePrice()"})
  public void testGetSalePrice_thenSkuBundleItemImplSkuSkuImpl() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();
    skuBundleItemImpl2.setSku(sku);

    // Act
    Money actualSalePrice = skuBundleItemImpl2.getSalePrice();

    // Assert
    Sku sku2 = skuBundleItemImpl2.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(skuBundleItemImpl2.deproxiedSku instanceof SkuImpl);
    assertNull(actualSalePrice);
    assertSame(sku, sku2);
  }

  /**
   * Test {@link SkuBundleItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuBundleItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuGetIdReturnOne_thenReturnMoney() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setSku(sku);

    // Act
    Money actualRetailPrice = skuBundleItemImpl2.getRetailPrice();

    // Assert
    verify(sku).getId();
    verify(sku).getRetailPrice();
    assertSame(money, actualRetailPrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) Sku {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuBundleItemImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenSkuBundleItemImplSkuSkuImpl() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();
    skuBundleItemImpl2.setSku(sku);

    // Act
    Money actualRetailPrice = skuBundleItemImpl2.getRetailPrice();

    // Assert
    Sku sku2 = skuBundleItemImpl2.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(skuBundleItemImpl2.deproxiedSku instanceof SkuImpl);
    assertNull(actualRetailPrice);
    assertSame(sku, sku2);
  }

  /**
   * Test {@link SkuBundleItemImpl#getBundle()}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getBundle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProductBundle SkuBundleItemImpl.getBundle()"})
  public void testGetBundle_thenReturnProductBundleImpl() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    ProductBundleImpl bundle = new ProductBundleImpl();
    skuBundleItemImpl2.setBundle(bundle);

    // Act and Assert
    assertSame(bundle, skuBundleItemImpl2.getBundle());
  }

  /**
   * Test {@link SkuBundleItemImpl#getSku()}.
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} (default constructor) Sku is {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getSku()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku SkuBundleItemImpl.getSku()"})
  public void testGetSku_givenSkuBundleItemImplSkuIsSkuImpl_thenReturnSkuImpl() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();
    skuBundleItemImpl2.setSku(sku);

    // Act and Assert
    assertSame(sku, skuBundleItemImpl2.getSku());
  }

  /**
   * Test {@link SkuBundleItemImpl#clearDynamicPrices()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) {@link SkuBundleItemImpl#sku}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuBundleItemImpl.clearDynamicPrices()"})
  public void testClearDynamicPrices_givenSkuGetIdReturnOne_thenSkuBundleItemImplSku() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    doNothing().when(sku).clearDynamicPrices();

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setSku(sku);

    // Act
    skuBundleItemImpl2.clearDynamicPrices();

    // Assert
    verify(sku).clearDynamicPrices();
    verify(sku).getId();
    Sku expectedSku = skuBundleItemImpl2.sku;
    assertSame(expectedSku, skuBundleItemImpl2.getSku());
  }

  /**
   * Test {@link SkuBundleItemImpl#clearDynamicPrices()}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) {@link SkuBundleItemImpl#deproxiedSku} hasSalePrice.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuBundleItemImpl.clearDynamicPrices()"})
  public void testClearDynamicPrices_thenSkuBundleItemImplDeproxiedSkuHasSalePrice() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setSku(sku);

    // Act
    skuBundleItemImpl2.clearDynamicPrices();

    // Assert
    Sku sku2 = skuBundleItemImpl2.deproxiedSku;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(sku2.hasSalePrice());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
    DynamicSkuPrices priceData = sku2.getPriceData();
    Money price = priceData.getPrice();
    assertEquals(salePrice, price);
    assertSame(price, priceData.getSalePrice());
    Money expectedMargin = salePrice.ZERO;
    assertSame(expectedMargin, sku2.getMargin());
    assertSame(sku.salePrice, ((SkuImpl) sku2).salePrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#clearDynamicPrices()}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) {@link SkuBundleItemImpl#deproxiedSku} {@link SkuImpl#salePrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuBundleItemImpl.clearDynamicPrices()"})
  public void testClearDynamicPrices_thenSkuBundleItemImplDeproxiedSkuSalePriceIsNull() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setSku(new SkuImpl());

    // Act
    skuBundleItemImpl2.clearDynamicPrices();

    // Assert
    Sku sku = skuBundleItemImpl2.deproxiedSku;
    assertTrue(sku instanceof SkuImpl);
    assertNull(((SkuImpl) sku).salePrice);
    assertNull(sku.getBaseSalePrice());
    assertNull(sku.getSalePrice());
    DynamicSkuPrices priceData = sku.getPriceData();
    assertNull(priceData.getPrice());
    assertNull(priceData.getSalePrice());
    assertFalse(sku.hasSalePrice());
  }

  /**
   * Test {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse SkuBundleItemImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuBundleItem> actualCreateOrRetrieveCopyInstanceResult = skuBundleItemImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}, and {@link SkuBundleItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuBundleItemImpl#equals(Object)}
   *   <li>{@link SkuBundleItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuBundleItemImpl.equals(Object)", "int SkuBundleItemImpl.hashCode()"})
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
    int expectedHashCodeResult = skuBundleItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuBundleItemImpl2.hashCode());
  }

  /**
   * Test {@link SkuBundleItemImpl#equals(Object)}, and {@link SkuBundleItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuBundleItemImpl#equals(Object)}
   *   <li>{@link SkuBundleItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuBundleItemImpl.equals(Object)", "int SkuBundleItemImpl.hashCode()"})
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuBundleItemImpl.equals(Object)", "int SkuBundleItemImpl.hashCode()"})
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuBundleItemImpl.equals(Object)", "int SkuBundleItemImpl.hashCode()"})
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuBundleItemImpl.equals(Object)", "int SkuBundleItemImpl.hashCode()"})
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
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuBundleItemImpl.<init>()", "Long SkuBundleItemImpl.getId()",
      "Integer SkuBundleItemImpl.getQuantity()", "BigDecimal SkuBundleItemImpl.getSequence()",
      "void SkuBundleItemImpl.setBundle(ProductBundle)", "void SkuBundleItemImpl.setId(Long)",
      "void SkuBundleItemImpl.setQuantity(Integer)", "void SkuBundleItemImpl.setSequence(BigDecimal)",
      "void SkuBundleItemImpl.setSku(Sku)"})
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
