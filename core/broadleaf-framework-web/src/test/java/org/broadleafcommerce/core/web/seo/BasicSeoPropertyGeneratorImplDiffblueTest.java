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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BasicSeoPropertyGeneratorImplDiffblueTest {
  @InjectMocks
  private BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl;

  @Mock
  private SeoDefaultPropertyService seoDefaultPropertyService;

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given 'foo'; when HashMap() 'foo' is 'foo'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.filterForSeoProperties(Map)"})
  void testFilterForSeoProperties_givenFoo_whenHashMapFooIsFoo_thenReturnEmpty() {
    // Arrange
    HashMap<String, String> properties = new HashMap<>();
    properties.put("foo", "foo");

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties).isEmpty());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@code metaDescription}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code metaDescription} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given 'metaDescription'; when HashMap() 'metaDescription' is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.filterForSeoProperties(Map)"})
  void testFilterForSeoProperties_givenMetaDescription_whenHashMapMetaDescriptionIsFoo() {
    // Arrange
    HashMap<String, String> properties = new HashMap<>();
    properties.put("metaDescription", "foo");

    // Act and Assert
    assertEquals(properties, basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>Given {@code title}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code title} is {@code foo}.</li>
   *   <li>Then return {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); given 'title'; when HashMap() 'title' is 'foo'; then return HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.filterForSeoProperties(Map)"})
  void testFilterForSeoProperties_givenTitle_whenHashMapTitleIsFoo_thenReturnHashMap() {
    // Arrange
    HashMap<String, String> properties = new HashMap<>();
    properties.put("title", "foo");

    // Act and Assert
    assertEquals(properties, basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @DisplayName("Test filterForSeoProperties(Map); when HashMap(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.filterForSeoProperties(Map)"})
  void testFilterForSeoProperties_whenHashMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Category)} with {@code category}.
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Category)}
   */
  @Test
  @DisplayName("Test gatherSeoProperties(Category) with 'category'; when CategoryImpl (default constructor); then return size is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.gatherSeoProperties(Category)"})
  void testGatherSeoPropertiesWithCategory_whenCategoryImpl_thenReturnSizeIsFive() {
    // Arrange
    when(seoDefaultPropertyService.getCanonicalUrl(Mockito.<Category>any())).thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getCategoryDescriptionPattern()).thenReturn("Category Description Pattern");
    when(seoDefaultPropertyService.getCategoryTitlePattern()).thenReturn("Dr");
    when(seoDefaultPropertyService.getPaginationNextUrl(Mockito.<Category>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getPaginationPrevUrl(Mockito.<Category>any()))
        .thenReturn("https://example.org/example");

    // Act
    Map<String, String> actualGatherSeoPropertiesResult = basicSeoPropertyGeneratorImpl
        .gatherSeoProperties(new CategoryImpl());

    // Assert
    verify(seoDefaultPropertyService).getCanonicalUrl(isA(Category.class));
    verify(seoDefaultPropertyService).getCategoryDescriptionPattern();
    verify(seoDefaultPropertyService).getCategoryTitlePattern();
    verify(seoDefaultPropertyService).getPaginationNextUrl(isA(Category.class));
    verify(seoDefaultPropertyService).getPaginationPrevUrl(isA(Category.class));
    assertEquals(5, actualGatherSeoPropertiesResult.size());
    assertEquals("Category Description Pattern", actualGatherSeoPropertiesResult.get("metaDescription"));
    assertEquals("Dr", actualGatherSeoPropertiesResult.get("title"));
    assertEquals("https://example.org/example", actualGatherSeoPropertiesResult.get("canonicalUrl"));
    assertEquals("https://example.org/example", actualGatherSeoPropertiesResult.get("paginationNextUrl"));
    assertEquals("https://example.org/example", actualGatherSeoPropertiesResult.get("paginationPrevUrl"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(PageDTO)} with {@code page}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(PageDTO)}
   */
  @Test
  @DisplayName("Test gatherSeoProperties(PageDTO) with 'page'; when PageDTO (default constructor); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.gatherSeoProperties(PageDTO)"})
  void testGatherSeoPropertiesWithPage_whenPageDTO_thenReturnSizeIsTwo() {
    // Arrange
    when(seoDefaultPropertyService.getDescription(Mockito.<PageDTO>any()))
        .thenReturn("The characteristics of someone or something");
    when(seoDefaultPropertyService.getTitle(Mockito.<PageDTO>any())).thenReturn("Dr");

    // Act
    Map<String, String> actualGatherSeoPropertiesResult = basicSeoPropertyGeneratorImpl
        .gatherSeoProperties(new PageDTO());

    // Assert
    verify(seoDefaultPropertyService).getDescription(isA(PageDTO.class));
    verify(seoDefaultPropertyService).getTitle(isA(PageDTO.class));
    assertEquals(2, actualGatherSeoPropertiesResult.size());
    assertEquals("Dr", actualGatherSeoPropertiesResult.get("title"));
    assertEquals("The characteristics of someone or something", actualGatherSeoPropertiesResult.get("metaDescription"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Product)} with {@code product}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Product)}
   */
  @Test
  @DisplayName("Test gatherSeoProperties(Product) with 'product'; when ProductBundleImpl (default constructor); then return size is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.gatherSeoProperties(Product)"})
  void testGatherSeoPropertiesWithProduct_whenProductBundleImpl_thenReturnSizeIsFive() {
    // Arrange
    when(seoDefaultPropertyService.getCanonicalUrl(Mockito.<Product>any())).thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getPaginationNextUrl(Mockito.<Product>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getPaginationPrevUrl(Mockito.<Product>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getProductDescriptionPattern(Mockito.<Product>any()))
        .thenReturn("Product Description Pattern");
    when(seoDefaultPropertyService.getProductTitlePattern(Mockito.<Product>any())).thenReturn("Dr");

    // Act
    Map<String, String> actualGatherSeoPropertiesResult = basicSeoPropertyGeneratorImpl
        .gatherSeoProperties(new ProductBundleImpl());

    // Assert
    verify(seoDefaultPropertyService).getCanonicalUrl(isA(Product.class));
    verify(seoDefaultPropertyService).getPaginationNextUrl(isA(Product.class));
    verify(seoDefaultPropertyService).getPaginationPrevUrl(isA(Product.class));
    verify(seoDefaultPropertyService).getProductDescriptionPattern(isA(Product.class));
    verify(seoDefaultPropertyService).getProductTitlePattern(isA(Product.class));
    assertEquals(5, actualGatherSeoPropertiesResult.size());
    assertEquals("Dr", actualGatherSeoPropertiesResult.get("title"));
    assertEquals("Product Description Pattern", actualGatherSeoPropertiesResult.get("metaDescription"));
    assertEquals("https://example.org/example", actualGatherSeoPropertiesResult.get("canonicalUrl"));
    assertEquals("https://example.org/example", actualGatherSeoPropertiesResult.get("paginationNextUrl"));
    assertEquals("https://example.org/example", actualGatherSeoPropertiesResult.get("paginationPrevUrl"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}.
   * <ul>
   *   <li>Given {@code title}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code title} is {@code Properties}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultTitle(Map, String); given 'title'; then HashMap() 'title' is 'Properties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BasicSeoPropertyGeneratorImpl.addDefaultTitle(Map, String)"})
  void testAddDefaultTitle_givenTitle_thenHashMapTitleIsProperties() {
    // Arrange
    HashMap<String, String> properties = new HashMap<>();
    properties.put("title", "Properties");

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultTitle(properties, "Dr");

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertEquals("Properties", properties.get("title"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code title} is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultTitle(Map, String); when HashMap(); then HashMap() 'title' is 'Dr'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BasicSeoPropertyGeneratorImpl.addDefaultTitle(Map, String)"})
  void testAddDefaultTitle_whenHashMap_thenHashMapTitleIsDr() {
    // Arrange
    HashMap<String, String> properties = new HashMap<>();

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultTitle(properties, "Dr");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Dr", properties.get("title"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code metaDescription} is {@code Default Description}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultDescription(Map, String); then HashMap() 'metaDescription' is 'Default Description'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BasicSeoPropertyGeneratorImpl.addDefaultDescription(Map, String)"})
  void testAddDefaultDescription_thenHashMapMetaDescriptionIsDefaultDescription() {
    // Arrange
    HashMap<String, String> properties = new HashMap<>();

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultDescription(properties, "Default Description");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Default Description", properties.get("metaDescription"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code metaDescription} is {@code Properties}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @DisplayName("Test addDefaultDescription(Map, String); then HashMap() 'metaDescription' is 'Properties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BasicSeoPropertyGeneratorImpl.addDefaultDescription(Map, String)"})
  void testAddDefaultDescription_thenHashMapMetaDescriptionIsProperties() {
    // Arrange
    HashMap<String, String> properties = new HashMap<>();
    properties.put("metaDescription", "Properties");

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultDescription(properties, "Default Description");

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertEquals("Properties", properties.get("metaDescription"));
  }
}
