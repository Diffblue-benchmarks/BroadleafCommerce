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

class CustomerLoggedInEventDiffblueTest {
  /**
   * Test {@link CustomerLoggedInEvent#CustomerLoggedInEvent(Customer, Object)}.
   *
   * <p>Method under test: {@link CustomerLoggedInEvent#CustomerLoggedInEvent(Customer, Object)}
   */
  @Test
  @DisplayName("Test new CustomerLoggedInEvent(Customer, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerLoggedInEvent.<init>(Customer, Object)"})
  void testNewCustomerLoggedInEvent() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    CustomerLoggedInEvent actualCustomerLoggedInEvent =
        new CustomerLoggedInEvent(customer, "Source");

    // Assert
    Customer customer2 = actualCustomerLoggedInEvent.getCustomer();
    assertTrue(customer2 instanceof CustomerImpl);
    assertEquals("Source", actualCustomerLoggedInEvent.getSource());
    assertSame(customer, customer2);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerLoggedInEvent#setCustomer(Customer)}
   *   <li>{@link CustomerLoggedInEvent#getCustomer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerLoggedInEvent.getCustomer()",
    "void CustomerLoggedInEvent.setCustomer(Customer)"
  })
  void testGettersAndSetters() {
    // Arrange
    CustomerLoggedInEvent customerLoggedInEvent =
        new CustomerLoggedInEvent(new CustomerImpl(), "Source");
    CustomerImpl customer = new CustomerImpl();

    // Act
    customerLoggedInEvent.setCustomer(customer);

    // Assert
    assertSame(customer, customerLoggedInEvent.getCustomer());
  }
}
