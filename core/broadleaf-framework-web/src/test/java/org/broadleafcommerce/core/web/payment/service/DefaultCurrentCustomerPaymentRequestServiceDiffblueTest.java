/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.payment.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.core.payment.service.PaymentRequestDTOService;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultCurrentCustomerPaymentRequestServiceDiffblueTest {
  @InjectMocks
  private DefaultCurrentCustomerPaymentRequestService defaultCurrentCustomerPaymentRequestService;

  @Mock
  private PaymentRequestDTOService paymentRequestDTOService;

  /**
   * Test {@link DefaultCurrentCustomerPaymentRequestService#getPaymentRequestFromCurrentCustomer()}.
   * <p>
   * Method under test: {@link DefaultCurrentCustomerPaymentRequestService#getPaymentRequestFromCurrentCustomer()}
   */
  @Test
  @DisplayName("Test getPaymentRequestFromCurrentCustomer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PaymentRequestDTO DefaultCurrentCustomerPaymentRequestService.getPaymentRequestFromCurrentCustomer()"})
  void testGetPaymentRequestFromCurrentCustomer() {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(paymentRequestDTOService.populateCustomerInfo(Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any()))
        .thenReturn(paymentRequestDTO);

    // Act
    PaymentRequestDTO actualPaymentRequestFromCurrentCustomer = defaultCurrentCustomerPaymentRequestService
        .getPaymentRequestFromCurrentCustomer();

    // Assert
    verify(paymentRequestDTOService).populateCustomerInfo(isA(PaymentRequestDTO.class), isNull());
    assertSame(paymentRequestDTO, actualPaymentRequestFromCurrentCustomer);
  }
}
