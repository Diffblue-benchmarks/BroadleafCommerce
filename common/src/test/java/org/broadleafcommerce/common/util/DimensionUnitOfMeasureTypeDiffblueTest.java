package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DimensionUnitOfMeasureTypeDiffblueTest {
  /**
   * Test {@link DimensionUnitOfMeasureType#getInstance(String)}.
   *
   * <p>Method under test: {@link DimensionUnitOfMeasureType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DimensionUnitOfMeasureType DimensionUnitOfMeasureType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    DimensionUnitOfMeasureType actualInstance = DimensionUnitOfMeasureType.getInstance("Type");

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
   *   <li>{@link DimensionUnitOfMeasureType#DimensionUnitOfMeasureType()}
   *   <li>{@link DimensionUnitOfMeasureType#getFriendlyType()}
   *   <li>{@link DimensionUnitOfMeasureType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DimensionUnitOfMeasureType.<init>()",
    "void DimensionUnitOfMeasureType.<init>(String, String)",
    "String DimensionUnitOfMeasureType.getFriendlyType()",
    "String DimensionUnitOfMeasureType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    DimensionUnitOfMeasureType actualDimensionUnitOfMeasureType = new DimensionUnitOfMeasureType();
    String actualFriendlyType = actualDimensionUnitOfMeasureType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualDimensionUnitOfMeasureType.getType());
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
   *   <li>{@link DimensionUnitOfMeasureType#DimensionUnitOfMeasureType(String, String)}
   *   <li>{@link DimensionUnitOfMeasureType#getFriendlyType()}
   *   <li>{@link DimensionUnitOfMeasureType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DimensionUnitOfMeasureType.<init>()",
    "void DimensionUnitOfMeasureType.<init>(String, String)",
    "String DimensionUnitOfMeasureType.getFriendlyType()",
    "String DimensionUnitOfMeasureType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    DimensionUnitOfMeasureType actualDimensionUnitOfMeasureType =
        new DimensionUnitOfMeasureType("Type", "Friendly Type");
    String actualFriendlyType = actualDimensionUnitOfMeasureType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualDimensionUnitOfMeasureType.getType());
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}, and {@link
   * DimensionUnitOfMeasureType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DimensionUnitOfMeasureType#equals(Object)}
   *   <li>{@link DimensionUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DimensionUnitOfMeasureType.equals(Object)",
    "int DimensionUnitOfMeasureType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType = DimensionUnitOfMeasureType.CENTIMETERS;
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType2 = DimensionUnitOfMeasureType.CENTIMETERS;

    // Act and Assert
    assertEquals(dimensionUnitOfMeasureType, dimensionUnitOfMeasureType2);
    assertEquals(dimensionUnitOfMeasureType.hashCode(), dimensionUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}, and {@link
   * DimensionUnitOfMeasureType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DimensionUnitOfMeasureType#equals(Object)}
   *   <li>{@link DimensionUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DimensionUnitOfMeasureType.equals(Object)",
    "int DimensionUnitOfMeasureType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType = DimensionUnitOfMeasureType.FEET;
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType2 =
        new DimensionUnitOfMeasureType("FEET", "FEET");

    // Act and Assert
    assertEquals(dimensionUnitOfMeasureType, dimensionUnitOfMeasureType2);
    assertEquals(dimensionUnitOfMeasureType.hashCode(), dimensionUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}, and {@link
   * DimensionUnitOfMeasureType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DimensionUnitOfMeasureType#equals(Object)}
   *   <li>{@link DimensionUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DimensionUnitOfMeasureType.equals(Object)",
    "int DimensionUnitOfMeasureType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType = new DimensionUnitOfMeasureType();
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType2 = new DimensionUnitOfMeasureType();

    // Act and Assert
    assertEquals(dimensionUnitOfMeasureType, dimensionUnitOfMeasureType2);
    assertEquals(dimensionUnitOfMeasureType.hashCode(), dimensionUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}, and {@link
   * DimensionUnitOfMeasureType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DimensionUnitOfMeasureType#equals(Object)}
   *   <li>{@link DimensionUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DimensionUnitOfMeasureType.equals(Object)",
    "int DimensionUnitOfMeasureType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType = DimensionUnitOfMeasureType.CENTIMETERS;

    // Act and Assert
    assertEquals(dimensionUnitOfMeasureType, dimensionUnitOfMeasureType);
    int expectedHashCodeResult = dimensionUnitOfMeasureType.hashCode();
    assertEquals(expectedHashCodeResult, dimensionUnitOfMeasureType.hashCode());
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DimensionUnitOfMeasureType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DimensionUnitOfMeasureType.equals(Object)",
    "int DimensionUnitOfMeasureType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DimensionUnitOfMeasureType.FEET, DimensionUnitOfMeasureType.CENTIMETERS);
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DimensionUnitOfMeasureType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DimensionUnitOfMeasureType.equals(Object)",
    "int DimensionUnitOfMeasureType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DimensionUnitOfMeasureType(), DimensionUnitOfMeasureType.CENTIMETERS);
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DimensionUnitOfMeasureType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DimensionUnitOfMeasureType.equals(Object)",
    "int DimensionUnitOfMeasureType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DimensionUnitOfMeasureType.CENTIMETERS, null);
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DimensionUnitOfMeasureType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DimensionUnitOfMeasureType.equals(Object)",
    "int DimensionUnitOfMeasureType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        DimensionUnitOfMeasureType.CENTIMETERS, "Different type to DimensionUnitOfMeasureType");
  }
}
