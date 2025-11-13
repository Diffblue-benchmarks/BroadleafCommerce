package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomerAuthenticatedFromCookieEventDiffblueTest {
  /**
   * Test {@link CustomerAuthenticatedFromCookieEvent#CustomerAuthenticatedFromCookieEvent(Customer,
   * Object)}.
   *
   * <p>Method under test: {@link
   * CustomerAuthenticatedFromCookieEvent#CustomerAuthenticatedFromCookieEvent(Customer, Object)}
   */
  @Test
  @DisplayName("Test new CustomerAuthenticatedFromCookieEvent(Customer, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAuthenticatedFromCookieEvent.<init>(Customer, Object)"})
  void testNewCustomerAuthenticatedFromCookieEvent() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    CustomerAuthenticatedFromCookieEvent actualCustomerAuthenticatedFromCookieEvent =
        new CustomerAuthenticatedFromCookieEvent(customer, "Source");

    // Assert
    Customer customer2 = actualCustomerAuthenticatedFromCookieEvent.getCustomer();
    assertTrue(customer2 instanceof CustomerImpl);
    assertEquals("Source", actualCustomerAuthenticatedFromCookieEvent.getSource());
    assertSame(customer, customer2);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAuthenticatedFromCookieEvent#setCustomer(Customer)}
   *   <li>{@link CustomerAuthenticatedFromCookieEvent#getCustomer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerAuthenticatedFromCookieEvent.getCustomer()",
    "void CustomerAuthenticatedFromCookieEvent.setCustomer(Customer)"
  })
  void testGettersAndSetters() {
    // Arrange
    CustomerAuthenticatedFromCookieEvent customerAuthenticatedFromCookieEvent =
        new CustomerAuthenticatedFromCookieEvent(new CustomerImpl(), "Source");
    CustomerImpl customer = new CustomerImpl();

    // Act
    customerAuthenticatedFromCookieEvent.setCustomer(customer);

    // Assert
    assertSame(customer, customerAuthenticatedFromCookieEvent.getCustomer());
  }
}
