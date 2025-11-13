package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaymentInfoFormDiffblueTest {
  /**
   * Test new {@link PaymentInfoForm} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PaymentInfoForm}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentInfoForm.<init>()"})
  public void testNewPaymentInfoForm() {
    // Arrange and Act
    PaymentInfoForm actualPaymentInfoForm = new PaymentInfoForm();

    // Assert
    assertTrue(actualPaymentInfoForm.getAddress() instanceof AddressImpl);
    assertNull(actualPaymentInfoForm.getCustomerPaymentId());
    assertNull(actualPaymentInfoForm.getEmailAddress());
    assertNull(actualPaymentInfoForm.getPaymentName());
    assertNull(actualPaymentInfoForm.getPaymentToken());
    assertFalse(actualPaymentInfoForm.getIsDefault());
    assertFalse(actualPaymentInfoForm.getShouldUseCustomerPayment());
    assertFalse(actualPaymentInfoForm.getShouldUseShippingAddress());
    assertFalse(actualPaymentInfoForm.hasCustomerPaymentId());
    assertFalse(actualPaymentInfoForm.hasValidAddress());
    assertTrue(actualPaymentInfoForm.getShouldSaveNewPayment());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentInfoForm#setAddress(Address)}
   *   <li>{@link PaymentInfoForm#setCustomerPaymentId(Long)}
   *   <li>{@link PaymentInfoForm#setEmailAddress(String)}
   *   <li>{@link PaymentInfoForm#setIsDefault(boolean)}
   *   <li>{@link PaymentInfoForm#setPaymentName(String)}
   *   <li>{@link PaymentInfoForm#setPaymentToken(String)}
   *   <li>{@link PaymentInfoForm#setShouldSaveNewPayment(boolean)}
   *   <li>{@link PaymentInfoForm#setShouldUseCustomerPayment(boolean)}
   *   <li>{@link PaymentInfoForm#setShouldUseShippingAddress(boolean)}
   *   <li>{@link PaymentInfoForm#getAddress()}
   *   <li>{@link PaymentInfoForm#getCustomerPaymentId()}
   *   <li>{@link PaymentInfoForm#getEmailAddress()}
   *   <li>{@link PaymentInfoForm#getIsDefault()}
   *   <li>{@link PaymentInfoForm#getPaymentName()}
   *   <li>{@link PaymentInfoForm#getPaymentToken()}
   *   <li>{@link PaymentInfoForm#getShouldSaveNewPayment()}
   *   <li>{@link PaymentInfoForm#getShouldUseCustomerPayment()}
   *   <li>{@link PaymentInfoForm#getShouldUseShippingAddress()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Address PaymentInfoForm.getAddress()",
    "Long PaymentInfoForm.getCustomerPaymentId()",
    "String PaymentInfoForm.getEmailAddress()",
    "boolean PaymentInfoForm.getIsDefault()",
    "String PaymentInfoForm.getPaymentName()",
    "String PaymentInfoForm.getPaymentToken()",
    "boolean PaymentInfoForm.getShouldSaveNewPayment()",
    "boolean PaymentInfoForm.getShouldUseCustomerPayment()",
    "boolean PaymentInfoForm.getShouldUseShippingAddress()",
    "void PaymentInfoForm.setAddress(Address)",
    "void PaymentInfoForm.setCustomerPaymentId(Long)",
    "void PaymentInfoForm.setEmailAddress(String)",
    "void PaymentInfoForm.setIsDefault(boolean)",
    "void PaymentInfoForm.setPaymentName(String)",
    "void PaymentInfoForm.setPaymentToken(String)",
    "void PaymentInfoForm.setShouldSaveNewPayment(boolean)",
    "void PaymentInfoForm.setShouldUseCustomerPayment(boolean)",
    "void PaymentInfoForm.setShouldUseShippingAddress(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    AddressImpl address = new AddressImpl();

    // Act
    paymentInfoForm.setAddress(address);
    paymentInfoForm.setCustomerPaymentId(1L);
    paymentInfoForm.setEmailAddress("42 Main St");
    paymentInfoForm.setIsDefault(true);
    paymentInfoForm.setPaymentName("Payment Name");
    paymentInfoForm.setPaymentToken("ABC123");
    paymentInfoForm.setShouldSaveNewPayment(true);
    paymentInfoForm.setShouldUseCustomerPayment(true);
    paymentInfoForm.setShouldUseShippingAddress(true);
    Address actualAddress = paymentInfoForm.getAddress();
    Long actualCustomerPaymentId = paymentInfoForm.getCustomerPaymentId();
    String actualEmailAddress = paymentInfoForm.getEmailAddress();
    boolean actualIsDefault = paymentInfoForm.getIsDefault();
    String actualPaymentName = paymentInfoForm.getPaymentName();
    String actualPaymentToken = paymentInfoForm.getPaymentToken();
    boolean actualShouldSaveNewPayment = paymentInfoForm.getShouldSaveNewPayment();
    boolean actualShouldUseCustomerPayment = paymentInfoForm.getShouldUseCustomerPayment();
    boolean actualShouldUseShippingAddress = paymentInfoForm.getShouldUseShippingAddress();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("ABC123", actualPaymentToken);
    assertEquals("Payment Name", actualPaymentName);
    assertEquals(1L, actualCustomerPaymentId.longValue());
    assertTrue(actualIsDefault);
    assertTrue(actualShouldSaveNewPayment);
    assertTrue(actualShouldUseCustomerPayment);
    assertTrue(actualShouldUseShippingAddress);
    assertSame(address, actualAddress);
  }

  /**
   * Test {@link PaymentInfoForm#hasCustomerPaymentId()}.
   *
   * <ul>
   *   <li>Given {@link PaymentInfoForm} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentInfoForm#hasCustomerPaymentId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentInfoForm.hasCustomerPaymentId()"})
  public void testHasCustomerPaymentId_givenPaymentInfoForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaymentInfoForm().hasCustomerPaymentId());
  }

  /**
   * Test {@link PaymentInfoForm#hasCustomerPaymentId()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentInfoForm#hasCustomerPaymentId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentInfoForm.hasCustomerPaymentId()"})
  public void testHasCustomerPaymentId_thenReturnTrue() {
    // Arrange
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setCustomerPaymentId(1L);

    // Act and Assert
    assertTrue(paymentInfoForm.hasCustomerPaymentId());
  }

  /**
   * Test {@link PaymentInfoForm#hasValidAddress()}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) City is {@code not blank}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentInfoForm#hasValidAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentInfoForm.hasValidAddress()"})
  public void testHasValidAddress_givenAddressImplCityIsNotBlank_thenReturnTrue() {
    // Arrange
    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountryAlpha2(new ISOCountryImpl());
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStateProvinceRegion("us-east-2");
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setAddressLine1("not blank");
    address.setCity("not blank");

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    // Act and Assert
    assertTrue(paymentInfoForm.hasValidAddress());
  }

  /**
   * Test {@link PaymentInfoForm#hasValidAddress()}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) City is space.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentInfoForm#hasValidAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentInfoForm.hasValidAddress()"})
  public void testHasValidAddress_givenAddressImplCityIsSpace_thenReturnFalse() {
    // Arrange
    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountryAlpha2(new ISOCountryImpl());
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStateProvinceRegion("us-east-2");
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setAddressLine1("not blank");
    address.setCity(" ");

    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(address);

    // Act and Assert
    assertFalse(paymentInfoForm.hasValidAddress());
  }

  /**
   * Test {@link PaymentInfoForm#hasValidAddress()}.
   *
   * <ul>
   *   <li>Given {@link PaymentInfoForm} (default constructor) Address is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentInfoForm#hasValidAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentInfoForm.hasValidAddress()"})
  public void testHasValidAddress_givenPaymentInfoFormAddressIsNull_thenReturnFalse() {
    // Arrange
    PaymentInfoForm paymentInfoForm = new PaymentInfoForm();
    paymentInfoForm.setAddress(null);

    // Act and Assert
    assertFalse(paymentInfoForm.hasValidAddress());
  }

  /**
   * Test {@link PaymentInfoForm#hasValidAddress()}.
   *
   * <ul>
   *   <li>Given {@link PaymentInfoForm} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentInfoForm#hasValidAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentInfoForm.hasValidAddress()"})
  public void testHasValidAddress_givenPaymentInfoForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PaymentInfoForm().hasValidAddress());
  }
}
