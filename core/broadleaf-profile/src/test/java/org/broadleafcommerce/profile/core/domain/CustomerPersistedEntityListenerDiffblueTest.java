package org.broadleafcommerce.profile.core.domain;

import org.junit.Test;

public class CustomerPersistedEntityListenerDiffblueTest {
  /**
   * Test {@link CustomerPersistedEntityListener#customerUpdated(Object)}.
   * <p>
   * Method under test:
   * {@link CustomerPersistedEntityListener#customerUpdated(Object)}
   */
  @Test
  public void testCustomerUpdated() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new CustomerPersistedEntityListener()).customerUpdated("Entity");
  }

  /**
   * Test new {@link CustomerPersistedEntityListener} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CustomerPersistedEntityListener}
   */
  @Test
  public void testNewCustomerPersistedEntityListener() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new CustomerPersistedEntityListener();
  }
}
