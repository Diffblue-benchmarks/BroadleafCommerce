/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhoneFormatterImplDiffblueTest {
  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link PhoneImpl} {@link PhoneImpl#getPhoneNumber()} return
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '42'; when PhoneImpl getPhoneNumber() return '42'")
  void testFormatPhoneNumber_given42_whenPhoneImplGetPhoneNumberReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();
    PhoneImpl phone = mock(PhoneImpl.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("42");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber(eq("42"));
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   * <ul>
   *   <li>Given {@code 6625550144\D}.</li>
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is
   * {@code 6625550144\D}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '6625550144\\D'; when PhoneImpl (default constructor) PhoneNumber is '6625550144\\D'")
  void testFormatPhoneNumber_given6625550144D_whenPhoneImplPhoneNumberIs6625550144D() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * <ul>
   *   <li>Given {@code 6625550144Phone Number}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '6625550144Phone Number'")
  void testFormatPhoneNumber_given6625550144PhoneNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

    PhoneImpl phone = new PhoneImpl();
    phone.setPhoneNumber("6625550144Phone Number");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertEquals("662-555-0144", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   * <ul>
   *   <li>Given {@code 6625550144}.</li>
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is
   * {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '6625550144'; when PhoneImpl (default constructor) PhoneNumber is '6625550144'")
  void testFormatPhoneNumber_given6625550144_whenPhoneImplPhoneNumberIs6625550144() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

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
   * <ul>
   *   <li>Given {@code 6625550144U}.</li>
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is
   * {@code 6625550144U}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '6625550144U'; when PhoneImpl (default constructor) PhoneNumber is '6625550144U'")
  void testFormatPhoneNumber_given6625550144u_whenPhoneImplPhoneNumberIs6625550144u() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * <ul>
   *   <li>Given {@code +44 1865 4960636}.</li>
   *   <li>Then {@link PhoneImpl} (default constructor) PhoneNumber is
   * {@code 441-865-4960}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '+44 1865 4960636'; then PhoneImpl (default constructor) PhoneNumber is '441-865-4960'")
  void testFormatPhoneNumber_given4418654960636_thenPhoneImplPhoneNumberIs4418654960() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

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
   * <ul>
   *   <li>Given {@code 6625550144+44 1865 4960636}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '6625550144+44 1865 4960636'")
  void testFormatPhoneNumber_given66255501444418654960636() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * <ul>
   *   <li>Given {@code \D}.</li>
   *   <li>When {@link PhoneImpl} {@link PhoneImpl#getPhoneNumber()} return
   * {@code \D}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '\\D'; when PhoneImpl getPhoneNumber() return '\\D'")
  void testFormatPhoneNumber_givenD_whenPhoneImplGetPhoneNumberReturnD() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();
    PhoneImpl phone = mock(PhoneImpl.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("\\D");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber(isNull());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   * <ul>
   *   <li>Given {@code -}.</li>
   *   <li>When {@link PhoneImpl} {@link PhoneImpl#getPhoneNumber()} return
   * {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '-'; when PhoneImpl getPhoneNumber() return '-'")
  void testFormatPhoneNumber_givenDash_whenPhoneImplGetPhoneNumberReturnDash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();
    PhoneImpl phone = mock(PhoneImpl.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("-");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber(isNull());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given empty string")
  void testFormatPhoneNumber_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();
    PhoneImpl phone = mock(PhoneImpl.class);
    when(phone.getPhoneNumber()).thenReturn("");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone).getPhoneNumber();
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link PhoneImpl} {@link PhoneImpl#getPhoneNumber()} return
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given 'foo'; when PhoneImpl getPhoneNumber() return 'foo'")
  void testFormatPhoneNumber_givenFoo_whenPhoneImplGetPhoneNumberReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();
    PhoneImpl phone = mock(PhoneImpl.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("foo");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber(isNull());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   * <ul>
   *   <li>Given {@code Phone Number}.</li>
   *   <li>When {@link PhoneImpl} (default constructor) PhoneNumber is
   * {@code Phone Number}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given 'Phone Number'; when PhoneImpl (default constructor) PhoneNumber is 'Phone Number'")
  void testFormatPhoneNumber_givenPhoneNumber_whenPhoneImplPhoneNumberIsPhoneNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

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
   * <ul>
   *   <li>Given {@code U}.</li>
   *   <li>When {@link PhoneImpl} {@link PhoneImpl#getPhoneNumber()} return
   * {@code U}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given 'U'; when PhoneImpl getPhoneNumber() return 'U'")
  void testFormatPhoneNumber_givenU_whenPhoneImplGetPhoneNumberReturnU() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();
    PhoneImpl phone = mock(PhoneImpl.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("U");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber(isNull());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   * <ul>
   *   <li>When {@link PhoneImpl} {@link PhoneImpl#getPhoneNumber()} return
   * {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); when PhoneImpl getPhoneNumber() return '6625550144'")
  void testFormatPhoneNumber_whenPhoneImplGetPhoneNumberReturn6625550144() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();
    PhoneImpl phone = mock(PhoneImpl.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("6625550144");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber(eq("662-555-0144"));
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   * <ul>
   *   <li>When {@link PhoneImpl} (default constructor).</li>
   *   <li>Then {@link PhoneImpl} (default constructor) PhoneNumber is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); when PhoneImpl (default constructor); then PhoneImpl (default constructor) PhoneNumber is 'null'")
  void testFormatPhoneNumber_whenPhoneImpl_thenPhoneImplPhoneNumberIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();
    PhoneImpl phone = new PhoneImpl();

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert that nothing has changed
    assertNull(phone.getPhoneNumber());
  }
}
