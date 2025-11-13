package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TargetModeTypeDiffblueTest {
  /**
   * Test {@link TargetModeType#getInstance(String)}.
   *
   * <p>Method under test: {@link TargetModeType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TargetModeType TargetModeType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    TargetModeType actualInstance = TargetModeType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
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
   *   <li>{@link TargetModeType#TargetModeType(String, String)}
   *   <li>{@link TargetModeType#getTypes()}
   *   <li>{@link TargetModeType#getFriendlyType()}
   *   <li>{@link TargetModeType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TargetModeType.<init>()",
    "void TargetModeType.<init>(String, String)",
    "String TargetModeType.getFriendlyType()",
    "String TargetModeType.getType()",
    "Map TargetModeType.getTypes()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    TargetModeType actualTargetModeType = new TargetModeType("Type", "Friendly Type");
    Map<String, TargetModeType> actualTypes = actualTargetModeType.getTypes();
    String actualFriendlyType = actualTargetModeType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualTargetModeType.getType());
    assertEquals(4, actualTypes.size());
    assertSame(TargetModeType.PRODUCTION, actualTypes.get("production"));
    assertSame(TargetModeType.SANDBOX, actualTypes.get("sandbox"));
    assertSame(TargetModeType.STAGE, actualTypes.get("stage"));
  }

  /**
   * Test {@link TargetModeType#equals(Object)}, and {@link TargetModeType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TargetModeType#equals(Object)}
   *   <li>{@link TargetModeType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TargetModeType.equals(Object)", "int TargetModeType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TargetModeType targetModeType = TargetModeType.PRODUCTION;
    TargetModeType targetModeType2 = TargetModeType.PRODUCTION;

    // Act and Assert
    assertEquals(targetModeType, targetModeType2);
    assertEquals(targetModeType.hashCode(), targetModeType2.hashCode());
  }

  /**
   * Test {@link TargetModeType#equals(Object)}, and {@link TargetModeType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TargetModeType#equals(Object)}
   *   <li>{@link TargetModeType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TargetModeType.equals(Object)", "int TargetModeType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TargetModeType targetModeType = TargetModeType.SANDBOX;
    TargetModeType targetModeType2 = new TargetModeType("sandbox", "sandbox");

    // Act and Assert
    assertEquals(targetModeType, targetModeType2);
    assertEquals(targetModeType.hashCode(), targetModeType2.hashCode());
  }

  /**
   * Test {@link TargetModeType#equals(Object)}, and {@link TargetModeType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TargetModeType#equals(Object)}
   *   <li>{@link TargetModeType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TargetModeType.equals(Object)", "int TargetModeType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TargetModeType targetModeType = new TargetModeType();
    TargetModeType targetModeType2 = new TargetModeType();

    // Act and Assert
    assertEquals(targetModeType, targetModeType2);
    assertEquals(targetModeType.hashCode(), targetModeType2.hashCode());
  }

  /**
   * Test {@link TargetModeType#equals(Object)}, and {@link TargetModeType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TargetModeType#equals(Object)}
   *   <li>{@link TargetModeType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TargetModeType.equals(Object)", "int TargetModeType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TargetModeType targetModeType = TargetModeType.PRODUCTION;

    // Act and Assert
    assertEquals(targetModeType, targetModeType);
    int expectedHashCodeResult = targetModeType.hashCode();
    assertEquals(expectedHashCodeResult, targetModeType.hashCode());
  }

  /**
   * Test {@link TargetModeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TargetModeType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TargetModeType.equals(Object)", "int TargetModeType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TargetModeType.SANDBOX, TargetModeType.PRODUCTION);
  }

  /**
   * Test {@link TargetModeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TargetModeType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TargetModeType.equals(Object)", "int TargetModeType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TargetModeType(), TargetModeType.PRODUCTION);
  }

  /**
   * Test {@link TargetModeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TargetModeType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TargetModeType.equals(Object)", "int TargetModeType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TargetModeType.PRODUCTION, null);
  }

  /**
   * Test {@link TargetModeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TargetModeType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TargetModeType.equals(Object)", "int TargetModeType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TargetModeType.PRODUCTION, "Different type to TargetModeType");
  }
}
