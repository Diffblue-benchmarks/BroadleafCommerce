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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerServiceImplDiffblueTest {
  @Mock
  private BroadleafApplicationEventPublisher broadleafApplicationEventPublisher;

  @Mock
  private CustomerAddressDao customerAddressDao;

  @Mock
  private CustomerDao customerDao;

  @Mock
  private CustomerForgotPasswordSecurityTokenDao customerForgotPasswordSecurityTokenDao;

  @InjectMocks
  private CustomerServiceImpl customerServiceImpl;

  @Mock
  private IdGenerationService idGenerationService;

  @Mock
  private PasswordEncoder passwordEncoder;

  @Mock
  private RoleDao roleDao;

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(new CustomerImpl()));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer2() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    CustomerImpl customer = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException("foo")).when(customer).setPassword(Mockito.<String>any());
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
    verify(customer).setPassword(eq("secret"));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code register}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(new CustomerImpl(), true));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code register}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister2() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    CustomerImpl customer = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException("foo")).when(customer).setPassword(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.getId()).thenReturn(1L);
    when(customer.getUsername()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer, true));
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(customer).setPassword(eq("secret"));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code register}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister3() {
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
    verify(customer).setPassword(eq("secret"));
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code register}.
   * <ul>
   *   <li>Then calls {@link CustomerDao#readCustomerById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister_thenCallsReadCustomerById() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(new CustomerImpl(), true));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code register}.
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setChallengeAnswer(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    verify(customer).setChallengeAnswer(eq("secret"));
    verify(customer).setPassword(eq("secret"));
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code register}.
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister_thenCallsSetId() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    CustomerImpl customer = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException("foo")).when(customer).setId(Mockito.<Long>any());
    when(customer.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer, true));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customer).getId();
    verify(customer).setId(eq(1L));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer, boolean)} with {@code customer}, {@code register}.
   * <ul>
   *   <li>Then {@link CustomerImpl} (default constructor) MainEntityName is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer, boolean)"})
  public void testSaveCustomerWithCustomerRegister_thenCustomerImplMainEntityNameIs1() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(null);
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    CustomerImpl customer = new CustomerImpl();

    // Act
    customerServiceImpl.saveCustomer(customer, true);

    // Assert
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
    verify(customerDao).save(isA(Customer.class));
    assertEquals("1", customer.getMainEntityName());
    assertEquals("1", customer.getUsername());
    assertEquals(1L, customer.getId().longValue());
    assertTrue(customer.isRegistered());
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>Given {@code Challenge Answer}.</li>
   *   <li>Then calls {@link CustomerImpl#setChallengeAnswer(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_givenChallengeAnswer_thenCallsSetChallengeAnswer() {
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
    verify(customer).setChallengeAnswer(eq("secret"));
    verify(customer).setPassword(eq("secret"));
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then calls {@link CustomerDao#readCustomerById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_thenCallsReadCustomerById() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(new CustomerImpl()));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_thenCallsSetId() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    CustomerImpl customer = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException("foo")).when(customer).setId(Mockito.<Long>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.saveCustomer(customer));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customer).getId();
    verify(customer).isRegistered();
    verify(customer).setId(eq(1L));
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then {@link CustomerImpl} (default constructor) MainEntityName is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.saveCustomer(Customer)"})
  public void testSaveCustomerWithCustomer_thenCustomerImplMainEntityNameIs1() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(null);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    CustomerImpl customer = new CustomerImpl();

    // Act
    Customer actualSaveCustomerResult = customerServiceImpl.saveCustomer(customer);

    // Assert
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
    verify(customerDao).save(isA(Customer.class));
    assertEquals("1", customer.getMainEntityName());
    assertEquals("1", customer.getUsername());
    assertEquals(1L, customer.getId().longValue());
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#saveCustomer(Customer)} with {@code customer}.
   * <ul>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#getChallengeAnswer()} return {@code secret}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#saveCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    verify(customer).setPassword(eq("secret"));
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualSaveCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("ROLE_USER"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.registerCustomer(new CustomerImpl(), "iloveyou", "Password Confirm"));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer2() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(null);
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenThrow(new IllegalArgumentException("ROLE_USER"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.registerCustomer(new CustomerImpl(), "iloveyou", "Password Confirm"));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).readRoleByName(eq("ROLE_USER"));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   * <ul>
   *   <li>Given {@code Challenge Answer}.</li>
   *   <li>Then calls {@link Customer#setChallengeAnswer(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_givenChallengeAnswer_thenCallsSetChallengeAnswer() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());
    Customer customer = mock(Customer.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act
    Customer actualRegisterCustomerResult = customerServiceImpl.registerCustomer(customer, "iloveyou",
        "Password Confirm");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName(eq("ROLE_USER"));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setChallengeAnswer(eq("secret"));
    verify(customer).setPassword(eq("secret"));
    verify(customer).setRegistered(eq(true));
    verify(customer).setUnencodedPassword(eq("iloveyou"));
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualRegisterCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#readCustomerById(Long)} return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_givenCustomerDaoReadCustomerByIdReturnCustomerImpl() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.registerCustomer(new CustomerImpl(), "iloveyou", "Password Confirm"));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link Customer} {@link Customer#isRegistered()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_givenFalse_whenCustomerIsRegisteredReturnFalse() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());
    Customer customer = mock(Customer.class);
    when(customer.getChallengeAnswer()).thenReturn("Challenge Answer");
    doNothing().when(customer).setChallengeAnswer(Mockito.<String>any());
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(false);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act
    Customer actualRegisterCustomerResult = customerServiceImpl.registerCustomer(customer, "iloveyou",
        "Password Confirm");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName(eq("ROLE_USER"));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer).isRegistered();
    verify(customer).setChallengeAnswer(eq("secret"));
    verify(customer).setPassword(eq("secret"));
    verify(customer).setRegistered(eq(true));
    verify(customer).setUnencodedPassword(eq("iloveyou"));
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualRegisterCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code ROLE_USER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_givenIllegalArgumentExceptionWithRoleUser() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    Customer customer = mock(Customer.class);
    doThrow(new IllegalArgumentException("ROLE_USER")).when(customer).setPassword(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm"));
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setPassword(eq("secret"));
    verify(customer).setRegistered(eq(true));
    verify(customer).setUnencodedPassword(eq("iloveyou"));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   * <ul>
   *   <li>Then calls {@link Customer#setId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_thenCallsSetId() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    Customer customer = mock(Customer.class);
    doThrow(new IllegalArgumentException("foo")).when(customer).setId(Mockito.<Long>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(null);
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm"));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customer).getId();
    verify(customer).isRegistered();
    verify(customer).setId(eq(1L));
    verify(customer).setRegistered(eq(true));
    verify(customer).setUnencodedPassword(eq("iloveyou"));
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   * <ul>
   *   <li>Then {@link CustomerImpl} (default constructor) MainEntityName is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_thenCustomerImplMainEntityNameIs1() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(null);
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(new CustomerImpl());
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());
    CustomerImpl customer = new CustomerImpl();

    // Act
    customerServiceImpl.registerCustomer(customer, "iloveyou", "Password Confirm");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName(eq("ROLE_USER"));
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertEquals("1", customer.getMainEntityName());
    assertEquals("1", customer.getUsername());
    assertEquals("iloveyou", customer.getUnencodedPassword());
    assertEquals("secret", customer.getPassword());
    assertEquals(1L, customer.getId().longValue());
    assertTrue(customer.isRegistered());
  }

  /**
   * Test {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}.
   * <ul>
   *   <li>When {@link Customer} {@link Customer#getChallengeAnswer()} return {@code secret}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#registerCustomer(Customer, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.registerCustomer(Customer, String, String)"})
  public void testRegisterCustomer_whenCustomerGetChallengeAnswerReturnSecret() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());
    Customer customer = mock(Customer.class);
    when(customer.getChallengeAnswer()).thenReturn("secret");
    doNothing().when(customer).setPassword(Mockito.<String>any());
    when(customer.isRegistered()).thenReturn(true);
    when(customer.getId()).thenReturn(1L);
    when(customer.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customer.getUnencodedPassword()).thenReturn("secret");
    when(customer.getUsername()).thenReturn("janedoe");
    doNothing().when(customer).setRegistered(anyBoolean());
    doNothing().when(customer).setUnencodedPassword(Mockito.<String>any());

    // Act
    Customer actualRegisterCustomerResult = customerServiceImpl.registerCustomer(customer, "iloveyou",
        "Password Confirm");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).save(isA(Customer.class));
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName(eq("ROLE_USER"));
    verify(customer).getChallengeAnswer();
    verify(customer).getId();
    verify(customer, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customer, atLeast(1)).getUnencodedPassword();
    verify(customer).getUsername();
    verify(customer, atLeast(1)).isRegistered();
    verify(customer).setPassword(eq("secret"));
    verify(customer).setRegistered(eq(true));
    verify(customer).setUnencodedPassword(eq("iloveyou"));
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualRegisterCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#createRegisteredCustomerRoles(Customer)}.
   * <ul>
   *   <li>Then calls {@link RoleDao#addRoleToCustomer(CustomerRole)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createRegisteredCustomerRoles(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.createRegisteredCustomerRoles(Customer)"})
  public void testCreateRegisteredCustomerRoles_thenCallsAddRoleToCustomer() {
    // Arrange
    when(roleDao.readRoleByName(Mockito.<String>any())).thenReturn(new RoleImpl());
    doNothing().when(roleDao).addRoleToCustomer(Mockito.<CustomerRole>any());

    // Act
    customerServiceImpl.createRegisteredCustomerRoles(new CustomerImpl());

    // Assert
    verify(roleDao).addRoleToCustomer(isA(CustomerRole.class));
    verify(roleDao).readRoleByName(eq("ROLE_USER"));
  }

  /**
   * Test {@link CustomerServiceImpl#createRegisteredCustomerRoles(Customer)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createRegisteredCustomerRoles(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.createRegisteredCustomerRoles(Customer)"})
  public void testCreateRegisteredCustomerRoles_thenThrowIllegalArgumentException() {
    // Arrange
    when(roleDao.readRoleByName(Mockito.<String>any())).thenThrow(new IllegalArgumentException("ROLE_USER"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.createRegisteredCustomerRoles(new CustomerImpl()));
    verify(roleDao).readRoleByName(eq("ROLE_USER"));
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByEmail(String)}.
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readCustomerByEmail(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByEmail(String)"})
  public void testReadCustomerByEmail_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByEmail(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    Customer actualReadCustomerByEmailResult = customerServiceImpl.readCustomerByEmail("42 Main St");

    // Assert
    verify(customerDao).readCustomerByEmail(eq("42 Main St"));
    assertSame(customerImpl, actualReadCustomerByEmailResult);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByEmail(String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readCustomerByEmail(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByEmail(String)"})
  public void testReadCustomerByEmail_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readCustomerByEmail(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.readCustomerByEmail("42 Main St"));
    verify(customerDao).readCustomerByEmail(eq("42 Main St"));
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword2() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getUnencodedPassword()).thenReturn("secret");
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(eq(false));
    verify(customerImpl).setUnencodedPassword(isNull());
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#readCustomerById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_givenCustomerDaoReadCustomerByIdReturnNull() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(null);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act
    Customer actualChangePasswordResult = customerServiceImpl.changePassword(new PasswordChange("janedoe"));

    // Assert
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerDao).save(isA(Customer.class));
    assertSame(customerImpl, actualChangePasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getChallengeAnswer()} return {@code secret}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Customer actualChangePasswordResult = customerServiceImpl.changePassword(new PasswordChange("janedoe"));

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerDao).save(isA(Customer.class));
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPassword(eq("secret"));
    verify(customerImpl).setPasswordChangeRequired(eq(false));
    verify(customerImpl).setUnencodedPassword(isNull());
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl2, actualChangePasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   * <ul>
   *   <li>Then calls {@link CustomerDao#readCustomerById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_thenCallsReadCustomerById() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   * <ul>
   *   <li>Then calls {@link CustomerDaoImpl#readCustomerByUsername(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_thenCallsReadCustomerByUsername() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getUnencodedPassword()).thenThrow(new IllegalArgumentException("foo"));
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getId();
    verify(customerImpl).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(eq(false));
    verify(customerImpl).setUnencodedPassword(isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setChallengeAnswer(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    Customer actualChangePasswordResult = customerServiceImpl.changePassword(new PasswordChange("janedoe"));

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerDao).save(isA(Customer.class));
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl, atLeast(1)).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setChallengeAnswer(eq("secret"));
    verify(customerImpl).setPassword(eq("secret"));
    verify(customerImpl).setPasswordChangeRequired(eq(false));
    verify(customerImpl).setUnencodedPassword(isNull());
    verify(passwordEncoder, atLeast(1)).encode(isA(CharSequence.class));
    assertSame(customerImpl2, actualChangePasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#changePassword(PasswordChange)}.
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.changePassword(PasswordChange)"})
  public void testChangePassword_thenCallsSetId() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException("foo")).when(customerImpl).setId(Mockito.<Long>any());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(null);
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getId();
    verify(customerImpl).isRegistered();
    verify(customerImpl).setId(eq(1L));
    verify(customerImpl).setPasswordChangeRequired(eq(false));
    verify(customerImpl).setUnencodedPassword(isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPassword(PasswordReset)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPassword(PasswordReset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.resetPassword(PasswordReset)"})
  public void testResetPassword() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.resetPassword(new PasswordReset("janedoe")));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPassword(PasswordReset)}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#readCustomerById(Long)} return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPassword(PasswordReset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.resetPassword(PasswordReset)"})
  public void testResetPassword_givenCustomerDaoReadCustomerByIdReturnCustomerImpl() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.resetPassword(new PasswordReset("janedoe")));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPassword(PasswordReset)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then calls {@link PasswordReset#getPasswordChangeRequired()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPassword(PasswordReset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.resetPassword(PasswordReset)"})
  public void testResetPassword_givenZero_thenCallsGetPasswordChangeRequired() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    doThrow(new IllegalArgumentException("foo")).when(customerImpl).setId(Mockito.<Long>any());
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(null);
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    PasswordReset passwordReset = mock(PasswordReset.class);
    when(passwordReset.getPasswordChangeRequired()).thenReturn(true);
    when(passwordReset.getPasswordLength()).thenReturn(0);
    when(passwordReset.getUsername()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.resetPassword(passwordReset));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(passwordReset).getPasswordChangeRequired();
    verify(passwordReset).getPasswordLength();
    verify(passwordReset).getUsername();
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getId();
    verify(customerImpl).isRegistered();
    verify(customerImpl).setId(eq(1L));
    verify(customerImpl).setPasswordChangeRequired(eq(true));
    verify(customerImpl).setUnencodedPassword(eq(""));
  }

  /**
   * Test {@link CustomerServiceImpl#resetPassword(PasswordReset)}.
   * <ul>
   *   <li>Then calls {@link CustomerDao#readCustomerById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPassword(PasswordReset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.resetPassword(PasswordReset)"})
  public void testResetPassword_thenCallsReadCustomerById() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(null);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    Customer actualResetPasswordResult = customerServiceImpl.resetPassword(new PasswordReset("janedoe"));

    // Assert
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).readCustomerById(eq(1L));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerDao).save(isA(Customer.class));
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertSame(customerImpl, actualResetPasswordResult);
  }

  /**
   * Test {@link CustomerServiceImpl#addPostRegisterListener(PostRegistrationObserver)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#addPostRegisterListener(PostRegistrationObserver)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.addPostRegisterListener(PostRegistrationObserver)"})
  public void testAddPostRegisterListener() {
    // Arrange
    PostRegistrationObserver postRegisterListeners = mock(PostRegistrationObserver.class);

    // Act
    customerServiceImpl.addPostRegisterListener(postRegisterListeners);

    // Assert
    List<PostRegistrationObserver> postRegistrationObserverList = customerServiceImpl.postRegisterListeners;
    assertEquals(1, postRegistrationObserverList.size());
    assertSame(postRegisterListeners, postRegistrationObserverList.get(0));
  }

  /**
   * Test {@link CustomerServiceImpl#notifyPostRegisterListeners(Customer)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#notifyPostRegisterListeners(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.notifyPostRegisterListeners(Customer)"})
  public void testNotifyPostRegisterListeners() {
    // Arrange
    PostRegistrationObserver postRegisterListeners = mock(PostRegistrationObserver.class);
    doNothing().when(postRegisterListeners).processRegistrationEvent(Mockito.<Customer>any());

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.addPostRegisterListener(postRegisterListeners);

    // Act
    customerServiceImpl.notifyPostRegisterListeners(new CustomerImpl());

    // Assert
    verify(postRegisterListeners).processRegistrationEvent(isA(Customer.class));
  }

  /**
   * Test {@link CustomerServiceImpl#notifyPostRegisterListeners(Customer)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#notifyPostRegisterListeners(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.notifyPostRegisterListeners(Customer)"})
  public void testNotifyPostRegisterListeners_thenThrowIllegalArgumentException() {
    // Arrange
    PostRegistrationObserver postRegisterListeners = mock(PostRegistrationObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(postRegisterListeners)
        .processRegistrationEvent(Mockito.<Customer>any());

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.addPostRegisterListener(postRegisterListeners);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.notifyPostRegisterListeners(new CustomerImpl()));
    verify(postRegisterListeners).processRegistrationEvent(isA(Customer.class));
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomer()}.
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createCustomer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomer()"})
  public void testCreateCustomer_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.create()).thenReturn(customerImpl);
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act
    Customer actualCreateCustomerResult = customerServiceImpl.createCustomer();

    // Assert
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).create();
    assertSame(customerImpl, actualCreateCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomer()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createCustomer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomer()"})
  public void testCreateCustomer_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.create()).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.createCustomer());
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerWithNullId()}.
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createCustomerWithNullId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createCustomerWithNullId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerWithNullId()"})
  public void testCreateCustomerWithNullId_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.create()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.createCustomerWithNullId());
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerFromId(Long)}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#readCustomerById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    verify(customerDao).readCustomerById(eq(1L));
    assertSame(customerImpl, actualCreateCustomerFromIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerFromId(Long)}.
   * <ul>
   *   <li>Then calls {@link IdGenerationService#findNextId(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerFromId(Long)"})
  public void testCreateCustomerFromId_thenCallsFindNextId() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.create()).thenReturn(customerImpl);
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act
    Customer actualCreateCustomerFromIdResult = customerServiceImpl.createCustomerFromId(null);

    // Assert
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).create();
    assertSame(customerImpl, actualCreateCustomerFromIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerFromId(Long)}.
   * <ul>
   *   <li>Then calls {@link CustomerDao#readCustomerById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerFromId(Long)"})
  public void testCreateCustomerFromId_thenCallsReadCustomerById() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(customerImpl);

    // Act
    Customer actualCreateCustomerFromIdResult = customerServiceImpl.createCustomerFromId(1L);

    // Assert
    verify(customerDao).readCustomerById(eq(1L));
    assertSame(customerImpl, actualCreateCustomerFromIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#createCustomerFromId(Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.createCustomerFromId(Long)"})
  public void testCreateCustomerFromId_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.create()).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.createCustomerFromId(null));
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#findNextCustomerId()}.
   * <ul>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#findNextCustomerId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long CustomerServiceImpl.findNextCustomerId()"})
  public void testFindNextCustomerId_thenReturnLongValueIsOne() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act
    Long actualFindNextCustomerIdResult = customerServiceImpl.findNextCustomerId();

    // Assert
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    assertEquals(1L, actualFindNextCustomerIdResult.longValue());
  }

  /**
   * Test {@link CustomerServiceImpl#findNextCustomerId()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#findNextCustomerId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long CustomerServiceImpl.findNextCustomerId()"})
  public void testFindNextCustomerId_thenThrowIllegalArgumentException() {
    // Arrange
    when(idGenerationService.findNextId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.findNextCustomerId());
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
  }

  /**
   * Test {@link CustomerServiceImpl#createNewCustomer()}.
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createNewCustomer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.createNewCustomer()"})
  public void testCreateNewCustomer_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.create()).thenReturn(customerImpl);
    when(idGenerationService.findNextId(Mockito.<String>any())).thenReturn(1L);

    // Act
    Customer actualCreateNewCustomerResult = customerServiceImpl.createNewCustomer();

    // Assert
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).create();
    assertSame(customerImpl, actualCreateNewCustomerResult);
  }

  /**
   * Test {@link CustomerServiceImpl#createNewCustomer()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#createNewCustomer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.createNewCustomer()"})
  public void testCreateNewCustomer_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.create()).thenReturn(new CustomerImpl());
    when(idGenerationService.findNextId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.createNewCustomer());
    verify(idGenerationService).findNextId(eq("org.broadleafcommerce.profile.core.domain.Customer"));
    verify(customerDao).create();
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(Customer)}.
   * <ul>
   *   <li>Given {@link CustomerAddressDao}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#deleteCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(Customer)"})
  public void testDeleteCustomer_givenCustomerAddressDao_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(roleDao).removeCustomerRolesByCustomerId(Mockito.<Long>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.deleteCustomer(new CustomerImpl()));
    verify(roleDao).removeCustomerRolesByCustomerId(isNull());
  }

  /**
   * Test {@link CustomerServiceImpl#deleteCustomer(Customer)}.
   * <ul>
   *   <li>Then calls {@link CustomerAddressDao#hardDeleteCustomerAddressesForCustomer(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#deleteCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.deleteCustomer(Customer)"})
  public void testDeleteCustomer_thenCallsHardDeleteCustomerAddressesForCustomer() {
    // Arrange
    doNothing().when(customerAddressDao).hardDeleteCustomerAddressesForCustomer(Mockito.<Long>any());
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
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#detach(Customer)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#detachCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#detachCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.detachCustomer(Customer)"})
  public void testDetachCustomer_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(customerDao).detach(Mockito.<Customer>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.detachCustomer(new CustomerImpl()));
    verify(customerDao).detach(isA(Customer.class));
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByUsername(String, Boolean)} with {@code username}, {@code cacheable}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#readCustomerByUsername(String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByUsername(String, Boolean)"})
  public void testReadCustomerByUsernameWithUsernameCacheable() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any(), Mockito.<Boolean>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.readCustomerByUsername("janedoe", true));
    verify(customerDao).readCustomerByUsername(eq("janedoe"), eq(true));
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByUsername(String, Boolean)} with {@code username}, {@code cacheable}.
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readCustomerByUsername(String, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByUsername(String, Boolean)"})
  public void testReadCustomerByUsernameWithUsernameCacheable_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByUsername(Mockito.<String>any(), Mockito.<Boolean>any())).thenReturn(customerImpl);

    // Act
    Customer actualReadCustomerByUsernameResult = customerServiceImpl.readCustomerByUsername("janedoe", true);

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"), eq(true));
    assertSame(customerImpl, actualReadCustomerByUsernameResult);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByUsername(String)} with {@code username}.
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readCustomerByUsername(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByUsername(String)"})
  public void testReadCustomerByUsernameWithUsername_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    Customer actualReadCustomerByUsernameResult = customerServiceImpl.readCustomerByUsername("janedoe");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    assertSame(customerImpl, actualReadCustomerByUsernameResult);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByUsername(String)} with {@code username}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readCustomerByUsername(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByUsername(String)"})
  public void testReadCustomerByUsernameWithUsername_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.readCustomerByUsername("janedoe"));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerById(Long)}.
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readCustomerById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerById(Long)"})
  public void testReadCustomerById_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(customerImpl);

    // Act
    Customer actualReadCustomerByIdResult = customerServiceImpl.readCustomerById(1L);

    // Assert
    verify(customerDao).readCustomerById(eq(1L));
    assertSame(customerImpl, actualReadCustomerByIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerById(Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readCustomerById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerById(Long)"})
  public void testReadCustomerById_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.readCustomerById(1L));
    verify(customerDao).readCustomerById(eq(1L));
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByExternalId(String)}.
   * <ul>
   *   <li>Then return {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readCustomerByExternalId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByExternalId(String)"})
  public void testReadCustomerByExternalId_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByExternalId(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    Customer actualReadCustomerByExternalIdResult = customerServiceImpl.readCustomerByExternalId("42");

    // Assert
    verify(customerDao).readCustomerByExternalId(eq("42"));
    assertSame(customerImpl, actualReadCustomerByExternalIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#readCustomerByExternalId(String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readCustomerByExternalId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Customer CustomerServiceImpl.readCustomerByExternalId(String)"})
  public void testReadCustomerByExternalId_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readCustomerByExternalId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.readCustomerByExternalId("42"));
    verify(customerDao).readCustomerByExternalId(eq("42"));
  }

  /**
   * Test {@link CustomerServiceImpl#encodePassword(String)}.
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#encode(CharSequence)} return {@code secret}.</li>
   *   <li>Then return {@code secret}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#encodePassword(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#encodePassword(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomerServiceImpl.encodePassword(String)"})
  public void testEncodePassword_thenThrowIllegalArgumentException() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.encodePassword("iloveyou"));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#isPasswordValid(String, String)}.
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#matches(CharSequence, String)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#isPasswordValid(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.isPasswordValid(String, String)"})
  public void testIsPasswordValid_givenPasswordEncoderMatchesReturnFalse_thenReturnFalse() {
    // Arrange
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualIsPasswordValidResult = customerServiceImpl.isPasswordValid("iloveyou", "secret");

    // Assert
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("secret"));
    assertFalse(actualIsPasswordValidResult);
  }

  /**
   * Test {@link CustomerServiceImpl#isPasswordValid(String, String)}.
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#matches(CharSequence, String)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#isPasswordValid(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.isPasswordValid(String, String)"})
  public void testIsPasswordValid_givenPasswordEncoderMatchesReturnTrue_thenReturnTrue() {
    // Arrange
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsPasswordValidResult = customerServiceImpl.isPasswordValid("iloveyou", "secret");

    // Assert
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("secret"));
    assertTrue(actualIsPasswordValidResult);
  }

  /**
   * Test {@link CustomerServiceImpl#isPasswordValid(String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#isPasswordValid(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.isPasswordValid(String, String)"})
  public void testIsPasswordValid_thenThrowIllegalArgumentException() {
    // Arrange
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.isPasswordValid("iloveyou", "secret"));
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("secret"));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertTrue(customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule2() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("getProductAttributes()[UU]")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule3() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer,
        new CustomerRuleHolder("getCategoryAttributesMap()[UU]")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule4() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("getSkuAttributes()[UU]")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule5() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer,
        new CustomerRuleHolder("getOrderItemAttributes()[UU]")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule6() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer,
        new CustomerRuleHolder("getCustomerAttributes()[UU]")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule7() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer,
        new CustomerRuleHolder("getAdditionalAttributes()[UU]")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule8() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("getAdditionalFields()[UU]")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule9() {
    // Arrange, Act and Assert
    assertFalse(
        customerServiceImpl.customerPassesCustomerRule(null, new CustomerRuleHolder("getProductAttributes()[UU]")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <ul>
   *   <li>Given {@link CustomerServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule_givenCustomerServiceImpl() {
    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("getProductAttributes")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <ul>
   *   <li>When {@link CustomerRuleHolder#CustomerRuleHolder(String)} with customerRule is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule_whenCustomerRuleHolderWithCustomerRuleIs42() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("42")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <ul>
   *   <li>When {@link CustomerRuleHolder#CustomerRuleHolder(String)} with customerRule is {@code customer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule_whenCustomerRuleHolderWithCustomerRuleIsCustomer() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("customer")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <ul>
   *   <li>When {@link CustomerRuleHolder#CustomerRuleHolder(String)} with customerRule is {@code customer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule_whenCustomerRuleHolderWithCustomerRuleIsCustomer2() {
    // Arrange, Act and Assert
    assertTrue(customerServiceImpl.customerPassesCustomerRule(null, new CustomerRuleHolder("customer")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <ul>
   *   <li>When {@link CustomerRuleHolder#CustomerRuleHolder(String)} with customerRule is {@code MVEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule_whenCustomerRuleHolderWithCustomerRuleIsMvel() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("MVEL")));
  }

  /**
   * Test {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}.
   * <ul>
   *   <li>When {@link CustomerRuleHolder#CustomerRuleHolder(String)} with customerRule is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.customerPassesCustomerRule(Customer, CustomerRuleHolder)"})
  public void testCustomerPassesCustomerRule_whenCustomerRuleHolderWithCustomerRuleIsNull() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertTrue(customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder(null)));
  }

  /**
   * Test {@link CustomerServiceImpl#buildCustomerRuleParams(Customer)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#buildCustomerRuleParams(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map CustomerServiceImpl.buildCustomerRuleParams(Customer)"})
  public void testBuildCustomerRuleParams() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act
    Map<String, Object> actualBuildCustomerRuleParamsResult = customerServiceImpl.buildCustomerRuleParams(customer);

    // Assert
    assertEquals(1, actualBuildCustomerRuleParamsResult.size());
    Object getResult = actualBuildCustomerRuleParamsResult.get("customer");
    assertTrue(getResult instanceof CustomerImpl);
    assertSame(customer, getResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CustomerServiceImpl.getPasswordChangedHandlers()",
      "List CustomerServiceImpl.getPasswordResetHandlers()", "int CustomerServiceImpl.getPasswordTokenLength()",
      "int CustomerServiceImpl.getTokenExpiredMinutes()", "void CustomerServiceImpl.setCustomerDao(CustomerDao)",
      "void CustomerServiceImpl.setPasswordChangedHandlers(List)",
      "void CustomerServiceImpl.setPasswordResetHandlers(List)", "void CustomerServiceImpl.setPasswordTokenLength(int)",
      "void CustomerServiceImpl.setTokenExpiredMinutes(int)"})
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
    List<PasswordUpdatedHandler> actualPasswordChangedHandlers = customerServiceImpl.getPasswordChangedHandlers();
    List<PasswordUpdatedHandler> actualPasswordResetHandlers = customerServiceImpl.getPasswordResetHandlers();
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
   * <ul>
   *   <li>Given {@link CustomerDao}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_givenCustomerDao_whenNull() {
    // Arrange and Act
    GenericResponse actualSendForgotUsernameNotificationResult = customerServiceImpl
        .sendForgotUsernameNotification(null);

    // Assert
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("notFound", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code inactiveUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_thenReturnErrorCodesListFirstIsInactiveUser() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(customerImpl);
    when(customerDao.readCustomersByEmail(Mockito.<String>any())).thenReturn(customerList);

    // Act
    GenericResponse actualSendForgotUsernameNotificationResult = customerServiceImpl
        .sendForgotUsernameNotification("42 Main St");

    // Assert
    verify(customerDao).readCustomersByEmail(eq("42 Main St"));
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code notFound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_thenReturnErrorCodesListFirstIsNotFound() {
    // Arrange
    when(customerDao.readCustomersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    GenericResponse actualSendForgotUsernameNotificationResult = customerServiceImpl
        .sendForgotUsernameNotification("42 Main St");

    // Assert
    verify(customerDao).readCustomersByEmail(eq("42 Main St"));
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("notFound", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}.
   * <ul>
   *   <li>Then return not HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotUsernameNotification(String)"})
  public void testSendForgotUsernameNotification_thenReturnNotHasErrors() {
    // Arrange
    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(new CustomerImpl());
    when(customerDao.readCustomersByEmail(Mockito.<String>any())).thenReturn(customerList);
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());

    // Act
    GenericResponse actualSendForgotUsernameNotificationResult = customerServiceImpl
        .sendForgotUsernameNotification("42 Main St");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomersByEmail(eq("42 Main St"));
    assertFalse(actualSendForgotUsernameNotificationResult.getHasErrors());
    assertTrue(actualSendForgotUsernameNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"})
  public void testSendForgotPasswordNotification() {
    // Arrange
    customerServiceImpl.setPasswordTokenLength(0);

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult = customerServiceImpl
        .sendForgotPasswordNotification(null, "");

    // Assert
    List<String> errorCodesList = actualSendForgotPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertTrue(actualSendForgotPasswordNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code emailNotFound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"})
  public void testSendForgotPasswordNotification_thenReturnErrorCodesListFirstIsEmailNotFound() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult = customerServiceImpl
        .sendForgotPasswordNotification("janedoe", "https://example.org/example");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    List<String> errorCodesList = actualSendForgotPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(actualSendForgotPasswordNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code inactiveUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"})
  public void testSendForgotPasswordNotification_thenReturnErrorCodesListFirstIsInactiveUser() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult = customerServiceImpl
        .sendForgotPasswordNotification("janedoe", "https://example.org/example");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualSendForgotPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualSendForgotPasswordNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   * <ul>
   *   <li>Then return not HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"})
  public void testSendForgotPasswordNotification_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult = customerServiceImpl
        .sendForgotPasswordNotification("janedoe", "https://example.org/example");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForgotPasswordNotificationResult.getHasErrors());
    assertTrue(actualSendForgotPasswordNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"})
  public void testSendForgotPasswordNotification_thenThrowIllegalArgumentException() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated())
        .thenThrow(new IllegalArgumentException("ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789"));
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.sendForgotPasswordNotification("janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return not HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"})
  public void testSendForgotPasswordNotification_whenEmptyString_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult = customerServiceImpl
        .sendForgotPasswordNotification("janedoe", "");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForgotPasswordNotificationResult.getHasErrors());
    assertTrue(actualSendForgotPasswordNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"})
  public void testSendForgotPasswordNotification_whenNull_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult = customerServiceImpl
        .sendForgotPasswordNotification("janedoe", null);

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForgotPasswordNotificationResult.getHasErrors());
    assertTrue(actualSendForgotPasswordNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}.
   * <ul>
   *   <li>When {@code ?}.</li>
   *   <li>Then return not HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForgotPasswordNotification(String, String)"})
  public void testSendForgotPasswordNotification_whenQuestionMark_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult = customerServiceImpl
        .sendForgotPasswordNotification("janedoe", "?");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForgotPasswordNotificationResult.getHasErrors());
    assertTrue(actualSendForgotPasswordNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"})
  public void testSendForcedPasswordChangeNotification() {
    // Arrange
    customerServiceImpl.setPasswordTokenLength(0);

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult = customerServiceImpl
        .sendForcedPasswordChangeNotification(null, null);

    // Assert
    List<String> errorCodesList = actualSendForcedPasswordChangeNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"})
  public void testSendForcedPasswordChangeNotification2() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult = customerServiceImpl
        .sendForcedPasswordChangeNotification("janedoe", "https://example.org/example");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    List<String> errorCodesList = actualSendForcedPasswordChangeNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"})
  public void testSendForcedPasswordChangeNotification3() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult = customerServiceImpl
        .sendForcedPasswordChangeNotification("janedoe", "https://example.org/example");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualSendForcedPasswordChangeNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   * <ul>
   *   <li>Then return not HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"})
  public void testSendForcedPasswordChangeNotification_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult = customerServiceImpl
        .sendForcedPasswordChangeNotification("janedoe", "https://example.org/example");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"})
  public void testSendForcedPasswordChangeNotification_thenThrowIllegalArgumentException() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated())
        .thenThrow(new IllegalArgumentException("ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789"));
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.sendForcedPasswordChangeNotification("janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return not HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"})
  public void testSendForcedPasswordChangeNotification_whenEmptyString_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult = customerServiceImpl
        .sendForcedPasswordChangeNotification("janedoe", "");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"})
  public void testSendForcedPasswordChangeNotification_whenNull_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult = customerServiceImpl
        .sendForcedPasswordChangeNotification("janedoe", null);

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}.
   * <ul>
   *   <li>When {@code ?}.</li>
   *   <li>Then return not HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.sendForcedPasswordChangeNotification(String, String)"})
  public void testSendForcedPasswordChangeNotification_whenQuestionMark_thenReturnNotHasErrors() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    when(customerForgotPasswordSecurityTokenDao.saveToken(Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    doNothing().when(broadleafApplicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act
    GenericResponse actualSendForcedPasswordChangeNotificationResult = customerServiceImpl
        .sendForcedPasswordChangeNotification("janedoe", "?");

    // Assert
    verify(broadleafApplicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).saveToken(isA(CustomerForgotPasswordSecurityToken.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).isDeactivated();
    verify(passwordEncoder).encode(isA(CharSequence.class));
    assertFalse(actualSendForcedPasswordChangeNotificationResult.getHasErrors());
    assertTrue(actualSendForcedPasswordChangeNotificationResult.getErrorCodesList().isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token}, {@code customer}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"})
  public void testCheckPasswordResetTokenWithTokenCustomer() {
    // Arrange and Act
    GenericResponse actualCheckPasswordResetTokenResult = customerServiceImpl.checkPasswordResetToken(null, null);

    // Assert
    List<String> errorCodesList = actualCheckPasswordResetTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualCheckPasswordResetTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token}, {@code customer}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"})
  public void testCheckPasswordResetTokenWithTokenCustomer2() {
    // Arrange
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    GenericResponse actualCheckPasswordResetTokenResult = customerServiceImpl.checkPasswordResetToken("ABC123",
        new CustomerImpl());

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    List<String> errorCodesList = actualCheckPasswordResetTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualCheckPasswordResetTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token}, {@code customer}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"})
  public void testCheckPasswordResetTokenWithTokenCustomer3() {
    // Arrange
    CustomerForgotPasswordSecurityTokenImpl customerForgotPasswordSecurityTokenImpl = mock(
        CustomerForgotPasswordSecurityTokenImpl.class);
    when(customerForgotPasswordSecurityTokenImpl.isTokenUsedFlag()).thenReturn(true);
    when(customerForgotPasswordSecurityTokenImpl.getToken()).thenReturn("ABC123");

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList = new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityTokenImpl);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    GenericResponse actualCheckPasswordResetTokenResult = customerServiceImpl.checkPasswordResetToken("ABC123",
        new CustomerImpl());

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityTokenImpl).getToken();
    verify(customerForgotPasswordSecurityTokenImpl).isTokenUsedFlag();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    List<String> errorCodesList = actualCheckPasswordResetTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("tokenUsed", errorCodesList.get(0));
    assertTrue(actualCheckPasswordResetTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token}, {@code customer}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"})
  public void testCheckPasswordResetTokenWithTokenCustomer4() {
    // Arrange
    CustomerForgotPasswordSecurityTokenImpl customerForgotPasswordSecurityTokenImpl = mock(
        CustomerForgotPasswordSecurityTokenImpl.class);
    when(customerForgotPasswordSecurityTokenImpl.getToken()).thenReturn("ABC123");

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList = new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityTokenImpl);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    GenericResponse actualCheckPasswordResetTokenResult = customerServiceImpl.checkPasswordResetToken("ABC123",
        new CustomerImpl());

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityTokenImpl).getToken();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    List<String> errorCodesList = actualCheckPasswordResetTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualCheckPasswordResetTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token}, {@code customer}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"})
  public void testCheckPasswordResetTokenWithTokenCustomer5() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenThrow(new IllegalArgumentException("invalidToken"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.checkPasswordResetToken("ABC123", null));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)} with {@code token}, {@code customer}, {@code response}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"})
  public void testCheckPasswordResetTokenWithTokenCustomerResponse() {
    // Arrange
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    CustomerImpl customer = new CustomerImpl();
    GenericResponse response = new GenericResponse();

    // Act
    CustomerForgotPasswordSecurityToken actualCheckPasswordResetTokenResult = customerServiceImpl
        .checkPasswordResetToken("ABC123", customer, response);

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertNull(actualCheckPasswordResetTokenResult);
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)} with {@code token}, {@code customer}, {@code response}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"})
  public void testCheckPasswordResetTokenWithTokenCustomerResponse2() {
    // Arrange
    CustomerForgotPasswordSecurityTokenImpl customerForgotPasswordSecurityTokenImpl = mock(
        CustomerForgotPasswordSecurityTokenImpl.class);
    when(customerForgotPasswordSecurityTokenImpl.isTokenUsedFlag()).thenReturn(true);
    when(customerForgotPasswordSecurityTokenImpl.getToken()).thenReturn("ABC123");

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList = new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityTokenImpl);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);
    CustomerImpl customer = new CustomerImpl();
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkPasswordResetToken("ABC123", customer, response);

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityTokenImpl).getToken();
    verify(customerForgotPasswordSecurityTokenImpl).isTokenUsedFlag();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("tokenUsed", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)} with {@code token}, {@code customer}, {@code response}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"})
  public void testCheckPasswordResetTokenWithTokenCustomerResponse3() {
    // Arrange
    CustomerForgotPasswordSecurityTokenImpl customerForgotPasswordSecurityTokenImpl = mock(
        CustomerForgotPasswordSecurityTokenImpl.class);
    when(customerForgotPasswordSecurityTokenImpl.getToken()).thenReturn("ABC123");

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList = new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityTokenImpl);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(false);
    CustomerImpl customer = new CustomerImpl();
    GenericResponse response = new GenericResponse();

    // Act
    CustomerForgotPasswordSecurityToken actualCheckPasswordResetTokenResult = customerServiceImpl
        .checkPasswordResetToken("ABC123", customer, response);

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityTokenImpl).getToken();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertNull(actualCheckPasswordResetTokenResult);
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)} with {@code token}, {@code customer}, {@code response}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"})
  public void testCheckPasswordResetTokenWithTokenCustomerResponse4() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    GenericResponse response = new GenericResponse();

    // Act
    CustomerForgotPasswordSecurityToken actualCheckPasswordResetTokenResult = customerServiceImpl
        .checkPasswordResetToken(null, customer, response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertNull(actualCheckPasswordResetTokenResult);
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)} with {@code token}, {@code customer}, {@code response}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"})
  public void testCheckPasswordResetTokenWithTokenCustomerResponse5() {
    // Arrange
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenThrow(new IllegalArgumentException("invalidToken"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.checkPasswordResetToken("ABC123", null, new GenericResponse()));
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)} with {@code token}, {@code customer}, {@code response}.
   * <ul>
   *   <li>Then calls {@link CustomerForgotPasswordSecurityTokenImpl#getCreateDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"})
  public void testCheckPasswordResetTokenWithTokenCustomerResponse_thenCallsGetCreateDate() {
    // Arrange
    CustomerForgotPasswordSecurityTokenImpl customerForgotPasswordSecurityTokenImpl = mock(
        CustomerForgotPasswordSecurityTokenImpl.class);
    when(customerForgotPasswordSecurityTokenImpl.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityTokenImpl.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityTokenImpl.getCreateDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList = new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityTokenImpl);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);
    CustomerImpl customer = new CustomerImpl();

    // Act
    customerServiceImpl.checkPasswordResetToken("ABC123", customer, new GenericResponse());

    // Assert that nothing has changed
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityTokenImpl).getCreateDate();
    verify(customerForgotPasswordSecurityTokenImpl).getToken();
    verify(customerForgotPasswordSecurityTokenImpl).isTokenUsedFlag();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)} with {@code token}, {@code customer}, {@code response}.
   * <ul>
   *   <li>Then calls {@link CustomerForgotPasswordSecurityTokenDao#readToken(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"})
  public void testCheckPasswordResetTokenWithTokenCustomerResponse_thenCallsReadToken() {
    // Arrange
    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken = mock(
        CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenThrow(new IllegalArgumentException("foo"));
    when(customerForgotPasswordSecurityTokenDao.readToken(Mockito.<String>any()))
        .thenReturn(customerForgotPasswordSecurityToken);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.checkPasswordResetToken("ABC123", null, new GenericResponse()));
    verify(customerForgotPasswordSecurityTokenDao).readToken(eq("secret"));
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)} with {@code token}, {@code customer}, {@code response}.
   * <ul>
   *   <li>When space.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "CustomerForgotPasswordSecurityToken CustomerServiceImpl.checkPasswordResetToken(String, Customer, GenericResponse)"})
  public void testCheckPasswordResetTokenWithTokenCustomerResponse_whenSpace() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    GenericResponse response = new GenericResponse();

    // Act
    CustomerForgotPasswordSecurityToken actualCheckPasswordResetTokenResult = customerServiceImpl
        .checkPasswordResetToken(" ", customer, response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertNull(actualCheckPasswordResetTokenResult);
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token}, {@code customer}.
   * <ul>
   *   <li>Then calls {@link CustomerForgotPasswordSecurityTokenImpl#getCreateDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"})
  public void testCheckPasswordResetTokenWithTokenCustomer_thenCallsGetCreateDate() {
    // Arrange
    CustomerForgotPasswordSecurityTokenImpl customerForgotPasswordSecurityTokenImpl = mock(
        CustomerForgotPasswordSecurityTokenImpl.class);
    when(customerForgotPasswordSecurityTokenImpl.isTokenUsedFlag()).thenReturn(false);
    when(customerForgotPasswordSecurityTokenImpl.getToken()).thenReturn("ABC123");
    when(customerForgotPasswordSecurityTokenImpl.getCreateDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList = new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityTokenImpl);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    customerServiceImpl.checkPasswordResetToken("ABC123", new CustomerImpl());

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityTokenImpl).getCreateDate();
    verify(customerForgotPasswordSecurityTokenImpl).getToken();
    verify(customerForgotPasswordSecurityTokenImpl).isTokenUsedFlag();
    verify(passwordEncoder).matches(isA(CharSequence.class), eq("ABC123"));
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token}, {@code customer}.
   * <ul>
   *   <li>Then calls {@link CustomerForgotPasswordSecurityTokenDao#readToken(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"})
  public void testCheckPasswordResetTokenWithTokenCustomer_thenCallsReadToken() {
    // Arrange
    CustomerForgotPasswordSecurityToken customerForgotPasswordSecurityToken = mock(
        CustomerForgotPasswordSecurityToken.class);
    when(customerForgotPasswordSecurityToken.isTokenUsedFlag()).thenThrow(new IllegalArgumentException("foo"));
    when(customerForgotPasswordSecurityTokenDao.readToken(Mockito.<String>any()))
        .thenReturn(customerForgotPasswordSecurityToken);
    when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.checkPasswordResetToken("ABC123", null));
    verify(customerForgotPasswordSecurityTokenDao).readToken(eq("secret"));
    verify(customerForgotPasswordSecurityToken).isTokenUsedFlag();
    verify(passwordEncoder).encode(isA(CharSequence.class));
  }

  /**
   * Test {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)} with {@code token}, {@code customer}.
   * <ul>
   *   <li>When space.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.checkPasswordResetToken(String, Customer)"})
  public void testCheckPasswordResetTokenWithTokenCustomer_whenSpace() {
    // Arrange and Act
    GenericResponse actualCheckPasswordResetTokenResult = customerServiceImpl.checkPasswordResetToken(" ", null);

    // Assert
    List<String> errorCodesList = actualCheckPasswordResetTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualCheckPasswordResetTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#readCustomerByUsername(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_givenCustomerDaoReadCustomerByUsernameReturnNull() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(null);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Given {@link CustomerDao}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_givenCustomerDao_whenNull() {
    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken(null, "ABC123",
        "iloveyou", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Given {@link PasswordEncoder} {@link PasswordEncoder#matches(CharSequence, String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_givenPasswordEncoderMatchesReturnFalse() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    CustomerForgotPasswordSecurityTokenImpl customerForgotPasswordSecurityTokenImpl = mock(
        CustomerForgotPasswordSecurityTokenImpl.class);
    when(customerForgotPasswordSecurityTokenImpl.getToken()).thenReturn("ABC123");

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList = new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityTokenImpl);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(eq(1L));
    verify(customerForgotPasswordSecurityTokenImpl).getToken();
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
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code emailNotFound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsEmailNotFound() {
    // Arrange
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("emailNotFound", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code inactiveUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsInactiveUser() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code invalidToken}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
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
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(eq(1L));
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
   * <ul>
   *   <li>Then return ErrorCodesList first is {@code tokenUsed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListFirstIsTokenUsed() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);
    CustomerForgotPasswordSecurityTokenImpl customerForgotPasswordSecurityTokenImpl = mock(
        CustomerForgotPasswordSecurityTokenImpl.class);
    when(customerForgotPasswordSecurityTokenImpl.isTokenUsedFlag()).thenReturn(true);
    when(customerForgotPasswordSecurityTokenImpl.getToken()).thenReturn("ABC123");

    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList = new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(customerForgotPasswordSecurityTokenImpl);
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);
    when(passwordEncoder.matches(Mockito.<CharSequence>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(eq(1L));
    verify(customerForgotPasswordSecurityTokenImpl).getToken();
    verify(customerForgotPasswordSecurityTokenImpl).isTokenUsedFlag();
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
   * <ul>
   *   <li>Then return ErrorCodesList second is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListSecondIsInvalidPassword() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
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
   * <ul>
   *   <li>Then return ErrorCodesList second is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListSecondIsInvalidPassword2() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "iloveyou", "");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
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
   * <ul>
   *   <li>Then return ErrorCodesList second is {@code invalidToken}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListSecondIsInvalidToken() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken("janedoe", "",
        "iloveyou", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertEquals("invalidToken", errorCodesList.get(1));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}.
   * <ul>
   *   <li>Then return ErrorCodesList second is {@code passwordMismatch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenReturnErrorCodesListSecondIsPasswordMismatch() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act
    GenericResponse actualResetPasswordUsingTokenResult = customerServiceImpl.resetPasswordUsingToken("janedoe",
        "ABC123", "Password", "iloveyou");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
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
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GenericResponse CustomerServiceImpl.resetPasswordUsingToken(String, String, String, String)"})
  public void testResetPasswordUsingToken_thenThrowIllegalArgumentException() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenThrow(new IllegalArgumentException("iloveyou"));
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.resetPasswordUsingToken("janedoe", "ABC123", "iloveyou", "iloveyou"));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
  }

  /**
   * Test {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}.
   * <ul>
   *   <li>Then calls {@link CustomerForgotPasswordSecurityTokenDao#readUnusedTokensByCustomerId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then calls {@link CustomerForgotPasswordSecurityTokenDao#saveToken(CustomerForgotPasswordSecurityToken)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.invalidateAllTokensForCustomer(Customer)"})
  public void testInvalidateAllTokensForCustomer_thenCallsSaveToken() {
    // Arrange
    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList = new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.saveToken(Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenReturn(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);

    // Act
    customerServiceImpl.invalidateAllTokensForCustomer(new CustomerImpl());

    // Assert
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityTokenDao).saveToken(isA(CustomerForgotPasswordSecurityToken.class));
  }

  /**
   * Test {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#invalidateAllTokensForCustomer(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.invalidateAllTokensForCustomer(Customer)"})
  public void testInvalidateAllTokensForCustomer_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<CustomerForgotPasswordSecurityToken> customerForgotPasswordSecurityTokenList = new ArrayList<>();
    customerForgotPasswordSecurityTokenList.add(new CustomerForgotPasswordSecurityTokenImpl());
    when(customerForgotPasswordSecurityTokenDao.saveToken(Mockito.<CustomerForgotPasswordSecurityToken>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(customerForgotPasswordSecurityTokenDao.readUnusedTokensByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerForgotPasswordSecurityTokenList);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.invalidateAllTokensForCustomer(new CustomerImpl()));
    verify(customerForgotPasswordSecurityTokenDao).readUnusedTokensByCustomerId(isNull());
    verify(customerForgotPasswordSecurityTokenDao).saveToken(isA(CustomerForgotPasswordSecurityToken.class));
  }

  /**
   * Test {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link CustomerImpl} {@link CustomerImpl#isDeactivated()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given space.</li>
   *   <li>When {@link CustomerImpl} (default constructor) EmailAddress is space.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.checkCustomer(Customer, GenericResponse)"})
  public void testCheckCustomer_givenSpace_whenCustomerImplEmailAddressIsSpace() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress(" ");
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
   * Test {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code inactiveUser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.checkCustomer(Customer, GenericResponse)"})
  public void testCheckCustomer_thenGenericResponseErrorCodesListFirstIsInactiveUser() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("Customer");
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkCustomer(customer, response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("inactiveUser", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code invalidCustomer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.checkCustomer(Customer, GenericResponse)"})
  public void testCheckCustomer_thenThrowIllegalArgumentException() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getEmailAddress()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.checkCustomer(customer, new GenericResponse()));
    verify(customer).getEmailAddress();
  }

  /**
   * Test {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsInvalidPassword() {
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
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code invalidPassword}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerServiceImpl.checkPassword(String, String, GenericResponse)"})
  public void testCheckPassword_thenGenericResponseErrorCodesListFirstIsInvalidPassword2() {
    // Arrange
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkPassword("iloveyou", "", response);

    // Assert
    List<String> errorCodesList = response.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidPassword", errorCodesList.get(0));
    assertTrue(response.getHasErrors());
  }

  /**
   * Test {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}.
   * <ul>
   *   <li>Then {@link GenericResponse} (default constructor) ErrorCodesList first is {@code passwordMismatch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link GenericResponse} (default constructor).</li>
   *   <li>Then not {@link GenericResponse} (default constructor) HasErrors.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.isTokenExpired(CustomerForgotPasswordSecurityToken)"})
  public void testIsTokenExpired() {
    // Arrange
    CustomerForgotPasswordSecurityToken fpst = mock(CustomerForgotPasswordSecurityToken.class);
    when(fpst.getCreateDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    customerServiceImpl.isTokenExpired(fpst);

    // Assert
    verify(fpst).getCreateDate();
  }

  /**
   * Test {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}.
   * <ul>
   *   <li>Given {@link Date#Date()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.isTokenExpired(CustomerForgotPasswordSecurityToken)"})
  public void testIsTokenExpired_givenDate_thenReturnFalse() {
    // Arrange
    CustomerForgotPasswordSecurityToken fpst = mock(CustomerForgotPasswordSecurityToken.class);
    when(fpst.getCreateDate()).thenReturn(new Date());

    // Act
    boolean actualIsTokenExpiredResult = customerServiceImpl.isTokenExpired(fpst);

    // Assert
    verify(fpst).getCreateDate();
    assertFalse(actualIsTokenExpiredResult);
  }

  /**
   * Test {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CustomerServiceImpl.isTokenExpired(CustomerForgotPasswordSecurityToken)"})
  public void testIsTokenExpired_thenThrowIllegalArgumentException() {
    // Arrange
    CustomerForgotPasswordSecurityToken fpst = mock(CustomerForgotPasswordSecurityToken.class);
    when(fpst.getCreateDate()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.isTokenExpired(fpst));
    verify(fpst).getCreateDate();
  }

  /**
   * Test {@link CustomerServiceImpl#readBatchCustomers(int, int)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readBatchCustomers(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CustomerServiceImpl.readBatchCustomers(int, int)"})
  public void testReadBatchCustomers_thenReturnEmpty() {
    // Arrange
    when(customerDao.readBatchCustomers(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<Customer> actualReadBatchCustomersResult = customerServiceImpl.readBatchCustomers(1, 3);

    // Assert
    verify(customerDao).readBatchCustomers(eq(1), eq(3));
    assertTrue(actualReadBatchCustomersResult.isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#readBatchCustomers(int, int)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readBatchCustomers(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CustomerServiceImpl.readBatchCustomers(int, int)"})
  public void testReadBatchCustomers_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readBatchCustomers(anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.readBatchCustomers(1, 3));
    verify(customerDao).readBatchCustomers(eq(1), eq(3));
  }

  /**
   * Test {@link CustomerServiceImpl#readNumberOfCustomers()}.
   * <ul>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readNumberOfCustomers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerServiceImpl#readNumberOfCustomers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long CustomerServiceImpl.readNumberOfCustomers()"})
  public void testReadNumberOfCustomers_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerDao.readNumberOfCustomers()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.readNumberOfCustomers());
    verify(customerDao).readNumberOfCustomers();
  }
}
