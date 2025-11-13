package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;

public class AbstractPaymentGatewayWebResponseServiceDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayWebResponseService#translateWebResponse(HttpServletRequest)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayWebResponseService#translateWebResponse(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayWebResponseService.translateWebResponse(HttpServletRequest)"
  })
  public void testTranslateWebResponse() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayWebResponseService abstractPaymentGatewayWebResponseService =
        new AbstractPaymentGatewayWebResponseService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayWebResponseService.translateWebResponse(
                new MockHttpServletRequest()));
  }
}
