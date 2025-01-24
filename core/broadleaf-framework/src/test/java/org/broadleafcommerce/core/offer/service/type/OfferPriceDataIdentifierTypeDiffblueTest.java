package org.broadleafcommerce.core.offer.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {OfferPriceDataIdentifierType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferPriceDataIdentifierTypeDiffblueTest {
  @Autowired
  private OfferPriceDataIdentifierType offerPriceDataIdentifierType;

  /**
   * Test {@link OfferPriceDataIdentifierType#getInstance(String)}.
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    OfferPriceDataIdentifierType actualInstance = OfferPriceDataIdentifierType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertEquals(1, actualInstance.getOrder());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#OfferPriceDataIdentifierType()}
   *   <li>{@link OfferPriceDataIdentifierType#setOrder(int)}
   *   <li>{@link OfferPriceDataIdentifierType#getFriendlyType()}
   *   <li>{@link OfferPriceDataIdentifierType#getOrder()}
   *   <li>{@link OfferPriceDataIdentifierType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferPriceDataIdentifierType actualOfferPriceDataIdentifierType = new OfferPriceDataIdentifierType();
    actualOfferPriceDataIdentifierType.setOrder(1);
    actualOfferPriceDataIdentifierType.getFriendlyType();
    int actualOrder = actualOfferPriceDataIdentifierType.getOrder();
    actualOfferPriceDataIdentifierType.getType();

    // Assert that nothing has changed
    assertEquals(1, actualOrder);
  }

  /**
   * Test
   * {@link OfferPriceDataIdentifierType#OfferPriceDataIdentifierType(String, String, int)}.
   * <p>
   * Method under test:
   * {@link OfferPriceDataIdentifierType#OfferPriceDataIdentifierType(String, String, int)}
   */
  @Test
  public void testNewOfferPriceDataIdentifierType() {
    // Arrange and Act
    OfferPriceDataIdentifierType actualOfferPriceDataIdentifierType = new OfferPriceDataIdentifierType("Type",
        "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualOfferPriceDataIdentifierType.getFriendlyType());
    assertEquals("Type", actualOfferPriceDataIdentifierType.getType());
    assertEquals(1, actualOfferPriceDataIdentifierType.getOrder());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link OfferPriceDataIdentifierType#PRODUCT_EXTERNAL_ID} Type is
   * {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenProduct_external_idTypeIsTypeType() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act
    offerPriceDataIdentifierType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", offerPriceDataIdentifierType2.getType());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link OfferPriceDataIdentifierType#PRODUCT_EXTERNAL_ID} Type is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenProduct_external_idTypeIsType() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act
    offerPriceDataIdentifierType2.setType("Type");

    // Assert
    assertEquals("Type", offerPriceDataIdentifierType2.getType());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and
   * {@link OfferPriceDataIdentifierType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType2);
    int expectedHashCodeResult = offerPriceDataIdentifierType.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataIdentifierType2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and
   * {@link OfferPriceDataIdentifierType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType = new OfferPriceDataIdentifierType();
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 = new OfferPriceDataIdentifierType();

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType2);
    int expectedHashCodeResult = offerPriceDataIdentifierType.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataIdentifierType2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and
   * {@link OfferPriceDataIdentifierType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType = new OfferPriceDataIdentifierType("PRODUCT_EXTERNAL_ID",
        "Friendly Type", 1);
    OfferPriceDataIdentifierType offerPriceDataIdentifierType2 = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType2);
    int expectedHashCodeResult = offerPriceDataIdentifierType.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataIdentifierType2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}, and
   * {@link OfferPriceDataIdentifierType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataIdentifierType#equals(Object)}
   *   <li>{@link OfferPriceDataIdentifierType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferPriceDataIdentifierType offerPriceDataIdentifierType = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act and Assert
    assertEquals(offerPriceDataIdentifierType, offerPriceDataIdentifierType);
    int expectedHashCodeResult = offerPriceDataIdentifierType.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataIdentifierType.hashCode());
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferPriceDataIdentifierType.PRODUCT_ID, OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    assertNotEquals(new OfferPriceDataIdentifierType(), OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID, null);
  }

  /**
   * Test {@link OfferPriceDataIdentifierType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataIdentifierType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID, "Different type to OfferPriceDataIdentifierType");
  }

  /**
   * Test
   * {@link OfferPriceDataIdentifierType#compareTo(OfferPriceDataIdentifierType)}
   * with {@code OfferPriceDataIdentifierType}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferPriceDataIdentifierType#compareTo(OfferPriceDataIdentifierType)}
   */
  @Test
  public void testCompareToWithOfferPriceDataIdentifierType_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0,
        OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID.compareTo(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID));
  }
}
