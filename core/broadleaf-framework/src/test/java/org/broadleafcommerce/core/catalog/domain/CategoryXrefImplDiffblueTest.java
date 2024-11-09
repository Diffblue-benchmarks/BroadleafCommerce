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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class CategoryXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryXrefImpl#setCategory(Category)}
   *   <li>{@link CategoryXrefImpl#setDefaultReference(Boolean)}
   *   <li>{@link CategoryXrefImpl#setDisplayOrder(BigDecimal)}
   *   <li>{@link CategoryXrefImpl#setId(Long)}
   *   <li>{@link CategoryXrefImpl#setSubCategory(Category)}
   *   <li>{@link CategoryXrefImpl#getCategory()}
   *   <li>{@link CategoryXrefImpl#getDefaultReference()}
   *   <li>{@link CategoryXrefImpl#getDisplayOrder()}
   *   <li>{@link CategoryXrefImpl#getId()}
   *   <li>{@link CategoryXrefImpl#getSubCategory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    CategoryImpl category = new CategoryImpl();

    // Act
    categoryXrefImpl.setCategory(category);
    categoryXrefImpl.setDefaultReference(true);
    BigDecimal displayOrder = new BigDecimal("2.3");
    categoryXrefImpl.setDisplayOrder(displayOrder);
    categoryXrefImpl.setId(1L);
    CategoryImpl subCategory = new CategoryImpl();
    categoryXrefImpl.setSubCategory(subCategory);
    Category actualCategory = categoryXrefImpl.getCategory();
    Boolean actualDefaultReference = categoryXrefImpl.getDefaultReference();
    BigDecimal actualDisplayOrder = categoryXrefImpl.getDisplayOrder();
    Long actualId = categoryXrefImpl.getId();
    Category actualSubCategory = categoryXrefImpl.getSubCategory();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertTrue(actualDefaultReference);
    assertEquals(new BigDecimal("2.3"), actualDisplayOrder);
    assertSame(displayOrder, actualDisplayOrder);
    assertSame(category, actualCategory);
    assertSame(subCategory, actualSubCategory);
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}, and
   * {@link CategoryXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryXrefImpl#equals(Object)}
   *   <li>{@link CategoryXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());

    CategoryXrefImpl categoryXrefImpl2 = new CategoryXrefImpl();
    categoryXrefImpl2.setCategory(new CategoryImpl());
    categoryXrefImpl2.setDefaultReference(true);
    categoryXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl2.setId(1L);
    categoryXrefImpl2.setSubCategory(new CategoryImpl());

    // Act and Assert
    assertEquals(categoryXrefImpl, categoryXrefImpl2);
    int expectedHashCodeResult = categoryXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}, and
   * {@link CategoryXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryXrefImpl#equals(Object)}
   *   <li>{@link CategoryXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(null);
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());

    CategoryXrefImpl categoryXrefImpl2 = new CategoryXrefImpl();
    categoryXrefImpl2.setCategory(null);
    categoryXrefImpl2.setDefaultReference(true);
    categoryXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl2.setId(1L);
    categoryXrefImpl2.setSubCategory(new CategoryImpl());

    // Act and Assert
    assertEquals(categoryXrefImpl, categoryXrefImpl2);
    int expectedHashCodeResult = categoryXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}, and
   * {@link CategoryXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryXrefImpl#equals(Object)}
   *   <li>{@link CategoryXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(null);

    CategoryXrefImpl categoryXrefImpl2 = new CategoryXrefImpl();
    categoryXrefImpl2.setCategory(new CategoryImpl());
    categoryXrefImpl2.setDefaultReference(true);
    categoryXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl2.setId(1L);
    categoryXrefImpl2.setSubCategory(null);

    // Act and Assert
    assertEquals(categoryXrefImpl, categoryXrefImpl2);
    int expectedHashCodeResult = categoryXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}, and
   * {@link CategoryXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryXrefImpl#equals(Object)}
   *   <li>{@link CategoryXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());

    // Act and Assert
    assertEquals(categoryXrefImpl, categoryXrefImpl);
    int expectedHashCodeResult = categoryXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryXrefImpl.hashCode());
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(null);
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());

    CategoryXrefImpl categoryXrefImpl2 = new CategoryXrefImpl();
    categoryXrefImpl2.setCategory(new CategoryImpl());
    categoryXrefImpl2.setDefaultReference(true);
    categoryXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl2.setId(1L);
    categoryXrefImpl2.setSubCategory(new CategoryImpl());

    // Act and Assert
    assertNotEquals(categoryXrefImpl, categoryXrefImpl2);
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(mock(CategoryImpl.class));
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());

    CategoryXrefImpl categoryXrefImpl2 = new CategoryXrefImpl();
    categoryXrefImpl2.setCategory(new CategoryImpl());
    categoryXrefImpl2.setDefaultReference(true);
    categoryXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl2.setId(1L);
    categoryXrefImpl2.setSubCategory(new CategoryImpl());

    // Act and Assert
    assertNotEquals(categoryXrefImpl, categoryXrefImpl2);
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(null);

    CategoryXrefImpl categoryXrefImpl2 = new CategoryXrefImpl();
    categoryXrefImpl2.setCategory(new CategoryImpl());
    categoryXrefImpl2.setDefaultReference(true);
    categoryXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl2.setId(1L);
    categoryXrefImpl2.setSubCategory(new CategoryImpl());

    // Act and Assert
    assertNotEquals(categoryXrefImpl, categoryXrefImpl2);
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(mock(CategoryImpl.class));

    CategoryXrefImpl categoryXrefImpl2 = new CategoryXrefImpl();
    categoryXrefImpl2.setCategory(new CategoryImpl());
    categoryXrefImpl2.setDefaultReference(true);
    categoryXrefImpl2.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl2.setId(1L);
    categoryXrefImpl2.setSubCategory(new CategoryImpl());

    // Act and Assert
    assertNotEquals(categoryXrefImpl, categoryXrefImpl2);
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());

    // Act and Assert
    assertNotEquals(categoryXrefImpl, null);
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setCategory(new CategoryImpl());
    categoryXrefImpl.setDefaultReference(true);
    categoryXrefImpl.setDisplayOrder(new BigDecimal("2.3"));
    categoryXrefImpl.setId(1L);
    categoryXrefImpl.setSubCategory(new CategoryImpl());

    // Act and Assert
    assertNotEquals(categoryXrefImpl, "Different type to CategoryXrefImpl");
  }

  /**
   * Test
   * {@link CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryXref> actualCreateOrRetrieveCopyInstanceResult = categoryXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link CategoryXrefImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnCategoryXrefImpl() throws CloneNotSupportedException {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<CategoryXref> actualCreateOrRetrieveCopyInstanceResult = categoryXrefImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService, atLeast(1)).getCeilingImplClass(Mockito.<String>any());
    verify(genericEntityService, atLeast(1)).getIdentifier(Mockito.<Object>any());
    CategoryXref clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CategoryXrefImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(categoryXrefImpl, clone);
  }

  /**
   * Test new {@link CategoryXrefImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CategoryXrefImpl}
   */
  @Test
  public void testNewCategoryXrefImpl() {
    // Arrange and Act
    CategoryXrefImpl actualCategoryXrefImpl = new CategoryXrefImpl();

    // Assert
    Category category = actualCategoryXrefImpl.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = actualCategoryXrefImpl.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertEquals("null", category.getGeneratedUrl());
    assertEquals('N', ((CategoryImpl) category).archiveStatus.getArchived().charValue());
    assertEquals('N', ((CategoryImpl) category).getArchived().charValue());
    assertNull(actualCategoryXrefImpl.getDefaultReference());
    assertNull(category.getId());
    assertNull(actualCategoryXrefImpl.getId());
    assertNull(category.getDescription());
    assertNull(category.getDisplayTemplate());
    assertNull(category.getExternalId());
    assertNull(category.getLongDescription());
    assertNull(category.getMetaDescription());
    assertNull(category.getMetaTitle());
    assertNull(category.getName());
    assertNull(category.getProductDescriptionPatternOverride());
    assertNull(category.getProductTitlePatternOverride());
    assertNull(category.getTaxCode());
    assertNull(category.getUrl());
    assertNull(category.getUrlKey());
    assertNull(((CategoryImpl) category).getLocation());
    assertNull(((CategoryImpl) category).getMainEntityName());
    assertNull(((CategoryImpl) category).description);
    assertNull(((CategoryImpl) category).fulfillmentType);
    assertNull(((CategoryImpl) category).inventoryType);
    assertNull(((CategoryImpl) category).longDescription);
    assertNull(((CategoryImpl) category).name);
    assertNull(((CategoryImpl) category).url);
    assertNull(((CategoryImpl) category).urlKey);
    assertNull(category.getRootDisplayOrder());
    assertNull(actualCategoryXrefImpl.getDisplayOrder());
    assertNull(category.getActiveEndDate());
    assertNull(category.getActiveStartDate());
    assertNull(((CategoryImpl) category).activeStartDate);
    assertNull(((CategoryImpl) category).childCategoryIds);
    assertNull(((CategoryImpl) category).filteredFeaturedProducts);
    assertNull(((CategoryImpl) category).filteredCrossSales);
    assertNull(((CategoryImpl) category).filteredUpSales);
    assertNull(((CategoryImpl) category).childCategoryURLMap);
    assertNull(category.getDefaultParentCategory());
    assertNull(category.getParentCategory());
    assertNull(((CategoryImpl) category).defaultParentCategory);
    assertNull(category.getParentCategoryXref());
    assertNull(category.getInventoryType());
    assertNull(category.getFulfillmentType());
    assertFalse(category.getOverrideGeneratedUrl());
    assertFalse(category.hasAllChildCategories());
    assertFalse(category.hasChildCategories());
    assertFalse(((CategoryImpl) category).overrideGeneratedUrl);
    assertTrue(category.getActiveProductXrefs().isEmpty());
    assertTrue(category.getActiveProducts().isEmpty());
    assertTrue(category.getAllChildCategories().isEmpty());
    assertTrue(category.getAllChildCategoryXrefs().isEmpty());
    assertTrue(category.getAllParentCategories().isEmpty());
    assertTrue(category.getAllParentCategoryXrefs().isEmpty());
    assertTrue(category.getAllProductXrefs().isEmpty());
    assertTrue(category.getAllProducts().isEmpty());
    assertTrue(category.getCategoryAttributes().isEmpty());
    assertTrue(category.getChildCategories().isEmpty());
    assertTrue(category.getChildCategoryXrefs().isEmpty());
    assertTrue(category.getCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeCrossSaleProducts().isEmpty());
    assertTrue(category.getCumulativeFeaturedProducts().isEmpty());
    assertTrue(category.getCumulativeSearchFacets().isEmpty());
    assertTrue(category.getCumulativeUpSaleProducts().isEmpty());
    assertTrue(category.getExcludedSearchFacets().isEmpty());
    assertTrue(category.getFeaturedProducts().isEmpty());
    assertTrue(category.getSearchFacets().isEmpty());
    assertTrue(category.getUpSaleProducts().isEmpty());
    assertTrue(((CategoryImpl) category).allLegacyChildCategories.isEmpty());
    assertTrue(((CategoryImpl) category).childCategoryXrefs.isEmpty());
    assertTrue(((CategoryImpl) category).legacyChildCategories.isEmpty());
    assertTrue(category.getCategoryAttributesMap().isEmpty());
    assertTrue(category.getCategoryMedia().isEmpty());
    assertTrue(category.getCategoryMediaXref().isEmpty());
    assertTrue(category.getMappedCategoryAttributes().isEmpty());
    assertTrue(category.getMultiValueCategoryAttributes().isEmpty());
    assertTrue(((CategoryImpl) category).legacyCategoryMedia.isEmpty());
    assertEquals(category, subCategory);
  }
}
