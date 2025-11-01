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
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.security.util.PasswordChange;
import org.broadleafcommerce.common.service.GenericResponse;
import org.broadleafcommerce.profile.core.dao.CustomerDao;
import org.broadleafcommerce.profile.core.dao.CustomerDaoImpl;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerForgotPasswordSecurityToken;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.dto.CustomerRuleHolder;
import org.broadleafcommerce.profile.core.service.handler.PasswordUpdatedHandler;
import org.broadleafcommerce.profile.core.service.listener.PostRegistrationObserver;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerServiceImplDiffblueTest {
  /**
   * Method under test: {@link CustomerServiceImpl#readCustomerByEmail(String)}
   */
  @Test
  public void testReadCustomerByEmail() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByEmail(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act
    Customer actualReadCustomerByEmailResult = customerServiceImpl.readCustomerByEmail("42 Main St");

    // Assert
    verify(customerDao).readCustomerByEmail(eq("42 Main St"));
    assertSame(customerImpl, actualReadCustomerByEmailResult);
  }

  /**
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  public void testChangePassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

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
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  public void testChangePassword2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getUnencodedPassword()).thenThrow(new IllegalArgumentException("foo"));
    when(customerImpl.isRegistered()).thenReturn(false);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getId();
    verify(customerImpl).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(eq(false));
    verify(customerImpl).setUnencodedPassword(isNull());
  }

  /**
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  public void testChangePassword3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn(null);
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    doNothing().when(customerImpl).setUsername(Mockito.<String>any());
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerById(eq(1L));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).getUsername();
    verify(customerImpl).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(eq(false));
    verify(customerImpl).setUnencodedPassword(isNull());
    verify(customerImpl).setUsername(eq("1"));
  }

  /**
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  public void testChangePassword4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getUnencodedPassword()).thenThrow(new IllegalArgumentException("foo"));
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
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerById(eq(1L));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl, atLeast(1)).getId();
    verify(customerImpl).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(eq(false));
    verify(customerImpl).setUnencodedPassword(isNull());
    verify(customerImpl).setUsername(eq("1"));
  }

  /**
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  public void testChangePassword5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getChallengeAnswer()).thenThrow(new IllegalArgumentException("foo"));
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn("secret");
    when(customerImpl.getUnencodedPassword()).thenReturn(null);
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.changePassword(new PasswordChange("janedoe")));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getChallengeAnswer();
    verify(customerImpl).getId();
    verify(customerImpl, atLeast(1)).getUnencodedChallengeAnswer();
    verify(customerImpl).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(eq(false));
    verify(customerImpl).setUnencodedPassword(isNull());
  }

  /**
   * Method under test: {@link CustomerServiceImpl#changePassword(PasswordChange)}
   */
  @Test
  public void testChangePassword6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getUnencodedChallengeAnswer()).thenReturn(null);
    when(customerImpl.getUnencodedPassword()).thenReturn(null);
    when(customerImpl.isRegistered()).thenReturn(true);
    when(customerImpl.getId()).thenReturn(1L);
    when(customerImpl.getUsername()).thenReturn("janedoe");
    doNothing().when(customerImpl).setPasswordChangeRequired(anyBoolean());
    doNothing().when(customerImpl).setUnencodedPassword(Mockito.<String>any());
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    CustomerImpl customerImpl2 = new CustomerImpl();
    when(customerDao.save(Mockito.<Customer>any())).thenReturn(customerImpl2);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act
    Customer actualChangePasswordResult = customerServiceImpl.changePassword(new PasswordChange("janedoe"));

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerDao).save(isA(Customer.class));
    verify(customerImpl).getId();
    verify(customerImpl).getUnencodedChallengeAnswer();
    verify(customerImpl).getUnencodedPassword();
    verify(customerImpl).getUsername();
    verify(customerImpl, atLeast(1)).isRegistered();
    verify(customerImpl).setPasswordChangeRequired(eq(false));
    verify(customerImpl).setUnencodedPassword(isNull());
    assertSame(customerImpl2, actualChangePasswordResult);
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#addPostRegisterListener(PostRegistrationObserver)}
   */
  @Test
  public void testAddPostRegisterListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    PostRegistrationObserver postRegisterListeners = mock(PostRegistrationObserver.class);

    // Act
    customerServiceImpl.addPostRegisterListener(postRegisterListeners);

    // Assert
    List<PostRegistrationObserver> postRegistrationObserverList = customerServiceImpl.postRegisterListeners;
    assertEquals(1, postRegistrationObserverList.size());
    assertTrue(customerServiceImpl.getPasswordResetHandlers().isEmpty());
    assertSame(postRegisterListeners, postRegistrationObserverList.get(0));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#notifyPostRegisterListeners(Customer)}
   */
  @Test
  public void testNotifyPostRegisterListeners() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link CustomerServiceImpl#notifyPostRegisterListeners(Customer)}
   */
  @Test
  public void testNotifyPostRegisterListeners2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PostRegistrationObserver postRegisterListeners = mock(PostRegistrationObserver.class);
    doNothing().when(postRegisterListeners).processRegistrationEvent(Mockito.<Customer>any());
    PostRegistrationObserver postRegisterListeners2 = mock(PostRegistrationObserver.class);
    doThrow(new IllegalArgumentException("foo")).when(postRegisterListeners2)
        .processRegistrationEvent(Mockito.<Customer>any());

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.addPostRegisterListener(postRegisterListeners2);
    customerServiceImpl.addPostRegisterListener(postRegisterListeners);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.notifyPostRegisterListeners(new CustomerImpl()));
    verify(postRegisterListeners2).processRegistrationEvent(isA(Customer.class));
  }

  /**
   * Method under test: {@link CustomerServiceImpl#createCustomerWithNullId()}
   */
  @Test
  public void testCreateCustomerWithNullId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.create()).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);

    // Act
    Customer actualCreateCustomerWithNullIdResult = customerServiceImpl.createCustomerWithNullId();

    // Assert
    verify(customerDao).create();
    assertSame(customerImpl, actualCreateCustomerWithNullIdResult);
  }

  /**
   * Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  public void testCreateCustomerFromId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act
    Customer actualCreateCustomerFromIdResult = customerServiceImpl.createCustomerFromId(1L);

    // Assert
    verify(customerDao).readCustomerById(eq(1L));
    assertSame(customerImpl, actualCreateCustomerFromIdResult);
  }

  /**
   * Method under test: {@link CustomerServiceImpl#createCustomerFromId(Long)}
   */
  @Test
  public void testCreateCustomerFromId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.create()).thenReturn(customerImpl);
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(null);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act
    Customer actualCreateCustomerFromIdResult = customerServiceImpl.createCustomerFromId(1L);

    // Assert
    verify(customerDao).create();
    verify(customerDao).readCustomerById(eq(1L));
    assertSame(customerImpl, actualCreateCustomerFromIdResult);
  }

  /**
   * Method under test: {@link CustomerServiceImpl#detachCustomer(Customer)}
   */
  @Test
  public void testDetachCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    doNothing().when(customerDao).detach(Mockito.<Customer>any());

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act
    customerServiceImpl.detachCustomer(new CustomerImpl());

    // Assert
    verify(customerDao).detach(isA(Customer.class));
  }

  /**
   * Method under test: {@link CustomerServiceImpl#readCustomerByUsername(String)}
   */
  @Test
  public void testReadCustomerByUsername() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act
    Customer actualReadCustomerByUsernameResult = customerServiceImpl.readCustomerByUsername("janedoe");

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    assertSame(customerImpl, actualReadCustomerByUsernameResult);
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#readCustomerByUsername(String, Boolean)}
   */
  @Test
  public void testReadCustomerByUsername2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByUsername(Mockito.<String>any(), Mockito.<Boolean>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act
    Customer actualReadCustomerByUsernameResult = customerServiceImpl.readCustomerByUsername("janedoe", true);

    // Assert
    verify(customerDao).readCustomerByUsername(eq("janedoe"), eq(true));
    assertSame(customerImpl, actualReadCustomerByUsernameResult);
  }

  /**
   * Method under test: {@link CustomerServiceImpl#readCustomerById(Long)}
   */
  @Test
  public void testReadCustomerById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerById(Mockito.<Long>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act
    Customer actualReadCustomerByIdResult = customerServiceImpl.readCustomerById(1L);

    // Assert
    verify(customerDao).readCustomerById(eq(1L));
    assertSame(customerImpl, actualReadCustomerByIdResult);
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#readCustomerByExternalId(String)}
   */
  @Test
  public void testReadCustomerByExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerDao.readCustomerByExternalId(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act
    Customer actualReadCustomerByExternalIdResult = customerServiceImpl.readCustomerByExternalId("42");

    // Assert
    verify(customerDao).readCustomerByExternalId(eq("42"));
    assertSame(customerImpl, actualReadCustomerByExternalIdResult);
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    CustomerRuleHolder customerRuleHolder = new CustomerRuleHolder("Customer Rule");
    customerRuleHolder.setCustomerRule(null);

    // Act and Assert
    assertTrue(customerServiceImpl.customerPassesCustomerRule(customer, customerRuleHolder));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    CustomerRuleHolder customerRuleHolder = new CustomerRuleHolder("Customer Rule");
    customerRuleHolder.setCustomerRule("");

    // Act and Assert
    assertTrue(customerServiceImpl.customerPassesCustomerRule(customer, customerRuleHolder));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("getProductAttributes()[UU]")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer,
        new CustomerRuleHolder("getCategoryAttributesMap()[UU]")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("getSkuAttributes()[UU]")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer,
        new CustomerRuleHolder("getOrderItemAttributes()[UU]")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer,
        new CustomerRuleHolder("getCustomerAttributes()[UU]")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer,
        new CustomerRuleHolder("getAdditionalAttributes()[UU]")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("getAdditionalFields()[UU]")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("42")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("customer")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(
        customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("getProductAttributes()[UU]")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

    // Act and Assert
    assertTrue(customerServiceImpl.customerPassesCustomerRule(null, new CustomerRuleHolder("customer")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer, new CustomerRuleHolder("MVEL")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer,
        new CustomerRuleHolder("getProductAttributes()[UU]getProductAttributes()[UU]")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#customerPassesCustomerRule(Customer, CustomerRuleHolder)}
   */
  @Test
  public void testCustomerPassesCustomerRule16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertFalse(customerServiceImpl.customerPassesCustomerRule(customer,
        new CustomerRuleHolder("getProductAttributes()[UU]getCategoryAttributesMap()[UU]")));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#buildCustomerRuleParams(Customer)}
   */
  @Test
  public void testBuildCustomerRuleParams() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act
    Map<String, Object> actualBuildCustomerRuleParamsResult = customerServiceImpl.buildCustomerRuleParams(customer);

    // Assert
    assertEquals(1, actualBuildCustomerRuleParamsResult.size());
    assertSame(customer, actualBuildCustomerRuleParamsResult.get("customer"));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#buildCustomerRuleParams(Customer)}
   */
  @Test
  public void testBuildCustomerRuleParams2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));
    CustomerImpl customer = new CustomerImpl();

    // Act
    Map<String, Object> actualBuildCustomerRuleParamsResult = customerServiceImpl.buildCustomerRuleParams(customer);

    // Assert
    assertEquals(1, actualBuildCustomerRuleParamsResult.size());
    assertSame(customer, actualBuildCustomerRuleParamsResult.get("customer"));
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  public void testSendForgotUsernameNotification() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualSendForgotUsernameNotificationResult = (new CustomerServiceImpl())
        .sendForgotUsernameNotification(null);

    // Assert
    List<String> errorCodesList = actualSendForgotUsernameNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("notFound", errorCodesList.get(0));
    assertTrue(actualSendForgotUsernameNotificationResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  public void testSendForgotUsernameNotification2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

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
   * Method under test:
   * {@link CustomerServiceImpl#sendForgotUsernameNotification(String)}
   */
  @Test
  public void testSendForgotUsernameNotification3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);

    ArrayList<Customer> customerList = new ArrayList<>();
    customerList.add(customerImpl);
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomersByEmail(Mockito.<String>any())).thenReturn(customerList);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

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
   * Method under test:
   * {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  public void testSendForgotPasswordNotification() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setPasswordTokenLength(0);

    // Act
    GenericResponse actualSendForgotPasswordNotificationResult = customerServiceImpl
        .sendForgotPasswordNotification(null, "?");

    // Assert
    List<String> errorCodesList = actualSendForgotPasswordNotificationResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertTrue(actualSendForgotPasswordNotificationResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  public void testSendForgotPasswordNotification2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

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
   * Method under test:
   * {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  public void testSendForgotPasswordNotification3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

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
   * Method under test:
   * {@link CustomerServiceImpl#sendForgotPasswordNotification(String, String)}
   */
  @Test
  public void testSendForgotPasswordNotification4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated())
        .thenThrow(new IllegalArgumentException("ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789"));
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.sendForgotPasswordNotification("janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  public void testSendForcedPasswordChangeNotification() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
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
   * Method under test:
   * {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  public void testSendForcedPasswordChangeNotification2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(new CustomerImpl());

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

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
   * Method under test:
   * {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  public void testSendForcedPasswordChangeNotification3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated()).thenReturn(true);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

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
   * Method under test:
   * {@link CustomerServiceImpl#sendForcedPasswordChangeNotification(String, String)}
   */
  @Test
  public void testSendForcedPasswordChangeNotification4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.isDeactivated())
        .thenThrow(new IllegalArgumentException("ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789"));
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readCustomerByUsername(Mockito.<String>any())).thenReturn(customerImpl);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.sendForcedPasswordChangeNotification("janedoe", "https://example.org/example"));
    verify(customerDao).readCustomerByUsername(eq("janedoe"));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).isDeactivated();
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer)}
   */
  @Test
  public void testCheckPasswordResetToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualCheckPasswordResetTokenResult = (new CustomerServiceImpl()).checkPasswordResetToken(null,
        null);

    // Assert
    List<String> errorCodesList = actualCheckPasswordResetTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidToken", errorCodesList.get(0));
    assertTrue(actualCheckPasswordResetTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#checkPasswordResetToken(String, Customer, GenericResponse)}
   */
  @Test
  public void testCheckPasswordResetToken2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = mock(CustomerImpl.class);
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
   * Method under test:
   * {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new CustomerServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", "iloveyou", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(1, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new CustomerServiceImpl()).resetPasswordUsingToken(null,
        null, "iloveyou", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertEquals("invalidToken", errorCodesList.get(1));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new CustomerServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", "invalidCustomer", "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertEquals("passwordMismatch", errorCodesList.get(1));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new CustomerServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", null, "iloveyou");

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#resetPasswordUsingToken(String, String, String, String)}
   */
  @Test
  public void testResetPasswordUsingToken5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GenericResponse actualResetPasswordUsingTokenResult = (new CustomerServiceImpl()).resetPasswordUsingToken(null,
        "ABC123", "iloveyou", null);

    // Assert
    List<String> errorCodesList = actualResetPasswordUsingTokenResult.getErrorCodesList();
    assertEquals(2, errorCodesList.size());
    assertEquals("invalidCustomer", errorCodesList.get(0));
    assertEquals("invalidPassword", errorCodesList.get(1));
    assertTrue(actualResetPasswordUsingTokenResult.getHasErrors());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  public void testCheckCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
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
   * Method under test:
   * {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  public void testCheckCustomer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
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
   * Method under test:
   * {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  public void testCheckCustomer3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

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
   * Method under test:
   * {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  public void testCheckCustomer4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));
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
   * Method under test:
   * {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  public void testCheckCustomer5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.isDeactivated()).thenReturn(false);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkCustomer(customer, response);

    // Assert
    verify(customer).getEmailAddress();
    verify(customer).isDeactivated();
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#checkCustomer(Customer, GenericResponse)}
   */
  @Test
  public void testCheckCustomer6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    Customer customer = mock(Customer.class);
    when(customer.getEmailAddress()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> customerServiceImpl.checkCustomer(customer, new GenericResponse()));
    verify(customer).getEmailAddress();
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkPassword("iloveyou", "iloveyou", response);

    // Assert that nothing has changed
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));
    GenericResponse response = new GenericResponse();

    // Act
    customerServiceImpl.checkPassword("iloveyou", "iloveyou", response);

    // Assert that nothing has changed
    assertFalse(response.getHasErrors());
    assertTrue(response.getErrorCodesList().isEmpty());
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
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
   * Method under test:
   * {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
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
   * Method under test:
   * {@link CustomerServiceImpl#checkPassword(String, String, GenericResponse)}
   */
  @Test
  public void testCheckPassword5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
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
   * Method under test:
   * {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}
   */
  @Test
  public void testIsTokenExpired() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerForgotPasswordSecurityToken fpst = mock(CustomerForgotPasswordSecurityToken.class);
    when(fpst.getCreateDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    customerServiceImpl.isTokenExpired(fpst);

    // Assert
    verify(fpst).getCreateDate();
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}
   */
  @Test
  public void testIsTokenExpired2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerForgotPasswordSecurityToken fpst = mock(CustomerForgotPasswordSecurityToken.class);
    when(fpst.getCreateDate()).thenReturn(new Date());

    // Act
    boolean actualIsTokenExpiredResult = customerServiceImpl.isTokenExpired(fpst);

    // Assert
    verify(fpst).getCreateDate();
    assertFalse(actualIsTokenExpiredResult);
  }

  /**
   * Method under test:
   * {@link CustomerServiceImpl#isTokenExpired(CustomerForgotPasswordSecurityToken)}
   */
  @Test
  public void testIsTokenExpired3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    CustomerForgotPasswordSecurityToken fpst = mock(CustomerForgotPasswordSecurityToken.class);
    when(fpst.getCreateDate()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> customerServiceImpl.isTokenExpired(fpst));
    verify(fpst).getCreateDate();
  }

  /**
   * Method under test: {@link CustomerServiceImpl#readBatchCustomers(int, int)}
   */
  @Test
  public void testReadBatchCustomers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    ArrayList<Customer> customerList = new ArrayList<>();
    when(customerDao.readBatchCustomers(anyInt(), anyInt())).thenReturn(customerList);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);
    customerServiceImpl.addPostRegisterListener(mock(PostRegistrationObserver.class));

    // Act
    List<Customer> actualReadBatchCustomersResult = customerServiceImpl.readBatchCustomers(1, 3);

    // Assert
    verify(customerDao).readBatchCustomers(eq(1), eq(3));
    assertTrue(actualReadBatchCustomersResult.isEmpty());
    assertSame(customerList, actualReadBatchCustomersResult);
  }

  /**
   * Method under test: {@link CustomerServiceImpl#readNumberOfCustomers()}
   */
  @Test
  public void testReadNumberOfCustomers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerDaoImpl customerDao = mock(CustomerDaoImpl.class);
    when(customerDao.readNumberOfCustomers()).thenReturn(1L);

    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    customerServiceImpl.setCustomerDao(customerDao);

    // Act
    Long actualReadNumberOfCustomersResult = customerServiceImpl.readNumberOfCustomers();

    // Assert
    verify(customerDao).readNumberOfCustomers();
    assertEquals(1L, actualReadNumberOfCustomersResult.longValue());
  }

  /**
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

    // Assert that nothing has changed
    assertEquals(1, customerServiceImpl.getTokenExpiredMinutes());
    assertEquals(3, actualPasswordTokenLength);
    assertTrue(actualPasswordChangedHandlers.isEmpty());
    assertTrue(actualPasswordResetHandlers.isEmpty());
    assertSame(passwordChangedHandlers, actualPasswordChangedHandlers);
    assertSame(passwordResetHandlers, actualPasswordResetHandlers);
  }
}
