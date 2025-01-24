package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResetPasswordFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ResetPasswordForm}
   *   <li>{@link ResetPasswordForm#setPassword(String)}
   *   <li>{@link ResetPasswordForm#setPasswordConfirm(String)}
   *   <li>{@link ResetPasswordForm#setToken(String)}
   *   <li>{@link ResetPasswordForm#setUsername(String)}
   *   <li>{@link ResetPasswordForm#getPassword()}
   *   <li>{@link ResetPasswordForm#getPasswordConfirm()}
   *   <li>{@link ResetPasswordForm#getToken()}
   *   <li>{@link ResetPasswordForm#getUsername()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ResetPasswordForm actualResetPasswordForm = new ResetPasswordForm();
    actualResetPasswordForm.setPassword("iloveyou");
    actualResetPasswordForm.setPasswordConfirm("Password Confirm");
    actualResetPasswordForm.setToken("ABC123");
    actualResetPasswordForm.setUsername("janedoe");
    String actualPassword = actualResetPasswordForm.getPassword();
    String actualPasswordConfirm = actualResetPasswordForm.getPasswordConfirm();
    String actualToken = actualResetPasswordForm.getToken();

    // Assert that nothing has changed
    assertEquals("ABC123", actualToken);
    assertEquals("Password Confirm", actualPasswordConfirm);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualResetPasswordForm.getUsername());
  }
}
