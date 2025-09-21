/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.persistence.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.PropertyValidationResult;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SystemPropertyAttributeNameValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemPropertyAttributeNameValidatorDiffblueTest {
  @Autowired private SystemPropertyAttributeNameValidator systemPropertyAttributeNameValidator;

  /**
   * Test {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   *   <li>Then calls {@link Entity#findProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyAttributeNameValidator#validate(Entity,
   * Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult SystemPropertyAttributeNameValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenNull_whenEntityFindPropertyReturnNull_thenCallsFindProperty() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        systemPropertyAttributeNameValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(entity).findProperty("name");
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code foo}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyAttributeNameValidator#validate(Entity,
   * Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult SystemPropertyAttributeNameValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenPropertyGetValueReturnFoo_thenCallsGetValue() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("foo");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        systemPropertyAttributeNameValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(entity, atLeast(1)).findProperty("name");
    verify(property).getValue();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyAttributeNameValidator#validate(Entity,
   * Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult SystemPropertyAttributeNameValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenPropertyGetValueReturnNull_thenCallsGetValue() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        systemPropertyAttributeNameValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(entity, atLeast(1)).findProperty("name");
    verify(property).getValue();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyAttributeNameValidator#validate(Entity,
   * Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult SystemPropertyAttributeNameValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenPropertyWithNameAndValue() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "Value"));
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        systemPropertyAttributeNameValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(entity, atLeast(1)).findProperty("name");
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyAttributeNameValidator#validate(Entity,
   * Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult SystemPropertyAttributeNameValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenPropertyWithNameAndValueIs42() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        systemPropertyAttributeNameValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(entity, atLeast(1)).findProperty("name");
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       name}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyAttributeNameValidator#validate(Entity,
   * Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult SystemPropertyAttributeNameValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenPropertyWithNameAndValueIsName() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "name"));
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        systemPropertyAttributeNameValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(entity, atLeast(1)).findProperty("name");
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyAttributeNameValidator#validate(Entity,
   * Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult SystemPropertyAttributeNameValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_givenPropertyWithNameAndValueIsNull() {
    // Arrange
    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        systemPropertyAttributeNameValidator.validate(
            entity,
            instance,
            entityFieldMetadata,
            validationConfiguration,
            new BasicFieldMetadata(),
            "Property Name",
            "42");

    // Assert
    verify(entity, atLeast(1)).findProperty("name");
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map,
   * BasicFieldMetadata, String, String)}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then return ErrorMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyAttributeNameValidator#validate(Entity,
   * Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyValidationResult SystemPropertyAttributeNameValidator.validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"
  })
  public void testValidate_whenEntity_thenReturnErrorMessageIsNull() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult =
        systemPropertyAttributeNameValidator.validate(
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
}
