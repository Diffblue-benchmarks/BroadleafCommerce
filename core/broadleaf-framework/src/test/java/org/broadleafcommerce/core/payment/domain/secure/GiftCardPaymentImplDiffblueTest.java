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

public class GiftCardPaymentImplDiffblueTest {
  /**
   * Method under test: {@link GiftCardPaymentImpl#getPan()}
   */
  @Test
  public void testGetPan() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    // Act and Assert
    assertEquals("Pan", giftCardPaymentImpl.getPan());
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#getPan()}
   */
  @Test
  public void testGetPan2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Decrypt");
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    // Act
    String actualPan = giftCardPaymentImpl.getPan();

    // Assert
    verify(encryptionModule).decrypt(eq("Encrypt"));
    verify(encryptionModule, atLeast(1)).encrypt(Mockito.<String>any());
    assertEquals("Decrypt", actualPan);
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#getPin()}
   */
  @Test
  public void testGetPin() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    // Act and Assert
    assertEquals("Pin", giftCardPaymentImpl.getPin());
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#getPin()}
   */
  @Test
  public void testGetPin2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Decrypt");
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    // Act
    String actualPin = giftCardPaymentImpl.getPin();

    // Assert
    verify(encryptionModule).decrypt(eq("Encrypt"));
    verify(encryptionModule, atLeast(1)).encrypt(Mockito.<String>any());
    assertEquals("Decrypt", actualPin);
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#setPan(String)}
   */
  @Test
  public void testSetPan() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    // Act
    giftCardPaymentImpl.setPan("Pan");

    // Assert
    verify(encryptionModule, atLeast(1)).encrypt(Mockito.<String>any());
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#setPin(String)}
   */
  @Test
  public void testSetPin() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    // Act
    giftCardPaymentImpl.setPin("Pin");

    // Assert
    verify(encryptionModule, atLeast(1)).encrypt(Mockito.<String>any());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
    int expectedHashCodeResult = giftCardPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, giftCardPaymentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
    int notExpectedHashCodeResult = giftCardPaymentImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, giftCardPaymentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");
    EncryptionModule encryptionModule2 = mock(EncryptionModule.class);
    when(encryptionModule2.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(encryptionModule2);
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
    int expectedHashCodeResult = giftCardPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, giftCardPaymentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber(null);
    EncryptionModule encryptionModule2 = mock(EncryptionModule.class);
    when(encryptionModule2.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(encryptionModule2);
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber(null);

    // Act and Assert
    assertEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
    int expectedHashCodeResult = giftCardPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, giftCardPaymentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    // Act and Assert
    assertEquals(giftCardPaymentImpl, giftCardPaymentImpl);
    int expectedHashCodeResult = giftCardPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, giftCardPaymentImpl.hashCode());
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(2L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(null);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Pan");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn(null);

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("Encrypt");
    EncryptionModule encryptionModule2 = mock(EncryptionModule.class);
    when(encryptionModule2.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(encryptionModule2);
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EncryptionModule encryptionModule = mock(EncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(encryptionModule);
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber(null);
    EncryptionModule encryptionModule2 = mock(EncryptionModule.class);
    when(encryptionModule2.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(encryptionModule2);
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(giftCardPaymentImpl, null);
  }

  /**
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(1L);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    // Act and Assert
    assertNotEquals(giftCardPaymentImpl, "Different type to GiftCardPaymentImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GiftCardPaymentImpl}
   *   <li>{@link GiftCardPaymentImpl#setEncryptionModule(EncryptionModule)}
   *   <li>{@link GiftCardPaymentImpl#setId(Long)}
   *   <li>{@link GiftCardPaymentImpl#setReferenceNumber(String)}
   *   <li>{@link GiftCardPaymentImpl#getEncryptionModule()}
   *   <li>{@link GiftCardPaymentImpl#getId()}
   *   <li>{@link GiftCardPaymentImpl#getReferenceNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    GiftCardPaymentImpl actualGiftCardPaymentImpl = new GiftCardPaymentImpl();
    PassthroughEncryptionModule encryptionModule = new PassthroughEncryptionModule();
    actualGiftCardPaymentImpl.setEncryptionModule(encryptionModule);
    actualGiftCardPaymentImpl.setId(1L);
    actualGiftCardPaymentImpl.setReferenceNumber("42");
    EncryptionModule actualEncryptionModule = actualGiftCardPaymentImpl.getEncryptionModule();
    Long actualId = actualGiftCardPaymentImpl.getId();

    // Assert that nothing has changed
    assertTrue(actualEncryptionModule instanceof PassthroughEncryptionModule);
    assertEquals("42", actualGiftCardPaymentImpl.getReferenceNumber());
    assertEquals(1L, actualId.longValue());
    assertSame(encryptionModule, actualEncryptionModule);
  }
}
