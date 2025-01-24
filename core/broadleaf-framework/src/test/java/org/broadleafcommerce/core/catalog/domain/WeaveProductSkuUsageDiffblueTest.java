package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WeaveProductSkuUsageDiffblueTest {
  /**
   * Test {@link WeaveProductSkuUsage#getUseDefaultSkuInInventory()}.
   * <ul>
   *   <li>Given {@link WeaveProductSkuUsage} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveProductSkuUsage#getUseDefaultSkuInInventory()}
   */
  @Test
  public void testGetUseDefaultSkuInInventory_givenWeaveProductSkuUsage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new WeaveProductSkuUsage()).getUseDefaultSkuInInventory());
  }

  /**
   * Test {@link WeaveProductSkuUsage#getUseDefaultSkuInInventory()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveProductSkuUsage#getUseDefaultSkuInInventory()}
   */
  @Test
  public void testGetUseDefaultSkuInInventory_thenReturnTrue() {
    // Arrange
    WeaveProductSkuUsage weaveProductSkuUsage = new WeaveProductSkuUsage();
    weaveProductSkuUsage.setUseDefaultSkuInInventory(true);

    // Act and Assert
    assertTrue(weaveProductSkuUsage.getUseDefaultSkuInInventory());
  }

  /**
   * Test {@link WeaveProductSkuUsage#setUseDefaultSkuInInventory(Boolean)}.
   * <ul>
   *   <li>Then {@link WeaveProductSkuUsage} (default constructor)
   * UseDefaultSkuInInventory.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WeaveProductSkuUsage#setUseDefaultSkuInInventory(Boolean)}
   */
  @Test
  public void testSetUseDefaultSkuInInventory_thenWeaveProductSkuUsageUseDefaultSkuInInventory() {
    // Arrange
    WeaveProductSkuUsage weaveProductSkuUsage = new WeaveProductSkuUsage();

    // Act
    weaveProductSkuUsage.setUseDefaultSkuInInventory(true);

    // Assert
    assertTrue(weaveProductSkuUsage.getUseDefaultSkuInInventory());
    assertTrue(weaveProductSkuUsage.useDefaultSkuInInventory);
  }

  /**
   * Test {@link WeaveProductSkuUsage#setUseDefaultSkuInInventory(Boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WeaveProductSkuUsage#setUseDefaultSkuInInventory(Boolean)}
   */
  @Test
  public void testSetUseDefaultSkuInInventory_whenFalse() {
    // Arrange
    WeaveProductSkuUsage weaveProductSkuUsage = new WeaveProductSkuUsage();

    // Act
    weaveProductSkuUsage.setUseDefaultSkuInInventory(false);

    // Assert
    assertFalse(weaveProductSkuUsage.getUseDefaultSkuInInventory());
    assertFalse(weaveProductSkuUsage.useDefaultSkuInInventory);
  }

  /**
   * Test {@link WeaveProductSkuUsage#setUseDefaultSkuInInventory(Boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WeaveProductSkuUsage#setUseDefaultSkuInInventory(Boolean)}
   */
  @Test
  public void testSetUseDefaultSkuInInventory_whenNull() {
    // Arrange
    WeaveProductSkuUsage weaveProductSkuUsage = new WeaveProductSkuUsage();

    // Act
    weaveProductSkuUsage.setUseDefaultSkuInInventory(null);

    // Assert
    assertFalse(weaveProductSkuUsage.getUseDefaultSkuInInventory());
    assertFalse(weaveProductSkuUsage.useDefaultSkuInInventory);
  }

  /**
   * Test new {@link WeaveProductSkuUsage} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link WeaveProductSkuUsage}
   */
  @Test
  public void testNewWeaveProductSkuUsage() {
    // Arrange and Act
    WeaveProductSkuUsage actualWeaveProductSkuUsage = new WeaveProductSkuUsage();

    // Assert
    assertFalse(actualWeaveProductSkuUsage.getUseDefaultSkuInInventory());
    assertFalse(actualWeaveProductSkuUsage.useDefaultSkuInInventory);
  }
}
