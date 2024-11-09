/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.checkout.service.gateway;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.junit.Test;

public class PassthroughPaymentConfigurationImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PassthroughPaymentConfigurationImpl#setFailureReportingThreshold(int)}
   *   <li>
   * {@link PassthroughPaymentConfigurationImpl#setPerformAuthorizeAndCapture(boolean)}
   *   <li>
   * {@link PassthroughPaymentConfigurationImpl#getFailureReportingThreshold()}
   *   <li>{@link PassthroughPaymentConfigurationImpl#getGatewayType()}
   *   <li>
   * {@link PassthroughPaymentConfigurationImpl#isPerformAuthorizeAndCapture()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl = new PassthroughPaymentConfigurationImpl();

    // Act
    passthroughPaymentConfigurationImpl.setFailureReportingThreshold(1);
    passthroughPaymentConfigurationImpl.setPerformAuthorizeAndCapture(true);
    int actualFailureReportingThreshold = passthroughPaymentConfigurationImpl.getFailureReportingThreshold();
    PaymentGatewayType actualGatewayType = passthroughPaymentConfigurationImpl.getGatewayType();

    // Assert that nothing has changed
    assertEquals(1, actualFailureReportingThreshold);
    assertFalse(passthroughPaymentConfigurationImpl.isPerformAuthorizeAndCapture());
    assertSame(actualGatewayType.PASSTHROUGH, actualGatewayType);
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesAuthorize()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesAuthorize()}
   */
  @Test
  public void testHandlesAuthorize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesAuthorize());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesCapture()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesCapture()}
   */
  @Test
  public void testHandlesCapture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesCapture());
  }

  /**
   * Test
   * {@link PassthroughPaymentConfigurationImpl#handlesAuthorizeAndCapture()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesAuthorizeAndCapture()}
   */
  @Test
  public void testHandlesAuthorizeAndCapture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesAuthorizeAndCapture());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesReverseAuthorize()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesReverseAuthorize()}
   */
  @Test
  public void testHandlesReverseAuthorize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesReverseAuthorize());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesVoid()}.
   * <p>
   * Method under test: {@link PassthroughPaymentConfigurationImpl#handlesVoid()}
   */
  @Test
  public void testHandlesVoid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesVoid());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesRefund()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesRefund()}
   */
  @Test
  public void testHandlesRefund() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesRefund());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesPartialCapture()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesPartialCapture()}
   */
  @Test
  public void testHandlesPartialCapture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PassthroughPaymentConfigurationImpl()).handlesPartialCapture());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesMultipleShipment()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesMultipleShipment()}
   */
  @Test
  public void testHandlesMultipleShipment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PassthroughPaymentConfigurationImpl()).handlesMultipleShipment());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesRecurringPayment()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesRecurringPayment()}
   */
  @Test
  public void testHandlesRecurringPayment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PassthroughPaymentConfigurationImpl()).handlesRecurringPayment());
  }

  /**
   * Test
   * {@link PassthroughPaymentConfigurationImpl#handlesSavedCustomerPayment()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesSavedCustomerPayment()}
   */
  @Test
  public void testHandlesSavedCustomerPayment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PassthroughPaymentConfigurationImpl()).handlesSavedCustomerPayment());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesMultiplePayments()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesMultiplePayments()}
   */
  @Test
  public void testHandlesMultiplePayments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PassthroughPaymentConfigurationImpl()).handlesMultiplePayments());
  }
}
