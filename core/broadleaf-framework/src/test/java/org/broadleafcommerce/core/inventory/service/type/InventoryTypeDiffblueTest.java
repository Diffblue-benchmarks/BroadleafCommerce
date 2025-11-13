package org.broadleafcommerce.core.inventory.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InventoryTypeDiffblueTest {
  /**
   * Test {@link InventoryType#equals(Object)}, and {@link InventoryType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryType#equals(Object)}
   *   <li>{@link InventoryType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryType.equals(Object)", "int InventoryType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InventoryType inventoryType = InventoryType.ALWAYS_AVAILABLE;
    InventoryType inventoryType2 = InventoryType.ALWAYS_AVAILABLE;

    // Act and Assert
    assertEquals(inventoryType, inventoryType2);
    assertEquals(inventoryType.hashCode(), inventoryType2.hashCode());
  }

  /**
   * Test {@link InventoryType#equals(Object)}, and {@link InventoryType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryType#equals(Object)}
   *   <li>{@link InventoryType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryType.equals(Object)", "int InventoryType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    InventoryType inventoryType = new InventoryType();
    InventoryType inventoryType2 = new InventoryType();

    // Act and Assert
    assertEquals(inventoryType, inventoryType2);
    assertEquals(inventoryType.hashCode(), inventoryType2.hashCode());
  }

  /**
   * Test {@link InventoryType#equals(Object)}, and {@link InventoryType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InventoryType#equals(Object)}
   *   <li>{@link InventoryType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryType.equals(Object)", "int InventoryType.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InventoryType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryType.equals(Object)", "int InventoryType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InventoryType.CHECK_QUANTITY, InventoryType.ALWAYS_AVAILABLE);
  }

  /**
   * Test {@link InventoryType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InventoryType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryType.equals(Object)", "int InventoryType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new InventoryType(), InventoryType.ALWAYS_AVAILABLE);
  }

  /**
   * Test {@link InventoryType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InventoryType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryType.equals(Object)", "int InventoryType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InventoryType.ALWAYS_AVAILABLE, null);
  }

  /**
   * Test {@link InventoryType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InventoryType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InventoryType.equals(Object)", "int InventoryType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InventoryType.ALWAYS_AVAILABLE, "Different type to InventoryType");
  }
}
