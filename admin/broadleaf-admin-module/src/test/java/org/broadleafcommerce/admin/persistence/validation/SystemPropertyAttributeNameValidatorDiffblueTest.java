/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.persistence.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
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
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.PropertyValidationResult;
import org.junit.Test;
import org.mockito.Mockito;

public class SystemPropertyAttributeNameValidatorDiffblueTest {
  /**
   * Test
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenPropertyGetValueReturn42_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyAttributeNameValidator systemPropertyAttributeNameValidator = new SystemPropertyAttributeNameValidator();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = systemPropertyAttributeNameValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(eq("name"));
    verify(property).getValue();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code foo}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenPropertyGetValueReturnFoo_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyAttributeNameValidator systemPropertyAttributeNameValidator = new SystemPropertyAttributeNameValidator();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("foo");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = systemPropertyAttributeNameValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(eq("name"));
    verify(property).getValue();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code name}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenPropertyGetValueReturnName_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyAttributeNameValidator systemPropertyAttributeNameValidator = new SystemPropertyAttributeNameValidator();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("name");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = systemPropertyAttributeNameValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(eq("name"));
    verify(property).getValue();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return
   * {@code UU}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenPropertyGetValueReturnUu_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyAttributeNameValidator systemPropertyAttributeNameValidator = new SystemPropertyAttributeNameValidator();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("UU");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = systemPropertyAttributeNameValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(eq("name"));
    verify(property).getValue();
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code name} and
   * value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenPropertyWithNameAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyAttributeNameValidator systemPropertyAttributeNameValidator = new SystemPropertyAttributeNameValidator();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("name", "42"));
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = systemPropertyAttributeNameValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(eq("name"));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_givenProperty_whenEntityFindPropertyReturnProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyAttributeNameValidator systemPropertyAttributeNameValidator = new SystemPropertyAttributeNameValidator();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = systemPropertyAttributeNameValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(entity, atLeast(1)).findProperty(eq("name"));
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }

  /**
   * Test
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return ErrorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyAttributeNameValidator#validate(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  public void testValidate_whenEntity_thenReturnErrorMessageIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyAttributeNameValidator systemPropertyAttributeNameValidator = new SystemPropertyAttributeNameValidator();
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act
    PropertyValidationResult actualValidateResult = systemPropertyAttributeNameValidator.validate(entity, instance,
        entityFieldMetadata, validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    assertNull(actualValidateResult.getErrorMessage());
    assertFalse(actualValidateResult.isNotValid());
    assertTrue(actualValidateResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }
}
