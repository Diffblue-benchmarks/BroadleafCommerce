package org.broadleafcommerce.profile.web.core.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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
   *   <li>When {@link Phone} {@link Phone#getPhoneNumber()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '42'; when Phone getPhoneNumber() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given42_whenPhoneGetPhoneNumberReturn42() {
    // Arrange
    Phone phone = mock(Phone.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("42");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber("42");
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
   *   <li>When {@link Phone} {@link Phone#getPhoneNumber()} return {@code 6625550144}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given '6625550144'; when Phone getPhoneNumber() return '6625550144'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given6625550144_whenPhoneGetPhoneNumberReturn6625550144() {
    // Arrange
    Phone phone = mock(Phone.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("6625550144");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber("662-555-0144");
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code 8605550118Phone Number}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '8605550118Phone Number'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given8605550118PhoneNumber() {
    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

    PhoneImpl phone = new PhoneImpl();
    phone.setPhoneNumber("8605550118Phone Number");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertEquals("860-555-0118", phone.getPhoneNumber());
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
   *   <li>Given {@code 8605550118+44 1865 4960636}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '8605550118+44 1865 4960636'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_given86055501184418654960636() {
    // Arrange
    PhoneFormatterImpl phoneFormatterImpl = new PhoneFormatterImpl();

    PhoneImpl phone = new PhoneImpl();
    phone.setPhoneNumber("8605550118+44 1865 4960636");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    assertEquals("860-555-0118", phone.getPhoneNumber());
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code \D}.
   *   <li>When {@link Phone} {@link Phone#getPhoneNumber()} return {@code \D}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given '\\D'; when Phone getPhoneNumber() return '\\D'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_givenD_whenPhoneGetPhoneNumberReturnD() {
    // Arrange
    Phone phone = mock(Phone.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("\\D");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber(null);
  }

  /**
   * Test {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}.
   *
   * <ul>
   *   <li>Given {@code -}.
   *   <li>When {@link Phone} {@link Phone#getPhoneNumber()} return {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given '-'; when Phone getPhoneNumber() return '-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_givenDash_whenPhoneGetPhoneNumberReturnDash() {
    // Arrange
    Phone phone = mock(Phone.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("-");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber(null);
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
   *   <li>Given {@code foo}.
   *   <li>When {@link Phone} {@link Phone#getPhoneNumber()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName(
      "Test formatPhoneNumber(Phone); given 'foo'; when Phone getPhoneNumber() return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_givenFoo_whenPhoneGetPhoneNumberReturnFoo() {
    // Arrange
    Phone phone = mock(Phone.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("foo");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber(null);
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
   *   <li>When {@link Phone} {@link Phone#getPhoneNumber()} return {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link PhoneFormatterImpl#formatPhoneNumber(Phone)}
   */
  @Test
  @DisplayName("Test formatPhoneNumber(Phone); given 'U'; when Phone getPhoneNumber() return 'U'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhoneFormatterImpl.formatPhoneNumber(Phone)"})
  void testFormatPhoneNumber_givenU_whenPhoneGetPhoneNumberReturnU() {
    // Arrange
    Phone phone = mock(Phone.class);
    doNothing().when(phone).setPhoneNumber(Mockito.<String>any());
    when(phone.getPhoneNumber()).thenReturn("U");

    // Act
    phoneFormatterImpl.formatPhoneNumber(phone);

    // Assert
    verify(phone, atLeast(1)).getPhoneNumber();
    verify(phone).setPhoneNumber(null);
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
