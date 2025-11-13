package org.broadleafcommerce.profile.web.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPhoneImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.service.CustomerPhoneService;
import org.broadleafcommerce.profile.web.controller.validator.PhoneValidator;
import org.broadleafcommerce.profile.web.core.model.PhoneNameForm;
import org.broadleafcommerce.profile.web.core.util.PhoneFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class CustomerPhoneControllerDiffblueTest {
  @InjectMocks private CustomerPhoneController customerPhoneController;

  @Mock private CustomerPhoneService customerPhoneService;

  @Mock private EntityConfiguration entityConfiguration;

  @Mock private PhoneFormatter phoneFormatter;

  @Mock private PhoneValidator phoneValidator;

  /**
   * Test {@link CustomerPhoneController#deletePhone(Long, HttpServletRequest)}.
   *
   * <p>Method under test: {@link CustomerPhoneController#deletePhone(Long, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test deletePhone(Long, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerPhoneController.deletePhone(Long, HttpServletRequest)"})
  void testDeletePhone() throws Exception {
    // Arrange
    doNothing().when(customerPhoneService).deleteCustomerPhoneById(Mockito.<Long>any());

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("?");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("6625550144");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(phoneImpl);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/myaccount/phone/deletePhone")
            .param("customerPhoneId", String.valueOf(1L));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerPhoneController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("phoneNameForm"))
        .andExpect(view().name("redirect:/myaccount/phone/viewPhone.htm1"))
        .andExpect(redirectedUrl("/myaccount/phone/viewPhone.htm1"));
  }

  /**
   * Test {@link CustomerPhoneController#initPhoneNameForm(HttpServletRequest, Model)}.
   *
   * <p>Method under test: {@link CustomerPhoneController#initPhoneNameForm(HttpServletRequest,
   * Model)}
   */
  @Test
  @DisplayName("Test initPhoneNameForm(HttpServletRequest, Model)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhoneNameForm CustomerPhoneController.initPhoneNameForm(HttpServletRequest, Model)"
  })
  void testInitPhoneNameForm() {
    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("org.broadleafcommerce.profile.core.domain.Phone");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("6625550144");

    EntityConfiguration entityConfiguration = mock(EntityConfiguration.class);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(phoneImpl);

    CustomerPhoneController customerPhoneController = new CustomerPhoneController();
    customerPhoneController.setEntityConfiguration(entityConfiguration);
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    PhoneNameForm actualInitPhoneNameFormResult =
        customerPhoneController.initPhoneNameForm(request, new ConcurrentModel());

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.profile.core.domain.Phone");
    assertNull(actualInitPhoneNameFormResult.getPhoneName());
    assertSame(phoneImpl, actualInitPhoneNameFormResult.getPhone());
  }

  /**
   * Test {@link CustomerPhoneController#makePhoneDefault(Long, HttpServletRequest)}.
   *
   * <p>Method under test: {@link CustomerPhoneController#makePhoneDefault(Long,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName("Test makePhoneDefault(Long, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerPhoneController.makePhoneDefault(Long, HttpServletRequest)"})
  void testMakePhoneDefault() throws Exception {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    doNothing()
        .when(customerPhoneService)
        .makeCustomerPhoneDefault(Mockito.<Long>any(), Mockito.<Long>any());
    when(customerPhoneService.readCustomerPhoneById(Mockito.<Long>any()))
        .thenReturn(customerPhoneImpl);

    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("?");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("6625550144");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(phoneImpl);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/myaccount/phone/makePhoneDefault")
            .param("customerPhoneId", String.valueOf(1L));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerPhoneController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("phoneNameForm"))
        .andExpect(view().name("redirect:/myaccount/phone/viewPhone.htm"))
        .andExpect(redirectedUrl("/myaccount/phone/viewPhone.htm"));
  }

  /**
   * Test {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest,
   * Long, Long)}.
   *
   * <p>Method under test: {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult,
   * HttpServletRequest, Long, Long)}
   */
  @Test
  @DisplayName("Test savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CustomerPhoneController.savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)"
  })
  void testSavePhone() throws Exception {
    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("?");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("6625550144");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(phoneImpl);
    doNothing().when(phoneFormatter).formatPhoneNumber(Mockito.<Phone>any());
    doNothing().when(phoneValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/myaccount/phone/savePhone");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerPhoneController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("phoneNameForm"))
        .andExpect(view().name("myAccount/phone/customerPhones"))
        .andExpect(forwardedUrl("myAccount/phone/customerPhones"));
  }

  /**
   * Test {@link CustomerPhoneController#viewPhone(Long, HttpServletRequest, PhoneNameForm,
   * BindingResult)}.
   *
   * <p>Method under test: {@link CustomerPhoneController#viewPhone(Long, HttpServletRequest,
   * PhoneNameForm, BindingResult)}
   */
  @Test
  @DisplayName("Test viewPhone(Long, HttpServletRequest, PhoneNameForm, BindingResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CustomerPhoneController.viewPhone(Long, HttpServletRequest, PhoneNameForm, BindingResult)"
  })
  void testViewPhone() throws Exception {
    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("?");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("6625550144");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(phoneImpl);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/myaccount/phone/viewPhone");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerPhoneController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("phoneNameForm"))
        .andExpect(view().name("myAccount/phone/customerPhones"))
        .andExpect(forwardedUrl("myAccount/phone/customerPhones"));
  }
}
