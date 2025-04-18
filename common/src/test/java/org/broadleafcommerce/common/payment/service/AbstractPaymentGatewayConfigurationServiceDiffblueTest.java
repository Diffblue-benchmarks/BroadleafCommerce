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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewayConfigurationServiceDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getConfiguration()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfigurationService#getConfiguration()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration AbstractPaymentGatewayConfigurationService.getConfiguration()"})
  public void testGetConfiguration() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getConfiguration());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getTransactionService()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfigurationService#getTransactionService()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionService AbstractPaymentGatewayConfigurationService.getTransactionService()"})
  public void testGetTransactionService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getTransactionService());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getCreditCardService()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfigurationService#getCreditCardService()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.payment.service.PaymentGatewayCreditCardService AbstractPaymentGatewayConfigurationService.getCreditCardService()"})
  public void testGetCreditCardService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getCreditCardService());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getCustomerService()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfigurationService#getCustomerService()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.payment.service.PaymentGatewayCustomerService AbstractPaymentGatewayConfigurationService.getCustomerService()"})
  public void testGetCustomerService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getCustomerService());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getSubscriptionService()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfigurationService#getSubscriptionService()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.payment.service.PaymentGatewaySubscriptionService AbstractPaymentGatewayConfigurationService.getSubscriptionService()"})
  public void testGetSubscriptionService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getSubscriptionService());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getRollbackService()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfigurationService#getRollbackService()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.payment.service.PaymentGatewayRollbackService AbstractPaymentGatewayConfigurationService.getRollbackService()"})
  public void testGetRollbackService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getRollbackService());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getTransparentRedirectService()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfigurationService#getTransparentRedirectService()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.payment.service.PaymentGatewayTransparentRedirectService AbstractPaymentGatewayConfigurationService.getTransparentRedirectService()"})
  public void testGetTransparentRedirectService() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getTransparentRedirectService());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getCreditCardExtensionHandler()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfigurationService#getCreditCardExtensionHandler()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.web.payment.processor.TRCreditCardExtensionHandler AbstractPaymentGatewayConfigurationService.getCreditCardExtensionHandler()"})
  public void testGetCreditCardExtensionHandler() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getCreditCardExtensionHandler());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getFieldExtensionHandler()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfigurationService#getFieldExtensionHandler()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.web.payment.expression.PaymentGatewayFieldExtensionHandler AbstractPaymentGatewayConfigurationService.getFieldExtensionHandler()"})
  public void testGetFieldExtensionHandler() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getFieldExtensionHandler());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfigurationService#getCreditCardTypesExtensionHandler()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfigurationService#getCreditCardTypesExtensionHandler()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.web.payment.processor.CreditCardTypesExtensionHandler AbstractPaymentGatewayConfigurationService.getCreditCardTypesExtensionHandler()"})
  public void testGetCreditCardTypesExtensionHandler() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfigurationService()).getCreditCardTypesExtensionHandler());
  }
}
