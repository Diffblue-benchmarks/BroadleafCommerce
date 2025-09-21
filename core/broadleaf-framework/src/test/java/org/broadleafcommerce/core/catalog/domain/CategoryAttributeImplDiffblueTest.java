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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
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
public class CategoryAttributeImplDiffblueTest {
  @Autowired private CategoryAttributeImpl categoryAttributeImpl;

  /**
   * Test {@link CategoryAttributeImpl#getValue()}.
   *
   * <p>Method under test: {@link CategoryAttributeImpl#getValue()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryAttributeImpl.getValue()"})
  public void testGetValue() {
    // Arrange, Act and Assert
    assertNull(categoryAttributeImpl.getValue());
  }

  /**
   * Test {@link CategoryAttributeImpl#getName()}.
   *
   * <p>Method under test: {@link CategoryAttributeImpl#getName()}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CategoryAttributeImpl.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(categoryAttributeImpl.getName());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and {@link
   * CategoryAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    assertEquals(categoryAttributeImpl.hashCode(), categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and {@link
   * CategoryAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    assertEquals(categoryAttributeImpl.hashCode(), categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and {@link
   * CategoryAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(null);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    assertEquals(categoryAttributeImpl.hashCode(), categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and {@link
   * CategoryAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(null);
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(null);
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    assertEquals(categoryAttributeImpl.hashCode(), categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and {@link
   * CategoryAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName(null);
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName(null);
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    assertEquals(categoryAttributeImpl.hashCode(), categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and {@link
   * CategoryAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue(null);

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue(null);

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    assertEquals(categoryAttributeImpl.hashCode(), categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and {@link
   * CategoryAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl);
    int expectedHashCodeResult = categoryAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryAttributeImpl.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(2L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(null);
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(mock(CategoryImpl.class));
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("42");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName(null);
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("Name");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue(null);

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, null);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CategoryAttributeImpl.equals(Object)",
    "int CategoryAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, "Different type to CategoryAttributeImpl");
  }

  /**
   * Test {@link CategoryAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new CategoryAttributeImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryAttribute> actualCreateOrRetrieveCopyInstanceResult =
        categoryAttributeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategoryAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(categoryAttributeImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryAttribute> actualCreateOrRetrieveCopyInstanceResult =
        categoryAttributeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link CategoryAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * CategoryAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse CategoryAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    CategoryImpl category = mock(CategoryImpl.class);
    when(category.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new CategoryImpl(), true));

    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(category);

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");
    CreateResponse<Object> createResponse = new CreateResponse<>(categoryAttributeImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryAttribute> actualCreateOrRetrieveCopyInstanceResult =
        categoryAttributeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(category).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CategoryAttributeImpl}
   *   <li>{@link CategoryAttributeImpl#setCategory(Category)}
   *   <li>{@link CategoryAttributeImpl#setId(Long)}
   *   <li>{@link CategoryAttributeImpl#setName(String)}
   *   <li>{@link CategoryAttributeImpl#setValue(String)}
   *   <li>{@link CategoryAttributeImpl#getCategory()}
   *   <li>{@link CategoryAttributeImpl#getId()}
   *   <li>{@link CategoryAttributeImpl#toString()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CategoryAttributeImpl.<init>()",
    "Category CategoryAttributeImpl.getCategory()",
    "Long CategoryAttributeImpl.getId()",
    "void CategoryAttributeImpl.setCategory(Category)",
    "void CategoryAttributeImpl.setId(Long)",
    "void CategoryAttributeImpl.setName(String)",
    "void CategoryAttributeImpl.setValue(String)",
    "String CategoryAttributeImpl.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CategoryAttributeImpl actualCategoryAttributeImpl = new CategoryAttributeImpl();
    CategoryImpl category = new CategoryImpl();
    actualCategoryAttributeImpl.setCategory(category);
    actualCategoryAttributeImpl.setId(1L);
    actualCategoryAttributeImpl.setName("Name");
    actualCategoryAttributeImpl.setValue("42");
    Category actualCategory = actualCategoryAttributeImpl.getCategory();
    Long actualId = actualCategoryAttributeImpl.getId();

    // Assert
    assertEquals("42", actualCategoryAttributeImpl.toString());
    assertEquals(1L, actualId.longValue());
    assertSame(category, actualCategory);
  }
}
