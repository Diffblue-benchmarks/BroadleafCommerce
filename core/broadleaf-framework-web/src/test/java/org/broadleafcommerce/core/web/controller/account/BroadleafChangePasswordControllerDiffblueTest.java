/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class BroadleafChangePasswordControllerDiffblueTest {
  /**
   * Test {@link BroadleafChangePasswordController#viewChangePassword(HttpServletRequest, Model)}.
   *
   * <p>Method under test: {@link
   * BroadleafChangePasswordController#viewChangePassword(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test viewChangePassword(HttpServletRequest, Model)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafChangePasswordController.viewChangePassword(HttpServletRequest, Model)"
  })
  void testViewChangePassword() {
    // Arrange
    BroadleafChangePasswordController broadleafChangePasswordController =
        new BroadleafChangePasswordController();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertEquals(
        "account/changePassword",
        broadleafChangePasswordController.viewChangePassword(request, new ConcurrentModel()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafChangePasswordController}
   *   <li>{@link BroadleafChangePasswordController#getChangePasswordRedirect()}
   *   <li>{@link BroadleafChangePasswordController#getChangePasswordView()}
   *   <li>{@link BroadleafChangePasswordController#getPasswordChangedMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafChangePasswordController.<init>()",
    "String BroadleafChangePasswordController.getChangePasswordRedirect()",
    "String BroadleafChangePasswordController.getChangePasswordView()",
    "String BroadleafChangePasswordController.getPasswordChangedMessage()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafChangePasswordController actualBroadleafChangePasswordController =
        new BroadleafChangePasswordController();
    String actualChangePasswordRedirect =
        actualBroadleafChangePasswordController.getChangePasswordRedirect();
    String actualChangePasswordView =
        actualBroadleafChangePasswordController.getChangePasswordView();

    // Assert
    assertEquals(
        "Password successfully changed",
        actualBroadleafChangePasswordController.getPasswordChangedMessage());
    assertEquals("account/changePassword", actualChangePasswordView);
    assertEquals("redirect:/account/password", actualChangePasswordRedirect);
  }
}
