package org.broadleafcommerce.core.offer.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferProrationType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferProrationTypeDiffblueTest {
  @Autowired
  private OfferProrationType offerProrationType;

  /**
   * Test {@link OfferProrationType#getInstance(String)}.
   * <p>
   * Method under test: {@link OfferProrationType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    OfferProrationType actualInstance = OfferProrationType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferProrationType#OfferProrationType()}
   *   <li>{@link OfferProrationType#getFriendlyType()}
   *   <li>{@link OfferProrationType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferProrationType actualOfferProrationType = new OfferProrationType();
    String actualFriendlyType = actualOfferProrationType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOfferProrationType.getType());
  }

  /**
   * Test {@link OfferProrationType#OfferProrationType(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferProrationType#OfferProrationType(String, String)}
   */
  @Test
  public void testNewOfferProrationType_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new OfferProrationType("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link OfferProrationType#OfferProrationType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferProrationType#OfferProrationType(String, String)}
   */
  @Test
  public void testNewOfferProrationType_whenType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new OfferProrationType("Type", "Friendly Type"));

  }

  /**
   * Test {@link OfferProrationType#getTypes()}.
   * <p>
   * Method under test: {@link OfferProrationType#getTypes()}
   */
  @Test
  public void testGetTypes() {
    // Arrange and Act
    List<OfferProrationType> actualTypes = OfferProrationType.getTypes();

    // Assert
    assertEquals(7, actualTypes.size());
    OfferProrationType getResult = actualTypes.get(4);
    assertEquals("", getResult.getType());
    OfferProrationType getResult2 = actualTypes.get(3);
    assertEquals("42", getResult2.getType());
    OfferProrationType getResult3 = actualTypes.get(1);
    assertEquals("Distribute discount between qualifiers and targets", getResult3.getFriendlyType());
    OfferProrationType getResult4 = actualTypes.get(2);
    assertEquals("Friendly Type", getResult4.getFriendlyType());
    assertEquals("Friendly Type", getResult2.getFriendlyType());
    assertEquals("Friendly Type", getResult.getFriendlyType());
    OfferProrationType getResult5 = actualTypes.get(5);
    assertEquals("Friendly Type", getResult5.getFriendlyType());
    OfferProrationType getResult6 = actualTypes.get(6);
    assertEquals("Friendly Type", getResult6.getFriendlyType());
    OfferProrationType getResult7 = actualTypes.get(0);
    assertEquals("Record discount to targets", getResult7.getFriendlyType());
    assertEquals("TARGET_AND_QUALIFIER", getResult3.getType());
    assertEquals("TARGET_ONLY", getResult7.getType());
    assertEquals("Type", getResult4.getType());
    assertEquals("java.util.Map$Entry", getResult5.getType());
    assertEquals("org.broadleafcommerce.core.offer.service.type.OfferProrationType", getResult6.getType());
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}, and
   * {@link OfferProrationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferProrationType#equals(Object)}
   *   <li>{@link OfferProrationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferProrationType offerProrationType = OfferProrationType.TARGET_AND_QUALIFIER;
    OfferProrationType offerProrationType2 = OfferProrationType.TARGET_AND_QUALIFIER;

    // Act and Assert
    assertEquals(offerProrationType, offerProrationType2);
    int expectedHashCodeResult = offerProrationType.hashCode();
    assertEquals(expectedHashCodeResult, offerProrationType2.hashCode());
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}, and
   * {@link OfferProrationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferProrationType#equals(Object)}
   *   <li>{@link OfferProrationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferProrationType offerProrationType = new OfferProrationType();
    OfferProrationType offerProrationType2 = new OfferProrationType();

    // Act and Assert
    assertEquals(offerProrationType, offerProrationType2);
    int expectedHashCodeResult = offerProrationType.hashCode();
    assertEquals(expectedHashCodeResult, offerProrationType2.hashCode());
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}, and
   * {@link OfferProrationType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferProrationType#equals(Object)}
   *   <li>{@link OfferProrationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferProrationType offerProrationType = OfferProrationType.TARGET_AND_QUALIFIER;

    // Act and Assert
    assertEquals(offerProrationType, offerProrationType);
    int expectedHashCodeResult = offerProrationType.hashCode();
    assertEquals(expectedHashCodeResult, offerProrationType.hashCode());
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferProrationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferProrationType.TARGET_ONLY, OfferProrationType.TARGET_AND_QUALIFIER);
    assertNotEquals(new OfferProrationType(), OfferProrationType.TARGET_AND_QUALIFIER);
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferProrationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferProrationType.TARGET_AND_QUALIFIER, null);
  }

  /**
   * Test {@link OfferProrationType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferProrationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OfferProrationType.TARGET_AND_QUALIFIER, "Different type to OfferProrationType");
  }
}
