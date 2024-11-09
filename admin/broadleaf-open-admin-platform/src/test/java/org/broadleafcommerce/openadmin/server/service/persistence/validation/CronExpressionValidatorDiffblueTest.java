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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;

public class CronExpressionValidatorDiffblueTest {
  /**
   * Test
   * {@link CronExpressionValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CronExpressionValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_when42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CronExpressionValidator cronExpressionValidator = new CronExpressionValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = cronExpressionValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
    assertEquals(CronExpressionValidator.INVALID_EXPRESSION, errorMessages.get(0));
    assertEquals(CronExpressionValidator.INVALID_EXPRESSION, actualValidateResult.getErrorMessage());
  }

  /**
   * Test
   * {@link CronExpressionValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CronExpressionValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CronExpressionValidator cronExpressionValidator = new CronExpressionValidator();
    Entity entity = mock(Entity.class);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = cronExpressionValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
    assertEquals(CronExpressionValidator.INVALID_EXPRESSION, errorMessages.get(0));
    assertEquals(CronExpressionValidator.INVALID_EXPRESSION, actualValidateResult.getErrorMessage());
  }

  /**
   * Test
   * {@link CronExpressionValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link CronExpressionValidator#INVALID_EXPRESSION}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CronExpressionValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenInvalid_expression() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CronExpressionValidator cronExpressionValidator = new CronExpressionValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = cronExpressionValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name",
        CronExpressionValidator.INVALID_EXPRESSION);

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
    assertEquals(CronExpressionValidator.INVALID_EXPRESSION, errorMessages.get(0));
    assertEquals(CronExpressionValidator.INVALID_EXPRESSION, actualValidateResult.getErrorMessage());
  }

  /**
   * Test
   * {@link CronExpressionValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CronExpressionValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CronExpressionValidator cronExpressionValidator = new CronExpressionValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = cronExpressionValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", null);

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
    assertEquals(CronExpressionValidator.INVALID_EXPRESSION, errorMessages.get(0));
    assertEquals(CronExpressionValidator.INVALID_EXPRESSION, actualValidateResult.getErrorMessage());
  }
}
