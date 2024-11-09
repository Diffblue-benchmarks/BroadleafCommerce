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
package org.broadleafcommerce.profile.core.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestion;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class EmailNotificationPasswordUpdatedHandlerDiffblueTest {
  /**
   * Test
   * {@link EmailNotificationPasswordUpdatedHandler#constructPasswordChangeEmailTemplateVariables(Customer, String)}.
   * <ul>
   *   <li>Given {@link ChallengeQuestion}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EmailNotificationPasswordUpdatedHandler#constructPasswordChangeEmailTemplateVariables(Customer, String)}
   */
  @Test
  public void testConstructPasswordChangeEmailTemplateVariables_givenChallengeQuestion() {
    // Arrange
    EmailNotificationPasswordUpdatedHandler emailNotificationPasswordUpdatedHandler = new EmailNotificationPasswordUpdatedHandler();

    CustomerImpl customer = new CustomerImpl();
    customer.setChallengeQuestion(mock(ChallengeQuestion.class));

    // Act
    HashMap actualConstructPasswordChangeEmailTemplateVariablesResult = emailNotificationPasswordUpdatedHandler
        .constructPasswordChangeEmailTemplateVariables(customer, "iloveyou");

    // Assert
    assertEquals(1, actualConstructPasswordChangeEmailTemplateVariablesResult.size());
    assertEquals("iloveyou", actualConstructPasswordChangeEmailTemplateVariablesResult
        .get(EmailNotificationPasswordUpdatedHandler.CUSTOMER_PASSWORD_TEMPLATE_VARIABLE));
  }

  /**
   * Test
   * {@link EmailNotificationPasswordUpdatedHandler#constructPasswordChangeEmailTemplateVariables(Customer, String)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EmailNotificationPasswordUpdatedHandler#constructPasswordChangeEmailTemplateVariables(Customer, String)}
   */
  @Test
  public void testConstructPasswordChangeEmailTemplateVariables_whenCustomerImpl() {
    // Arrange
    EmailNotificationPasswordUpdatedHandler emailNotificationPasswordUpdatedHandler = new EmailNotificationPasswordUpdatedHandler();

    // Act
    HashMap actualConstructPasswordChangeEmailTemplateVariablesResult = emailNotificationPasswordUpdatedHandler
        .constructPasswordChangeEmailTemplateVariables(new CustomerImpl(), "iloveyou");

    // Assert
    assertEquals(1, actualConstructPasswordChangeEmailTemplateVariablesResult.size());
    assertEquals("iloveyou", actualConstructPasswordChangeEmailTemplateVariablesResult
        .get(EmailNotificationPasswordUpdatedHandler.CUSTOMER_PASSWORD_TEMPLATE_VARIABLE));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EmailNotificationPasswordUpdatedHandler#setPasswordResetEmailDefaultLocale(Locale)}
   *   <li>
   * {@link EmailNotificationPasswordUpdatedHandler#setPasswordResetEmailFromAddress(String)}
   *   <li>
   * {@link EmailNotificationPasswordUpdatedHandler#setPasswordResetEmailSubject(Map)}
   *   <li>
   * {@link EmailNotificationPasswordUpdatedHandler#setPasswordResetEmailTemplate(Map)}
   *   <li>
   * {@link EmailNotificationPasswordUpdatedHandler#getPasswordResetEmailDefaultLocale()}
   *   <li>
   * {@link EmailNotificationPasswordUpdatedHandler#getPasswordResetEmailFromAddress()}
   *   <li>
   * {@link EmailNotificationPasswordUpdatedHandler#getPasswordResetEmailSubject()}
   *   <li>
   * {@link EmailNotificationPasswordUpdatedHandler#getPasswordResetEmailTemplate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EmailNotificationPasswordUpdatedHandler emailNotificationPasswordUpdatedHandler = new EmailNotificationPasswordUpdatedHandler();

    // Act
    emailNotificationPasswordUpdatedHandler.setPasswordResetEmailDefaultLocale(Locale.getDefault());
    emailNotificationPasswordUpdatedHandler.setPasswordResetEmailFromAddress("42 Main St");
    HashMap<Locale, String> passwordResetEmailSubject = new HashMap<>();
    emailNotificationPasswordUpdatedHandler.setPasswordResetEmailSubject(passwordResetEmailSubject);
    HashMap<Locale, String> passwordResetEmailTemplate = new HashMap<>();
    emailNotificationPasswordUpdatedHandler.setPasswordResetEmailTemplate(passwordResetEmailTemplate);
    Locale actualPasswordResetEmailDefaultLocale = emailNotificationPasswordUpdatedHandler
        .getPasswordResetEmailDefaultLocale();
    String actualPasswordResetEmailFromAddress = emailNotificationPasswordUpdatedHandler
        .getPasswordResetEmailFromAddress();
    Map<Locale, String> actualPasswordResetEmailSubject = emailNotificationPasswordUpdatedHandler
        .getPasswordResetEmailSubject();
    Map<Locale, String> actualPasswordResetEmailTemplate = emailNotificationPasswordUpdatedHandler
        .getPasswordResetEmailTemplate();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualPasswordResetEmailFromAddress);
    assertTrue(actualPasswordResetEmailSubject.isEmpty());
    assertTrue(actualPasswordResetEmailTemplate.isEmpty());
    assertSame(passwordResetEmailSubject, actualPasswordResetEmailSubject);
    assertSame(passwordResetEmailTemplate, actualPasswordResetEmailTemplate);
    assertSame(actualPasswordResetEmailDefaultLocale.UK, actualPasswordResetEmailDefaultLocale);
  }

  /**
   * Test new {@link EmailNotificationPasswordUpdatedHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link EmailNotificationPasswordUpdatedHandler}
   */
  @Test
  public void testNewEmailNotificationPasswordUpdatedHandler() throws MissingResourceException {
    // Arrange and Act
    EmailNotificationPasswordUpdatedHandler actualEmailNotificationPasswordUpdatedHandler = new EmailNotificationPasswordUpdatedHandler();

    // Assert
    Locale passwordResetEmailDefaultLocale = actualEmailNotificationPasswordUpdatedHandler
        .getPasswordResetEmailDefaultLocale();
    assertEquals("", passwordResetEmailDefaultLocale.getDisplayScript());
    assertEquals("", passwordResetEmailDefaultLocale.getDisplayVariant());
    assertEquals("", passwordResetEmailDefaultLocale.getScript());
    assertEquals("", passwordResetEmailDefaultLocale.getVariant());
    assertEquals("English (United States)", passwordResetEmailDefaultLocale.getDisplayName());
    assertEquals("English", passwordResetEmailDefaultLocale.getDisplayLanguage());
    assertEquals("US", passwordResetEmailDefaultLocale.getCountry());
    assertEquals("USA", passwordResetEmailDefaultLocale.getISO3Country());
    assertEquals("United States", passwordResetEmailDefaultLocale.getDisplayCountry());
    assertEquals("en", passwordResetEmailDefaultLocale.getLanguage());
    assertEquals("eng", passwordResetEmailDefaultLocale.getISO3Language());
    assertNull(actualEmailNotificationPasswordUpdatedHandler.getPasswordResetEmailFromAddress());
    assertNull(actualEmailNotificationPasswordUpdatedHandler.emailService);
    assertFalse(passwordResetEmailDefaultLocale.hasExtensions());
    assertTrue(actualEmailNotificationPasswordUpdatedHandler.getPasswordResetEmailSubject().isEmpty());
    assertTrue(actualEmailNotificationPasswordUpdatedHandler.getPasswordResetEmailTemplate().isEmpty());
    Set<Character> extensionKeys = passwordResetEmailDefaultLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertSame(extensionKeys, passwordResetEmailDefaultLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, passwordResetEmailDefaultLocale.getUnicodeLocaleKeys());
  }
}
