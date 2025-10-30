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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OrderStateDiffblueTest {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order OrderState.getOrder(Customer)"})
  void testGetOrder_whenCustomerImpl_thenReturnNull() {
    // Arrange
    OrderState orderState = new OrderState();

    // Act and Assert
    assertNull(orderState.getOrder(new CustomerImpl()));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order OrderState.setOrder(Customer, Order)"})
  void testSetOrder_whenCustomerImpl_thenReturnNull() {
    // Arrange
    OrderState orderState = new OrderState();

    // Act and Assert
    assertNull(orderState.setOrder(new CustomerImpl(), null));
  }

  /**
   * Test {@link OrderState#setOrder(Customer, Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderState#setOrder(Customer, Order)}
   */
  @Test
  @DisplayName("Test setOrder(Customer, Order); when NullOrderImpl (default constructor); then return NullOrderImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order OrderState.setOrder(Customer, Order)"})
  void testSetOrder_whenNullOrderImpl_thenReturnNullOrderImpl() {
    // Arrange
    OrderState orderState = new OrderState();
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertSame(order, orderState.setOrder(customer, order));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Order OrderState.setOrder(Customer, Order)"})
  void testSetOrder_whenNull_thenReturnNull() {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OrderState.<init>()"})
  void testNewOrderState() {
    // Arrange, Act and Assert
    assertNull((new OrderState()).orderDao);
  }
}
