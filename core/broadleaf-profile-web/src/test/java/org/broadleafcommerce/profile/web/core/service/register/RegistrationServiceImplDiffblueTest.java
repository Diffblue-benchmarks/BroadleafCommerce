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
package org.broadleafcommerce.profile.web.core.service.register;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceImplDiffblueTest {
  @Mock
  private CustomerService customerService;

  @InjectMocks
  private RegistrationServiceImpl registrationServiceImpl;

  /**
   * Test {@link RegistrationServiceImpl#initCustomerRegistrationForm()}.
   * <p>
   * Method under test: {@link RegistrationServiceImpl#initCustomerRegistrationForm()}
   */
  @Test
  @DisplayName("Test initCustomerRegistrationForm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RegisterCustomerForm RegistrationServiceImpl.initCustomerRegistrationForm()"})
  void testInitCustomerRegistrationForm() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerService.createCustomerWithNullId()).thenReturn(customerImpl);

    // Act
    RegisterCustomerForm actualInitCustomerRegistrationFormResult = registrationServiceImpl
        .initCustomerRegistrationForm();

    // Assert
    verify(customerService).createCustomerWithNullId();
    Customer customer = actualInitCustomerRegistrationFormResult.getCustomer();
    assertTrue(customer instanceof CustomerImpl);
    assertNull(actualInitCustomerRegistrationFormResult.getPassword());
    assertNull(actualInitCustomerRegistrationFormResult.getPasswordConfirm());
    assertNull(actualInitCustomerRegistrationFormResult.getRedirectUrl());
    assertSame(customerImpl, customer);
  }
}
