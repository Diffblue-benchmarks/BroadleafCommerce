/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.seo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXref;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXref;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXrefImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

@ExtendWith(MockitoExtension.class)
class SeoDefaultPropertyServiceImplDiffblueTest {
  @Mock private BaseUrlResolver baseUrlResolver;

  @Mock private CategoryDao categoryDao;

  @Mock private Environment environment;

  @InjectMocks private SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}
   */
  @Test
  @DisplayName("Test getCategoryTitlePattern(); then return 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryTitlePattern()"})
  void testGetCategoryTitlePattern_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualCategoryTitlePattern = seoDefaultPropertyServiceImpl.getCategoryTitlePattern();

    // Assert
    verify(environment).getProperty("seo.category.title.pattern");
    assertEquals("Property", actualCategoryTitlePattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}
   */
  @Test
  @DisplayName("Test getCategoryTitlePattern(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryTitlePattern()"})
  void testGetCategoryTitlePattern_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCategoryTitlePattern());
    verify(environment).getProperty("seo.category.title.pattern");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}.
   *
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}
   */
  @Test
  @DisplayName("Test getTitle(PageDTO); when PageDTO (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getTitle(PageDTO)"})
  void testGetTitle_whenPageDTO_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getTitle(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Category)} with {@code category}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Category)}
   */
  @Test
  @DisplayName("Test getType(Category) with 'category'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getType(Category)"})
  void testGetTypeWithCategory() {
    // Arrange, Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new CategoryImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)} with {@code page}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)}
   */
  @Test
  @DisplayName("Test getType(PageDTO) with 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getType(PageDTO)"})
  void testGetTypeWithPage() {
    // Arrange, Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}
   */
  @Test
  @DisplayName("Test getCategoryDescriptionPattern(); then return 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryDescriptionPattern()"})
  void testGetCategoryDescriptionPattern_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualCategoryDescriptionPattern =
        seoDefaultPropertyServiceImpl.getCategoryDescriptionPattern();

    // Assert
    verify(environment).getProperty("seo.category.description.pattern");
    assertEquals("Property", actualCategoryDescriptionPattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}
   */
  @Test
  @DisplayName("Test getCategoryDescriptionPattern(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryDescriptionPattern()"})
  void testGetCategoryDescriptionPattern_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCategoryDescriptionPattern());
    verify(environment).getProperty("seo.category.description.pattern");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}.
   *
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}
   */
  @Test
  @DisplayName(
      "Test getDescription(PageDTO); when PageDTO (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getDescription(PageDTO)"})
  void testGetDescription_whenPageDTO_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getDescription(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Category)} with {@code category}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(Category)}
   */
  @Test
  @DisplayName("Test getUrl(Category) with 'category'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(Category)"})
  void testGetUrlWithCategory() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(Category)}
   */
  @Test
  @DisplayName("Test getUrl(Category) with 'category'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(Category)"})
  void testGetUrlWithCategory_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)} with {@code page}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/examplenull}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)}
   */
  @Test
  @DisplayName("Test getUrl(PageDTO) with 'page'; then return 'https://example.org/examplenull'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(PageDTO)"})
  void testGetUrlWithPage_thenReturnHttpsExampleOrgExamplenull() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act
    String actualUrl = seoDefaultPropertyServiceImpl.getUrl(new PageDTO());

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    assertEquals("https://example.org/examplenull", actualUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)} with {@code page}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)}
   */
  @Test
  @DisplayName("Test getUrl(PageDTO) with 'page'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(PageDTO)"})
  void testGetUrlWithPage_thenThrowNumberFormatException() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getUrl(new PageDTO()));
    verify(baseUrlResolver).getSiteBaseUrl();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with {@code category}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Category)"})
  void testGetImageWithCategory() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    HashMap<String, CategoryMediaXref> stringCategoryMediaXrefMap = new HashMap<>();
    stringCategoryMediaXrefMap.put("primary", new CategoryMediaXrefImpl());

    Category category = mock(Category.class);
    when(category.getCategoryMediaXref()).thenReturn(stringCategoryMediaXrefMap);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getImage(category));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(category).getCategoryMediaXref();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then calls {@link CategoryMediaXref#getMedia()}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'; then calls getMedia()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Category)"})
  void testGetImageWithCategory_thenCallsGetMedia() {
    // Arrange
    CategoryMediaXref categoryMediaXref = mock(CategoryMediaXref.class);
    when(categoryMediaXref.getMedia()).thenThrow(new NumberFormatException());

    HashMap<String, CategoryMediaXref> stringCategoryMediaXrefMap = new HashMap<>();
    stringCategoryMediaXrefMap.put("primary", categoryMediaXref);

    Category category = mock(Category.class);
    when(category.getCategoryMediaXref()).thenReturn(stringCategoryMediaXrefMap);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getImage(category));
    verify(category).getCategoryMediaXref();
    verify(categoryMediaXref).getMedia();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'; then return 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Category)"})
  void testGetImageWithCategory_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    HashMap<String, CategoryMediaXref> stringCategoryMediaXrefMap = new HashMap<>();
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl =
        new CategoryMediaXrefImpl(category, new MediaDto(), "primary");
    stringCategoryMediaXrefMap.put("primary", categoryMediaXrefImpl);

    Category category2 = mock(Category.class);
    when(category2.getCategoryMediaXref()).thenReturn(stringCategoryMediaXrefMap);

    // Act
    String actualImage = seoDefaultPropertyServiceImpl.getImage(category2);

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(category2).getCategoryMediaXref();
    assertEquals("https://example.org/example", actualImage);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with {@code category}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName(
      "Test getImage(Category) with 'category'; when CategoryImpl (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Category)"})
  void testGetImageWithCategory_whenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new CategoryImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)} with {@code page}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)}
   */
  @Test
  @DisplayName("Test getImage(PageDTO) with 'page'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(PageDTO)"})
  void testGetImageWithPage() {
    // Arrange, Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with {@code product}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @DisplayName("Test getImage(Product) with 'product'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Product)"})
  void testGetImageWithProduct() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    HashMap<String, SkuMediaXref> stringSkuMediaXrefMap = new HashMap<>();
    stringSkuMediaXrefMap.put("primary", new SkuMediaXrefImpl());

    Sku sku = mock(Sku.class);
    when(sku.getSkuMediaXref()).thenReturn(stringSkuMediaXrefMap);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getImage(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(product).getDefaultSku();
    verify(sku).getSkuMediaXref();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @DisplayName(
      "Test getImage(Product) with 'product'; given SkuImpl (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Product)"})
  void testGetImageWithProduct_givenSkuImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    String actualImage = seoDefaultPropertyServiceImpl.getImage(product);

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualImage);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Then calls {@link SkuMediaXref#getMedia()}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @DisplayName("Test getImage(Product) with 'product'; then calls getMedia()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Product)"})
  void testGetImageWithProduct_thenCallsGetMedia() {
    // Arrange
    SkuMediaXref skuMediaXref = mock(SkuMediaXref.class);
    when(skuMediaXref.getMedia()).thenThrow(new NumberFormatException());

    HashMap<String, SkuMediaXref> stringSkuMediaXrefMap = new HashMap<>();
    stringSkuMediaXrefMap.put("primary", skuMediaXref);

    Sku sku = mock(Sku.class);
    when(sku.getSkuMediaXref()).thenReturn(stringSkuMediaXrefMap);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getImage(product));
    verify(product).getDefaultSku();
    verify(sku).getSkuMediaXref();
    verify(skuMediaXref).getMedia();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @DisplayName("Test getImage(Product) with 'product'; then return 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Product)"})
  void testGetImageWithProduct_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    HashMap<String, SkuMediaXref> stringSkuMediaXrefMap = new HashMap<>();
    SkuImpl sku = new SkuImpl();
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl(sku, new MediaDto(), "primary");
    stringSkuMediaXrefMap.put("primary", skuMediaXrefImpl);

    Sku sku2 = mock(Sku.class);
    when(sku2.getSkuMediaXref()).thenReturn(stringSkuMediaXrefMap);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku2);

    // Act
    String actualImage = seoDefaultPropertyServiceImpl.getImage(product);

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(product).getDefaultSku();
    verify(sku2).getSkuMediaXref();
    assertEquals("https://example.org/example", actualImage);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)} with {@code category}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Category) with 'category'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Category)"})
  void testGetCanonicalUrlWithCategory() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)} with {@code
   * category}, {@code pageNumber}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Category, int) with 'category', 'pageNumber'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Category, int)"})
  void testGetCanonicalUrlWithCategoryPageNumber() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl(), 10));
    verify(baseUrlResolver).getSiteBaseUrl();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)} with {@code
   * category}, {@code pageNumber}.
   *
   * <ul>
   *   <li>Then calls {@link Environment#getProperty(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Category, int) with 'category', 'pageNumber'; then calls getProperty(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Category, int)"})
  void testGetCanonicalUrlWithCategoryPageNumber_thenCallsGetProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl(), 10));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Category) with 'category'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Category)"})
  void testGetCanonicalUrlWithCategory_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Product) with 'product'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new ProductBundleImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Product) with 'product'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    ProductBundleImpl product = new ProductBundleImpl();
    product.setCanonicalUrl("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given CategoryImpl (default constructor) Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsName() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("Name");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code
   *       seo.product.pagination.param}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given CategoryImpl (default constructor) Name is 'seo.product.pagination.param'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsSeoProductPaginationParam() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("seo.product.pagination.param");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code //}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given CategoryImpl (default constructor) Name is '//'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsSlashSlash() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("//");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is space.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given CategoryImpl (default constructor) Name is space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsSpace() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName(" ");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code UU UU}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given CategoryImpl (default constructor) Name is 'UU UU'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsUuUu() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("UU UU");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code .*?\W.*?}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given CategoryImpl (default constructor) Name is '.*?\\W.*?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsW() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName(".*?\\W.*?");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code [^\w-]+}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given CategoryImpl (default constructor) Name is '[^\\w-]+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsW2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("[^\\w-]+");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then calls {@link Product#getCanonicalUrl()}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given empty string; then calls getCanonicalUrl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenEmptyString_thenCallsGetCanonicalUrl() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    Product product = mock(Product.class);
    when(product.getCanonicalUrl()).thenReturn("");
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(product).getCanonicalUrl();
    verify(product).getUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is space.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given SkuImpl (default constructor) Name is space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenSkuImplNameIsSpace() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("seo.product.pagination.param");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setName(" ");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(defaultSku);
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is {@code UU UU}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given SkuImpl (default constructor) Name is 'UU UU'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenSkuImplNameIsUuUu() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("seo.product.pagination.param");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setName("UU UU");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(defaultSku);
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is {@code .*?\W.*?}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; given SkuImpl (default constructor) Name is '.*?\\W.*?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenSkuImplNameIsW() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("seo.product.pagination.param");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setName(".*?\\W.*?");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(defaultSku);
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then calls {@link BaseUrlResolver#getSiteBaseUrl()}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName(
      "Test getCanonicalUrl(Product) with 'product'; when ProductBundleImpl (default constructor); then calls getSiteBaseUrl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_whenProductBundleImpl_thenCallsGetSiteBaseUrl() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new ProductBundleImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)} with {@code
   * category}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)}
   */
  @Test
  @DisplayName("Test getPaginationPrevUrl(Category) with 'category'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getPaginationPrevUrl(Category)"})
  void testGetPaginationPrevUrlWithCategory() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());

    // Act
    String actualPaginationPrevUrl =
        seoDefaultPropertyServiceImpl.getPaginationPrevUrl(new CategoryImpl());

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertNull(actualPaginationPrevUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)} with {@code
   * category}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, String)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)}
   */
  @Test
  @DisplayName(
      "Test getPaginationPrevUrl(Category) with 'category'; given Environment getProperty(String, String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getPaginationPrevUrl(Category)"})
  void testGetPaginationPrevUrlWithCategory_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    String actualPaginationPrevUrl =
        seoDefaultPropertyServiceImpl.getPaginationPrevUrl(new CategoryImpl());

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertNull(actualPaginationPrevUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Category)} with {@code
   * category}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Category)}
   */
  @Test
  @DisplayName(
      "Test getPaginationNextUrl(Category) with 'category'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getPaginationNextUrl(Category)"})
  void testGetPaginationNextUrlWithCategory_thenThrowNumberFormatException() {
    // Arrange
    when(categoryDao.readCountAllActiveProductsByCategory(Mockito.<Category>any()))
        .thenThrow(new NumberFormatException());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getPaginationNextUrl(new CategoryImpl()));
    verify(categoryDao).readCountAllActiveProductsByCategory(isA(Category.class));
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeProductPagination(int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeProductPagination(int)"})
  void testShouldIncludeProductPagination_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldIncludeProductPaginationResult =
        seoDefaultPropertyServiceImpl.shouldIncludeProductPagination(10);

    // Assert
    verify(environment).getProperty("seo.product.pagination.param");
    verify(environment)
        .getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertFalse(actualShouldIncludeProductPaginationResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeProductPagination(int); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeProductPagination(int)"})
  void testShouldIncludeProductPagination_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldIncludeProductPaginationResult =
        seoDefaultPropertyServiceImpl.shouldIncludeProductPagination(10);

    // Assert
    verify(environment).getProperty("seo.product.pagination.param");
    verify(environment)
        .getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertTrue(actualShouldIncludeProductPaginationResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeProductPagination(int); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeProductPagination(int)"})
  void testShouldIncludeProductPagination_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.shouldIncludeProductPagination(10));
    verify(environment).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeCategoryPagination(int); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(int)"})
  void testShouldIncludeCategoryPagination_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldIncludeCategoryPaginationResult =
        seoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(10);

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertTrue(actualShouldIncludeCategoryPaginationResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeCategoryPagination(int); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(int)"})
  void testShouldIncludeCategoryPagination_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(10));
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeCategoryPagination(int); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(int)"})
  void testShouldIncludeCategoryPagination_whenOne_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldIncludeCategoryPaginationResult =
        seoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(1);

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertFalse(actualShouldIncludeCategoryPaginationResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @DisplayName("Test isValidPrevPageNumber(Integer); when ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.isValidPrevPageNumber(Integer)"})
  void testIsValidPrevPageNumber_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(seoDefaultPropertyServiceImpl.isValidPrevPageNumber(10));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @DisplayName("Test isValidPrevPageNumber(Integer); when zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.isValidPrevPageNumber(Integer)"})
  void testIsValidPrevPageNumber_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(seoDefaultPropertyServiceImpl.isValidPrevPageNumber(0));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Category, Integer)} with {@code
   * category}, {@code pageNumber}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Category,
   * Integer)}
   */
  @Test
  @DisplayName(
      "Test isValidNextPageNumber(Category, Integer) with 'category', 'pageNumber'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SeoDefaultPropertyServiceImpl.isValidNextPageNumber(Category, Integer)"
  })
  void testIsValidNextPageNumberWithCategoryPageNumber_thenThrowNumberFormatException() {
    // Arrange
    when(categoryDao.readCountAllActiveProductsByCategory(Mockito.<Category>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.isValidNextPageNumber(new CategoryImpl(), 10));
    verify(categoryDao).readCountAllActiveProductsByCategory(isA(Category.class));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPageCount(Category)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getPageCount(Category)}
   */
  @Test
  @DisplayName("Test getPageCount(Category); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getPageCount(Category)"})
  void testGetPageCount_thenThrowNumberFormatException() {
    // Arrange
    when(categoryDao.readCountAllActiveProductsByCategory(Mockito.<Category>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getPageCount(new CategoryImpl()));
    verify(categoryDao).readCountAllActiveProductsByCategory(isA(Category.class));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}
   */
  @Test
  @DisplayName("Test getCurrentProductPageNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentProductPageNumber()"})
  void testGetCurrentProductPageNumber() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    // Act
    Integer actualCurrentProductPageNumber =
        seoDefaultPropertyServiceImpl.getCurrentProductPageNumber();

    // Assert
    verify(environment).getProperty("seo.product.pagination.param");
    assertEquals(1, actualCurrentProductPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}
   */
  @Test
  @DisplayName(
      "Test getCurrentProductPageNumber(); given Environment getProperty(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentProductPageNumber()"})
  void testGetCurrentProductPageNumber_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    Integer actualCurrentProductPageNumber =
        seoDefaultPropertyServiceImpl.getCurrentProductPageNumber();

    // Assert
    verify(environment).getProperty("seo.product.pagination.param");
    assertEquals(1, actualCurrentProductPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}
   */
  @Test
  @DisplayName("Test getCurrentCategoryPageNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber()"})
  void testGetCurrentCategoryPageNumber() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());

    // Act
    Integer actualCurrentCategoryPageNumber =
        seoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber();

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertEquals(1, actualCurrentCategoryPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, String)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}
   */
  @Test
  @DisplayName(
      "Test getCurrentCategoryPageNumber(); given Environment getProperty(String, String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber()"})
  void testGetCurrentCategoryPageNumber_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    Integer actualCurrentCategoryPageNumber =
        seoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber();

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertEquals(1, actualCurrentCategoryPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}
   */
  @Test
  @DisplayName("Test productPaginationIsEnabled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.productPaginationIsEnabled()"})
  void testProductPaginationIsEnabled_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    boolean actualProductPaginationIsEnabledResult =
        seoDefaultPropertyServiceImpl.productPaginationIsEnabled();

    // Assert
    verify(environment)
        .getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertFalse(actualProductPaginationIsEnabledResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}
   */
  @Test
  @DisplayName("Test productPaginationIsEnabled(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.productPaginationIsEnabled()"})
  void testProductPaginationIsEnabled_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    boolean actualProductPaginationIsEnabledResult =
        seoDefaultPropertyServiceImpl.productPaginationIsEnabled();

    // Assert
    verify(environment)
        .getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertTrue(actualProductPaginationIsEnabledResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}
   */
  @Test
  @DisplayName("Test productPaginationIsEnabled(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.productPaginationIsEnabled()"})
  void testProductPaginationIsEnabled_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.productPaginationIsEnabled());
    verify(environment)
        .getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}
   */
  @Test
  @DisplayName("Test getProductPaginationParam(); then return 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductPaginationParam()"})
  void testGetProductPaginationParam_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualProductPaginationParam = seoDefaultPropertyServiceImpl.getProductPaginationParam();

    // Assert
    verify(environment).getProperty("seo.product.pagination.param");
    assertEquals("Property", actualProductPaginationParam);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}
   */
  @Test
  @DisplayName("Test getProductPaginationParam(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductPaginationParam()"})
  void testGetProductPaginationParam_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getProductPaginationParam());
    verify(environment).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}
   */
  @Test
  @DisplayName("Test getCategoryPaginationParam(); then return 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryPaginationParam()"})
  void testGetCategoryPaginationParam_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");

    // Act
    String actualCategoryPaginationParam =
        seoDefaultPropertyServiceImpl.getCategoryPaginationParam();

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertEquals("Property", actualCategoryPaginationParam);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}
   */
  @Test
  @DisplayName("Test getCategoryPaginationParam(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryPaginationParam()"})
  void testGetCategoryPaginationParam_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCategoryPaginationParam());
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }
}
