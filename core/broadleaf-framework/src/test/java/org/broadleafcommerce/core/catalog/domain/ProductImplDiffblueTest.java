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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductImplDiffblueTest {
  /**
   * Test {@link ProductImpl#getName()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getName()"})
  public void testGetName_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getName());
  }

  /**
   * Test {@link ProductImpl#getName()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getName()"})
  public void testGetName_givenSkuGetNameReturnName_thenReturnName() {
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
   * Test {@link ProductImpl#getName()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getName()"})
  public void testGetName_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertNull(productImpl.getName());
  }

  /**
   * Test {@link ProductImpl#setName(String)}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setName(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setName(String)"})
  public void testSetName_givenProductImplDefaultSkuIsSkuImpl_thenProductImplDefaultSkuSkuImpl() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act
    productImpl.setName("Name");

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertEquals("Name", productImpl.getMainEntityName());
    assertEquals("Name", productImpl.getName());
    assertEquals("Name", defaultSku.getName());
    assertEquals("Name", ((SkuImpl) defaultSku).name);
    assertEquals("name", productImpl.getUrlKey());
  }

  /**
   * Test {@link ProductImpl#getDescription()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getDescription()"})
  public void testGetDescription_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getDescription());
  }

  /**
   * Test {@link ProductImpl#getDescription()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getDescription()"})
  public void testGetDescription_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertNull(productImpl.getDescription());
  }

  /**
   * Test {@link ProductImpl#getDescription()}.
   *
   * <ul>
   *   <li>Then return {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getDescription()"})
  public void testGetDescription_thenReturnTheCharacteristicsOfSomeoneOrSomething() {
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
   * Test {@link ProductImpl#setDescription(String)}.
   *
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setDescription(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setDescription(String)"})
  public void testSetDescription_thenProductImplDefaultSkuSkuImpl() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act
    productImpl.setDescription("The characteristics of someone or something");

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertEquals("The characteristics of someone or something", productImpl.getDescription());
    assertEquals("The characteristics of someone or something", defaultSku.getDescription());
    assertEquals("The characteristics of someone or something", ((SkuImpl) defaultSku).description);
  }

  /**
   * Test {@link ProductImpl#getLongDescription()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLongDescription()"})
  public void testGetLongDescription_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getLongDescription());
  }

  /**
   * Test {@link ProductImpl#getLongDescription()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLongDescription()"})
  public void testGetLongDescription_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertNull(productImpl.getLongDescription());
  }

  /**
   * Test {@link ProductImpl#getLongDescription()}.
   *
   * <ul>
   *   <li>Then return {@code Long Description}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLongDescription()"})
  public void testGetLongDescription_thenReturnLongDescription() {
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
   * Test {@link ProductImpl#setLongDescription(String)}.
   *
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setLongDescription(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setLongDescription(String)"})
  public void testSetLongDescription_thenProductImplDefaultSkuSkuImpl() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act
    productImpl.setLongDescription("Long Description");

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertEquals("Long Description", productImpl.getLongDescription());
    assertEquals("Long Description", defaultSku.getLongDescription());
    assertEquals("Long Description", ((SkuImpl) defaultSku).longDescription);
  }

  /**
   * Test {@link ProductImpl#getActiveStartDate()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date ProductImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getActiveStartDate());
  }

  /**
   * Test {@link ProductImpl#getActiveStartDate()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date ProductImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertNull(productImpl.getActiveStartDate());
  }

  /**
   * Test {@link ProductImpl#setActiveStartDate(Date)}.
   *
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setActiveStartDate(Date)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setActiveStartDate(Date)"})
  public void testSetActiveStartDate_thenProductImplDefaultSkuSkuImpl() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    Date activeStartDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    productImpl.setActiveStartDate(activeStartDate);

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertSame(activeStartDate, productImpl.getActiveStartDate());
    assertSame(activeStartDate, defaultSku.getActiveStartDate());
    assertSame(activeStartDate, ((SkuImpl) defaultSku).activeStartDate);
  }

  /**
   * Test {@link ProductImpl#getActiveEndDate()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getActiveEndDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date ProductImpl.getActiveEndDate()"})
  public void testGetActiveEndDate_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getActiveEndDate());
  }

  /**
   * Test {@link ProductImpl#getActiveEndDate()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getActiveEndDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date ProductImpl.getActiveEndDate()"})
  public void testGetActiveEndDate_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertNull(productImpl.getActiveEndDate());
  }

  /**
   * Test {@link ProductImpl#setActiveEndDate(Date)}.
   *
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setActiveEndDate(Date)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setActiveEndDate(Date)"})
  public void testSetActiveEndDate_thenProductImplDefaultSkuSkuImpl() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    Date activeEndDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    productImpl.setActiveEndDate(activeEndDate);

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertSame(activeEndDate, productImpl.getActiveEndDate());
    assertSame(activeEndDate, defaultSku.getActiveEndDate());
    assertSame(activeEndDate, ((SkuImpl) defaultSku).activeEndDate);
  }

  /**
   * Test {@link ProductImpl#isActive()}.
   *
   * <p>Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductImpl.isActive()"})
  public void testIsActive() {
    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(defaultSku.getActiveStartDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * Test {@link ProductImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) Archived is {@code Y}.
   *   <li>Then calls {@link Sku#getActiveEndDate()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductImpl.isActive()"})
  public void testIsActive_givenProductImplArchivedIsY_thenCallsGetActiveEndDate() {
    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getActiveEndDate()).thenReturn(new Date());
    when(defaultSku.getActiveStartDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setArchived('Y');
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
   * Test {@link ProductImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductImpl.isActive()"})
  public void testIsActive_givenProductImplDefaultSkuIsSkuImpl_thenReturnFalse() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertFalse(productImpl.isActive());
  }

  /**
   * Test {@link ProductImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getActiveStartDate()} return {@link Date#Date()}.
   *   <li>Then calls {@link Sku#getActiveEndDate()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductImpl.isActive()"})
  public void testIsActive_givenSkuGetActiveStartDateReturnDate_thenCallsGetActiveEndDate() {
    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getActiveEndDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(defaultSku.getActiveStartDate()).thenReturn(new Date());
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
   * Test {@link ProductImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductImpl.isActive()"})
  public void testIsActive_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertFalse(productImpl.isActive());
  }

  /**
   * Test {@link ProductImpl#isFeaturedProduct()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) FeaturedProduct is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#isFeaturedProduct()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductImpl.isFeaturedProduct()"})
  public void testIsFeaturedProduct_givenProductImplFeaturedProductIsTrue_thenReturnTrue() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setFeaturedProduct(true);

    // Act and Assert
    assertTrue(productImpl.isFeaturedProduct());
  }

  /**
   * Test {@link ProductImpl#isOnSale()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductImpl.isOnSale()"})
  public void testIsOnSale_givenProductImplDefaultSkuIsSkuImpl_thenReturnFalse() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertFalse(productImpl.isOnSale());
  }

  /**
   * Test {@link ProductImpl#isOnSale()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertFalse(productImpl.isOnSale());
  }

  /**
   * Test {@link ProductImpl#isOnSale()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplSalePriceIsMoney_thenReturnFalse() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setSalePrice(new Money());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertFalse(productImpl.isOnSale());
  }

  /**
   * Test {@link ProductImpl#isOnSale()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#isOnSale()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#isOnSale()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductImpl.isOnSale()"})
  public void testIsOnSale_givenSkuIsOnSaleReturnTrue_thenReturnTrue() {
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
   * Test {@link ProductImpl#getMargin()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return abs is {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductImpl.getMargin()"})
  public void testGetMargin_givenProductImplDefaultSkuIsSkuImpl_thenReturnAbsIsZero() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act
    Money actualMargin = productImpl.getMargin();

    // Assert
    Money money = Money.ZERO;
    assertEquals(money, actualMargin.abs());
    assertEquals(money, actualMargin.zero());
  }

  /**
   * Test {@link ProductImpl#getMargin()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return abs is {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductImpl.getMargin()"})
  public void testGetMargin_givenSkuImplProductIsProductBundleImpl_thenReturnAbsIsZero() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Money actualMargin = productImpl.getMargin();

    // Assert
    Money money = Money.ZERO;
    assertEquals(money, actualMargin.abs());
    assertEquals(money, actualMargin.zero());
  }

  /**
   * Test {@link ProductImpl#getMargin()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link SkuImpl} (default constructor) {@link
   *       SkuImpl#retailPrice}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductImpl.getMargin()"})
  public void testGetMargin_thenReturnAbsAbsAbsAmountIsSkuImplRetailPrice() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setRetailPrice(new Money());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Money actualMargin = productImpl.getMargin();

    // Assert
    BigDecimal bigDecimal = defaultSku.retailPrice;
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
   * Test {@link ProductImpl#getMargin()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link SkuImpl} (default constructor) {@link
   *       SkuImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getMargin()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductImpl.getMargin()"})
  public void testGetMargin_thenReturnAbsAbsAbsAmountIsSkuImplSalePrice() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setSalePrice(new Money());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    Money actualMargin = productImpl.getMargin();

    // Assert
    BigDecimal bigDecimal = defaultSku.salePrice;
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
   * Test {@link ProductImpl#getExternalId()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getExternalId()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getExternalId()"})
  public void testGetExternalId_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getExternalId());
  }

  /**
   * Test {@link ProductImpl#getAllSellableSkus()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) CanSellWithoutOptions is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductImpl.getAllSellableSkus()"})
  public void testGetAllSellableSkus_givenProductImplCanSellWithoutOptionsIsNull() {
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
   * Test {@link ProductImpl#getAllSellableSkus()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) CanSellWithoutOptions is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getAllSellableSkus()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductImpl.getAllSellableSkus()"})
  public void testGetAllSellableSkus_givenProductImplCanSellWithoutOptionsIsTrue() {
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ProductImpl.getAdditionalSkus()",
    "List ProductImpl.getAllParentCategoryXrefs()",
    "String ProductImpl.getCanonicalUrl()",
    "List ProductImpl.getCrossSaleProducts()",
    "Sku ProductImpl.getDefaultSku()",
    "String ProductImpl.getDisplayTemplate()",
    "FieldEntity ProductImpl.getFieldEntityType()",
    "Long ProductImpl.getId()",
    "String ProductImpl.getManufacturer()",
    "String ProductImpl.getMetaDescription()",
    "String ProductImpl.getMetaTitle()",
    "String ProductImpl.getModel()",
    "String ProductImpl.getPromoMessage()",
    "List ProductImpl.getUpSaleProducts()",
    "void ProductImpl.setCanSellWithoutOptions(Boolean)",
    "void ProductImpl.setCanonicalUrl(String)",
    "void ProductImpl.setDefaultCategory(Category)",
    "void ProductImpl.setDisplayTemplate(String)",
    "void ProductImpl.setId(Long)",
    "void ProductImpl.setManufacturer(String)",
    "void ProductImpl.setMetaDescription(String)",
    "void ProductImpl.setMetaTitle(String)",
    "void ProductImpl.setModel(String)",
    "void ProductImpl.setProductOptionXrefs(List)",
    "void ProductImpl.setPromoMessage(String)",
    "void ProductImpl.setUrl(String)",
    "void ProductImpl.setUrlKey(String)"
  })
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
    List<CategoryProductXref> actualAllParentCategoryXrefs =
        productImpl.getAllParentCategoryXrefs();
    String actualCanonicalUrl = productImpl.getCanonicalUrl();
    List<RelatedProduct> actualCrossSaleProducts = productImpl.getCrossSaleProducts();
    Sku actualDefaultSku = productImpl.getDefaultSku();
    String actualDisplayTemplate = productImpl.getDisplayTemplate();
    FieldEntity actualFieldEntityType = productImpl.getFieldEntityType();
    Long actualId = productImpl.getId();
    String actualManufacturer = productImpl.getManufacturer();
    String actualMetaDescription = productImpl.getMetaDescription();
    String actualMetaTitle = productImpl.getMetaTitle();
    String actualModel = productImpl.getModel();
    String actualPromoMessage = productImpl.getPromoMessage();
    List<RelatedProduct> actualUpSaleProducts = productImpl.getUpSaleProducts();

    // Assert
    assertEquals("Display Template", actualDisplayTemplate);
    assertEquals("Dr", actualMetaTitle);
    assertEquals("Manufacturer", actualManufacturer);
    assertEquals("Meta Description", actualMetaDescription);
    assertEquals("Model", actualModel);
    assertEquals("Promo Message", actualPromoMessage);
    assertEquals("https://example.org/example", actualCanonicalUrl);
    assertNull(actualDefaultSku);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalSkus.isEmpty());
    assertTrue(actualAllParentCategoryXrefs.isEmpty());
    assertTrue(actualCrossSaleProducts.isEmpty());
    assertTrue(actualUpSaleProducts.isEmpty());
    assertSame(FieldEntity.PRODUCT, actualFieldEntityType);
  }

  /**
   * Test {@link ProductImpl#setAdditionalSkus(List)}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor).
   *   <li>Then {@link ProductImpl} (default constructor) AdditionalSkus is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setAdditionalSkus(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setAdditionalSkus(List)"})
  public void testSetAdditionalSkus_givenProductImpl_thenProductImplAdditionalSkusIsArrayList() {
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
   * Test {@link ProductImpl#getDefaultCategory()}.
   *
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getDefaultCategory()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Category ProductImpl.getDefaultCategory()"})
  public void testGetDefaultCategory_thenReturnCategoryImpl() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    CategoryImpl defaultCategory = new CategoryImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertSame(defaultCategory, productImpl.getDefaultCategory());
  }

  /**
   * Test {@link ProductImpl#getMedia()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProductImpl.getMedia()"})
  public void testGetMedia_givenProductImplDefaultSkuIsSkuImpl_thenReturnEmpty() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertTrue(productImpl.getMedia().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getMedia()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProductImpl.getMedia()"})
  public void testGetMedia_givenSkuImplProductIsProductBundleImpl_thenReturnEmpty() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertTrue(productImpl.getMedia().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getAllSkuMedia()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getAllSkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProductImpl.getAllSkuMedia()"})
  public void testGetAllSkuMedia_givenProductImplDefaultSkuIsSkuImpl_thenReturnEmpty() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertTrue(productImpl.getAllSkuMedia().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getAllSkuMedia()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getAllSkuMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProductImpl.getAllSkuMedia()"})
  public void testGetAllSkuMedia_givenSkuImplProductIsProductBundleImpl_thenReturnEmpty() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertTrue(productImpl.getAllSkuMedia().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getDimension()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@link SkuImpl} (default constructor) {@link SkuImpl#dimension}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getDimension()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Dimension ProductImpl.getDimension()"})
  public void testGetDimension_givenProductImplDefaultSkuIsSkuImpl_thenReturnSkuImplDimension() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertSame(defaultSku.dimension, productImpl.getDimension());
  }

  /**
   * Test {@link ProductImpl#getWidth()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getWidth()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductImpl.getWidth()"})
  public void testGetWidth_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getWidth());
  }

  /**
   * Test {@link ProductImpl#setWidth(BigDecimal)}.
   *
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) Dimension DimensionString is {@code
   *       nullHx2.3WxnullD"}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setWidth(BigDecimal)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setWidth(BigDecimal)"})
  public void testSetWidth_thenProductImplDimensionDimensionStringIsNullHx23WxnullD() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    BigDecimal width = new BigDecimal("2.3");

    // Act
    productImpl.setWidth(width);

    // Assert
    Dimension dimension = productImpl.getDimension();
    assertEquals("nullHx2.3WxnullD\"", dimension.getDimensionString());
    assertEquals("nullHx2.3WxnullD\"", productImpl.getDimensionString());
    assertSame(width, dimension.getWidth());
    assertSame(width, productImpl.getWidth());
  }

  /**
   * Test {@link ProductImpl#getHeight()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getHeight()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductImpl.getHeight()"})
  public void testGetHeight_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getHeight());
  }

  /**
   * Test {@link ProductImpl#setHeight(BigDecimal)}.
   *
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) Dimension DimensionString is {@code
   *       2.3HxnullWxnullD"}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setHeight(BigDecimal)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setHeight(BigDecimal)"})
  public void testSetHeight_thenProductImplDimensionDimensionStringIs23HxnullWxnullD() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    BigDecimal height = new BigDecimal("2.3");

    // Act
    productImpl.setHeight(height);

    // Assert
    Dimension dimension = productImpl.getDimension();
    assertEquals("2.3HxnullWxnullD\"", dimension.getDimensionString());
    assertEquals("2.3HxnullWxnullD\"", productImpl.getDimensionString());
    assertSame(height, dimension.getHeight());
    assertSame(height, productImpl.getHeight());
  }

  /**
   * Test {@link ProductImpl#getDepth()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getDepth()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductImpl.getDepth()"})
  public void testGetDepth_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getDepth());
  }

  /**
   * Test {@link ProductImpl#setDepth(BigDecimal)}.
   *
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) Dimension DimensionString is {@code
   *       nullHxnullWx2.3D"}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setDepth(BigDecimal)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setDepth(BigDecimal)"})
  public void testSetDepth_thenProductImplDimensionDimensionStringIsNullHxnullWx23d() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    BigDecimal depth = new BigDecimal("2.3");

    // Act
    productImpl.setDepth(depth);

    // Assert
    Dimension dimension = productImpl.getDimension();
    assertEquals("nullHxnullWx2.3D\"", dimension.getDimensionString());
    assertEquals("nullHxnullWx2.3D\"", productImpl.getDimensionString());
    assertSame(depth, dimension.getDepth());
    assertSame(depth, productImpl.getDepth());
  }

  /**
   * Test {@link ProductImpl#getGirth()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getGirth()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductImpl.getGirth()"})
  public void testGetGirth_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getGirth());
  }

  /**
   * Test {@link ProductImpl#setGirth(BigDecimal)}.
   *
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) Dimension Girth is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setGirth(BigDecimal)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setGirth(BigDecimal)"})
  public void testSetGirth_thenProductImplDimensionGirthIsBigDecimalWith23() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());
    BigDecimal girth = new BigDecimal("2.3");

    // Act
    productImpl.setGirth(girth);

    // Assert
    assertSame(girth, productImpl.getDimension().getGirth());
    assertSame(girth, productImpl.getGirth());
  }

  /**
   * Test {@link ProductImpl#getDimensionString()}.
   *
   * <ul>
   *   <li>Then return {@code nullHxnullWxnullD"}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getDimensionString()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getDimensionString()"})
  public void testGetDimensionString_thenReturnNullHxnullWxnullD() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertEquals("nullHxnullWxnullD\"", productImpl.getDimensionString());
  }

  /**
   * Test {@link ProductImpl#getWeight()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@link SkuImpl} (default constructor) {@link SkuImpl#weight}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getWeight()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Weight ProductImpl.getWeight()"})
  public void testGetWeight_givenProductImplDefaultSkuIsSkuImpl_thenReturnSkuImplWeight() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    SkuImpl defaultSku = new SkuImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertSame(defaultSku.weight, productImpl.getWeight());
  }

  /**
   * Test {@link ProductImpl#setWeight(Weight)}.
   *
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setWeight(Weight)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setWeight(Weight)"})
  public void testSetWeight_thenProductImplDefaultSkuSkuImpl() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act
    productImpl.setWeight(weight);

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    Money margin = productImpl.getMargin();
    assertEquals(margin, margin.zero().abs().abs().zero().abs().zero().zero().zero());
    assertSame(weight, productImpl.getWeight());
    assertSame(weight, defaultSku.getWeight());
    assertSame(weight, ((SkuImpl) defaultSku).weight);
  }

  /**
   * Test {@link ProductImpl#getCumulativeCrossSaleProducts()}.
   *
   * <p>Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeCrossSaleProducts()).thenReturn(new ArrayList<>());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        productImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultCategory).getCumulativeCrossSaleProducts();
    assertTrue(actualCumulativeCrossSaleProducts.isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CrossSaleProductImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_givenArrayListAddCrossSaleProductImpl() {
    // Arrange
    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());

    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeCrossSaleProducts()).thenReturn(relatedProductList);

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        productImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultCategory).getCumulativeCrossSaleProducts();
    assertTrue(actualCumulativeCrossSaleProducts.isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultCategory is {@link CategoryImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_givenProductImplDefaultCategoryIsCategoryImpl() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(productImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenThrowUnsupportedOperationException() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getCumulativeCrossSaleProducts())
        .thenThrow(new UnsupportedOperationException());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> productImpl.getCumulativeCrossSaleProducts());
    verify(defaultCategory).getCumulativeCrossSaleProducts();
  }

  /**
   * Test {@link ProductImpl#getProductAttributes()}.
   *
   * <ul>
   *   <li>Then return containsKey {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getProductAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProductImpl.getProductAttributes()"})
  public void testGetProductAttributes_thenReturnContainsKeyName() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = mock(ProductAttributeImpl.class);
    when(productAttributeImpl.getName()).thenReturn("Name");

    HashMap<String, ProductAttribute> productAttributes = new HashMap<>();
    productAttributes.put("foo", productAttributeImpl);

    ProductImpl productImpl = new ProductImpl();
    productImpl.setProductAttributes(productAttributes);

    // Act
    Map<String, ProductAttribute> actualProductAttributes = productImpl.getProductAttributes();

    // Assert
    verify(productAttributeImpl).getName();
    assertEquals(1, actualProductAttributes.size());
    assertTrue(actualProductAttributes.containsKey("Name"));
  }

  /**
   * Test {@link ProductImpl#getProductAttributes()}.
   *
   * <ul>
   *   <li>Then return {@code null} is {@link ProductAttributeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getProductAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProductImpl.getProductAttributes()"})
  public void testGetProductAttributes_thenReturnNullIsProductAttributeImpl() {
    // Arrange
    HashMap<String, ProductAttribute> productAttributes = new HashMap<>();
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributes.put("foo", productAttributeImpl);

    ProductImpl productImpl = new ProductImpl();
    productImpl.setProductAttributes(productAttributes);

    // Act
    Map<String, ProductAttribute> actualProductAttributes = productImpl.getProductAttributes();

    // Assert
    assertEquals(1, actualProductAttributes.size());
    assertSame(productAttributeImpl, actualProductAttributes.get(null));
  }

  /**
   * Test {@link ProductImpl#getMultiValueProductAttributes()}.
   *
   * <ul>
   *   <li>Then return {@code null} is {@link ProductImpl} (default constructor) {@link
   *       ProductImpl#productAttributes}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getMultiValueProductAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProductImpl.getMultiValueProductAttributes()"})
  public void testGetMultiValueProductAttributes_thenReturnNullIsProductImplProductAttributes() {
    // Arrange
    HashMap<String, ProductAttribute> productAttributes = new HashMap<>();
    productAttributes.put("foo", new ProductAttributeImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setProductAttributes(productAttributes);

    // Act
    Map<String, ProductAttribute> actualMultiValueProductAttributes =
        productImpl.getMultiValueProductAttributes();

    // Assert
    assertEquals(1, actualMultiValueProductAttributes.size());
    assertEquals(productImpl.productAttributes, actualMultiValueProductAttributes.get(null));
  }

  /**
   * Test {@link ProductImpl#getProductOptions()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductOptionXrefImpl} (default
   *       constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getProductOptions()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductImpl.getProductOptions()"})
  public void testGetProductOptions_givenArrayListAddProductOptionXrefImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(new ProductOptionXrefImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setProductOptionXrefs(productOptions);

    // Act
    List<ProductOption> actualProductOptions = productImpl.getProductOptions();

    // Assert
    assertEquals(1, actualProductOptions.size());
    assertTrue(actualProductOptions.get(0) instanceof ProductOptionImpl);
  }

  /**
   * Test {@link ProductImpl#getProductOptions()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductOptionXrefImpl} (default
   *       constructor).
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getProductOptions()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductImpl.getProductOptions()"})
  public void testGetProductOptions_givenArrayListAddProductOptionXrefImpl_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(new ProductOptionXrefImpl());
    productOptions.add(new ProductOptionXrefImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setProductOptionXrefs(productOptions);

    // Act
    List<ProductOption> actualProductOptions = productImpl.getProductOptions();

    // Assert
    assertEquals(2, actualProductOptions.size());
    ProductOption getResult = actualProductOptions.get(1);
    assertTrue(getResult instanceof ProductOptionImpl);
    assertEquals(actualProductOptions.get(0), getResult);
  }

  /**
   * Test {@link ProductImpl#getProductOptions()}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getProductOptions()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ProductImpl.getProductOptions()"})
  public void testGetProductOptions_thenReturnSizeIsThree() {
    // Arrange
    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(new ProductOptionXrefImpl());
    productOptions.add(new ProductOptionXrefImpl());
    productOptions.add(new ProductOptionXrefImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setProductOptionXrefs(productOptions);

    // Act
    List<ProductOption> actualProductOptions = productImpl.getProductOptions();

    // Assert
    assertEquals(3, actualProductOptions.size());
    ProductOption getResult = actualProductOptions.get(2);
    assertTrue(getResult instanceof ProductOptionImpl);
    assertEquals(actualProductOptions.get(0), getResult);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getGeneratedUrl()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplGetGeneratedUrlReturnNull_thenReturnNull() {
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
   * Test {@link ProductImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getGeneratedUrl()} return {@code //}.
   *   <li>Then return {@code //null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplGetGeneratedUrlReturnSlashSlash_thenReturnNull() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("//");

    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(null);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("//null", actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code null}.
   *   <li>Then calls {@link Sku#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrl()"})
  public void testGetUrl_givenSkuGetNameReturnNull_thenCallsGetName() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(null);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//null", actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is {@code //}.
   *   <li>Then return {@code https://example.org/example////}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrl()"})
  public void testGetUrl_givenSkuImplNameIsSlashSlash_thenReturnHttpsExampleOrgExample() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setName("//");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example////", actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrl()"})
  public void testGetUrl_givenSkuImplProductIsProductBundleImpl() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualUrl = productImpl.getUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//null", actualUrl);
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrl()"})
  public void testGetUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", productImpl.getUrl());
  }

  /**
   * Test {@link ProductImpl#getUrl()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example//https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrl()"})
  public void testGetUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
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
   * Test {@link ProductImpl#getUrl()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example//null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrl()"})
  public void testGetUrl_thenReturnHttpsExampleOrgExampleNull() {
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
   * Test {@link ProductImpl#getUrl()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrl()"})
  public void testGetUrl_thenThrowUnsupportedOperationException() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenThrow(new UnsupportedOperationException());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getUrl());
    verify(defaultCategory).getGeneratedUrl();
  }

  /**
   * Test {@link ProductImpl#getProductOptionValuesMap()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductOptionXrefImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getProductOptionValuesMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProductImpl.getProductOptionValuesMap()"})
  public void testGetProductOptionValuesMap_givenArrayListAddProductOptionXrefImpl() {
    // Arrange
    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(new ProductOptionXrefImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setProductOptionXrefs(productOptions);

    // Act and Assert
    assertTrue(productImpl.getProductOptionValuesMap().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getProductOptionValuesMap()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductOptionXrefImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getProductOptionValuesMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProductImpl.getProductOptionValuesMap()"})
  public void testGetProductOptionValuesMap_givenArrayListAddProductOptionXrefImpl2() {
    // Arrange
    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(new ProductOptionXrefImpl());
    productOptions.add(new ProductOptionXrefImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setProductOptionXrefs(productOptions);

    // Act and Assert
    assertTrue(productImpl.getProductOptionValuesMap().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getProductOptionValuesMap()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductOptionXrefImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getProductOptionValuesMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ProductImpl.getProductOptionValuesMap()"})
  public void testGetProductOptionValuesMap_givenArrayListAddProductOptionXrefImpl3() {
    // Arrange
    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(new ProductOptionXrefImpl());
    productOptions.add(new ProductOptionXrefImpl());
    productOptions.add(new ProductOptionXrefImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setProductOptionXrefs(productOptions);

    // Act and Assert
    assertTrue(productImpl.getProductOptionValuesMap().isEmpty());
  }

  /**
   * Test {@link ProductImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrlKey()"})
  public void testGetUrlKey_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getUrlKey());
  }

  /**
   * Test {@link ProductImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code null}.
   *   <li>Then calls {@link Sku#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrlKey()"})
  public void testGetUrlKey_givenSkuGetNameReturnNull_thenCallsGetName() {
    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(null);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act
    String actualUrlKey = productImpl.getUrlKey();

    // Assert
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertNull(actualUrlKey);
  }

  /**
   * Test {@link ProductImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is {@code name}.
   *   <li>Then return {@code name}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrlKey()"})
  public void testGetUrlKey_givenSkuImplNameIsName_thenReturnName() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setName("name");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertEquals("name", productImpl.getUrlKey());
  }

  /**
   * Test {@link ProductImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getUrlKey()"})
  public void testGetUrlKey_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertNull(productImpl.getUrlKey());
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getGeneratedUrl()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplGetGeneratedUrlReturnNull_thenReturnNull() {
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
   * Test {@link ProductImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code null}.
   *   <li>Then calls {@link Sku#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenSkuGetNameReturnNull_thenCallsGetName() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(null);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//null", actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenSkuImplProductIsProductBundleImpl() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//null", actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example////}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setName("//");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example////", actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example//https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
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
   * Test {@link ProductImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example//null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnHttpsExampleOrgExampleNull() {
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
   * Test {@link ProductImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code //null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnNull() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("//");

    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(null);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualGeneratedUrl = productImpl.getGeneratedUrl();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("//null", actualGeneratedUrl);
  }

  /**
   * Test {@link ProductImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenThrowUnsupportedOperationException() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenThrow(new UnsupportedOperationException());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getGeneratedUrl());
    verify(defaultCategory).getGeneratedUrl();
  }

  /**
   * Test {@link ProductImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getMainEntityName()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getMainEntityName());
  }

  /**
   * Test {@link ProductImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getMainEntityName()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenSkuGetNameReturnName_thenReturnName() {
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
   * Test {@link ProductImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getMainEntityName()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    // Act and Assert
    assertNull(productImpl.getMainEntityName());
  }

  /**
   * Test {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SkuImpl(), true));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new ProductBundleImpl());

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    productImpl.createOrRetrieveCopyInstance(context);

    // Assert that nothing has changed
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(context, atLeast(1)).getFromCatalog();
    verify(context, atLeast(1)).getToCatalog();
    verify(catalogImpl2, atLeast(1)).getId();
    verify(catalogImpl, atLeast(1)).getId();
    verify(defaultSku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(null, true));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new ProductBundleImpl());

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    productImpl.createOrRetrieveCopyInstance(context);

    // Assert that nothing has changed
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(context, atLeast(1)).getFromCatalog();
    verify(context, atLeast(1)).getToCatalog();
    verify(catalogImpl2, atLeast(1)).getId();
    verify(catalogImpl, atLeast(1)).getId();
    verify(defaultSku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductBundleImpl#setCanSellWithoutOptions(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCallsSetCanSellWithoutOptions()
      throws CloneNotSupportedException {
    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(mock(SkuImpl.class), true));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    doNothing().when(productBundleImpl).setCanSellWithoutOptions(Mockito.<Boolean>any());
    doNothing().when(productBundleImpl).setCanonicalUrl(Mockito.<String>any());
    doNothing().when(productBundleImpl).setDefaultCategory(Mockito.<Category>any());
    doNothing().when(productBundleImpl).setDefaultSku(Mockito.<Sku>any());
    doNothing().when(productBundleImpl).setFeaturedProduct(anyBoolean());
    doNothing().when(productBundleImpl).setManufacturer(Mockito.<String>any());
    doNothing().when(productBundleImpl).setMetaDescription(Mockito.<String>any());
    doNothing().when(productBundleImpl).setMetaTitle(Mockito.<String>any());
    doNothing().when(productBundleImpl).setModel(Mockito.<String>any());
    doNothing().when(productBundleImpl).setPromoMessage(Mockito.<String>any());
    doNothing().when(productBundleImpl).setUrl(Mockito.<String>any());
    doNothing().when(productBundleImpl).setUrlKey(Mockito.<String>any());

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(productBundleImpl);

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    productImpl.createOrRetrieveCopyInstance(context);

    // Assert that nothing has changed
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(context, atLeast(1)).getFromCatalog();
    verify(context, atLeast(1)).getToCatalog();
    verify(catalogImpl2, atLeast(1)).getId();
    verify(catalogImpl, atLeast(1)).getId();
    verify(productBundleImpl).setCanSellWithoutOptions(false);
    verify(productBundleImpl).setCanonicalUrl(null);
    verify(productBundleImpl).setDefaultCategory(isNull());
    verify(productBundleImpl).setDefaultSku(isA(Sku.class));
    verify(productBundleImpl).setFeaturedProduct(false);
    verify(productBundleImpl).setManufacturer(null);
    verify(productBundleImpl).setMetaDescription(null);
    verify(productBundleImpl).setMetaTitle(null);
    verify(productBundleImpl).setModel(null);
    verify(productBundleImpl).setPromoMessage(null);
    verify(productBundleImpl).setUrl(null);
    verify(productBundleImpl).setUrlKey(null);
    verify(defaultSku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then Clone DefaultCategory return {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenCloneDefaultCategoryReturnCategoryImpl()
      throws CloneNotSupportedException {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(new CategoryImpl());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any()))
        .thenReturn(new CreateResponse<>(productBundleImpl, false));

    // Act
    CreateResponse<Product> actualCreateOrRetrieveCopyInstanceResult =
        productImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context, atLeast(1)).getCopyHints();
    verify(context, atLeast(1)).getFromCatalog();
    verify(context, atLeast(1)).getToCatalog();
    verify(catalogImpl2, atLeast(1)).getId();
    verify(catalogImpl, atLeast(1)).getId();
    Product clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    Category defaultCategory = clone.getDefaultCategory();
    assertTrue(defaultCategory instanceof CategoryImpl);
    assertTrue(clone instanceof ProductBundleImpl);
    Category category = productBundleImpl.defaultCategory;
    assertSame(category, defaultCategory);
    assertSame(category, productImpl.getDefaultCategory());
    assertSame(category, ((ProductBundleImpl) clone).defaultCategory);
  }

  /**
   * Test {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowUnsupportedOperationException()
      throws CloneNotSupportedException {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    doThrow(new UnsupportedOperationException())
        .when(skuImpl)
        .setDefaultProduct(Mockito.<Product>any());

    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(skuImpl, true));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new ProductBundleImpl());

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> productImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(context).getFromCatalog();
    verify(context).getToCatalog();
    verify(catalogImpl2).getId();
    verify(catalogImpl).getId();
    verify(defaultSku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    verify(skuImpl).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductImpl#getTaxCode()}.
   *
   * <ul>
   *   <li>Given {@link ProductImpl} (default constructor) DefaultSku is {@link SkuImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getTaxCode()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getTaxCode()"})
  public void testGetTaxCode_givenProductImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(productImpl.getTaxCode());
  }

  /**
   * Test {@link ProductImpl#getTaxCode()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#getTaxCode()} return {@code Tax Code}.
   *   <li>Then return {@code Tax Code}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getTaxCode()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getTaxCode()"})
  public void testGetTaxCode_givenSkuImplGetTaxCodeReturnTaxCode_thenReturnTaxCode() {
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
   * Test {@link ProductImpl#setTaxCode(String)}.
   *
   * <ul>
   *   <li>Then {@link ProductImpl} (default constructor) DefaultSku {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#setTaxCode(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductImpl.setTaxCode(String)"})
  public void testSetTaxCode_thenProductImplDefaultSkuSkuImpl() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(new SkuImpl());

    // Act
    productImpl.setTaxCode("Tax Code");

    // Assert
    Sku defaultSku = productImpl.getDefaultSku();
    assertTrue(defaultSku instanceof SkuImpl);
    assertEquals("Tax Code", productImpl.getTaxCode());
    assertEquals("Tax Code", defaultSku.getTaxCode());
    assertEquals("Tax Code", ((SkuImpl) defaultSku).taxCode);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getGeneratedUrl()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplGetGeneratedUrlReturnNull_thenReturnNull() {
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
   * Test {@link ProductImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} {@link CategoryImpl#getGeneratedUrl()} return {@code //}.
   *   <li>Then return {@code //null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplGetGeneratedUrlReturnSlashSlash_thenReturnNull() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("//");

    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(null);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("//null", actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getName()} return {@code null}.
   *   <li>Then calls {@link Sku#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLocation()"})
  public void testGetLocation_givenSkuGetNameReturnNull_thenCallsGetName() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getName()).thenReturn(null);
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    verify(defaultSku).getName();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals("https://example.org/example//null", actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is {@code //}.
   *   <li>Then return {@code https://example.org/example////}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLocation()"})
  public void testGetLocation_givenSkuImplNameIsSlashSlash_thenReturnHttpsExampleOrgExample() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setName("//");

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example////", actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLocation()"})
  public void testGetLocation_givenSkuImplProductIsProductBundleImpl() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenReturn("https://example.org/example");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultSku(defaultSku);
    productImpl.setDefaultCategory(defaultCategory);

    // Act
    String actualLocation = productImpl.getLocation();

    // Assert
    verify(defaultCategory, atLeast(1)).getGeneratedUrl();
    assertEquals("https://example.org/example//null", actualLocation);
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLocation()"})
  public void testGetLocation_thenReturnHttpsExampleOrgExample() {
    // Arrange
    ProductImpl productImpl = new ProductImpl();
    productImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", productImpl.getLocation());
  }

  /**
   * Test {@link ProductImpl#getLocation()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example//https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLocation()"})
  public void testGetLocation_thenReturnHttpsExampleOrgExampleHttpsExampleOrgExample() {
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
   * Test {@link ProductImpl#getLocation()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example//null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLocation()"})
  public void testGetLocation_thenReturnHttpsExampleOrgExampleNull() {
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
   * Test {@link ProductImpl#getLocation()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ProductImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductImpl.getLocation()"})
  public void testGetLocation_thenThrowUnsupportedOperationException() {
    // Arrange
    CategoryImpl defaultCategory = mock(CategoryImpl.class);
    when(defaultCategory.getGeneratedUrl()).thenThrow(new UnsupportedOperationException());

    ProductImpl productImpl = new ProductImpl();
    productImpl.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> productImpl.getLocation());
    verify(defaultCategory).getGeneratedUrl();
  }
}
