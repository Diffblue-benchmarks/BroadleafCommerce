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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;

public class GreaterThanMinValueValidatorDiffblueTest {
  /**
   * Test
   * {@link GreaterThanMinValueValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code minValue}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GreaterThanMinValueValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenMinValue_when42_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GreaterThanMinValueValidator greaterThanMinValueValidator = new GreaterThanMinValueValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("minValue", "42");

    // Act
    PropertyValidationResult actualValidateResult = greaterThanMinValueValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link GreaterThanMinValueValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code minValue}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GreaterThanMinValueValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenMinValue_whenEmptyString_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GreaterThanMinValueValidator greaterThanMinValueValidator = new GreaterThanMinValueValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("minValue", "42");

    // Act
    PropertyValidationResult actualValidateResult = greaterThanMinValueValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link GreaterThanMinValueValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code minValue}.</li>
   *   <li>When {@code minValue}.</li>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GreaterThanMinValueValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenMinValue_whenMinValue_thenReturnNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GreaterThanMinValueValidator greaterThanMinValueValidator = new GreaterThanMinValueValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("minValue", "42");

    // Act
    PropertyValidationResult actualValidateResult = greaterThanMinValueValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "minValue");

    // Assert
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test
   * {@link GreaterThanMinValueValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code minValue}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GreaterThanMinValueValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenMinValue_whenNull_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GreaterThanMinValueValidator greaterThanMinValueValidator = new GreaterThanMinValueValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("minValue", "42");

    // Act
    PropertyValidationResult actualValidateResult = greaterThanMinValueValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", null);

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }
}
