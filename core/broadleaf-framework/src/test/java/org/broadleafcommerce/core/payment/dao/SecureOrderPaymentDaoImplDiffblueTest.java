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
package org.broadleafcommerce.core.payment.dao;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.encryption.EncryptionModule;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.payment.domain.secure.BankAccountPayment;
import org.broadleafcommerce.core.payment.domain.secure.CreditCardPayment;
import org.broadleafcommerce.core.payment.domain.secure.GiftCardPayment;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SecureOrderPaymentDaoImplDiffblueTest {
  @Mock
  private EncryptionModule encryptionModule;

  @Mock
  private EntityConfiguration entityConfiguration;

  @InjectMocks
  private SecureOrderPaymentDaoImpl secureOrderPaymentDaoImpl;

  /**
   * Test {@link SecureOrderPaymentDaoImpl#createBankAccountPayment()}.
   * <p>
   * Method under test: {@link SecureOrderPaymentDaoImpl#createBankAccountPayment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BankAccountPayment SecureOrderPaymentDaoImpl.createBankAccountPayment()"})
  public void testCreateBankAccountPayment() {
    // Arrange
    BankAccountPayment bankAccountPayment = mock(BankAccountPayment.class);
    doNothing().when(bankAccountPayment).setEncryptionModule(Mockito.<EncryptionModule>any());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<BankAccountPayment>>any()))
        .thenReturn(bankAccountPayment);

    // Act
    secureOrderPaymentDaoImpl.createBankAccountPayment();

    // Assert
    verify(entityConfiguration).createEntityInstance(
        eq("org.broadleafcommerce.core.payment.domain.secure.BankAccountPayment"), isA(Class.class));
    verify(bankAccountPayment).setEncryptionModule(isA(EncryptionModule.class));
  }

  /**
   * Test {@link SecureOrderPaymentDaoImpl#createGiftCardPayment()}.
   * <p>
   * Method under test: {@link SecureOrderPaymentDaoImpl#createGiftCardPayment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GiftCardPayment SecureOrderPaymentDaoImpl.createGiftCardPayment()"})
  public void testCreateGiftCardPayment() {
    // Arrange
    GiftCardPayment giftCardPayment = mock(GiftCardPayment.class);
    doNothing().when(giftCardPayment).setEncryptionModule(Mockito.<EncryptionModule>any());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<GiftCardPayment>>any()))
        .thenReturn(giftCardPayment);

    // Act
    secureOrderPaymentDaoImpl.createGiftCardPayment();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(eq("org.broadleafcommerce.core.payment.domain.secure.GiftCardPayment"), isA(Class.class));
    verify(giftCardPayment).setEncryptionModule(isA(EncryptionModule.class));
  }

  /**
   * Test {@link SecureOrderPaymentDaoImpl#createCreditCardPayment()}.
   * <p>
   * Method under test: {@link SecureOrderPaymentDaoImpl#createCreditCardPayment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreditCardPayment SecureOrderPaymentDaoImpl.createCreditCardPayment()"})
  public void testCreateCreditCardPayment() {
    // Arrange
    CreditCardPayment creditCardPayment = mock(CreditCardPayment.class);
    doNothing().when(creditCardPayment).setEncryptionModule(Mockito.<EncryptionModule>any());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any(), Mockito.<Class<CreditCardPayment>>any()))
        .thenReturn(creditCardPayment);

    // Act
    secureOrderPaymentDaoImpl.createCreditCardPayment();

    // Assert
    verify(entityConfiguration).createEntityInstance(
        eq("org.broadleafcommerce.core.payment.domain.secure.CreditCardPayment"), isA(Class.class));
    verify(creditCardPayment).setEncryptionModule(isA(EncryptionModule.class));
  }
}
