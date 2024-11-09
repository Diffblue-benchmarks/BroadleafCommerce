/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.security.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class PasswordChangeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("Challenge Answer", actualChallengeAnswer);
    assertEquals("Challenge Question", actualChallengeQuestion);
    assertEquals("New Password Confirm", actualPasswordChange.getNewPasswordConfirm());
    assertEquals("iloveyou", actualCurrentPassword);
    assertEquals("iloveyou", actualNewPassword);
    assertEquals("janedoe", actualPasswordChange.getUsername());
    assertEquals(22, actualPasswordChange.getPasswordLength());
    assertFalse(actualPasswordChange.getPasswordChangeRequired());
    assertFalse(actualPasswordChange.isSendResetEmailReliableAsync());
  }
}
