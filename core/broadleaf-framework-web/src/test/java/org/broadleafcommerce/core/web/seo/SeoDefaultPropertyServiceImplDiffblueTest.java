/*-
 * #%L
 * BroadleafCommerce Framework Web
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeoDefaultPropertyServiceImplDiffblueTest {
  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product)")
  void testGetProductTitlePattern() {
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
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); given CategoryImpl (default constructor)")
  void testGetProductTitlePattern_givenCategoryImpl() {
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
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>Then return {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); then return 'Dr'")
  void testGetProductTitlePattern_thenReturnDr() {
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
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); when 'null'; then return empty string")
  void testGetProductTitlePattern_whenNull_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SeoDefaultPropertyServiceImpl()).getProductTitlePattern(null));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductTitlePattern(Product)}
   */
  @Test
  @DisplayName("Test getProductTitlePattern(Product); when ProductBundleImpl (default constructor); then return empty string")
  void testGetProductTitlePattern_whenProductBundleImpl_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("", seoDefaultPropertyServiceImpl.getProductTitlePattern(new ProductBundleImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PageDTO#getPageAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}
   */
  @Test
  @DisplayName("Test getTitle(PageDTO); given HashMap(); then calls getPageAttributes()")
  void testGetTitle_givenHashMap_thenCallsGetPageAttributes() {
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
  void testGetTitle_whenPageDTO_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getTitle(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Category)} with
   * {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Category)}
   */
  @Test
  @DisplayName("Test getType(Category) with 'category'; when CategoryImpl (default constructor)")
  void testGetTypeWithCategory_whenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new CategoryImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Category)} with
   * {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Category)}
   */
  @Test
  @DisplayName("Test getType(Category) with 'category'; when CategoryImpl")
  void testGetTypeWithCategory_whenCategoryImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("article", (new SeoDefaultPropertyServiceImpl()).getType(mock(CategoryImpl.class)));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>When {@link NullPageDTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)}
   */
  @Test
  @DisplayName("Test getType(PageDTO) with 'page'; when NullPageDTO")
  void testGetTypeWithPage_whenNullPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("article", (new SeoDefaultPropertyServiceImpl()).getType(mock(NullPageDTO.class)));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)}
   */
  @Test
  @DisplayName("Test getType(PageDTO) with 'page'; when PageDTO (default constructor)")
  void testGetTypeWithPage_whenPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Product)} with
   * {@code product}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Product)}
   */
  @Test
  @DisplayName("Test getType(Product) with 'product'; when ProductBundleImpl (default constructor)")
  void testGetTypeWithProduct_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("product", seoDefaultPropertyServiceImpl.getType(new ProductBundleImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Product)} with
   * {@code product}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getType(Product)}
   */
  @Test
  @DisplayName("Test getType(Product) with 'product'; when ProductBundleImpl")
  void testGetTypeWithProduct_whenProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("product", (new SeoDefaultPropertyServiceImpl()).getType(mock(ProductBundleImpl.class)));
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product)")
  void testGetProductDescriptionPattern() {
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
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); given CategoryImpl (default constructor)")
  void testGetProductDescriptionPattern_givenCategoryImpl() {
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
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>Then return {@code Product Description Pattern Override}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); then return 'Product Description Pattern Override'")
  void testGetProductDescriptionPattern_thenReturnProductDescriptionPatternOverride() {
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
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); when 'null'; then return empty string")
  void testGetProductDescriptionPattern_whenNull_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SeoDefaultPropertyServiceImpl()).getProductDescriptionPattern(null));
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getProductDescriptionPattern(Product)}
   */
  @Test
  @DisplayName("Test getProductDescriptionPattern(Product); when ProductBundleImpl (default constructor); then return empty string")
  void testGetProductDescriptionPattern_whenProductBundleImpl_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("", seoDefaultPropertyServiceImpl.getProductDescriptionPattern(new ProductBundleImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PageDTO#getPageAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}
   */
  @Test
  @DisplayName("Test getDescription(PageDTO); given HashMap(); then calls getPageAttributes()")
  void testGetDescription_givenHashMap_thenCallsGetPageAttributes() {
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
   * Test {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}
   */
  @Test
  @DisplayName("Test getDescription(PageDTO); when PageDTO (default constructor); then return 'null'")
  void testGetDescription_whenPageDTO_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getDescription(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'; given HashMap(); then return 'null'")
  void testGetImageWithCategory_givenHashMap_thenReturnNull() {
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
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with
   * {@code category}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'; then throw NumberFormatException")
  void testGetImageWithCategory_thenThrowNumberFormatException() {
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
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with
   * {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Category)}
   */
  @Test
  @DisplayName("Test getImage(Category) with 'category'; when CategoryImpl (default constructor); then return 'null'")
  void testGetImageWithCategory_whenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new CategoryImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>When {@link NullPageDTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)}
   */
  @Test
  @DisplayName("Test getImage(PageDTO) with 'page'; when NullPageDTO")
  void testGetImageWithPage_whenNullPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SeoDefaultPropertyServiceImpl()).getImage(mock(NullPageDTO.class)));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)} with
   * {@code page}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)}
   */
  @Test
  @DisplayName("Test getImage(PageDTO) with 'page'; when PageDTO (default constructor)")
  void testGetImageWithPage_whenPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with
   * {@code product}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @DisplayName("Test getImage(Product) with 'product'; given SkuImpl (default constructor); then return 'null'")
  void testGetImageWithProduct_givenSkuImpl_thenReturnNull() {
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
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @DisplayName("Test isValidPrevPageNumber(Integer); when ten; then return 'true'")
  void testIsValidPrevPageNumber_whenTen_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SeoDefaultPropertyServiceImpl()).isValidPrevPageNumber(10));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @DisplayName("Test isValidPrevPageNumber(Integer); when zero; then return 'false'")
  void testIsValidPrevPageNumber_whenZero_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SeoDefaultPropertyServiceImpl()).isValidPrevPageNumber(0));
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   * with {@code product}, {@code pageNumber}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   */
  @Test
  @DisplayName("Test isValidNextPageNumber(Product, Integer) with 'product', 'pageNumber'; when ProductBundleImpl (default constructor)")
  void testIsValidNextPageNumberWithProductPageNumber_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl = new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertTrue(seoDefaultPropertyServiceImpl.isValidNextPageNumber(new ProductBundleImpl(), 10));
  }

  /**
   * Test
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   * with {@code product}, {@code pageNumber}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Product, Integer)}
   */
  @Test
  @DisplayName("Test isValidNextPageNumber(Product, Integer) with 'product', 'pageNumber'; when ProductBundleImpl")
  void testIsValidNextPageNumberWithProductPageNumber_whenProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SeoDefaultPropertyServiceImpl()).isValidNextPageNumber(mock(ProductBundleImpl.class), 10));
  }
}
