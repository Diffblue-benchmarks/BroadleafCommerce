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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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

@ContextConfiguration(classes = {CheckoutException.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CheckoutExceptionDiffblueTest {
  @Autowired
  private CheckoutException checkoutException;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutException#CheckoutException()}
   *   <li>{@link CheckoutException#setCheckoutResponse(CheckoutResponse)}
   *   <li>{@link CheckoutException#getCheckoutResponse()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckoutException.<init>()", "CheckoutResponse CheckoutException.getCheckoutResponse()",
      "void CheckoutException.setCheckoutResponse(CheckoutResponse)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    CheckoutException actualCheckoutException = new CheckoutException();
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    actualCheckoutException.setCheckoutResponse(checkoutResponse);
    CheckoutResponse actualCheckoutResponse = actualCheckoutException.getCheckoutResponse();

    // Assert
    assertNull(actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getCause());
    assertNull(actualCheckoutException.getRootCause());
    assertEquals(0, actualCheckoutException.getSuppressed().length);
    assertSame(checkoutResponse, actualCheckoutResponse);
  }

  /**
   * Test {@link CheckoutException#CheckoutException(String, CheckoutSeed)}.
   * <p>
   * Method under test: {@link CheckoutException#CheckoutException(String, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckoutException.<init>(String, CheckoutSeed)"})
  public void testNewCheckoutException() {
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
   * Test {@link CheckoutException#CheckoutException(Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutException#CheckoutException(Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckoutException.<init>(Throwable, CheckoutSeed)"})
  public void testNewCheckoutException_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    CheckoutException actualCheckoutException = new CheckoutException(cause, new CheckoutSeed(order, new HashMap<>()));

    // Assert
    CheckoutResponse checkoutResponse = actualCheckoutException.getCheckoutResponse();
    assertTrue(checkoutResponse instanceof CheckoutSeed);
    assertTrue(checkoutResponse.getOrder() instanceof NullOrderImpl);
    assertEquals("java.lang.Throwable", actualCheckoutException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualCheckoutException.getMessage());
    assertSame(cause, actualCheckoutException.getCause());
    assertSame(cause, actualCheckoutException.getRootCause());
  }

  /**
   * Test {@link CheckoutException#CheckoutException(Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutException#CheckoutException(Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckoutException.<init>(Throwable, CheckoutSeed)"})
  public void testNewCheckoutException_thenReturnRootCauseLocalizedMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    CheckoutException actualCheckoutException = new CheckoutException(cause, new CheckoutSeed(order, new HashMap<>()));

    // Assert
    Throwable rootCause = actualCheckoutException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualCheckoutException.getCause().getCause());
  }

  /**
   * Test {@link CheckoutException#CheckoutException(String, Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>Then return RootCause LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutException#CheckoutException(String, Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckoutException.<init>(String, Throwable, CheckoutSeed)"})
  public void testNewCheckoutException_thenReturnRootCauseLocalizedMessageIsNull2() {
    // Arrange
    Throwable cause = new Throwable();
    Throwable throwable = new Throwable();
    cause.initCause(throwable);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    CheckoutException actualCheckoutException = new CheckoutException("An error occurred", cause,
        new CheckoutSeed(order, new HashMap<>()));

    // Assert
    Throwable rootCause = actualCheckoutException.getRootCause();
    assertNull(rootCause.getLocalizedMessage());
    assertNull(rootCause.getMessage());
    assertNull(rootCause.getCause());
    assertSame(throwable, actualCheckoutException.getCause().getCause());
  }

  /**
   * Test {@link CheckoutException#CheckoutException(Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return LocalizedMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutException#CheckoutException(Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckoutException.<init>(Throwable, CheckoutSeed)"})
  public void testNewCheckoutException_whenNull_thenReturnLocalizedMessageIsNull() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    CheckoutException actualCheckoutException = new CheckoutException((Throwable) null,
        new CheckoutSeed(order, new HashMap<>()));

    // Assert
    CheckoutResponse checkoutResponse = actualCheckoutException.getCheckoutResponse();
    assertTrue(checkoutResponse instanceof CheckoutSeed);
    Order order2 = checkoutResponse.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertNull(actualCheckoutException.getLocalizedMessage());
    assertNull(actualCheckoutException.getMessage());
    assertNull(actualCheckoutException.getCause());
    assertNull(actualCheckoutException.getRootCause());
    Money orderAdjustmentsValue = order2.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, order2.getSubTotal());
  }

  /**
   * Test {@link CheckoutException#CheckoutException(String, Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return RootCauseMessage is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutException#CheckoutException(String, Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckoutException.<init>(String, Throwable, CheckoutSeed)"})
  public void testNewCheckoutException_whenNull_thenReturnRootCauseMessageIsAnErrorOccurred() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    // Act
    CheckoutException actualCheckoutException = new CheckoutException("An error occurred", null,
        new CheckoutSeed(order, new HashMap<>()));

    // Assert
    CheckoutResponse checkoutResponse = actualCheckoutException.getCheckoutResponse();
    assertTrue(checkoutResponse instanceof CheckoutSeed);
    Order order2 = checkoutResponse.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertEquals("An error occurred", actualCheckoutException.getRootCauseMessage());
    assertNull(actualCheckoutException.getCause());
    Money orderAdjustmentsValue = order2.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, order2.getSubTotal());
    assertSame(actualCheckoutException, actualCheckoutException.getRootCause());
  }

  /**
   * Test {@link CheckoutException#CheckoutException(String, Throwable, CheckoutSeed)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return RootCauseMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutException#CheckoutException(String, Throwable, CheckoutSeed)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CheckoutException.<init>(String, Throwable, CheckoutSeed)"})
  public void testNewCheckoutException_whenThrowable_thenReturnRootCauseMessageIsNull() {
    // Arrange
    Throwable cause = new Throwable();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    CheckoutException actualCheckoutException = new CheckoutException("An error occurred", cause,
        new CheckoutSeed(order, new HashMap<>()));

    // Assert
    CheckoutResponse checkoutResponse = actualCheckoutException.getCheckoutResponse();
    assertTrue(checkoutResponse instanceof CheckoutSeed);
    assertTrue(checkoutResponse.getOrder() instanceof NullOrderImpl);
    assertNull(actualCheckoutException.getRootCauseMessage());
    assertSame(cause, actualCheckoutException.getCause());
    assertSame(cause, actualCheckoutException.getRootCause());
  }
}
