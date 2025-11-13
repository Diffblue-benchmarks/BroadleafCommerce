package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;

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
