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
public class CreditCardPaymentInfoImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreditCardPaymentInfoImpl.<init>()",
    "String CreditCardPaymentInfoImpl.getCvvCode()",
    "EncryptionModule CreditCardPaymentInfoImpl.getEncryptionModule()",
    "Integer CreditCardPaymentInfoImpl.getExpirationMonth()",
    "Integer CreditCardPaymentInfoImpl.getExpirationYear()",
    "Long CreditCardPaymentInfoImpl.getId()",
    "String CreditCardPaymentInfoImpl.getNameOnCard()",
    "String CreditCardPaymentInfoImpl.getReferenceNumber()",
    "void CreditCardPaymentInfoImpl.setCvvCode(String)",
    "void CreditCardPaymentInfoImpl.setEncryptionModule(EncryptionModule)",
    "void CreditCardPaymentInfoImpl.setExpirationMonth(Integer)",
    "void CreditCardPaymentInfoImpl.setExpirationYear(Integer)",
    "void CreditCardPaymentInfoImpl.setId(Long)",
    "void CreditCardPaymentInfoImpl.setNameOnCard(String)",
    "void CreditCardPaymentInfoImpl.setReferenceNumber(String)"
  })
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

    // Assert
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
   *
   * <ul>
   *   <li>Given {@link CreditCardPaymentInfoImpl#CreditCardPaymentInfoImpl()} CvvCode is {@code Cvv
   *       Code}.
   *   <li>Then return {@code Pan}.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#getPan()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CreditCardPaymentInfoImpl.getPan()"})
  public void testGetPan_givenCreditCardPaymentInfoImplCvvCodeIsCvvCode_thenReturnPan() {
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
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and {@link
   * CreditCardPaymentInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
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
    assertEquals(creditCardPaymentInfoImpl.hashCode(), creditCardPaymentInfoImpl2.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and {@link
   * CreditCardPaymentInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
    assertEquals(creditCardPaymentInfoImpl.hashCode(), creditCardPaymentInfoImpl2.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and {@link
   * CreditCardPaymentInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
    creditCardPaymentInfoImpl2.setId(null);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
    assertEquals(creditCardPaymentInfoImpl.hashCode(), creditCardPaymentInfoImpl2.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and {@link
   * CreditCardPaymentInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl.setExpirationMonth(null);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("Pan");
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(null);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
    assertEquals(creditCardPaymentInfoImpl.hashCode(), creditCardPaymentInfoImpl2.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and {@link
   * CreditCardPaymentInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
    creditCardPaymentInfoImpl2.setExpirationYear(null);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan("Pan");
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
    assertEquals(creditCardPaymentInfoImpl.hashCode(), creditCardPaymentInfoImpl2.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and {@link
   * CreditCardPaymentInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan(null);
    creditCardPaymentInfoImpl.setReferenceNumber("42");

    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl2 = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl2.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl2.setExpirationMonth(1);
    creditCardPaymentInfoImpl2.setExpirationYear(1);
    creditCardPaymentInfoImpl2.setId(1L);
    creditCardPaymentInfoImpl2.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl2.setPan(null);
    creditCardPaymentInfoImpl2.setReferenceNumber("42");

    // Act and Assert
    assertEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
    assertEquals(creditCardPaymentInfoImpl.hashCode(), creditCardPaymentInfoImpl2.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and {@link
   * CreditCardPaymentInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
    creditCardPaymentInfoImpl2.setReferenceNumber(null);

    // Act and Assert
    assertEquals(creditCardPaymentInfoImpl, creditCardPaymentInfoImpl2);
    assertEquals(creditCardPaymentInfoImpl.hashCode(), creditCardPaymentInfoImpl2.hashCode());
  }

  /**
   * Test {@link CreditCardPaymentInfoImpl#equals(Object)}, and {@link
   * CreditCardPaymentInfoImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardPaymentInfoImpl#equals(Object)}
   *   <li>{@link CreditCardPaymentInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan("42");
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
    creditCardPaymentInfoImpl.setExpirationMonth(1);
    creditCardPaymentInfoImpl.setExpirationYear(1);
    creditCardPaymentInfoImpl.setId(null);
    creditCardPaymentInfoImpl.setNameOnCard("Name On Card");
    creditCardPaymentInfoImpl.setPan(null);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CreditCardPaymentInfoImpl creditCardPaymentInfoImpl = new CreditCardPaymentInfoImpl();
    creditCardPaymentInfoImpl.setCvvCode("Cvv Code");
    creditCardPaymentInfoImpl.setEncryptionModule(new PassthroughEncryptionModule());
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardPaymentInfoImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CreditCardPaymentInfoImpl.equals(Object)",
    "int CreditCardPaymentInfoImpl.hashCode()"
  })
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
