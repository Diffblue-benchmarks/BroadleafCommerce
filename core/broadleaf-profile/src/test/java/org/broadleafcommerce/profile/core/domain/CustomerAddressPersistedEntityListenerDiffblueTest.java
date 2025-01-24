package org.broadleafcommerce.profile.core.domain;

import org.junit.Test;

public class CustomerAddressPersistedEntityListenerDiffblueTest {
  /**
   * Test
   * {@link CustomerAddressPersistedEntityListener#customerAddressUpdated(Object)}.
   * <p>
   * Method under test:
   * {@link CustomerAddressPersistedEntityListener#customerAddressUpdated(Object)}
   */
  @Test
  public void testCustomerAddressUpdated() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new CustomerAddressPersistedEntityListener()).customerAddressUpdated("Entity");
  }

  /**
   * Test new {@link CustomerAddressPersistedEntityListener} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CustomerAddressPersistedEntityListener}
   */
  @Test
  public void testNewCustomerAddressPersistedEntityListener() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new CustomerAddressPersistedEntityListener();
  }
}
