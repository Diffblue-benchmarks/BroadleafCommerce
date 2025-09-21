/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PhoneFormatterImpl.class})
@ExtendWith(SpringExtension.class)
class PhoneFormatterImplDiffblueTest {
  @Autowired private PhoneFormatterImpl phoneFormatterImpl;

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link PhoneImpl} (default constructor) PhoneNumber is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given '42'; then PhoneImpl (default constructor) PhoneNumber is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given42_thenPhoneImplPhoneNumberIs42() {
    // Arrange
    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("42");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert that nothing has changed
    assertEquals("42", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code 6625550144\D}.
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is {@code 6625550144\D}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given '6625550144\\D'; when PhoneImpl (default constructor) PhoneNumber is '6625550144\\D'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given6625550144D_whenPhoneImplPhoneNumberIs6625550144D() {
    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("6625550144\\D");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertEquals("662-555-0144", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code 6625550144Phone Number}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '6625550144Phone Number'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given6625550144PhoneNumber() {
    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("6625550144Phone Number");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertEquals("662-555-0144", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code 6625550144}.
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is {@code 6625550144}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given '6625550144'; when PhoneImpl (default constructor) PhoneNumber is '6625550144'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given6625550144_whenPhoneImplPhoneNumberIs6625550144() {
    // Arrange
    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("6625550144");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertEquals("662-555-0144", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code 6625550144-}.
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is {@code 6625550144-}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given '6625550144-'; when PhoneImpl (default constructor) PhoneNumber is '6625550144-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given6625550144_whenPhoneImplPhoneNumberIs66255501442() {
    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("6625550144-");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertEquals("662-555-0144", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code 6625550144U}.
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is {@code 6625550144U}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given '6625550144U'; when PhoneImpl (default constructor) PhoneNumber is '6625550144U'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given6625550144u_whenPhoneImplPhoneNumberIs6625550144u() {
    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("6625550144U");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertEquals("662-555-0144", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code +44 1865 4960636}.
   *   <li>Then {@link PhoneImpl} (default constructor) PhoneNumber is {@code 441-865-4960}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given '+44 1865 4960636'; then PhoneImpl (default constructor) PhoneNumber is '441-865-4960'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given4418654960636_thenPhoneImplPhoneNumberIs4418654960() {
    // Arrange
    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("+44 1865 4960636");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertEquals("441-865-4960", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code 6625550144+44 1865 4960636}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '6625550144+44 1865 4960636'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given66255501444418654960636() {
    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("6625550144+44 1865 4960636");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertEquals("662-555-0144", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code \D}.
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is {@code \D}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given '\\D'; when PhoneImpl (default constructor) PhoneNumber is '\\D'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_givenD_whenPhoneImplPhoneNumberIsD() {
    // Arrange
    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("\\D");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertNull(phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code -}.
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given '-'; when PhoneImpl (default constructor) PhoneNumber is '-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_givenDash_whenPhoneImplPhoneNumberIsDash() {
    // Arrange
    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("-");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertNull(phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then {@link PhoneImpl} (default constructor) PhoneNumber is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given empty string; then PhoneImpl (default constructor) PhoneNumber is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_givenEmptyString_thenPhoneImplPhoneNumberIsEmptyString() {
    // Arrange
    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert that nothing has changed
    assertEquals("", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code Phone Number}.
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is {@code Phone Number}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given 'Phone Number'; when PhoneImpl (default constructor) PhoneNumber is 'Phone Number'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_givenPhoneNumber_whenPhoneImplPhoneNumberIsPhoneNumber() {
    // Arrange
    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("Phone Number");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertNull(phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code U}.
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given 'U'; when PhoneImpl (default constructor) PhoneNumber is 'U'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_givenU_whenPhoneImplPhoneNumberIsU() {
    // Arrange
    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setDefault(true);
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("U");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertNull(phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>When {@link PhoneImpl} (default constructor).
   *   <li>Then {@link PhoneImpl} (default constructor) PhoneNumber is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); when PhoneImpl (default constructor); then PhoneImpl (default constructor) PhoneNumber is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_whenPhoneImpl_thenPhoneImplPhoneNumberIsNull() {
    // Arrange
    PhoneImpl phone = new PhoneImpl();

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert that nothing has changed
    assertNull(phone.getPhoneNumber());
  }
}
