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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

@ContextConfiguration(classes = {FieldLengthValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldLengthValidatorDiffblueTest {
  @Autowired private FieldLengthValidator fieldLengthValidator;

  /**
   * Test {@link FieldLengthValidator#validate(Entity, Serializable, Map, BasicFieldMetadata,
   * String, String)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then calls {@link BasicFieldMetadata#getLength()}.
   * </ul>
   *
   * <p>Method under test: {@link FieldLengthValidator#validate(Entity, Serializable, Map,
   * BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult FieldLengthValidator.validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenThree_thenCallsGetLength() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = mock(BasicFieldMetadata.class);
    when(propertyMetadata.getLength()).thenReturn(3);

    // Act
    PropertyValidationResult actualValidateResult =
        fieldLengthValidator.validate(
            entity, instance, entityFieldMetadata, propertyMetadata, "Property Name", "42");

    // Assert
    verify(propertyMetadata, atLeast(1)).getLength();
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("", errorMessages.get(0));
    assertEquals("", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link FieldLengthValidator#validate(Entity, Serializable, Map, BasicFieldMetadata,
   * String, String)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link BasicFieldMetadata} (default constructor) Length is zero.
   * </ul>
   *
   * <p>Method under test: {@link FieldLengthValidator#validate(Entity, Serializable, Map,
   * BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult FieldLengthValidator.validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenZero_whenBasicFieldMetadataLengthIsZero() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    BasicFieldMetadata propertyMetadata = new BasicFieldMetadata();
    propertyMetadata.setLength(0);

    // Act
    PropertyValidationResult actualValidateResult =
        fieldLengthValidator.validate(
            entity, instance, entityFieldMetadata, propertyMetadata, "Property Name", null);

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("", errorMessages.get(0));
    assertEquals("", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link FieldLengthValidator#validate(Entity, Serializable, Map, BasicFieldMetadata,
   * String, String)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).
   *   <li>Then return ErrorMessages size is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldLengthValidator#validate(Entity, Serializable, Map,
   * BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult FieldLengthValidator.validate(Entity, Serializable, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_whenBasicFieldMetadata_thenReturnErrorMessagesSizeIsOne() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        fieldLengthValidator.validate(
            entity, instance, entityFieldMetadata, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    List<String> errorMessages = actualValidateResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("", errorMessages.get(0));
    assertEquals("", actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.isValid());
  }
}
