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

public class TaxHostExceptionDiffblueTest {
  /**
   * Test {@link TaxHostException#TaxHostException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxHostException#TaxHostException()}
   */
  @Test
  public void testNewTaxHostException_thenReturnMessageIsNull() {
    // Arrange and Act
    TaxHostException actualTaxHostException = new TaxHostException();

    // Assert
    assertNull(actualTaxHostException.getMessage());
    assertNull(actualTaxHostException.getCause());
    assertNull(actualTaxHostException.getTaxResponse());
    assertEquals(0, actualTaxHostException.getSuppressed().length);
  }

  /**
   * Test {@link TaxHostException#TaxHostException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxHostException#TaxHostException(String)}
   */
  @Test
  public void testNewTaxHostException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    TaxHostException actualTaxHostException = new TaxHostException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTaxHostException.getMessage());
    assertNull(actualTaxHostException.getCause());
    assertNull(actualTaxHostException.getTaxResponse());
    assertEquals(0, actualTaxHostException.getSuppressed().length);
  }

  /**
   * Test {@link TaxHostException#TaxHostException(String, Throwable)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TaxHostException#TaxHostException(String, Throwable)}
   */
  @Test
  public void testNewTaxHostException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxHostException actualTaxHostException = new TaxHostException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTaxHostException.getMessage());
    assertNull(actualTaxHostException.getTaxResponse());
    assertEquals(0, actualTaxHostException.getSuppressed().length);
    assertSame(cause, actualTaxHostException.getCause());
  }

  /**
   * Test {@link TaxHostException#TaxHostException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaxHostException#TaxHostException(Throwable)}
   */
  @Test
  public void testNewTaxHostException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxHostException actualTaxHostException = new TaxHostException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualTaxHostException.getMessage());
    assertNull(actualTaxHostException.getTaxResponse());
    assertEquals(0, actualTaxHostException.getSuppressed().length);
    assertSame(cause, actualTaxHostException.getCause());
  }
}
