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
package org.broadleafcommerce.openadmin.server.service.sandbox;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.PropertyValidationResult;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SandBoxNameValidatorDiffblueTest {
  @InjectMocks private SandBoxNameValidator sandBoxNameValidator;

  /**
   * Test {@link SandBoxNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then return not NotValid.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxNameValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult SandBoxNameValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_whenEntity_thenReturnNotNotValid() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        sandBoxNameValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SandBoxNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then return not Valid.
   * </ul>
   *
   * <p>Method under test: {@link SandBoxNameValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult SandBoxNameValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_whenEntity_thenReturnNotValid() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        sandBoxNameValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            null);

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isNotValid());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SandBoxNameValidator#setSucceedForNullValues(boolean)}
   *   <li>{@link SandBoxNameValidator#isSucceedForNullValues()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SandBoxNameValidator.isSucceedForNullValues()",
    "void SandBoxNameValidator.setSucceedForNullValues(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SandBoxNameValidator sandBoxNameValidator = new SandBoxNameValidator();

    // Act
    sandBoxNameValidator.setSucceedForNullValues(true);

    // Assert
    assertTrue(sandBoxNameValidator.isSucceedForNullValues());
  }
}
