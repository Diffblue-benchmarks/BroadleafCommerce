package org.broadleafcommerce.openadmin.server.security.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PermissionTypeDiffblueTest {
  /**
   * Test {@link PermissionType#equals(Object)}, and {@link PermissionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PermissionType#equals(Object)}
   *   <li>{@link PermissionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionType.equals(Object)", "int PermissionType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PermissionType permissionType = PermissionType.ALL;
    PermissionType permissionType2 = PermissionType.ALL;

    // Act and Assert
    assertEquals(permissionType, permissionType2);
    assertEquals(permissionType.hashCode(), permissionType2.hashCode());
  }

  /**
   * Test {@link PermissionType#equals(Object)}, and {@link PermissionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PermissionType#equals(Object)}
   *   <li>{@link PermissionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionType.equals(Object)", "int PermissionType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PermissionType permissionType = new PermissionType();
    PermissionType permissionType2 = new PermissionType();

    // Act and Assert
    assertEquals(permissionType, permissionType2);
    assertEquals(permissionType.hashCode(), permissionType2.hashCode());
  }

  /**
   * Test {@link PermissionType#equals(Object)}, and {@link PermissionType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PermissionType#equals(Object)}
   *   <li>{@link PermissionType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionType.equals(Object)", "int PermissionType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PermissionType permissionType = PermissionType.ALL;

    // Act and Assert
    assertEquals(permissionType, permissionType);
    int expectedHashCodeResult = permissionType.hashCode();
    assertEquals(expectedHashCodeResult, permissionType.hashCode());
  }

  /**
   * Test {@link PermissionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PermissionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionType.equals(Object)", "int PermissionType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PermissionType.CREATE, PermissionType.ALL);
  }

  /**
   * Test {@link PermissionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PermissionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionType.equals(Object)", "int PermissionType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PermissionType(), PermissionType.ALL);
  }

  /**
   * Test {@link PermissionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PermissionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionType.equals(Object)", "int PermissionType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PermissionType.ALL, null);
  }

  /**
   * Test {@link PermissionType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PermissionType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionType.equals(Object)", "int PermissionType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PermissionType.ALL, "Different type to PermissionType");
  }
}
