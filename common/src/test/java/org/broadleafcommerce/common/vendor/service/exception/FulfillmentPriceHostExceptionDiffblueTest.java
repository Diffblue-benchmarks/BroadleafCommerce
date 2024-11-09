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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class FulfillmentPriceHostExceptionDiffblueTest {
  /**
   * Test
   * {@link FulfillmentPriceHostException#FulfillmentPriceHostException(String)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentPriceHostException#FulfillmentPriceHostException(String)}
   */
  @Test
  public void testNewFulfillmentPriceHostException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    FulfillmentPriceHostException actualFulfillmentPriceHostException = new FulfillmentPriceHostException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualFulfillmentPriceHostException.getMessage());
    assertNull(actualFulfillmentPriceHostException.getCause());
    assertNull(actualFulfillmentPriceHostException.getFulfillmentPriceExceptionResponse());
    assertEquals(0, actualFulfillmentPriceHostException.getSuppressed().length);
  }

  /**
   * Test
   * {@link FulfillmentPriceHostException#FulfillmentPriceHostException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentPriceHostException#FulfillmentPriceHostException(String, Throwable)}
   */
  @Test
  public void testNewFulfillmentPriceHostException_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FulfillmentPriceHostException actualFulfillmentPriceHostException = new FulfillmentPriceHostException(
        "An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualFulfillmentPriceHostException.getMessage());
    assertNull(actualFulfillmentPriceHostException.getFulfillmentPriceExceptionResponse());
    assertEquals(0, actualFulfillmentPriceHostException.getSuppressed().length);
    assertSame(cause, actualFulfillmentPriceHostException.getCause());
  }

  /**
   * Test
   * {@link FulfillmentPriceHostException#FulfillmentPriceHostException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentPriceHostException#FulfillmentPriceHostException(Throwable)}
   */
  @Test
  public void testNewFulfillmentPriceHostException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    FulfillmentPriceHostException actualFulfillmentPriceHostException = new FulfillmentPriceHostException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualFulfillmentPriceHostException.getMessage());
    assertNull(actualFulfillmentPriceHostException.getFulfillmentPriceExceptionResponse());
    assertEquals(0, actualFulfillmentPriceHostException.getSuppressed().length);
    assertSame(cause, actualFulfillmentPriceHostException.getCause());
  }

  /**
   * Test {@link FulfillmentPriceHostException#FulfillmentPriceHostException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentPriceHostException#FulfillmentPriceHostException()}
   */
  @Test
  public void testNewFulfillmentPriceHostException_thenReturnMessageIsNull() {
    // Arrange and Act
    FulfillmentPriceHostException actualFulfillmentPriceHostException = new FulfillmentPriceHostException();

    // Assert
    assertNull(actualFulfillmentPriceHostException.getMessage());
    assertNull(actualFulfillmentPriceHostException.getCause());
    assertNull(actualFulfillmentPriceHostException.getFulfillmentPriceExceptionResponse());
    assertEquals(0, actualFulfillmentPriceHostException.getSuppressed().length);
  }
}
