package org.broadleafcommerce.core.payment.domain.secure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
public class GiftCardPaymentImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GiftCardPaymentImpl.<init>()",
    "EncryptionModule GiftCardPaymentImpl.getEncryptionModule()",
    "Long GiftCardPaymentImpl.getId()",
    "String GiftCardPaymentImpl.getReferenceNumber()",
    "void GiftCardPaymentImpl.setEncryptionModule(EncryptionModule)",
    "void GiftCardPaymentImpl.setId(Long)",
    "void GiftCardPaymentImpl.setReferenceNumber(String)"
  })
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
   *
   * <ul>
   *   <li>Then return {@code Pan}.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#getPan()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GiftCardPaymentImpl.getPan()"})
  public void testGetPan_thenReturnPan() {
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
   * Test {@link GiftCardPaymentImpl#getPin()}.
   *
   * <ul>
   *   <li>Then return {@code Pin}.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#getPin()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GiftCardPaymentImpl.getPin()"})
  public void testGetPin_thenReturnPin() {
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
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
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
    assertEquals(giftCardPaymentImpl.hashCode(), giftCardPaymentImpl2.hashCode());
  }

  /**
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
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
    assertEquals(giftCardPaymentImpl.hashCode(), giftCardPaymentImpl2.hashCode());
  }

  /**
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
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
    assertEquals(giftCardPaymentImpl.hashCode(), giftCardPaymentImpl2.hashCode());
  }

  /**
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan(null);
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("42");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan(null);
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
    assertEquals(giftCardPaymentImpl.hashCode(), giftCardPaymentImpl2.hashCode());
  }

  /**
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin(null);
    giftCardPaymentImpl.setReferenceNumber("42");

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin(null);
    giftCardPaymentImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
    assertEquals(giftCardPaymentImpl.hashCode(), giftCardPaymentImpl2.hashCode());
  }

  /**
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber(null);

    GiftCardPaymentImpl giftCardPaymentImpl2 = new GiftCardPaymentImpl();
    giftCardPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl2.setId(1L);
    giftCardPaymentImpl2.setPan("Pan");
    giftCardPaymentImpl2.setPin("Pin");
    giftCardPaymentImpl2.setReferenceNumber(null);

    // Act and Assert
    assertEquals(giftCardPaymentImpl, giftCardPaymentImpl2);
    assertEquals(giftCardPaymentImpl.hashCode(), giftCardPaymentImpl2.hashCode());
  }

  /**
   * Test {@link GiftCardPaymentImpl#equals(Object)}, and {@link GiftCardPaymentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftCardPaymentImpl#equals(Object)}
   *   <li>{@link GiftCardPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pin");
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan(null);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pan");
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin(null);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber("Pan");

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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    GiftCardPaymentImpl giftCardPaymentImpl = new GiftCardPaymentImpl();
    giftCardPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    giftCardPaymentImpl.setId(null);
    giftCardPaymentImpl.setPan("Pan");
    giftCardPaymentImpl.setPin("Pin");
    giftCardPaymentImpl.setReferenceNumber(null);

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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GiftCardPaymentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardPaymentImpl.equals(Object)",
    "int GiftCardPaymentImpl.hashCode()"
  })
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
