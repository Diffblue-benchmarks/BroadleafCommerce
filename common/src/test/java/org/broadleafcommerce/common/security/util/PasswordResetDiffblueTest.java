/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PasswordResetDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PasswordReset.<init>()",
    "void PasswordReset.<init>(String)",
    "String PasswordReset.getEmail()",
    "boolean PasswordReset.getPasswordChangeRequired()",
    "int PasswordReset.getPasswordLength()",
    "String PasswordReset.getUsername()",
    "boolean PasswordReset.isSendResetEmailReliableAsync()",
    "void PasswordReset.setEmail(String)",
    "void PasswordReset.setPasswordChangeRequired(boolean)",
    "void PasswordReset.setPasswordLength(int)",
    "void PasswordReset.setSendResetEmailReliableAsync(boolean)",
    "void PasswordReset.setUsername(String)"
  })
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

    // Assert
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("janedoe", actualUsername);
    assertEquals(3, actualPasswordLength);
    assertTrue(actualPasswordChangeRequired);
    assertTrue(actualPasswordReset.isSendResetEmailReliableAsync());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code janedoe}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PasswordReset.<init>()",
    "void PasswordReset.<init>(String)",
    "String PasswordReset.getEmail()",
    "boolean PasswordReset.getPasswordChangeRequired()",
    "int PasswordReset.getPasswordLength()",
    "String PasswordReset.getUsername()",
    "boolean PasswordReset.isSendResetEmailReliableAsync()",
    "void PasswordReset.setEmail(String)",
    "void PasswordReset.setPasswordChangeRequired(boolean)",
    "void PasswordReset.setPasswordLength(int)",
    "void PasswordReset.setSendResetEmailReliableAsync(boolean)",
    "void PasswordReset.setUsername(String)"
  })
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

    // Assert
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("janedoe", actualUsername);
    assertEquals(3, actualPasswordLength);
    assertTrue(actualPasswordChangeRequired);
    assertTrue(actualPasswordReset.isSendResetEmailReliableAsync());
  }
}
