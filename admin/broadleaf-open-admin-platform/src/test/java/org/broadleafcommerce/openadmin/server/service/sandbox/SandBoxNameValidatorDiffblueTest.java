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
package org.broadleafcommerce.openadmin.server.service.sandbox;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.PropertyValidationResult;
import org.junit.Test;

public class SandBoxNameValidatorDiffblueTest {
  /**
   * Test
   * {@link SandBoxNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link Entity} {@link Entity#getPMap()} return
   * {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link Entity#getPMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SandBoxNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenHashMap_whenEntityGetPMapReturnHashMap_thenCallsGetPMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SandBoxNameValidator sandBoxNameValidator = new SandBoxNameValidator();
    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(new HashMap<>());
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = sandBoxNameValidator.validate(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity).getPMap();
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link SandBoxNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return not NotValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SandBoxNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenEntity_thenReturnNotNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SandBoxNameValidator sandBoxNameValidator = new SandBoxNameValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = sandBoxNameValidator.validate(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link SandBoxNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link Entity}.</li>
   *   <li>Then return not Valid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SandBoxNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenEntity_thenReturnNotValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SandBoxNameValidator sandBoxNameValidator = new SandBoxNameValidator();
    Entity entity = mock(Entity.class);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = sandBoxNameValidator.validate(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", null);

    // Assert
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SandBoxNameValidator#setSucceedForNullValues(boolean)}
   *   <li>{@link SandBoxNameValidator#isSucceedForNullValues()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SandBoxNameValidator sandBoxNameValidator = new SandBoxNameValidator();

    // Act
    sandBoxNameValidator.setSucceedForNullValues(true);

    // Assert that nothing has changed
    assertTrue(sandBoxNameValidator.isSucceedForNullValues());
  }
}
