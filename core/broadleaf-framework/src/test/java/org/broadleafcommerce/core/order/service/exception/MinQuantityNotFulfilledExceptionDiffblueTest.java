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
package org.broadleafcommerce.core.order.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class MinQuantityNotFulfilledExceptionDiffblueTest {
  @MockBean
  private MinQuantityNotFulfilledException minQuantityNotFulfilledException;

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MinQuantityNotFulfilledException#MinQuantityNotFulfilledException(String)}
   *   <li>{@link MinQuantityNotFulfilledException#setProductId(Long)}
   *   <li>{@link MinQuantityNotFulfilledException#getProductId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenAnErrorOccurred() {
    // Arrange and Act
    MinQuantityNotFulfilledException actualMinQuantityNotFulfilledException = new MinQuantityNotFulfilledException(
        "An error occurred");
    actualMinQuantityNotFulfilledException.setProductId(1L);
    Long actualProductId = actualMinQuantityNotFulfilledException.getProductId();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualMinQuantityNotFulfilledException.getMessage());
    assertEquals(0, actualMinQuantityNotFulfilledException.getSuppressed().length);
    assertEquals(1L, actualProductId.longValue());
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
   * {@link MinQuantityNotFulfilledException#MinQuantityNotFulfilledException(String, Throwable)}
   *   <li>{@link MinQuantityNotFulfilledException#setProductId(Long)}
   *   <li>{@link MinQuantityNotFulfilledException#getProductId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    MinQuantityNotFulfilledException actualMinQuantityNotFulfilledException = new MinQuantityNotFulfilledException(
        "An error occurred", cause);
    actualMinQuantityNotFulfilledException.setProductId(1L);
    Long actualProductId = actualMinQuantityNotFulfilledException.getProductId();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualMinQuantityNotFulfilledException.getMessage());
    assertEquals(0, actualMinQuantityNotFulfilledException.getSuppressed().length);
    assertEquals(1L, actualProductId.longValue());
    assertSame(cause, actualMinQuantityNotFulfilledException.getCause());
  }

  /**
   * Test
   * {@link MinQuantityNotFulfilledException#MinQuantityNotFulfilledException(String, Long)}.
   * <p>
   * Method under test:
   * {@link MinQuantityNotFulfilledException#MinQuantityNotFulfilledException(String, Long)}
   */
  @Test
  public void testNewMinQuantityNotFulfilledException() {
    // Arrange and Act
    MinQuantityNotFulfilledException actualMinQuantityNotFulfilledException = new MinQuantityNotFulfilledException(
        "An error occurred", 1L);

    // Assert
    assertEquals("An error occurred", actualMinQuantityNotFulfilledException.getLocalizedMessage());
    assertEquals("An error occurred", actualMinQuantityNotFulfilledException.getMessage());
    assertNull(actualMinQuantityNotFulfilledException.getCause());
    assertEquals(0, actualMinQuantityNotFulfilledException.getSuppressed().length);
    assertEquals(1L, actualMinQuantityNotFulfilledException.getProductId().longValue());
  }
}
