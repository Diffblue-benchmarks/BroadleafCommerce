package org.broadleafcommerce.core.checkout.service.gateway;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PassthroughPaymentConfigurationImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PassthroughPaymentConfigurationImplDiffblueTest {
  @Autowired private PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PassthroughPaymentConfigurationImpl#setFailureReportingThreshold(int)}
   *   <li>{@link PassthroughPaymentConfigurationImpl#setPerformAuthorizeAndCapture(boolean)}
   *   <li>{@link PassthroughPaymentConfigurationImpl#getFailureReportingThreshold()}
   *   <li>{@link PassthroughPaymentConfigurationImpl#getGatewayType()}
   *   <li>{@link PassthroughPaymentConfigurationImpl#isPerformAuthorizeAndCapture()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PassthroughPaymentConfigurationImpl.getFailureReportingThreshold()",
    "PaymentGatewayType PassthroughPaymentConfigurationImpl.getGatewayType()",
    "boolean PassthroughPaymentConfigurationImpl.isPerformAuthorizeAndCapture()",
    "void PassthroughPaymentConfigurationImpl.setFailureReportingThreshold(int)",
    "void PassthroughPaymentConfigurationImpl.setPerformAuthorizeAndCapture(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl =
        new PassthroughPaymentConfigurationImpl();

    // Act
    passthroughPaymentConfigurationImpl.setFailureReportingThreshold(1);
    passthroughPaymentConfigurationImpl.setPerformAuthorizeAndCapture(true);
    int actualFailureReportingThreshold =
        passthroughPaymentConfigurationImpl.getFailureReportingThreshold();
    PaymentGatewayType actualGatewayType = passthroughPaymentConfigurationImpl.getGatewayType();

    // Assert
    assertEquals(1, actualFailureReportingThreshold);
    assertFalse(passthroughPaymentConfigurationImpl.isPerformAuthorizeAndCapture());
    assertSame(PaymentGatewayType.PASSTHROUGH, actualGatewayType);
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesAuthorize()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesAuthorize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesAuthorize()"})
  public void testHandlesAuthorize() {
    // Arrange, Act and Assert
    assertTrue(passthroughPaymentConfigurationImpl.handlesAuthorize());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesCapture()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesCapture()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesCapture()"})
  public void testHandlesCapture() {
    // Arrange, Act and Assert
    assertTrue(passthroughPaymentConfigurationImpl.handlesCapture());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesAuthorizeAndCapture()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesAuthorizeAndCapture()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesAuthorizeAndCapture()"})
  public void testHandlesAuthorizeAndCapture() {
    // Arrange, Act and Assert
    assertTrue(passthroughPaymentConfigurationImpl.handlesAuthorizeAndCapture());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesReverseAuthorize()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesReverseAuthorize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesReverseAuthorize()"})
  public void testHandlesReverseAuthorize() {
    // Arrange, Act and Assert
    assertTrue(passthroughPaymentConfigurationImpl.handlesReverseAuthorize());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesVoid()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesVoid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesVoid()"})
  public void testHandlesVoid() {
    // Arrange, Act and Assert
    assertTrue(passthroughPaymentConfigurationImpl.handlesVoid());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesRefund()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesRefund()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesRefund()"})
  public void testHandlesRefund() {
    // Arrange, Act and Assert
    assertTrue(passthroughPaymentConfigurationImpl.handlesRefund());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesPartialCapture()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesPartialCapture()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesPartialCapture()"})
  public void testHandlesPartialCapture() {
    // Arrange, Act and Assert
    assertFalse(passthroughPaymentConfigurationImpl.handlesPartialCapture());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesMultipleShipment()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesMultipleShipment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesMultipleShipment()"})
  public void testHandlesMultipleShipment() {
    // Arrange, Act and Assert
    assertFalse(passthroughPaymentConfigurationImpl.handlesMultipleShipment());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesRecurringPayment()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesRecurringPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesRecurringPayment()"})
  public void testHandlesRecurringPayment() {
    // Arrange, Act and Assert
    assertFalse(passthroughPaymentConfigurationImpl.handlesRecurringPayment());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesSavedCustomerPayment()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesSavedCustomerPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesSavedCustomerPayment()"})
  public void testHandlesSavedCustomerPayment() {
    // Arrange, Act and Assert
    assertFalse(passthroughPaymentConfigurationImpl.handlesSavedCustomerPayment());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesMultiplePayments()}.
   *
   * <p>Method under test: {@link PassthroughPaymentConfigurationImpl#handlesMultiplePayments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PassthroughPaymentConfigurationImpl.handlesMultiplePayments()"})
  public void testHandlesMultiplePayments() {
    // Arrange, Act and Assert
    assertFalse(passthroughPaymentConfigurationImpl.handlesMultiplePayments());
  }
}
