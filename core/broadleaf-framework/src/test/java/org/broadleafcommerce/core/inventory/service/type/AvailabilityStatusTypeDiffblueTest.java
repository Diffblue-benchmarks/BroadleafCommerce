package org.broadleafcommerce.core.inventory.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AvailabilityStatusType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AvailabilityStatusTypeDiffblueTest {
  @Autowired
  private AvailabilityStatusType availabilityStatusType;

  /**
   * Test {@link AvailabilityStatusType#getInstance(String)}.
   * <p>
   * Method under test: {@link AvailabilityStatusType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    AvailabilityStatusType actualInstance = AvailabilityStatusType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AvailabilityStatusType#AvailabilityStatusType()}
   *   <li>{@link AvailabilityStatusType#getFriendlyType()}
   *   <li>{@link AvailabilityStatusType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AvailabilityStatusType actualAvailabilityStatusType = new AvailabilityStatusType();
    String actualFriendlyType = actualAvailabilityStatusType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualAvailabilityStatusType.getType());
  }

  /**
   * Test {@link AvailabilityStatusType#AvailabilityStatusType(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AvailabilityStatusType#AvailabilityStatusType(String, String)}
   */
  @Test
  public void testNewAvailabilityStatusType_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new AvailabilityStatusType("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link AvailabilityStatusType#AvailabilityStatusType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AvailabilityStatusType#AvailabilityStatusType(String, String)}
   */
  @Test
  public void testNewAvailabilityStatusType_whenType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new AvailabilityStatusType("Type", "Friendly Type"));

  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}, and
   * {@link AvailabilityStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AvailabilityStatusType#equals(Object)}
   *   <li>{@link AvailabilityStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AvailabilityStatusType availabilityStatusType = AvailabilityStatusType.AVAILABLE;
    AvailabilityStatusType availabilityStatusType2 = AvailabilityStatusType.AVAILABLE;

    // Act and Assert
    assertEquals(availabilityStatusType, availabilityStatusType2);
    int expectedHashCodeResult = availabilityStatusType.hashCode();
    assertEquals(expectedHashCodeResult, availabilityStatusType2.hashCode());
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}, and
   * {@link AvailabilityStatusType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AvailabilityStatusType#equals(Object)}
   *   <li>{@link AvailabilityStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AvailabilityStatusType availabilityStatusType = new AvailabilityStatusType();
    AvailabilityStatusType availabilityStatusType2 = new AvailabilityStatusType();

    // Act and Assert
    assertEquals(availabilityStatusType, availabilityStatusType2);
    int expectedHashCodeResult = availabilityStatusType.hashCode();
    assertEquals(expectedHashCodeResult, availabilityStatusType2.hashCode());
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}, and
   * {@link AvailabilityStatusType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AvailabilityStatusType#equals(Object)}
   *   <li>{@link AvailabilityStatusType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AvailabilityStatusType availabilityStatusType = AvailabilityStatusType.AVAILABLE;

    // Act and Assert
    assertEquals(availabilityStatusType, availabilityStatusType);
    int expectedHashCodeResult = availabilityStatusType.hashCode();
    assertEquals(expectedHashCodeResult, availabilityStatusType.hashCode());
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvailabilityStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AvailabilityStatusType.BACKORDERED, AvailabilityStatusType.AVAILABLE);
    assertNotEquals(new AvailabilityStatusType(), AvailabilityStatusType.AVAILABLE);
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvailabilityStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AvailabilityStatusType.AVAILABLE, null);
  }

  /**
   * Test {@link AvailabilityStatusType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvailabilityStatusType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AvailabilityStatusType.AVAILABLE, "Different type to AvailabilityStatusType");
  }
}
