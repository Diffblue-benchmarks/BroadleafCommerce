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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
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
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).isOnSale());
  }

  /**
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertFalse(skuImpl.isOnSale());
  }

  /**
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money());

    // Act and Assert
    assertFalse(skuImpl.isOnSale());
  }

  /**
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.isOnSale());
  }

  /**
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertFalse(skuImpl.isOnSale());
  }

  /**
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale6() {
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
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale7() {
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
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale8() {
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
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale9() {
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
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale10() {
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
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale11() {
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
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale12() {
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
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale13() {
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
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale14() {
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
   * Method under test: {@link SkuImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale15() {
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
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).hasDefaultSku());
  }

  /**
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.hasDefaultSku());
  }

  /**
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku3() {
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
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku4() {
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
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku5() {
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
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku6() {
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
   * Method under test: {@link SkuImpl#hasDefaultSku()}
   */
  @Test
  public void testHasDefaultSku7() {
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
   * Method under test: {@link SkuImpl#lookupDefaultSku()}
   */
  @Test
  public void testLookupDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).lookupDefaultSku());
  }

  /**
   * Method under test: {@link SkuImpl#lookupDefaultSku()}
   */
  @Test
  public void testLookupDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.lookupDefaultSku());
  }

  /**
   * Method under test: {@link SkuImpl#lookupDefaultSku()}
   */
  @Test
  public void testLookupDefaultSku3() {
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
   * Method under test: {@link SkuImpl#lookupDefaultSku()}
   */
  @Test
  public void testLookupDefaultSku4() {
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
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getProductOptionValueAdjustments());
  }

  /**
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getProductOptionValueAdjustments());
  }

  /**
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments3() {
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
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments4() {
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
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments5() {
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
   * Method under test: {@link SkuImpl#getProductOptionValueAdjustments()}
   */
  @Test
  public void testGetProductOptionValueAdjustments6() {
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
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money salePrice = new Money();
    skuImpl.setSalePrice(salePrice);

    // Act and Assert
    assertEquals(salePrice, skuImpl.getSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice5() {
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
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice6() {
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
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice7() {
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
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice8() {
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
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice9() {
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
   * Method under test: {@link SkuImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice10() {
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
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).hasSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertTrue(skuImpl.hasSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.hasSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertFalse(skuImpl.hasSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice5() {
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
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice6() {
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
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice7() {
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
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice8() {
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
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice9() {
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
   * Method under test: {@link SkuImpl#hasSalePrice()}
   */
  @Test
  public void testHasSalePrice10() {
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
   * Method under test: {@link SkuImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money salePrice = new Money();

    // Act
    skuImpl.setSalePrice(salePrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = salePrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), skuImpl.salePrice);
    assertEquals(salePrice, salePrice.abs());
    assertEquals(salePrice, salePrice.zero());
    assertSame(skuImpl.salePrice, amount);
  }

  /**
   * Method under test: {@link SkuImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setSalePrice(null);

    // Assert
    assertNull(skuImpl.salePrice);
  }

  /**
   * Method under test: {@link SkuImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setSalePrice(mock(Money.class));

    // Assert
    assertNull(skuImpl.salePrice);
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl.getRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice6() {
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
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice7() {
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
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice8() {
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
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice9() {
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
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice10() {
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
   * Method under test: {@link SkuImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice11() {
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
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getRetailPriceInternal());
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getRetailPriceInternal());
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl.getRetailPriceInternal());
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getRetailPriceInternal());
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getRetailPriceInternal());
  }

  /**
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal6() {
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
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal7() {
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
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal8() {
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
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal9() {
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
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal10() {
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
   * Method under test: {@link SkuImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal11() {
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
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getBaseRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl.getBaseRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getBaseRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getBaseRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice5() {
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
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice6() {
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
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice7() {
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
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice8() {
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
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice9() {
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
   * Method under test: {@link SkuImpl#getBaseRetailPrice()}
   */
  @Test
  public void testGetBaseRetailPrice10() {
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
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getBaseSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money salePrice = new Money();
    skuImpl.setSalePrice(salePrice);

    // Act and Assert
    assertEquals(salePrice, skuImpl.getBaseSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getBaseSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getBaseSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice5() {
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
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice6() {
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
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice7() {
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
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice8() {
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
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice9() {
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
   * Method under test: {@link SkuImpl#getBaseSalePrice()}
   */
  @Test
  public void testGetBaseSalePrice10() {
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
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  public void testGetPriceData() {
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
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  public void testGetPriceData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money salePrice = new Money();
    skuImpl.setSalePrice(salePrice);

    // Act
    DynamicSkuPrices actualPriceData = skuImpl.getPriceData();

    // Assert
    assertNull(actualPriceData.getPriceAdjustment());
    assertNull(actualPriceData.getRetailPrice());
    assertFalse(actualPriceData.getDidOverride());
    Money price = actualPriceData.getPrice();
    assertEquals(salePrice, price);
    assertSame(price, actualPriceData.getSalePrice());
  }

  /**
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  public void testGetPriceData3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act
    DynamicSkuPrices actualPriceData = skuImpl.getPriceData();

    // Assert
    assertNull(actualPriceData.getPriceAdjustment());
    assertNull(actualPriceData.getSalePrice());
    assertFalse(actualPriceData.getDidOverride());
    Money price = actualPriceData.getPrice();
    assertEquals(retailPrice, price);
    assertSame(price, actualPriceData.getRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  public void testGetPriceData4() {
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
   * Method under test: {@link SkuImpl#getPriceData()}
   */
  @Test
  public void testGetPriceData5() {
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
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).hasRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertFalse(skuImpl.hasRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money());

    // Act and Assert
    assertTrue(skuImpl.hasRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.hasRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertFalse(skuImpl.hasRetailPrice());
  }

  /**
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice6() {
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
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice7() {
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
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice8() {
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
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice9() {
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
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice10() {
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
   * Method under test: {@link SkuImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice11() {
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
   * Method under test: {@link SkuImpl#setRetailPrice(Money)}
   */
  @Test
  public void testSetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();

    // Act
    skuImpl.setRetailPrice(retailPrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = retailPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), skuImpl.retailPrice);
    assertEquals(retailPrice, retailPrice.abs());
    assertEquals(retailPrice, retailPrice.zero());
    assertSame(skuImpl.retailPrice, amount);
  }

  /**
   * Method under test: {@link SkuImpl#setRetailPrice(Money)}
   */
  @Test
  public void testSetRetailPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setRetailPrice(null);

    // Assert
    assertNull(skuImpl.retailPrice);
  }

  /**
   * Method under test: {@link SkuImpl#setRetailPrice(Money)}
   */
  @Test
  public void testSetRetailPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setRetailPrice(mock(Money.class));

    // Assert
    assertNull(skuImpl.retailPrice);
  }

  /**
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl.getPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice6() {
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
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice7() {
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
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice8() {
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
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice9() {
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
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice10() {
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
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice11() {
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
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice12() {
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
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice13() {
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
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice14() {
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
   * Method under test: {@link SkuImpl#getPrice()}
   */
  @Test
  public void testGetPrice15() {
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
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getListPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getListPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money retailPrice = new Money();
    skuImpl.setRetailPrice(retailPrice);

    // Act and Assert
    assertEquals(retailPrice, skuImpl.getListPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getListPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getListPrice());
  }

  /**
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice6() {
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
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice7() {
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
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice8() {
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
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice9() {
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
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice10() {
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
   * Method under test: {@link SkuImpl#getListPrice()}
   */
  @Test
  public void testGetListPrice11() {
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
   * Method under test: {@link SkuImpl#setListPrice(Money)}
   */
  @Test
  public void testSetListPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money listPrice = new Money();

    // Act
    skuImpl.setListPrice(listPrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = listPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), skuImpl.retailPrice);
    assertEquals(listPrice, listPrice.abs());
    assertEquals(listPrice, listPrice.zero());
    assertSame(skuImpl.retailPrice, amount);
  }

  /**
   * Method under test: {@link SkuImpl#setListPrice(Money)}
   */
  @Test
  public void testSetListPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setListPrice(null);

    // Assert
    assertNull(skuImpl.retailPrice);
  }

  /**
   * Method under test: {@link SkuImpl#setListPrice(Money)}
   */
  @Test
  public void testSetListPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setListPrice(mock(Money.class));

    // Assert
    assertNull(skuImpl.retailPrice);
  }

  /**
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getCost());
  }

  /**
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money cost = new Money();
    skuImpl.setCost(cost);

    // Act and Assert
    assertEquals(cost, skuImpl.getCost());
  }

  /**
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getCost());
  }

  /**
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setCost(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getCost());
  }

  /**
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost5() {
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
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost6() {
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
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost7() {
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
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost8() {
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
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost9() {
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
   * Method under test: {@link SkuImpl#getCost()}
   */
  @Test
  public void testGetCost10() {
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
   * Method under test: {@link SkuImpl#setCost(Money)}
   */
  @Test
  public void testSetCost() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Money cost = new Money();

    // Act
    skuImpl.setCost(cost);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = cost.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), skuImpl.cost);
    assertEquals(cost, cost.abs());
    assertEquals(cost, cost.zero());
    assertSame(skuImpl.cost, amount);
  }

  /**
   * Method under test: {@link SkuImpl#setCost(Money)}
   */
  @Test
  public void testSetCost2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setCost(null);

    // Assert
    assertNull(skuImpl.cost);
  }

  /**
   * Method under test: {@link SkuImpl#setCost(Money)}
   */
  @Test
  public void testSetCost3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setCost(mock(Money.class));

    // Assert
    assertNull(skuImpl.cost);
  }

  /**
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    assertNull(skuImpl.product);
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    assertNull(skuImpl.product);
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money());

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    assertNull(skuImpl.product);
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setCost(new Money());

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    assertNull(skuImpl.product);
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act
    Money actualMargin = skuImpl.getMargin();

    // Assert
    assertNull(skuImpl.product);
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setRetailPrice(new Money(10.0d));

    // Act and Assert
    assertNull(skuImpl.getMargin());
    assertNull(skuImpl.product);
  }

  /**
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin7() {
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
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin8() {
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
    assertSame(actualMargin.ZERO, actualMargin);
  }

  /**
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin9() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin10() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin11() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin12() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin13() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin14() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getCost()).thenReturn(money);
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
    Currency currency = actualMargin.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("1.00");
    assertEquals(expectedAmount, actualMargin.getAmount());
    assertEquals(money, actualMargin.zero());
    assertEquals(actualMargin, actualMargin.abs());
  }

  /**
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin16() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin17() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin18() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin19() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin20() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin21() {
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
   * Method under test: {@link SkuImpl#getMargin()}
   */
  @Test
  public void testGetMargin22() {
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
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getName());
  }

  /**
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getName());
  }

  /**
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setName("name");

    // Act and Assert
    assertEquals("name", skuImpl.getName());
  }

  /**
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getName());
  }

  /**
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getName());
  }

  /**
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName6() {
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
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName7() {
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
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName8() {
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
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName9() {
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
   * Method under test: {@link SkuImpl#getName()}
   */
  @Test
  public void testGetName10() {
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
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getDescription());
  }

  /**
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getDescription());
  }

  /**
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals("The characteristics of someone or something", skuImpl.getDescription());
  }

  /**
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getDescription());
  }

  /**
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getDescription());
  }

  /**
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription6() {
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
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription7() {
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
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription8() {
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
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription9() {
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
   * Method under test: {@link SkuImpl#getDescription()}
   */
  @Test
  public void testGetDescription10() {
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
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getLongDescription());
  }

  /**
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertNull(skuImpl.getLongDescription());
  }

  /**
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setLongDescription("longDescription");

    // Act and Assert
    assertEquals("longDescription", skuImpl.getLongDescription());
  }

  /**
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getLongDescription());
  }

  /**
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getLongDescription());
  }

  /**
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription6() {
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
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription7() {
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
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription8() {
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
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription9() {
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
   * Method under test: {@link SkuImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription10() {
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
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).isTaxable());
  }

  /**
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setTaxable(true);

    // Act and Assert
    assertTrue(skuImpl.isTaxable());
  }

  /**
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.isTaxable());
  }

  /**
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setTaxable(false);

    // Act and Assert
    assertFalse(skuImpl.isTaxable());
  }

  /**
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable5() {
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
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable6() {
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
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable7() {
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
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable8() {
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
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable9() {
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
   * Method under test: {@link SkuImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable10() {
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
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getTaxable());
  }

  /**
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setTaxable(true);

    // Act and Assert
    assertTrue(skuImpl.getTaxable());
  }

  /**
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getTaxable());
  }

  /**
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setTaxable(false);

    // Act and Assert
    assertFalse(skuImpl.getTaxable());
  }

  /**
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable5() {
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
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable6() {
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
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable7() {
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
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable8() {
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
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable9() {
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
   * Method under test: {@link SkuImpl#getTaxable()}
   */
  @Test
  public void testGetTaxable10() {
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
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  public void testSetTaxable() {
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
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  public void testSetTaxable2() {
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
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  public void testSetTaxable3() {
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
   * Method under test: {@link SkuImpl#setTaxable(Boolean)}
   */
  @Test
  public void testSetTaxable4() {
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
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).isDiscountable());
  }

  /**
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDiscountable(true);

    // Act and Assert
    assertTrue(skuImpl.isDiscountable());
  }

  /**
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.isDiscountable());
  }

  /**
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDiscountable(false);

    // Act and Assert
    assertFalse(skuImpl.isDiscountable());
  }

  /**
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable5() {
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
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable6() {
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
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable7() {
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
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable8() {
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
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable9() {
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
   * Method under test: {@link SkuImpl#isDiscountable()}
   */
  @Test
  public void testIsDiscountable10() {
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
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).getDiscountable());
  }

  /**
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDiscountable(true);

    // Act and Assert
    assertTrue(skuImpl.getDiscountable());
  }

  /**
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.getDiscountable());
  }

  /**
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDiscountable(false);

    // Act and Assert
    assertFalse(skuImpl.getDiscountable());
  }

  /**
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable5() {
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
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable6() {
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
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable7() {
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
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable8() {
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
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable9() {
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
   * Method under test: {@link SkuImpl#getDiscountable()}
   */
  @Test
  public void testGetDiscountable10() {
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
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  public void testSetDiscountable() {
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
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  public void testSetDiscountable2() {
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
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  public void testSetDiscountable3() {
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
   * Method under test: {@link SkuImpl#setDiscountable(Boolean)}
   */
  @Test
  public void testSetDiscountable4() {
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
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).isAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setAvailable(true);

    // Act and Assert
    assertTrue(skuImpl.isAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.isAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.isAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    // Act and Assert
    assertTrue(skuImpl.isAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setAvailable(false);

    // Act and Assert
    assertFalse(skuImpl.isAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable7() {
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
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable8() {
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
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable9() {
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
   * Method under test: {@link SkuImpl#isAvailable()}
   */
  @Test
  public void testIsAvailable10() {
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
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setAvailable(true);

    // Act and Assert
    assertTrue(skuImpl.getAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.getAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.getAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    // Act and Assert
    assertTrue(skuImpl.getAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setAvailable(false);

    // Act and Assert
    assertFalse(skuImpl.getAvailable());
  }

  /**
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable7() {
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
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable8() {
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
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable9() {
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
   * Method under test: {@link SkuImpl#getAvailable()}
   */
  @Test
  public void testGetAvailable10() {
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
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  public void testSetAvailable() {
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
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  public void testSetAvailable2() {
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
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  public void testSetAvailable3() {
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
   * Method under test: {@link SkuImpl#setAvailable(Boolean)}
   */
  @Test
  public void testSetAvailable4() {
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
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getActiveStartDate());
  }

  /**
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Date activeStartDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    skuImpl.setActiveStartDate(activeStartDate);

    // Act and Assert
    assertSame(activeStartDate, skuImpl.getActiveStartDate());
  }

  /**
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getActiveStartDate());
  }

  /**
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveStartDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(skuImpl.activeStartDate, skuImpl.getActiveStartDate());
  }

  /**
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate5() {
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
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate6() {
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
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate7() {
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
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(sku.getActiveStartDate()).thenReturn(fromResult);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Date actualActiveStartDate = skuImpl.getActiveStartDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getActiveStartDate();
    verify(sku).getId();
    assertSame(fromResult, actualActiveStartDate);
  }

  /**
   * Method under test: {@link SkuImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate9() {
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
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getActiveEndDate());
  }

  /**
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Date activeEndDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    skuImpl.setActiveEndDate(activeEndDate);

    // Act and Assert
    assertSame(activeEndDate, skuImpl.getActiveEndDate());
  }

  /**
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getActiveEndDate());
  }

  /**
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(skuImpl.activeEndDate, skuImpl.getActiveEndDate());
  }

  /**
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate5() {
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
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate6() {
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
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate7() {
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
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(sku.getActiveEndDate()).thenReturn(fromResult);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(2L);
    skuImpl.setProduct(product);

    // Act
    Date actualActiveEndDate = skuImpl.getActiveEndDate();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    verify(sku).getActiveEndDate();
    verify(sku).getId();
    assertSame(fromResult, actualActiveEndDate);
  }

  /**
   * Method under test: {@link SkuImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate9() {
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
   * Method under test: {@link SkuImpl#getDimension()}
   */
  @Test
  public void testGetDimension() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act and Assert
    assertSame(skuImpl.dimension, skuImpl.getDimension());
  }

  /**
   * Method under test: {@link SkuImpl#getDimension()}
   */
  @Test
  public void testGetDimension2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertSame(skuImpl.dimension, skuImpl.getDimension());
  }

  /**
   * Method under test: {@link SkuImpl#getWeight()}
   */
  @Test
  public void testGetWeight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act and Assert
    assertSame(skuImpl.weight, skuImpl.getWeight());
  }

  /**
   * Method under test: {@link SkuImpl#getWeight()}
   */
  @Test
  public void testGetWeight2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertSame(skuImpl.weight, skuImpl.getWeight());
  }

  /**
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).isActive());
  }

  /**
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setId(1L);

    // Act and Assert
    assertFalse(skuImpl.isActive());
  }

  /**
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());

    // Act and Assert
    assertFalse(skuImpl.isActive());
  }

  /**
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl.isActive());
  }

  /**
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertFalse(skuImpl.isActive());
  }

  /**
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive6() {
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
   * Method under test: {@link SkuImpl#isActive()}
   */
  @Test
  public void testIsActive7() {
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
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActive8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActive9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    Product product = mock(Product.class);

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActive10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(new Money());
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActive11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActive12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl.isActive(null, new CategoryImpl()));
  }

  /**
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActive13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Product product = mock(Product.class);

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActive14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Product product = mock(Product.class);

    // Act and Assert
    assertFalse(skuImpl.isActive(product, new CategoryImpl()));
  }

  /**
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActive15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl.isActive(mock(Product.class), mock(Category.class)));
  }

  /**
   * Method under test: {@link SkuImpl#isActive(Product, Category)}
   */
  @Test
  public void testIsActive16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setActiveEndDate(new Date());
    skuImpl.setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(skuImpl.isActive(mock(Product.class), mock(Category.class)));
  }

  /**
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getSkuMedia().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertTrue(skuImpl.getSkuMedia().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia3() {
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
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia4() {
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
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia5() {
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
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia6() {
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
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia7() {
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
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia8() {
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
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia9() {
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
   * Method under test: {@link SkuImpl#getSkuMedia()}
   */
  @Test
  public void testGetSkuMedia10() {
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
   * Method under test: {@link SkuImpl#setSkuMedia(Map)}
   */
  @Test
  public void testSetSkuMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setSkuMedia(new HashMap<>());

    // Assert
    assertTrue(skuImpl.getSkuMedia().isEmpty());
    Map<String, SkuMediaXref> skuMediaXref = skuImpl.getSkuMediaXref();
    assertTrue(skuMediaXref.isEmpty());
    assertTrue(skuImpl.skuMedia.isEmpty());
    assertSame(skuImpl.skuMedia, skuMediaXref);
  }

  /**
   * Method under test: {@link SkuImpl#setSkuMedia(Map)}
   */
  @Test
  public void testSetSkuMedia2() {
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
   * Method under test: {@link SkuImpl#setSkuMedia(Map)}
   */
  @Test
  public void testSetSkuMedia3() {
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
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl.getSkuMediaXref();

    // Assert
    assertTrue(actualSkuMediaXref.isEmpty());
    assertSame(skuImpl.skuMedia, actualSkuMediaXref);
  }

  /**
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl.getSkuMediaXref();

    // Assert
    assertTrue(actualSkuMediaXref.isEmpty());
    assertSame(skuImpl.skuMedia, actualSkuMediaXref);
  }

  /**
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref3() {
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
    assertSame(skuImpl.skuMedia, actualSkuMediaXref);
  }

  /**
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    SkuImpl skuImpl = new SkuImpl();
    when(product.getDefaultSku()).thenReturn(skuImpl);

    SkuImpl skuImpl2 = new SkuImpl();
    skuImpl2.setId(1L);
    skuImpl2.setProduct(product);

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXref = skuImpl2.getSkuMediaXref();

    // Assert
    verify(product, atLeast(1)).getDefaultSku();
    assertTrue(actualSkuMediaXref.isEmpty());
    assertSame(skuImpl.skuMedia, actualSkuMediaXref);
  }

  /**
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref5() {
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
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref6() {
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
    assertSame(skuImpl.skuMedia, actualSkuMediaXref);
  }

  /**
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    HashMap<String, SkuMediaXref> stringSkuMediaXrefMap = new HashMap<>();
    when(sku.getSkuMediaXref()).thenReturn(stringSkuMediaXrefMap);
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
    assertSame(stringSkuMediaXrefMap, actualSkuMediaXref);
  }

  /**
   * Method under test: {@link SkuImpl#getSkuMediaXref()}
   */
  @Test
  public void testGetSkuMediaXref8() {
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
   * Method under test: {@link SkuImpl#getSkuMediaXrefIgnoreDefaultSku()}
   */
  @Test
  public void testGetSkuMediaXrefIgnoreDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXrefIgnoreDefaultSku = skuImpl.getSkuMediaXrefIgnoreDefaultSku();

    // Assert
    assertTrue(actualSkuMediaXrefIgnoreDefaultSku.isEmpty());
    assertSame(skuImpl.skuMedia, actualSkuMediaXrefIgnoreDefaultSku);
  }

  /**
   * Method under test: {@link SkuImpl#getSkuMediaXrefIgnoreDefaultSku()}
   */
  @Test
  public void testGetSkuMediaXrefIgnoreDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act
    Map<String, SkuMediaXref> actualSkuMediaXrefIgnoreDefaultSku = skuImpl.getSkuMediaXrefIgnoreDefaultSku();

    // Assert
    assertTrue(actualSkuMediaXrefIgnoreDefaultSku.isEmpty());
    assertSame(skuImpl.skuMedia, actualSkuMediaXrefIgnoreDefaultSku);
  }

  /**
   * Method under test: {@link SkuImpl#getPrimarySkuMedia()}
   */
  @Test
  public void testGetPrimarySkuMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getPrimarySkuMedia());
  }

  /**
   * Method under test: {@link SkuImpl#getPrimarySkuMedia()}
   */
  @Test
  public void testGetPrimarySkuMedia2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertNull(skuImpl.getPrimarySkuMedia());
  }

  /**
   * Method under test: {@link SkuImpl#isOrderedSkuMedia(Map)}
   */
  @Test
  public void testIsOrderedSkuMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act and Assert
    assertFalse(skuImpl.isOrderedSkuMedia(new HashMap<>()));
  }

  /**
   * Method under test: {@link SkuImpl#isOrderedSkuMedia(Map)}
   */
  @Test
  public void testIsOrderedSkuMedia2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashMap<String, SkuMediaXref> skuMedia = new HashMap<>();
    skuMedia.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertFalse(skuImpl.isOrderedSkuMedia(skuMedia));
  }

  /**
   * Method under test: {@link SkuImpl#sortSkuMedia(Map)}
   */
  @Test
  public void testSortSkuMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act and Assert
    assertTrue(skuImpl.sortSkuMedia(new HashMap<>()).isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#sortSkuMedia(Map)}
   */
  @Test
  public void testSortSkuMedia2() {
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
   * Method under test: {@link SkuImpl#sortSkuMedia(Map)}
   */
  @Test
  public void testSortSkuMedia3() {
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
   * Method under test: {@link SkuImpl#getProduct()}
   */
  @Test
  public void testGetProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getProduct());
  }

  /**
   * Method under test: {@link SkuImpl#getProduct()}
   */
  @Test
  public void testGetProduct2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    ProductBundleImpl defaultProduct = new ProductBundleImpl();
    skuImpl.setDefaultProduct(defaultProduct);

    // Act and Assert
    assertSame(defaultProduct, skuImpl.getProduct());
  }

  /**
   * Method under test: {@link SkuImpl#getProductOptionValuesCollection()}
   */
  @Test
  public void testGetProductOptionValuesCollection() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getProductOptionValuesCollection().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#getProductOptionValuesCollection()}
   */
  @Test
  public void testGetProductOptionValuesCollection2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertTrue(skuImpl.getProductOptionValuesCollection().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#getProductOptionValuesCollection()}
   */
  @Test
  public void testGetProductOptionValuesCollection3() {
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
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  public void testSetProductOptionValuesCollection() {
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
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  public void testSetProductOptionValuesCollection2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();
    productOptionValues.add(new ProductOptionValueImpl());

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
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  public void testSetProductOptionValuesCollection3() {
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
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  public void testSetProductOptionValuesCollection4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setName("Name");

    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();
    productOptionValues.add(new ProductOptionValueImpl());

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
   * Method under test: {@link SkuImpl#setProductOptionValuesCollection(Set)}
   */
  @Test
  public void testSetProductOptionValuesCollection5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    HashSet<ProductOptionValue> productOptionValues = new HashSet<>();
    productOptionValues.add(new ProductOptionValueImpl());
    productOptionValues.add(mock(ProductOptionValueImpl.class));

    // Act
    skuImpl.setProductOptionValuesCollection(productOptionValues);

    // Assert
    assertEquals(2, skuImpl.getProductOptionValues().size());
    assertEquals(2, skuImpl.getProductOptionValueXrefs().size());
    assertEquals(2, skuImpl.legacyProductOptionValues.size());
    Set<ProductOptionValue> productOptionValueSet = skuImpl.legacyProductOptionValues;
    assertEquals(productOptionValueSet, productOptionValues);
    assertEquals(productOptionValueSet, skuImpl.getProductOptionValuesCollection());
  }

  /**
   * Method under test: {@link SkuImpl#getProductOptionValues()}
   */
  @Test
  public void testGetProductOptionValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getProductOptionValues().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#getProductOptionValues()}
   */
  @Test
  public void testGetProductOptionValues2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertTrue(skuImpl.getProductOptionValues().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#getProductOptionValues()}
   */
  @Test
  public void testGetProductOptionValues3() {
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
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  public void testSetProductOptionValues() {
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
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  public void testSetProductOptionValues2() {
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
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  public void testSetProductOptionValues3() {
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
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  public void testSetProductOptionValues4() {
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
   * Method under test: {@link SkuImpl#setProductOptionValues(List)}
   */
  @Test
  public void testSetProductOptionValues5() {
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
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).isMachineSortable());
  }

  /**
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.isMachineSortable());
  }

  /**
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setMachineSortable(true);

    // Act and Assert
    assertTrue(skuImpl.isMachineSortable());
  }

  /**
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable4() {
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
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable5() {
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
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable6() {
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
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable7() {
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
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable8() {
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
   * Method under test: {@link SkuImpl#isMachineSortable()}
   */
  @Test
  public void testIsMachineSortable9() {
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
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SkuImpl()).getIsMachineSortable());
  }

  /**
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertFalse(skuImpl.getIsMachineSortable());
  }

  /**
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setMachineSortable(true);

    // Act and Assert
    assertTrue(skuImpl.getIsMachineSortable());
  }

  /**
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable4() {
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
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable5() {
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
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable6() {
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
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable7() {
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
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable8() {
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
   * Method under test: {@link SkuImpl#getIsMachineSortable()}
   */
  @Test
  public void testGetIsMachineSortable9() {
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
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getInventoryType());
  }

  /**
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getInventoryType());
  }

  /**
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getInventoryType());
  }

  /**
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType4() {
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
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType5() {
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
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType6() {
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
   * Method under test: {@link SkuImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType7() {
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
   * Method under test: {@link SkuImpl#setInventoryType(InventoryType)}
   */
  @Test
  public void testSetInventoryType() {
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
   * Method under test: {@link SkuImpl#setInventoryType(InventoryType)}
   */
  @Test
  public void testSetInventoryType2() {
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
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getFulfillmentType());
  }

  /**
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getFulfillmentType());
  }

  /**
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getFulfillmentType());
  }

  /**
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType4() {
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
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType5() {
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
   * Method under test: {@link SkuImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType6() {
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
   * Method under test: {@link SkuImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  public void testSetFulfillmentType() {
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
   * Method under test: {@link SkuImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  public void testSetFulfillmentType2() {
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
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  public void testGetSkuAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getSkuAttributes().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  public void testGetSkuAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertTrue(skuImpl.getSkuAttributes().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  public void testGetSkuAttributes3() {
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
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  public void testGetSkuAttributes4() {
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
   * Method under test: {@link SkuImpl#getSkuAttributes()}
   */
  @Test
  public void testGetSkuAttributes5() {
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
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  public void testGetMultiValueSkuAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SkuImpl()).getMultiValueSkuAttributes().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  public void testGetMultiValueSkuAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSalePrice(mock(Money.class));

    // Act and Assert
    assertTrue(skuImpl.getMultiValueSkuAttributes().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  public void testGetMultiValueSkuAttributes3() {
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
    List<SkuAttribute> expectedGetResult = skuImpl.skuAttributes;
    assertEquals(expectedGetResult, actualMultiValueSkuAttributes.get(null));
  }

  /**
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  public void testGetMultiValueSkuAttributes4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, SkuAttribute> skuAttributes = new HashMap<>();
    skuAttributes.put("ThreadLocalManager.notify.orphans", new SkuAttributeImpl());
    skuAttributes.put("foo", new SkuAttributeImpl());

    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setSkuAttributes(skuAttributes);

    // Act
    Map<String, Collection<SkuAttribute>> actualMultiValueSkuAttributes = skuImpl.getMultiValueSkuAttributes();

    // Assert
    assertEquals(1, actualMultiValueSkuAttributes.size());
    List<SkuAttribute> expectedGetResult = skuImpl.skuAttributes;
    assertEquals(expectedGetResult, actualMultiValueSkuAttributes.get(null));
  }

  /**
   * Method under test: {@link SkuImpl#getMultiValueSkuAttributes()}
   */
  @Test
  public void testGetMultiValueSkuAttributes5() {
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
   * Method under test: {@link SkuImpl#setSkuAttributes(Map)}
   */
  @Test
  public void testSetSkuAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();

    // Act
    skuImpl.setSkuAttributes(new HashMap<>());

    // Assert
    assertTrue(skuImpl.getFees().isEmpty());
    assertTrue(skuImpl.getProductOptionValues().isEmpty());
    assertTrue(skuImpl.getFieldEntityType().getAdditionalLookupTypes().isEmpty());
    assertTrue(skuImpl.skuAttributes.isEmpty());
    assertTrue(skuImpl.getMultiValueSkuAttributes().isEmpty());
    assertTrue(skuImpl.getSkuAttributes().isEmpty());
  }

  /**
   * Method under test: {@link SkuImpl#setSkuAttributes(Map)}
   */
  @Test
  public void testSetSkuAttributes2() {
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
    assertTrue(skuImpl.getFees().isEmpty());
    assertTrue(skuImpl.getProductOptionValues().isEmpty());
    assertTrue(skuImpl.getFieldEntityType().getAdditionalLookupTypes().isEmpty());
    List<SkuAttribute> expectedGetResult = skuImpl.skuAttributes;
    assertEquals(expectedGetResult, multiValueSkuAttributes.get(null));
    assertSame(skuAttributeImpl, skuAttributeList.get(0));
    assertSame(skuAttributeImpl, skuAttributes2.get(null));
  }

  /**
   * Method under test: {@link SkuImpl#setSkuAttributes(Map)}
   */
  @Test
  public void testSetSkuAttributes3() {
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
    assertTrue(skuImpl.getFees().isEmpty());
    assertTrue(skuImpl.getProductOptionValues().isEmpty());
    assertTrue(skuImpl.getFieldEntityType().getAdditionalLookupTypes().isEmpty());
    List<SkuAttribute> expectedGetResult = skuImpl.skuAttributes;
    assertEquals(expectedGetResult, multiValueSkuAttributes.get(null));
    assertSame(skuAttributeImpl, skuAttributeList.get(0));
    assertSame(skuAttributeImpl, skuAttributes2.get(null));
  }

  /**
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getCurrency());
  }

  /**
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getCurrency());
  }

  /**
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    skuImpl.setCurrency(currency);

    // Act and Assert
    assertSame(currency, skuImpl.getCurrency());
  }

  /**
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency4() {
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
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency5() {
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
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency6() {
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
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency7() {
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
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency8() {
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
   * Method under test: {@link SkuImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency9() {
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
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuImpl()).getTaxCode());
  }

  /**
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setDefaultProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getTaxCode());
  }

  /**
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setProduct(new ProductBundleImpl());

    // Act and Assert
    assertNull(skuImpl.getTaxCode());
  }

  /**
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    skuImpl.setTaxCode("Tax Code");

    // Act and Assert
    assertEquals("Tax Code", skuImpl.getTaxCode());
  }

  /**
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode5() {
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
   * Method under test: {@link SkuImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode6() {
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
   * Method under test:
   * {@link SkuImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
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

  /**
   * Method under test:
   * {@link SkuImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
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
}
