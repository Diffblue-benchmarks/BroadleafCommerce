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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.search.domain.CategoryExcludedSearchFacet;
import org.broadleafcommerce.core.search.domain.CategorySearchFacet;
import org.broadleafcommerce.core.search.domain.CategorySearchFacetImpl;
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

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryImplDiffblueTest {
  @Autowired private CategoryImpl categoryImpl;

  /**
   * Test {@link CategoryImpl#getName()}.
   *
   * <p>Method under test: {@link CategoryImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getName());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Url is {@code :}.
   *   <li>Then return {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplUrlIsColon_thenReturnColon() {
    // Arrange
    categoryImpl.setUrl(":");

    // Act and Assert
    assertEquals(":", categoryImpl.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Url is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplUrlIsEmptyString_thenReturnEmptyString() {
    // Arrange
    categoryImpl.setUrl("");

    // Act and Assert
    assertEquals("", categoryImpl.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Url is {@code foo}.
   *   <li>Then return {@code /foo}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplUrlIsFoo_thenReturnFoo() {
    // Arrange
    categoryImpl.setUrl("foo");

    // Act and Assert
    assertEquals("/foo", categoryImpl.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Url is {@code ?}.
   *   <li>Then return {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplUrlIsQuestionMark_thenReturnQuestionMark() {
    // Arrange
    categoryImpl.setUrl("?");

    // Act and Assert
    assertEquals("?", categoryImpl.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Url is {@code /}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImplUrlIsSlash_thenReturnSlash() {
    // Arrange
    categoryImpl.setUrl("/");

    // Act and Assert
    assertEquals("/", categoryImpl.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getUrl()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example?}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrl()"})
  public void testGetUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange
    categoryImpl.setUrl("https://example.org/example?");

    // Act and Assert
    assertEquals("https://example.org/example?", categoryImpl.getUrl());
  }

  /**
   * Test {@link CategoryImpl#getOverrideGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getOverrideGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CategoryImpl.getOverrideGeneratedUrl()"})
  public void testGetOverrideGeneratedUrl_givenCategoryImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryImpl.getOverrideGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getOverrideGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getOverrideGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CategoryImpl.getOverrideGeneratedUrl()"})
  public void testGetOverrideGeneratedUrl_thenReturnTrue() {
    // Arrange
    categoryImpl.setOverrideGeneratedUrl(true);

    // Act and Assert
    assertTrue(categoryImpl.getOverrideGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then not {@link CategoryImpl} OverrideGeneratedUrl.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setOverrideGeneratedUrl(Boolean)"})
  public void testSetOverrideGeneratedUrl_whenNull_thenNotCategoryImplOverrideGeneratedUrl() {
    // Arrange and Act
    categoryImpl.setOverrideGeneratedUrl(null);

    // Assert that nothing has changed
    assertFalse(categoryImpl.getOverrideGeneratedUrl());
    assertFalse(categoryImpl.overrideGeneratedUrl);
  }

  /**
   * Test {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link CategoryImpl} OverrideGeneratedUrl.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setOverrideGeneratedUrl(Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setOverrideGeneratedUrl(Boolean)"})
  public void testSetOverrideGeneratedUrl_whenTrue_thenCategoryImplOverrideGeneratedUrl() {
    // Arrange and Act
    categoryImpl.setOverrideGeneratedUrl(true);

    // Assert
    assertTrue(categoryImpl.getOverrideGeneratedUrl());
    assertTrue(categoryImpl.overrideGeneratedUrl);
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is {@code :}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsColon_thenReturnEmptyString() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName(":");

    // Act and Assert
    assertEquals("", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsEmptyString_thenReturnEmptyString() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("");

    // Act and Assert
    assertEquals("", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsFoo_thenReturnFoo() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("foo");

    // Act and Assert
    assertEquals("foo", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is {@code String}.
   *   <li>Then return {@code javalangString}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsJavaLangString_thenReturnJavalangString() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("java.lang.String");

    // Act and Assert
    assertEquals("javalangString", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is {@code List}.
   *   <li>Then return {@code javautilList}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsJavaUtilList_thenReturnJavautilList() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("java.util.List");

    // Act and Assert
    assertEquals("javautilList", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is {@code Map$Entry}.
   *   <li>Then return {@code javautilMapEntry}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsJavaUtilMapEntry_thenReturnJavautilMapEntry() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("java.util.Map$Entry");

    // Act and Assert
    assertEquals("javautilMapEntry", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is {@code ?}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsQuestionMark_thenReturnEmptyString() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("?");

    // Act and Assert
    assertEquals("", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is {@code /}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsSlash_thenReturnEmptyString() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("/");

    // Act and Assert
    assertEquals("", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is space space.
   *   <li>Then return {@code --}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsSpaceSpace_thenReturnDashDash() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("  ");

    // Act and Assert
    assertEquals("--", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is space.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsSpace_thenReturnDash() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName(" ");

    // Act and Assert
    assertEquals("-", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is {@code UU UU}.
   *   <li>Then return {@code uU-UU}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsUuUu_thenReturnUUUu() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("UU UU");

    // Act and Assert
    assertEquals("uU-UU", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Name is {@code .*?\W.*?}.
   *   <li>Then return {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplNameIsW_thenReturnW() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName(".*?\\W.*?");

    // Act and Assert
    assertEquals("w", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} UrlKey is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplUrlKeyIsFoo_thenReturnFoo() {
    // Arrange
    categoryImpl.setUrlKey("foo");
    categoryImpl.setName(null);

    // Act and Assert
    assertEquals("foo", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} UrlKey is space.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImplUrlKeyIsSpace_thenReturnFoo() {
    // Arrange
    categoryImpl.setUrlKey(" ");
    categoryImpl.setName("foo");

    // Act and Assert
    assertEquals("foo", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Then return {@code orgbroadleafcommercecommonmediadomainMedia}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_thenReturnOrgbroadleafcommercecommonmediadomainMedia() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("org.broadleafcommerce.common.media.domain.Media");

    // Act and Assert
    assertEquals("orgbroadleafcommercecommonmediadomainMedia", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getUrlKey()}.
   *
   * <ul>
   *   <li>Then return {@code orgbroadleafcommercecorecatalogdomainCategory}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getUrlKey()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getUrlKey()"})
  public void testGetUrlKey_thenReturnOrgbroadleafcommercecorecatalogdomainCategory() {
    // Arrange
    categoryImpl.setUrlKey(null);
    categoryImpl.setName("org.broadleafcommerce.core.catalog.domain.Category");

    // Act and Assert
    assertEquals("orgbroadleafcommercecorecatalogdomainCategory", categoryImpl.getUrlKey());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("org.broadleafcommerce.core.catalog.domain.CategoryAttribute");

    // Act and Assert
    assertEquals(
        "orgbroadleafcommercecorecatalogdomainCategoryAttribute", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code :}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsColon_thenReturnEmptyString() {
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
    categoryImpl.setName(":");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code -}.
   *   <li>Then return {@code --}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsDash_thenReturnDashDash() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" -");

    // Act and Assert
    assertEquals("--", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsEmptyString_thenReturnEmptyString() {
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
    categoryImpl.setName("");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code List}.
   *   <li>Then return {@code javautilList}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsJavaUtilList_thenReturnJavautilList() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.util.List");

    // Act and Assert
    assertEquals("javautilList", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.
   *   <li>Then return {@code name}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsName_thenReturnName() {
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

    // Act and Assert
    assertEquals("name", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code ?}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsQuestionMark_thenReturnEmptyString() {
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
    categoryImpl.setName("?");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code /}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsSlash_thenReturnEmptyString() {
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
    categoryImpl.setName("/");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("");

    // Act and Assert
    assertEquals("", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is space space.
   *   <li>Then return {@code --}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsSpaceSpace_thenReturnDashDash() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("  ");

    // Act and Assert
    assertEquals("--", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is space.
   *   <li>Then return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsSpace_thenReturnDash() {
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
    categoryImpl.setName(" ");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("");

    // Act and Assert
    assertEquals("-", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code UU UU}.
   *   <li>Then return {@code uU-UU}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsUuUu_thenReturnUUUu() {
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
    categoryImpl.setName("UU UU");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("");

    // Act and Assert
    assertEquals("uU-UU", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code UU UU}.
   *   <li>Then return {@code -UU-UU}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsUuUu_thenReturnUuUu() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" UU UU");

    // Act and Assert
    assertEquals("-UU-UU", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code .*?\W.*?}.
   *   <li>Then return {@code w}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImplNameIsW_thenReturnW() {
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
    categoryImpl.setName(".*?\\W.*?");
    categoryImpl.setOverrideGeneratedUrl(true);
    categoryImpl.setProductDescriptionPatternOverride("Product Description Pattern Override");
    categoryImpl.setProductTitlePatternOverride("Dr");
    categoryImpl.setRootDisplayOrder(new BigDecimal("2.3"));
    categoryImpl.setSearchFacets(new ArrayList<>());
    categoryImpl.setTaxCode("Tax Code");
    categoryImpl.setUpSaleProducts(new ArrayList<>());
    categoryImpl.setUrl("https://example.org/example");
    categoryImpl.setUrlKey("");

    // Act and Assert
    assertEquals("w", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnHttpsExampleOrgExample() {
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
    assertEquals("https://example.org/example", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code javalangString}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnJavalangString() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.lang.String");

    // Act and Assert
    assertEquals("javalangString", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code javautilMapEntry}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnJavautilMapEntry() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.util.Map$Entry");

    // Act and Assert
    assertEquals("javautilMapEntry", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code orgbroadleafcommercecommonmediadomainMedia}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnOrgbroadleafcommercecommonmediadomainMedia() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("org.broadleafcommerce.common.media.domain.Media");

    // Act and Assert
    assertEquals("orgbroadleafcommercecommonmediadomainMedia", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code orgbroadleafcommercecorecatalogdomainCategory}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnOrgbroadleafcommercecorecatalogdomainCategory() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("org.broadleafcommerce.core.catalog.domain.Category");

    // Act and Assert
    assertEquals("orgbroadleafcommercecorecatalogdomainCategory", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getGeneratedUrl()}.
   *
   * <ul>
   *   <li>Then return {@code orgbroadleafcommercecorecatalogdomainCategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getGeneratedUrl()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getGeneratedUrl()"})
  public void testGetGeneratedUrl_thenReturnOrgbroadleafcommercecorecatalogdomainCategoryImpl() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("org.broadleafcommerce.core.catalog.domain.CategoryImpl");

    // Act and Assert
    assertEquals(
        "orgbroadleafcommercecorecatalogdomainCategoryImpl", categoryImpl.getGeneratedUrl());
  }

  /**
   * Test {@link CategoryImpl#getDescription()}.
   *
   * <p>Method under test: {@link CategoryImpl#getDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getDescription()"})
  public void testGetDescription() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getDescription());
  }

  /**
   * Test {@link CategoryImpl#getActiveStartDate()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Archived is {@code Y}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date CategoryImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenCategoryImplArchivedIsY_thenReturnNull() {
    // Arrange
    categoryImpl.setArchived('Y');

    // Act and Assert
    assertNull(categoryImpl.getActiveStartDate());
  }

  /**
   * Test {@link CategoryImpl#getActiveStartDate()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getActiveStartDate()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date CategoryImpl.getActiveStartDate()"})
  public void testGetActiveStartDate_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getActiveStartDate());
  }

  /**
   * Test {@link CategoryImpl#setActiveStartDate(Date)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link CategoryImpl} ActiveStartDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setActiveStartDate(Date)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setActiveStartDate(Date)"})
  public void testSetActiveStartDate_whenNull_thenCategoryImplActiveStartDateIsNull() {
    // Arrange and Act
    categoryImpl.setActiveStartDate(null);

    // Assert that nothing has changed
    assertNull(categoryImpl.getActiveStartDate());
    assertNull(categoryImpl.activeStartDate);
  }

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
   * Test {@link CategoryImpl#setActiveEndDate(Date)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link CategoryImpl} ActiveEndDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setActiveEndDate(Date)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setActiveEndDate(Date)"})
  public void testSetActiveEndDate_whenNull_thenCategoryImplActiveEndDateIsNull() {
    // Arrange and Act
    categoryImpl.setActiveEndDate(null);

    // Assert that nothing has changed
    assertNull(categoryImpl.getActiveEndDate());
  }

  /**
   * Test {@link CategoryImpl#isActive()}.
   *
   * <p>Method under test: {@link CategoryImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.isActive()"})
  public void testIsActive() {
    // Arrange
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setArchived(null);

    // Act and Assert
    assertFalse(categoryImpl.isActive());
  }

  /**
   * Test {@link CategoryImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} ActiveEndDate is {@link Date#Date()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.isActive()"})
  public void testIsActive_givenCategoryImplActiveEndDateIsDate_thenReturnFalse() {
    // Arrange
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveEndDate(new Date());
    categoryImpl.setArchived('Y');

    // Act and Assert
    assertFalse(categoryImpl.isActive());
  }

  /**
   * Test {@link CategoryImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.isActive()"})
  public void testIsActive_givenCategoryImplArchivedIsY_thenReturnFalse() {
    // Arrange
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    categoryImpl.setActiveEndDate(null);
    categoryImpl.setArchived('Y');

    // Act and Assert
    assertFalse(categoryImpl.isActive());
  }

  /**
   * Test {@link CategoryImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#isActive()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.isActive()"})
  public void testIsActive_givenCategoryImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(categoryImpl.isActive());
  }

  /**
   * Test {@link CategoryImpl#getLongDescription()}.
   *
   * <p>Method under test: {@link CategoryImpl#getLongDescription()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getLongDescription()"})
  public void testGetLongDescription() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getLongDescription());
  }

  /**
   * Test {@link CategoryImpl#getDefaultParentCategory()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getDefaultParentCategory()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Category CategoryImpl.getDefaultParentCategory()"})
  public void testGetDefaultParentCategory_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getDefaultParentCategory());
  }

  /**
   * Test {@link CategoryImpl#getDefaultParentCategory()}.
   *
   * <ul>
   *   <li>Then return {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getDefaultParentCategory()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Category CategoryImpl.getDefaultParentCategory()"})
  public void testGetDefaultParentCategory_thenReturnCategoryImpl() {
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

    // Act and Assert
    assertSame(defaultParentCategory, categoryImpl.getDefaultParentCategory());
  }

  /**
   * Test {@link CategoryImpl#getParentCategory()}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategory()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Category CategoryImpl.getParentCategory()"})
  public void testGetParentCategory() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getParentCategory());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryXref()}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryXref()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CategoryXref CategoryImpl.getParentCategoryXref()"})
  public void testGetParentCategoryXref() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getParentCategoryXref());
  }

  /**
   * Test {@link CategoryImpl#setParentCategory(Category)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} AllParentCategoryXrefs size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setParentCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setParentCategory(Category)"})
  public void testSetParentCategory_thenCategoryImplAllParentCategoryXrefsSizeIsOne() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

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
    assertSame(category, allParentCategories.get(0));
    assertSame(category, getResult.getCategory());
    assertSame(categoryImpl, getResult.getSubCategory());
  }

  /**
   * Test {@link CategoryImpl#setParentCategory(Category)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link CategoryImpl} AllParentCategories Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setParentCategory(Category)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setParentCategory(Category)"})
  public void testSetParentCategory_whenNull_thenCategoryImplAllParentCategoriesEmpty() {
    // Arrange and Act
    categoryImpl.setParentCategory(null);

    // Assert that nothing has changed
    assertTrue(categoryImpl.getAllParentCategories().isEmpty());
    assertTrue(categoryImpl.getAllParentCategoryXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryXrefs()}.
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryXrefs()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getChildCategoryXrefs()"})
  public void testGetChildCategoryXrefs() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getChildCategoryXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategoryXrefs(List)}.
   *
   * <ul>
   *   <li>Then not {@link CategoryImpl} hasAllChildCategories.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllChildCategoryXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllChildCategoryXrefs(List)"})
  public void testSetAllChildCategoryXrefs_thenNotCategoryImplHasAllChildCategories() {
    // Arrange and Act
    categoryImpl.setAllChildCategoryXrefs(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(categoryImpl.hasAllChildCategories());
    assertTrue(categoryImpl.getAllChildCategories().isEmpty());
    assertTrue(categoryImpl.getAllChildCategoryXrefs().isEmpty());
    assertTrue(categoryImpl.allLegacyChildCategories.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getAllChildCategories()}.
   *
   * <p>Method under test: {@link CategoryImpl#getAllChildCategories()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getAllChildCategories()"})
  public void testGetAllChildCategories() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getAllChildCategories().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#hasAllChildCategories()}.
   *
   * <p>Method under test: {@link CategoryImpl#hasAllChildCategories()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.hasAllChildCategories()"})
  public void testHasAllChildCategories() {
    // Arrange, Act and Assert
    assertFalse(categoryImpl.hasAllChildCategories());
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategories(List)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllChildCategories(List)"})
  public void testSetAllChildCategories_givenCategoryImpl_whenArrayListAddCategoryImpl() {
    // Arrange
    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.setAllChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategories(List)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllChildCategories(List)"})
  public void testSetAllChildCategories_givenCategoryImpl_whenArrayListAddCategoryImpl2() {
    // Arrange
    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.setAllChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#setAllChildCategories(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllChildCategories(List)"})
  public void testSetAllChildCategories_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.setAllChildCategories(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#getChildCategories()}.
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategories()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getChildCategories()"})
  public void testGetChildCategories() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getChildCategories().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#hasChildCategories()}.
   *
   * <p>Method under test: {@link CategoryImpl#hasChildCategories()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryImpl.hasChildCategories()"})
  public void testHasChildCategories() {
    // Arrange, Act and Assert
    assertFalse(categoryImpl.hasChildCategories());
  }

  /**
   * Test {@link CategoryImpl#setChildCategories(List)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setChildCategories(List)"})
  public void testSetChildCategories_givenCategoryImpl_whenArrayListAddCategoryImpl() {
    // Arrange
    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.setChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#setChildCategories(List)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setChildCategories(List)"})
  public void testSetChildCategories_givenCategoryImpl_whenArrayListAddCategoryImpl2() {
    // Arrange
    ArrayList<Category> childCategories = new ArrayList<>();
    childCategories.add(new CategoryImpl());
    childCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.setChildCategories(childCategories));
  }

  /**
   * Test {@link CategoryImpl#setChildCategories(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setChildCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setChildCategories(List)"})
  public void testSetChildCategories_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.setChildCategories(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryIds()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryIds()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getChildCategoryIds()"})
  public void testGetChildCategoryIds_thenReturnEmpty() {
    // Arrange
    categoryImpl.setChildCategoryIds(new ArrayList<>());

    // Act and Assert
    assertTrue(categoryImpl.getChildCategoryIds().isEmpty());
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
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Cannot create childCategoryURLMap - the urlKey for a category(");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("cannot-create-childCategoryURLMap---the-urlKey-for-a-category");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code :}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsColon_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(":");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsEmptyString_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code String}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsJavaLangString_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("java.lang.String");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsName_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("Name");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code ?}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsQuestionMark_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("?");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code /}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsSlash_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("/");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is space.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsSpace_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(" ");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code UU UU}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsUuUu_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("UU UU");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code .*?\W.*?}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnNull() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName(".*?\\W.*?");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code [^\w-]+}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplNameIsW_thenReturnNull2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("[^\\w-]+");

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) UrlKey is empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplUrlKeyIsEmptyString_thenReturnNull() {
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

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) UrlKey is {@code
   *       https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplUrlKeyIsHttpsExampleOrgExample() {
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
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) UrlKey is {@code /}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImplUrlKeyIsSlash_thenReturnNull() {
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

    // Act and Assert
    assertNull(categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_givenCategoryImpl_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> categoryImpl.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getChildCategoryURLMap()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getChildCategoryURLMap()"})
  public void testGetChildCategoryURLMap_thenReturnEmpty() {
    // Arrange
    categoryImpl.setChildCategoryURLMap(new HashMap<>());

    // Act and Assert
    assertTrue(categoryImpl.getChildCategoryURLMap().isEmpty());
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
   *   <li>Then return {@code /uU-UU} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createChildCategoryURLMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.createChildCategoryURLMap()"})
  public void testCreateChildCategoryURLMap_thenReturnUUUuSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setName("UU UU");

    // Act
    Map<String, List<Long>> actualCreateChildCategoryURLMapResult =
        categoryImpl.createChildCategoryURLMap();

    // Assert
    assertEquals(1, actualCreateChildCategoryURLMapResult.size());
    List<Long> getResult = actualCreateChildCategoryURLMapResult.get("/uU-UU");
    assertEquals(1, getResult.size());
    assertNull(getResult.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath() {
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
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(null);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category defaultParentCategory2 = getResult.getDefaultParentCategory();
    assertTrue(defaultParentCategory2 instanceof CategoryImpl);
    assertEquals(defaultParentCategory, defaultParentCategory2);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath2() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(
            Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
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

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(null);

    // Assert
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(false));
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    assertSame(categoryImpl, getResult);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath3() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(
            Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
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
        UnsupportedOperationException.class, () -> categoryImpl.getParentCategoryHierarchy(null));
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(false));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent() {
    // Arrange and Act
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(null, null);

    // Assert
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    assertSame(categoryImpl, getResult);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent2() {
    // Arrange
    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());
    CategoryImpl categoryImpl = new CategoryImpl();
    currentPath.add(categoryImpl);

    // Act
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals(categoryImpl, getResult);
    assertSame(categoryImpl, getResult);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent3() {
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

    // Act
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(null, null);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category getResult2 = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult2 instanceof CategoryImpl);
    assertEquals("Name", getResult2.getName());
    assertEquals("Name", ((CategoryImpl) getResult2).getMainEntityName());
    assertEquals("Name", ((CategoryImpl) getResult2).name);
    assertEquals("null", getResult.getGeneratedUrl());
    assertNull(getResult.getName());
    assertNull(getResult.getUrlKey());
    assertNull(((CategoryImpl) getResult).getMainEntityName());
    assertNull(((CategoryImpl) getResult).name);
    assertNull(getResult.getDefaultParentCategory());
    assertNull(((CategoryImpl) getResult).defaultParentCategory);
    assertSame(defaultParentCategory, getResult2.getDefaultParentCategory());
    assertSame(defaultParentCategory, ((CategoryImpl) getResult2).defaultParentCategory);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent4() {
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
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(null, true);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    Category getResult2 = actualParentCategoryHierarchy.get(0);
    assertSame(getResult2, getResult.getDefaultParentCategory());
    assertSame(getResult2, ((CategoryImpl) getResult).defaultParentCategory);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent5() {
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
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(null, null);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category getResult2 = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult2 instanceof CategoryImpl);
    assertEquals("null", getResult.getGeneratedUrl());
    assertNull(getResult.getName());
    assertNull(getResult2.getName());
    assertNull(getResult.getUrlKey());
    assertNull(((CategoryImpl) getResult).getMainEntityName());
    assertNull(((CategoryImpl) getResult2).getMainEntityName());
    assertNull(((CategoryImpl) getResult).name);
    assertNull(((CategoryImpl) getResult2).name);
    assertNull(getResult.getDefaultParentCategory());
    assertNull(((CategoryImpl) getResult).defaultParentCategory);
    assertSame(defaultParentCategory, getResult2.getDefaultParentCategory());
    assertSame(defaultParentCategory, ((CategoryImpl) getResult2).defaultParentCategory);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent6() {
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
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(null, null);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals("Name", getResult.getName());
    assertEquals("Name", ((CategoryImpl) getResult).getMainEntityName());
    assertEquals("Name", ((CategoryImpl) getResult).name);
    assertEquals("name", getResult.getGeneratedUrl());
    assertEquals("name", getResult.getUrlKey());
    assertNull(getResult.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent7() {
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
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(null, null);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category defaultParentCategory2 = getResult.getDefaultParentCategory();
    assertTrue(defaultParentCategory2 instanceof CategoryImpl);
    assertEquals(defaultParentCategory, defaultParentCategory2);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent8() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(
            Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
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

    // Act
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(null, null);

    // Assert
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(false));
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    Category getResult2 = actualParentCategoryHierarchy.get(0);
    assertSame(getResult2, getResult.getDefaultParentCategory());
    assertSame(getResult2, ((CategoryImpl) getResult).defaultParentCategory);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent9() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getParentCategoryHierarchy(
            Mockito.<List<Category>>any(), Mockito.<Boolean>any()))
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
        () -> categoryImpl.getParentCategoryHierarchy(null, null));
    verify(defaultParentCategory).getParentCategoryHierarchy(isA(List.class), eq(false));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_thenArrayListSizeIsOne() {
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
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(currentPath, null);

    // Assert
    assertEquals(1, currentPath.size());
    assertSame(currentPath, actualParentCategoryHierarchy);
    assertSame(defaultParentCategory, currentPath.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_thenReturnArrayList() {
    // Arrange
    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());

    // Act
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(currentPath, true);

    // Assert
    assertSame(currentPath, actualParentCategoryHierarchy);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getParentCategoryHierarchy(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)} with {@code currentPath},
   * {@code firstParent}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List, Boolean)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List, Boolean)"})
  public void testGetParentCategoryHierarchyWithCurrentPathFirstParent_thenReturnSizeIsOne() {
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
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(null, null);

    // Assert
    assertEquals(1, actualParentCategoryHierarchy.size());
    assertTrue(actualParentCategoryHierarchy.get(0) instanceof CategoryImpl);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenArrayListSizeIsOne() {
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
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(1, currentPath.size());
    assertSame(currentPath, actualParentCategoryHierarchy);
    assertSame(defaultParentCategory, currentPath.get(0));
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenReturnArrayList() {
    // Arrange
    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());

    // Act
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertSame(currentPath, actualParentCategoryHierarchy);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <ul>
   *   <li>Then return first is {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenReturnFirstIsCategoryImpl() {
    // Arrange and Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(null);

    // Assert
    assertEquals(1, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    assertSame(categoryImpl, getResult);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <ul>
   *   <li>Then return first Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenReturnFirstNameIsName() {
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
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(null);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals("Name", getResult.getName());
    assertEquals("Name", ((CategoryImpl) getResult).getMainEntityName());
    assertEquals("Name", ((CategoryImpl) getResult).name);
    assertEquals("name", getResult.getGeneratedUrl());
    assertEquals("name", getResult.getUrlKey());
    assertNull(getResult.getChildCategoryURLMap());
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <ul>
   *   <li>Then return second is {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenReturnSecondIsCategoryImpl() {
    // Arrange
    ArrayList<Category> currentPath = new ArrayList<>();
    currentPath.add(new CategoryImpl());
    CategoryImpl categoryImpl = new CategoryImpl();
    currentPath.add(categoryImpl);

    // Act
    List<Category> actualParentCategoryHierarchy =
        categoryImpl.getParentCategoryHierarchy(currentPath);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    assertEquals(categoryImpl, getResult);
    assertSame(categoryImpl, getResult);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <ul>
   *   <li>Then return second Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenReturnSecondNameIsName() {
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

    // Act
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(null);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category getResult2 = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult2 instanceof CategoryImpl);
    assertEquals("Name", getResult2.getName());
    assertEquals("Name", ((CategoryImpl) getResult2).getMainEntityName());
    assertEquals("Name", ((CategoryImpl) getResult2).name);
    assertEquals("null", getResult.getGeneratedUrl());
    assertNull(getResult.getName());
    assertNull(getResult.getUrlKey());
    assertNull(((CategoryImpl) getResult).getMainEntityName());
    assertNull(((CategoryImpl) getResult).name);
    assertNull(getResult.getDefaultParentCategory());
    assertNull(((CategoryImpl) getResult).defaultParentCategory);
    assertSame(defaultParentCategory, getResult2.getDefaultParentCategory());
    assertSame(defaultParentCategory, ((CategoryImpl) getResult2).defaultParentCategory);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <ul>
   *   <li>Then return second Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenReturnSecondNameIsNull() {
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
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(null);

    // Assert
    assertEquals(2, actualParentCategoryHierarchy.size());
    Category getResult = actualParentCategoryHierarchy.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category getResult2 = actualParentCategoryHierarchy.get(1);
    assertTrue(getResult2 instanceof CategoryImpl);
    assertEquals("null", getResult.getGeneratedUrl());
    assertNull(getResult.getName());
    assertNull(getResult2.getName());
    assertNull(getResult.getUrlKey());
    assertNull(((CategoryImpl) getResult).getMainEntityName());
    assertNull(((CategoryImpl) getResult2).getMainEntityName());
    assertNull(((CategoryImpl) getResult).name);
    assertNull(((CategoryImpl) getResult2).name);
    assertNull(getResult.getDefaultParentCategory());
    assertNull(((CategoryImpl) getResult).defaultParentCategory);
    assertSame(defaultParentCategory, getResult2.getDefaultParentCategory());
    assertSame(defaultParentCategory, ((CategoryImpl) getResult2).defaultParentCategory);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_thenReturnSizeIsOne() {
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
    List<Category> actualParentCategoryHierarchy = categoryImpl.getParentCategoryHierarchy(null);

    // Assert
    assertEquals(1, actualParentCategoryHierarchy.size());
    assertTrue(actualParentCategoryHierarchy.get(0) instanceof CategoryImpl);
  }

  /**
   * Test {@link CategoryImpl#getParentCategoryHierarchy(List)} with {@code currentPath}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentCategoryHierarchy(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentCategoryHierarchy(List)"})
  public void testGetParentCategoryHierarchyWithCurrentPath_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getParentCategoryHierarchy(new ArrayList<>()).isEmpty());
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
        categoryImpl.buildDefaultParentCategoryPath(null);

    // Assert
    assertEquals(2, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category defaultParentCategory2 = getResult.getDefaultParentCategory();
    assertTrue(defaultParentCategory2 instanceof CategoryImpl);
    assertEquals(defaultParentCategory, defaultParentCategory2);
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

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(null);

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    assertEquals(2, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(1);
    assertTrue(getResult instanceof CategoryImpl);
    assertSame(categoryImpl, getResult);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_givenCategoryImpl_thenReturnArrayList() {
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
   *   <li>Then return first Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenReturnFirstNameIsName() {
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
    assertEquals("Name", getResult.getName());
    assertEquals("Name", ((CategoryImpl) getResult).getMainEntityName());
    assertEquals("Name", ((CategoryImpl) getResult).name);
    assertEquals("name", getResult.getGeneratedUrl());
    assertEquals("name", getResult.getUrlKey());
    assertNull(getResult.getChildCategoryURLMap());
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
   *   <li>Then return second Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenReturnSecondNameIsName() {
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

    // Act
    List<Category> actualBuildDefaultParentCategoryPathResult =
        categoryImpl.buildDefaultParentCategoryPath(null);

    // Assert
    assertEquals(2, actualBuildDefaultParentCategoryPathResult.size());
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category getResult2 = actualBuildDefaultParentCategoryPathResult.get(1);
    assertTrue(getResult2 instanceof CategoryImpl);
    assertEquals("Name", getResult2.getName());
    assertEquals("Name", ((CategoryImpl) getResult2).getMainEntityName());
    assertEquals("Name", ((CategoryImpl) getResult2).name);
    assertEquals("null", getResult.getGeneratedUrl());
    assertNull(getResult.getName());
    assertNull(getResult.getUrlKey());
    assertNull(((CategoryImpl) getResult).getMainEntityName());
    assertNull(((CategoryImpl) getResult).name);
    assertNull(getResult.getDefaultParentCategory());
    assertNull(((CategoryImpl) getResult).defaultParentCategory);
    assertSame(defaultParentCategory, getResult2.getDefaultParentCategory());
    assertSame(defaultParentCategory, ((CategoryImpl) getResult2).defaultParentCategory);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>Then return second Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenReturnSecondNameIsNull() {
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
    Category getResult = actualBuildDefaultParentCategoryPathResult.get(0);
    assertTrue(getResult instanceof CategoryImpl);
    Category getResult2 = actualBuildDefaultParentCategoryPathResult.get(1);
    assertTrue(getResult2 instanceof CategoryImpl);
    assertEquals("null", getResult.getGeneratedUrl());
    assertNull(getResult.getName());
    assertNull(getResult2.getName());
    assertNull(getResult.getUrlKey());
    assertNull(((CategoryImpl) getResult).getMainEntityName());
    assertNull(((CategoryImpl) getResult2).getMainEntityName());
    assertNull(((CategoryImpl) getResult).name);
    assertNull(((CategoryImpl) getResult2).name);
    assertNull(getResult.getDefaultParentCategory());
    assertNull(((CategoryImpl) getResult).defaultParentCategory);
    assertSame(defaultParentCategory, getResult2.getDefaultParentCategory());
    assertSame(defaultParentCategory, ((CategoryImpl) getResult2).defaultParentCategory);
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_thenReturnSizeIsOne() {
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
        () -> categoryImpl.buildDefaultParentCategoryPath(null));
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#buildDefaultParentCategoryPath(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_whenArrayList_thenArrayListSizeIsOne() {
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
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#buildDefaultParentCategoryPath(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.buildDefaultParentCategoryPath(List)"})
  public void testBuildDefaultParentCategoryPath_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.buildDefaultParentCategoryPath(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategoryXrefs(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} AllParentCategories Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategoryXrefs(List)"})
  public void testSetAllParentCategoryXrefs_thenCategoryImplAllParentCategoriesEmpty() {
    // Arrange and Act
    categoryImpl.setAllParentCategoryXrefs(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(categoryImpl.getAllParentCategories().isEmpty());
    assertTrue(categoryImpl.getAllParentCategoryXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategoryXrefs(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} AllParentCategories size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategoryXrefs(List)"})
  public void testSetAllParentCategoryXrefs_thenCategoryImplAllParentCategoriesSizeIsOne() {
    // Arrange
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
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} AllParentCategories size is two.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllParentCategoryXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategoryXrefs(List)"})
  public void testSetAllParentCategoryXrefs_thenCategoryImplAllParentCategoriesSizeIsTwo() {
    // Arrange
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
   *
   * <p>Method under test: {@link CategoryImpl#getAllParentCategories()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getAllParentCategories()"})
  public void testGetAllParentCategories() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getAllParentCategories().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategories(List)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategories(List)"})
  public void testSetAllParentCategories_givenCategoryImpl_whenArrayListAddCategoryImpl() {
    // Arrange
    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.setAllParentCategories(allParentCategories));
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategories(List)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategories(List)"})
  public void testSetAllParentCategories_givenCategoryImpl_whenArrayListAddCategoryImpl2() {
    // Arrange
    ArrayList<Category> allParentCategories = new ArrayList<>();
    allParentCategories.add(new CategoryImpl());
    allParentCategories.add(new CategoryImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.setAllParentCategories(allParentCategories));
  }

  /**
   * Test {@link CategoryImpl#setAllParentCategories(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllParentCategories(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllParentCategories(List)"})
  public void testSetAllParentCategories_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.setAllParentCategories(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#setFeaturedProducts(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} CumulativeFeaturedProducts Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setFeaturedProducts(List)"})
  public void testSetFeaturedProducts_thenCategoryImplCumulativeFeaturedProductsEmpty() {
    // Arrange and Act
    categoryImpl.setFeaturedProducts(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(categoryImpl.getFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setFeaturedProducts(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} CumulativeFeaturedProducts size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setFeaturedProducts(List)"})
  public void testSetFeaturedProducts_thenCategoryImplCumulativeFeaturedProductsSizeIsOne() {
    // Arrange
    ArrayList<FeaturedProduct> featuredProducts = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProducts.add(featuredProductImpl);

    // Act
    categoryImpl.setFeaturedProducts(featuredProducts);

    // Assert
    List<FeaturedProduct> cumulativeFeaturedProducts = categoryImpl.getCumulativeFeaturedProducts();
    assertEquals(1, cumulativeFeaturedProducts.size());
    List<FeaturedProduct> featuredProducts2 = categoryImpl.getFeaturedProducts();
    assertEquals(1, featuredProducts2.size());
    assertSame(featuredProductImpl, cumulativeFeaturedProducts.get(0));
    assertSame(featuredProductImpl, featuredProducts2.get(0));
  }

  /**
   * Test {@link CategoryImpl#setFeaturedProducts(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CumulativeFeaturedProducts size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setFeaturedProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setFeaturedProducts(List)"})
  public void testSetFeaturedProducts_thenCategoryImplCumulativeFeaturedProductsSizeIsOne2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<FeaturedProduct> featuredProducts = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProducts.add(featuredProductImpl);
    featuredProducts.add(new FeaturedProductImpl());

    // Act
    categoryImpl.setFeaturedProducts(featuredProducts);

    // Assert
    List<FeaturedProduct> cumulativeFeaturedProducts = categoryImpl.getCumulativeFeaturedProducts();
    assertEquals(1, cumulativeFeaturedProducts.size());
    assertEquals(featuredProducts, categoryImpl.getFeaturedProducts());
    assertSame(featuredProductImpl, cumulativeFeaturedProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#setCrossSaleProducts(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} CrossSaleProducts size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setCrossSaleProducts(List)"})
  public void testSetCrossSaleProducts_thenCategoryImplCrossSaleProductsSizeIsOne() {
    // Arrange
    ArrayList<RelatedProduct> crossSaleProducts = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProducts.add(crossSaleProductImpl);

    // Act
    categoryImpl.setCrossSaleProducts(crossSaleProducts);

    // Assert
    List<RelatedProduct> crossSaleProducts2 = categoryImpl.getCrossSaleProducts();
    assertEquals(1, crossSaleProducts2.size());
    List<RelatedProduct> cumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();
    assertEquals(1, cumulativeCrossSaleProducts.size());
    assertSame(crossSaleProductImpl, crossSaleProducts2.get(0));
    assertSame(crossSaleProductImpl, cumulativeCrossSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#setCrossSaleProducts(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CumulativeCrossSaleProducts size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setCrossSaleProducts(List)"})
  public void testSetCrossSaleProducts_thenCategoryImplCumulativeCrossSaleProductsSizeIsOne() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<RelatedProduct> crossSaleProducts = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    crossSaleProducts.add(crossSaleProductImpl);
    crossSaleProducts.add(new CrossSaleProductImpl());

    // Act
    categoryImpl.setCrossSaleProducts(crossSaleProducts);

    // Assert
    List<RelatedProduct> cumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();
    assertEquals(1, cumulativeCrossSaleProducts.size());
    assertEquals(crossSaleProducts, categoryImpl.getCrossSaleProducts());
    assertSame(crossSaleProductImpl, cumulativeCrossSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#setCrossSaleProducts(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link CategoryImpl} CrossSaleProducts Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setCrossSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setCrossSaleProducts(List)"})
  public void testSetCrossSaleProducts_whenArrayList_thenCategoryImplCrossSaleProductsEmpty() {
    // Arrange and Act
    categoryImpl.setCrossSaleProducts(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(categoryImpl.getCrossSaleProducts().isEmpty());
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts() {
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
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts3() {
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
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();

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
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts4() {
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
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();

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
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts5() {
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
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();

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
    assertTrue(getResult instanceof UpSaleProductImpl);
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
    assertEquals(allSellableSkus, product.getAllSkus());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Id is one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_givenCategoryImplIdIsOne_thenReturnEmpty() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setId(1L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_givenCategoryImplNameIsName_thenReturnEmpty() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setName("Name");

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code
   *       https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_givenCategoryImplUrlIsHttpsExampleOrgExample() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setUrl("https://example.org/example");

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getCumulativeCrossSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Then first Category return {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenFirstCategoryReturnCategoryImpl() {
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

    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    CategoryImpl category = new CategoryImpl();
    crossSaleProductImpl.setCategory(category);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);
    relatedProductList.add(relatedProduct);
    relatedProductList.add(upSaleProductImpl);

    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getCrossSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(0);
    Category category2 = getResult.getCategory();
    assertTrue(category2 instanceof CategoryImpl);
    assertTrue(getResult instanceof CrossSaleProductImpl);
    assertEquals(categoryImpl, category2);
    assertSame(category, category2);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenReturnEmpty() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getCrossSaleProducts()).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    assertTrue(actualCumulativeCrossSaleProducts.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Then return first Category is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenReturnFirstCategoryIsNull() {
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
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(0);
    assertTrue(getResult instanceof CrossSaleProductImpl);
    assertNull(getResult.getCategory());
    assertSame(upSaleProductImpl, actualCumulativeCrossSaleProducts.get(2));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Then return first Category is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenReturnFirstCategoryIsNull2() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getSequence()).thenThrow(new UnsupportedOperationException());

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
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(0);
    assertTrue(getResult instanceof CrossSaleProductImpl);
    assertNull(getResult.getCategory());
    assertSame(upSaleProductImpl, actualCumulativeCrossSaleProducts.get(2));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Then return second Category is {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenReturnSecondCategoryIsCategoryImpl() {
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
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(1);
    Category category = getResult.getCategory();
    assertTrue(category instanceof CategoryImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    assertEquals(categoryImpl, category);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Then return second Category is {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenReturnSecondCategoryIsCategoryImpl2() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getSequence()).thenThrow(new UnsupportedOperationException());

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
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeCrossSaleProducts.size());
    RelatedProduct getResult = actualCumulativeCrossSaleProducts.get(1);
    Category category = getResult.getCategory();
    assertTrue(category instanceof CategoryImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    assertEquals(categoryImpl, category);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeCrossSaleProducts =
        categoryImpl.getCumulativeCrossSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getCrossSaleProducts();
    assertEquals(1, actualCumulativeCrossSaleProducts.size());
    assertSame(upSaleProductImpl, actualCumulativeCrossSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeCrossSaleProducts()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeCrossSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeCrossSaleProducts()"})
  public void testGetCumulativeCrossSaleProducts_thenThrowUnsupportedOperationException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new UnsupportedOperationException());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> categoryImpl.getCumulativeCrossSaleProducts());
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts() {
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
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts3() {
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
    List<RelatedProduct> actualCumulativeUpSaleProducts =
        categoryImpl.getCumulativeUpSaleProducts();

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
    assertTrue(getResult instanceof UpSaleProductImpl);
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
    assertEquals(allSellableSkus, product.getAllSkus());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Id is one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_givenCategoryImplIdIsOne_thenReturnEmpty() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setId(1L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_givenCategoryImplNameIsName_thenReturnEmpty() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setName("Name");

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code
   *       https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_givenCategoryImplUrlIsHttpsExampleOrgExample() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setUrl("https://example.org/example");

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Then first Category return {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenFirstCategoryReturnCategoryImpl() {
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

    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    CategoryImpl category = new CategoryImpl();
    crossSaleProductImpl.setCategory(category);

    ArrayList<RelatedProduct> relatedProductList = new ArrayList<>();
    relatedProductList.add(crossSaleProductImpl);
    relatedProductList.add(relatedProduct);
    relatedProductList.add(upSaleProductImpl);

    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getUpSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts =
        categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(0);
    Category category2 = getResult.getCategory();
    assertTrue(category2 instanceof CategoryImpl);
    assertTrue(getResult instanceof CrossSaleProductImpl);
    assertEquals(categoryImpl, category2);
    assertSame(category, category2);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenReturnEmpty() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getUpSaleProducts()).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts =
        categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    assertTrue(actualCumulativeUpSaleProducts.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Then return first Category is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenReturnFirstCategoryIsNull() {
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
    List<RelatedProduct> actualCumulativeUpSaleProducts =
        categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(0);
    assertTrue(getResult instanceof CrossSaleProductImpl);
    assertNull(getResult.getCategory());
    assertSame(upSaleProductImpl, actualCumulativeUpSaleProducts.get(2));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Then return first Category is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenReturnFirstCategoryIsNull2() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getSequence()).thenThrow(new UnsupportedOperationException());

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
    List<RelatedProduct> actualCumulativeUpSaleProducts =
        categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    verify(relatedProduct, atLeast(1)).getSequence();
    assertEquals(3, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(0);
    assertTrue(getResult instanceof CrossSaleProductImpl);
    assertNull(getResult.getCategory());
    assertSame(upSaleProductImpl, actualCumulativeUpSaleProducts.get(2));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Then return second Category GeneratedUrl is {@code sequence}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenReturnSecondCategoryGeneratedUrlIsSequence() {
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
    List<RelatedProduct> actualCumulativeUpSaleProducts =
        categoryImpl.getCumulativeUpSaleProducts();

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
   *
   * <ul>
   *   <li>Then return second Category is {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenReturnSecondCategoryIsCategoryImpl() {
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
    List<RelatedProduct> actualCumulativeUpSaleProducts =
        categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(1);
    Category category = getResult.getCategory();
    assertTrue(category instanceof CategoryImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    assertEquals(categoryImpl, category);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Then return second Category is {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenReturnSecondCategoryIsCategoryImpl2() {
    // Arrange
    UpSaleProductImpl upSaleProductImpl = new UpSaleProductImpl();
    upSaleProductImpl.setCategory(new CategoryImpl());
    upSaleProductImpl.setId(1L);
    upSaleProductImpl.setProduct(new ProductBundleImpl());
    upSaleProductImpl.setPromotionMessage("Promotion Message");
    upSaleProductImpl.setRelatedProduct(new ProductBundleImpl());
    upSaleProductImpl.setSequence(new BigDecimal("2.3"));

    RelatedProduct relatedProduct = mock(RelatedProduct.class);
    when(relatedProduct.getSequence()).thenThrow(new UnsupportedOperationException());

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
    List<RelatedProduct> actualCumulativeUpSaleProducts =
        categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    verify(relatedProduct).getSequence();
    assertEquals(2, actualCumulativeUpSaleProducts.size());
    RelatedProduct getResult = actualCumulativeUpSaleProducts.get(1);
    Category category = getResult.getCategory();
    assertTrue(category instanceof CategoryImpl);
    assertTrue(getResult instanceof UpSaleProductImpl);
    assertEquals(categoryImpl, category);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts =
        categoryImpl.getCumulativeUpSaleProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getUpSaleProducts();
    assertEquals(1, actualCumulativeUpSaleProducts.size());
    assertSame(upSaleProductImpl, actualCumulativeUpSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeUpSaleProducts()}.
   *
   * <ul>
   *   <li>Then second RelatedProduct return {@link ProductBundleImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    relatedProductList.add(new CrossSaleProductImpl());
    relatedProductList.add(upSaleProductImpl);

    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getUpSaleProducts()).thenReturn(relatedProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<RelatedProduct> actualCumulativeUpSaleProducts =
        categoryImpl.getCumulativeUpSaleProducts();

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
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeUpSaleProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeUpSaleProducts()"})
  public void testGetCumulativeUpSaleProducts_thenThrowUnsupportedOperationException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new UnsupportedOperationException());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> categoryImpl.getCumulativeUpSaleProducts());
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts() {
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
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts3() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = new FeaturedProductImpl();
    featuredProductImpl.setSequence(new BigDecimal("2.3"));

    FeaturedProductImpl featuredProductImpl2 = mock(FeaturedProductImpl.class);
    when(featuredProductImpl2.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    featuredProductList.add(featuredProductImpl2);
    featuredProductList.add(featuredProductImpl);

    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts =
        categoryImpl.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    verify(featuredProductImpl2).getSequence();
    assertEquals(2, actualCumulativeFeaturedProducts.size());
    assertSame(featuredProductImpl, actualCumulativeFeaturedProducts.get(1));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts =
        categoryImpl.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    assertEquals(featuredProductList, actualCumulativeFeaturedProducts);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts =
        categoryImpl.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    assertEquals(2, actualCumulativeFeaturedProducts.size());
    assertNull(actualCumulativeFeaturedProducts.get(0));
    assertSame(featuredProductImpl, actualCumulativeFeaturedProducts.get(1));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Id is one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_givenCategoryImplIdIsOne_thenReturnEmpty() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setId(1L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Name is {@code Name}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_givenCategoryImplNameIsName_thenReturnEmpty() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setName("Name");

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Url is {@code
   *       https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_givenCategoryImplUrlIsHttpsExampleOrgExample() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setUrl("https://example.org/example");

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getCumulativeFeaturedProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_thenReturnEmpty() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(new ArrayList<>());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts =
        categoryImpl.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    assertTrue(actualCumulativeFeaturedProducts.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts =
        categoryImpl.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    assertEquals(1, actualCumulativeFeaturedProducts.size());
    assertSame(featuredProductImpl, actualCumulativeFeaturedProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts =
        categoryImpl.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    assertEquals(1, actualCumulativeFeaturedProducts.size());
    assertSame(featuredProductImpl, actualCumulativeFeaturedProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_thenReturnSizeIsThree() {
    // Arrange
    FeaturedProductImpl featuredProductImpl = mock(FeaturedProductImpl.class);
    when(featuredProductImpl.getSequence()).thenReturn(new BigDecimal("2.3"));

    ArrayList<FeaturedProduct> featuredProductList = new ArrayList<>();
    FeaturedProductImpl featuredProductImpl2 = new FeaturedProductImpl();
    featuredProductList.add(featuredProductImpl2);
    featuredProductList.add(featuredProductImpl);
    featuredProductList.add(null);

    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenReturn(new ArrayList<>());
    when(defaultParentCategory.getFeaturedProducts()).thenReturn(featuredProductList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts =
        categoryImpl.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    verify(featuredProductImpl).getSequence();
    assertEquals(3, actualCumulativeFeaturedProducts.size());
    assertNull(actualCumulativeFeaturedProducts.get(2));
    assertSame(featuredProductImpl2, actualCumulativeFeaturedProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<FeaturedProduct> actualCumulativeFeaturedProducts =
        categoryImpl.getCumulativeFeaturedProducts();

    // Assert
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
    verify(defaultParentCategory).getFeaturedProducts();
    verify(featuredProductImpl).getSequence();
    assertEquals(2, actualCumulativeFeaturedProducts.size());
    assertSame(featuredProductImpl2, actualCumulativeFeaturedProducts.get(1));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeFeaturedProducts()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeFeaturedProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeFeaturedProducts()"})
  public void testGetCumulativeFeaturedProducts_thenThrowUnsupportedOperationException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.buildDefaultParentCategoryPath(Mockito.<List<Category>>any()))
        .thenThrow(new UnsupportedOperationException());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> categoryImpl.getCumulativeFeaturedProducts());
    verify(defaultParentCategory).buildDefaultParentCategoryPath(isA(List.class));
  }

  /**
   * Test {@link CategoryImpl#setUpSaleProducts(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} CumulativeUpSaleProducts Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setUpSaleProducts(List)"})
  public void testSetUpSaleProducts_thenCategoryImplCumulativeUpSaleProductsEmpty() {
    // Arrange
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();

    // Act
    categoryImpl.setUpSaleProducts(upSaleProducts);

    // Assert
    assertTrue(categoryImpl.getCumulativeUpSaleProducts().isEmpty());
    assertSame(upSaleProducts, categoryImpl.getUpSaleProducts());
  }

  /**
   * Test {@link CategoryImpl#setUpSaleProducts(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} CumulativeUpSaleProducts size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setUpSaleProducts(List)"})
  public void testSetUpSaleProducts_thenCategoryImplCumulativeUpSaleProductsSizeIsOne() {
    // Arrange
    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    upSaleProducts.add(crossSaleProductImpl);

    // Act
    categoryImpl.setUpSaleProducts(upSaleProducts);

    // Assert
    List<RelatedProduct> cumulativeUpSaleProducts = categoryImpl.getCumulativeUpSaleProducts();
    assertEquals(1, cumulativeUpSaleProducts.size());
    assertSame(upSaleProducts, categoryImpl.getUpSaleProducts());
    assertSame(crossSaleProductImpl, cumulativeUpSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#setUpSaleProducts(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} (default constructor) CumulativeUpSaleProducts size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setUpSaleProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setUpSaleProducts(List)"})
  public void testSetUpSaleProducts_thenCategoryImplCumulativeUpSaleProductsSizeIsOne2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();

    ArrayList<RelatedProduct> upSaleProducts = new ArrayList<>();
    CrossSaleProductImpl crossSaleProductImpl = new CrossSaleProductImpl();
    upSaleProducts.add(crossSaleProductImpl);
    upSaleProducts.add(new CrossSaleProductImpl());

    // Act
    categoryImpl.setUpSaleProducts(upSaleProducts);

    // Assert
    List<RelatedProduct> cumulativeUpSaleProducts = categoryImpl.getCumulativeUpSaleProducts();
    assertEquals(1, cumulativeUpSaleProducts.size());
    assertEquals(2, upSaleProducts.size());
    assertSame(upSaleProducts, categoryImpl.getUpSaleProducts());
    assertSame(crossSaleProductImpl, cumulativeUpSaleProducts.get(0));
  }

  /**
   * Test {@link CategoryImpl#getActiveProductXrefs()}.
   *
   * <p>Method under test: {@link CategoryImpl#getActiveProductXrefs()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getActiveProductXrefs()"})
  public void testGetActiveProductXrefs() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getActiveProductXrefs().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllProductXrefs(List)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} AllProductXrefs size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllProductXrefs(List)"})
  public void testSetAllProductXrefs_thenCategoryImplAllProductXrefsSizeIsOne() {
    // Arrange
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
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} AllProductXrefs size is two.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllProductXrefs(List)"})
  public void testSetAllProductXrefs_thenCategoryImplAllProductXrefsSizeIsTwo() {
    // Arrange
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link CategoryImpl} AllProductXrefs Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllProductXrefs(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllProductXrefs(List)"})
  public void testSetAllProductXrefs_whenArrayList_thenCategoryImplAllProductXrefsEmpty() {
    // Arrange and Act
    categoryImpl.setAllProductXrefs(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(categoryImpl.getAllProductXrefs().isEmpty());
    assertTrue(categoryImpl.getAllProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getActiveProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getActiveProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getActiveProducts()"})
  public void testGetActiveProducts() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getActiveProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getAllProducts()}.
   *
   * <p>Method under test: {@link CategoryImpl#getAllProducts()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getAllProducts()"})
  public void testGetAllProducts() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getAllProducts().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#setAllProducts(List)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllProducts(List)"})
  public void testSetAllProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl() {
    // Arrange
    ArrayList<Product> allProducts = new ArrayList<>();
    allProducts.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> categoryImpl.setAllProducts(allProducts));
  }

  /**
   * Test {@link CategoryImpl#setAllProducts(List)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllProducts(List)"})
  public void testSetAllProducts_givenProductBundleImpl_whenArrayListAddProductBundleImpl2() {
    // Arrange
    ArrayList<Product> allProducts = new ArrayList<>();
    allProducts.add(new ProductBundleImpl());
    allProducts.add(new ProductBundleImpl());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> categoryImpl.setAllProducts(allProducts));
  }

  /**
   * Test {@link CategoryImpl#setAllProducts(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setAllProducts(List)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setAllProducts(List)"})
  public void testSetAllProducts_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> categoryImpl.setAllProducts(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#getInventoryType()}.
   *
   * <p>Method under test: {@link CategoryImpl#getInventoryType()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"InventoryType CategoryImpl.getInventoryType()"})
  public void testGetInventoryType() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getInventoryType());
  }

  /**
   * Test {@link CategoryImpl#setInventoryType(InventoryType)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} {@link CategoryImpl#inventoryType} is {@code ALWAYS_AVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setInventoryType(InventoryType)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setInventoryType(InventoryType)"})
  public void testSetInventoryType_thenCategoryImplInventoryTypeIsAlwaysAvailable() {
    // Arrange and Act
    categoryImpl.setInventoryType(InventoryType.ALWAYS_AVAILABLE);

    // Assert
    assertEquals("ALWAYS_AVAILABLE", categoryImpl.inventoryType);
    assertSame(InventoryType.ALWAYS_AVAILABLE, categoryImpl.getInventoryType());
  }

  /**
   * Test {@link CategoryImpl#setInventoryType(InventoryType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link CategoryImpl} {@link CategoryImpl#inventoryType} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setInventoryType(InventoryType)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setInventoryType(InventoryType)"})
  public void testSetInventoryType_whenNull_thenCategoryImplInventoryTypeIsNull() {
    // Arrange and Act
    categoryImpl.setInventoryType(null);

    // Assert that nothing has changed
    assertNull(categoryImpl.inventoryType);
    assertNull(categoryImpl.getInventoryType());
  }

  /**
   * Test {@link CategoryImpl#getFulfillmentType()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getFulfillmentType()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentType CategoryImpl.getFulfillmentType()"})
  public void testGetFulfillmentType_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getFulfillmentType());
  }

  /**
   * Test {@link CategoryImpl#getFulfillmentType()}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentType#DIGITAL}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getFulfillmentType()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentType CategoryImpl.getFulfillmentType()"})
  public void testGetFulfillmentType_thenReturnDigital() {
    // Arrange
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);

    // Act and Assert
    assertSame(FulfillmentType.DIGITAL, categoryImpl.getFulfillmentType());
  }

  /**
   * Test {@link CategoryImpl#setFulfillmentType(FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@link FulfillmentType#DIGITAL}.
   *   <li>Then {@link CategoryImpl} {@link CategoryImpl#fulfillmentType} is {@code DIGITAL}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setFulfillmentType(FulfillmentType)"})
  public void testSetFulfillmentType_whenDigital_thenCategoryImplFulfillmentTypeIsDigital() {
    // Arrange and Act
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);

    // Assert
    assertEquals("DIGITAL", categoryImpl.fulfillmentType);
    assertSame(FulfillmentType.DIGITAL, categoryImpl.getFulfillmentType());
  }

  /**
   * Test {@link CategoryImpl#setFulfillmentType(FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link CategoryImpl} {@link CategoryImpl#fulfillmentType} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setFulfillmentType(FulfillmentType)"})
  public void testSetFulfillmentType_whenNull_thenCategoryImplFulfillmentTypeIsNull() {
    // Arrange and Act
    categoryImpl.setFulfillmentType(null);

    // Assert that nothing has changed
    assertNull(categoryImpl.fulfillmentType);
    assertNull(categoryImpl.getFulfillmentType());
  }

  /**
   * Test {@link CategoryImpl#getParentFacets(Collection)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentFacets(Collection)"})
  public void testGetParentFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl() {
    // Arrange
    ArrayList<SearchFacet> facets = new ArrayList<>();
    facets.add(new SearchFacetImpl());

    // Act and Assert
    assertNull(categoryImpl.getParentFacets(facets));
  }

  /**
   * Test {@link CategoryImpl#getParentFacets(Collection)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchFacetImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentFacets(Collection)"})
  public void testGetParentFacets_givenSearchFacetImpl_whenArrayListAddSearchFacetImpl2() {
    // Arrange
    ArrayList<SearchFacet> facets = new ArrayList<>();
    facets.add(new SearchFacetImpl());
    facets.add(new SearchFacetImpl());

    // Act and Assert
    assertNull(categoryImpl.getParentFacets(facets));
  }

  /**
   * Test {@link CategoryImpl#getParentFacets(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getParentFacets(Collection)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getParentFacets(Collection)"})
  public void testGetParentFacets_whenArrayList() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getParentFacets(new ArrayList<>()));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets() {
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
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets3() {
    // Arrange
    ArrayList<CategorySearchFacet> categorySearchFacetList = new ArrayList<>();
    categorySearchFacetList.add(new CategorySearchFacetImpl());

    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(categorySearchFacetList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets();

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(categorySearchFacetList, actualCumulativeSearchFacets);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets4() {
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
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets();

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(searchFacets, actualCumulativeSearchFacets);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet() {
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
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(2, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet2() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet3() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(null);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet4() {
    // Arrange
    ArrayList<CategorySearchFacet> categorySearchFacetList = new ArrayList<>();
    categorySearchFacetList.add(new CategorySearchFacetImpl());

    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(categorySearchFacetList);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets(new HashSet<>());

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(categorySearchFacetList, actualCumulativeSearchFacets);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_givenCategoryImpl() {
    // Arrange
    HashSet<Category> categoryHierarchy = new HashSet<>();
    categoryHierarchy.add(new CategoryImpl());

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Id is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_givenCategoryImplIdIsOne() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setId(1L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then {@link HashSet#HashSet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_givenCategoryImpl_thenHashSetSizeIsOne() {
    // Arrange
    HashSet<Category> categoryHierarchy = new HashSet<>();

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(1, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashSet#HashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_givenNull_whenHashSetAddNull() {
    // Arrange
    HashSet<Category> categoryHierarchy = new HashSet<>();
    categoryHierarchy.add(null);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets(categoryHierarchy);

    // Assert
    assertEquals(2, categoryHierarchy.size());
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_thenReturnArrayList() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(null);

    ArrayList<CategorySearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new CategorySearchFacetImpl());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setSearchFacets(searchFacets);
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets(new HashSet<>());

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(searchFacets, actualCumulativeSearchFacets);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets(Set)} with {@code Set}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets(Set)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets(Set)"})
  public void testGetCumulativeSearchFacetsWithSet_thenThrowUnsupportedOperationException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenThrow(new UnsupportedOperationException());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> categoryImpl.getCumulativeSearchFacets(new HashSet<>()));
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   *
   * <ul>
   *   <li>Given {@link Category} {@link Category#getCumulativeSearchFacets(Set)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_givenCategoryGetCumulativeSearchFacetsReturnNull() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(null);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets();

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertTrue(actualCumulativeSearchFacets.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   *
   * <ul>
   *   <li>Given {@link Category} {@link Category#getCumulativeSearchFacets(Set)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_givenCategoryGetCumulativeSearchFacetsReturnNull2() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenReturn(null);

    ArrayList<CategorySearchFacet> searchFacets = new ArrayList<>();
    searchFacets.add(new CategorySearchFacetImpl());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setSearchFacets(searchFacets);
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act
    List<CategorySearchFacet> actualCumulativeSearchFacets =
        categoryImpl.getCumulativeSearchFacets();

    // Assert
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
    assertEquals(searchFacets, actualCumulativeSearchFacets);
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) Id is one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_givenCategoryImplIdIsOne_thenReturnEmpty() {
    // Arrange
    CategoryImpl defaultParentCategory = new CategoryImpl();
    defaultParentCategory.setId(1L);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getCumulativeSearchFacets().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCumulativeSearchFacets()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCumulativeSearchFacets()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CategoryImpl.getCumulativeSearchFacets()"})
  public void testGetCumulativeSearchFacets_thenThrowUnsupportedOperationException() {
    // Arrange
    Category defaultParentCategory = mock(Category.class);
    when(defaultParentCategory.getCumulativeSearchFacets(Mockito.<Set<Category>>any()))
        .thenThrow(new UnsupportedOperationException());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(defaultParentCategory);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> categoryImpl.getCumulativeSearchFacets());
    verify(defaultParentCategory).getCumulativeSearchFacets(isA(Set.class));
  }

  /**
   * Test {@link CategoryImpl#getCategoryMedia()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCategoryMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getCategoryMedia()"})
  public void testGetCategoryMedia_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getCategoryMedia().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryMedia()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link
   *       CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   *   <li>Then return {@code foo} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCategoryMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getCategoryMedia()"})
  public void testGetCategoryMedia_givenHashMapFooIsCategoryMediaXrefImpl_thenReturnFooIsNull() {
    // Arrange
    HashMap<String, CategoryMediaXref> categoryMediaXref = new HashMap<>();
    categoryMediaXref.put("foo", new CategoryMediaXrefImpl());

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setCategoryMediaXref(categoryMediaXref);

    // Act
    Map<String, Media> actualCategoryMedia = categoryImpl.getCategoryMedia();

    // Assert
    assertEquals(1, actualCategoryMedia.size());
    assertNull(actualCategoryMedia.get("foo"));
  }

  /**
   * Test {@link CategoryImpl#getCategoryMedia()}.
   *
   * <ul>
   *   <li>Then return {@code foo} is {@link CategoryMediaXrefImpl#CategoryMediaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCategoryMedia()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getCategoryMedia()"})
  public void testGetCategoryMedia_thenReturnFooIsCategoryMediaXrefImpl() {
    // Arrange
    CategoryMediaXref categoryMediaXref = mock(CategoryMediaXref.class);
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    when(categoryMediaXref.getMedia()).thenReturn(categoryMediaXrefImpl);

    HashMap<String, CategoryMediaXref> categoryMediaXref2 = new HashMap<>();
    categoryMediaXref2.put("foo", categoryMediaXref);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setCategoryMediaXref(categoryMediaXref2);

    // Act
    Map<String, Media> actualCategoryMedia = categoryImpl.getCategoryMedia();

    // Assert
    verify(categoryMediaXref).getMedia();
    assertEquals(1, actualCategoryMedia.size());
    assertSame(categoryMediaXrefImpl, actualCategoryMedia.get("foo"));
  }

  /**
   * Test {@link CategoryImpl#setCategoryMedia(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setCategoryMedia(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setCategoryMedia(Map)"})
  public void testSetCategoryMedia_whenHashMap_thenHashMapEmpty() {
    // Arrange
    HashMap<String, Media> categoryMedia = new HashMap<>();

    // Act
    categoryImpl.setCategoryMedia(categoryMedia);

    // Assert that nothing has changed
    assertTrue(categoryMedia.isEmpty());
    assertTrue(categoryImpl.getCategoryMedia().isEmpty());
    assertTrue(categoryImpl.getCategoryMediaXref().isEmpty());
    assertTrue(categoryImpl.legacyCategoryMedia.isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributesMap()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getCategoryAttributesMap()"})
  public void testGetCategoryAttributesMap_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getCategoryAttributesMap().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributesMap()}.
   *
   * <ul>
   *   <li>Then return containsKey {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getCategoryAttributesMap()"})
  public void testGetCategoryAttributesMap_thenReturnContainsKeyName() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = mock(CategoryAttributeImpl.class);
    when(categoryAttributeImpl.getName()).thenReturn("Name");

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    categoryAttributes.put("foo", categoryAttributeImpl);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, CategoryAttribute> actualCategoryAttributesMap =
        categoryImpl.getCategoryAttributesMap();

    // Assert
    verify(categoryAttributeImpl).getName();
    assertEquals(1, actualCategoryAttributesMap.size());
    assertTrue(actualCategoryAttributesMap.containsKey("Name"));
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributesMap()}.
   *
   * <ul>
   *   <li>Then return {@code null} is {@link CategoryAttributeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCategoryAttributesMap()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getCategoryAttributesMap()"})
  public void testGetCategoryAttributesMap_thenReturnNullIsCategoryAttributeImpl() {
    // Arrange
    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributes.put("foo", categoryAttributeImpl);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, CategoryAttribute> actualCategoryAttributesMap =
        categoryImpl.getCategoryAttributesMap();

    // Assert
    assertEquals(1, actualCategoryAttributesMap.size());
    assertSame(categoryAttributeImpl, actualCategoryAttributesMap.get(null));
  }

  /**
   * Test {@link CategoryImpl#setCategoryAttributesMap(Map)}.
   *
   * <ul>
   *   <li>Then {@link CategoryImpl} CategoryAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setCategoryAttributesMap(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setCategoryAttributesMap(Map)"})
  public void testSetCategoryAttributesMap_thenCategoryImplCategoryAttributesSizeIsOne() {
    // Arrange
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
    Map<String, CategoryAttribute> multiValueCategoryAttributes =
        categoryImpl.getMultiValueCategoryAttributes();
    assertEquals(1, multiValueCategoryAttributes.size());
    assertEquals(categoryAttributes2, multiValueCategoryAttributes.get(null));
    assertEquals(categoryAttributesMap, categoryImpl.getMappedCategoryAttributes());
    assertSame(categoryAttributeImpl, categoryAttributes2.get(0));
    assertSame(categoryAttributeImpl, categoryAttributesMap.get(null));
  }

  /**
   * Test {@link CategoryImpl#setCategoryAttributesMap(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link CategoryImpl} CategoryAttributes Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#setCategoryAttributesMap(Map)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setCategoryAttributesMap(Map)"})
  public void testSetCategoryAttributesMap_whenHashMap_thenCategoryImplCategoryAttributesEmpty() {
    // Arrange and Act
    categoryImpl.setCategoryAttributesMap(new HashMap<>());

    // Assert that nothing has changed
    assertTrue(categoryImpl.getCategoryAttributes().isEmpty());
    assertTrue(categoryImpl.getCategoryAttributesMap().isEmpty());
    assertTrue(categoryImpl.getMappedCategoryAttributes().isEmpty());
    assertTrue(categoryImpl.getMultiValueCategoryAttributes().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributeByName(String)}.
   *
   * <ul>
   *   <li>Given {@link CategoryAttributeImpl} {@link CategoryAttributeImpl#getName()} return {@code
   *       foo}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCategoryAttributeByName(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CategoryAttribute CategoryImpl.getCategoryAttributeByName(String)"})
  public void testGetCategoryAttributeByName_givenCategoryAttributeImplGetNameReturnFoo() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = mock(CategoryAttributeImpl.class);
    when(categoryAttributeImpl.getName()).thenReturn("foo");

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    categoryAttributes.put("foo", categoryAttributeImpl);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setCategoryAttributesMap(categoryAttributes);

    // Act
    CategoryAttribute actualCategoryAttributeByName =
        categoryImpl.getCategoryAttributeByName("Name");

    // Assert
    verify(categoryAttributeImpl).getName();
    assertNull(actualCategoryAttributeByName);
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributeByName(String)}.
   *
   * <ul>
   *   <li>Given {@link CategoryAttributeImpl} {@link CategoryAttributeImpl#getName()} return {@code
   *       Name}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCategoryAttributeByName(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CategoryAttribute CategoryImpl.getCategoryAttributeByName(String)"})
  public void testGetCategoryAttributeByName_givenCategoryAttributeImplGetNameReturnName() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = mock(CategoryAttributeImpl.class);
    when(categoryAttributeImpl.getName()).thenReturn("Name");

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    categoryAttributes.put("foo", categoryAttributeImpl);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setCategoryAttributesMap(categoryAttributes);

    // Act
    categoryImpl.getCategoryAttributeByName("Name");

    // Assert
    verify(categoryAttributeImpl).getName();
  }

  /**
   * Test {@link CategoryImpl#getCategoryAttributeByName(String)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getCategoryAttributeByName(String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CategoryAttribute CategoryImpl.getCategoryAttributeByName(String)"})
  public void testGetCategoryAttributeByName_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getCategoryAttributeByName("Name"));
  }

  /**
   * Test {@link CategoryImpl#getMappedCategoryAttributes()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getMappedCategoryAttributes()"})
  public void testGetMappedCategoryAttributes_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getMappedCategoryAttributes().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getMappedCategoryAttributes()}.
   *
   * <ul>
   *   <li>Then return containsKey {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getMappedCategoryAttributes()"})
  public void testGetMappedCategoryAttributes_thenReturnContainsKeyName() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = mock(CategoryAttributeImpl.class);
    when(categoryAttributeImpl.getName()).thenReturn("Name");

    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    categoryAttributes.put("foo", categoryAttributeImpl);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, CategoryAttribute> actualMappedCategoryAttributes =
        categoryImpl.getMappedCategoryAttributes();

    // Assert
    verify(categoryAttributeImpl).getName();
    assertEquals(1, actualMappedCategoryAttributes.size());
    assertTrue(actualMappedCategoryAttributes.containsKey("Name"));
  }

  /**
   * Test {@link CategoryImpl#getMappedCategoryAttributes()}.
   *
   * <ul>
   *   <li>Then return {@code null} is {@link CategoryAttributeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getMappedCategoryAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getMappedCategoryAttributes()"})
  public void testGetMappedCategoryAttributes_thenReturnNullIsCategoryAttributeImpl() {
    // Arrange
    HashMap<String, CategoryAttribute> categoryAttributes = new HashMap<>();
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributes.put("foo", categoryAttributeImpl);

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setCategoryAttributesMap(categoryAttributes);

    // Act
    Map<String, CategoryAttribute> actualMappedCategoryAttributes =
        categoryImpl.getMappedCategoryAttributes();

    // Assert
    assertEquals(1, actualMappedCategoryAttributes.size());
    assertSame(categoryAttributeImpl, actualMappedCategoryAttributes.get(null));
  }

  /**
   * Test {@link CategoryImpl#getMultiValueCategoryAttributes()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getMultiValueCategoryAttributes()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CategoryImpl.getMultiValueCategoryAttributes()"})
  public void testGetMultiValueCategoryAttributes_givenCategoryImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(categoryImpl.getMultiValueCategoryAttributes().isEmpty());
  }

  /**
   * Test {@link CategoryImpl#getArchived()}.
   *
   * <p>Method under test: {@link CategoryImpl#getArchived()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character CategoryImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', categoryImpl.getArchived().charValue());
  }

  /**
   * Test {@link CategoryImpl#setArchived(Character)}.
   *
   * <p>Method under test: {@link CategoryImpl#setArchived(Character)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange and Act
    categoryImpl.setArchived('A');

    // Assert
    assertEquals('A', categoryImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', categoryImpl.getArchived().charValue());
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
   * Test {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new CategoryImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Category> actualCreateOrRetrieveCopyInstanceResult =
        categoryImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(categoryImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Category> actualCreateOrRetrieveCopyInstanceResult =
        categoryImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

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
    CreateResponse<Object> createResponse = new CreateResponse<>(categoryImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Category> actualCreateOrRetrieveCopyInstanceResult =
        categoryImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then return Clone ActiveEndDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenReturnCloneActiveEndDateIsNull()
      throws CloneNotSupportedException {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

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

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any()))
        .thenReturn(new CreateResponse<>(categoryImpl2, false));

    // Act
    CreateResponse<Category> actualCreateOrRetrieveCopyInstanceResult =
        categoryImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    Category clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CategoryImpl);
    assertNull(clone.getActiveEndDate());
    assertSame(categoryImpl2.activeStartDate, ((CategoryImpl) clone).activeStartDate);
  }

  /**
   * Test {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then return Clone AllParentCategoryXrefs size is one.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenReturnCloneAllParentCategoryXrefsSizeIsOne()
      throws CloneNotSupportedException {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setDefaultParentCategory(new CategoryImpl());

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

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any()))
        .thenReturn(new CreateResponse<>(categoryImpl2, false));

    // Act
    CreateResponse<Category> actualCreateOrRetrieveCopyInstanceResult =
        categoryImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context, atLeast(1)).createOrRetrieveCopyInstance(isA(Object.class));
    Category clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CategoryImpl);
    List<CategoryXref> allParentCategoryXrefs = clone.getAllParentCategoryXrefs();
    assertEquals(1, allParentCategoryXrefs.size());
    CategoryXref getResult = allParentCategoryXrefs.get(0);
    assertTrue(getResult instanceof CategoryXrefImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getDisplayOrder());
    List<Category> allParentCategories = clone.getAllParentCategories();
    assertEquals(1, allParentCategories.size());
    assertTrue(getResult.getDefaultReference());
    assertSame(categoryImpl2, allParentCategories.get(0));
    assertSame(categoryImpl2, getResult.getCategory());
    assertSame(categoryImpl2, getResult.getSubCategory());
  }

  /**
   * Test {@link CategoryImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link CategoryImpl#getMainEntityName()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getMainEntityName());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Url is {@code :}.
   *   <li>Then return {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplUrlIsColon_thenReturnColon() {
    // Arrange
    categoryImpl.setUrl(":");

    // Act and Assert
    assertEquals(":", categoryImpl.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Url is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplUrlIsEmptyString_thenReturnEmptyString() {
    // Arrange
    categoryImpl.setUrl("");

    // Act and Assert
    assertEquals("", categoryImpl.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Url is {@code foo}.
   *   <li>Then return {@code /foo}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplUrlIsFoo_thenReturnFoo() {
    // Arrange
    categoryImpl.setUrl("foo");

    // Act and Assert
    assertEquals("/foo", categoryImpl.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Url is {@code ?}.
   *   <li>Then return {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplUrlIsQuestionMark_thenReturnQuestionMark() {
    // Arrange
    categoryImpl.setUrl("?");

    // Act and Assert
    assertEquals("?", categoryImpl.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} Url is {@code /}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImplUrlIsSlash_thenReturnSlash() {
    // Arrange
    categoryImpl.setUrl("/");

    // Act and Assert
    assertEquals("/", categoryImpl.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_givenCategoryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(categoryImpl.getLocation());
  }

  /**
   * Test {@link CategoryImpl#getLocation()}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example?}.
   * </ul>
   *
   * <p>Method under test: {@link CategoryImpl#getLocation()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryImpl.getLocation()"})
  public void testGetLocation_thenReturnHttpsExampleOrgExample() {
    // Arrange
    categoryImpl.setUrl("https://example.org/example?");

    // Act and Assert
    assertEquals("https://example.org/example?", categoryImpl.getLocation());
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
