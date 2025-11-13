package org.broadleafcommerce.common.config.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SystemPropertyFieldTypeDiffblueTest {
  /**
   * Test {@link SystemPropertyFieldType#getInstance(String)}.
   *
   * <p>Method under test: {@link SystemPropertyFieldType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemPropertyFieldType SystemPropertyFieldType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    SystemPropertyFieldType actualInstance = SystemPropertyFieldType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return FriendlyType is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemPropertyFieldType#SystemPropertyFieldType()}
   *   <li>{@link SystemPropertyFieldType#getFriendlyType()}
   *   <li>{@link SystemPropertyFieldType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SystemPropertyFieldType.<init>()",
    "void SystemPropertyFieldType.<init>(String, String)",
    "String SystemPropertyFieldType.getFriendlyType()",
    "String SystemPropertyFieldType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    SystemPropertyFieldType actualSystemPropertyFieldType = new SystemPropertyFieldType();
    String actualFriendlyType = actualSystemPropertyFieldType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSystemPropertyFieldType.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code Friendly Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemPropertyFieldType#SystemPropertyFieldType(String, String)}
   *   <li>{@link SystemPropertyFieldType#getFriendlyType()}
   *   <li>{@link SystemPropertyFieldType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SystemPropertyFieldType.<init>()",
    "void SystemPropertyFieldType.<init>(String, String)",
    "String SystemPropertyFieldType.getFriendlyType()",
    "String SystemPropertyFieldType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    SystemPropertyFieldType actualSystemPropertyFieldType =
        new SystemPropertyFieldType("Type", "Friendly Type");
    String actualFriendlyType = actualSystemPropertyFieldType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualSystemPropertyFieldType.getType());
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}, and {@link
   * SystemPropertyFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemPropertyFieldType#equals(Object)}
   *   <li>{@link SystemPropertyFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyFieldType.equals(Object)",
    "int SystemPropertyFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SystemPropertyFieldType systemPropertyFieldType = SystemPropertyFieldType.BOOLEAN_TYPE;
    SystemPropertyFieldType systemPropertyFieldType2 = SystemPropertyFieldType.BOOLEAN_TYPE;

    // Act and Assert
    assertEquals(systemPropertyFieldType, systemPropertyFieldType2);
    assertEquals(systemPropertyFieldType.hashCode(), systemPropertyFieldType2.hashCode());
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}, and {@link
   * SystemPropertyFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemPropertyFieldType#equals(Object)}
   *   <li>{@link SystemPropertyFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyFieldType.equals(Object)",
    "int SystemPropertyFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SystemPropertyFieldType systemPropertyFieldType = SystemPropertyFieldType.DOUBLE_TYPE;
    SystemPropertyFieldType systemPropertyFieldType2 =
        new SystemPropertyFieldType("DOUBLE_TYPE", "DOUBLE_TYPE");

    // Act and Assert
    assertEquals(systemPropertyFieldType, systemPropertyFieldType2);
    assertEquals(systemPropertyFieldType.hashCode(), systemPropertyFieldType2.hashCode());
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}, and {@link
   * SystemPropertyFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemPropertyFieldType#equals(Object)}
   *   <li>{@link SystemPropertyFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyFieldType.equals(Object)",
    "int SystemPropertyFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SystemPropertyFieldType systemPropertyFieldType = new SystemPropertyFieldType();
    SystemPropertyFieldType systemPropertyFieldType2 = new SystemPropertyFieldType();

    // Act and Assert
    assertEquals(systemPropertyFieldType, systemPropertyFieldType2);
    assertEquals(systemPropertyFieldType.hashCode(), systemPropertyFieldType2.hashCode());
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}, and {@link
   * SystemPropertyFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemPropertyFieldType#equals(Object)}
   *   <li>{@link SystemPropertyFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyFieldType.equals(Object)",
    "int SystemPropertyFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SystemPropertyFieldType systemPropertyFieldType = SystemPropertyFieldType.BOOLEAN_TYPE;

    // Act and Assert
    assertEquals(systemPropertyFieldType, systemPropertyFieldType);
    int expectedHashCodeResult = systemPropertyFieldType.hashCode();
    assertEquals(expectedHashCodeResult, systemPropertyFieldType.hashCode());
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyFieldType.equals(Object)",
    "int SystemPropertyFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SystemPropertyFieldType.DOUBLE_TYPE, SystemPropertyFieldType.BOOLEAN_TYPE);
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyFieldType.equals(Object)",
    "int SystemPropertyFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SystemPropertyFieldType(), SystemPropertyFieldType.BOOLEAN_TYPE);
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyFieldType.equals(Object)",
    "int SystemPropertyFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SystemPropertyFieldType.BOOLEAN_TYPE, null);
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyFieldType.equals(Object)",
    "int SystemPropertyFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        SystemPropertyFieldType.BOOLEAN_TYPE, "Different type to SystemPropertyFieldType");
  }
}
