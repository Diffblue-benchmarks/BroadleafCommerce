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
package org.broadleafcommerce.core.payment.domain.secure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.encryption.EncryptionModule;
import org.broadleafcommerce.common.encryption.PassthroughEncryptionModule;
import org.junit.Test;
import org.mockito.Mockito;

public class BankAccountPaymentImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BankAccountPaymentImpl}
   *   <li>{@link BankAccountPaymentImpl#setEncryptionModule(EncryptionModule)}
   *   <li>{@link BankAccountPaymentImpl#setId(Long)}
   *   <li>{@link BankAccountPaymentImpl#setReferenceNumber(String)}
   *   <li>{@link BankAccountPaymentImpl#getEncryptionModule()}
   *   <li>{@link BankAccountPaymentImpl#getId()}
   *   <li>{@link BankAccountPaymentImpl#getReferenceNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BankAccountPaymentImpl actualBankAccountPaymentImpl = new BankAccountPaymentImpl();
    PassthroughEncryptionModule encryptionModule = new PassthroughEncryptionModule();
    actualBankAccountPaymentImpl.setEncryptionModule(encryptionModule);
    actualBankAccountPaymentImpl.setId(1L);
    actualBankAccountPaymentImpl.setReferenceNumber("42");
    EncryptionModule actualEncryptionModule = actualBankAccountPaymentImpl.getEncryptionModule();
    Long actualId = actualBankAccountPaymentImpl.getId();

    // Assert that nothing has changed
    assertTrue(actualEncryptionModule instanceof PassthroughEncryptionModule);
    assertEquals("42", actualBankAccountPaymentImpl.getReferenceNumber());
    assertEquals(1L, actualId.longValue());
    assertSame(encryptionModule, actualEncryptionModule);
  }

  /**
   * Test {@link BankAccountPaymentImpl#getAccountNumber()}.
   * <ul>
   *   <li>Then return {@code Decrypt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#getAccountNumber()}
   */
  @Test
  public void testGetAccountNumber_thenReturnDecrypt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Decrypt");

    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(encryptionModule);

    // Act
    String actualAccountNumber = bankAccountPaymentImpl.getAccountNumber();

    // Assert
    verify(encryptionModule).decrypt(isNull());
    assertEquals("Decrypt", actualAccountNumber);
  }

  /**
   * Test {@link BankAccountPaymentImpl#getAccountNumber()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#getAccountNumber()}
   */
  @Test
  public void testGetAccountNumber_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act and Assert
    assertNull(bankAccountPaymentImpl.getAccountNumber());
  }

  /**
   * Test {@link BankAccountPaymentImpl#setAccountNumber(String)}.
   * <ul>
   *   <li>Then {@link BankAccountPaymentImpl#BankAccountPaymentImpl()}
   * AccountNumber is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#setAccountNumber(String)}
   */
  @Test
  public void testSetAccountNumber_thenBankAccountPaymentImplAccountNumberIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act
    bankAccountPaymentImpl.setAccountNumber("42");

    // Assert
    assertEquals("42", bankAccountPaymentImpl.getAccountNumber());
    assertEquals("42", bankAccountPaymentImpl.accountNumber);
  }

  /**
   * Test {@link BankAccountPaymentImpl#setAccountNumber(String)}.
   * <ul>
   *   <li>Then {@link BankAccountPaymentImpl#BankAccountPaymentImpl()}
   * {@link BankAccountPaymentImpl#accountNumber} is {@code Encrypt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#setAccountNumber(String)}
   */
  @Test
  public void testSetAccountNumber_thenBankAccountPaymentImplAccountNumberIsEncrypt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(encryptionModule);

    // Act
    bankAccountPaymentImpl.setAccountNumber("42");

    // Assert
    verify(encryptionModule).encrypt(eq("42"));
    assertEquals("Encrypt", bankAccountPaymentImpl.accountNumber);
    assertNull(bankAccountPaymentImpl.getAccountNumber());
  }

  /**
   * Test {@link BankAccountPaymentImpl#getRoutingNumber()}.
   * <ul>
   *   <li>Then return {@code Decrypt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#getRoutingNumber()}
   */
  @Test
  public void testGetRoutingNumber_thenReturnDecrypt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Decrypt");

    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(encryptionModule);

    // Act
    String actualRoutingNumber = bankAccountPaymentImpl.getRoutingNumber();

    // Assert
    verify(encryptionModule).decrypt(isNull());
    assertEquals("Decrypt", actualRoutingNumber);
  }

  /**
   * Test {@link BankAccountPaymentImpl#getRoutingNumber()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#getRoutingNumber()}
   */
  @Test
  public void testGetRoutingNumber_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act and Assert
    assertNull(bankAccountPaymentImpl.getRoutingNumber());
  }

  /**
   * Test {@link BankAccountPaymentImpl#setRoutingNumber(String)}.
   * <ul>
   *   <li>Then {@link BankAccountPaymentImpl#BankAccountPaymentImpl()}
   * RoutingNumber is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#setRoutingNumber(String)}
   */
  @Test
  public void testSetRoutingNumber_thenBankAccountPaymentImplRoutingNumberIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act
    bankAccountPaymentImpl.setRoutingNumber("42");

    // Assert
    assertEquals("42", bankAccountPaymentImpl.getRoutingNumber());
    assertEquals("42", bankAccountPaymentImpl.routingNumber);
  }

  /**
   * Test {@link BankAccountPaymentImpl#setRoutingNumber(String)}.
   * <ul>
   *   <li>Then {@link BankAccountPaymentImpl#BankAccountPaymentImpl()}
   * {@link BankAccountPaymentImpl#routingNumber} is {@code Encrypt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#setRoutingNumber(String)}
   */
  @Test
  public void testSetRoutingNumber_thenBankAccountPaymentImplRoutingNumberIsEncrypt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(encryptionModule);

    // Act
    bankAccountPaymentImpl.setRoutingNumber("42");

    // Assert
    verify(encryptionModule).encrypt(eq("42"));
    assertEquals("Encrypt", bankAccountPaymentImpl.routingNumber);
    assertNull(bankAccountPaymentImpl.getRoutingNumber());
  }
}
