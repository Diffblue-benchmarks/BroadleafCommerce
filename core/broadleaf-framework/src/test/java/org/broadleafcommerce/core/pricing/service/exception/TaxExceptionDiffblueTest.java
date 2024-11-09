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
package org.broadleafcommerce.core.pricing.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class TaxExceptionDiffblueTest {
  /**
   * Test {@link TaxException#TaxException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxException#TaxException()}
   */
  @Test
  public void testNewTaxException_thenReturnMessageIsNull() {
    // Arrange and Act
    TaxException actualTaxException = new TaxException();

    // Assert
    assertNull(actualTaxException.getMessage());
    assertNull(actualTaxException.getCause());
    assertEquals(0, actualTaxException.getSuppressed().length);
  }

  /**
   * Test {@link TaxException#TaxException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxException#TaxException(String)}
   */
  @Test
  public void testNewTaxException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    TaxException actualTaxException = new TaxException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTaxException.getMessage());
    assertNull(actualTaxException.getCause());
    assertEquals(0, actualTaxException.getSuppressed().length);
  }

  /**
   * Test {@link TaxException#TaxException(String, Throwable)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxException#TaxException(String, Throwable)}
   */
  @Test
  public void testNewTaxException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxException actualTaxException = new TaxException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTaxException.getMessage());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(cause, actualTaxException.getCause());
  }

  /**
   * Test {@link TaxException#TaxException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxException#TaxException(Throwable)}
   */
  @Test
  public void testNewTaxException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxException actualTaxException = new TaxException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualTaxException.getMessage());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(cause, actualTaxException.getCause());
  }
}
