/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.vendor.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.vendor.service.message.TaxResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TaxExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaxException#TaxException()}
   *   <li>{@link TaxException#setTaxResponse(TaxResponse)}
   *   <li>{@link TaxException#getTaxResponse()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TaxException.<init>()", "void TaxException.<init>(String)",
      "void TaxException.<init>(String, Throwable)", "void TaxException.<init>(Throwable)",
      "TaxResponse TaxException.getTaxResponse()", "void TaxException.setTaxResponse(TaxResponse)"})
  public void testGettersAndSetters_thenReturnMessageIsNull() {
    // Arrange and Act
    TaxException actualTaxException = new TaxException();
    TaxResponse taxResponse = mock(TaxResponse.class);
    actualTaxException.setTaxResponse(taxResponse);
    TaxResponse actualTaxResponse = actualTaxException.getTaxResponse();

    // Assert
    assertNull(actualTaxException.getMessage());
    assertNull(actualTaxException.getCause());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(taxResponse, actualTaxResponse);
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
   *   <li>{@link TaxException#TaxException(String)}
   *   <li>{@link TaxException#setTaxResponse(TaxResponse)}
   *   <li>{@link TaxException#getTaxResponse()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TaxException.<init>()", "void TaxException.<init>(String)",
      "void TaxException.<init>(String, Throwable)", "void TaxException.<init>(Throwable)",
      "TaxResponse TaxException.getTaxResponse()", "void TaxException.setTaxResponse(TaxResponse)"})
  public void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    TaxException actualTaxException = new TaxException("An error occurred");
    TaxResponse taxResponse = mock(TaxResponse.class);
    actualTaxException.setTaxResponse(taxResponse);
    TaxResponse actualTaxResponse = actualTaxException.getTaxResponse();

    // Assert
    assertEquals("An error occurred", actualTaxException.getMessage());
    assertNull(actualTaxException.getCause());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(taxResponse, actualTaxResponse);
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
   *   <li>{@link TaxException#TaxException(String, Throwable)}
   *   <li>{@link TaxException#setTaxResponse(TaxResponse)}
   *   <li>{@link TaxException#getTaxResponse()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TaxException.<init>()", "void TaxException.<init>(String)",
      "void TaxException.<init>(String, Throwable)", "void TaxException.<init>(Throwable)",
      "TaxResponse TaxException.getTaxResponse()", "void TaxException.setTaxResponse(TaxResponse)"})
  public void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxException actualTaxException = new TaxException("An error occurred", cause);
    TaxResponse taxResponse = mock(TaxResponse.class);
    actualTaxException.setTaxResponse(taxResponse);
    TaxResponse actualTaxResponse = actualTaxException.getTaxResponse();

    // Assert
    assertEquals("An error occurred", actualTaxException.getMessage());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(cause, actualTaxException.getCause());
    assertSame(taxResponse, actualTaxResponse);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaxException#TaxException(Throwable)}
   *   <li>{@link TaxException#setTaxResponse(TaxResponse)}
   *   <li>{@link TaxException#getTaxResponse()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TaxException.<init>()", "void TaxException.<init>(String)",
      "void TaxException.<init>(String, Throwable)", "void TaxException.<init>(Throwable)",
      "TaxResponse TaxException.getTaxResponse()", "void TaxException.setTaxResponse(TaxResponse)"})
  public void testGettersAndSetters_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TaxException actualTaxException = new TaxException(cause);
    TaxResponse taxResponse = mock(TaxResponse.class);
    actualTaxException.setTaxResponse(taxResponse);
    TaxResponse actualTaxResponse = actualTaxException.getTaxResponse();

    // Assert
    assertEquals("java.lang.Throwable", actualTaxException.getMessage());
    assertEquals(0, actualTaxException.getSuppressed().length);
    assertSame(cause, actualTaxException.getCause());
    assertSame(taxResponse, actualTaxResponse);
  }
}
