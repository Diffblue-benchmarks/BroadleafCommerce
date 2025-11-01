/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Test;

class OrderStateDiffblueTest {
  /**
   * Method under test: {@link OrderState#getOrder(Customer)}
   */
  @Test
  void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();

    // Act and Assert
    assertNull(orderState.getOrder(new CustomerImpl()));
  }

  /**
   * Method under test: {@link OrderState#getOrder(Customer)}
   */
  @Test
  void testGetOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();
    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);

    // Act
    Order actualOrder = orderState.getOrder(customer);

    // Assert
    verify(customer).getId();
    assertNull(actualOrder);
  }

  /**
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  void testSetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, orderState.setOrder(customer, order));
  }

  /**
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  void testSetOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderState()).setOrder(null, null));
  }

  /**
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  void testSetOrder3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();

    // Act and Assert
    assertNull(orderState.setOrder(new CustomerImpl(), null));
  }

  /**
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  void testSetOrder4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();
    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    Order actualSetOrderResult = orderState.setOrder(customer, order);

    // Assert
    verify(customer).getId();
    assertSame(order, actualSetOrderResult);
  }

  /**
   * Method under test: default or parameterless constructor of {@link OrderState}
   */
  @Test
  void testNewOrderState() {
    // Arrange, Act and Assert
    assertNull((new OrderState()).orderDao);
  }
}
