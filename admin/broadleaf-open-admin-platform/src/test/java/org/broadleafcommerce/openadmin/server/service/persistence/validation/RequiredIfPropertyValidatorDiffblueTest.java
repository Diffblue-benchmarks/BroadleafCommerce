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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;

public class RequiredIfPropertyValidatorDiffblueTest {
  /**
   * Test
   * {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return ErrorMessages size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_when42_thenReturnErrorMessagesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredIfPropertyValidator requiredIfPropertyValidator = new RequiredIfPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = requiredIfPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return ErrorMessages size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenDot_thenReturnErrorMessagesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredIfPropertyValidator requiredIfPropertyValidator = new RequiredIfPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = requiredIfPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), ".", "42");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return ErrorMessages size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenEmptyString_thenReturnErrorMessagesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredIfPropertyValidator requiredIfPropertyValidator = new RequiredIfPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = requiredIfPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link Entity}.</li>
   *   <li>Then return ErrorMessages size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenEntity_thenReturnErrorMessagesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredIfPropertyValidator requiredIfPropertyValidator = new RequiredIfPropertyValidator();
    Entity entity = mock(Entity.class);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = requiredIfPropertyValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ErrorMessages size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenNull_thenReturnErrorMessagesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredIfPropertyValidator requiredIfPropertyValidator = new RequiredIfPropertyValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = requiredIfPropertyValidator.validate(entity, instance,
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
   * Test {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}
   */
  @Test
  public void testLookupCompareFieldName_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredIfPropertyValidator requiredIfPropertyValidator = new RequiredIfPropertyValidator();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.computeIfPresent("compareField", mock(BiFunction.class));

    // Act and Assert
    assertNull(requiredIfPropertyValidator.lookupCompareFieldName("Current Field Name", validationConfiguration));
  }

  /**
   * Test {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}.
   * <ul>
   *   <li>Then return {@code .Validation Configuration}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}
   */
  @Test
  public void testLookupCompareFieldName_thenReturnValidationConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredIfPropertyValidator requiredIfPropertyValidator = new RequiredIfPropertyValidator();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("compareField", "Validation Configuration");

    // Act and Assert
    assertEquals(".Validation Configuration",
        requiredIfPropertyValidator.lookupCompareFieldName(".", validationConfiguration));
  }

  /**
   * Test {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}
   */
  @Test
  public void testLookupCompareFieldName_whenHashMap_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequiredIfPropertyValidator requiredIfPropertyValidator = new RequiredIfPropertyValidator();

    // Act and Assert
    assertNull(requiredIfPropertyValidator.lookupCompareFieldName("Current Field Name", new HashMap<>()));
  }
}
