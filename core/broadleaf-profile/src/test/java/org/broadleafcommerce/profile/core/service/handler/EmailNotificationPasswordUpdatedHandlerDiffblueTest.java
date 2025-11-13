package org.broadleafcommerce.profile.core.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EmailNotificationPasswordUpdatedHandlerDiffblueTest {
  /**
   * Test {@link
   * EmailNotificationPasswordUpdatedHandler#constructPasswordChangeEmailTemplateVariables(Customer,
   * String)}.
   *
   * <p>Method under test: {@link
   * EmailNotificationPasswordUpdatedHandler#constructPasswordChangeEmailTemplateVariables(Customer,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HashMap EmailNotificationPasswordUpdatedHandler.constructPasswordChangeEmailTemplateVariables(Customer, String)"
  })
  public void testConstructPasswordChangeEmailTemplateVariables() {
    // Arrange
    EmailNotificationPasswordUpdatedHandler emailNotificationPasswordUpdatedHandler =
        new EmailNotificationPasswordUpdatedHandler();

    // Act
    HashMap actualConstructPasswordChangeEmailTemplateVariablesResult =
        emailNotificationPasswordUpdatedHandler.constructPasswordChangeEmailTemplateVariables(
            new CustomerImpl(), "iloveyou");

    // Assert
    assertEquals(1, actualConstructPasswordChangeEmailTemplateVariablesResult.size());
    assertEquals(
        "iloveyou",
        actualConstructPasswordChangeEmailTemplateVariablesResult.get(
            EmailNotificationPasswordUpdatedHandler.CUSTOMER_PASSWORD_TEMPLATE_VARIABLE));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       EmailNotificationPasswordUpdatedHandler#setPasswordResetEmailDefaultLocale(Locale)}
   *   <li>{@link EmailNotificationPasswordUpdatedHandler#setPasswordResetEmailFromAddress(String)}
   *   <li>{@link EmailNotificationPasswordUpdatedHandler#setPasswordResetEmailSubject(Map)}
   *   <li>{@link EmailNotificationPasswordUpdatedHandler#setPasswordResetEmailTemplate(Map)}
   *   <li>{@link EmailNotificationPasswordUpdatedHandler#getPasswordResetEmailDefaultLocale()}
   *   <li>{@link EmailNotificationPasswordUpdatedHandler#getPasswordResetEmailFromAddress()}
   *   <li>{@link EmailNotificationPasswordUpdatedHandler#getPasswordResetEmailSubject()}
   *   <li>{@link EmailNotificationPasswordUpdatedHandler#getPasswordResetEmailTemplate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Locale EmailNotificationPasswordUpdatedHandler.getPasswordResetEmailDefaultLocale()",
    "String EmailNotificationPasswordUpdatedHandler.getPasswordResetEmailFromAddress()",
    "Map EmailNotificationPasswordUpdatedHandler.getPasswordResetEmailSubject()",
    "Map EmailNotificationPasswordUpdatedHandler.getPasswordResetEmailTemplate()",
    "void EmailNotificationPasswordUpdatedHandler.setPasswordResetEmailDefaultLocale(Locale)",
    "void EmailNotificationPasswordUpdatedHandler.setPasswordResetEmailFromAddress(String)",
    "void EmailNotificationPasswordUpdatedHandler.setPasswordResetEmailSubject(Map)",
    "void EmailNotificationPasswordUpdatedHandler.setPasswordResetEmailTemplate(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange
    EmailNotificationPasswordUpdatedHandler emailNotificationPasswordUpdatedHandler =
        new EmailNotificationPasswordUpdatedHandler();

    // Act
    emailNotificationPasswordUpdatedHandler.setPasswordResetEmailDefaultLocale(Locale.getDefault());
    emailNotificationPasswordUpdatedHandler.setPasswordResetEmailFromAddress("42 Main St");
    HashMap<Locale, String> passwordResetEmailSubject = new HashMap<>();
    emailNotificationPasswordUpdatedHandler.setPasswordResetEmailSubject(passwordResetEmailSubject);
    HashMap<Locale, String> passwordResetEmailTemplate = new HashMap<>();
    emailNotificationPasswordUpdatedHandler.setPasswordResetEmailTemplate(
        passwordResetEmailTemplate);
    Locale actualPasswordResetEmailDefaultLocale =
        emailNotificationPasswordUpdatedHandler.getPasswordResetEmailDefaultLocale();
    String actualPasswordResetEmailFromAddress =
        emailNotificationPasswordUpdatedHandler.getPasswordResetEmailFromAddress();
    Map<Locale, String> actualPasswordResetEmailSubject =
        emailNotificationPasswordUpdatedHandler.getPasswordResetEmailSubject();
    Map<Locale, String> actualPasswordResetEmailTemplate =
        emailNotificationPasswordUpdatedHandler.getPasswordResetEmailTemplate();

    // Assert
    assertEquals("42 Main St", actualPasswordResetEmailFromAddress);
    assertTrue(actualPasswordResetEmailSubject.isEmpty());
    assertTrue(actualPasswordResetEmailTemplate.isEmpty());
    assertSame(passwordResetEmailSubject, actualPasswordResetEmailSubject);
    assertSame(passwordResetEmailTemplate, actualPasswordResetEmailTemplate);
    assertSame(Locale.ENGLISH, actualPasswordResetEmailDefaultLocale);
  }

  /**
   * Test new {@link EmailNotificationPasswordUpdatedHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * EmailNotificationPasswordUpdatedHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmailNotificationPasswordUpdatedHandler.<init>()"})
  public void testNewEmailNotificationPasswordUpdatedHandler() throws MissingResourceException {
    // Arrange and Act
    EmailNotificationPasswordUpdatedHandler actualEmailNotificationPasswordUpdatedHandler =
        new EmailNotificationPasswordUpdatedHandler();

    // Assert
    Locale passwordResetEmailDefaultLocale =
        actualEmailNotificationPasswordUpdatedHandler.getPasswordResetEmailDefaultLocale();
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
    assertTrue(
        actualEmailNotificationPasswordUpdatedHandler.getPasswordResetEmailSubject().isEmpty());
    assertTrue(
        actualEmailNotificationPasswordUpdatedHandler.getPasswordResetEmailTemplate().isEmpty());
    Set<Character> extensionKeys = passwordResetEmailDefaultLocale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertSame(extensionKeys, passwordResetEmailDefaultLocale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, passwordResetEmailDefaultLocale.getUnicodeLocaleKeys());
  }
}
