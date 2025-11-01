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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WeaveSkuMinOrderQuantityDiffblueTest {
  /**
   * Method under test: {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}
   */
  @Test
  public void testHasMinOrderQuantity() {
    // Arrange, Act and Assert
    assertFalse((new WeaveSkuMinOrderQuantity()).hasMinOrderQuantity());
  }

  /**
   * Method under test: {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}
   */
  @Test
  public void testHasMinOrderQuantity2() {
    // Arrange
    WeaveSkuMinOrderQuantity weaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();
    weaveSkuMinOrderQuantity.setHasMinOrderQuantity(null);

    // Act and Assert
    assertFalse(weaveSkuMinOrderQuantity.hasMinOrderQuantity());
  }

  /**
   * Method under test: {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}
   */
  @Test
  public void testHasMinOrderQuantity3() {
    // Arrange
    WeaveSkuMinOrderQuantity weaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();
    weaveSkuMinOrderQuantity.setHasMinOrderQuantity(true);

    // Act and Assert
    assertTrue(weaveSkuMinOrderQuantity.hasMinOrderQuantity());
  }

  /**
   * Method under test: {@link WeaveSkuMinOrderQuantity#getMinOrderQuantity()}
   */
  @Test
  public void testGetMinOrderQuantity() {
    // Arrange, Act and Assert
    assertEquals(1, (new WeaveSkuMinOrderQuantity()).getMinOrderQuantity().intValue());
  }

  /**
   * Method under test: {@link WeaveSkuMinOrderQuantity#getMinOrderQuantity()}
   */
  @Test
  public void testGetMinOrderQuantity2() {
    // Arrange
    WeaveSkuMinOrderQuantity weaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();
    weaveSkuMinOrderQuantity.setMinOrderQuantity(1);

    // Act and Assert
    assertEquals(1, weaveSkuMinOrderQuantity.getMinOrderQuantity().intValue());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link WeaveSkuMinOrderQuantity}
   */
  @Test
  public void testNewWeaveSkuMinOrderQuantity() {
    // Arrange and Act
    WeaveSkuMinOrderQuantity actualWeaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();

    // Assert
    assertNull(actualWeaveSkuMinOrderQuantity.minOrderQuantity);
    assertEquals(1, actualWeaveSkuMinOrderQuantity.getMinOrderQuantity().intValue());
    assertFalse(actualWeaveSkuMinOrderQuantity.hasMinOrderQuantity);
  }
}
