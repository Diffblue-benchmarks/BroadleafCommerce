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
package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import org.junit.Test;

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
}
