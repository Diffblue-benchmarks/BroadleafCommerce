package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderInfoFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderInfoForm}
   *   <li>{@link OrderInfoForm#setEmailAddress(String)}
   *   <li>{@link OrderInfoForm#getEmailAddress()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    OrderInfoForm actualOrderInfoForm = new OrderInfoForm();
    actualOrderInfoForm.setEmailAddress("42 Main St");

    // Assert that nothing has changed
    assertEquals("42 Main St", actualOrderInfoForm.getEmailAddress());
  }
}
