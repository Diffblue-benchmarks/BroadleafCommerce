package org.broadleafcommerce.core.web.seo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.web.BaseUrlResolver;
import org.broadleafcommerce.core.catalog.dao.CategoryDao;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXref;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXref;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXrefImpl;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

@RunWith(MockitoJUnitRunner.class)
public class SeoDefaultPropertyServiceImplDiffblueTest {
  @Mock private BaseUrlResolver baseUrlResolver;

  @Mock private CategoryDao categoryDao;

  @Mock private Environment environment;

  @InjectMocks private SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl;

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryTitlePattern()"})
  public void testGetCategoryTitlePattern_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualCategoryTitlePattern = seoDefaultPropertyServiceImpl.getCategoryTitlePattern();

    // Assert
    verify(environment).getProperty("seo.category.title.pattern");
    assertEquals("Property", actualCategoryTitlePattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryTitlePattern()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryTitlePattern()"})
  public void testGetCategoryTitlePattern_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCategoryTitlePattern());
    verify(environment).getProperty("seo.category.title.pattern");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}.
   *
   * <ul>
   *   <li>Given {@link SeoDefaultPropertyServiceImpl} (default constructor).
   *   <li>When {@link PageDTO} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getTitle(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getTitle(PageDTO)"})
  public void testGetTitle_givenSeoDefaultPropertyServiceImpl_whenPageDTO_thenReturnNull() {
    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl =
        new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getTitle(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(Category)} with {@code category}.
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getType(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getType(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetTypeWithCategory() {
    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl =
        new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new CategoryImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)} with {@code page}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getType(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getType(PageDTO)"})
  public void testGetTypeWithPage() {
    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl =
        new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertEquals("article", seoDefaultPropertyServiceImpl.getType(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryDescriptionPattern()"})
  public void testGetCategoryDescriptionPattern_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualCategoryDescriptionPattern =
        seoDefaultPropertyServiceImpl.getCategoryDescriptionPattern();

    // Assert
    verify(environment).getProperty("seo.category.description.pattern");
    assertEquals("Property", actualCategoryDescriptionPattern);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryDescriptionPattern()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryDescriptionPattern()"})
  public void testGetCategoryDescriptionPattern_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCategoryDescriptionPattern());
    verify(environment).getProperty("seo.category.description.pattern");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}.
   *
   * <ul>
   *   <li>Given {@link SeoDefaultPropertyServiceImpl} (default constructor).
   *   <li>When {@link PageDTO} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getDescription(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getDescription(PageDTO)"})
  public void testGetDescription_givenSeoDefaultPropertyServiceImpl_whenPageDTO_thenReturnNull() {
    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl =
        new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getDescription(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Category)} with {@code category}.
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getUrl(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getUrl(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetUrlWithCategory() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getUrl(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getUrl(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetUrlWithCategory_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)} with {@code page}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/examplenull}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(PageDTO)"})
  public void testGetUrlWithPage_thenReturnHttpsExampleOrgExamplenull() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act
    String actualUrl = seoDefaultPropertyServiceImpl.getUrl(new PageDTO());

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    assertEquals("https://example.org/examplenull", actualUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)} with {@code page}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getUrl(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getUrl(PageDTO)"})
  public void testGetUrlWithPage_thenThrowNumberFormatException() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getUrl(new PageDTO()));
    verify(baseUrlResolver).getSiteBaseUrl();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getImage(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getImage(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetImageWithCategory_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    HashMap<String, CategoryMediaXref> categoryMediaXref = new HashMap<>();
    CategoryImpl category = new CategoryImpl();
    CategoryMediaXrefImpl categoryMediaXrefImpl =
        new CategoryMediaXrefImpl(category, new MediaDto(), "primary");
    categoryMediaXref.put("primary", categoryMediaXrefImpl);

    CategoryImpl category2 = new CategoryImpl();
    category2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category2.setCategoryAttributes(new ArrayList<>());
    category2.setCategoryAttributesMap(new HashMap<>());
    category2.setChildCategoryIds(new ArrayList<>());
    category2.setChildCategoryURLMap(new HashMap<>());
    category2.setDefaultParentCategory(new CategoryImpl());
    category2.setDescription("The characteristics of someone or something");
    category2.setDisplayTemplate("Display Template");
    category2.setExcludedSearchFacets(new ArrayList<>());
    category2.setExternalId("42");
    category2.setFulfillmentType(new FulfillmentType());
    category2.setId(1L);
    category2.setInventoryType(new InventoryType());
    category2.setLongDescription("Long Description");
    category2.setMetaDescription("Meta Description");
    category2.setMetaTitle("Dr");
    category2.setName("Name");
    category2.setOverrideGeneratedUrl(true);
    category2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    category2.setProductTitlePatternOverride("Dr");
    category2.setRootDisplayOrder(new BigDecimal("2.3"));
    category2.setSearchFacets(new ArrayList<>());
    category2.setTaxCode("Tax Code");
    category2.setUpSaleProducts(new ArrayList<>());
    category2.setUrl("https://example.org/example");
    category2.setUrlKey("https://example.org/example");
    category2.setCategoryMediaXref(categoryMediaXref);

    // Act
    String actualImage = seoDefaultPropertyServiceImpl.getImage(category2);

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    assertEquals("https://example.org/example", actualImage);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getImage(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getImage(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetImageWithCategory_thenThrowNumberFormatException() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    HashMap<String, CategoryMediaXref> categoryMediaXref = new HashMap<>();
    categoryMediaXref.put("primary", new CategoryMediaXrefImpl());

    CategoryImpl category = new CategoryImpl();
    category.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setCategoryAttributes(new ArrayList<>());
    category.setCategoryAttributesMap(new HashMap<>());
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
    category.setCategoryMediaXref(categoryMediaXref);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getImage(category));
    verify(baseUrlResolver).getSiteBaseUrl();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Category)} with {@code category}.
   *
   * <ul>
   *   <li>When {@link CategoryImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getImage(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getImage(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetImageWithCategory_whenCategoryImpl_thenReturnNull() {
    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl =
        new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new CategoryImpl()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)} with {@code page}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(PageDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(PageDTO)"})
  public void testGetImageWithPage() {
    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl =
        new SeoDefaultPropertyServiceImpl();

    // Act and Assert
    assertNull(seoDefaultPropertyServiceImpl.getImage(new PageDTO()));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with {@code product}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Product)"})
  public void testGetImageWithProduct() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    HashMap<String, SkuMediaXref> stringSkuMediaXrefMap = new HashMap<>();
    stringSkuMediaXrefMap.put("primary", new SkuMediaXrefImpl());

    Sku sku = mock(Sku.class);
    when(sku.getSkuMediaXref()).thenReturn(stringSkuMediaXrefMap);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getImage(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(product).getDefaultSku();
    verify(sku).getSkuMediaXref();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Product)"})
  public void testGetImageWithProduct_givenSkuImpl_thenReturnNull() {
    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl =
        new SeoDefaultPropertyServiceImpl();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(new SkuImpl());

    // Act
    String actualImage = seoDefaultPropertyServiceImpl.getImage(product);

    // Assert
    verify(product).getDefaultSku();
    assertNull(actualImage);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Then calls {@link SkuMediaXref#getMedia()}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Product)"})
  public void testGetImageWithProduct_thenCallsGetMedia() {
    // Arrange
    SeoDefaultPropertyServiceImpl seoDefaultPropertyServiceImpl =
        new SeoDefaultPropertyServiceImpl();

    SkuMediaXref skuMediaXref = mock(SkuMediaXref.class);
    when(skuMediaXref.getMedia()).thenThrow(new NumberFormatException());

    HashMap<String, SkuMediaXref> stringSkuMediaXrefMap = new HashMap<>();
    stringSkuMediaXrefMap.put("primary", skuMediaXref);

    Sku sku = mock(Sku.class);
    when(sku.getSkuMediaXref()).thenReturn(stringSkuMediaXrefMap);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getImage(product));
    verify(product).getDefaultSku();
    verify(sku).getSkuMediaXref();
    verify(skuMediaXref).getMedia();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getImage(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getImage(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getImage(Product)"})
  public void testGetImageWithProduct_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    HashMap<String, SkuMediaXref> stringSkuMediaXrefMap = new HashMap<>();
    SkuImpl sku = new SkuImpl();
    SkuMediaXrefImpl skuMediaXrefImpl = new SkuMediaXrefImpl(sku, new MediaDto(), "primary");
    stringSkuMediaXrefMap.put("primary", skuMediaXrefImpl);

    Sku sku2 = mock(Sku.class);
    when(sku2.getSkuMediaXref()).thenReturn(stringSkuMediaXrefMap);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getDefaultSku()).thenReturn(sku2);

    // Act
    String actualImage = seoDefaultPropertyServiceImpl.getImage(product);

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(product).getDefaultSku();
    verify(sku2).getSkuMediaXref();
    assertEquals("https://example.org/example", actualImage);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)} with {@code category}.
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getCanonicalUrl(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getCanonicalUrl(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCanonicalUrlWithCategory() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)} with {@code
   * category}, {@code pageNumber}.
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getCanonicalUrl(org.broadleafcommerce.core.catalog.domain.Category,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getCanonicalUrl(org.broadleafcommerce.core.catalog.domain.Category, int)"
  })
  public void testGetCanonicalUrlWithCategoryPageNumber() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl(), 10));
    verify(baseUrlResolver).getSiteBaseUrl();
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category, int)} with {@code
   * category}, {@code pageNumber}.
   *
   * <ul>
   *   <li>Then calls {@link Environment#getProperty(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getCanonicalUrl(org.broadleafcommerce.core.catalog.domain.Category,
   * int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getCanonicalUrl(org.broadleafcommerce.core.catalog.domain.Category, int)"
  })
  public void testGetCanonicalUrlWithCategoryPageNumber_thenCallsGetProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl(), 10));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Category)} with {@code category}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getCanonicalUrl(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getCanonicalUrl(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCanonicalUrlWithCategory_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new CategoryImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new ProductBundleImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    ProductBundleImpl product = new ProductBundleImpl();
    product.setCanonicalUrl("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsName() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("Name");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code
   *       seo.product.pagination.param}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsSeoProductPaginationParam() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("seo.product.pagination.param");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code //}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsSlashSlash() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("//");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is space.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsSpace() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName(" ");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is space space space.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsSpaceSpaceSpace() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("   ");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code .*?\W.*?}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsW() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName(".*?\\W.*?");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code [^\w-]+}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsW2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("[^\\w-]+");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code xx xx}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenCategoryImplNameIsXxXx() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("xx xx");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(new SkuImpl());
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then calls {@link Product#getCanonicalUrl()}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenEmptyString_thenCallsGetCanonicalUrl() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    Product product = mock(Product.class);
    when(product.getCanonicalUrl()).thenReturn("");
    when(product.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(product).getCanonicalUrl();
    verify(product).getUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is space.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenSkuImplNameIsSpace() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("seo.product.pagination.param");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setName(" ");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(defaultSku);
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Name is {@code .*?\W.*?}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_givenSkuImplNameIsW() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    CategoryImpl defaultCategory = new CategoryImpl();
    defaultCategory.setName("seo.product.pagination.param");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setName(".*?\\W.*?");

    ProductBundleImpl product = new ProductBundleImpl();
    product.setDefaultSku(defaultSku);
    product.setDefaultCategory(defaultCategory);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(product));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)} with {@code product}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then calls {@link BaseUrlResolver#getSiteBaseUrl()}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCanonicalUrl(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCanonicalUrl(Product)"})
  public void testGetCanonicalUrlWithProduct_whenProductBundleImpl_thenCallsGetSiteBaseUrl() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCanonicalUrl(new ProductBundleImpl()));
    verify(baseUrlResolver).getSiteBaseUrl();
    verify(environment, atLeast(1)).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)} with {@code
   * category}.
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getPaginationPrevUrl(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetPaginationPrevUrlWithCategory() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());

    // Act
    String actualPaginationPrevUrl =
        seoDefaultPropertyServiceImpl.getPaginationPrevUrl(new CategoryImpl());

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertNull(actualPaginationPrevUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(Category)} with {@code
   * category}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, String)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getPaginationPrevUrl(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getPaginationPrevUrl(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetPaginationPrevUrlWithCategory_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    String actualPaginationPrevUrl =
        seoDefaultPropertyServiceImpl.getPaginationPrevUrl(new CategoryImpl());

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertNull(actualPaginationPrevUrl);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPaginationNextUrl(Category)} with {@code
   * category}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getPaginationNextUrl(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SeoDefaultPropertyServiceImpl.getPaginationNextUrl(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetPaginationNextUrlWithCategory_thenThrowNumberFormatException() {
    // Arrange
    when(categoryDao.readCountAllActiveProductsByCategory(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenThrow(new NumberFormatException());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getPaginationNextUrl(new CategoryImpl()));
    verify(categoryDao)
        .readCountAllActiveProductsByCategory(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#shouldIncludeProductPagination(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeProductPagination(int)"})
  public void testShouldIncludeProductPagination_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.shouldIncludeProductPagination(10));
    verify(environment).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(int)"})
  public void testShouldIncludeCategoryPagination_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldIncludeCategoryPaginationResult =
        seoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(10);

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertTrue(actualShouldIncludeCategoryPaginationResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(int)"})
  public void testShouldIncludeCategoryPagination_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(10));
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#shouldIncludeCategoryPagination(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(int)"})
  public void testShouldIncludeCategoryPagination_whenOne_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldIncludeCategoryPaginationResult =
        seoDefaultPropertyServiceImpl.shouldIncludeCategoryPagination(1);

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertFalse(actualShouldIncludeCategoryPaginationResult);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.isValidPrevPageNumber(Integer)"})
  public void testIsValidPrevPageNumber_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new SeoDefaultPropertyServiceImpl().isValidPrevPageNumber(10));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#isValidPrevPageNumber(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SeoDefaultPropertyServiceImpl.isValidPrevPageNumber(Integer)"})
  public void testIsValidPrevPageNumber_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new SeoDefaultPropertyServiceImpl().isValidPrevPageNumber(0));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#isValidNextPageNumber(Category, Integer)} with {@code
   * category}, {@code pageNumber}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#isValidNextPageNumber(org.broadleafcommerce.core.catalog.domain.Category,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SeoDefaultPropertyServiceImpl.isValidNextPageNumber(org.broadleafcommerce.core.catalog.domain.Category, Integer)"
  })
  public void testIsValidNextPageNumberWithCategoryPageNumber_thenThrowNumberFormatException() {
    // Arrange
    when(categoryDao.readCountAllActiveProductsByCategory(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.isValidNextPageNumber(new CategoryImpl(), 10));
    verify(categoryDao)
        .readCountAllActiveProductsByCategory(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getPageCount(Category)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SeoDefaultPropertyServiceImpl#getPageCount(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer SeoDefaultPropertyServiceImpl.getPageCount(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetPageCount_thenThrowNumberFormatException() {
    // Arrange
    when(categoryDao.readCountAllActiveProductsByCategory(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getPageCount(new CategoryImpl()));
    verify(categoryDao)
        .readCountAllActiveProductsByCategory(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class));
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentProductPageNumber()"})
  public void testGetCurrentProductPageNumber() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    // Act
    Integer actualCurrentProductPageNumber =
        seoDefaultPropertyServiceImpl.getCurrentProductPageNumber();

    // Assert
    verify(environment).getProperty("seo.product.pagination.param");
    assertEquals(1, actualCurrentProductPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentProductPageNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentProductPageNumber()"})
  public void testGetCurrentProductPageNumber_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    Integer actualCurrentProductPageNumber =
        seoDefaultPropertyServiceImpl.getCurrentProductPageNumber();

    // Assert
    verify(environment).getProperty("seo.product.pagination.param");
    assertEquals(1, actualCurrentProductPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}.
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber()"})
  public void testGetCurrentCategoryPageNumber() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());

    // Act
    Integer actualCurrentCategoryPageNumber =
        seoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber();

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertEquals(1, actualCurrentCategoryPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, String)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCurrentCategoryPageNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SeoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber()"})
  public void testGetCurrentCategoryPageNumber_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    Integer actualCurrentCategoryPageNumber =
        seoDefaultPropertyServiceImpl.getCurrentCategoryPageNumber();

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertEquals(1, actualCurrentCategoryPageNumber.intValue());
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductPaginationParam()"})
  public void testGetProductPaginationParam_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    String actualProductPaginationParam = seoDefaultPropertyServiceImpl.getProductPaginationParam();

    // Assert
    verify(environment).getProperty("seo.product.pagination.param");
    assertEquals("Property", actualProductPaginationParam);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getProductPaginationParam()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getProductPaginationParam()"})
  public void testGetProductPaginationParam_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getProductPaginationParam());
    verify(environment).getProperty("seo.product.pagination.param");
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryPaginationParam()"})
  public void testGetCategoryPaginationParam_thenReturnProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("Property");

    // Act
    String actualCategoryPaginationParam =
        seoDefaultPropertyServiceImpl.getCategoryPaginationParam();

    // Assert
    verify(environment).getProperty("seo.category.pagination.param", "page");
    assertEquals("Property", actualCategoryPaginationParam);
  }

  /**
   * Test {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link SeoDefaultPropertyServiceImpl#getCategoryPaginationParam()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SeoDefaultPropertyServiceImpl.getCategoryPaginationParam()"})
  public void testGetCategoryPaginationParam_thenThrowNumberFormatException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> seoDefaultPropertyServiceImpl.getCategoryPaginationParam());
    verify(environment).getProperty("seo.category.pagination.param", "page");
  }
}
