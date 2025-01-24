package org.broadleafcommerce.openadmin.web.form;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ResetPasswordFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ResetPasswordForm}
   *   <li>{@link ResetPasswordForm#setConfirmPassword(String)}
   *   <li>{@link ResetPasswordForm#setOldPassword(String)}
   *   <li>{@link ResetPasswordForm#setPassword(String)}
   *   <li>{@link ResetPasswordForm#setToken(String)}
   *   <li>{@link ResetPasswordForm#setUsername(String)}
   *   <li>{@link ResetPasswordForm#getConfirmPassword()}
   *   <li>{@link ResetPasswordForm#getOldPassword()}
   *   <li>{@link ResetPasswordForm#getPassword()}
   *   <li>{@link ResetPasswordForm#getToken()}
   *   <li>{@link ResetPasswordForm#getUsername()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ResetPasswordForm actualResetPasswordForm = new ResetPasswordForm();
    actualResetPasswordForm.setConfirmPassword("iloveyou");
    actualResetPasswordForm.setOldPassword("iloveyou");
    actualResetPasswordForm.setPassword("iloveyou");
    actualResetPasswordForm.setToken("ABC123");
    actualResetPasswordForm.setUsername("janedoe");
    String actualConfirmPassword = actualResetPasswordForm.getConfirmPassword();
    String actualOldPassword = actualResetPasswordForm.getOldPassword();
    String actualPassword = actualResetPasswordForm.getPassword();
    String actualToken = actualResetPasswordForm.getToken();

    // Assert that nothing has changed
    assertEquals("ABC123", actualToken);
    assertEquals("iloveyou", actualConfirmPassword);
    assertEquals("iloveyou", actualOldPassword);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualResetPasswordForm.getUsername());
  }
}
