/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
