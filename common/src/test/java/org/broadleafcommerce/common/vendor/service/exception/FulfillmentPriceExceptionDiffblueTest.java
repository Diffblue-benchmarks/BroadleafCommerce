/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.vendor.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.vendor.service.message.FulfillmentPriceExceptionResponse;
import org.junit.Test;

public class FulfillmentPriceExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentPriceException#FulfillmentPriceException()}
   *   <li>
   * {@link FulfillmentPriceException#setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)}
   *   <li>{@link FulfillmentPriceException#getFulfillmentPriceExceptionResponse()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentPriceException actualFulfillmentPriceException = new FulfillmentPriceException();
    FulfillmentPriceExceptionResponse fulfillmentPriceExceptionResponse = mock(FulfillmentPriceExceptionResponse.class);
    actualFulfillmentPriceException.setFulfillmentPriceExceptionResponse(fulfillmentPriceExceptionResponse);
    FulfillmentPriceExceptionResponse actualFulfillmentPriceExceptionResponse = actualFulfillmentPriceException
        .getFulfillmentPriceExceptionResponse();

    // Assert that nothing has changed
    assertEquals(0, actualFulfillmentPriceException.getSuppressed().length);
    assertSame(fulfillmentPriceExceptionResponse, actualFulfillmentPriceExceptionResponse);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentPriceException#FulfillmentPriceException(String)}
   *   <li>
   * {@link FulfillmentPriceException#setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)}
   *   <li>{@link FulfillmentPriceException#getFulfillmentPriceExceptionResponse()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    FulfillmentPriceException actualFulfillmentPriceException = new FulfillmentPriceException("An error occurred");
    FulfillmentPriceExceptionResponse fulfillmentPriceExceptionResponse = mock(FulfillmentPriceExceptionResponse.class);
    actualFulfillmentPriceException.setFulfillmentPriceExceptionResponse(fulfillmentPriceExceptionResponse);
    FulfillmentPriceExceptionResponse actualFulfillmentPriceExceptionResponse = actualFulfillmentPriceException
        .getFulfillmentPriceExceptionResponse();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualFulfillmentPriceException.getMessage());
    assertEquals(0, actualFulfillmentPriceException.getSuppressed().length);
    assertSame(fulfillmentPriceExceptionResponse, actualFulfillmentPriceExceptionResponse);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link FulfillmentPriceException#FulfillmentPriceException(String, Throwable)}
   *   <li>
   * {@link FulfillmentPriceException#setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)}
   *   <li>{@link FulfillmentPriceException#getFulfillmentPriceExceptionResponse()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FulfillmentPriceException actualFulfillmentPriceException = new FulfillmentPriceException("An error occurred",
        cause);
    FulfillmentPriceExceptionResponse fulfillmentPriceExceptionResponse = mock(FulfillmentPriceExceptionResponse.class);
    actualFulfillmentPriceException.setFulfillmentPriceExceptionResponse(fulfillmentPriceExceptionResponse);
    FulfillmentPriceExceptionResponse actualFulfillmentPriceExceptionResponse = actualFulfillmentPriceException
        .getFulfillmentPriceExceptionResponse();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualFulfillmentPriceException.getMessage());
    assertEquals(0, actualFulfillmentPriceException.getSuppressed().length);
    assertSame(cause, actualFulfillmentPriceException.getCause());
    assertSame(fulfillmentPriceExceptionResponse, actualFulfillmentPriceExceptionResponse);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentPriceException#FulfillmentPriceException(Throwable)}
   *   <li>
   * {@link FulfillmentPriceException#setFulfillmentPriceExceptionResponse(FulfillmentPriceExceptionResponse)}
   *   <li>{@link FulfillmentPriceException#getFulfillmentPriceExceptionResponse()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FulfillmentPriceException actualFulfillmentPriceException = new FulfillmentPriceException(cause);
    FulfillmentPriceExceptionResponse fulfillmentPriceExceptionResponse = mock(FulfillmentPriceExceptionResponse.class);
    actualFulfillmentPriceException.setFulfillmentPriceExceptionResponse(fulfillmentPriceExceptionResponse);
    FulfillmentPriceExceptionResponse actualFulfillmentPriceExceptionResponse = actualFulfillmentPriceException
        .getFulfillmentPriceExceptionResponse();

    // Assert that nothing has changed
    assertEquals("java.lang.Throwable", actualFulfillmentPriceException.getMessage());
    assertEquals(0, actualFulfillmentPriceException.getSuppressed().length);
    assertSame(cause, actualFulfillmentPriceException.getCause());
    assertSame(fulfillmentPriceExceptionResponse, actualFulfillmentPriceExceptionResponse);
  }
}
