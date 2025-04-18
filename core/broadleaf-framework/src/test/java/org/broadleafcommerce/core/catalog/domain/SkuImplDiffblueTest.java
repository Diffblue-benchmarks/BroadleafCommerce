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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPrices;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;
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
public class SkuImplDiffblueTest {
  @Autowired
  private SkuImpl skuImpl;

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOnSale()"})
  public void testIsOnSale_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl2.isOnSale();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOnSale()"})
  public void testIsOnSale_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl2.isOnSale();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOnSale()"})
  public void testIsOnSale_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl2.isOnSale();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOnSale()"})
  public void testIsOnSale_givenSkuGetRetailPriceReturnMoney_thenCallsGetRetailPrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl2.isOnSale();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    verify(sku).getRetailPrice();
    verify(sku).getSalePrice();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl2.isOnSale());
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplRetailPriceIsMoney_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());

    // Act and Assert
    assertFalse(skuImpl2.isOnSale());
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplSalePriceIsMoney_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertFalse(skuImpl2.isOnSale());
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).isOnSale());
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOnSale()"})
  public void testIsOnSale_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.isOnSale());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOnSale()"})
  public void testIsOnSale_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.isOnSale());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#hasDefaultSku()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasDefaultSku()"})
  public void testHasDefaultSku_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasDefaultSkuResult = skuImpl2.hasDefaultSku();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualHasDefaultSkuResult);
  }

  /**
   * Test {@link SkuImpl#hasDefaultSku()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasDefaultSku()"})
  public void testHasDefaultSku_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasDefaultSkuResult = skuImpl2.hasDefaultSku();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualHasDefaultSkuResult);
  }

  /**
   * Test {@link SkuImpl#hasDefaultSku()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasDefaultSku()"})
  public void testHasDefaultSku_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl2.hasDefaultSku());
  }

  /**
   * Test {@link SkuImpl#hasDefaultSku()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasDefaultSku()"})
  public void testHasDefaultSku_givenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).hasDefaultSku());
  }

  /**
   * Test {@link SkuImpl#hasDefaultSku()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasDefaultSku()"})
  public void testHasDefaultSku_thenReturnTrue() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasDefaultSkuResult = skuImpl2.hasDefaultSku();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertTrue(actualHasDefaultSkuResult);
  }

  /**
   * Test {@link SkuImpl#hasDefaultSku()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasDefaultSku()"})
  public void testHasDefaultSku_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.hasDefaultSku());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#lookupDefaultSku()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#lookupDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku SkuImpl.lookupDefaultSku()"})
  public void testLookupDefaultSku_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.lookupDefaultSku());
  }

  /**
   * Test {@link SkuImpl#lookupDefaultSku()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#lookupDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku SkuImpl.lookupDefaultSku()"})
  public void testLookupDefaultSku_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).lookupDefaultSku());
  }

  /**
   * Test {@link SkuImpl#lookupDefaultSku()}.
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#lookupDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku SkuImpl.lookupDefaultSku()"})
  public void testLookupDefaultSku_thenReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    SkuImpl skuImpl2 = new SkuImpl();
    when(product.getDefaultSku()).thenReturn(skuImpl2);

    SkuImpl skuImpl3 = new SkuImpl();
    skuImpl3.setProduct(product);

    // Act
    Sku actualLookupDefaultSkuResult = skuImpl3.lookupDefaultSku();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertSame(skuImpl2, actualLookupDefaultSkuResult);
  }

  /**
   * Test {@link SkuImpl#lookupDefaultSku()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#lookupDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku SkuImpl.lookupDefaultSku()"})
  public void testLookupDefaultSku_thenThrowIllegalStateException() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.lookupDefaultSku());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#getProductOptionValueAdjustments()}.
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getProductOptionValueAdjustments()"})
  public void testGetProductOptionValueAdjustments() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getProductOptionValueAdjustments());
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getSalePrice()"})
  public void testGetSalePrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Money actualSalePrice = skuImpl2.getSalePrice();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getSalePrice()"})
  public void testGetSalePrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualSalePrice = skuImpl2.getSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualSalePrice = skuImpl2.getSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuGetSalePriceReturnMoney_thenCallsGetSalePrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getSalePrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Money actualSalePrice = skuImpl2.getSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getSalePrice();
    assertSame(money, actualSalePrice);
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getSalePrice());
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuImplSalePriceIsMoney_thenReturnMoney() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money salePrice = new Money();
    skuImpl2.setSalePrice(salePrice);

    // Act and Assert
    assertEquals(salePrice, skuImpl2.getSalePrice());
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getSalePrice());
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getSalePrice()"})
  public void testGetSalePrice_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getSalePrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getSalePrice()"})
  public void testGetSalePrice_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getSalePrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasSalePrice()"})
  public void testHasSalePrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnFalse() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasSalePriceResult = skuImpl2.hasSalePrice();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualHasSalePriceResult);
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasSalePrice()"})
  public void testHasSalePrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnFalse2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasSalePriceResult = skuImpl2.hasSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualHasSalePriceResult);
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasSalePrice()"})
  public void testHasSalePrice_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasSalePriceResult = skuImpl2.hasSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualHasSalePriceResult);
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasSalePrice()"})
  public void testHasSalePrice_givenSkuGetSalePriceReturnMoney_thenCallsGetSalePrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasSalePriceResult = skuImpl2.hasSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getSalePrice();
    assertTrue(actualHasSalePriceResult);
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasSalePrice()"})
  public void testHasSalePrice_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl2.hasSalePrice());
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasSalePrice()"})
  public void testHasSalePrice_givenSkuImplSalePriceIsMoney_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertTrue(skuImpl2.hasSalePrice());
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasSalePrice()"})
  public void testHasSalePrice_givenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).hasSalePrice());
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasSalePrice()"})
  public void testHasSalePrice_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.hasSalePrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasSalePrice()"})
  public void testHasSalePrice_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.hasSalePrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#salePrice} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSalePrice(Money)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setSalePrice(Money)"})
  public void testSetSalePrice_whenMoney_thenSkuImplSalePriceIsBigDecimalWith000() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money salePrice = new Money();

    // Act
    skuImpl2.setSalePrice(salePrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuImpl2.salePrice);
    BigDecimal bigDecimal = skuImpl2.salePrice;
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
   * Test {@link SkuImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#salePrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSalePrice(Money)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setSalePrice(Money)"})
  public void testSetSalePrice_whenNull_thenSkuImplSalePriceIsNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setSalePrice(null);

    // Assert that nothing has changed
    assertNull(skuImpl2.salePrice);
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Money actualRetailPrice = skuImpl2.getRetailPrice();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualRetailPrice = skuImpl2.getRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualRetailPrice = skuImpl2.getRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuGetRetailPriceReturnMoney_thenCallsGetRetailPrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Money actualRetailPrice = skuImpl2.getRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getRetailPrice();
    assertSame(money, actualRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl2.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl2.getRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl2.getRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getRetailPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getRetailPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPriceInternal()"})
  public void testGetRetailPriceInternal_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Money actualRetailPriceInternal = skuImpl2.getRetailPriceInternal();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualRetailPriceInternal);
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPriceInternal()"})
  public void testGetRetailPriceInternal_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualRetailPriceInternal = skuImpl2.getRetailPriceInternal();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualRetailPriceInternal);
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPriceInternal()"})
  public void testGetRetailPriceInternal_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualRetailPriceInternal = skuImpl2.getRetailPriceInternal();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualRetailPriceInternal);
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPriceInternal()"})
  public void testGetRetailPriceInternal_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getRetailPriceInternal());
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPriceInternal()"})
  public void testGetRetailPriceInternal_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl2.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl2.getRetailPriceInternal());
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPriceInternal()"})
  public void testGetRetailPriceInternal_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl2.getRetailPriceInternal());
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPriceInternal()"})
  public void testGetRetailPriceInternal_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getRetailPriceInternal());
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Then calls {@link Sku#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPriceInternal()"})
  public void testGetRetailPriceInternal_thenCallsGetRetailPrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Money actualRetailPriceInternal = skuImpl2.getRetailPriceInternal();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getRetailPrice();
    assertSame(money, actualRetailPriceInternal);
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPriceInternal()"})
  public void testGetRetailPriceInternal_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getRetailPriceInternal());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getRetailPriceInternal()"})
  public void testGetRetailPriceInternal_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getRetailPriceInternal());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Money actualBaseRetailPrice = skuImpl2.getBaseRetailPrice();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualBaseRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualBaseRetailPrice = skuImpl2.getBaseRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualBaseRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualBaseRetailPrice = skuImpl2.getBaseRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualBaseRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getBaseRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl2.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl2.getBaseRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getBaseRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Then calls {@link Sku#getBaseRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_thenCallsGetBaseRetailPrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getBaseRetailPrice()).thenReturn(money);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Money actualBaseRetailPrice = skuImpl2.getBaseRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getBaseRetailPrice();
    verify(sku).getId();
    assertSame(money, actualBaseRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getBaseRetailPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseRetailPrice()"})
  public void testGetBaseRetailPrice_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getBaseRetailPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Money actualBaseSalePrice = skuImpl2.getBaseSalePrice();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualBaseSalePrice);
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualBaseSalePrice = skuImpl2.getBaseSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualBaseSalePrice);
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualBaseSalePrice = skuImpl2.getBaseSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualBaseSalePrice);
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getBaseSalePrice());
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_givenSkuImplSalePriceIsMoney_thenReturnMoney() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money salePrice = new Money();
    skuImpl2.setSalePrice(salePrice);

    // Act and Assert
    assertEquals(salePrice, skuImpl2.getBaseSalePrice());
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getBaseSalePrice());
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Then calls {@link Sku#getBaseSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_thenCallsGetBaseSalePrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getBaseSalePrice()).thenReturn(money);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Money actualBaseSalePrice = skuImpl2.getBaseSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getBaseSalePrice();
    verify(sku).getId();
    assertSame(money, actualBaseSalePrice);
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getBaseSalePrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getBaseSalePrice()"})
  public void testGetBaseSalePrice_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getBaseSalePrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getPriceData()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.</li>
   *   <li>Then return RetailPrice is Price.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DynamicSkuPrices SkuImpl.getPriceData()"})
  public void testGetPriceData_givenSkuImplRetailPriceIsMoney_thenReturnRetailPriceIsPrice() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());

    // Act
    DynamicSkuPrices actualPriceData = skuImpl2.getPriceData();

    // Assert
    Money price = actualPriceData.getPrice();
    assertSame(price, actualPriceData.getRetailPrice());
    BigDecimal bigDecimal = skuImpl2.retailPrice;
    Money absResult = price.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = price.zero();
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
   * Test {@link SkuImpl#getPriceData()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return SalePrice is Price.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DynamicSkuPrices SkuImpl.getPriceData()"})
  public void testGetPriceData_givenSkuImplSalePriceIsMoney_thenReturnSalePriceIsPrice() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act
    DynamicSkuPrices actualPriceData = skuImpl2.getPriceData();

    // Assert
    Money price = actualPriceData.getPrice();
    assertSame(price, actualPriceData.getSalePrice());
    BigDecimal bigDecimal = skuImpl2.salePrice;
    Money absResult = price.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = price.zero();
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
   * Test {@link SkuImpl#getPriceData()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Price is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DynamicSkuPrices SkuImpl.getPriceData()"})
  public void testGetPriceData_givenSkuImpl_thenReturnPriceIsNull() {
    // Arrange and Act
    DynamicSkuPrices actualPriceData = (new SkuImpl()).getPriceData();

    // Assert
    assertNull(actualPriceData.getPrice());
    assertNull(actualPriceData.getPriceAdjustment());
    assertNull(actualPriceData.getRetailPrice());
    assertNull(actualPriceData.getSalePrice());
    assertFalse(actualPriceData.getDidOverride());
  }

  /**
   * Test {@link SkuImpl#getPriceData()}.
   * <ul>
   *   <li>Then return Price is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DynamicSkuPrices SkuImpl.getPriceData()"})
  public void testGetPriceData_thenReturnPriceIsNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setCurrency(new BroadleafCurrencyImpl());

    // Act
    DynamicSkuPrices actualPriceData = skuImpl2.getPriceData();

    // Assert
    assertNull(actualPriceData.getPrice());
    assertNull(actualPriceData.getPriceAdjustment());
    assertNull(actualPriceData.getRetailPrice());
    assertNull(actualPriceData.getSalePrice());
    assertFalse(actualPriceData.getDidOverride());
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasRetailPrice()"})
  public void testHasRetailPrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnFalse() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasRetailPriceResult = skuImpl2.hasRetailPrice();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualHasRetailPriceResult);
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasRetailPrice()"})
  public void testHasRetailPrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnFalse2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasRetailPriceResult = skuImpl2.hasRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualHasRetailPriceResult);
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasRetailPrice()"})
  public void testHasRetailPrice_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasRetailPriceResult = skuImpl2.hasRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualHasRetailPriceResult);
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasRetailPrice()"})
  public void testHasRetailPrice_givenSkuGetRetailPriceReturnMoney_thenCallsGetRetailPrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    boolean actualHasRetailPriceResult = skuImpl2.hasRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getRetailPrice();
    assertTrue(actualHasRetailPriceResult);
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasRetailPrice()"})
  public void testHasRetailPrice_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl2.hasRetailPrice());
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasRetailPrice()"})
  public void testHasRetailPrice_givenSkuImplRetailPriceIsMoney_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());

    // Act and Assert
    assertTrue(skuImpl2.hasRetailPrice());
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasRetailPrice()"})
  public void testHasRetailPrice_givenSkuImplSalePriceIsMoney_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertFalse(skuImpl2.hasRetailPrice());
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasRetailPrice()"})
  public void testHasRetailPrice_givenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).hasRetailPrice());
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasRetailPrice()"})
  public void testHasRetailPrice_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.hasRetailPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.hasRetailPrice()"})
  public void testHasRetailPrice_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.hasRetailPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setRetailPrice(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setRetailPrice(Money)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setRetailPrice(Money)"})
  public void testSetRetailPrice_whenMoney_thenSkuImplRetailPriceIsBigDecimalWith000() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money retailPrice = new Money();

    // Act
    skuImpl2.setRetailPrice(retailPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuImpl2.retailPrice);
    BigDecimal bigDecimal = skuImpl2.retailPrice;
    Money absResult = retailPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = retailPrice.zero();
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
   * Test {@link SkuImpl#setRetailPrice(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setRetailPrice(Money)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setRetailPrice(Money)"})
  public void testSetRetailPrice_whenNull_thenSkuImplRetailPriceIsNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setRetailPrice(null);

    // Assert that nothing has changed
    assertNull(skuImpl2.retailPrice);
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getPrice()"})
  public void testGetPrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Money actualPrice = skuImpl2.getPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualPrice);
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getPrice()"})
  public void testGetPrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualPrice = skuImpl2.getPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualPrice);
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getPrice()"})
  public void testGetPrice_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualPrice = skuImpl2.getPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    assertNull(actualPrice);
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getPrice()"})
  public void testGetPrice_givenSkuGetRetailPriceReturnMoney_thenCallsGetRetailPrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Money actualPrice = skuImpl2.getPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    assertSame(money, actualPrice);
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getPrice()"})
  public void testGetPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getPrice());
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getPrice()"})
  public void testGetPrice_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl2.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl2.getPrice());
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getPrice()"})
  public void testGetPrice_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl2.getPrice());
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getPrice()"})
  public void testGetPrice_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getPrice());
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getPrice()"})
  public void testGetPrice_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getPrice()"})
  public void testGetPrice_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getListPrice()"})
  public void testGetListPrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Money actualListPrice = skuImpl2.getListPrice();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualListPrice);
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getListPrice()"})
  public void testGetListPrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualListPrice = skuImpl2.getListPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualListPrice);
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getListPrice()"})
  public void testGetListPrice_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualListPrice = skuImpl2.getListPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualListPrice);
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getListPrice()"})
  public void testGetListPrice_givenSkuGetRetailPriceReturnMoney_thenCallsGetRetailPrice() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Money actualListPrice = skuImpl2.getListPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getRetailPrice();
    assertSame(money, actualListPrice);
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getListPrice()"})
  public void testGetListPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getListPrice());
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getListPrice()"})
  public void testGetListPrice_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl2.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl2.getListPrice());
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getListPrice()"})
  public void testGetListPrice_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl2.getListPrice());
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getListPrice()"})
  public void testGetListPrice_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getListPrice());
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getListPrice()"})
  public void testGetListPrice_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getListPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getListPrice()"})
  public void testGetListPrice_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getListPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setListPrice(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setListPrice(Money)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setListPrice(Money)"})
  public void testSetListPrice_whenMoney_thenSkuImplRetailPriceIsBigDecimalWith000() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money listPrice = new Money();

    // Act
    skuImpl2.setListPrice(listPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuImpl2.retailPrice);
    BigDecimal bigDecimal = skuImpl2.retailPrice;
    Money absResult = listPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = listPrice.zero();
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
   * Test {@link SkuImpl#setListPrice(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setListPrice(Money)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setListPrice(Money)"})
  public void testSetListPrice_whenNull_thenSkuImplRetailPriceIsNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setListPrice(null);

    // Assert that nothing has changed
    assertNull(skuImpl2.retailPrice);
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getCost()"})
  public void testGetCost_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Money actualCost = skuImpl2.getCost();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualCost);
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getCost()"})
  public void testGetCost_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualCost = skuImpl2.getCost();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualCost);
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getCost()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getCost()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getCost()"})
  public void testGetCost_givenSkuGetCostReturnMoney_thenCallsGetCost() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getCost()).thenReturn(money);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Money actualCost = skuImpl2.getCost();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku).getId();
    assertSame(money, actualCost);
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getCost()"})
  public void testGetCost_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualCost = skuImpl2.getCost();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualCost);
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Cost is {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getCost()"})
  public void testGetCost_givenSkuImplCostIsMoney_thenReturnMoney() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money cost = new Money();
    skuImpl2.setCost(cost);

    // Act and Assert
    assertEquals(cost, skuImpl2.getCost());
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getCost()"})
  public void testGetCost_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getCost());
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getCost()"})
  public void testGetCost_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getCost());
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getCost()"})
  public void testGetCost_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getCost());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getCost()"})
  public void testGetCost_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setCost(new Money());
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getCost());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setCost(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#cost} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setCost(Money)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setCost(Money)"})
  public void testSetCost_whenMoney_thenSkuImplCostIsBigDecimalWith000() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    Money cost = new Money();

    // Act
    skuImpl2.setCost(cost);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuImpl2.cost);
    BigDecimal bigDecimal = skuImpl2.cost;
    Money absResult = cost.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = cost.zero();
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
   * Test {@link SkuImpl#setCost(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#cost} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setCost(Money)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setCost(Money)"})
  public void testSetCost_whenNull_thenSkuImplCostIsNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setCost(null);

    // Assert that nothing has changed
    assertNull(skuImpl2.cost);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()} {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_givenMoney_thenReturnMoneyZero() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);
    Money money = new Money();

    // Act
    Money actualMargin = skuImpl2.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    assertSame(money.ZERO, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_givenProductGetDefaultSkuReturnSkuImpl_thenReturnAbsIsZero() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Money actualMargin = skuImpl2.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    Money money = actualMargin.ZERO;
    assertEquals(money, actualMargin.abs());
    assertEquals(money, actualMargin.zero());
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_givenProductGetDefaultSkuReturnSkuImpl_thenReturnAbsIsZero2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Money actualMargin = skuImpl2.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    Money money = actualMargin.ZERO;
    assertEquals(money, actualMargin.abs());
    assertEquals(money, actualMargin.zero());
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getCost()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getCost()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_givenSkuGetCostReturnMoney_thenCallsGetCost() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getCost()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(new Money());
    Money money = new Money();
    when(sku.getSalePrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Money actualMargin = skuImpl2.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    assertSame(money.ZERO, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Cost is {@link Money#Money()}.</li>
   *   <li>Then return abs abs abs Amount is {@link SkuImpl} (default constructor) {@link SkuImpl#cost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_givenSkuImplCostIsMoney_thenReturnAbsAbsAbsAmountIsSkuImplCost() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setCost(new Money());

    // Act
    Money actualMargin = skuImpl2.getMargin();

    // Assert
    BigDecimal bigDecimal = skuImpl2.cost;
    Money absResult = actualMargin.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualMargin.zero();
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
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_givenSkuImplRetailPriceIsMoneyWithAmountIsTen_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money(10.0d));

    // Act and Assert
    assertNull(skuImpl2.getMargin());
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_givenSkuImpl_thenReturnAbsIsZero() {
    // Arrange and Act
    Money actualMargin = (new SkuImpl()).getMargin();

    // Assert
    Money money = actualMargin.ZERO;
    assertEquals(money, actualMargin.abs());
    assertEquals(money, actualMargin.zero());
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_thenReturnAbsAbsAbsAmountIsSkuImplRetailPrice() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setRetailPrice(new Money());

    // Act
    Money actualMargin = skuImpl2.getMargin();

    // Assert
    BigDecimal bigDecimal = skuImpl2.retailPrice;
    Money absResult = actualMargin.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualMargin.zero();
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
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link SkuImpl} (default constructor) {@link SkuImpl#salePrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_thenReturnAbsAbsAbsAmountIsSkuImplSalePrice() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act
    Money actualMargin = skuImpl2.getMargin();

    // Assert
    BigDecimal bigDecimal = skuImpl2.salePrice;
    Money absResult = actualMargin.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualMargin.zero();
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
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getMargin());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money SkuImpl.getMargin()"})
  public void testGetMargin_thenThrowIllegalStateException2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money());
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getMargin());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getName()"})
  public void testGetName_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    String actualName = skuImpl2.getName();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualName);
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getName()"})
  public void testGetName_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    String actualName = skuImpl2.getName();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualName);
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getName()"})
  public void testGetName_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    String actualName = skuImpl2.getName();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualName);
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getName()"})
  public void testGetName_givenSkuGetNameReturnName_thenReturnName() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getName()).thenReturn("Name");
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    String actualName = skuImpl2.getName();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getName();
    assertEquals("Name", actualName);
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is {@code name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getName()"})
  public void testGetName_givenSkuImplNameIsName_thenReturnName() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setName("name");

    // Act and Assert
    assertEquals("name", skuImpl2.getName());
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getName()"})
  public void testGetName_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getName());
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getName()"})
  public void testGetName_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl2.getName());
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getName()"})
  public void testGetName_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getName());
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getName()"})
  public void testGetName_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getName());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getDescription()"})
  public void testGetDescription() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals("The characteristics of someone or something", skuImpl2.getDescription());
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getDescription()"})
  public void testGetDescription_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    String actualDescription = skuImpl2.getDescription();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualDescription);
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getDescription()"})
  public void testGetDescription_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    String actualDescription = skuImpl2.getDescription();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualDescription);
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getDescription()"})
  public void testGetDescription_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    String actualDescription = skuImpl2.getDescription();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualDescription);
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getDescription()"})
  public void testGetDescription_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getDescription());
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getDescription()"})
  public void testGetDescription_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl2.getDescription());
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getDescription()"})
  public void testGetDescription_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getDescription());
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Then calls {@link Sku#getDescription()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getDescription()"})
  public void testGetDescription_thenCallsGetDescription() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getDescription()).thenReturn("The characteristics of someone or something");
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    String actualDescription = skuImpl2.getDescription();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getDescription();
    verify(sku).getId();
    assertEquals("The characteristics of someone or something", actualDescription);
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getDescription()"})
  public void testGetDescription_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getDescription());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getLongDescription()"})
  public void testGetLongDescription_givenProductGetDefaultSkuReturnSkuImpl() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    String actualLongDescription = skuImpl2.getLongDescription();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualLongDescription);
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getLongDescription()"})
  public void testGetLongDescription_givenProductGetDefaultSkuReturnSkuImpl2() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    String actualLongDescription = skuImpl2.getLongDescription();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualLongDescription);
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getLongDescription()"})
  public void testGetLongDescription_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    String actualLongDescription = skuImpl2.getLongDescription();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualLongDescription);
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getLongDescription()"})
  public void testGetLongDescription_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getLongDescription());
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getLongDescription()"})
  public void testGetLongDescription_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl2.getLongDescription());
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getLongDescription()"})
  public void testGetLongDescription_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getLongDescription());
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Then return {@code longDescription}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getLongDescription()"})
  public void testGetLongDescription_thenReturnLongDescription() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setLongDescription("longDescription");

    // Act and Assert
    assertEquals("longDescription", skuImpl2.getLongDescription());
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Then return {@code Long Description}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getLongDescription()"})
  public void testGetLongDescription_thenReturnLongDescription2() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getLongDescription()).thenReturn("Long Description");
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    String actualLongDescription = skuImpl2.getLongDescription();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getLongDescription();
    assertEquals("Long Description", actualLongDescription);
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getLongDescription()"})
  public void testGetLongDescription_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getLongDescription());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isTaxable()"})
  public void testIsTaxable_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsTaxableResult = skuImpl2.isTaxable();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualIsTaxableResult);
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isTaxable()"})
  public void testIsTaxable_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsTaxableResult = skuImpl2.isTaxable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualIsTaxableResult);
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isTaxable()"})
  public void testIsTaxable_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsTaxableResult = skuImpl2.isTaxable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualIsTaxableResult);
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isTaxable()"})
  public void testIsTaxable_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.isTaxable());
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Taxable is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isTaxable()"})
  public void testIsTaxable_givenSkuImplTaxableIsFalse_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setTaxable(false);

    // Act and Assert
    assertFalse(skuImpl2.isTaxable());
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Taxable is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isTaxable()"})
  public void testIsTaxable_givenSkuImplTaxableIsTrue_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setTaxable(true);

    // Act and Assert
    assertTrue(skuImpl2.isTaxable());
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isTaxable()"})
  public void testIsTaxable_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).isTaxable());
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#isTaxable()} return {@code true}.</li>
   *   <li>Then calls {@link Sku#isTaxable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isTaxable()"})
  public void testIsTaxable_givenSkuIsTaxableReturnTrue_thenCallsIsTaxable() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsTaxableResult = skuImpl2.isTaxable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).isTaxable();
    assertTrue(actualIsTaxableResult);
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isTaxable()"})
  public void testIsTaxable_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.isTaxable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getTaxable()"})
  public void testGetTaxable_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Boolean actualTaxable = skuImpl2.getTaxable();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualTaxable);
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getTaxable()"})
  public void testGetTaxable_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualTaxable = skuImpl2.getTaxable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualTaxable);
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getTaxable()"})
  public void testGetTaxable_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualTaxable = skuImpl2.getTaxable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualTaxable);
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getTaxable()"})
  public void testGetTaxable_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getTaxable());
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Taxable is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getTaxable()"})
  public void testGetTaxable_givenSkuImplTaxableIsFalse_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setTaxable(false);

    // Act and Assert
    assertFalse(skuImpl2.getTaxable());
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Taxable is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getTaxable()"})
  public void testGetTaxable_givenSkuImplTaxableIsTrue_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setTaxable(true);

    // Act and Assert
    assertTrue(skuImpl2.getTaxable());
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getTaxable()"})
  public void testGetTaxable_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getTaxable());
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#isTaxable()} return {@code true}.</li>
   *   <li>Then calls {@link Sku#isTaxable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getTaxable()"})
  public void testGetTaxable_givenSkuIsTaxableReturnTrue_thenCallsIsTaxable() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualTaxable = skuImpl2.getTaxable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).isTaxable();
    assertTrue(actualTaxable);
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getTaxable()"})
  public void testGetTaxable_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getTaxable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setTaxable(Boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#taxable} charValue is {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setTaxable(Boolean)"})
  public void testSetTaxable_whenFalse_thenSkuImplTaxableCharValueIsN() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setTaxable(false);

    // Assert
    assertEquals('N', skuImpl2.taxable.charValue());
    assertFalse(skuImpl2.getTaxable());
  }

  /**
   * Test {@link SkuImpl#setTaxable(Boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) Taxable is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setTaxable(Boolean)"})
  public void testSetTaxable_whenNull_thenSkuImplTaxableIsNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setTaxable(null);

    // Assert that nothing has changed
    assertNull(skuImpl2.getTaxable());
    assertNull(skuImpl2.taxable);
  }

  /**
   * Test {@link SkuImpl#setTaxable(Boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#taxable} charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setTaxable(Boolean)"})
  public void testSetTaxable_whenTrue_thenSkuImplTaxableCharValueIsY() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setTaxable(true);

    // Assert
    assertEquals('Y', skuImpl2.taxable.charValue());
    assertTrue(skuImpl2.getTaxable());
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isDiscountable()"})
  public void testIsDiscountable_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsDiscountableResult = skuImpl2.isDiscountable();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualIsDiscountableResult);
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isDiscountable()"})
  public void testIsDiscountable_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsDiscountableResult = skuImpl2.isDiscountable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualIsDiscountableResult);
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isDiscountable()"})
  public void testIsDiscountable_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsDiscountableResult = skuImpl2.isDiscountable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualIsDiscountableResult);
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Discountable is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isDiscountable()"})
  public void testIsDiscountable_givenSkuImplDiscountableIsFalse_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDiscountable(false);

    // Act and Assert
    assertFalse(skuImpl2.isDiscountable());
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Discountable is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isDiscountable()"})
  public void testIsDiscountable_givenSkuImplDiscountableIsTrue_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDiscountable(true);

    // Act and Assert
    assertTrue(skuImpl2.isDiscountable());
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isDiscountable()"})
  public void testIsDiscountable_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl2.isDiscountable());
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isDiscountable()"})
  public void testIsDiscountable_givenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).isDiscountable());
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#isDiscountable()} return {@code true}.</li>
   *   <li>Then calls {@link Sku#isDiscountable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isDiscountable()"})
  public void testIsDiscountable_givenSkuIsDiscountableReturnTrue_thenCallsIsDiscountable() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isDiscountable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsDiscountableResult = skuImpl2.isDiscountable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).isDiscountable();
    assertTrue(actualIsDiscountableResult);
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isDiscountable()"})
  public void testIsDiscountable_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.isDiscountable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getDiscountable()"})
  public void testGetDiscountable_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Boolean actualDiscountable = skuImpl2.getDiscountable();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualDiscountable);
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getDiscountable()"})
  public void testGetDiscountable_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualDiscountable = skuImpl2.getDiscountable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualDiscountable);
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getDiscountable()"})
  public void testGetDiscountable_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualDiscountable = skuImpl2.getDiscountable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualDiscountable);
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Discountable is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getDiscountable()"})
  public void testGetDiscountable_givenSkuImplDiscountableIsFalse_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDiscountable(false);

    // Act and Assert
    assertFalse(skuImpl2.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Discountable is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getDiscountable()"})
  public void testGetDiscountable_givenSkuImplDiscountableIsTrue_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDiscountable(true);

    // Act and Assert
    assertTrue(skuImpl2.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getDiscountable()"})
  public void testGetDiscountable_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl2.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getDiscountable()"})
  public void testGetDiscountable_givenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).getDiscountable());
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#isDiscountable()} return {@code true}.</li>
   *   <li>Then calls {@link Sku#isDiscountable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getDiscountable()"})
  public void testGetDiscountable_givenSkuIsDiscountableReturnTrue_thenCallsIsDiscountable() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isDiscountable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualDiscountable = skuImpl2.getDiscountable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).isDiscountable();
    assertTrue(actualDiscountable);
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getDiscountable()"})
  public void testGetDiscountable_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getDiscountable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setDiscountable(Boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#discountable} charValue is {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setDiscountable(Boolean)"})
  public void testSetDiscountable_whenFalse_thenSkuImplDiscountableCharValueIsN() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setDiscountable(false);

    // Assert
    assertEquals('N', skuImpl2.discountable.charValue());
    assertFalse(skuImpl2.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#setDiscountable(Boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then not {@link SkuImpl} (default constructor) Discountable.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setDiscountable(Boolean)"})
  public void testSetDiscountable_whenNull_thenNotSkuImplDiscountable() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setDiscountable(null);

    // Assert that nothing has changed
    assertFalse(skuImpl2.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#setDiscountable(Boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#discountable} charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setDiscountable(Boolean)"})
  public void testSetDiscountable_whenTrue_thenSkuImplDiscountableCharValueIsY() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setDiscountable(true);

    // Assert
    assertEquals('Y', skuImpl2.discountable.charValue());
    assertTrue(skuImpl2.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getInventoryType()} return {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isAvailable()"})
  public void testIsAvailable_givenCategoryImplGetInventoryTypeReturnAlways_available() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualIsAvailableResult = skuImpl2.isAvailable();

    // Assert
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertTrue(actualIsAvailableResult);
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getInventoryType()} return {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isAvailable()"})
  public void testIsAvailable_givenCategoryImplGetInventoryTypeReturnUnavailable() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualIsAvailableResult = skuImpl2.isAvailable();

    // Assert
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertFalse(actualIsAvailableResult);
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultCategory()} return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isAvailable()"})
  public void testIsAvailable_givenProductBundleImplGetDefaultCategoryReturnCategoryImpl() {
    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualIsAvailableResult = skuImpl2.isAvailable();

    // Assert
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertTrue(actualIsAvailableResult);
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Available is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isAvailable()"})
  public void testIsAvailable_givenSkuImplAvailableIsFalse_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setAvailable(false);

    // Act and Assert
    assertFalse(skuImpl2.isAvailable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Available is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isAvailable()"})
  public void testIsAvailable_givenSkuImplAvailableIsTrue_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setAvailable(true);

    // Act and Assert
    assertTrue(skuImpl2.isAvailable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) DefaultProduct is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isAvailable()"})
  public void testIsAvailable_givenSkuImplDefaultProductIsProductBundleImpl_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl2.isAvailable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) InventoryType is {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isAvailable()"})
  public void testIsAvailable_givenSkuImplInventoryTypeIsAlways_available_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    // Act and Assert
    assertTrue(skuImpl2.isAvailable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isAvailable()"})
  public void testIsAvailable_givenSkuImplProductIsProductBundleImpl_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl2.isAvailable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isAvailable()"})
  public void testIsAvailable_givenSkuImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).isAvailable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isAvailable()"})
  public void testIsAvailable_thenThrowIllegalStateException() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.isAvailable());
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getInventoryType()} return {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getAvailable()"})
  public void testGetAvailable_givenCategoryImplGetInventoryTypeReturnAlways_available() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualAvailable = skuImpl2.getAvailable();

    // Assert
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertTrue(actualAvailable);
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getInventoryType()} return {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getAvailable()"})
  public void testGetAvailable_givenCategoryImplGetInventoryTypeReturnUnavailable() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualAvailable = skuImpl2.getAvailable();

    // Assert
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertFalse(actualAvailable);
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultCategory()} return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getAvailable()"})
  public void testGetAvailable_givenProductBundleImplGetDefaultCategoryReturnCategoryImpl() {
    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualAvailable = skuImpl2.getAvailable();

    // Assert
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertTrue(actualAvailable);
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Available is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getAvailable()"})
  public void testGetAvailable_givenSkuImplAvailableIsFalse_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setAvailable(false);

    // Act and Assert
    assertFalse(skuImpl2.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Available is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getAvailable()"})
  public void testGetAvailable_givenSkuImplAvailableIsTrue_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setAvailable(true);

    // Act and Assert
    assertTrue(skuImpl2.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) DefaultProduct is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getAvailable()"})
  public void testGetAvailable_givenSkuImplDefaultProductIsProductBundleImpl_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl2.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) InventoryType is {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getAvailable()"})
  public void testGetAvailable_givenSkuImplInventoryTypeIsAlways_available_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    // Act and Assert
    assertTrue(skuImpl2.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getAvailable()"})
  public void testGetAvailable_givenSkuImplProductIsProductBundleImpl_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl2.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getAvailable()"})
  public void testGetAvailable_givenSkuImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getAvailable());
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getAvailable()"})
  public void testGetAvailable_thenThrowIllegalStateException() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getAvailable());
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
  }

  /**
   * Test {@link SkuImpl#setAvailable(Boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#available} charValue is {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setAvailable(Boolean)"})
  public void testSetAvailable_whenFalse_thenSkuImplAvailableCharValueIsN() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setAvailable(false);

    // Assert
    assertEquals('N', skuImpl2.available.charValue());
    assertFalse(skuImpl2.getAvailable());
  }

  /**
   * Test {@link SkuImpl#setAvailable(Boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) Available.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setAvailable(Boolean)"})
  public void testSetAvailable_whenNull_thenSkuImplAvailable() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setAvailable(null);

    // Assert that nothing has changed
    assertTrue(skuImpl2.getAvailable());
  }

  /**
   * Test {@link SkuImpl#setAvailable(Boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#available} charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setAvailable(Boolean)"})
  public void testSetAvailable_whenTrue_thenSkuImplAvailableCharValueIsY() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setAvailable(true);

    // Assert
    assertEquals('Y', skuImpl2.available.charValue());
    assertTrue(skuImpl2.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Date actualActiveStartDate = skuImpl2.getActiveStartDate();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualActiveStartDate);
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Date actualActiveStartDate = skuImpl2.getActiveStartDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualActiveStartDate);
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Date actualActiveStartDate = skuImpl2.getActiveStartDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualActiveStartDate);
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getActiveStartDate());
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getActiveStartDate());
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Then calls {@link Sku#getActiveStartDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_thenCallsGetActiveStartDate() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getActiveStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    skuImpl2.getActiveStartDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getActiveStartDate();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getActiveStartDate());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveEndDate()"})
  public void testGetActiveEndDate_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Date actualActiveEndDate = skuImpl2.getActiveEndDate();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualActiveEndDate);
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveEndDate()"})
  public void testGetActiveEndDate_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Date actualActiveEndDate = skuImpl2.getActiveEndDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualActiveEndDate);
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveEndDate()"})
  public void testGetActiveEndDate_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Date actualActiveEndDate = skuImpl2.getActiveEndDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualActiveEndDate);
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveEndDate()"})
  public void testGetActiveEndDate_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getActiveEndDate());
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveEndDate()"})
  public void testGetActiveEndDate_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getActiveEndDate());
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Then calls {@link Sku#getActiveEndDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveEndDate()"})
  public void testGetActiveEndDate_thenCallsGetActiveEndDate() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getActiveEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    skuImpl2.getActiveEndDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getActiveEndDate();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date SkuImpl.getActiveEndDate()"})
  public void testGetActiveEndDate_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getActiveEndDate());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getDimension()}.
   * <p>
   * Method under test: {@link SkuImpl#getDimension()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Dimension SkuImpl.getDimension()"})
  public void testGetDimension() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act and Assert
    assertSame(skuImpl2.dimension, skuImpl2.getDimension());
  }

  /**
   * Test {@link SkuImpl#getWeight()}.
   * <p>
   * Method under test: {@link SkuImpl#getWeight()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Weight SkuImpl.getWeight()"})
  public void testGetWeight() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act and Assert
    assertSame(skuImpl2.weight, skuImpl2.getWeight());
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive()"})
  public void testIsActive() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl2.isActive());
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product}, {@code Category}.
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive(Product, Category)"})
  public void testIsActiveWithProductCategory() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertFalse(skuImpl2.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product}, {@code Category}.
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive(Product, Category)"})
  public void testIsActiveWithProductCategory2() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl2.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl2.isActive(mock(Product.class), mock(Category.class)));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product}, {@code Category}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Product} {@link Product#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive(Product, Category)"})
  public void testIsActiveWithProductCategory_givenFalse_whenProductIsActiveReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Product product = mock(Product.class);
    when(product.isActive()).thenReturn(false);

    // Act and Assert
    assertFalse(skuImpl2.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product}, {@code Category}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) ActiveEndDate is {@link Date#Date()}.</li>
   *   <li>When {@link Product}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive(Product, Category)"})
  public void testIsActiveWithProductCategory_givenSkuImplActiveEndDateIsDate_whenProduct() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveEndDate(new Date());
    skuImpl2.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl2.isActive(mock(Product.class), mock(Category.class)));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product}, {@code Category}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) ActiveEndDate is {@link Date#Date()}.</li>
   *   <li>When {@link Product}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive(Product, Category)"})
  public void testIsActiveWithProductCategory_givenSkuImplActiveEndDateIsDate_whenProduct2() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(new Date());
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl.isActive(mock(Product.class), mock(Category.class)));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product}, {@code Category}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive(Product, Category)"})
  public void testIsActiveWithProductCategory_givenSkuImplSalePriceIsMoney() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertFalse(skuImpl2.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product}, {@code Category}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive(Product, Category)"})
  public void testIsActiveWithProductCategory_givenSkuImpl_whenProductBundleImpl() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertFalse(skuImpl2.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product}, {@code Category}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Product} {@link Product#isActive()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive(Product, Category)"})
  public void testIsActiveWithProductCategory_givenTrue_whenProductIsActiveReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Product product = mock(Product.class);
    when(product.isActive()).thenReturn(true);

    // Act and Assert
    assertFalse(skuImpl2.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product}, {@code Category}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive(Product, Category)"})
  public void testIsActiveWithProductCategory_whenNull_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl2.isActive(null, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#isActive()} return {@code false}.</li>
   *   <li>Then calls {@link ProductImpl#isActive()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive()"})
  public void testIsActive_givenProductBundleImplIsActiveReturnFalse_thenCallsIsActive() {
    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.isActive()).thenReturn(false);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    boolean actualIsActiveResult = skuImpl2.isActive();

    // Assert
    verify(defaultProduct).isActive();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#isActive()} return {@code true}.</li>
   *   <li>Then calls {@link ProductImpl#isActive()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive()"})
  public void testIsActive_givenProductBundleImplIsActiveReturnTrue_thenCallsIsActive() {
    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.isActive()).thenReturn(true);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    boolean actualIsActiveResult = skuImpl2.isActive();

    // Assert
    verify(defaultProduct).isActive();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive()"})
  public void testIsActive_givenSkuImplSalePriceIsMoney_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setSalePrice(new Money());

    // Act and Assert
    assertFalse(skuImpl2.isActive());
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive()"})
  public void testIsActive_givenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).isActive());
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <ul>
   *   <li>Given {@link SkuImpl}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isActive()"})
  public void testIsActive_givenSkuImpl_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(skuImpl.isActive());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMedia()"})
  public void testGetSkuMedia_givenHashMap42IsSkuMediaXrefImpl_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, SkuMediaXref> stringSkuMediaXrefMap = new HashMap<>();
    stringSkuMediaXrefMap.put("42", new SkuMediaXrefImpl());
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getSkuMediaXref()).thenReturn(stringSkuMediaXrefMap);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl2.getSkuMedia();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getSkuMediaXref();
    assertEquals(1, actualSkuMedia.size());
    assertNull(actualSkuMedia.get("42"));
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMedia()"})
  public void testGetSkuMedia_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnEmpty() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl2.getSkuMedia();

    // Assert
    verify(product).getDefaultSku();
    assertTrue(actualSkuMedia.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMedia()"})
  public void testGetSkuMedia_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnEmpty2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl2.getSkuMedia();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertTrue(actualSkuMedia.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMedia()"})
  public void testGetSkuMedia_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl2.getSkuMedia();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertTrue(actualSkuMedia.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSkuMediaXref()} return {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link Sku#getSkuMediaXref()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMedia()"})
  public void testGetSkuMedia_givenSkuGetSkuMediaXrefReturnHashMap_thenCallsGetSkuMediaXref() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getSkuMediaXref()).thenReturn(new HashMap<>());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl2.getSkuMedia();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getSkuMediaXref();
    assertTrue(actualSkuMedia.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMedia()"})
  public void testGetSkuMedia_givenSkuImplProductIsProductBundleImpl_thenReturnEmpty() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl2.getSkuMedia().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMedia()"})
  public void testGetSkuMedia_givenSkuImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getSkuMedia().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMedia()"})
  public void testGetSkuMedia_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getSkuMedia());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setSkuMedia(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) SkuMedia size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSkuMedia(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setSkuMedia(Map)"})
  public void testSetSkuMedia_givenFoo_thenSkuImplSkuMediaSizeIsOne() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    HashMap<String, Media> skuMedia = new HashMap<>();
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    skuMedia.put("foo", categoryMediaXrefImpl);

    // Act
    skuImpl2.setSkuMedia(skuMedia);

    // Assert
    Map<String, Media> skuMedia2 = skuImpl2.getSkuMedia();
    assertEquals(1, skuMedia2.size());
    assertEquals(1, skuImpl2.skuMedia.size());
    assertSame(categoryMediaXrefImpl, skuMedia2.get("foo"));
    Map<String, SkuMediaXref> expectedSkuMediaXref = skuImpl2.skuMedia;
    assertSame(expectedSkuMediaXref, skuImpl2.getSkuMediaXref());
  }

  /**
   * Test {@link SkuImpl#setSkuMedia(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) SkuMedia Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSkuMedia(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setSkuMedia(Map)"})
  public void testSetSkuMedia_whenHashMap_thenSkuImplSkuMediaEmpty() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setSkuMedia(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(skuImpl2.getSkuMedia().isEmpty());
    assertTrue(skuImpl2.getSkuMediaXref().isEmpty());
    assertTrue(skuImpl2.skuMedia.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMediaXref()"})
  public void testGetSkuMediaXref_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl2.getSkuMediaXref();

    // Assert
    verify(product).getDefaultSku();
    assertTrue(actualSkuMediaXref.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMediaXref()"})
  public void testGetSkuMediaXref_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl2.getSkuMediaXref();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertTrue(actualSkuMediaXref.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMediaXref()"})
  public void testGetSkuMediaXref_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl2.getSkuMediaXref();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertTrue(actualSkuMediaXref.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMediaXref()"})
  public void testGetSkuMediaXref_givenSkuImplProductIsProductBundleImpl_thenReturnEmpty() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl2.getSkuMediaXref().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMediaXref()"})
  public void testGetSkuMediaXref_givenSkuImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getSkuMediaXref().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Then calls {@link Sku#getSkuMediaXref()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMediaXref()"})
  public void testGetSkuMediaXref_thenCallsGetSkuMediaXref() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getSkuMediaXref()).thenReturn(new HashMap<>());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl2.getSkuMediaXref();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getSkuMediaXref();
    assertTrue(actualSkuMediaXref.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMediaXref()"})
  public void testGetSkuMediaXref_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getSkuMediaXref());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXrefIgnoreDefaultSku()}.
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXrefIgnoreDefaultSku()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuMediaXrefIgnoreDefaultSku()"})
  public void testGetSkuMediaXrefIgnoreDefaultSku() {
    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getSkuMediaXrefIgnoreDefaultSku().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getPrimarySkuMedia()}.
   * <p>
   * Method under test: {@link SkuImpl#getPrimarySkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Media SkuImpl.getPrimarySkuMedia()"})
  public void testGetPrimarySkuMedia() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getPrimarySkuMedia());
  }

  /**
   * Test {@link SkuImpl#isOrderedSkuMedia(Map)}.
   * <p>
   * Method under test: {@link SkuImpl#isOrderedSkuMedia(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuImpl.isOrderedSkuMedia(Map)"})
  public void testIsOrderedSkuMedia() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act and Assert
    assertFalse(skuImpl2.isOrderedSkuMedia(new HashMap<>()));
  }

  /**
   * Test {@link SkuImpl#sortSkuMedia(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#sortSkuMedia(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.sortSkuMedia(Map)"})
  public void testSortSkuMedia_givenFoo_whenHashMapFooIsSkuMediaXrefImpl_thenReturnSizeIsOne() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    HashMap<String, SkuMediaXref> skuMedia = new HashMap<>();
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMedia.put("foo", skuMediaXrefImpl);

    // Act
    Map<String, SkuMediaXref> actualSortSkuMediaResult = skuImpl2.sortSkuMedia(skuMedia);

    // Assert
    assertEquals(1, actualSortSkuMediaResult.size());
    assertSame(skuMediaXrefImpl, actualSortSkuMediaResult.get(null));
  }

  /**
   * Test {@link SkuImpl#sortSkuMedia(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#sortSkuMedia(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.sortSkuMedia(Map)"})
  public void testSortSkuMedia_whenHashMap_thenReturnEmpty() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act and Assert
    assertTrue(skuImpl2.sortSkuMedia(new HashMap<>()).isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuImpl#setActiveEndDate(Date)}
   *   <li>{@link SkuImpl#setActiveStartDate(Date)}
   *   <li>{@link SkuImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link SkuImpl#setDefaultProduct(Product)}
   *   <li>{@link SkuImpl#setDescription(String)}
   *   <li>{@link SkuImpl#setDisplayTemplate(String)}
   *   <li>{@link SkuImpl#setExcludedFulfillmentOptions(List)}
   *   <li>{@link SkuImpl#setExternalId(String)}
   *   <li>{@link SkuImpl#setFees(List)}
   *   <li>{@link SkuImpl#setFulfillmentFlatRates(Map)}
   *   <li>{@link SkuImpl#setId(Long)}
   *   <li>{@link SkuImpl#setIsMachineSortable(Boolean)}
   *   <li>{@link SkuImpl#setLongDescription(String)}
   *   <li>{@link SkuImpl#setMachineSortable(Boolean)}
   *   <li>{@link SkuImpl#setName(String)}
   *   <li>{@link SkuImpl#setProduct(Product)}
   *   <li>{@link SkuImpl#setProductOptionValueXrefs(Set)}
   *   <li>{@link SkuImpl#setQuantityAvailable(Integer)}
   *   <li>{@link SkuImpl#setSkuMediaXref(Map)}
   *   <li>{@link SkuImpl#setTaxCode(String)}
   *   <li>{@link SkuImpl#setUpc(String)}
   *   <li>{@link SkuImpl#setUrlKey(String)}
   *   <li>{@link SkuImpl#setWeight(Weight)}
   *   <li>{@link SkuImpl#getDefaultProduct()}
   *   <li>{@link SkuImpl#getDisplayTemplate()}
   *   <li>{@link SkuImpl#getExcludedFulfillmentOptions()}
   *   <li>{@link SkuImpl#getExternalId()}
   *   <li>{@link SkuImpl#getFees()}
   *   <li>{@link SkuImpl#getFieldEntityType()}
   *   <li>{@link SkuImpl#getFulfillmentFlatRates()}
   *   <li>{@link SkuImpl#getId()}
   *   <li>{@link SkuImpl#getProductOptionValueXrefs()}
   *   <li>{@link SkuImpl#getQuantityAvailable()}
   *   <li>{@link SkuImpl#getUpc()}
   *   <li>{@link SkuImpl#getUrlKey()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product SkuImpl.getDefaultProduct()", "String SkuImpl.getDisplayTemplate()",
      "List SkuImpl.getExcludedFulfillmentOptions()", "String SkuImpl.getExternalId()", "List SkuImpl.getFees()",
      "FieldEntity SkuImpl.getFieldEntityType()", "Map SkuImpl.getFulfillmentFlatRates()", "Long SkuImpl.getId()",
      "Set SkuImpl.getProductOptionValueXrefs()", "Integer SkuImpl.getQuantityAvailable()", "String SkuImpl.getUpc()",
      "String SkuImpl.getUrlKey()", "void SkuImpl.setActiveEndDate(Date)", "void SkuImpl.setActiveStartDate(Date)",
      "void SkuImpl.setCurrency(BroadleafCurrency)", "void SkuImpl.setDefaultProduct(Product)",
      "void SkuImpl.setDescription(String)", "void SkuImpl.setDimension(Dimension)",
      "void SkuImpl.setDisplayTemplate(String)", "void SkuImpl.setExcludedFulfillmentOptions(List)",
      "void SkuImpl.setExternalId(String)", "void SkuImpl.setFees(List)", "void SkuImpl.setFulfillmentFlatRates(Map)",
      "void SkuImpl.setId(Long)", "void SkuImpl.setIsMachineSortable(Boolean)",
      "void SkuImpl.setLongDescription(String)", "void SkuImpl.setMachineSortable(Boolean)",
      "void SkuImpl.setName(String)", "void SkuImpl.setProduct(Product)",
      "void SkuImpl.setProductOptionValueXrefs(Set)", "void SkuImpl.setQuantityAvailable(Integer)",
      "void SkuImpl.setSkuMediaXref(Map)", "void SkuImpl.setTaxCode(String)", "void SkuImpl.setUpc(String)",
      "void SkuImpl.setUrlKey(String)", "void SkuImpl.setWeight(Weight)"})
  public void testGettersAndSetters() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl.setCurrency(new BroadleafCurrencyImpl());
    ProductBundleImpl defaultProduct = new ProductBundleImpl();
    skuImpl.setDefaultProduct(defaultProduct);
    skuImpl.setDescription("The characteristics of someone or something");
    skuImpl.setDisplayTemplate("Display Template");
    ArrayList<FulfillmentOption> excludedFulfillmentOptions = new ArrayList<>();
    skuImpl.setExcludedFulfillmentOptions(excludedFulfillmentOptions);
    skuImpl.setExternalId("42");
    ArrayList<SkuFee> fees = new ArrayList<>();
    skuImpl.setFees(fees);
    HashMap<FulfillmentOption, BigDecimal> fulfillmentFlatRates = new HashMap<>();
    skuImpl.setFulfillmentFlatRates(fulfillmentFlatRates);
    skuImpl.setId(1L);
    skuImpl.setIsMachineSortable(true);
    skuImpl.setLongDescription("Long Description");
    skuImpl.setMachineSortable(true);
    skuImpl.setName("Name");
    skuImpl.setProduct(new ProductBundleImpl());
    HashSet<SkuProductOptionValueXref> productOptionValueXrefs = new HashSet<>();
    skuImpl.setProductOptionValueXrefs(productOptionValueXrefs);
    skuImpl.setQuantityAvailable(1);
    skuImpl.setSkuMediaXref(new HashMap<>());
    skuImpl.setTaxCode("Tax Code");
    skuImpl.setUpc("Upc");
    skuImpl.setUrlKey("https://example.org/example");
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));
    skuImpl.setWeight(weight);
    Product actualDefaultProduct = skuImpl.getDefaultProduct();
    String actualDisplayTemplate = skuImpl.getDisplayTemplate();
    List<FulfillmentOption> actualExcludedFulfillmentOptions = skuImpl.getExcludedFulfillmentOptions();
    String actualExternalId = skuImpl.getExternalId();
    List<SkuFee> actualFees = skuImpl.getFees();
    FieldEntity actualFieldEntityType = skuImpl.getFieldEntityType();
    Map<FulfillmentOption, BigDecimal> actualFulfillmentFlatRates = skuImpl.getFulfillmentFlatRates();
    Long actualId = skuImpl.getId();
    Set<SkuProductOptionValueXref> actualProductOptionValueXrefs = skuImpl.getProductOptionValueXrefs();
    Integer actualQuantityAvailable = skuImpl.getQuantityAvailable();
    String actualUpc = skuImpl.getUpc();

    // Assert
    assertEquals("42", actualExternalId);
    assertEquals("Display Template", actualDisplayTemplate);
    assertEquals("Upc", actualUpc);
    assertEquals("https://example.org/example", skuImpl.getUrlKey());
    assertEquals(1, actualQuantityAvailable.intValue());
    assertEquals(1L, actualId.longValue());
    assertSame(excludedFulfillmentOptions, actualExcludedFulfillmentOptions);
    assertSame(fees, actualFees);
    assertSame(fulfillmentFlatRates, actualFulfillmentFlatRates);
    assertSame(productOptionValueXrefs, actualProductOptionValueXrefs);
    assertSame(defaultProduct, actualDefaultProduct);
    assertSame(actualFieldEntityType.SKU, actualFieldEntityType);
  }

  /**
   * Test {@link SkuImpl#getProduct()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProduct()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product SkuImpl.getProduct()"})
  public void testGetProduct_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getProduct());
  }

  /**
   * Test {@link SkuImpl#getProduct()}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProduct()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product SkuImpl.getProduct()"})
  public void testGetProduct_thenReturnProductBundleImpl() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    ProductBundleImpl defaultProduct = new ProductBundleImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertSame(defaultProduct, skuImpl2.getProduct());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValuesCollection()}.
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValuesCollection()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set SkuImpl.getProductOptionValuesCollection()"})
  public void testGetProductOptionValuesCollection() {
    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getProductOptionValuesCollection().isEmpty());
  }

  /**
   * Test {@link SkuImpl#setProductOptionValuesCollection(Set)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setProductOptionValuesCollection(Set)"})
  public void testSetProductOptionValuesCollection_givenSkuImplNameIsName() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setName("Name");

    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValues.add(productOptionValueImpl);

    // Act
    skuImpl2.setProductOptionValuesCollection(productOptionValues);

    // Assert
    List<ProductOptionValue> productOptionValues2 = skuImpl2.getProductOptionValues();
    assertEquals(1, productOptionValues2.size());
    assertEquals(1, skuImpl2.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl2.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl2.legacyProductOptionValues.size());
    assertSame(productOptionValueImpl, productOptionValues2.get(0));
  }

  /**
   * Test {@link SkuImpl#setProductOptionValuesCollection(Set)}.
   * <ul>
   *   <li>Then {@link SkuImpl} (default constructor) ProductOptionValues Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setProductOptionValuesCollection(Set)"})
  public void testSetProductOptionValuesCollection_thenSkuImplProductOptionValuesEmpty() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setProductOptionValuesCollection(new HashSet<>());

    // Assert that nothing has changed
    assertTrue(skuImpl2.getProductOptionValues().isEmpty());
    assertTrue(skuImpl2.getProductOptionValueXrefs().isEmpty());
    assertTrue(skuImpl2.getProductOptionValuesCollection().isEmpty());
    assertTrue(skuImpl2.legacyProductOptionValues.isEmpty());
  }

  /**
   * Test {@link SkuImpl#setProductOptionValuesCollection(Set)}.
   * <ul>
   *   <li>Then {@link SkuImpl} (default constructor) ProductOptionValues size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setProductOptionValuesCollection(Set)"})
  public void testSetProductOptionValuesCollection_thenSkuImplProductOptionValuesSizeIsOne() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValues.add(productOptionValueImpl);

    // Act
    skuImpl2.setProductOptionValuesCollection(productOptionValues);

    // Assert
    List<ProductOptionValue> productOptionValues2 = skuImpl2.getProductOptionValues();
    assertEquals(1, productOptionValues2.size());
    assertEquals(1, skuImpl2.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl2.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl2.legacyProductOptionValues.size());
    assertSame(productOptionValueImpl, productOptionValues2.get(0));
  }

  /**
   * Test {@link SkuImpl#setProductOptionValuesCollection(Set)}.
   * <ul>
   *   <li>Then {@link SkuImpl} (default constructor) ProductOptionValues size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setProductOptionValuesCollection(Set)"})
  public void testSetProductOptionValuesCollection_thenSkuImplProductOptionValuesSizeIsTwo() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();
    productOptionValues.add(null);
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValues.add(productOptionValueImpl);

    // Act
    skuImpl2.setProductOptionValuesCollection(productOptionValues);

    // Assert
    List<ProductOptionValue> productOptionValues2 = skuImpl2.getProductOptionValues();
    assertEquals(2, productOptionValues2.size());
    assertNull(productOptionValues2.get(0));
    assertEquals(2, skuImpl2.getProductOptionValueXrefs().size());
    assertEquals(2, skuImpl2.getProductOptionValuesCollection().size());
    assertEquals(2, skuImpl2.legacyProductOptionValues.size());
    assertSame(productOptionValueImpl, productOptionValues2.get(1));
  }

  /**
   * Test {@link SkuImpl#getProductOptionValues()}.
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValues()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SkuImpl.getProductOptionValues()"})
  public void testGetProductOptionValues() {
    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getProductOptionValues().isEmpty());
  }

  /**
   * Test {@link SkuImpl#setProductOptionValues(List)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setProductOptionValues(List)"})
  public void testSetProductOptionValues_givenSkuImplNameIsName() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setName("Name");

    ArrayList<ProductOptionValue> productOptionValues = new ArrayList<>();
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValues.add(productOptionValueImpl);

    // Act
    skuImpl2.setProductOptionValues(productOptionValues);

    // Assert
    List<ProductOptionValue> productOptionValues2 = skuImpl2.getProductOptionValues();
    assertEquals(1, productOptionValues2.size());
    assertEquals(1, skuImpl2.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl2.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl2.legacyProductOptionValues.size());
    assertSame(productOptionValueImpl, productOptionValues2.get(0));
  }

  /**
   * Test {@link SkuImpl#setProductOptionValues(List)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then {@link SkuImpl} (default constructor) ProductOptionValues size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setProductOptionValues(List)"})
  public void testSetProductOptionValues_givenSkuImpl_thenSkuImplProductOptionValuesSizeIsOne() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    ArrayList<ProductOptionValue> productOptionValues = new ArrayList<>();
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValues.add(productOptionValueImpl);

    // Act
    skuImpl2.setProductOptionValues(productOptionValues);

    // Assert
    List<ProductOptionValue> productOptionValues2 = skuImpl2.getProductOptionValues();
    assertEquals(1, productOptionValues2.size());
    assertEquals(1, skuImpl2.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl2.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl2.legacyProductOptionValues.size());
    assertSame(productOptionValueImpl, productOptionValues2.get(0));
  }

  /**
   * Test {@link SkuImpl#setProductOptionValues(List)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then {@link SkuImpl} (default constructor) ProductOptionValues size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setProductOptionValues(List)"})
  public void testSetProductOptionValues_givenSkuImpl_thenSkuImplProductOptionValuesSizeIsOne2() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    ArrayList<ProductOptionValue> productOptionValues = new ArrayList<>();
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValues.add(productOptionValueImpl);
    productOptionValues.add(new ProductOptionValueImpl());

    // Act
    skuImpl2.setProductOptionValues(productOptionValues);

    // Assert
    List<ProductOptionValue> productOptionValues2 = skuImpl2.getProductOptionValues();
    assertEquals(1, productOptionValues2.size());
    assertEquals(1, skuImpl2.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl2.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl2.legacyProductOptionValues.size());
    assertSame(productOptionValueImpl, productOptionValues2.get(0));
  }

  /**
   * Test {@link SkuImpl#setProductOptionValues(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) ProductOptionValues Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setProductOptionValues(List)"})
  public void testSetProductOptionValues_whenArrayList_thenSkuImplProductOptionValuesEmpty() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setProductOptionValues(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(skuImpl2.getProductOptionValues().isEmpty());
    assertTrue(skuImpl2.getProductOptionValueXrefs().isEmpty());
    assertTrue(skuImpl2.getProductOptionValuesCollection().isEmpty());
    assertTrue(skuImpl2.legacyProductOptionValues.isEmpty());
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isMachineSortable()"})
  public void testIsMachineSortable_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsMachineSortableResult = skuImpl2.isMachineSortable();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualIsMachineSortableResult);
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isMachineSortable()"})
  public void testIsMachineSortable_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsMachineSortableResult = skuImpl2.isMachineSortable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualIsMachineSortableResult);
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isMachineSortable()"})
  public void testIsMachineSortable_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsMachineSortableResult = skuImpl2.isMachineSortable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualIsMachineSortableResult);
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) MachineSortable is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isMachineSortable()"})
  public void testIsMachineSortable_givenSkuImplMachineSortableIsTrue_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setMachineSortable(true);

    // Act and Assert
    assertTrue(skuImpl2.isMachineSortable());
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isMachineSortable()"})
  public void testIsMachineSortable_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl2.isMachineSortable());
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isMachineSortable()"})
  public void testIsMachineSortable_givenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).isMachineSortable());
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Then calls {@link Sku#isMachineSortable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isMachineSortable()"})
  public void testIsMachineSortable_thenCallsIsMachineSortable() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isMachineSortable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsMachineSortableResult = skuImpl2.isMachineSortable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).isMachineSortable();
    assertTrue(actualIsMachineSortableResult);
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.isMachineSortable()"})
  public void testIsMachineSortable_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.isMachineSortable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getIsMachineSortable()"})
  public void testGetIsMachineSortable_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsMachineSortable = skuImpl2.getIsMachineSortable();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualIsMachineSortable);
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getIsMachineSortable()"})
  public void testGetIsMachineSortable_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsMachineSortable = skuImpl2.getIsMachineSortable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualIsMachineSortable);
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getIsMachineSortable()"})
  public void testGetIsMachineSortable_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsMachineSortable = skuImpl2.getIsMachineSortable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualIsMachineSortable);
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) MachineSortable is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getIsMachineSortable()"})
  public void testGetIsMachineSortable_givenSkuImplMachineSortableIsTrue_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setMachineSortable(true);

    // Act and Assert
    assertTrue(skuImpl2.getIsMachineSortable());
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getIsMachineSortable()"})
  public void testGetIsMachineSortable_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl2.getIsMachineSortable());
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getIsMachineSortable()"})
  public void testGetIsMachineSortable_givenSkuImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).getIsMachineSortable());
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Then calls {@link Sku#getIsMachineSortable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getIsMachineSortable()"})
  public void testGetIsMachineSortable_thenCallsGetIsMachineSortable() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getIsMachineSortable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    Boolean actualIsMachineSortable = skuImpl2.getIsMachineSortable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getIsMachineSortable();
    assertTrue(actualIsMachineSortable);
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean SkuImpl.getIsMachineSortable()"})
  public void testGetIsMachineSortable_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getIsMachineSortable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getInventoryType()} return {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InventoryType SkuImpl.getInventoryType()"})
  public void testGetInventoryType_givenCategoryImplGetInventoryTypeReturnAlways_available() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    InventoryType actualInventoryType = skuImpl2.getInventoryType();

    // Assert
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertSame(actualInventoryType.ALWAYS_AVAILABLE, actualInventoryType);
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultCategory()} return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InventoryType SkuImpl.getInventoryType()"})
  public void testGetInventoryType_givenProductBundleImplGetDefaultCategoryReturnCategoryImpl() {
    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    InventoryType actualInventoryType = skuImpl2.getInventoryType();

    // Assert
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertNull(actualInventoryType);
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) DefaultProduct is {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InventoryType SkuImpl.getInventoryType()"})
  public void testGetInventoryType_givenSkuImplDefaultProductIsProductBundleImpl() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getInventoryType());
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) InventoryType is {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InventoryType SkuImpl.getInventoryType()"})
  public void testGetInventoryType_givenSkuImplInventoryTypeIsAlways_available() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    // Act
    InventoryType actualInventoryType = skuImpl2.getInventoryType();

    // Assert
    assertSame(actualInventoryType.ALWAYS_AVAILABLE, actualInventoryType);
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InventoryType SkuImpl.getInventoryType()"})
  public void testGetInventoryType_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getInventoryType());
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InventoryType SkuImpl.getInventoryType()"})
  public void testGetInventoryType_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getInventoryType());
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InventoryType SkuImpl.getInventoryType()"})
  public void testGetInventoryType_thenThrowIllegalStateException() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getInventoryType());
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
  }

  /**
   * Test {@link SkuImpl#setInventoryType(InventoryType)}.
   * <ul>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#inventoryType} is {@code ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setInventoryType(InventoryType)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setInventoryType(InventoryType)"})
  public void testSetInventoryType_thenSkuImplInventoryTypeIsAlwaysAvailable() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    InventoryType inventoryType = InventoryType.ALWAYS_AVAILABLE;

    // Act
    skuImpl2.setInventoryType(inventoryType);

    // Assert
    assertEquals("ALWAYS_AVAILABLE", skuImpl2.inventoryType);
    InventoryType expectedInventoryType = inventoryType.ALWAYS_AVAILABLE;
    assertSame(expectedInventoryType, skuImpl2.getInventoryType());
  }

  /**
   * Test {@link SkuImpl#setInventoryType(InventoryType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#inventoryType} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setInventoryType(InventoryType)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setInventoryType(InventoryType)"})
  public void testSetInventoryType_whenNull_thenSkuImplInventoryTypeIsNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setInventoryType(null);

    // Assert that nothing has changed
    assertNull(skuImpl2.inventoryType);
    assertNull(skuImpl2.getInventoryType());
  }

  /**
   * Test {@link SkuImpl#getFulfillmentType()}.
   * <p>
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType SkuImpl.getFulfillmentType()"})
  public void testGetFulfillmentType() {
    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    FulfillmentType actualFulfillmentType = skuImpl2.getFulfillmentType();

    // Assert
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertNull(actualFulfillmentType);
  }

  /**
   * Test {@link SkuImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) DefaultProduct is {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType SkuImpl.getFulfillmentType()"})
  public void testGetFulfillmentType_givenSkuImplDefaultProductIsProductBundleImpl() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getFulfillmentType());
  }

  /**
   * Test {@link SkuImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) FulfillmentType is {@link FulfillmentType#DIGITAL}.</li>
   *   <li>Then return {@link FulfillmentType#DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType SkuImpl.getFulfillmentType()"})
  public void testGetFulfillmentType_givenSkuImplFulfillmentTypeIsDigital_thenReturnDigital() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setFulfillmentType(FulfillmentType.DIGITAL);

    // Act
    FulfillmentType actualFulfillmentType = skuImpl2.getFulfillmentType();

    // Assert
    assertSame(actualFulfillmentType.DIGITAL, actualFulfillmentType);
  }

  /**
   * Test {@link SkuImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType SkuImpl.getFulfillmentType()"})
  public void testGetFulfillmentType_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getFulfillmentType());
  }

  /**
   * Test {@link SkuImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType SkuImpl.getFulfillmentType()"})
  public void testGetFulfillmentType_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getFulfillmentType());
  }

  /**
   * Test {@link SkuImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType SkuImpl.getFulfillmentType()"})
  public void testGetFulfillmentType_thenThrowIllegalStateException() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFulfillmentType()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getFulfillmentType());
    verify(categoryImpl).getFulfillmentType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
  }

  /**
   * Test {@link SkuImpl#setFulfillmentType(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#DIGITAL}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#fulfillmentType} is {@code DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setFulfillmentType(FulfillmentType)"})
  public void testSetFulfillmentType_whenDigital_thenSkuImplFulfillmentTypeIsDigital() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    FulfillmentType fulfillmentType = FulfillmentType.DIGITAL;

    // Act
    skuImpl2.setFulfillmentType(fulfillmentType);

    // Assert
    assertEquals("DIGITAL", skuImpl2.fulfillmentType);
    FulfillmentType expectedFulfillmentType = fulfillmentType.DIGITAL;
    assertSame(expectedFulfillmentType, skuImpl2.getFulfillmentType());
  }

  /**
   * Test {@link SkuImpl#setFulfillmentType(FulfillmentType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#fulfillmentType} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setFulfillmentType(FulfillmentType)"})
  public void testSetFulfillmentType_whenNull_thenSkuImplFulfillmentTypeIsNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setFulfillmentType(null);

    // Assert that nothing has changed
    assertNull(skuImpl2.fulfillmentType);
    assertNull(skuImpl2.getFulfillmentType());
  }

  /**
   * Test {@link SkuImpl#getSkuAttributes()}.
   * <p>
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getSkuAttributes()"})
  public void testGetSkuAttributes() {
    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getSkuAttributes().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getMultiValueSkuAttributes()}.
   * <p>
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuImpl.getMultiValueSkuAttributes()"})
  public void testGetMultiValueSkuAttributes() {
    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getMultiValueSkuAttributes().isEmpty());
  }

  /**
   * Test {@link SkuImpl#setSkuAttributes(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#skuAttributes} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSkuAttributes(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setSkuAttributes(Map)"})
  public void testSetSkuAttributes_givenFoo_thenSkuImplSkuAttributesSizeIsOne() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    HashMap<String, SkuAttribute> skuAttributes = new HashMap<>();
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributes.put("foo", skuAttributeImpl);

    // Act
    skuImpl2.setSkuAttributes(skuAttributes);

    // Assert
    List<SkuAttribute> skuAttributeList = skuImpl2.skuAttributes;
    assertEquals(1, skuAttributeList.size());
    Map<String, Collection<SkuAttribute>> multiValueSkuAttributes = skuImpl2.getMultiValueSkuAttributes();
    assertEquals(1, multiValueSkuAttributes.size());
    Map<String, SkuAttribute> skuAttributes2 = skuImpl2.getSkuAttributes();
    assertEquals(1, skuAttributes2.size());
    List<SkuAttribute> expectedGetResult = skuImpl2.skuAttributes;
    assertEquals(expectedGetResult, multiValueSkuAttributes.get(null));
    assertSame(skuAttributeImpl, skuAttributeList.get(0));
    assertSame(skuAttributeImpl, skuAttributes2.get(null));
  }

  /**
   * Test {@link SkuImpl#setSkuAttributes(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#skuAttributes} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSkuAttributes(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.setSkuAttributes(Map)"})
  public void testSetSkuAttributes_whenHashMap_thenSkuImplSkuAttributesEmpty() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();

    // Act
    skuImpl2.setSkuAttributes(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(skuImpl2.skuAttributes.isEmpty());
    assertTrue(skuImpl2.getMultiValueSkuAttributes().isEmpty());
    assertTrue(skuImpl2.getSkuAttributes().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency SkuImpl.getCurrency()"})
  public void testGetCurrency_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    BroadleafCurrency actualCurrency = skuImpl2.getCurrency();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualCurrency);
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency SkuImpl.getCurrency()"})
  public void testGetCurrency_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    BroadleafCurrency actualCurrency = skuImpl2.getCurrency();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualCurrency);
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency SkuImpl.getCurrency()"})
  public void testGetCurrency_givenSkuGetIdReturnOne_thenCallsGetId() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    BroadleafCurrency actualCurrency = skuImpl2.getCurrency();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualCurrency);
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency SkuImpl.getCurrency()"})
  public void testGetCurrency_givenSkuImplCurrencyIsBroadleafCurrencyImpl() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    skuImpl2.setCurrency(currency);

    // Act and Assert
    assertSame(currency, skuImpl2.getCurrency());
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency SkuImpl.getCurrency()"})
  public void testGetCurrency_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getCurrency());
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency SkuImpl.getCurrency()"})
  public void testGetCurrency_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getCurrency());
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Then calls {@link Sku#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency SkuImpl.getCurrency()"})
  public void testGetCurrency_thenCallsGetCurrency() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    when(sku.getCurrency()).thenReturn(broadleafCurrencyImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(2L);
    skuImpl2.setProduct(product);

    // Act
    BroadleafCurrency actualCurrency = skuImpl2.getCurrency();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCurrency();
    verify(sku).getId();
    assertSame(broadleafCurrencyImpl, actualCurrency);
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BroadleafCurrency SkuImpl.getCurrency()"})
  public void testGetCurrency_thenThrowIllegalStateException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getCurrency());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultCategory()} return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getTaxCode()"})
  public void testGetTaxCode_givenProductBundleImplGetDefaultCategoryReturnCategoryImpl() {
    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act
    String actualTaxCode = skuImpl2.getTaxCode();

    // Assert
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertNull(actualTaxCode);
  }

  /**
   * Test {@link SkuImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) DefaultProduct is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getTaxCode()"})
  public void testGetTaxCode_givenSkuImplDefaultProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getTaxCode());
  }

  /**
   * Test {@link SkuImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getTaxCode()"})
  public void testGetTaxCode_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl2.getTaxCode());
  }

  /**
   * Test {@link SkuImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) TaxCode is {@code Tax Code}.</li>
   *   <li>Then return {@code Tax Code}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getTaxCode()"})
  public void testGetTaxCode_givenSkuImplTaxCodeIsTaxCode_thenReturnTaxCode() {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setTaxCode("Tax Code");

    // Act and Assert
    assertEquals("Tax Code", skuImpl2.getTaxCode());
  }

  /**
   * Test {@link SkuImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getTaxCode()"})
  public void testGetTaxCode_givenSkuImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getTaxCode());
  }

  /**
   * Test {@link SkuImpl#getTaxCode()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SkuImpl.getTaxCode()"})
  public void testGetTaxCode_thenThrowIllegalStateException() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getTaxCode()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl2.getTaxCode());
    verify(categoryImpl).getTaxCode();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
  }

  /**
   * Test {@link SkuImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link SkuImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse SkuImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Sku> actualCreateOrRetrieveCopyInstanceResult = skuImpl2.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SkuImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then Clone return {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse SkuImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_givenJavaLangObject_thenCloneReturnSkuImpl()
      throws CloneNotSupportedException {
    // Arrange
    SkuImpl skuImpl2 = new SkuImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<Sku> actualCreateOrRetrieveCopyInstanceResult = skuImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.SkuImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    Sku clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof SkuImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(skuImpl2, clone);
  }

  /**
   * Test new {@link SkuImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SkuImpl}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuImpl.<init>()"})
  public void testNewSkuImpl() {
    // Arrange and Act
    SkuImpl actualSkuImpl = new SkuImpl();

    // Assert
    assertNull(actualSkuImpl.getTaxable());
    assertNull(actualSkuImpl.isMachineSortable);
    assertNull(actualSkuImpl.available);
    assertNull(actualSkuImpl.discountable);
    assertNull(actualSkuImpl.taxable);
    assertNull(actualSkuImpl.getId());
    assertNull(actualSkuImpl.getDescription());
    assertNull(actualSkuImpl.getDisplayTemplate());
    assertNull(actualSkuImpl.getExternalId());
    assertNull(actualSkuImpl.getLongDescription());
    assertNull(actualSkuImpl.getName());
    assertNull(actualSkuImpl.getTaxCode());
    assertNull(actualSkuImpl.getUpc());
    assertNull(actualSkuImpl.getUrlKey());
    assertNull(actualSkuImpl.description);
    assertNull(actualSkuImpl.fulfillmentType);
    assertNull(actualSkuImpl.inventoryType);
    assertNull(actualSkuImpl.longDescription);
    assertNull(actualSkuImpl.name);
    assertNull(actualSkuImpl.taxCode);
    assertNull(actualSkuImpl.cost);
    assertNull(actualSkuImpl.retailPrice);
    assertNull(actualSkuImpl.salePrice);
    assertNull(actualSkuImpl.getActiveEndDate());
    assertNull(actualSkuImpl.getActiveStartDate());
    assertNull(actualSkuImpl.activeEndDate);
    assertNull(actualSkuImpl.activeStartDate);
    assertNull(actualSkuImpl.getCurrency());
    assertNull(actualSkuImpl.currency);
    assertNull(actualSkuImpl.getPrimarySkuMedia());
    assertNull(actualSkuImpl.getBaseRetailPrice());
    assertNull(actualSkuImpl.getBaseSalePrice());
    assertNull(actualSkuImpl.getCost());
    assertNull(actualSkuImpl.getListPrice());
    assertNull(actualSkuImpl.getPrice());
    assertNull(actualSkuImpl.getProductOptionValueAdjustments());
    assertNull(actualSkuImpl.getRetailPrice());
    assertNull(actualSkuImpl.getRetailPriceInternal());
    assertNull(actualSkuImpl.getSalePrice());
    assertNull(actualSkuImpl.getDefaultProduct());
    assertNull(actualSkuImpl.getProduct());
    assertNull(actualSkuImpl.product);
    assertNull(actualSkuImpl.getInventoryType());
    assertNull(actualSkuImpl.getFulfillmentType());
    assertEquals(0, actualSkuImpl.getQuantityAvailable().intValue());
    assertFalse(actualSkuImpl.getDiscountable());
    assertFalse(actualSkuImpl.getIsMachineSortable());
    assertFalse(actualSkuImpl.hasDefaultSku());
    assertFalse(actualSkuImpl.hasRetailPrice());
    assertFalse(actualSkuImpl.hasSalePrice());
    assertTrue(actualSkuImpl.getExcludedFulfillmentOptions().isEmpty());
    assertTrue(actualSkuImpl.getFees().isEmpty());
    assertTrue(actualSkuImpl.getProductOptionValues().isEmpty());
    assertTrue(actualSkuImpl.skuAttributes.isEmpty());
    assertTrue(actualSkuImpl.getFulfillmentFlatRates().isEmpty());
    assertTrue(actualSkuImpl.getMultiValueSkuAttributes().isEmpty());
    assertTrue(actualSkuImpl.getSkuAttributes().isEmpty());
    assertTrue(actualSkuImpl.getSkuMedia().isEmpty());
    assertTrue(actualSkuImpl.getSkuMediaXref().isEmpty());
    assertTrue(actualSkuImpl.legacySkuMedia.isEmpty());
    assertTrue(actualSkuImpl.skuMedia.isEmpty());
    assertTrue(actualSkuImpl.getProductOptionValueXrefs().isEmpty());
    assertTrue(actualSkuImpl.getProductOptionValuesCollection().isEmpty());
    assertTrue(actualSkuImpl.legacyProductOptionValues.isEmpty());
    assertTrue(actualSkuImpl.getAvailable());
    Dimension expectedDimension = actualSkuImpl.dimension;
    assertSame(expectedDimension, actualSkuImpl.getDimension());
    Map<String, SkuMediaXref> expectedSkuMediaXrefIgnoreDefaultSku = actualSkuImpl.skuMedia;
    assertSame(expectedSkuMediaXrefIgnoreDefaultSku, actualSkuImpl.getSkuMediaXrefIgnoreDefaultSku());
    Weight expectedWeight = actualSkuImpl.weight;
    assertSame(expectedWeight, actualSkuImpl.getWeight());
  }
}
