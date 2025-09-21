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
public class CategoryExcludedSearchFacetImplDiffblueTest {
  @Autowired private CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl;

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and {@link
   * CategoryExcludedSearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    assertEquals(
        categoryExcludedSearchFacetImpl.hashCode(), categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and {@link
   * CategoryExcludedSearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(null);
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(null);
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    assertEquals(
        categoryExcludedSearchFacetImpl.hashCode(), categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and {@link
   * CategoryExcludedSearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(null);
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(null);
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    assertEquals(
        categoryExcludedSearchFacetImpl.hashCode(), categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and {@link
   * CategoryExcludedSearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(null);

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(null);

    // Act and Assert
    assertEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
    assertEquals(
        categoryExcludedSearchFacetImpl.hashCode(), categoryExcludedSearchFacetImpl2.hashCode());
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}, and {@link
   * CategoryExcludedSearchFacetImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryExcludedSearchFacetImpl#equals(Object)}
   *   <li>{@link CategoryExcludedSearchFacetImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(null);
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(mock(CategoryImpl.class));
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    searchFacet.setId(1L);

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(searchFacet);
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(null);
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(null);

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(BigDecimal.valueOf(1L));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl2 =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl2.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl2.setId(1L);
    categoryExcludedSearchFacetImpl2.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl2.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, categoryExcludedSearchFacetImpl2);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(categoryExcludedSearchFacetImpl, null);
  }

  /**
   * Test {@link CategoryExcludedSearchFacetImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryExcludedSearchFacetImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryExcludedSearchFacetImpl.equals(Object)",
    "int CategoryExcludedSearchFacetImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(new CategoryImpl());
    categoryExcludedSearchFacetImpl.setId(1L);
    categoryExcludedSearchFacetImpl.setSearchFacet(new SearchFacetImpl());
    categoryExcludedSearchFacetImpl.setSequence(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        categoryExcludedSearchFacetImpl, "Different type to CategoryExcludedSearchFacetImpl");
  }

  /**
   * Test {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new CategoryExcludedSearchFacetImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryExcludedSearchFacet> actualCreateOrRetrieveCopyInstanceResult =
        categoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(categoryExcludedSearchFacetImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryExcludedSearchFacet> actualCreateOrRetrieveCopyInstanceResult =
        categoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new CategoryImpl(), true));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(category);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new CategoryExcludedSearchFacetImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    categoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(category).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setCategory(category);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new CategoryExcludedSearchFacetImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> categoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(category).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance5() throws CloneNotSupportedException {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new CategoryImpl(), true));

    SearchFacetImpl searchFacet = mock(SearchFacetImpl.class);
    when(searchFacet.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SearchFacetImpl(), true));

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setSearchFacet(searchFacet);
    categoryExcludedSearchFacetImpl.setCategory(category);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new CategoryExcludedSearchFacetImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    categoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(category).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(searchFacet).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryExcludedSearchFacetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance6() throws CloneNotSupportedException {
    // Arrange
    SearchFacetImpl searchFacet = mock(SearchFacetImpl.class);
    when(searchFacet.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    CategoryExcludedSearchFacetImpl categoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    categoryExcludedSearchFacetImpl.setSearchFacet(searchFacet);
    categoryExcludedSearchFacetImpl.setCategory(mock(CategoryImpl.class));

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new CategoryExcludedSearchFacetImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> categoryExcludedSearchFacetImpl.createOrRetrieveCopyInstance(context));
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
   *   <li>default or parameterless constructor of {@link CategoryExcludedSearchFacetImpl}
   *   <li>{@link
   *       CategoryExcludedSearchFacetImpl#setCategory(org.broadleafcommerce.core.catalog.domain.Category)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryExcludedSearchFacetImpl.<init>()",
    "org.broadleafcommerce.core.catalog.domain.Category CategoryExcludedSearchFacetImpl.getCategory()",
    "Long CategoryExcludedSearchFacetImpl.getId()",
    "SearchFacet CategoryExcludedSearchFacetImpl.getSearchFacet()",
    "BigDecimal CategoryExcludedSearchFacetImpl.getSequence()",
    "void CategoryExcludedSearchFacetImpl.setCategory(org.broadleafcommerce.core.catalog.domain.Category)",
    "void CategoryExcludedSearchFacetImpl.setId(Long)",
    "void CategoryExcludedSearchFacetImpl.setSearchFacet(SearchFacet)",
    "void CategoryExcludedSearchFacetImpl.setSequence(BigDecimal)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CategoryExcludedSearchFacetImpl actualCategoryExcludedSearchFacetImpl =
        new CategoryExcludedSearchFacetImpl();
    CategoryImpl category = new CategoryImpl();
    actualCategoryExcludedSearchFacetImpl.setCategory(category);
    actualCategoryExcludedSearchFacetImpl.setId(1L);
    SearchFacetImpl searchFacet = new SearchFacetImpl();
    actualCategoryExcludedSearchFacetImpl.setSearchFacet(searchFacet);
    BigDecimal sequence = new BigDecimal("2.3");
    actualCategoryExcludedSearchFacetImpl.setSequence(sequence);
    org.broadleafcommerce.core.catalog.domain.Category actualCategory =
        actualCategoryExcludedSearchFacetImpl.getCategory();
    Long actualId = actualCategoryExcludedSearchFacetImpl.getId();
    SearchFacet actualSearchFacet = actualCategoryExcludedSearchFacetImpl.getSearchFacet();
    BigDecimal actualSequence = actualCategoryExcludedSearchFacetImpl.getSequence();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
    assertSame(category, actualCategory);
    assertSame(searchFacet, actualSearchFacet);
  }
}
