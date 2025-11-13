package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CustomerAddressFormDiffblueTest {
  /**
   * Test new {@link CustomerAddressForm} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CustomerAddressForm}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressForm.<init>()"})
  public void testNewCustomerAddressForm() {
    // Arrange and Act
    CustomerAddressForm actualCustomerAddressForm = new CustomerAddressForm();

    // Assert
    assertTrue(actualCustomerAddressForm.getAddress() instanceof AddressImpl);
    assertNull(actualCustomerAddressForm.getCustomerAddressId());
    assertNull(actualCustomerAddressForm.getAddressName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerAddressForm#setAddressName(String)}
   *   <li>{@link CustomerAddressForm#setCustomerAddressId(Long)}
   *   <li>{@link CustomerAddressForm#getAddress()}
   *   <li>{@link CustomerAddressForm#getAddressName()}
   *   <li>{@link CustomerAddressForm#getCustomerAddressId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Address CustomerAddressForm.getAddress()",
    "String CustomerAddressForm.getAddressName()",
    "Long CustomerAddressForm.getCustomerAddressId()",
    "void CustomerAddressForm.setAddressName(String)",
    "void CustomerAddressForm.setCustomerAddressId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    // Act
    customerAddressForm.setAddressName("42 Main St");
    customerAddressForm.setCustomerAddressId(1L);
    Address actualAddress = customerAddressForm.getAddress();
    String actualAddressName = customerAddressForm.getAddressName();

    // Assert
    assertTrue(actualAddress instanceof AddressImpl);
    assertEquals("42 Main St", actualAddressName);
    assertEquals(1L, customerAddressForm.getCustomerAddressId().longValue());
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   *
   * <ul>
   *   <li>Given {@code Fax}.
   *   <li>Then {@link AddressImpl} (default constructor) PhonePrimary Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
  public void testSetAddress_givenFax_thenAddressImplPhonePrimaryIdIsNull() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    address.setFax("Fax");

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    assertNull(phonePrimary.getId());
    assertNull(phonePrimary.getCountryCode());
    assertNull(phonePrimary.getExtension());
    assertNull(phonePrimary.getPhoneNumber());
    assertFalse(phonePrimary.isDefault());
    assertTrue(phonePrimary.isActive());
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   *
   * <ul>
   *   <li>Then {@link AddressImpl} (default constructor) PhoneFax is {@link PhoneImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
  public void testSetAddress_thenAddressImplPhoneFaxIsPhoneImpl() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    PhoneImpl phoneFax = new PhoneImpl();
    address.setPhoneFax(phoneFax);

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax2 = address.getPhoneFax();
    assertTrue(phoneFax2 instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
    assertSame(phoneFax, phoneFax2);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor) PhonePrimary is {@link PhoneImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
  public void testSetAddress_whenAddressImplPhonePrimaryIsPhoneImpl() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    PhoneImpl phonePrimary = new PhoneImpl();
    address.setPhonePrimary(phonePrimary);

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    assertTrue(address.getPhoneFax() instanceof PhoneImpl);
    Phone phonePrimary2 = address.getPhonePrimary();
    assertTrue(phonePrimary2 instanceof PhoneImpl);
    assertTrue(address.getPhoneSecondary() instanceof PhoneImpl);
    assertSame(phonePrimary, phonePrimary2);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor) PhoneSecondary is {@link PhoneImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
  public void testSetAddress_whenAddressImplPhoneSecondaryIsPhoneImpl() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    PhoneImpl phoneSecondary = new PhoneImpl();
    address.setPhoneSecondary(phoneSecondary);

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    assertTrue(address.getPhoneFax() instanceof PhoneImpl);
    assertTrue(address.getPhonePrimary() instanceof PhoneImpl);
    Phone phoneSecondary2 = address.getPhoneSecondary();
    assertTrue(phoneSecondary2 instanceof PhoneImpl);
    assertSame(phoneSecondary, phoneSecondary2);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor) PrimaryPhone is {@code 6625550144}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
  public void testSetAddress_whenAddressImplPrimaryPhoneIs6625550144() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    address.setPrimaryPhone("6625550144");

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    assertTrue(address.getPhonePrimary() instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertNull(phoneFax.getId());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertFalse(phoneFax.isDefault());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor) SecondaryPhone is {@code 6625550144}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
  public void testSetAddress_whenAddressImplSecondaryPhoneIs6625550144() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();

    AddressImpl address = new AddressImpl();
    address.setSecondaryPhone("6625550144");

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    assertTrue(address.getPhoneSecondary() instanceof PhoneImpl);
    assertNull(phoneFax.getId());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertFalse(phoneFax.isDefault());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phonePrimary);
  }

  /**
   * Test {@link CustomerAddressForm#setAddress(Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).
   *   <li>Then {@link AddressImpl} (default constructor) PhonePrimary is {@link AddressImpl}
   *       (default constructor) PhoneFax.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressForm#setAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressForm.setAddress(Address)"})
  public void testSetAddress_whenAddressImpl_thenAddressImplPhonePrimaryIsAddressImplPhoneFax() {
    // Arrange
    CustomerAddressForm customerAddressForm = new CustomerAddressForm();
    AddressImpl address = new AddressImpl();

    // Act
    customerAddressForm.setAddress(address);

    // Assert
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertNull(phoneFax.getId());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertFalse(phoneFax.isDefault());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }
}
