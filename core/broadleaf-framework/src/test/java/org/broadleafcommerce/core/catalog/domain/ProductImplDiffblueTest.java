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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.util.DimensionUnitOfMeasureType;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.common.vendor.service.type.ContainerShapeType;
import org.broadleafcommerce.common.vendor.service.type.ContainerSizeType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductImplDiffblueTest {
  /**
   * Method under test: {@link ProductImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getName());
  }

  /**
   * Method under test: {@link ProductImpl#getName()}
   */
  @Test
  public void testGetName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualName = productImpl.getName();

    // Assert
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("Name", actualName);
  }

  /**
   * Method under test: {@link ProductImpl#setName(String)}
   */
  @Test
  public void testSetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setName("Name");

    // Assert
    assertEquals("Name", productImpl.getMainEntityName());
    assertEquals("Name", productImpl.getName());
    assertEquals("name", productImpl.getUrlKey());
    assertSame(defaultSku, productImpl.getDefaultSku());
  }

  /**
   * Method under test: {@link ProductImpl#setName(String)}
   */
  @Test
  public void testSetName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());
    doNothing().when(defaultSku).setName(Mockito.<String>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setName("Name");

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    verify(defaultSku).setName(eq("Name"));
    assertNull(productImpl.getMainEntityName());
    assertNull(productImpl.getName());
    assertNull(productImpl.getUrlKey());
  }

  /**
   * Method under test: {@link ProductImpl#getDescription()}
   */
  @Test
  public void testGetDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getDescription());
  }

  /**
   * Method under test: {@link ProductImpl#getDescription()}
   */
  @Test
  public void testGetDescription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getDescription()).thenReturn("The characteristics of someone or something");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualDescription = productImpl.getDescription();

    // Assert
    verify(defaultSku).getDescription();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("The characteristics of someone or something", actualDescription);
  }

  /**
   * Method under test: {@link ProductImpl#setDescription(String)}
   */
  @Test
  public void testSetDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setDescription("The characteristics of someone or something");

    // Assert
    assertEquals("The characteristics of someone or something", productImpl.getDescription());
    assertSame(defaultSku, productImpl.getDefaultSku());
  }

  /**
   * Method under test: {@link ProductImpl#setDescription(String)}
   */
  @Test
  public void testSetDescription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());
    doNothing().when(defaultSku).setDescription(Mockito.<String>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setDescription("The characteristics of someone or something");

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    verify(defaultSku).setDescription(eq("The characteristics of someone or something"));
    assertNull(productImpl.getDescription());
  }

  /**
   * Method under test: {@link ProductImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getLongDescription());
  }

  /**
   * Method under test: {@link ProductImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getLongDescription()).thenReturn("Long Description");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualLongDescription = productImpl.getLongDescription();

    // Assert
    verify(defaultSku).getLongDescription();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("Long Description", actualLongDescription);
  }

  /**
   * Method under test: {@link ProductImpl#setLongDescription(String)}
   */
  @Test
  public void testSetLongDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setLongDescription("Long Description");

    // Assert
    assertEquals("Long Description", productImpl.getLongDescription());
    assertSame(defaultSku, productImpl.getDefaultSku());
  }

  /**
   * Method under test: {@link ProductImpl#setLongDescription(String)}
   */
  @Test
  public void testSetLongDescription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());
    doNothing().when(defaultSku).setLongDescription(Mockito.<String>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setLongDescription("Long Description");

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    verify(defaultSku).setLongDescription(eq("Long Description"));
    assertNull(productImpl.getLongDescription());
  }

  /**
   * Method under test: {@link ProductImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getActiveStartDate());
  }

  /**
   * Method under test: {@link ProductImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(defaultSku.getActiveStartDate()).thenReturn(fromResult);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Date actualActiveStartDate = productImpl.getActiveStartDate();

    // Assert
    verify(defaultSku).getActiveStartDate();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertSame(fromResult, actualActiveStartDate);
  }

  /**
   * Method under test: {@link ProductImpl#setActiveStartDate(Date)}
   */
  @Test
  public void testSetActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);
    Date activeStartDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    productImpl.setActiveStartDate(activeStartDate);

    // Assert
    assertSame(defaultSku, productImpl.getDefaultSku());
    assertSame(activeStartDate, productImpl.getActiveStartDate());
  }

  /**
   * Method under test: {@link ProductImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getActiveEndDate());
  }

  /**
   * Method under test: {@link ProductImpl#getActiveEndDate()}
   */
  @Test
  public void testGetActiveEndDate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(defaultSku.getActiveEndDate()).thenReturn(fromResult);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Date actualActiveEndDate = productImpl.getActiveEndDate();

    // Assert
    verify(defaultSku).getActiveEndDate();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertSame(fromResult, actualActiveEndDate);
  }

  /**
   * Method under test: {@link ProductImpl#setActiveEndDate(Date)}
   */
  @Test
  public void testSetActiveEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);
    Date activeEndDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    productImpl.setActiveEndDate(activeEndDate);

    // Assert
    assertSame(defaultSku, productImpl.getDefaultSku());
    assertSame(activeEndDate, productImpl.getActiveEndDate());
  }

  /**
   * Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertFalse(productImpl.isActive());
  }

  /**
   * Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  public void testIsActive2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getActiveEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(defaultSku.getActiveStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    boolean actualIsActiveResult = productImpl.isActive();

    // Assert
    verify(defaultSku).getActiveEndDate();
    verify(defaultSku).getActiveStartDate();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertFalse(actualIsActiveResult);
  }

  /**
   * Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  public void testIsActive3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getActiveEndDate()).thenReturn(null);
    when(defaultSku.getActiveStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.isActive();

    // Assert
    verify(defaultSku).getActiveEndDate();
    verify(defaultSku).getActiveStartDate();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Method under test: {@link ProductImpl#isFeaturedProduct()}
   */
  @Test
  public void testIsFeaturedProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductImpl()).isFeaturedProduct());
  }

  /**
   * Method under test: {@link ProductImpl#isFeaturedProduct()}
   */
  @Test
  public void testIsFeaturedProduct2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setFeaturedProduct(true);

    // Act and Assert
    assertTrue(productImpl.isFeaturedProduct());
  }

  /**
   * Method under test: {@link ProductImpl#setFeaturedProduct(boolean)}
   */
  @Test
  public void testSetFeaturedProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setFeaturedProduct(true);

    // Assert
    assertTrue(productImpl.isFeaturedProduct);
  }

  /**
   * Method under test: {@link ProductImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductImpl()).hasRetailPrice());
  }

  /**
   * Method under test: {@link ProductImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertFalse(productImpl.hasRetailPrice());
  }

  /**
   * Method under test: {@link ProductImpl#hasRetailPrice()}
   */
  @Test
  public void testHasRetailPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getRetailPrice()).thenReturn(new Money());
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    boolean actualHasRetailPriceResult = productImpl.hasRetailPrice();

    // Assert
    verify(defaultSku).getRetailPrice();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertTrue(actualHasRetailPriceResult);
  }

  /**
   * Method under test: {@link ProductImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getRetailPrice());
  }

  /**
   * Method under test: {@link ProductImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getRetailPrice());
  }

  /**
   * Method under test: {@link ProductImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getSalePrice());
  }

  /**
   * Method under test: {@link ProductImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getSalePrice());
  }

  /**
   * Method under test: {@link ProductImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getRetailPriceInternal());
  }

  /**
   * Method under test: {@link ProductImpl#getRetailPriceInternal()}
   */
  @Test
  public void testGetRetailPriceInternal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getRetailPriceInternal());
  }

  /**
   * Method under test: {@link ProductImpl#getSalePriceInternal()}
   */
  @Test
  public void testGetSalePriceInternal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getSalePriceInternal());
  }

  /**
   * Method under test: {@link ProductImpl#getSalePriceInternal()}
   */
  @Test
  public void testGetSalePriceInternal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getSalePriceInternal());
  }

  /**
   * Method under test: {@link ProductImpl#getPrice()}
   */
  @Test
  public void testGetPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getPrice());
  }

  /**
   * Method under test: {@link ProductImpl#getPrice()}
   */
  @Test
  public void testGetPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getPrice());
  }

  /**
   * Method under test: {@link ProductImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertFalse(productImpl.isOnSale());
  }

  /**
   * Method under test: {@link ProductImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.isOnSale()).thenReturn(true);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    boolean actualIsOnSaleResult = productImpl.isOnSale();

    // Assert
    verify(defaultSku).isOnSale();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertTrue(actualIsOnSaleResult);
  }

  /**
   * Method under test: {@link ProductImpl#getExternalId()}
   */
  @Test
  public void testGetExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getExternalId());
  }

  /**
   * Method under test: {@link ProductImpl#getExternalId()}
   */
  @Test
  public void testGetExternalId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getExternalId()).thenReturn("42");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualExternalId = productImpl.getExternalId();

    // Assert
    verify(defaultSku).getExternalId();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("42", actualExternalId);
  }

  /**
   * Method under test: {@link ProductImpl#getCanSellWithoutOptions()}
   */
  @Test
  public void testGetCanSellWithoutOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductImpl()).getCanSellWithoutOptions());
  }

  /**
   * Method under test: {@link ProductImpl#getCanSellWithoutOptions()}
   */
  @Test
  public void testGetCanSellWithoutOptions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);

    // Act and Assert
    assertTrue(productImpl.getCanSellWithoutOptions());
  }

  /**
   * Method under test: {@link ProductImpl#getCanSellWithoutOptions()}
   */
  @Test
  public void testGetCanSellWithoutOptions3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(null);

    // Act and Assert
    assertFalse(productImpl.getCanSellWithoutOptions());
  }

  /**
   * Method under test: {@link ProductImpl#setDefaultSku(Sku)}
   */
  @Test
  public void testSetDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();

    // Act
    productImpl.setDefaultSku(defaultSku);

    // Assert
    assertEquals(productImpl.productAttributes, productImpl.productOptions);
    assertSame(productImpl, defaultSku.getDefaultProduct());
    assertSame(productImpl, defaultSku.getProduct());
  }

  /**
   * Method under test: {@link ProductImpl#setDefaultSku(Sku)}
   */
  @Test
  public void testSetDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setDefaultSku(null);

    // Assert
    List<Sku> allSellableSkus = productImpl.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    List<Sku> allSkus = productImpl.getAllSkus();
    assertEquals(1, allSkus.size());
    assertNull(allSkus.get(0));
    assertNull(productImpl.getDefaultSku());
    assertTrue(productImpl.productOptions.isEmpty());
    assertTrue(productImpl.skus.isEmpty());
    assertTrue(productImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(productImpl.getProductAttributes().isEmpty());
    Map<String, Set<String>> productOptionValuesMap = productImpl.getProductOptionValuesMap();
    assertTrue(productOptionValuesMap.isEmpty());
    assertSame(productOptionValuesMap, productImpl.productOptionMap);
  }

  /**
   * Method under test: {@link ProductImpl#setDefaultSku(Sku)}
   */
  @Test
  public void testSetDefaultSku3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    // Act
    productImpl.setDefaultSku(defaultSku);

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertNull(productImpl.getDescription());
    assertNull(productImpl.getExternalId());
    assertNull(productImpl.getLongDescription());
    assertNull(productImpl.getMainEntityName());
    assertNull(productImpl.getName());
    assertNull(productImpl.getTaxCode());
    assertNull(productImpl.getUrlKey());
    assertNull(productImpl.getActiveEndDate());
    assertNull(productImpl.getActiveStartDate());
    assertNull(productImpl.getMargin());
    assertNull(productImpl.getDimension());
    assertNull(productImpl.getWeight());
    List<Sku> allSellableSkus = productImpl.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertFalse(productImpl.isOnSale());
    assertTrue(productImpl.productOptions.isEmpty());
    assertTrue(productImpl.skus.isEmpty());
    assertTrue(productImpl.getAllSkuMedia().isEmpty());
    assertTrue(productImpl.getMedia().isEmpty());
    assertTrue(productImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(productImpl.getProductAttributes().isEmpty());
    Map<String, Set<String>> productOptionValuesMap = productImpl.getProductOptionValuesMap();
    assertTrue(productOptionValuesMap.isEmpty());
    assertEquals(allSellableSkus, productImpl.getAllSkus());
    assertSame(productOptionValuesMap, productImpl.productOptionMap);
    assertSame(defaultSku, allSellableSkus.get(0));
    assertSame(defaultSku, productImpl.getDefaultSku());
  }

  /**
   * Method under test: {@link ProductImpl#setDefaultSku(Sku)}
   */
  @Test
  public void testSetDefaultSku4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = mock(SkuImpl.class);
    doThrow(new UnsupportedOperationException("foo")).when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setDefaultSku(defaultSku));
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Method under test: {@link ProductImpl#getAllSkus()}
   */
  @Test
  public void testGetAllSkus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<Sku> actualAllSkus = (new ProductImpl()).getAllSkus();

    // Assert
    assertEquals(1, actualAllSkus.size());
    assertNull(actualAllSkus.get(0));
  }

  /**
   * Method under test: {@link ProductImpl#getAllSkus()}
   */
  @Test
  public void testGetAllSkus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    List<Sku> actualAllSkus = productImpl.getAllSkus();

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(1, actualAllSkus.size());
  }

  /**
   * Method under test: {@link ProductImpl#getAllSkus(boolean)}
   */
  @Test
  public void testGetAllSkus3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<Sku> actualAllSkus = (new ProductImpl()).getAllSkus(true);

    // Assert
    assertEquals(1, actualAllSkus.size());
    assertNull(actualAllSkus.get(0));
  }

  /**
   * Method under test: {@link ProductImpl#getAllSkus(boolean)}
   */
  @Test
  public void testGetAllSkus4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getAllSkus(false).isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getAllSkus(boolean)}
   */
  @Test
  public void testGetAllSkus5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    List<Sku> actualAllSkus = productImpl.getAllSkus(true);

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(1, actualAllSkus.size());
  }

  /**
   * Method under test: {@link ProductImpl#getSkus()}
   */
  @Test
  public void testGetSkus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getSkus().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#setAdditionalSkus(List)}
   */
  @Test
  public void testSetAdditionalSkus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setAdditionalSkus(new ArrayList<>());

    // Assert
    assertTrue(productImpl.getAdditionalSkus().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#setAdditionalSkus(List)}
   */
  @Test
  public void testSetAdditionalSkus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());

    // Act
    productImpl.setAdditionalSkus(skus);

    // Assert
    assertEquals(skus, productImpl.getAdditionalSkus());
  }

  /**
   * Method under test: {@link ProductImpl#setAdditionalSkus(List)}
   */
  @Test
  public void testSetAdditionalSkus3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(new SkuImpl());
    skus.add(new SkuImpl());

    // Act
    productImpl.setAdditionalSkus(skus);

    // Assert
    assertEquals(skus, productImpl.getAdditionalSkus());
  }

  /**
   * Method under test: {@link ProductImpl#setAdditionalSkus(List)}
   */
  @Test
  public void testSetAdditionalSkus4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<Sku> skus = new ArrayList<>();
    skus.add(mock(SkuImpl.class));

    // Act
    productImpl.setAdditionalSkus(skus);

    // Assert
    assertEquals(1, productImpl.getAdditionalSkus().size());
  }

  /**
   * Method under test: {@link ProductImpl#getDefaultCategory()}
   */
  @Test
  public void testGetDefaultCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act and Assert
    assertNull(productImpl.getDefaultCategory());
    assertNull(productImpl.defaultCategory);
    assertTrue(productImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(productImpl.getProductAttributes().isEmpty());
    assertTrue(productImpl.getProductOptionValuesMap().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getDefaultCategory()}
   */
  @Test
  public void testGetDefaultCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    CategoryImpl defaultCategory = new CategoryImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    Category actualDefaultCategory = productImpl.getDefaultCategory();

    // Assert
    Category category = productImpl.defaultCategory;
    assertTrue(category instanceof CategoryImpl);
    assertTrue(category.getCategoryAttributesMap().isEmpty());
    assertTrue(category.getCategoryMedia().isEmpty());
    assertTrue(category.getMappedCategoryAttributes().isEmpty());
    assertTrue(category.getMultiValueCategoryAttributes().isEmpty());
    assertTrue(productImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(productImpl.getProductAttributes().isEmpty());
    assertTrue(productImpl.getProductOptionValuesMap().isEmpty());
    assertSame(defaultCategory, actualDefaultCategory);
    assertSame(((CategoryImpl) actualDefaultCategory).allLegacyChildCategories,
        ((CategoryImpl) category).allLegacyChildCategories);
    assertSame(((CategoryImpl) actualDefaultCategory).archiveStatus, ((CategoryImpl) category).archiveStatus);
    assertSame(((CategoryImpl) actualDefaultCategory).childCategoryXrefs, ((CategoryImpl) category).childCategoryXrefs);
    assertSame(((CategoryImpl) actualDefaultCategory).legacyCategoryMedia,
        ((CategoryImpl) category).legacyCategoryMedia);
    assertSame(((CategoryImpl) actualDefaultCategory).legacyChildCategories,
        ((CategoryImpl) category).legacyChildCategories);
  }

  /**
   * Method under test: {@link ProductImpl#getDefaultCategory()}
   */
  @Test
  public void testGetDefaultCategory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(mock(CategoryImpl.class));

    // Act
    Category actualDefaultCategory = productImpl.getDefaultCategory();

    // Assert
    assertTrue(productImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(productImpl.getProductAttributes().isEmpty());
    assertTrue(productImpl.getProductOptionValuesMap().isEmpty());
    assertSame(productImpl.defaultCategory, actualDefaultCategory);
  }

  /**
   * Method under test: {@link ProductImpl#getCategory()}
   */
  @Test
  public void testGetCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getCategory());
  }

  /**
   * Method under test: {@link ProductImpl#setCategory(Category)}
   */
  @Test
  public void testSetCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    productImpl.setCategory(category);

    // Assert
    List<CategoryProductXref> allParentCategoryXrefs = productImpl.getAllParentCategoryXrefs();
    assertEquals(1, allParentCategoryXrefs.size());
    CategoryProductXref getResult = allParentCategoryXrefs.get(0);
    assertTrue(getResult instanceof CategoryProductXrefImpl);
    List<String> allParentCategoryIds = productImpl.getAllParentCategoryIds();
    assertEquals(1, allParentCategoryIds.size());
    assertEquals("null", allParentCategoryIds.get(0));
    List<Long> parentCategoryHierarchyIds = productImpl.getParentCategoryHierarchyIds();
    assertEquals(1, parentCategoryHierarchyIds.size());
    assertNull(parentCategoryHierarchyIds.get(0));
    assertNull(getResult.getId());
    assertNull(getResult.getDisplayOrder());
    List<Category> allParentCategories = productImpl.getAllParentCategories();
    assertEquals(1, allParentCategories.size());
    assertTrue(getResult.getDefaultReference());
    assertSame(category, allParentCategories.get(0));
    assertSame(category, getResult.getCategory());
    assertSame(productImpl, getResult.getProduct());
  }

  /**
   * Method under test: {@link ProductImpl#setCategory(Category)}
   */
  @Test
  public void testSetCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setCategory(null);

    // Assert that nothing has changed
    assertTrue(productImpl.getAllParentCategories().isEmpty());
    assertTrue(productImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(productImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(productImpl.getParentCategoryHierarchyIds().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#setCategory(Category)}
   */
  @Test
  public void testSetCategory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    CategoryImpl category = mock(CategoryImpl.class);

    // Act
    productImpl.setCategory(category);

    // Assert
    List<CategoryProductXref> allParentCategoryXrefs = productImpl.getAllParentCategoryXrefs();
    assertEquals(1, allParentCategoryXrefs.size());
    CategoryProductXref getResult = allParentCategoryXrefs.get(0);
    assertTrue(getResult instanceof CategoryProductXrefImpl);
    List<String> allParentCategoryIds = productImpl.getAllParentCategoryIds();
    assertEquals(1, allParentCategoryIds.size());
    assertEquals("0", allParentCategoryIds.get(0));
    assertNull(getResult.getId());
    assertNull(getResult.getDisplayOrder());
    List<Category> allParentCategories = productImpl.getAllParentCategories();
    assertEquals(1, allParentCategories.size());
    assertTrue(productImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(getResult.getDefaultReference());
    assertSame(productImpl, getResult.getProduct());
    assertSame(category, allParentCategories.get(0));
    assertSame(category, getResult.getCategory());
  }

  /**
   * Method under test: {@link ProductImpl#getMedia()}
   */
  @Test
  public void testGetMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertTrue(productImpl.getMedia().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getMedia()}
   */
  @Test
  public void testGetMedia2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    HashMap<String, Media> stringMediaMap = new HashMap<>();
    when(defaultSku.getSkuMedia()).thenReturn(stringMediaMap);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Map<String, Media> actualMedia = productImpl.getMedia();

    // Assert
    verify(defaultSku).getSkuMedia();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertTrue(actualMedia.isEmpty());
    assertSame(stringMediaMap, actualMedia);
  }

  /**
   * Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  public void testGetAllSellableSkus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<Sku> actualAllSellableSkus = (new ProductImpl()).getAllSellableSkus();

    // Assert
    assertEquals(1, actualAllSellableSkus.size());
    assertNull(actualAllSellableSkus.get(0));
  }

  /**
   * Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  public void testGetAllSellableSkus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(true);

    // Act
    List<Sku> actualAllSellableSkus = productImpl.getAllSellableSkus();

    // Assert
    assertEquals(1, actualAllSellableSkus.size());
    assertNull(actualAllSellableSkus.get(0));
  }

  /**
   * Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  public void testGetAllSellableSkus3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setCanSellWithoutOptions(null);

    // Act
    List<Sku> actualAllSellableSkus = productImpl.getAllSellableSkus();

    // Assert
    assertEquals(1, actualAllSellableSkus.size());
    assertNull(actualAllSellableSkus.get(0));
  }

  /**
   * Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  public void testGetAllSellableSkus4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    List<Sku> actualAllSellableSkus = productImpl.getAllSellableSkus();

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(1, actualAllSellableSkus.size());
  }

  /**
   * Method under test: {@link ProductImpl#getAllSkuMedia()}
   */
  @Test
  public void testGetAllSkuMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertTrue(productImpl.getAllSkuMedia().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getAllSkuMedia()}
   */
  @Test
  public void testGetAllSkuMedia2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getSkuMedia()).thenReturn(new HashMap<>());
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Map<String, Media> actualAllSkuMedia = productImpl.getAllSkuMedia();

    // Assert
    verify(defaultSku).getSkuMedia();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertTrue(actualAllSkuMedia.isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setAllParentCategoryXrefs(new ArrayList<>());

    // Assert
    assertEquals(1, productImpl.getAllSellableSkus().size());
    assertEquals(1, productImpl.getAllSkus().size());
    assertTrue(productImpl.getAllParentCategories().isEmpty());
    assertTrue(productImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(productImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(productImpl.getParentCategoryHierarchyIds().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<CategoryProductXref> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryProductXrefImpl());

    // Act
    productImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    List<String> allParentCategoryIds = productImpl.getAllParentCategoryIds();
    assertEquals(1, allParentCategoryIds.size());
    assertEquals("null", allParentCategoryIds.get(0));
    List<Long> parentCategoryHierarchyIds = productImpl.getParentCategoryHierarchyIds();
    assertEquals(1, parentCategoryHierarchyIds.size());
    assertNull(parentCategoryHierarchyIds.get(0));
    assertEquals(1, productImpl.getAllParentCategories().size());
    assertEquals(1, productImpl.getAllSellableSkus().size());
    assertEquals(1, productImpl.getAllSkus().size());
    assertEquals(allParentCategories, productImpl.getAllParentCategoryXrefs());
  }

  /**
   * Method under test: {@link ProductImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<CategoryProductXref> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryProductXrefImpl());
    allParentCategories.add(new CategoryProductXrefImpl());

    // Act
    productImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    List<String> allParentCategoryIds = productImpl.getAllParentCategoryIds();
    assertEquals(2, allParentCategoryIds.size());
    assertEquals("null", allParentCategoryIds.get(0));
    assertEquals("null", allParentCategoryIds.get(1));
    List<Long> parentCategoryHierarchyIds = productImpl.getParentCategoryHierarchyIds();
    assertEquals(2, parentCategoryHierarchyIds.size());
    assertNull(parentCategoryHierarchyIds.get(0));
    assertNull(parentCategoryHierarchyIds.get(1));
    assertEquals(1, productImpl.getAllSellableSkus().size());
    assertEquals(1, productImpl.getAllSkus().size());
    assertEquals(2, productImpl.getAllParentCategories().size());
    assertEquals(allParentCategories, productImpl.getAllParentCategoryXrefs());
  }

  /**
   * Method under test: {@link ProductImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<CategoryProductXref> allParentCategories = new ArrayList<>();
    allParentCategories.add(mock(CategoryProductXrefImpl.class));

    // Act
    productImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    assertNull(productImpl.allParentCategoryIds);
    List<Category> allParentCategories2 = productImpl.getAllParentCategories();
    assertEquals(1, allParentCategories2.size());
    assertNull(allParentCategories2.get(0));
    assertEquals(1, productImpl.getAllParentCategoryXrefs().size());
    assertEquals(1, productImpl.getAllSellableSkus().size());
    assertEquals(1, productImpl.getAllSkus().size());
  }

  /**
   * Method under test: {@link ProductImpl#getParentCategoryHierarchyIds()}
   */
  @Test
  public void testGetParentCategoryHierarchyIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getParentCategoryHierarchyIds().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getAllParentCategoryIds()}
   */
  @Test
  public void testGetAllParentCategoryIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    List<String> actualAllParentCategoryIds = productImpl.getAllParentCategoryIds();

    // Assert
    assertTrue(productImpl.getAdditionalSkus().isEmpty());
    assertTrue(productImpl.getAllParentCategories().isEmpty());
    assertTrue(actualAllParentCategoryIds.isEmpty());
    assertTrue(productImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(productImpl.getCrossSaleProducts().isEmpty());
    assertTrue(productImpl.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(productImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(productImpl.getProductOptionXrefs().isEmpty());
    assertTrue(productImpl.getProductOptions().isEmpty());
    assertTrue(productImpl.getSkus().isEmpty());
    assertTrue(productImpl.getFieldEntityType().getAdditionalLookupTypes().isEmpty());
    assertTrue(productImpl.allParentCategoryIds.isEmpty());
    assertTrue(productImpl.productAttributes.isEmpty());
    assertTrue(productImpl.productOptions.isEmpty());
    assertTrue(productImpl.skus.isEmpty());
    assertSame(productImpl.allParentCategoryIds, actualAllParentCategoryIds);
  }

  /**
   * Method under test: {@link ProductImpl#getAllParentCategories()}
   */
  @Test
  public void testGetAllParentCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getAllParentCategories().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setAllParentCategories(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ProductImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setAllParentCategories(allParentCategories));
  }

  /**
   * Method under test: {@link ProductImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setAllParentCategories(allParentCategories));
  }

  /**
   * Method under test: {@link ProductImpl#getDimension()}
   */
  @Test
  public void testGetDimension() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertSame(defaultSku.dimension, productImpl.getDimension());
  }

  /**
   * Method under test: {@link ProductImpl#getDimension()}
   */
  @Test
  public void testGetDimension2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.getDimension();

    // Assert
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Method under test: {@link ProductImpl#setDimension(Dimension)}
   */
  @Test
  public void testSetDimension() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);
    Dimension dimension = mock(Dimension.class);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    // Act
    productImpl.setDimension(dimension);

    // Assert
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    assertNull(productImpl.getDimensionString());
    assertNull(productImpl.getContainer());
    assertNull(productImpl.getSize());
    Money margin = productImpl.getMargin();
    assertEquals(margin, margin.zero());
    assertSame(defaultSku, productImpl.getDefaultSku());
    assertSame(dimension, productImpl.getDimension());
  }

  /**
   * Method under test: {@link ProductImpl#getWidth()}
   */
  @Test
  public void testGetWidth() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getWidth());
  }

  /**
   * Method under test: {@link ProductImpl#getWidth()}
   */
  @Test
  public void testGetWidth2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(dimension.getWidth()).thenReturn(bigDecimal);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    BigDecimal actualWidth = productImpl.getWidth();

    // Assert
    verify(dimension).getWidth();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(new BigDecimal("2.3"), actualWidth);
    assertSame(bigDecimal, actualWidth);
  }

  /**
   * Method under test: {@link ProductImpl#setWidth(BigDecimal)}
   */
  @Test
  public void testSetWidth() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);
    BigDecimal width = new BigDecimal("2.3");

    // Act
    productImpl.setWidth(width);

    // Assert
    assertEquals("nullHx2.3WxnullD\"", productImpl.getDimensionString());
    assertSame(width, productImpl.getWidth());
    Dimension expectedDimension = defaultSku.dimension;
    assertSame(expectedDimension, productImpl.getDimension());
  }

  /**
   * Method under test: {@link ProductImpl#getHeight()}
   */
  @Test
  public void testGetHeight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getHeight());
  }

  /**
   * Method under test: {@link ProductImpl#getHeight()}
   */
  @Test
  public void testGetHeight2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(dimension.getHeight()).thenReturn(bigDecimal);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    BigDecimal actualHeight = productImpl.getHeight();

    // Assert
    verify(dimension).getHeight();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(new BigDecimal("2.3"), actualHeight);
    assertSame(bigDecimal, actualHeight);
  }

  /**
   * Method under test: {@link ProductImpl#setHeight(BigDecimal)}
   */
  @Test
  public void testSetHeight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);
    BigDecimal height = new BigDecimal("2.3");

    // Act
    productImpl.setHeight(height);

    // Assert
    assertEquals("2.3HxnullWxnullD\"", productImpl.getDimensionString());
    assertSame(height, productImpl.getHeight());
    Dimension expectedDimension = defaultSku.dimension;
    assertSame(expectedDimension, productImpl.getDimension());
  }

  /**
   * Method under test: {@link ProductImpl#getDepth()}
   */
  @Test
  public void testGetDepth() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getDepth());
  }

  /**
   * Method under test: {@link ProductImpl#getDepth()}
   */
  @Test
  public void testGetDepth2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(dimension.getDepth()).thenReturn(bigDecimal);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    BigDecimal actualDepth = productImpl.getDepth();

    // Assert
    verify(dimension).getDepth();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(new BigDecimal("2.3"), actualDepth);
    assertSame(bigDecimal, actualDepth);
  }

  /**
   * Method under test: {@link ProductImpl#setDepth(BigDecimal)}
   */
  @Test
  public void testSetDepth() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);
    BigDecimal depth = new BigDecimal("2.3");

    // Act
    productImpl.setDepth(depth);

    // Assert
    assertEquals("nullHxnullWx2.3D\"", productImpl.getDimensionString());
    assertSame(depth, productImpl.getDepth());
    Dimension expectedDimension = defaultSku.dimension;
    assertSame(expectedDimension, productImpl.getDimension());
  }

  /**
   * Method under test: {@link ProductImpl#getGirth()}
   */
  @Test
  public void testGetGirth() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getGirth());
  }

  /**
   * Method under test: {@link ProductImpl#getGirth()}
   */
  @Test
  public void testGetGirth2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(dimension.getGirth()).thenReturn(bigDecimal);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    BigDecimal actualGirth = productImpl.getGirth();

    // Assert
    verify(dimension).getGirth();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(new BigDecimal("2.3"), actualGirth);
    assertSame(bigDecimal, actualGirth);
  }

  /**
   * Method under test: {@link ProductImpl#setGirth(BigDecimal)}
   */
  @Test
  public void testSetGirth() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);
    BigDecimal girth = new BigDecimal("2.3");

    // Act
    productImpl.setGirth(girth);

    // Assert
    Dimension dimension = productImpl.getDimension();
    assertSame(girth, dimension.getGirth());
    assertSame(girth, productImpl.getGirth());
    assertSame(defaultSku.dimension, dimension);
  }

  /**
   * Method under test: {@link ProductImpl#getSize()}
   */
  @Test
  public void testGetSize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    ContainerSizeType containerSizeType = new ContainerSizeType();
    when(dimension.getSize()).thenReturn(containerSizeType);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    ContainerSizeType actualSize = productImpl.getSize();

    // Assert
    verify(dimension).getSize();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertSame(containerSizeType, actualSize);
  }

  /**
   * Method under test: {@link ProductImpl#getContainer()}
   */
  @Test
  public void testGetContainer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    ContainerShapeType containerShapeType = new ContainerShapeType();
    when(dimension.getContainer()).thenReturn(containerShapeType);
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    ContainerShapeType actualContainer = productImpl.getContainer();

    // Assert
    verify(dimension).getContainer();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertSame(containerShapeType, actualContainer);
  }

  /**
   * Method under test: {@link ProductImpl#getDimensionString()}
   */
  @Test
  public void testGetDimensionString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertEquals("nullHxnullWxnullD\"", productImpl.getDimensionString());
  }

  /**
   * Method under test: {@link ProductImpl#getDimensionString()}
   */
  @Test
  public void testGetDimensionString2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Dimension dimension = mock(Dimension.class);
    when(dimension.getDimensionString()).thenReturn("Dimension String");
    doNothing().when(dimension).setSize(Mockito.<ContainerSizeType>any());
    doNothing().when(dimension).setWidth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setContainer(Mockito.<ContainerShapeType>any());
    doNothing().when(dimension).setDepth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setDimensionUnitOfMeasure(Mockito.<DimensionUnitOfMeasureType>any());
    doNothing().when(dimension).setGirth(Mockito.<BigDecimal>any());
    doNothing().when(dimension).setHeight(Mockito.<BigDecimal>any());
    dimension.setContainer(mock(ContainerShapeType.class));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getDimension()).thenReturn(dimension);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualDimensionString = productImpl.getDimensionString();

    // Assert
    verify(dimension).getDimensionString();
    verify(dimension).setContainer(isA(ContainerShapeType.class));
    verify(dimension).setDepth(isA(BigDecimal.class));
    verify(dimension).setDimensionUnitOfMeasure(isA(DimensionUnitOfMeasureType.class));
    verify(dimension).setGirth(isA(BigDecimal.class));
    verify(dimension).setHeight(isA(BigDecimal.class));
    verify(dimension).setSize(isA(ContainerSizeType.class));
    verify(dimension).setWidth(isA(BigDecimal.class));
    verify(defaultSku).getDimension();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("Dimension String", actualDimensionString);
  }

  /**
   * Method under test: {@link ProductImpl#getWeight()}
   */
  @Test
  public void testGetWeight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertSame(defaultSku.weight, productImpl.getWeight());
  }

  /**
   * Method under test: {@link ProductImpl#getWeight()}
   */
  @Test
  public void testGetWeight2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getWeight()).thenReturn(weight);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Weight actualWeight = productImpl.getWeight();

    // Assert
    verify(defaultSku).getWeight();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertSame(weight, actualWeight);
  }

  /**
   * Method under test: {@link ProductImpl#setWeight(Weight)}
   */
  @Test
  public void testSetWeight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);
    Weight weight = mock(Weight.class);
    doNothing().when(weight).setWeight(Mockito.<BigDecimal>any());
    doNothing().when(weight).setWeightUnitOfMeasure(Mockito.<WeightUnitOfMeasureType>any());
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act
    productImpl.setWeight(weight);

    // Assert
    verify(weight).setWeight(isA(BigDecimal.class));
    verify(weight).setWeightUnitOfMeasure(isA(WeightUnitOfMeasureType.class));
    Money margin = productImpl.getMargin();
    assertEquals(margin, margin.zero());
    assertSame(defaultSku, productImpl.getDefaultSku());
    assertSame(weight, productImpl.getWeight());
  }

  /**
   * Method under test: {@link ProductImpl#setCrossSaleProducts(List)}
   */
  @Test
  public void testSetCrossSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setCrossSaleProducts(new ArrayList<>());

    // Assert
    assertTrue(productImpl.getCrossSaleProducts().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#setCrossSaleProducts(List)}
   */
  @Test
  public void testSetCrossSaleProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<RelatedProduct> crossSaleProducts = new ArrayList<>();
    crossSaleProducts.add(mock(CrossSaleProductImpl.class));

    // Act
    productImpl.setCrossSaleProducts(crossSaleProducts);

    // Assert
    assertEquals(1, productImpl.getCrossSaleProducts().size());
  }

  /**
   * Method under test: {@link ProductImpl#setUpSaleProducts(List)}
   */
  @Test
  public void testSetUpSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();

    // Act
    productImpl.setUpSaleProducts(upSaleProducts);

    // Assert
    FieldEntity fieldEntityType = productImpl.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals(1, productImpl.getAllSkus().size());
    assertTrue(upSaleProducts.isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(productImpl.getProductOptionValuesMap().isEmpty());
    assertSame(upSaleProducts, productImpl.getCumulativeUpSaleProducts());
    assertSame(upSaleProducts, productImpl.getUpSaleProducts());
  }

  /**
   * Method under test: {@link ProductImpl#setUpSaleProducts(List)}
   */
  @Test
  public void testSetUpSaleProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    upSaleProducts.add(mock(CrossSaleProductImpl.class));

    // Act
    productImpl.setUpSaleProducts(upSaleProducts);

    // Assert
    FieldEntity fieldEntityType = productImpl.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals(1, upSaleProducts.size());
    assertEquals(1, productImpl.getAllSkus().size());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(productImpl.getProductOptionValuesMap().isEmpty());
    assertSame(upSaleProducts, productImpl.getUpSaleProducts());
  }

  /**
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(productImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeCrossSaleProducts()).thenReturn(new ArrayList<>());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = productImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultCategory).getCumulativeCrossSaleProducts();
    assertTrue(actualCumulativeCrossSaleProducts.isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = productImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultCategory).getCumulativeCrossSaleProducts();
    assertTrue(actualCumulativeCrossSaleProducts.isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeCrossSaleProducts()).thenThrow(new UnsupportedOperationException("foo"));

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getCumulativeCrossSaleProducts());
    verify(defaultCategory).getCumulativeCrossSaleProducts();
  }

  /**
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(productImpl.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeUpSaleProducts()).thenReturn(new ArrayList<>());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = productImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultCategory).getCumulativeUpSaleProducts();
    assertTrue(actualCumulativeUpSaleProducts.isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeUpSaleProducts()).thenReturn(relatedProductList);

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = productImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultCategory).getCumulativeUpSaleProducts();
    assertTrue(actualCumulativeUpSaleProducts.isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeUpSaleProducts()).thenThrow(new UnsupportedOperationException("foo"));

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getCumulativeUpSaleProducts());
    verify(defaultCategory).getCumulativeUpSaleProducts();
  }

  /**
   * Method under test: {@link ProductImpl#getProductAttributes()}
   */
  @Test
  public void testGetProductAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getProductAttributes().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getMultiValueProductAttributes()}
   */
  @Test
  public void testGetMultiValueProductAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getMultiValueProductAttributes().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#setProductAttributes(Map)}
   */
  @Test
  public void testSetProductAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setProductAttributes(new HashMap<>());

    // Assert
    assertTrue(productImpl.getAdditionalSkus().isEmpty());
    assertTrue(productImpl.getAllParentCategories().isEmpty());
    assertTrue(productImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(productImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(productImpl.getCrossSaleProducts().isEmpty());
    assertTrue(productImpl.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(productImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(productImpl.getProductOptionXrefs().isEmpty());
    assertTrue(productImpl.getProductOptions().isEmpty());
    assertTrue(productImpl.getSkus().isEmpty());
    assertTrue(productImpl.getFieldEntityType().getAdditionalLookupTypes().isEmpty());
    assertTrue(productImpl.productAttributes.isEmpty());
    assertTrue(productImpl.skus.isEmpty());
    assertTrue(productImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(productImpl.getProductAttributes().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#setProductAttributes(Map)}
   */
  @Test
  public void testSetProductAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    HashMap<String, ProductAttribute> productAttributes = new HashMap<>();
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributes.put("foo", productAttributeImpl);

    // Act
    productImpl.setProductAttributes(productAttributes);

    // Assert
    List<ProductAttribute> productAttributeList = productImpl.productAttributes;
    assertEquals(1, productAttributeList.size());
    Map<String, ProductAttribute> multiValueProductAttributes = productImpl.getMultiValueProductAttributes();
    assertEquals(1, multiValueProductAttributes.size());
    Map<String, ProductAttribute> productAttributes2 = productImpl.getProductAttributes();
    assertEquals(1, productAttributes2.size());
    assertTrue(productImpl.getAdditionalSkus().isEmpty());
    assertTrue(productImpl.getAllParentCategories().isEmpty());
    assertTrue(productImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(productImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(productImpl.getCrossSaleProducts().isEmpty());
    assertTrue(productImpl.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(productImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(productImpl.getProductOptionXrefs().isEmpty());
    assertTrue(productImpl.getProductOptions().isEmpty());
    assertTrue(productImpl.getSkus().isEmpty());
    assertTrue(productImpl.getFieldEntityType().getAdditionalLookupTypes().isEmpty());
    assertTrue(productImpl.skus.isEmpty());
    List<ProductAttribute> expectedGetResult = productImpl.productAttributes;
    assertEquals(expectedGetResult, multiValueProductAttributes.get(null));
    assertSame(productAttributeImpl, productAttributeList.get(0));
    assertSame(productAttributeImpl, productAttributes2.get(null));
  }

  /**
   * Method under test: {@link ProductImpl#setProductAttributes(Map)}
   */
  @Test
  public void testSetProductAttributes3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    HashMap<String, ProductAttribute> productAttributes = new HashMap<>();
    productAttributes.computeIfPresent("foo", mock(BiFunction.class));
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributes.put("foo", productAttributeImpl);

    // Act
    productImpl.setProductAttributes(productAttributes);

    // Assert
    List<ProductAttribute> productAttributeList = productImpl.productAttributes;
    assertEquals(1, productAttributeList.size());
    Map<String, ProductAttribute> multiValueProductAttributes = productImpl.getMultiValueProductAttributes();
    assertEquals(1, multiValueProductAttributes.size());
    Map<String, ProductAttribute> productAttributes2 = productImpl.getProductAttributes();
    assertEquals(1, productAttributes2.size());
    assertTrue(productImpl.getAdditionalSkus().isEmpty());
    assertTrue(productImpl.getAllParentCategories().isEmpty());
    assertTrue(productImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(productImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(productImpl.getCrossSaleProducts().isEmpty());
    assertTrue(productImpl.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(productImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(productImpl.getProductOptionXrefs().isEmpty());
    assertTrue(productImpl.getProductOptions().isEmpty());
    assertTrue(productImpl.getSkus().isEmpty());
    assertTrue(productImpl.getFieldEntityType().getAdditionalLookupTypes().isEmpty());
    assertTrue(productImpl.skus.isEmpty());
    List<ProductAttribute> expectedGetResult = productImpl.productAttributes;
    assertEquals(expectedGetResult, multiValueProductAttributes.get(null));
    assertSame(productAttributeImpl, productAttributeList.get(0));
    assertSame(productAttributeImpl, productAttributes2.get(null));
  }

  /**
   * Method under test: {@link ProductImpl#getProductOptionXrefs()}
   */
  @Test
  public void testGetProductOptionXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getProductOptionXrefs().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#getProductOptions()}
   */
  @Test
  public void testGetProductOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ProductImpl()).getProductOptions().isEmpty());
  }

  /**
   * Method under test: {@link ProductImpl#setProductOptions(List)}
   */
  @Test
  public void testSetProductOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setProductOptions(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ProductImpl#setProductOptions(List)}
   */
  @Test
  public void testSetProductOptions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<ProductOption> productOptions = new ArrayList<>();
    productOptions.add(new ProductOptionImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setProductOptions(productOptions));
  }

  /**
   * Method under test: {@link ProductImpl#setProductOptions(List)}
   */
  @Test
  public void testSetProductOptions3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    ArrayList<ProductOption> productOptions = new ArrayList<>();
    productOptions.add(new ProductOptionImpl());
    productOptions.add(new ProductOptionImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.setProductOptions(productOptions));
  }

  /**
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getUrl());
  }

  /**
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", productImpl.getUrl());
  }

  /**
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//null", actualUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//https://example.org/example", actualUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenThrow(new UnsupportedOperationException("foo"));

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getUrl());
    verify(defaultCategory).getGeneratedUrl();
  }

  /**
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//name", actualUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(" ");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//-", actualUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("[^A-Za-z0-9/-]");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//a-za-z0-9/-", actualUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("//");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("//name", actualUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  public void testGetUrl10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn(null);
    Sku defaultSku = mock(Sku.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory).getGeneratedUrl();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertNull(actualUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getOverrideGeneratedUrl()}
   */
  @Test
  public void testGetOverrideGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductImpl()).getOverrideGeneratedUrl());
  }

  /**
   * Method under test: {@link ProductImpl#getOverrideGeneratedUrl()}
   */
  @Test
  public void testGetOverrideGeneratedUrl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setOverrideGeneratedUrl(true);

    // Act and Assert
    assertTrue(productImpl.getOverrideGeneratedUrl());
  }

  /**
   * Method under test: {@link ProductImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setOverrideGeneratedUrl(true);

    // Assert
    assertTrue(productImpl.getOverrideGeneratedUrl());
    assertTrue(productImpl.overrideGeneratedUrl);
  }

  /**
   * Method under test: {@link ProductImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedUrl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setOverrideGeneratedUrl(null);

    // Assert
    assertFalse(productImpl.getOverrideGeneratedUrl());
    assertFalse(productImpl.overrideGeneratedUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new ProductImpl()).getArchived().charValue());
  }

  /**
   * Method under test: {@link ProductImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setArchived('A');

    // Assert
    assertEquals('A', productImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', productImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link ProductImpl#getProductOptionValuesMap()}
   */
  @Test
  public void testGetProductOptionValuesMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    Map<String, Set<String>> actualProductOptionValuesMap = productImpl.getProductOptionValuesMap();

    // Assert
    assertTrue(productImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(productImpl.getProductAttributes().isEmpty());
    assertTrue(actualProductOptionValuesMap.isEmpty());
    assertSame(productImpl.productOptionMap, actualProductOptionValuesMap);
  }

  /**
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getUrlKey());
  }

  /**
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrlKey("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", productImpl.getUrlKey());
  }

  /**
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualUrlKey = productImpl.getUrlKey();

    // Assert
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("name", actualUrlKey);
  }

  /**
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(" ");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualUrlKey = productImpl.getUrlKey();

    // Assert
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("-", actualUrlKey);
  }

  /**
   * Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("[^A-Za-z0-9/-]");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualUrlKey = productImpl.getUrlKey();

    // Assert
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("a-za-z0-9/-", actualUrlKey);
  }

  /**
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getGeneratedUrl());
  }

  /**
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//null", actualGeneratedUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//https://example.org/example", actualGeneratedUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenThrow(new UnsupportedOperationException("foo"));

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getGeneratedUrl());
    verify(defaultCategory).getGeneratedUrl();
  }

  /**
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//name", actualGeneratedUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(" ");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//-", actualGeneratedUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("[^A-Za-z0-9/-]");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//a-za-z0-9/-", actualGeneratedUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("//");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("//name", actualGeneratedUrl);
  }

  /**
   * Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn(null);
    Sku defaultSku = mock(Sku.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory).getGeneratedUrl();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertNull(actualGeneratedUrl);
  }

  /**
   * Method under test: {@link ProductImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).clearDynamicPrices();
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.clearDynamicPrices();

    // Assert
    verify(defaultSku).clearDynamicPrices();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Method under test: {@link ProductImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getMainEntityName());
  }

  /**
   * Method under test: {@link ProductImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualMainEntityName = productImpl.getMainEntityName();

    // Assert
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("Name", actualMainEntityName);
  }

  /**
   * Method under test:
   * {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(new HashMap<>());
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Product> actualCreateOrRetrieveCopyInstanceResult = productImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test:
   * {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", "PROPAGATION");
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Product> actualCreateOrRetrieveCopyInstanceResult = productImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context, atLeast(1)).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test: {@link ProductImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getTaxCode());
  }

  /**
   * Method under test: {@link ProductImpl#getTaxCode()}
   */
  @Test
  public void testGetTaxCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.getTaxCode()).thenReturn("Tax Code");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualTaxCode = productImpl.getTaxCode();

    // Assert
    verify(defaultSku).getTaxCode();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("Tax Code", actualTaxCode);
  }

  /**
   * Method under test: {@link ProductImpl#setTaxCode(String)}
   */
  @Test
  public void testSetTaxCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setTaxCode("Tax Code");

    // Assert
    assertEquals("Tax Code", productImpl.getTaxCode());
    assertSame(defaultSku, productImpl.getDefaultSku());
  }

  /**
   * Method under test: {@link ProductImpl#setTaxCode(String)}
   */
  @Test
  public void testSetTaxCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());
    doNothing().when(defaultSku).setTaxCode(Mockito.<String>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    productImpl.setTaxCode("Tax Code");

    // Assert
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    verify(defaultSku).setTaxCode(eq("Tax Code"));
    assertNull(productImpl.getTaxCode());
  }

  /**
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductImpl()).getLocation());
  }

  /**
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", productImpl.getLocation());
  }

  /**
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//null", actualLocation);
  }

  /**
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrlKey("https://example.org/example");
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//https://example.org/example", actualLocation);
  }

  /**
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenThrow(new UnsupportedOperationException("foo"));

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getLocation());
    verify(defaultCategory).getGeneratedUrl();
  }

  /**
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//name", actualLocation);
  }

  /**
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(" ");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//-", actualLocation);
  }

  /**
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("[^A-Za-z0-9/-]");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//a-za-z0-9/-", actualLocation);
  }

  /**
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("//");
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn("Name");
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku, atLeast(1)).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("//name", actualLocation);
  }

  /**
   * Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  public void testGetLocation10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn(null);
    Sku defaultSku = mock(Sku.class);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory).getGeneratedUrl();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertNull(actualLocation);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductImpl#setCanSellWithoutOptions(Boolean)}
   *   <li>{@link ProductImpl#setCanonicalUrl(String)}
   *   <li>{@link ProductImpl#setDefaultCategory(Category)}
   *   <li>{@link ProductImpl#setDisplayTemplate(String)}
   *   <li>{@link ProductImpl#setId(Long)}
   *   <li>{@link ProductImpl#setManufacturer(String)}
   *   <li>{@link ProductImpl#setMetaDescription(String)}
   *   <li>{@link ProductImpl#setMetaTitle(String)}
   *   <li>{@link ProductImpl#setModel(String)}
   *   <li>{@link ProductImpl#setProductOptionXrefs(List)}
   *   <li>{@link ProductImpl#setPromoMessage(String)}
   *   <li>{@link ProductImpl#setUrl(String)}
   *   <li>{@link ProductImpl#setUrlKey(String)}
   *   <li>{@link ProductImpl#getAdditionalSkus()}
   *   <li>{@link ProductImpl#getAllParentCategoryXrefs()}
   *   <li>{@link ProductImpl#getCanonicalUrl()}
   *   <li>{@link ProductImpl#getCrossSaleProducts()}
   *   <li>{@link ProductImpl#getDefaultSku()}
   *   <li>{@link ProductImpl#getDisplayTemplate()}
   *   <li>{@link ProductImpl#getFieldEntityType()}
   *   <li>{@link ProductImpl#getId()}
   *   <li>{@link ProductImpl#getManufacturer()}
   *   <li>{@link ProductImpl#getMetaDescription()}
   *   <li>{@link ProductImpl#getMetaTitle()}
   *   <li>{@link ProductImpl#getModel()}
   *   <li>{@link ProductImpl#getPromoMessage()}
   *   <li>{@link ProductImpl#getUpSaleProducts()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();

    // Act
    productImpl.setCanSellWithoutOptions(true);
    productImpl.setCanonicalUrl("https://example.org/example");
    productImpl.setDefaultCategory(new CategoryImpl());
    productImpl.setDisplayTemplate("Display Template");
    productImpl.setId(1L);
    productImpl.setManufacturer("Manufacturer");
    productImpl.setMetaDescription("Meta Description");
    productImpl.setMetaTitle("Dr");
    productImpl.setModel("Model");
    productImpl.setProductOptionXrefs(new ArrayList<>());
    productImpl.setPromoMessage("Promo Message");
    productImpl.setUrl("https://example.org/example");
    productImpl.setUrlKey("https://example.org/example");
    List<Sku> actualAdditionalSkus = productImpl.getAdditionalSkus();
    List<CategoryProductXref> actualAllParentCategoryXrefs = productImpl.getAllParentCategoryXrefs();
    String actualCanonicalUrl = productImpl.getCanonicalUrl();
    List<RelatedProduct> actualCrossSaleProducts = productImpl.getCrossSaleProducts();
    productImpl.getDefaultSku();
    String actualDisplayTemplate = productImpl.getDisplayTemplate();
    FieldEntity actualFieldEntityType = productImpl.getFieldEntityType();
    Long actualId = productImpl.getId();
    String actualManufacturer = productImpl.getManufacturer();
    String actualMetaDescription = productImpl.getMetaDescription();
    String actualMetaTitle = productImpl.getMetaTitle();
    String actualModel = productImpl.getModel();
    String actualPromoMessage = productImpl.getPromoMessage();
    List<RelatedProduct> actualUpSaleProducts = productImpl.getUpSaleProducts();

    // Assert that nothing has changed
    assertEquals("Display Template", actualDisplayTemplate);
    assertEquals("Dr", actualMetaTitle);
    assertEquals("Manufacturer", actualManufacturer);
    assertEquals("Meta Description", actualMetaDescription);
    assertEquals("Model", actualModel);
    assertEquals("Promo Message", actualPromoMessage);
    assertEquals("https://example.org/example", actualCanonicalUrl);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalSkus.isEmpty());
    assertTrue(actualAllParentCategoryXrefs.isEmpty());
    assertTrue(actualCrossSaleProducts.isEmpty());
    assertTrue(actualUpSaleProducts.isEmpty());
    assertSame(actualFieldEntityType.PRODUCT, actualFieldEntityType);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ProductImpl}
   */
  @Test
  public void testNewProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProductImpl actualProductImpl = new ProductImpl();

    // Assert
    FieldEntity fieldEntityType = actualProductImpl.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals('N', actualProductImpl.archiveStatus.getArchived().charValue());
    assertEquals('N', actualProductImpl.getArchived().charValue());
    assertNull(actualProductImpl.getId());
    assertNull(actualProductImpl.getCanonicalUrl());
    assertNull(actualProductImpl.getDisplayTemplate());
    assertNull(actualProductImpl.getGeneratedUrl());
    assertNull(actualProductImpl.getLocation());
    assertNull(actualProductImpl.getManufacturer());
    assertNull(actualProductImpl.getMetaDescription());
    assertNull(actualProductImpl.getMetaTitle());
    assertNull(actualProductImpl.getModel());
    assertNull(actualProductImpl.getPromoMessage());
    assertNull(actualProductImpl.getUrl());
    assertNull(actualProductImpl.url);
    assertNull(actualProductImpl.urlKey);
    assertNull(actualProductImpl.getPrice());
    assertNull(actualProductImpl.getRetailPrice());
    assertNull(actualProductImpl.getRetailPriceInternal());
    assertNull(actualProductImpl.getSalePrice());
    assertNull(actualProductImpl.getSalePriceInternal());
    assertNull(actualProductImpl.getCategory());
    assertNull(actualProductImpl.getDefaultCategory());
    assertNull(actualProductImpl.defaultCategory);
    List<Sku> allSellableSkus = actualProductImpl.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    List<Sku> allSkus = actualProductImpl.getAllSkus();
    assertEquals(1, allSkus.size());
    assertNull(allSkus.get(0));
    assertNull(actualProductImpl.getDefaultSku());
    assertFalse(actualProductImpl.getCanSellWithoutOptions());
    assertFalse(actualProductImpl.getOverrideGeneratedUrl());
    assertFalse(actualProductImpl.hasRetailPrice());
    assertFalse(actualProductImpl.canSellWithoutOptions);
    assertFalse(actualProductImpl.isFeaturedProduct);
    assertFalse(actualProductImpl.overrideGeneratedUrl);
    assertTrue(actualProductImpl.getAdditionalSkus().isEmpty());
    assertTrue(actualProductImpl.getAllParentCategories().isEmpty());
    assertTrue(actualProductImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(actualProductImpl.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = actualProductImpl.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = actualProductImpl.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(actualProductImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(actualProductImpl.getProductOptionXrefs().isEmpty());
    assertTrue(actualProductImpl.getProductOptions().isEmpty());
    assertTrue(actualProductImpl.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(actualProductImpl.productAttributes.isEmpty());
    assertTrue(actualProductImpl.productOptions.isEmpty());
    assertTrue(actualProductImpl.skus.isEmpty());
    assertTrue(actualProductImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(actualProductImpl.getProductAttributes().isEmpty());
    Map<String, Set<String>> productOptionValuesMap = actualProductImpl.getProductOptionValuesMap();
    assertTrue(productOptionValuesMap.isEmpty());
    assertSame(crossSaleProducts, actualProductImpl.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, actualProductImpl.getUpSaleProducts());
    assertSame(productOptionValuesMap, actualProductImpl.productOptionMap);
  }
}
