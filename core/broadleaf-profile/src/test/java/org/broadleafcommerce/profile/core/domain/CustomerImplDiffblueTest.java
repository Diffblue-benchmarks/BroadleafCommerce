/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
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
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerImplDiffblueTest {
  /**
   * Test {@link CustomerImpl#isPasswordChangeRequired()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isPasswordChangeRequired()}
   */
  @Test
  public void testIsPasswordChangeRequired_givenAuditableCreatedByIsOne_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setPasswordChangeRequired(true);

    // Act and Assert
    assertTrue(customerImpl.isPasswordChangeRequired());
  }

  /**
   * Test {@link CustomerImpl#isPasswordChangeRequired()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isPasswordChangeRequired()}
   */
  @Test
  public void testIsPasswordChangeRequired_givenCustomerImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CustomerImpl()).isPasswordChangeRequired());
  }

  /**
   * Test {@link CustomerImpl#isPasswordChangeRequired()}.
   * <ul>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isPasswordChangeRequired()}
   */
  @Test
  public void testIsPasswordChangeRequired_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setPasswordChangeRequired(true);

    // Act
    boolean actualIsPasswordChangeRequiredResult = customerImpl.isPasswordChangeRequired();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertTrue(actualIsPasswordChangeRequiredResult);
  }

  /**
   * Test {@link CustomerImpl#setPasswordChangeRequired(boolean)}.
   * <p>
   * Method under test: {@link CustomerImpl#setPasswordChangeRequired(boolean)}
   */
  @Test
  public void testSetPasswordChangeRequired() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setChallengeQuestion(mock(ChallengeQuestionImpl.class));

    // Act
    customerImpl.setPasswordChangeRequired(true);

    // Assert
    assertTrue(customerImpl.isPasswordChangeRequired());
    assertTrue(customerImpl.passwordChangeRequired);
  }

  /**
   * Test {@link CustomerImpl#setPasswordChangeRequired(boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setPasswordChangeRequired(boolean)}
   */
  @Test
  public void testSetPasswordChangeRequired_givenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    // Act
    customerImpl.setPasswordChangeRequired(true);

    // Assert
    assertTrue(customerImpl.isPasswordChangeRequired());
    assertTrue(customerImpl.passwordChangeRequired);
  }

  /**
   * Test {@link CustomerImpl#isReceiveEmail()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isReceiveEmail()}
   */
  @Test
  public void testIsReceiveEmail_givenAuditableCreatedByIsOne_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setReceiveEmail(true);

    // Act and Assert
    assertTrue(customerImpl.isReceiveEmail());
  }

  /**
   * Test {@link CustomerImpl#isReceiveEmail()}.
   * <ul>
   *   <li>Given {@link Auditable} {@link Auditable#setCreatedBy(Long)} does
   * nothing.</li>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isReceiveEmail()}
   */
  @Test
  public void testIsReceiveEmail_givenAuditableSetCreatedByDoesNothing_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setReceiveEmail(true);

    // Act
    boolean actualIsReceiveEmailResult = customerImpl.isReceiveEmail();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertTrue(actualIsReceiveEmailResult);
  }

  /**
   * Test {@link CustomerImpl#isReceiveEmail()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isReceiveEmail()}
   */
  @Test
  public void testIsReceiveEmail_givenCustomerImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CustomerImpl()).isReceiveEmail());
  }

  /**
   * Test {@link CustomerImpl#setReceiveEmail(boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setReceiveEmail(boolean)}
   */
  @Test
  public void testSetReceiveEmail_givenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    // Act
    customerImpl.setReceiveEmail(true);

    // Assert
    assertTrue(customerImpl.isReceiveEmail());
    assertTrue(customerImpl.receiveEmail);
  }

  /**
   * Test {@link CustomerImpl#setReceiveEmail(boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) ChallengeQuestion is
   * {@link ChallengeQuestionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setReceiveEmail(boolean)}
   */
  @Test
  public void testSetReceiveEmail_givenCustomerImplChallengeQuestionIsChallengeQuestionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setChallengeQuestion(mock(ChallengeQuestionImpl.class));

    // Act
    customerImpl.setReceiveEmail(true);

    // Assert
    assertTrue(customerImpl.isReceiveEmail());
    assertTrue(customerImpl.receiveEmail);
  }

  /**
   * Test {@link CustomerImpl#isRegistered()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isRegistered()}
   */
  @Test
  public void testIsRegistered_givenAuditableCreatedByIsOne_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setRegistered(true);

    // Act and Assert
    assertTrue(customerImpl.isRegistered());
  }

  /**
   * Test {@link CustomerImpl#isRegistered()}.
   * <ul>
   *   <li>Given {@link Auditable} {@link Auditable#setCreatedBy(Long)} does
   * nothing.</li>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isRegistered()}
   */
  @Test
  public void testIsRegistered_givenAuditableSetCreatedByDoesNothing_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setRegistered(true);

    // Act
    boolean actualIsRegisteredResult = customerImpl.isRegistered();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertTrue(actualIsRegisteredResult);
  }

  /**
   * Test {@link CustomerImpl#isRegistered()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isRegistered()}
   */
  @Test
  public void testIsRegistered_givenCustomerImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CustomerImpl()).isRegistered());
  }

  /**
   * Test {@link CustomerImpl#setRegistered(boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setRegistered(boolean)}
   */
  @Test
  public void testSetRegistered_givenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    // Act
    customerImpl.setRegistered(true);

    // Assert
    assertTrue(customerImpl.isRegistered());
    assertTrue(customerImpl.registered);
  }

  /**
   * Test {@link CustomerImpl#setRegistered(boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) ChallengeQuestion is
   * {@link ChallengeQuestionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setRegistered(boolean)}
   */
  @Test
  public void testSetRegistered_givenCustomerImplChallengeQuestionIsChallengeQuestionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setChallengeQuestion(mock(ChallengeQuestionImpl.class));

    // Act
    customerImpl.setRegistered(true);

    // Assert
    assertTrue(customerImpl.isRegistered());
    assertTrue(customerImpl.registered);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerImpl#setAuditable(Auditable)}
   *   <li>{@link CustomerImpl#setChallengeAnswer(String)}
   *   <li>{@link CustomerImpl#setChallengeQuestion(ChallengeQuestion)}
   *   <li>{@link CustomerImpl#setCustomerAddresses(List)}
   *   <li>{@link CustomerImpl#setCustomerAttributes(Map)}
   *   <li>{@link CustomerImpl#setCustomerLocale(Locale)}
   *   <li>{@link CustomerImpl#setCustomerPayments(List)}
   *   <li>{@link CustomerImpl#setCustomerPhones(List)}
   *   <li>{@link CustomerImpl#setEmailAddress(String)}
   *   <li>{@link CustomerImpl#setExternalId(String)}
   *   <li>{@link CustomerImpl#setFirstName(String)}
   *   <li>{@link CustomerImpl#setId(Long)}
   *   <li>{@link CustomerImpl#setLastName(String)}
   *   <li>{@link CustomerImpl#setPassword(String)}
   *   <li>{@link CustomerImpl#setUnencodedChallengeAnswer(String)}
   *   <li>{@link CustomerImpl#setUnencodedPassword(String)}
   *   <li>{@link CustomerImpl#setUsername(String)}
   *   <li>{@link CustomerImpl#getAuditable()}
   *   <li>{@link CustomerImpl#getChallengeAnswer()}
   *   <li>{@link CustomerImpl#getChallengeQuestion()}
   *   <li>{@link CustomerImpl#getCustomerAddresses()}
   *   <li>{@link CustomerImpl#getCustomerAttributes()}
   *   <li>{@link CustomerImpl#getCustomerLocale()}
   *   <li>{@link CustomerImpl#getCustomerPayments()}
   *   <li>{@link CustomerImpl#getCustomerPhones()}
   *   <li>{@link CustomerImpl#getEmailAddress()}
   *   <li>{@link CustomerImpl#getExternalId()}
   *   <li>{@link CustomerImpl#getFirstName()}
   *   <li>{@link CustomerImpl#getId()}
   *   <li>{@link CustomerImpl#getLastName()}
   *   <li>{@link CustomerImpl#getPassword()}
   *   <li>{@link CustomerImpl#getTaxExemptionCode()}
   *   <li>{@link CustomerImpl#getTransientProperties()}
   *   <li>{@link CustomerImpl#getUnencodedChallengeAnswer()}
   *   <li>{@link CustomerImpl#getUnencodedPassword()}
   *   <li>{@link CustomerImpl#getUsername()}
   *   <li>{@link CustomerImpl#isAnonymous()}
   *   <li>{@link CustomerImpl#isCookied()}
   *   <li>{@link CustomerImpl#isLoggedIn()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    // Act
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    ChallengeQuestionImpl challengeQuestion = new ChallengeQuestionImpl();
    customerImpl.setChallengeQuestion(challengeQuestion);
    ArrayList<CustomerAddress> customerAddresses = new ArrayList<>();
    customerImpl.setCustomerAddresses(customerAddresses);
    HashMap<String, CustomerAttribute> customerAttributes = new HashMap<>();
    customerImpl.setCustomerAttributes(customerAttributes);
    LocaleImpl customerLocale = new LocaleImpl();
    customerImpl.setCustomerLocale(customerLocale);
    ArrayList<CustomerPayment> customerPayments = new ArrayList<>();
    customerImpl.setCustomerPayments(customerPayments);
    ArrayList<CustomerPhone> customerPhones = new ArrayList<>();
    customerImpl.setCustomerPhones(customerPhones);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    Auditable actualAuditable = customerImpl.getAuditable();
    String actualChallengeAnswer = customerImpl.getChallengeAnswer();
    ChallengeQuestion actualChallengeQuestion = customerImpl.getChallengeQuestion();
    List<CustomerAddress> actualCustomerAddresses = customerImpl.getCustomerAddresses();
    Map<String, CustomerAttribute> actualCustomerAttributes = customerImpl.getCustomerAttributes();
    Locale actualCustomerLocale = customerImpl.getCustomerLocale();
    List<CustomerPayment> actualCustomerPayments = customerImpl.getCustomerPayments();
    List<CustomerPhone> actualCustomerPhones = customerImpl.getCustomerPhones();
    String actualEmailAddress = customerImpl.getEmailAddress();
    String actualExternalId = customerImpl.getExternalId();
    String actualFirstName = customerImpl.getFirstName();
    Long actualId = customerImpl.getId();
    String actualLastName = customerImpl.getLastName();
    String actualPassword = customerImpl.getPassword();
    customerImpl.getTaxExemptionCode();
    Map<String, Object> actualTransientProperties = customerImpl.getTransientProperties();
    String actualUnencodedChallengeAnswer = customerImpl.getUnencodedChallengeAnswer();
    String actualUnencodedPassword = customerImpl.getUnencodedPassword();
    String actualUsername = customerImpl.getUsername();
    boolean actualIsAnonymousResult = customerImpl.isAnonymous();
    boolean actualIsCookiedResult = customerImpl.isCookied();
    boolean actualIsLoggedInResult = customerImpl.isLoggedIn();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("42", actualExternalId);
    assertEquals("Challenge Answer", actualChallengeAnswer);
    assertEquals("Doe", actualLastName);
    assertEquals("Jane", actualFirstName);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
    assertEquals("secret", actualUnencodedChallengeAnswer);
    assertEquals("secret", actualUnencodedPassword);
    assertEquals(1L, actualId.longValue());
    assertFalse(actualIsAnonymousResult);
    assertFalse(actualIsCookiedResult);
    assertFalse(actualIsLoggedInResult);
    assertTrue(actualCustomerAddresses.isEmpty());
    assertTrue(actualCustomerPayments.isEmpty());
    assertTrue(actualCustomerPhones.isEmpty());
    assertTrue(actualCustomerAttributes.isEmpty());
    assertTrue(actualTransientProperties.isEmpty());
    assertSame(customerAddresses, actualCustomerAddresses);
    assertSame(customerPayments, actualCustomerPayments);
    assertSame(customerPhones, actualCustomerPhones);
    assertSame(customerAttributes, actualCustomerAttributes);
    assertSame(auditable, actualAuditable);
    assertSame(customerLocale, actualCustomerLocale);
    assertSame(challengeQuestion, actualChallengeQuestion);
  }

  /**
   * Test {@link CustomerImpl#setAnonymous(boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then not {@link CustomerImpl} (default constructor) Anonymous.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setAnonymous(boolean)}
   */
  @Test
  public void testSetAnonymous_givenAuditableCreatedByIsOne_thenNotCustomerImplAnonymous() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act
    customerImpl.setAnonymous(false);

    // Assert
    assertFalse(customerImpl.isAnonymous());
  }

  /**
   * Test {@link CustomerImpl#setAnonymous(boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} {@link Auditable#setCreatedBy(Long)} does
   * nothing.</li>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setAnonymous(boolean)}
   */
  @Test
  public void testSetAnonymous_givenAuditableSetCreatedByDoesNothing_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act
    customerImpl.setAnonymous(false);

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertFalse(customerImpl.isAnonymous());
  }

  /**
   * Test {@link CustomerImpl#setAnonymous(boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link CustomerImpl} (default constructor) Anonymous.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setAnonymous(boolean)}
   */
  @Test
  public void testSetAnonymous_givenCustomerImpl_whenTrue_thenCustomerImplAnonymous() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    // Act
    customerImpl.setAnonymous(true);

    // Assert
    assertTrue(customerImpl.isAnonymous());
  }

  /**
   * Test {@link CustomerImpl#setCookied(boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link CustomerImpl} (default constructor) Cookied.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setCookied(boolean)}
   */
  @Test
  public void testSetCookied_givenAuditableCreatedByIsOne_whenFalse_thenNotCustomerImplCookied() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act
    customerImpl.setCookied(false);

    // Assert
    assertFalse(customerImpl.isCookied());
  }

  /**
   * Test {@link CustomerImpl#setCookied(boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} {@link Auditable#setCreatedBy(Long)} does
   * nothing.</li>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setCookied(boolean)}
   */
  @Test
  public void testSetCookied_givenAuditableSetCreatedByDoesNothing_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act
    customerImpl.setCookied(false);

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertFalse(customerImpl.isCookied());
  }

  /**
   * Test {@link CustomerImpl#setCookied(boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link CustomerImpl} (default constructor) Cookied.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setCookied(boolean)}
   */
  @Test
  public void testSetCookied_givenCustomerImpl_whenTrue_thenCustomerImplCookied() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    // Act
    customerImpl.setCookied(true);

    // Assert
    assertTrue(customerImpl.isCookied());
  }

  /**
   * Test {@link CustomerImpl#setLoggedIn(boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then not {@link CustomerImpl} (default constructor) LoggedIn.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setLoggedIn(boolean)}
   */
  @Test
  public void testSetLoggedIn_givenAuditableCreatedByIsOne_thenNotCustomerImplLoggedIn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act
    customerImpl.setLoggedIn(false);

    // Assert
    assertFalse(customerImpl.isLoggedIn());
  }

  /**
   * Test {@link CustomerImpl#setLoggedIn(boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} {@link Auditable#setCreatedBy(Long)} does
   * nothing.</li>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setLoggedIn(boolean)}
   */
  @Test
  public void testSetLoggedIn_givenAuditableSetCreatedByDoesNothing_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act
    customerImpl.setLoggedIn(false);

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertFalse(customerImpl.isLoggedIn());
  }

  /**
   * Test {@link CustomerImpl#setLoggedIn(boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link CustomerImpl} (default constructor) LoggedIn.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setLoggedIn(boolean)}
   */
  @Test
  public void testSetLoggedIn_givenCustomerImpl_whenTrue_thenCustomerImplLoggedIn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    // Act
    customerImpl.setLoggedIn(true);

    // Assert
    assertTrue(customerImpl.isLoggedIn());
  }

  /**
   * Test {@link CustomerImpl#isDeactivated()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isDeactivated()}
   */
  @Test
  public void testIsDeactivated_givenAuditableCreatedByIsOne_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setDeactivated(true);

    // Act and Assert
    assertTrue(customerImpl.isDeactivated());
  }

  /**
   * Test {@link CustomerImpl#isDeactivated()}.
   * <ul>
   *   <li>Given {@link Auditable} {@link Auditable#setCreatedBy(Long)} does
   * nothing.</li>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isDeactivated()}
   */
  @Test
  public void testIsDeactivated_givenAuditableSetCreatedByDoesNothing_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setDeactivated(true);

    // Act
    boolean actualIsDeactivatedResult = customerImpl.isDeactivated();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertTrue(actualIsDeactivatedResult);
  }

  /**
   * Test {@link CustomerImpl#isDeactivated()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isDeactivated()}
   */
  @Test
  public void testIsDeactivated_givenCustomerImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CustomerImpl()).isDeactivated());
  }

  /**
   * Test {@link CustomerImpl#setDeactivated(boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setDeactivated(boolean)}
   */
  @Test
  public void testSetDeactivated_givenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    // Act
    customerImpl.setDeactivated(true);

    // Assert
    assertTrue(customerImpl.isDeactivated());
    assertTrue(customerImpl.deactivated);
  }

  /**
   * Test {@link CustomerImpl#setDeactivated(boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) ChallengeQuestion is
   * {@link ChallengeQuestionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setDeactivated(boolean)}
   */
  @Test
  public void testSetDeactivated_givenCustomerImplChallengeQuestionIsChallengeQuestionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setChallengeQuestion(mock(ChallengeQuestionImpl.class));

    // Act
    customerImpl.setDeactivated(true);

    // Assert
    assertTrue(customerImpl.isDeactivated());
    assertTrue(customerImpl.deactivated);
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenAuditableCreatedByIsOne_thenReturn1() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setId(1L);
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername(null);
    customerImpl.setFirstName("foo");
    customerImpl.setLastName(null);

    // Act and Assert
    assertEquals("1", customerImpl.getMainEntityName());
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) LastName is
   * {@code foo}.</li>
   *   <li>Then return {@code foo foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenCustomerImplLastNameIsFoo_thenReturnFooFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setId(1L);
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername(null);
    customerImpl.setFirstName("foo");
    customerImpl.setLastName("foo");

    // Act and Assert
    assertEquals("foo foo", customerImpl.getMainEntityName());
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) Username is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenCustomerImplUsernameIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setId(1L);
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("");
    customerImpl.setFirstName("foo");
    customerImpl.setLastName(null);

    // Act
    String actualMainEntityName = customerImpl.getMainEntityName();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertEquals("1", actualMainEntityName);
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) Username is
   * {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenCustomerImplUsernameIsFoo_thenReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setId(1L);
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("foo");
    customerImpl.setFirstName(null);
    customerImpl.setLastName(null);

    // Act and Assert
    assertEquals("foo", customerImpl.getMainEntityName());
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenCustomerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("null", (new CustomerImpl()).getMainEntityName());
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   * <ul>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setId(1L);
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername(null);
    customerImpl.setFirstName("foo");
    customerImpl.setLastName(null);

    // Act
    String actualMainEntityName = customerImpl.getMainEntityName();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertEquals("1", actualMainEntityName);
  }

  /**
   * Test {@link CustomerImpl#getPreview()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#getPreview()}
   */
  @Test
  public void testGetPreview_givenAuditableCreatedByIsOne_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setPreview(true);

    // Act and Assert
    assertTrue(customerImpl.getPreview());
  }

  /**
   * Test {@link CustomerImpl#getPreview()}.
   * <ul>
   *   <li>Given {@link Auditable} {@link Auditable#setCreatedBy(Long)} does
   * nothing.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#getPreview()}
   */
  @Test
  public void testGetPreview_givenAuditableSetCreatedByDoesNothing_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setPreview(true);

    // Act
    Boolean actualPreview = customerImpl.getPreview();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertTrue(actualPreview);
  }

  /**
   * Test {@link CustomerImpl#getPreview()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) Preview is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#getPreview()}
   */
  @Test
  public void testGetPreview_givenCustomerImplPreviewIsFalse_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");
    customerImpl.setPreview(false);

    // Act
    Boolean actualPreview = customerImpl.getPreview();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertFalse(actualPreview);
  }

  /**
   * Test {@link CustomerImpl#getPreview()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#getPreview()}
   */
  @Test
  public void testGetPreview_givenCustomerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CustomerImpl()).getPreview());
  }

  /**
   * Test {@link CustomerImpl#setPreview(Boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setPreview(Boolean)}
   */
  @Test
  public void testSetPreview_givenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    // Act
    customerImpl.setPreview(true);

    // Assert
    assertTrue(customerImpl.previewable.getPreview());
    assertTrue(customerImpl.getPreview());
  }

  /**
   * Test {@link CustomerImpl#setPreview(Boolean)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) ChallengeQuestion is
   * {@link ChallengeQuestionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setPreview(Boolean)}
   */
  @Test
  public void testSetPreview_givenCustomerImplChallengeQuestionIsChallengeQuestionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setChallengeQuestion(mock(ChallengeQuestionImpl.class));

    // Act
    customerImpl.setPreview(true);

    // Assert
    assertTrue(customerImpl.previewable.getPreview());
    assertTrue(customerImpl.getPreview());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}, and
   * {@link CustomerImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerImpl#equals(Object)}
   *   <li>{@link CustomerImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customerImpl2 = new CustomerImpl();
    customerImpl2.setAuditable(auditable2);
    customerImpl2.setChallengeAnswer("Challenge Answer");
    customerImpl2.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl2.setCustomerAddresses(new ArrayList<>());
    customerImpl2.setCustomerAttributes(new HashMap<>());
    customerImpl2.setCustomerLocale(new LocaleImpl());
    customerImpl2.setCustomerPayments(new ArrayList<>());
    customerImpl2.setCustomerPhones(new ArrayList<>());
    customerImpl2.setDeactivated(true);
    customerImpl2.setEmailAddress("42 Main St");
    customerImpl2.setExternalId("42");
    customerImpl2.setFirstName("Jane");
    customerImpl2.setId(1L);
    customerImpl2.setLastName("Doe");
    customerImpl2.setPassword("iloveyou");
    customerImpl2.setPasswordChangeRequired(true);
    customerImpl2.setReceiveEmail(true);
    customerImpl2.setRegistered(true);
    customerImpl2.setUnencodedChallengeAnswer("secret");
    customerImpl2.setUnencodedPassword("secret");
    customerImpl2.setUsername("janedoe");

    // Act and Assert
    assertEquals(customerImpl, customerImpl2);
    int expectedHashCodeResult = customerImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerImpl2.hashCode());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}, and
   * {@link CustomerImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerImpl#equals(Object)}
   *   <li>{@link CustomerImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customerImpl2 = new CustomerImpl();
    customerImpl2.setAuditable(auditable2);
    customerImpl2.setChallengeAnswer("Challenge Answer");
    customerImpl2.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl2.setCustomerAddresses(new ArrayList<>());
    customerImpl2.setCustomerAttributes(new HashMap<>());
    customerImpl2.setCustomerLocale(new LocaleImpl());
    customerImpl2.setCustomerPayments(new ArrayList<>());
    customerImpl2.setCustomerPhones(new ArrayList<>());
    customerImpl2.setDeactivated(true);
    customerImpl2.setEmailAddress("42 Main St");
    customerImpl2.setExternalId("42");
    customerImpl2.setFirstName("Jane");
    customerImpl2.setId(1L);
    customerImpl2.setLastName("Doe");
    customerImpl2.setPassword("iloveyou");
    customerImpl2.setPasswordChangeRequired(true);
    customerImpl2.setReceiveEmail(true);
    customerImpl2.setRegistered(true);
    customerImpl2.setUnencodedChallengeAnswer("secret");
    customerImpl2.setUnencodedPassword("secret");
    customerImpl2.setUsername("janedoe");

    // Act and Assert
    assertEquals(customerImpl, customerImpl2);
    int expectedHashCodeResult = customerImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerImpl2.hashCode());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}, and
   * {@link CustomerImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerImpl#equals(Object)}
   *   <li>{@link CustomerImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(null);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customerImpl2 = new CustomerImpl();
    customerImpl2.setAuditable(auditable2);
    customerImpl2.setChallengeAnswer("Challenge Answer");
    customerImpl2.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl2.setCustomerAddresses(new ArrayList<>());
    customerImpl2.setCustomerAttributes(new HashMap<>());
    customerImpl2.setCustomerLocale(new LocaleImpl());
    customerImpl2.setCustomerPayments(new ArrayList<>());
    customerImpl2.setCustomerPhones(new ArrayList<>());
    customerImpl2.setDeactivated(true);
    customerImpl2.setEmailAddress("42 Main St");
    customerImpl2.setExternalId("42");
    customerImpl2.setFirstName("Jane");
    customerImpl2.setId(1L);
    customerImpl2.setLastName("Doe");
    customerImpl2.setPassword("iloveyou");
    customerImpl2.setPasswordChangeRequired(true);
    customerImpl2.setReceiveEmail(true);
    customerImpl2.setRegistered(true);
    customerImpl2.setUnencodedChallengeAnswer("secret");
    customerImpl2.setUnencodedPassword("secret");
    customerImpl2.setUsername("janedoe");

    // Act and Assert
    assertEquals(customerImpl, customerImpl2);
    int expectedHashCodeResult = customerImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerImpl2.hashCode());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}, and
   * {@link CustomerImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerImpl#equals(Object)}
   *   <li>{@link CustomerImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customerImpl2 = new CustomerImpl();
    customerImpl2.setAuditable(auditable2);
    customerImpl2.setChallengeAnswer("Challenge Answer");
    customerImpl2.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl2.setCustomerAddresses(new ArrayList<>());
    customerImpl2.setCustomerAttributes(new HashMap<>());
    customerImpl2.setCustomerLocale(new LocaleImpl());
    customerImpl2.setCustomerPayments(new ArrayList<>());
    customerImpl2.setCustomerPhones(new ArrayList<>());
    customerImpl2.setDeactivated(true);
    customerImpl2.setEmailAddress("42 Main St");
    customerImpl2.setExternalId("42");
    customerImpl2.setFirstName("Jane");
    customerImpl2.setId(null);
    customerImpl2.setLastName("Doe");
    customerImpl2.setPassword("iloveyou");
    customerImpl2.setPasswordChangeRequired(true);
    customerImpl2.setReceiveEmail(true);
    customerImpl2.setRegistered(true);
    customerImpl2.setUnencodedChallengeAnswer("secret");
    customerImpl2.setUnencodedPassword("secret");
    customerImpl2.setUsername("janedoe");

    // Act and Assert
    assertEquals(customerImpl, customerImpl2);
    int expectedHashCodeResult = customerImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerImpl2.hashCode());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}, and
   * {@link CustomerImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerImpl#equals(Object)}
   *   <li>{@link CustomerImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act and Assert
    assertEquals(customerImpl, customerImpl);
    int expectedHashCodeResult = customerImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerImpl.hashCode());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(2L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customerImpl2 = new CustomerImpl();
    customerImpl2.setAuditable(auditable2);
    customerImpl2.setChallengeAnswer("Challenge Answer");
    customerImpl2.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl2.setCustomerAddresses(new ArrayList<>());
    customerImpl2.setCustomerAttributes(new HashMap<>());
    customerImpl2.setCustomerLocale(new LocaleImpl());
    customerImpl2.setCustomerPayments(new ArrayList<>());
    customerImpl2.setCustomerPhones(new ArrayList<>());
    customerImpl2.setDeactivated(true);
    customerImpl2.setEmailAddress("42 Main St");
    customerImpl2.setExternalId("42");
    customerImpl2.setFirstName("Jane");
    customerImpl2.setId(1L);
    customerImpl2.setLastName("Doe");
    customerImpl2.setPassword("iloveyou");
    customerImpl2.setPasswordChangeRequired(true);
    customerImpl2.setReceiveEmail(true);
    customerImpl2.setRegistered(true);
    customerImpl2.setUnencodedChallengeAnswer("secret");
    customerImpl2.setUnencodedPassword("secret");
    customerImpl2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(customerImpl, customerImpl2);
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(customerImpl, null);
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(customerImpl, "Different type to CustomerImpl");
  }

  /**
   * Test
   * {@link CustomerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CustomerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Customer> actualCreateOrRetrieveCopyInstanceResult = customerImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CustomerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then Clone return {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenJavaLangObject_thenCloneReturnCustomerImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<Customer> actualCreateOrRetrieveCopyInstanceResult = customerImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.profile.core.domain.CustomerImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    Customer clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CustomerImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(customerImpl, clone);
  }

  /**
   * Test {@link CustomerImpl#setTaxExemptionCode(String)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setTaxExemptionCode(String)}
   */
  @Test
  public void testSetTaxExemptionCode_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act
    customerImpl.setTaxExemptionCode(null);

    // Assert
    assertNull(customerImpl.getTaxExemptionCode());
    assertFalse(customerImpl.isTaxExempt);
  }

  /**
   * Test {@link CustomerImpl#setTaxExemptionCode(String)}.
   * <ul>
   *   <li>Then calls {@link Auditable#setCreatedBy(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setTaxExemptionCode(String)}
   */
  @Test
  public void testSetTaxExemptionCode_thenCallsSetCreatedBy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setAuditable(auditable);
    customerImpl.setChallengeAnswer("Challenge Answer");
    customerImpl.setChallengeQuestion(new ChallengeQuestionImpl());
    customerImpl.setCustomerAddresses(new ArrayList<>());
    customerImpl.setCustomerAttributes(new HashMap<>());
    customerImpl.setCustomerLocale(new LocaleImpl());
    customerImpl.setCustomerPayments(new ArrayList<>());
    customerImpl.setCustomerPhones(new ArrayList<>());
    customerImpl.setDeactivated(true);
    customerImpl.setEmailAddress("42 Main St");
    customerImpl.setExternalId("42");
    customerImpl.setFirstName("Jane");
    customerImpl.setId(1L);
    customerImpl.setLastName("Doe");
    customerImpl.setPassword("iloveyou");
    customerImpl.setPasswordChangeRequired(true);
    customerImpl.setReceiveEmail(true);
    customerImpl.setRegistered(true);
    customerImpl.setUnencodedChallengeAnswer("secret");
    customerImpl.setUnencodedPassword("secret");
    customerImpl.setUsername("janedoe");

    // Act
    customerImpl.setTaxExemptionCode(null);

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    assertNull(customerImpl.getTaxExemptionCode());
    assertFalse(customerImpl.isTaxExempt);
  }

  /**
   * Test {@link CustomerImpl#setTaxExemptionCode(String)}.
   * <ul>
   *   <li>Then {@link CustomerImpl} (default constructor) TaxExemptionCode is
   * {@code Exemption}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#setTaxExemptionCode(String)}
   */
  @Test
  public void testSetTaxExemptionCode_thenCustomerImplTaxExemptionCodeIsExemption() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    // Act
    customerImpl.setTaxExemptionCode("Exemption");

    // Assert
    assertEquals("Exemption", customerImpl.getTaxExemptionCode());
    assertTrue(customerImpl.isTaxExempt);
  }

  /**
   * Test {@link CustomerImpl#isTaxExempt()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isTaxExempt()}
   */
  @Test
  public void testIsTaxExempt_givenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new CustomerImpl()).isTaxExempt());
  }

  /**
   * Test {@link CustomerImpl#isTaxExempt()}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) ChallengeQuestion is
   * {@link ChallengeQuestionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerImpl#isTaxExempt()}
   */
  @Test
  public void testIsTaxExempt_givenCustomerImplChallengeQuestionIsChallengeQuestionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    customerImpl.setChallengeQuestion(mock(ChallengeQuestionImpl.class));

    // Act and Assert
    assertFalse(customerImpl.isTaxExempt());
  }

  /**
   * Test new {@link CustomerImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link CustomerImpl}
   */
  @Test
  public void testNewCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CustomerImpl actualCustomerImpl = new CustomerImpl();

    // Assert
    assertEquals("null", actualCustomerImpl.getMainEntityName());
    assertNull(actualCustomerImpl.previewable.getPreview());
    assertNull(actualCustomerImpl.getPreview());
    Auditable auditable = actualCustomerImpl.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(actualCustomerImpl.getId());
    assertNull(actualCustomerImpl.getChallengeAnswer());
    assertNull(actualCustomerImpl.getEmailAddress());
    assertNull(actualCustomerImpl.getExternalId());
    assertNull(actualCustomerImpl.getFirstName());
    assertNull(actualCustomerImpl.getLastName());
    assertNull(actualCustomerImpl.getPassword());
    assertNull(actualCustomerImpl.getTaxExemptionCode());
    assertNull(actualCustomerImpl.getUnencodedChallengeAnswer());
    assertNull(actualCustomerImpl.getUnencodedPassword());
    assertNull(actualCustomerImpl.getUsername());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(actualCustomerImpl.getCustomerLocale());
    assertNull(actualCustomerImpl.getChallengeQuestion());
    assertFalse(actualCustomerImpl.isAnonymous());
    assertFalse(actualCustomerImpl.isCookied());
    assertFalse(actualCustomerImpl.isDeactivated());
    assertFalse(actualCustomerImpl.isLoggedIn());
    assertFalse(actualCustomerImpl.isPasswordChangeRequired());
    assertFalse(actualCustomerImpl.isReceiveEmail());
    assertFalse(actualCustomerImpl.isRegistered());
    assertFalse(actualCustomerImpl.deactivated);
    assertFalse(actualCustomerImpl.isTaxExempt);
    assertFalse(actualCustomerImpl.passwordChangeRequired);
    assertFalse(actualCustomerImpl.receiveEmail);
    assertFalse(actualCustomerImpl.registered);
    assertTrue(actualCustomerImpl.getCustomerAddresses().isEmpty());
    assertTrue(actualCustomerImpl.getCustomerPayments().isEmpty());
    assertTrue(actualCustomerImpl.getCustomerPhones().isEmpty());
    assertTrue(actualCustomerImpl.getCustomerAttributes().isEmpty());
    assertTrue(actualCustomerImpl.getTransientProperties().isEmpty());
  }
}
