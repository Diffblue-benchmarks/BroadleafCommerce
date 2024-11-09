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
package org.broadleafcommerce.core.inventory.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class InventoryUnavailableExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Arg0}.</li>
   *   <li>Then return Message is {@code Arg0}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link InventoryUnavailableException#InventoryUnavailableException(String, Long, Integer, Integer)}
   *   <li>{@link InventoryUnavailableException#setSkuId(Long)}
   *   <li>{@link InventoryUnavailableException#getSkuId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenArg0_thenReturnMessageIsArg0() {
    // Arrange and Act
    InventoryUnavailableException actualInventoryUnavailableException = new InventoryUnavailableException("Arg0", 1L, 1,
        1);
    actualInventoryUnavailableException.setSkuId(1L);
    Long actualSkuId = actualInventoryUnavailableException.getSkuId();

    // Assert that nothing has changed
    assertEquals("Arg0", actualInventoryUnavailableException.getMessage());
    assertEquals(0, actualInventoryUnavailableException.getSuppressed().length);
    assertEquals(1, actualInventoryUnavailableException.quantityAvailable.intValue());
    assertEquals(1, actualInventoryUnavailableException.quantityRequested.intValue());
    assertEquals(1L, actualSkuId.longValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Msg}.</li>
   *   <li>Then return Message is {@code Msg}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link InventoryUnavailableException#InventoryUnavailableException(String)}
   *   <li>{@link InventoryUnavailableException#setSkuId(Long)}
   *   <li>{@link InventoryUnavailableException#getSkuId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenMsg_thenReturnMessageIsMsg() {
    // Arrange and Act
    InventoryUnavailableException actualInventoryUnavailableException = new InventoryUnavailableException("Msg");
    actualInventoryUnavailableException.setSkuId(1L);
    Long actualSkuId = actualInventoryUnavailableException.getSkuId();

    // Assert that nothing has changed
    assertEquals("Msg", actualInventoryUnavailableException.getMessage());
    assertEquals(0, actualInventoryUnavailableException.getSuppressed().length);
    assertEquals(1L, actualSkuId.longValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link InventoryUnavailableException#quantityAvailable}
   * intValue is one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link InventoryUnavailableException#InventoryUnavailableException(Long, Integer, Integer)}
   *   <li>{@link InventoryUnavailableException#setSkuId(Long)}
   *   <li>{@link InventoryUnavailableException#getSkuId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenOne_thenReturnQuantityAvailableIntValueIsOne() {
    // Arrange and Act
    InventoryUnavailableException actualInventoryUnavailableException = new InventoryUnavailableException(1L, 1, 1);
    actualInventoryUnavailableException.setSkuId(1L);
    Long actualSkuId = actualInventoryUnavailableException.getSkuId();

    // Assert that nothing has changed
    assertEquals(0, actualInventoryUnavailableException.getSuppressed().length);
    assertEquals(1, actualInventoryUnavailableException.quantityAvailable.intValue());
    assertEquals(1, actualInventoryUnavailableException.quantityRequested.intValue());
    assertEquals(1L, actualSkuId.longValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link InventoryUnavailableException#InventoryUnavailableException(String, Throwable)}
   *   <li>{@link InventoryUnavailableException#setSkuId(Long)}
   *   <li>{@link InventoryUnavailableException#getSkuId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    InventoryUnavailableException actualInventoryUnavailableException = new InventoryUnavailableException("Msg", cause);
    actualInventoryUnavailableException.setSkuId(1L);
    Long actualSkuId = actualInventoryUnavailableException.getSkuId();

    // Assert that nothing has changed
    assertEquals("Msg", actualInventoryUnavailableException.getMessage());
    assertEquals(0, actualInventoryUnavailableException.getSuppressed().length);
    assertEquals(1L, actualSkuId.longValue());
    assertSame(cause, actualInventoryUnavailableException.getCause());
  }

  /**
   * Test {@link InventoryUnavailableException#getQuantityRequested()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InventoryUnavailableException#getQuantityRequested()}
   */
  @Test
  public void testGetQuantityRequested_thenReturnOne() {
    // Arrange
    InventoryUnavailableException inventoryUnavailableException = new InventoryUnavailableException("Msg");
    inventoryUnavailableException.setQuantityRequested(1);

    // Act and Assert
    assertEquals(1, inventoryUnavailableException.getQuantityRequested());
  }

  /**
   * Test {@link InventoryUnavailableException#setQuantityRequested(int)}.
   * <p>
   * Method under test:
   * {@link InventoryUnavailableException#setQuantityRequested(int)}
   */
  @Test
  public void testSetQuantityRequested() {
    // Arrange
    InventoryUnavailableException inventoryUnavailableException = new InventoryUnavailableException("Msg");

    // Act
    inventoryUnavailableException.setQuantityRequested(1);

    // Assert
    assertEquals(1, inventoryUnavailableException.quantityRequested.intValue());
    assertEquals(1, inventoryUnavailableException.getQuantityRequested());
  }

  /**
   * Test {@link InventoryUnavailableException#getQuantityAvailable()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InventoryUnavailableException#getQuantityAvailable()}
   */
  @Test
  public void testGetQuantityAvailable_thenReturnOne() {
    // Arrange
    InventoryUnavailableException inventoryUnavailableException = new InventoryUnavailableException("Msg");
    inventoryUnavailableException.setQuantityAvailable(1);

    // Act and Assert
    assertEquals(1, inventoryUnavailableException.getQuantityAvailable());
  }

  /**
   * Test {@link InventoryUnavailableException#setQuantityAvailable(int)}.
   * <p>
   * Method under test:
   * {@link InventoryUnavailableException#setQuantityAvailable(int)}
   */
  @Test
  public void testSetQuantityAvailable() {
    // Arrange
    InventoryUnavailableException inventoryUnavailableException = new InventoryUnavailableException("Msg");

    // Act
    inventoryUnavailableException.setQuantityAvailable(1);

    // Assert
    assertEquals(1, inventoryUnavailableException.quantityAvailable.intValue());
    assertEquals(1, inventoryUnavailableException.getQuantityAvailable());
  }
}
