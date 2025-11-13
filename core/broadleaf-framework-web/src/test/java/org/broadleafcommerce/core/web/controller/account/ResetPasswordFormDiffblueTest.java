package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ResetPasswordFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResetPasswordForm.<init>()",
    "String ResetPasswordForm.getPassword()",
    "String ResetPasswordForm.getPasswordConfirm()",
    "String ResetPasswordForm.getToken()",
    "String ResetPasswordForm.getUsername()",
    "void ResetPasswordForm.setPassword(String)",
    "void ResetPasswordForm.setPasswordConfirm(String)",
    "void ResetPasswordForm.setToken(String)",
    "void ResetPasswordForm.setUsername(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ResetPasswordForm actualResetPasswordForm = new ResetPasswordForm();
    actualResetPasswordForm.setPassword("iloveyou");
    actualResetPasswordForm.setPasswordConfirm("Password Confirm");
    actualResetPasswordForm.setToken("ABC123");
    actualResetPasswordForm.setUsername("janedoe");
    String actualPassword = actualResetPasswordForm.getPassword();
    String actualPasswordConfirm = actualResetPasswordForm.getPasswordConfirm();
    String actualToken = actualResetPasswordForm.getToken();

    // Assert
    assertEquals("ABC123", actualToken);
    assertEquals("Password Confirm", actualPasswordConfirm);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualResetPasswordForm.getUsername());
  }
}
