/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
