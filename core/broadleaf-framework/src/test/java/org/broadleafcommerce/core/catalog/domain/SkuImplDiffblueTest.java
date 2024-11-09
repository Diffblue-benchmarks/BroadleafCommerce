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
import java.util.function.BiFunction;
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
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class SkuImplDiffblueTest {
  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.isOnSale());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertThrows(IllegalStateException.class, () -> skuImpl.isOnSale());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#isZero()} return {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenMoneyIsZeroReturnFalse_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    when(money.isZero()).thenReturn(false);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl.isOnSale();

    // Assert
    verify(money).isZero();
    verify(money).lessThan(isA(Money.class));
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    verify(sku).getRetailPrice();
    verify(sku).getSalePrice();
    assertTrue(actualIsOnSaleResult);
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link Money#isZero()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenMoneyIsZeroReturnTrue_thenCallsIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    when(money.isZero()).thenReturn(true);
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl.isOnSale();

    // Assert
    verify(money).isZero();
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    verify(sku).getRetailPrice();
    verify(sku).getSalePrice();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl.isOnSale();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl.isOnSale();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return
   * {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuGetSalePriceReturnMoneyWithAmountIsTen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money(10.0d));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl.isOnSale();

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
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuGetSalePriceReturnMoney_thenCallsGetSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl.isOnSale();

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
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    boolean actualIsOnSaleResult = skuImpl.isOnSale();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.isOnSale());
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuImplRetailPriceIsMoney_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money());

    // Act and Assert
    assertFalse(skuImpl.isOnSale());
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuImplSalePriceIsMoney_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertFalse(skuImpl.isOnSale());
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuImplSalePriceIsMoney_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertFalse(skuImpl.isOnSale());
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
  public void testIsOnSale_givenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).isOnSale());
  }

  /**
   * Test {@link SkuImpl#isOnSale()}.
   * <ul>
   *   <li>Then calls {@link Sku#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_thenCallsGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getCurrency()).thenThrow(new IllegalStateException("currency.default"));
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.isOnSale());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCurrency();
    verify(sku, atLeast(1)).getId();
    verify(sku).getRetailPrice();
  }

  /**
   * Test {@link SkuImpl#hasDefaultSku()}.
   * <p>
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.hasDefaultSku());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#hasDefaultSku()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    boolean actualHasDefaultSkuResult = skuImpl.hasDefaultSku();

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
  public void testHasDefaultSku_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    boolean actualHasDefaultSkuResult = skuImpl.hasDefaultSku();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualHasDefaultSkuResult);
  }

  /**
   * Test {@link SkuImpl#hasDefaultSku()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku_givenSkuGetIdThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.hasDefaultSku());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#hasDefaultSku()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.hasDefaultSku());
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
  public void testHasDefaultSku_givenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testHasDefaultSku_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    boolean actualHasDefaultSkuResult = skuImpl.hasDefaultSku();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertTrue(actualHasDefaultSkuResult);
  }

  /**
   * Test {@link SkuImpl#lookupDefaultSku()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#lookupDefaultSku()}
   */
  @Test
  public void testLookupDefaultSku_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.lookupDefaultSku());
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
  public void testLookupDefaultSku_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testLookupDefaultSku_thenReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    SkuImpl skuImpl = new SkuImpl();
    when(product.getDefaultSku()).thenReturn(skuImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setProduct(product);

    // Act
    Sku actualLookupDefaultSkuResult = skuImpl2.lookupDefaultSku();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertSame(skuImpl, actualLookupDefaultSkuResult);
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
  public void testLookupDefaultSku_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.lookupDefaultSku());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#getProductOptionValueAdjustments()}.
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<SkuProductOptionValueXref> productOptionValueXrefs = new HashSet<>();
    SkuImpl sku = new SkuImpl();
    productOptionValueXrefs.add(new SkuProductOptionValueXrefImpl(sku, new ProductOptionValueImpl()));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProductOptionValueXrefs(productOptionValueXrefs);

    // Act and Assert
    assertNull(skuImpl.getProductOptionValueAdjustments());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValueAdjustments()}.
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl(new SkuImpl(),
        mock(ProductOptionValueImpl.class));
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());

    HashSet<SkuProductOptionValueXref> productOptionValueXrefs = new HashSet<>();
    productOptionValueXrefs.add(skuProductOptionValueXrefImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProductOptionValueXrefs(productOptionValueXrefs);

    // Act and Assert
    assertNull(skuImpl.getProductOptionValueAdjustments());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValueAdjustments()}.
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValue = new ProductOptionValueImpl();
    productOptionValue.setPriceAdjustment(new Money());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl(new SkuImpl(),
        mock(ProductOptionValueImpl.class));
    skuProductOptionValueXrefImpl.setProductOptionValue(productOptionValue);

    HashSet<SkuProductOptionValueXref> productOptionValueXrefs = new HashSet<>();
    productOptionValueXrefs.add(skuProductOptionValueXrefImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProductOptionValueXrefs(productOptionValueXrefs);
    Money expectedProductOptionValueAdjustments = new Money();

    // Act and Assert
    assertEquals(expectedProductOptionValueAdjustments, skuImpl.getProductOptionValueAdjustments());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValueAdjustments()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getProductOptionValueAdjustments());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValueAdjustments()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getProductOptionValueAdjustments());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValueAdjustments()}.
   * <ul>
   *   <li>Then calls {@link ProductOptionValueImpl#getPriceAdjustment()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments_thenCallsGetPriceAdjustment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl val = mock(ProductOptionValueImpl.class);
    Money money = new Money();
    when(val.getPriceAdjustment()).thenReturn(money);
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl(new SkuImpl(), val);

    HashSet<SkuProductOptionValueXref> productOptionValueXrefs = new HashSet<>();
    productOptionValueXrefs.add(skuProductOptionValueXrefImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProductOptionValueXrefs(productOptionValueXrefs);

    // Act
    Money actualProductOptionValueAdjustments = skuImpl.getProductOptionValueAdjustments();

    // Assert
    verify(val, atLeast(1)).getPriceAdjustment();
    assertSame(money, actualProductOptionValueAdjustments);
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Money actualSalePrice = skuImpl.getSalePrice();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualSalePrice = skuImpl.getSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenSkuGetSalePriceReturnMoney_thenCallsGetSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getSalePrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualSalePrice = skuImpl.getSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getSalePrice();
    assertSame(money, actualSalePrice);
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualSalePrice = skuImpl.getSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getSalePrice());
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenSkuImplSalePriceIsMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money salePrice = new Money();
    skuImpl.setSalePrice(salePrice);

    // Act and Assert
    assertEquals(salePrice, skuImpl.getSalePrice());
  }

  /**
   * Test {@link SkuImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getSalePrice());
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
  public void testGetSalePrice_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetSalePrice_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getSalePrice());
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
  public void testGetSalePrice_thenThrowIllegalStateException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getSalePrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    boolean actualHasSalePriceResult = skuImpl.hasSalePrice();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualHasSalePriceResult);
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    boolean actualHasSalePriceResult = skuImpl.hasSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualHasSalePriceResult);
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice_givenSkuGetSalePriceReturnMoney_thenCallsGetSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    boolean actualHasSalePriceResult = skuImpl.hasSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getSalePrice();
    assertTrue(actualHasSalePriceResult);
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    boolean actualHasSalePriceResult = skuImpl.hasSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualHasSalePriceResult);
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.hasSalePrice());
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice_givenSkuImplSalePriceIsMoney_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertFalse(skuImpl.hasSalePrice());
  }

  /**
   * Test {@link SkuImpl#hasSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice_givenSkuImplSalePriceIsMoney_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertTrue(skuImpl.hasSalePrice());
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
  public void testHasSalePrice_givenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testHasSalePrice_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.hasSalePrice());
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
  public void testHasSalePrice_thenThrowIllegalStateException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.hasSalePrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#salePrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice_whenMoney_thenSkuImplSalePriceIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money salePrice = new Money();

    // Act
    skuImpl.setSalePrice(salePrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuImpl.salePrice);
    BigDecimal bigDecimal = skuImpl.salePrice;
    Money absResult = salePrice.abs();
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
    Money zeroResult = salePrice.zero();
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
   * Test {@link SkuImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#salePrice} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice_whenMoney_thenSkuImplSalePriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setSalePrice(mock(Money.class));

    // Assert
    assertNull(skuImpl.salePrice);
  }

  /**
   * Test {@link SkuImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#salePrice} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice_whenNull_thenSkuImplSalePriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setSalePrice(null);

    // Assert
    assertNull(skuImpl.salePrice);
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Money actualRetailPrice = skuImpl.getRetailPrice();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualRetailPrice = skuImpl.getRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenSkuGetRetailPriceReturnMoney_thenCallsGetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualRetailPrice = skuImpl.getRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getRetailPrice();
    assertSame(money, actualRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualRetailPrice = skuImpl.getRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl.getRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenSkuImplSalePriceIsMoney_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getRetailPrice());
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
  public void testGetRetailPrice_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetRetailPrice_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getRetailPrice());
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
  public void testGetRetailPrice_thenThrowIllegalStateException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertThrows(IllegalStateException.class, () -> skuImpl.getRetailPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal_givenProductGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Money actualRetailPriceInternal = skuImpl.getRetailPriceInternal();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualRetailPriceInternal);
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal_givenProductGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualRetailPriceInternal = skuImpl.getRetailPriceInternal();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualRetailPriceInternal);
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualRetailPriceInternal = skuImpl.getRetailPriceInternal();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualRetailPriceInternal);
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getRetailPriceInternal());
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl.getRetailPriceInternal());
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getRetailPriceInternal());
  }

  /**
   * Test {@link SkuImpl#getRetailPriceInternal()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal_givenSkuImplSalePriceIsMoney_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getRetailPriceInternal());
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
  public void testGetRetailPriceInternal_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetRetailPriceInternal_thenCallsGetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualRetailPriceInternal = skuImpl.getRetailPriceInternal();

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
  public void testGetRetailPriceInternal_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getRetailPriceInternal());
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
  public void testGetRetailPriceInternal_thenThrowIllegalStateException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertThrows(IllegalStateException.class, () -> skuImpl.getRetailPriceInternal());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Money actualBaseRetailPrice = skuImpl.getBaseRetailPrice();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualBaseRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualBaseRetailPrice = skuImpl.getBaseRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualBaseRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualBaseRetailPrice = skuImpl.getBaseRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualBaseRetailPrice);
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getBaseRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl.getBaseRetailPrice());
  }

  /**
   * Test {@link SkuImpl#getBaseRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice_givenSkuImplRetailPriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getBaseRetailPrice());
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
  public void testGetBaseRetailPrice_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetBaseRetailPrice_thenCallsGetBaseRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getBaseRetailPrice()).thenReturn(money);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualBaseRetailPrice = skuImpl.getBaseRetailPrice();

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
  public void testGetBaseRetailPrice_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getBaseRetailPrice());
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
  public void testGetBaseRetailPrice_thenThrowIllegalStateException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money());
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getBaseRetailPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Money actualBaseSalePrice = skuImpl.getBaseSalePrice();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualBaseSalePrice);
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualBaseSalePrice = skuImpl.getBaseSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualBaseSalePrice);
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualBaseSalePrice = skuImpl.getBaseSalePrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualBaseSalePrice);
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getBaseSalePrice());
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_givenSkuImplSalePriceIsMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money salePrice = new Money();
    skuImpl.setSalePrice(salePrice);

    // Act and Assert
    assertEquals(salePrice, skuImpl.getBaseSalePrice());
  }

  /**
   * Test {@link SkuImpl#getBaseSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getBaseSalePrice());
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
  public void testGetBaseSalePrice_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetBaseSalePrice_thenCallsGetBaseSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getBaseSalePrice()).thenReturn(money);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualBaseSalePrice = skuImpl.getBaseSalePrice();

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
  public void testGetBaseSalePrice_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getBaseSalePrice());
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
  public void testGetBaseSalePrice_thenThrowIllegalStateException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getBaseSalePrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getPriceData()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Currency is
   * {@link BroadleafCurrencyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  public void testGetPriceData_givenSkuImplCurrencyIsBroadleafCurrencyImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setCurrency(new BroadleafCurrencyImpl());

    // Act
    DynamicSkuPrices actualPriceData = skuImpl.getPriceData();

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
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return RetailPrice is Price.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  public void testGetPriceData_givenSkuImplRetailPriceIsMoney_thenReturnRetailPriceIsPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money());

    // Act
    DynamicSkuPrices actualPriceData = skuImpl.getPriceData();

    // Assert
    Money price = actualPriceData.getPrice();
    assertSame(price, actualPriceData.getRetailPrice());
    BigDecimal bigDecimal = skuImpl.retailPrice;
    Money absResult = price.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = price.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult6.getAmount());
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
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult5.getAmount());
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
    assertSame(bigDecimal, absResult15.getAmount());
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
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult15 = absResult4.zero();
    Money absResult46 = zeroResult15.abs();
    assertSame(bigDecimal, absResult46.abs().getAmount());
    Money zeroResult16 = absResult9.zero();
    Money absResult47 = zeroResult16.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult17 = absResult13.zero();
    Money absResult48 = zeroResult17.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult18 = absResult17.zero();
    Money absResult49 = zeroResult18.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult19 = absResult20.zero();
    Money absResult50 = zeroResult19.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult20 = absResult23.zero();
    Money absResult51 = zeroResult20.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult21 = absResult26.zero();
    Money absResult52 = zeroResult21.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult22 = absResult29.zero();
    Money absResult53 = zeroResult22.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult23 = zeroResult8.zero();
    Money absResult54 = zeroResult23.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult24 = zeroResult9.zero();
    Money absResult55 = zeroResult24.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult25 = zeroResult10.zero();
    Money absResult56 = zeroResult25.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult26 = zeroResult11.zero();
    Money absResult57 = zeroResult26.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult27 = zeroResult12.zero();
    Money absResult58 = zeroResult27.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult28 = zeroResult13.zero();
    Money absResult59 = zeroResult28.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult29 = zeroResult14.zero();
    Money absResult60 = zeroResult29.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult30 = zeroResult7.zero();
    Money absResult61 = zeroResult30.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult48 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult52 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult56 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult60 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link SkuImpl#getPriceData()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return Price is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  public void testGetPriceData_givenSkuImplSalePriceIsMoney_thenReturnPriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act
    DynamicSkuPrices actualPriceData = skuImpl.getPriceData();

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
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return SalePrice is Price.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  public void testGetPriceData_givenSkuImplSalePriceIsMoney_thenReturnSalePriceIsPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act
    DynamicSkuPrices actualPriceData = skuImpl.getPriceData();

    // Assert
    Money price = actualPriceData.getPrice();
    assertSame(price, actualPriceData.getSalePrice());
    BigDecimal bigDecimal = skuImpl.salePrice;
    Money absResult = price.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = price.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult6.getAmount());
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
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult5.getAmount());
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
    assertSame(bigDecimal, absResult15.getAmount());
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
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult15 = absResult4.zero();
    Money absResult46 = zeroResult15.abs();
    assertSame(bigDecimal, absResult46.abs().getAmount());
    Money zeroResult16 = absResult9.zero();
    Money absResult47 = zeroResult16.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult17 = absResult13.zero();
    Money absResult48 = zeroResult17.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult18 = absResult17.zero();
    Money absResult49 = zeroResult18.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult19 = absResult20.zero();
    Money absResult50 = zeroResult19.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult20 = absResult23.zero();
    Money absResult51 = zeroResult20.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult21 = absResult26.zero();
    Money absResult52 = zeroResult21.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult22 = absResult29.zero();
    Money absResult53 = zeroResult22.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult23 = zeroResult8.zero();
    Money absResult54 = zeroResult23.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult24 = zeroResult9.zero();
    Money absResult55 = zeroResult24.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult25 = zeroResult10.zero();
    Money absResult56 = zeroResult25.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult26 = zeroResult11.zero();
    Money absResult57 = zeroResult26.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult27 = zeroResult12.zero();
    Money absResult58 = zeroResult27.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult28 = zeroResult13.zero();
    Money absResult59 = zeroResult28.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult29 = zeroResult14.zero();
    Money absResult60 = zeroResult29.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult30 = zeroResult7.zero();
    Money absResult61 = zeroResult30.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult48 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult52 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult56 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult60 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
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
  public void testGetPriceData_givenSkuImpl_thenReturnPriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    boolean actualHasRetailPriceResult = skuImpl.hasRetailPrice();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualHasRetailPriceResult);
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    boolean actualHasRetailPriceResult = skuImpl.hasRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertFalse(actualHasRetailPriceResult);
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenSkuGetRetailPriceReturnMoney_thenCallsGetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    boolean actualHasRetailPriceResult = skuImpl.hasRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getRetailPrice();
    assertTrue(actualHasRetailPriceResult);
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    boolean actualHasRetailPriceResult = skuImpl.hasRetailPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualHasRetailPriceResult);
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.hasRetailPrice());
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenSkuImplRetailPriceIsMoney_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money());

    // Act and Assert
    assertTrue(skuImpl.hasRetailPrice());
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenSkuImplSalePriceIsMoney_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertFalse(skuImpl.hasRetailPrice());
  }

  /**
   * Test {@link SkuImpl#hasRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice_givenSkuImplSalePriceIsMoney_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertFalse(skuImpl.hasRetailPrice());
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
  public void testHasRetailPrice_givenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testHasRetailPrice_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.hasRetailPrice());
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
  public void testHasRetailPrice_thenThrowIllegalStateException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertThrows(IllegalStateException.class, () -> skuImpl.hasRetailPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setRetailPrice(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setRetailPrice(Money)}
   */
  @Test
  public void testSetRetailPrice_whenMoney_thenSkuImplRetailPriceIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();

    // Act
    skuImpl.setRetailPrice(retailPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuImpl.retailPrice);
    BigDecimal bigDecimal = skuImpl.retailPrice;
    Money absResult = retailPrice.abs();
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
    Money zeroResult = retailPrice.zero();
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
   * Test {@link SkuImpl#setRetailPrice(Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setRetailPrice(Money)}
   */
  @Test
  public void testSetRetailPrice_whenMoney_thenSkuImplRetailPriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setRetailPrice(mock(Money.class));

    // Assert
    assertNull(skuImpl.retailPrice);
  }

  /**
   * Test {@link SkuImpl#setRetailPrice(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setRetailPrice(Money)}
   */
  @Test
  public void testSetRetailPrice_whenNull_thenSkuImplRetailPriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setRetailPrice(null);

    // Assert
    assertNull(skuImpl.retailPrice);
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertThrows(IllegalStateException.class, () -> skuImpl.getPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#isZero()} return {@code false}.</li>
   *   <li>Then calls {@link Money#lessThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenMoneyIsZeroReturnFalse_thenCallsLessThan() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    when(money.isZero()).thenReturn(false);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    skuImpl.getPrice();

    // Assert
    verify(money).isZero();
    verify(money).lessThan(isA(Money.class));
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    verify(sku).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link Money#isZero()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenMoneyIsZeroReturnTrue_thenCallsIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    when(money.isZero()).thenReturn(true);
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money2 = new Money();
    when(sku.getRetailPrice()).thenReturn(money2);
    when(sku.getSalePrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualPrice = skuImpl.getPrice();

    // Assert
    verify(money).isZero();
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    assertSame(money2, actualPrice);
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Money actualPrice = skuImpl.getPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualPrice);
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenProductGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualPrice = skuImpl.getPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualPrice);
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return
   * {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenSkuGetSalePriceReturnMoneyWithAmountIsTen_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);
    when(sku.getSalePrice()).thenReturn(new Money(10.0d));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualPrice = skuImpl.getPrice();

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
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenSkuGetSalePriceReturnMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualPrice = skuImpl.getPrice();

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
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenSkuImplIdIsOne_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualPrice = skuImpl.getPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    assertNull(actualPrice);
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getPrice());
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl.getPrice());
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getPrice());
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_givenSkuImplSalePriceIsMoney_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getPrice());
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
  public void testGetPrice_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getPrice());
  }

  /**
   * Test {@link SkuImpl#getPrice()}.
   * <ul>
   *   <li>Then calls {@link Sku#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice_thenCallsGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getCurrency()).thenThrow(new IllegalStateException("currency.default"));
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCurrency();
    verify(sku, atLeast(1)).getId();
    verify(sku).getRetailPrice();
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Money actualListPrice = skuImpl.getListPrice();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualListPrice);
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualListPrice = skuImpl.getListPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualListPrice);
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice_givenSkuGetRetailPriceReturnMoney_thenCallsGetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualListPrice = skuImpl.getListPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getRetailPrice();
    assertSame(money, actualListPrice);
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualListPrice = skuImpl.getListPrice();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualListPrice);
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getListPrice());
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl.getListPrice());
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getListPrice());
  }

  /**
   * Test {@link SkuImpl#getListPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice_givenSkuImplSalePriceIsMoney_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getListPrice());
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
  public void testGetListPrice_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetListPrice_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getListPrice());
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
  public void testGetListPrice_thenThrowIllegalStateException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertThrows(IllegalStateException.class, () -> skuImpl.getListPrice());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setListPrice(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setListPrice(Money)}
   */
  @Test
  public void testSetListPrice_whenMoney_thenSkuImplRetailPriceIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money listPrice = new Money();

    // Act
    skuImpl.setListPrice(listPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuImpl.retailPrice);
    BigDecimal bigDecimal = skuImpl.retailPrice;
    Money absResult = listPrice.abs();
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
    Money zeroResult = listPrice.zero();
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
   * Test {@link SkuImpl#setListPrice(Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setListPrice(Money)}
   */
  @Test
  public void testSetListPrice_whenMoney_thenSkuImplRetailPriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setListPrice(mock(Money.class));

    // Assert
    assertNull(skuImpl.retailPrice);
  }

  /**
   * Test {@link SkuImpl#setListPrice(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#retailPrice} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setListPrice(Money)}
   */
  @Test
  public void testSetListPrice_whenNull_thenSkuImplRetailPriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setListPrice(null);

    // Assert
    assertNull(skuImpl.retailPrice);
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Money actualCost = skuImpl.getCost();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualCost);
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualCost = skuImpl.getCost();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertNull(actualCost);
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getCost()} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getCost()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost_givenSkuGetCostReturnMoney_thenCallsGetCost() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getCost()).thenReturn(money);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualCost = skuImpl.getCost();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku).getId();
    assertSame(money, actualCost);
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Cost is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost_givenSkuImplCostIsMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money cost = new Money();
    skuImpl.setCost(cost);

    // Act and Assert
    assertEquals(cost, skuImpl.getCost());
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Cost is {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost_givenSkuImplCostIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setCost(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getCost());
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualCost = skuImpl.getCost();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualCost);
  }

  /**
   * Test {@link SkuImpl#getCost()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getCost());
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
  public void testGetCost_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetCost_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getCost());
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
  public void testGetCost_thenThrowIllegalStateException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setCost(new Money());
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getCost());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#setCost(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#cost} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setCost(Money)}
   */
  @Test
  public void testSetCost_whenMoney_thenSkuImplCostIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money cost = new Money();

    // Act
    skuImpl.setCost(cost);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuImpl.cost);
    BigDecimal bigDecimal = skuImpl.cost;
    Money absResult = cost.abs();
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
    Money zeroResult = cost.zero();
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
   * Test {@link SkuImpl#setCost(Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#cost} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setCost(Money)}
   */
  @Test
  public void testSetCost_whenMoney_thenSkuImplCostIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setCost(mock(Money.class));

    // Assert
    assertNull(skuImpl.cost);
  }

  /**
   * Test {@link SkuImpl#setCost(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#cost} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setCost(Money)}
   */
  @Test
  public void testSetCost_whenNull_thenSkuImplCostIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setCost(null);

    // Assert
    assertNull(skuImpl.cost);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getMargin());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#divide(BigDecimal)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#divide(BigDecimal)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenMoneyDivideReturnMoney_thenCallsDivide() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    Money money2 = new Money();
    when(money.divide(Mockito.<BigDecimal>any())).thenReturn(money2);
    Money money3 = mock(Money.class);
    when(money3.subtract(Mockito.<Money>any())).thenReturn(money);
    when(money3.getAmount()).thenReturn(new BigDecimal("2.3"));
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getCost()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(money3);
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(money).divide(isA(BigDecimal.class));
    verify(money3, atLeast(1)).getAmount();
    verify(money3).subtract(isA(Money.class));
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    assertSame(money2, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#isZero()} return {@code true}.</li>
   *   <li>Then calls {@link Money#divide(BigDecimal)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenMoneyIsZeroReturnTrue_thenCallsDivide() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    Money money2 = new Money();
    when(money.divide(Mockito.<BigDecimal>any())).thenReturn(money2);
    Money money3 = mock(Money.class);
    when(money3.subtract(Mockito.<Money>any())).thenReturn(money);
    when(money3.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money money4 = mock(Money.class);
    when(money4.isZero()).thenReturn(true);
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getCost()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(money3);
    when(sku.getSalePrice()).thenReturn(money4);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(money).divide(isA(BigDecimal.class));
    verify(money3, atLeast(1)).getAmount();
    verify(money4).isZero();
    verify(money3).subtract(isA(Money.class));
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    assertSame(money2, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#lessThan(Money)} return
   * {@code false}.</li>
   *   <li>Then calls {@link Money#lessThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenMoneyLessThanReturnFalse_thenCallsLessThan() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    Money money2 = new Money();
    when(money.divide(Mockito.<BigDecimal>any())).thenReturn(money2);
    Money money3 = mock(Money.class);
    when(money3.subtract(Mockito.<Money>any())).thenReturn(money);
    when(money3.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money money4 = mock(Money.class);
    when(money4.subtract(Mockito.<Money>any())).thenReturn(new Money());
    when(money4.getAmount()).thenReturn(mock(InternalNumber.class));
    when(money4.isZero()).thenReturn(false);
    when(money4.lessThan(Mockito.<Money>any())).thenReturn(false);
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getCost()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(money3);
    when(sku.getSalePrice()).thenReturn(money4);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(money).divide(isA(BigDecimal.class));
    verify(money3, atLeast(1)).getAmount();
    verify(money4).isZero();
    verify(money4).lessThan(isA(Money.class));
    verify(money3).subtract(isA(Money.class));
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    assertSame(money2, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#lessThan(Money)} return
   * {@code true}.</li>
   *   <li>Then calls {@link Money#lessThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenMoneyLessThanReturnTrue_thenCallsLessThan() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(mock(Money.class));
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money money2 = mock(Money.class);
    when(money2.subtract(Mockito.<Money>any())).thenReturn(new Money());
    when(money2.getAmount()).thenReturn(new BigDecimal("2.3"));
    when(money2.isZero()).thenReturn(false);
    when(money2.lessThan(Mockito.<Money>any())).thenReturn(true);
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money3 = new Money();
    when(sku.getCost()).thenReturn(money3);
    when(sku.getRetailPrice()).thenReturn(money);
    when(sku.getSalePrice()).thenReturn(money2);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(money2, atLeast(1)).getAmount();
    verify(money2).isZero();
    verify(money2).lessThan(isA(Money.class));
    verify(money2).subtract(isA(Money.class));
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
    assertEquals(money3, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenMoneySubtractReturnMoney_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money2 = new Money();
    when(sku.getCost()).thenReturn(money2);
    when(sku.getRetailPrice()).thenReturn(money);
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(money, atLeast(1)).getAmount();
    verify(money).subtract(isA(Money.class));
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    assertEquals(money2, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenMoneySubtractThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenThrow(new IllegalStateException("foo"));
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getCost()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(money);
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getMargin());
    verify(money).getAmount();
    verify(money).subtract(isA(Money.class));
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenProductGetDefaultSkuReturnSkuImpl_thenReturnAbsIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    Money money = actualMargin.ZERO;
    assertEquals(money, actualMargin.abs());
    assertEquals(money, actualMargin.zero());
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenProductGetDefaultSkuReturnSkuImpl_thenReturnAbsIsZero2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    Money money = actualMargin.ZERO;
    assertEquals(money, actualMargin.abs());
    assertEquals(money, actualMargin.zero());
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getCost()} return {@code null}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenSkuGetCostReturnNull_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getCost()).thenReturn(null);
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenSkuGetRetailPriceReturnMoney_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getCost()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getRetailPrice()} return {@code null}.</li>
   *   <li>Then calls {@link Sku#getPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenSkuGetRetailPriceReturnNull_thenCallsGetPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getCost()).thenReturn(new Money());
    when(sku.getPrice()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(null);
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku).getPrice();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenSkuImplIdIsOne_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku, atLeast(1)).getId();
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenSkuImplRetailPriceIsMoneyWithAmountIsTen_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money(10.0d));

    // Act and Assert
    assertNull(skuImpl.getMargin());
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return abs is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_givenSkuImplSalePriceIsMoney_thenReturnAbsIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    Money money = actualMargin.ZERO;
    assertEquals(money, actualMargin.abs());
    assertEquals(money, actualMargin.zero());
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
  public void testGetMargin_givenSkuImpl_thenReturnAbsIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   *   <li>Then calls {@link Sku#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_thenCallsGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getCurrency()).thenThrow(new IllegalStateException("currency.default"));
    when(sku.getId()).thenReturn(1L);
    when(sku.getRetailPrice()).thenReturn(mock(Money.class));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getMargin());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCurrency();
    verify(sku, atLeast(1)).getId();
    verify(sku).getRetailPrice();
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs Amount is {@link SkuImpl}
   * (default constructor) {@link SkuImpl#cost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_thenReturnAbsAbsAbsAbsAbsAbsAbsAmountIsSkuImplCost() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setCost(new Money());

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    BigDecimal bigDecimal = skuImpl.cost;
    Money absResult = actualMargin.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualMargin.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult6.getAmount());
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
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult5.getAmount());
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
    assertSame(bigDecimal, absResult15.getAmount());
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
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs Amount is {@link SkuImpl}
   * (default constructor) {@link SkuImpl#retailPrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_thenReturnAbsAbsAbsAbsAbsAbsAbsAmountIsSkuImplRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money());

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    BigDecimal bigDecimal = skuImpl.retailPrice;
    Money absResult = actualMargin.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualMargin.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult6.getAmount());
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
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult5.getAmount());
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
    assertSame(bigDecimal, absResult15.getAmount());
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
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs Amount is {@link SkuImpl}
   * (default constructor) {@link SkuImpl#salePrice}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_thenReturnAbsAbsAbsAbsAbsAbsAbsAmountIsSkuImplSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    BigDecimal bigDecimal = skuImpl.salePrice;
    Money absResult = actualMargin.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualMargin.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult6.getAmount());
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
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult5.getAmount());
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
    assertSame(bigDecimal, absResult15.getAmount());
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
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link SkuImpl#getMargin()}.
   * <ul>
   *   <li>Then return zero Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin_thenReturnZeroAmountIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getCost()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(new Money(10.0d));
    when(sku.getSalePrice()).thenReturn(new Money());
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCost();
    verify(sku, atLeast(1)).getId();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku).getSalePrice();
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualMargin.zero();
    BigDecimal amount = zeroResult.getAmount();
    assertEquals(expectedAmount, amount);
    BigDecimal expectedAmount2 = new BigDecimal("1.00");
    assertEquals(expectedAmount2, actualMargin.getAmount());
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
    Money absResult6 = actualMargin.abs();
    Money zeroResult6 = absResult6.zero();
    Money absResult7 = zeroResult6.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    assertSame(amount2, absResult10.abs().getAmount());
    assertSame(amount2, absResult5.getAmount());
    Money absResult11 = absResult6.abs();
    Money zeroResult7 = absResult11.zero();
    Money absResult12 = zeroResult7.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    assertSame(amount2, absResult14.abs().getAmount());
    Money zeroResult8 = absResult.zero();
    Money absResult15 = zeroResult8.abs();
    Money absResult16 = absResult15.abs();
    Money absResult17 = absResult16.abs();
    assertSame(amount2, absResult17.abs().getAmount());
    assertSame(amount2, absResult10.getAmount());
    Money zeroResult9 = zeroResult6.zero();
    Money absResult18 = zeroResult9.abs();
    Money absResult19 = absResult18.abs();
    Money absResult20 = absResult19.abs();
    assertSame(amount2, absResult20.abs().getAmount());
    assertSame(amount2, absResult4.getAmount());
    Money absResult21 = absResult11.abs();
    Money zeroResult10 = absResult21.zero();
    Money absResult22 = zeroResult10.abs();
    Money absResult23 = absResult22.abs();
    assertSame(amount2, absResult23.abs().getAmount());
    Money zeroResult11 = absResult2.zero();
    Money absResult24 = zeroResult11.abs();
    Money absResult25 = absResult24.abs();
    assertSame(amount2, absResult25.abs().getAmount());
    assertSame(amount2, absResult14.getAmount());
    Money zeroResult12 = absResult7.zero();
    Money absResult26 = zeroResult12.abs();
    Money absResult27 = absResult26.abs();
    assertSame(amount2, absResult27.abs().getAmount());
    assertSame(amount2, absResult17.getAmount());
    assertSame(amount2, absResult9.getAmount());
    Money zeroResult13 = zeroResult7.zero();
    Money absResult28 = zeroResult13.abs();
    Money absResult29 = absResult28.abs();
    assertSame(amount2, absResult29.abs().getAmount());
    Money zeroResult14 = zeroResult8.zero();
    Money absResult30 = zeroResult14.abs();
    Money absResult31 = absResult30.abs();
    assertSame(amount2, absResult31.abs().getAmount());
    assertSame(amount2, absResult20.getAmount());
    Money zeroResult15 = zeroResult9.zero();
    Money absResult32 = zeroResult15.abs();
    Money absResult33 = absResult32.abs();
    assertSame(amount2, absResult33.abs().getAmount());
    assertSame(amount2, absResult3.getAmount());
    Money absResult34 = absResult21.abs();
    Money zeroResult16 = absResult34.zero();
    Money absResult35 = zeroResult16.abs();
    assertSame(amount2, absResult35.abs().getAmount());
    Money zeroResult17 = absResult3.zero();
    Money absResult36 = zeroResult17.abs();
    assertSame(amount2, absResult36.abs().getAmount());
    assertSame(amount2, absResult23.getAmount());
    Money zeroResult18 = absResult8.zero();
    Money absResult37 = zeroResult18.abs();
    assertSame(amount2, absResult37.abs().getAmount());
    assertSame(amount2, absResult25.getAmount());
    assertSame(amount2, absResult13.getAmount());
    Money zeroResult19 = absResult12.zero();
    Money absResult38 = zeroResult19.abs();
    assertSame(amount2, absResult38.abs().getAmount());
    Money zeroResult20 = absResult15.zero();
    Money absResult39 = zeroResult20.abs();
    assertSame(amount2, absResult39.abs().getAmount());
    assertSame(amount2, absResult27.getAmount());
    Money zeroResult21 = absResult18.zero();
    Money absResult40 = zeroResult21.abs();
    assertSame(amount2, absResult40.abs().getAmount());
    assertSame(amount2, absResult16.getAmount());
    assertSame(amount2, absResult8.getAmount());
    Money zeroResult22 = zeroResult10.zero();
    Money absResult41 = zeroResult22.abs();
    assertSame(amount2, absResult41.abs().getAmount());
    Money zeroResult23 = zeroResult11.zero();
    Money absResult42 = zeroResult23.abs();
    assertSame(amount2, absResult42.abs().getAmount());
    assertSame(amount2, absResult29.getAmount());
    Money zeroResult24 = zeroResult12.zero();
    Money absResult43 = zeroResult24.abs();
    assertSame(amount2, absResult43.abs().getAmount());
    assertSame(amount2, absResult31.getAmount());
    assertSame(amount2, absResult19.getAmount());
    Money zeroResult25 = zeroResult13.zero();
    Money absResult44 = zeroResult25.abs();
    assertSame(amount2, absResult44.abs().getAmount());
    Money zeroResult26 = zeroResult14.zero();
    Money absResult45 = zeroResult26.abs();
    assertSame(amount2, absResult45.abs().getAmount());
    assertSame(amount2, absResult33.getAmount());
    Money zeroResult27 = zeroResult15.zero();
    Money absResult46 = zeroResult27.abs();
    assertSame(amount2, absResult46.abs().getAmount());
    assertSame(amount2, absResult2.getAmount());
    Money absResult47 = absResult34.abs();
    Money zeroResult28 = absResult47.zero();
    assertSame(amount2, zeroResult28.abs().getAmount());
    Money zeroResult29 = absResult4.zero();
    assertSame(amount2, zeroResult29.abs().getAmount());
    assertSame(amount2, absResult35.getAmount());
    Money zeroResult30 = absResult9.zero();
    assertSame(amount2, zeroResult30.abs().getAmount());
    assertSame(amount2, absResult36.getAmount());
    assertSame(amount2, absResult22.getAmount());
    Money zeroResult31 = absResult13.zero();
    assertSame(amount2, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult16.zero();
    assertSame(amount2, zeroResult32.abs().getAmount());
    assertSame(amount2, absResult37.getAmount());
    Money zeroResult33 = absResult19.zero();
    assertSame(amount2, zeroResult33.abs().getAmount());
    assertSame(amount2, absResult24.getAmount());
    assertSame(amount2, absResult12.getAmount());
    Money zeroResult34 = absResult22.zero();
    assertSame(amount2, zeroResult34.abs().getAmount());
    Money zeroResult35 = absResult24.zero();
    assertSame(amount2, zeroResult35.abs().getAmount());
    assertSame(amount2, absResult38.getAmount());
    Money zeroResult36 = absResult26.zero();
    assertSame(amount2, zeroResult36.abs().getAmount());
    assertSame(amount2, absResult39.getAmount());
    assertSame(amount2, absResult26.getAmount());
    Money zeroResult37 = absResult28.zero();
    assertSame(amount2, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(amount2, zeroResult38.abs().getAmount());
    assertSame(amount2, absResult40.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(amount2, zeroResult39.abs().getAmount());
    assertSame(amount2, absResult15.getAmount());
    assertSame(amount2, absResult7.getAmount());
    Money zeroResult40 = zeroResult16.zero();
    assertSame(amount2, zeroResult40.abs().getAmount());
    Money zeroResult41 = zeroResult17.zero();
    assertSame(amount2, zeroResult41.abs().getAmount());
    assertSame(amount2, absResult41.getAmount());
    Money zeroResult42 = zeroResult18.zero();
    assertSame(amount2, zeroResult42.abs().getAmount());
    assertSame(amount2, absResult42.getAmount());
    assertSame(amount2, absResult28.getAmount());
    Money zeroResult43 = zeroResult19.zero();
    assertSame(amount2, zeroResult43.abs().getAmount());
    Money zeroResult44 = zeroResult20.zero();
    assertSame(amount2, zeroResult44.abs().getAmount());
    assertSame(amount2, absResult43.getAmount());
    Money zeroResult45 = zeroResult21.zero();
    assertSame(amount2, zeroResult45.abs().getAmount());
    assertSame(amount2, absResult30.getAmount());
    assertSame(amount2, absResult18.getAmount());
    Money zeroResult46 = zeroResult22.zero();
    assertSame(amount2, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult23.zero();
    assertSame(amount2, zeroResult47.abs().getAmount());
    assertSame(amount2, absResult44.getAmount());
    Money zeroResult48 = zeroResult24.zero();
    assertSame(amount2, zeroResult48.abs().getAmount());
    assertSame(amount2, absResult45.getAmount());
    assertSame(amount2, absResult32.getAmount());
    Money zeroResult49 = zeroResult25.zero();
    assertSame(amount2, zeroResult49.abs().getAmount());
    Money zeroResult50 = zeroResult26.zero();
    assertSame(amount2, zeroResult50.abs().getAmount());
    assertSame(amount2, absResult46.getAmount());
    Money zeroResult51 = zeroResult27.zero();
    assertSame(amount2, zeroResult51.abs().getAmount());
    assertSame(amount2, absResult.getAmount());
    assertSame(amount2, absResult47.abs().zero().getAmount());
    assertSame(amount2, absResult5.zero().getAmount());
    assertSame(amount2, zeroResult28.getAmount());
    assertSame(amount2, absResult10.zero().getAmount());
    assertSame(amount2, zeroResult29.getAmount());
    assertSame(amount2, zeroResult16.getAmount());
    assertSame(amount2, absResult14.zero().getAmount());
    assertSame(amount2, absResult17.zero().getAmount());
    assertSame(amount2, zeroResult30.getAmount());
    assertSame(amount2, absResult20.zero().getAmount());
    assertSame(amount2, zeroResult17.getAmount());
    assertSame(amount2, zeroResult10.getAmount());
    assertSame(amount2, absResult23.zero().getAmount());
    assertSame(amount2, absResult25.zero().getAmount());
    assertSame(amount2, zeroResult31.getAmount());
    assertSame(amount2, absResult27.zero().getAmount());
    assertSame(amount2, zeroResult32.getAmount());
    assertSame(amount2, zeroResult18.getAmount());
    assertSame(amount2, absResult29.zero().getAmount());
    assertSame(amount2, absResult31.zero().getAmount());
    assertSame(amount2, zeroResult33.getAmount());
    assertSame(amount2, absResult33.zero().getAmount());
    assertSame(amount2, zeroResult11.getAmount());
    assertSame(amount2, zeroResult7.getAmount());
    assertSame(amount2, absResult35.zero().getAmount());
    assertSame(amount2, absResult36.zero().getAmount());
    assertSame(amount2, zeroResult34.getAmount());
    assertSame(amount2, absResult37.zero().getAmount());
    assertSame(amount2, zeroResult35.getAmount());
    assertSame(amount2, zeroResult19.getAmount());
    assertSame(amount2, absResult38.zero().getAmount());
    assertSame(amount2, absResult39.zero().getAmount());
    assertSame(amount2, zeroResult36.getAmount());
    assertSame(amount2, absResult40.zero().getAmount());
    assertSame(amount2, zeroResult20.getAmount());
    assertSame(amount2, zeroResult12.getAmount());
    assertSame(amount2, absResult41.zero().getAmount());
    assertSame(amount2, absResult42.zero().getAmount());
    assertSame(amount2, zeroResult37.getAmount());
    assertSame(amount2, absResult43.zero().getAmount());
    assertSame(amount2, zeroResult38.getAmount());
    assertSame(amount2, zeroResult21.getAmount());
    assertSame(amount2, absResult44.zero().getAmount());
    assertSame(amount2, absResult45.zero().getAmount());
    assertSame(amount2, zeroResult39.getAmount());
    assertSame(amount2, absResult46.zero().getAmount());
    assertSame(amount2, zeroResult8.getAmount());
    assertSame(amount2, zeroResult6.getAmount());
    assertSame(amount2, zeroResult28.zero().getAmount());
    assertSame(amount2, zeroResult29.zero().getAmount());
    assertSame(amount2, zeroResult40.getAmount());
    assertSame(amount2, zeroResult30.zero().getAmount());
    assertSame(amount2, zeroResult41.getAmount());
    assertSame(amount2, zeroResult22.getAmount());
    assertSame(amount2, zeroResult31.zero().getAmount());
    assertSame(amount2, zeroResult32.zero().getAmount());
    assertSame(amount2, zeroResult42.getAmount());
    assertSame(amount2, zeroResult33.zero().getAmount());
    assertSame(amount2, zeroResult23.getAmount());
    assertSame(amount2, zeroResult13.getAmount());
    assertSame(amount2, zeroResult34.zero().getAmount());
    assertSame(amount2, zeroResult35.zero().getAmount());
    assertSame(amount2, zeroResult43.getAmount());
    assertSame(amount2, zeroResult36.zero().getAmount());
    assertSame(amount2, zeroResult44.getAmount());
    assertSame(amount2, zeroResult24.getAmount());
    assertSame(amount2, zeroResult37.zero().getAmount());
    assertSame(amount2, zeroResult38.zero().getAmount());
    assertSame(amount2, zeroResult45.getAmount());
    assertSame(amount2, zeroResult39.zero().getAmount());
    assertSame(amount2, zeroResult14.getAmount());
    assertSame(amount2, zeroResult9.getAmount());
    assertSame(amount2, zeroResult40.zero().getAmount());
    assertSame(amount2, zeroResult41.zero().getAmount());
    assertSame(amount2, zeroResult46.getAmount());
    assertSame(amount2, zeroResult42.zero().getAmount());
    assertSame(amount2, zeroResult47.getAmount());
    assertSame(amount2, zeroResult25.getAmount());
    assertSame(amount2, zeroResult43.zero().getAmount());
    assertSame(amount2, zeroResult44.zero().getAmount());
    assertSame(amount2, zeroResult48.getAmount());
    assertSame(amount2, zeroResult45.zero().getAmount());
    assertSame(amount2, zeroResult26.getAmount());
    assertSame(amount2, zeroResult15.getAmount());
    assertSame(amount2, zeroResult46.zero().getAmount());
    assertSame(amount2, zeroResult47.zero().getAmount());
    assertSame(amount2, zeroResult49.getAmount());
    assertSame(amount2, zeroResult48.zero().getAmount());
    assertSame(amount2, zeroResult50.getAmount());
    assertSame(amount2, zeroResult27.getAmount());
    assertSame(amount2, zeroResult49.zero().getAmount());
    assertSame(amount2, zeroResult50.zero().getAmount());
    assertSame(amount2, zeroResult51.getAmount());
    assertSame(amount2, zeroResult51.zero().getAmount());
    assertSame(amount2, amount2);
    assertSame(zeroResult5.getAmount(), zeroResult5.getAmount());
    BigDecimal amount3 = zeroResult4.getAmount();
    assertSame(amount3, zeroResult5.abs().getAmount());
    assertSame(amount3, amount3);
    BigDecimal amount4 = zeroResult3.getAmount();
    Money absResult48 = zeroResult4.abs();
    Money absResult49 = absResult48.abs();
    assertSame(amount4, absResult49.abs().getAmount());
    assertSame(amount4, absResult49.getAmount());
    assertSame(amount4, absResult48.getAmount());
    assertSame(amount4, absResult49.zero().getAmount());
    assertSame(amount4, absResult48.zero().getAmount());
    assertSame(amount4, amount4);
    BigDecimal amount5 = zeroResult2.getAmount();
    Money absResult50 = zeroResult3.abs();
    Money absResult51 = absResult50.abs();
    Money absResult52 = absResult51.abs();
    assertSame(amount5, absResult52.abs().getAmount());
    assertSame(amount5, absResult52.getAmount());
    Money zeroResult52 = absResult50.zero();
    Money absResult53 = zeroResult52.abs();
    assertSame(amount5, absResult53.abs().getAmount());
    assertSame(amount5, absResult51.getAmount());
    Money zeroResult53 = absResult51.zero();
    assertSame(amount5, zeroResult53.abs().getAmount());
    assertSame(amount5, absResult53.getAmount());
    Money zeroResult54 = zeroResult52.zero();
    assertSame(amount5, zeroResult54.abs().getAmount());
    assertSame(amount5, absResult50.getAmount());
    assertSame(amount5, absResult52.zero().getAmount());
    assertSame(amount5, zeroResult53.getAmount());
    assertSame(amount5, absResult53.zero().getAmount());
    assertSame(amount5, zeroResult52.getAmount());
    assertSame(amount5, zeroResult53.zero().getAmount());
    assertSame(amount5, zeroResult54.getAmount());
    assertSame(amount5, zeroResult54.zero().getAmount());
    assertSame(amount5, amount5);
    Money absResult54 = zeroResult2.abs();
    Money absResult55 = absResult54.abs();
    Money absResult56 = absResult55.abs();
    Money absResult57 = absResult56.abs();
    assertSame(amount, absResult57.abs().getAmount());
    assertSame(amount, absResult57.getAmount());
    Money zeroResult55 = absResult54.zero();
    Money absResult58 = zeroResult55.abs();
    Money absResult59 = absResult58.abs();
    assertSame(amount, absResult59.abs().getAmount());
    assertSame(amount, absResult56.getAmount());
    Money zeroResult56 = absResult55.zero();
    Money absResult60 = zeroResult56.abs();
    assertSame(amount, absResult60.abs().getAmount());
    assertSame(amount, absResult59.getAmount());
    Money zeroResult57 = zeroResult55.zero();
    Money absResult61 = zeroResult57.abs();
    assertSame(amount, absResult61.abs().getAmount());
    assertSame(amount, absResult55.getAmount());
    Money zeroResult58 = absResult56.zero();
    assertSame(amount, zeroResult58.abs().getAmount());
    assertSame(amount, absResult60.getAmount());
    Money zeroResult59 = absResult58.zero();
    assertSame(amount, zeroResult59.abs().getAmount());
    assertSame(amount, absResult58.getAmount());
    Money zeroResult60 = zeroResult56.zero();
    assertSame(amount, zeroResult60.abs().getAmount());
    assertSame(amount, absResult61.getAmount());
    Money zeroResult61 = zeroResult57.zero();
    assertSame(amount, zeroResult61.abs().getAmount());
    assertSame(amount, absResult54.getAmount());
    assertSame(amount, absResult57.zero().getAmount());
    assertSame(amount, zeroResult58.getAmount());
    assertSame(amount, absResult59.zero().getAmount());
    assertSame(amount, zeroResult56.getAmount());
    assertSame(amount, absResult60.zero().getAmount());
    assertSame(amount, zeroResult59.getAmount());
    assertSame(amount, absResult61.zero().getAmount());
    assertSame(amount, zeroResult55.getAmount());
    assertSame(amount, zeroResult58.zero().getAmount());
    assertSame(amount, zeroResult60.getAmount());
    assertSame(amount, zeroResult59.zero().getAmount());
    assertSame(amount, zeroResult57.getAmount());
    assertSame(amount, zeroResult60.zero().getAmount());
    assertSame(amount, zeroResult61.getAmount());
    assertSame(amount, zeroResult61.zero().getAmount());
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    String actualName = skuImpl.getName();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualName);
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    String actualName = skuImpl.getName();

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
  public void testGetName_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    String actualName = skuImpl.getName();

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
  public void testGetName_givenSkuGetNameReturnName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getName()).thenReturn("Name");
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    String actualName = skuImpl.getName();

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
  public void testGetName_givenSkuImplNameIsName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setName("name");

    // Act and Assert
    assertEquals("name", skuImpl.getName());
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getName());
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getName());
  }

  /**
   * Test {@link SkuImpl#getName()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName_givenSkuImplSalePriceIsMoney_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getName());
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
  public void testGetName_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetName_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getName());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals("The characteristics of someone or something", skuImpl.getDescription());
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    String actualDescription = skuImpl.getDescription();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualDescription);
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link Product#getDefaultSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription_givenProductGetDefaultSkuReturnSkuImpl_thenCallsGetDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    String actualDescription = skuImpl.getDescription();

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
  public void testGetDescription_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    String actualDescription = skuImpl.getDescription();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualDescription);
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getDescription());
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getDescription());
  }

  /**
   * Test {@link SkuImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription_givenSkuImplSalePriceIsMoney_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getDescription());
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
  public void testGetDescription_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetDescription_thenCallsGetDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getDescription()).thenReturn("The characteristics of someone or something");
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    String actualDescription = skuImpl.getDescription();

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
  public void testGetDescription_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getDescription());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_givenProductGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    String actualLongDescription = skuImpl.getLongDescription();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualLongDescription);
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link Product} {@link Product#getDefaultSku()} return
   * {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_givenProductGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    String actualLongDescription = skuImpl.getLongDescription();

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
  public void testGetLongDescription_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    String actualLongDescription = skuImpl.getLongDescription();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualLongDescription);
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getLongDescription());
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_givenSkuImplSalePriceIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getLongDescription());
  }

  /**
   * Test {@link SkuImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_givenSkuImplSalePriceIsMoney_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getLongDescription());
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
  public void testGetLongDescription_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetLongDescription_thenReturnLongDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setLongDescription("longDescription");

    // Act and Assert
    assertEquals("longDescription", skuImpl.getLongDescription());
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
  public void testGetLongDescription_thenReturnLongDescription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getLongDescription()).thenReturn("Long Description");
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    String actualLongDescription = skuImpl.getLongDescription();

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
  public void testGetLongDescription_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    Product product = mock(Product.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getLongDescription());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.isTaxable());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsTaxableResult = skuImpl.isTaxable();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualIsTaxableResult);
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsTaxableResult = skuImpl.isTaxable();

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
  public void testIsTaxable_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsTaxableResult = skuImpl.isTaxable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualIsTaxableResult);
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable_givenSkuGetIdThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.isTaxable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.isTaxable());
  }

  /**
   * Test {@link SkuImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Taxable is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable_givenSkuImplTaxableIsFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setTaxable(false);

    // Act and Assert
    assertFalse(skuImpl.isTaxable());
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
  public void testIsTaxable_givenSkuImplTaxableIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setTaxable(true);

    // Act and Assert
    assertTrue(skuImpl.isTaxable());
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
  public void testIsTaxable_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testIsTaxable_givenSkuIsTaxableReturnTrue_thenCallsIsTaxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsTaxableResult = skuImpl.isTaxable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).isTaxable();
    assertTrue(actualIsTaxableResult);
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getTaxable());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Boolean actualTaxable = skuImpl.getTaxable();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualTaxable);
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualTaxable = skuImpl.getTaxable();

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
  public void testGetTaxable_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualTaxable = skuImpl.getTaxable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualTaxable);
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable_givenSkuGetIdThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getTaxable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getTaxable());
  }

  /**
   * Test {@link SkuImpl#getTaxable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Taxable is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable_givenSkuImplTaxableIsFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setTaxable(false);

    // Act and Assert
    assertFalse(skuImpl.getTaxable());
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
  public void testGetTaxable_givenSkuImplTaxableIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setTaxable(true);

    // Act and Assert
    assertTrue(skuImpl.getTaxable());
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
  public void testGetTaxable_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetTaxable_givenSkuIsTaxableReturnTrue_thenCallsIsTaxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isTaxable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualTaxable = skuImpl.getTaxable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).isTaxable();
    assertTrue(actualTaxable);
  }

  /**
   * Test {@link SkuImpl#setTaxable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#taxable}
   * charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  public void testSetTaxable_givenSkuImplSalePriceIsMoney_thenSkuImplTaxableCharValueIsY() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act
    skuImpl.setTaxable(true);

    // Assert
    assertEquals('Y', skuImpl.taxable.charValue());
    assertTrue(skuImpl.getTaxable());
  }

  /**
   * Test {@link SkuImpl#setTaxable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#taxable}
   * charValue is {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  public void testSetTaxable_givenSkuImpl_whenFalse_thenSkuImplTaxableCharValueIsN() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setTaxable(false);

    // Assert
    assertEquals('N', skuImpl.taxable.charValue());
    assertFalse(skuImpl.getTaxable());
  }

  /**
   * Test {@link SkuImpl#setTaxable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) Taxable is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  public void testSetTaxable_givenSkuImpl_whenNull_thenSkuImplTaxableIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setTaxable(null);

    // Assert
    assertNull(skuImpl.getTaxable());
    assertNull(skuImpl.taxable);
  }

  /**
   * Test {@link SkuImpl#setTaxable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#taxable}
   * charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  public void testSetTaxable_givenSkuImpl_whenTrue_thenSkuImplTaxableCharValueIsY() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setTaxable(true);

    // Assert
    assertEquals('Y', skuImpl.taxable.charValue());
    assertTrue(skuImpl.getTaxable());
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.isDiscountable());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsDiscountableResult = skuImpl.isDiscountable();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualIsDiscountableResult);
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsDiscountableResult = skuImpl.isDiscountable();

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
  public void testIsDiscountable_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsDiscountableResult = skuImpl.isDiscountable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualIsDiscountableResult);
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable_givenSkuGetIdThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.isDiscountable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Discountable is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable_givenSkuImplDiscountableIsFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDiscountable(false);

    // Act and Assert
    assertFalse(skuImpl.isDiscountable());
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Discountable is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable_givenSkuImplDiscountableIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDiscountable(true);

    // Act and Assert
    assertTrue(skuImpl.isDiscountable());
  }

  /**
   * Test {@link SkuImpl#isDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.isDiscountable());
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
  public void testIsDiscountable_givenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testIsDiscountable_givenSkuIsDiscountableReturnTrue_thenCallsIsDiscountable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isDiscountable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsDiscountableResult = skuImpl.isDiscountable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).isDiscountable();
    assertTrue(actualIsDiscountableResult);
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getDiscountable());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Boolean actualDiscountable = skuImpl.getDiscountable();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualDiscountable);
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualDiscountable = skuImpl.getDiscountable();

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
  public void testGetDiscountable_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualDiscountable = skuImpl.getDiscountable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualDiscountable);
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable_givenSkuGetIdThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getDiscountable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Discountable is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable_givenSkuImplDiscountableIsFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDiscountable(false);

    // Act and Assert
    assertFalse(skuImpl.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Discountable is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable_givenSkuImplDiscountableIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDiscountable(true);

    // Act and Assert
    assertTrue(skuImpl.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#getDiscountable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.getDiscountable());
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
  public void testGetDiscountable_givenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetDiscountable_givenSkuIsDiscountableReturnTrue_thenCallsIsDiscountable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isDiscountable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualDiscountable = skuImpl.getDiscountable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).isDiscountable();
    assertTrue(actualDiscountable);
  }

  /**
   * Test {@link SkuImpl#setDiscountable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  public void testSetDiscountable_givenSkuImplSalePriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act
    skuImpl.setDiscountable(true);

    // Assert
    assertEquals('Y', skuImpl.discountable.charValue());
    assertTrue(skuImpl.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#setDiscountable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#discountable}
   * charValue is {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  public void testSetDiscountable_givenSkuImpl_whenFalse_thenSkuImplDiscountableCharValueIsN() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setDiscountable(false);

    // Assert
    assertEquals('N', skuImpl.discountable.charValue());
    assertFalse(skuImpl.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#setDiscountable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#discountable}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  public void testSetDiscountable_givenSkuImpl_whenNull_thenSkuImplDiscountableIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setDiscountable(null);

    // Assert
    assertNull(skuImpl.discountable);
    assertFalse(skuImpl.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#setDiscountable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#discountable}
   * charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  public void testSetDiscountable_givenSkuImpl_whenTrue_thenSkuImplDiscountableCharValueIsY() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setDiscountable(true);

    // Assert
    assertEquals('Y', skuImpl.discountable.charValue());
    assertTrue(skuImpl.getDiscountable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getInventoryType()} return
   * {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable_givenCategoryImplGetInventoryTypeReturnAlways_available() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualIsAvailableResult = skuImpl.isAvailable();

    // Assert
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertTrue(actualIsAvailableResult);
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getInventoryType()} return
   * {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable_givenCategoryImplGetInventoryTypeReturnUnavailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualIsAvailableResult = skuImpl.isAvailable();

    // Assert
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertFalse(actualIsAvailableResult);
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultCategory()}
   * return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable_givenProductBundleImplGetDefaultCategoryReturnCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualIsAvailableResult = skuImpl.isAvailable();

    // Assert
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertTrue(actualIsAvailableResult);
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Available is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable_givenSkuImplAvailableIsFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setAvailable(false);

    // Act and Assert
    assertFalse(skuImpl.isAvailable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Available is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable_givenSkuImplAvailableIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setAvailable(true);

    // Act and Assert
    assertTrue(skuImpl.isAvailable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) DefaultProduct is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable_givenSkuImplDefaultProductIsProductBundleImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.isAvailable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) InventoryType is
   * {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable_givenSkuImplInventoryTypeIsAlways_available_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    // Act and Assert
    assertTrue(skuImpl.isAvailable());
  }

  /**
   * Test {@link SkuImpl#isAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable_givenSkuImplProductIsProductBundleImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.isAvailable());
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
  public void testIsAvailable_givenSkuImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testIsAvailable_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.isAvailable());
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getInventoryType()} return
   * {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable_givenCategoryImplGetInventoryTypeReturnAlways_available() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualAvailable = skuImpl.getAvailable();

    // Assert
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertTrue(actualAvailable);
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getInventoryType()} return
   * {@link InventoryType#UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable_givenCategoryImplGetInventoryTypeReturnUnavailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenReturn(InventoryType.UNAVAILABLE);
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualAvailable = skuImpl.getAvailable();

    // Assert
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertFalse(actualAvailable);
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultCategory()}
   * return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable_givenProductBundleImplGetDefaultCategoryReturnCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    Boolean actualAvailable = skuImpl.getAvailable();

    // Assert
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertTrue(actualAvailable);
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Available is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable_givenSkuImplAvailableIsFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setAvailable(false);

    // Act and Assert
    assertFalse(skuImpl.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Available is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable_givenSkuImplAvailableIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setAvailable(true);

    // Act and Assert
    assertTrue(skuImpl.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) DefaultProduct is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable_givenSkuImplDefaultProductIsProductBundleImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) InventoryType is
   * {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable_givenSkuImplInventoryTypeIsAlways_available_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    // Act and Assert
    assertTrue(skuImpl.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getAvailable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable_givenSkuImplProductIsProductBundleImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.getAvailable());
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
  public void testGetAvailable_givenSkuImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetAvailable_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getAvailable());
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
  }

  /**
   * Test {@link SkuImpl#setAvailable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#available}
   * charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  public void testSetAvailable_givenSkuImplSalePriceIsMoney_thenSkuImplAvailableCharValueIsY() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act
    skuImpl.setAvailable(true);

    // Assert
    assertEquals('Y', skuImpl.available.charValue());
    assertTrue(skuImpl.getAvailable());
  }

  /**
   * Test {@link SkuImpl#setAvailable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#available}
   * charValue is {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  public void testSetAvailable_givenSkuImpl_whenFalse_thenSkuImplAvailableCharValueIsN() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setAvailable(false);

    // Assert
    assertEquals('N', skuImpl.available.charValue());
    assertFalse(skuImpl.getAvailable());
  }

  /**
   * Test {@link SkuImpl#setAvailable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#available} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  public void testSetAvailable_givenSkuImpl_whenNull_thenSkuImplAvailableIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setAvailable(null);

    // Assert
    assertNull(skuImpl.available);
    assertTrue(skuImpl.getAvailable());
  }

  /**
   * Test {@link SkuImpl#setAvailable(Boolean)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#available}
   * charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  public void testSetAvailable_givenSkuImpl_whenTrue_thenSkuImplAvailableCharValueIsY() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setAvailable(true);

    // Assert
    assertEquals('Y', skuImpl.available.charValue());
    assertTrue(skuImpl.getAvailable());
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Date actualActiveStartDate = skuImpl.getActiveStartDate();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualActiveStartDate);
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Date actualActiveStartDate = skuImpl.getActiveStartDate();

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
  public void testGetActiveStartDate_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Date actualActiveStartDate = skuImpl.getActiveStartDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualActiveStartDate);
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getActiveStartDate());
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
  public void testGetActiveStartDate_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetActiveStartDate_thenCallsGetActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getActiveStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    skuImpl.getActiveStartDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getActiveStartDate();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor)
   * {@link SkuImpl#activeStartDate}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate_thenReturnSkuImplActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveStartDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(skuImpl.activeStartDate, skuImpl.getActiveStartDate());
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
  public void testGetActiveStartDate_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getActiveStartDate());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Date actualActiveEndDate = skuImpl.getActiveEndDate();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualActiveEndDate);
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Date actualActiveEndDate = skuImpl.getActiveEndDate();

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
  public void testGetActiveEndDate_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Date actualActiveEndDate = skuImpl.getActiveEndDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualActiveEndDate);
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getActiveEndDate());
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
  public void testGetActiveEndDate_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetActiveEndDate_thenCallsGetActiveEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getActiveEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    skuImpl.getActiveEndDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getActiveEndDate();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getActiveEndDate()}.
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor)
   * {@link SkuImpl#activeEndDate}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate_thenReturnSkuImplActiveEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(skuImpl.activeEndDate, skuImpl.getActiveEndDate());
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
  public void testGetActiveEndDate_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getActiveEndDate());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getDimension()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDimension()}
   */
  @Test
  public void testGetDimension_givenSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act and Assert
    assertSame(skuImpl.dimension, skuImpl.getDimension());
  }

  /**
   * Test {@link SkuImpl#getDimension()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getDimension()}
   */
  @Test
  public void testGetDimension_givenSkuImplSalePriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertSame(skuImpl.dimension, skuImpl.getDimension());
  }

  /**
   * Test {@link SkuImpl#getWeight()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getWeight()}
   */
  @Test
  public void testGetWeight_givenSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act and Assert
    assertSame(skuImpl.weight, skuImpl.getWeight());
  }

  /**
   * Test {@link SkuImpl#getWeight()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getWeight()}
   */
  @Test
  public void testGetWeight_givenSkuImplSalePriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertSame(skuImpl.weight, skuImpl.getWeight());
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl.isActive());
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product},
   * {@code Category}.
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActiveWithProductCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product},
   * {@code Category}.
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActiveWithProductCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl.isActive(mock(Product.class), mock(Category.class)));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product},
   * {@code Category}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) ActiveEndDate is
   * {@link Date#Date()}.</li>
   *   <li>When {@link Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActiveWithProductCategory_givenSkuImplActiveEndDateIsDate_whenCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(new Date());
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl.isActive(mock(Product.class), mock(Category.class)));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product},
   * {@code Category}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActiveWithProductCategory_givenSkuImplSalePriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product},
   * {@code Category}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActiveWithProductCategory_givenSkuImpl_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product},
   * {@code Category}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@link Product}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActiveWithProductCategory_givenSkuImpl_whenProduct_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Product product = mock(Product.class);

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product},
   * {@code Category}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActiveWithProductCategory_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl.isActive(null, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product},
   * {@code Category}.
   * <ul>
   *   <li>When {@link Product}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActiveWithProductCategory_whenProduct_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Product product = mock(Product.class);

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive(Product, Category)} with {@code Product},
   * {@code Category}.
   * <ul>
   *   <li>When {@link Product}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActiveWithProductCategory_whenProduct_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Product product = mock(Product.class);

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#isActive()} return
   * {@code false}.</li>
   *   <li>Then calls {@link ProductImpl#isActive()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive_givenProductBundleImplIsActiveReturnFalse_thenCallsIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.isActive()).thenReturn(false);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    boolean actualIsActiveResult = skuImpl.isActive();

    // Assert
    verify(defaultProduct).isActive();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#isActive()} return
   * {@code true}.</li>
   *   <li>Then calls {@link ProductImpl#isActive()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive_givenProductBundleImplIsActiveReturnTrue_thenCallsIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.isActive()).thenReturn(true);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    boolean actualIsActiveResult = skuImpl.isActive();

    // Assert
    verify(defaultProduct).isActive();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive_givenSkuImplIdIsOne_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);

    // Act and Assert
    assertFalse(skuImpl.isActive());
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive_givenSkuImplSalePriceIsMoney_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertFalse(skuImpl.isActive());
  }

  /**
   * Test {@link SkuImpl#isActive()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive_givenSkuImplSalePriceIsMoney_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertFalse(skuImpl.isActive());
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
  public void testIsActive_givenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).isActive());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getSkuMedia());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is
   * {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.</li>
   *   <li>Then return {@code 42} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia_givenHashMap42IsSkuMediaXrefImpl_thenReturn42IsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, SkuMediaXref> stringSkuMediaXrefMap = new HashMap<>();
    stringSkuMediaXrefMap.put("42", new SkuMediaXrefImpl());
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getSkuMediaXref()).thenReturn(stringSkuMediaXrefMap);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl.getSkuMedia();

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
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl.getSkuMedia();

    // Assert
    verify(product).getDefaultSku();
    assertTrue(actualSkuMedia.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl.getSkuMedia();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertTrue(actualSkuMedia.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia_givenSkuGetIdThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getSkuMedia());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSkuMediaXref()} return
   * {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link Sku#getSkuMediaXref()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia_givenSkuGetSkuMediaXrefReturnHashMap_thenCallsGetSkuMediaXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getSkuMediaXref()).thenReturn(new HashMap<>());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl.getSkuMedia();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getSkuMediaXref();
    assertTrue(actualSkuMedia.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia_givenSkuImplIdIsOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl.getSkuMedia();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertTrue(actualSkuMedia.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia_givenSkuImplProductIsProductBundleImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.getSkuMedia().isEmpty());
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
  public void testGetSkuMedia_givenSkuImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getSkuMedia().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMedia()}.
   * <ul>
   *   <li>Then return {@code 42} is
   * {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia_thenReturn42IsCategoryMediaXrefImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuMediaXrefImpl skuMediaXrefImpl = mock(SkuMediaXrefImpl.class);
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    when(skuMediaXrefImpl.getMedia()).thenReturn(categoryMediaXrefImpl);

    HashMap<String, SkuMediaXref> stringSkuMediaXrefMap = new HashMap<>();
    stringSkuMediaXrefMap.put("42", skuMediaXrefImpl);
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getSkuMediaXref()).thenReturn(stringSkuMediaXrefMap);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Map<String, Media> actualSkuMedia = skuImpl.getSkuMedia();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getSkuMediaXref();
    verify(skuMediaXrefImpl).getMedia();
    assertEquals(1, actualSkuMedia.size());
    assertSame(categoryMediaXrefImpl, actualSkuMedia.get("42"));
  }

  /**
   * Test {@link SkuImpl#setSkuMedia(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSkuMedia(Map)}
   */
  @Test
  public void testSetSkuMedia_givenBiFunction_whenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashMap<String, Media> skuMedia = new HashMap<>();
    skuMedia.computeIfPresent("foo", mock(BiFunction.class));
    skuMedia.put("foo", new CategoryMediaXrefImpl());

    // Act
    skuImpl.setSkuMedia(skuMedia);

    // Assert
    assertEquals(1, skuImpl.skuMedia.size());
    assertEquals(skuMedia, skuImpl.getSkuMedia());
    Map<String, SkuMediaXref> expectedSkuMediaXref = skuImpl.skuMedia;
    assertSame(expectedSkuMediaXref, skuImpl.getSkuMediaXref());
  }

  /**
   * Test {@link SkuImpl#setSkuMedia(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#skuMedia} size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSkuMedia(Map)}
   */
  @Test
  public void testSetSkuMedia_givenFoo_thenSkuImplSkuMediaSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashMap<String, Media> skuMedia = new HashMap<>();
    skuMedia.put("foo", new CategoryMediaXrefImpl());

    // Act
    skuImpl.setSkuMedia(skuMedia);

    // Assert
    assertEquals(1, skuImpl.skuMedia.size());
    assertEquals(skuMedia, skuImpl.getSkuMedia());
    Map<String, SkuMediaXref> expectedSkuMediaXref = skuImpl.skuMedia;
    assertSame(expectedSkuMediaXref, skuImpl.getSkuMediaXref());
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
  public void testSetSkuMedia_whenHashMap_thenSkuImplSkuMediaEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setSkuMedia(new HashMap<>());

    // Assert
    assertTrue(skuImpl.getSkuMedia().isEmpty());
    assertTrue(skuImpl.getSkuMediaXref().isEmpty());
    assertTrue(skuImpl.skuMedia.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getSkuMediaXref());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl.getSkuMediaXref();

    // Assert
    verify(product).getDefaultSku();
    assertTrue(actualSkuMediaXref.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl.getSkuMediaXref();

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
  public void testGetSkuMediaXref_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl.getSkuMediaXref();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertTrue(actualSkuMediaXref.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref_givenSkuGetIdThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getSkuMediaXref());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXref()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref_givenSkuImplProductIsProductBundleImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.getSkuMediaXref().isEmpty());
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
  public void testGetSkuMediaXref_givenSkuImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetSkuMediaXref_thenCallsGetSkuMediaXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    when(sku.getSkuMediaXref()).thenReturn(new HashMap<>());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl.getSkuMediaXref();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getSkuMediaXref();
    assertTrue(actualSkuMediaXref.isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXrefIgnoreDefaultSku()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXrefIgnoreDefaultSku()}
   */
  @Test
  public void testGetSkuMediaXrefIgnoreDefaultSku_givenSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getSkuMediaXrefIgnoreDefaultSku().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuMediaXrefIgnoreDefaultSku()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuMediaXrefIgnoreDefaultSku()}
   */
  @Test
  public void testGetSkuMediaXrefIgnoreDefaultSku_givenSkuImplSalePriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertTrue(skuImpl.getSkuMediaXrefIgnoreDefaultSku().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getPrimarySkuMedia()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrimarySkuMedia()}
   */
  @Test
  public void testGetPrimarySkuMedia_givenSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getPrimarySkuMedia());
  }

  /**
   * Test {@link SkuImpl#getPrimarySkuMedia()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getPrimarySkuMedia()}
   */
  @Test
  public void testGetPrimarySkuMedia_givenSkuImplSalePriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getPrimarySkuMedia());
  }

  /**
   * Test {@link SkuImpl#isOrderedSkuMedia(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOrderedSkuMedia(Map)}
   */
  @Test
  public void testIsOrderedSkuMedia_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashMap<String, SkuMediaXref> skuMedia = new HashMap<>();
    skuMedia.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertFalse(skuImpl.isOrderedSkuMedia(skuMedia));
  }

  /**
   * Test {@link SkuImpl#isOrderedSkuMedia(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isOrderedSkuMedia(Map)}
   */
  @Test
  public void testIsOrderedSkuMedia_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act and Assert
    assertFalse(skuImpl.isOrderedSkuMedia(new HashMap<>()));
  }

  /**
   * Test {@link SkuImpl#sortSkuMedia(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#sortSkuMedia(Map)}
   */
  @Test
  public void testSortSkuMedia_givenBiFunction_whenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashMap<String, SkuMediaXref> skuMedia = new HashMap<>();
    skuMedia.computeIfPresent("foo", mock(BiFunction.class));
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMedia.put("foo", skuMediaXrefImpl);

    // Act
    Map<String, SkuMediaXref> actualSortSkuMediaResult = skuImpl.sortSkuMedia(skuMedia);

    // Assert
    assertEquals(1, actualSortSkuMediaResult.size());
    assertSame(skuMediaXrefImpl, actualSortSkuMediaResult.get(null));
  }

  /**
   * Test {@link SkuImpl#sortSkuMedia(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is
   * {@link SkuMediaXrefImpl#SkuMediaXrefImpl()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#sortSkuMedia(Map)}
   */
  @Test
  public void testSortSkuMedia_givenFoo_whenHashMapFooIsSkuMediaXrefImpl_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashMap<String, SkuMediaXref> skuMedia = new HashMap<>();
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl();
    skuMedia.put("foo", skuMediaXrefImpl);

    // Act
    Map<String, SkuMediaXref> actualSortSkuMediaResult = skuImpl.sortSkuMedia(skuMedia);

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
  public void testSortSkuMedia_whenHashMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act and Assert
    assertTrue(skuImpl.sortSkuMedia(new HashMap<>()).isEmpty());
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

    // Assert that nothing has changed
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
  public void testGetProduct_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetProduct_thenReturnProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    ProductBundleImpl defaultProduct = new ProductBundleImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertSame(defaultProduct, skuImpl.getProduct());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValuesCollection()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValuesCollection()}
   */
  @Test
  public void testGetProductOptionValuesCollection_givenSkuImplSalePriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertTrue(skuImpl.getProductOptionValuesCollection().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValuesCollection()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValuesCollection()}
   */
  @Test
  public void testGetProductOptionValuesCollection_givenSkuImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getProductOptionValuesCollection().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValuesCollection()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValuesCollection()}
   */
  @Test
  public void testGetProductOptionValuesCollection_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<SkuProductOptionValueXref> productOptionValueXrefs = new HashSet<>();
    productOptionValueXrefs.add(new SkuProductOptionValueXrefImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProductOptionValueXrefs(productOptionValueXrefs);

    // Act and Assert
    assertEquals(1, skuImpl.getProductOptionValuesCollection().size());
  }

  /**
   * Test {@link SkuImpl#setProductOptionValuesCollection(Set)}.
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  public void testSetProductOptionValuesCollection() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValues.add(productOptionValueImpl);

    // Act
    skuImpl.setProductOptionValuesCollection(productOptionValues);

    // Assert
    assertEquals(1, productOptionValues.size());
    List<ProductOptionValue> productOptionValues2 = skuImpl.getProductOptionValues();
    assertEquals(1, productOptionValues2.size());
    assertEquals(1, skuImpl.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl.legacyProductOptionValues.size());
    assertSame(productOptionValueImpl, productOptionValues2.get(0));
  }

  /**
   * Test {@link SkuImpl#setProductOptionValuesCollection(Set)}.
   * <ul>
   *   <li>Given {@link ProductOptionValueImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  public void testSetProductOptionValuesCollection_givenProductOptionValueImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();
    productOptionValues.add(mock(ProductOptionValueImpl.class));

    // Act
    skuImpl.setProductOptionValuesCollection(productOptionValues);

    // Assert
    assertEquals(1, productOptionValues.size());
    assertEquals(1, skuImpl.getProductOptionValues().size());
    assertEquals(1, skuImpl.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl.legacyProductOptionValues.size());
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
  public void testSetProductOptionValuesCollection_givenSkuImplNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setName("Name");

    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValues.add(productOptionValueImpl);

    // Act
    skuImpl.setProductOptionValuesCollection(productOptionValues);

    // Assert
    assertEquals(1, productOptionValues.size());
    List<ProductOptionValue> productOptionValues2 = skuImpl.getProductOptionValues();
    assertEquals(1, productOptionValues2.size());
    assertEquals(1, skuImpl.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl.legacyProductOptionValues.size());
    assertSame(productOptionValueImpl, productOptionValues2.get(0));
  }

  /**
   * Test {@link SkuImpl#setProductOptionValuesCollection(Set)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then {@link HashSet#HashSet()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  public void testSetProductOptionValuesCollection_givenSkuImpl_whenHashSet_thenHashSetEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();

    // Act
    skuImpl.setProductOptionValuesCollection(productOptionValues);

    // Assert
    assertTrue(productOptionValues.isEmpty());
    assertTrue(skuImpl.getProductOptionValues().isEmpty());
    assertTrue(skuImpl.getProductOptionValueXrefs().isEmpty());
    assertTrue(skuImpl.getProductOptionValuesCollection().isEmpty());
    assertTrue(skuImpl.legacyProductOptionValues.isEmpty());
  }

  /**
   * Test {@link SkuImpl#setProductOptionValuesCollection(Set)}.
   * <ul>
   *   <li>Then {@link HashSet#HashSet()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  public void testSetProductOptionValuesCollection_thenHashSetSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();
    productOptionValues.add(new ProductOptionValueImpl());
    productOptionValues.add(mock(ProductOptionValueImpl.class));

    // Act
    skuImpl.setProductOptionValuesCollection(productOptionValues);

    // Assert
    assertEquals(2, productOptionValues.size());
    assertEquals(2, skuImpl.getProductOptionValues().size());
    assertEquals(2, skuImpl.getProductOptionValueXrefs().size());
    assertEquals(2, skuImpl.getProductOptionValuesCollection().size());
    assertEquals(2, skuImpl.legacyProductOptionValues.size());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValues()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValues()}
   */
  @Test
  public void testGetProductOptionValues_givenSkuImplSalePriceIsMoney_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertTrue(skuImpl.getProductOptionValues().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValues()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValues()}
   */
  @Test
  public void testGetProductOptionValues_givenSkuImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getProductOptionValues().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getProductOptionValues()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getProductOptionValues()}
   */
  @Test
  public void testGetProductOptionValues_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<SkuProductOptionValueXref> productOptionValueXrefs = new HashSet<>();
    productOptionValueXrefs.add(new SkuProductOptionValueXrefImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProductOptionValueXrefs(productOptionValueXrefs);

    // Act
    List<ProductOptionValue> actualProductOptionValues = skuImpl.getProductOptionValues();

    // Assert
    assertEquals(1, actualProductOptionValues.size());
    assertNull(actualProductOptionValues.get(0));
  }

  /**
   * Test {@link SkuImpl#setProductOptionValues(List)}.
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  public void testSetProductOptionValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    ArrayList<ProductOptionValue> productOptionValues = new ArrayList<>();
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValues.add(productOptionValueImpl);
    productOptionValues.add(new ProductOptionValueImpl());

    // Act
    skuImpl.setProductOptionValues(productOptionValues);

    // Assert
    List<ProductOptionValue> productOptionValues2 = skuImpl.getProductOptionValues();
    assertEquals(1, productOptionValues2.size());
    assertEquals(1, skuImpl.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl.legacyProductOptionValues.size());
    assertSame(productOptionValueImpl, productOptionValues2.get(0));
  }

  /**
   * Test {@link SkuImpl#setProductOptionValues(List)}.
   * <ul>
   *   <li>Given {@link ProductOptionValueImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  public void testSetProductOptionValues_givenProductOptionValueImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    ArrayList<ProductOptionValue> productOptionValues = new ArrayList<>();
    productOptionValues.add(mock(ProductOptionValueImpl.class));

    // Act
    skuImpl.setProductOptionValues(productOptionValues);

    // Assert
    assertEquals(1, skuImpl.getProductOptionValues().size());
    assertEquals(1, skuImpl.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl.legacyProductOptionValues.size());
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
  public void testSetProductOptionValues_givenSkuImplNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setName("Name");

    ArrayList<ProductOptionValue> productOptionValues = new ArrayList<>();
    productOptionValues.add(new ProductOptionValueImpl());

    // Act
    skuImpl.setProductOptionValues(productOptionValues);

    // Assert
    assertEquals(1, skuImpl.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl.legacyProductOptionValues.size());
    assertEquals(productOptionValues, skuImpl.getProductOptionValues());
  }

  /**
   * Test {@link SkuImpl#setProductOptionValues(List)}.
   * <ul>
   *   <li>Then {@link SkuImpl} (default constructor) ProductOptionValues is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  public void testSetProductOptionValues_thenSkuImplProductOptionValuesIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    ArrayList<ProductOptionValue> productOptionValues = new ArrayList<>();
    productOptionValues.add(new ProductOptionValueImpl());

    // Act
    skuImpl.setProductOptionValues(productOptionValues);

    // Assert
    assertEquals(1, skuImpl.getProductOptionValueXrefs().size());
    assertEquals(1, skuImpl.getProductOptionValuesCollection().size());
    assertEquals(1, skuImpl.legacyProductOptionValues.size());
    assertEquals(productOptionValues, skuImpl.getProductOptionValues());
  }

  /**
   * Test {@link SkuImpl#setProductOptionValues(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) ProductOptionValues
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  public void testSetProductOptionValues_whenArrayList_thenSkuImplProductOptionValuesEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setProductOptionValues(new ArrayList<>());

    // Assert
    assertTrue(skuImpl.getProductOptionValues().isEmpty());
    assertTrue(skuImpl.getProductOptionValueXrefs().isEmpty());
    assertTrue(skuImpl.getProductOptionValuesCollection().isEmpty());
    assertTrue(skuImpl.legacyProductOptionValues.isEmpty());
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.isMachineSortable());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsMachineSortableResult = skuImpl.isMachineSortable();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualIsMachineSortableResult);
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsMachineSortableResult = skuImpl.isMachineSortable();

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
  public void testIsMachineSortable_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsMachineSortableResult = skuImpl.isMachineSortable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualIsMachineSortableResult);
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable_givenSkuGetIdThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.isMachineSortable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) MachineSortable is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable_givenSkuImplMachineSortableIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setMachineSortable(true);

    // Act and Assert
    assertTrue(skuImpl.isMachineSortable());
  }

  /**
   * Test {@link SkuImpl#isMachineSortable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.isMachineSortable());
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
  public void testIsMachineSortable_givenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testIsMachineSortable_thenCallsIsMachineSortable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isMachineSortable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsMachineSortableResult = skuImpl.isMachineSortable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).isMachineSortable();
    assertTrue(actualIsMachineSortableResult);
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getIsMachineSortable());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable_givenProductBundleImplGetDefaultSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsMachineSortable = skuImpl.getIsMachineSortable();

    // Assert
    verify(product).getDefaultSku();
    assertFalse(actualIsMachineSortable);
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable_givenProductBundleImplGetDefaultSkuReturnSkuImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsMachineSortable = skuImpl.getIsMachineSortable();

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
  public void testGetIsMachineSortable_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsMachineSortable = skuImpl.getIsMachineSortable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertFalse(actualIsMachineSortable);
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable_givenSkuGetIdThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getIsMachineSortable());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) MachineSortable is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable_givenSkuImplMachineSortableIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setMachineSortable(true);

    // Act and Assert
    assertTrue(skuImpl.getIsMachineSortable());
  }

  /**
   * Test {@link SkuImpl#getIsMachineSortable()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.getIsMachineSortable());
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
  public void testGetIsMachineSortable_givenSkuImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetIsMachineSortable_thenCallsGetIsMachineSortable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getIsMachineSortable()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Boolean actualIsMachineSortable = skuImpl.getIsMachineSortable();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    verify(sku).getIsMachineSortable();
    assertTrue(actualIsMachineSortable);
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getInventoryType()} return
   * {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType_givenCategoryImplGetInventoryTypeReturnAlways_available() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenReturn(InventoryType.ALWAYS_AVAILABLE);
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    InventoryType actualInventoryType = skuImpl.getInventoryType();

    // Assert
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertSame(actualInventoryType.ALWAYS_AVAILABLE, actualInventoryType);
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultCategory()}
   * return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType_givenProductBundleImplGetDefaultCategoryReturnCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    InventoryType actualInventoryType = skuImpl.getInventoryType();

    // Assert
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertNull(actualInventoryType);
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) DefaultProduct is
   * {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType_givenSkuImplDefaultProductIsProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getInventoryType());
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) InventoryType is
   * {@link InventoryType#ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType_givenSkuImplInventoryTypeIsAlways_available() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    // Act
    InventoryType actualInventoryType = skuImpl.getInventoryType();

    // Assert
    assertSame(actualInventoryType.ALWAYS_AVAILABLE, actualInventoryType);
  }

  /**
   * Test {@link SkuImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getInventoryType());
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
  public void testGetInventoryType_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetInventoryType_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getInventoryType()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getInventoryType());
    verify(categoryImpl).getInventoryType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
  }

  /**
   * Test {@link SkuImpl#setInventoryType(InventoryType)}.
   * <ul>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#inventoryType}
   * is {@code ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setInventoryType(InventoryType)}
   */
  @Test
  public void testSetInventoryType_thenSkuImplInventoryTypeIsAlwaysAvailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    InventoryType inventoryType = InventoryType.ALWAYS_AVAILABLE;

    // Act
    skuImpl.setInventoryType(inventoryType);

    // Assert
    assertEquals("ALWAYS_AVAILABLE", skuImpl.inventoryType);
    InventoryType expectedInventoryType = inventoryType.ALWAYS_AVAILABLE;
    assertSame(expectedInventoryType, skuImpl.getInventoryType());
  }

  /**
   * Test {@link SkuImpl#setInventoryType(InventoryType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#inventoryType}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setInventoryType(InventoryType)}
   */
  @Test
  public void testSetInventoryType_whenNull_thenSkuImplInventoryTypeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setInventoryType(null);

    // Assert
    assertNull(skuImpl.inventoryType);
    assertNull(skuImpl.getInventoryType());
  }

  /**
   * Test {@link SkuImpl#getFulfillmentType()}.
   * <p>
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    FulfillmentType actualFulfillmentType = skuImpl.getFulfillmentType();

    // Assert
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertNull(actualFulfillmentType);
  }

  /**
   * Test {@link SkuImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) DefaultProduct is
   * {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType_givenSkuImplDefaultProductIsProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getFulfillmentType());
  }

  /**
   * Test {@link SkuImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) FulfillmentType is
   * {@link FulfillmentType#DIGITAL}.</li>
   *   <li>Then return {@link FulfillmentType#DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType_givenSkuImplFulfillmentTypeIsDigital_thenReturnDigital() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setFulfillmentType(FulfillmentType.DIGITAL);

    // Act
    FulfillmentType actualFulfillmentType = skuImpl.getFulfillmentType();

    // Assert
    assertSame(actualFulfillmentType.DIGITAL, actualFulfillmentType);
  }

  /**
   * Test {@link SkuImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getFulfillmentType());
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
  public void testGetFulfillmentType_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetFulfillmentType_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFulfillmentType()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getFulfillmentType());
    verify(categoryImpl).getFulfillmentType();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
  }

  /**
   * Test {@link SkuImpl#setFulfillmentType(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#DIGITAL}.</li>
   *   <li>Then {@link SkuImpl} (default constructor)
   * {@link SkuImpl#fulfillmentType} is {@code DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  public void testSetFulfillmentType_whenDigital_thenSkuImplFulfillmentTypeIsDigital() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    FulfillmentType fulfillmentType = FulfillmentType.DIGITAL;

    // Act
    skuImpl.setFulfillmentType(fulfillmentType);

    // Assert
    assertEquals("DIGITAL", skuImpl.fulfillmentType);
    FulfillmentType expectedFulfillmentType = fulfillmentType.DIGITAL;
    assertSame(expectedFulfillmentType, skuImpl.getFulfillmentType());
  }

  /**
   * Test {@link SkuImpl#setFulfillmentType(FulfillmentType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SkuImpl} (default constructor)
   * {@link SkuImpl#fulfillmentType} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  public void testSetFulfillmentType_whenNull_thenSkuImplFulfillmentTypeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setFulfillmentType(null);

    // Assert that nothing has changed
    assertNull(skuImpl.fulfillmentType);
    assertNull(skuImpl.getFulfillmentType());
  }

  /**
   * Test {@link SkuImpl#getSkuAttributes()}.
   * <p>
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  public void testGetSkuAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, SkuAttribute> skuAttributes = new HashMap<>();
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributes.put("ThreadLocalManager.notify.orphans", skuAttributeImpl);
    skuAttributes.put("foo", new SkuAttributeImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSkuAttributes(skuAttributes);

    // Act
    Map<String, SkuAttribute> actualSkuAttributes = skuImpl.getSkuAttributes();

    // Assert
    assertEquals(1, actualSkuAttributes.size());
    assertSame(skuAttributeImpl, actualSkuAttributes.get(null));
  }

  /**
   * Test {@link SkuImpl#getSkuAttributes()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  public void testGetSkuAttributes_givenSkuImplSalePriceIsMoney_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertTrue(skuImpl.getSkuAttributes().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuAttributes()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  public void testGetSkuAttributes_givenSkuImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getSkuAttributes().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getSkuAttributes()}.
   * <ul>
   *   <li>Then return containsKey {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  public void testGetSkuAttributes_thenReturnContainsKeyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuAttributeImpl skuAttributeImpl = mock(SkuAttributeImpl.class);
    when(skuAttributeImpl.getName()).thenReturn("Name");

    HashMap<String, SkuAttribute> skuAttributes = new HashMap<>();
    skuAttributes.put("foo", skuAttributeImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSkuAttributes(skuAttributes);

    // Act
    Map<String, SkuAttribute> actualSkuAttributes = skuImpl.getSkuAttributes();

    // Assert
    verify(skuAttributeImpl).getName();
    assertEquals(1, actualSkuAttributes.size());
    assertTrue(actualSkuAttributes.containsKey("Name"));
  }

  /**
   * Test {@link SkuImpl#getSkuAttributes()}.
   * <ul>
   *   <li>Then return {@code null} is {@link SkuAttributeImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  public void testGetSkuAttributes_thenReturnNullIsSkuAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, SkuAttribute> skuAttributes = new HashMap<>();
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributes.put("foo", skuAttributeImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSkuAttributes(skuAttributes);

    // Act
    Map<String, SkuAttribute> actualSkuAttributes = skuImpl.getSkuAttributes();

    // Assert
    assertEquals(1, actualSkuAttributes.size());
    assertSame(skuAttributeImpl, actualSkuAttributes.get(null));
  }

  /**
   * Test {@link SkuImpl#getMultiValueSkuAttributes()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  public void testGetMultiValueSkuAttributes_givenSkuImplSalePriceIsMoney_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertTrue(skuImpl.getMultiValueSkuAttributes().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getMultiValueSkuAttributes()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  public void testGetMultiValueSkuAttributes_givenSkuImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getMultiValueSkuAttributes().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getMultiValueSkuAttributes()}.
   * <ul>
   *   <li>Then return {@code Name} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  public void testGetMultiValueSkuAttributes_thenReturnNameSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuAttributeImpl skuAttributeImpl = mock(SkuAttributeImpl.class);
    when(skuAttributeImpl.getName()).thenReturn("Name");

    HashMap<String, SkuAttribute> skuAttributes = new HashMap<>();
    skuAttributes.put("foo", skuAttributeImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSkuAttributes(skuAttributes);

    // Act
    Map<String, Collection<SkuAttribute>> actualMultiValueSkuAttributes = skuImpl.getMultiValueSkuAttributes();

    // Assert
    verify(skuAttributeImpl).getName();
    assertEquals(1, actualMultiValueSkuAttributes.size());
    Collection<SkuAttribute> getResult = actualMultiValueSkuAttributes.get("Name");
    assertEquals(1, getResult.size());
    assertTrue(getResult instanceof List);
  }

  /**
   * Test {@link SkuImpl#getMultiValueSkuAttributes()}.
   * <ul>
   *   <li>Then return {@code null} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  public void testGetMultiValueSkuAttributes_thenReturnNullSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, SkuAttribute> skuAttributes = new HashMap<>();
    skuAttributes.put("foo", new SkuAttributeImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSkuAttributes(skuAttributes);

    // Act
    Map<String, Collection<SkuAttribute>> actualMultiValueSkuAttributes = skuImpl.getMultiValueSkuAttributes();

    // Assert
    assertEquals(1, actualMultiValueSkuAttributes.size());
    Collection<SkuAttribute> getResult = actualMultiValueSkuAttributes.get(null);
    assertEquals(1, getResult.size());
    assertTrue(getResult instanceof List);
    SkuAttribute getResult2 = ((List<SkuAttribute>) getResult).get(0);
    assertTrue(getResult2 instanceof SkuAttributeImpl);
    assertNull(getResult2.getId());
    assertNull(getResult2.toString());
    assertNull(getResult2.getValue());
    assertNull(getResult2.getName());
    assertNull(((SkuAttributeImpl) getResult2).name);
    assertNull(getResult2.getSku());
  }

  /**
   * Test {@link SkuImpl#getMultiValueSkuAttributes()}.
   * <ul>
   *   <li>Then return {@code null} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  public void testGetMultiValueSkuAttributes_thenReturnNullSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, SkuAttribute> skuAttributes = new HashMap<>();
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributes.put("ThreadLocalManager.notify.orphans", skuAttributeImpl);
    skuAttributes.put("foo", new SkuAttributeImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSkuAttributes(skuAttributes);

    // Act
    Map<String, Collection<SkuAttribute>> actualMultiValueSkuAttributes = skuImpl.getMultiValueSkuAttributes();

    // Assert
    assertEquals(1, actualMultiValueSkuAttributes.size());
    Collection<SkuAttribute> getResult = actualMultiValueSkuAttributes.get(null);
    assertEquals(2, getResult.size());
    assertTrue(getResult instanceof List);
    assertTrue(((List<SkuAttribute>) getResult).get(0) instanceof SkuAttributeImpl);
    assertSame(skuAttributeImpl, ((List<SkuAttribute>) getResult).get(1));
  }

  /**
   * Test {@link SkuImpl#setSkuAttributes(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSkuAttributes(Map)}
   */
  @Test
  public void testSetSkuAttributes_givenBiFunction_whenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashMap<String, SkuAttribute> skuAttributes = new HashMap<>();
    skuAttributes.computeIfPresent("foo", mock(BiFunction.class));
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributes.put("foo", skuAttributeImpl);

    // Act
    skuImpl.setSkuAttributes(skuAttributes);

    // Assert
    List<SkuAttribute> skuAttributeList = skuImpl.skuAttributes;
    assertEquals(1, skuAttributeList.size());
    Map<String, Collection<SkuAttribute>> multiValueSkuAttributes = skuImpl.getMultiValueSkuAttributes();
    assertEquals(1, multiValueSkuAttributes.size());
    Map<String, SkuAttribute> skuAttributes2 = skuImpl.getSkuAttributes();
    assertEquals(1, skuAttributes2.size());
    List<SkuAttribute> expectedGetResult = skuImpl.skuAttributes;
    assertEquals(expectedGetResult, multiValueSkuAttributes.get(null));
    assertSame(skuAttributeImpl, skuAttributeList.get(0));
    assertSame(skuAttributeImpl, skuAttributes2.get(null));
  }

  /**
   * Test {@link SkuImpl#setSkuAttributes(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#skuAttributes}
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSkuAttributes(Map)}
   */
  @Test
  public void testSetSkuAttributes_givenFoo_thenSkuImplSkuAttributesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashMap<String, SkuAttribute> skuAttributes = new HashMap<>();
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributes.put("foo", skuAttributeImpl);

    // Act
    skuImpl.setSkuAttributes(skuAttributes);

    // Assert
    List<SkuAttribute> skuAttributeList = skuImpl.skuAttributes;
    assertEquals(1, skuAttributeList.size());
    Map<String, Collection<SkuAttribute>> multiValueSkuAttributes = skuImpl.getMultiValueSkuAttributes();
    assertEquals(1, multiValueSkuAttributes.size());
    Map<String, SkuAttribute> skuAttributes2 = skuImpl.getSkuAttributes();
    assertEquals(1, skuAttributes2.size());
    List<SkuAttribute> expectedGetResult = skuImpl.skuAttributes;
    assertEquals(expectedGetResult, multiValueSkuAttributes.get(null));
    assertSame(skuAttributeImpl, skuAttributeList.get(0));
    assertSame(skuAttributeImpl, skuAttributes2.get(null));
  }

  /**
   * Test {@link SkuImpl#setSkuAttributes(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link SkuImpl} (default constructor) {@link SkuImpl#skuAttributes}
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#setSkuAttributes(Map)}
   */
  @Test
  public void testSetSkuAttributes_whenHashMap_thenSkuImplSkuAttributesEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setSkuAttributes(new HashMap<>());

    // Assert
    assertTrue(skuImpl.skuAttributes.isEmpty());
    assertTrue(skuImpl.getMultiValueSkuAttributes().isEmpty());
    assertTrue(skuImpl.getSkuAttributes().isEmpty());
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenThrow(new IllegalStateException("foo"));

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getCurrency());
    verify(product).getDefaultSku();
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(product);

    // Act
    BroadleafCurrency actualCurrency = skuImpl.getCurrency();

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualCurrency);
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultSku()}
   * return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_givenProductBundleImplGetDefaultSkuReturnSkuImpl_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    BroadleafCurrency actualCurrency = skuImpl.getCurrency();

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
  public void testGetCurrency_givenSkuGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act
    BroadleafCurrency actualCurrency = skuImpl.getCurrency();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
    assertNull(actualCurrency);
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} throw
   * {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_givenSkuGetIdThrowIllegalStateExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);
    skuImpl.setProduct(product);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getCurrency());
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getId();
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Currency is
   * {@link BroadleafCurrencyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_givenSkuImplCurrencyIsBroadleafCurrencyImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    skuImpl.setCurrency(currency);

    // Act and Assert
    assertSame(currency, skuImpl.getCurrency());
  }

  /**
   * Test {@link SkuImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getCurrency());
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
  public void testGetCurrency_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetCurrency_thenCallsGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    when(sku.getCurrency()).thenReturn(broadleafCurrencyImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    BroadleafCurrency actualCurrency = skuImpl.getCurrency();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getCurrency();
    verify(sku).getId();
    assertSame(broadleafCurrencyImpl, actualCurrency);
  }

  /**
   * Test {@link SkuImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} {@link ProductImpl#getDefaultCategory()}
   * return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode_givenProductBundleImplGetDefaultCategoryReturnCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act
    String actualTaxCode = skuImpl.getTaxCode();

    // Assert
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
    assertNull(actualTaxCode);
  }

  /**
   * Test {@link SkuImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) DefaultProduct is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode_givenSkuImplDefaultProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getTaxCode());
  }

  /**
   * Test {@link SkuImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getTaxCode());
  }

  /**
   * Test {@link SkuImpl#getTaxCode()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) TaxCode is
   * {@code Tax Code}.</li>
   *   <li>Then return {@code Tax Code}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode_givenSkuImplTaxCodeIsTaxCode_thenReturnTaxCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setTaxCode("Tax Code");

    // Act and Assert
    assertEquals("Tax Code", skuImpl.getTaxCode());
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
  public void testGetTaxCode_givenSkuImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetTaxCode_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getTaxCode()).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl defaultProduct = mock(ProductBundleImpl.class);
    when(defaultProduct.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> skuImpl.getTaxCode());
    verify(categoryImpl).getTaxCode();
    verify(defaultProduct, atLeast(1)).getDefaultCategory();
  }

  /**
   * Test {@link SkuImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link SkuImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Sku> actualCreateOrRetrieveCopyInstanceResult = skuImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SkuImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then Clone return {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenJavaLangObject_thenCloneReturnSkuImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<Sku> actualCreateOrRetrieveCopyInstanceResult = skuImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.SkuImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    Sku clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof SkuImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(skuImpl, clone);
  }
}
