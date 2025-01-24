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

@ContextConfiguration(classes = {InventoryType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class InventoryTypeDiffblueTest {
  @Autowired
  private InventoryType inventoryType;

  /**
   * Test {@link InventoryType#getInstance(String)}.
   * <p>
   * Method under test: {@link InventoryType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    InventoryType actualInstance = InventoryType.getInstance("Type");

    // Assert
    assertEquals("Type", actualInstance.getType());
    assertEquals("UNAVAILABLE", actualInstance.getFriendlyType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InventoryType#InventoryType()}
   *   <li>{@link InventoryType#getFriendlyType()}
   *   <li>{@link InventoryType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    InventoryType actualInventoryType = new InventoryType();
    String actualFriendlyType = actualInventoryType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualInventoryType.getType());
  }

  /**
   * Test {@link InventoryType#InventoryType(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryType#InventoryType(String, String)}
   */
  @Test
  public void testNewInventoryType_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new InventoryType("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link InventoryType#InventoryType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryType#InventoryType(String, String)}
   */
  @Test
  public void testNewInventoryType_whenType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new InventoryType("Type", "Friendly Type"));

  }

  /**
   * Test {@link InventoryType#equals(Object)}, and
   * {@link InventoryType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InventoryType#equals(Object)}
   *   <li>{@link InventoryType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InventoryType inventoryType = InventoryType.ALWAYS_AVAILABLE;
    InventoryType inventoryType2 = InventoryType.ALWAYS_AVAILABLE;

    // Act and Assert
    assertEquals(inventoryType, inventoryType2);
    int expectedHashCodeResult = inventoryType.hashCode();
    assertEquals(expectedHashCodeResult, inventoryType2.hashCode());
  }

  /**
   * Test {@link InventoryType#equals(Object)}, and
   * {@link InventoryType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InventoryType#equals(Object)}
   *   <li>{@link InventoryType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    InventoryType inventoryType = new InventoryType();
    InventoryType inventoryType2 = new InventoryType();

    // Act and Assert
    assertEquals(inventoryType, inventoryType2);
    int expectedHashCodeResult = inventoryType.hashCode();
    assertEquals(expectedHashCodeResult, inventoryType2.hashCode());
  }

  /**
   * Test {@link InventoryType#equals(Object)}, and
   * {@link InventoryType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InventoryType#equals(Object)}
   *   <li>{@link InventoryType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InventoryType inventoryType = InventoryType.ALWAYS_AVAILABLE;

    // Act and Assert
    assertEquals(inventoryType, inventoryType);
    int expectedHashCodeResult = inventoryType.hashCode();
    assertEquals(expectedHashCodeResult, inventoryType.hashCode());
  }

  /**
   * Test {@link InventoryType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InventoryType.CHECK_QUANTITY, InventoryType.ALWAYS_AVAILABLE);
    assertNotEquals(new InventoryType(), InventoryType.ALWAYS_AVAILABLE);
  }

  /**
   * Test {@link InventoryType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InventoryType.ALWAYS_AVAILABLE, null);
  }

  /**
   * Test {@link InventoryType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InventoryType.ALWAYS_AVAILABLE, "Different type to InventoryType");
  }
}
