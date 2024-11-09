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

public class AbstractPaymentGatewayConfigurationDiffblueTest {
  /**
   * Test
   * {@link AbstractPaymentGatewayConfiguration#isPerformAuthorizeAndCapture()}.
   * <p>
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
   * Test
   * {@link AbstractPaymentGatewayConfiguration#setPerformAuthorizeAndCapture(boolean)}.
   * <p>
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
   * Test
   * {@link AbstractPaymentGatewayConfiguration#getFailureReportingThreshold()}.
   * <p>
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
   * Test
   * {@link AbstractPaymentGatewayConfiguration#setFailureReportingThreshold(int)}.
   * <p>
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
   * Test {@link AbstractPaymentGatewayConfiguration#handlesAuthorize()}.
   * <p>
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
   * Test {@link AbstractPaymentGatewayConfiguration#handlesCapture()}.
   * <p>
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
   * Test
   * {@link AbstractPaymentGatewayConfiguration#handlesAuthorizeAndCapture()}.
   * <p>
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
   * Test {@link AbstractPaymentGatewayConfiguration#handlesReverseAuthorize()}.
   * <p>
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
   * Test {@link AbstractPaymentGatewayConfiguration#handlesVoid()}.
   * <p>
   * Method under test: {@link AbstractPaymentGatewayConfiguration#handlesVoid()}
   */
  @Test
  public void testHandlesVoid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new AbstractPaymentGatewayConfiguration()).handlesVoid());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesRefund()}.
   * <p>
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
   * Test {@link AbstractPaymentGatewayConfiguration#handlesPartialCapture()}.
   * <p>
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
   * Test {@link AbstractPaymentGatewayConfiguration#handlesMultipleShipment()}.
   * <p>
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
   * Test {@link AbstractPaymentGatewayConfiguration#handlesRecurringPayment()}.
   * <p>
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
   * Test
   * {@link AbstractPaymentGatewayConfiguration#handlesSavedCustomerPayment()}.
   * <p>
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
   * Test {@link AbstractPaymentGatewayConfiguration#handlesMultiplePayments()}.
   * <p>
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
   * Test {@link AbstractPaymentGatewayConfiguration#getGatewayType()}.
   * <p>
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
