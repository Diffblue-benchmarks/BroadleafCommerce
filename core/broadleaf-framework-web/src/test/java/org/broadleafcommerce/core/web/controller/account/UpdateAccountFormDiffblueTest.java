package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UpdateAccountFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UpdateAccountForm}
   *   <li>{@link UpdateAccountForm#setEmailAddress(String)}
   *   <li>{@link UpdateAccountForm#setFirstName(String)}
   *   <li>{@link UpdateAccountForm#setLastName(String)}
   *   <li>{@link UpdateAccountForm#getEmailAddress()}
   *   <li>{@link UpdateAccountForm#getFirstName()}
   *   <li>{@link UpdateAccountForm#getLastName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    UpdateAccountForm actualUpdateAccountForm = new UpdateAccountForm();
    actualUpdateAccountForm.setEmailAddress("42 Main St");
    actualUpdateAccountForm.setFirstName("Jane");
    actualUpdateAccountForm.setLastName("Doe");
    String actualEmailAddress = actualUpdateAccountForm.getEmailAddress();
    String actualFirstName = actualUpdateAccountForm.getFirstName();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("Doe", actualUpdateAccountForm.getLastName());
    assertEquals("Jane", actualFirstName);
  }
}
