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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXref;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.jupiter.api.Test;

class SeoDefaultPropertyServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  void testGetProductTitlePattern() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("", seoDefaultPropertyServiceImpl.getProductTitlePattern(new ProductBundleImpl()));
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  void testGetProductTitlePattern2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SeoDefaultPropertyServiceImpl()).getProductTitlePattern(null));
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  void testGetProductTitlePattern3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(new CategoryImpl());

    // Act
    String actualProductTitlePattern = seoDefaultPropertyServiceImpl.getProductTitlePattern(product);

    // Assert
    verify(product).getCategory();
    assertEquals("", actualProductTitlePattern);
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  void testGetProductTitlePattern4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
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
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  void testGetProductTitlePattern5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getProductTitlePatternOverride()).thenReturn("");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualProductTitlePattern = seoDefaultPropertyServiceImpl.getProductTitlePattern(product);

    // Assert
    verify(categoryImpl).getProductTitlePatternOverride();
    verify(product).getCategory();
    assertEquals("", actualProductTitlePattern);
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}
   */
  @Test
  void testGetTitle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getTitle(new PageDTO()));
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}
   */
  @Test
  void testGetTitle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    PageDTO page = mock(PageDTO.class);
    when(page.getPageAttributes()).thenReturn(new HashMap<>());

    // Act
    String actualTitle = seoDefaultPropertyServiceImpl.getTitle(page);

    // Assert
    verify(page).getPageAttributes();
    assertNull(actualTitle);
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)}
   */
  @Test
  void testGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new PageDTO()));
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)}
   */
  @Test
  void testGetType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("article", (new SeoDefaultPropertyServiceImpl()).getType(mock(NullPageDTO.class)));
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Category)}
   */
  @Test
  void testGetType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new CategoryImpl()));
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Category)}
   */
  @Test
  void testGetType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("article", (new SeoDefaultPropertyServiceImpl()).getType(mock(CategoryImpl.class)));
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Product)}
   */
  @Test
  void testGetType5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("product", seoDefaultPropertyServiceImpl.getType(new ProductBundleImpl()));
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Product)}
   */
  @Test
  void testGetType6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("product", (new SeoDefaultPropertyServiceImpl()).getType(mock(ProductBundleImpl.class)));
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  void testGetProductDescriptionPattern() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("", seoDefaultPropertyServiceImpl.getProductDescriptionPattern(new ProductBundleImpl()));
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  void testGetProductDescriptionPattern2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SeoDefaultPropertyServiceImpl()).getProductDescriptionPattern(null));
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  void testGetProductDescriptionPattern3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(new CategoryImpl());

    // Act
    String actualProductDescriptionPattern = seoDefaultPropertyServiceImpl.getProductDescriptionPattern(product);

    // Assert
    verify(product).getCategory();
    assertEquals("", actualProductDescriptionPattern);
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  void testGetProductDescriptionPattern4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
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
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  void testGetProductDescriptionPattern5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getProductDescriptionPatternOverride()).thenReturn("");
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCategory()).thenReturn(categoryImpl);

    // Act
    String actualProductDescriptionPattern = seoDefaultPropertyServiceImpl.getProductDescriptionPattern(product);

    // Assert
    verify(categoryImpl).getProductDescriptionPatternOverride();
    verify(product).getCategory();
    assertEquals("", actualProductDescriptionPattern);
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}
   */
  @Test
  void testGetDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getDescription(new PageDTO()));
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}
   */
  @Test
  void testGetDescription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    PageDTO page = mock(PageDTO.class);
    when(page.getPageAttributes()).thenReturn(new HashMap<>());

    // Act
    String actualDescription = seoDefaultPropertyServiceImpl.getDescription(page);

    // Assert
    verify(page).getPageAttributes();
    assertNull(actualDescription);
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)}
   */
  @Test
  void testGetImage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new PageDTO()));
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)}
   */
  @Test
  void testGetImage2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SeoDefaultPropertyServiceImpl()).getImage(mock(NullPageDTO.class)));
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  void testGetImage3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new CategoryImpl()));
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  void testGetImage4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    Category category = mock(Category.class);
    when(category.getCategoryMediaXref()).thenReturn(new HashMap<>());

    // Act
    String actualImage = seoDefaultPropertyServiceImpl.getImage(category);

    // Assert
    verify(category).getCategoryMediaXref();
    assertNull(actualImage);
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  void testGetImage5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl = mock(CategoryMediaXrefImpl.class);
    when(categoryMediaXrefImpl.getMedia()).thenThrow(new NumberFormatException("foo"));

    HashMap<String, CategoryMediaXref> stringCategoryMediaXrefMap = new HashMap<>();
    stringCategoryMediaXrefMap.put("primary", categoryMediaXrefImpl);
    Category category = mock(Category.class);
    when(category.getCategoryMediaXref()).thenReturn(stringCategoryMediaXrefMap);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getImage(category));
    verify(category).getCategoryMediaXref();
    verify(categoryMediaXrefImpl).getMedia();
  }

  /**
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  void testGetImage6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    String actualImage = seoDefaultPropertyServiceImpl.getImage(product);

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualImage);
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  void testIsValidPrevPageNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SeoDefaultPropertyServiceImpl()).isValidPrevPageNumber(10));
    assertFalse((new SeoDefaultPropertyServiceImpl()).isValidPrevPageNumber(0));
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   */
  @Test
  void testIsValidNextPageNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertTrue(seoDefaultPropertyServiceImpl.isValidNextPageNumber(new ProductBundleImpl(), 10));
  }

  /**
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   */
  @Test
  void testIsValidNextPageNumber2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SeoDefaultPropertyServiceImpl()).isValidNextPageNumber(mock(ProductBundleImpl.class), 10));
  }
}
