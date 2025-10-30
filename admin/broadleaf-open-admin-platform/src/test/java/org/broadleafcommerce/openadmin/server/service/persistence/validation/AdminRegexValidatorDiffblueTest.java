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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.config.service.SystemPropertiesService;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminRegexValidatorDiffblueTest {
  @InjectMocks
  private AdminRegexValidator adminRegexValidator;

  @Mock
  private SystemPropertiesService systemPropertiesService;

  /**
   * Test {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <p>
   * Method under test: {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AdminRegexValidator.validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidateInternal() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("Resolve System Property");
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY,
        AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY);
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act
    boolean actualValidateInternalResult = adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(systemPropertiesService, atLeast(1)).resolveSystemProperty(eq("regexPropertyName"));
    assertFalse(actualValidateInternalResult);
  }

  /**
   * Test {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <p>
   * Method under test: {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AdminRegexValidator.validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidateInternal2() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("");
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY,
        AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY);
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act
    boolean actualValidateInternalResult = adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(systemPropertiesService).resolveSystemProperty(eq("regexPropertyName"));
    assertFalse(actualValidateInternalResult);
  }

  /**
   * Test {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link AdminRegexValidator#REGEX_CONFIG_PROPERTY}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AdminRegexValidator.validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidateInternal_givenRegex_config_property_when42_thenReturnFalse() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act and Assert
    assertFalse(adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", "42"));
  }

  /**
   * Test {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link SystemPropertiesService} {@link SystemPropertiesService#resolveSystemProperty(String)} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AdminRegexValidator.validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidateInternal_givenSystemPropertiesServiceResolveSystemPropertyReturn42() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("42");
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY,
        AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY);
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act
    boolean actualValidateInternalResult = adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(systemPropertiesService, atLeast(1)).resolveSystemProperty(eq("regexPropertyName"));
    assertTrue(actualValidateInternalResult);
  }

  /**
   * Test {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>Given {@link SystemPropertiesService} {@link SystemPropertiesService#resolveSystemProperty(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AdminRegexValidator.validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidateInternal_givenSystemPropertiesServiceResolveSystemPropertyReturnNull() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn(null);
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY,
        AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY);
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act
    boolean actualValidateInternalResult = adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "42");

    // Assert
    verify(systemPropertiesService).resolveSystemProperty(eq("regexPropertyName"));
    assertFalse(actualValidateInternalResult);
  }

  /**
   * Test {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AdminRegexValidator.validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidateInternal_when42_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();
    HashMap<String, String> validationConfiguration = new HashMap<>();

    // Act and Assert
    assertTrue(adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", "42"));
  }

  /**
   * Test {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AdminRegexValidator.validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidateInternal_whenNull_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY,
        AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY);
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act and Assert
    assertTrue(adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata, validationConfiguration,
        new BasicFieldMetadata(), "Property Name", null));
  }

  /**
   * Test {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}.
   * <ul>
   *   <li>When {@code Resolve System Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRegexValidator#validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AdminRegexValidator.validateInternal(Entity, Serializable, Map, Map, BasicFieldMetadata, String, String)"})
  public void testValidateInternal_whenResolveSystemProperty() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("Resolve System Property");
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> entityFieldMetadata = new HashMap<>();

    HashMap<String, String> validationConfiguration = new HashMap<>();
    validationConfiguration.put(AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY,
        AdminRegexValidator.REGEX_PROPERTY_NAME_CONFIG_PROPERTY);
    validationConfiguration.put(AdminRegexValidator.REGEX_CONFIG_PROPERTY, AdminRegexValidator.REGEX_CONFIG_PROPERTY);

    // Act
    boolean actualValidateInternalResult = adminRegexValidator.validateInternal(entity, instance, entityFieldMetadata,
        validationConfiguration, new BasicFieldMetadata(), "Property Name", "Resolve System Property");

    // Assert
    verify(systemPropertiesService, atLeast(1)).resolveSystemProperty(eq("regexPropertyName"));
    assertTrue(actualValidateInternalResult);
  }
}
