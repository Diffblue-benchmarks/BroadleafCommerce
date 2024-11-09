/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderStateDiffblueTest {
  /**
   * Test {@link OrderState#getOrder(Customer)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getId()} return one.</li>
   *   <li>Then calls {@link CustomerImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#getOrder(Customer)}
   */
  @Test
  @DisplayName("Test getOrder(Customer); given one; when CustomerImpl getId() return one; then calls getId()")
  void testGetOrder_givenOne_whenCustomerImplGetIdReturnOne_thenCallsGetId() {
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
   * Test {@link OrderState#getOrder(Customer)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#getOrder(Customer)}
   */
  @Test
  @DisplayName("Test getOrder(Customer); when CustomerImpl (default constructor); then return 'null'")
  void testGetOrder_whenCustomerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();

    // Act and Assert
    assertNull(orderState.getOrder(new CustomerImpl()));
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getId()} return one.</li>
   *   <li>Then calls {@link CustomerImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @DisplayName("Test setOrder(Customer, Order); given one; when CustomerImpl getId() return one; then calls getId()")
  void testSetOrder_givenOne_whenCustomerImplGetIdReturnOne_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();
    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);

    // Act
    Order actualSetOrderResult = orderState.setOrder(customer, new NullOrderImpl());

    // Assert
    verify(customer).getId();
    assertTrue(actualSetOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualSetOrderResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualSetOrderResult.getSubTotal());
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @DisplayName("Test setOrder(Customer, Order); when CustomerImpl (default constructor); then return 'null'")
  void testSetOrder_whenCustomerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();

    // Act and Assert
    assertNull(orderState.setOrder(new CustomerImpl(), null));
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @DisplayName("Test setOrder(Customer, Order); when CustomerImpl (default constructor); then return NullOrderImpl")
  void testSetOrder_whenCustomerImpl_thenReturnNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderState orderState = new OrderState();
    CustomerImpl customer = new CustomerImpl();

    // Act
    Order actualSetOrderResult = orderState.setOrder(customer, new NullOrderImpl());

    // Assert
    assertTrue(actualSetOrderResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualSetOrderResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualSetOrderResult.getSubTotal());
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @DisplayName("Test setOrder(Customer, Order); when 'null'; then return 'null'")
  void testSetOrder_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderState()).setOrder(null, null));
  }

  /**
   * Test new {@link OrderState} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OrderState}
   */
  @Test
  @DisplayName("Test new OrderState (default constructor)")
  void testNewOrderState() {
    // Arrange, Act and Assert
    assertNull((new OrderState()).orderDao);
  }
}
