/*-
 * #%L
 * BroadleafCommerce Profile Web
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.web.controller.validator.PhoneValidator;
import org.broadleafcommerce.profile.web.core.model.PhoneNameForm;
import org.broadleafcommerce.profile.web.core.util.PhoneFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

class CustomerPhoneControllerDiffblueTest {
  /**
   * Test
   * {@link CustomerPhoneController#initPhoneNameForm(HttpServletRequest, Model)}.
   * <ul>
   *   <li>Given {@link PhoneImpl} (default constructor) Active is
   * {@code true}.</li>
   *   <li>Then return PhoneName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#initPhoneNameForm(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test initPhoneNameForm(HttpServletRequest, Model); given PhoneImpl (default constructor) Active is 'true'; then return PhoneName is 'null'")
  void testInitPhoneNameForm_givenPhoneImplActiveIsTrue_thenReturnPhoneNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    PhoneNameForm actualInitPhoneNameFormResult = customerPhoneController.initPhoneNameForm(request,
        new ConcurrentModel());

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.profile.core.domain.Phone"));
    assertNull(actualInitPhoneNameFormResult.getPhoneName());
    assertSame(phoneImpl, actualInitPhoneNameFormResult.getPhone());
  }

  /**
   * Test
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}.
   * <ul>
   *   <li>Given {@link PhoneImpl} {@link PhoneImpl#setId(Long)} does nothing.</li>
   *   <li>Then calls {@link PhoneImpl#setId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}
   */
  @Test
  @DisplayName("Test savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long); given PhoneImpl setId(Long) does nothing; then calls setId(Long)")
  void testSavePhone_givenPhoneImplSetIdDoesNothing_thenCallsSetId() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatter phoneFormatter = mock(PhoneFormatter.class);
    doNothing().when(phoneFormatter).formatPhoneNumber(Mockito.<Phone>any());
    PhoneValidator phoneValidator = mock(PhoneValidator.class);
    doNothing().when(phoneValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    CustomerPhoneController customerPhoneController = new CustomerPhoneController();
    customerPhoneController.setEntityConfiguration(mock(EntityConfiguration.class));
    customerPhoneController.setPhoneValidator(phoneValidator);
    customerPhoneController.setPhoneFormatter(phoneFormatter);
    PhoneImpl phoneImpl = mock(PhoneImpl.class);
    doNothing().when(phoneImpl).setId(Mockito.<Long>any());
    PhoneNameForm phoneNameForm = mock(PhoneNameForm.class);
    when(phoneNameForm.getPhone()).thenReturn(phoneImpl);
    when(phoneNameForm.getPhoneName()).thenReturn("");
    doNothing().when(phoneNameForm).setPhone(Mockito.<Phone>any());
    doNothing().when(phoneNameForm).setPhoneName(Mockito.<String>any());
    phoneNameForm.setPhone(new PhoneImpl());
    phoneNameForm.setPhoneName("6625550144");
    BindingResult errors = mock(BindingResult.class);
    when(errors.getFieldValue(Mockito.<String>any())).thenReturn("Field Value");
    when(errors.hasErrors()).thenReturn(true);
    doNothing().when(errors).popNestedPath();
    doNothing().when(errors).pushNestedPath(Mockito.<String>any());

    // Act
    String actualSavePhoneResult = customerPhoneController.savePhone(phoneNameForm, errors,
        new MockHttpServletRequest(), 1L, 1L);

    // Assert
    verify(phoneImpl).setId(eq(1L));
    verify(phoneValidator).validate(isA(Object.class), isA(Errors.class));
    verify(phoneNameForm, atLeast(1)).getPhone();
    verify(phoneNameForm).getPhoneName();
    verify(phoneNameForm).setPhone(isA(Phone.class));
    verify(phoneNameForm).setPhoneName(eq("6625550144"));
    verify(phoneFormatter).formatPhoneNumber(isA(Phone.class));
    verify(errors).getFieldValue(eq("phoneName"));
    verify(errors).hasErrors();
    verify(errors).popNestedPath();
    verify(errors).pushNestedPath(eq("phone"));
    assertEquals("myAccount/phone/customerPhones", actualSavePhoneResult);
  }

  /**
   * Test
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}.
   * <ul>
   *   <li>Then return {@code myAccount/phone/customerPhones}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}
   */
  @Test
  @DisplayName("Test savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long); then return 'myAccount/phone/customerPhones'")
  void testSavePhone_thenReturnMyAccountPhoneCustomerPhones() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatter phoneFormatter = mock(PhoneFormatter.class);
    doNothing().when(phoneFormatter).formatPhoneNumber(Mockito.<Phone>any());
    PhoneValidator phoneValidator = mock(PhoneValidator.class);
    doNothing().when(phoneValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    CustomerPhoneController customerPhoneController = new CustomerPhoneController();
    customerPhoneController.setPhoneValidator(phoneValidator);
    customerPhoneController.setPhoneFormatter(phoneFormatter);
    PhoneNameForm phoneNameForm = mock(PhoneNameForm.class);
    when(phoneNameForm.getPhone()).thenReturn(new PhoneImpl());
    when(phoneNameForm.getPhoneName()).thenReturn("6625550144");
    doNothing().when(phoneNameForm).setPhone(Mockito.<Phone>any());
    doNothing().when(phoneNameForm).setPhoneName(Mockito.<String>any());
    phoneNameForm.setPhone(new PhoneImpl());
    phoneNameForm.setPhoneName("6625550144");

    BindException errors = new BindException("Target", "Object Name");
    errors.addError(new ObjectError("phone", "phone"));

    // Act
    String actualSavePhoneResult = customerPhoneController.savePhone(phoneNameForm, errors,
        new MockHttpServletRequest(), 1L, 1L);

    // Assert
    verify(phoneValidator).validate(isA(Object.class), isA(Errors.class));
    verify(phoneNameForm, atLeast(1)).getPhone();
    verify(phoneNameForm).getPhoneName();
    verify(phoneNameForm).setPhone(isA(Phone.class));
    verify(phoneNameForm).setPhoneName(eq("6625550144"));
    verify(phoneFormatter).formatPhoneNumber(isA(Phone.class));
    assertEquals("myAccount/phone/customerPhones", actualSavePhoneResult);
  }

  /**
   * Test
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code myAccount/phone/customerPhones}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPhoneController#savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long)}
   */
  @Test
  @DisplayName("Test savePhone(PhoneNameForm, BindingResult, HttpServletRequest, Long, Long); when 'null'; then return 'myAccount/phone/customerPhones'")
  void testSavePhone_whenNull_thenReturnMyAccountPhoneCustomerPhones() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PhoneFormatter phoneFormatter = mock(PhoneFormatter.class);
    doNothing().when(phoneFormatter).formatPhoneNumber(Mockito.<Phone>any());
    PhoneValidator phoneValidator = mock(PhoneValidator.class);
    doNothing().when(phoneValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());

    CustomerPhoneController customerPhoneController = new CustomerPhoneController();
    customerPhoneController.setPhoneValidator(phoneValidator);
    customerPhoneController.setPhoneFormatter(phoneFormatter);
    PhoneNameForm phoneNameForm = mock(PhoneNameForm.class);
    when(phoneNameForm.getPhone()).thenReturn(new PhoneImpl());
    when(phoneNameForm.getPhoneName()).thenReturn("6625550144");
    doNothing().when(phoneNameForm).setPhone(Mockito.<Phone>any());
    doNothing().when(phoneNameForm).setPhoneName(Mockito.<String>any());
    phoneNameForm.setPhone(new PhoneImpl());
    phoneNameForm.setPhoneName("6625550144");

    BindException errors = new BindException("Target", "Object Name");
    errors.addError(new ObjectError("phone", "phone"));

    // Act
    String actualSavePhoneResult = customerPhoneController.savePhone(phoneNameForm, errors,
        new MockHttpServletRequest(), 1L, null);

    // Assert
    verify(phoneValidator).validate(isA(Object.class), isA(Errors.class));
    verify(phoneNameForm, atLeast(1)).getPhone();
    verify(phoneNameForm).getPhoneName();
    verify(phoneNameForm).setPhone(isA(Phone.class));
    verify(phoneNameForm).setPhoneName(eq("6625550144"));
    verify(phoneFormatter).formatPhoneNumber(isA(Phone.class));
    assertEquals("myAccount/phone/customerPhones", actualSavePhoneResult);
  }
}
