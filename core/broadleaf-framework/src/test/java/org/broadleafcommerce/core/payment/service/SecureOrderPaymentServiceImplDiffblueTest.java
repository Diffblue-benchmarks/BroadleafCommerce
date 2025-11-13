package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Mock private SecureOrderPaymentDao secureOrderPaymentDao;

  @InjectMocks private SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;

  /**
   * Test {@link SecureOrderPaymentServiceImpl#save(Referenced)}.
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#save(Referenced)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaymentType} {@link PaymentType#isCreditCardType()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_givenFalse_whenPaymentTypeIsCreditCardTypeReturnFalse() {
    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl =
        new SecureOrderPaymentServiceImpl();

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
   *
   * <ul>
   *   <li>Given {@link SecureOrderPaymentServiceImpl} (default constructor).
   *   <li>When {@link PaymentType#PaymentType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_givenSecureOrderPaymentServiceImpl_whenPaymentType_thenReturnNull() {
    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl =
        new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.create(new PaymentType()));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   *
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#createBankAccountPayment()}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_thenCallsCreateBankAccountPayment() {
    // Arrange
    when(secureOrderPaymentDao.createBankAccountPayment())
        .thenReturn(mock(BankAccountPayment.class));

    // Act
    secureOrderPaymentServiceImpl.create(PaymentType.BANK_ACCOUNT);

    // Assert
    verify(secureOrderPaymentDao).createBankAccountPayment();
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   *
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#createCreditCardPayment()}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_thenCallsCreateCreditCardPayment() {
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
   *
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#createGiftCardPayment()}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_thenCallsCreateGiftCardPayment() {
    // Arrange
    when(secureOrderPaymentDao.createGiftCardPayment()).thenReturn(mock(GiftCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.create(PaymentType.GIFT_CARD);

    // Assert
    verify(secureOrderPaymentDao).createGiftCardPayment();
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   *
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type} and {@code
   *       Friendly Type}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Referenced SecureOrderPaymentServiceImpl.create(PaymentType)"})
  public void testCreate_whenPaymentTypeWithTypeAndFriendlyType_thenReturnNull() {
    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl =
        new SecureOrderPaymentServiceImpl();

    // Act
    Referenced actualCreateResult =
        secureOrderPaymentServiceImpl.create(new PaymentType("Type", "Friendly Type"));

    // Assert
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaymentType} {@link PaymentType#isCreditCardType()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Referenced SecureOrderPaymentServiceImpl.findSecurePaymentInfo(String, PaymentType)"
  })
  public void testFindSecurePaymentInfo_givenFalse_whenPaymentTypeIsCreditCardTypeReturnFalse()
      throws WorkflowException {
    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl =
        new SecureOrderPaymentServiceImpl();

    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(false);

    // Act
    Referenced actualFindSecurePaymentInfoResult =
        secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", paymentType);

    // Assert
    verify(paymentType).isCreditCardType();
    assertNull(actualFindSecurePaymentInfoResult);
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   *
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#findBankAccountPayment(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Referenced SecureOrderPaymentServiceImpl.findSecurePaymentInfo(String, PaymentType)"
  })
  public void testFindSecurePaymentInfo_thenCallsFindBankAccountPayment() throws WorkflowException {
    // Arrange
    when(secureOrderPaymentDao.findBankAccountPayment(Mockito.<String>any()))
        .thenReturn(mock(BankAccountPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", PaymentType.BANK_ACCOUNT);

    // Assert
    verify(secureOrderPaymentDao).findBankAccountPayment("42");
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   *
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#findCreditCardPayment(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Referenced SecureOrderPaymentServiceImpl.findSecurePaymentInfo(String, PaymentType)"
  })
  public void testFindSecurePaymentInfo_thenCallsFindCreditCardPayment() throws WorkflowException {
    // Arrange
    when(secureOrderPaymentDao.findCreditCardPayment(Mockito.<String>any()))
        .thenReturn(mock(CreditCardPayment.class));

    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    // Act
    secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", paymentType);

    // Assert
    verify(paymentType).isCreditCardType();
    verify(secureOrderPaymentDao).findCreditCardPayment("42");
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   *
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#findGiftCardPayment(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Referenced SecureOrderPaymentServiceImpl.findSecurePaymentInfo(String, PaymentType)"
  })
  public void testFindSecurePaymentInfo_thenCallsFindGiftCardPayment() throws WorkflowException {
    // Arrange
    when(secureOrderPaymentDao.findGiftCardPayment(Mockito.<String>any()))
        .thenReturn(mock(GiftCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", PaymentType.GIFT_CARD);

    // Assert
    verify(secureOrderPaymentDao).findGiftCardPayment("42");
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   *
   * <ul>
   *   <li>When {@link PaymentType#PaymentType()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Referenced SecureOrderPaymentServiceImpl.findSecurePaymentInfo(String, PaymentType)"
  })
  public void testFindSecurePaymentInfo_whenPaymentType_thenReturnNull() throws WorkflowException {
    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl =
        new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", new PaymentType()));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}.
   *
   * <ul>
   *   <li>Given {@link SecureOrderPaymentServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo(String, PaymentType)"
  })
  public void testFindAndRemoveSecurePaymentInfo_givenSecureOrderPaymentServiceImpl()
      throws WorkflowException {
    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl =
        new SecureOrderPaymentServiceImpl();

    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(false);

    // Act
    secureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo("42", paymentType);

    // Assert
    verify(paymentType).isCreditCardType();
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}.
   *
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#findBankAccountPayment(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo(String, PaymentType)"
  })
  public void testFindAndRemoveSecurePaymentInfo_thenCallsFindBankAccountPayment()
      throws WorkflowException {
    // Arrange
    doNothing().when(secureOrderPaymentDao).delete(Mockito.<Referenced>any());
    when(secureOrderPaymentDao.findBankAccountPayment(Mockito.<String>any()))
        .thenReturn(mock(BankAccountPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo("42", PaymentType.BANK_ACCOUNT);

    // Assert
    verify(secureOrderPaymentDao).delete(isA(Referenced.class));
    verify(secureOrderPaymentDao).findBankAccountPayment("42");
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}.
   *
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#findCreditCardPayment(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo(String, PaymentType)"
  })
  public void testFindAndRemoveSecurePaymentInfo_thenCallsFindCreditCardPayment()
      throws WorkflowException {
    // Arrange
    doNothing().when(secureOrderPaymentDao).delete(Mockito.<Referenced>any());
    when(secureOrderPaymentDao.findCreditCardPayment(Mockito.<String>any()))
        .thenReturn(mock(CreditCardPayment.class));

    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    // Act
    secureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo("42", paymentType);

    // Assert
    verify(paymentType).isCreditCardType();
    verify(secureOrderPaymentDao).delete(isA(Referenced.class));
    verify(secureOrderPaymentDao).findCreditCardPayment("42");
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}.
   *
   * <ul>
   *   <li>Then calls {@link SecureOrderPaymentDao#findGiftCardPayment(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo(String, PaymentType)"
  })
  public void testFindAndRemoveSecurePaymentInfo_thenCallsFindGiftCardPayment()
      throws WorkflowException {
    // Arrange
    doNothing().when(secureOrderPaymentDao).delete(Mockito.<Referenced>any());
    when(secureOrderPaymentDao.findGiftCardPayment(Mockito.<String>any()))
        .thenReturn(mock(GiftCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findAndRemoveSecurePaymentInfo("42", PaymentType.GIFT_CARD);

    // Assert
    verify(secureOrderPaymentDao).delete(isA(Referenced.class));
    verify(secureOrderPaymentDao).findGiftCardPayment("42");
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#remove(Referenced)}.
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#remove(Referenced)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#findBankAccountInfo(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BankAccountPayment SecureOrderPaymentServiceImpl.findBankAccountInfo(String)"
  })
  public void testFindBankAccountInfo() {
    // Arrange
    when(secureOrderPaymentDao.findBankAccountPayment(Mockito.<String>any()))
        .thenReturn(mock(BankAccountPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findBankAccountInfo("42");

    // Assert
    verify(secureOrderPaymentDao).findBankAccountPayment("42");
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findCreditCardInfo(String)}.
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#findCreditCardInfo(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardPayment SecureOrderPaymentServiceImpl.findCreditCardInfo(String)"})
  public void testFindCreditCardInfo() {
    // Arrange
    when(secureOrderPaymentDao.findCreditCardPayment(Mockito.<String>any()))
        .thenReturn(mock(CreditCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findCreditCardInfo("42");

    // Assert
    verify(secureOrderPaymentDao).findCreditCardPayment("42");
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findGiftCardInfo(String)}.
   *
   * <p>Method under test: {@link SecureOrderPaymentServiceImpl#findGiftCardInfo(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GiftCardPayment SecureOrderPaymentServiceImpl.findGiftCardInfo(String)"})
  public void testFindGiftCardInfo() {
    // Arrange
    when(secureOrderPaymentDao.findGiftCardPayment(Mockito.<String>any()))
        .thenReturn(mock(GiftCardPayment.class));

    // Act
    secureOrderPaymentServiceImpl.findGiftCardInfo("42");

    // Assert
    verify(secureOrderPaymentDao).findGiftCardPayment("42");
  }
}
