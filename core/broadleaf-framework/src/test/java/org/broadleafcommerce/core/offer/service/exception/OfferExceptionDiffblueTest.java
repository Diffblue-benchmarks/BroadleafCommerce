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
package org.broadleafcommerce.core.offer.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutSeed;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferException.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferExceptionDiffblueTest {
  @Autowired
  private OfferException offerException;

  /**
   * Method under test: {@link OfferException#OfferException()}
   */
  @Test
  public void testNewOfferException() {
    // Arrange and Act
    OfferException actualOfferException = new OfferException();

    // Assert
    assertNull(actualOfferException.getMessage());
    assertNull(actualOfferException.getCause());
    assertNull(actualOfferException.getRootCause());
    assertNull(actualOfferException.getCheckoutResponse());
    assertEquals(0, actualOfferException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link OfferException#OfferException(Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewOfferException2() {
    // Arrange
    Throwable cause = new Throwable();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    OfferException actualOfferException = new OfferException(cause, seed);

    // Assert
    assertEquals("java.lang.Throwable", actualOfferException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualOfferException.getMessage());
    assertNull(actualOfferException.getRootCauseMessage());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(cause, actualOfferException.getCause());
    assertSame(cause, actualOfferException.getRootCause());
    assertSame(seed, actualOfferException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link OfferException#OfferException(Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewOfferException3() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    OfferException actualOfferException = new OfferException((Throwable) null, seed);

    // Assert
    assertNull(actualOfferException.getLocalizedMessage());
    assertNull(actualOfferException.getMessage());
    assertNull(actualOfferException.getRootCauseMessage());
    assertNull(actualOfferException.getCause());
    assertNull(actualOfferException.getRootCause());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(seed, actualOfferException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link OfferException#OfferException(Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewOfferException4() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    OfferException actualOfferException = new OfferException(cause, seed);

    // Assert
    assertEquals("java.lang.Throwable", actualOfferException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualOfferException.getMessage());
    assertNull(actualOfferException.getRootCauseMessage());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(cause, actualOfferException.getCause());
    assertSame(throwable, actualOfferException.getRootCause());
    assertSame(seed, actualOfferException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link OfferException#OfferException(Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewOfferException5() {
    // Arrange
    Throwable cause = new Throwable();

    HashMap<String, Object> userDefinedFields = new HashMap<>();
    userDefinedFields.computeIfPresent("foo", mock(BiFunction.class));
    CheckoutSeed seed = new CheckoutSeed(new NullOrderImpl(), userDefinedFields);

    // Act
    OfferException actualOfferException = new OfferException(cause, seed);

    // Assert
    assertEquals("java.lang.Throwable", actualOfferException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualOfferException.getMessage());
    assertNull(actualOfferException.getRootCauseMessage());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(cause, actualOfferException.getCause());
    assertSame(cause, actualOfferException.getRootCause());
    assertSame(seed, actualOfferException.getCheckoutResponse());
  }

  /**
   * Method under test: {@link OfferException#OfferException(String)}
   */
  @Test
  public void testNewOfferException6() {
    // Arrange and Act
    OfferException actualOfferException = new OfferException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOfferException.getLocalizedMessage());
    assertEquals("An error occurred", actualOfferException.getMessage());
    assertEquals("An error occurred", actualOfferException.getRootCauseMessage());
    assertNull(actualOfferException.getCause());
    assertNull(actualOfferException.getCheckoutResponse());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(actualOfferException, actualOfferException.getRootCause());
  }

  /**
   * Method under test:
   * {@link OfferException#OfferException(String, Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewOfferException7() {
    // Arrange
    Throwable cause = new Throwable();
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    OfferException actualOfferException = new OfferException("An error occurred", cause, seed);

    // Assert
    assertEquals("An error occurred", actualOfferException.getLocalizedMessage());
    assertEquals("An error occurred", actualOfferException.getMessage());
    assertNull(actualOfferException.getRootCauseMessage());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(cause, actualOfferException.getCause());
    assertSame(cause, actualOfferException.getRootCause());
    assertSame(seed, actualOfferException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link OfferException#OfferException(String, Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewOfferException8() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    OfferException actualOfferException = new OfferException("An error occurred", null, seed);

    // Assert
    assertEquals("An error occurred", actualOfferException.getLocalizedMessage());
    assertEquals("An error occurred", actualOfferException.getMessage());
    assertEquals("An error occurred", actualOfferException.getRootCauseMessage());
    assertNull(actualOfferException.getCause());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(seed, actualOfferException.getCheckoutResponse());
    assertSame(actualOfferException, actualOfferException.getRootCause());
  }

  /**
   * Method under test:
   * {@link OfferException#OfferException(String, Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewOfferException9() {
    // Arrange
    Throwable throwable = new Throwable();
    IOException cause = new IOException("foo", throwable);

    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    OfferException actualOfferException = new OfferException("An error occurred", cause, seed);

    // Assert
    assertEquals("An error occurred", actualOfferException.getLocalizedMessage());
    assertEquals("An error occurred", actualOfferException.getMessage());
    assertNull(actualOfferException.getRootCauseMessage());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(cause, actualOfferException.getCause());
    assertSame(throwable, actualOfferException.getRootCause());
    assertSame(seed, actualOfferException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link OfferException#OfferException(String, Throwable, CheckoutSeed)}
   */
  @Test
  public void testNewOfferException10() {
    // Arrange
    Throwable cause = new Throwable();
    NullOrderImpl order = mock(NullOrderImpl.class);
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    OfferException actualOfferException = new OfferException("An error occurred", cause, seed);

    // Assert
    assertEquals("An error occurred", actualOfferException.getLocalizedMessage());
    assertEquals("An error occurred", actualOfferException.getMessage());
    assertNull(actualOfferException.getRootCauseMessage());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(cause, actualOfferException.getCause());
    assertSame(cause, actualOfferException.getRootCause());
    assertSame(seed, actualOfferException.getCheckoutResponse());
  }

  /**
   * Method under test:
   * {@link OfferException#OfferException(String, CheckoutSeed)}
   */
  @Test
  public void testNewOfferException11() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    OfferException actualOfferException = new OfferException("An error occurred", seed);

    // Assert
    assertEquals("An error occurred", actualOfferException.getLocalizedMessage());
    assertEquals("An error occurred", actualOfferException.getMessage());
    assertEquals("An error occurred", actualOfferException.getRootCauseMessage());
    assertNull(actualOfferException.getCause());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(seed, actualOfferException.getCheckoutResponse());
    assertSame(actualOfferException, actualOfferException.getRootCause());
  }

  /**
   * Method under test:
   * {@link OfferException#OfferException(String, CheckoutSeed)}
   */
  @Test
  public void testNewOfferException12() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    CheckoutSeed seed = new CheckoutSeed(order, new HashMap<>());

    // Act
    OfferException actualOfferException = new OfferException("An error occurred", seed);

    // Assert
    assertEquals("An error occurred", actualOfferException.getLocalizedMessage());
    assertEquals("An error occurred", actualOfferException.getMessage());
    assertEquals("An error occurred", actualOfferException.getRootCauseMessage());
    assertNull(actualOfferException.getCause());
    assertEquals(0, actualOfferException.getSuppressed().length);
    assertSame(seed, actualOfferException.getCheckoutResponse());
    assertSame(actualOfferException, actualOfferException.getRootCause());
  }
}
