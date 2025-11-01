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
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.jupiter.api.Test;

class SeoElementVariableExpressionDiffblueTest {
  /**
   * Method under test: {@link SeoElementVariableExpression#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("seoElement", (new SeoElementVariableExpression()).getName());
  }

  /**
   * Method under test: {@link SeoElementVariableExpression#getTitle(Category)}
   */
  @Test
  void testGetTitle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    // Act and Assert
    assertNull(seoElementVariableExpression.getTitle(new CategoryImpl()));
  }

  /**
   * Method under test: {@link SeoElementVariableExpression#getTitle(Category)}
   */
  @Test
  void testGetTitle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    Category category = mock(Category.class);
    when(category.getMetaTitle()).thenReturn("Dr");

    // Act
    String actualTitle = seoElementVariableExpression.getTitle(category);

    // Assert
    verify(category).getMetaTitle();
    assertEquals("Dr", actualTitle);
  }

  /**
   * Method under test: {@link SeoElementVariableExpression#getTitle(Category)}
   */
  @Test
  void testGetTitle3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  void testGetTitle4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  void testGetTitle5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  void testGetTitle6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertNull(seoElementVariableExpression.getTitle(product));
  }

  /**
   * Method under test: {@link SeoElementVariableExpression#getTitle(Product)}
   */
  @Test
  void testGetTitle7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(defaultSku);

    // Act and Assert
    assertNull(seoElementVariableExpression.getTitle(product));
  }

  /**
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  void testGetDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    // Act and Assert
    assertEquals("", seoElementVariableExpression.getDescription(new CategoryImpl()));
  }

  /**
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  void testGetDescription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    Category category = mock(Category.class);
    when(category.getLongDescription()).thenReturn("Long Description");
    when(category.getMetaDescription()).thenReturn("Meta Description");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(category);

    // Assert
    verify(category).getLongDescription();
    verify(category).getMetaDescription();
    assertEquals("Meta Description", actualDescription);
  }

  /**
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Category)}
   */
  @Test
  void testGetDescription3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();
    Category category = mock(Category.class);
    when(category.getLongDescription()).thenReturn("Long Description");
    when(category.getMetaDescription()).thenReturn("");

    // Act
    String actualDescription = seoElementVariableExpression.getDescription(category);

    // Assert
    verify(category).getLongDescription();
    verify(category).getMetaDescription();
    assertEquals("Long Description", actualDescription);
  }

  /**
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  void testGetDescription4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  void testGetDescription5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  void testGetDescription6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  void testGetDescription7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());

    // Act and Assert
    assertEquals("", seoElementVariableExpression.getDescription(product));
  }

  /**
   * Method under test:
   * {@link SeoElementVariableExpression#getDescription(Product)}
   */
  @Test
  void testGetDescription8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(defaultSku);

    // Act and Assert
    assertEquals("", seoElementVariableExpression.getDescription(product));
  }

  /**
   * Method under test:
   * {@link SeoElementVariableExpression#buildTitleString(List, String)}
   */
  @Test
  void testBuildTitleString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ArrayList<String> titleElements = new ArrayList<>();
    titleElements.add("seo.site.simple.url");

    // Act and Assert
    assertEquals("seo.site.simple.url",
        seoElementVariableExpression.buildTitleString(titleElements, "Element Delimiter"));
  }

  /**
   * Method under test:
   * {@link SeoElementVariableExpression#buildTitleString(List, String)}
   */
  @Test
  void testBuildTitleString2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    ArrayList<String> titleElements = new ArrayList<>();
    titleElements.add("foo");
    titleElements.add("seo.site.simple.url");

    // Act and Assert
    assertEquals("fooElement Delimiterseo.site.simple.url",
        seoElementVariableExpression.buildTitleString(titleElements, "Element Delimiter"));
  }
}
