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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomerLoggedInEventDiffblueTest {
  /**
   * Test {@link CustomerLoggedInEvent#CustomerLoggedInEvent(Customer, Object)}.
   * <p>
   * Method under test: {@link CustomerLoggedInEvent#CustomerLoggedInEvent(Customer, Object)}
   */
  @Test
  @DisplayName("Test new CustomerLoggedInEvent(Customer, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomerLoggedInEvent.<init>(Customer, Object)"})
  void testNewCustomerLoggedInEvent() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    CustomerLoggedInEvent actualCustomerLoggedInEvent = new CustomerLoggedInEvent(customer, "Source");

    // Assert
    Customer customer2 = actualCustomerLoggedInEvent.getCustomer();
    assertTrue(customer2 instanceof CustomerImpl);
    assertEquals("Source", actualCustomerLoggedInEvent.getSource());
    assertSame(customer, customer2);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerLoggedInEvent#setCustomer(Customer)}
   *   <li>{@link CustomerLoggedInEvent#getCustomer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Customer CustomerLoggedInEvent.getCustomer()",
      "void CustomerLoggedInEvent.setCustomer(Customer)"})
  void testGettersAndSetters() {
    // Arrange
    CustomerLoggedInEvent customerLoggedInEvent = new CustomerLoggedInEvent(new CustomerImpl(), "Source");
    CustomerImpl customer = new CustomerImpl();

    // Act
    customerLoggedInEvent.setCustomer(customer);

    // Assert
    assertSame(customer, customerLoggedInEvent.getCustomer());
  }
}
