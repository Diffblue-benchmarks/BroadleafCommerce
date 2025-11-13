package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CustomerPersistedEventDiffblueTest {
  /**
   * Test {@link CustomerPersistedEvent#CustomerPersistedEvent(Customer)}.
   *
   * <p>Method under test: {@link CustomerPersistedEvent#CustomerPersistedEvent(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPersistedEvent.<init>(Customer)"})
  public void testNewCustomerPersistedEvent() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    CustomerPersistedEvent actualCustomerPersistedEvent = new CustomerPersistedEvent(customer);

    // Assert
    Customer customer2 = actualCustomerPersistedEvent.getCustomer();
    assertTrue(customer2 instanceof CustomerImpl);
    assertSame(customer, actualCustomerPersistedEvent.getSource());
    assertSame(customer, customer2);
  }

  /**
   * Test {@link CustomerPersistedEvent#getCustomer()}.
   *
   * <p>Method under test: {@link CustomerPersistedEvent#getCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerPersistedEvent.getCustomer()"})
  public void testGetCustomer() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertSame(customer, new CustomerPersistedEvent(customer).getCustomer());
  }
}
