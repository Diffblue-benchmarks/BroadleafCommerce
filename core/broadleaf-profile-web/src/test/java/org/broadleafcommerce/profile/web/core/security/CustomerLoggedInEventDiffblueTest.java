/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestion;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Test;

class CustomerLoggedInEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerLoggedInEvent#setCustomer(Customer)}
   *   <li>{@link CustomerLoggedInEvent#getCustomer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CustomerLoggedInEvent customerLoggedInEvent = new CustomerLoggedInEvent(new CustomerImpl(), "Source");
    CustomerImpl customer = new CustomerImpl();

    // Act
    customerLoggedInEvent.setCustomer(customer);

    // Assert that nothing has changed
    assertSame(customer, customerLoggedInEvent.getCustomer());
  }

  /**
   * Method under test:
   * {@link CustomerLoggedInEvent#CustomerLoggedInEvent(Customer, Object)}
   */
  @Test
  void testNewCustomerLoggedInEvent() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    CustomerLoggedInEvent actualCustomerLoggedInEvent = new CustomerLoggedInEvent(customer, "Source");

    // Assert
    assertEquals("Source", actualCustomerLoggedInEvent.getSource());
    assertSame(customer, actualCustomerLoggedInEvent.getCustomer());
  }

  /**
   * Method under test:
   * {@link CustomerLoggedInEvent#CustomerLoggedInEvent(Customer, Object)}
   */
  @Test
  void testNewCustomerLoggedInEvent2() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    customer.setChallengeQuestion(mock(ChallengeQuestion.class));

    // Act
    CustomerLoggedInEvent actualCustomerLoggedInEvent = new CustomerLoggedInEvent(customer, "Source");

    // Assert
    assertEquals("Source", actualCustomerLoggedInEvent.getSource());
    assertSame(customer, actualCustomerLoggedInEvent.getCustomer());
  }
}
