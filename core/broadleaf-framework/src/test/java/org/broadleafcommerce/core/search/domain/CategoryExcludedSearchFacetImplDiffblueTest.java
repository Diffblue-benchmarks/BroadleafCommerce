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

public class CategoryExcludedSearchFacetImplDiffblueTest {
  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and
   * {@link CategoryExcludedSearchFacetImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    int expectedHashCodeResult = categoryExcludedSearchFacetImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and
   * {@link CategoryExcludedSearchFacetImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(null);
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(null);
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    int expectedHashCodeResult = categoryExcludedSearchFacetImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and
   * {@link CategoryExcludedSearchFacetImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(null);
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(null);
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    int expectedHashCodeResult = categoryExcludedSearchFacetImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and
   * {@link CategoryExcludedSearchFacetImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(null);

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(null);

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    int expectedHashCodeResult = categoryExcludedSearchFacetImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and
   * {@link CategoryExcludedSearchFacetImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl);
    int expectedHashCodeResult = categoryExcludedSearchFacetImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryExcludedSearchFacetImpl.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(null);
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(mock(CategoryImpl.class));
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    searchFacet.setId(1L);

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(searchFacet);
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(null);
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("4.5"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(null);

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, null);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, "Different type to CategoryExcludedSearchFacetImpl");
  }

  /**
   * Test
   * {@link CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryExcludedSearchFacet> actualCreateOrRetrieveCopyInstanceResult = categoryExcludedSearchFacetImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link CategoryExcludedSearchFacetImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnCategoryExcludedSearchFacetImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<CategoryExcludedSearchFacet> actualCreateOrRetrieveCopyInstanceResult = categoryExcludedSearchFacetImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.search.domain.CategoryExcludedSearchFacetImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    CategoryExcludedSearchFacet clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CategoryExcludedSearchFacetImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(categoryExcludedSearchFacetImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CategoryExcludedSearchFacetImpl}
   *   <li>{@link CategoryExcludedSearchFacetImpl#setCategory(Category)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#setId(Long)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#setSearchFacet(SearchFacet)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#setSequence(BigDecimal)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#getCategory()}
   *   <li>{@link CategoryExcludedSearchFacetImpl#getId()}
   *   <li>{@link CategoryExcludedSearchFacetImpl#getSearchFacet()}
   *   <li>{@link CategoryExcludedSearchFacetImpl#getSequence()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CategoryExcludedSearchFacetImpl actualCategoryExcludedSearchFacetImpl = new CategoryExcludedSearchFacetImpl();
    CategoryImpl category = new CategoryImpl();
    actualCategoryExcludedSearchFacetImpl.setCategory(category);
    actualCategoryExcludedSearchFacetImpl.setId(1L);
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    actualCategoryExcludedSearchFacetImpl.setSearchFacet(searchFacet);
    BigDecimal sequence = new BigDecimal("2.3");
    actualCategoryExcludedSearchFacetImpl.setSequence(sequence);
    Category actualCategory = actualCategoryExcludedSearchFacetImpl.getCategory();
    Long actualId = actualCategoryExcludedSearchFacetImpl.getId();
    SearchFacet actualSearchFacet = actualCategoryExcludedSearchFacetImpl.getSearchFacet();
    BigDecimal actualSequence = actualCategoryExcludedSearchFacetImpl.getSequence();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(searchFacet, actualSearchFacet);
  }
}
