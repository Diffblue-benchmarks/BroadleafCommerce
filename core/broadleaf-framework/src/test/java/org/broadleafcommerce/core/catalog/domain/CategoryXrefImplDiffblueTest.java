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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import org.junit.Test;
import org.mockito.Mockito;

public class CategoryXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Category CategoryXrefImpl.getCategory()",
    "Boolean CategoryXrefImpl.getDefaultReference()",
    "BigDecimal CategoryXrefImpl.getDisplayOrder()",
    "Long CategoryXrefImpl.getId()",
    "Category CategoryXrefImpl.getSubCategory()",
    "void CategoryXrefImpl.setCategory(Category)",
    "void CategoryXrefImpl.setDefaultReference(Boolean)",
    "void CategoryXrefImpl.setDisplayOrder(BigDecimal)",
    "void CategoryXrefImpl.setId(Long)",
    "void CategoryXrefImpl.setSubCategory(Category)"
  })
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

    // Assert
    assertEquals(1L, actualId.longValue());
    assertTrue(actualDefaultReference);
    assertEquals(new BigDecimal("2.3"), actualDisplayOrder);
    assertSame(displayOrder, actualDisplayOrder);
    assertSame(category, actualCategory);
    assertSame(subCategory, actualSubCategory);
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}, and {@link CategoryXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryXrefImpl#equals(Object)}
   *   <li>{@link CategoryXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryXrefImpl.equals(Object)", "int CategoryXrefImpl.hashCode()"})
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
    assertEquals(categoryXrefImpl.hashCode(), categoryXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}, and {@link CategoryXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryXrefImpl#equals(Object)}
   *   <li>{@link CategoryXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryXrefImpl.equals(Object)", "int CategoryXrefImpl.hashCode()"})
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
    assertEquals(categoryXrefImpl.hashCode(), categoryXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}, and {@link CategoryXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryXrefImpl#equals(Object)}
   *   <li>{@link CategoryXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryXrefImpl.equals(Object)", "int CategoryXrefImpl.hashCode()"})
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
    assertEquals(categoryXrefImpl.hashCode(), categoryXrefImpl2.hashCode());
  }

  /**
   * Test {@link CategoryXrefImpl#equals(Object)}, and {@link CategoryXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryXrefImpl#equals(Object)}
   *   <li>{@link CategoryXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryXrefImpl.equals(Object)", "int CategoryXrefImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryXrefImpl.equals(Object)", "int CategoryXrefImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryXrefImpl.equals(Object)", "int CategoryXrefImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryXrefImpl.equals(Object)", "int CategoryXrefImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryXrefImpl.equals(Object)", "int CategoryXrefImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryXrefImpl.equals(Object)", "int CategoryXrefImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryXrefImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryXrefImpl.equals(Object)", "int CategoryXrefImpl.hashCode()"})
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
   * Test {@link CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new CategoryXrefImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryXref> actualCreateOrRetrieveCopyInstanceResult =
        categoryXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    CreateResponse<Category> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new CategoryImpl());

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(createResponse);

    CategoryImpl subCategory = mock(CategoryImpl.class);
    when(subCategory.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new CategoryImpl(), true));

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setSubCategory(subCategory);
    categoryXrefImpl.setCategory(category);

    CreateResponse<Object> createResponse2 = mock(CreateResponse.class);
    when(createResponse2.isAlreadyPopulated()).thenReturn(false);
    when(createResponse2.getClone()).thenReturn(new CategoryXrefImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act
    categoryXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse2).getClone();
    verify(createResponse).getClone();
    verify(createResponse2).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(subCategory).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(category).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link CategoryXrefImpl} (default constructor) SubCategory is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenCategoryXrefImplSubCategoryIsNull()
      throws CloneNotSupportedException {
    // Arrange
    CreateResponse<Category> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new CategoryImpl());

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(createResponse);

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setSubCategory(null);
    categoryXrefImpl.setCategory(category);

    CreateResponse<Object> createResponse2 = mock(CreateResponse.class);
    when(createResponse2.isAlreadyPopulated()).thenReturn(false);
    when(createResponse2.getClone()).thenReturn(new CategoryXrefImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act
    categoryXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse2).getClone();
    verify(createResponse).getClone();
    verify(createResponse2).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(category).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CategoryXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException()
      throws CloneNotSupportedException {
    // Arrange
    CreateResponse<Category> createResponse = mock(CreateResponse.class);
    when(createResponse.getClone()).thenReturn(new CategoryImpl());

    CategoryImpl category = mock(CategoryImpl.class);
    when(category.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(createResponse);

    CategoryImpl subCategory = mock(CategoryImpl.class);
    when(subCategory.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    CategoryXrefImpl categoryXrefImpl = new CategoryXrefImpl();
    categoryXrefImpl.setSubCategory(subCategory);
    categoryXrefImpl.setCategory(category);

    CreateResponse<Object> createResponse2 = mock(CreateResponse.class);
    when(createResponse2.isAlreadyPopulated()).thenReturn(false);
    when(createResponse2.getClone()).thenReturn(new CategoryXrefImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse2);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> categoryXrefImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse2).getClone();
    verify(createResponse).getClone();
    verify(createResponse2).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(subCategory).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(category).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test new {@link CategoryXrefImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CategoryXrefImpl}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CategoryXrefImpl.<init>()"})
  public void testNewCategoryXrefImpl() {
    // Arrange and Act
    CategoryXrefImpl actualCategoryXrefImpl = new CategoryXrefImpl();

    // Assert
    Category category = actualCategoryXrefImpl.getCategory();
    assertTrue(category instanceof CategoryImpl);
    Category subCategory = actualCategoryXrefImpl.getSubCategory();
    assertTrue(subCategory instanceof CategoryImpl);
    assertNull(actualCategoryXrefImpl.getDefaultReference());
    assertNull(actualCategoryXrefImpl.getId());
    assertNull(actualCategoryXrefImpl.getDisplayOrder());
    assertEquals(category, subCategory);
  }
}
