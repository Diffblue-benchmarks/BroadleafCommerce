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
package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class CategorySearchFacetImplDiffblueTest {
  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}, and
   * {@link CategorySearchFacetImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategorySearchFacetImpl#equals(Object)}
   *   <li>{@link CategorySearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(new CategoryImpl());
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategorySearchFacetImpl categorySearchFacetImpl2 = new CategorySearchFacetImpl();
    categorySearchFacetImpl2.setCategory(new CategoryImpl());
    categorySearchFacetImpl2.setId(1L);
    categorySearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categorySearchFacetImpl, categorySearchFacetImpl2);
    int expectedHashCodeResult = categorySearchFacetImpl.hashCode();
    assertEquals(expectedHashCodeResult, categorySearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}, and
   * {@link CategorySearchFacetImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategorySearchFacetImpl#equals(Object)}
   *   <li>{@link CategorySearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(new CategoryImpl());
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categorySearchFacetImpl, categorySearchFacetImpl);
    int expectedHashCodeResult = categorySearchFacetImpl.hashCode();
    assertEquals(expectedHashCodeResult, categorySearchFacetImpl.hashCode());
  }

  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(null);
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategorySearchFacetImpl categorySearchFacetImpl2 = new CategorySearchFacetImpl();
    categorySearchFacetImpl2.setCategory(new CategoryImpl());
    categorySearchFacetImpl2.setId(1L);
    categorySearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categorySearchFacetImpl, categorySearchFacetImpl2);
  }

  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(mock(CategoryImpl.class));
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategorySearchFacetImpl categorySearchFacetImpl2 = new CategorySearchFacetImpl();
    categorySearchFacetImpl2.setCategory(new CategoryImpl());
    categorySearchFacetImpl2.setId(1L);
    categorySearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categorySearchFacetImpl, categorySearchFacetImpl2);
  }

  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(new CategoryImpl());
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categorySearchFacetImpl, null);
  }

  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategorySearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setCategory(new CategoryImpl());
    categorySearchFacetImpl.setId(1L);
    categorySearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categorySearchFacetImpl, "Different type to CategorySearchFacetImpl");
  }

  /**
   * Test
   * {@link CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategorySearchFacet> actualCreateOrRetrieveCopyInstanceResult = categorySearchFacetImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link CategorySearchFacetImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnCategorySearchFacetImpl()
      throws CloneNotSupportedException {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<CategorySearchFacet> actualCreateOrRetrieveCopyInstanceResult = categorySearchFacetImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.search.domain.CategorySearchFacetImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    CategorySearchFacet clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CategorySearchFacetImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(categorySearchFacetImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CategorySearchFacetImpl}
   *   <li>{@link CategorySearchFacetImpl#setCategory(Category)}
   *   <li>{@link CategorySearchFacetImpl#setId(Long)}
   *   <li>{@link CategorySearchFacetImpl#setSearchFacet(SearchFacet)}
   *   <li>{@link CategorySearchFacetImpl#setSequence(BigDecimal)}
   *   <li>{@link CategorySearchFacetImpl#getCategory()}
   *   <li>{@link CategorySearchFacetImpl#getId()}
   *   <li>{@link CategorySearchFacetImpl#getSearchFacet()}
   *   <li>{@link CategorySearchFacetImpl#getSequence()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CategorySearchFacetImpl actualCategorySearchFacetImpl = new CategorySearchFacetImpl();
    CategoryImpl category = new CategoryImpl();
    actualCategorySearchFacetImpl.setCategory(category);
    actualCategorySearchFacetImpl.setId(1L);
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    actualCategorySearchFacetImpl.setSearchFacet(searchFacet);
    BigDecimal sequence = new BigDecimal("2.3");
    actualCategorySearchFacetImpl.setSequence(sequence);
    Category actualCategory = actualCategorySearchFacetImpl.getCategory();
    Long actualId = actualCategorySearchFacetImpl.getId();
    SearchFacet actualSearchFacet = actualCategorySearchFacetImpl.getSearchFacet();
    BigDecimal actualSequence = actualCategorySearchFacetImpl.getSequence();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(searchFacet, actualSearchFacet);
  }
}
