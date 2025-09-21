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
package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SeoElementVariableExpressionDiffblueTest {
  /**
   * Test {@link SeoElementVariableExpression#getName()}.
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("seoElement", new SeoElementVariableExpression().getName());
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Given {@code Dr}.
   *   <li>When {@link CategoryImpl} (default constructor) MetaTitle is {@code Dr}.
   *   <li>Then return {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getTitle(Category)}
   */
  @Test
  @DisplayName(
      "Test getTitle(Category) with 'category'; given 'Dr'; when CategoryImpl (default constructor) MetaTitle is 'Dr'; then return 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getTitle(Category)"})
  void testGetTitleWithCategory_givenDr_whenCategoryImplMetaTitleIsDr_thenReturnDr() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    CategoryImpl category = new CategoryImpl();
    category.setMetaTitle("Dr");

    // Act and Assert
    assertEquals("Dr", seoElementVariableExpression.getTitle(category));
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getTitle(Category)}
   */
  @Test
  @DisplayName("Test getTitle(Category) with 'category'; given empty string; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getTitle(Category)"})
  void testGetTitleWithCategory_givenEmptyString_thenReturnName() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    Category category = mock(Category.class);
    when(category.getMetaTitle()).thenReturn("");
    when(category.getName()).thenReturn("Name");

    // Act
    String actualTitle = seoElementVariableExpression.getTitle(category);

    // Assert
    verify(category).getMetaTitle();
    verify(category).getName();
    assertEquals("Name", actualTitle);
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Category)} with {@code category}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getTitle(Category)}
   */
  @Test
  @DisplayName(
      "Test getTitle(Category) with 'category'; when CategoryImpl (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getTitle(Category)"})
  void testGetTitleWithCategory_whenCategoryImpl_thenReturnNull() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    // Act and Assert
    assertNull(seoElementVariableExpression.getTitle(new CategoryImpl()));
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@code Dr}.
   *   <li>Then return {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  @DisplayName("Test getTitle(Product) with 'product'; given 'Dr'; then return 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getTitle(Product)"})
  void testGetTitleWithProduct_givenDr_thenReturnDr() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMetaTitle()).thenReturn("Dr");

    // Act
    String actualTitle = seoElementVariableExpression.getTitle(product);

    // Assert
    verify(product).getMetaTitle();
    assertEquals("Dr", actualTitle);
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  @DisplayName("Test getTitle(Product) with 'product'; given empty string; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getTitle(Product)"})
  void testGetTitleWithProduct_givenEmptyString_thenReturnName() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getMetaTitle()).thenReturn("");
    when(product.getName()).thenReturn("Name");

    // Act
    String actualTitle = seoElementVariableExpression.getTitle(product);

    // Assert
    verify(product).getMetaTitle();
    verify(product).getName();
    assertEquals("Name", actualTitle);
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  @DisplayName(
      "Test getTitle(Product) with 'product'; given SkuImpl (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getTitle(Product)"})
  void testGetTitleWithProduct_givenSkuImpl_thenReturnNull() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(seoElementVariableExpression.getTitle(product));
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  @DisplayName("Test getDescription(Category) with 'category'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Category)"})
  void testGetDescriptionWithCategory_givenEmptyString() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    Category category = mock(Category.class);
    when(category.getLongDescription()).thenReturn("");
    when(category.getMetaDescription()).thenReturn("");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(category);

    // Assert
    verify(category).getLongDescription();
    verify(category).getMetaDescription();
    assertEquals("", actualDescription);
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Given {@code not empty}.
   *   <li>Then return {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  @DisplayName(
      "Test getDescription(Category) with 'category'; given 'not empty'; then return 'not empty'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Category)"})
  void testGetDescriptionWithCategory_givenNotEmpty_thenReturnNotEmpty() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    Category category = mock(Category.class);
    when(category.getLongDescription()).thenReturn("not empty");
    when(category.getMetaDescription()).thenReturn("not empty");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(category);

    // Assert
    verify(category).getLongDescription();
    verify(category).getMetaDescription();
    assertEquals("not empty", actualDescription);
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with {@code category}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor) LongDescription is {@code
   *       longDescription}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  @DisplayName(
      "Test getDescription(Category) with 'category'; when CategoryImpl (default constructor) LongDescription is 'longDescription'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Category)"})
  void testGetDescriptionWithCategory_whenCategoryImplLongDescriptionIsLongDescription() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    CategoryImpl category = new CategoryImpl();
    category.setLongDescription("longDescription");

    // Act and Assert
    assertEquals("longDescription", seoElementVariableExpression.getDescription(category));
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with {@code category}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor) MetaDescription is {@code
   *       longDescription}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  @DisplayName(
      "Test getDescription(Category) with 'category'; when CategoryImpl (default constructor) MetaDescription is 'longDescription'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Category)"})
  void testGetDescriptionWithCategory_whenCategoryImplMetaDescriptionIsLongDescription() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    CategoryImpl category = new CategoryImpl();
    category.setMetaDescription("longDescription");

    // Act and Assert
    assertEquals("longDescription", seoElementVariableExpression.getDescription(category));
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with {@code category}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  @DisplayName(
      "Test getDescription(Category) with 'category'; when CategoryImpl (default constructor); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Category)"})
  void testGetDescriptionWithCategory_whenCategoryImpl_thenReturnEmptyString() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    // Act and Assert
    assertEquals("", seoElementVariableExpression.getDescription(new CategoryImpl()));
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Product)} with {@code product}.
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  @DisplayName("Test getDescription(Product) with 'product'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Product)"})
  void testGetDescriptionWithProduct() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getLongDescription()).thenReturn("");
    when(product.getMetaDescription()).thenReturn("");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(product);

    // Assert
    verify(product).getLongDescription();
    verify(product).getMetaDescription();
    assertEquals("", actualDescription);
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@code Long Description}.
   *   <li>Then return {@code Long Description}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  @DisplayName(
      "Test getDescription(Product) with 'product'; given 'Long Description'; then return 'Long Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Product)"})
  void testGetDescriptionWithProduct_givenLongDescription_thenReturnLongDescription() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getLongDescription()).thenReturn("Long Description");
    when(product.getMetaDescription()).thenReturn("");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(product);

    // Assert
    verify(product).getLongDescription();
    verify(product).getMetaDescription();
    assertEquals("Long Description", actualDescription);
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@code Meta Description}.
   *   <li>Then return {@code Meta Description}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  @DisplayName(
      "Test getDescription(Product) with 'product'; given 'Meta Description'; then return 'Meta Description'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Product)"})
  void testGetDescriptionWithProduct_givenMetaDescription_thenReturnMetaDescription() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getLongDescription()).thenReturn("Long Description");
    when(product.getMetaDescription()).thenReturn("Meta Description");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(product);

    // Assert
    verify(product).getLongDescription();
    verify(product).getMetaDescription();
    assertEquals("Meta Description", actualDescription);
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  @DisplayName("Test getDescription(Product) with 'product'; given SkuImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Product)"})
  void testGetDescriptionWithProduct_givenSkuImpl() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertEquals("", seoElementVariableExpression.getDescription(product));
  }

  /**
   * Test {@link SeoElementVariableExpression#buildTitleString(List, String)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return {@code fooElement Delimiterseo.site.simple.url}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#buildTitleString(List, String)}
   */
  @Test
  @DisplayName(
      "Test buildTitleString(List, String); given 'foo'; then return 'fooElement Delimiterseo.site.simple.url'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.buildTitleString(List, String)"})
  void testBuildTitleString_givenFoo_thenReturnFooElementDelimiterseoSiteSimpleUrl() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ArrayList<String> titleElements = new ArrayList<>();
    titleElements.add("foo");
    titleElements.add("seo.site.simple.url");

    // Act and Assert
    assertEquals(
        "fooElement Delimiterseo.site.simple.url",
        seoElementVariableExpression.buildTitleString(titleElements, "Element Delimiter"));
  }

  /**
   * Test {@link SeoElementVariableExpression#buildTitleString(List, String)}.
   *
   * <ul>
   *   <li>Given {@code seo.site.simple.url}.
   *   <li>Then return {@code seo.site.simple.url}.
   * </ul>
   *
   * <p>Method under test: {@link SeoElementVariableExpression#buildTitleString(List, String)}
   */
  @Test
  @DisplayName(
      "Test buildTitleString(List, String); given 'seo.site.simple.url'; then return 'seo.site.simple.url'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.buildTitleString(List, String)"})
  void testBuildTitleString_givenSeoSiteSimpleUrl_thenReturnSeoSiteSimpleUrl() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ArrayList<String> titleElements = new ArrayList<>();
    titleElements.add("seo.site.simple.url");

    // Act and Assert
    assertEquals(
        "seo.site.simple.url",
        seoElementVariableExpression.buildTitleString(titleElements, "Element Delimiter"));
  }
}
