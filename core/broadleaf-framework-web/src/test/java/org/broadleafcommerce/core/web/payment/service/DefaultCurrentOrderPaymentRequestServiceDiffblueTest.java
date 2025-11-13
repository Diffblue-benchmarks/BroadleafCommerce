package org.broadleafcommerce.core.web.payment.service;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCurrentOrderPaymentRequestServiceDiffblueTest {
  @InjectMocks
  private DefaultCurrentOrderPaymentRequestService defaultCurrentOrderPaymentRequestService;

  @Mock private OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;

  /**
   * Test {@link DefaultCurrentOrderPaymentRequestService#getPaymentRequestFromCurrentOrder()}.
   *
   * <p>Method under test: {@link
   * DefaultCurrentOrderPaymentRequestService#getPaymentRequestFromCurrentOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO DefaultCurrentOrderPaymentRequestService.getPaymentRequestFromCurrentOrder()"
  })
  public void testGetPaymentRequestFromCurrentOrder() {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(orderToPaymentRequestDTOService.translateOrder(Mockito.<Order>any()))
        .thenReturn(paymentRequestDTO);

    // Act
    PaymentRequestDTO actualPaymentRequestFromCurrentOrder =
        defaultCurrentOrderPaymentRequestService.getPaymentRequestFromCurrentOrder();

    // Assert
    verify(orderToPaymentRequestDTOService).translateOrder(isNull());
    assertSame(paymentRequestDTO, actualPaymentRequestFromCurrentOrder);
  }
}
