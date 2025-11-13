package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;

public class CategoryAttributeImplDiffblueTest {
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
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
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
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
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
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
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
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual10() {
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
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual11() {
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
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual12() {
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
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual2() {
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
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
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
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
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
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
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
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
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
  public void testEquals_whenOtherIsNull_thenReturnNotEqual2() {
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
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual2() {
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
  public void testGettersAndSetters2() {
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
