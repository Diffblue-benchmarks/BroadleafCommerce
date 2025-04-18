/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.event;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ForgotPasswordEventDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForgotPasswordEvent#setCustomerId(Long)}
   *   <li>{@link ForgotPasswordEvent#setResetPasswordUrl(String)}
   *   <li>{@link ForgotPasswordEvent#setToken(String)}
   *   <li>{@link ForgotPasswordEvent#getCustomerId()}
   *   <li>{@link ForgotPasswordEvent#getResetPasswordUrl()}
   *   <li>{@link ForgotPasswordEvent#getToken()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long ForgotPasswordEvent.getCustomerId()", "String ForgotPasswordEvent.getResetPasswordUrl()",
      "String ForgotPasswordEvent.getToken()", "void ForgotPasswordEvent.setCustomerId(Long)",
      "void ForgotPasswordEvent.setResetPasswordUrl(String)", "void ForgotPasswordEvent.setToken(String)"})
  public void testGettersAndSetters() {
    // Arrange
    ForgotPasswordEvent forgotPasswordEvent = new ForgotPasswordEvent("Source", 1L, "ABC123",
        "https://example.org/example");

    // Act
    forgotPasswordEvent.setCustomerId(1L);
    forgotPasswordEvent.setResetPasswordUrl("https://example.org/example");
    forgotPasswordEvent.setToken("ABC123");
    Long actualCustomerId = forgotPasswordEvent.getCustomerId();
    String actualResetPasswordUrl = forgotPasswordEvent.getResetPasswordUrl();

    // Assert
    assertEquals("ABC123", forgotPasswordEvent.getToken());
    assertEquals("https://example.org/example", actualResetPasswordUrl);
    assertEquals(1L, actualCustomerId.longValue());
  }
}
