package org.broadleafcommerce.common.security.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PasswordChangeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PasswordChange#PasswordChange(String)}
   *   <li>{@link PasswordChange#setChallengeAnswer(String)}
   *   <li>{@link PasswordChange#setChallengeQuestion(String)}
   *   <li>{@link PasswordChange#setCurrentPassword(String)}
   *   <li>{@link PasswordChange#setNewPassword(String)}
   *   <li>{@link PasswordChange#setNewPasswordConfirm(String)}
   *   <li>{@link PasswordChange#getChallengeAnswer()}
   *   <li>{@link PasswordChange#getChallengeQuestion()}
   *   <li>{@link PasswordChange#getCurrentPassword()}
   *   <li>{@link PasswordChange#getNewPassword()}
   *   <li>{@link PasswordChange#getNewPasswordConfirm()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PasswordChange.<init>(String)",
    "String PasswordChange.getChallengeAnswer()",
    "String PasswordChange.getChallengeQuestion()",
    "String PasswordChange.getCurrentPassword()",
    "String PasswordChange.getNewPassword()",
    "String PasswordChange.getNewPasswordConfirm()",
    "void PasswordChange.setChallengeAnswer(String)",
    "void PasswordChange.setChallengeQuestion(String)",
    "void PasswordChange.setCurrentPassword(String)",
    "void PasswordChange.setNewPassword(String)",
    "void PasswordChange.setNewPasswordConfirm(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PasswordChange actualPasswordChange = new PasswordChange("janedoe");
    actualPasswordChange.setChallengeAnswer("Challenge Answer");
    actualPasswordChange.setChallengeQuestion("Challenge Question");
    actualPasswordChange.setCurrentPassword("iloveyou");
    actualPasswordChange.setNewPassword("iloveyou");
    actualPasswordChange.setNewPasswordConfirm("New Password Confirm");
    String actualChallengeAnswer = actualPasswordChange.getChallengeAnswer();
    String actualChallengeQuestion = actualPasswordChange.getChallengeQuestion();
    String actualCurrentPassword = actualPasswordChange.getCurrentPassword();
    String actualNewPassword = actualPasswordChange.getNewPassword();

    // Assert
    assertEquals("Challenge Answer", actualChallengeAnswer);
    assertEquals("Challenge Question", actualChallengeQuestion);
    assertEquals("New Password Confirm", actualPasswordChange.getNewPasswordConfirm());
    assertEquals("iloveyou", actualCurrentPassword);
    assertEquals("iloveyou", actualNewPassword);
    assertEquals("janedoe", actualPasswordChange.getUsername());
    assertNull(actualPasswordChange.getEmail());
    assertEquals(22, actualPasswordChange.getPasswordLength());
    assertFalse(actualPasswordChange.getPasswordChangeRequired());
    assertFalse(actualPasswordChange.isSendResetEmailReliableAsync());
  }
}
