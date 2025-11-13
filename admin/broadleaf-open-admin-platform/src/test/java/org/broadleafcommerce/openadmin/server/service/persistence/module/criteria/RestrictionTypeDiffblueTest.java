package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RestrictionTypeDiffblueTest {
  /**
   * Test {@link RestrictionType#equals(Object)}, and {@link RestrictionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RestrictionType#equals(Object)}
   *   <li>{@link RestrictionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RestrictionType.equals(Object)", "int RestrictionType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RestrictionType restrictionType = RestrictionType.BOOLEAN;
    RestrictionType restrictionType2 = RestrictionType.BOOLEAN;

    // Act and Assert
    assertEquals(restrictionType, restrictionType2);
    assertEquals(restrictionType.hashCode(), restrictionType2.hashCode());
  }

  /**
   * Test {@link RestrictionType#equals(Object)}, and {@link RestrictionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RestrictionType#equals(Object)}
   *   <li>{@link RestrictionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RestrictionType.equals(Object)", "int RestrictionType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RestrictionType restrictionType = new RestrictionType();
    RestrictionType restrictionType2 = new RestrictionType();

    // Act and Assert
    assertEquals(restrictionType, restrictionType2);
    assertEquals(restrictionType.hashCode(), restrictionType2.hashCode());
  }

  /**
   * Test {@link RestrictionType#equals(Object)}, and {@link RestrictionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RestrictionType#equals(Object)}
   *   <li>{@link RestrictionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RestrictionType.equals(Object)", "int RestrictionType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RestrictionType restrictionType = RestrictionType.BOOLEAN;

    // Act and Assert
    assertEquals(restrictionType, restrictionType);
    int expectedHashCodeResult = restrictionType.hashCode();
    assertEquals(expectedHashCodeResult, restrictionType.hashCode());
  }

  /**
   * Test {@link RestrictionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RestrictionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RestrictionType.equals(Object)", "int RestrictionType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RestrictionType.CHARACTER, RestrictionType.BOOLEAN);
  }

  /**
   * Test {@link RestrictionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RestrictionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RestrictionType.equals(Object)", "int RestrictionType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RestrictionType(), RestrictionType.BOOLEAN);
  }

  /**
   * Test {@link RestrictionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RestrictionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RestrictionType.equals(Object)", "int RestrictionType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RestrictionType.BOOLEAN, null);
  }

  /**
   * Test {@link RestrictionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RestrictionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RestrictionType.equals(Object)", "int RestrictionType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RestrictionType.BOOLEAN, "Different type to RestrictionType");
  }
}
