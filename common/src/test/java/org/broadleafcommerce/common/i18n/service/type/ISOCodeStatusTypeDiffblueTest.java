package org.broadleafcommerce.common.i18n.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ISOCodeStatusTypeDiffblueTest {
  /**
   * Test {@link ISOCodeStatusType#getInstance(String)}.
   *
   * <p>Method under test: {@link ISOCodeStatusType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ISOCodeStatusType ISOCodeStatusType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    ISOCodeStatusType actualInstance = ISOCodeStatusType.getInstance("Type");

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
   *   <li>{@link ISOCodeStatusType#ISOCodeStatusType()}
   *   <li>{@link ISOCodeStatusType#getFriendlyType()}
   *   <li>{@link ISOCodeStatusType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ISOCodeStatusType.<init>()",
    "void ISOCodeStatusType.<init>(String, String)",
    "String ISOCodeStatusType.getFriendlyType()",
    "String ISOCodeStatusType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    ISOCodeStatusType actualIsoCodeStatusType = new ISOCodeStatusType();
    String actualFriendlyType = actualIsoCodeStatusType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualIsoCodeStatusType.getType());
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
   *   <li>{@link ISOCodeStatusType#ISOCodeStatusType(String, String)}
   *   <li>{@link ISOCodeStatusType#getFriendlyType()}
   *   <li>{@link ISOCodeStatusType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ISOCodeStatusType.<init>()",
    "void ISOCodeStatusType.<init>(String, String)",
    "String ISOCodeStatusType.getFriendlyType()",
    "String ISOCodeStatusType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    ISOCodeStatusType actualIsoCodeStatusType = new ISOCodeStatusType("Type", "Friendly Type");
    String actualFriendlyType = actualIsoCodeStatusType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualIsoCodeStatusType.getType());
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}, and {@link ISOCodeStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCodeStatusType#equals(Object)}
   *   <li>{@link ISOCodeStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ISOCodeStatusType.equals(Object)",
    "int ISOCodeStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ISOCodeStatusType isoCodeStatusType = ISOCodeStatusType.EXCEPTIONALLY_RESERVED;
    ISOCodeStatusType isoCodeStatusType2 = ISOCodeStatusType.EXCEPTIONALLY_RESERVED;

    // Act and Assert
    assertEquals(isoCodeStatusType, isoCodeStatusType2);
    assertEquals(isoCodeStatusType.hashCode(), isoCodeStatusType2.hashCode());
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}, and {@link ISOCodeStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCodeStatusType#equals(Object)}
   *   <li>{@link ISOCodeStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ISOCodeStatusType.equals(Object)",
    "int ISOCodeStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ISOCodeStatusType isoCodeStatusType = ISOCodeStatusType.INDETERMINATELY_RESERVED;
    ISOCodeStatusType isoCodeStatusType2 =
        new ISOCodeStatusType("INDETERMINATELY_RESERVED", "INDETERMINATELY_RESERVED");

    // Act and Assert
    assertEquals(isoCodeStatusType, isoCodeStatusType2);
    assertEquals(isoCodeStatusType.hashCode(), isoCodeStatusType2.hashCode());
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}, and {@link ISOCodeStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCodeStatusType#equals(Object)}
   *   <li>{@link ISOCodeStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ISOCodeStatusType.equals(Object)",
    "int ISOCodeStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ISOCodeStatusType isoCodeStatusType = new ISOCodeStatusType();
    ISOCodeStatusType isoCodeStatusType2 = new ISOCodeStatusType();

    // Act and Assert
    assertEquals(isoCodeStatusType, isoCodeStatusType2);
    assertEquals(isoCodeStatusType.hashCode(), isoCodeStatusType2.hashCode());
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}, and {@link ISOCodeStatusType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ISOCodeStatusType#equals(Object)}
   *   <li>{@link ISOCodeStatusType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ISOCodeStatusType.equals(Object)",
    "int ISOCodeStatusType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ISOCodeStatusType isoCodeStatusType = ISOCodeStatusType.EXCEPTIONALLY_RESERVED;

    // Act and Assert
    assertEquals(isoCodeStatusType, isoCodeStatusType);
    int expectedHashCodeResult = isoCodeStatusType.hashCode();
    assertEquals(expectedHashCodeResult, isoCodeStatusType.hashCode());
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCodeStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ISOCodeStatusType.equals(Object)",
    "int ISOCodeStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ISOCodeStatusType.INDETERMINATELY_RESERVED, ISOCodeStatusType.EXCEPTIONALLY_RESERVED);
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCodeStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ISOCodeStatusType.equals(Object)",
    "int ISOCodeStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ISOCodeStatusType(), ISOCodeStatusType.EXCEPTIONALLY_RESERVED);
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCodeStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ISOCodeStatusType.equals(Object)",
    "int ISOCodeStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ISOCodeStatusType.EXCEPTIONALLY_RESERVED, null);
  }

  /**
   * Test {@link ISOCodeStatusType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ISOCodeStatusType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ISOCodeStatusType.equals(Object)",
    "int ISOCodeStatusType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ISOCodeStatusType.EXCEPTIONALLY_RESERVED, "Different type to ISOCodeStatusType");
  }
}
