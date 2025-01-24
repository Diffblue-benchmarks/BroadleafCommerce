package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestion;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerLoggedInEventDiffblueTest {
  /**
   * Test {@link CustomerLoggedInEvent#CustomerLoggedInEvent(Customer, Object)}.
   * <ul>
   *   <li>Given {@link ChallengeQuestion}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerLoggedInEvent#CustomerLoggedInEvent(Customer, Object)}
   */
  @Test
  @DisplayName("Test new CustomerLoggedInEvent(Customer, Object); given ChallengeQuestion")
  void testNewCustomerLoggedInEvent_givenChallengeQuestion() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    customer.setChallengeQuestion(mock(ChallengeQuestion.class));

    // Act
    CustomerLoggedInEvent actualCustomerLoggedInEvent = new CustomerLoggedInEvent(customer, "Source");

    // Assert
    assertEquals("Source", actualCustomerLoggedInEvent.getSource());
    assertSame(customer, actualCustomerLoggedInEvent.getCustomer());
  }

  /**
   * Test {@link CustomerLoggedInEvent#CustomerLoggedInEvent(Customer, Object)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerLoggedInEvent#CustomerLoggedInEvent(Customer, Object)}
   */
  @Test
  @DisplayName("Test new CustomerLoggedInEvent(Customer, Object); when CustomerImpl (default constructor)")
  void testNewCustomerLoggedInEvent_whenCustomerImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    CustomerLoggedInEvent actualCustomerLoggedInEvent = new CustomerLoggedInEvent(customer, "Source");

    // Assert
    assertEquals("Source", actualCustomerLoggedInEvent.getSource());
    assertSame(customer, actualCustomerLoggedInEvent.getCustomer());
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
  void testGettersAndSetters() {
    // Arrange
    CustomerLoggedInEvent customerLoggedInEvent = new CustomerLoggedInEvent(new CustomerImpl(), "Source");
    CustomerImpl customer = new CustomerImpl();

    // Act
    customerLoggedInEvent.setCustomer(customer);

    // Assert that nothing has changed
    assertSame(customer, customerLoggedInEvent.getCustomer());
  }
}
