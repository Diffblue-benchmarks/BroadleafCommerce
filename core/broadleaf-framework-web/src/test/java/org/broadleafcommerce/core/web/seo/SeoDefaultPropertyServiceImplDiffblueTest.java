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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.search.service.SearchService;
import org.broadleafcommerce.core.web.service.SearchFacetDTOService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;

@ExtendWith(MockitoExtension.class)
class SeoDefaultPropertyServiceImplDiffblueTest {
  @Mock
  private BaseUrlResolver baseUrlResolver;

  @Mock
  private CategoryDao categoryDao;

  @Mock
  private Environment environment;

  @Mock
  private SearchFacetDTOService searchFacetDTOService;

  @Mock
  private SearchService searchService;

  @InjectMocks
  private SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductTitlePattern(Product)"})
  void testGetProductTitlePattern() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("seo.product.title.pattern"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(new CategoryImpl());

    // Act
    String actualProductTitlePattern = seoDefaultPropertyServiceImpl.getProductTitlePattern(product);

    // Assert
    verify(product).getCategory();
    verify(environment).getProperty(eq("seo.product.title.pattern"));
    assertEquals("", actualProductTitlePattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductTitlePattern(Product)"})
  void testGetProductTitlePattern2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getProductTitlePatternOverride()).thenReturn("");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualProductTitlePattern = seoDefaultPropertyServiceImpl.getProductTitlePattern(product);

    // Assert
    verify(categoryImpl).getProductTitlePatternOverride();
    verify(product).getCategory();
    verify(environment).getProperty(eq("seo.product.title.pattern"));
    assertEquals("Property", actualProductTitlePattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>Given {@link Environment}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); given Environment; when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductTitlePattern(Product)"})
  void testGetProductTitlePattern_givenEnvironment_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", seoDefaultPropertyServiceImpl.getProductTitlePattern(null));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>Then return {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); then return 'Dr'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductTitlePattern(Product)"})
  void testGetProductTitlePattern_thenReturnDr() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getProductTitlePatternOverride()).thenReturn("Dr");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualProductTitlePattern = seoDefaultPropertyServiceImpl.getProductTitlePattern(product);

    // Assert
    verify(categoryImpl).getProductTitlePatternOverride();
    verify(product).getCategory();
    assertEquals("Dr", actualProductTitlePattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); then return 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductTitlePattern(Product)"})
  void testGetProductTitlePattern_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(new CategoryImpl());

    // Act
    String actualProductTitlePattern = seoDefaultPropertyServiceImpl.getProductTitlePattern(product);

    // Assert
    verify(product).getCategory();
    verify(environment).getProperty(eq("seo.product.title.pattern"));
    assertEquals("Property", actualProductTitlePattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); when ProductBundleImpl (default constructor); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductTitlePattern(Product)"})
  void testGetProductTitlePattern_whenProductBundleImpl_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", seoDefaultPropertyServiceImpl.getProductTitlePattern(new ProductBundleImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}.
   * <ul>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}
   */
  @Test
  @DisplayName("Test getCategoryTitlePattern(); then return 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryTitlePattern()"})
  void testGetCategoryTitlePattern_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualCategoryTitlePattern = seoDefaultPropertyServiceImpl.getCategoryTitlePattern();

    // Assert
    verify(environment).getProperty(eq("seo.category.title.pattern"));
    assertEquals("Property", actualCategoryTitlePattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}
   */
  @Test
  @DisplayName("Test getCategoryTitlePattern(); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryTitlePattern()"})
  void testGetCategoryTitlePattern_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("seo.category.title.pattern"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCategoryTitlePattern());
    verify(environment).getProperty(eq("seo.category.title.pattern"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}
   */
  @Test
  @DisplayName("Test getTitle(PageDTO); when PageDTO (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getTitle(PageDTO)"})
  void testGetTitle_whenPageDTO_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getTitle(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Category)} with {@code category}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Category)}
   */
  @Test
  @DisplayName("Test getType(Category) with 'category'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getType(Category)"})
  void testGetTypeWithCategory() {
    // Arrange, Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new CategoryImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)} with {@code page}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)}
   */
  @Test
  @DisplayName("Test getType(PageDTO) with 'page'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getType(PageDTO)"})
  void testGetTypeWithPage() {
    // Arrange, Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Product)} with {@code product}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Product)}
   */
  @Test
  @DisplayName("Test getType(Product) with 'product'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getType(Product)"})
  void testGetTypeWithProduct() {
    // Arrange, Act and Assert
    assertEquals("product", seoDefaultPropertyServiceImpl.getType(new ProductBundleImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductDescriptionPattern(Product)"})
  void testGetProductDescriptionPattern() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("seo.product.description.pattern"));
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(new CategoryImpl());

    // Act
    String actualProductDescriptionPattern = seoDefaultPropertyServiceImpl.getProductDescriptionPattern(product);

    // Assert
    verify(product).getCategory();
    verify(environment).getProperty(eq("seo.product.description.pattern"));
    assertEquals("", actualProductDescriptionPattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductDescriptionPattern(Product)"})
  void testGetProductDescriptionPattern2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getProductDescriptionPatternOverride()).thenReturn("");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualProductDescriptionPattern = seoDefaultPropertyServiceImpl.getProductDescriptionPattern(product);

    // Assert
    verify(categoryImpl).getProductDescriptionPatternOverride();
    verify(product).getCategory();
    verify(environment).getProperty(eq("seo.product.description.pattern"));
    assertEquals("Property", actualProductDescriptionPattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>Given {@link Environment}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); given Environment; when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductDescriptionPattern(Product)"})
  void testGetProductDescriptionPattern_givenEnvironment_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", seoDefaultPropertyServiceImpl.getProductDescriptionPattern(null));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>Then return {@code Product Description Pattern Override}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); then return 'Product Description Pattern Override'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductDescriptionPattern(Product)"})
  void testGetProductDescriptionPattern_thenReturnProductDescriptionPatternOverride() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getProductDescriptionPatternOverride()).thenReturn("Product Description Pattern Override");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualProductDescriptionPattern = seoDefaultPropertyServiceImpl.getProductDescriptionPattern(product);

    // Assert
    verify(categoryImpl).getProductDescriptionPatternOverride();
    verify(product).getCategory();
    assertEquals("Product Description Pattern Override", actualProductDescriptionPattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); then return 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductDescriptionPattern(Product)"})
  void testGetProductDescriptionPattern_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(new CategoryImpl());

    // Act
    String actualProductDescriptionPattern = seoDefaultPropertyServiceImpl.getProductDescriptionPattern(product);

    // Assert
    verify(product).getCategory();
    verify(environment).getProperty(eq("seo.product.description.pattern"));
    assertEquals("Property", actualProductDescriptionPattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); when ProductBundleImpl (default constructor); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductDescriptionPattern(Product)"})
  void testGetProductDescriptionPattern_whenProductBundleImpl_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", seoDefaultPropertyServiceImpl.getProductDescriptionPattern(new ProductBundleImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}.
   * <ul>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}
   */
  @Test
  @DisplayName("Test getCategoryDescriptionPattern(); then return 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryDescriptionPattern()"})
  void testGetCategoryDescriptionPattern_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualCategoryDescriptionPattern = seoDefaultPropertyServiceImpl.getCategoryDescriptionPattern();

    // Assert
    verify(environment).getProperty(eq("seo.category.description.pattern"));
    assertEquals("Property", actualCategoryDescriptionPattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}
   */
  @Test
  @DisplayName("Test getCategoryDescriptionPattern(); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryDescriptionPattern()"})
  void testGetCategoryDescriptionPattern_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("seo.category.description.pattern"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCategoryDescriptionPattern());
    verify(environment).getProperty(eq("seo.category.description.pattern"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}
   */
  @Test
  @DisplayName("Test getDescription(PageDTO); when PageDTO (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getDescription(PageDTO)"})
  void testGetDescription_whenPageDTO_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getDescription(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Category)} with {@code category}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(Category)}
   */
  @Test
  @DisplayName("Test getUrl(Category) with 'category'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(Category)"})
  void testGetUrlWithCategory() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Category)} with {@code category}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(Category)}
   */
  @Test
  @DisplayName("Test getUrl(Category) with 'category'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(Category)"})
  void testGetUrlWithCategory_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty(eq("seo.category.pagination.param"), eq("page"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)} with {@code page}.
   * <ul>
   *   <li>Then return {@code https://example.org/examplenull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)}
   */
  @Test
  @DisplayName("Test getUrl(PageDTO) with 'page'; then return 'https://example.org/examplenull'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)}
   */
  @Test
  @DisplayName("Test getUrl(PageDTO) with 'page'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(PageDTO)"})
  void testGetUrlWithPage_thenThrowNumberFormatException() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException("foo"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getUrl(new PageDTO()));
    verify(baseUrlResolver).getSiteBaseUrl();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Product)} with {@code product}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(Product)}
   */
  @Test
  @DisplayName("Test getUrl(Product) with 'product'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(Product)"})
  void testGetUrlWithProduct() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getUrl(new ProductBundleImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty(eq("seo.product.pagination.param"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Product)} with {@code product}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(Product)}
   */
  @Test
  @DisplayName("Test getUrl(Product) with 'product'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(Product)"})
  void testGetUrlWithProduct2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getUrl(new ProductBundleImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty(eq("seo.product.pagination.param"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Product)} with {@code product}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link Product#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(Product)}
   */
  @Test
  @DisplayName("Test getUrl(Product) with 'product'; given empty string; then calls getUrl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(Product)"})
  void testGetUrlWithProduct_givenEmptyString_thenCallsGetUrl() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    Product product = mock(Product.class);
    when(product.getCanonicalUrl()).thenReturn("");
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(product).getCanonicalUrl();
    verify(product).getUrl();
    verify(environment, atLeast(1)).getProperty(eq("seo.product.pagination.param"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Product)} with {@code product}.
   * <ul>
   *   <li>When {@link Product} {@link Product#getCanonicalUrl()} return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(Product)}
   */
  @Test
  @DisplayName("Test getUrl(Product) with 'product'; when Product getCanonicalUrl() return 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(Product)"})
  void testGetUrlWithProduct_whenProductGetCanonicalUrlReturnHttpsExampleOrgExample() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getCanonicalUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getUrl(product));
    verify(product).getCanonicalUrl();
    verify(environment, atLeast(1)).getProperty(eq("seo.product.pagination.param"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'; when CategoryImpl (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Category)"})
  void testGetImageWithCategory_whenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new CategoryImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)} with {@code page}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)}
   */
  @Test
  @DisplayName("Test getImage(PageDTO) with 'page'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(PageDTO)"})
  void testGetImageWithPage() {
    // Arrange, Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with {@code product}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @DisplayName("Test getImage(Product) with 'product'; given SkuImpl (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)} with {@code category}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Category) with 'category'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Category)"})
  void testGetCanonicalUrlWithCategory() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)} with {@code category}, {@code pageNumber}.
   * <ul>
   *   <li>Then return {@code https://example.org/examplenull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Category, int) with 'category', 'pageNumber'; then return 'https://example.org/examplenull'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Category, int)"})
  void testGetCanonicalUrlWithCategoryPageNumber_thenReturnHttpsExampleOrgExamplenull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act
    String actualCanonicalUrl = seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl(), 1);

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("https://example.org/examplenull", actualCanonicalUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)} with {@code category}, {@code pageNumber}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Category, int) with 'category', 'pageNumber'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Category, int)"})
  void testGetCanonicalUrlWithCategoryPageNumber_thenThrowNumberFormatException() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl(), 10));
    verify(baseUrlResolver).getSiteBaseUrl();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)} with {@code category}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Category) with 'category'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Category)"})
  void testGetCanonicalUrlWithCategory_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty(eq("seo.category.pagination.param"), eq("page"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Product) with 'product'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new ProductBundleImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty(eq("seo.product.pagination.param"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Product) with 'product'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new ProductBundleImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty(eq("seo.product.pagination.param"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Product) with 'product'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct3() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    Product product = mock(Product.class);
    when(product.getCanonicalUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(product).getCanonicalUrl();
    verify(environment, atLeast(1)).getProperty(eq("seo.product.pagination.param"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product, int)} with {@code product}, {@code pageNumber}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product, int)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Product, int) with 'product', 'pageNumber'; then return 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product, int)"})
  void testGetCanonicalUrlWithProductPageNumber_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);
    Product product = mock(Product.class);
    when(product.getCanonicalUrl()).thenReturn("https://example.org/example");

    // Act
    String actualCanonicalUrl = seoDefaultPropertyServiceImpl.getCanonicalUrl(product, 10);

    // Assert
    verify(product).getCanonicalUrl();
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertEquals("https://example.org/example", actualCanonicalUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product, int)} with {@code product}, {@code pageNumber}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product, int)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Product, int) with 'product', 'pageNumber'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product, int)"})
  void testGetCanonicalUrlWithProductPageNumber_thenThrowNumberFormatException() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new ProductBundleImpl(), 10));
    verify(baseUrlResolver).getSiteBaseUrl();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link Product#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @DisplayName("Test getCanonicalUrl(Product) with 'product'; given empty string; then calls getUrl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  void testGetCanonicalUrlWithProduct_givenEmptyString_thenCallsGetUrl() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");
    Product product = mock(Product.class);
    when(product.getCanonicalUrl()).thenReturn("");
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(product).getCanonicalUrl();
    verify(product).getUrl();
    verify(environment, atLeast(1)).getProperty(eq("seo.product.pagination.param"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)} with {@code category}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)}
   */
  @Test
  @DisplayName("Test getPaginationPrevUrl(Category) with 'category'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getPaginationPrevUrl(Category)"})
  void testGetPaginationPrevUrlWithCategory() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act
    String actualPaginationPrevUrl = seoDefaultPropertyServiceImpl.getPaginationPrevUrl(new CategoryImpl());

    // Assert
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertNull(actualPaginationPrevUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)} with {@code category}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)}
   */
  @Test
  @DisplayName("Test getPaginationPrevUrl(Category) with 'category'; given Environment getProperty(String, String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getPaginationPrevUrl(Category)"})
  void testGetPaginationPrevUrlWithCategory_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    String actualPaginationPrevUrl = seoDefaultPropertyServiceImpl.getPaginationPrevUrl(new CategoryImpl());

    // Assert
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertNull(actualPaginationPrevUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Product)} with {@code product}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Product)}
   */
  @Test
  @DisplayName("Test getPaginationPrevUrl(Product) with 'product'; given Environment getProperty(String, Class, Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getPaginationPrevUrl(Product)"})
  void testGetPaginationPrevUrlWithProduct_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    String actualPaginationPrevUrl = seoDefaultPropertyServiceImpl.getPaginationPrevUrl(new ProductBundleImpl());

    // Assert
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertNull(actualPaginationPrevUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Product)} with {@code product}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Product)}
   */
  @Test
  @DisplayName("Test getPaginationPrevUrl(Product) with 'product'; given Environment getProperty(String, Class, Object) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getPaginationPrevUrl(Product)"})
  void testGetPaginationPrevUrlWithProduct_givenEnvironmentGetPropertyReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    String actualPaginationPrevUrl = seoDefaultPropertyServiceImpl.getPaginationPrevUrl(new ProductBundleImpl());

    // Assert
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertNull(actualPaginationPrevUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Product)} with {@code product}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Product)}
   */
  @Test
  @DisplayName("Test getPaginationPrevUrl(Product) with 'product'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getPaginationPrevUrl(Product)"})
  void testGetPaginationPrevUrlWithProduct_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getPaginationPrevUrl(new ProductBundleImpl()));
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Product)} with {@code product}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Product)}
   */
  @Test
  @DisplayName("Test getPaginationNextUrl(Product) with 'product'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getPaginationNextUrl(Product)"})
  void testGetPaginationNextUrlWithProduct_thenReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    String actualPaginationNextUrl = seoDefaultPropertyServiceImpl.getPaginationNextUrl(new ProductBundleImpl());

    // Assert
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertNull(actualPaginationNextUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Product)} with {@code product}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Product)}
   */
  @Test
  @DisplayName("Test getPaginationNextUrl(Product) with 'product'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getPaginationNextUrl(Product)"})
  void testGetPaginationNextUrlWithProduct_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getPaginationNextUrl(new ProductBundleImpl()));
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeProductPagination(int); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeProductPagination(int)"})
  void testShouldIncludeProductPagination_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldIncludeProductPaginationResult = seoDefaultPropertyServiceImpl
        .shouldIncludeProductPagination(10);

    // Assert
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertFalse(actualShouldIncludeProductPaginationResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeProductPagination(int); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeProductPagination(int)"})
  void testShouldIncludeProductPagination_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldIncludeProductPaginationResult = seoDefaultPropertyServiceImpl
        .shouldIncludeProductPagination(10);

    // Assert
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertTrue(actualShouldIncludeProductPaginationResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeProductPagination(int); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeProductPagination(int)"})
  void testShouldIncludeProductPagination_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.shouldIncludeProductPagination(10));
    verify(environment).getProperty(eq("seo.product.pagination.param"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeCategoryPagination(int); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(int)"})
  void testShouldIncludeCategoryPagination_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldIncludeCategoryPaginationResult = seoDefaultPropertyServiceImpl
        .shouldIncludeCategoryPagination(10);

    // Assert
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertTrue(actualShouldIncludeCategoryPaginationResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeCategoryPagination(int); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(int)"})
  void testShouldIncludeCategoryPagination_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(10));
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}
   */
  @Test
  @DisplayName("Test shouldIncludeCategoryPagination(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(int)"})
  void testShouldIncludeCategoryPagination_whenOne_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldIncludeCategoryPaginationResult = seoDefaultPropertyServiceImpl
        .shouldIncludeCategoryPagination(1);

    // Assert
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertFalse(actualShouldIncludeCategoryPaginationResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @DisplayName("Test isValidPrevPageNumber(Integer); when ten; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.isValidPrevPageNumber(Integer)"})
  void testIsValidPrevPageNumber_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(seoDefaultPropertyServiceImpl.isValidPrevPageNumber(10));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @DisplayName("Test isValidPrevPageNumber(Integer); when zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.isValidPrevPageNumber(Integer)"})
  void testIsValidPrevPageNumber_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(seoDefaultPropertyServiceImpl.isValidPrevPageNumber(0));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Category, Integer)} with {@code category}, {@code pageNumber}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Category, Integer)}
   */
  @Test
  @DisplayName("Test isValidNextPageNumber(Category, Integer) with 'category', 'pageNumber'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.isValidNextPageNumber(Category, Integer)"})
  void testIsValidNextPageNumberWithCategoryPageNumber_thenThrowNumberFormatException() {
    // Arrange
    when(categoryDao.readCountAllActiveProductsByCategory(Mockito.<Category>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.isValidNextPageNumber(new CategoryImpl(), 10));
    verify(categoryDao).readCountAllActiveProductsByCategory(isA(Category.class));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)} with {@code product}, {@code pageNumber}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   */
  @Test
  @DisplayName("Test isValidNextPageNumber(Product, Integer) with 'product', 'pageNumber'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.isValidNextPageNumber(Product, Integer)"})
  void testIsValidNextPageNumberWithProductPageNumber() {
    // Arrange, Act and Assert
    assertTrue(seoDefaultPropertyServiceImpl.isValidNextPageNumber(new ProductBundleImpl(), 10));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPageCount(Category)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getPageCount(Category)}
   */
  @Test
  @DisplayName("Test getPageCount(Category); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getPageCount(Category)"})
  void testGetPageCount_thenThrowNumberFormatException() {
    // Arrange
    when(categoryDao.readCountAllActiveProductsByCategory(Mockito.<Category>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getPageCount(new CategoryImpl()));
    verify(categoryDao).readCountAllActiveProductsByCategory(isA(Category.class));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}
   */
  @Test
  @DisplayName("Test getCurrentProductPageNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentProductPageNumber()"})
  void testGetCurrentProductPageNumber() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act
    Integer actualCurrentProductPageNumber = seoDefaultPropertyServiceImpl.getCurrentProductPageNumber();

    // Assert
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    assertEquals(1, actualCurrentProductPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}
   */
  @Test
  @DisplayName("Test getCurrentProductPageNumber(); given Environment getProperty(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentProductPageNumber()"})
  void testGetCurrentProductPageNumber_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    Integer actualCurrentProductPageNumber = seoDefaultPropertyServiceImpl.getCurrentProductPageNumber();

    // Assert
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    assertEquals(1, actualCurrentProductPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}.
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}
   */
  @Test
  @DisplayName("Test getCurrentCategoryPageNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber()"})
  void testGetCurrentCategoryPageNumber() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException("ThreadLocalManager.notify.orphans"));

    // Act
    Integer actualCurrentCategoryPageNumber = seoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber();

    // Assert
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals(1, actualCurrentCategoryPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}
   */
  @Test
  @DisplayName("Test getCurrentCategoryPageNumber(); given Environment getProperty(String, String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber()"})
  void testGetCurrentCategoryPageNumber_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    Integer actualCurrentCategoryPageNumber = seoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber();

    // Assert
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals(1, actualCurrentCategoryPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}
   */
  @Test
  @DisplayName("Test productPaginationIsEnabled(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.productPaginationIsEnabled()"})
  void testProductPaginationIsEnabled_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    boolean actualProductPaginationIsEnabledResult = seoDefaultPropertyServiceImpl.productPaginationIsEnabled();

    // Assert
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertFalse(actualProductPaginationIsEnabledResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}
   */
  @Test
  @DisplayName("Test productPaginationIsEnabled(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.productPaginationIsEnabled()"})
  void testProductPaginationIsEnabled_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    boolean actualProductPaginationIsEnabledResult = seoDefaultPropertyServiceImpl.productPaginationIsEnabled();

    // Assert
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
    assertTrue(actualProductPaginationIsEnabledResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#productPaginationIsEnabled()}
   */
  @Test
  @DisplayName("Test productPaginationIsEnabled(); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.productPaginationIsEnabled()"})
  void testProductPaginationIsEnabled_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new NumberFormatException("seo.product.pagination.enabled"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.productPaginationIsEnabled());
    verify(environment).getProperty(eq("seo.product.pagination.enabled"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}.
   * <ul>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}
   */
  @Test
  @DisplayName("Test getProductPaginationParam(); then return 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductPaginationParam()"})
  void testGetProductPaginationParam_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualProductPaginationParam = seoDefaultPropertyServiceImpl.getProductPaginationParam();

    // Assert
    verify(environment).getProperty(eq("seo.product.pagination.param"));
    assertEquals("Property", actualProductPaginationParam);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}
   */
  @Test
  @DisplayName("Test getProductPaginationParam(); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductPaginationParam()"})
  void testGetProductPaginationParam_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NumberFormatException("seo.product.pagination.param"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getProductPaginationParam());
    verify(environment).getProperty(eq("seo.product.pagination.param"));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}.
   * <ul>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}
   */
  @Test
  @DisplayName("Test getCategoryPaginationParam(); then return 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryPaginationParam()"})
  void testGetCategoryPaginationParam_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualCategoryPaginationParam = seoDefaultPropertyServiceImpl.getCategoryPaginationParam();

    // Assert
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
    assertEquals("Property", actualCategoryPaginationParam);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}
   */
  @Test
  @DisplayName("Test getCategoryPaginationParam(); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryPaginationParam()"})
  void testGetCategoryPaginationParam_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException("seo.category.pagination.param"));

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCategoryPaginationParam());
    verify(environment).getProperty(eq("seo.category.pagination.param"), eq("page"));
  }
}
