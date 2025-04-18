/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.search.domain.CategoryExcludedSearchFacet;
import org.broadleafcommerce.core.search.domain.CategorySearchFacet;
import org.broadleafcommerce.core.search.domain.CategorySearchFacetImpl;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CategoryImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CategoryImplDiffblueTest {
  @Autowired
  private CategoryImpl categoryImpl;

  /**
   * Test {@link CategoryImpl#getName()}.
   * <p>
   * Method under test: {@link CategoryImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getName());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code :}.</li>
   *   <li>Then return {@code :}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplUrlIsColon_thenReturnColon() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setUrl(":");

    // Act and Assert
    assertEquals(":", categoryImpl2.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplUrlIsEmptyString_thenReturnEmptyString() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setUrl("");

    // Act and Assert
    assertEquals("", categoryImpl2.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code foo}.</li>
   *   <li>Then return {@code /foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplUrlIsFoo_thenReturnFoo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setUrl("foo");

    // Act and Assert
    assertEquals("/foo", categoryImpl2.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code ?}.</li>
   *   <li>Then return {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplUrlIsQuestionMark_thenReturnQuestionMark() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setUrl("?");

    // Act and Assert
    assertEquals("?", categoryImpl2.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplUrlIsSlash_thenReturnSlash() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setUrl("/");

    // Act and Assert
    assertEquals("/", categoryImpl2.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getUrl());
  }

  /**
   * Test {@link CategoryImpl#getOverrideGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getOverrideGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean CategoryImpl.getOverrideGeneratedUrl()"})
  public void testGetOverrideGeneratedUrl_givenCategoryImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).getOverrideGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getOverrideGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getOverrideGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean CategoryImpl.getOverrideGeneratedUrl()"})
  public void testGetOverrideGeneratedUrl_thenReturnTrue() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setOverrideGeneratedUrl(true);

    // Act and Assert
    assertTrue(categoryImpl2.getOverrideGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) OverrideGeneratedUrl.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setOverrideGeneratedUrl(Boolean)"})
  public void testSetOverrideGeneratedUrl_thenCategoryImplOverrideGeneratedUrl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act
    categoryImpl2.setOverrideGeneratedUrl(true);

    // Assert
    assertTrue(categoryImpl2.getOverrideGeneratedUrl());
    assertTrue(categoryImpl2.overrideGeneratedUrl);
  }

  /**
   * Test {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}.
   * <ul>
   *   <li>Then not {@link CategoryImpl} (default constructor) OverrideGeneratedUrl.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setOverrideGeneratedUrl(Boolean)"})
  public void testSetOverrideGeneratedUrl_thenNotCategoryImplOverrideGeneratedUrl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    categoryImpl2.setOverrideGeneratedUrl(null);

    // Assert
    assertFalse(categoryImpl2.getOverrideGeneratedUrl());
    assertFalse(categoryImpl2.overrideGeneratedUrl);
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsEmptyString_thenReturnEmptyString() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("");

    // Act and Assert
    assertEquals("", categoryImpl2.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code /}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsSlash_thenReturnEmptyString() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("/");

    // Act and Assert
    assertEquals("", categoryImpl2.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) UrlKey is {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplUrlKeyIsFoo_thenReturnFoo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("foo");
    categoryImpl2.setName(null);

    // Act and Assert
    assertEquals("foo", categoryImpl2.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) UrlKey is {@code null}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplUrlKeyIsNull_thenReturnFoo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setOverrideGeneratedUrl(true);
    categoryImpl2.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl2.setProductTitlePatternOverride("Dr");
    categoryImpl2.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl2.setSearchFacets(new ArrayList<>());
    categoryImpl2.setTaxCode("Tax Code");
    categoryImpl2.setUpSaleProducts(new ArrayList<>());
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey(null);
    categoryImpl2.setName("foo");

    // Act and Assert
    assertEquals("foo", categoryImpl2.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code :}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsColon_thenReturnEmptyString() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName(":");

    // Act and Assert
    assertEquals("", categoryImpl2.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsEmptyString_thenReturnEmptyString() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("");

    // Act and Assert
    assertEquals("", categoryImpl2.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsName_thenReturnName() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("Name");

    // Act and Assert
    assertEquals("name", categoryImpl2.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code ?}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsQuestionMark_thenReturnEmptyString() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("?");

    // Act and Assert
    assertEquals("", categoryImpl2.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code /}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsSlash_thenReturnEmptyString() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("/");

    // Act and Assert
    assertEquals("", categoryImpl2.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is space.</li>
   *   <li>Then return {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsSpace_thenReturnDash() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName(" ");

    // Act and Assert
    assertEquals("-", categoryImpl2.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code UU UU}.</li>
   *   <li>Then return {@code uU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsUuUu_thenReturnUUUu() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("UU UU");

    // Act and Assert
    assertEquals("uU-UU", categoryImpl2.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code .*?\W.*?}.</li>
   *   <li>Then return {@code w}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsW_thenReturnW() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName(".*?\\W.*?");

    // Act and Assert
    assertEquals("w", categoryImpl2.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", (new CategoryImpl()).getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals("https://example.org/example", categoryImpl2.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getDescription()}.
   * <p>
   * Method under test: {@link CategoryImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getDescription()"})
  public void testGetDescription() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getDescription());
  }

  /**
   * Test {@link CategoryImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Archived is {@code Y}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date CategoryImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenCategoryImplArchivedIsY_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setArchived('Y');

    // Act and Assert
    assertNull(categoryImpl2.getActiveStartDate());
  }

  /**
   * Test {@link CategoryImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date CategoryImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getActiveStartDate());
  }

  /**
   * Test {@link CategoryImpl#setActiveStartDate(Date)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) ActiveStartDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setActiveStartDate(Date)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setActiveStartDate(Date)"})
  public void testSetActiveStartDate_thenCategoryImplActiveStartDateIsNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    categoryImpl2.setActiveStartDate(null);

    // Assert
    assertNull(categoryImpl2.getActiveStartDate());
    assertNull(categoryImpl2.activeStartDate);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date CategoryImpl.getActiveEndDate()", "List CategoryImpl.getAllChildCategoryXrefs()",
      "List CategoryImpl.getAllParentCategoryXrefs()", "List CategoryImpl.getAllProductXrefs()",
      "List CategoryImpl.getCategoryAttributes()", "Map CategoryImpl.getCategoryMediaXref()",
      "List CategoryImpl.getCrossSaleProducts()", "String CategoryImpl.getDisplayTemplate()",
      "List CategoryImpl.getExcludedSearchFacets()", "String CategoryImpl.getExternalId()",
      "List CategoryImpl.getFeaturedProducts()", "Long CategoryImpl.getId()",
      "String CategoryImpl.getMetaDescription()", "String CategoryImpl.getMetaTitle()",
      "String CategoryImpl.getProductDescriptionPatternOverride()",
      "String CategoryImpl.getProductTitlePatternOverride()", "BigDecimal CategoryImpl.getRootDisplayOrder()",
      "List CategoryImpl.getSearchFacets()", "String CategoryImpl.getTaxCode()",
      "List CategoryImpl.getUpSaleProducts()", "void CategoryImpl.setCategoryAttributes(List)",
      "void CategoryImpl.setCategoryMediaXref(Map)", "void CategoryImpl.setChildCategoryIds(List)",
      "void CategoryImpl.setChildCategoryURLMap(Map)", "void CategoryImpl.setDefaultParentCategory(Category)",
      "void CategoryImpl.setDescription(String)", "void CategoryImpl.setDisplayTemplate(String)",
      "void CategoryImpl.setExcludedSearchFacets(List)", "void CategoryImpl.setExternalId(String)",
      "void CategoryImpl.setId(Long)", "void CategoryImpl.setLongDescription(String)",
      "void CategoryImpl.setMetaDescription(String)", "void CategoryImpl.setMetaTitle(String)",
      "void CategoryImpl.setName(String)", "void CategoryImpl.setProductDescriptionPatternOverride(String)",
      "void CategoryImpl.setProductTitlePatternOverride(String)", "void CategoryImpl.setRootDisplayOrder(BigDecimal)",
      "void CategoryImpl.setSearchFacets(List)", "void CategoryImpl.setTaxCode(String)",
      "void CategoryImpl.setUrl(String)", "void CategoryImpl.setUrlKey(String)"})
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
    List<CategoryExcludedSearchFacet> actualExcludedSearchFacets = categoryImpl.getExcludedSearchFacets();
    String actualExternalId = categoryImpl.getExternalId();
    List<FeaturedProduct> actualFeaturedProducts = categoryImpl.getFeaturedProducts();
    Long actualId = categoryImpl.getId();
    String actualMetaDescription = categoryImpl.getMetaDescription();
    String actualMetaTitle = categoryImpl.getMetaTitle();
    String actualProductDescriptionPatternOverride = categoryImpl.getProductDescriptionPatternOverride();
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
   * Test {@link CategoryImpl#isActive()}.
   * <p>
   * Method under test: {@link CategoryImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.isActive()"})
  public void testIsActive() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
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
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setArchived(null);

    // Act and Assert
    assertFalse(categoryImpl2.isActive());
  }

  /**
   * Test {@link CategoryImpl#isActive()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.isActive()"})
  public void testIsActive_givenCategoryImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).isActive());
  }

  /**
   * Test {@link CategoryImpl#getLongDescription()}.
   * <p>
   * Method under test: {@link CategoryImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getLongDescription()"})
  public void testGetLongDescription() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getLongDescription());
  }

  /**
   * Test {@link CategoryImpl#getDefaultParentCategory()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getDefaultParentCategory()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Category CategoryImpl.getDefaultParentCategory()"})
  public void testGetDefaultParentCategory_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getDefaultParentCategory());
  }

  /**
   * Test {@link CategoryImpl#getDefaultParentCategory()}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getDefaultParentCategory()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Category CategoryImpl.getDefaultParentCategory()"})
  public void testGetDefaultParentCategory_thenReturnCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertSame(defaultParentCategory, categoryImpl2.getDefaultParentCategory());
  }

  /**
   * Test {@link CategoryImpl#getParentCategory()}.
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategory()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Category CategoryImpl.getParentCategory()"})
  public void testGetParentCategory() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getParentCategory());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryXref()}.
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryXref()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CategoryXref CategoryImpl.getParentCategoryXref()"})
  public void testGetParentCategoryXref() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getParentCategoryXref());
  }

  /**
   * Test {@link CategoryImpl#setParentCategory(Category)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then {@link CategoryImpl} (default constructor) AllParentCategories Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setParentCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setParentCategory(Category)"})
  public void testSetParentCategory_givenCategoryImpl_thenCategoryImplAllParentCategoriesEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act
    categoryImpl2.setParentCategory(null);

    // Assert that nothing has changed
    assertTrue(categoryImpl2.getAllParentCategories().isEmpty());
    assertTrue(categoryImpl2.getAllParentCategoryXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setParentCategory(Category)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} AllParentCategories first is {@link Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setParentCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setParentCategory(Category)"})
  public void testSetParentCategory_thenCategoryImplAllParentCategoriesFirstIsCategory() {
    // Arrange
    Category category = mock(Category.class);

    // Act
    categoryImpl.setParentCategory(category);

    // Assert
    List<CategoryXref> allParentCategoryXrefs = categoryImpl.getAllParentCategoryXrefs();
    assertEquals(1, allParentCategoryXrefs.size());
    CategoryXref getResult = allParentCategoryXrefs.get(0);
    assertTrue(getResult instanceof CategoryXrefImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getDisplayOrder());
    List<Category> allParentCategories = categoryImpl.getAllParentCategories();
    assertEquals(1, allParentCategories.size());
    assertTrue(getResult.getDefaultReference());
    assertSame(categoryImpl, getResult.getSubCategory());
    assertSame(category, allParentCategories.get(0));
    assertSame(category, getResult.getCategory());
  }

  /**
   * Test {@link CategoryImpl#setParentCategory(Category)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} AllParentCategories first is {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setParentCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setParentCategory(Category)"})
  public void testSetParentCategory_thenCategoryImplAllParentCategoriesFirstIsCategoryImpl() {
    // Arrange and Act
    categoryImpl.setParentCategory(categoryImpl);

    // Assert
    List<CategoryXref> allParentCategoryXrefs = categoryImpl.getAllParentCategoryXrefs();
    assertEquals(1, allParentCategoryXrefs.size());
    CategoryXref getResult = allParentCategoryXrefs.get(0);
    assertTrue(getResult instanceof CategoryXrefImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getDisplayOrder());
    List<Category> allParentCategories = categoryImpl.getAllParentCategories();
    assertEquals(1, allParentCategories.size());
    assertTrue(getResult.getDefaultReference());
    assertSame(categoryImpl, allParentCategories.get(0));
    assertSame(categoryImpl, getResult.getCategory());
    assertSame(categoryImpl, getResult.getSubCategory());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryXrefs()}.
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryXrefs()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getChildCategoryXrefs()"})
  public void testGetChildCategoryXrefs() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getChildCategoryXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllChildCategories size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategoryXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllChildCategoryXrefs(List)"})
  public void testSetAllChildCategoryXrefs_thenCategoryImplAllChildCategoriesSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    ArrayList<CategoryXref> childCategories = new ArrayList<>();
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    childCategories.add(categoryXrefImpl);

    // Act
    categoryImpl2.setAllChildCategoryXrefs(childCategories);

    // Assert
    assertEquals(1, categoryImpl2.getAllChildCategories().size());
    List<CategoryXref> allChildCategoryXrefs = categoryImpl2.getAllChildCategoryXrefs();
    assertEquals(1, allChildCategoryXrefs.size());
    assertEquals(1, categoryImpl2.allLegacyChildCategories.size());
    assertTrue(categoryImpl2.hasAllChildCategories());
    assertSame(categoryXrefImpl, allChildCategoryXrefs.get(0));
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllChildCategories size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategoryXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllChildCategoryXrefs(List)"})
  public void testSetAllChildCategoryXrefs_thenCategoryImplAllChildCategoriesSizeIsTwo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<CategoryXref> childCategories = new ArrayList<>();
    childCategories.add(new CategoryXrefImpl());
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    childCategories.add(categoryXrefImpl);

    // Act
    categoryImpl2.setAllChildCategoryXrefs(childCategories);

    // Assert
    assertEquals(2, categoryImpl2.getAllChildCategories().size());
    List<CategoryXref> allChildCategoryXrefs = categoryImpl2.getAllChildCategoryXrefs();
    assertEquals(2, allChildCategoryXrefs.size());
    assertEquals(2, categoryImpl2.allLegacyChildCategories.size());
    assertSame(categoryXrefImpl, allChildCategoryXrefs.get(1));
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategoryXrefs(List)}.
   * <ul>
   *   <li>Then not {@link CategoryImpl} (default constructor) hasAllChildCategories.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategoryXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllChildCategoryXrefs(List)"})
  public void testSetAllChildCategoryXrefs_thenNotCategoryImplHasAllChildCategories() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act
    categoryImpl2.setAllChildCategoryXrefs(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(categoryImpl2.hasAllChildCategories());
    assertTrue(categoryImpl2.getAllChildCategories().isEmpty());
    assertTrue(categoryImpl2.getAllChildCategoryXrefs().isEmpty());
    assertTrue(categoryImpl2.allLegacyChildCategories.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getAllChildCategories()}.
   * <p>
   * Method under test: {@link CategoryImpl#getAllChildCategories()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getAllChildCategories()"})
  public void testGetAllChildCategories() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getAllChildCategories().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#hasAllChildCategories()}.
   * <p>
   * Method under test: {@link CategoryImpl#hasAllChildCategories()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.hasAllChildCategories()"})
  public void testHasAllChildCategories() {
    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).hasAllChildCategories());
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllChildCategories(List)"})
  public void testSetAllChildCategories_whenArrayList() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setAllChildCategories(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllChildCategories(List)"})
  public void testSetAllChildCategories_whenArrayListAddCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setAllChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllChildCategories(List)"})
  public void testSetAllChildCategories_whenArrayListAddCategoryImpl2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setAllChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#getChildCategories()}.
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategories()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getChildCategories()"})
  public void testGetChildCategories() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getChildCategories().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#hasChildCategories()}.
   * <p>
   * Method under test: {@link CategoryImpl#hasChildCategories()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.hasChildCategories()"})
  public void testHasChildCategories() {
    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).hasChildCategories());
  }

  /**
   * Test {@link CategoryImpl#setChildCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setChildCategories(List)"})
  public void testSetChildCategories_whenArrayList() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setChildCategories(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#setChildCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setChildCategories(List)"})
  public void testSetChildCategories_whenArrayListAddCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#setChildCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setChildCategories(List)"})
  public void testSetChildCategories_whenArrayListAddCategoryImpl2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryIds()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryIds()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getChildCategoryIds()"})
  public void testGetChildCategoryIds_thenReturnEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
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
    categoryImpl2.setChildCategoryIds(new ArrayList<>());

    // Act and Assert
    assertTrue(categoryImpl2.getChildCategoryIds().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryIds()}.
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryIds()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.createChildCategoryIds()"})
  public void testCreateChildCategoryIds() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act and Assert
    assertTrue(categoryImpl2.createChildCategoryIds().isEmpty());
    assertTrue(categoryImpl2.childCategoryIds.isEmpty());
    List<Long> expectedChildCategoryIds = categoryImpl2.childCategoryIds;
    assertSame(expectedChildCategoryIds, categoryImpl2.getChildCategoryIds());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("Cannot create childCategoryURLMap - the urlKey for a category(");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("cannot-create-childCategoryURLMap---the-urlKey-for-a-category");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) ChildCategoryURLMap is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplChildCategoryURLMapIsNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
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
    categoryImpl2.setChildCategoryURLMap(null);

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code :}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsColon_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName(":");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsEmptyString_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsName_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("Name");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code ?}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsQuestionMark_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("?");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code /}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsSlash_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("/");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is space.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsSpace_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName(" ");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code UU UU}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsUuUu_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("UU UU");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code .*?\W.*?}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName(".*?\\W.*?");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code [^\w-]+}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnNull2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("[^\\w-]+");

    // Act and Assert
    assertNull(categoryImpl2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImpl_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new CategoryImpl()).getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_thenReturnEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2.setCategoryAttributes(new ArrayList<>());
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());
    categoryImpl2.setCategoryMediaXref(new HashMap<>());
    categoryImpl2.setChildCategoryIds(new ArrayList<>());
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
    categoryImpl2.setChildCategoryURLMap(new HashMap<>());

    // Act and Assert
    assertTrue(categoryImpl2.getChildCategoryURLMap().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("Cannot create childCategoryURLMap - the urlKey for a category(");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult
        .get("/cannot-create-childCategoryURLMap---the-urlKey-for-a-category");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("cannot-create-childCategoryURLMap---the-urlKey-for-a-category");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult
        .get("/cannot-create-childCategoryURLMap---the-urlKey-for-a-category");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code :}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsColon() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName(":");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsEmptyString() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsQuestionMark() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("?");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsSlash() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("/");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code .*?\W.*?}.</li>
   *   <li>Then return {@code /w} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnWSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName(".*?\\W.*?");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/w");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code [^\w-]+}.</li>
   *   <li>Then return {@code /w-} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnWSizeIsOne2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("[^\\w-]+");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/w-");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_givenCategoryImpl_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new CategoryImpl()).createChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Then return {@code /https://example.org/example} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnHttpsExampleOrgExampleSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/https://example.org/example");
    assertEquals(1, getResult.size());
    assertEquals(1L, getResult.get(0).longValue());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Then return {@code /name} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnNameSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("Name");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/name");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Then return {@code /-} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnSlashDashSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName(" ");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/-");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Then return {@code /uU-UU} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnUUUuSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("UU UU");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl2.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/uU-UU");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
        .thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath);

    // Assert
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(false));
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category category = categoryImpl2.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath2() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> categoryImpl2.getParentCategoryHierarchy(new ArrayList<>()));
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(false));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath}, {@code firstParent}.
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl3 = new CategoryImpl();
    currentPath.add(categoryImpl3);

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals(categoryImpl2, getResult);
    assertSame(categoryImpl3, getResult);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath}, {@code firstParent}.
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals(categoryImpl2, getResult);
    assertSame(defaultParentCategory, currentPath.get(0));
    assertSame(defaultParentCategory, getResult);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath}, {@code firstParent}.
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent3() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
        .thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath, true);

    // Assert
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(true));
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category category = categoryImpl2.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath}, {@code firstParent}.
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent4() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> categoryImpl2.getParentCategoryHierarchy(new ArrayList<>(), true));
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(true));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath}, {@code firstParent}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_thenArrayListEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualParentCategoryHierarchy.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath}, {@code firstParent}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_thenReturnSizeIsTwo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());
    CategoryImpl categoryImpl3 = new CategoryImpl();
    currentPath.add(categoryImpl3);

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals(categoryImpl2, getResult);
    assertSame(categoryImpl3, getResult);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath}, {@code firstParent}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_whenFalse() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
        .thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath, false);

    // Assert
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(false));
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category category = categoryImpl2.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath}, {@code firstParent}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_whenNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath, null);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualParentCategoryHierarchy.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenArrayListEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualParentCategoryHierarchy.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first is {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenArrayListFirstIsCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    assertSame(defaultParentCategory, currentPath.get(0));
    assertSame(categoryImpl2.defaultParentCategory, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   * <ul>
   *   <li>Then first return {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenFirstReturnCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl3 = new CategoryImpl();
    currentPath.add(categoryImpl3);

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals(categoryImpl2, getResult);
    assertSame(categoryImpl3, getResult);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenReturnSizeIsTwo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());
    CategoryImpl categoryImpl3 = new CategoryImpl();
    currentPath.add(categoryImpl3);

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl2.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals(categoryImpl2, getResult);
    assertSame(categoryImpl3, getResult);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   * <p>
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl2
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    assertEquals(1, currentPath.size());
    assertEquals(1, actualBuildDefaultParentCategoryPathResult.size());
    Category category = categoryImpl2.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualBuildDefaultParentCategoryPathResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_givenCategoryImpl_thenArrayListEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl2
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualBuildDefaultParentCategoryPathResult.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first is {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenArrayListFirstIsCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl2
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertEquals(1, actualBuildDefaultParentCategoryPathResult.size());
    assertSame(defaultParentCategory, currentPath.get(0));
    assertSame(categoryImpl2.defaultParentCategory, actualBuildDefaultParentCategoryPathResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   * <ul>
   *   <li>Then first return {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenFirstReturnCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl3 = new CategoryImpl();
    currentPath.add(categoryImpl3);

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl2
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertEquals(1, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals(categoryImpl2, getResult);
    assertSame(categoryImpl3, getResult);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenReturnSizeIsTwo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());
    CategoryImpl categoryImpl3 = new CategoryImpl();
    currentPath.add(categoryImpl3);

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl2
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertEquals(2, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals(categoryImpl2, getResult);
    assertSame(categoryImpl3, getResult);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenThrowUnsupportedOperationException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> categoryImpl2.buildDefaultParentCategoryPath(new ArrayList<>()));
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllParentCategories Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategoryXrefs(List)"})
  public void testSetAllParentCategoryXrefs_thenCategoryImplAllParentCategoriesEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act
    categoryImpl2.setAllParentCategoryXrefs(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(categoryImpl2.getAllParentCategories().isEmpty());
    assertTrue(categoryImpl2.getAllParentCategoryXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllParentCategories size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategoryXrefs(List)"})
  public void testSetAllParentCategoryXrefs_thenCategoryImplAllParentCategoriesSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<CategoryXref> allParentCategories = new ArrayList<>();
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    allParentCategories.add(categoryXrefImpl);

    // Act
    categoryImpl2.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    assertEquals(1, categoryImpl2.getAllParentCategories().size());
    List<CategoryXref> allParentCategoryXrefs = categoryImpl2.getAllParentCategoryXrefs();
    assertEquals(1, allParentCategoryXrefs.size());
    assertSame(categoryXrefImpl, allParentCategoryXrefs.get(0));
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllParentCategories size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategoryXrefs(List)"})
  public void testSetAllParentCategoryXrefs_thenCategoryImplAllParentCategoriesSizeIsTwo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<CategoryXref> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryXrefImpl());
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    allParentCategories.add(categoryXrefImpl);

    // Act
    categoryImpl2.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    assertEquals(2, categoryImpl2.getAllParentCategories().size());
    List<CategoryXref> allParentCategoryXrefs = categoryImpl2.getAllParentCategoryXrefs();
    assertEquals(2, allParentCategoryXrefs.size());
    assertSame(categoryXrefImpl, allParentCategoryXrefs.get(1));
  }

  /**
   * Test {@link CategoryImpl#getAllParentCategories()}.
   * <p>
   * Method under test: {@link CategoryImpl#getAllParentCategories()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getAllParentCategories()"})
  public void testGetAllParentCategories() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getAllParentCategories().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategories(List)"})
  public void testSetAllParentCategories_whenArrayList() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setAllParentCategories(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategories(List)"})
  public void testSetAllParentCategories_whenArrayListAddCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setAllParentCategories(allParentCategories));
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategories(List)"})
  public void testSetAllParentCategories_whenArrayListAddCategoryImpl2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setAllParentCategories(allParentCategories));
  }

  /**
   * Test {@link CategoryImpl#setFeaturedProducts(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CumulativeFeaturedProducts Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setFeaturedProducts(List)"})
  public void testSetFeaturedProducts_thenCategoryImplCumulativeFeaturedProductsEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act
    categoryImpl2.setFeaturedProducts(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(categoryImpl2.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(categoryImpl2.getFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setFeaturedProducts(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) FeaturedProducts is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setFeaturedProducts(List)"})
  public void testSetFeaturedProducts_thenCategoryImplFeaturedProductsIsArrayList() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<FeaturedProduct> featuredProducts = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProducts.add(featuredProductImpl);
    featuredProducts.add(new FeaturedProductImpl());

    // Act
    categoryImpl2.setFeaturedProducts(featuredProducts);

    // Assert
    List<FeaturedProduct> cumulativeFeaturedProducts = categoryImpl2.getCumulativeFeaturedProducts();
    assertEquals(1, cumulativeFeaturedProducts.size());
    assertEquals(featuredProducts, categoryImpl2.getFeaturedProducts());
    assertSame(featuredProductImpl, cumulativeFeaturedProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#setFeaturedProducts(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) FeaturedProducts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setFeaturedProducts(List)"})
  public void testSetFeaturedProducts_thenCategoryImplFeaturedProductsSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    ArrayList<FeaturedProduct> featuredProducts = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProducts.add(featuredProductImpl);

    // Act
    categoryImpl2.setFeaturedProducts(featuredProducts);

    // Assert
    List<FeaturedProduct> cumulativeFeaturedProducts = categoryImpl2.getCumulativeFeaturedProducts();
    assertEquals(1, cumulativeFeaturedProducts.size());
    List<FeaturedProduct> featuredProducts2 = categoryImpl2.getFeaturedProducts();
    assertEquals(1, featuredProducts2.size());
    assertSame(featuredProductImpl, cumulativeFeaturedProducts.get(0));
    assertSame(featuredProductImpl, featuredProducts2.get(0));
  }

  /**
   * Test {@link CategoryImpl#setCrossSaleProducts(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CrossSaleProducts is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setCrossSaleProducts(List)"})
  public void testSetCrossSaleProducts_thenCategoryImplCrossSaleProductsIsArrayList() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<RelatedProduct> crossSaleProducts = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProducts.add(crossSaleProductImpl);
    crossSaleProducts.add(new CrossSaleProductImpl());

    // Act
    categoryImpl2.setCrossSaleProducts(crossSaleProducts);

    // Assert
    List<RelatedProduct> cumulativeCrossSaleProducts = categoryImpl2.getCumulativeCrossSaleProducts();
    assertEquals(1, cumulativeCrossSaleProducts.size());
    assertEquals(crossSaleProducts, categoryImpl2.getCrossSaleProducts());
    assertSame(crossSaleProductImpl, cumulativeCrossSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#setCrossSaleProducts(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CrossSaleProducts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setCrossSaleProducts(List)"})
  public void testSetCrossSaleProducts_thenCategoryImplCrossSaleProductsSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    ArrayList<RelatedProduct> crossSaleProducts = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProducts.add(crossSaleProductImpl);

    // Act
    categoryImpl2.setCrossSaleProducts(crossSaleProducts);

    // Assert
    List<RelatedProduct> crossSaleProducts2 = categoryImpl2.getCrossSaleProducts();
    assertEquals(1, crossSaleProducts2.size());
    List<RelatedProduct> cumulativeCrossSaleProducts = categoryImpl2.getCumulativeCrossSaleProducts();
    assertEquals(1, cumulativeCrossSaleProducts.size());
    assertSame(crossSaleProductImpl, crossSaleProducts2.get(0));
    assertSame(crossSaleProductImpl, cumulativeCrossSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#setCrossSaleProducts(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link CategoryImpl} (default constructor) CrossSaleProducts Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setCrossSaleProducts(List)"})
  public void testSetCrossSaleProducts_whenArrayList_thenCategoryImplCrossSaleProductsEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act
    categoryImpl2.setCrossSaleProducts(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(categoryImpl2.getCrossSaleProducts().isEmpty());
    assertTrue(categoryImpl2.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl2.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts2() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    relatedProductList.add(crossSaleProductImpl);
    relatedProductList.add(upSaleProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getCrossSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = categoryImpl2.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    assertEquals(2, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(1);
    assertTrue(getResult.getRelatedProduct() instanceof ProductBundleImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    assertSame(crossSaleProductImpl, actualCumulativeCrossSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenReturnEmpty() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getCrossSaleProducts()).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = categoryImpl2.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    assertTrue(actualCumulativeCrossSaleProducts.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenReturnSizeIsOne() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(upSaleProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getCrossSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = categoryImpl2.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    assertEquals(1, actualCumulativeCrossSaleProducts.size());
    assertSame(upSaleProductImpl, actualCumulativeCrossSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenReturnSizeIsThree() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));
    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(relatedProduct);
    relatedProductList.add(upSaleProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getCrossSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeCrossSaleProducts.size());
    assertSame(upSaleProductImpl, actualCumulativeCrossSaleProducts.get(2));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Then second Product return {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenSecondProductReturnProductBundleImpl() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));
    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);
    relatedProductList.add(upSaleProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getCrossSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = categoryImpl2.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(1);
    Product product = getResult.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    FieldEntity fieldEntityType = product.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    List<Sku> allSellableSkus = product.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertEquals(allSellableSkus, product.getAllSkus());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenThrowRuntimeException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new RuntimeException("foo"));

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> categoryImpl2.getCumulativeCrossSaleProducts());
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl2.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenReturnEmpty() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getUpSaleProducts()).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = categoryImpl2.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    assertTrue(actualCumulativeUpSaleProducts.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenReturnSizeIsOne() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(upSaleProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getUpSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = categoryImpl2.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    assertEquals(1, actualCumulativeUpSaleProducts.size());
    assertSame(upSaleProductImpl, actualCumulativeUpSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenReturnSizeIsThree() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));
    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(relatedProduct);
    relatedProductList.add(upSaleProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getUpSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeUpSaleProducts.size());
    assertSame(upSaleProductImpl, actualCumulativeUpSaleProducts.get(2));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then second Product return {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenSecondProductReturnProductBundleImpl() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));
    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct);
    relatedProductList.add(upSaleProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getUpSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = categoryImpl2.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(1);
    Product product = getResult.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    FieldEntity fieldEntityType = product.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    List<Sku> allSellableSkus = product.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertEquals(allSellableSkus, product.getAllSkus());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then second RelatedProduct return {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenSecondRelatedProductReturnProductBundleImpl() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    relatedProductList.add(crossSaleProductImpl);
    relatedProductList.add(upSaleProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getUpSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = categoryImpl2.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    assertEquals(2, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(1);
    assertTrue(getResult.getRelatedProduct() instanceof ProductBundleImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    assertSame(crossSaleProductImpl, actualCumulativeUpSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenThrowRuntimeException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new RuntimeException("foo"));

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> categoryImpl2.getCumulativeUpSaleProducts());
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl2.getCumulativeFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_givenArrayListAddNull_thenReturnArrayList() {
    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(mock(FeaturedProductImpl.class));
    featuredProductList.add(null);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl2.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    assertEquals(featuredProductList, actualCumulativeFeaturedProducts);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_givenArrayListAddNull_thenReturnFirstIsNull() {
    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(null);
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl2.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    assertEquals(2, actualCumulativeFeaturedProducts.size());
    assertNull(actualCumulativeFeaturedProducts.get(0));
    assertSame(featuredProductImpl, actualCumulativeFeaturedProducts.get(1));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_thenReturnArrayList() {
    // Arrange
    FeaturedProduct featuredProduct = mock(FeaturedProduct.class);
    when(featuredProduct.getSequence()).thenReturn(new BigDecimal("2.3"));
    FeaturedProductImpl featuredProductImpl = mock(FeaturedProductImpl.class);
    when(featuredProductImpl.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(featuredProductImpl);
    featuredProductList.add(featuredProduct);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl2.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    verify(featuredProduct).getSequence();
    verify(featuredProductImpl).getSequence();
    assertEquals(featuredProductList, actualCumulativeFeaturedProducts);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_thenReturnEmpty() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl2.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    assertTrue(actualCumulativeFeaturedProducts.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl2.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    assertEquals(1, actualCumulativeFeaturedProducts.size());
    assertSame(featuredProductImpl, actualCumulativeFeaturedProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl);
    featuredProductList.add(new FeaturedProductImpl());
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl2.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    assertEquals(1, actualCumulativeFeaturedProducts.size());
    assertSame(featuredProductImpl, actualCumulativeFeaturedProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_thenReturnSizeIsThree() {
    // Arrange
    FeaturedProduct featuredProduct = mock(FeaturedProduct.class);
    when(featuredProduct.getSequence()).thenReturn(new BigDecimal("2.3"));
    FeaturedProductImpl featuredProductImpl = mock(FeaturedProductImpl.class);
    when(featuredProductImpl.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl2);
    featuredProductList.add(featuredProductImpl);
    featuredProductList.add(featuredProduct);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl2.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    verify(featuredProduct).getSequence();
    verify(featuredProductImpl, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeFeaturedProducts.size());
    assertSame(featuredProductImpl2, actualCumulativeFeaturedProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_thenReturnSizeIsTwo() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = mock(FeaturedProductImpl.class);
    when(featuredProductImpl.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(featuredProductImpl);
    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl2);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl2.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    verify(featuredProductImpl).getSequence();
    assertEquals(2, actualCumulativeFeaturedProducts.size());
    assertSame(featuredProductImpl2, actualCumulativeFeaturedProducts.get(1));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_thenThrowRuntimeException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new RuntimeException("foo"));

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> categoryImpl2.getCumulativeFeaturedProducts());
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#setUpSaleProducts(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setUpSaleProducts(List)"})
  public void testSetUpSaleProducts_givenCategoryImpl_thenArrayListSizeIsTwo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    upSaleProducts.add(crossSaleProductImpl);
    upSaleProducts.add(new CrossSaleProductImpl());

    // Act
    categoryImpl2.setUpSaleProducts(upSaleProducts);

    // Assert
    List<RelatedProduct> cumulativeUpSaleProducts = categoryImpl2.getCumulativeUpSaleProducts();
    assertEquals(1, cumulativeUpSaleProducts.size());
    assertEquals(2, upSaleProducts.size());
    assertSame(upSaleProducts, categoryImpl2.getUpSaleProducts());
    assertSame(crossSaleProductImpl, cumulativeUpSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#setUpSaleProducts(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setUpSaleProducts(List)"})
  public void testSetUpSaleProducts_givenCategoryImpl_whenArrayList_thenArrayListEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();

    // Act
    categoryImpl2.setUpSaleProducts(upSaleProducts);

    // Assert
    assertTrue(upSaleProducts.isEmpty());
    assertTrue(categoryImpl2.getCumulativeUpSaleProducts().isEmpty());
    assertSame(upSaleProducts, categoryImpl2.getUpSaleProducts());
  }

  /**
   * Test {@link CategoryImpl#setUpSaleProducts(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setUpSaleProducts(List)"})
  public void testSetUpSaleProducts_thenArrayList() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    categoryImpl2.setUpSaleProducts(upSaleProducts);
    categoryImpl2.setUrl("https://example.org/example");
    categoryImpl2.setUrlKey("https://example.org/example");

    ArrayList<RelatedProduct> upSaleProducts2 = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    upSaleProducts2.add(crossSaleProductImpl);

    // Act
    categoryImpl2.setUpSaleProducts(upSaleProducts2);

    // Assert
    List<RelatedProduct> cumulativeUpSaleProducts = categoryImpl2.getCumulativeUpSaleProducts();
    assertEquals(1, cumulativeUpSaleProducts.size());
    assertEquals(upSaleProducts, upSaleProducts2);
    assertSame(upSaleProducts2, categoryImpl2.getUpSaleProducts());
    assertSame(crossSaleProductImpl, cumulativeUpSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getActiveProductXrefs()}.
   * <p>
   * Method under test: {@link CategoryImpl#getActiveProductXrefs()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getActiveProductXrefs()"})
  public void testGetActiveProductXrefs() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getActiveProductXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllProductXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllProductXrefs size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllProductXrefs(List)"})
  public void testSetAllProductXrefs_thenCategoryImplAllProductXrefsSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<CategoryProductXref> allProducts = new ArrayList<>();
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    allProducts.add(categoryProductXrefImpl);

    // Act
    categoryImpl2.setAllProductXrefs(allProducts);

    // Assert
    List<CategoryProductXref> allProductXrefs = categoryImpl2.getAllProductXrefs();
    assertEquals(1, allProductXrefs.size());
    assertEquals(1, categoryImpl2.getAllProducts().size());
    assertSame(categoryProductXrefImpl, allProductXrefs.get(0));
  }

  /**
   * Test {@link CategoryImpl#setAllProductXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllProductXrefs size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllProductXrefs(List)"})
  public void testSetAllProductXrefs_thenCategoryImplAllProductXrefsSizeIsTwo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<CategoryProductXref> allProducts = new ArrayList<>();
    allProducts.add(new CategoryProductXrefImpl());
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    allProducts.add(categoryProductXrefImpl);

    // Act
    categoryImpl2.setAllProductXrefs(allProducts);

    // Assert
    List<CategoryProductXref> allProductXrefs = categoryImpl2.getAllProductXrefs();
    assertEquals(2, allProductXrefs.size());
    assertEquals(2, categoryImpl2.getAllProducts().size());
    assertSame(categoryProductXrefImpl, allProductXrefs.get(1));
  }

  /**
   * Test {@link CategoryImpl#setAllProductXrefs(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link CategoryImpl} (default constructor) AllProductXrefs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllProductXrefs(List)"})
  public void testSetAllProductXrefs_whenArrayList_thenCategoryImplAllProductXrefsEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act
    categoryImpl2.setAllProductXrefs(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(categoryImpl2.getAllProductXrefs().isEmpty());
    assertTrue(categoryImpl2.getAllProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getActiveProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getActiveProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getActiveProducts()"})
  public void testGetActiveProducts() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getActiveProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getAllProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getAllProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getAllProducts()"})
  public void testGetAllProducts() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getAllProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllProducts(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllProducts(List)"})
  public void testSetAllProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Product> allProducts = new ArrayList<>();
    allProducts.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setAllProducts(allProducts));
  }

  /**
   * Test {@link CategoryImpl#setAllProducts(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllProducts(List)"})
  public void testSetAllProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<Product> allProducts = new ArrayList<>();
    allProducts.add(new ProductBundleImpl());
    allProducts.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setAllProducts(allProducts));
  }

  /**
   * Test {@link CategoryImpl#setAllProducts(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setAllProducts(List)"})
  public void testSetAllProducts_whenArrayList() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.setAllProducts(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#getInventoryType()}.
   * <p>
   * Method under test: {@link CategoryImpl#getInventoryType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InventoryType CategoryImpl.getInventoryType()"})
  public void testGetInventoryType() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getInventoryType());
  }

  /**
   * Test {@link CategoryImpl#setInventoryType(InventoryType)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) {@link CategoryImpl#inventoryType} is {@code ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setInventoryType(InventoryType)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setInventoryType(InventoryType)"})
  public void testSetInventoryType_thenCategoryImplInventoryTypeIsAlwaysAvailable() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    InventoryType inventoryType = InventoryType.ALWAYS_AVAILABLE;

    // Act
    categoryImpl2.setInventoryType(inventoryType);

    // Assert
    assertEquals("ALWAYS_AVAILABLE", categoryImpl2.inventoryType);
    InventoryType expectedInventoryType = inventoryType.ALWAYS_AVAILABLE;
    assertSame(expectedInventoryType, categoryImpl2.getInventoryType());
  }

  /**
   * Test {@link CategoryImpl#setInventoryType(InventoryType)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) {@link CategoryImpl#inventoryType} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setInventoryType(InventoryType)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setInventoryType(InventoryType)"})
  public void testSetInventoryType_thenCategoryImplInventoryTypeIsNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    categoryImpl2.setInventoryType(null);

    // Assert
    assertNull(categoryImpl2.inventoryType);
    assertNull(categoryImpl2.getInventoryType());
  }

  /**
   * Test {@link CategoryImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getFulfillmentType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType CategoryImpl.getFulfillmentType()"})
  public void testGetFulfillmentType_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getFulfillmentType());
  }

  /**
   * Test {@link CategoryImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Then return {@link FulfillmentType#DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getFulfillmentType()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType CategoryImpl.getFulfillmentType()"})
  public void testGetFulfillmentType_thenReturnDigital() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setFulfillmentType(FulfillmentType.DIGITAL);

    // Act
    FulfillmentType actualFulfillmentType = categoryImpl2.getFulfillmentType();

    // Assert
    assertSame(actualFulfillmentType.DIGITAL, actualFulfillmentType);
  }

  /**
   * Test {@link CategoryImpl#setFulfillmentType(FulfillmentType)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) {@link CategoryImpl#fulfillmentType} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setFulfillmentType(FulfillmentType)"})
  public void testSetFulfillmentType_thenCategoryImplFulfillmentTypeIsNull() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    categoryImpl2.setFulfillmentType(null);

    // Assert
    assertNull(categoryImpl2.fulfillmentType);
    assertNull(categoryImpl2.getFulfillmentType());
  }

  /**
   * Test {@link CategoryImpl#setFulfillmentType(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#DIGITAL}.</li>
   *   <li>Then {@link CategoryImpl} (default constructor) {@link CategoryImpl#fulfillmentType} is {@code DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setFulfillmentType(FulfillmentType)"})
  public void testSetFulfillmentType_whenDigital_thenCategoryImplFulfillmentTypeIsDigital() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    FulfillmentType fulfillmentType = FulfillmentType.DIGITAL;

    // Act
    categoryImpl2.setFulfillmentType(fulfillmentType);

    // Assert
    assertEquals("DIGITAL", categoryImpl2.fulfillmentType);
    FulfillmentType expectedFulfillmentType = fulfillmentType.DIGITAL;
    assertSame(expectedFulfillmentType, categoryImpl2.getFulfillmentType());
  }

  /**
   * Test {@link CategoryImpl#getParentFacets(Collection)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentFacets(Collection)"})
  public void testGetParentFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<SearchFacet> facets = new ArrayList<>();
    facets.add(new SearchFacetImpl());

    // Act and Assert
    assertNull(categoryImpl2.getParentFacets(facets));
  }

  /**
   * Test {@link CategoryImpl#getParentFacets(Collection)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentFacets(Collection)"})
  public void testGetParentFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    ArrayList<SearchFacet> facets = new ArrayList<>();
    facets.add(new SearchFacetImpl());
    facets.add(new SearchFacetImpl());

    // Act and Assert
    assertNull(categoryImpl2.getParentFacets(facets));
  }

  /**
   * Test {@link CategoryImpl#getParentFacets(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getParentFacets(Collection)"})
  public void testGetParentFacets_whenArrayList() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act and Assert
    assertNull(categoryImpl2.getParentFacets(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl2.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setUrl("https://example.org/example");
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl2.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet2() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(new CategoryImpl());
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl2.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_givenCategoryImplNameIsName() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("Name");
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl2.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then {@link HashSet#HashSet()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_givenCategoryImpl_thenHashSetSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl2.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>Then calls {@link Category#getCumulativeSearchFacets(Set)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_thenCallsGetCumulativeSearchFacets() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any())).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl2.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_thenReturnArrayList() {
    // Arrange
    ArrayList<CategorySearchFacet> categorySearchFacetList = new ArrayList<>();
    categorySearchFacetList.add(new CategorySearchFacetImpl());
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(categorySearchFacetList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl2.getCumulativeSearchFacets(new HashSet<>());

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(categorySearchFacetList, actualCumulativeSearchFacets);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_thenThrowUnsupportedOperationException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.getCumulativeSearchFacets(new HashSet<>()));
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_whenHashSetAddCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    HashSet<Category> categoryHierarchy = new HashSet<>();
    categoryHierarchy.add(new CategoryImpl());

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl2.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add {@code null}.</li>
   *   <li>Then {@link HashSet#HashSet()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_whenHashSetAddNull_thenHashSetSizeIsTwo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    HashSet<Category> categoryHierarchy = new HashSet<>();
    categoryHierarchy.add(null);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl2.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(2, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_givenCategoryImplNameIsName_thenReturnEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setName("Name");

    // Act and Assert
    assertTrue(categoryImpl2.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_givenCategoryImplUrlIsHttpsExampleOrgExample() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setUrl("https://example.org/example");

    // Act and Assert
    assertTrue(categoryImpl2.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <ul>
   *   <li>Then calls {@link Category#getCumulativeSearchFacets(Set)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_thenCallsGetCumulativeSearchFacets() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any())).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl2.getCumulativeSearchFacets();

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_thenReturnArrayList() {
    // Arrange
    ArrayList<CategorySearchFacet> categorySearchFacetList = new ArrayList<>();
    categorySearchFacetList.add(new CategorySearchFacetImpl());
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(categorySearchFacetList);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl2.getCumulativeSearchFacets();

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(categorySearchFacetList, actualCumulativeSearchFacets);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_thenThrowUnsupportedOperationException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl2.getCumulativeSearchFacets());
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
  }

  /**
   * Test {@link CategoryImpl#getCategoryMedia()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getCategoryMedia()"})
  public void testGetCategoryMedia_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCategoryMedia().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryMedia()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   *   <li>Then return {@code foo} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getCategoryMedia()"})
  public void testGetCategoryMedia_givenHashMapFooIsCategoryMediaXrefImpl_thenReturnFooIsNull() {
    // Arrange
    HashMap<String, CategoryMediaXref> categoryMediaXref = new HashMap<>();
    categoryMediaXref.put("foo", new CategoryMediaXrefImpl());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setCategoryMediaXref(categoryMediaXref);

    // Act
    Map<String, Media> actualCategoryMedia = categoryImpl2.getCategoryMedia();

    // Assert
    assertEquals(1, actualCategoryMedia.size());
    assertNull(actualCategoryMedia.get("foo"));
  }

  /**
   * Test {@link CategoryImpl#getCategoryMedia()}.
   * <ul>
   *   <li>Then return {@code foo} is {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getCategoryMedia()"})
  public void testGetCategoryMedia_thenReturnFooIsCategoryMediaXrefImpl() {
    // Arrange
    CategoryMediaXrefImpl categoryMediaXrefImpl = mock(CategoryMediaXrefImpl.class);
    CategoryMediaXrefImpl categoryMediaXrefImpl2 = new CategoryMediaXrefImpl();
    when(categoryMediaXrefImpl.getMedia()).thenReturn(categoryMediaXrefImpl2);

    HashMap<String, CategoryMediaXref> categoryMediaXref = new HashMap<>();
    categoryMediaXref.put("foo", categoryMediaXrefImpl);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setCategoryMediaXref(categoryMediaXref);

    // Act
    Map<String, Media> actualCategoryMedia = categoryImpl2.getCategoryMedia();

    // Assert
    verify(categoryMediaXrefImpl).getMedia();
    assertEquals(1, actualCategoryMedia.size());
    assertSame(categoryMediaXrefImpl2, actualCategoryMedia.get("foo"));
  }

  /**
   * Test {@link CategoryImpl#setCategoryMedia(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCategoryMedia(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setCategoryMedia(Map)"})
  public void testSetCategoryMedia_whenHashMap_thenHashMapEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    HashMap<String, Media> categoryMedia = new HashMap<>();

    // Act
    categoryImpl2.setCategoryMedia(categoryMedia);

    // Assert that nothing has changed
    assertTrue(categoryMedia.isEmpty());
    assertTrue(categoryImpl2.getCategoryMedia().isEmpty());
    assertTrue(categoryImpl2.getCategoryMediaXref().isEmpty());
    assertTrue(categoryImpl2.legacyCategoryMedia.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributesMap()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getCategoryAttributesMap()"})
  public void testGetCategoryAttributesMap() {
    // Arrange
    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributes.put("ThreadLocalManager.notify.orphans", categoryAttributeImpl);
    categoryAttributes.put("foo", new CategoryAttributeImpl());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, CategoryAttribute> actualCategoryAttributesMap = categoryImpl2.getCategoryAttributesMap();

    // Assert
    assertEquals(1, actualCategoryAttributesMap.size());
    assertSame(categoryAttributeImpl, actualCategoryAttributesMap.get(null));
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributesMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getCategoryAttributesMap()"})
  public void testGetCategoryAttributesMap_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCategoryAttributesMap().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributesMap()}.
   * <ul>
   *   <li>Then return containsKey {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getCategoryAttributesMap()"})
  public void testGetCategoryAttributesMap_thenReturnContainsKeyName() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = mock(CategoryAttributeImpl.class);
    when(categoryAttributeImpl.getName()).thenReturn("Name");

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    categoryAttributes.put("foo", categoryAttributeImpl);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, CategoryAttribute> actualCategoryAttributesMap = categoryImpl2.getCategoryAttributesMap();

    // Assert
    verify(categoryAttributeImpl).getName();
    assertEquals(1, actualCategoryAttributesMap.size());
    assertTrue(actualCategoryAttributesMap.containsKey("Name"));
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributesMap()}.
   * <ul>
   *   <li>Then return {@code null} is {@link CategoryAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getCategoryAttributesMap()"})
  public void testGetCategoryAttributesMap_thenReturnNullIsCategoryAttributeImpl() {
    // Arrange
    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributes.put("foo", categoryAttributeImpl);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, CategoryAttribute> actualCategoryAttributesMap = categoryImpl2.getCategoryAttributesMap();

    // Assert
    assertEquals(1, actualCategoryAttributesMap.size());
    assertSame(categoryAttributeImpl, actualCategoryAttributesMap.get(null));
  }

  /**
   * Test {@link CategoryImpl#setCategoryAttributesMap(Map)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CategoryAttributes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCategoryAttributesMap(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setCategoryAttributesMap(Map)"})
  public void testSetCategoryAttributesMap_thenCategoryImplCategoryAttributesSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributes.put("foo", categoryAttributeImpl);

    // Act
    categoryImpl2.setCategoryAttributesMap(categoryAttributes);

    // Assert
    List<CategoryAttribute> categoryAttributes2 = categoryImpl2.getCategoryAttributes();
    assertEquals(1, categoryAttributes2.size());
    Map<String, CategoryAttribute> categoryAttributesMap = categoryImpl2.getCategoryAttributesMap();
    assertEquals(1, categoryAttributesMap.size());
    Map<String, CategoryAttribute> multiValueCategoryAttributes = categoryImpl2.getMultiValueCategoryAttributes();
    assertEquals(1, multiValueCategoryAttributes.size());
    assertEquals(categoryAttributes2, multiValueCategoryAttributes.get(null));
    assertEquals(categoryAttributesMap, categoryImpl2.getMappedCategoryAttributes());
    assertSame(categoryAttributeImpl, categoryAttributes2.get(0));
    assertSame(categoryAttributeImpl, categoryAttributesMap.get(null));
  }

  /**
   * Test {@link CategoryImpl#setCategoryAttributesMap(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link CategoryImpl} (default constructor) CategoryAttributes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCategoryAttributesMap(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setCategoryAttributesMap(Map)"})
  public void testSetCategoryAttributesMap_whenHashMap_thenCategoryImplCategoryAttributesEmpty() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act
    categoryImpl2.setCategoryAttributesMap(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(categoryImpl2.getCategoryAttributes().isEmpty());
    assertTrue(categoryImpl2.getCategoryAttributesMap().isEmpty());
    assertTrue(categoryImpl2.getMappedCategoryAttributes().isEmpty());
    assertTrue(categoryImpl2.getMultiValueCategoryAttributes().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributeByName(String)}.
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryAttributeByName(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CategoryAttribute CategoryImpl.getCategoryAttributeByName(String)"})
  public void testGetCategoryAttributeByName() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getCategoryAttributeByName("Name"));
  }

  /**
   * Test {@link CategoryImpl#getMappedCategoryAttributes()}.
   * <p>
   * Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getMappedCategoryAttributes()"})
  public void testGetMappedCategoryAttributes() {
    // Arrange
    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributes.put("ThreadLocalManager.notify.orphans", categoryAttributeImpl);
    categoryAttributes.put("foo", new CategoryAttributeImpl());

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, CategoryAttribute> actualMappedCategoryAttributes = categoryImpl2.getMappedCategoryAttributes();

    // Assert
    assertEquals(1, actualMappedCategoryAttributes.size());
    assertSame(categoryAttributeImpl, actualMappedCategoryAttributes.get(null));
  }

  /**
   * Test {@link CategoryImpl#getMappedCategoryAttributes()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getMappedCategoryAttributes()"})
  public void testGetMappedCategoryAttributes_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getMappedCategoryAttributes().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getMappedCategoryAttributes()}.
   * <ul>
   *   <li>Then return containsKey {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getMappedCategoryAttributes()"})
  public void testGetMappedCategoryAttributes_thenReturnContainsKeyName() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = mock(CategoryAttributeImpl.class);
    when(categoryAttributeImpl.getName()).thenReturn("Name");

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    categoryAttributes.put("foo", categoryAttributeImpl);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, CategoryAttribute> actualMappedCategoryAttributes = categoryImpl2.getMappedCategoryAttributes();

    // Assert
    verify(categoryAttributeImpl).getName();
    assertEquals(1, actualMappedCategoryAttributes.size());
    assertTrue(actualMappedCategoryAttributes.containsKey("Name"));
  }

  /**
   * Test {@link CategoryImpl#getMappedCategoryAttributes()}.
   * <ul>
   *   <li>Then return {@code null} is {@link CategoryAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getMappedCategoryAttributes()"})
  public void testGetMappedCategoryAttributes_thenReturnNullIsCategoryAttributeImpl() {
    // Arrange
    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributes.put("foo", categoryAttributeImpl);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, CategoryAttribute> actualMappedCategoryAttributes = categoryImpl2.getMappedCategoryAttributes();

    // Assert
    assertEquals(1, actualMappedCategoryAttributes.size());
    assertSame(categoryAttributeImpl, actualMappedCategoryAttributes.get(null));
  }

  /**
   * Test {@link CategoryImpl#getMultiValueCategoryAttributes()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getMultiValueCategoryAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CategoryImpl.getMultiValueCategoryAttributes()"})
  public void testGetMultiValueCategoryAttributes_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getMultiValueCategoryAttributes().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getArchived()}.
   * <p>
   * Method under test: {@link CategoryImpl#getArchived()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Character CategoryImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', (new CategoryImpl()).getArchived().charValue());
  }

  /**
   * Test {@link CategoryImpl#setArchived(Character)}.
   * <p>
   * Method under test: {@link CategoryImpl#setArchived(Character)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CategoryImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();

    // Act
    categoryImpl2.setArchived('A');

    // Assert
    assertEquals('A', categoryImpl2.archiveStatus.getArchived().charValue());
    assertEquals('A', categoryImpl2.getArchived().charValue());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and {@link CategoryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryImpl#equals(Object)}
   *   <li>{@link CategoryImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    int expectedHashCodeResult = categoryImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryImpl2.hashCode());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and {@link CategoryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryImpl#equals(Object)}
   *   <li>{@link CategoryImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    int expectedHashCodeResult = categoryImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryImpl2.hashCode());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and {@link CategoryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryImpl#equals(Object)}
   *   <li>{@link CategoryImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    int expectedHashCodeResult = categoryImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryImpl2.hashCode());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and {@link CategoryImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryImpl#equals(Object)}
   *   <li>{@link CategoryImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CategoryImpl.equals(Object)", "int CategoryImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * Test {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse CategoryImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Category> actualCreateOrRetrieveCopyInstanceResult = categoryImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then Clone return {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse CategoryImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_givenJavaLangObject_thenCloneReturnCategoryImpl()
      throws CloneNotSupportedException {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<Category> actualCreateOrRetrieveCopyInstanceResult = categoryImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.CategoryImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    Category clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CategoryImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(categoryImpl2, clone);
  }

  /**
   * Test {@link CategoryImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link CategoryImpl#getMainEntityName()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getMainEntityName());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code :}.</li>
   *   <li>Then return {@code :}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplUrlIsColon_thenReturnColon() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setUrl(":");

    // Act and Assert
    assertEquals(":", categoryImpl2.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplUrlIsEmptyString_thenReturnEmptyString() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setUrl("");

    // Act and Assert
    assertEquals("", categoryImpl2.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code foo}.</li>
   *   <li>Then return {@code /foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplUrlIsFoo_thenReturnFoo() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setUrl("foo");

    // Act and Assert
    assertEquals("/foo", categoryImpl2.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code ?}.</li>
   *   <li>Then return {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplUrlIsQuestionMark_thenReturnQuestionMark() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setUrl("?");

    // Act and Assert
    assertEquals("?", categoryImpl2.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplUrlIsSlash_thenReturnSlash() {
    // Arrange
    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl2.setUrlKey("https://example.org/example");
    categoryImpl2.setUrl("/");

    // Act and Assert
    assertEquals("/", categoryImpl2.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getLocation());
  }

  /**
   * Test new {@link CategoryImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CategoryImpl}
   */
  @Test
  @org.junit.experimental.categories.Category(MaintainedByDiffblue.class)
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
