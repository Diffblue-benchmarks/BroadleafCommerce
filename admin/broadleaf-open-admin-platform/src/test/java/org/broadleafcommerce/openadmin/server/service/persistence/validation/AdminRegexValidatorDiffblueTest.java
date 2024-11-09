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

public class AdminRegexValidatorDiffblueTest {
  /**
   * Test
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()}
   * {@link AdminRegexValidator#REGEX_CONFIG_PROPERTY} is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidateInternal_given42_whenHashMapRegex_config_propertyIs42_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, "42");

    // Act and Assert
    assertTrue(adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", "42"));
  }

  /**
   * Test
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidateInternal_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, "");

    // Act and Assert
    assertTrue(adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", "42"));
  }

  /**
   * Test
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link AdminRegexValidator#REGEX_CONFIG_PROPERTY}.</li>
   *   <li>When {@link AdminRegexValidator#REGEX_CONFIG_PROPERTY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidateInternal_givenRegex_config_property_whenRegex_config_property() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act and Assert
    assertTrue(adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", AdminRegexValidator.REGEX_CONFIG_PROPERTY));
  }

  /**
   * Test
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidateInternal_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act and Assert
    assertFalse(adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", "42"));
  }

  /**
   * Test
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidateInternal_when42_thenReturnTrue() {
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
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link Entity}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidateInternal_whenEntity_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = mock(Entity.class);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act and Assert
    assertTrue(adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", "42"));
  }

  /**
   * Test
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidateInternal_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRegexValidator adminRegexValidator = new AdminRegexValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act and Assert
    assertTrue(adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", null));
  }
}
