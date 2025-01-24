package org.broadleafcommerce.core.order.domain;

import org.junit.Test;

public class OrderPersistedEntityListenerDiffblueTest {
  /**
   * Test {@link OrderPersistedEntityListener#orderUpdated(Object)}.
   * <p>
   * Method under test: {@link OrderPersistedEntityListener#orderUpdated(Object)}
   */
  @Test
  public void testOrderUpdated() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new OrderPersistedEntityListener()).orderUpdated("Entity");
  }

  /**
   * Test new {@link OrderPersistedEntityListener} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OrderPersistedEntityListener}
   */
  @Test
  public void testNewOrderPersistedEntityListener() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new OrderPersistedEntityListener();
  }
}
