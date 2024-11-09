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

public class FieldLengthValidatorDiffblueTest {
  /**
   * Test
   * {@link FieldLengthValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link BasicFieldMetadata} (default constructor) Length is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldLengthValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenZero_whenBasicFieldMetadataLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldLengthValidator fieldLengthValidator = new FieldLengthValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = new BasicFieldMetadata();
    propertyMetadata.setLength(0);

    // Act
    PropertyValidationResult actualValidateResult = fieldLengthValidator.validate(entity, instance, entityFieldMetadata,
        propertyMetadata, "Property Name", null);

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("", errorMessages.get(0));
    assertEquals("", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link FieldLengthValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return ErrorMessages size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldLengthValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenBasicFieldMetadata_thenReturnErrorMessagesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldLengthValidator fieldLengthValidator = new FieldLengthValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = fieldLengthValidator.validate(entity, instance, entityFieldMetadata,
        new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("", errorMessages.get(0));
    assertEquals("", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link FieldLengthValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link Entity}.</li>
   *   <li>Then return ErrorMessages size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldLengthValidator#validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenEntity_thenReturnErrorMessagesSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldLengthValidator fieldLengthValidator = new FieldLengthValidator();
    Entity entity = mock(Entity.class);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = fieldLengthValidator.validate(entity, instance, entityFieldMetadata,
        new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("", errorMessages.get(0));
    assertEquals("", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }
}
