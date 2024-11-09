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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WeaveSkuMinOrderQuantityDiffblueTest {
  /**
   * Test {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}.
   * <ul>
   *   <li>Given {@link WeaveSkuMinOrderQuantity} (default constructor)
   * HasMinOrderQuantity is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}
   */
  @Test
  public void testHasMinOrderQuantity_givenWeaveSkuMinOrderQuantityHasMinOrderQuantityIsNull() {
    // Arrange
    WeaveSkuMinOrderQuantity weaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();
    weaveSkuMinOrderQuantity.setHasMinOrderQuantity(null);

    // Act and Assert
    assertFalse(weaveSkuMinOrderQuantity.hasMinOrderQuantity());
  }

  /**
   * Test {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}.
   * <ul>
   *   <li>Given {@link WeaveSkuMinOrderQuantity} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}
   */
  @Test
  public void testHasMinOrderQuantity_givenWeaveSkuMinOrderQuantity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new WeaveSkuMinOrderQuantity()).hasMinOrderQuantity());
  }

  /**
   * Test {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveSkuMinOrderQuantity#hasMinOrderQuantity()}
   */
  @Test
  public void testHasMinOrderQuantity_thenReturnTrue() {
    // Arrange
    WeaveSkuMinOrderQuantity weaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();
    weaveSkuMinOrderQuantity.setHasMinOrderQuantity(true);

    // Act and Assert
    assertTrue(weaveSkuMinOrderQuantity.hasMinOrderQuantity());
  }

  /**
   * Test {@link WeaveSkuMinOrderQuantity#getMinOrderQuantity()}.
   * <ul>
   *   <li>Given {@link WeaveSkuMinOrderQuantity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveSkuMinOrderQuantity#getMinOrderQuantity()}
   */
  @Test
  public void testGetMinOrderQuantity_givenWeaveSkuMinOrderQuantity() {
    // Arrange, Act and Assert
    assertEquals(1, (new WeaveSkuMinOrderQuantity()).getMinOrderQuantity().intValue());
  }

  /**
   * Test {@link WeaveSkuMinOrderQuantity#getMinOrderQuantity()}.
   * <ul>
   *   <li>Given {@link WeaveSkuMinOrderQuantity} (default constructor)
   * MinOrderQuantity is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeaveSkuMinOrderQuantity#getMinOrderQuantity()}
   */
  @Test
  public void testGetMinOrderQuantity_givenWeaveSkuMinOrderQuantityMinOrderQuantityIsOne() {
    // Arrange
    WeaveSkuMinOrderQuantity weaveSkuMinOrderQuantity = new WeaveSkuMinOrderQuantity();
    weaveSkuMinOrderQuantity.setMinOrderQuantity(1);

    // Act and Assert
    assertEquals(1, weaveSkuMinOrderQuantity.getMinOrderQuantity().intValue());
  }

  /**
   * Test new {@link WeaveSkuMinOrderQuantity} (default constructor).
   * <p>
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
