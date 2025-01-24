package org.broadleafcommerce.profile.core.domain;

import org.junit.Test;

public class CustomerPaymentPersistedEntityListenerDiffblueTest {
  /**
   * Test
   * {@link CustomerPaymentPersistedEntityListener#customerPaymentUpdated(Object)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentPersistedEntityListener#customerPaymentUpdated(Object)}
   */
  @Test
  public void testCustomerPaymentUpdated() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new CustomerPaymentPersistedEntityListener()).customerPaymentUpdated("Entity");
  }

  /**
   * Test new {@link CustomerPaymentPersistedEntityListener} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CustomerPaymentPersistedEntityListener}
   */
  @Test
  public void testNewCustomerPaymentPersistedEntityListener() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new CustomerPaymentPersistedEntityListener();
  }
}
