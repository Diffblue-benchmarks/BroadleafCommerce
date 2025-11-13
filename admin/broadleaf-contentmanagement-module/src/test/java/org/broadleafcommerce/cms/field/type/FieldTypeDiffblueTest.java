package org.broadleafcommerce.cms.field.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldTypeDiffblueTest {
  /**
   * Test {@link FieldType#getInstance(String)}.
   *
   * <p>Method under test: {@link FieldType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldType FieldType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    FieldType actualInstance = FieldType.getInstance("Type");

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
   *   <li>{@link FieldType#FieldType()}
   *   <li>{@link FieldType#getFriendlyType()}
   *   <li>{@link FieldType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldType.<init>()",
    "void FieldType.<init>(String, String)",
    "String FieldType.getFriendlyType()",
    "String FieldType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    FieldType actualFieldType = new FieldType();
    String actualFriendlyType = actualFieldType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFieldType.getType());
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
   *   <li>{@link FieldType#FieldType(String, String)}
   *   <li>{@link FieldType#getFriendlyType()}
   *   <li>{@link FieldType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldType.<init>()",
    "void FieldType.<init>(String, String)",
    "String FieldType.getFriendlyType()",
    "String FieldType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    FieldType actualFieldType = new FieldType("Type", "Friendly Type");
    String actualFriendlyType = actualFieldType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualFieldType.getType());
  }

  /**
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldType fieldType = FieldType.BOOLEAN;
    FieldType fieldType2 = FieldType.BOOLEAN;

    // Act and Assert
    assertEquals(fieldType, fieldType2);
    assertEquals(fieldType.hashCode(), fieldType2.hashCode());
  }

  /**
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FieldType fieldType = FieldType.DATE;
    FieldType fieldType2 = new FieldType("DATE", "DATE");

    // Act and Assert
    assertEquals(fieldType, fieldType2);
    assertEquals(fieldType.hashCode(), fieldType2.hashCode());
  }

  /**
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FieldType fieldType = new FieldType();
    FieldType fieldType2 = new FieldType();

    // Act and Assert
    assertEquals(fieldType, fieldType2);
    assertEquals(fieldType.hashCode(), fieldType2.hashCode());
  }

  /**
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldType fieldType = FieldType.BOOLEAN;

    // Act and Assert
    assertEquals(fieldType, fieldType);
    int expectedHashCodeResult = fieldType.hashCode();
    assertEquals(expectedHashCodeResult, fieldType.hashCode());
  }

  /**
   * Test {@link FieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.DATE, FieldType.BOOLEAN);
  }

  /**
   * Test {@link FieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new FieldType(), FieldType.BOOLEAN);
  }

  /**
   * Test {@link FieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.BOOLEAN, null);
  }

  /**
   * Test {@link FieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldType.equals(Object)", "int FieldType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.BOOLEAN, "Different type to FieldType");
  }
}
