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

class CustomerAuthenticatedFromCookieEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAuthenticatedFromCookieEvent#setCustomer(Customer)}
   *   <li>{@link CustomerAuthenticatedFromCookieEvent#getCustomer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CustomerAuthenticatedFromCookieEvent customerAuthenticatedFromCookieEvent = new CustomerAuthenticatedFromCookieEvent(
        new CustomerImpl(), "Source");
    CustomerImpl customer = new CustomerImpl();

    // Act
    customerAuthenticatedFromCookieEvent.setCustomer(customer);

    // Assert that nothing has changed
    assertSame(customer, customerAuthenticatedFromCookieEvent.getCustomer());
  }

  /**
   * Method under test:
   * {@link CustomerAuthenticatedFromCookieEvent#CustomerAuthenticatedFromCookieEvent(Customer, Object)}
   */
  @Test
  void testNewCustomerAuthenticatedFromCookieEvent() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    CustomerAuthenticatedFromCookieEvent actualCustomerAuthenticatedFromCookieEvent = new CustomerAuthenticatedFromCookieEvent(
        customer, "Source");

    // Assert
    assertEquals("Source", actualCustomerAuthenticatedFromCookieEvent.getSource());
    assertSame(customer, actualCustomerAuthenticatedFromCookieEvent.getCustomer());
  }

  /**
   * Method under test:
   * {@link CustomerAuthenticatedFromCookieEvent#CustomerAuthenticatedFromCookieEvent(Customer, Object)}
   */
  @Test
  void testNewCustomerAuthenticatedFromCookieEvent2() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    customer.setChallengeQuestion(mock(ChallengeQuestion.class));

    // Act
    CustomerAuthenticatedFromCookieEvent actualCustomerAuthenticatedFromCookieEvent = new CustomerAuthenticatedFromCookieEvent(
        customer, "Source");

    // Assert
    assertEquals("Source", actualCustomerAuthenticatedFromCookieEvent.getSource());
    assertSame(customer, actualCustomerAuthenticatedFromCookieEvent.getCustomer());
  }
}
