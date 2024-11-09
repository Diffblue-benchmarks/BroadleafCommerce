/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Map;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class NotificationForgotPasswordEventListenerDiffblueTest {
  /**
   * Test
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return containsKey {@code resetPasswordUrl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}
   */
  @Test
  public void testCreateContext_whenCustomerImpl_thenReturnContainsKeyResetPasswordUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationForgotPasswordEventListener notificationForgotPasswordEventListener = new NotificationForgotPasswordEventListener();
    CustomerImpl customer = new CustomerImpl();

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotPasswordEventListener.createContext(customer,
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertTrue(actualCreateContextResult.containsKey("resetPasswordUrl"));
    assertTrue(actualCreateContextResult.containsKey("token"));
    assertSame(customer, actualCreateContextResult.get("customer"));
  }

  /**
   * Test
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   *   <li>Then return {@code customer} is {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}
   */
  @Test
  public void testCreateContext_whenCustomerImpl_thenReturnCustomerIsCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationForgotPasswordEventListener notificationForgotPasswordEventListener = new NotificationForgotPasswordEventListener();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotPasswordEventListener.createContext(customer,
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertSame(customer, actualCreateContextResult.get("customer"));
  }

  /**
   * Test
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code customer} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationForgotPasswordEventListener#createContext(Customer, ForgotPasswordEvent)}
   */
  @Test
  public void testCreateContext_whenNull_thenReturnCustomerIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationForgotPasswordEventListener notificationForgotPasswordEventListener = new NotificationForgotPasswordEventListener();

    // Act
    Map<String, Object> actualCreateContextResult = notificationForgotPasswordEventListener.createContext(null,
        new ForgotPasswordEvent("Source", 1L, "ABC123", "https://example.org/example"));

    // Assert
    assertEquals(3, actualCreateContextResult.size());
    assertEquals("ABC123", actualCreateContextResult.get("token"));
    assertEquals("https://example.org/example", actualCreateContextResult.get("resetPasswordUrl"));
    assertNull(actualCreateContextResult.get("customer"));
  }

  /**
   * Test {@link NotificationForgotPasswordEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link NotificationForgotPasswordEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationForgotPasswordEventListener()).isAsynchronous());
  }
}
