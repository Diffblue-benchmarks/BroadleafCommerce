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

@ContextConfiguration(classes = {RequiredIfPropertyValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RequiredIfPropertyValidatorDiffblueTest {
  @Autowired
  private RequiredIfPropertyValidator requiredIfPropertyValidator;

  /**
   * Test {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RequiredIfPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_whenDot() {
    // Arrange
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
   * Test {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RequiredIfPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_whenEmptyString() {
    // Arrange
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
   * Test {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequiredIfPropertyValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RequiredIfPropertyValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_whenPropertyName() {
    // Arrange
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
   * Test {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}.
   * <ul>
   *   <li>Given {@code compareField}.</li>
   *   <li>Then return {@code .Validation Configuration}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RequiredIfPropertyValidator.lookupCompareFieldName(String, Map)"})
  public void testLookupCompareFieldName_givenCompareField_thenReturnValidationConfiguration() {
    // Arrange
    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put("compareField", "Validation Configuration");

    // Act and Assert
    assertEquals(".Validation Configuration",
        requiredIfPropertyValidator.lookupCompareFieldName(".", validationConfiguration));
  }

  /**
   * Test {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}.
   * <ul>
   *   <li>When {@code Current Field Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequiredIfPropertyValidator#lookupCompareFieldName(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RequiredIfPropertyValidator.lookupCompareFieldName(String, Map)"})
  public void testLookupCompareFieldName_whenCurrentFieldName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(requiredIfPropertyValidator.lookupCompareFieldName("Current Field Name", new HashMap<>()));
  }
}
