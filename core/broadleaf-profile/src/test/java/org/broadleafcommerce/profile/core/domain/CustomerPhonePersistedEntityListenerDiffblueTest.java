package org.broadleafcommerce.profile.core.domain;

import org.junit.Test;

public class CustomerPhonePersistedEntityListenerDiffblueTest {
  /**
   * Test
   * {@link CustomerPhonePersistedEntityListener#customerPhoneUpdated(Object)}.
   * <p>
   * Method under test:
   * {@link CustomerPhonePersistedEntityListener#customerPhoneUpdated(Object)}
   */
  @Test
  public void testCustomerPhoneUpdated() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new CustomerPhonePersistedEntityListener()).customerPhoneUpdated("Entity");
  }

  /**
   * Test new {@link CustomerPhonePersistedEntityListener} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CustomerPhonePersistedEntityListener}
   */
  @Test
  public void testNewCustomerPhonePersistedEntityListener() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new CustomerPhonePersistedEntityListener();
  }
}
