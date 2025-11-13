package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CustomerPaymentImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerPaymentImpl}
   *   <li>{@link CustomerPaymentImpl#setAdditionalFields(Map)}
   *   <li>{@link CustomerPaymentImpl#setBillingAddress(Address)}
   *   <li>{@link CustomerPaymentImpl#setCustomer(Customer)}
   *   <li>{@link CustomerPaymentImpl#setId(Long)}
   *   <li>{@link CustomerPaymentImpl#setIsDefault(boolean)}
   *   <li>{@link CustomerPaymentImpl#setPaymentToken(String)}
   *   <li>{@link CustomerPaymentImpl#getAdditionalFields()}
   *   <li>{@link CustomerPaymentImpl#getBillingAddress()}
   *   <li>{@link CustomerPaymentImpl#getCustomer()}
   *   <li>{@link CustomerPaymentImpl#getId()}
   *   <li>{@link CustomerPaymentImpl#getPaymentToken()}
   *   <li>{@link CustomerPaymentImpl#isDefault()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerPaymentImpl.<init>()",
    "Map CustomerPaymentImpl.getAdditionalFields()",
    "Address CustomerPaymentImpl.getBillingAddress()",
    "Customer CustomerPaymentImpl.getCustomer()",
    "Long CustomerPaymentImpl.getId()",
    "String CustomerPaymentImpl.getPaymentToken()",
    "boolean CustomerPaymentImpl.isDefault()",
    "void CustomerPaymentImpl.setAdditionalFields(Map)",
    "void CustomerPaymentImpl.setBillingAddress(Address)",
    "void CustomerPaymentImpl.setCustomer(Customer)",
    "void CustomerPaymentImpl.setId(Long)",
    "void CustomerPaymentImpl.setIsDefault(boolean)",
    "void CustomerPaymentImpl.setPaymentToken(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerPaymentImpl actualCustomerPaymentImpl = new CustomerPaymentImpl();
    HashMap<String, String> additionalFields = new HashMap<>();
    actualCustomerPaymentImpl.setAdditionalFields(additionalFields);
    AddressImpl billingAddress = new AddressImpl();
    actualCustomerPaymentImpl.setBillingAddress(billingAddress);
    CustomerImpl customer = new CustomerImpl();
    actualCustomerPaymentImpl.setCustomer(customer);
    actualCustomerPaymentImpl.setId(1L);
    actualCustomerPaymentImpl.setIsDefault(true);
    actualCustomerPaymentImpl.setPaymentToken("ABC123");
    Map<String, String> actualAdditionalFields = actualCustomerPaymentImpl.getAdditionalFields();
    Address actualBillingAddress = actualCustomerPaymentImpl.getBillingAddress();
    Customer actualCustomer = actualCustomerPaymentImpl.getCustomer();
    Long actualId = actualCustomerPaymentImpl.getId();
    String actualPaymentToken = actualCustomerPaymentImpl.getPaymentToken();
    boolean actualIsDefaultResult = actualCustomerPaymentImpl.isDefault();

    // Assert
    assertEquals("ABC123", actualPaymentToken);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalFields.isEmpty());
    assertTrue(actualIsDefaultResult);
    assertSame(additionalFields, actualAdditionalFields);
    assertSame(billingAddress, actualBillingAddress);
    assertSame(customer, actualCustomer);
  }
}
