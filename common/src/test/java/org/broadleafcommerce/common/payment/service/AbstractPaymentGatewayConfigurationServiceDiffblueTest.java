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
package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class AbstractPaymentGatewayConfigurationServiceDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getConfiguration()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getConfiguration()}
   */
  @Test
  public void testGetConfiguration() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getConfiguration());
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getTransactionService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getTransactionService()}
   */
  @Test
  public void testGetTransactionService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getTransactionService());
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getTransactionConfirmationService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getTransactionConfirmationService()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTransactionConfirmationService() throws PaymentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PaymentGatewayTransactionConfirmationService actualTransactionConfirmationService = (new AbstractPaymentGatewayConfigurationService())
        .getTransactionConfirmationService();
    actualTransactionConfirmationService.confirmTransaction(new PaymentRequestDTO());
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getReportingService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getReportingService()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetReportingService() throws PaymentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PaymentGatewayReportingService actualReportingService = (new AbstractPaymentGatewayConfigurationService())
        .getReportingService();
    actualReportingService.findDetailsByTransaction(new PaymentRequestDTO());
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getCreditCardService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getCreditCardService()}
   */
  @Test
  public void testGetCreditCardService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getCreditCardService());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getCustomerService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getCustomerService()}
   */
  @Test
  public void testGetCustomerService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getCustomerService());
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getSubscriptionService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getSubscriptionService()}
   */
  @Test
  public void testGetSubscriptionService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getSubscriptionService());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getFraudService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getFraudService()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFraudService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PaymentGatewayFraudService actualFraudService = (new AbstractPaymentGatewayConfigurationService())
        .getFraudService();
    actualFraudService.requestPayerAuthentication(new PaymentRequestDTO());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getHostedService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getHostedService()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetHostedService() throws PaymentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PaymentGatewayHostedService actualHostedService = (new AbstractPaymentGatewayConfigurationService())
        .getHostedService();
    actualHostedService.requestHostedEndpoint(new PaymentRequestDTO());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getRollbackService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getRollbackService()}
   */
  @Test
  public void testGetRollbackService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getRollbackService());
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getWebResponseService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getWebResponseService()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetWebResponseService() throws PaymentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PaymentGatewayWebResponseService actualWebResponseService = (new AbstractPaymentGatewayConfigurationService())
        .getWebResponseService();
    actualWebResponseService
        .translateWebResponse(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getTransparentRedirectService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getTransparentRedirectService()}
   */
  @Test
  public void testGetTransparentRedirectService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getTransparentRedirectService());
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getClientTokenService()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getClientTokenService()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetClientTokenService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PaymentGatewayClientTokenService actualClientTokenService = (new AbstractPaymentGatewayConfigurationService())
        .getClientTokenService();
    actualClientTokenService.generateClientToken(new PaymentRequestDTO());
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getCreditCardExtensionHandler()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getCreditCardExtensionHandler()}
   */
  @Test
  public void testGetCreditCardExtensionHandler() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getCreditCardExtensionHandler());
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getFieldExtensionHandler()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getFieldExtensionHandler()}
   */
  @Test
  public void testGetFieldExtensionHandler() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getFieldExtensionHandler());
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayConfigurationService#getCreditCardTypesExtensionHandler()}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayConfigurationService#getCreditCardTypesExtensionHandler()}
   */
  @Test
  public void testGetCreditCardTypesExtensionHandler() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getCreditCardTypesExtensionHandler());
  }

  /**
   * Test new {@link AbstractPaymentGatewayConfigurationService} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractPaymentGatewayConfigurationService}
   */
  @Test
  public void testNewAbstractPaymentGatewayConfigurationService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new AbstractPaymentGatewayConfigurationService();
  }
}
