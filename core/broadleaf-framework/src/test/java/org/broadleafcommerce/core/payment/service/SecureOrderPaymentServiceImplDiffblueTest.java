/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.payment.domain.secure.Referenced;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.junit.Test;

public class SecureOrderPaymentServiceImplDiffblueTest {
  /**
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  public void testCreate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.create(new PaymentType("Type", "Friendly Type")));
  }

  /**
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  public void testCreate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.create(new PaymentType()));
  }

  /**
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  public void testCreate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(false);

    // Act
    Referenced actualCreateResult = secureOrderPaymentServiceImpl.create(paymentType);

    // Assert
    verify(paymentType).isCreditCardType();
    assertNull(actualCreateResult);
  }

  /**
   * Method under test:
   * {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  public void testFindSecurePaymentInfo() throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", new PaymentType("Type", "Friendly Type")));
  }
}
