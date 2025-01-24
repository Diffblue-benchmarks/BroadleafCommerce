package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class CustomerPersistedEventDiffblueTest {
  /**
   * Test {@link CustomerPersistedEvent#CustomerPersistedEvent(Customer)}.
   * <ul>
   *   <li>Given {@link ChallengeQuestion}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPersistedEvent#CustomerPersistedEvent(Customer)}
   */
  @Test
  public void testNewCustomerPersistedEvent_givenChallengeQuestion() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    customer.setChallengeQuestion(mock(ChallengeQuestion.class));

    // Act
    CustomerPersistedEvent actualCustomerPersistedEvent = new CustomerPersistedEvent(customer);

    // Assert
    assertSame(customer, actualCustomerPersistedEvent.getSource());
    assertSame(customer, actualCustomerPersistedEvent.getCustomer());
  }

  /**
   * Test {@link CustomerPersistedEvent#CustomerPersistedEvent(Customer)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPersistedEvent#CustomerPersistedEvent(Customer)}
   */
  @Test
  public void testNewCustomerPersistedEvent_whenCustomerImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    CustomerPersistedEvent actualCustomerPersistedEvent = new CustomerPersistedEvent(customer);

    // Assert
    assertSame(customer, actualCustomerPersistedEvent.getSource());
    assertSame(customer, actualCustomerPersistedEvent.getCustomer());
  }

  /**
   * Test {@link CustomerPersistedEvent#getCustomer()}.
   * <p>
   * Method under test: {@link CustomerPersistedEvent#getCustomer()}
   */
  @Test
  public void testGetCustomer() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertSame(customer, (new CustomerPersistedEvent(customer)).getCustomer());
  }

  /**
   * Test {@link CustomerPersistedEvent#getCustomer()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) ChallengeQuestion is
   * {@link ChallengeQuestion}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPersistedEvent#getCustomer()}
   */
  @Test
  public void testGetCustomer_givenCustomerImplChallengeQuestionIsChallengeQuestion() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    customer.setChallengeQuestion(mock(ChallengeQuestion.class));

    // Act and Assert
    assertSame(customer, (new CustomerPersistedEvent(customer)).getCustomer());
  }
}
