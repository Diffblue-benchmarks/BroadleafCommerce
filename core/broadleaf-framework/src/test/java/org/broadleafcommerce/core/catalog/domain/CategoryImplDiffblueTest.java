/*-
 * #%L
 * BroadleafCommerce Framework
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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import java.util.function.BiFunction;
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
import org.mockito.Mockito;

public class CategoryImplDiffblueTest {
  /**
   * Test {@link CategoryImpl#getName()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getName()}
   */
  @Test
  public void testGetName_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getName());
  }

  /**
   * Test {@link CategoryImpl#getName()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getName()}
   */
  @Test
  public void testGetName_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    String actualName = categoryImpl.getName();

    // Assert
    verify(activeStartDate).getTime();
    assertNull(actualName);
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
  public void testGetUrl_givenCategoryImplUrlIsColon_thenReturnColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl(":");

    // Act and Assert
    assertEquals(":", categoryImpl.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is empty
   * string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenCategoryImplUrlIsEmptyString_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl("");

    // Act and Assert
    assertEquals("", categoryImpl.getUrl());
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
  public void testGetUrl_givenCategoryImplUrlIsFoo_thenReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl("foo");

    // Act and Assert
    assertEquals("/foo", categoryImpl.getUrl());
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
  public void testGetUrl_givenCategoryImplUrlIsQuestionMark_thenReturnQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl("?");

    // Act and Assert
    assertEquals("?", categoryImpl.getUrl());
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
  public void testGetUrl_givenCategoryImplUrlIsSlash_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl("/");

    // Act and Assert
    assertEquals("/", categoryImpl.getUrl());
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
  public void testGetUrl_givenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   * <ul>
   *   <li>Given {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  public void testGetUrl_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl("");

    // Act
    String actualUrl = categoryImpl.getUrl();

    // Assert
    verify(activeEndDate).getTime();
    assertEquals("", actualUrl);
  }

  /**
   * Test {@link CategoryImpl#getOverrideGeneratedUrl()}.
   * <p>
   * Method under test: {@link CategoryImpl#getOverrideGeneratedUrl()}
   */
  @Test
  public void testGetOverrideGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setOverrideGeneratedUrl(true);

    // Act and Assert
    assertTrue(categoryImpl.getOverrideGeneratedUrl());
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
  public void testGetOverrideGeneratedUrl_givenCategoryImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).getOverrideGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getOverrideGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getOverrideGeneratedUrl()}
   */
  @Test
  public void testGetOverrideGeneratedUrl_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setOverrideGeneratedUrl(true);

    // Act
    Boolean actualOverrideGeneratedUrl = categoryImpl.getOverrideGeneratedUrl();

    // Assert
    verify(activeEndDate).getTime();
    assertTrue(actualOverrideGeneratedUrl);
  }

  /**
   * Test {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}.
   * <p>
   * Method under test: {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    // Act
    categoryImpl.setOverrideGeneratedUrl(null);

    // Assert
    assertFalse(categoryImpl.getOverrideGeneratedUrl());
    assertFalse(categoryImpl.overrideGeneratedUrl);
  }

  /**
   * Test {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}.
   * <ul>
   *   <li>Given {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedUrl_givenDateGetTimeReturnTen_whenNull_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl.setOverrideGeneratedUrl(null);

    // Assert
    verify(activeEndDate).getTime();
    assertFalse(categoryImpl.getOverrideGeneratedUrl());
    assertFalse(categoryImpl.overrideGeneratedUrl);
  }

  /**
   * Test {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor)
   * OverrideGeneratedUrl.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedUrl_thenCategoryImplOverrideGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    categoryImpl.setOverrideGeneratedUrl(true);

    // Assert
    assertTrue(categoryImpl.getOverrideGeneratedUrl());
    assertTrue(categoryImpl.overrideGeneratedUrl);
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   * <p>
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("foo");

    // Act and Assert
    assertEquals("foo", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) UrlKey is
   * {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey_givenCategoryImplUrlKeyIsFoo_thenReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("foo");
    categoryImpl.setName(null);

    // Act and Assert
    assertEquals("foo", categoryImpl.getUrlKey());
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
  public void testGetUrlKey_givenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   * <ul>
   *   <li>Given {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("foo");

    // Act
    String actualUrlKey = categoryImpl.getUrlKey();

    // Assert
    verify(activeEndDate).getTime();
    assertEquals("foo", actualUrlKey);
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertEquals("https://example.org/example", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("org.broadleafcommerce.core.catalog.domain.CategoryAttribute");

    // Act and Assert
    assertEquals("orgbroadleafcommercecorecatalogdomainCategoryAttribute", categoryImpl.getGeneratedUrl());
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
  public void testGetGeneratedUrl_givenCategoryImplNameIsColon_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(":");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is empty
   * string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenCategoryImplNameIsEmptyString_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code java.util.List}.</li>
   *   <li>Then return {@code javautilList}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenCategoryImplNameIsJavaUtilList_thenReturnJavautilList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.util.List");

    // Act and Assert
    assertEquals("javautilList", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code Name}.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenCategoryImplNameIsName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Name");

    // Act and Assert
    assertEquals("name", categoryImpl.getGeneratedUrl());
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
  public void testGetGeneratedUrl_givenCategoryImplNameIsQuestionMark_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("?");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
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
  public void testGetGeneratedUrl_givenCategoryImplNameIsSlash_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("/");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is space
   * space.</li>
   *   <li>Then return {@code --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenCategoryImplNameIsSpaceSpace_thenReturnDashDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("  ");

    // Act and Assert
    assertEquals("--", categoryImpl.getGeneratedUrl());
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
  public void testGetGeneratedUrl_givenCategoryImplNameIsSpace_thenReturnDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" ");

    // Act and Assert
    assertEquals("-", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code UU UU}.</li>
   *   <li>Then return {@code uU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenCategoryImplNameIsUuUu_thenReturnUUUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("UU UU");

    // Act and Assert
    assertEquals("uU-UU", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code UU UU}.</li>
   *   <li>Then return {@code -UU-UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenCategoryImplNameIsUuUu_thenReturnUuUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" UU UU");

    // Act and Assert
    assertEquals("-UU-UU", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code .*?\W.*?}.</li>
   *   <li>Then return {@code w}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenCategoryImplNameIsW_thenReturnW() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(".*?\\W.*?");

    // Act and Assert
    assertEquals("w", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) UrlKey is empty
   * string.</li>
   *   <li>Then return {@code name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenCategoryImplUrlKeyIsEmptyString_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    String actualGeneratedUrl = categoryImpl.getGeneratedUrl();

    // Assert
    verify(activeEndDate).getTime();
    assertEquals("name", actualGeneratedUrl);
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
  public void testGetGeneratedUrl_givenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("null", (new CategoryImpl()).getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Given {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_givenDateGetTimeReturnTen_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    String actualGeneratedUrl = categoryImpl.getGeneratedUrl();

    // Assert
    verify(activeEndDate).getTime();
    assertEquals("https://example.org/example", actualGeneratedUrl);
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code javalangString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_thenReturnJavalangString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.lang.String");

    // Act and Assert
    assertEquals("javalangString", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code javautilMapEntry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_thenReturnJavautilMapEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.util.Map$Entry");

    // Act and Assert
    assertEquals("javautilMapEntry", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code orgbroadleafcommercecommonmediadomainMedia}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_thenReturnOrgbroadleafcommercecommonmediadomainMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("org.broadleafcommerce.common.media.domain.Media");

    // Act and Assert
    assertEquals("orgbroadleafcommercecommonmediadomainMedia", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   * <ul>
   *   <li>Then return {@code orgbroadleafcommercecorecatalogdomainCategory}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl_thenReturnOrgbroadleafcommercecorecatalogdomainCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("org.broadleafcommerce.core.catalog.domain.Category");

    // Act and Assert
    assertEquals("orgbroadleafcommercecorecatalogdomainCategory", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getDescription()}
   */
  @Test
  public void testGetDescription_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getDescription());
  }

  /**
   * Test {@link CategoryImpl#getDescription()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getDescription()}
   */
  @Test
  public void testGetDescription_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    String actualDescription = categoryImpl.getDescription();

    // Assert
    verify(activeStartDate).getTime();
    assertNull(actualDescription);
  }

  /**
   * Test {@link CategoryImpl#getActiveStartDate()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Archived is
   * {@code Y}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate_givenCategoryImplArchivedIsY_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setArchived('Y');

    // Act and Assert
    assertNull(categoryImpl.getActiveStartDate());
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
  public void testGetActiveStartDate_givenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getActiveStartDate());
  }

  /**
   * Test {@link CategoryImpl#setActiveStartDate(Date)}.
   * <p>
   * Method under test: {@link CategoryImpl#setActiveStartDate(Date)}
   */
  @Test
  public void testSetActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    // Act
    categoryImpl.setActiveStartDate(null);

    // Assert
    assertNull(categoryImpl.getActiveStartDate());
    assertNull(categoryImpl.activeStartDate);
  }

  /**
   * Test {@link CategoryImpl#setActiveStartDate(Date)}.
   * <p>
   * Method under test: {@link CategoryImpl#setActiveStartDate(java.util.Date)}
   */
  @Test
  public void testSetActiveStartDate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    // Act
    categoryImpl.setActiveStartDate(activeStartDate);

    // Assert
    verify(activeStartDate).getTime();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("1970-01-01", simpleDateFormat.format(categoryImpl.getActiveStartDate()));
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(categoryImpl.activeStartDate));
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
    categoryImpl.getActiveEndDate();
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

    // Assert that nothing has changed
    assertEquals("42", actualExternalId);
    assertEquals("Display Template", actualDisplayTemplate);
    assertEquals("Dr", actualMetaTitle);
    assertEquals("Dr", actualProductTitlePatternOverride);
    assertEquals("Meta Description", actualMetaDescription);
    assertEquals("Product Description Pattern Override", actualProductDescriptionPatternOverride);
    assertEquals("Tax Code", actualTaxCode);
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
   * Test {@link CategoryImpl#setActiveEndDate(Date)}.
   * <p>
   * Method under test: {@link CategoryImpl#setActiveEndDate(java.util.Date)}
   */
  @Test
  public void testSetActiveEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    // Act
    categoryImpl.setActiveEndDate(activeEndDate);

    // Assert
    verify(activeEndDate).getTime();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("1970-01-01", simpleDateFormat.format(categoryImpl.getActiveEndDate()));
  }

  /**
   * Test {@link CategoryImpl#isActive()}.
   * <p>
   * Method under test: {@link CategoryImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
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
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setArchived(null);

    // Act and Assert
    assertFalse(categoryImpl.isActive());
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
  public void testIsActive_givenCategoryImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).isActive());
  }

  /**
   * Test {@link CategoryImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getLongDescription());
  }

  /**
   * Test {@link CategoryImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    String actualLongDescription = categoryImpl.getLongDescription();

    // Assert
    verify(activeStartDate).getTime();
    assertNull(actualLongDescription);
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
  public void testGetDefaultParentCategory_givenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getDefaultParentCategory());
  }

  /**
   * Test {@link CategoryImpl#getDefaultParentCategory()}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor)
   * {@link CategoryImpl#defaultParentCategory} {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getDefaultParentCategory()}
   */
  @Test
  public void testGetDefaultParentCategory_thenCategoryImplDefaultParentCategoryCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    Category actualDefaultParentCategory = categoryImpl.getDefaultParentCategory();

    // Assert
    Category category = categoryImpl.defaultParentCategory;
    assertTrue(category instanceof CategoryImpl);
    assertSame(defaultParentCategory, actualDefaultParentCategory);
    assertSame(((CategoryImpl) actualDefaultParentCategory).allLegacyChildCategories,
        ((CategoryImpl) category).allLegacyChildCategories);
    assertSame(((CategoryImpl) actualDefaultParentCategory).archiveStatus, ((CategoryImpl) category).archiveStatus);
    assertSame(((CategoryImpl) actualDefaultParentCategory).childCategoryXrefs,
        ((CategoryImpl) category).childCategoryXrefs);
    assertSame(((CategoryImpl) actualDefaultParentCategory).legacyCategoryMedia,
        ((CategoryImpl) category).legacyCategoryMedia);
    assertSame(((CategoryImpl) actualDefaultParentCategory).legacyChildCategories,
        ((CategoryImpl) category).legacyChildCategories);
  }

  /**
   * Test {@link CategoryImpl#getDefaultParentCategory()}.
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor)
   * {@link CategoryImpl#defaultParentCategory}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getDefaultParentCategory()}
   */
  @Test
  public void testGetDefaultParentCategory_thenReturnCategoryImplDefaultParentCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(mock(Category.class));

    // Act and Assert
    assertSame(categoryImpl.defaultParentCategory, categoryImpl.getDefaultParentCategory());
  }

  /**
   * Test {@link CategoryImpl#getParentCategory()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategory()}
   */
  @Test
  public void testGetParentCategory_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getParentCategory());
  }

  /**
   * Test {@link CategoryImpl#getParentCategory()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategory()}
   */
  @Test
  public void testGetParentCategory_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    Category actualParentCategory = categoryImpl.getParentCategory();

    // Assert
    verify(activeStartDate).getTime();
    assertNull(actualParentCategory);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryXref()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryXref()}
   */
  @Test
  public void testGetParentCategoryXref_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getParentCategoryXref());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryXref()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryXref()}
   */
  @Test
  public void testGetParentCategoryXref_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    CategoryXref actualParentCategoryXref = categoryImpl.getParentCategoryXref();

    // Assert
    verify(activeStartDate).getTime();
    assertNull(actualParentCategoryXref);
  }

  /**
   * Test {@link CategoryImpl#setParentCategory(Category)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllParentCategoryXrefs
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setParentCategory(Category)}
   */
  @Test
  public void testSetParentCategory_thenCategoryImplAllParentCategoryXrefsSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
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
   *   <li>When {@code null}.</li>
   *   <li>Then {@link CategoryImpl} (default constructor) AllParentCategories
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setParentCategory(Category)}
   */
  @Test
  public void testSetParentCategory_whenNull_thenCategoryImplAllParentCategoriesEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    categoryImpl.setParentCategory(null);

    // Assert that nothing has changed
    assertTrue(categoryImpl.getAllParentCategories().isEmpty());
    assertTrue(categoryImpl.getAllParentCategoryXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryXrefs()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryXrefs()}
   */
  @Test
  public void testGetChildCategoryXrefs_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getChildCategoryXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryXrefs()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryXrefs()}
   */
  @Test
  public void testGetChildCategoryXrefs_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    List<CategoryXref> actualChildCategoryXrefs = categoryImpl.getChildCategoryXrefs();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualChildCategoryXrefs.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategoryXrefs(List)}.
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategoryXrefs(List)}
   */
  @Test
  public void testSetAllChildCategoryXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    ArrayList<CategoryXref> childCategories = new ArrayList<>();
    childCategories.add(new CategoryXrefImpl());

    // Act
    categoryImpl.setAllChildCategoryXrefs(childCategories);

    // Assert
    assertEquals(1, categoryImpl.getAllChildCategories().size());
    assertEquals(1, categoryImpl.allLegacyChildCategories.size());
    assertTrue(categoryImpl.hasAllChildCategories());
    assertEquals(childCategories, categoryImpl.getAllChildCategoryXrefs());
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategoryXrefs(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) DefaultParentCategory is
   * {@link Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategoryXrefs(List)}
   */
  @Test
  public void testSetAllChildCategoryXrefs_givenCategoryImplDefaultParentCategoryIsCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setDefaultParentCategory(mock(Category.class));
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

    ArrayList<CategoryXref> childCategories = new ArrayList<>();
    childCategories.add(new CategoryXrefImpl());

    // Act
    categoryImpl.setAllChildCategoryXrefs(childCategories);

    // Assert
    assertEquals(1, categoryImpl.getAllChildCategories().size());
    assertEquals(1, categoryImpl.allLegacyChildCategories.size());
    assertTrue(categoryImpl.hasAllChildCategories());
    assertEquals(childCategories, categoryImpl.getAllChildCategoryXrefs());
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategoryXrefs(List)}.
   * <ul>
   *   <li>Then not {@link CategoryImpl} (default constructor)
   * hasAllChildCategories.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategoryXrefs(List)}
   */
  @Test
  public void testSetAllChildCategoryXrefs_thenNotCategoryImplHasAllChildCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    categoryImpl.setAllChildCategoryXrefs(new ArrayList<>());

    // Assert
    assertFalse(categoryImpl.hasAllChildCategories());
    assertTrue(categoryImpl.getAllChildCategories().isEmpty());
    assertTrue(categoryImpl.getAllChildCategoryXrefs().isEmpty());
    assertTrue(categoryImpl.allLegacyChildCategories.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getAllChildCategories()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getAllChildCategories()}
   */
  @Test
  public void testGetAllChildCategories_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getAllChildCategories().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getAllChildCategories()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getAllChildCategories()}
   */
  @Test
  public void testGetAllChildCategories_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    List<Category> actualAllChildCategories = categoryImpl.getAllChildCategories();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualAllChildCategories.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#hasAllChildCategories()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#hasAllChildCategories()}
   */
  @Test
  public void testHasAllChildCategories_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).hasAllChildCategories());
  }

  /**
   * Test {@link CategoryImpl#hasAllChildCategories()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#hasAllChildCategories()}
   */
  @Test
  public void testHasAllChildCategories_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    boolean actualHasAllChildCategoriesResult = categoryImpl.hasAllChildCategories();

    // Assert
    verify(activeStartDate).getTime();
    assertFalse(actualHasAllChildCategoriesResult);
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
  public void testSetAllChildCategories_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllChildCategories(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  public void testSetAllChildCategories_whenArrayListAddCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  public void testSetAllChildCategories_whenArrayListAddCategoryImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#getChildCategories()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategories()}
   */
  @Test
  public void testGetChildCategories_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getChildCategories().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getChildCategories()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategories()}
   */
  @Test
  public void testGetChildCategories_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    List<Category> actualChildCategories = categoryImpl.getChildCategories();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualChildCategories.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#hasChildCategories()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#hasChildCategories()}
   */
  @Test
  public void testHasChildCategories_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).hasChildCategories());
  }

  /**
   * Test {@link CategoryImpl#hasChildCategories()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#hasChildCategories()}
   */
  @Test
  public void testHasChildCategories_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    boolean actualHasChildCategoriesResult = categoryImpl.hasChildCategories();

    // Assert
    verify(activeStartDate).getTime();
    assertFalse(actualHasChildCategoriesResult);
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
  public void testSetChildCategories_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setChildCategories(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#setChildCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  public void testSetChildCategories_whenArrayListAddCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#setChildCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  public void testSetChildCategories_whenArrayListAddCategoryImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryIds()}.
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryIds()}
   */
  @Test
  public void testGetChildCategoryIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
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
    categoryImpl.setChildCategoryIds(new ArrayList<>());

    // Act and Assert
    assertTrue(categoryImpl.getChildCategoryIds().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryIds()}.
   * <ul>
   *   <li>Given {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryIds()}
   */
  @Test
  public void testGetChildCategoryIds_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
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
    categoryImpl.setChildCategoryIds(new ArrayList<>());

    // Act
    List<Long> actualChildCategoryIds = categoryImpl.getChildCategoryIds();

    // Assert
    verify(activeEndDate).getTime();
    assertTrue(actualChildCategoryIds.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryIds()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryIds()}
   */
  @Test
  public void testCreateChildCategoryIds_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertTrue(categoryImpl.createChildCategoryIds().isEmpty());
    assertTrue(categoryImpl.childCategoryIds.isEmpty());
    List<Long> expectedChildCategoryIds = categoryImpl.childCategoryIds;
    assertSame(expectedChildCategoryIds, categoryImpl.getChildCategoryIds());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryIds()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryIds()}
   */
  @Test
  public void testCreateChildCategoryIds_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    List<Long> actualCreateChildCategoryIdsResult = categoryImpl.createChildCategoryIds();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualCreateChildCategoryIdsResult.isEmpty());
    assertTrue(categoryImpl.childCategoryIds.isEmpty());
    List<Long> expectedChildCategoryIds = categoryImpl.childCategoryIds;
    assertSame(expectedChildCategoryIds, categoryImpl.getChildCategoryIds());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setChildCategoryURLMap(null);

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Cannot create childCategoryURLMap - the urlKey for a category(");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("cannot-create-childCategoryURLMap---the-urlKey-for-a-category");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
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
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsColon_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(":");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is empty
   * string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsEmptyString_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsName_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Name");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
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
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsQuestionMark_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("?");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
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
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsSlash_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("/");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
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
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsSpace_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" ");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code UU UU}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsUuUu_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("UU UU");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code .*?\W.*?}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(".*?\\W.*?");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code [^\w-]+}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("[^\\w-]+");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) UrlKey is empty
   * string.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap_givenCategoryImplUrlKeyIsEmptyString_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
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
    categoryImpl.setChildCategoryURLMap(null);

    // Act
    Map<String, List<Long>> actualChildCategoryURLMap = categoryImpl.getChildCategoryURLMap();

    // Assert
    verify(activeEndDate).getTime();
    assertNull(actualChildCategoryURLMap);
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) UrlKey is
   * {@code /}.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap_givenCategoryImplUrlKeyIsSlash_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
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
    categoryImpl.setChildCategoryURLMap(null);

    // Act
    Map<String, List<Long>> actualChildCategoryURLMap = categoryImpl.getChildCategoryURLMap();

    // Assert
    verify(activeEndDate).getTime();
    assertNull(actualChildCategoryURLMap);
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
  public void testGetChildCategoryURLMap_givenCategoryImpl_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new CategoryImpl()).getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setCategoryAttributes(new ArrayList<>());
    categoryImpl.setCategoryAttributesMap(new HashMap<>());
    categoryImpl.setCategoryMediaXref(new HashMap<>());
    categoryImpl.setChildCategoryIds(new ArrayList<>());
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
    categoryImpl.setChildCategoryURLMap(null);

    // Act
    Map<String, List<Long>> actualChildCategoryURLMap = categoryImpl.getChildCategoryURLMap();

    // Assert
    verify(activeEndDate).getTime();
    assertNull(actualChildCategoryURLMap);
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
  public void testGetChildCategoryURLMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setChildCategoryURLMap(new HashMap<>());

    // Act and Assert
    assertTrue(categoryImpl.getChildCategoryURLMap().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/https://example.org/example");
    assertEquals(1, getResult.size());
    assertEquals(1L, getResult.get(0).longValue());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Cannot create childCategoryURLMap - the urlKey for a category(");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

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
  public void testCreateChildCategoryURLMap3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("cannot-create-childCategoryURLMap---the-urlKey-for-a-category");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

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
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(":");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

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
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("?");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

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
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("/");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code .*?\W.*?}.</li>
   *   <li>Then return {@code /w} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnWSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(".*?\\W.*?");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/w");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code [^\w-]+}.</li>
   *   <li>Then return {@code /w-} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnWSizeIsOne2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("[^\\w-]+");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

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
  public void testCreateChildCategoryURLMap_givenCategoryImpl_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new CategoryImpl()).createChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Then return empty string size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap_thenReturnEmptyStringSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

    // Assert
    verify(activeEndDate).getTime();
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("");
    assertEquals(1, getResult.size());
    assertEquals(1L, getResult.get(0).longValue());
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
  public void testCreateChildCategoryURLMap_thenReturnHttpsExampleOrgExampleSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

    // Assert
    verify(activeEndDate).getTime();
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/https://example.org/example");
    assertEquals(1, getResult.size());
    assertEquals(1L, getResult.get(0).longValue());
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Then return {@code /name} first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap_thenReturnNameFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Name");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/name");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#createChildCategoryURLMap()}.
   * <ul>
   *   <li>Then return {@code /name} first longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap_thenReturnNameFirstLongValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

    // Assert
    verify(activeEndDate).getTime();
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/name");
    assertEquals(1, getResult.size());
    assertEquals(1L, getResult.get(0).longValue());
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
  public void testCreateChildCategoryURLMap_thenReturnSlashDashSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" ");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

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
  public void testCreateChildCategoryURLMap_thenReturnUUUuSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("UU UU");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult = categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/uU-UU");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with
   * {@code currentPath}.
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
        .thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(false));
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category category = categoryImpl.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with
   * {@code currentPath}.
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPath2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.getParentCategoryHierarchy(new ArrayList<>()));
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(false));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with
   * {@code currentPath}, {@code firstParent}.
   * <p>
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(1, actualParentCategoryHierarchy.size());
    assertSame(categoryImpl2, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with
   * {@code currentPath}, {@code firstParent}.
   * <p>
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    assertSame(defaultParentCategory, currentPath.get(0));
    assertSame(defaultParentCategory, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with
   * {@code currentPath}, {@code firstParent}.
   * <p>
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
        .thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(true));
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category category = categoryImpl.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with
   * {@code currentPath}, {@code firstParent}.
   * <p>
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> categoryImpl.getParentCategoryHierarchy(new ArrayList<>(), true));
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(true));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with
   * {@code currentPath}, {@code firstParent}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualParentCategoryHierarchy.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with
   * {@code currentPath}, {@code firstParent}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(mock(Category.class));

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(1, currentPath.size());
    assertSame(currentPath, actualParentCategoryHierarchy);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with
   * {@code currentPath}, {@code firstParent}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    assertSame(categoryImpl2, actualParentCategoryHierarchy.get(1));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with
   * {@code currentPath}, {@code firstParent}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
        .thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, false);

    // Assert
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(false));
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category category = categoryImpl.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with
   * {@code currentPath}, {@code firstParent}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, null);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualParentCategoryHierarchy.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with
   * {@code currentPath}.
   * <ul>
   *   <li>Given {@link Category}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPath_givenCategory_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(mock(Category.class));

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertSame(currentPath, actualParentCategoryHierarchy);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with
   * {@code currentPath}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPath_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualParentCategoryHierarchy.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with
   * {@code currentPath}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first is {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPath_thenArrayListFirstIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    assertSame(defaultParentCategory, currentPath.get(0));
    assertSame(categoryImpl.defaultParentCategory, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with
   * {@code currentPath}.
   * <ul>
   *   <li>Then return first is {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPath_thenReturnFirstIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(1, actualParentCategoryHierarchy.size());
    assertSame(categoryImpl2, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with
   * {@code currentPath}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchyWithCurrentPath_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    assertSame(categoryImpl2, actualParentCategoryHierarchy.get(1));
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   * <p>
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    assertEquals(1, currentPath.size());
    assertEquals(1, actualBuildDefaultParentCategoryPathResult.size());
    Category category = categoryImpl.defaultParentCategory;
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
  public void testBuildDefaultParentCategoryPath_givenCategoryImpl_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualBuildDefaultParentCategoryPathResult.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   * <ul>
   *   <li>Given {@link Category}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath_givenCategory_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(mock(Category.class));

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertSame(currentPath, actualBuildDefaultParentCategoryPathResult);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first is {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath_thenArrayListFirstIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertEquals(1, actualBuildDefaultParentCategoryPathResult.size());
    assertSame(defaultParentCategory, currentPath.get(0));
    assertSame(categoryImpl.defaultParentCategory, actualBuildDefaultParentCategoryPathResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   * <ul>
   *   <li>Then return first is {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath_thenReturnFirstIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertEquals(1, actualBuildDefaultParentCategoryPathResult.size());
    assertSame(categoryImpl2, actualBuildDefaultParentCategoryPathResult.get(0));
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
  public void testBuildDefaultParentCategoryPath_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertEquals(2, actualBuildDefaultParentCategoryPathResult.size());
    assertSame(categoryImpl2, actualBuildDefaultParentCategoryPathResult.get(1));
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
  public void testBuildDefaultParentCategoryPath_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> categoryImpl.buildDefaultParentCategoryPath(new ArrayList<>()));
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategoryXrefs(List)}.
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<CategoryXref> allParentCategories = new ArrayList<>();
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    allParentCategories.add(categoryXrefImpl);

    // Act
    categoryImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    assertEquals(1, categoryImpl.getAllParentCategories().size());
    List<CategoryXref> allParentCategoryXrefs = categoryImpl.getAllParentCategoryXrefs();
    assertEquals(1, allParentCategoryXrefs.size());
    assertSame(categoryXrefImpl, allParentCategoryXrefs.get(0));
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllParentCategories
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs_thenCategoryImplAllParentCategoriesEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    categoryImpl.setAllParentCategoryXrefs(new ArrayList<>());

    // Assert
    assertTrue(categoryImpl.getAllParentCategories().isEmpty());
    assertTrue(categoryImpl.getAllParentCategoryXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllParentCategories first
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs_thenCategoryImplAllParentCategoriesFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<CategoryXref> allParentCategories = new ArrayList<>();
    allParentCategories.add(mock(CategoryXrefImpl.class));

    // Act
    categoryImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    List<Category> allParentCategories2 = categoryImpl.getAllParentCategories();
    assertEquals(1, allParentCategories2.size());
    assertNull(allParentCategories2.get(0));
    assertEquals(1, categoryImpl.getAllParentCategoryXrefs().size());
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategoryXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllParentCategories size
   * is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs_thenCategoryImplAllParentCategoriesSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<CategoryXref> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryXrefImpl());
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    allParentCategories.add(categoryXrefImpl);

    // Act
    categoryImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    assertEquals(2, categoryImpl.getAllParentCategories().size());
    List<CategoryXref> allParentCategoryXrefs = categoryImpl.getAllParentCategoryXrefs();
    assertEquals(2, allParentCategoryXrefs.size());
    assertSame(categoryXrefImpl, allParentCategoryXrefs.get(1));
  }

  /**
   * Test {@link CategoryImpl#getAllParentCategories()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getAllParentCategories()}
   */
  @Test
  public void testGetAllParentCategories_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getAllParentCategories().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getAllParentCategories()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getAllParentCategories()}
   */
  @Test
  public void testGetAllParentCategories_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    List<Category> actualAllParentCategories = categoryImpl.getAllParentCategories();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualAllParentCategories.isEmpty());
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
  public void testSetAllParentCategories_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllParentCategories(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories_whenArrayListAddCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllParentCategories(allParentCategories));
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategories(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories_whenArrayListAddCategoryImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllParentCategories(allParentCategories));
  }

  /**
   * Test {@link CategoryImpl#setFeaturedProducts(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) DefaultParentCategory is
   * {@link Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  public void testSetFeaturedProducts_givenCategoryImplDefaultParentCategoryIsCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setDefaultParentCategory(mock(Category.class));
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

    ArrayList<FeaturedProduct> featuredProducts = new ArrayList<>();
    featuredProducts.add(new FeaturedProductImpl());

    // Act
    categoryImpl.setFeaturedProducts(featuredProducts);

    // Assert
    assertEquals(featuredProducts, categoryImpl.getCumulativeFeaturedProducts());
    assertEquals(featuredProducts, categoryImpl.getFeaturedProducts());
  }

  /**
   * Test {@link CategoryImpl#setFeaturedProducts(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) DefaultParentCategory is
   * {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  public void testSetFeaturedProducts_givenCategoryImplDefaultParentCategoryIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    ArrayList<FeaturedProduct> featuredProducts = new ArrayList<>();
    featuredProducts.add(new FeaturedProductImpl());

    // Act
    categoryImpl.setFeaturedProducts(featuredProducts);

    // Assert
    assertEquals(featuredProducts, categoryImpl.getCumulativeFeaturedProducts());
    assertEquals(featuredProducts, categoryImpl.getFeaturedProducts());
  }

  /**
   * Test {@link CategoryImpl#setFeaturedProducts(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor)
   * CumulativeFeaturedProducts Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  public void testSetFeaturedProducts_thenCategoryImplCumulativeFeaturedProductsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    categoryImpl.setFeaturedProducts(new ArrayList<>());

    // Assert
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(categoryImpl.getFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setCrossSaleProducts(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) DefaultParentCategory is
   * {@link Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  public void testSetCrossSaleProducts_givenCategoryImplDefaultParentCategoryIsCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setDefaultParentCategory(mock(Category.class));
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

    ArrayList<RelatedProduct> crossSaleProducts = new ArrayList<>();
    crossSaleProducts.add(new CrossSaleProductImpl());

    // Act
    categoryImpl.setCrossSaleProducts(crossSaleProducts);

    // Assert
    assertEquals(crossSaleProducts, categoryImpl.getCrossSaleProducts());
    assertEquals(crossSaleProducts, categoryImpl.getCumulativeCrossSaleProducts());
  }

  /**
   * Test {@link CategoryImpl#setCrossSaleProducts(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) DefaultParentCategory is
   * {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  public void testSetCrossSaleProducts_givenCategoryImplDefaultParentCategoryIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    ArrayList<RelatedProduct> crossSaleProducts = new ArrayList<>();
    crossSaleProducts.add(new CrossSaleProductImpl());

    // Act
    categoryImpl.setCrossSaleProducts(crossSaleProducts);

    // Assert
    assertEquals(crossSaleProducts, categoryImpl.getCrossSaleProducts());
    assertEquals(crossSaleProducts, categoryImpl.getCumulativeCrossSaleProducts());
  }

  /**
   * Test {@link CategoryImpl#setCrossSaleProducts(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CrossSaleProducts
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  public void testSetCrossSaleProducts_thenCategoryImplCrossSaleProductsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    categoryImpl.setCrossSaleProducts(new ArrayList<>());

    // Assert
    assertTrue(categoryImpl.getCrossSaleProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = new CategoryImpl();
    category.setName("sequence");

    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(category);
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(1);
    Category category2 = getResult.getCategory();
    assertTrue(category2 instanceof CategoryImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    assertEquals("sequence", category2.getGeneratedUrl());
    assertEquals("sequence", category2.getName());
    assertEquals("sequence", category2.getUrlKey());
    assertEquals("sequence", ((CategoryImpl) category2).getMainEntityName());
    assertEquals("sequence", ((CategoryImpl) category2).name);
    assertNull(category2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = new CategoryImpl();
    category.setUrl("https://example.org/example");

    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(category);
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(1);
    Category category2 = getResult.getCategory();
    assertTrue(category2 instanceof CategoryImpl);
    Product product = getResult.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    Product relatedProduct2 = getResult.getRelatedProduct();
    assertTrue(relatedProduct2 instanceof ProductBundleImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    FieldEntity fieldEntityType = product.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals("https://example.org/example", category2.getUrl());
    assertEquals("https://example.org/example", ((CategoryImpl) category2).getLocation());
    assertEquals("https://example.org/example", ((CategoryImpl) category2).url);
    assertEquals("null", category2.getGeneratedUrl());
    assertNull(category2.getName());
    assertNull(category2.getUrlKey());
    assertNull(((CategoryImpl) category2).getMainEntityName());
    assertNull(((CategoryImpl) category2).name);
    List<Sku> allSellableSkus = product.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertEquals(allSellableSkus, relatedProduct2.getAllSellableSkus());
    assertEquals(allSellableSkus, product.getAllSkus());
    assertEquals(allSellableSkus, relatedProduct2.getAllSkus());
    assertSame(fieldEntityType, relatedProduct2.getFieldEntityType());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RelatedProduct relatedProduct2 = mock(RelatedProduct.class);
    when(relatedProduct2.getSequence()).thenThrow(new UnsupportedOperationException("foo"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct2);
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
    verify(relatedProduct2).getSequence();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(2);
    Product product = getResult.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    Product relatedProduct3 = getResult.getRelatedProduct();
    assertTrue(relatedProduct3 instanceof ProductBundleImpl);
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
    assertEquals(allSellableSkus, relatedProduct3.getAllSellableSkus());
    assertEquals(allSellableSkus, product.getAllSkus());
    assertEquals(allSellableSkus, relatedProduct3.getAllSkus());
    assertSame(fieldEntityType, relatedProduct3.getFieldEntityType());
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
  public void testGetCumulativeCrossSaleProducts_givenCategoryImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Then first return {@link CrossSaleProductImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts_thenFirstReturnCrossSaleProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RelatedProduct relatedProduct2 = mock(RelatedProduct.class);
    when(relatedProduct2.getSequence()).thenThrow(new UnsupportedOperationException("foo"));

    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    CategoryImpl category = new CategoryImpl();
    crossSaleProductImpl.setCategory(category);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);
    relatedProductList.add(relatedProduct2);
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
    verify(relatedProduct2, atLeast(1)).getSequence();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(4, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(0);
    assertTrue(getResult instanceof CrossSaleProductImpl);
    assertSame(category, getResult.getCategory());
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
  public void testGetCumulativeCrossSaleProducts_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getCrossSaleProducts()).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    assertTrue(actualCumulativeCrossSaleProducts.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Then return fourth is {@link UpSaleProductImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts_thenReturnFourthIsUpSaleProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RelatedProduct relatedProduct2 = mock(RelatedProduct.class);
    when(relatedProduct2.getSequence()).thenThrow(new UnsupportedOperationException("foo"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(relatedProduct2);
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
    verify(relatedProduct2, atLeast(1)).getSequence();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(4, actualCumulativeCrossSaleProducts.size());
    assertSame(upSaleProductImpl, actualCumulativeCrossSaleProducts.get(3));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   * <ul>
   *   <li>Then return second Category is {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts_thenReturnSecondCategoryIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(1);
    Category category = getResult.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Product product = getResult.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    Product relatedProduct2 = getResult.getRelatedProduct();
    assertTrue(relatedProduct2 instanceof ProductBundleImpl);
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
    assertEquals(categoryImpl, category);
    assertEquals(allSellableSkus, relatedProduct2.getAllSellableSkus());
    assertEquals(allSellableSkus, product.getAllSkus());
    assertEquals(allSellableSkus, relatedProduct2.getAllSkus());
    assertSame(fieldEntityType, relatedProduct2.getFieldEntityType());
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
  public void testGetCumulativeCrossSaleProducts_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts = categoryImpl.getCumulativeCrossSaleProducts();

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
  public void testGetCumulativeCrossSaleProducts_thenReturnSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(2);
    assertTrue(getResult.getProduct() instanceof ProductBundleImpl);
    assertTrue(getResult.getRelatedProduct() instanceof ProductBundleImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
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
  public void testGetCumulativeCrossSaleProducts_thenSecondProductReturnProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
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
    assertEquals(2, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(1);
    assertTrue(getResult.getProduct() instanceof ProductBundleImpl);
    assertTrue(getResult.getRelatedProduct() instanceof ProductBundleImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
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
  public void testGetCumulativeCrossSaleProducts_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new RuntimeException("foo"));

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> categoryImpl.getCumulativeCrossSaleProducts());
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = new CategoryImpl();
    category.setUrl("https://example.org/example");

    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(category);
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(1);
    Category category2 = getResult.getCategory();
    assertTrue(category2 instanceof CategoryImpl);
    Product product = getResult.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    Product relatedProduct2 = getResult.getRelatedProduct();
    assertTrue(relatedProduct2 instanceof ProductBundleImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    FieldEntity fieldEntityType = product.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals("https://example.org/example", category2.getUrl());
    assertEquals("https://example.org/example", ((CategoryImpl) category2).getLocation());
    assertEquals("https://example.org/example", ((CategoryImpl) category2).url);
    assertEquals("null", category2.getGeneratedUrl());
    assertNull(category2.getName());
    assertNull(category2.getUrlKey());
    assertNull(((CategoryImpl) category2).getMainEntityName());
    assertNull(((CategoryImpl) category2).name);
    List<Sku> allSellableSkus = product.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertEquals(allSellableSkus, relatedProduct2.getAllSellableSkus());
    assertEquals(allSellableSkus, product.getAllSkus());
    assertEquals(allSellableSkus, relatedProduct2.getAllSkus());
    assertSame(fieldEntityType, relatedProduct2.getFieldEntityType());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RelatedProduct relatedProduct2 = mock(RelatedProduct.class);
    when(relatedProduct2.getSequence()).thenThrow(new UnsupportedOperationException("foo"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(relatedProduct2);
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
    verify(relatedProduct2).getSequence();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(2);
    Product product = getResult.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    Product relatedProduct3 = getResult.getRelatedProduct();
    assertTrue(relatedProduct3 instanceof ProductBundleImpl);
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
    assertEquals(allSellableSkus, relatedProduct3.getAllSellableSkus());
    assertEquals(allSellableSkus, product.getAllSkus());
    assertEquals(allSellableSkus, relatedProduct3.getAllSkus());
    assertSame(fieldEntityType, relatedProduct3.getFieldEntityType());
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
  public void testGetCumulativeUpSaleProducts_givenCategoryImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then first return {@link CrossSaleProductImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts_thenFirstReturnCrossSaleProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RelatedProduct relatedProduct2 = mock(RelatedProduct.class);
    when(relatedProduct2.getSequence()).thenThrow(new UnsupportedOperationException("foo"));

    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    CategoryImpl category = new CategoryImpl();
    crossSaleProductImpl.setCategory(category);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);
    relatedProductList.add(relatedProduct2);
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
    verify(relatedProduct2, atLeast(1)).getSequence();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(4, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(0);
    assertTrue(getResult instanceof CrossSaleProductImpl);
    assertSame(category, getResult.getCategory());
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
  public void testGetCumulativeUpSaleProducts_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getUpSaleProducts()).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    assertTrue(actualCumulativeUpSaleProducts.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then return fourth is {@link UpSaleProductImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts_thenReturnFourthIsUpSaleProductImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RelatedProduct relatedProduct2 = mock(RelatedProduct.class);
    when(relatedProduct2.getSequence()).thenThrow(new UnsupportedOperationException("foo"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(relatedProduct2);
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
    verify(relatedProduct2, atLeast(1)).getSequence();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(4, actualCumulativeUpSaleProducts.size());
    assertSame(upSaleProductImpl, actualCumulativeUpSaleProducts.get(3));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then return second Category GeneratedUrl is {@code sequence}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts_thenReturnSecondCategoryGeneratedUrlIsSequence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl category = new CategoryImpl();
    category.setName("sequence");

    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(category);
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(1);
    Category category2 = getResult.getCategory();
    assertTrue(category2 instanceof CategoryImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    assertEquals("sequence", category2.getGeneratedUrl());
    assertEquals("sequence", category2.getName());
    assertEquals("sequence", category2.getUrlKey());
    assertEquals("sequence", ((CategoryImpl) category2).getMainEntityName());
    assertEquals("sequence", ((CategoryImpl) category2).name);
    assertNull(category2.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   * <ul>
   *   <li>Then return second Category is {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts_thenReturnSecondCategoryIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(1);
    Category category = getResult.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Product product = getResult.getProduct();
    assertTrue(product instanceof ProductBundleImpl);
    Product relatedProduct2 = getResult.getRelatedProduct();
    assertTrue(relatedProduct2 instanceof ProductBundleImpl);
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
    assertEquals(categoryImpl, category);
    assertEquals(allSellableSkus, relatedProduct2.getAllSellableSkus());
    assertEquals(allSellableSkus, product.getAllSkus());
    assertEquals(allSellableSkus, relatedProduct2.getAllSkus());
    assertSame(fieldEntityType, relatedProduct2.getFieldEntityType());
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
  public void testGetCumulativeUpSaleProducts_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts = categoryImpl.getCumulativeUpSaleProducts();

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
  public void testGetCumulativeUpSaleProducts_thenReturnSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(2);
    assertTrue(getResult.getProduct() instanceof ProductBundleImpl);
    assertTrue(getResult.getRelatedProduct() instanceof ProductBundleImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
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
  public void testGetCumulativeUpSaleProducts_thenSecondProductReturnProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(new CrossSaleProductImpl());
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
    assertEquals(2, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(1);
    assertTrue(getResult.getProduct() instanceof ProductBundleImpl);
    assertTrue(getResult.getRelatedProduct() instanceof ProductBundleImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
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
  public void testGetCumulativeUpSaleProducts_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new RuntimeException("foo"));

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> categoryImpl.getCumulativeUpSaleProducts());
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
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
  public void testGetCumulativeFeaturedProducts_givenArrayListAddNull_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(mock(FeaturedProductImpl.class));
    featuredProductList.add(null);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl.getCumulativeFeaturedProducts();

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
  public void testGetCumulativeFeaturedProducts_givenArrayListAddNull_thenReturnFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(null);
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl.getCumulativeFeaturedProducts();

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
  public void testGetCumulativeFeaturedProducts_givenCategoryImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
  public void testGetCumulativeFeaturedProducts_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl.getCumulativeFeaturedProducts();

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
  public void testGetCumulativeFeaturedProducts_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl.getCumulativeFeaturedProducts();

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
  public void testGetCumulativeFeaturedProducts_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl);
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl.getCumulativeFeaturedProducts();

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
  public void testGetCumulativeFeaturedProducts_thenReturnSizeIsOne2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl);
    featuredProductList.add(new FeaturedProductImpl());
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl.getCumulativeFeaturedProducts();

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
  public void testGetCumulativeFeaturedProducts_thenReturnSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl.getCumulativeFeaturedProducts();

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
  public void testGetCumulativeFeaturedProducts_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts = categoryImpl.getCumulativeFeaturedProducts();

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
  public void testGetCumulativeFeaturedProducts_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new RuntimeException("foo"));

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> categoryImpl.getCumulativeFeaturedProducts());
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#setUpSaleProducts(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) DefaultParentCategory is
   * {@link Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  public void testSetUpSaleProducts_givenCategoryImplDefaultParentCategoryIsCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setDefaultParentCategory(mock(Category.class));
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
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    categoryImpl.setUpSaleProducts(upSaleProducts);
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    ArrayList<RelatedProduct> upSaleProducts2 = new ArrayList<>();
    upSaleProducts2.add(new CrossSaleProductImpl());

    // Act
    categoryImpl.setUpSaleProducts(upSaleProducts2);

    // Assert
    assertEquals(upSaleProducts, upSaleProducts2);
    assertEquals(upSaleProducts, categoryImpl.getCumulativeUpSaleProducts());
    assertSame(upSaleProducts2, categoryImpl.getUpSaleProducts());
  }

  /**
   * Test {@link CategoryImpl#setUpSaleProducts(List)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) DefaultParentCategory is
   * {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  public void testSetUpSaleProducts_givenCategoryImplDefaultParentCategoryIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    categoryImpl.setUpSaleProducts(upSaleProducts);
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    ArrayList<RelatedProduct> upSaleProducts2 = new ArrayList<>();
    upSaleProducts2.add(new CrossSaleProductImpl());

    // Act
    categoryImpl.setUpSaleProducts(upSaleProducts2);

    // Assert
    assertEquals(upSaleProducts, upSaleProducts2);
    assertEquals(upSaleProducts, categoryImpl.getCumulativeUpSaleProducts());
    assertSame(upSaleProducts2, categoryImpl.getUpSaleProducts());
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
  public void testSetUpSaleProducts_givenCategoryImpl_whenArrayList_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();

    // Act
    categoryImpl.setUpSaleProducts(upSaleProducts);

    // Assert
    assertTrue(upSaleProducts.isEmpty());
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
    assertSame(upSaleProducts, categoryImpl.getUpSaleProducts());
  }

  /**
   * Test {@link CategoryImpl#getActiveProductXrefs()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getActiveProductXrefs()}
   */
  @Test
  public void testGetActiveProductXrefs_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getActiveProductXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getActiveProductXrefs()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getActiveProductXrefs()}
   */
  @Test
  public void testGetActiveProductXrefs_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    List<CategoryProductXref> actualActiveProductXrefs = categoryImpl.getActiveProductXrefs();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualActiveProductXrefs.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllProductXrefs(List)}.
   * <p>
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  public void testSetAllProductXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<CategoryProductXref> allProducts = new ArrayList<>();
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    allProducts.add(categoryProductXrefImpl);

    // Act
    categoryImpl.setAllProductXrefs(allProducts);

    // Assert
    List<CategoryProductXref> allProductXrefs = categoryImpl.getAllProductXrefs();
    assertEquals(1, allProductXrefs.size());
    assertEquals(1, categoryImpl.getAllProducts().size());
    assertSame(categoryProductXrefImpl, allProductXrefs.get(0));
  }

  /**
   * Test {@link CategoryImpl#setAllProductXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllProductXrefs size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  public void testSetAllProductXrefs_thenCategoryImplAllProductXrefsSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<CategoryProductXref> allProducts = new ArrayList<>();
    allProducts.add(new CategoryProductXrefImpl());
    CategoryProductXrefImpl categoryProductXrefImpl = new CategoryProductXrefImpl();
    allProducts.add(categoryProductXrefImpl);

    // Act
    categoryImpl.setAllProductXrefs(allProducts);

    // Assert
    List<CategoryProductXref> allProductXrefs = categoryImpl.getAllProductXrefs();
    assertEquals(2, allProductXrefs.size());
    assertEquals(2, categoryImpl.getAllProducts().size());
    assertSame(categoryProductXrefImpl, allProductXrefs.get(1));
  }

  /**
   * Test {@link CategoryImpl#setAllProductXrefs(List)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) AllProducts first is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  public void testSetAllProductXrefs_thenCategoryImplAllProductsFirstIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<CategoryProductXref> allProducts = new ArrayList<>();
    allProducts.add(mock(CategoryProductXrefImpl.class));

    // Act
    categoryImpl.setAllProductXrefs(allProducts);

    // Assert
    List<Product> allProducts2 = categoryImpl.getAllProducts();
    assertEquals(1, allProducts2.size());
    assertNull(allProducts2.get(0));
    assertEquals(1, categoryImpl.getAllProductXrefs().size());
  }

  /**
   * Test {@link CategoryImpl#setAllProductXrefs(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link CategoryImpl} (default constructor) AllProductXrefs
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  public void testSetAllProductXrefs_whenArrayList_thenCategoryImplAllProductXrefsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    categoryImpl.setAllProductXrefs(new ArrayList<>());

    // Assert
    assertTrue(categoryImpl.getAllProductXrefs().isEmpty());
    assertTrue(categoryImpl.getAllProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getActiveProducts()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getActiveProducts()}
   */
  @Test
  public void testGetActiveProducts_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getActiveProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getActiveProducts()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getActiveProducts()}
   */
  @Test
  public void testGetActiveProducts_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    List<Product> actualActiveProducts = categoryImpl.getActiveProducts();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualActiveProducts.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getAllProducts()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getAllProducts()}
   */
  @Test
  public void testGetAllProducts_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getAllProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getAllProducts()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getAllProducts()}
   */
  @Test
  public void testGetAllProducts_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    List<Product> actualAllProducts = categoryImpl.getAllProducts();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualAllProducts.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllProducts(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  public void testSetAllProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Product> allProducts = new ArrayList<>();
    allProducts.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllProducts(allProducts));
  }

  /**
   * Test {@link CategoryImpl#setAllProducts(List)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  public void testSetAllProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Product> allProducts = new ArrayList<>();
    allProducts.add(new ProductBundleImpl());
    allProducts.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllProducts(allProducts));
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
  public void testSetAllProducts_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllProducts(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getInventoryType());
  }

  /**
   * Test {@link CategoryImpl#getInventoryType()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    InventoryType actualInventoryType = categoryImpl.getInventoryType();

    // Assert
    verify(activeStartDate).getTime();
    assertNull(actualInventoryType);
  }

  /**
   * Test {@link CategoryImpl#setInventoryType(InventoryType)}.
   * <p>
   * Method under test: {@link CategoryImpl#setInventoryType(InventoryType)}
   */
  @Test
  public void testSetInventoryType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    // Act
    categoryImpl.setInventoryType(null);

    // Assert
    assertNull(categoryImpl.inventoryType);
    assertNull(categoryImpl.getInventoryType());
  }

  /**
   * Test {@link CategoryImpl#setInventoryType(InventoryType)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor)
   * {@link CategoryImpl#inventoryType} is {@code ALWAYS_AVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setInventoryType(InventoryType)}
   */
  @Test
  public void testSetInventoryType_thenCategoryImplInventoryTypeIsAlwaysAvailable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    InventoryType inventoryType = InventoryType.ALWAYS_AVAILABLE;

    // Act
    categoryImpl.setInventoryType(inventoryType);

    // Assert
    assertEquals("ALWAYS_AVAILABLE", categoryImpl.inventoryType);
    InventoryType expectedInventoryType = inventoryType.ALWAYS_AVAILABLE;
    assertSame(expectedInventoryType, categoryImpl.getInventoryType());
  }

  /**
   * Test {@link CategoryImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) DefaultParentCategory is
   * {@link Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType_givenCategoryImplDefaultParentCategoryIsCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setDefaultParentCategory(mock(Category.class));
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    categoryImpl.setExcludedSearchFacets(new ArrayList<>());
    categoryImpl.setExternalId("42");
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
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);

    // Act
    FulfillmentType actualFulfillmentType = categoryImpl.getFulfillmentType();

    // Assert
    assertSame(actualFulfillmentType.DIGITAL, actualFulfillmentType);
  }

  /**
   * Test {@link CategoryImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) DefaultParentCategory is
   * {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType_givenCategoryImplDefaultParentCategoryIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);

    // Act
    FulfillmentType actualFulfillmentType = categoryImpl.getFulfillmentType();

    // Assert
    assertSame(actualFulfillmentType.DIGITAL, actualFulfillmentType);
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
  public void testGetFulfillmentType_givenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getFulfillmentType());
  }

  /**
   * Test {@link CategoryImpl#setFulfillmentType(FulfillmentType)}.
   * <p>
   * Method under test: {@link CategoryImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  public void testSetFulfillmentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    // Act
    categoryImpl.setFulfillmentType(null);

    // Assert
    assertNull(categoryImpl.fulfillmentType);
    assertNull(categoryImpl.getFulfillmentType());
  }

  /**
   * Test {@link CategoryImpl#setFulfillmentType(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#DIGITAL}.</li>
   *   <li>Then {@link CategoryImpl} (default constructor)
   * {@link CategoryImpl#fulfillmentType} is {@code DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  public void testSetFulfillmentType_whenDigital_thenCategoryImplFulfillmentTypeIsDigital() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    FulfillmentType fulfillmentType = FulfillmentType.DIGITAL;

    // Act
    categoryImpl.setFulfillmentType(fulfillmentType);

    // Assert
    assertEquals("DIGITAL", categoryImpl.fulfillmentType);
    FulfillmentType expectedFulfillmentType = fulfillmentType.DIGITAL;
    assertSame(expectedFulfillmentType, categoryImpl.getFulfillmentType());
  }

  /**
   * Test {@link CategoryImpl#getParentFacets(Collection)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  public void testGetParentFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<SearchFacet> facets = new ArrayList<>();
    facets.add(new SearchFacetImpl());

    // Act and Assert
    assertNull(categoryImpl.getParentFacets(facets));
  }

  /**
   * Test {@link CategoryImpl#getParentFacets(Collection)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  public void testGetParentFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<SearchFacet> facets = new ArrayList<>();
    facets.add(new SearchFacetImpl());
    facets.add(new SearchFacetImpl());

    // Act and Assert
    assertNull(categoryImpl.getParentFacets(facets));
  }

  /**
   * Test {@link CategoryImpl#getParentFacets(Collection)}.
   * <ul>
   *   <li>Given {@link SearchFacetImpl}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  public void testGetParentFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<SearchFacet> facets = new ArrayList<>();
    facets.add(mock(SearchFacetImpl.class));

    // Act and Assert
    assertNull(categoryImpl.getParentFacets(facets));
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
  public void testGetParentFacets_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertNull(categoryImpl.getParentFacets(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacetsWithSet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setUrl("https://example.org/example");
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

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
  public void testGetCumulativeSearchFacetsWithSet2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacetsWithSet_givenCategoryImplIdIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any())).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setId(1L);
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    HashSet<Category> categoryHierarchy = new HashSet<>();
    categoryHierarchy.add(new CategoryImpl());

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacetsWithSet_givenCategoryImplIdIsOne2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any())).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setId(1L);
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2.setId(1L);

    HashSet<Category> categoryHierarchy = new HashSet<>();
    categoryHierarchy.add(categoryImpl2);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacetsWithSet_givenCategoryImplNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Name");
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

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
  public void testGetCumulativeSearchFacetsWithSet_givenCategoryImpl_thenHashSetSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>Given {@link Category}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@link Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacetsWithSet_givenCategory_whenHashSetAddCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    HashSet<Category> categoryHierarchy = new HashSet<>();
    categoryHierarchy.add(mock(Category.class));

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(2, categoryHierarchy.size());
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
  public void testGetCumulativeSearchFacetsWithSet_thenCallsGetCumulativeSearchFacets() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any())).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

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
  public void testGetCumulativeSearchFacetsWithSet_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<CategorySearchFacet> categorySearchFacetList = new ArrayList<>();
    categorySearchFacetList.add(new CategorySearchFacetImpl());
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(categorySearchFacetList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(new HashSet<>());

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(categorySearchFacetList, actualCumulativeSearchFacets);
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
  public void testGetCumulativeSearchFacetsWithSet_thenReturnArrayList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any())).thenReturn(new ArrayList<>());

    ArrayList<CategorySearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new CategorySearchFacetImpl());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setSearchFacets(searchFacets);
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(new HashSet<>());

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(searchFacets, actualCumulativeSearchFacets);
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
  public void testGetCumulativeSearchFacetsWithSet_thenReturnArrayList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<CategorySearchFacet> categorySearchFacetList = new ArrayList<>();
    categorySearchFacetList.add(new CategorySearchFacetImpl());
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(categorySearchFacetList);

    ArrayList<CategorySearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new CategorySearchFacetImpl());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setSearchFacets(searchFacets);
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(new HashSet<>());

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(searchFacets, actualCumulativeSearchFacets);
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
  public void testGetCumulativeSearchFacetsWithSet_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.getCumulativeSearchFacets(new HashSet<>()));
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add {@link CategoryImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacetsWithSet_whenHashSetAddCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    HashSet<Category> categoryHierarchy = new HashSet<>();
    categoryHierarchy.add(new CategoryImpl());

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

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
  public void testGetCumulativeSearchFacetsWithSet_whenHashSetAddNull_thenHashSetSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    HashSet<Category> categoryHierarchy = new HashSet<>();
    categoryHierarchy.add(null);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(2, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is
   * {@code Name}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets_givenCategoryImplNameIsName_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Name");

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets_givenCategoryImplUrlIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
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
  public void testGetCumulativeSearchFacets_givenCategoryImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeSearchFacets().isEmpty());
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
  public void testGetCumulativeSearchFacets_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<CategorySearchFacet> categorySearchFacetList = new ArrayList<>();
    categorySearchFacetList.add(new CategorySearchFacetImpl());
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(categorySearchFacetList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets();

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(categorySearchFacetList, actualCumulativeSearchFacets);
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
  public void testGetCumulativeSearchFacets_thenReturnArrayList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any())).thenReturn(new ArrayList<>());

    ArrayList<CategorySearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new CategorySearchFacetImpl());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setSearchFacets(searchFacets);
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets();

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(searchFacets, actualCumulativeSearchFacets);
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
  public void testGetCumulativeSearchFacets_thenReturnArrayList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<CategorySearchFacet> categorySearchFacetList = new ArrayList<>();
    categorySearchFacetList.add(new CategorySearchFacetImpl());
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(categorySearchFacetList);

    ArrayList<CategorySearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new CategorySearchFacetImpl());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setSearchFacets(searchFacets);
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets();

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(searchFacets, actualCumulativeSearchFacets);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any())).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets();

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertTrue(actualCumulativeSearchFacets.isEmpty());
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
  public void testGetCumulativeSearchFacets_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.getCumulativeSearchFacets());
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
  }

  /**
   * Test {@link CategoryImpl#getCategoryMedia()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryMedia()}
   */
  @Test
  public void testGetCategoryMedia_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCategoryMedia().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryMedia()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryMedia()}
   */
  @Test
  public void testGetCategoryMedia_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    Map<String, Media> actualCategoryMedia = categoryImpl.getCategoryMedia();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualCategoryMedia.isEmpty());
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
  public void testSetCategoryMedia_whenHashMap_thenHashMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    HashMap<String, Media> categoryMedia = new HashMap<>();

    // Act
    categoryImpl.setCategoryMedia(categoryMedia);

    // Assert
    assertTrue(categoryMedia.isEmpty());
    assertTrue(categoryImpl.getCategoryMedia().isEmpty());
    assertTrue(categoryImpl.getCategoryMediaXref().isEmpty());
    assertTrue(categoryImpl.legacyCategoryMedia.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributesMap()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  public void testGetCategoryAttributesMap_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCategoryAttributesMap().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributesMap()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  public void testGetCategoryAttributesMap_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    Map<String, CategoryAttribute> actualCategoryAttributesMap = categoryImpl.getCategoryAttributesMap();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualCategoryAttributesMap.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setCategoryAttributesMap(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCategoryAttributesMap(Map)}
   */
  @Test
  public void testSetCategoryAttributesMap_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    categoryAttributes.computeIfPresent("foo", mock(BiFunction.class));
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributes.put("foo", categoryAttributeImpl);

    // Act
    categoryImpl.setCategoryAttributesMap(categoryAttributes);

    // Assert
    List<CategoryAttribute> categoryAttributes2 = categoryImpl.getCategoryAttributes();
    assertEquals(1, categoryAttributes2.size());
    Map<String, CategoryAttribute> categoryAttributesMap = categoryImpl.getCategoryAttributesMap();
    assertEquals(1, categoryAttributesMap.size());
    Map<String, CategoryAttribute> multiValueCategoryAttributes = categoryImpl.getMultiValueCategoryAttributes();
    assertEquals(1, multiValueCategoryAttributes.size());
    assertEquals(categoryAttributes2, multiValueCategoryAttributes.get(null));
    assertEquals(categoryAttributesMap, categoryImpl.getMappedCategoryAttributes());
    assertSame(categoryAttributeImpl, categoryAttributes2.get(0));
    assertSame(categoryAttributeImpl, categoryAttributesMap.get(null));
  }

  /**
   * Test {@link CategoryImpl#setCategoryAttributesMap(Map)}.
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CategoryAttributes size
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCategoryAttributesMap(Map)}
   */
  @Test
  public void testSetCategoryAttributesMap_thenCategoryImplCategoryAttributesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributes.put("foo", categoryAttributeImpl);

    // Act
    categoryImpl.setCategoryAttributesMap(categoryAttributes);

    // Assert
    List<CategoryAttribute> categoryAttributes2 = categoryImpl.getCategoryAttributes();
    assertEquals(1, categoryAttributes2.size());
    Map<String, CategoryAttribute> categoryAttributesMap = categoryImpl.getCategoryAttributesMap();
    assertEquals(1, categoryAttributesMap.size());
    Map<String, CategoryAttribute> multiValueCategoryAttributes = categoryImpl.getMultiValueCategoryAttributes();
    assertEquals(1, multiValueCategoryAttributes.size());
    assertEquals(categoryAttributes2, multiValueCategoryAttributes.get(null));
    assertEquals(categoryAttributesMap, categoryImpl.getMappedCategoryAttributes());
    assertSame(categoryAttributeImpl, categoryAttributes2.get(0));
    assertSame(categoryAttributeImpl, categoryAttributesMap.get(null));
  }

  /**
   * Test {@link CategoryImpl#setCategoryAttributesMap(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link CategoryImpl} (default constructor) CategoryAttributes
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setCategoryAttributesMap(Map)}
   */
  @Test
  public void testSetCategoryAttributesMap_whenHashMap_thenCategoryImplCategoryAttributesEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    categoryImpl.setCategoryAttributesMap(new HashMap<>());

    // Assert
    assertTrue(categoryImpl.getCategoryAttributes().isEmpty());
    assertTrue(categoryImpl.getCategoryAttributesMap().isEmpty());
    assertTrue(categoryImpl.getMappedCategoryAttributes().isEmpty());
    assertTrue(categoryImpl.getMultiValueCategoryAttributes().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributeByName(String)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryAttributeByName(String)}
   */
  @Test
  public void testGetCategoryAttributeByName_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getCategoryAttributeByName("Name"));
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributeByName(String)}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getCategoryAttributeByName(String)}
   */
  @Test
  public void testGetCategoryAttributeByName_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    CategoryAttribute actualCategoryAttributeByName = categoryImpl.getCategoryAttributeByName("Name");

    // Assert
    verify(activeStartDate).getTime();
    assertNull(actualCategoryAttributeByName);
  }

  /**
   * Test {@link CategoryImpl#getMappedCategoryAttributes()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  public void testGetMappedCategoryAttributes_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getMappedCategoryAttributes().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getMappedCategoryAttributes()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  public void testGetMappedCategoryAttributes_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    Map<String, CategoryAttribute> actualMappedCategoryAttributes = categoryImpl.getMappedCategoryAttributes();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualMappedCategoryAttributes.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getMultiValueCategoryAttributes()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getMultiValueCategoryAttributes()}
   */
  @Test
  public void testGetMultiValueCategoryAttributes_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getMultiValueCategoryAttributes().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getMultiValueCategoryAttributes()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getMultiValueCategoryAttributes()}
   */
  @Test
  public void testGetMultiValueCategoryAttributes_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    Map<String, CategoryAttribute> actualMultiValueCategoryAttributes = categoryImpl.getMultiValueCategoryAttributes();

    // Assert
    verify(activeStartDate).getTime();
    assertTrue(actualMultiValueCategoryAttributes.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new CategoryImpl()).getArchived().charValue());
  }

  /**
   * Test {@link CategoryImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    Character actualArchived = categoryImpl.getArchived();

    // Assert
    verify(activeStartDate).getTime();
    assertEquals('N', actualArchived.charValue());
  }

  /**
   * Test {@link CategoryImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    categoryImpl.setArchived('A');

    // Assert
    assertEquals('A', categoryImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', categoryImpl.getArchived().charValue());
  }

  /**
   * Test {@link CategoryImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    categoryImpl.setArchived('A');

    // Assert
    verify(activeStartDate).getTime();
    assertEquals('A', categoryImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', categoryImpl.getArchived().charValue());
  }

  /**
   * Test {@link CategoryImpl#equals(Object)}, and
   * {@link CategoryImpl#hashCode()}.
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
   * Test {@link CategoryImpl#equals(Object)}, and
   * {@link CategoryImpl#hashCode()}.
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
    categoryImpl.setDefaultParentCategory(mock(Category.class));
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
   * Test {@link CategoryImpl#equals(Object)}, and
   * {@link CategoryImpl#hashCode()}.
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
   * Test {@link CategoryImpl#equals(Object)}, and
   * {@link CategoryImpl#hashCode()}.
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
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
   * Test {@link CategoryImpl#equals(Object)}, and
   * {@link CategoryImpl#hashCode()}.
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
   * Test
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Category> actualCreateOrRetrieveCopyInstanceResult = categoryImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then Clone return {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenJavaLangObject_thenCloneReturnCategoryImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<Category> actualCreateOrRetrieveCopyInstanceResult = categoryImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.CategoryImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    Category clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CategoryImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(categoryImpl, clone);
  }

  /**
   * Test
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

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
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(categoryImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    categoryImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

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
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(categoryImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    categoryImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone3() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

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
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(categoryImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    categoryImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse, atLeast(1)).getClone();
    verify(createResponse, atLeast(1)).isAlreadyPopulated();
    verify(context, atLeast(1)).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test {@link CategoryImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getMainEntityName());
  }

  /**
   * Test {@link CategoryImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link Date} {@link java.util.Date#getTime()} return ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeStartDate = mock(java.sql.Date.class);
    when(activeStartDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(activeStartDate);

    // Act
    String actualMainEntityName = categoryImpl.getMainEntityName();

    // Assert
    verify(activeStartDate).getTime();
    assertNull(actualMainEntityName);
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
  public void testGetLocation_givenCategoryImplUrlIsColon_thenReturnColon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl(":");

    // Act and Assert
    assertEquals(":", categoryImpl.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is empty
   * string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenCategoryImplUrlIsEmptyString_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl("");

    // Act and Assert
    assertEquals("", categoryImpl.getLocation());
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
  public void testGetLocation_givenCategoryImplUrlIsFoo_thenReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl("foo");

    // Act and Assert
    assertEquals("/foo", categoryImpl.getLocation());
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
  public void testGetLocation_givenCategoryImplUrlIsQuestionMark_thenReturnQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl("?");

    // Act and Assert
    assertEquals("?", categoryImpl.getLocation());
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
  public void testGetLocation_givenCategoryImplUrlIsSlash_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl("/");

    // Act and Assert
    assertEquals("/", categoryImpl.getLocation());
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
  public void testGetLocation_givenCategoryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenDateGetTimeReturnTen_thenCallsGetTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    java.sql.Date activeEndDate = mock(java.sql.Date.class);
    when(activeEndDate.getTime()).thenReturn(10L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(activeEndDate);
    categoryImpl.setActiveStartDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    categoryImpl.setUrlKey("https://example.org/example");
    categoryImpl.setUrl("");

    // Act
    String actualLocation = categoryImpl.getLocation();

    // Assert
    verify(activeEndDate).getTime();
    assertEquals("", actualLocation);
  }

  /**
   * Test new {@link CategoryImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CategoryImpl}
   */
  @Test
  public void testNewCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CategoryImpl actualCategoryImpl = new CategoryImpl();

    // Assert
    assertEquals("null", actualCategoryImpl.getGeneratedUrl());
    assertEquals('N', actualCategoryImpl.archiveStatus.getArchived().charValue());
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
