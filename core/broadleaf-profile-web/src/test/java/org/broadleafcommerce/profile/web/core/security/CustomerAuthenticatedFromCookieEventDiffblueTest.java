package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestion;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerAuthenticatedFromCookieEventDiffblueTest {
  /**
   * Test
   * {@link CustomerAuthenticatedFromCookieEvent#CustomerAuthenticatedFromCookieEvent(Customer, Object)}.
   * <ul>
   *   <li>Given {@link ChallengeQuestion}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerAuthenticatedFromCookieEvent#CustomerAuthenticatedFromCookieEvent(Customer, Object)}
   */
  @Test
  @DisplayName("Test new CustomerAuthenticatedFromCookieEvent(Customer, Object); given ChallengeQuestion")
  void testNewCustomerAuthenticatedFromCookieEvent_givenChallengeQuestion() {
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

  /**
   * Test
   * {@link CustomerAuthenticatedFromCookieEvent#CustomerAuthenticatedFromCookieEvent(Customer, Object)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerAuthenticatedFromCookieEvent#CustomerAuthenticatedFromCookieEvent(Customer, Object)}
   */
  @Test
  @DisplayName("Test new CustomerAuthenticatedFromCookieEvent(Customer, Object); when CustomerImpl (default constructor)")
  void testNewCustomerAuthenticatedFromCookieEvent_whenCustomerImpl() {
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAuthenticatedFromCookieEvent#setCustomer(Customer)}
   *   <li>{@link CustomerAuthenticatedFromCookieEvent#getCustomer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
}
