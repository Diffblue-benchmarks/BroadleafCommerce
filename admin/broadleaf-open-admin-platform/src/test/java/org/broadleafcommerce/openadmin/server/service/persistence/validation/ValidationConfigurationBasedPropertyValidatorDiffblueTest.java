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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;

public class ValidationConfigurationBasedPropertyValidatorDiffblueTest {
  /**
   * Test
   * {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()}
   * {@link AdminRegexValidator#REGEX_CONFIG_PROPERTY} is {@code 42}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_given42_whenHashMapRegex_config_propertyIs42_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, "42");

    // Act
    PropertyValidationResult actualValidateResult = adminRegexValidator.validate(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_thenReturnNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act
    PropertyValidationResult actualValidateResult = adminRegexValidator.validate(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test
   * {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenEntity_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = adminRegexValidator.validate(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link Entity}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenEntity_thenReturnNotNotValid2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = mock(Entity.class);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = adminRegexValidator.validate(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link AdminRegexValidator#REGEX_CONFIG_PROPERTY}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenRegex_config_property_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act
    PropertyValidationResult actualValidateResult = adminRegexValidator.validate(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link ValidationConfigurationBasedPropertyValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link AdminRegexValidator} (default constructor).</li>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidationConfigurationBasedPropertyValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidateInternal_givenAdminRegexValidator_whenEntity_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act and Assert
    assertTrue(adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", "42"));
  }

  /**
   * Test
   * {@link ValidationConfigurationBasedPropertyValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link AfterStartDateValidator} (default constructor).</li>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidationConfigurationBasedPropertyValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidateInternal_givenAfterStartDateValidator_whenEntity_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AfterStartDateValidator afterStartDateValidator = new AfterStartDateValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act and Assert
    assertFalse(afterStartDateValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", "42"));
  }

  /**
   * Test
   * {@link ValidationConfigurationBasedPropertyValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link AfterStartDateValidator} (default constructor).</li>
   *   <li>When {@link Entity}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidationConfigurationBasedPropertyValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidateInternal_givenAfterStartDateValidator_whenEntity_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AfterStartDateValidator afterStartDateValidator = new AfterStartDateValidator();
    Entity entity = mock(Entity.class);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act and Assert
    assertFalse(afterStartDateValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", "42"));
  }
}
