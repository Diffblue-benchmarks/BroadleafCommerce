package org.broadleafcommerce.core.web.payment.service;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.core.payment.service.PaymentRequestDTOService;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCurrentCustomerPaymentRequestServiceDiffblueTest {
  @InjectMocks
  private DefaultCurrentCustomerPaymentRequestService defaultCurrentCustomerPaymentRequestService;

  @Mock private PaymentRequestDTOService paymentRequestDTOService;

  /**
   * Test {@link
   * DefaultCurrentCustomerPaymentRequestService#getPaymentRequestFromCurrentCustomer()}.
   *
   * <p>Method under test: {@link
   * DefaultCurrentCustomerPaymentRequestService#getPaymentRequestFromCurrentCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO DefaultCurrentCustomerPaymentRequestService.getPaymentRequestFromCurrentCustomer()"
  })
  public void testGetPaymentRequestFromCurrentCustomer() {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any()))
        .thenReturn(paymentRequestDTO);

    // Act
    PaymentRequestDTO actualPaymentRequestFromCurrentCustomer =
        defaultCurrentCustomerPaymentRequestService.getPaymentRequestFromCurrentCustomer();

    // Assert
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isNull());
    assertSame(paymentRequestDTO, actualPaymentRequestFromCurrentCustomer);
  }
}
