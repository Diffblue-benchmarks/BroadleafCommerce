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

@ContextConfiguration(classes = {RequiredPropertyValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RequiredPropertyValidatorDiffblueTest {
  @Autowired
  private RequiredPropertyValidator requiredPropertyValidator;

  /**
   * Test {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RequiredPropertyValidator.validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_givenNull_when42_thenReturnNotNotValid() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = new BasicFieldMetadata();
    propertyMetadata.setRequiredOverride(null);
    propertyMetadata.setRequired(true);

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, propertyMetadata, "Property Name", "42");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("requiredValidationFailure", errorMessages.get(0));
    assertEquals("requiredValidationFailure", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RequiredPropertyValidator.validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_givenNull_whenEmptyString_thenReturnNotValid() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = new BasicFieldMetadata();
    propertyMetadata.setRequiredOverride(null);
    propertyMetadata.setRequired(true);

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, propertyMetadata, "Property Name", "");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("requiredValidationFailure", errorMessages.get(0));
    assertEquals("requiredValidationFailure", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RequiredPropertyValidator.validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_givenNull_whenNull_thenReturnNotValid() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = new BasicFieldMetadata();
    propertyMetadata.setRequiredOverride(null);
    propertyMetadata.setRequired(true);

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, propertyMetadata, "Property Name", null);

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("requiredValidationFailure", errorMessages.get(0));
    assertEquals("requiredValidationFailure", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) RequiredOverride is {@code true}.</li>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RequiredPropertyValidator.validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_whenBasicFieldMetadataRequiredOverrideIsTrue_thenReturnNotValid() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = new BasicFieldMetadata();
    propertyMetadata.setRequiredOverride(true);
    propertyMetadata.setRequired(null);

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, propertyMetadata, "Property Name", null);

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("requiredValidationFailure", errorMessages.get(0));
    assertEquals("requiredValidationFailure", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequiredPropertyValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PropertyValidationResult RequiredPropertyValidator.validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)"})
  public void testValidate_whenBasicFieldMetadata_thenReturnNotNotValid() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = requiredPropertyValidator.validate(entity, instance,
        entityFieldMetadata, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("requiredValidationFailure", errorMessages.get(0));
    assertEquals("requiredValidationFailure", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }
}
