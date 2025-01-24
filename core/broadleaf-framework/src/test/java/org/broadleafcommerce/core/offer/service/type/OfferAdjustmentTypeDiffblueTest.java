package org.broadleafcommerce.core.offer.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {OfferAdjustmentType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferAdjustmentTypeDiffblueTest {
  @Autowired
  private OfferAdjustmentType offerAdjustmentType;

  /**
   * Test {@link OfferAdjustmentType#getInstance(String)}.
   * <p>
   * Method under test: {@link OfferAdjustmentType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    OfferAdjustmentType actualInstance = OfferAdjustmentType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferAdjustmentType#OfferAdjustmentType()}
   *   <li>{@link OfferAdjustmentType#getFriendlyType()}
   *   <li>{@link OfferAdjustmentType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferAdjustmentType actualOfferAdjustmentType = new OfferAdjustmentType();
    String actualFriendlyType = actualOfferAdjustmentType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOfferAdjustmentType.getType());
  }

  /**
   * Test {@link OfferAdjustmentType#OfferAdjustmentType(String, String)}.
   * <p>
   * Method under test:
   * {@link OfferAdjustmentType#OfferAdjustmentType(String, String)}
   */
  @Test
  public void testNewOfferAdjustmentType() {
    // Arrange and Act
    OfferAdjustmentType actualOfferAdjustmentType = new OfferAdjustmentType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOfferAdjustmentType.getFriendlyType());
    assertEquals("Type", actualOfferAdjustmentType.getType());
  }

  /**
   * Test {@link OfferAdjustmentType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link OfferAdjustmentType#FUTURE_CREDIT} Type is
   * {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAdjustmentType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenFuture_creditTypeIsTypeType() {
    // Arrange
    OfferAdjustmentType offerAdjustmentType2 = OfferAdjustmentType.FUTURE_CREDIT;

    // Act
    offerAdjustmentType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerAdjustmentType2.getType());
  }

  /**
   * Test {@link OfferAdjustmentType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link OfferAdjustmentType#FUTURE_CREDIT} Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAdjustmentType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenFuture_creditTypeIsType() {
    // Arrange
    OfferAdjustmentType offerAdjustmentType2 = OfferAdjustmentType.FUTURE_CREDIT;

    // Act
    offerAdjustmentType2.setType("Type");

    // Assert
    assertEquals("Type", offerAdjustmentType2.getType());
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}, and
   * {@link OfferAdjustmentType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferAdjustmentType#equals(Object)}
   *   <li>{@link OfferAdjustmentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferAdjustmentType offerAdjustmentType = OfferAdjustmentType.FUTURE_CREDIT;
    OfferAdjustmentType offerAdjustmentType2 = OfferAdjustmentType.FUTURE_CREDIT;

    // Act and Assert
    assertEquals(offerAdjustmentType, offerAdjustmentType2);
    int expectedHashCodeResult = offerAdjustmentType.hashCode();
    assertEquals(expectedHashCodeResult, offerAdjustmentType2.hashCode());
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}, and
   * {@link OfferAdjustmentType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferAdjustmentType#equals(Object)}
   *   <li>{@link OfferAdjustmentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferAdjustmentType offerAdjustmentType = new OfferAdjustmentType();
    OfferAdjustmentType offerAdjustmentType2 = new OfferAdjustmentType();

    // Act and Assert
    assertEquals(offerAdjustmentType, offerAdjustmentType2);
    int expectedHashCodeResult = offerAdjustmentType.hashCode();
    assertEquals(expectedHashCodeResult, offerAdjustmentType2.hashCode());
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}, and
   * {@link OfferAdjustmentType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferAdjustmentType#equals(Object)}
   *   <li>{@link OfferAdjustmentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferAdjustmentType offerAdjustmentType = new OfferAdjustmentType("FUTURE_CREDIT", "Friendly Type");
    OfferAdjustmentType offerAdjustmentType2 = OfferAdjustmentType.FUTURE_CREDIT;

    // Act and Assert
    assertEquals(offerAdjustmentType, offerAdjustmentType2);
    int expectedHashCodeResult = offerAdjustmentType.hashCode();
    assertEquals(expectedHashCodeResult, offerAdjustmentType2.hashCode());
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}, and
   * {@link OfferAdjustmentType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferAdjustmentType#equals(Object)}
   *   <li>{@link OfferAdjustmentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferAdjustmentType offerAdjustmentType = OfferAdjustmentType.FUTURE_CREDIT;

    // Act and Assert
    assertEquals(offerAdjustmentType, offerAdjustmentType);
    int expectedHashCodeResult = offerAdjustmentType.hashCode();
    assertEquals(expectedHashCodeResult, offerAdjustmentType.hashCode());
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAdjustmentType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferAdjustmentType.ORDER_DISCOUNT, OfferAdjustmentType.FUTURE_CREDIT);
    assertNotEquals(new OfferAdjustmentType(), OfferAdjustmentType.FUTURE_CREDIT);
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAdjustmentType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferAdjustmentType.FUTURE_CREDIT, null);
  }

  /**
   * Test {@link OfferAdjustmentType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferAdjustmentType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferAdjustmentType.FUTURE_CREDIT, "Different type to OfferAdjustmentType");
  }
}
