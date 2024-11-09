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
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PasswordResetDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PasswordReset#PasswordReset()}
   *   <li>{@link PasswordReset#setEmail(String)}
   *   <li>{@link PasswordReset#setPasswordChangeRequired(boolean)}
   *   <li>{@link PasswordReset#setPasswordLength(int)}
   *   <li>{@link PasswordReset#setSendResetEmailReliableAsync(boolean)}
   *   <li>{@link PasswordReset#setUsername(String)}
   *   <li>{@link PasswordReset#getEmail()}
   *   <li>{@link PasswordReset#getPasswordChangeRequired()}
   *   <li>{@link PasswordReset#getPasswordLength()}
   *   <li>{@link PasswordReset#getUsername()}
   *   <li>{@link PasswordReset#isSendResetEmailReliableAsync()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PasswordReset actualPasswordReset = new PasswordReset();
    actualPasswordReset.setEmail("jane.doe@example.org");
    actualPasswordReset.setPasswordChangeRequired(true);
    actualPasswordReset.setPasswordLength(3);
    actualPasswordReset.setSendResetEmailReliableAsync(true);
    actualPasswordReset.setUsername("janedoe");
    String actualEmail = actualPasswordReset.getEmail();
    boolean actualPasswordChangeRequired = actualPasswordReset.getPasswordChangeRequired();
    int actualPasswordLength = actualPasswordReset.getPasswordLength();
    String actualUsername = actualPasswordReset.getUsername();

    // Assert that nothing has changed
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("janedoe", actualUsername);
    assertEquals(3, actualPasswordLength);
    assertTrue(actualPasswordChangeRequired);
    assertTrue(actualPasswordReset.isSendResetEmailReliableAsync());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code janedoe}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PasswordReset#PasswordReset(String)}
   *   <li>{@link PasswordReset#setEmail(String)}
   *   <li>{@link PasswordReset#setPasswordChangeRequired(boolean)}
   *   <li>{@link PasswordReset#setPasswordLength(int)}
   *   <li>{@link PasswordReset#setSendResetEmailReliableAsync(boolean)}
   *   <li>{@link PasswordReset#setUsername(String)}
   *   <li>{@link PasswordReset#getEmail()}
   *   <li>{@link PasswordReset#getPasswordChangeRequired()}
   *   <li>{@link PasswordReset#getPasswordLength()}
   *   <li>{@link PasswordReset#getUsername()}
   *   <li>{@link PasswordReset#isSendResetEmailReliableAsync()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenJanedoe() {
    // Arrange and Act
    PasswordReset actualPasswordReset = new PasswordReset("janedoe");
    actualPasswordReset.setEmail("jane.doe@example.org");
    actualPasswordReset.setPasswordChangeRequired(true);
    actualPasswordReset.setPasswordLength(3);
    actualPasswordReset.setSendResetEmailReliableAsync(true);
    actualPasswordReset.setUsername("janedoe");
    String actualEmail = actualPasswordReset.getEmail();
    boolean actualPasswordChangeRequired = actualPasswordReset.getPasswordChangeRequired();
    int actualPasswordLength = actualPasswordReset.getPasswordLength();
    String actualUsername = actualPasswordReset.getUsername();

    // Assert that nothing has changed
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("janedoe", actualUsername);
    assertEquals(3, actualPasswordLength);
    assertTrue(actualPasswordChangeRequired);
    assertTrue(actualPasswordReset.isSendResetEmailReliableAsync());
  }
}
