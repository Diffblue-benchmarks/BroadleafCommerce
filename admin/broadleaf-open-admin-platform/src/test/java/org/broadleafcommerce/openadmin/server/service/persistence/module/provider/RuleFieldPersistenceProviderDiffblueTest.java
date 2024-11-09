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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
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
   * Test
   * {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence_thenReturnFalse() {
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
   * Test
   * {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_thenReturnFalse() {
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
   * Test
   * {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue_thenReturnNotHandled() throws PersistenceException {
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
   * Test
   * {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenReturnNotHandled() throws PersistenceException {
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
   * Test
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given array of {@link Property} with
   * {@link Property#Property(String, String)} with {@code Name} and value is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameAndValueIs42() {
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
   * Test
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given array of {@link Property} with
   * {@link Property#Property(String, String)} with name is {@code Json} and value
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameIsJsonAndValueIs42() {
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
   * Test
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_givenPropertyGetNameReturnJson() {
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
   * Test
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_givenPropertyGetNameReturnName_thenCallsGetName() {
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
   * Test
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  public void testExtractSimpleRule_givenOne_thenThrowUnsupportedOperationException() {
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
   * Test
   * {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  public void testExtractQuantityRule_thenThrowUnsupportedOperationException() {
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
   * Test
   * {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then throw {@link PersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateSimpleRule_thenThrowPersistenceException() throws Exception {
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
   * Test
   * {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule, EntityManager)}.
   * <ul>
   *   <li>When {@link SimpleRule}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule, EntityManager)}
   */
  @Test
  public void testGetContainedRuleId_whenSimpleRule_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new RuleFieldPersistenceProvider()).getContainedRuleId(mock(SimpleRule.class), null));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   * <p>
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
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <p>
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

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualRecursivelyExtractParentResult instanceof SimpleDateFormat);
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getCalendar() instanceof GregorianCalendar);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link FieldManager}
   * {@link FieldManager#getFieldValue(Object, String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent_givenFieldManagerGetFieldValueReturnNull()
      throws IllegalAccessException, FieldNotAvailableException {
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

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    verify(fieldManager).getFieldValue(isA(Object.class), eq(""));
    verify(populateValueRequest).getFieldManager();
    verify(populateValueRequest).getProperty();
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualRecursivelyExtractParentResult instanceof SimpleDateFormat);
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getCalendar() instanceof GregorianCalendar);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent_givenPropertyGetNameReturnName_thenCallsGetName()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    verify(populateValueRequest).getProperty();
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualRecursivelyExtractParentResult instanceof SimpleDateFormat);
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getCalendar() instanceof GregorianCalendar);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent_givenPropertyWithNameAndValueIs42()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(populateValueRequest).getProperty();
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualRecursivelyExtractParentResult instanceof SimpleDateFormat);
    assertTrue(((SimpleDateFormat) actualRecursivelyExtractParentResult).getCalendar() instanceof GregorianCalendar);
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code Field Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testRecursivelyExtractParent_thenReturnFieldValue()
      throws IllegalAccessException, FieldNotAvailableException {
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
   * Test {@link RuleFieldPersistenceProvider#parseParentProperty(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#parseParentProperty(String)}
   */
  @Test
  public void testParseParentProperty_whenDot_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new RuleFieldPersistenceProvider()).parseParentProperty("."));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}
   */
  @Test
  public void testIsEmbeddable_whenJavaLangObject_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(ruleFieldPersistenceProvider.isEmbeddable(clazz));
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <ul>
   *   <li>Then throw {@link PersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  public void testConvertQuantityBasedRuleToJson_thenThrowPersistenceException() {
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
   * Test
   * {@link RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)}.
   * <ul>
   *   <li>Then throw {@link PersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)}
   */
  @Test
  public void testUpdateSimpleRule_thenThrowPersistenceException()
      throws IllegalAccessException, FieldNotAvailableException {
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
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_givenBasicFieldMetadata() throws ClassNotFoundException, IllegalAccessException {
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
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_givenPropertyGetNameReturnName_thenCallsGetName()
      throws ClassNotFoundException, IllegalAccessException {
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
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_givenPropertyWithNameAndValueIs42()
      throws ClassNotFoundException, IllegalAccessException {
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
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_thenReturnList() throws ClassNotFoundException, IllegalAccessException {
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
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_thenThrowIllegalAccessException()
      throws ClassNotFoundException, IllegalAccessException {
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
   * Test
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType_thenThrowIllegalAccessException2()
      throws ClassNotFoundException, IllegalAccessException {
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
   * Test {@link RuleFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.RULE, (new RuleFieldPersistenceProvider()).getOrder());
  }

  /**
   * Test
   * {@link RuleFieldPersistenceProvider#findContainedRuleIfApplicable(Object)}.
   * <ul>
   *   <li>When {@code Rule}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleFieldPersistenceProvider#findContainedRuleIfApplicable(Object)}
   */
  @Test
  public void testFindContainedRuleIfApplicable_whenRule_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(RuleFieldPersistenceProvider.findContainedRuleIfApplicable("Rule"));
  }
}
