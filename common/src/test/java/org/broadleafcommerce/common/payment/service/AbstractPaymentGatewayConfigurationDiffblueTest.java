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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewayConfigurationDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayConfiguration#isPerformAuthorizeAndCapture()}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayConfiguration#isPerformAuthorizeAndCapture()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.isPerformAuthorizeAndCapture()"})
  public void testIsPerformAuthorizeAndCapture() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().isPerformAuthorizeAndCapture());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#setPerformAuthorizeAndCapture(boolean)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayConfiguration#setPerformAuthorizeAndCapture(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractPaymentGatewayConfiguration.setPerformAuthorizeAndCapture(boolean)"
  })
  public void testSetPerformAuthorizeAndCapture() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().setPerformAuthorizeAndCapture(true));
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#getFailureReportingThreshold()}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayConfiguration#getFailureReportingThreshold()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractPaymentGatewayConfiguration.getFailureReportingThreshold()"})
  public void testGetFailureReportingThreshold() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().getFailureReportingThreshold());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#setFailureReportingThreshold(int)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayConfiguration#setFailureReportingThreshold(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractPaymentGatewayConfiguration.setFailureReportingThreshold(int)"})
  public void testSetFailureReportingThreshold() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().setFailureReportingThreshold(1));
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesAuthorize()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesAuthorize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesAuthorize()"})
  public void testHandlesAuthorize() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesAuthorize());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesCapture()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesCapture()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesCapture()"})
  public void testHandlesCapture() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesCapture());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesAuthorizeAndCapture()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesAuthorizeAndCapture()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesAuthorizeAndCapture()"})
  public void testHandlesAuthorizeAndCapture() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesAuthorizeAndCapture());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesReverseAuthorize()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesReverseAuthorize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesReverseAuthorize()"})
  public void testHandlesReverseAuthorize() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesReverseAuthorize());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesVoid()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesVoid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesVoid()"})
  public void testHandlesVoid() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesVoid());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesRefund()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesRefund()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesRefund()"})
  public void testHandlesRefund() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesRefund());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesPartialCapture()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesPartialCapture()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesPartialCapture()"})
  public void testHandlesPartialCapture() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesPartialCapture());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesMultipleShipment()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesMultipleShipment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesMultipleShipment()"})
  public void testHandlesMultipleShipment() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesMultipleShipment());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesRecurringPayment()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesRecurringPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesRecurringPayment()"})
  public void testHandlesRecurringPayment() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesRecurringPayment());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesSavedCustomerPayment()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesSavedCustomerPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesSavedCustomerPayment()"})
  public void testHandlesSavedCustomerPayment() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesSavedCustomerPayment());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#handlesMultiplePayments()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#handlesMultiplePayments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractPaymentGatewayConfiguration.handlesMultiplePayments()"})
  public void testHandlesMultiplePayments() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().handlesMultiplePayments());
  }

  /**
   * Test {@link AbstractPaymentGatewayConfiguration#getGatewayType()}.
   *
   * <p>Method under test: {@link AbstractPaymentGatewayConfiguration#getGatewayType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.PaymentGatewayType AbstractPaymentGatewayConfiguration.getGatewayType()"
  })
  public void testGetGatewayType() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new AbstractPaymentGatewayConfiguration().getGatewayType());
  }
}
