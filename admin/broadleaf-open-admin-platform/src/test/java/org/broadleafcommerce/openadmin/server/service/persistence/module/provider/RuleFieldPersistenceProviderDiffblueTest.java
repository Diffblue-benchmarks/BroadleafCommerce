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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.rule.QuantityBasedRule;
import org.broadleafcommerce.common.rule.SimpleRule;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddFilterPropertiesRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELToDataWrapperTranslator;
import org.junit.Test;
import org.mockito.Mockito;

public class RuleFieldPersistenceProviderDiffblueTest {
  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertFalse(
        ruleFieldPersistenceProvider.canHandlePersistence(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandlePersistenceResult = ruleFieldPersistenceProvider.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(populateValueRequest, atLeast(1)).getMetadata();
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertFalse(ruleFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = ruleFieldPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property());

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        ruleFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue2() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualPopulateValueResult = ruleFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(populateValueRequest, atLeast(1)).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        ruleFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue2() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualExtractValueResult = ruleFieldPersistenceProvider.extractValue(extractValueRequest,
        new Property());

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(extractValueRequest, atLeast(1)).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Json", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = ruleFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = ruleFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{property});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = ruleFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    verify(property).getName();
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Json");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{property});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    HashMap<String, FieldMetadata> properties = new HashMap<>();
    properties.put("42", new AdornedTargetCollectionMetadata());

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = ruleFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, properties);

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    verify(property, atLeast(1)).getName();
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  public void testExtractSimpleRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getRequestedValue()).thenReturn(1);
    Property property = new Property();
    ObjectMapper mapper = new ObjectMapper();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ruleFieldPersistenceProvider
        .extractSimpleRule(extractValueRequest, property, mapper, new MVELToDataWrapperTranslator()));
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  public void testExtractQuantityRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    ObjectMapper mapper = new ObjectMapper();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ruleFieldPersistenceProvider
        .extractQuantityRule(extractValueRequest, mapper, new MVELToDataWrapperTranslator()));
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateSimpleRule() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenThrow(new PersistenceException("An error occurred"));
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act and Assert
    assertThrows(PersistenceException.class, () -> ruleFieldPersistenceProvider.populateSimpleRule(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd")));
    verify(property).getName();
    verify(property).getUnHtmlEncodedValue();
    verify(populateValueRequest, atLeast(1)).getProperty();
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule, EntityManager)}
   */
  @Test
  public void testGetContainedRuleId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new RuleFieldPersistenceProvider()).getContainedRuleId(mock(SimpleRule.class), null));
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  public void testTransformId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1L, (new RuleFieldPersistenceProvider()).transformId(1L, "Rule").longValue());
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertSame(instance, ruleFieldPersistenceProvider.recursivelyExtractParent(populateValueRequest, instance));
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent2() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, instance);

    // Assert
    verify(populateValueRequest).getProperty();
    assertSame(instance, actualRecursivelyExtractParentResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent3() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, instance);

    // Assert
    verify(property).getName();
    verify(populateValueRequest).getProperty();
    assertSame(instance, actualRecursivelyExtractParentResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent4() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn(".");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    verify(fieldManager).getFieldValue(isA(Object.class), eq(""));
    verify(populateValueRequest).getFieldManager();
    verify(populateValueRequest).getProperty();
    assertEquals("Field Value", actualRecursivelyExtractParentResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent5() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn(".");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(null);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(populateValueRequest.getProperty()).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, instance);

    // Assert
    verify(property).getName();
    verify(fieldManager).getFieldValue(isA(Object.class), eq(""));
    verify(populateValueRequest).getFieldManager();
    verify(populateValueRequest).getProperty();
    assertSame(instance, actualRecursivelyExtractParentResult);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#parseParentProperty(String)}
   */
  @Test
  public void testParseParentProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new RuleFieldPersistenceProvider()).parseParentProperty("."));
  }

  /**
   * Method under test: {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}
   */
  @Test
  public void testIsEmbeddable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(ruleFieldPersistenceProvider.isEmbeddable(clazz));
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  public void testConvertQuantityBasedRuleToJson() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();
    ObjectMapper mapper = new ObjectMapper();
    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getMatchRule()).thenReturn("Match Rule");
    QuantityBasedRule quantityBasedRule2 = mock(QuantityBasedRule.class);
    when(quantityBasedRule2.getMatchRule()).thenReturn("Match Rule");
    QuantityBasedRule quantityBasedRule3 = mock(QuantityBasedRule.class);
    when(quantityBasedRule3.getMatchRule()).thenThrow(new PersistenceException("An error occurred"));

    ArrayList<QuantityBasedRule> quantityBasedRules = new ArrayList<>();
    quantityBasedRules.add(quantityBasedRule3);
    quantityBasedRules.add(quantityBasedRule2);
    quantityBasedRules.add(quantityBasedRule);

    // Act and Assert
    assertThrows(PersistenceException.class, () -> ruleFieldPersistenceProvider
        .convertQuantityBasedRuleToJson(translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(quantityBasedRule3).getMatchRule();
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)}
   */
  @Test
  public void testUpdateSimpleRule() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    SimpleRule rule = mock(SimpleRule.class);
    doThrow(new PersistenceException("An error occurred")).when(rule).setMatchRule(Mockito.<String>any());

    // Act and Assert
    assertThrows(PersistenceException.class,
        () -> ruleFieldPersistenceProvider.updateSimpleRule(populateValueRequest, "Mvel", true, rule));
    verify(rule).setMatchRule(eq("Mvel"));
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    Class<?> actualStartingValueType = ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(populateValueRequest).getProperty();
    verify(populateValueRequest).getReturnType();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
    assertSame(forNameResult, actualStartingValueType);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType2() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(null);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act and Assert
    assertThrows(IllegalAccessException.class,
        () -> ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest));
    verify(populateValueRequest, atLeast(1)).getProperty();
    verify(populateValueRequest).getReturnType();
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType3() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(new BasicFieldMetadata());
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getProperty()).thenReturn(new Property("---", "42"));

    // Act
    Class<?> actualStartingValueType = ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getProperty();
    verify(populateValueRequest).getReturnType();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
    assertSame(forNameResult, actualStartingValueType);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType4() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getMapFieldValueClass()).thenReturn("java.util.List");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getProperty()).thenReturn(new Property("---", "42"));

    // Act
    Class<?> actualStartingValueType = ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(basicFieldMetadata).getMapFieldValueClass();
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getProperty();
    Class<List> expectedStartingValueType = List.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType5() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act
    Class<?> actualStartingValueType = ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(property).getName();
    verify(populateValueRequest).getProperty();
    verify(populateValueRequest).getReturnType();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
    assertSame(forNameResult, actualStartingValueType);
  }

  /**
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType6() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(null);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act and Assert
    assertThrows(IllegalAccessException.class,
        () -> ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest));
    verify(property, atLeast(1)).getName();
    verify(populateValueRequest, atLeast(1)).getProperty();
    verify(populateValueRequest).getReturnType();
  }

  /**
   * Method under test: {@link RuleFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.RULE, (new RuleFieldPersistenceProvider()).getOrder());
  }
}
