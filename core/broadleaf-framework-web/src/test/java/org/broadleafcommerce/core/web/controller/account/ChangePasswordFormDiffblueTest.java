package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChangePasswordFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ChangePasswordForm}
   *   <li>{@link ChangePasswordForm#setCurrentPassword(String)}
   *   <li>{@link ChangePasswordForm#setNewPassword(String)}
   *   <li>{@link ChangePasswordForm#setNewPasswordConfirm(String)}
   *   <li>{@link ChangePasswordForm#getCurrentPassword()}
   *   <li>{@link ChangePasswordForm#getNewPassword()}
   *   <li>{@link ChangePasswordForm#getNewPasswordConfirm()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ChangePasswordForm actualChangePasswordForm = new ChangePasswordForm();
    actualChangePasswordForm.setCurrentPassword("iloveyou");
    actualChangePasswordForm.setNewPassword("iloveyou");
    actualChangePasswordForm.setNewPasswordConfirm("New Password Confirm");
    String actualCurrentPassword = actualChangePasswordForm.getCurrentPassword();
    String actualNewPassword = actualChangePasswordForm.getNewPassword();

    // Assert that nothing has changed
    assertEquals("New Password Confirm", actualChangePasswordForm.getNewPasswordConfirm());
    assertEquals("iloveyou", actualCurrentPassword);
    assertEquals("iloveyou", actualNewPassword);
  }
}
