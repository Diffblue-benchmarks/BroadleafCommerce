package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.search.domain.CategoryExcludedSearchFacet;
import org.broadleafcommerce.core.search.domain.CategorySearchFacet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryImplDiffblueTest {
  @Autowired private CategoryImpl categoryImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryImpl#setCategoryAttributes(List)}
   *   <li>{@link CategoryImpl#setCategoryMediaXref(Map)}
   *   <li>{@link CategoryImpl#setChildCategoryIds(List)}
   *   <li>{@link CategoryImpl#setChildCategoryURLMap(Map)}
   *   <li>{@link CategoryImpl#setDefaultParentCategory(Category)}
   *   <li>{@link CategoryImpl#setDescription(String)}
   *   <li>{@link CategoryImpl#setDisplayTemplate(String)}
   *   <li>{@link CategoryImpl#setExcludedSearchFacets(List)}
   *   <li>{@link CategoryImpl#setExternalId(String)}
   *   <li>{@link CategoryImpl#setId(Long)}
   *   <li>{@link CategoryImpl#setLongDescription(String)}
   *   <li>{@link CategoryImpl#setMetaDescription(String)}
   *   <li>{@link CategoryImpl#setMetaTitle(String)}
   *   <li>{@link CategoryImpl#setName(String)}
   *   <li>{@link CategoryImpl#setProductDescriptionPatternOverride(String)}
   *   <li>{@link CategoryImpl#setProductTitlePatternOverride(String)}
   *   <li>{@link CategoryImpl#setRootDisplayOrder(BigDecimal)}
   *   <li>{@link CategoryImpl#setSearchFacets(List)}
   *   <li>{@link CategoryImpl#setTaxCode(String)}
   *   <li>{@link CategoryImpl#setUrl(String)}
   *   <li>{@link CategoryImpl#setUrlKey(String)}
   *   <li>{@link CategoryImpl#getActiveEndDate()}
   *   <li>{@link CategoryImpl#getAllChildCategoryXrefs()}
   *   <li>{@link CategoryImpl#getAllParentCategoryXrefs()}
   *   <li>{@link CategoryImpl#getAllProductXrefs()}
   *   <li>{@link CategoryImpl#getCategoryAttributes()}
   *   <li>{@link CategoryImpl#getCategoryMediaXref()}
   *   <li>{@link CategoryImpl#getCrossSaleProducts()}
   *   <li>{@link CategoryImpl#getDisplayTemplate()}
   *   <li>{@link CategoryImpl#getExcludedSearchFacets()}
   *   <li>{@link CategoryImpl#getExternalId()}
   *   <li>{@link CategoryImpl#getFeaturedProducts()}
   *   <li>{@link CategoryImpl#getId()}
   *   <li>{@link CategoryImpl#getMetaDescription()}
   *   <li>{@link CategoryImpl#getMetaTitle()}
   *   <li>{@link CategoryImpl#getProductDescriptionPatternOverride()}
   *   <li>{@link CategoryImpl#getProductTitlePatternOverride()}
   *   <li>{@link CategoryImpl#getRootDisplayOrder()}
   *   <li>{@link CategoryImpl#getSearchFacets()}
   *   <li>{@link CategoryImpl#getTaxCode()}
   *   <li>{@link CategoryImpl#getUpSaleProducts()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Date CategoryImpl.getActiveEndDate()",
    "List CategoryImpl.getAllChildCategoryXrefs()",
    "List CategoryImpl.getAllParentCategoryXrefs()",
    "List CategoryImpl.getAllProductXrefs()",
    "List CategoryImpl.getCategoryAttributes()",
    "Map CategoryImpl.getCategoryMediaXref()",
    "List CategoryImpl.getCrossSaleProducts()",
    "String CategoryImpl.getDisplayTemplate()",
    "List CategoryImpl.getExcludedSearchFacets()",
    "String CategoryImpl.getExternalId()",
    "List CategoryImpl.getFeaturedProducts()",
    "Long CategoryImpl.getId()",
    "String CategoryImpl.getMetaDescription()",
    "String CategoryImpl.getMetaTitle()",
    "String CategoryImpl.getProductDescriptionPatternOverride()",
    "String CategoryImpl.getProductTitlePatternOverride()",
    "BigDecimal CategoryImpl.getRootDisplayOrder()",
    "List CategoryImpl.getSearchFacets()",
    "String CategoryImpl.getTaxCode()",
    "List CategoryImpl.getUpSaleProducts()",
    "void CategoryImpl.setCategoryAttributes(List)",
    "void CategoryImpl.setCategoryMediaXref(Map)",
    "void CategoryImpl.setChildCategoryIds(List)",
    "void CategoryImpl.setChildCategoryURLMap(Map)",
    "void CategoryImpl.setDefaultParentCategory(Category)",
    "void CategoryImpl.setDescription(String)",
    "void CategoryImpl.setDisplayTemplate(String)",
    "void CategoryImpl.setExcludedSearchFacets(List)",
    "void CategoryImpl.setExternalId(String)",
    "void CategoryImpl.setId(Long)",
    "void CategoryImpl.setLongDescription(String)",
    "void CategoryImpl.setMetaDescription(String)",
    "void CategoryImpl.setMetaTitle(String)",
    "void CategoryImpl.setName(String)",
    "void CategoryImpl.setProductDescriptionPatternOverride(String)",
    "void CategoryImpl.setProductTitlePatternOverride(String)",
    "void CategoryImpl.setRootDisplayOrder(BigDecimal)",
    "void CategoryImpl.setSearchFacets(List)",
    "void CategoryImpl.setTaxCode(String)",
    "void CategoryImpl.setUrl(String)",
    "void CategoryImpl.setUrlKey(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    ArrayList<CategoryAttribute> categoryAttributes = new ArrayList<>();

    // Act
    categoryImpl.setCategoryAttributes(categoryAttributes);
    HashMap<String, CategoryMediaXref> categoryMediaXref = new HashMap<>();
    categoryImpl.setCategoryMediaXref(categoryMediaXref);
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    ArrayList<CategoryExcludedSearchFacet> excludedSearchFacets = new ArrayList<>();
    categoryImpl.setExcludedSearchFacets(excludedSearchFacets);
    categoryImpl.setExternalId("42");
    categoryImpl.setId(1L);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    BigDecimal rootDisplayOrder = new BigDecimal("2.3");
    categoryImpl.setRootDisplayOrder(rootDisplayOrder);
    ArrayList<CategorySearchFacet> searchFacets = new ArrayList<>();
    categoryImpl.setSearchFacets(searchFacets);
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");
    Date actualActiveEndDate = categoryImpl.getActiveEndDate();
    List<CategoryXref> actualAllChildCategoryXrefs = categoryImpl.getAllChildCategoryXrefs();
    List<CategoryXref> actualAllParentCategoryXrefs = categoryImpl.getAllParentCategoryXrefs();
    List<CategoryProductXref> actualAllProductXrefs = categoryImpl.getAllProductXrefs();
    List<CategoryAttribute> actualCategoryAttributes = categoryImpl.getCategoryAttributes();
    Map<String, CategoryMediaXref> actualCategoryMediaXref = categoryImpl.getCategoryMediaXref();
    List<RelatedProduct> actualCrossSaleProducts = categoryImpl.getCrossSaleProducts();
    String actualDisplayTemplate = categoryImpl.getDisplayTemplate();
    List<CategoryExcludedSearchFacet> actualExcludedSearchFacets =
        categoryImpl.getExcludedSearchFacets();
    String actualExternalId = categoryImpl.getExternalId();
    List<FeaturedProduct> actualFeaturedProducts = categoryImpl.getFeaturedProducts();
    Long actualId = categoryImpl.getId();
    String actualMetaDescription = categoryImpl.getMetaDescription();
    String actualMetaTitle = categoryImpl.getMetaTitle();
    String actualProductDescriptionPatternOverride =
        categoryImpl.getProductDescriptionPatternOverride();
    String actualProductTitlePatternOverride = categoryImpl.getProductTitlePatternOverride();
    BigDecimal actualRootDisplayOrder = categoryImpl.getRootDisplayOrder();
    List<CategorySearchFacet> actualSearchFacets = categoryImpl.getSearchFacets();
    String actualTaxCode = categoryImpl.getTaxCode();
    List<RelatedProduct> actualUpSaleProducts = categoryImpl.getUpSaleProducts();

    // Assert
    assertEquals("42", actualExternalId);
    assertEquals("Display Template", actualDisplayTemplate);
    assertEquals("Dr", actualMetaTitle);
    assertEquals("Dr", actualProductTitlePatternOverride);
    assertEquals("Meta Description", actualMetaDescription);
    assertEquals("Product Description Pattern Override", actualProductDescriptionPatternOverride);
    assertEquals("Tax Code", actualTaxCode);
    assertNull(actualActiveEndDate);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAllChildCategoryXrefs.isEmpty());
    assertTrue(actualAllParentCategoryXrefs.isEmpty());
    assertTrue(actualAllProductXrefs.isEmpty());
    assertTrue(actualCategoryAttributes.isEmpty());
    assertTrue(actualCrossSaleProducts.isEmpty());
    assertTrue(actualExcludedSearchFacets.isEmpty());
    assertTrue(actualFeaturedProducts.isEmpty());
    assertTrue(actualSearchFacets.isEmpty());
    assertTrue(actualUpSaleProducts.isEmpty());
    assertTrue(actualCategoryMediaXref.isEmpty());
    assertEquals(new BigDecimal("2.3"), actualRootDisplayOrder);
    assertSame(rootDisplayOrder, actualRootDisplayOrder);
    assertSame(categoryAttributes, actualCategoryAttributes);
    assertSame(excludedSearchFacets, actualExcludedSearchFacets);
    assertSame(searchFacets, actualSearchFacets);
    assertSame(categoryMediaXref, actualCategoryMediaXref);
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryIds()}.
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryIds()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.createChildCategoryIds()"})
  public void testCreateChildCategoryIds() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.createChildCategoryIds().isEmpty());
    assertTrue(categoryImpl.childCategoryIds.isEmpty());
    List<Long> expectedChildCategoryIds = categoryImpl.childCategoryIds;
    assertSame(expectedChildCategoryIds, categoryImpl.getChildCategoryIds());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Cannot create childCategoryURLMap - the urlKey for a category(");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult =
        actualCreateChildCategoryURLMapResult.get(
            "/cannot-create-childCategoryURLMap---the-urlKey-for-a-category");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("cannot-create-childCategoryURLMap---the-urlKey-for-a-category");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult =
        actualCreateChildCategoryURLMapResult.get(
            "/cannot-create-childCategoryURLMap---the-urlKey-for-a-category");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsColon() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(":");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsEmptyString() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsQuestionMark() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("?");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsSlash() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("/");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code .*?\W.*?}.
   *   <li>Then return {@code /w} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnWSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(".*?\\W.*?");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/w");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code [^\w-]+}.
   *   <li>Then return {@code /w-} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnWSizeIsOne2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("[^\\w-]+");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/w-");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImpl_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> categoryImpl.createChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Then return empty string size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnEmptyStringSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("/");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("");
    assertEquals(1, getResult.size());
    assertEquals(1L, getResult.get(0).longValue());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Then return {@code /https://example.org/example} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnHttpsExampleOrgExampleSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult =
        actualCreateChildCategoryURLMapResult.get("/https://example.org/example");
    assertEquals(1, getResult.size());
    assertEquals(1L, getResult.get(0).longValue());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Then return {@code /javalangString} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnJavalangStringSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.lang.String");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/javalangString");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Then return {@code /name} first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnNameFirstIsNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Name");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/name");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Then return {@code /name} first longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnNameFirstLongValueIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/name");
    assertEquals(1, getResult.size());
    assertEquals(1L, getResult.get(0).longValue());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Then return {@code /---} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnSlashDashDashDashSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("   ");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/---");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Then return {@code /-} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnSlashDashSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" ");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/-");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Then return {@code /xx-xx} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnXxXxSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("xx xx");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/xx-xx");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setDefaultParentCategory(new CategoryImpl());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(new ArrayList<>());

    // Assert
    assertEquals(1, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category defaultParentCategory2 = getResult.getDefaultParentCategory();
    assertTrue(defaultParentCategory2 instanceof CategoryImpl);
    assertEquals(defaultParentCategory, defaultParentCategory2);
    assertSame(defaultParentCategory2, ((CategoryImpl) getResult).defaultParentCategory);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath2() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(currentPath);

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    assertEquals(1, currentPath.size());
    assertSame(currentPath, actualBuildDefaultParentCategoryPathResult);
    assertSame(categoryImpl.defaultParentCategory, currentPath.get(0));
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_givenCategoryImpl() {
    // Arrange
    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertSame(currentPath, actualBuildDefaultParentCategoryPathResult);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_givenCategoryImplNameIsNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName(null);
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(null);

    // Assert
    assertEquals(2, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    assertSame(categoryImpl, getResult);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.buildDefaultParentCategoryPath(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first is {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenArrayListFirstIsCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertSame(currentPath, actualBuildDefaultParentCategoryPathResult);
    assertSame(defaultParentCategory, currentPath.get(0));
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>Then return first is {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenReturnFirstIsCategoryImpl() {
    // Arrange and Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(null);

    // Assert
    assertEquals(1, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    assertSame(categoryImpl, getResult);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>Then return second is {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenReturnSecondIsCategoryImpl() {
    // Arrange
    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());
    CategoryImpl categoryImpl = new CategoryImpl();
    currentPath.add(categoryImpl);

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertEquals(2, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals(categoryImpl, getResult);
    assertSame(categoryImpl, getResult);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenThrowUnsupportedOperationException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new UnsupportedOperationException());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.buildDefaultParentCategoryPath(new ArrayList<>()));
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return first Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_whenNull_thenReturnFirstNameIsName() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setName("Name");

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(null);

    // Assert
    assertEquals(2, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category getResult2 = actualBuildDefaultParentCategoryPathResult.get(1);
    assertTrue(getResult2 instanceof CategoryImpl);
    assertEquals("Name", getResult.getName());
    assertEquals("Name", getResult2.getName());
    assertEquals("Name", ((CategoryImpl) getResult).getMainEntityName());
    assertEquals("Name", ((CategoryImpl) getResult2).getMainEntityName());
    assertEquals("Name", ((CategoryImpl) getResult).name);
    assertEquals("Name", ((CategoryImpl) getResult2).name);
    assertEquals("name", getResult.getGeneratedUrl());
    assertEquals("name", getResult.getUrlKey());
    assertNull(getResult.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return second is {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_whenNull_thenReturnSecondIsCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(null);

    // Assert
    assertEquals(2, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    assertSame(categoryImpl, getResult);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_whenNull_thenReturnSizeIsOne() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setId(1L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(null);

    // Assert
    assertEquals(1, actualBuildDefaultParentCategoryPathResult.size());
    assertTrue(actualBuildDefaultParentCategoryPathResult.get(0) instanceof CategoryImpl);
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and {@link CategoryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryImpl#equals(Object)}
   *   <li>{@link CategoryImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    categoryImpl2.setDescription("The characteristics of someone or something");
    categoryImpl2.setDisplayTemplate("Display Template");
    categoryImpl2.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl2.setExternalId("42");
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl2.setId(1L);
    categoryImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl2.setLongDescription("Long Description");
    categoryImpl2.setMetaDescription("Meta Description");
    categoryImpl2.setMetaTitle("Dr");
    categoryImpl2.setName("Name");
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");

    // Act and Assert
    assertEquals(categoryImpl, categoryImpl2);
    assertEquals(categoryImpl.hashCode(), categoryImpl2.hashCode());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and {@link CategoryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryImpl#equals(Object)}
   *   <li>{@link CategoryImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(null);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    categoryImpl2.setDescription("The characteristics of someone or something");
    categoryImpl2.setDisplayTemplate("Display Template");
    categoryImpl2.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl2.setExternalId("42");
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl2.setId(1L);
    categoryImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl2.setLongDescription("Long Description");
    categoryImpl2.setMetaDescription("Meta Description");
    categoryImpl2.setMetaTitle("Dr");
    categoryImpl2.setName("Name");
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");

    // Act and Assert
    assertEquals(categoryImpl, categoryImpl2);
    assertEquals(categoryImpl.hashCode(), categoryImpl2.hashCode());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and {@link CategoryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryImpl#equals(Object)}
   *   <li>{@link CategoryImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    categoryImpl2.setDescription("The characteristics of someone or something");
    categoryImpl2.setDisplayTemplate("Display Template");
    categoryImpl2.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl2.setExternalId("42");
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl2.setId(null);
    categoryImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl2.setLongDescription("Long Description");
    categoryImpl2.setMetaDescription("Meta Description");
    categoryImpl2.setMetaTitle("Dr");
    categoryImpl2.setName("Name");
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");

    // Act and Assert
    assertEquals(categoryImpl, categoryImpl2);
    assertEquals(categoryImpl.hashCode(), categoryImpl2.hashCode());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and {@link CategoryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryImpl#equals(Object)}
   *   <li>{@link CategoryImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(null);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName(null);
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    categoryImpl2.setDescription("The characteristics of someone or something");
    categoryImpl2.setDisplayTemplate("Display Template");
    categoryImpl2.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl2.setExternalId("42");
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl2.setId(1L);
    categoryImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl2.setLongDescription("Long Description");
    categoryImpl2.setMetaDescription("Meta Description");
    categoryImpl2.setMetaTitle("Dr");
    categoryImpl2.setName(null);
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");

    // Act and Assert
    assertEquals(categoryImpl, categoryImpl2);
    assertEquals(categoryImpl.hashCode(), categoryImpl2.hashCode());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and {@link CategoryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryImpl#equals(Object)}
   *   <li>{@link CategoryImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(null);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl(null);
    categoryImpl.setUrlKey("https://example.org/example");

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    categoryImpl2.setDescription("The characteristics of someone or something");
    categoryImpl2.setDisplayTemplate("Display Template");
    categoryImpl2.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl2.setExternalId("42");
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl2.setId(1L);
    categoryImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl2.setLongDescription("Long Description");
    categoryImpl2.setMetaDescription("Meta Description");
    categoryImpl2.setMetaTitle("Dr");
    categoryImpl2.setName("Name");
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl(null);
    categoryImpl2.setUrlKey("https://example.org/example");

    // Act and Assert
    assertEquals(categoryImpl, categoryImpl2);
    assertEquals(categoryImpl.hashCode(), categoryImpl2.hashCode());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and {@link CategoryImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryImpl#equals(Object)}
   *   <li>{@link CategoryImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    // Act and Assert
    assertEquals(categoryImpl, categoryImpl);
    int expectedHashCodeResult = categoryImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryImpl.hashCode());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(2L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    categoryImpl2.setDescription("The characteristics of someone or something");
    categoryImpl2.setDisplayTemplate("Display Template");
    categoryImpl2.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl2.setExternalId("42");
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl2.setId(1L);
    categoryImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl2.setLongDescription("Long Description");
    categoryImpl2.setMetaDescription("Meta Description");
    categoryImpl2.setMetaTitle("Dr");
    categoryImpl2.setName("Name");
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");

    // Act and Assert
    assertNotEquals(categoryImpl, categoryImpl2);
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(null);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("https://example.org/example");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    categoryImpl2.setDescription("The characteristics of someone or something");
    categoryImpl2.setDisplayTemplate("Display Template");
    categoryImpl2.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl2.setExternalId("42");
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl2.setId(1L);
    categoryImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl2.setLongDescription("Long Description");
    categoryImpl2.setMetaDescription("Meta Description");
    categoryImpl2.setMetaTitle("Dr");
    categoryImpl2.setName("Name");
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");

    // Act and Assert
    assertNotEquals(categoryImpl, categoryImpl2);
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(null);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName(null);
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    categoryImpl2.setDescription("The characteristics of someone or something");
    categoryImpl2.setDisplayTemplate("Display Template");
    categoryImpl2.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl2.setExternalId("42");
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl2.setId(1L);
    categoryImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl2.setLongDescription("Long Description");
    categoryImpl2.setMetaDescription("Meta Description");
    categoryImpl2.setMetaTitle("Dr");
    categoryImpl2.setName("Name");
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");

    // Act and Assert
    assertNotEquals(categoryImpl, categoryImpl2);
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(null);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("Name");
    categoryImpl.setUrlKey("https://example.org/example");

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    categoryImpl2.setDescription("The characteristics of someone or something");
    categoryImpl2.setDisplayTemplate("Display Template");
    categoryImpl2.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl2.setExternalId("42");
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl2.setId(1L);
    categoryImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl2.setLongDescription("Long Description");
    categoryImpl2.setMetaDescription("Meta Description");
    categoryImpl2.setMetaTitle("Dr");
    categoryImpl2.setName("Name");
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");

    // Act and Assert
    assertNotEquals(categoryImpl, categoryImpl2);
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(null);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl(null);
    categoryImpl.setUrlKey("https://example.org/example");

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    categoryImpl2.setDescription("The characteristics of someone or something");
    categoryImpl2.setDisplayTemplate("Display Template");
    categoryImpl2.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl2.setExternalId("42");
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl2.setId(1L);
    categoryImpl2.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl2.setLongDescription("Long Description");
    categoryImpl2.setMetaDescription("Meta Description");
    categoryImpl2.setMetaTitle("Dr");
    categoryImpl2.setName("Name");
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");

    // Act and Assert
    assertNotEquals(categoryImpl, categoryImpl2);
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    // Act and Assert
    assertNotEquals(categoryImpl, null);
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
    categoryImpl.setChildCategoryURLMap(new HashMap<>());
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    categoryImpl.setId(1L);
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);
    categoryImpl.setLongDescription("Long Description");
    categoryImpl.setMetaDescription("Meta Description");
    categoryImpl.setMetaTitle("Dr");
    categoryImpl.setName("Name");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    // Act and Assert
    assertNotEquals(categoryImpl, "Different type to CategoryImpl");
  }

  /**
   * Test new {@link CategoryImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CategoryImpl}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.<init>()"})
  public void testNewCategoryImpl() {
    // Arrange and Act
    CategoryImpl actualCategoryImpl = new CategoryImpl();

    // Assert
    assertEquals("null", actualCategoryImpl.getGeneratedUrl());
    assertEquals('N', actualCategoryImpl.getArchived().charValue());
    assertNull(actualCategoryImpl.getId());
    assertNull(actualCategoryImpl.getDescription());
    assertNull(actualCategoryImpl.getDisplayTemplate());
    assertNull(actualCategoryImpl.getExternalId());
    assertNull(actualCategoryImpl.getLocation());
    assertNull(actualCategoryImpl.getLongDescription());
    assertNull(actualCategoryImpl.getMainEntityName());
    assertNull(actualCategoryImpl.getMetaDescription());
    assertNull(actualCategoryImpl.getMetaTitle());
    assertNull(actualCategoryImpl.getName());
    assertNull(actualCategoryImpl.getProductDescriptionPatternOverride());
    assertNull(actualCategoryImpl.getProductTitlePatternOverride());
    assertNull(actualCategoryImpl.getTaxCode());
    assertNull(actualCategoryImpl.getUrl());
    assertNull(actualCategoryImpl.getUrlKey());
    assertNull(actualCategoryImpl.description);
    assertNull(actualCategoryImpl.fulfillmentType);
    assertNull(actualCategoryImpl.inventoryType);
    assertNull(actualCategoryImpl.longDescription);
    assertNull(actualCategoryImpl.name);
    assertNull(actualCategoryImpl.url);
    assertNull(actualCategoryImpl.urlKey);
    assertNull(actualCategoryImpl.getRootDisplayOrder());
    assertNull(actualCategoryImpl.getActiveEndDate());
    assertNull(actualCategoryImpl.getActiveStartDate());
    assertNull(actualCategoryImpl.activeStartDate);
    assertNull(actualCategoryImpl.childCategoryIds);
    assertNull(actualCategoryImpl.filteredFeaturedProducts);
    assertNull(actualCategoryImpl.filteredCrossSales);
    assertNull(actualCategoryImpl.filteredUpSales);
    assertNull(actualCategoryImpl.childCategoryURLMap);
    assertNull(actualCategoryImpl.getDefaultParentCategory());
    assertNull(actualCategoryImpl.getParentCategory());
    assertNull(actualCategoryImpl.defaultParentCategory);
    assertNull(actualCategoryImpl.getParentCategoryXref());
    assertNull(actualCategoryImpl.getInventoryType());
    assertNull(actualCategoryImpl.getFulfillmentType());
    assertFalse(actualCategoryImpl.getOverrideGeneratedUrl());
    assertFalse(actualCategoryImpl.hasAllChildCategories());
    assertFalse(actualCategoryImpl.hasChildCategories());
    assertFalse(actualCategoryImpl.overrideGeneratedUrl);
    assertTrue(actualCategoryImpl.getActiveProductXrefs().isEmpty());
    assertTrue(actualCategoryImpl.getActiveProducts().isEmpty());
    assertTrue(actualCategoryImpl.getAllChildCategories().isEmpty());
    assertTrue(actualCategoryImpl.getAllChildCategoryXrefs().isEmpty());
    assertTrue(actualCategoryImpl.getAllParentCategories().isEmpty());
    assertTrue(actualCategoryImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(actualCategoryImpl.getAllProductXrefs().isEmpty());
    assertTrue(actualCategoryImpl.getAllProducts().isEmpty());
    assertTrue(actualCategoryImpl.getCategoryAttributes().isEmpty());
    assertTrue(actualCategoryImpl.getChildCategories().isEmpty());
    assertTrue(actualCategoryImpl.getChildCategoryXrefs().isEmpty());
    assertTrue(actualCategoryImpl.getCrossSaleProducts().isEmpty());
    assertTrue(actualCategoryImpl.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(actualCategoryImpl.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(actualCategoryImpl.getCumulativeSearchFacets().isEmpty());
    assertTrue(actualCategoryImpl.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(actualCategoryImpl.getExcludedSearchFacets().isEmpty());
    assertTrue(actualCategoryImpl.getFeaturedProducts().isEmpty());
    assertTrue(actualCategoryImpl.getSearchFacets().isEmpty());
    assertTrue(actualCategoryImpl.getUpSaleProducts().isEmpty());
    assertTrue(actualCategoryImpl.allLegacyChildCategories.isEmpty());
    assertTrue(actualCategoryImpl.childCategoryXrefs.isEmpty());
    assertTrue(actualCategoryImpl.legacyChildCategories.isEmpty());
    assertTrue(actualCategoryImpl.getCategoryAttributesMap().isEmpty());
    assertTrue(actualCategoryImpl.getCategoryMedia().isEmpty());
    assertTrue(actualCategoryImpl.getCategoryMediaXref().isEmpty());
    assertTrue(actualCategoryImpl.getMappedCategoryAttributes().isEmpty());
    assertTrue(actualCategoryImpl.getMultiValueCategoryAttributes().isEmpty());
    assertTrue(actualCategoryImpl.legacyCategoryMedia.isEmpty());
  }
}
