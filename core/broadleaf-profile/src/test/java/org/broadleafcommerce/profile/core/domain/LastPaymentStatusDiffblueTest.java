package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LastPaymentStatusDiffblueTest {
  /**
   * Test {@link LastPaymentStatus#equals(Object)}, and {@link LastPaymentStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LastPaymentStatus#equals(Object)}
   *   <li>{@link LastPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LastPaymentStatus.equals(Object)",
    "int LastPaymentStatus.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LastPaymentStatus lastPaymentStatus = LastPaymentStatus.ERROR;
    LastPaymentStatus lastPaymentStatus2 = LastPaymentStatus.ERROR;

    // Act and Assert
    assertEquals(lastPaymentStatus, lastPaymentStatus2);
    assertEquals(lastPaymentStatus.hashCode(), lastPaymentStatus2.hashCode());
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}, and {@link LastPaymentStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LastPaymentStatus#equals(Object)}
   *   <li>{@link LastPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LastPaymentStatus.equals(Object)",
    "int LastPaymentStatus.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LastPaymentStatus lastPaymentStatus = new LastPaymentStatus();
    LastPaymentStatus lastPaymentStatus2 = new LastPaymentStatus();

    // Act and Assert
    assertEquals(lastPaymentStatus, lastPaymentStatus2);
    assertEquals(lastPaymentStatus.hashCode(), lastPaymentStatus2.hashCode());
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}, and {@link LastPaymentStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LastPaymentStatus#equals(Object)}
   *   <li>{@link LastPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LastPaymentStatus.equals(Object)",
    "int LastPaymentStatus.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LastPaymentStatus lastPaymentStatus = LastPaymentStatus.ERROR;

    // Act and Assert
    assertEquals(lastPaymentStatus, lastPaymentStatus);
    int expectedHashCodeResult = lastPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, lastPaymentStatus.hashCode());
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LastPaymentStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LastPaymentStatus.equals(Object)",
    "int LastPaymentStatus.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LastPaymentStatus.OK, LastPaymentStatus.ERROR);
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LastPaymentStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LastPaymentStatus.equals(Object)",
    "int LastPaymentStatus.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new LastPaymentStatus(), LastPaymentStatus.ERROR);
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LastPaymentStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LastPaymentStatus.equals(Object)",
    "int LastPaymentStatus.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LastPaymentStatus.ERROR, null);
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LastPaymentStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LastPaymentStatus.equals(Object)",
    "int LastPaymentStatus.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LastPaymentStatus.ERROR, "Different type to LastPaymentStatus");
  }
}
