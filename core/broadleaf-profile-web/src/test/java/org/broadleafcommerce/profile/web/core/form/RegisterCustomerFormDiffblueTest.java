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
package org.broadleafcommerce.profile.web.core.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegisterCustomerFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RegisterCustomerForm.<init>()",
    "Customer RegisterCustomerForm.getCustomer()",
    "String RegisterCustomerForm.getPassword()",
    "String RegisterCustomerForm.getPasswordConfirm()",
    "String RegisterCustomerForm.getRedirectUrl()",
    "void RegisterCustomerForm.setCustomer(Customer)",
    "void RegisterCustomerForm.setPassword(String)",
    "void RegisterCustomerForm.setPasswordConfirm(String)",
    "void RegisterCustomerForm.setRedirectUrl(String)"
  })
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

    // Assert
    assertEquals("Password Confirm", actualPasswordConfirm);
    assertEquals("https://example.org/example", actualRegisterCustomerForm.getRedirectUrl());
    assertEquals("iloveyou", actualPassword);
    assertSame(customer, actualCustomer);
  }
}
