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
package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;

public class CatalogURLServiceImplDiffblueTest {
  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code Current Url}.</li>
   *   <li>Then return {@code Current Url}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  public void testBuildRelativeProductURL_givenOne_whenCurrentUrl_thenReturnCurrentUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult = catalogURLServiceImpl.buildRelativeProductURL("Current Url", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("Current Url", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  public void testBuildRelativeProductURL_givenOne_whenEmptyString_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult = catalogURLServiceImpl.buildRelativeProductURL("", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("/example", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  public void testBuildRelativeProductURL_givenOne_whenSlash_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult = catalogURLServiceImpl.buildRelativeProductURL("/", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("/example", actualBuildRelativeProductURLResult);
  }

  /**
   * Test {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeProductURL(String, Product)}
   */
  @Test
  public void testBuildRelativeProductURL_thenReturnHttpsExampleOrgExampleExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeProductURLResult = catalogURLServiceImpl
        .buildRelativeProductURL("https://example.org/example", product);

    // Assert
    verify(product).getId();
    verify(product).getUrl();
    assertEquals("https://example.org/example/example", actualBuildRelativeProductURLResult);
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code Current Url}.</li>
   *   <li>Then return {@code Current Url}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}
   */
  @Test
  public void testBuildRelativeCategoryURL_givenOne_whenCurrentUrl_thenReturnCurrentUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult = catalogURLServiceImpl.buildRelativeCategoryURL("Current Url",
        category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("Current Url", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}
   */
  @Test
  public void testBuildRelativeCategoryURL_givenOne_whenEmptyString_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult = catalogURLServiceImpl.buildRelativeCategoryURL("", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("/example", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}
   */
  @Test
  public void testBuildRelativeCategoryURL_givenOne_whenSlash_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult = catalogURLServiceImpl.buildRelativeCategoryURL("/", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("/example", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeCategoryURL(String, Category)}
   */
  @Test
  public void testBuildRelativeCategoryURL_thenReturnHttpsExampleOrgExampleExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.getId()).thenReturn(1L);
    when(category.getUrl()).thenReturn("https://example.org/example");

    // Act
    String actualBuildRelativeCategoryURLResult = catalogURLServiceImpl
        .buildRelativeCategoryURL("https://example.org/example", category);

    // Assert
    verify(category).getId();
    verify(category).getUrl();
    assertEquals("https://example.org/example/example", actualBuildRelativeCategoryURLResult);
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  public void testBuildRelativeUrlWithParam() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example/https://example.org/example",
        (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("https://example.org/example",
            "https://example.org/example", "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <ul>
   *   <li>When {@code Current Url}.</li>
   *   <li>Then return {@code Current Url}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  public void testBuildRelativeUrlWithParam_whenCurrentUrl_thenReturnCurrentUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Current Url", (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("Current Url",
        "https://example.org/example", "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  public void testBuildRelativeUrlWithParam_whenEmptyString_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/https://example.org/example", (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("",
        "https://example.org/example", "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  public void testBuildRelativeUrlWithParam_whenSlash_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/https://example.org/example", (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("/",
        "https://example.org/example", "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#buildRelativeUrlWithParam(String, String, String, String)}
   */
  @Test
  public void testBuildRelativeUrlWithParam_whenSlash_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/", (new CatalogURLServiceImpl()).buildRelativeUrlWithParam("/", "/", "https://example.org/example",
        "https://example.org/example"));
  }

  /**
   * Test {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#getProductUrlFragment(Product)}
   */
  @Test
  public void testGetProductUrlFragment_givenHttpsExampleOrgExample_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
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
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CatalogURLServiceImpl#getCategoryUrlFragment(Category)}
   */
  @Test
  public void testGetCategoryUrlFragment_givenHttpsExampleOrgExample_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogURLServiceImpl catalogURLServiceImpl = new CatalogURLServiceImpl();
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
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogURLServiceImpl#getLastFragment(String)}
   */
  @Test
  public void testGetLastFragment_whenHttpsExampleOrgExample_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("example", (new CatalogURLServiceImpl()).getLastFragment("https://example.org/example"));
  }
}
