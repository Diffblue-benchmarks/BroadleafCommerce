package org.broadleafcommerce.profile.web.core.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegisterCustomerFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RegisterCustomerForm}
   *   <li>{@link RegisterCustomerForm#setCustomer(Customer)}
   *   <li>{@link RegisterCustomerForm#setPassword(String)}
   *   <li>{@link RegisterCustomerForm#setPasswordConfirm(String)}
   *   <li>{@link RegisterCustomerForm#setRedirectUrl(String)}
   *   <li>{@link RegisterCustomerForm#getCustomer()}
   *   <li>{@link RegisterCustomerForm#getPassword()}
   *   <li>{@link RegisterCustomerForm#getPasswordConfirm()}
   *   <li>{@link RegisterCustomerForm#getRedirectUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    RegisterCustomerForm actualRegisterCustomerForm = new RegisterCustomerForm();
    CustomerImpl customer = new CustomerImpl();
    actualRegisterCustomerForm.setCustomer(customer);
    actualRegisterCustomerForm.setPassword("iloveyou");
    actualRegisterCustomerForm.setPasswordConfirm("Password Confirm");
    actualRegisterCustomerForm.setRedirectUrl("https://example.org/example");
    Customer actualCustomer = actualRegisterCustomerForm.getCustomer();
    String actualPassword = actualRegisterCustomerForm.getPassword();
    String actualPasswordConfirm = actualRegisterCustomerForm.getPasswordConfirm();

    // Assert that nothing has changed
    assertEquals("Password Confirm", actualPasswordConfirm);
    assertEquals("https://example.org/example", actualRegisterCustomerForm.getRedirectUrl());
    assertEquals("iloveyou", actualPassword);
    assertSame(customer, actualCustomer);
  }
}
