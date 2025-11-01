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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhoneFormatterImplDiffblueTest {
  /**
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();
    PhoneImpl phone = new PhoneImpl();

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert that nothing has changed
    assertNull(phone.getPhoneNumber());
  }

  /**
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber2() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber3() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber4() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber5() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber6() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber7() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber8() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber9() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber10() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber11() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber12() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber13() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber14() {
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
   * Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  void testFormatPhoneNumber15() {
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
}
