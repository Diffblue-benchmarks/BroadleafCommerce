/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
   * Method under test: {@link WeaveProductSkuUsage#getUseDefaultSkuInInventory()}
   */
  @Test
  public void testGetUseDefaultSkuInInventory() {
    // Arrange, Act and Assert
    assertFalse((new WeaveProductSkuUsage()).getUseDefaultSkuInInventory());
  }

  /**
   * Method under test: {@link WeaveProductSkuUsage#getUseDefaultSkuInInventory()}
   */
  @Test
  public void testGetUseDefaultSkuInInventory2() {
    // Arrange
    WeaveProductSkuUsage weaveProductSkuUsage = new WeaveProductSkuUsage();
    weaveProductSkuUsage.setUseDefaultSkuInInventory(true);

    // Act and Assert
    assertTrue(weaveProductSkuUsage.getUseDefaultSkuInInventory());
  }

  /**
   * Method under test:
   * {@link WeaveProductSkuUsage#setUseDefaultSkuInInventory(Boolean)}
   */
  @Test
  public void testSetUseDefaultSkuInInventory() {
    // Arrange
    WeaveProductSkuUsage weaveProductSkuUsage = new WeaveProductSkuUsage();

    // Act
    weaveProductSkuUsage.setUseDefaultSkuInInventory(true);

    // Assert
    assertTrue(weaveProductSkuUsage.getUseDefaultSkuInInventory());
    assertTrue(weaveProductSkuUsage.useDefaultSkuInInventory);
  }

  /**
   * Method under test:
   * {@link WeaveProductSkuUsage#setUseDefaultSkuInInventory(Boolean)}
   */
  @Test
  public void testSetUseDefaultSkuInInventory2() {
    // Arrange
    WeaveProductSkuUsage weaveProductSkuUsage = new WeaveProductSkuUsage();

    // Act
    weaveProductSkuUsage.setUseDefaultSkuInInventory(false);

    // Assert
    assertFalse(weaveProductSkuUsage.getUseDefaultSkuInInventory());
    assertFalse(weaveProductSkuUsage.useDefaultSkuInInventory);
  }

  /**
   * Method under test:
   * {@link WeaveProductSkuUsage#setUseDefaultSkuInInventory(Boolean)}
   */
  @Test
  public void testSetUseDefaultSkuInInventory3() {
    // Arrange
    WeaveProductSkuUsage weaveProductSkuUsage = new WeaveProductSkuUsage();

    // Act
    weaveProductSkuUsage.setUseDefaultSkuInInventory(null);

    // Assert
    assertFalse(weaveProductSkuUsage.getUseDefaultSkuInInventory());
    assertFalse(weaveProductSkuUsage.useDefaultSkuInInventory);
  }

  /**
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
