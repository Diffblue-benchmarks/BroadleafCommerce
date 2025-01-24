package org.broadleafcommerce.core.order.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FulfillmentBandResultAmountType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentBandResultAmountTypeDiffblueTest {
  @Autowired
  private FulfillmentBandResultAmountType fulfillmentBandResultAmountType;

  /**
   * Test {@link FulfillmentBandResultAmountType#getInstance(String)}.
   * <p>
   * Method under test:
   * {@link FulfillmentBandResultAmountType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    FulfillmentBandResultAmountType actualInstance = FulfillmentBandResultAmountType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentBandResultAmountType#FulfillmentBandResultAmountType()}
   *   <li>{@link FulfillmentBandResultAmountType#getFriendlyType()}
   *   <li>{@link FulfillmentBandResultAmountType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentBandResultAmountType actualFulfillmentBandResultAmountType = new FulfillmentBandResultAmountType();
    String actualFriendlyType = actualFulfillmentBandResultAmountType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFulfillmentBandResultAmountType.getType());
  }

  /**
   * Test
   * {@link FulfillmentBandResultAmountType#FulfillmentBandResultAmountType(String, String)}.
   * <p>
   * Method under test:
   * {@link FulfillmentBandResultAmountType#FulfillmentBandResultAmountType(String, String)}
   */
  @Test
  public void testNewFulfillmentBandResultAmountType() {
    // Arrange and Act
    FulfillmentBandResultAmountType actualFulfillmentBandResultAmountType = new FulfillmentBandResultAmountType("Type",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFulfillmentBandResultAmountType.getFriendlyType());
    assertEquals("Type", actualFulfillmentBandResultAmountType.getType());
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}, and
   * {@link FulfillmentBandResultAmountType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentBandResultAmountType#equals(Object)}
   *   <li>{@link FulfillmentBandResultAmountType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType = FulfillmentBandResultAmountType.PERCENTAGE;
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType2 = FulfillmentBandResultAmountType.PERCENTAGE;

    // Act and Assert
    assertEquals(fulfillmentBandResultAmountType, fulfillmentBandResultAmountType2);
    int expectedHashCodeResult = fulfillmentBandResultAmountType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentBandResultAmountType2.hashCode());
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}, and
   * {@link FulfillmentBandResultAmountType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentBandResultAmountType#equals(Object)}
   *   <li>{@link FulfillmentBandResultAmountType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType = new FulfillmentBandResultAmountType();
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType2 = new FulfillmentBandResultAmountType();

    // Act and Assert
    assertEquals(fulfillmentBandResultAmountType, fulfillmentBandResultAmountType2);
    int expectedHashCodeResult = fulfillmentBandResultAmountType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentBandResultAmountType2.hashCode());
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}, and
   * {@link FulfillmentBandResultAmountType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentBandResultAmountType#equals(Object)}
   *   <li>{@link FulfillmentBandResultAmountType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType = new FulfillmentBandResultAmountType("PERCENTAGE",
        "Friendly Type");
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType2 = FulfillmentBandResultAmountType.PERCENTAGE;

    // Act and Assert
    assertEquals(fulfillmentBandResultAmountType, fulfillmentBandResultAmountType2);
    int expectedHashCodeResult = fulfillmentBandResultAmountType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentBandResultAmountType2.hashCode());
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}, and
   * {@link FulfillmentBandResultAmountType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentBandResultAmountType#equals(Object)}
   *   <li>{@link FulfillmentBandResultAmountType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType = FulfillmentBandResultAmountType.PERCENTAGE;

    // Act and Assert
    assertEquals(fulfillmentBandResultAmountType, fulfillmentBandResultAmountType);
    int expectedHashCodeResult = fulfillmentBandResultAmountType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentBandResultAmountType.hashCode());
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandResultAmountType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentBandResultAmountType.RATE, FulfillmentBandResultAmountType.PERCENTAGE);
    assertNotEquals(new FulfillmentBandResultAmountType(), FulfillmentBandResultAmountType.PERCENTAGE);
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandResultAmountType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentBandResultAmountType.PERCENTAGE, null);
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentBandResultAmountType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentBandResultAmountType.PERCENTAGE, "Different type to FulfillmentBandResultAmountType");
  }
}
