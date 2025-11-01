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
import static org.junit.jupiter.api.Assertions.assertThrows;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class BroadleafManageCustomerPaymentsControllerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafManageCustomerPaymentsController}
   *   <li>
   * {@link BroadleafManageCustomerPaymentsController#getCustomerPaymentRedirect()}
   *   <li>
   * {@link BroadleafManageCustomerPaymentsController#getCustomerPaymentView()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafManageCustomerPaymentsController actualBroadleafManageCustomerPaymentsController = new BroadleafManageCustomerPaymentsController();
    String actualCustomerPaymentRedirect = actualBroadleafManageCustomerPaymentsController.getCustomerPaymentRedirect();

    // Assert
    assertEquals("account/manageCustomerPayments",
        actualBroadleafManageCustomerPaymentsController.getCustomerPaymentView());
    assertEquals("redirect:/account/payments", actualCustomerPaymentRedirect);
  }

  /**
   * Method under test:
   * {@link BroadleafManageCustomerPaymentsController#viewCustomerPayments(HttpServletRequest, Model, PaymentInfoForm)}
   */
  @Test
  void testViewCustomerPayments() {
    // Arrange
    BroadleafManageCustomerPaymentsController broadleafManageCustomerPaymentsController = new BroadleafManageCustomerPaymentsController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafManageCustomerPaymentsController.viewCustomerPayments(request, model, new PaymentInfoForm()));
  }
}
