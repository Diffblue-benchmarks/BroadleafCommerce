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
package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerImplDiffblueTest {
  @Autowired private CustomerImpl customerImpl;

  /**
   * Test {@link CustomerImpl#isPasswordChangeRequired()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#isPasswordChangeRequired()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.isPasswordChangeRequired()"})
  public void testIsPasswordChangeRequired_givenCustomerImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(customerImpl.isPasswordChangeRequired());
  }

  /**
   * Test {@link CustomerImpl#isPasswordChangeRequired()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#isPasswordChangeRequired()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.isPasswordChangeRequired()"})
  public void testIsPasswordChangeRequired_thenReturnTrue() {
    // Arrange
    customerImpl.setPasswordChangeRequired(true);

    // Act and Assert
    assertTrue(customerImpl.isPasswordChangeRequired());
  }

  /**
   * Test {@link CustomerImpl#setPasswordChangeRequired(boolean)}.
   *
   * <p>Method under test: {@link CustomerImpl#setPasswordChangeRequired(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setPasswordChangeRequired(boolean)"})
  public void testSetPasswordChangeRequired() {
    // Arrange and Act
    customerImpl.setPasswordChangeRequired(true);

    // Assert
    assertTrue(customerImpl.isPasswordChangeRequired());
    assertTrue(customerImpl.passwordChangeRequired);
  }

  /**
   * Test {@link CustomerImpl#isReceiveEmail()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} ReceiveEmail is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#isReceiveEmail()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.isReceiveEmail()"})
  public void testIsReceiveEmail_givenCustomerImplReceiveEmailIsTrue_thenReturnTrue() {
    // Arrange
    customerImpl.setReceiveEmail(true);

    // Act and Assert
    assertTrue(customerImpl.isReceiveEmail());
  }

  /**
   * Test {@link CustomerImpl#isReceiveEmail()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#isReceiveEmail()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.isReceiveEmail()"})
  public void testIsReceiveEmail_givenCustomerImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(customerImpl.isReceiveEmail());
  }

  /**
   * Test {@link CustomerImpl#setReceiveEmail(boolean)}.
   *
   * <p>Method under test: {@link CustomerImpl#setReceiveEmail(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setReceiveEmail(boolean)"})
  public void testSetReceiveEmail() {
    // Arrange and Act
    customerImpl.setReceiveEmail(true);

    // Assert
    assertTrue(customerImpl.isReceiveEmail());
    assertTrue(customerImpl.receiveEmail);
  }

  /**
   * Test {@link CustomerImpl#isRegistered()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} Registered is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#isRegistered()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.isRegistered()"})
  public void testIsRegistered_givenCustomerImplRegisteredIsTrue_thenReturnTrue() {
    // Arrange
    customerImpl.setRegistered(true);

    // Act and Assert
    assertTrue(customerImpl.isRegistered());
  }

  /**
   * Test {@link CustomerImpl#isRegistered()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#isRegistered()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.isRegistered()"})
  public void testIsRegistered_givenCustomerImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(customerImpl.isRegistered());
  }

  /**
   * Test {@link CustomerImpl#setRegistered(boolean)}.
   *
   * <p>Method under test: {@link CustomerImpl#setRegistered(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setRegistered(boolean)"})
  public void testSetRegistered() {
    // Arrange and Act
    customerImpl.setRegistered(true);

    // Assert
    assertTrue(customerImpl.isRegistered());
    assertTrue(customerImpl.registered);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Auditable CustomerImpl.getAuditable()",
    "String CustomerImpl.getChallengeAnswer()",
    "ChallengeQuestion CustomerImpl.getChallengeQuestion()",
    "List CustomerImpl.getCustomerAddresses()",
    "Map CustomerImpl.getCustomerAttributes()",
    "Locale CustomerImpl.getCustomerLocale()",
    "List CustomerImpl.getCustomerPayments()",
    "List CustomerImpl.getCustomerPhones()",
    "String CustomerImpl.getEmailAddress()",
    "String CustomerImpl.getExternalId()",
    "String CustomerImpl.getFirstName()",
    "Long CustomerImpl.getId()",
    "String CustomerImpl.getLastName()",
    "String CustomerImpl.getPassword()",
    "String CustomerImpl.getTaxExemptionCode()",
    "Map CustomerImpl.getTransientProperties()",
    "String CustomerImpl.getUnencodedChallengeAnswer()",
    "String CustomerImpl.getUnencodedPassword()",
    "String CustomerImpl.getUsername()",
    "boolean CustomerImpl.isAnonymous()",
    "boolean CustomerImpl.isCookied()",
    "boolean CustomerImpl.isLoggedIn()",
    "void CustomerImpl.setAuditable(Auditable)",
    "void CustomerImpl.setChallengeAnswer(String)",
    "void CustomerImpl.setChallengeQuestion(ChallengeQuestion)",
    "void CustomerImpl.setCustomerAddresses(List)",
    "void CustomerImpl.setCustomerAttributes(Map)",
    "void CustomerImpl.setCustomerLocale(Locale)",
    "void CustomerImpl.setCustomerPayments(List)",
    "void CustomerImpl.setCustomerPhones(List)",
    "void CustomerImpl.setEmailAddress(String)",
    "void CustomerImpl.setExternalId(String)",
    "void CustomerImpl.setFirstName(String)",
    "void CustomerImpl.setId(Long)",
    "void CustomerImpl.setLastName(String)",
    "void CustomerImpl.setPassword(String)",
    "void CustomerImpl.setUnencodedChallengeAnswer(String)",
    "void CustomerImpl.setUnencodedPassword(String)",
    "void CustomerImpl.setUsername(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    String actualTaxExemptionCode = customerImpl.getTaxExemptionCode();
    Map<String, Object> actualTransientProperties = customerImpl.getTransientProperties();
    String actualUnencodedChallengeAnswer = customerImpl.getUnencodedChallengeAnswer();
    String actualUnencodedPassword = customerImpl.getUnencodedPassword();
    String actualUsername = customerImpl.getUsername();
    boolean actualIsAnonymousResult = customerImpl.isAnonymous();
    boolean actualIsCookiedResult = customerImpl.isCookied();
    boolean actualIsLoggedInResult = customerImpl.isLoggedIn();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("42", actualExternalId);
    assertEquals("Challenge Answer", actualChallengeAnswer);
    assertEquals("Doe", actualLastName);
    assertEquals("Jane", actualFirstName);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
    assertEquals("secret", actualUnencodedChallengeAnswer);
    assertEquals("secret", actualUnencodedPassword);
    assertNull(actualTaxExemptionCode);
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
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link CustomerImpl} Anonymous.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#setAnonymous(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setAnonymous(boolean)"})
  public void testSetAnonymous_whenFalse_thenNotCustomerImplAnonymous() {
    // Arrange and Act
    customerImpl.setAnonymous(false);

    // Assert that nothing has changed
    assertFalse(customerImpl.isAnonymous());
  }

  /**
   * Test {@link CustomerImpl#setAnonymous(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link CustomerImpl} Anonymous.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#setAnonymous(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setAnonymous(boolean)"})
  public void testSetAnonymous_whenTrue_thenCustomerImplAnonymous() {
    // Arrange and Act
    customerImpl.setAnonymous(true);

    // Assert
    assertTrue(customerImpl.isAnonymous());
  }

  /**
   * Test {@link CustomerImpl#setCookied(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link CustomerImpl} Cookied.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#setCookied(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setCookied(boolean)"})
  public void testSetCookied_whenFalse_thenNotCustomerImplCookied() {
    // Arrange and Act
    customerImpl.setCookied(false);

    // Assert that nothing has changed
    assertFalse(customerImpl.isCookied());
  }

  /**
   * Test {@link CustomerImpl#setCookied(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link CustomerImpl} Cookied.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#setCookied(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setCookied(boolean)"})
  public void testSetCookied_whenTrue_thenCustomerImplCookied() {
    // Arrange and Act
    customerImpl.setCookied(true);

    // Assert
    assertTrue(customerImpl.isCookied());
  }

  /**
   * Test {@link CustomerImpl#setLoggedIn(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link CustomerImpl} LoggedIn.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#setLoggedIn(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setLoggedIn(boolean)"})
  public void testSetLoggedIn_whenFalse_thenNotCustomerImplLoggedIn() {
    // Arrange and Act
    customerImpl.setLoggedIn(false);

    // Assert that nothing has changed
    assertFalse(customerImpl.isLoggedIn());
  }

  /**
   * Test {@link CustomerImpl#setLoggedIn(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link CustomerImpl} LoggedIn.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#setLoggedIn(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setLoggedIn(boolean)"})
  public void testSetLoggedIn_whenTrue_thenCustomerImplLoggedIn() {
    // Arrange and Act
    customerImpl.setLoggedIn(true);

    // Assert
    assertTrue(customerImpl.isLoggedIn());
  }

  /**
   * Test {@link CustomerImpl#isDeactivated()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} Deactivated is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#isDeactivated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.isDeactivated()"})
  public void testIsDeactivated_givenCustomerImplDeactivatedIsTrue_thenReturnTrue() {
    // Arrange
    customerImpl.setDeactivated(true);

    // Act and Assert
    assertTrue(customerImpl.isDeactivated());
  }

  /**
   * Test {@link CustomerImpl#isDeactivated()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#isDeactivated()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.isDeactivated()"})
  public void testIsDeactivated_givenCustomerImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(customerImpl.isDeactivated());
  }

  /**
   * Test {@link CustomerImpl#setDeactivated(boolean)}.
   *
   * <p>Method under test: {@link CustomerImpl#setDeactivated(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setDeactivated(boolean)"})
  public void testSetDeactivated() {
    // Arrange and Act
    customerImpl.setDeactivated(true);

    // Assert
    assertTrue(customerImpl.isDeactivated());
    assertTrue(customerImpl.deactivated);
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} FirstName is empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplFirstNameIsEmptyString_thenReturnNull() {
    // Arrange
    customerImpl.setFirstName("");
    customerImpl.setLastName("");
    customerImpl.setUsername("");

    // Act and Assert
    assertEquals("null", customerImpl.getMainEntityName());
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} FirstName is {@code foo}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplFirstNameIsFoo_thenReturnNull() {
    // Arrange
    customerImpl.setFirstName("foo");
    customerImpl.setLastName("");
    customerImpl.setUsername("");

    // Act and Assert
    assertEquals("null", customerImpl.getMainEntityName());
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} LastName is {@code foo}.
   *   <li>Then return {@code foo foo}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplLastNameIsFoo_thenReturnFooFoo() {
    // Arrange
    customerImpl.setFirstName("foo");
    customerImpl.setLastName("foo");
    customerImpl.setUsername("");

    // Act and Assert
    assertEquals("foo foo", customerImpl.getMainEntityName());
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} Username is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImplUsernameIsFoo_thenReturnFoo() {
    // Arrange
    customerImpl.setFirstName("");
    customerImpl.setLastName("");
    customerImpl.setUsername("foo");

    // Act and Assert
    assertEquals("foo", customerImpl.getMainEntityName());
  }

  /**
   * Test {@link CustomerImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCustomerImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", customerImpl.getMainEntityName());
  }

  /**
   * Test {@link CustomerImpl#getPreview()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} Preview is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#getPreview()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CustomerImpl.getPreview()"})
  public void testGetPreview_givenCustomerImplPreviewIsFalse_thenReturnFalse() {
    // Arrange
    customerImpl.setPreview(false);

    // Act and Assert
    assertFalse(customerImpl.getPreview());
  }

  /**
   * Test {@link CustomerImpl#getPreview()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl} Preview is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#getPreview()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CustomerImpl.getPreview()"})
  public void testGetPreview_givenCustomerImplPreviewIsTrue_thenReturnTrue() {
    // Arrange
    customerImpl.setPreview(true);

    // Act and Assert
    assertTrue(customerImpl.getPreview());
  }

  /**
   * Test {@link CustomerImpl#getPreview()}.
   *
   * <ul>
   *   <li>Given {@link CustomerImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#getPreview()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CustomerImpl.getPreview()"})
  public void testGetPreview_givenCustomerImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(customerImpl.getPreview());
  }

  /**
   * Test {@link CustomerImpl#setPreview(Boolean)}.
   *
   * <p>Method under test: {@link CustomerImpl#setPreview(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setPreview(Boolean)"})
  public void testSetPreview() {
    // Arrange and Act
    customerImpl.setPreview(true);

    // Assert
    assertTrue(customerImpl.previewable.getPreview());
    assertTrue(customerImpl.getPreview());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}, and {@link CustomerImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerImpl#equals(Object)}
   *   <li>{@link CustomerImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.equals(Object)", "int CustomerImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals(customerImpl.hashCode(), customerImpl2.hashCode());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}, and {@link CustomerImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerImpl#equals(Object)}
   *   <li>{@link CustomerImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.equals(Object)", "int CustomerImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals(customerImpl.hashCode(), customerImpl2.hashCode());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}, and {@link CustomerImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerImpl#equals(Object)}
   *   <li>{@link CustomerImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.equals(Object)", "int CustomerImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals(customerImpl.hashCode(), customerImpl2.hashCode());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}, and {@link CustomerImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerImpl#equals(Object)}
   *   <li>{@link CustomerImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.equals(Object)", "int CustomerImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    customerImpl.setUsername(null);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    customerImpl2.setUsername(null);

    // Act and Assert
    assertEquals(customerImpl, customerImpl2);
    assertEquals(customerImpl.hashCode(), customerImpl2.hashCode());
  }

  /**
   * Test {@link CustomerImpl#equals(Object)}, and {@link CustomerImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CustomerImpl#equals(Object)}
   *   <li>{@link CustomerImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.equals(Object)", "int CustomerImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.equals(Object)", "int CustomerImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.equals(Object)", "int CustomerImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    customerImpl.setUsername("Username");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.equals(Object)", "int CustomerImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    customerImpl.setUsername(null);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.equals(Object)", "int CustomerImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.equals(Object)", "int CustomerImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * Test {@link CustomerImpl#setTaxExemptionCode(String)}.
   *
   * <ul>
   *   <li>Then {@link CustomerImpl} TaxExemptionCode is {@code Exemption}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#setTaxExemptionCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setTaxExemptionCode(String)"})
  public void testSetTaxExemptionCode_thenCustomerImplTaxExemptionCodeIsExemption() {
    // Arrange and Act
    customerImpl.setTaxExemptionCode("Exemption");

    // Assert
    assertEquals("Exemption", customerImpl.getTaxExemptionCode());
    assertTrue(customerImpl.isTaxExempt);
  }

  /**
   * Test {@link CustomerImpl#setTaxExemptionCode(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then not {@link CustomerImpl} {@link CustomerImpl#isTaxExempt}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerImpl#setTaxExemptionCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.setTaxExemptionCode(String)"})
  public void testSetTaxExemptionCode_whenNull_thenNotCustomerImplIsTaxExempt() {
    // Arrange and Act
    customerImpl.setTaxExemptionCode(null);

    // Assert that nothing has changed
    assertFalse(customerImpl.isTaxExempt);
  }

  /**
   * Test {@link CustomerImpl#isTaxExempt()}.
   *
   * <p>Method under test: {@link CustomerImpl#isTaxExempt()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomerImpl.isTaxExempt()"})
  public void testIsTaxExempt() {
    // Arrange, Act and Assert
    assertFalse(customerImpl.isTaxExempt());
  }

  /**
   * Test new {@link CustomerImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CustomerImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerImpl.<init>()"})
  public void testNewCustomerImpl() {
    // Arrange and Act
    CustomerImpl actualCustomerImpl = new CustomerImpl();

    // Assert
    assertEquals("null", actualCustomerImpl.getMainEntityName());
    assertNull(actualCustomerImpl.getPreview());
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
