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
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class CategoryImplDiffblueTest {
  /**
   * Method under test: {@link CategoryImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getName());
  }

  /**
   * Method under test: {@link CategoryImpl#getName()}
   */
  @Test
  public void testGetName2() {
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
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  public void testGetUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  public void testGetUrl2() {
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
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  public void testGetUrl3() {
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
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  public void testGetUrl4() {
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
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  public void testGetUrl5() {
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
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  public void testGetUrl6() {
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
   * Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  public void testGetUrl7() {
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
   * Method under test: {@link CategoryImpl#getOverrideGeneratedUrl()}
   */
  @Test
  public void testGetOverrideGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).getOverrideGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getOverrideGeneratedUrl()}
   */
  @Test
  public void testGetOverrideGeneratedUrl2() {
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
   * Method under test: {@link CategoryImpl#getOverrideGeneratedUrl()}
   */
  @Test
  public void testGetOverrideGeneratedUrl3() {
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
   * Method under test: {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedUrl() {
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
   * Method under test: {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedUrl2() {
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
   * Method under test: {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedUrl3() {
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
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getUrlKey());
  }

  /**
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey2() {
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
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey3() {
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
   * Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  public void testGetUrlKey4() {
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
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("null", (new CategoryImpl()).getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl2() {
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
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Name");

    // Act and Assert
    assertEquals("name", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" ");

    // Act and Assert
    assertEquals("-", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("UU UU");

    // Act and Assert
    assertEquals("uU-UU", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(".*?\\W.*?");

    // Act and Assert
    assertEquals("w", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("/");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(":");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("?");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl11() {
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
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl12() {
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
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.lang.String");

    // Act and Assert
    assertEquals("javalangString", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.util.List");

    // Act and Assert
    assertEquals("javautilList", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.util.Map$Entry");

    // Act and Assert
    assertEquals("javautilMapEntry", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("org.broadleafcommerce.common.media.domain.Media");

    // Act and Assert
    assertEquals("orgbroadleafcommercecommonmediadomainMedia", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("  ");

    // Act and Assert
    assertEquals("--", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl18() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("org.broadleafcommerce.core.catalog.domain.Category");

    // Act and Assert
    assertEquals("orgbroadleafcommercecorecatalogdomainCategory", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl19() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" UU UU");

    // Act and Assert
    assertEquals("-UU-UU", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  public void testGetGeneratedUrl20() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("org.broadleafcommerce.core.catalog.domain.CategoryAttribute");

    // Act and Assert
    assertEquals("orgbroadleafcommercecorecatalogdomainCategoryAttribute", categoryImpl.getGeneratedUrl());
  }

  /**
   * Method under test: {@link CategoryImpl#getDescription()}
   */
  @Test
  public void testGetDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getDescription());
  }

  /**
   * Method under test: {@link CategoryImpl#getDescription()}
   */
  @Test
  public void testGetDescription2() {
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
   * Method under test: {@link CategoryImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getActiveStartDate());
  }

  /**
   * Method under test: {@link CategoryImpl#getActiveStartDate()}
   */
  @Test
  public void testGetActiveStartDate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setArchived('Y');

    // Act and Assert
    assertNull(categoryImpl.getActiveStartDate());
  }

  /**
   * Method under test: {@link CategoryImpl#setActiveStartDate(Date)}
   */
  @Test
  public void testSetActiveStartDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    categoryImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    Date expectedActiveStartDate = categoryImpl.activeStartDate;
    assertSame(expectedActiveStartDate, categoryImpl.getActiveStartDate());
  }

  /**
   * Method under test: {@link CategoryImpl#setActiveStartDate(Date)}
   */
  @Test
  public void testSetActiveStartDate2() {
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
   * Method under test: {@link CategoryImpl#setActiveStartDate(java.util.Date)}
   */
  @Test
  public void testSetActiveStartDate3() {
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
    java.util.Date activeStartDate2 = categoryImpl.getActiveStartDate();
    assertEquals("1970-01-01", simpleDateFormat.format(activeStartDate2));
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(categoryImpl.activeStartDate));
    assertSame(categoryImpl.activeStartDate, activeStartDate2);
  }

  /**
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
   * Method under test: {@link CategoryImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).isActive());
  }

  /**
   * Method under test: {@link CategoryImpl#isActive()}
   */
  @Test
  public void testIsActive2() {
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
   * Method under test: {@link CategoryImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getLongDescription());
  }

  /**
   * Method under test: {@link CategoryImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription2() {
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
   * Method under test: {@link CategoryImpl#getDefaultParentCategory()}
   */
  @Test
  public void testGetDefaultParentCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertNull(categoryImpl.getDefaultParentCategory());
    assertNull(categoryImpl.defaultParentCategory);
  }

  /**
   * Method under test: {@link CategoryImpl#getDefaultParentCategory()}
   */
  @Test
  public void testGetDefaultParentCategory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    Category category = categoryImpl.defaultParentCategory;
    assertTrue(category instanceof CategoryImpl);
    assertEquals(categoryImpl, category);
    assertSame(defaultParentCategory, categoryImpl.getDefaultParentCategory());
  }

  /**
   * Method under test: {@link CategoryImpl#getDefaultParentCategory()}
   */
  @Test
  public void testGetDefaultParentCategory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(mock(Category.class));

    // Act and Assert
    assertSame(categoryImpl.defaultParentCategory, categoryImpl.getDefaultParentCategory());
  }

  /**
   * Method under test: {@link CategoryImpl#getParentCategory()}
   */
  @Test
  public void testGetParentCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getParentCategory());
  }

  /**
   * Method under test: {@link CategoryImpl#getParentCategory()}
   */
  @Test
  public void testGetParentCategory2() {
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
   * Method under test: {@link CategoryImpl#getParentCategoryXref()}
   */
  @Test
  public void testGetParentCategoryXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getParentCategoryXref());
  }

  /**
   * Method under test: {@link CategoryImpl#getParentCategoryXref()}
   */
  @Test
  public void testGetParentCategoryXref2() {
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
   * Method under test: {@link CategoryImpl#setParentCategory(Category)}
   */
  @Test
  public void testSetParentCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    categoryImpl.setParentCategory(category);

    // Assert
    assertEquals(categoryImpl, category);
  }

  /**
   * Method under test: {@link CategoryImpl#setParentCategory(Category)}
   */
  @Test
  public void testSetParentCategory2() {
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
   * Method under test: {@link CategoryImpl#setParentCategory(Category)}
   */
  @Test
  public void testSetParentCategory3() {
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
   * Method under test: {@link CategoryImpl#getChildCategoryXrefs()}
   */
  @Test
  public void testGetChildCategoryXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getChildCategoryXrefs().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryXrefs()}
   */
  @Test
  public void testGetChildCategoryXrefs2() {
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
   * Method under test: {@link CategoryImpl#setAllChildCategoryXrefs(List)}
   */
  @Test
  public void testSetAllChildCategoryXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    ArrayList<CategoryXref> childCategories = new ArrayList<>();

    // Act
    categoryImpl.setAllChildCategoryXrefs(childCategories);

    // Assert
    assertNull(categoryImpl.getDefaultParentCategory());
    assertNull(categoryImpl.defaultParentCategory);
    assertFalse(categoryImpl.hasAllChildCategories());
    assertTrue(childCategories.isEmpty());
    assertTrue(categoryImpl.getActiveProductXrefs().isEmpty());
    assertTrue(categoryImpl.getActiveProducts().isEmpty());
    assertTrue(categoryImpl.getAllChildCategories().isEmpty());
    assertTrue(categoryImpl.getAllChildCategoryXrefs().isEmpty());
    assertTrue(categoryImpl.getAllParentCategories().isEmpty());
    assertTrue(categoryImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(categoryImpl.getAllProductXrefs().isEmpty());
    assertTrue(categoryImpl.getAllProducts().isEmpty());
    assertTrue(categoryImpl.getCategoryAttributes().isEmpty());
    assertTrue(categoryImpl.getChildCategories().isEmpty());
    assertTrue(categoryImpl.getChildCategoryXrefs().isEmpty());
    assertTrue(categoryImpl.getCrossSaleProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(categoryImpl.getExcludedSearchFacets().isEmpty());
    assertTrue(categoryImpl.getFeaturedProducts().isEmpty());
    assertTrue(categoryImpl.getSearchFacets().isEmpty());
    assertTrue(categoryImpl.getUpSaleProducts().isEmpty());
    assertTrue(categoryImpl.allLegacyChildCategories.isEmpty());
    assertTrue(categoryImpl.childCategoryXrefs.isEmpty());
    assertTrue(categoryImpl.legacyChildCategories.isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#setAllChildCategoryXrefs(List)}
   */
  @Test
  public void testSetAllChildCategoryXrefs2() {
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
    CategoryImpl defaultParentCategory = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    categoryImpl.setDescription("The characteristics of someone or something");
    categoryImpl.setDisplayTemplate("Display Template");
    ArrayList<CategoryExcludedSearchFacet> excludedSearchFacets = new ArrayList<>();
    categoryImpl.setExcludedSearchFacets(excludedSearchFacets);
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
    ArrayList<CategorySearchFacet> searchFacets = new ArrayList<>();
    categoryImpl.setSearchFacets(searchFacets);
    categoryImpl.setTaxCode("Tax Code");
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    categoryImpl.setUpSaleProducts(upSaleProducts);
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    ArrayList<CategoryXref> childCategories = new ArrayList<>();
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    childCategories.add(categoryXrefImpl);

    // Act
    categoryImpl.setAllChildCategoryXrefs(childCategories);

    // Assert
    Category category = categoryImpl.defaultParentCategory;
    assertTrue(category instanceof CategoryImpl);
    assertEquals(1, childCategories.size());
    assertEquals(1, categoryImpl.getAllChildCategories().size());
    assertEquals(1, categoryImpl.allLegacyChildCategories.size());
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(categoryImpl.getActiveProductXrefs().isEmpty());
    assertTrue(categoryImpl.getActiveProducts().isEmpty());
    assertTrue(categoryImpl.getAllParentCategories().isEmpty());
    assertTrue(categoryImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(categoryImpl.getAllProductXrefs().isEmpty());
    assertTrue(categoryImpl.getAllProducts().isEmpty());
    assertTrue(categoryImpl.getCategoryAttributes().isEmpty());
    assertTrue(categoryImpl.getChildCategories().isEmpty());
    assertTrue(categoryImpl.getChildCategoryXrefs().isEmpty());
    assertTrue(categoryImpl.getCrossSaleProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
    List<CategoryExcludedSearchFacet> excludedSearchFacets2 = categoryImpl.getExcludedSearchFacets();
    assertTrue(excludedSearchFacets2.isEmpty());
    assertTrue(categoryImpl.getFeaturedProducts().isEmpty());
    List<CategorySearchFacet> searchFacets2 = categoryImpl.getSearchFacets();
    assertTrue(searchFacets2.isEmpty());
    List<RelatedProduct> upSaleProducts2 = categoryImpl.getUpSaleProducts();
    assertTrue(upSaleProducts2.isEmpty());
    assertTrue(categoryImpl.childCategoryXrefs.isEmpty());
    assertTrue(categoryImpl.legacyChildCategories.isEmpty());
    assertTrue(categoryImpl.hasAllChildCategories());
    assertEquals(childCategories, categoryImpl.getAllChildCategoryXrefs());
    assertSame(excludedSearchFacets, excludedSearchFacets2);
    assertSame(searchFacets, searchFacets2);
    assertSame(upSaleProducts, upSaleProducts2);
    assertSame(defaultParentCategory, categoryImpl.getDefaultParentCategory());
    assertSame(categoryXrefImpl, childCategories.get(0));
  }

  /**
   * Method under test: {@link CategoryImpl#setAllChildCategoryXrefs(List)}
   */
  @Test
  public void testSetAllChildCategoryXrefs3() {
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
    ArrayList<CategoryExcludedSearchFacet> excludedSearchFacets = new ArrayList<>();
    categoryImpl.setExcludedSearchFacets(excludedSearchFacets);
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
    ArrayList<CategorySearchFacet> searchFacets = new ArrayList<>();
    categoryImpl.setSearchFacets(searchFacets);
    categoryImpl.setTaxCode("Tax Code");
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    categoryImpl.setUpSaleProducts(upSaleProducts);
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("https://example.org/example");

    ArrayList<CategoryXref> childCategories = new ArrayList<>();
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    childCategories.add(categoryXrefImpl);

    // Act
    categoryImpl.setAllChildCategoryXrefs(childCategories);

    // Assert
    assertEquals(1, childCategories.size());
    assertEquals(1, categoryImpl.getAllChildCategories().size());
    assertEquals(1, categoryImpl.allLegacyChildCategories.size());
    assertTrue(categoryImpl.getActiveProductXrefs().isEmpty());
    assertTrue(categoryImpl.getActiveProducts().isEmpty());
    assertTrue(categoryImpl.getAllParentCategories().isEmpty());
    assertTrue(categoryImpl.getAllParentCategoryXrefs().isEmpty());
    assertTrue(categoryImpl.getAllProductXrefs().isEmpty());
    assertTrue(categoryImpl.getAllProducts().isEmpty());
    assertTrue(categoryImpl.getCategoryAttributes().isEmpty());
    assertTrue(categoryImpl.getChildCategories().isEmpty());
    assertTrue(categoryImpl.getChildCategoryXrefs().isEmpty());
    assertTrue(categoryImpl.getCrossSaleProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
    List<CategoryExcludedSearchFacet> excludedSearchFacets2 = categoryImpl.getExcludedSearchFacets();
    assertTrue(excludedSearchFacets2.isEmpty());
    assertTrue(categoryImpl.getFeaturedProducts().isEmpty());
    List<CategorySearchFacet> searchFacets2 = categoryImpl.getSearchFacets();
    assertTrue(searchFacets2.isEmpty());
    List<RelatedProduct> upSaleProducts2 = categoryImpl.getUpSaleProducts();
    assertTrue(upSaleProducts2.isEmpty());
    assertTrue(categoryImpl.childCategoryXrefs.isEmpty());
    assertTrue(categoryImpl.legacyChildCategories.isEmpty());
    assertTrue(categoryImpl.hasAllChildCategories());
    assertEquals(childCategories, categoryImpl.getAllChildCategoryXrefs());
    assertSame(excludedSearchFacets, excludedSearchFacets2);
    assertSame(searchFacets, searchFacets2);
    assertSame(upSaleProducts, upSaleProducts2);
    assertSame(categoryXrefImpl, childCategories.get(0));
    Category expectedDefaultParentCategory = categoryImpl.defaultParentCategory;
    assertSame(expectedDefaultParentCategory, categoryImpl.getDefaultParentCategory());
  }

  /**
   * Method under test: {@link CategoryImpl#getAllChildCategories()}
   */
  @Test
  public void testGetAllChildCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getAllChildCategories().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getAllChildCategories()}
   */
  @Test
  public void testGetAllChildCategories2() {
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
   * Method under test: {@link CategoryImpl#hasAllChildCategories()}
   */
  @Test
  public void testHasAllChildCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).hasAllChildCategories());
  }

  /**
   * Method under test: {@link CategoryImpl#hasAllChildCategories()}
   */
  @Test
  public void testHasAllChildCategories2() {
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
   * Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  public void testSetAllChildCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllChildCategories(new ArrayList<>()));
  }

  /**
   * Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  public void testSetAllChildCategories2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllChildCategories(childCategories));
  }

  /**
   * Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  public void testSetAllChildCategories3() {
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
   * Method under test: {@link CategoryImpl#getChildCategories()}
   */
  @Test
  public void testGetChildCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getChildCategories().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategories()}
   */
  @Test
  public void testGetChildCategories2() {
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
   * Method under test: {@link CategoryImpl#hasChildCategories()}
   */
  @Test
  public void testHasChildCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CategoryImpl()).hasChildCategories());
  }

  /**
   * Method under test: {@link CategoryImpl#hasChildCategories()}
   */
  @Test
  public void testHasChildCategories2() {
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
   * Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  public void testSetChildCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setChildCategories(new ArrayList<>()));
  }

  /**
   * Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  public void testSetChildCategories2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setChildCategories(childCategories));
  }

  /**
   * Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  public void testSetChildCategories3() {
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
    ArrayList<Long> childCategoryIds = new ArrayList<>();
    categoryImpl.setChildCategoryIds(childCategoryIds);

    // Act
    List<Long> actualChildCategoryIds = categoryImpl.getChildCategoryIds();

    // Assert
    assertTrue(actualChildCategoryIds.isEmpty());
    assertSame(childCategoryIds, actualChildCategoryIds);
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryIds()}
   */
  @Test
  public void testGetChildCategoryIds2() {
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
    ArrayList<Long> childCategoryIds = new ArrayList<>();
    categoryImpl.setChildCategoryIds(childCategoryIds);

    // Act
    List<Long> actualChildCategoryIds = categoryImpl.getChildCategoryIds();

    // Assert
    verify(activeEndDate).getTime();
    assertTrue(actualChildCategoryIds.isEmpty());
    assertSame(childCategoryIds, actualChildCategoryIds);
  }

  /**
   * Method under test: {@link CategoryImpl#createChildCategoryIds()}
   */
  @Test
  public void testCreateChildCategoryIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act
    List<Long> actualCreateChildCategoryIdsResult = categoryImpl.createChildCategoryIds();

    // Assert
    assertTrue(actualCreateChildCategoryIdsResult.isEmpty());
    assertTrue(categoryImpl.childCategoryIds.isEmpty());
    List<Long> resultLongList = categoryImpl.childCategoryIds;
    assertSame(resultLongList, actualCreateChildCategoryIdsResult);
    assertSame(resultLongList, categoryImpl.getChildCategoryIds());
  }

  /**
   * Method under test: {@link CategoryImpl#createChildCategoryIds()}
   */
  @Test
  public void testCreateChildCategoryIds2() {
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
    List<Long> resultLongList = categoryImpl.childCategoryIds;
    assertSame(resultLongList, actualCreateChildCategoryIdsResult);
    assertSame(resultLongList, categoryImpl.getChildCategoryIds());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new CategoryImpl()).getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap2() {
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
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap3() {
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
    HashMap<String, List<Long>> childCategoryURLMap = new HashMap<>();
    categoryImpl.setChildCategoryURLMap(childCategoryURLMap);

    // Act
    Map<String, List<Long>> actualChildCategoryURLMap = categoryImpl.getChildCategoryURLMap();

    // Assert
    assertTrue(actualChildCategoryURLMap.isEmpty());
    assertSame(childCategoryURLMap, actualChildCategoryURLMap);
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Cannot create childCategoryURLMap - the urlKey for a category(");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" ");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("UU UU");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(".*?\\W.*?");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("[^\\w-]+");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Name");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("/");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("cannot-create-childCategoryURLMap---the-urlKey-for-a-category");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(":");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("?");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap15() {
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
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap16() {
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
   * Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  public void testGetChildCategoryURLMap17() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new CategoryImpl()).createChildCategoryURLMap());
  }

  /**
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap2() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap3() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap4() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap5() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap6() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap7() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap8() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap9() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap10() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap11() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap12() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap13() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap14() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap15() {
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
   * Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  public void testCreateChildCategoryURLMap16() {
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
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualParentCategoryHierarchy.isEmpty());
    assertSame(currentPath, actualParentCategoryHierarchy);
  }

  /**
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchy2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertSame(currentPath, actualParentCategoryHierarchy);
    assertSame(categoryImpl2, currentPath.get(0));
  }

  /**
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchy3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);
    currentPath.add(new CategoryImpl());

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(2, currentPath.size());
    assertSame(currentPath, actualParentCategoryHierarchy);
    assertSame(categoryImpl2, currentPath.get(0));
  }

  /**
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchy4() {
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
    assertSame(currentPath, actualParentCategoryHierarchy);
    assertSame(defaultParentCategory, currentPath.get(0));
  }

  /**
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchy5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(mock(Category.class));

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    assertSame(currentPath, actualParentCategoryHierarchy);
  }

  /**
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchy6() {
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
    assertSame(currentPath, actualParentCategoryHierarchy);
    Category category = categoryImpl.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  public void testGetParentCategoryHierarchy7() {
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
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchy8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualParentCategoryHierarchy.isEmpty());
    assertSame(currentPath, actualParentCategoryHierarchy);
  }

  /**
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchy9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(1, currentPath.size());
    assertSame(currentPath, actualParentCategoryHierarchy);
    assertSame(categoryImpl2, currentPath.get(0));
  }

  /**
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchy10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);
    currentPath.add(new CategoryImpl());

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(2, currentPath.size());
    assertSame(currentPath, actualParentCategoryHierarchy);
    assertSame(categoryImpl2, currentPath.get(0));
  }

  /**
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchy11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    ArrayList<Category> currentPath = new ArrayList<>();

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, null);

    // Assert
    assertTrue(currentPath.isEmpty());
    assertTrue(actualParentCategoryHierarchy.isEmpty());
    assertSame(currentPath, actualParentCategoryHierarchy);
  }

  /**
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchy12() {
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
    assertSame(currentPath, actualParentCategoryHierarchy);
    assertSame(defaultParentCategory, currentPath.get(0));
  }

  /**
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchy13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(mock(Category.class));

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(1, currentPath.size());
    assertEquals(1, actualParentCategoryHierarchy.size());
    assertSame(currentPath, actualParentCategoryHierarchy);
  }

  /**
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchy14() {
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
    assertSame(currentPath, actualParentCategoryHierarchy);
    Category category = categoryImpl.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchy15() {
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
    assertSame(currentPath, actualParentCategoryHierarchy);
    Category category = categoryImpl.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualParentCategoryHierarchy.get(0));
  }

  /**
   * Method under test:
   * {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  public void testGetParentCategoryHierarchy16() {
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
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath() {
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
    assertSame(currentPath, actualBuildDefaultParentCategoryPathResult);
  }

  /**
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath2() {
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
    assertEquals(1, currentPath.size());
    assertSame(currentPath, actualBuildDefaultParentCategoryPathResult);
    assertSame(categoryImpl2, currentPath.get(0));
  }

  /**
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> currentPath = new ArrayList<>();
    CategoryImpl categoryImpl2 = new CategoryImpl();
    currentPath.add(categoryImpl2);
    currentPath.add(new CategoryImpl());

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult = categoryImpl
        .buildDefaultParentCategoryPath(currentPath);

    // Assert
    assertEquals(2, currentPath.size());
    assertSame(currentPath, actualBuildDefaultParentCategoryPathResult);
    assertSame(categoryImpl2, currentPath.get(0));
  }

  /**
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath4() {
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
    assertSame(currentPath, actualBuildDefaultParentCategoryPathResult);
    assertSame(defaultParentCategory, currentPath.get(0));
  }

  /**
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath5() {
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
    assertEquals(1, actualBuildDefaultParentCategoryPathResult.size());
    assertSame(currentPath, actualBuildDefaultParentCategoryPathResult);
  }

  /**
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath6() {
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
    assertSame(currentPath, actualBuildDefaultParentCategoryPathResult);
    Category category = categoryImpl.defaultParentCategory;
    assertSame(category, currentPath.get(0));
    assertSame(category, actualBuildDefaultParentCategoryPathResult.get(0));
  }

  /**
   * Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  public void testBuildDefaultParentCategoryPath7() {
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
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs() {
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
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<CategoryXref> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryXrefImpl());

    // Act
    categoryImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    assertEquals(1, categoryImpl.getAllParentCategories().size());
    assertEquals(allParentCategories, categoryImpl.getAllParentCategoryXrefs());
  }

  /**
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<CategoryXref> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryXrefImpl());
    allParentCategories.add(new CategoryXrefImpl());

    // Act
    categoryImpl.setAllParentCategoryXrefs(allParentCategories);

    // Assert
    assertEquals(2, categoryImpl.getAllParentCategories().size());
    assertEquals(allParentCategories, categoryImpl.getAllParentCategoryXrefs());
  }

  /**
   * Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  public void testSetAllParentCategoryXrefs4() {
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
   * Method under test: {@link CategoryImpl#getAllParentCategories()}
   */
  @Test
  public void testGetAllParentCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getAllParentCategories().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getAllParentCategories()}
   */
  @Test
  public void testGetAllParentCategories2() {
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
   * Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllParentCategories(new ArrayList<>()));
  }

  /**
   * Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllParentCategories(allParentCategories));
  }

  /**
   * Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  public void testSetAllParentCategories3() {
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
   * Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  public void testSetFeaturedProducts() {
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
   * Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  public void testSetFeaturedProducts2() {
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
   * Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  public void testSetFeaturedProducts3() {
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
   * Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  public void testSetCrossSaleProducts() {
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
   * Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  public void testSetCrossSaleProducts2() {
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
   * Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  public void testSetCrossSaleProducts3() {
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
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts3() {
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
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts4() {
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
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts5() {
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
    assertEquals(relatedProductList, actualCumulativeCrossSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts6() {
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
    assertEquals(relatedProductList, actualCumulativeCrossSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts7() {
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
    assertEquals(relatedProductList, actualCumulativeCrossSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts8() {
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
    assertEquals(relatedProductList, actualCumulativeCrossSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts9() {
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
    assertEquals(relatedProductList, actualCumulativeCrossSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts10() {
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
    assertEquals(relatedProductList, actualCumulativeCrossSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts11() {
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
    assertEquals(relatedProductList, actualCumulativeCrossSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts12() {
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
    assertEquals(relatedProductList, actualCumulativeCrossSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  public void testGetCumulativeCrossSaleProducts13() {
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
    crossSaleProductImpl.setCategory(new CategoryImpl());

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
    assertEquals(relatedProductList, actualCumulativeCrossSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts3() {
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
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts4() {
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
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts5() {
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
    assertEquals(relatedProductList, actualCumulativeUpSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts6() {
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
    assertEquals(relatedProductList, actualCumulativeUpSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts7() {
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
    assertEquals(relatedProductList, actualCumulativeUpSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts8() {
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
    assertEquals(relatedProductList, actualCumulativeUpSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts9() {
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
    assertEquals(relatedProductList, actualCumulativeUpSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts10() {
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
    assertEquals(relatedProductList, actualCumulativeUpSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts11() {
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
    assertEquals(relatedProductList, actualCumulativeUpSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts12() {
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
    assertEquals(relatedProductList, actualCumulativeUpSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  public void testGetCumulativeUpSaleProducts13() {
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
    crossSaleProductImpl.setCategory(new CategoryImpl());

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
    assertEquals(relatedProductList, actualCumulativeUpSaleProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeFeaturedProducts().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts3() {
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
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
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
    assertEquals(featuredProductList, actualCumulativeFeaturedProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts5() {
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
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts6() {
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
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(null);
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
    assertEquals(featuredProductList, actualCumulativeFeaturedProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FeaturedProductImpl featuredProductImpl = mock(FeaturedProductImpl.class);
    when(featuredProductImpl.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
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
    verify(featuredProductImpl).getSequence();
    assertEquals(featuredProductList, actualCumulativeFeaturedProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts9() {
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
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts10() {
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
   * Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  public void testGetCumulativeFeaturedProducts11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FeaturedProduct featuredProduct = mock(FeaturedProduct.class);
    when(featuredProduct.getSequence()).thenReturn(new BigDecimal("2.3"));
    FeaturedProductImpl featuredProductImpl = mock(FeaturedProductImpl.class);
    when(featuredProductImpl.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(new FeaturedProductImpl());
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
    assertEquals(featuredProductList, actualCumulativeFeaturedProducts);
  }

  /**
   * Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  public void testSetUpSaleProducts() {
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
   * Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  public void testSetUpSaleProducts2() {
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
    assertEquals(1, upSaleProducts2.size());
    assertEquals(upSaleProducts, categoryImpl.getCumulativeUpSaleProducts());
    assertSame(upSaleProducts2, categoryImpl.getUpSaleProducts());
  }

  /**
   * Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  public void testSetUpSaleProducts3() {
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
    assertEquals(1, upSaleProducts2.size());
    assertEquals(upSaleProducts, categoryImpl.getCumulativeUpSaleProducts());
    assertSame(upSaleProducts2, categoryImpl.getUpSaleProducts());
  }

  /**
   * Method under test: {@link CategoryImpl#getActiveProductXrefs()}
   */
  @Test
  public void testGetActiveProductXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getActiveProductXrefs().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getActiveProductXrefs()}
   */
  @Test
  public void testGetActiveProductXrefs2() {
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
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  public void testSetAllProductXrefs() {
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
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  public void testSetAllProductXrefs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<CategoryProductXref> allProducts = new ArrayList<>();
    allProducts.add(new CategoryProductXrefImpl());

    // Act
    categoryImpl.setAllProductXrefs(allProducts);

    // Assert
    assertEquals(1, categoryImpl.getAllProducts().size());
    assertEquals(allProducts, categoryImpl.getAllProductXrefs());
  }

  /**
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  public void testSetAllProductXrefs3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<CategoryProductXref> allProducts = new ArrayList<>();
    allProducts.add(new CategoryProductXrefImpl());
    allProducts.add(new CategoryProductXrefImpl());

    // Act
    categoryImpl.setAllProductXrefs(allProducts);

    // Assert
    assertEquals(2, categoryImpl.getAllProducts().size());
    assertEquals(allProducts, categoryImpl.getAllProductXrefs());
  }

  /**
   * Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  public void testSetAllProductXrefs4() {
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
   * Method under test: {@link CategoryImpl#getActiveProducts()}
   */
  @Test
  public void testGetActiveProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getActiveProducts().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getActiveProducts()}
   */
  @Test
  public void testGetActiveProducts2() {
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
   * Method under test: {@link CategoryImpl#getAllProducts()}
   */
  @Test
  public void testGetAllProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getAllProducts().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getAllProducts()}
   */
  @Test
  public void testGetAllProducts2() {
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
   * Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  public void testSetAllProducts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllProducts(new ArrayList<>()));
  }

  /**
   * Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  public void testSetAllProducts2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<Product> allProducts = new ArrayList<>();
    allProducts.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> categoryImpl.setAllProducts(allProducts));
  }

  /**
   * Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  public void testSetAllProducts3() {
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
   * Method under test: {@link CategoryImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getInventoryType());
  }

  /**
   * Method under test: {@link CategoryImpl#getInventoryType()}
   */
  @Test
  public void testGetInventoryType2() {
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
   * Method under test: {@link CategoryImpl#setInventoryType(InventoryType)}
   */
  @Test
  public void testSetInventoryType() {
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
   * Method under test: {@link CategoryImpl#setInventoryType(InventoryType)}
   */
  @Test
  public void testSetInventoryType2() {
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
   * Method under test: {@link CategoryImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getFulfillmentType());
  }

  /**
   * Method under test: {@link CategoryImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType2() {
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
   * Method under test: {@link CategoryImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType3() {
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
   * Method under test: {@link CategoryImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  public void testSetFulfillmentType() {
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
   * Method under test: {@link CategoryImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  public void testSetFulfillmentType2() {
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
   * Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  public void testGetParentFacets() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    // Act and Assert
    assertNull(categoryImpl.getParentFacets(new ArrayList<>()));
  }

  /**
   * Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  public void testGetParentFacets2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<SearchFacet> facets = new ArrayList<>();
    facets.add(new SearchFacetImpl());

    // Act and Assert
    assertNull(categoryImpl.getParentFacets(facets));
  }

  /**
   * Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  public void testGetParentFacets3() {
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
   * Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  public void testGetParentFacets4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<SearchFacet> facets = new ArrayList<>();
    facets.add(mock(SearchFacetImpl.class));

    // Act and Assert
    assertNull(categoryImpl.getParentFacets(facets));
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Name");

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setUrl("https://example.org/example");

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets5() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets6() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets7() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets8() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  public void testGetCumulativeSearchFacets9() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets10() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets11() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets12() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets13() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets14() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets15() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets16() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets17() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets18() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<CategorySearchFacet> categorySearchFacetList = new ArrayList<>();
    categorySearchFacetList.add(new CategorySearchFacetImpl());
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(categorySearchFacetList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(1, categoryHierarchy.size());
    assertEquals(categorySearchFacetList, actualCumulativeSearchFacets);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets19() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets20() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets21() {
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
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets22() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any())).thenReturn(new ArrayList<>());

    ArrayList<CategorySearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new CategorySearchFacetImpl());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setSearchFacets(searchFacets);
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(1, categoryHierarchy.size());
    assertEquals(searchFacets, actualCumulativeSearchFacets);
  }

  /**
   * Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  public void testGetCumulativeSearchFacets23() {
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
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets = categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(1, categoryHierarchy.size());
    assertEquals(searchFacets, actualCumulativeSearchFacets);
  }

  /**
   * Method under test: {@link CategoryImpl#getCategoryMedia()}
   */
  @Test
  public void testGetCategoryMedia() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCategoryMedia().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCategoryMedia()}
   */
  @Test
  public void testGetCategoryMedia2() {
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
   * Method under test: {@link CategoryImpl#setCategoryMedia(Map)}
   */
  @Test
  public void testSetCategoryMedia() {
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
    assertTrue(categoryImpl.getMappedCategoryAttributes().isEmpty());
    assertTrue(categoryImpl.getMultiValueCategoryAttributes().isEmpty());
    assertTrue(categoryImpl.legacyCategoryMedia.isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  public void testGetCategoryAttributesMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getCategoryAttributesMap().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  public void testGetCategoryAttributesMap2() {
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
   * Method under test: {@link CategoryImpl#setCategoryAttributesMap(Map)}
   */
  @Test
  public void testSetCategoryAttributesMap() {
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
   * Method under test: {@link CategoryImpl#setCategoryAttributesMap(Map)}
   */
  @Test
  public void testSetCategoryAttributesMap2() {
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
   * Method under test: {@link CategoryImpl#setCategoryAttributesMap(Map)}
   */
  @Test
  public void testSetCategoryAttributesMap3() {
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
   * Method under test: {@link CategoryImpl#getCategoryAttributeByName(String)}
   */
  @Test
  public void testGetCategoryAttributeByName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getCategoryAttributeByName("Name"));
  }

  /**
   * Method under test: {@link CategoryImpl#getCategoryAttributeByName(String)}
   */
  @Test
  public void testGetCategoryAttributeByName2() {
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
   * Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  public void testGetMappedCategoryAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getMappedCategoryAttributes().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  public void testGetMappedCategoryAttributes2() {
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
   * Method under test: {@link CategoryImpl#getMultiValueCategoryAttributes()}
   */
  @Test
  public void testGetMultiValueCategoryAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CategoryImpl()).getMultiValueCategoryAttributes().isEmpty());
  }

  /**
   * Method under test: {@link CategoryImpl#getMultiValueCategoryAttributes()}
   */
  @Test
  public void testGetMultiValueCategoryAttributes2() {
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
   * Method under test: {@link CategoryImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new CategoryImpl()).getArchived().charValue());
  }

  /**
   * Method under test: {@link CategoryImpl#getArchived()}
   */
  @Test
  public void testGetArchived2() {
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
   * Method under test: {@link CategoryImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
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
   * Method under test: {@link CategoryImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived2() {
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
   * Method under test:
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
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
   * Method under test:
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
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
   * Method under test:
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
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
   * Method under test:
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
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
   * Method under test:
   * {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance5() throws CloneNotSupportedException {
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
   * Method under test: {@link CategoryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getMainEntityName());
  }

  /**
   * Method under test: {@link CategoryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName2() {
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
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  public void testGetLocation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryImpl()).getLocation());
  }

  /**
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  public void testGetLocation2() {
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
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  public void testGetLocation3() {
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
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  public void testGetLocation4() {
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
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  public void testGetLocation5() {
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
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  public void testGetLocation6() {
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
   * Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  public void testGetLocation7() {
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
