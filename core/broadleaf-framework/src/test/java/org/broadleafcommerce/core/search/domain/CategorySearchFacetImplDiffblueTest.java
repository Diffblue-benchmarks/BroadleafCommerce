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
package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class CategorySearchFacetImplDiffblueTest {
  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}, and {@link
   * CategorySearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategorySearchFacetImpl#equals(Object)}
   *   <li>{@link CategorySearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySearchFacetImpl.equals(Object)",
    "int CategorySearchFacetImpl.hashCode()"
  })
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
    assertEquals(categorySearchFacetImpl.hashCode(), categorySearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategorySearchFacetImpl#equals(Object)}, and {@link
   * CategorySearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategorySearchFacetImpl#equals(Object)}
   *   <li>{@link CategorySearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySearchFacetImpl.equals(Object)",
    "int CategorySearchFacetImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategorySearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySearchFacetImpl.equals(Object)",
    "int CategorySearchFacetImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategorySearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySearchFacetImpl.equals(Object)",
    "int CategorySearchFacetImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategorySearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategorySearchFacetImpl.equals(Object)",
    "int CategorySearchFacetImpl.hashCode()"
  })
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
   * Test {@link CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategorySearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new CategorySearchFacetImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategorySearchFacet> actualCreateOrRetrieveCopyInstanceResult =
        categorySearchFacetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategorySearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();

    CategorySearchFacetImpl categorySearchFacetImpl2 = new CategorySearchFacetImpl();
    categorySearchFacetImpl2.setCategory(new CategoryImpl());
    categorySearchFacetImpl2.setId(1L);
    categorySearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categorySearchFacetImpl2.setSequence(new BigDecimal("2.3"));
    CreateResponse<Object> createResponse = new CreateResponse<>(categorySearchFacetImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategorySearchFacet> actualCreateOrRetrieveCopyInstanceResult =
        categorySearchFacetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategorySearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    SearchFacetImpl searchFacet = mock(SearchFacetImpl.class);
    when(searchFacet.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SearchFacetImpl(), true));

    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setSearchFacet(searchFacet);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new CategorySearchFacetImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    categorySearchFacetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(searchFacet).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategorySearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategorySearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException()
      throws CloneNotSupportedException {
    // Arrange
    SearchFacetImpl searchFacet = mock(SearchFacetImpl.class);
    when(searchFacet.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    CategorySearchFacetImpl categorySearchFacetImpl = new CategorySearchFacetImpl();
    categorySearchFacetImpl.setSearchFacet(searchFacet);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new CategorySearchFacetImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> categorySearchFacetImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(searchFacet).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CategorySearchFacetImpl}
   *   <li>{@link
   *       CategorySearchFacetImpl#setCategory(org.broadleafcommerce.core.catalog.domain.Category)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategorySearchFacetImpl.<init>()",
    "org.broadleafcommerce.core.catalog.domain.Category CategorySearchFacetImpl.getCategory()",
    "Long CategorySearchFacetImpl.getId()",
    "SearchFacet CategorySearchFacetImpl.getSearchFacet()",
    "BigDecimal CategorySearchFacetImpl.getSequence()",
    "void CategorySearchFacetImpl.setCategory(org.broadleafcommerce.core.catalog.domain.Category)",
    "void CategorySearchFacetImpl.setId(Long)",
    "void CategorySearchFacetImpl.setSearchFacet(SearchFacet)",
    "void CategorySearchFacetImpl.setSequence(BigDecimal)"
  })
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
    org.broadleafcommerce.core.catalog.domain.Category actualCategory =
        actualCategorySearchFacetImpl.getCategory();
    Long actualId = actualCategorySearchFacetImpl.getId();
    SearchFacet actualSearchFacet = actualCategorySearchFacetImpl.getSearchFacet();
    BigDecimal actualSequence = actualCategorySearchFacetImpl.getSequence();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(searchFacet, actualSearchFacet);
  }
}
