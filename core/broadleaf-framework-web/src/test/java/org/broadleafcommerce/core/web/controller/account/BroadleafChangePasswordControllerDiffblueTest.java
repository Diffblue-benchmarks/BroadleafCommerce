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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class BroadleafChangePasswordControllerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafChangePasswordController}
   *   <li>{@link BroadleafChangePasswordController#getChangePasswordRedirect()}
   *   <li>{@link BroadleafChangePasswordController#getChangePasswordView()}
   *   <li>{@link BroadleafChangePasswordController#getPasswordChangedMessage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafChangePasswordController actualBroadleafChangePasswordController = new BroadleafChangePasswordController();
    String actualChangePasswordRedirect = actualBroadleafChangePasswordController.getChangePasswordRedirect();
    String actualChangePasswordView = actualBroadleafChangePasswordController.getChangePasswordView();

    // Assert
    assertEquals("Password successfully changed", actualBroadleafChangePasswordController.getPasswordChangedMessage());
    assertEquals("account/changePassword", actualChangePasswordView);
    assertEquals("redirect:/account/password", actualChangePasswordRedirect);
  }

  /**
   * Method under test:
   * {@link BroadleafChangePasswordController#viewChangePassword(HttpServletRequest, Model)}
   */
  @Test
  void testViewChangePassword() {
    // Arrange
    BroadleafChangePasswordController broadleafChangePasswordController = new BroadleafChangePasswordController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertEquals("account/changePassword",
        broadleafChangePasswordController.viewChangePassword(request, new ConcurrentModel()));
  }

  /**
   * Method under test:
   * {@link BroadleafChangePasswordController#viewChangePassword(HttpServletRequest, Model)}
   */
  @Test
  void testViewChangePassword2() {
    // Arrange
    BroadleafChangePasswordController broadleafChangePasswordController = new BroadleafChangePasswordController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("foo", function);

    // Act
    String actualViewChangePasswordResult = broadleafChangePasswordController.viewChangePassword(request, model);

    // Assert
    verify(function).apply(eq("foo"));
    assertEquals("account/changePassword", actualViewChangePasswordResult);
  }
}
