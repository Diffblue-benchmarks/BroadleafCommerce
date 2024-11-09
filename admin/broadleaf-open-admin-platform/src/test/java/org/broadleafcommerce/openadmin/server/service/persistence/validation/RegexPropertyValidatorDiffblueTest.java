/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;

public class RegexPropertyValidatorDiffblueTest {
  /**
   * Test
   * {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code regularExpression} is
   * {@code 42}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_given42_whenHashMapRegularExpressionIs42_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RegexPropertyValidator regexPropertyValidator = new RegexPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("regularExpression", "42");

    // Act
    PropertyValidationResult actualValidateResult = regexPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code regularExpression}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenRegularExpression_whenNull_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RegexPropertyValidator regexPropertyValidator = new RegexPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("regularExpression", "regularExpression");

    // Act
    PropertyValidationResult actualValidateResult = regexPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", null);

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code regularExpression}.</li>
   *   <li>When {@code regularExpression}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenRegularExpression_whenRegularExpression_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RegexPropertyValidator regexPropertyValidator = new RegexPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("regularExpression", "regularExpression");

    // Act
    PropertyValidationResult actualValidateResult = regexPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "regularExpression");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code regularExpression} is
   * {@code regularExpression}.</li>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RegexPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenHashMapRegularExpressionIsRegularExpression_thenReturnNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RegexPropertyValidator regexPropertyValidator = new RegexPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("regularExpression", "regularExpression");

    // Act
    PropertyValidationResult actualValidateResult = regexPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link RegexPropertyValidator#initExploitProtectionService()}.
   * <p>
   * Method under test:
   * {@link RegexPropertyValidator#initExploitProtectionService()}
   */
  @Test
  public void testInitExploitProtectionService() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ServiceException.class, () -> (new RegexPropertyValidator()).initExploitProtectionService());
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
  public void testGettersAndSetters() {
    // Arrange
    RegexPropertyValidator regexPropertyValidator = new RegexPropertyValidator();

    // Act
    regexPropertyValidator.setSucceedForInvalidRegex(true);
    regexPropertyValidator.setSucceedForNullValues(true);
    boolean actualIsSucceedForInvalidRegexResult = regexPropertyValidator.isSucceedForInvalidRegex();

    // Assert that nothing has changed
    assertTrue(actualIsSucceedForInvalidRegexResult);
    assertTrue(regexPropertyValidator.isSucceedForNullValues());
  }
}
