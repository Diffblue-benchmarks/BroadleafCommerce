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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Map;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class NotificationRegisterCustomerEventListenerDiffblueTest {
  /**
   * Test
   * {@link NotificationRegisterCustomerEventListener#createContext(Customer, RegisterCustomerEvent)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code customer} is {@link CustomerImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRegisterCustomerEventListener#createContext(Customer, RegisterCustomerEvent)}
   */
  @Test
  public void testCreateContext_whenCustomerImpl_thenReturnCustomerIsCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRegisterCustomerEventListener notificationRegisterCustomerEventListener = new NotificationRegisterCustomerEventListener();
    CustomerImpl customer = new CustomerImpl();

    // Act
    Map<String, Object> actualCreateContextResult = notificationRegisterCustomerEventListener.createContext(customer,
        new RegisterCustomerEvent("Source", 1L));

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    assertSame(customer, actualCreateContextResult.get("customer"));
  }

  /**
   * Test
   * {@link NotificationRegisterCustomerEventListener#createContext(Customer, RegisterCustomerEvent)}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   *   <li>Then return {@code customer} is {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRegisterCustomerEventListener#createContext(Customer, RegisterCustomerEvent)}
   */
  @Test
  public void testCreateContext_whenCustomerImpl_thenReturnCustomerIsCustomerImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRegisterCustomerEventListener notificationRegisterCustomerEventListener = new NotificationRegisterCustomerEventListener();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act
    Map<String, Object> actualCreateContextResult = notificationRegisterCustomerEventListener.createContext(customer,
        new RegisterCustomerEvent("Source", 1L));

    // Assert
    assertEquals(1, actualCreateContextResult.size());
    assertSame(customer, actualCreateContextResult.get("customer"));
  }

  /**
   * Test {@link NotificationRegisterCustomerEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link NotificationRegisterCustomerEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationRegisterCustomerEventListener()).isAsynchronous());
  }
}
