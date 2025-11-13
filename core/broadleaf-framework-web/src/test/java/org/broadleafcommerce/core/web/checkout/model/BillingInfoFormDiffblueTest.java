package org.broadleafcommerce.core.web.checkout.model;

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
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BillingInfoFormDiffblueTest {
  /**
   * Test new {@link BillingInfoForm} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BillingInfoForm}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BillingInfoForm.<init>()"})
  public void testNewBillingInfoForm() {
    // Arrange and Act
    BillingInfoForm actualBillingInfoForm = new BillingInfoForm();

    // Assert
    assertTrue(actualBillingInfoForm.getAddress() instanceof AddressImpl);
    assertNull(actualBillingInfoForm.getCustomerPaymentId());
    assertNull(actualBillingInfoForm.getPaymentName());
    assertNull(actualBillingInfoForm.getCustomerPayment());
    assertFalse(actualBillingInfoForm.getUseCustomerPayment());
    assertFalse(actualBillingInfoForm.isUseShippingAddress());
    assertFalse(actualBillingInfoForm.useCustomerPayment);
    assertTrue(actualBillingInfoForm.getSaveNewPayment());
    assertTrue(actualBillingInfoForm.saveNewPayment);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BillingInfoForm#setAddress(Address)}
   *   <li>{@link BillingInfoForm#setCustomerPayment(CustomerPayment)}
   *   <li>{@link BillingInfoForm#setCustomerPaymentId(Long)}
   *   <li>{@link BillingInfoForm#setPaymentName(String)}
   *   <li>{@link BillingInfoForm#setUseShippingAddress(boolean)}
   *   <li>{@link BillingInfoForm#getAddress()}
   *   <li>{@link BillingInfoForm#getCustomerPayment()}
   *   <li>{@link BillingInfoForm#getCustomerPaymentId()}
   *   <li>{@link BillingInfoForm#getPaymentName()}
   *   <li>{@link BillingInfoForm#isUseShippingAddress()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Address BillingInfoForm.getAddress()",
    "CustomerPayment BillingInfoForm.getCustomerPayment()",
    "Long BillingInfoForm.getCustomerPaymentId()",
    "String BillingInfoForm.getPaymentName()",
    "boolean BillingInfoForm.isUseShippingAddress()",
    "void BillingInfoForm.setAddress(Address)",
    "void BillingInfoForm.setCustomerPayment(CustomerPayment)",
    "void BillingInfoForm.setCustomerPaymentId(Long)",
    "void BillingInfoForm.setPaymentName(String)",
    "void BillingInfoForm.setUseShippingAddress(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    AddressImpl address = new AddressImpl();

    // Act
    billingInfoForm.setAddress(address);
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    billingInfoForm.setCustomerPayment(customerPayment);
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setUseShippingAddress(true);
    Address actualAddress = billingInfoForm.getAddress();
    CustomerPayment actualCustomerPayment = billingInfoForm.getCustomerPayment();
    Long actualCustomerPaymentId = billingInfoForm.getCustomerPaymentId();
    String actualPaymentName = billingInfoForm.getPaymentName();
    boolean actualIsUseShippingAddressResult = billingInfoForm.isUseShippingAddress();

    // Assert
    assertEquals("Payment Name", actualPaymentName);
    assertEquals(1L, actualCustomerPaymentId.longValue());
    assertTrue(actualIsUseShippingAddressResult);
    assertSame(address, actualAddress);
    assertSame(customerPayment, actualCustomerPayment);
  }

  /**
   * Test {@link BillingInfoForm#getUseCustomerPayment()}.
   *
   * <ul>
   *   <li>Given {@link BillingInfoForm} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BillingInfoForm#getUseCustomerPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BillingInfoForm.getUseCustomerPayment()"})
  public void testGetUseCustomerPayment_givenBillingInfoForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BillingInfoForm().getUseCustomerPayment());
  }

  /**
   * Test {@link BillingInfoForm#getUseCustomerPayment()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BillingInfoForm#getUseCustomerPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BillingInfoForm.getUseCustomerPayment()"})
  public void testGetUseCustomerPayment_thenReturnTrue() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseShippingAddress(true);
    billingInfoForm.setUseCustomerPayment(true);

    // Act and Assert
    assertTrue(billingInfoForm.getUseCustomerPayment());
  }

  /**
   * Test {@link BillingInfoForm#setUseCustomerPayment(Boolean)}.
   *
   * <ul>
   *   <li>Then {@link BillingInfoForm} (default constructor) UseCustomerPayment.
   * </ul>
   *
   * <p>Method under test: {@link BillingInfoForm#setUseCustomerPayment(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BillingInfoForm.setUseCustomerPayment(Boolean)"})
  public void testSetUseCustomerPayment_thenBillingInfoFormUseCustomerPayment() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();

    // Act
    billingInfoForm.setUseCustomerPayment(true);

    // Assert
    assertTrue(billingInfoForm.getUseCustomerPayment());
    assertTrue(billingInfoForm.useCustomerPayment);
  }

  /**
   * Test {@link BillingInfoForm#setUseCustomerPayment(Boolean)}.
   *
   * <ul>
   *   <li>Then not {@link BillingInfoForm} (default constructor) UseCustomerPayment.
   * </ul>
   *
   * <p>Method under test: {@link BillingInfoForm#setUseCustomerPayment(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BillingInfoForm.setUseCustomerPayment(Boolean)"})
  public void testSetUseCustomerPayment_thenNotBillingInfoFormUseCustomerPayment() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    // Act
    billingInfoForm.setUseCustomerPayment(null);

    // Assert
    assertFalse(billingInfoForm.getUseCustomerPayment());
    assertFalse(billingInfoForm.useCustomerPayment);
  }

  /**
   * Test {@link BillingInfoForm#getSaveNewPayment()}.
   *
   * <ul>
   *   <li>Given {@link BillingInfoForm} (default constructor) Address is {@link AddressImpl}
   *       (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BillingInfoForm#getSaveNewPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BillingInfoForm.getSaveNewPayment()"})
  public void testGetSaveNewPayment_givenBillingInfoFormAddressIsAddressImpl_thenReturnFalse() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);
    billingInfoForm.setSaveNewPayment(null);

    // Act and Assert
    assertFalse(billingInfoForm.getSaveNewPayment());
  }

  /**
   * Test {@link BillingInfoForm#getSaveNewPayment()}.
   *
   * <ul>
   *   <li>Given {@link BillingInfoForm} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BillingInfoForm#getSaveNewPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BillingInfoForm.getSaveNewPayment()"})
  public void testGetSaveNewPayment_givenBillingInfoForm_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new BillingInfoForm().getSaveNewPayment());
  }

  /**
   * Test {@link BillingInfoForm#setSaveNewPayment(Boolean)}.
   *
   * <ul>
   *   <li>Given {@link BillingInfoForm} (default constructor).
   *   <li>Then {@link BillingInfoForm} (default constructor) SaveNewPayment.
   * </ul>
   *
   * <p>Method under test: {@link BillingInfoForm#setSaveNewPayment(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BillingInfoForm.setSaveNewPayment(Boolean)"})
  public void testSetSaveNewPayment_givenBillingInfoForm_thenBillingInfoFormSaveNewPayment() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();

    // Act
    billingInfoForm.setSaveNewPayment(true);

    // Assert that nothing has changed
    assertTrue(billingInfoForm.getSaveNewPayment());
    assertTrue(billingInfoForm.saveNewPayment);
  }

  /**
   * Test {@link BillingInfoForm#setSaveNewPayment(Boolean)}.
   *
   * <ul>
   *   <li>Then not {@link BillingInfoForm} (default constructor) SaveNewPayment.
   * </ul>
   *
   * <p>Method under test: {@link BillingInfoForm#setSaveNewPayment(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BillingInfoForm.setSaveNewPayment(Boolean)"})
  public void testSetSaveNewPayment_thenNotBillingInfoFormSaveNewPayment() {
    // Arrange
    BillingInfoForm billingInfoForm = new BillingInfoForm();
    billingInfoForm.setAddress(new AddressImpl());
    billingInfoForm.setCustomerPayment(new CustomerPaymentImpl());
    billingInfoForm.setCustomerPaymentId(1L);
    billingInfoForm.setPaymentName("Payment Name");
    billingInfoForm.setSaveNewPayment(true);
    billingInfoForm.setUseCustomerPayment(true);
    billingInfoForm.setUseShippingAddress(true);

    // Act
    billingInfoForm.setSaveNewPayment(null);

    // Assert
    assertFalse(billingInfoForm.getSaveNewPayment());
    assertFalse(billingInfoForm.saveNewPayment);
  }
}
