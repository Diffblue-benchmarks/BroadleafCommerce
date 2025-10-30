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
package org.broadleafcommerce.profile.web.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

@ExtendWith(MockitoExtension.class)
class CustomerPhoneControllerDiffblueTest {
  @InjectMocks
  private CustomerPhoneController customerPhoneController;

  @Mock
  private CustomerPhoneService customerPhoneService;

  @Mock
  private EntityConfiguration entityConfiguration;

  @Mock
  private PhoneFormatter phoneFormatter;

  @Mock
  private PhoneValidator phoneValidator;

  /**
   * Test {@link CustomerPhoneController#deletePhone(Long, HttpServletRequest)}.
   * <p>
   * Method under test: {@link CustomerPhoneController#deletePhone(Long, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test deletePhone(Long, HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
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
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/myaccount/phone/deletePhone");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("customerPhoneId", String.valueOf(1L));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerPhoneController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("phoneNameForm"))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/myaccount/phone/viewPhone.htm1"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/myaccount/phone/viewPhone.htm1"));
  }

  /**
   * Test {@link CustomerPhoneController#initPhoneNameForm(HttpServletRequest, Model)}.
   * <p>
   * Method under test: {@link CustomerPhoneController#initPhoneNameForm(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test initPhoneNameForm(HttpServletRequest, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhoneNameForm CustomerPhoneController.initPhoneNameForm(HttpServletRequest, Model)"})
  void testInitPhoneNameForm() {
    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    phoneImpl.setActive(true);
    phoneImpl.setCountryCode("GB");
    phoneImpl.setDefault(true);
    phoneImpl.setExtension("org.broadleafcommerce.profile.core.domain.Phone");
    phoneImpl.setId(1L);
    phoneImpl.setPhoneNumber("6625550144");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(phoneImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    PhoneNameForm actualInitPhoneNameFormResult = customerPhoneController.initPhoneNameForm(request,
        new ConcurrentModel());

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.profile.core.domain.Phone"));
    assertNull(actualInitPhoneNameFormResult.getPhoneName());
    assertSame(phoneImpl, actualInitPhoneNameFormResult.getPhone());
  }

  /**
   * Test {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}.
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /myaccount/phone/savePhone}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}
   */
  @Test
  @DisplayName("Test savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long); when get(String, Object[]) '/myaccount/phone/savePhone'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String CustomerPhoneController.savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)"})
  void testSavePhone_whenGetMyaccountPhoneSavePhone() throws Exception {
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/myaccount/phone/savePhone");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerPhoneController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("phoneNameForm"))
        .andExpect(MockMvcResultMatchers.view().name("myAccount/phone/customerPhones"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("myAccount/phone/customerPhones"));
  }

  /**
   * Test {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}.
   * <ul>
   *   <li>When valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}
   */
  @Test
  @DisplayName("Test savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long); when valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String CustomerPhoneController.savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)"})
  void testSavePhone_whenValueOfOne() throws Exception {
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
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/myaccount/phone/savePhone");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("phoneId", String.valueOf(1L));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerPhoneController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("phoneNameForm"))
        .andExpect(MockMvcResultMatchers.view().name("myAccount/phone/customerPhones"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("myAccount/phone/customerPhones"));
  }

  /**
   * Test {@link CustomerPhoneController#viewPhone(Long, HttpServletRequest, PhoneNameForm, BindingResult)}.
   * <p>
   * Method under test: {@link CustomerPhoneController#viewPhone(Long, HttpServletRequest, PhoneNameForm, BindingResult)}
   */
  @Test
  @DisplayName("Test viewPhone(Long, HttpServletRequest, PhoneNameForm, BindingResult)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String CustomerPhoneController.viewPhone(Long, HttpServletRequest, PhoneNameForm, BindingResult)"})
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/myaccount/phone/viewPhone");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerPhoneController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("phoneNameForm"))
        .andExpect(MockMvcResultMatchers.view().name("myAccount/phone/customerPhones"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("myAccount/phone/customerPhones"));
  }
}
