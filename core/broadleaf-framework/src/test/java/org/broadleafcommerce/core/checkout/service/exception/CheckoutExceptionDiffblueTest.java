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
package org.broadleafcommerce.core.checkout.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutSeed;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CheckoutException.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckoutExceptionDiffblueTest {
  @Autowired
  private CheckoutException checkoutException;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutException#CheckoutException()}
   *   <li>{@link CheckoutException#setCheckoutResponse(CheckoutResponse)}
   *   <li>{@link CheckoutException#getCheckoutResponse()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CheckoutException actualCheckoutException = new CheckoutException();
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    actualCheckoutException.setCheckoutResponse(checkoutResponse);
    CheckoutResponse actualCheckoutResponse = actualCheckoutException.getCheckoutResponse();

    // Assert that nothing has changed
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(checkoutResponse, actualCheckoutResponse);
  }

  /**
   * Method under test:
   * {@link CheckoutException#CheckoutException(Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewCheckoutException() {
    // Arrange
    Throwable cause = new Throwable();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    CheckoutException actualCheckoutException = new CheckoutException(cause, seed);

    // Assert
    assertEquals("java.lang.Throwable", actualCheckoutException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getRootCauseMessage());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(cause, actualCheckoutException.getCause());
    assertSame(cause, actualCheckoutException.getRootCause());
    assertSame(seed, actualCheckoutException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link CheckoutException#CheckoutException(Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewCheckoutException2() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    CheckoutException actualCheckoutException = new CheckoutException((Throwable) null, seed);

    // Assert
    assertNull(actualCheckoutException.getLocalizedMessage());
    assertNull(actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getRootCauseMessage());
    assertNull(actualCheckoutException.getCause());
    assertNull(actualCheckoutException.getRootCause());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(seed, actualCheckoutException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link CheckoutException#CheckoutException(Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewCheckoutException3() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    CheckoutException actualCheckoutException = new CheckoutException(cause, seed);

    // Assert
    assertEquals("java.lang.Throwable", actualCheckoutException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getRootCauseMessage());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(cause, actualCheckoutException.getCause());
    assertSame(throwable, actualCheckoutException.getRootCause());
    assertSame(seed, actualCheckoutException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link CheckoutException#CheckoutException(Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewCheckoutException4() {
    // Arrange
    Throwable cause = new Throwable();

    HashMap<String, Object> userDefinedFields = new HashMap<>();
    userDefinedFields.computeIfPresent("foo", mock(BiFunction.class));
    CheckoutSeed seed = new CheckoutSeed(new NullOrderImpl(), userDefinedFields);

    // Act
    CheckoutException actualCheckoutException = new CheckoutException(cause, seed);

    // Assert
    assertEquals("java.lang.Throwable", actualCheckoutException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getRootCauseMessage());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(cause, actualCheckoutException.getCause());
    assertSame(cause, actualCheckoutException.getRootCause());
    assertSame(seed, actualCheckoutException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link CheckoutException#CheckoutException(String, Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewCheckoutException5() {
    // Arrange
    Throwable cause = new Throwable();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    CheckoutException actualCheckoutException = new CheckoutException("An error occurred", cause, seed);

    // Assert
    assertEquals("An error occurred", actualCheckoutException.getLocalizedMessage());
    assertEquals("An error occurred", actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getRootCauseMessage());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(cause, actualCheckoutException.getCause());
    assertSame(cause, actualCheckoutException.getRootCause());
    assertSame(seed, actualCheckoutException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link CheckoutException#CheckoutException(String, Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewCheckoutException6() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    CheckoutException actualCheckoutException = new CheckoutException("An error occurred", null, seed);

    // Assert
    assertEquals("An error occurred", actualCheckoutException.getLocalizedMessage());
    assertEquals("An error occurred", actualCheckoutException.getMessage());
    assertEquals("An error occurred", actualCheckoutException.getRootCauseMessage());
    assertNull(actualCheckoutException.getCause());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(actualCheckoutException, actualCheckoutException.getRootCause());
    assertSame(seed, actualCheckoutException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link CheckoutException#CheckoutException(String, Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewCheckoutException7() {
    // Arrange
    Throwable throwable = new Throwable();
    IOException cause = new IOException("foo", throwable);

    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    CheckoutException actualCheckoutException = new CheckoutException("An error occurred", cause, seed);

    // Assert
    assertEquals("An error occurred", actualCheckoutException.getLocalizedMessage());
    assertEquals("An error occurred", actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getRootCauseMessage());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(cause, actualCheckoutException.getCause());
    assertSame(throwable, actualCheckoutException.getRootCause());
    assertSame(seed, actualCheckoutException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link CheckoutException#CheckoutException(String, Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewCheckoutException8() {
    // Arrange
    Throwable cause = new Throwable();
    NullOrderImpl order = mock(NullOrderImpl.class);
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    CheckoutException actualCheckoutException = new CheckoutException("An error occurred", cause, seed);

    // Assert
    assertEquals("An error occurred", actualCheckoutException.getLocalizedMessage());
    assertEquals("An error occurred", actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getRootCauseMessage());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(cause, actualCheckoutException.getCause());
    assertSame(cause, actualCheckoutException.getRootCause());
    assertSame(seed, actualCheckoutException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link CheckoutException#CheckoutException(String, CheckoutSeed)}
   */
  @Test
  public void testNewCheckoutException9() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    CheckoutException actualCheckoutException = new CheckoutException("An error occurred", seed);

    // Assert
    assertEquals("An error occurred", actualCheckoutException.getLocalizedMessage());
    assertEquals("An error occurred", actualCheckoutException.getMessage());
    assertEquals("An error occurred", actualCheckoutException.getRootCauseMessage());
    assertNull(actualCheckoutException.getCause());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(actualCheckoutException, actualCheckoutException.getRootCause());
    assertSame(seed, actualCheckoutException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link CheckoutException#CheckoutException(String, CheckoutSeed)}
   */
  @Test
  public void testNewCheckoutException10() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    CheckoutException actualCheckoutException = new CheckoutException("An error occurred", seed);

    // Assert
    assertEquals("An error occurred", actualCheckoutException.getLocalizedMessage());
    assertEquals("An error occurred", actualCheckoutException.getMessage());
    assertEquals("An error occurred", actualCheckoutException.getRootCauseMessage());
    assertNull(actualCheckoutException.getCause());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(actualCheckoutException, actualCheckoutException.getRootCause());
    assertSame(seed, actualCheckoutException.getCheckoutResponse());
  }
}
