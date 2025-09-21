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
package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CatalogURLServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogURLServiceImplDiffblueTest {
  @Autowired private CatalogURLServiceImpl catalogURLServiceImpl;

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@code 42}.
   *   <li>Then return {@code /42/example?productId=1}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.buildRelativeProductURL(String, Product)"})
  public void testBuildRelativeProductURL_givenOne_when42_thenReturn42ExampleProductId1() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult =
        catalogURLServiceImpl.buildRelativeProductURL("42", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("/42/example?productId=1", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@code Current Url}.
   *   <li>Then return {@code Current Url}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.buildRelativeProductURL(String, Product)"})
  public void testBuildRelativeProductURL_givenOne_whenCurrentUrl_thenReturnCurrentUrl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult =
        catalogURLServiceImpl.buildRelativeProductURL("Current Url", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("Current Url", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When empty string.
   *   <li>Then return {@code /example?productId=1}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.buildRelativeProductURL(String, Product)"})
  public void testBuildRelativeProductURL_givenOne_whenEmptyString_thenReturnExampleProductId1() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult =
        catalogURLServiceImpl.buildRelativeProductURL("", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("/example?productId=1", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@code /}.
   *   <li>Then return {@code /example?productId=1}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.buildRelativeProductURL(String, Product)"})
  public void testBuildRelativeProductURL_givenOne_whenSlash_thenReturnExampleProductId1() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult =
        catalogURLServiceImpl.buildRelativeProductURL("/", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("/example?productId=1", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/example}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.buildRelativeProductURL(String, Product)"})
  public void testBuildRelativeProductURL_thenReturnHttpsExampleOrgExampleExample() {
    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult =
        catalogURLServiceImpl.buildRelativeProductURL("https://example.org/example", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("https://example.org/example/example", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/example?productId=1}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.buildRelativeProductURL(String, Product)"})
  public void testBuildRelativeProductURL_thenReturnHttpsExampleOrgExampleExampleProductId1() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult =
        catalogURLServiceImpl.buildRelativeProductURL("https://example.org/example", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals(
        "https://example.org/example/example?productId=1", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@code 42}.
   *   <li>Then return {@code /42/example?categoryId=1}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String,
   * org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeCategoryURL(String, org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testBuildRelativeCategoryURL_givenOne_when42_thenReturn42ExampleCategoryId1() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult =
        catalogURLServiceImpl.buildRelativeCategoryURL("42", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("/42/example?categoryId=1", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@code Current Url}.
   *   <li>Then return {@code Current Url}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String,
   * org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeCategoryURL(String, org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testBuildRelativeCategoryURL_givenOne_whenCurrentUrl_thenReturnCurrentUrl() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult =
        catalogURLServiceImpl.buildRelativeCategoryURL("Current Url", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("Current Url", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@code /}.
   *   <li>Then return {@code /example?categoryId=1}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String,
   * org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeCategoryURL(String, org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testBuildRelativeCategoryURL_givenOne_whenSlash_thenReturnExampleCategoryId1() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult =
        catalogURLServiceImpl.buildRelativeCategoryURL("/", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("/example?categoryId=1", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/example}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String,
   * org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeCategoryURL(String, org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testBuildRelativeCategoryURL_thenReturnHttpsExampleOrgExampleExample() {
    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult =
        catalogURLServiceImpl.buildRelativeCategoryURL("https://example.org/example", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("https://example.org/example/example", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example/example?categoryId=1}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String,
   * org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeCategoryURL(String, org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testBuildRelativeCategoryURL_thenReturnHttpsExampleOrgExampleExampleCategoryId1() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult =
        catalogURLServiceImpl.buildRelativeCategoryURL("https://example.org/example", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals(
        "https://example.org/example/example?categoryId=1", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code /example?categoryId=1}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String,
   * org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeCategoryURL(String, org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testBuildRelativeCategoryURL_whenEmptyString_thenReturnExampleCategoryId1() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult =
        catalogURLServiceImpl.buildRelativeCategoryURL("", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("/example?categoryId=1", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeUrlWithParam(String, String, String, String)"
  })
  public void testBuildRelativeUrlWithParam() {
    // Arrange, Act and Assert
    assertEquals(
        "/https://example.org/example?https%3A%2F%2Fexample.org%2Fexample=https%3A%2F%2Fexample.org%2Fexample",
        catalogURLServiceImpl.buildRelativeUrlWithParam(
            "",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example"));
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeUrlWithParam(String, String, String, String)"
  })
  public void testBuildRelativeUrlWithParam2() {
    // Arrange, Act and Assert
    assertEquals(
        "/https://example.org/example?https%3A%2F%2Fexample.org%2Fexample=https%3A%2F%2Fexample.org%2Fexample",
        catalogURLServiceImpl.buildRelativeUrlWithParam(
            "/",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example"));
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeUrlWithParam(String, String, String, String)"
  })
  public void testBuildRelativeUrlWithParam3() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example/https://example.org/example?Id+Param=https%3A%2F%2Fexample.org%2Fexample",
        catalogURLServiceImpl.buildRelativeUrlWithParam(
            "https://example.org/example",
            "https://example.org/example",
            "Id Param",
            "https://example.org/example"));
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeUrlWithParam(String, String, String, String)"
  })
  public void testBuildRelativeUrlWithParam4() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example/https://example.org/example",
        new CatalogURLServiceImpl()
            .buildRelativeUrlWithParam(
                "https://example.org/example",
                "https://example.org/example",
                "https://example.org/example",
                "https://example.org/example"));
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link CatalogURLServiceImpl}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeUrlWithParam(String, String, String, String)"
  })
  public void testBuildRelativeUrlWithParam_givenCatalogURLServiceImpl_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example/https://example.org/example?https%3A%2F%2Fexample.org%2Fexample=https%3A"
            + "%2F%2Fexample.org%2Fexample",
        catalogURLServiceImpl.buildRelativeUrlWithParam(
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example"));
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link CatalogURLServiceImpl} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeUrlWithParam(String, String, String, String)"
  })
  public void testBuildRelativeUrlWithParam_givenCatalogURLServiceImpl_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        new CatalogURLServiceImpl()
            .buildRelativeUrlWithParam(
                "", "/", "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeUrlWithParam(String, String, String, String)"
  })
  public void testBuildRelativeUrlWithParam_when42_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "/42/https://example.org/example?https%3A%2F%2Fexample.org%2Fexample=https%3A%2F%2Fexample.org"
            + "%2Fexample",
        catalogURLServiceImpl.buildRelativeUrlWithParam(
            "42",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example"));
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Current Url}.
   *   <li>Then return {@code Current Url}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.buildRelativeUrlWithParam(String, String, String, String)"
  })
  public void testBuildRelativeUrlWithParam_whenCurrentUrl_thenReturnCurrentUrl() {
    // Arrange, Act and Assert
    assertEquals(
        "Current Url",
        catalogURLServiceImpl.buildRelativeUrlWithParam(
            "Current Url",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example"));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code :}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.getProductUrlFragment(Product)"})
  public void testGetProductUrlFragment_givenCategoryImplNameIsColon_thenReturnEmptyString() {
    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName(":");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertEquals("", catalogURLServiceImpl.getProductUrlFragment(product));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.getProductUrlFragment(Product)"})
  public void testGetProductUrlFragment_givenCategoryImplNameIsName_thenReturnNull() {
    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("Name");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertEquals("null", catalogURLServiceImpl.getProductUrlFragment(product));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.getProductUrlFragment(Product)"})
  public void testGetProductUrlFragment_givenCategoryImplNameIsQuestionMark() {
    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("?");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertEquals("", catalogURLServiceImpl.getProductUrlFragment(product));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code //}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.getProductUrlFragment(Product)"})
  public void testGetProductUrlFragment_givenCategoryImplNameIsSlashSlash() {
    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("//");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertEquals("", catalogURLServiceImpl.getProductUrlFragment(product));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code /}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.getProductUrlFragment(Product)"})
  public void testGetProductUrlFragment_givenCategoryImplNameIsSlash_thenReturnEmptyString() {
    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("/");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertEquals("", catalogURLServiceImpl.getProductUrlFragment(product));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is space.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.getProductUrlFragment(Product)"})
  public void testGetProductUrlFragment_givenCategoryImplNameIsSpace_thenReturnNull() {
    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName(" ");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertEquals("null", catalogURLServiceImpl.getProductUrlFragment(product));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code UU UU}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.getProductUrlFragment(Product)"})
  public void testGetProductUrlFragment_givenCategoryImplNameIsUuUu_thenReturnNull() {
    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("UU UU");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertEquals("null", catalogURLServiceImpl.getProductUrlFragment(product));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code .*?\W.*?}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.getProductUrlFragment(Product)"})
  public void testGetProductUrlFragment_givenCategoryImplNameIsW_thenReturnNull() {
    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName(".*?\\W.*?");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertEquals("null", catalogURLServiceImpl.getProductUrlFragment(product));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then return {@code example}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.getProductUrlFragment(Product)"})
  public void testGetProductUrlFragment_givenHttpsExampleOrgExample_thenReturnExample() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualProductUrlFragment = catalogURLServiceImpl.getProductUrlFragment(product);

    // Assert
    verify(product).getUrl();
    assertEquals("example", actualProductUrlFragment);
  }

  /**
   * Test {@link CatalogURLServiceImpl#getCategoryUrlFragment(Category)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then return {@code example}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogURLServiceImpl#getCategoryUrlFragment(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogURLServiceImpl.getCategoryUrlFragment(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCategoryUrlFragment_givenHttpsExampleOrgExample_thenReturnExample() {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualCategoryUrlFragment = catalogURLServiceImpl.getCategoryUrlFragment(category);

    // Assert
    verify(category).getUrl();
    assertEquals("example", actualCategoryUrlFragment);
  }

  /**
   * Test {@link CatalogURLServiceImpl#getLastFragment(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code example}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogURLServiceImpl#getLastFragment(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CatalogURLServiceImpl.getLastFragment(String)"})
  public void testGetLastFragment_whenHttpsExampleOrgExample_thenReturnExample() {
    // Arrange, Act and Assert
    assertEquals("example", catalogURLServiceImpl.getLastFragment("https://example.org/example"));
  }
}
