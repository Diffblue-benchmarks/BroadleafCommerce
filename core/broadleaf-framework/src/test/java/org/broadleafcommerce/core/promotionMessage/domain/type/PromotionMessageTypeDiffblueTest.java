package org.broadleafcommerce.core.promotionMessage.domain.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {PromotionMessageType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PromotionMessageTypeDiffblueTest {
  @Autowired
  private PromotionMessageType promotionMessageType;

  /**
   * Test {@link PromotionMessageType#getInstance(String)}.
   * <p>
   * Method under test: {@link PromotionMessageType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    PromotionMessageType actualInstance = PromotionMessageType.getInstance("Type");

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
   *   <li>{@link PromotionMessageType#PromotionMessageType()}
   *   <li>{@link PromotionMessageType#setOrder(int)}
   *   <li>{@link PromotionMessageType#getFriendlyType()}
   *   <li>{@link PromotionMessageType#getOrder()}
   *   <li>{@link PromotionMessageType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PromotionMessageType actualPromotionMessageType = new PromotionMessageType();
    actualPromotionMessageType.setOrder(1);
    actualPromotionMessageType.getFriendlyType();
    int actualOrder = actualPromotionMessageType.getOrder();
    actualPromotionMessageType.getType();

    // Assert that nothing has changed
    assertEquals(1, actualOrder);
  }

  /**
   * Test {@link PromotionMessageType#PromotionMessageType(String, String, int)}.
   * <p>
   * Method under test:
   * {@link PromotionMessageType#PromotionMessageType(String, String, int)}
   */
  @Test
  public void testNewPromotionMessageType() {
    // Arrange and Act
    PromotionMessageType actualPromotionMessageType = new PromotionMessageType("Type", "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualPromotionMessageType.getFriendlyType());
    assertEquals("Type", actualPromotionMessageType.getType());
    assertEquals(1, actualPromotionMessageType.getOrder());
  }

  /**
   * Test {@link PromotionMessageType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link PromotionMessageType#QUALIFIERS} Type is
   * {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenQualifiersTypeIsTypeType() {
    // Arrange
    PromotionMessageType promotionMessageType2 = PromotionMessageType.QUALIFIERS;

    // Act
    promotionMessageType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", promotionMessageType2.getType());
  }

  /**
   * Test {@link PromotionMessageType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link PromotionMessageType#QUALIFIERS} Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenQualifiersTypeIsType() {
    // Arrange
    PromotionMessageType promotionMessageType2 = PromotionMessageType.QUALIFIERS;

    // Act
    promotionMessageType2.setType("Type");

    // Assert
    assertEquals("Type", promotionMessageType2.getType());
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}, and
   * {@link PromotionMessageType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PromotionMessageType promotionMessageType = PromotionMessageType.QUALIFIERS;
    PromotionMessageType promotionMessageType2 = PromotionMessageType.QUALIFIERS;

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType2);
    int expectedHashCodeResult = promotionMessageType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageType2.hashCode());
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}, and
   * {@link PromotionMessageType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PromotionMessageType promotionMessageType = new PromotionMessageType();
    PromotionMessageType promotionMessageType2 = new PromotionMessageType();

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType2);
    int expectedHashCodeResult = promotionMessageType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageType2.hashCode());
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}, and
   * {@link PromotionMessageType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PromotionMessageType promotionMessageType = new PromotionMessageType("QUALIFIERS", "Friendly Type", 1);
    PromotionMessageType promotionMessageType2 = PromotionMessageType.QUALIFIERS;

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType2);
    int expectedHashCodeResult = promotionMessageType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageType2.hashCode());
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}, and
   * {@link PromotionMessageType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageType#equals(Object)}
   *   <li>{@link PromotionMessageType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PromotionMessageType promotionMessageType = PromotionMessageType.QUALIFIERS;

    // Act and Assert
    assertEquals(promotionMessageType, promotionMessageType);
    int expectedHashCodeResult = promotionMessageType.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageType.hashCode());
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessageType.TARGETS, PromotionMessageType.QUALIFIERS);
    assertNotEquals(new PromotionMessageType(), PromotionMessageType.QUALIFIERS);
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessageType.QUALIFIERS, null);
  }

  /**
   * Test {@link PromotionMessageType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionMessageType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PromotionMessageType.QUALIFIERS, "Different type to PromotionMessageType");
  }

  /**
   * Test {@link PromotionMessageType#compareTo(PromotionMessageType)} with
   * {@code PromotionMessageType}.
   * <ul>
   *   <li>When {@link PromotionMessageType#QUALIFIERS}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageType#compareTo(PromotionMessageType)}
   */
  @Test
  public void testCompareToWithPromotionMessageType_whenQualifiers_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, PromotionMessageType.QUALIFIERS.compareTo(PromotionMessageType.QUALIFIERS));
  }
}
