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
package org.broadleafcommerce.core.order.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class NotificationOrderSubmittedEventListenerDiffblueTest {
  /**
   * Test {@link NotificationOrderSubmittedEventListener#createContext(Order)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code customer} is {@link CustomerImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationOrderSubmittedEventListener#createContext(Order)}
   */
  @Test
  public void testCreateContext_givenCustomerImpl_thenReturnCustomerIsCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationOrderSubmittedEventListener notificationOrderSubmittedEventListener = new NotificationOrderSubmittedEventListener();
    NullOrderImpl order = mock(NullOrderImpl.class);
    CustomerImpl customerImpl = new CustomerImpl();
    when(order.getCustomer()).thenReturn(customerImpl);

    // Act
    Map<String, Object> actualCreateContextResult = notificationOrderSubmittedEventListener.createContext(order);

    // Assert
    verify(order).getCustomer();
    assertEquals(2, actualCreateContextResult.size());
    assertSame(customerImpl, actualCreateContextResult.get("customer"));
    assertSame(order, actualCreateContextResult.get("order"));
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#createContext(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code customer} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationOrderSubmittedEventListener#createContext(Order)}
   */
  @Test
  public void testCreateContext_whenNullOrderImpl_thenReturnCustomerIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationOrderSubmittedEventListener notificationOrderSubmittedEventListener = new NotificationOrderSubmittedEventListener();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Map<String, Object> actualCreateContextResult = notificationOrderSubmittedEventListener.createContext(order);

    // Assert
    assertEquals(2, actualCreateContextResult.size());
    assertNull(actualCreateContextResult.get("customer"));
    assertSame(order, actualCreateContextResult.get("order"));
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#createContext(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationOrderSubmittedEventListener#createContext(Order)}
   */
  @Test
  public void testCreateContext_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new NotificationOrderSubmittedEventListener()).createContext(null).isEmpty());
  }

  /**
   * Test {@link NotificationOrderSubmittedEventListener#isAsynchronous()}.
   * <p>
   * Method under test:
   * {@link NotificationOrderSubmittedEventListener#isAsynchronous()}
   */
  @Test
  public void testIsAsynchronous() {
    // Arrange, Act and Assert
    assertTrue((new NotificationOrderSubmittedEventListener()).isAsynchronous());
  }
}
