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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.rule.QuantityBasedRule;
import org.broadleafcommerce.common.rule.SimpleRule;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.ParentEntityPersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.RuleFieldPersistenceProviderExtensionHandler;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.RuleFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddFilterPropertiesRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.broadleafcommerce.openadmin.web.rulebuilder.DataDTOToMVELTranslator;
import org.broadleafcommerce.openadmin.web.rulebuilder.MVELToDataWrapperTranslator;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldService;
import org.broadleafcommerce.openadmin.web.rulebuilder.service.RuleBuilderFieldServiceFactory;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RuleFieldPersistenceProviderDiffblueTest {
  @Mock
  private RuleBuilderFieldServiceFactory ruleBuilderFieldServiceFactory;

  @Mock
  private RuleFieldExtractionUtility ruleFieldExtractionUtility;

  @InjectMocks
  private RuleFieldPersistenceProvider ruleFieldPersistenceProvider;

  @Mock
  private RuleFieldPersistenceProviderExtensionManager ruleFieldPersistenceProviderExtensionManager;

  @Mock
  private SandBoxHelper sandBoxHelper;

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link RuleFieldPersistenceProvider} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"})
  public void testCanHandlePersistence_givenRuleFieldPersistenceProvider_thenReturnTrue() {
    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.RULE_WITH_QUANTITY);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertTrue(
        ruleFieldPersistenceProvider.canHandlePersistence(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"})
  public void testCanHandlePersistence_thenCallsGetFieldType() {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"})
  public void testCanHandlePersistence_thenReturnFalse() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

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
   * Test {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Given {@link RuleFieldPersistenceProvider} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction_givenRuleFieldPersistenceProvider_thenReturnTrue() {
    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.RULE_WITH_QUANTITY);
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertTrue(ruleFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction_thenCallsGetFieldType() {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction_thenReturnFalse() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

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
   * Test {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse RuleFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue() throws PersistenceException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

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
   * Test {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse RuleFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue_thenCallsGetFieldType() throws PersistenceException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse RuleFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue() throws PersistenceException {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

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
   * Test {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse RuleFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue_thenCallsGetFieldType() throws PersistenceException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse RuleFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"})
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameAndValueIs42() {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property(String, String)} with name is {@code Json} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse RuleFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"})
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameIsJsonAndValueIs42() {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse RuleFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"})
  public void testFilterProperties_givenPropertyGetNameReturnName_thenCallsGetName() {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void RuleFieldPersistenceProvider.extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)"})
  public void testExtractSimpleRule() {
    // Arrange
    Property property = new Property();
    when(ruleFieldExtractionUtility.convertSimpleRuleToJson(Mockito.<MVELToDataWrapperTranslator>any(),
        Mockito.<ObjectMapper>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(property);
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    Property property2 = new Property();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    ruleFieldPersistenceProvider.extractSimpleRule(extractValueRequest, property2, mapper,
        new MVELToDataWrapperTranslator());

    // Assert
    verify(ruleFieldExtractionUtility).convertSimpleRuleToJson(isA(MVELToDataWrapperTranslator.class),
        isA(ObjectMapper.class), eq("Requested Value"), eq("nullJson"), isNull());
    assertEquals(property, property2);
    assertSame(props, extractValueRequest.getProps());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void RuleFieldPersistenceProvider.extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)"})
  public void testExtractSimpleRule2() {
    // Arrange
    Property property = new Property();
    when(ruleFieldExtractionUtility.convertSimpleRuleToJson(Mockito.<MVELToDataWrapperTranslator>any(),
        Mockito.<ObjectMapper>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(property);
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getRuleIdentifier()).thenReturn("42");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    Property property2 = new Property();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    ruleFieldPersistenceProvider.extractSimpleRule(extractValueRequest, property2, mapper,
        new MVELToDataWrapperTranslator());

    // Assert
    verify(metadata).getRuleIdentifier();
    verify(ruleFieldExtractionUtility).convertSimpleRuleToJson(isA(MVELToDataWrapperTranslator.class),
        isA(ObjectMapper.class), eq("Requested Value"), eq("nullJson"), eq("42"));
    assertEquals(property, property2);
    assertSame(props, extractValueRequest.getProps());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void RuleFieldPersistenceProvider.extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)"})
  public void testExtractSimpleRule3() {
    // Arrange
    Property property = new Property();
    when(ruleFieldExtractionUtility.convertSimpleRuleToJson(Mockito.<MVELToDataWrapperTranslator>any(),
        Mockito.<ObjectMapper>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(property);
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getRuleIdentifier()).thenReturn("42");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, null,
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    Property property2 = new Property();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    ruleFieldPersistenceProvider.extractSimpleRule(extractValueRequest, property2, mapper,
        new MVELToDataWrapperTranslator());

    // Assert
    verify(metadata).getRuleIdentifier();
    verify(ruleFieldExtractionUtility).convertSimpleRuleToJson(isA(MVELToDataWrapperTranslator.class),
        isA(ObjectMapper.class), isNull(), eq("nullJson"), eq("42"));
    assertEquals(property, property2);
    assertSame(props, extractValueRequest.getProps());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void RuleFieldPersistenceProvider.extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)"})
  public void testExtractSimpleRule_thenThrowUnsupportedOperationException() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, 42, "Display Val",
        persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"), new String[]{"Custom Criteria"});

    Property property = new Property();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ruleFieldPersistenceProvider
        .extractSimpleRule(extractValueRequest, property, mapper, new MVELToDataWrapperTranslator()));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void RuleFieldPersistenceProvider.extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)"})
  public void testExtractQuantityRule_thenThrowUnsupportedOperationException() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ruleFieldPersistenceProvider
        .extractQuantityRule(extractValueRequest, mapper, new MVELToDataWrapperTranslator()));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"})
  public void testPopulateSimpleRule() throws Exception {
    // Arrange
    when(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(Mockito.<DataDTOToMVELTranslator>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<DataWrapper>any()))
        .thenReturn("Convert Simple Match Rule Json To Mvel");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(new DataWrapper());
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getMetadata()).thenReturn(new BasicFieldMetadata());
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    boolean actualPopulateSimpleRuleResult = ruleFieldPersistenceProvider.populateSimpleRule(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    verify(ruleFieldExtractionUtility).convertSimpleMatchRuleJsonToMvel(isA(DataDTOToMVELTranslator.class), isNull(),
        isNull(), isA(DataWrapper.class));
    verify(populateValueRequest, atLeast(1)).getMetadata();
    verify(populateValueRequest, atLeast(1)).getProperty();
    verify(populateValueRequest).getReturnType();
    assertFalse(actualPopulateSimpleRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"})
  public void testPopulateSimpleRule2() throws Exception {
    // Arrange
    when(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(Mockito.<DataDTOToMVELTranslator>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<DataWrapper>any()))
        .thenReturn("Convert Simple Match Rule Json To Mvel");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(null);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getMetadata()).thenReturn(new BasicFieldMetadata());
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    boolean actualPopulateSimpleRuleResult = ruleFieldPersistenceProvider.populateSimpleRule(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    verify(ruleFieldExtractionUtility).convertSimpleMatchRuleJsonToMvel(isA(DataDTOToMVELTranslator.class), isNull(),
        isNull(), isNull());
    verify(populateValueRequest, atLeast(1)).getMetadata();
    verify(populateValueRequest, atLeast(1)).getProperty();
    verify(populateValueRequest).getReturnType();
    assertFalse(actualPopulateSimpleRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getError()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"})
  public void testPopulateSimpleRule_givenDataWrapperGetErrorReturnEmptyString() throws Exception {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("");
    when(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(Mockito.<DataDTOToMVELTranslator>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<DataWrapper>any()))
        .thenReturn("Convert Simple Match Rule Json To Mvel");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getMetadata()).thenReturn(new BasicFieldMetadata());
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    boolean actualPopulateSimpleRuleResult = ruleFieldPersistenceProvider.populateSimpleRule(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    verify(ruleFieldExtractionUtility).convertSimpleMatchRuleJsonToMvel(isA(DataDTOToMVELTranslator.class), isNull(),
        isNull(), isA(DataWrapper.class));
    verify(populateValueRequest, atLeast(1)).getMetadata();
    verify(populateValueRequest, atLeast(1)).getProperty();
    verify(populateValueRequest).getReturnType();
    verify(dataWrapper).getError();
    assertFalse(actualPopulateSimpleRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then calls {@link DataWrapper#getError()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"})
  public void testPopulateSimpleRule_thenCallsGetError() throws Exception {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    boolean actualPopulateSimpleRuleResult = ruleFieldPersistenceProvider.populateSimpleRule(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    verify(populateValueRequest, atLeast(1)).getProperty();
    verify(dataWrapper).getError();
    assertFalse(actualPopulateSimpleRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule, EntityManager)}.
   * <ul>
   *   <li>When {@link SimpleRule}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule, EntityManager)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long RuleFieldPersistenceProvider.getContainedRuleId(SimpleRule, EntityManager)"})
  public void testGetContainedRuleId_whenSimpleRule_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ruleFieldPersistenceProvider.getContainedRuleId(mock(SimpleRule.class), null));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long RuleFieldPersistenceProvider.transformId(Long, Object)"})
  public void testTransformId() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler = mock(
        RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);

    // Act
    Long actualTransformIdResult = ruleFieldPersistenceProvider.transformId(1L, "Rule");

    // Assert
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
    verify(ruleFieldPersistenceProviderExtensionHandler).transformId(isA(Object.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1L, actualTransformIdResult.longValue());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long RuleFieldPersistenceProvider.transformId(Long, Object)"})
  public void testTransformId2() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler = mock(
        RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);

    // Act
    Long actualTransformIdResult = ruleFieldPersistenceProvider.transformId(1L, "Rule");

    // Assert
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
    verify(ruleFieldPersistenceProviderExtensionHandler).transformId(isA(Object.class),
        isA(ExtensionResultHolder.class));
    assertEquals(1L, actualTransformIdResult.longValue());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   * <ul>
   *   <li>Given {@link RuleFieldPersistenceProvider} (default constructor).</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long RuleFieldPersistenceProvider.transformId(Long, Object)"})
  public void testTransformId_givenRuleFieldPersistenceProvider_thenReturnLongValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1L, (new RuleFieldPersistenceProvider()).transformId(1L, "Rule").longValue());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   * <ul>
   *   <li>Then throw {@link PersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long RuleFieldPersistenceProvider.transformId(Long, Object)"})
  public void testTransformId_thenThrowPersistenceException() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler = mock(
        RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenThrow(new PersistenceException("An error occurred"));
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);

    // Act and Assert
    assertThrows(PersistenceException.class, () -> ruleFieldPersistenceProvider.transformId(1L, "Rule"));
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
    verify(ruleFieldPersistenceProviderExtensionHandler).transformId(isA(Object.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"})
  public void testRecursivelyExtractParent() throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

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
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"})
  public void testRecursivelyExtractParent2() throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn(".");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    when(populateValueRequest.getProperty()).thenReturn(property);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Object actualRecursivelyExtractParentResult = ruleFieldPersistenceProvider
        .recursivelyExtractParent(populateValueRequest, instance);

    // Assert
    verify(property).getName();
    verify(populateValueRequest).getFieldManager();
    verify(populateValueRequest).getProperty();
    assertSame(instance, actualRecursivelyExtractParentResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link FieldManager} {@link FieldManager#getFieldValue(Object, String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"})
  public void testRecursivelyExtractParent_givenFieldManagerGetFieldValueReturnNull()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"})
  public void testRecursivelyExtractParent_givenPropertyGetNameReturnName_thenCallsGetName()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"})
  public void testRecursivelyExtractParent_givenPropertyWithNameAndValueIs42()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code Field Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"})
  public void testRecursivelyExtractParent_thenReturnFieldValue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
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
   * Method under test: {@link RuleFieldPersistenceProvider#parseParentProperty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RuleFieldPersistenceProvider.parseParentProperty(String)"})
  public void testParseParentProperty_whenDot_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ruleFieldPersistenceProvider.parseParentProperty("."));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.isEmbeddable(Class)"})
  public void testIsEmbeddable_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(ruleFieldPersistenceProvider.isEmbeddable(clazz));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"})
  public void testConvertQuantityBasedRuleToJson() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler = mock(
        RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenReturn("Unescape Special Characters");
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getQuantity()).thenReturn(1);
    when(quantityBasedRule.getId()).thenReturn(1L);
    when(quantityBasedRule.getMatchRule()).thenReturn("Match Rule");

    ArrayList<QuantityBasedRule> quantityBasedRules = new ArrayList<>();
    quantityBasedRules.add(quantityBasedRule);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(translator,
        mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility).unescapeSpecialCharacters(eq("Match Rule"));
    verify(ruleFieldPersistenceProviderExtensionHandler).transformId(isA(Object.class),
        isA(ExtensionResultHolder.class));
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), eq("quantity"), eq("id"), eq("containedId"),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"})
  public void testConvertQuantityBasedRuleToJson2() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler = mock(
        RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any())).thenReturn(null);
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getQuantity()).thenReturn(1);
    when(quantityBasedRule.getId()).thenReturn(1L);
    when(quantityBasedRule.getMatchRule()).thenReturn("Match Rule");

    ArrayList<QuantityBasedRule> quantityBasedRules = new ArrayList<>();
    quantityBasedRules.add(quantityBasedRule);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(translator,
        mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility).unescapeSpecialCharacters(eq("Match Rule"));
    verify(ruleFieldPersistenceProviderExtensionHandler).transformId(isA(Object.class),
        isA(ExtensionResultHolder.class));
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), eq("quantity"), eq("id"), eq("containedId"),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <ul>
   *   <li>Given {@link DataDTO} (default constructor) Condition is {@code matchRule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"})
  public void testConvertQuantityBasedRuleToJson_givenDataDTOConditionIsMatchRule() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));

    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("matchRule");
    dataDTO.setContainedPk(6L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(6L);
    dataDTO.setPreviousContainedPk(6L);
    dataDTO.setPreviousPk(6L);
    dataDTO.setQuantity(6);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> dataDTOList = new ArrayList<>();
    dataDTOList.add(dataDTO);
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(dataDTOList);
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(translator,
        mapper, new ArrayList<>(), "Json Prop", "Field Service"));
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), eq("quantity"), eq("id"), eq("containedId"),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"})
  public void testConvertQuantityBasedRuleToJson_givenJavaLangObject() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    builderResult.addMixIn(target, mixinSource);
    JsonMapper mapper = builderResult.findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(translator,
        mapper, new ArrayList<>(), "Json Prop", "Field Service"));
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), eq("quantity"), eq("id"), eq("containedId"),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"})
  public void testConvertQuantityBasedRuleToJson_thenCallsGetProxy() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler = mock(
        RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenReturn("Unescape Special Characters");
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getQuantity()).thenReturn(1);
    when(quantityBasedRule.getId()).thenReturn(1L);
    when(quantityBasedRule.getMatchRule()).thenReturn("Match Rule");

    ArrayList<QuantityBasedRule> quantityBasedRules = new ArrayList<>();
    quantityBasedRules.add(quantityBasedRule);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(translator,
        mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility).unescapeSpecialCharacters(eq("Match Rule"));
    verify(ruleFieldPersistenceProviderExtensionHandler).transformId(isA(Object.class),
        isA(ExtensionResultHolder.class));
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), eq("quantity"), eq("id"), eq("containedId"),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"})
  public void testConvertQuantityBasedRuleToJson_thenCallsGetProxy2() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler = mock(
        RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenReturn("Unescape Special Characters");
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getQuantity()).thenReturn(1);
    when(quantityBasedRule.getId()).thenReturn(1L);
    when(quantityBasedRule.getMatchRule()).thenReturn("Match Rule");
    QuantityBasedRule quantityBasedRule2 = mock(QuantityBasedRule.class);
    when(quantityBasedRule2.getQuantity()).thenReturn(1);
    when(quantityBasedRule2.getId()).thenReturn(1L);
    when(quantityBasedRule2.getMatchRule()).thenReturn("Match Rule");

    ArrayList<QuantityBasedRule> quantityBasedRules = new ArrayList<>();
    quantityBasedRules.add(quantityBasedRule2);
    quantityBasedRules.add(quantityBasedRule);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(translator,
        mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager, atLeast(1)).getProxy();
    verify(quantityBasedRule2).getId();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule2).getMatchRule();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule2).getQuantity();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility, atLeast(1)).unescapeSpecialCharacters(eq("Match Rule"));
    verify(ruleFieldPersistenceProviderExtensionHandler, atLeast(1)).transformId(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Long>>any());
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), eq("quantity"), eq("id"), eq("containedId"),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <ul>
   *   <li>Then return RawValue is {@code {"data":[],"error":null,"rawMvel":null}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"})
  public void testConvertQuantityBasedRuleToJson_thenReturnRawValueIsDataErrorNullRawMvelNull() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(new DataWrapper());
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    Property actualConvertQuantityBasedRuleToJsonResult = ruleFieldPersistenceProvider
        .convertQuantityBasedRuleToJson(translator, mapper, new ArrayList<>(), "Json Prop", "Field Service");

    // Assert
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), eq("quantity"), eq("id"), eq("containedId"),
        isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
    assertTrue(actualConvertQuantityBasedRuleToJsonResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Json Prop", actualConvertQuantityBasedRuleToJsonResult.getName());
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}",
        actualConvertQuantityBasedRuleToJsonResult.getRawValue());
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}",
        actualConvertQuantityBasedRuleToJsonResult.getUnHtmlEncodedValue());
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}",
        actualConvertQuantityBasedRuleToJsonResult.getValue());
    assertNull(actualConvertQuantityBasedRuleToJsonResult.getDisplayValue());
    assertNull(actualConvertQuantityBasedRuleToJsonResult.getOriginalDisplayValue());
    assertNull(actualConvertQuantityBasedRuleToJsonResult.getOriginalValue());
    assertNull(actualConvertQuantityBasedRuleToJsonResult.getDeployDate());
    assertFalse(actualConvertQuantityBasedRuleToJsonResult.getIsDirty());
    assertFalse(actualConvertQuantityBasedRuleToJsonResult.isAdvancedCollection());
    assertTrue(actualConvertQuantityBasedRuleToJsonResult.getEnabled());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <ul>
   *   <li>Then return RawValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"})
  public void testConvertQuantityBasedRuleToJson_thenReturnRawValueIsNull() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    Property actualConvertQuantityBasedRuleToJsonResult = ruleFieldPersistenceProvider
        .convertQuantityBasedRuleToJson(translator, mapper, new ArrayList<>(), "Json Prop", "Field Service");

    // Assert
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
    assertTrue(actualConvertQuantityBasedRuleToJsonResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Json Prop", actualConvertQuantityBasedRuleToJsonResult.getName());
    assertEquals("null", actualConvertQuantityBasedRuleToJsonResult.getRawValue());
    assertEquals("null", actualConvertQuantityBasedRuleToJsonResult.getUnHtmlEncodedValue());
    assertEquals("null", actualConvertQuantityBasedRuleToJsonResult.getValue());
    assertNull(actualConvertQuantityBasedRuleToJsonResult.getDisplayValue());
    assertNull(actualConvertQuantityBasedRuleToJsonResult.getOriginalDisplayValue());
    assertNull(actualConvertQuantityBasedRuleToJsonResult.getOriginalValue());
    assertNull(actualConvertQuantityBasedRuleToJsonResult.getDeployDate());
    assertFalse(actualConvertQuantityBasedRuleToJsonResult.getIsDirty());
    assertFalse(actualConvertQuantityBasedRuleToJsonResult.isAdvancedCollection());
    assertTrue(actualConvertQuantityBasedRuleToJsonResult.getEnabled());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <ul>
   *   <li>Then throw {@link ParentEntityPersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"})
  public void testConvertQuantityBasedRuleToJson_thenThrowParentEntityPersistenceException() {
    // Arrange
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getMatchRule()).thenThrow(new ParentEntityPersistenceException("An error occurred"));

    ArrayList<QuantityBasedRule> quantityBasedRules = new ArrayList<>();
    quantityBasedRules.add(quantityBasedRule);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class, () -> ruleFieldPersistenceProvider
        .convertQuantityBasedRuleToJson(translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(quantityBasedRule).getMatchRule();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"})
  public void testConvertQuantityBasedRuleToJson_whenArrayList_thenThrowRuntimeException() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(Mockito.<Entity[]>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<RuleBuilderFieldService>any())).thenReturn(dataWrapper);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(translator,
        mapper, new ArrayList<>(), "Json Prop", "Field Service"));
    verify(translator).createRuleData(isA(Entity[].class), eq("matchRule"), eq("quantity"), eq("id"), eq("containedId"),
        isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance(eq("Field Service"));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"})
  public void testUpdateQuantityRule() {
    // Arrange
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(null);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();
    ArrayList<QuantityBasedRule> criteriaList = new ArrayList<>();
    Class<Object> memberType = Object.class;
    Property property = new Property();

    // Act
    boolean actualUpdateQuantityRuleResult = ruleFieldPersistenceProvider.updateQuantityRule(null, translator,
        "Entity Key", "Field Service", "42", criteriaList, memberType, "Parent", "Mapped By", property);

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertFalse(actualUpdateQuantityRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getError()} return {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"})
  public void testUpdateQuantityRule_givenDataWrapperGetErrorReturnAnErrorOccurred() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();
    ArrayList<QuantityBasedRule> criteriaList = new ArrayList<>();
    Class<Object> memberType = Object.class;
    Property property = new Property();

    // Act
    boolean actualUpdateQuantityRuleResult = ruleFieldPersistenceProvider.updateQuantityRule(null, translator,
        "Entity Key", "Field Service", "42", criteriaList, memberType, "Parent", "Mapped By", property);

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    verify(dataWrapper).getError();
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertFalse(actualUpdateQuantityRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getError()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"})
  public void testUpdateQuantityRule_givenDataWrapperGetErrorReturnEmptyString() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();
    ArrayList<QuantityBasedRule> criteriaList = new ArrayList<>();
    Class<Object> memberType = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldPersistenceProvider.updateQuantityRule(null, translator,
        "Entity Key", "Field Service", "42", criteriaList, memberType, "Parent", "Mapped By", new Property()));
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    verify(dataWrapper, atLeast(1)).getData();
    verify(dataWrapper, atLeast(1)).getError();
    verify(dataWrapper).getRawMvel();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getError()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"})
  public void testUpdateQuantityRule_givenDataWrapperGetErrorReturnNull() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn(null);
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();
    ArrayList<QuantityBasedRule> criteriaList = new ArrayList<>();
    Class<Object> memberType = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ruleFieldPersistenceProvider.updateQuantityRule(null, translator,
        "Entity Key", "Field Service", "42", criteriaList, memberType, "Parent", "Mapped By", new Property()));
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    verify(dataWrapper, atLeast(1)).getData();
    verify(dataWrapper, atLeast(1)).getError();
    verify(dataWrapper).getRawMvel();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   * <ul>
   *   <li>Given {@link QuantityBasedRule}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link QuantityBasedRule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"})
  public void testUpdateQuantityRule_givenQuantityBasedRule_whenArrayListAddQuantityBasedRule() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    ArrayList<QuantityBasedRule> criteriaList = new ArrayList<>();
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;
    Property property = new Property();

    // Act
    boolean actualUpdateQuantityRuleResult = ruleFieldPersistenceProvider.updateQuantityRule(null, translator,
        "Entity Key", "Field Service", "42", criteriaList, memberType, "Parent", "Mapped By", property);

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    verify(dataWrapper).getError();
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertFalse(actualUpdateQuantityRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   * <ul>
   *   <li>Given {@link QuantityBasedRule}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link QuantityBasedRule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"})
  public void testUpdateQuantityRule_givenQuantityBasedRule_whenArrayListAddQuantityBasedRule2() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    ArrayList<QuantityBasedRule> criteriaList = new ArrayList<>();
    criteriaList.add(mock(QuantityBasedRule.class));
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;
    Property property = new Property();

    // Act
    boolean actualUpdateQuantityRuleResult = ruleFieldPersistenceProvider.updateQuantityRule(null, translator,
        "Entity Key", "Field Service", "42", criteriaList, memberType, "Parent", "Mapped By", property);

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    verify(dataWrapper).getError();
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertFalse(actualUpdateQuantityRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   * <ul>
   *   <li>Then {@link Property#Property()} RawValue is {@code {"data":[],"error":null,"rawMvel":null}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"})
  public void testUpdateQuantityRule_thenPropertyRawValueIsDataErrorNullRawMvelNull() {
    // Arrange
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(new DataWrapper());
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();
    ArrayList<QuantityBasedRule> criteriaList = new ArrayList<>();
    Class<Object> memberType = Object.class;
    Property property = new Property();

    // Act
    boolean actualUpdateQuantityRuleResult = ruleFieldPersistenceProvider.updateQuantityRule(null, translator,
        "Entity Key", "Field Service", "42", criteriaList, memberType, "Parent", "Mapped By", property);

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}", property.getRawValue());
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}", property.getUnHtmlEncodedValue());
    assertEquals("{\"data\":[],\"error\":null,\"rawMvel\":null}", property.getValue());
    assertFalse(actualUpdateQuantityRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   * <ul>
   *   <li>Then throw {@link ParentEntityPersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"})
  public void testUpdateQuantityRule_thenThrowParentEntityPersistenceException() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any())).thenReturn(dataWrapper);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();
    ArrayList<QuantityBasedRule> criteriaList = new ArrayList<>();
    Class<Object> memberType = Object.class;

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> ruleFieldPersistenceProvider.updateQuantityRule(null, translator, "Entity Key", "Field Service", "42",
            criteriaList, memberType, "Parent", "Mapped By", new Property()));
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper(eq("42"));
    verify(dataWrapper).getError();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link Property#Property()} RawValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"})
  public void testUpdateQuantityRule_whenArrayList_thenPropertyRawValueIsNull() {
    // Arrange
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();
    ArrayList<QuantityBasedRule> criteriaList = new ArrayList<>();
    Class<Object> memberType = Object.class;
    Property property = new Property();

    // Act
    boolean actualUpdateQuantityRuleResult = ruleFieldPersistenceProvider.updateQuantityRule(null, translator,
        "Entity Key", "Field Service", null, criteriaList, memberType, "Parent", "Mapped By", property);

    // Assert
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertFalse(actualUpdateQuantityRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)}.
   * <ul>
   *   <li>Then throw {@link PersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void RuleFieldPersistenceProvider.updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)"})
  public void testUpdateSimpleRule_thenThrowPersistenceException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_givenBasicFieldMetadata() throws ClassNotFoundException, IllegalAccessException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_givenPropertyGetNameReturnName_thenCallsGetName()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_givenPropertyWithNameAndValueIs42()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_thenReturnList() throws ClassNotFoundException, IllegalAccessException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_thenThrowIllegalAccessException()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
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
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_thenThrowIllegalAccessException2()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RuleFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.RULE, ruleFieldPersistenceProvider.getOrder());
  }
}
