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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.encryption.EncryptionModule;
import org.broadleafcommerce.common.encryption.PassthroughEncryptionModule;
import org.junit.Test;
import org.mockito.Mockito;

public class CreditCardPaymentInfoImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CreditCardPaymentInfoImpl}
   *   <li>{@link CreditCardPaymentInfoImpl#setCvvCode(String)}
   *   <li>{@link CreditCardPaymentInfoImpl#setEncryptionModule(EncryptionModule)}
   *   <li>{@link CreditCardPaymentInfoImpl#setExpirationMonth(Integer)}
   *   <li>{@link CreditCardPaymentInfoImpl#setExpirationYear(Integer)}
   *   <li>{@link CreditCardPaymentInfoImpl#setId(Long)}
   *   <li>{@link CreditCardPaymentInfoImpl#setNameOnCard(String)}
   *   <li>{@link CreditCardPaymentInfoImpl#setReferenceNumber(String)}
   *   <li>{@link CreditCardPaymentInfoImpl#getCvvCode()}
   *   <li>{@link CreditCardPaymentInfoImpl#getEncryptionModule()}
   *   <li>{@link CreditCardPaymentInfoImpl#getExpirationMonth()}
   *   <li>{@link CreditCardPaymentInfoImpl#getExpirationYear()}
   *   <li>{@link CreditCardPaymentInfoImpl#getId()}
   *   <li>{@link CreditCardPaymentInfoImpl#getNameOnCard()}
   *   <li>{@link CreditCardPaymentInfoImpl#getReferenceNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CreditCardPaymentInfoImpl actualCreditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    actualCreditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    PassthroughEncryptionModule encryptionModule = new PassthroughEncryptionModule();
    actualCreditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    actualCreditCardPaymentInfoImpl.setExpirationMonth(1);
    actualCreditCardPaymentInfoImpl.setExpirationYear(1);
    actualCreditCardPaymentInfoImpl.setId(1L);
    actualCreditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    actualCreditCardPaymentInfoImpl.setReferenceNumber("42");
    String actualCvvCode = actualCreditCardPaymentInfoImpl.getCvvCode();
    EncryptionModule actualEncryptionModule = actualCreditCardPaymentInfoImpl.getEncryptionModule();
    Integer actualExpirationMonth = actualCreditCardPaymentInfoImpl.getExpirationMonth();
    Integer actualExpirationYear = actualCreditCardPaymentInfoImpl.getExpirationYear();
    Long actualId = actualCreditCardPaymentInfoImpl.getId();
    String actualNameOnCard = actualCreditCardPaymentInfoImpl.getNameOnCard();

    // Assert that nothing has changed
    assertTrue(actualEncryptionModule instanceof PassthroughEncryptionModule);
    assertEquals("42", actualCreditCardPaymentInfoImpl.getReferenceNumber());
    assertEquals("Cvv Code", actualCvvCode);
    assertEquals("Name On Card", actualNameOnCard);
    assertEquals(1, actualExpirationMonth.intValue());
    assertEquals(1, actualExpirationYear.intValue());
    assertEquals(1L, actualId.longValue());
    assertSame(encryptionModule, actualEncryptionModule);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#getPan()}.
   * <ul>
   *   <li>Then return {@code Decrypt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#getPan()}
   */
  @Test
  public void testGetPan_thenReturnDecrypt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Decrypt");
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(1L);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    // Act
    String actualPan = creditCardPaymentInfoImpl.getPan();

    // Assert
    verify(encryptionModule).decrypt(eq("Encrypt"));
    verify(encryptionModule).encrypt(eq("Pan"));
    assertEquals("Decrypt", actualPan);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#getPan()}.
   * <ul>
   *   <li>Then return {@code Pan}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#getPan()}
   */
  @Test
  public void testGetPan_thenReturnPan() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(1L);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    // Act and Assert
    assertEquals("Pan", creditCardPaymentInfoImpl.getPan());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#setPan(String)}.
   * <ul>
   *   <li>Given {@link PassthroughEncryptionModule}
   * {@link PassthroughEncryptionModule#encrypt(String)} return
   * {@code Encrypt}.</li>
   *   <li>Then calls {@link PassthroughEncryptionModule#encrypt(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#setPan(String)}
   */
  @Test
  public void testSetPan_givenPassthroughEncryptionModuleEncryptReturnEncrypt_thenCallsEncrypt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(1L);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    // Act
    creditCardPaymentInfoImpl.setPan("Pan");

    // Assert
    verify(encryptionModule, atLeast(1)).encrypt(eq("Pan"));
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and
   * {@link CreditCardPaymentInfoImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(1L);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
    int expectedHashCodeResult = creditCardPaymentInfoImpl.hashCode();
    assertEquals(expectedHashCodeResult, creditCardPaymentInfoImpl2.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and
   * {@link CreditCardPaymentInfoImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(1L);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
    int notExpectedHashCodeResult = creditCardPaymentInfoImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, creditCardPaymentInfoImpl2.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and
   * {@link CreditCardPaymentInfoImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Pan");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
    int expectedHashCodeResult = creditCardPaymentInfoImpl.hashCode();
    assertEquals(expectedHashCodeResult, creditCardPaymentInfoImpl2.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and
   * {@link CreditCardPaymentInfoImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(1L);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    // Act and Assert
    assertEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl);
    int expectedHashCodeResult = creditCardPaymentInfoImpl.hashCode();
    assertEquals(expectedHashCodeResult, creditCardPaymentInfoImpl.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(2L);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(1L);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(null);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn(null);

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(0);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(null);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(0);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(null);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Pan");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("Pan");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Pan");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(encryptionModule);
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber(null);

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(1L);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, null);
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(1L);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(creditCardPaymentInfoImpl, "Different type to CreditCardPaymentInfoImpl");
  }
}
