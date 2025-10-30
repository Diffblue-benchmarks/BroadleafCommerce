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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutSeed;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferException.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferExceptionDiffblueTest {
  @Autowired
  private OfferException offerException;

  /**
   * Test {@link OfferException#OfferException()}.
   * <p>
   * Method under test: {@link OfferException#OfferException()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferException.<init>()"})
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
   * Test {@link OfferException#OfferException(String)}.
   * <p>
   * Method under test: {@link OfferException#OfferException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferException.<init>(String)"})
  public void testNewOfferException2() {
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
   * Test {@link OfferException#OfferException(String, CheckoutSeed)}.
   * <p>
   * Method under test: {@link OfferException#OfferException(String, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferException.<init>(String, CheckoutSeed)"})
  public void testNewOfferException3() {
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
   * Test {@link OfferException#OfferException(Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferException#OfferException(Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferException.<init>(Throwable, CheckoutSeed)"})
  public void testNewOfferException_givenThrowable_thenReturnRootCauseLocalizedMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    OfferException actualOfferException = new OfferException(cause, new CheckoutSeed(order, new HashMap<>()));

    // Assert
    Throwable rootCause = actualOfferException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualOfferException.getCause().getCause());
  }

  /**
   * Test {@link OfferException#OfferException(String, Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>Given {@link Throwable#Throwable()}.</li>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferException#OfferException(String, Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferException.<init>(String, Throwable, CheckoutSeed)"})
  public void testNewOfferException_givenThrowable_thenReturnRootCauseLocalizedMessageIsNull2() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    OfferException actualOfferException = new OfferException("An error occurred", cause,
        new CheckoutSeed(order, new HashMap<>()));

    // Assert
    Throwable rootCause = actualOfferException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualOfferException.getCause().getCause());
  }

  /**
   * Test {@link OfferException#OfferException(Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferException#OfferException(Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferException.<init>(Throwable, CheckoutSeed)"})
  public void testNewOfferException_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    OfferException actualOfferException = new OfferException(cause, new CheckoutSeed(order, new HashMap<>()));

    // Assert
    CheckoutResponse checkoutResponse = actualOfferException.getCheckoutResponse();
    assertTrue(checkoutResponse instanceof CheckoutSeed);
    assertTrue(checkoutResponse.getOrder() instanceof NullOrderImpl);
    assertEquals("java.lang.Throwable", actualOfferException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualOfferException.getMessage());
    assertSame(cause, actualOfferException.getCause());
    assertSame(cause, actualOfferException.getRootCause());
  }

  /**
   * Test {@link OfferException#OfferException(Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferException#OfferException(Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferException.<init>(Throwable, CheckoutSeed)"})
  public void testNewOfferException_whenNull_thenReturnLocalizedMessageIsNull() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    OfferException actualOfferException = new OfferException((Throwable) null,
        new CheckoutSeed(order, new HashMap<>()));

    // Assert
    CheckoutResponse checkoutResponse = actualOfferException.getCheckoutResponse();
    assertTrue(checkoutResponse instanceof CheckoutSeed);
    Order order2 = checkoutResponse.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertNull(actualOfferException.getLocalizedMessage());
    assertNull(actualOfferException.getMessage());
    assertNull(actualOfferException.getCause());
    assertNull(actualOfferException.getRootCause());
    Money orderAdjustmentsValue = order2.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, order2.getSubTotal());
  }

  /**
   * Test {@link OfferException#OfferException(String, Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return RootCauseMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferException#OfferException(String, Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferException.<init>(String, Throwable, CheckoutSeed)"})
  public void testNewOfferException_whenNull_thenReturnRootCauseMessageIsAnErrorOccurred() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    OfferException actualOfferException = new OfferException("An error occurred", null,
        new CheckoutSeed(order, new HashMap<>()));

    // Assert
    CheckoutResponse checkoutResponse = actualOfferException.getCheckoutResponse();
    assertTrue(checkoutResponse instanceof CheckoutSeed);
    Order order2 = checkoutResponse.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertEquals("An error occurred", actualOfferException.getRootCauseMessage());
    assertNull(actualOfferException.getCause());
    Money orderAdjustmentsValue = order2.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, order2.getSubTotal());
    assertSame(actualOfferException, actualOfferException.getRootCause());
  }

  /**
   * Test {@link OfferException#OfferException(String, Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return RootCauseMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferException#OfferException(String, Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferException.<init>(String, Throwable, CheckoutSeed)"})
  public void testNewOfferException_whenThrowable_thenReturnRootCauseMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    OfferException actualOfferException = new OfferException("An error occurred", cause,
        new CheckoutSeed(order, new HashMap<>()));

    // Assert
    CheckoutResponse checkoutResponse = actualOfferException.getCheckoutResponse();
    assertTrue(checkoutResponse instanceof CheckoutSeed);
    assertTrue(checkoutResponse.getOrder() instanceof NullOrderImpl);
    assertNull(actualOfferException.getRootCauseMessage());
    assertSame(cause, actualOfferException.getCause());
    assertSame(cause, actualOfferException.getRootCause());
  }
}
