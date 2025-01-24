package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class LastPaymentStatusDiffblueTest {
  /**
   * Test {@link LastPaymentStatus#getInstance(String)}.
   * <p>
   * Method under test: {@link LastPaymentStatus#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    LastPaymentStatus actualInstance = LastPaymentStatus.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LastPaymentStatus#LastPaymentStatus()}
   *   <li>{@link LastPaymentStatus#getFriendlyType()}
   *   <li>{@link LastPaymentStatus#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LastPaymentStatus actualLastPaymentStatus = new LastPaymentStatus();
    String actualFriendlyType = actualLastPaymentStatus.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualLastPaymentStatus.getType());
  }

  /**
   * Test {@link LastPaymentStatus#LastPaymentStatus(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LastPaymentStatus#LastPaymentStatus(String, String)}
   */
  @Test
  public void testNewLastPaymentStatus_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LastPaymentStatus("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link LastPaymentStatus#LastPaymentStatus(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LastPaymentStatus#LastPaymentStatus(String, String)}
   */
  @Test
  public void testNewLastPaymentStatus_whenType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new LastPaymentStatus("Type", "Friendly Type"));

  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}, and
   * {@link LastPaymentStatus#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LastPaymentStatus#equals(Object)}
   *   <li>{@link LastPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LastPaymentStatus lastPaymentStatus = LastPaymentStatus.ERROR;
    LastPaymentStatus lastPaymentStatus2 = LastPaymentStatus.ERROR;

    // Act and Assert
    assertEquals(lastPaymentStatus, lastPaymentStatus2);
    int expectedHashCodeResult = lastPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, lastPaymentStatus2.hashCode());
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}, and
   * {@link LastPaymentStatus#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LastPaymentStatus#equals(Object)}
   *   <li>{@link LastPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LastPaymentStatus lastPaymentStatus = new LastPaymentStatus();
    LastPaymentStatus lastPaymentStatus2 = new LastPaymentStatus();

    // Act and Assert
    assertEquals(lastPaymentStatus, lastPaymentStatus2);
    int expectedHashCodeResult = lastPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, lastPaymentStatus2.hashCode());
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}, and
   * {@link LastPaymentStatus#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LastPaymentStatus#equals(Object)}
   *   <li>{@link LastPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastPaymentStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LastPaymentStatus.OK, LastPaymentStatus.ERROR);
    assertNotEquals(new LastPaymentStatus(), LastPaymentStatus.ERROR);
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastPaymentStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LastPaymentStatus.ERROR, null);
  }

  /**
   * Test {@link LastPaymentStatus#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastPaymentStatus#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LastPaymentStatus.ERROR, "Different type to LastPaymentStatus");
  }
}
