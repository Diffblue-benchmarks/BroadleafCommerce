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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AfterStartDateValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ValidationConfigurationBasedPropertyValidatorDiffblueTest {
  @Autowired
  private ValidationConfigurationBasedPropertyValidator validationConfigurationBasedPropertyValidator;

  /**
   * Test {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@link AdminRegexValidator#REGEX_CONFIG_PROPERTY} is {@code 42}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult ValidationConfigurationBasedPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_given42_whenHashMapRegex_config_propertyIs42_thenReturnNotNotValid() {
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
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult ValidationConfigurationBasedPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_thenReturnNotValid() {
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
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult ValidationConfigurationBasedPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_when42_thenReturnNotNotValid() {
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
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link AdminRegexValidator#REGEX_CONFIG_PROPERTY}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationConfigurationBasedPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult ValidationConfigurationBasedPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_whenRegex_config_property_thenReturnNotNotValid() {
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
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link ValidationConfigurationBasedPropertyValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <p>
   * Method under test: {@link ValidationConfigurationBasedPropertyValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidationConfigurationBasedPropertyValidator.validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidateInternal() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act and Assert
    assertFalse(validationConfigurationBasedPropertyValidator.validateInternal(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42"));
  }
}
