package org.broadleafcommerce.profile.web.core.service.register;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Mock private CustomerService customerService;

  @InjectMocks private RegistrationServiceImpl registrationServiceImpl;

  /**
   * Test {@link RegistrationServiceImpl#initCustomerRegistrationForm()}.
   *
   * <p>Method under test: {@link RegistrationServiceImpl#initCustomerRegistrationForm()}
   */
  @Test
  @DisplayName("Test initCustomerRegistrationForm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegisterCustomerForm RegistrationServiceImpl.initCustomerRegistrationForm()"})
  void testInitCustomerRegistrationForm() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerService.createCustomerWithNullId()).thenReturn(customerImpl);

    // Act
    RegisterCustomerForm actualInitCustomerRegistrationFormResult =
        registrationServiceImpl.initCustomerRegistrationForm();

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
