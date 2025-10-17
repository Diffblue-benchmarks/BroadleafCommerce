/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.event.BroadleafApplicationEventPublisher;
import org.broadleafcommerce.common.id.service.IdGenerationService;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.security.util.PasswordChange;
import org.broadleafcommerce.common.security.util.PasswordReset;
import org.broadleafcommerce.common.service.GenericResponse;
import org.broadleafcommerce.profile.core.dao.CustomerAddressDao;
import org.broadleafcommerce.profile.core.dao.CustomerDao;
import org.broadleafcommerce.profile.core.dao.CustomerDaoImpl;
import org.broadleafcommerce.profile.core.dao.CustomerForgotPasswordSecurityTokenDao;
import org.broadleafcommerce.profile.core.dao.RoleDao;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerForgotPasswordSecurityToken;
import org.broadleafcommerce.profile.core.domain.CustomerForgotPasswordSecurityTokenImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerRole;
import org.broadleafcommerce.profile.core.domain.RoleImpl;
import org.broadleafcommerce.profile.core.dto.CustomerRuleHolder;
import org.broadleafcommerce.profile.core.service.handler.PasswordUpdatedHandler;
import org.broadleafcommerce.profile.core.service.listener.PostRegistrationObserver;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplDiffblueTest {
  @Mock private BroadleafApplicationEventPublisher broadleafApplicationEventPublisher;

  @Mock private CustomerAddressDao customerAddressDao;

  @Mock private CustomerDao customerDao;

  @Mock private CustomerForgotPasswordSecurityTokenDao customerForgotPasswordSecurityTokenDao;

  @InjectMocks private CustomerServiceImpl customerServiceImpl;

  @Mock private IdGenerationService idGenerationService;

  @Mock private PasswordEncoder passwordEncoder;

  @Mock private RoleDao roleDao;

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(new CustomerImpl()));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer2() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any()))
        .thenThrow(new IllegalArgumentException());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer));
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer3() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException()).when(customer).setPassword(Mockito.<String>any());
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer));
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setPassword("secret");
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer4() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn(null);
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer);

    // Assert
    verify(customerDao).save(isA(Customer.class));
    verify(customer).getId();
    verify(customer).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setPassword("secret");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer5() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setId(null);
    customer.setUsername(null);
    customer.setUnencodedPassword(null);
    customer.setUnencodedChallengeAnswer(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerById(1L);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.saveCustomer(new CustomerImpl(), true));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister2() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any()))
        .thenThrow(new IllegalArgumentException());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer, true));
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister3() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException()).when(customer).setPassword(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer, true));
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(customer).setPassword("secret");
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister4() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("secret");
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer, true);

    // Assert
    verify(customerDao).save(isA(Customer.class));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(customer).setPassword("secret");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister5() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getUnencodedChallengeAnswer()).thenReturn(null);
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer, true);

    // Assert
    verify(customerDao).save(isA(Customer.class));
    verify(customer).getId();
    verify(customer).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(customer).setPassword("secret");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister6() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn(null);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer, true);

    // Assert
    verify(customerDao).save(isA(Customer.class));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(customer).setChallengeAnswer("secret");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister7() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setId(null);
    customer.setUsername(null);
    customer.setUnencodedPassword(null);
    customer.setUnencodedChallengeAnswer(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer, false));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerById(1L);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister8() {
    // Arrange
    when(customerDao.save(Mockito.<Customer>any())).thenThrow(new IllegalArgumentException());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setId(null);
    customer.setUsername("janedoe");
    customer.setUnencodedPassword(null);
    customer.setUnencodedChallengeAnswer(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer, false));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).save(isA(Customer.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link CustomerImpl#setRegistered(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister_givenFalse_thenCallsSetRegistered() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(false);
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    doNothing().when(customer).setRegistered(anyBoolean());
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer, true);

    // Assert
    verify(customerDao).save(isA(Customer.class));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(customer).setChallengeAnswer("secret");
    verify(customer).setPassword("secret");
    verify(customer).setRegistered(true);
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerDao#readCustomerById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister_thenCallsReadCustomerById() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.saveCustomer(new CustomerImpl(), true));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerById(1L);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setChallengeAnswer(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister_thenCallsSetChallengeAnswer() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer, true);

    // Assert
    verify(customerDao).save(isA(Customer.class));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(customer).setChallengeAnswer("secret");
    verify(customer).setPassword("secret");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code
   * register}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister_thenCallsSetId() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    CustomerImpl customer = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException()).when(customer).setId(Mockito.<Long>any());
    when(customer.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer, true));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customer).getId();
    verify(customer).setId(1L);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#save(Customer)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_givenCustomerDaoSaveThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.save(Mockito.<Customer>any())).thenThrow(new IllegalArgumentException());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setId(null);
    customer.setUsername("janedoe");
    customer.setUnencodedPassword(null);
    customer.setUnencodedChallengeAnswer(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).save(isA(Customer.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#isRegistered()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_givenFalse_whenCustomerImplIsRegisteredReturnFalse() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(false);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer);

    // Assert
    verify(customerDao).save(isA(Customer.class));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(customer).setChallengeAnswer("secret");
    verify(customer).setPassword("secret");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerDao#readCustomerById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_thenCallsReadCustomerById() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(new CustomerImpl()));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerById(1L);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setChallengeAnswer(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_thenCallsSetChallengeAnswer() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer);

    // Assert
    verify(customerDao).save(isA(Customer.class));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setChallengeAnswer("secret");
    verify(customer).setPassword("secret");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_thenCallsSetId() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    CustomerImpl customer = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException()).when(customer).setId(Mockito.<Long>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customer).getId();
    verify(customer).isRegistered();
    verify(customer).setId(1L);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getChallengeAnswer()} return {@code
   *       secret}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_whenCustomerImplGetChallengeAnswerReturnSecret() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("secret");
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer);

    // Assert
    verify(customerDao).save(isA(Customer.class));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setPassword("secret");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getUnencodedPassword()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_whenCustomerImplGetUnencodedPasswordReturnNull() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn(null);
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer);

    // Assert
    verify(customerDao).save(isA(Customer.class));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setChallengeAnswer("secret");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.registerCustomer(
                new CustomerImpl(), "iloveyou", "Password Confirm"));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer2() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setId(null);
    customer.setUsername(null);
    customer.setUnencodedPassword(null);
    customer.setUnencodedChallengeAnswer(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm"));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerById(1L);
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#save(Customer)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_givenCustomerDaoSaveThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.save(Mockito.<Customer>any())).thenThrow(new IllegalArgumentException());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setId(null);
    customer.setUsername("janedoe");
    customer.setUnencodedPassword(null);
    customer.setUnencodedChallengeAnswer(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm"));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).save(isA(Customer.class));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#isRegistered()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_givenFalse_whenCustomerImplIsRegisteredReturnFalse() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(false);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act
    Customer actualRegisterCustomerResult =
        customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName("ROLE_USER");
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(customer).setChallengeAnswer("secret");
    verify(customer).setPassword("secret");
    verify(customer).setRegistered(true);
    verify(customer).setUnencodedPassword("iloveyou");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualRegisterCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#encode(CharSequence)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_givenPasswordEncoderEncodeThrowIllegalArgumentException() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any()))
        .thenThrow(new IllegalArgumentException());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm"));
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setRegistered(true);
    verify(customer).setUnencodedPassword("iloveyou");
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>Given {@link RoleDao} {@link RoleDao#readRoleByName(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_givenRoleDaoReadRoleByNameThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm"));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).readRoleByName("ROLE_USER");
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setChallengeAnswer("secret");
    verify(customer).setPassword("secret");
    verify(customer).setRegistered(true);
    verify(customer).setUnencodedPassword("iloveyou");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setChallengeAnswer(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_thenCallsSetChallengeAnswer() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act
    Customer actualRegisterCustomerResult =
        customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName("ROLE_USER");
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setChallengeAnswer("secret");
    verify(customer).setPassword("secret");
    verify(customer).setRegistered(true);
    verify(customer).setUnencodedPassword("iloveyou");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualRegisterCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_thenCallsSetId() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    CustomerImpl customer = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException()).when(customer).setId(Mockito.<Long>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(null);
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm"));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customer).getId();
    verify(customer).isRegistered();
    verify(customer).setId(1L);
    verify(customer).setRegistered(true);
    verify(customer).setUnencodedPassword("iloveyou");
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>Then {@link CustomerImpl} (default constructor) UnencodedPassword is {@code iloveyou}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_thenCustomerImplUnencodedPasswordIsIloveyou() {
    // Arrange
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());

    PostRegistrationObserver postRegisterListeners = mock(PostRegistrationObserver.class);
    doNothing().when(postRegisterListeners).processRegistrationEvent(Mockito.<Customer>any());
    customerServiceImpl.addPostRegisterListener(postRegisterListeners);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setId(null);
    customer.setUsername("janedoe");
    customer.setUnencodedPassword(null);
    customer.setUnencodedChallengeAnswer("Customer");

    // Act
    customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName("ROLE_USER");
    verify(postRegisterListeners).processRegistrationEvent(isA(Customer.class));
    verify(passwordEncoder, atLeast(1)).encode(Mockito.<CharSequence>any());
    assertEquals("iloveyou", customer.getUnencodedPassword());
    assertEquals("secret", customer.getChallengeAnswer());
    assertEquals("secret", customer.getPassword());
    assertEquals(1L, customer.getId().longValue());
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getChallengeAnswer()} return {@code
   *       secret}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_whenCustomerImplGetChallengeAnswerReturnSecret() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("secret");
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act
    Customer actualRegisterCustomerResult =
        customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName("ROLE_USER");
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setPassword("secret");
    verify(customer).setRegistered(true);
    verify(customer).setUnencodedPassword("iloveyou");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualRegisterCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getUnencodedChallengeAnswer()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_whenCustomerImplGetUnencodedChallengeAnswerReturnNull() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());

    CustomerImpl customer = mock(CustomerImpl.class);
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn(null);
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act
    Customer actualRegisterCustomerResult =
        customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName("ROLE_USER");
    verify(customer).getId();
    verify(customer).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setPassword("secret");
    verify(customer).setRegistered(true);
    verify(customer).setUnencodedPassword("iloveyou");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualRegisterCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getUnencodedPassword()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_whenCustomerImplGetUnencodedPasswordReturnNull() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn(null);
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act
    Customer actualRegisterCustomerResult =
        customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName("ROLE_USER");
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setChallengeAnswer("secret");
    verify(customer).setRegistered(true);
    verify(customer).setUnencodedPassword("iloveyou");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualRegisterCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   *
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).
   *   <li>Then calls {@link CustomerDao#readCustomerById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_whenCustomerImpl_thenCallsReadCustomerById() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.registerCustomer(
                new CustomerImpl(), "iloveyou", "Password Confirm"));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerById(1L);
  }

  /**
   * Test {@link CustomerServiceImpl#createRegisteredCustomerRoles(Customer)}.
   *
   * <ul>
   *   <li>Then calls {@link RoleDao#addRoleToCustomer(CustomerRole)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createRegisteredCustomerRoles(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.createRegisteredCustomerRoles(Customer)"})
  public void testCreateRegisteredCustomerRoles_thenCallsAddRoleToCustomer() {
    // Arrange
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());

    // Act
    customerServiceImpl.createRegisteredCustomerRoles(new CustomerImpl());

    // Assert
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName("ROLE_USER");
  }

  /**
   * Test {@link CustomerServiceImpl#createRegisteredCustomerRoles(Customer)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createRegisteredCustomerRoles(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.createRegisteredCustomerRoles(Customer)"})
  public void testCreateRegisteredCustomerRoles_thenThrowIllegalArgumentException() {
    // Arrange
    when(roleDao.readRoleByName(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.createRegisteredCustomerRoles(new CustomerImpl()));
    verify(roleDao).readRoleByName("ROLE_USER");
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByEmail(String)}.
   *
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readCustomerByEmail(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByEmail(String)"})
  public void testReadCustomerByEmail_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByEmail(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    Customer actualReadCustomerByEmailResult =
        customerServiceImpl.readCustomerByEmail("42 Main St");

    // Assert
    verify(customerDao).readCustomerByEmail("42 Main St");
    assertSame(customerImpl, actualReadCustomerByEmailResult);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByEmail(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readCustomerByEmail(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByEmail(String)"})
  public void testReadCustomerByEmail_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readCustomerByEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.readCustomerByEmail("42 Main St"));
    verify(customerDao).readCustomerByEmail("42 Main St");
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerByUsername("janedoe");
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword2() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerByUsername("janedoe");
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword3() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getUnencodedPassword()).thenThrow(new IllegalArgumentException());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getId();
    verify(customerImpl).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword(null);
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getChallengeAnswer()} return {@code
   *       secret}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_givenCustomerImplGetChallengeAnswerReturnSecret() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("secret");
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    CustomerImpl customerImpl2 = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl2);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    Customer actualChangePasswordResult =
        customerServiceImpl.changePassword(new PasswordChange("janedoe"));

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword(null);
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl2, actualChangePasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getUnencodedChallengeAnswer()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_givenCustomerImplGetUnencodedChallengeAnswerReturnNull() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn(null);
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    CustomerImpl customerImpl2 = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl2);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    Customer actualChangePasswordResult =
        customerServiceImpl.changePassword(new PasswordChange("janedoe"));

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerImpl).getId();
    verify(customerImpl).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword(null);
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl2, actualChangePasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getUnencodedPassword()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_givenCustomerImplGetUnencodedPasswordReturnNull() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customerImpl).setChallengeAnswer(Mockito.<String>any());
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn(null);
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    CustomerImpl customerImpl2 = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl2);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    Customer actualChangePasswordResult =
        customerServiceImpl.changePassword(new PasswordChange("janedoe"));

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setChallengeAnswer("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword(null);
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl2, actualChangePasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#isRegistered()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_givenCustomerImplIsRegisteredReturnFalse() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customerImpl).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.isRegistered()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    CustomerImpl customerImpl2 = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl2);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    Customer actualChangePasswordResult =
        customerServiceImpl.changePassword(new PasswordChange("janedoe"));

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl).isRegistered();
    verify(customerImpl).setChallengeAnswer("secret");
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword(null);
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl2, actualChangePasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#setPassword(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_givenCustomerImplSetPasswordThrowIllegalArgumentException() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException()).when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword(null);
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#encode(CharSequence)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_givenPasswordEncoderEncodeThrowIllegalArgumentException() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword(null);
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerDao#readCustomerById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_thenCallsReadCustomerById() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerById(1L);
    verify(customerDao).readCustomerByUsername("janedoe");
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerDaoImpl#readCustomerById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_thenCallsReadCustomerById2() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getUnencodedPassword()).thenThrow(new IllegalArgumentException());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn(null);
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    doNothing().when(customerImpl).setUsername(Mockito.<String>any());

    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(null);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerById(1L);
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword(null);
    verify(customerImpl).setUsername("1");
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setChallengeAnswer(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_thenCallsSetChallengeAnswer() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customerImpl).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    CustomerImpl customerImpl2 = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl2);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    Customer actualChangePasswordResult =
        customerServiceImpl.changePassword(new PasswordChange("janedoe"));

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setChallengeAnswer("secret");
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword(null);
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl2, actualChangePasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_thenCallsSetId() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException()).when(customerImpl).setId(Mockito.<Long>any());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(null);
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getId();
    verify(customerImpl).isRegistered();
    verify(customerImpl).setId(1L);
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword(null);
  }

  /**
   * Test {@link CustomerServiceImpl#resetPassword(PasswordReset)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPassword(PasswordReset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.resetPassword(PasswordReset)"})
  public void testResetPassword() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.resetPassword(new PasswordReset("janedoe")));
    verify(customerDao).readCustomerByUsername("janedoe");
  }

  /**
   * Test {@link CustomerServiceImpl#resetPassword(PasswordReset)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPassword(PasswordReset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.resetPassword(PasswordReset)"})
  public void testResetPassword2() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.resetPassword(new PasswordReset("janedoe")));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerByUsername("janedoe");
  }

  /**
   * Test {@link CustomerServiceImpl#resetPassword(PasswordReset)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link PasswordReset} {@link PasswordReset#getPasswordLength()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPassword(PasswordReset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.resetPassword(PasswordReset)"})
  public void testResetPassword_givenZero_whenPasswordResetGetPasswordLengthReturnZero() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customerImpl).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    CustomerImpl customerImpl2 = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl2);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    PasswordReset passwordReset = mock(PasswordReset.class);
    when(passwordReset.getPasswordChangeRequired()).thenReturn(true);
    when(passwordReset.getPasswordLength()).thenReturn(0);
    when(passwordReset.getUsername()).thenReturn("janedoe");

    // Act
    Customer actualResetPasswordResult = customerServiceImpl.resetPassword(passwordReset);

    // Assert
    verify(passwordReset).getPasswordChangeRequired();
    verify(passwordReset).getPasswordLength();
    verify(passwordReset).getUsername();
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setChallengeAnswer("secret");
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(true);
    verify(customerImpl).setUnencodedPassword("");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl2, actualResetPasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#resetPassword(PasswordReset)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerDao#readCustomerById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPassword(PasswordReset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.resetPassword(PasswordReset)"})
  public void testResetPassword_thenCallsReadCustomerById() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.resetPassword(new PasswordReset("janedoe")));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).readCustomerById(1L);
    verify(customerDao).readCustomerByUsername("janedoe");
  }

  /**
   * Test {@link CustomerServiceImpl#addPostRegisterListener(PostRegistrationObserver)}.
   *
   * <p>Method under test: {@link
   * CustomerServiceImpl#addPostRegisterListener(PostRegistrationObserver)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.addPostRegisterListener(PostRegistrationObserver)"})
  public void testAddPostRegisterListener() {
    // Arrange
    PostRegistrationObserver postRegisterListeners = mock(PostRegistrationObserver.class);

    // Act
    customerServiceImpl.addPostRegisterListener(postRegisterListeners);

    // Assert
    List<PostRegistrationObserver> postRegistrationObserverList =
        customerServiceImpl.postRegisterListeners;
    assertEquals(1, postRegistrationObserverList.size());
    assertSame(postRegisterListeners, postRegistrationObserverList.get(0));
  }

  /**
   * Test {@link CustomerServiceImpl#notifyPostRegisterListeners(Customer)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#notifyPostRegisterListeners(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.notifyPostRegisterListeners(Customer)"})
  public void testNotifyPostRegisterListeners() {
    // Arrange
    PostRegistrationObserver postRegisterListeners = mock(PostRegistrationObserver.class);
    doNothing().when(postRegisterListeners).processRegistrationEvent(Mockito.<Customer>any());
    customerServiceImpl.addPostRegisterListener(postRegisterListeners);

    // Act
    customerServiceImpl.notifyPostRegisterListeners(new CustomerImpl());

    // Assert
    verify(postRegisterListeners).processRegistrationEvent(isA(Customer.class));
  }

  /**
   * Test {@link CustomerServiceImpl#notifyPostRegisterListeners(Customer)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#notifyPostRegisterListeners(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.notifyPostRegisterListeners(Customer)"})
  public void testNotifyPostRegisterListeners_thenThrowIllegalArgumentException() {
    // Arrange
    PostRegistrationObserver postRegisterListeners = mock(PostRegistrationObserver.class);
    doThrow(new IllegalArgumentException())
        .when(postRegisterListeners)
        .processRegistrationEvent(Mockito.<Customer>any());
    customerServiceImpl.addPostRegisterListener(postRegisterListeners);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.notifyPostRegisterListeners(new CustomerImpl()));
    verify(postRegisterListeners).processRegistrationEvent(isA(Customer.class));
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomer()}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomer()"})
  public void testCreateCustomer() {
    // Arrange
    when(customerDao.create()).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.createCustomer());
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomer()}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#create()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomer()"})
  public void testCreateCustomer_givenCustomerDaoCreateThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.create()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.createCustomer());
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomer()}.
   *
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomer()"})
  public void testCreateCustomer_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.create()).thenReturn(customerImpl);
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act
    Customer actualCreateCustomerResult = customerServiceImpl.createCustomer();

    // Assert
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).create();
    assertSame(customerImpl, actualCreateCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerWithNullId()}.
   *
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomerWithNullId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerWithNullId()"})
  public void testCreateCustomerWithNullId_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.create()).thenReturn(customerImpl);

    // Act
    Customer actualCreateCustomerWithNullIdResult = customerServiceImpl.createCustomerWithNullId();

    // Assert
    verify(customerDao).create();
    assertSame(customerImpl, actualCreateCustomerWithNullIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerWithNullId()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomerWithNullId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerWithNullId()"})
  public void testCreateCustomerWithNullId_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.create()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.createCustomerWithNullId());
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerFromId(Long)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerFromId(Long)"})
  public void testCreateCustomerFromId() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.createCustomerFromId(1L));
    verify(customerDao).readCustomerById(1L);
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerFromId(Long)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerFromId(Long)"})
  public void testCreateCustomerFromId2() {
    // Arrange
    when(customerDao.create()).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.createCustomerFromId(null));
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerFromId(Long)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#create()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerFromId(Long)"})
  public void testCreateCustomerFromId_givenCustomerDaoCreateThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.create()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.createCustomerFromId(null));
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerFromId(Long)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#readCustomerById(Long)} return {@link
   *       CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerFromId(Long)"})
  public void testCreateCustomerFromId_givenCustomerDaoReadCustomerByIdReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(customerImpl);

    // Act
    Customer actualCreateCustomerFromIdResult = customerServiceImpl.createCustomerFromId(1L);

    // Assert
    verify(customerDao).readCustomerById(1L);
    assertSame(customerImpl, actualCreateCustomerFromIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerFromId(Long)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#readCustomerById(Long)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerFromId(Long)"})
  public void testCreateCustomerFromId_givenCustomerDaoReadCustomerByIdReturnNull() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.create()).thenReturn(customerImpl);
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(null);

    // Act
    Customer actualCreateCustomerFromIdResult = customerServiceImpl.createCustomerFromId(1L);

    // Assert
    verify(customerDao).create();
    verify(customerDao).readCustomerById(1L);
    assertSame(customerImpl, actualCreateCustomerFromIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerFromId(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link IdGenerationService#findNextId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerFromId(Long)"})
  public void testCreateCustomerFromId_thenCallsFindNextId() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.create()).thenReturn(customerImpl);
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act
    Customer actualCreateCustomerFromIdResult = customerServiceImpl.createCustomerFromId(null);

    // Assert
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).create();
    assertSame(customerImpl, actualCreateCustomerFromIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findNextCustomerId()}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findNextCustomerId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomerServiceImpl.findNextCustomerId()"})
  public void testFindNextCustomerId_thenReturnLongValueIsOne() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act
    Long actualFindNextCustomerIdResult = customerServiceImpl.findNextCustomerId();

    // Assert
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    assertEquals(1L, actualFindNextCustomerIdResult.longValue());
  }

  /**
   * Test {@link CustomerServiceImpl#findNextCustomerId()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#findNextCustomerId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomerServiceImpl.findNextCustomerId()"})
  public void testFindNextCustomerId_thenThrowIllegalArgumentException() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.findNextCustomerId());
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
  }

  /**
   * Test {@link CustomerServiceImpl#createNewCustomer()}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#createNewCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createNewCustomer()"})
  public void testCreateNewCustomer() {
    // Arrange
    when(customerDao.create()).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.createNewCustomer());
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#createNewCustomer()}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#create()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createNewCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createNewCustomer()"})
  public void testCreateNewCustomer_givenCustomerDaoCreateThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.create()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.createNewCustomer());
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#createNewCustomer()}.
   *
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#createNewCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.createNewCustomer()"})
  public void testCreateNewCustomer_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.create()).thenReturn(customerImpl);
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act
    Customer actualCreateNewCustomerResult = customerServiceImpl.createNewCustomer();

    // Assert
    verify(idGenerationService).findNextId("org.broadleafcommerce.profile.core.domain.Customer");
    verify(customerDao).create();
    assertSame(customerImpl, actualCreateNewCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(Customer)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(Customer)"})
  public void testDeleteCustomer() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(roleDao)
        .removeCustomerRolesByCustomerId(Mockito.<Long>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.deleteCustomer(new CustomerImpl()));
    verify(roleDao).removeCustomerRolesByCustomerId(isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(Customer)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#delete(Customer)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(Customer)"})
  public void testDeleteCustomer_givenCustomerDaoDeleteThrowIllegalArgumentException() {
    // Arrange
    doNothing()
        .when(customerAddressDao)
        .hardDeleteCustomerAddressesForCustomer(Mockito.<Long>any());
    doThrow(new IllegalArgumentException()).when(customerDao).delete(Mockito.<Customer>any());
    doNothing().when(roleDao).removeCustomerRolesByCustomerId(Mockito.<Long>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.deleteCustomer(new CustomerImpl()));
    verify(customerAddressDao).hardDeleteCustomerAddressesForCustomer(isNull());
    verify(customerDao).delete(isA(Customer.class));
    verify(roleDao).removeCustomerRolesByCustomerId(isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerAddressDao#hardDeleteCustomerAddressesForCustomer(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#deleteCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(Customer)"})
  public void testDeleteCustomer_thenCallsHardDeleteCustomerAddressesForCustomer() {
    // Arrange
    doNothing()
        .when(customerAddressDao)
        .hardDeleteCustomerAddressesForCustomer(Mockito.<Long>any());
    doNothing().when(customerDao).delete(Mockito.<Customer>any());
    doNothing().when(roleDao).removeCustomerRolesByCustomerId(Mockito.<Long>any());

    // Act
    customerServiceImpl.deleteCustomer(new CustomerImpl());

    // Assert
    verify(customerAddressDao).hardDeleteCustomerAddressesForCustomer(isNull());
    verify(customerDao).delete(isA(Customer.class));
    verify(roleDao).removeCustomerRolesByCustomerId(isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#detachCustomer(Customer)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#detach(Customer)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#detachCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.detachCustomer(Customer)"})
  public void testDetachCustomer_givenCustomerDaoDetachDoesNothing() {
    // Arrange
    doNothing().when(customerDao).detach(Mockito.<Customer>any());

    // Act
    customerServiceImpl.detachCustomer(new CustomerImpl());

    // Assert
    verify(customerDao).detach(isA(Customer.class));
  }

  /**
   * Test {@link CustomerServiceImpl#detachCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#detachCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.detachCustomer(Customer)"})
  public void testDetachCustomer_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException()).when(customerDao).detach(Mockito.<Customer>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.detachCustomer(new CustomerImpl()));
    verify(customerDao).detach(isA(Customer.class));
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByUsername(String, Boolean)} with {@code username},
   * {@code cacheable}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#readCustomerByUsername(String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByUsername(String, Boolean)"})
  public void testReadCustomerByUsernameWithUsernameCacheable() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any(), Mockito.<Boolean>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.readCustomerByUsername("janedoe", true));
    verify(customerDao).readCustomerByUsername("janedoe", true);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByUsername(String, Boolean)} with {@code username},
   * {@code cacheable}.
   *
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readCustomerByUsername(String, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByUsername(String, Boolean)"})
  public void testReadCustomerByUsernameWithUsernameCacheable_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByUsername(Mockito.<String>any(), Mockito.<Boolean>any()))
        .thenReturn(customerImpl);

    // Act
    Customer actualReadCustomerByUsernameResult =
        customerServiceImpl.readCustomerByUsername("janedoe", true);

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe", true);
    assertSame(customerImpl, actualReadCustomerByUsernameResult);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByUsername(String)} with {@code username}.
   *
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readCustomerByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByUsername(String)"})
  public void testReadCustomerByUsernameWithUsername_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    Customer actualReadCustomerByUsernameResult =
        customerServiceImpl.readCustomerByUsername("janedoe");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    assertSame(customerImpl, actualReadCustomerByUsernameResult);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByUsername(String)} with {@code username}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readCustomerByUsername(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByUsername(String)"})
  public void testReadCustomerByUsernameWithUsername_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.readCustomerByUsername("janedoe"));
    verify(customerDao).readCustomerByUsername("janedoe");
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerById(Long)}.
   *
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readCustomerById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerById(Long)"})
  public void testReadCustomerById_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(customerImpl);

    // Act
    Customer actualReadCustomerByIdResult = customerServiceImpl.readCustomerById(1L);

    // Assert
    verify(customerDao).readCustomerById(1L);
    assertSame(customerImpl, actualReadCustomerByIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readCustomerById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerById(Long)"})
  public void testReadCustomerById_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.readCustomerById(1L));
    verify(customerDao).readCustomerById(1L);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByExternalId(String)}.
   *
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readCustomerByExternalId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByExternalId(String)"})
  public void testReadCustomerByExternalId_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByExternalId(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    Customer actualReadCustomerByExternalIdResult =
        customerServiceImpl.readCustomerByExternalId("42");

    // Assert
    verify(customerDao).readCustomerByExternalId("42");
    assertSame(customerImpl, actualReadCustomerByExternalIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByExternalId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readCustomerByExternalId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByExternalId(String)"})
  public void testReadCustomerByExternalId_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readCustomerByExternalId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.readCustomerByExternalId("42"));
    verify(customerDao).readCustomerByExternalId("42");
  }

  /**
   * Test {@link CustomerServiceImpl#encodePassword(String)}.
   *
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#encode(CharSequence)} return {@code
   *       secret}.
   *   <li>Then return {@code secret}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#encodePassword(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerServiceImpl.encodePassword(String)"})
  public void testEncodePassword_givenPasswordEncoderEncodeReturnSecret_thenReturnSecret() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    String actualEncodePasswordResult = customerServiceImpl.encodePassword("iloveyou");

    // Assert
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertEquals("secret", actualEncodePasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#encodePassword(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#encodePassword(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerServiceImpl.encodePassword(String)"})
  public void testEncodePassword_thenThrowIllegalArgumentException() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.encodePassword("iloveyou"));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#isPasswordValid(String, String)}.
   *
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#matches(CharSequence, String)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#isPasswordValid(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerServiceImpl.isPasswordValid(String, String)"})
  public void testIsPasswordValid_givenPasswordEncoderMatchesReturnFalse_thenReturnFalse() {
    // Arrange
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualIsPasswordValidResult = customerServiceImpl.isPasswordValid("iloveyou", "secret");

    // Assert
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("secret"));
    assertFalse(actualIsPasswordValidResult);
  }

  /**
   * Test {@link CustomerServiceImpl#isPasswordValid(String, String)}.
   *
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#matches(CharSequence, String)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#isPasswordValid(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerServiceImpl.isPasswordValid(String, String)"})
  public void testIsPasswordValid_givenPasswordEncoderMatchesReturnTrue_thenReturnTrue() {
    // Arrange
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualIsPasswordValidResult = customerServiceImpl.isPasswordValid("iloveyou", "secret");

    // Assert
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("secret"));
    assertTrue(actualIsPasswordValidResult);
  }

  /**
   * Test {@link CustomerServiceImpl#isPasswordValid(String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#isPasswordValid(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerServiceImpl.isPasswordValid(String, String)"})
  public void testIsPasswordValid_thenThrowIllegalArgumentException() {
    // Arrange
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.isPasswordValid("iloveyou", "secret"));
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("secret"));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder(""));

    // Assert
    assertTrue(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule2() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer, new CustomerRuleHolder("getProductAttributes()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule3() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer, new CustomerRuleHolder("getCategoryAttributesMap()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule4() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer, new CustomerRuleHolder("getSkuAttributes()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule5() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer, new CustomerRuleHolder("getOrderItemAttributes()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule6() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer, new CustomerRuleHolder("getCustomerAttributes()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule7() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer, new CustomerRuleHolder("getAdditionalAttributes()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule8() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer, new CustomerRuleHolder("getAdditionalFields()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule9() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer,
            new CustomerRuleHolder("getProductAttributes()[UU]getProductAttributes()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule10() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer,
            new CustomerRuleHolder("getProductAttributes()[UU]getCategoryAttributesMap()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule11() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer, new CustomerRuleHolder("getProductAttributes()[UU]getSkuAttributes()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule12() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer,
            new CustomerRuleHolder("getProductAttributes()[UU]getOrderItemAttributes()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule13() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer,
            new CustomerRuleHolder("getProductAttributes()[UU]getCustomerAttributes()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule14() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer,
            new CustomerRuleHolder("getProductAttributes()[UU]getAdditionalAttributes()[UU]"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <ul>
   *   <li>Given {@link CustomerServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule_givenCustomerServiceImpl() {
    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(
        customerServiceImpl.customerPassesCustomerRule(
            customer, new CustomerRuleHolder("getProductAttributes")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <ul>
   *   <li>Given {@link CustomerServiceImpl}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule_givenCustomerServiceImpl_whenNull_thenReturnTrue() {
    // Arrange and Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(null, new CustomerRuleHolder("customer"));

    // Assert
    assertTrue(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <ul>
   *   <li>Given {@code customergetProductAttributes()[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule_givenCustomergetProductAttributesUu() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    CustomerRuleHolder customerRuleHolder = new CustomerRuleHolder("Customer Rule");
    customerRuleHolder.setCustomerRule("customergetProductAttributes()[UU]");

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(customer, customerRuleHolder);

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule_givenGetProductAttributesUu() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    CustomerRuleHolder customerRuleHolder = new CustomerRuleHolder("Customer Rule");
    customerRuleHolder.setCustomerRule("getProductAttributes()[UU]");

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(customer, customerRuleHolder);

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]customer}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule_givenGetProductAttributesUuCustomer() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    CustomerRuleHolder customerRuleHolder = new CustomerRuleHolder("Customer Rule");
    customerRuleHolder.setCustomerRule("getProductAttributes()[UU]customer");

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(customer, customerRuleHolder);

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <ul>
   *   <li>When {@link CustomerRuleHolder#CustomerRuleHolder(String)} with customerRule is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule_whenCustomerRuleHolderWithCustomerRuleIs42() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("42"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <ul>
   *   <li>When {@link CustomerRuleHolder#CustomerRuleHolder(String)} with customerRule is {@code
   *       customer}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule_whenCustomerRuleHolderWithCustomerRuleIsCustomer() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(
            customer, new CustomerRuleHolder("customer"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <ul>
   *   <li>When {@link CustomerRuleHolder#CustomerRuleHolder(String)} with customerRule is {@code
   *       MVEL}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule_whenCustomerRuleHolderWithCustomerRuleIsMvel() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("MVEL"));

    // Assert
    assertFalse(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   *
   * <ul>
   *   <li>When {@link CustomerRuleHolder#CustomerRuleHolder(String)} with customerRule is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer,
   * CustomerRuleHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"
  })
  public void testCustomerPassesCustomerRule_whenCustomerRuleHolderWithCustomerRuleIsNull() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    boolean actualCustomerPassesCustomerRuleResult =
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder(null));

    // Assert
    assertTrue(actualCustomerPassesCustomerRuleResult);
  }

  /**
   * Test {@link CustomerServiceImpl#buildCustomerRuleParams(Customer)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#buildCustomerRuleParams(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CustomerServiceImpl.buildCustomerRuleParams(Customer)"})
  public void testBuildCustomerRuleParams() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    Map<String, Object> actualBuildCustomerRuleParamsResult =
        customerServiceImpl.buildCustomerRuleParams(customer);

    // Assert
    assertEquals(1, actualBuildCustomerRuleParamsResult.size());
    Object getResult = actualBuildCustomerRuleParamsResult.get("customer");
    assertTrue(getResult instanceof CustomerImpl);
    assertSame(customer, getResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerServiceImpl#setCustomerDao(CustomerDao)}
   *   <li>{@link CustomerServiceImpl#setPasswordChangedHandlers(List)}
   *   <li>{@link CustomerServiceImpl#setPasswordResetHandlers(List)}
   *   <li>{@link CustomerServiceImpl#setPasswordTokenLength(int)}
   *   <li>{@link CustomerServiceImpl#setTokenExpiredMinutes(int)}
   *   <li>{@link CustomerServiceImpl#getPasswordChangedHandlers()}
   *   <li>{@link CustomerServiceImpl#getPasswordResetHandlers()}
   *   <li>{@link CustomerServiceImpl#getPasswordTokenLength()}
   *   <li>{@link CustomerServiceImpl#getTokenExpiredMinutes()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CustomerServiceImpl.getPasswordChangedHandlers()",
    "List CustomerServiceImpl.getPasswordResetHandlers()",
    "int CustomerServiceImpl.getPasswordTokenLength()",
    "int CustomerServiceImpl.getTokenExpiredMinutes()",
    "void CustomerServiceImpl.setCustomerDao(CustomerDao)",
    "void CustomerServiceImpl.setPasswordChangedHandlers(List)",
    "void CustomerServiceImpl.setPasswordResetHandlers(List)",
    "void CustomerServiceImpl.setPasswordTokenLength(int)",
    "void CustomerServiceImpl.setTokenExpiredMinutes(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

    // Act
    customerServiceImpl.setCustomerDao(new CustomerDaoImpl());
    ArrayList<PasswordUpdatedHandler> passwordChangedHandlers = new ArrayList<>();
    customerServiceImpl.setPasswordChangedHandlers(passwordChangedHandlers);
    ArrayList<PasswordUpdatedHandler> passwordResetHandlers = new ArrayList<>();
    customerServiceImpl.setPasswordResetHandlers(passwordResetHandlers);
    customerServiceImpl.setPasswordTokenLength(3);
    customerServiceImpl.setTokenExpiredMinutes(1);
    List<PasswordUpdatedHandler> actualPasswordChangedHandlers =
        customerServiceImpl.getPasswordChangedHandlers();
    List<PasswordUpdatedHandler> actualPasswordResetHandlers =
        customerServiceImpl.getPasswordResetHandlers();
    int actualPasswordTokenLength = customerServiceImpl.getPasswordTokenLength();

    // Assert
    assertEquals(1, customerServiceImpl.getTokenExpiredMinutes());
    assertEquals(3, actualPasswordTokenLength);
    assertTrue(actualPasswordChangedHandlers.isEmpty());
    assertTrue(actualPasswordResetHandlers.isEmpty());
    assertSame(passwordChangedHandlers, actualPasswordChangedHandlers);
    assertSame(passwordResetHandlers, actualPasswordResetHandlers);
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification() {
    // Arrange
    when(customerDao.readCustomersByEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.sendForgotUsernameNotification("42 Main St"));
    verify(customerDao).readCustomersByEmail("42 Main St");
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification2() {
    // Arrange
    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(customerDao.readCustomersByEmail(Mockito.<String>any())).thenReturn(customerList);
    doThrow(new IllegalArgumentException())
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.sendForgotUsernameNotification("42 Main St"));
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomersByEmail("42 Main St");
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}.
   *
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code inactiveUser}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_thenReturnErrorCodesListFirstIsInactiveUser() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(customerImpl);
    when(customerDao.readCustomersByEmail(Mockito.<String>any())).thenReturn(customerList);

    // Act
    GenericResponse actualSendForgotUsernameNotificationResult =
        customerServiceImpl.sendForgotUsernameNotification("42 Main St");

    // Assert
    verify(customerDao).readCustomersByEmail("42 Main St");
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}.
   *
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code notFound}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_thenReturnErrorCodesListFirstIsNotFound() {
    // Arrange
    when(customerDao.readCustomersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    GenericResponse actualSendForgotUsernameNotificationResult =
        customerServiceImpl.sendForgotUsernameNotification("42 Main St");

    // Assert
    verify(customerDao).readCustomersByEmail("42 Main St");
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("notFound", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}.
   *
   * <ul>
   *   <li>Then return not HasErrors.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_thenReturnNotHasErrors() {
    // Arrange
    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(customerDao.readCustomersByEmail(Mockito.<String>any())).thenReturn(customerList);
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());

    // Act
    GenericResponse actualSendForgotUsernameNotificationResult =
        customerServiceImpl.sendForgotUsernameNotification("42 Main St");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomersByEmail("42 Main St");
    assertFalse(actualSendForgotUsernameNotificationResult.getHasErrors());
    assertTrue(actualSendForgotUsernameNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_whenNull() {
    // Arrange and Act
    GenericResponse actualSendForgotUsernameNotificationResult =
        customerServiceImpl.sendForgotUsernameNotification(null);

    // Assert
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("notFound", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification() {
    // Arrange
    customerServiceImpl.setPasswordTokenLength(0);

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult =
        customerServiceImpl.sendForgotPasswordNotification(null, "");

    // Assert
    List<String> errorCodesList = actualSendForgotPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertTrue(actualSendForgotPasswordNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification2() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.sendForgotPasswordNotification(
                "janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername("janedoe");
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification3() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getEmailAddress()).thenThrow(new IllegalArgumentException());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.sendForgotPasswordNotification(
                "janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification4() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenThrow(new IllegalArgumentException());
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.sendForgotPasswordNotification(
                "janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification5() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.sendForgotPasswordNotification(
                "janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification6() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setEmailAddress("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doThrow(new IllegalArgumentException())
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    customerServiceImpl.setPasswordTokenLength(0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.sendForgotPasswordNotification("janedoe", ""));
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) EmailAddress is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification_givenCustomerImplEmailAddressIs42MainSt() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setEmailAddress("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    customerServiceImpl.setPasswordTokenLength(0);

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult =
        customerServiceImpl.sendForgotPasswordNotification("janedoe", "");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForgotPasswordNotificationResult.getHasErrors());
    assertTrue(actualSendForgotPasswordNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code emailNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification_thenReturnErrorCodesListFirstIsEmailNotFound() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult =
        customerServiceImpl.sendForgotPasswordNotification(
            "janedoe", "https://example.org/example");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    List<String> errorCodesList = actualSendForgotPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(actualSendForgotPasswordNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code inactiveUser}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification_thenReturnErrorCodesListFirstIsInactiveUser() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult =
        customerServiceImpl.sendForgotPasswordNotification(
            "janedoe", "https://example.org/example");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualSendForgotPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualSendForgotPasswordNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <ul>
   *   <li>Then return not HasErrors.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult =
        customerServiceImpl.sendForgotPasswordNotification(
            "janedoe", "https://example.org/example");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForgotPasswordNotificationResult.getHasErrors());
    assertTrue(actualSendForgotPasswordNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <ul>
   *   <li>Then return not HasErrors.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification_thenReturnNotHasErrors2() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult =
        customerServiceImpl.sendForgotPasswordNotification("janedoe", "");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForgotPasswordNotificationResult.getHasErrors());
    assertTrue(actualSendForgotPasswordNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not HasErrors.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification_whenNull_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult =
        customerServiceImpl.sendForgotPasswordNotification("janedoe", null);

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForgotPasswordNotificationResult.getHasErrors());
    assertTrue(actualSendForgotPasswordNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   *
   * <ul>
   *   <li>When {@code ?}.
   *   <li>Then return not HasErrors.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"
  })
  public void testSendForgotPasswordNotification_whenQuestionMark_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult =
        customerServiceImpl.sendForgotPasswordNotification("janedoe", "?");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForgotPasswordNotificationResult.getHasErrors());
    assertTrue(actualSendForgotPasswordNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification() {
    // Arrange
    customerServiceImpl.setPasswordTokenLength(0);

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult =
        customerServiceImpl.sendForcedPasswordChangeNotification(null, "");

    // Assert
    List<String> errorCodesList =
        actualSendForcedPasswordChangeNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification2() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult =
        customerServiceImpl.sendForcedPasswordChangeNotification(
            "janedoe", "https://example.org/example");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    List<String> errorCodesList =
        actualSendForcedPasswordChangeNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification3() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.sendForcedPasswordChangeNotification(
                "janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername("janedoe");
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification4() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getEmailAddress()).thenThrow(new IllegalArgumentException());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.sendForcedPasswordChangeNotification(
                "janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification5() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult =
        customerServiceImpl.sendForcedPasswordChangeNotification(
            "janedoe", "https://example.org/example");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList =
        actualSendForcedPasswordChangeNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification6() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenThrow(new IllegalArgumentException());
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.sendForcedPasswordChangeNotification(
                "janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification7() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.sendForcedPasswordChangeNotification(
                "janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification8() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setEmailAddress("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doThrow(new IllegalArgumentException())
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    customerServiceImpl.setPasswordTokenLength(0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.sendForcedPasswordChangeNotification("janedoe", ""));
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) EmailAddress is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification_givenCustomerImplEmailAddressIs42MainSt() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setEmailAddress("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    customerServiceImpl.setPasswordTokenLength(0);

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult =
        customerServiceImpl.sendForcedPasswordChangeNotification("janedoe", "");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <ul>
   *   <li>Then return not HasErrors.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult =
        customerServiceImpl.sendForcedPasswordChangeNotification(
            "janedoe", "https://example.org/example");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <ul>
   *   <li>Then return not HasErrors.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification_thenReturnNotHasErrors2() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult =
        customerServiceImpl.sendForcedPasswordChangeNotification("janedoe", "");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not HasErrors.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification_whenNull_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult =
        customerServiceImpl.sendForcedPasswordChangeNotification("janedoe", null);

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   *
   * <ul>
   *   <li>When {@code ?}.
   *   <li>Then return not HasErrors.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"
  })
  public void testSendForcedPasswordChangeNotification_whenQuestionMark_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing()
        .when(broadleafApplicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult =
        customerServiceImpl.sendForcedPasswordChangeNotification("janedoe", "?");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token},
   * {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomer() {
    // Arrange and Act
    GenericResponse actualCheckPasswordResetTokenResult =
        customerServiceImpl.checkPasswordResetToken(null, null);

    // Assert
    List<String> errorCodesList = actualCheckPasswordResetTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualCheckPasswordResetTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token},
   * {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomer2() {
    // Arrange
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    GenericResponse actualCheckPasswordResetTokenResult =
        customerServiceImpl.checkPasswordResetToken("ABC123", new CustomerImpl());

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    List<String> errorCodesList = actualCheckPasswordResetTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualCheckPasswordResetTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token},
   * {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomer3() {
    // Arrange
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.checkPasswordResetToken("ABC123", new CustomerImpl()));
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token},
   * {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomer4() {
    // Arrange
    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.checkPasswordResetToken("ABC123", new CustomerImpl()));
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(passwordEncoder).matches(isA(CharSequence.class), isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token},
   * {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomer5() {
    // Arrange
    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(true);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    GenericResponse actualCheckPasswordResetTokenResult =
        customerServiceImpl.checkPasswordResetToken("ABC123", new CustomerImpl());

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    List<String> errorCodesList = actualCheckPasswordResetTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("tokenUsed", errorCodesList.get(0));
    assertTrue(actualCheckPasswordResetTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token},
   * {@code customer}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomer6() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.checkPasswordResetToken("ABC123", null));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   * with {@code token}, {@code customer}, {@code response}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomerResponse() {
    // Arrange
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    CustomerImpl customer = new CustomerImpl();
    GenericResponse response = new GenericResponse();

    // Act
    CustomerForgotPasswordSecurityToken actualCheckPasswordResetTokenResult =
        customerServiceImpl.checkPasswordResetToken("ABC123", customer, response);

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertNull(actualCheckPasswordResetTokenResult);
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   * with {@code token}, {@code customer}, {@code response}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomerResponse2() {
    // Arrange
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.checkPasswordResetToken("ABC123", customer, new GenericResponse()));
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   * with {@code token}, {@code customer}, {@code response}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomerResponse3() {
    // Arrange
    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.checkPasswordResetToken("ABC123", customer, new GenericResponse()));
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(passwordEncoder).matches(isA(CharSequence.class), isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   * with {@code token}, {@code customer}, {@code response}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomerResponse4() {
    // Arrange
    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(true);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);
    CustomerImpl customer = new CustomerImpl();
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkPasswordResetToken("ABC123", customer, response);

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("tokenUsed", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   * with {@code token}, {@code customer}, {@code response}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomerResponse5() {
    // Arrange
    Customer customer = mock(Customer.class);

    GenericResponse response = mock(GenericResponse.class);
    doThrow(new IllegalArgumentException()).when(response).addErrorCode(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.checkPasswordResetToken(" ", customer, response));
    verify(response).addErrorCode("invalidToken");
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   * with {@code token}, {@code customer}, {@code response}.
   *
   * <ul>
   *   <li>Then calls {@link PasswordEncoder#encode(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomerResponse_thenCallsEncode() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.checkPasswordResetToken("ABC123", null, new GenericResponse()));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   * with {@code token}, {@code customer}, {@code response}.
   *
   * <ul>
   *   <li>Then calls {@link GenericResponse#getHasErrors()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomerResponse_thenCallsGetHasErrors() {
    // Arrange
    Customer customer = mock(Customer.class);

    GenericResponse response = mock(GenericResponse.class);
    when(response.getHasErrors()).thenReturn(true);

    // Act
    CustomerForgotPasswordSecurityToken actualCheckPasswordResetTokenResult =
        customerServiceImpl.checkPasswordResetToken("ABC123", customer, response);

    // Assert
    verify(response).getHasErrors();
    assertNull(actualCheckPasswordResetTokenResult);
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   * with {@code token}, {@code customer}, {@code response}.
   *
   * <ul>
   *   <li>Then calls {@link Customer#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomerResponse_thenCallsGetId() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.checkPasswordResetToken("ABC123", customer, new GenericResponse()));
    verify(customer).getId();
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   * with {@code token}, {@code customer}, {@code response}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomerResponse_whenEmptyString() {
    // Arrange
    Customer customer = mock(Customer.class);

    GenericResponse response = mock(GenericResponse.class);
    doNothing().when(response).addErrorCode(Mockito.<String>any());
    when(response.getHasErrors()).thenReturn(true);

    // Act
    CustomerForgotPasswordSecurityToken actualCheckPasswordResetTokenResult =
        customerServiceImpl.checkPasswordResetToken("", customer, response);

    // Assert
    verify(response).addErrorCode("invalidToken");
    verify(response).getHasErrors();
    assertNull(actualCheckPasswordResetTokenResult);
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   * with {@code token}, {@code customer}, {@code response}.
   *
   * <ul>
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomerResponse_whenSpace() {
    // Arrange
    Customer customer = mock(Customer.class);

    GenericResponse response = mock(GenericResponse.class);
    doNothing().when(response).addErrorCode(Mockito.<String>any());
    when(response.getHasErrors()).thenReturn(true);

    // Act
    CustomerForgotPasswordSecurityToken actualCheckPasswordResetTokenResult =
        customerServiceImpl.checkPasswordResetToken(" ", customer, response);

    // Assert
    verify(response).addErrorCode("invalidToken");
    verify(response).getHasErrors();
    assertNull(actualCheckPasswordResetTokenResult);
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token},
   * {@code customer}.
   *
   * <ul>
   *   <li>Then calls {@link Customer#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomer_thenCallsGetId() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.checkPasswordResetToken("ABC123", customer));
    verify(customer).getId();
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token},
   * {@code customer}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerForgotPasswordSecurityTokenDao#readToken(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomer_thenCallsReadToken() {
    // Arrange
    when(customerForgotPasswordSecurityTokenDao.readToken(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.checkPasswordResetToken("ABC123", null));
    verify(customerForgotPasswordSecurityTokenDao).readToken("secret");
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token},
   * {@code customer}.
   *
   * <ul>
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"
  })
  public void testCheckPasswordResetTokenWithTokenCustomer_whenSpace() {
    // Arrange and Act
    GenericResponse actualCheckPasswordResetTokenResult =
        customerServiceImpl.checkPasswordResetToken(" ", null);

    // Assert
    List<String> errorCodesList = actualCheckPasswordResetTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualCheckPasswordResetTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerByUsername("janedoe");
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken2() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getEmailAddress()).thenThrow(new IllegalArgumentException());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken3() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenThrow(new IllegalArgumentException());
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken4() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(1L);
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getId();
    verify(customerImpl).isDeactivated();
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken5() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(1L);
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).matches(isA(CharSequence.class), isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken6() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.getCustomerId())
        .thenThrow(new IllegalArgumentException());
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken7() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException())
        .when(customerImpl)
        .setUnencodedPassword(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken8() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.encode(Mockito.<CharSequence>any()))
        .thenThrow(new IllegalArgumentException());
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl).isDeactivated();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken9() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customerImpl).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    doNothing().when(customerForgotPasswordSecurityToken).setTokenUsedFlag(anyBoolean());
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenThrow(new IllegalArgumentException());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerForgotPasswordSecurityTokenDao, atLeast(1)).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerForgotPasswordSecurityToken).setTokenUsedFlag(true);
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl).isDeactivated();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setChallengeAnswer("secret");
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken10() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn(null);
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    doNothing().when(customerForgotPasswordSecurityToken).setTokenUsedFlag(anyBoolean());
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerForgotPasswordSecurityTokenDao, atLeast(1)).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerForgotPasswordSecurityToken).setTokenUsedFlag(true);
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl).isDeactivated();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken11() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getUsername()).thenReturn(null);
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    doNothing().when(customerImpl).setUsername(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerById(1L);
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).getUsername();
    verify(customerImpl).isDeactivated();
    verify(customerImpl).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(customerImpl).setUsername("1");
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#readCustomerById(Long)} return {@link
   *       CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_givenCustomerDaoReadCustomerByIdReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getUsername()).thenReturn(null);
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    doNothing().when(customerImpl).setUsername(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            customerServiceImpl.resetPasswordUsingToken(
                "janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerById(1L);
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).getUsername();
    verify(customerImpl).isDeactivated();
    verify(customerImpl).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(customerImpl).setUsername("1");
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#readCustomerById(Long)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_givenCustomerDaoReadCustomerByIdReturnNull() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customerImpl).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.getUsername()).thenReturn(null);
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    doNothing().when(customerImpl).setUsername(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(null);
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    doNothing().when(customerForgotPasswordSecurityToken).setTokenUsedFlag(anyBoolean());
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerById(1L);
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerForgotPasswordSecurityTokenDao, atLeast(1)).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerForgotPasswordSecurityToken).setTokenUsedFlag(true);
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl).isDeactivated();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setChallengeAnswer("secret");
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(customerImpl).setUsername("1");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getChallengeAnswer()} return {@code
   *       secret}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_givenCustomerImplGetChallengeAnswerReturnSecret() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("secret");
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    doNothing().when(customerForgotPasswordSecurityToken).setTokenUsedFlag(anyBoolean());
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerForgotPasswordSecurityTokenDao, atLeast(1)).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerForgotPasswordSecurityToken).setTokenUsedFlag(true);
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl).isDeactivated();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getId()} return fourteen.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_givenCustomerImplGetIdReturnFourteen() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(14L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult =
        customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(14L);
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    assertEquals(1, actualResetPasswordUsingTokenResult.getErrorCodesList().size());
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getUnencodedPassword()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_givenCustomerImplGetUnencodedPasswordReturnNull() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customerImpl).setChallengeAnswer(Mockito.<String>any());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn(null);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    doNothing().when(customerForgotPasswordSecurityToken).setTokenUsedFlag(anyBoolean());
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerForgotPasswordSecurityTokenDao, atLeast(1)).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerForgotPasswordSecurityToken).setTokenUsedFlag(true);
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl).isDeactivated();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setChallengeAnswer("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(passwordEncoder).encode(isA(CharSequence.class));
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#isRegistered()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_givenCustomerImplIsRegisteredReturnFalse() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customerImpl).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.isRegistered()).thenReturn(false);
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    doNothing().when(customerForgotPasswordSecurityToken).setTokenUsedFlag(anyBoolean());
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerForgotPasswordSecurityTokenDao, atLeast(1)).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerForgotPasswordSecurityToken).setTokenUsedFlag(true);
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl).isDeactivated();
    verify(customerImpl).isRegistered();
    verify(customerImpl).setChallengeAnswer("secret");
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#matches(CharSequence, String)}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_givenPasswordEncoderMatchesReturnFalse() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult =
        customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setChallengeAnswer(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_thenCallsSetChallengeAnswer() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customerImpl).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customerImpl).setPassword(Mockito.<String>any());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    doNothing().when(customerForgotPasswordSecurityToken).setTokenUsedFlag(anyBoolean());
    when(customerForgotPasswordSecurityToken.getCustomerId()).thenReturn(1L);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityToken.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerDao).save(isA(Customer.class));
    verify(customerForgotPasswordSecurityTokenDao, atLeast(1)).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerForgotPasswordSecurityToken).getCreateDate();
    verify(customerForgotPasswordSecurityToken).getCustomerId();
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerForgotPasswordSecurityToken).setTokenUsedFlag(true);
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl).isDeactivated();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setChallengeAnswer("secret");
    verify(customerImpl).setPassword("secret");
    verify(customerImpl).setPasswordChangeRequired(false);
    verify(customerImpl).setUnencodedPassword("iloveyou");
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code emailNotFound}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsEmailNotFound() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());

    // Act
    GenericResponse actualResetPasswordUsingTokenResult =
        customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code inactiveUser}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsInactiveUser() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult =
        customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code invalidToken}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsInvalidToken() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    GenericResponse actualResetPasswordUsingTokenResult =
        customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(1L);
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getId();
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code tokenUsed}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsTokenUsed() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken =
        mock(CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenReturn(true);
    when(customerForgotPasswordSecurityToken.getToken()).thenReturn("ABC123");

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityToken);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult =
        customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(1L);
    verify(customerForgotPasswordSecurityToken).getToken();
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("tokenUsed", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return ErrorCodesList second is {@code passwordMismatch}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_thenReturnErrorCodesListSecondIsPasswordMismatch() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult =
        customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "Password", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertEquals("passwordMismatch", errorCodesList.get(1));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return ErrorCodesList size is two.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_thenReturnErrorCodesListSizeIsTwo() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult =
        customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", " ");

    // Assert
    verify(customerDao).readCustomerByUsername("janedoe");
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorCodesList size is three.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_whenNull_thenReturnErrorCodesListSizeIsThree() {
    // Arrange, Act and Assert
    List<String> errorCodesList =
        customerServiceImpl.resetPasswordUsingToken(null, " ", " ", " ").getErrorCodesList();
    assertEquals(3, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertEquals("invalidToken", errorCodesList.get(2));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorCodesList size is three.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_whenNull_thenReturnErrorCodesListSizeIsThree2() {
    // Arrange, Act and Assert
    List<String> errorCodesList =
        customerServiceImpl.resetPasswordUsingToken(null, null, " ", " ").getErrorCodesList();
    assertEquals(3, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertEquals("invalidToken", errorCodesList.get(2));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorCodesList size is two.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"
  })
  public void testResetPasswordUsingToken_whenNull_thenReturnErrorCodesListSizeIsTwo() {
    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult =
        customerServiceImpl.resetPasswordUsingToken(null, "ABC123", " ", " ");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.invalidateAllTokensForCustomer(Customer)"})
  public void testInvalidateAllTokensForCustomer() {
    // Arrange
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.invalidateAllTokensForCustomer(new CustomerImpl()));
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.invalidateAllTokensForCustomer(Customer)"})
  public void testInvalidateAllTokensForCustomer2() {
    // Arrange
    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenThrow(new IllegalArgumentException());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> customerServiceImpl.invalidateAllTokensForCustomer(new CustomerImpl()));
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
  }

  /**
   * Test {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       CustomerForgotPasswordSecurityTokenDao#readUnusedTokensByCustomerId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.invalidateAllTokensForCustomer(Customer)"})
  public void testInvalidateAllTokensForCustomer_thenCallsReadUnusedTokensByCustomerId() {
    // Arrange
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    customerServiceImpl.invalidateAllTokensForCustomer(new CustomerImpl());

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       CustomerForgotPasswordSecurityTokenDao#saveToken(CustomerForgotPasswordSecurityToken)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.invalidateAllTokensForCustomer(Customer)"})
  public void testInvalidateAllTokensForCustomer_thenCallsSaveToken() {
    // Arrange
    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList =
        new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.saveToken(
            Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);

    // Act
    customerServiceImpl.invalidateAllTokensForCustomer(new CustomerImpl());

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityTokenDao)
        .saveToken(isA(CustomerForgotPasswordSecurityToken.class));
  }

  /**
   * Test {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#isDeactivated()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.checkCustomer(Customer, GenericResponse)"})
  public void testCheckCustomer_givenFalse_whenCustomerImplIsDeactivatedReturnFalse() {
    // Arrange
    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.isDeactivated()).thenReturn(false);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkCustomer(customer, response);

    // Assert that nothing has changed
    verify(customer).getEmailAddress();
    verify(customer).isDeactivated();
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>Then calls {@link Customer#getEmailAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.checkCustomer(Customer, GenericResponse)"})
  public void testCheckCustomer_givenSpace_thenCallsGetEmailAddress() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getEmailAddress()).thenReturn(" ");
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkCustomer(customer, response);

    // Assert
    verify(customer).getEmailAddress();
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code
   *       inactiveUser}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.checkCustomer(Customer, GenericResponse)"})
  public void testCheckCustomer_givenTrue_thenGenericResponseErrorCodesListFirstIsInactiveUser() {
    // Arrange
    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.isDeactivated()).thenReturn(true);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkCustomer(customer, response);

    // Assert
    verify(customer).getEmailAddress();
    verify(customer).isDeactivated();
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}.
   *
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code
   *       invalidCustomer}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.checkCustomer(Customer, GenericResponse)"})
  public void testCheckCustomer_thenGenericResponseErrorCodesListFirstIsInvalidCustomer() {
    // Arrange
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkCustomer(null, response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}.
   *
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.checkCustomer(Customer, GenericResponse)"})
  public void testCheckCustomer_whenCustomerImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkCustomer(customer, response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}.
   *
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code
   *       invalidPassword}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPassword(String, String,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsInvalidPassword() {
    // Arrange
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkPassword(" ", "iloveyou", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}.
   *
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code
   *       invalidPassword}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPassword(String, String,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsInvalidPassword2() {
    // Arrange
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkPassword("iloveyou", " ", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}.
   *
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code
   *       passwordMismatch}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPassword(String, String,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsPasswordMismatch() {
    // Arrange
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkPassword("Password", "iloveyou", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("passwordMismatch", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPassword(String, String,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_whenEmptyString() {
    // Arrange
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkPassword("", "iloveyou", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}.
   *
   * <ul>
   *   <li>When {@link GenericResponse} (default constructor).
   *   <li>Then not {@link GenericResponse} (default constructor) HasErrors.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#checkPassword(String, String,
   * GenericResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_whenGenericResponse_thenNotGenericResponseHasErrors() {
    // Arrange
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkPassword("iloveyou", "iloveyou", response);

    // Assert that nothing has changed
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}.
   *
   * <p>Method under test: {@link
   * CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.isTokenExpired(CustomerForgotPasswordSecurityToken)"
  })
  public void testIsTokenExpired() {
    // Arrange
    CustomerForgotPasswordSecurityToken fpst = mock(CustomerForgotPasswordSecurityToken.class);
    when(fpst.getCreateDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    customerServiceImpl.isTokenExpired(fpst);

    // Assert
    verify(fpst).getCreateDate();
  }

  /**
   * Test {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}.
   *
   * <ul>
   *   <li>Given from now atStartOfDay atZone {@link ZoneOffset#UTC} toInstant.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.isTokenExpired(CustomerForgotPasswordSecurityToken)"
  })
  public void testIsTokenExpired_givenFromNowAtStartOfDayAtZoneUtcToInstant() {
    // Arrange
    CustomerForgotPasswordSecurityToken fpst = mock(CustomerForgotPasswordSecurityToken.class);
    when(fpst.getCreateDate())
        .thenReturn(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    customerServiceImpl.isTokenExpired(fpst);

    // Assert
    verify(fpst).getCreateDate();
  }

  /**
   * Test {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CustomerServiceImpl.isTokenExpired(CustomerForgotPasswordSecurityToken)"
  })
  public void testIsTokenExpired_thenThrowIllegalArgumentException() {
    // Arrange
    CustomerForgotPasswordSecurityToken fpst = mock(CustomerForgotPasswordSecurityToken.class);
    when(fpst.getCreateDate()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.isTokenExpired(fpst));
    verify(fpst).getCreateDate();
  }

  /**
   * Test {@link CustomerServiceImpl#readBatchCustomers(int, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readBatchCustomers(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CustomerServiceImpl.readBatchCustomers(int, int)"})
  public void testReadBatchCustomers_thenReturnEmpty() {
    // Arrange
    when(customerDao.readBatchCustomers(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<Customer> actualReadBatchCustomersResult = customerServiceImpl.readBatchCustomers(1, 3);

    // Assert
    verify(customerDao).readBatchCustomers(1, 3);
    assertTrue(actualReadBatchCustomersResult.isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#readBatchCustomers(int, int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readBatchCustomers(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CustomerServiceImpl.readBatchCustomers(int, int)"})
  public void testReadBatchCustomers_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readBatchCustomers(anyInt(), anyInt()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customerServiceImpl.readBatchCustomers(1, 3));
    verify(customerDao).readBatchCustomers(1, 3);
  }

  /**
   * Test {@link CustomerServiceImpl#readNumberOfCustomers()}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readNumberOfCustomers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomerServiceImpl.readNumberOfCustomers()"})
  public void testReadNumberOfCustomers_thenReturnLongValueIsOne() {
    // Arrange
    when(customerDao.readNumberOfCustomers()).thenReturn(1L);

    // Act
    Long actualReadNumberOfCustomersResult = customerServiceImpl.readNumberOfCustomers();

    // Assert
    verify(customerDao).readNumberOfCustomers();
    assertEquals(1L, actualReadNumberOfCustomersResult.longValue());
  }

  /**
   * Test {@link CustomerServiceImpl#readNumberOfCustomers()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerServiceImpl#readNumberOfCustomers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomerServiceImpl.readNumberOfCustomers()"})
  public void testReadNumberOfCustomers_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readNumberOfCustomers()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.readNumberOfCustomers());
    verify(customerDao).readNumberOfCustomers();
  }
}
