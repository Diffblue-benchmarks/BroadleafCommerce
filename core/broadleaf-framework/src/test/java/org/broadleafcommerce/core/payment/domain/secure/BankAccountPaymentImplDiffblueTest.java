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
package org.broadleafcommerce.core.payment.domain.secure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.encryption.EncryptionModule;
import org.broadleafcommerce.common.encryption.PassthroughEncryptionModule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BankAccountPaymentImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BankAccountPaymentImpl.<init>()",
    "EncryptionModule BankAccountPaymentImpl.getEncryptionModule()",
    "Long BankAccountPaymentImpl.getId()",
    "String BankAccountPaymentImpl.getReferenceNumber()",
    "void BankAccountPaymentImpl.setEncryptionModule(EncryptionModule)",
    "void BankAccountPaymentImpl.setId(Long)",
    "void BankAccountPaymentImpl.setReferenceNumber(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BankAccountPaymentImpl actualBankAccountPaymentImpl = new BankAccountPaymentImpl();
    PassthroughEncryptionModule encryptionModule = new PassthroughEncryptionModule();
    actualBankAccountPaymentImpl.setEncryptionModule(encryptionModule);
    actualBankAccountPaymentImpl.setId(1L);
    actualBankAccountPaymentImpl.setReferenceNumber("42");
    EncryptionModule actualEncryptionModule = actualBankAccountPaymentImpl.getEncryptionModule();
    Long actualId = actualBankAccountPaymentImpl.getId();

    // Assert
    assertTrue(actualEncryptionModule instanceof PassthroughEncryptionModule);
    assertEquals("42", actualBankAccountPaymentImpl.getReferenceNumber());
    assertEquals(1L, actualId.longValue());
    assertSame(encryptionModule, actualEncryptionModule);
  }

  /**
   * Test {@link BankAccountPaymentImpl#getAccountNumber()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BankAccountPaymentImpl#getAccountNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BankAccountPaymentImpl.getAccountNumber()"})
  public void testGetAccountNumber_thenReturnNull() {
    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act and Assert
    assertNull(bankAccountPaymentImpl.getAccountNumber());
  }

  /**
   * Test {@link BankAccountPaymentImpl#setAccountNumber(String)}.
   *
   * <ul>
   *   <li>Then {@link BankAccountPaymentImpl#BankAccountPaymentImpl()} AccountNumber is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BankAccountPaymentImpl#setAccountNumber(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BankAccountPaymentImpl.setAccountNumber(String)"})
  public void testSetAccountNumber_thenBankAccountPaymentImplAccountNumberIs42() {
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
   * Test {@link BankAccountPaymentImpl#getRoutingNumber()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BankAccountPaymentImpl#getRoutingNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BankAccountPaymentImpl.getRoutingNumber()"})
  public void testGetRoutingNumber_thenReturnNull() {
    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act and Assert
    assertNull(bankAccountPaymentImpl.getRoutingNumber());
  }

  /**
   * Test {@link BankAccountPaymentImpl#setRoutingNumber(String)}.
   *
   * <ul>
   *   <li>Then {@link BankAccountPaymentImpl#BankAccountPaymentImpl()} RoutingNumber is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BankAccountPaymentImpl#setRoutingNumber(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BankAccountPaymentImpl.setRoutingNumber(String)"})
  public void testSetRoutingNumber_thenBankAccountPaymentImplRoutingNumberIs42() {
    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act
    bankAccountPaymentImpl.setRoutingNumber("42");

    // Assert
    assertEquals("42", bankAccountPaymentImpl.getRoutingNumber());
    assertEquals("42", bankAccountPaymentImpl.routingNumber);
  }
}
