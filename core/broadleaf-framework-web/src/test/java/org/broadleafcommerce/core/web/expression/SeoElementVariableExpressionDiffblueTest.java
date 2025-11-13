package org.broadleafcommerce.core.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SeoElementVariableExpressionDiffblueTest {
  /**
   * Test {@link SeoElementVariableExpression#getName()}.
   *
   * <p>Method under test: {@link SeoElementVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("seoElement", new SeoElementVariableExpression().getName());
  }

  /**
   * Test {@link SeoElementVariableExpression#getTitle(Category)} with {@code category}.
   *
   * <p>Method under test: {@link
   * SeoElementVariableExpression#getTitle(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoElementVariableExpression.getTitle(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetTitleWithCategory() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    CategoryImpl category = new CategoryImpl();
    category.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setCategoryAttributes(new ArrayList<>());
    category.setCategoryAttributesMap(new HashMap<>());
    category.setCategoryMediaXref(new HashMap<>());
    category.setChildCategoryIds(new ArrayList<>());
    category.setChildCategoryURLMap(new HashMap<>());
    category.setDefaultParentCategory(new CategoryImpl());
    category.setDescription("The characteristics of someone or something");
    category.setDisplayTemplate("Display Template");
    category.setExcludedSearchFacets(new ArrayList<>());
    category.setExternalId("42");
    category.setFulfillmentType(new FulfillmentType());
    category.setId(1L);
    category.setInventoryType(new InventoryType());
    category.setLongDescription("Long Description");
    category.setMetaDescription("Meta Description");
    category.setName("Name");
    category.setOverrideGeneratedUrl(true);
    category.setProductDescriptionPatternOverride("Product Description Pattern Override");
    category.setProductTitlePatternOverride("Dr");
    category.setRootDisplayOrder(new BigDecimal("2.3"));
    category.setSearchFacets(new ArrayList<>());
    category.setTaxCode("Tax Code");
    category.setUpSaleProducts(new ArrayList<>());
    category.setUrl("https://example.org/example");
    category.setUrlKey("https://example.org/example");
    category.setMetaTitle("");

    // Act and Assert
    assertEquals("Name", seoElementVariableExpression.getTitle(category));
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
   * <p>Method under test: {@link
   * SeoElementVariableExpression#getTitle(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoElementVariableExpression.getTitle(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetTitleWithCategory_givenDr_whenCategoryImplMetaTitleIsDr_thenReturnDr() {
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
   *   <li>Then calls {@link org.broadleafcommerce.core.catalog.domain.Category#getMetaTitle()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoElementVariableExpression#getTitle(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoElementVariableExpression.getTitle(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetTitleWithCategory_thenCallsGetMetaTitle() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
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
   * <p>Method under test: {@link
   * SeoElementVariableExpression#getTitle(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoElementVariableExpression.getTitle(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetTitleWithCategory_whenCategoryImpl_thenReturnNull() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getTitle(Product)"})
  public void testGetTitleWithProduct_givenDr_thenReturnDr() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getTitle(Product)"})
  public void testGetTitleWithProduct_givenEmptyString_thenReturnName() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getTitle(Product)"})
  public void testGetTitleWithProduct_givenSkuImpl_thenReturnNull() {
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
   *   <li>Then return {@code Long Description}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoElementVariableExpression#getDescription(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoElementVariableExpression.getDescription(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetDescriptionWithCategory_givenEmptyString_thenReturnLongDescription() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    CategoryImpl category = new CategoryImpl();
    category.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setCategoryAttributes(new ArrayList<>());
    category.setCategoryAttributesMap(new HashMap<>());
    category.setCategoryMediaXref(new HashMap<>());
    category.setChildCategoryIds(new ArrayList<>());
    category.setChildCategoryURLMap(new HashMap<>());
    category.setDefaultParentCategory(new CategoryImpl());
    category.setDescription("The characteristics of someone or something");
    category.setDisplayTemplate("Display Template");
    category.setExcludedSearchFacets(new ArrayList<>());
    category.setExternalId("42");
    category.setFulfillmentType(new FulfillmentType());
    category.setId(1L);
    category.setInventoryType(new InventoryType());
    category.setLongDescription("Long Description");
    category.setMetaTitle("Dr");
    category.setName("Name");
    category.setOverrideGeneratedUrl(true);
    category.setProductDescriptionPatternOverride("Product Description Pattern Override");
    category.setProductTitlePatternOverride("Dr");
    category.setRootDisplayOrder(new BigDecimal("2.3"));
    category.setSearchFacets(new ArrayList<>());
    category.setTaxCode("Tax Code");
    category.setUpSaleProducts(new ArrayList<>());
    category.setUrl("https://example.org/example");
    category.setUrlKey("https://example.org/example");
    category.setMetaDescription("");

    // Act and Assert
    assertEquals("Long Description", seoElementVariableExpression.getDescription(category));
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       org.broadleafcommerce.core.catalog.domain.Category#getLongDescription()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoElementVariableExpression#getDescription(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoElementVariableExpression.getDescription(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetDescriptionWithCategory_thenCallsGetLongDescription() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    org.broadleafcommerce.core.catalog.domain.Category category =
        mock(org.broadleafcommerce.core.catalog.domain.Category.class);
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
   *   <li>When {@link CategoryImpl} (default constructor) MetaDescription is {@code not empty}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoElementVariableExpression#getDescription(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoElementVariableExpression.getDescription(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetDescriptionWithCategory_whenCategoryImplMetaDescriptionIsNotEmpty() {
    // Arrange
    SeoElementVariableExpression seoElementVariableExpression = new SeoElementVariableExpression();

    CategoryImpl category = new CategoryImpl();
    category.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setCategoryAttributes(new ArrayList<>());
    category.setCategoryAttributesMap(new HashMap<>());
    category.setCategoryMediaXref(new HashMap<>());
    category.setChildCategoryIds(new ArrayList<>());
    category.setChildCategoryURLMap(new HashMap<>());
    category.setDefaultParentCategory(new CategoryImpl());
    category.setDescription("The characteristics of someone or something");
    category.setDisplayTemplate("Display Template");
    category.setExcludedSearchFacets(new ArrayList<>());
    category.setExternalId("42");
    category.setFulfillmentType(new FulfillmentType());
    category.setId(1L);
    category.setInventoryType(new InventoryType());
    category.setLongDescription("Long Description");
    category.setMetaTitle("Dr");
    category.setName("Name");
    category.setOverrideGeneratedUrl(true);
    category.setProductDescriptionPatternOverride("Product Description Pattern Override");
    category.setProductTitlePatternOverride("Dr");
    category.setRootDisplayOrder(new BigDecimal("2.3"));
    category.setSearchFacets(new ArrayList<>());
    category.setTaxCode("Tax Code");
    category.setUpSaleProducts(new ArrayList<>());
    category.setUrl("https://example.org/example");
    category.setUrlKey("https://example.org/example");
    category.setMetaDescription("not empty");

    // Act and Assert
    assertEquals("not empty", seoElementVariableExpression.getDescription(category));
  }

  /**
   * Test {@link SeoElementVariableExpression#getDescription(Category)} with {@code category}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoElementVariableExpression#getDescription(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoElementVariableExpression.getDescription(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetDescriptionWithCategory_whenCategoryImpl_thenReturnEmptyString() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Product)"})
  public void testGetDescriptionWithProduct() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Product)"})
  public void testGetDescriptionWithProduct_givenLongDescription_thenReturnLongDescription() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Product)"})
  public void testGetDescriptionWithProduct_givenMetaDescription_thenReturnMetaDescription() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.getDescription(Product)"})
  public void testGetDescriptionWithProduct_givenSkuImpl() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.buildTitleString(List, String)"})
  public void testBuildTitleString_givenFoo_thenReturnFooElementDelimiterseoSiteSimpleUrl() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoElementVariableExpression.buildTitleString(List, String)"})
  public void testBuildTitleString_givenSeoSiteSimpleUrl_thenReturnSeoSiteSimpleUrl() {
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
