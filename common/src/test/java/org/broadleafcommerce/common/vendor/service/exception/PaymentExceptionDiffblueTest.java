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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentException.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PaymentExceptionDiffblueTest {
  @Autowired
  private PaymentException paymentException;

  /**
   * Test {@link PaymentException#PaymentException()}.
   * <p>
   * Method under test: {@link PaymentException#PaymentException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentException.<init>()"})
  public void testNewPaymentException() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException();

    // Assert
    assertNull(actualPaymentException.getMessage());
    assertNull(actualPaymentException.getCause());
    assertNull(actualPaymentException.getRootCause());
    assertEquals(0, actualPaymentException.getSuppressed().length);
  }

  /**
   * Test {@link PaymentException#PaymentException(String)}.
   * <p>
   * Method under test: {@link PaymentException#PaymentException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentException.<init>(String)"})
  public void testNewPaymentException2() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualPaymentException.getLocalizedMessage());
    assertEquals("An error occurred", actualPaymentException.getMessage());
    assertEquals("An error occurred", actualPaymentException.getRootCauseMessage());
    assertNull(actualPaymentException.getCause());
    assertEquals(0, actualPaymentException.getSuppressed().length);
    assertSame(actualPaymentException, actualPaymentException.getRootCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(Throwable)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentException.<init>(Throwable)"})
  public void testNewPaymentException_givenThrowable_thenReturnRootCauseLocalizedMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);

    // Act
    PaymentException actualPaymentException = new PaymentException(cause);

    // Assert
    Throwable rootCause = actualPaymentException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualPaymentException.getCause().getCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(String, Throwable)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentException.<init>(String, Throwable)"})
  public void testNewPaymentException_givenThrowable_thenReturnRootCauseLocalizedMessageIsNull2() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);

    // Act
    PaymentException actualPaymentException = new PaymentException("An error occurred", cause);

    // Assert
    Throwable rootCause = actualPaymentException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualPaymentException.getCause().getCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(Throwable)}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentException.<init>(Throwable)"})
  public void testNewPaymentException_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PaymentException actualPaymentException = new PaymentException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualPaymentException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualPaymentException.getMessage());
    assertSame(cause, actualPaymentException.getCause());
    assertSame(cause, actualPaymentException.getRootCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(String, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentException.<init>(String, Throwable)"})
  public void testNewPaymentException_whenNull_thenReturnLocalizedMessageIsAnErrorOccurred() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException("An error occurred", null);

    // Assert
    assertEquals("An error occurred", actualPaymentException.getLocalizedMessage());
    assertEquals("An error occurred", actualPaymentException.getMessage());
    assertEquals("An error occurred", actualPaymentException.getRootCauseMessage());
    assertNull(actualPaymentException.getCause());
    assertEquals(0, actualPaymentException.getSuppressed().length);
    assertSame(actualPaymentException, actualPaymentException.getRootCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentException.<init>(Throwable)"})
  public void testNewPaymentException_whenNull_thenReturnLocalizedMessageIsNull() {
    // Arrange and Act
    PaymentException actualPaymentException = new PaymentException((Throwable) null);

    // Assert
    assertNull(actualPaymentException.getLocalizedMessage());
    assertNull(actualPaymentException.getMessage());
    assertNull(actualPaymentException.getCause());
    assertNull(actualPaymentException.getRootCause());
  }

  /**
   * Test {@link PaymentException#PaymentException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return RootCauseMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentException#PaymentException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PaymentException.<init>(String, Throwable)"})
  public void testNewPaymentException_whenThrowable_thenReturnRootCauseMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PaymentException actualPaymentException = new PaymentException("An error occurred", cause);

    // Assert
    assertNull(actualPaymentException.getRootCauseMessage());
    assertSame(cause, actualPaymentException.getCause());
    assertSame(cause, actualPaymentException.getRootCause());
  }
}
