package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {PaymentGatewayResolverImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentGatewayResolverImplDiffblueTest {
  @Autowired private PaymentGatewayResolverImpl paymentGatewayResolverImpl;

  /**
   * Test {@link PaymentGatewayResolverImpl#isHandlerCompatible(PaymentGatewayType)}.
   *
   * <p>Method under test: {@link
   * PaymentGatewayResolverImpl#isHandlerCompatible(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentGatewayResolverImpl.isHandlerCompatible(PaymentGatewayType)"})
  public void testIsHandlerCompatible() {
    // Arrange, Act and Assert
    assertTrue(paymentGatewayResolverImpl.isHandlerCompatible(PaymentGatewayType.PASSTHROUGH));
  }

  /**
   * Test {@link PaymentGatewayResolverImpl#resolvePaymentGateway(WebRequest)}.
   *
   * <p>Method under test: {@link PaymentGatewayResolverImpl#resolvePaymentGateway(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentGatewayType PaymentGatewayResolverImpl.resolvePaymentGateway(WebRequest)"
  })
  public void testResolvePaymentGateway() {
    // Arrange, Act and Assert
    assertNull(
        paymentGatewayResolverImpl.resolvePaymentGateway(
            new ServletWebRequest(new MockHttpServletRequest())));
  }
}
