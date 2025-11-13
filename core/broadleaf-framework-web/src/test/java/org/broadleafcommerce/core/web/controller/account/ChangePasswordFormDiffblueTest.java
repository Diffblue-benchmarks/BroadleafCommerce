package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ChangePasswordFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangePasswordForm.<init>()",
    "String ChangePasswordForm.getCurrentPassword()",
    "String ChangePasswordForm.getNewPassword()",
    "String ChangePasswordForm.getNewPasswordConfirm()",
    "void ChangePasswordForm.setCurrentPassword(String)",
    "void ChangePasswordForm.setNewPassword(String)",
    "void ChangePasswordForm.setNewPasswordConfirm(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ChangePasswordForm actualChangePasswordForm = new ChangePasswordForm();
    actualChangePasswordForm.setCurrentPassword("iloveyou");
    actualChangePasswordForm.setNewPassword("iloveyou");
    actualChangePasswordForm.setNewPasswordConfirm("New Password Confirm");
    String actualCurrentPassword = actualChangePasswordForm.getCurrentPassword();
    String actualNewPassword = actualChangePasswordForm.getNewPassword();

    // Assert
    assertEquals("New Password Confirm", actualChangePasswordForm.getNewPasswordConfirm());
    assertEquals("iloveyou", actualCurrentPassword);
    assertEquals("iloveyou", actualNewPassword);
  }
}
