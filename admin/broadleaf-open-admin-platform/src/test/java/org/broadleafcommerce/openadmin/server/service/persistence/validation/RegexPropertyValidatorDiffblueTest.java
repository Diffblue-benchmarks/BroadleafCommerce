/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RegexPropertyValidatorDiffblueTest {
  @InjectMocks
  private RegexPropertyValidator regexPropertyValidator;

  @Mock
  private ExploitProtectionService exploitProtectionService;

  /**
   * Test {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <p>
   * Method under test: {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RegexPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate() {
    // Arrange
    when(exploitProtectionService.htmlDecode(Mockito.<String>any()))
        .thenThrow(new PatternSyntaxException("regularExpression", "regularExpression", 1));
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = regexPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(exploitProtectionService).htmlDecode(eq("42"));
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("Invalid regular expression pattern for Property Name", errorMessages.get(0));
    assertEquals("Invalid regular expression pattern for Property Name", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <p>
   * Method under test: {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RegexPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate2() {
    // Arrange
    when(exploitProtectionService.htmlDecode(Mockito.<String>any()))
        .thenThrow(new PatternSyntaxException("Invalid regular expression pattern '", "regularExpression", 1));
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = regexPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(exploitProtectionService).htmlDecode(eq("42"));
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("Invalid regular expression pattern for Property Name", errorMessages.get(0));
    assertEquals("Invalid regular expression pattern for Property Name", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code regularExpression}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RegexPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_givenRegularExpression() {
    // Arrange
    when(exploitProtectionService.htmlDecode(Mockito.<String>any())).thenReturn("Html Decode");
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("regularExpression", "regularExpression");

    // Act
    PropertyValidationResult actualValidateResult = regexPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(exploitProtectionService).htmlDecode(eq("42"));
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RegexPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_whenNull_thenReturnNotNotValid() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = regexPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", null);

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link RegexPropertyValidator#initExploitProtectionService()}.
   * <p>
   * Method under test: {@link RegexPropertyValidator#initExploitProtectionService()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExploitProtectionService RegexPropertyValidator.initExploitProtectionService()"})
  public void testInitExploitProtectionService() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(ServiceException.class, () -> regexPropertyValidator.initExploitProtectionService());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RegexPropertyValidator#setSucceedForInvalidRegex(boolean)}
   *   <li>{@link RegexPropertyValidator#setSucceedForNullValues(boolean)}
   *   <li>{@link RegexPropertyValidator#isSucceedForInvalidRegex()}
   *   <li>{@link RegexPropertyValidator#isSucceedForNullValues()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RegexPropertyValidator.isSucceedForInvalidRegex()",
      "boolean RegexPropertyValidator.isSucceedForNullValues()",
      "void RegexPropertyValidator.setSucceedForInvalidRegex(boolean)",
      "void RegexPropertyValidator.setSucceedForNullValues(boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    RegexPropertyValidator regexPropertyValidator = new RegexPropertyValidator();

    // Act
    regexPropertyValidator.setSucceedForInvalidRegex(true);
    regexPropertyValidator.setSucceedForNullValues(true);
    boolean actualIsSucceedForInvalidRegexResult = regexPropertyValidator.isSucceedForInvalidRegex();

    // Assert
    assertTrue(actualIsSucceedForInvalidRegexResult);
    assertTrue(regexPropertyValidator.isSucceedForNullValues());
  }
}
