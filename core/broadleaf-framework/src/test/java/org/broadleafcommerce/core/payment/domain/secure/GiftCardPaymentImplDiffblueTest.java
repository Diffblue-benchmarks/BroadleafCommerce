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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.encryption.EncryptionModule;
import org.broadleafcommerce.common.encryption.PassthroughEncryptionModule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class GiftCardPaymentImplDiffblueTest {
  @Autowired
  private GiftCardPaymentImpl giftCardPaymentImpl;

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GiftCardPaymentImpl.<init>()", "EncryptionModule GiftCardPaymentImpl.getEncryptionModule()",
      "Long GiftCardPaymentImpl.getId()", "String GiftCardPaymentImpl.getReferenceNumber()",
      "void GiftCardPaymentImpl.setEncryptionModule(EncryptionModule)", "void GiftCardPaymentImpl.setId(Long)",
      "void GiftCardPaymentImpl.setReferenceNumber(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    GiftCardPaymentImpl actualGiftCardPaymentImpl = new GiftCardPaymentImpl();
    PassthroughEncryptionModule encryptionModule = new PassthroughEncryptionModule();
    actualGiftCardPaymentImpl.setEncryptionModule(encryptionModule);
    actualGiftCardPaymentImpl.setId(1L);
    actualGiftCardPaymentImpl.setReferenceNumber("42");
    EncryptionModule actualEncryptionModule = actualGiftCardPaymentImpl.getEncryptionModule();
    Long actualId = actualGiftCardPaymentImpl.getId();

    // Assert
    assertTrue(actualEncryptionModule instanceof PassthroughEncryptionModule);
    assertEquals("42", actualGiftCardPaymentImpl.getReferenceNumber());
    assertEquals(1L, actualId.longValue());
    assertSame(encryptionModule, actualEncryptionModule);
  }

  /**
   * Test {@link GiftCardPaymentImpl#getPan()}.
   * <ul>
   *   <li>Then return {@code Pan}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftCardPaymentImpl#getPan()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String GiftCardPaymentImpl.getPan()"})
  public void testGetPan_thenReturnPan() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals("Pan", giftCardPaymentImpl2.getPan());
  }

  /**
   * Test {@link GiftCardPaymentImpl#getPin()}.
   * <ul>
   *   <li>Then return {@code Pin}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftCardPaymentImpl#getPin()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String GiftCardPaymentImpl.getPin()"})
  public void testGetPin_thenReturnPin() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals("Pin", giftCardPaymentImpl2.getPin());
  }

  /**
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GiftCardPaymentImpl.equals(Object)", "int GiftCardPaymentImpl.hashCode()"})
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
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GiftCardPaymentImpl.equals(Object)", "int GiftCardPaymentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
    assertEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
    int expectedHashCodeResult = giftCardPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, giftCardPaymentImpl2.hashCode());
  }

  /**
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GiftCardPaymentImpl.equals(Object)", "int GiftCardPaymentImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
    assertEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
    int expectedHashCodeResult = giftCardPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, giftCardPaymentImpl2.hashCode());
  }

  /**
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GiftCardPaymentImpl.equals(Object)", "int GiftCardPaymentImpl.hashCode()"})
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
   * Test {@link GiftCardPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GiftCardPaymentImpl.equals(Object)", "int GiftCardPaymentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
   * Test {@link GiftCardPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GiftCardPaymentImpl.equals(Object)", "int GiftCardPaymentImpl.hashCode()"})
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
   * Test {@link GiftCardPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GiftCardPaymentImpl.equals(Object)", "int GiftCardPaymentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   * Test {@link GiftCardPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GiftCardPaymentImpl.equals(Object)", "int GiftCardPaymentImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * Test {@link GiftCardPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GiftCardPaymentImpl.equals(Object)", "int GiftCardPaymentImpl.hashCode()"})
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
   * Test {@link GiftCardPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GiftCardPaymentImpl.equals(Object)", "int GiftCardPaymentImpl.hashCode()"})
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
}
