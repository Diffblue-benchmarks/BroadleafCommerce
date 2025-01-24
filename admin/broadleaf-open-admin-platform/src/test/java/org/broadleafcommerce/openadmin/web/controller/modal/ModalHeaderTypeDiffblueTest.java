package org.broadleafcommerce.openadmin.web.controller.modal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ModalHeaderType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ModalHeaderTypeDiffblueTest {
  @Autowired
  private ModalHeaderType modalHeaderType;

  /**
   * Test {@link ModalHeaderType#getInstance(String)}.
   * <p>
   * Method under test: {@link ModalHeaderType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    ModalHeaderType actualInstance = ModalHeaderType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModalHeaderType#ModalHeaderType()}
   *   <li>{@link ModalHeaderType#getFriendlyType()}
   *   <li>{@link ModalHeaderType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ModalHeaderType actualModalHeaderType = new ModalHeaderType();
    String actualFriendlyType = actualModalHeaderType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualModalHeaderType.getType());
  }

  /**
   * Test {@link ModalHeaderType#ModalHeaderType(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModalHeaderType#ModalHeaderType(String, String)}
   */
  @Test
  public void testNewModalHeaderType_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new ModalHeaderType("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link ModalHeaderType#ModalHeaderType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModalHeaderType#ModalHeaderType(String, String)}
   */
  @Test
  public void testNewModalHeaderType_whenType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new ModalHeaderType("Type", "Friendly Type"));

  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}, and
   * {@link ModalHeaderType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModalHeaderType#equals(Object)}
   *   <li>{@link ModalHeaderType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModalHeaderType modalHeaderType = ModalHeaderType.ADD_COLLECTION_ITEM;
    ModalHeaderType modalHeaderType2 = ModalHeaderType.ADD_COLLECTION_ITEM;

    // Act and Assert
    assertEquals(modalHeaderType, modalHeaderType2);
    int expectedHashCodeResult = modalHeaderType.hashCode();
    assertEquals(expectedHashCodeResult, modalHeaderType2.hashCode());
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}, and
   * {@link ModalHeaderType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModalHeaderType#equals(Object)}
   *   <li>{@link ModalHeaderType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ModalHeaderType modalHeaderType = new ModalHeaderType();
    ModalHeaderType modalHeaderType2 = new ModalHeaderType();

    // Act and Assert
    assertEquals(modalHeaderType, modalHeaderType2);
    int expectedHashCodeResult = modalHeaderType.hashCode();
    assertEquals(expectedHashCodeResult, modalHeaderType2.hashCode());
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}, and
   * {@link ModalHeaderType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModalHeaderType#equals(Object)}
   *   <li>{@link ModalHeaderType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModalHeaderType modalHeaderType = ModalHeaderType.ADD_COLLECTION_ITEM;

    // Act and Assert
    assertEquals(modalHeaderType, modalHeaderType);
    int expectedHashCodeResult = modalHeaderType.hashCode();
    assertEquals(expectedHashCodeResult, modalHeaderType.hashCode());
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModalHeaderType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModalHeaderType.ADD_ENTITY, ModalHeaderType.ADD_COLLECTION_ITEM);
    assertNotEquals(new ModalHeaderType(), ModalHeaderType.ADD_COLLECTION_ITEM);
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModalHeaderType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModalHeaderType.ADD_COLLECTION_ITEM, null);
  }

  /**
   * Test {@link ModalHeaderType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModalHeaderType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModalHeaderType.ADD_COLLECTION_ITEM, "Different type to ModalHeaderType");
  }
}
