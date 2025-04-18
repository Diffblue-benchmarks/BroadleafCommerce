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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.payment.dao.SecureOrderPaymentDao;
import org.broadleafcommerce.core.payment.domain.secure.BankAccountPayment;
import org.broadleafcommerce.core.payment.domain.secure.CreditCardPayment;
import org.broadleafcommerce.core.payment.domain.secure.GiftCardPayment;
import org.broadleafcommerce.core.payment.domain.secure.Referenced;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SecureOrderPaymentServiceImplDiffblueTest {
  @Mock
  private SecureOrderPaymentDao secureOrderPaymentDao;

  @InjectMocks
  private SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;

  /**
   * Test {@link SecureOrderPaymentServiceImpl#save(Referenced)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#save(Referenced)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.save(Referenced)"})
  public void testSave() {
    // Arrange
    when(secureOrderPaymentDao.save(Mockito.<Referenced>any())).thenReturn(mock(Referenced.class));

    // Act
    secureOrderPaymentServiceImpl.save(mock(Referenced.class));

    // Assert
    verify(secureOrderPaymentDao).save(isA(Referenced.class));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate() {
    // Arrange
    when(secureOrderPaymentDao.createCreditCardPayment()).thenReturn(mock(CreditCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.create(new PaymentType("BANK_ACCOUNT", "BANK_ACCOUNT", true, true));

    // Assert
    verify(secureOrderPaymentDao).createCreditCardPayment();
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link PaymentType} {@link PaymentType#isCreditCardType()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_givenFalse_whenPaymentTypeIsCreditCardTypeReturnFalse() {
    // Arrange
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
   *   <li>Given {@link SecureOrderPaymentDao}.</li>
   *   <li>When {@link PaymentType#PaymentType()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_givenSecureOrderPaymentDao_whenPaymentType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(secureOrderPaymentServiceImpl.create(new PaymentType()));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link PaymentType} {@link PaymentType#isCreditCardType()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_givenTrue_whenPaymentTypeIsCreditCardTypeReturnTrue() {
    // Arrange
    when(secureOrderPaymentDao.createCreditCardPayment()).thenReturn(mock(CreditCardPayment.class));
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    // Act
    secureOrderPaymentServiceImpl.create(paymentType);

    // Assert
    verify(paymentType).isCreditCardType();
    verify(secureOrderPaymentDao).createCreditCardPayment();
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#createBankAccountPayment()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_thenCallsCreateBankAccountPayment() {
    // Arrange
    when(secureOrderPaymentDao.createBankAccountPayment()).thenReturn(mock(BankAccountPayment.class));

    // Act
    secureOrderPaymentServiceImpl.create(new PaymentType("BANK_ACCOUNT", "Friendly Type"));

    // Assert
    verify(secureOrderPaymentDao).createBankAccountPayment();
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type} and {@code Friendly Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_whenPaymentTypeWithTypeAndFriendlyType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(secureOrderPaymentServiceImpl.create(new PaymentType("Type", "Friendly Type")));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.findSecurePaymentInfo(String, PaymentType)"})
  public void testFindSecurePaymentInfo() throws WorkflowException {
    // Arrange
    when(secureOrderPaymentDao.findCreditCardPayment(Mockito.<String>any())).thenReturn(mock(CreditCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", new PaymentType("Type", "Friendly Type", true, true));

    // Assert
    verify(secureOrderPaymentDao).findCreditCardPayment(eq("42"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.findSecurePaymentInfo(String, PaymentType)"})
  public void testFindSecurePaymentInfo_givenTrue_thenCallsIsCreditCardType() throws WorkflowException {
    // Arrange
    when(secureOrderPaymentDao.findCreditCardPayment(Mockito.<String>any())).thenReturn(mock(CreditCardPayment.class));
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    // Act
    secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", paymentType);

    // Assert
    verify(paymentType).isCreditCardType();
    verify(secureOrderPaymentDao).findCreditCardPayment(eq("42"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#findBankAccountPayment(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.findSecurePaymentInfo(String, PaymentType)"})
  public void testFindSecurePaymentInfo_thenCallsFindBankAccountPayment() throws WorkflowException {
    // Arrange
    when(secureOrderPaymentDao.findBankAccountPayment(Mockito.<String>any()))
        .thenReturn(mock(BankAccountPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", PaymentType.BANK_ACCOUNT);

    // Assert
    verify(secureOrderPaymentDao).findBankAccountPayment(eq("42"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#findGiftCardPayment(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.findSecurePaymentInfo(String, PaymentType)"})
  public void testFindSecurePaymentInfo_thenCallsFindGiftCardPayment() throws WorkflowException {
    // Arrange
    when(secureOrderPaymentDao.findGiftCardPayment(Mockito.<String>any())).thenReturn(mock(GiftCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", PaymentType.GIFT_CARD);

    // Assert
    verify(secureOrderPaymentDao).findGiftCardPayment(eq("42"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type} and {@code Friendly Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.findSecurePaymentInfo(String, PaymentType)"})
  public void testFindSecurePaymentInfo_whenPaymentTypeWithTypeAndFriendlyType_thenReturnNull()
      throws WorkflowException {
    // Arrange, Act and Assert
    assertNull(secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", new PaymentType("Type", "Friendly Type")));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SecureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo(String, PaymentType)"})
  public void testFindAndRemoveSecurePaymentInfo() throws WorkflowException {
    // Arrange
    doNothing().when(secureOrderPaymentDao).delete(Mockito.<Referenced>any());
    when(secureOrderPaymentDao.findCreditCardPayment(Mockito.<String>any())).thenReturn(mock(CreditCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo("42",
        new PaymentType("Type", "Friendly Type", true, true));

    // Assert
    verify(secureOrderPaymentDao).delete(isA(Referenced.class));
    verify(secureOrderPaymentDao).findCreditCardPayment(eq("42"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SecureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo(String, PaymentType)"})
  public void testFindAndRemoveSecurePaymentInfo_givenTrue_thenCallsIsCreditCardType() throws WorkflowException {
    // Arrange
    doNothing().when(secureOrderPaymentDao).delete(Mockito.<Referenced>any());
    when(secureOrderPaymentDao.findCreditCardPayment(Mockito.<String>any())).thenReturn(mock(CreditCardPayment.class));
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    // Act
    secureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo("42", paymentType);

    // Assert
    verify(paymentType).isCreditCardType();
    verify(secureOrderPaymentDao).delete(isA(Referenced.class));
    verify(secureOrderPaymentDao).findCreditCardPayment(eq("42"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}.
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#findBankAccountPayment(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SecureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo(String, PaymentType)"})
  public void testFindAndRemoveSecurePaymentInfo_thenCallsFindBankAccountPayment() throws WorkflowException {
    // Arrange
    doNothing().when(secureOrderPaymentDao).delete(Mockito.<Referenced>any());
    when(secureOrderPaymentDao.findBankAccountPayment(Mockito.<String>any()))
        .thenReturn(mock(BankAccountPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo("42", PaymentType.BANK_ACCOUNT);

    // Assert
    verify(secureOrderPaymentDao).delete(isA(Referenced.class));
    verify(secureOrderPaymentDao).findBankAccountPayment(eq("42"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}.
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#findGiftCardPayment(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SecureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo(String, PaymentType)"})
  public void testFindAndRemoveSecurePaymentInfo_thenCallsFindGiftCardPayment() throws WorkflowException {
    // Arrange
    doNothing().when(secureOrderPaymentDao).delete(Mockito.<Referenced>any());
    when(secureOrderPaymentDao.findGiftCardPayment(Mockito.<String>any())).thenReturn(mock(GiftCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo("42", PaymentType.GIFT_CARD);

    // Assert
    verify(secureOrderPaymentDao).delete(isA(Referenced.class));
    verify(secureOrderPaymentDao).findGiftCardPayment(eq("42"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#remove(Referenced)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#remove(Referenced)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SecureOrderPaymentServiceImpl.remove(Referenced)"})
  public void testRemove() {
    // Arrange
    doNothing().when(secureOrderPaymentDao).delete(Mockito.<Referenced>any());

    // Act
    secureOrderPaymentServiceImpl.remove(mock(Referenced.class));

    // Assert
    verify(secureOrderPaymentDao).delete(isA(Referenced.class));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findBankAccountInfo(String)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findBankAccountInfo(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BankAccountPayment SecureOrderPaymentServiceImpl.findBankAccountInfo(String)"})
  public void testFindBankAccountInfo() {
    // Arrange
    when(secureOrderPaymentDao.findBankAccountPayment(Mockito.<String>any()))
        .thenReturn(mock(BankAccountPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findBankAccountInfo("42");

    // Assert
    verify(secureOrderPaymentDao).findBankAccountPayment(eq("42"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findCreditCardInfo(String)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findCreditCardInfo(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreditCardPayment SecureOrderPaymentServiceImpl.findCreditCardInfo(String)"})
  public void testFindCreditCardInfo() {
    // Arrange
    when(secureOrderPaymentDao.findCreditCardPayment(Mockito.<String>any())).thenReturn(mock(CreditCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findCreditCardInfo("42");

    // Assert
    verify(secureOrderPaymentDao).findCreditCardPayment(eq("42"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findGiftCardInfo(String)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#findGiftCardInfo(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GiftCardPayment SecureOrderPaymentServiceImpl.findGiftCardInfo(String)"})
  public void testFindGiftCardInfo() {
    // Arrange
    when(secureOrderPaymentDao.findGiftCardPayment(Mockito.<String>any())).thenReturn(mock(GiftCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findGiftCardInfo("42");

    // Assert
    verify(secureOrderPaymentDao).findGiftCardPayment(eq("42"));
  }
}
