package org.broadleafcommerce.core.web.seo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.core.catalog.domain.CategoryAttribute;
import org.broadleafcommerce.core.catalog.domain.CategoryAttributeImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductAttribute;
import org.broadleafcommerce.core.catalog.domain.ProductAttributeImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BasicSeoPropertyGeneratorImplDiffblueTest {
  @InjectMocks private BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl;

  @Mock private SeoDefaultPropertyService seoDefaultPropertyService;

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.filterForSeoProperties(Map)"})
  public void testFilterForSeoProperties_givenFoo_whenHashMapFooIsFoo_thenReturnEmpty() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("foo", "foo");

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties).isEmpty());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   *
   * <ul>
   *   <li>Given {@code metaDescription}.
   *   <li>When {@link HashMap#HashMap()} {@code metaDescription} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.filterForSeoProperties(Map)"})
  public void testFilterForSeoProperties_givenMetaDescription_whenHashMapMetaDescriptionIsFoo() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("metaDescription", "foo");

    // Act
    Map<String, String> actualFilterForSeoPropertiesResult =
        basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties);

    // Assert
    assertEquals(properties, actualFilterForSeoPropertiesResult);
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   *
   * <ul>
   *   <li>Given {@code title}.
   *   <li>When {@link HashMap#HashMap()} {@code title} is {@code foo}.
   *   <li>Then return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.filterForSeoProperties(Map)"})
  public void testFilterForSeoProperties_givenTitle_whenHashMapTitleIsFoo_thenReturnHashMap() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("title", "foo");

    // Act
    Map<String, String> actualFilterForSeoPropertiesResult =
        basicSeoPropertyGeneratorImpl.filterForSeoProperties(properties);

    // Assert
    assertEquals(properties, actualFilterForSeoPropertiesResult);
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#filterForSeoProperties(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.filterForSeoProperties(Map)"})
  public void testFilterForSeoProperties_whenHashMap_thenReturnEmpty() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    // Act and Assert
    assertTrue(basicSeoPropertyGeneratorImpl.filterForSeoProperties(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link CategoryAttributeImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BasicSeoPropertyGeneratorImpl#gatherSeoProperties(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map BasicSeoPropertyGeneratorImpl.gatherSeoProperties(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGatherSeoPropertiesWithCategory_givenHashMapFooIsCategoryAttributeImpl() {
    // Arrange
    when(seoDefaultPropertyService.getCanonicalUrl(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getCategoryDescriptionPattern())
        .thenReturn("Category Description Pattern");
    when(seoDefaultPropertyService.getCategoryTitlePattern()).thenReturn("Dr");
    when(seoDefaultPropertyService.getPaginationNextUrl(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getPaginationPrevUrl(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn("https://example.org/example");

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    categoryAttributes.put("foo", new CategoryAttributeImpl());

    CategoryImpl category = new CategoryImpl();
    category.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, String> actualGatherSeoPropertiesResult =
        basicSeoPropertyGeneratorImpl.gatherSeoProperties(category);

    // Assert
    verify(seoDefaultPropertyService)
        .getCanonicalUrl(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(seoDefaultPropertyService).getCategoryDescriptionPattern();
    verify(seoDefaultPropertyService).getCategoryTitlePattern();
    verify(seoDefaultPropertyService)
        .getPaginationNextUrl(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(seoDefaultPropertyService)
        .getPaginationPrevUrl(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    assertEquals(5, actualGatherSeoPropertiesResult.size());
    assertEquals(
        "Category Description Pattern", actualGatherSeoPropertiesResult.get("metaDescription"));
    assertEquals("Dr", actualGatherSeoPropertiesResult.get("title"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("canonicalUrl"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("paginationNextUrl"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("paginationPrevUrl"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Category)} with {@code category}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link
   * BasicSeoPropertyGeneratorImpl#gatherSeoProperties(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map BasicSeoPropertyGeneratorImpl.gatherSeoProperties(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGatherSeoPropertiesWithCategory_whenCategoryImpl_thenReturnSizeIsFive() {
    // Arrange
    when(seoDefaultPropertyService.getCanonicalUrl(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getCategoryDescriptionPattern())
        .thenReturn("Category Description Pattern");
    when(seoDefaultPropertyService.getCategoryTitlePattern()).thenReturn("Dr");
    when(seoDefaultPropertyService.getPaginationNextUrl(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getPaginationPrevUrl(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn("https://example.org/example");

    // Act
    Map<String, String> actualGatherSeoPropertiesResult =
        basicSeoPropertyGeneratorImpl.gatherSeoProperties(new CategoryImpl());

    // Assert
    verify(seoDefaultPropertyService)
        .getCanonicalUrl(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(seoDefaultPropertyService).getCategoryDescriptionPattern();
    verify(seoDefaultPropertyService).getCategoryTitlePattern();
    verify(seoDefaultPropertyService)
        .getPaginationNextUrl(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(seoDefaultPropertyService)
        .getPaginationPrevUrl(isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    assertEquals(5, actualGatherSeoPropertiesResult.size());
    assertEquals(
        "Category Description Pattern", actualGatherSeoPropertiesResult.get("metaDescription"));
    assertEquals("Dr", actualGatherSeoPropertiesResult.get("title"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("canonicalUrl"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("paginationNextUrl"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("paginationPrevUrl"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(PageDTO)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.gatherSeoProperties(PageDTO)"})
  public void testGatherSeoPropertiesWithPage_givenHashMapFooIsFoo() {
    // Arrange
    when(seoDefaultPropertyService.getDescription(Mockito.<PageDTO>any()))
        .thenReturn("The characteristics of someone or something");
    when(seoDefaultPropertyService.getTitle(Mockito.<PageDTO>any())).thenReturn("Dr");

    HashMap<String, String> pageAttributes = new HashMap<>();
    pageAttributes.put("foo", "foo");

    PageDTO page = new PageDTO();
    page.setPageAttributes(pageAttributes);

    // Act
    Map<String, String> actualGatherSeoPropertiesResult =
        basicSeoPropertyGeneratorImpl.gatherSeoProperties(page);

    // Assert
    verify(seoDefaultPropertyService).getDescription(isA(PageDTO.class));
    verify(seoDefaultPropertyService).getTitle(isA(PageDTO.class));
    assertEquals(2, actualGatherSeoPropertiesResult.size());
    assertEquals("Dr", actualGatherSeoPropertiesResult.get("title"));
    assertEquals(
        "The characteristics of someone or something",
        actualGatherSeoPropertiesResult.get("metaDescription"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(PageDTO)} with {@code page}.
   *
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.gatherSeoProperties(PageDTO)"})
  public void testGatherSeoPropertiesWithPage_whenPageDTO_thenReturnSizeIsTwo() {
    // Arrange
    when(seoDefaultPropertyService.getDescription(Mockito.<PageDTO>any()))
        .thenReturn("The characteristics of someone or something");
    when(seoDefaultPropertyService.getTitle(Mockito.<PageDTO>any())).thenReturn("Dr");

    // Act
    Map<String, String> actualGatherSeoPropertiesResult =
        basicSeoPropertyGeneratorImpl.gatherSeoProperties(new PageDTO());

    // Assert
    verify(seoDefaultPropertyService).getDescription(isA(PageDTO.class));
    verify(seoDefaultPropertyService).getTitle(isA(PageDTO.class));
    assertEquals(2, actualGatherSeoPropertiesResult.size());
    assertEquals("Dr", actualGatherSeoPropertiesResult.get("title"));
    assertEquals(
        "The characteristics of someone or something",
        actualGatherSeoPropertiesResult.get("metaDescription"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ProductAttributeImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.gatherSeoProperties(Product)"})
  public void testGatherSeoPropertiesWithProduct_givenHashMapFooIsProductAttributeImpl() {
    // Arrange
    when(seoDefaultPropertyService.getCanonicalUrl(Mockito.<Product>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getPaginationNextUrl(Mockito.<Product>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getPaginationPrevUrl(Mockito.<Product>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getProductDescriptionPattern(Mockito.<Product>any()))
        .thenReturn("Product Description Pattern");
    when(seoDefaultPropertyService.getProductTitlePattern(Mockito.<Product>any())).thenReturn("Dr");

    HashMap<String, ProductAttribute> productAttributes = new HashMap<>();
    productAttributes.put("foo", new ProductAttributeImpl());

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductAttributes(productAttributes);

    // Act
    Map<String, String> actualGatherSeoPropertiesResult =
        basicSeoPropertyGeneratorImpl.gatherSeoProperties(product);

    // Assert
    verify(seoDefaultPropertyService).getCanonicalUrl(isA(Product.class));
    verify(seoDefaultPropertyService).getPaginationNextUrl(isA(Product.class));
    verify(seoDefaultPropertyService).getPaginationPrevUrl(isA(Product.class));
    verify(seoDefaultPropertyService).getProductDescriptionPattern(isA(Product.class));
    verify(seoDefaultPropertyService).getProductTitlePattern(isA(Product.class));
    assertEquals(5, actualGatherSeoPropertiesResult.size());
    assertEquals("Dr", actualGatherSeoPropertiesResult.get("title"));
    assertEquals(
        "Product Description Pattern", actualGatherSeoPropertiesResult.get("metaDescription"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("canonicalUrl"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("paginationNextUrl"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("paginationPrevUrl"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Product)} with {@code product}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#gatherSeoProperties(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicSeoPropertyGeneratorImpl.gatherSeoProperties(Product)"})
  public void testGatherSeoPropertiesWithProduct_whenProductBundleImpl_thenReturnSizeIsFive() {
    // Arrange
    when(seoDefaultPropertyService.getCanonicalUrl(Mockito.<Product>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getPaginationNextUrl(Mockito.<Product>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getPaginationPrevUrl(Mockito.<Product>any()))
        .thenReturn("https://example.org/example");
    when(seoDefaultPropertyService.getProductDescriptionPattern(Mockito.<Product>any()))
        .thenReturn("Product Description Pattern");
    when(seoDefaultPropertyService.getProductTitlePattern(Mockito.<Product>any())).thenReturn("Dr");

    // Act
    Map<String, String> actualGatherSeoPropertiesResult =
        basicSeoPropertyGeneratorImpl.gatherSeoProperties(new ProductBundleImpl());

    // Assert
    verify(seoDefaultPropertyService).getCanonicalUrl(isA(Product.class));
    verify(seoDefaultPropertyService).getPaginationNextUrl(isA(Product.class));
    verify(seoDefaultPropertyService).getPaginationPrevUrl(isA(Product.class));
    verify(seoDefaultPropertyService).getProductDescriptionPattern(isA(Product.class));
    verify(seoDefaultPropertyService).getProductTitlePattern(isA(Product.class));
    assertEquals(5, actualGatherSeoPropertiesResult.size());
    assertEquals("Dr", actualGatherSeoPropertiesResult.get("title"));
    assertEquals(
        "Product Description Pattern", actualGatherSeoPropertiesResult.get("metaDescription"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("canonicalUrl"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("paginationNextUrl"));
    assertEquals(
        "https://example.org/example", actualGatherSeoPropertiesResult.get("paginationPrevUrl"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}.
   *
   * <ul>
   *   <li>Given {@code title}.
   *   <li>Then {@link HashMap#HashMap()} {@code title} is {@code Properties}.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicSeoPropertyGeneratorImpl.addDefaultTitle(Map, String)"})
  public void testAddDefaultTitle_givenTitle_thenHashMapTitleIsProperties() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

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
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link HashMap#HashMap()} {@code title} is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#addDefaultTitle(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicSeoPropertyGeneratorImpl.addDefaultTitle(Map, String)"})
  public void testAddDefaultTitle_whenHashMap_thenHashMapTitleIsDr() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();
    HashMap<String, String> properties = new HashMap<>();

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultTitle(properties, "Dr");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Dr", properties.get("title"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code metaDescription} is {@code Default Description}.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicSeoPropertyGeneratorImpl.addDefaultDescription(Map, String)"})
  public void testAddDefaultDescription_thenHashMapMetaDescriptionIsDefaultDescription() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();
    HashMap<String, String> properties = new HashMap<>();

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultDescription(properties, "Default Description");

    // Assert
    assertEquals(1, properties.size());
    assertEquals("Default Description", properties.get("metaDescription"));
  }

  /**
   * Test {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} {@code metaDescription} is {@code Properties}.
   * </ul>
   *
   * <p>Method under test: {@link BasicSeoPropertyGeneratorImpl#addDefaultDescription(Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicSeoPropertyGeneratorImpl.addDefaultDescription(Map, String)"})
  public void testAddDefaultDescription_thenHashMapMetaDescriptionIsProperties() {
    // Arrange
    BasicSeoPropertyGeneratorImpl basicSeoPropertyGeneratorImpl =
        new BasicSeoPropertyGeneratorImpl();

    HashMap<String, String> properties = new HashMap<>();
    properties.put("metaDescription", "Properties");

    // Act
    basicSeoPropertyGeneratorImpl.addDefaultDescription(properties, "Default Description");

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertEquals("Properties", properties.get("metaDescription"));
  }
}
