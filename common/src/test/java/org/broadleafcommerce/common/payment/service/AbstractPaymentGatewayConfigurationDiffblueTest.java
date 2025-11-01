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
import org.junit.Test;

public class AbstractPaymentGatewayConfigurationDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#isPerformAuthorizeAndCapture()}
   */
  @Test
  public void testIsPerformAuthorizeAndCapture() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).isPerformAuthorizeAndCapture());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#setPerformAuthorizeAndCapture(boolean)}
   */
  @Test
  public void testSetPerformAuthorizeAndCapture() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).setPerformAuthorizeAndCapture(true));
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#getFailureReportingThreshold()}
   */
  @Test
  public void testGetFailureReportingThreshold() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).getFailureReportingThreshold());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#setFailureReportingThreshold(int)}
   */
  @Test
  public void testSetFailureReportingThreshold() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).setFailureReportingThreshold(1));
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#handlesAuthorize()}
   */
  @Test
  public void testHandlesAuthorize() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).handlesAuthorize());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#handlesCapture()}
   */
  @Test
  public void testHandlesCapture() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).handlesCapture());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#handlesAuthorizeAndCapture()}
   */
  @Test
  public void testHandlesAuthorizeAndCapture() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).handlesAuthorizeAndCapture());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#handlesReverseAuthorize()}
   */
  @Test
  public void testHandlesReverseAuthorize() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).handlesReverseAuthorize());
  }

  /**
   * Method under test: {@link AbstractPaymentGatewayConfiguration#handlesVoid()}
   */
  @Test
  public void testHandlesVoid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new AbstractPaymentGatewayConfiguration()).handlesVoid());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#handlesRefund()}
   */
  @Test
  public void testHandlesRefund() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).handlesRefund());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#handlesPartialCapture()}
   */
  @Test
  public void testHandlesPartialCapture() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).handlesPartialCapture());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#handlesMultipleShipment()}
   */
  @Test
  public void testHandlesMultipleShipment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).handlesMultipleShipment());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#handlesRecurringPayment()}
   */
  @Test
  public void testHandlesRecurringPayment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).handlesRecurringPayment());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#handlesSavedCustomerPayment()}
   */
  @Test
  public void testHandlesSavedCustomerPayment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).handlesSavedCustomerPayment());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#handlesMultiplePayments()}
   */
  @Test
  public void testHandlesMultiplePayments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).handlesMultiplePayments());
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayConfiguration#getGatewayType()}
   */
  @Test
  public void testGetGatewayType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new AbstractPaymentGatewayConfiguration()).getGatewayType());
  }
}
