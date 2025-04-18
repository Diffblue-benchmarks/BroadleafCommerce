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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultCurrentOrderPaymentRequestServiceDiffblueTest {
  @InjectMocks
  private DefaultCurrentOrderPaymentRequestService defaultCurrentOrderPaymentRequestService;

  @Mock
  private OrderService orderService;

  @Mock
  private OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;

  /**
   * Test {@link DefaultCurrentOrderPaymentRequestService#getPaymentRequestFromCurrentOrder()}.
   * <p>
   * Method under test: {@link DefaultCurrentOrderPaymentRequestService#getPaymentRequestFromCurrentOrder()}
   */
  @Test
  @DisplayName("Test getPaymentRequestFromCurrentOrder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PaymentRequestDTO DefaultCurrentOrderPaymentRequestService.getPaymentRequestFromCurrentOrder()"})
  void testGetPaymentRequestFromCurrentOrder() {
    // Arrange
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(orderToPaymentRequestDTOService.translateOrder(Mockito.<Order>any())).thenReturn(paymentRequestDTO);

    // Act
    PaymentRequestDTO actualPaymentRequestFromCurrentOrder = defaultCurrentOrderPaymentRequestService
        .getPaymentRequestFromCurrentOrder();

    // Assert
    verify(orderToPaymentRequestDTOService).translateOrder(isNull());
    assertSame(paymentRequestDTO, actualPaymentRequestFromCurrentOrder);
  }
}
