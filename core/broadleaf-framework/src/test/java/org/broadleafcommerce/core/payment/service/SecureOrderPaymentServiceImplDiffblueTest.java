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
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  public void testCreate_givenFalse_thenCallsIsCreditCardType() {
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
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  public void testCreate_whenPaymentTypeWithTypeAndFriendlyType_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.create(new PaymentType("Type", "Friendly Type")));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  public void testCreate_whenPaymentType_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.create(new PaymentType()));
  }

  /**
   * Test
   * {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  public void testFindSecurePaymentInfo_whenPaymentTypeWithTypeAndFriendlyType_thenReturnNull()
      throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", new PaymentType("Type", "Friendly Type")));
  }
}
