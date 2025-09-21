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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.rule.QuantityBasedRule;
import org.broadleafcommerce.common.rule.SimpleRule;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
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
  @Mock private RuleBuilderFieldServiceFactory ruleBuilderFieldServiceFactory;

  @Mock private RuleFieldExtractionUtility ruleFieldExtractionUtility;

  @InjectMocks private RuleFieldPersistenceProvider ruleFieldPersistenceProvider;

  @Mock
  private RuleFieldPersistenceProviderExtensionManager ruleFieldPersistenceProviderExtensionManager;

  @Mock private SandBoxHelper sandBoxHelper;

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.RULE_WITH_QUANTITY);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualCanHandlePersistenceResult =
        ruleFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata).getFieldType();
    assertTrue(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence2() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.RULE_SIMPLE_TIME);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualCanHandlePersistenceResult =
        ruleFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    assertTrue(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence_thenReturnFalse() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualCanHandlePersistenceResult =
        ruleFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@link
   *       SupportedFieldType#RULE_SIMPLE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence_whenBasicFieldMetadataGetFieldTypeReturnRule_simple() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.RULE_SIMPLE);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualCanHandlePersistenceResult =
        ruleFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    assertTrue(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.RULE_WITH_QUANTITY);
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act
    boolean actualCanHandleExtractionResult =
        ruleFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property());

    // Assert
    verify(metadata).getFieldType();
    assertTrue(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_thenReturnFalse() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act and Assert
    assertFalse(
        ruleFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@link
   *       SupportedFieldType#RULE_SIMPLE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_whenBasicFieldMetadataGetFieldTypeReturnRule_simple() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.RULE_SIMPLE);
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act
    boolean actualCanHandleExtractionResult =
        ruleFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property());

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    assertTrue(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@link
   *       SupportedFieldType#RULE_SIMPLE_TIME}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_whenBasicFieldMetadataGetFieldTypeReturnRule_simple_time() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.RULE_SIMPLE_TIME);
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act
    boolean actualCanHandleExtractionResult =
        ruleFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property());

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    assertTrue(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN}.
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse RuleFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_givenUnknown_thenCallsGetFieldType() throws PersistenceException {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult =
        ruleFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse RuleFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_thenReturnNotHandled() throws PersistenceException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult =
        ruleFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN}.
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse RuleFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_givenUnknown_thenCallsGetFieldType() throws PersistenceException {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act
    MetadataProviderResponse actualExtractValueResult =
        ruleFieldPersistenceProvider.extractValue(extractValueRequest, new Property());

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse RuleFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_thenReturnNotHandled() throws PersistenceException {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        ruleFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property(String, String)} with
   *       {@code Name} and value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse RuleFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"
  })
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameAndValueIs42() {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[] {new Property("Name", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult =
        ruleFieldPersistenceProvider.filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property(String, String)} with name
   *       is {@code Json} and value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse RuleFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"
  })
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameIsJsonAndValueIs42() {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[] {new Property("Json", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult =
        ruleFieldPersistenceProvider.filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse RuleFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"
  })
  public void testFilterProperties_givenPropertyGetNameReturnJson() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Json");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[] {property});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    HashMap<String, FieldMetadata> properties = new HashMap<>();
    properties.put("42", new AdornedTargetCollectionMetadata());

    // Act
    MetadataProviderResponse actualFilterPropertiesResult =
        ruleFieldPersistenceProvider.filterProperties(addFilterPropertiesRequest, properties);

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    verify(property, atLeast(1)).getName();
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse RuleFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"
  })
  public void testFilterProperties_givenPropertyGetNameReturnName_thenCallsGetName() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[] {property});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult =
        ruleFieldPersistenceProvider.filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    verify(property).getName();
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link PersistenceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse RuleFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"
  })
  public void testFilterProperties_thenThrowPersistenceException() {
    // Arrange
    Entity entity = mock(Entity.class);
    doThrow(new PersistenceException("An error occurred"))
        .when(entity)
        .setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[] {new Property("Json", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.filterProperties(
                addFilterPropertiesRequest, new HashMap<>()));
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property,
   * ObjectMapper, MVELToDataWrapperTranslator)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper,
   * MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)"
  })
  public void testExtractSimpleRule() {
    // Arrange
    Property property = new Property();
    when(ruleFieldExtractionUtility.convertSimpleRuleToJson(
            Mockito.<MVELToDataWrapperTranslator>any(),
            Mockito.<ObjectMapper>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(property);
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    Property property2 = new Property();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    ruleFieldPersistenceProvider.extractSimpleRule(
        extractValueRequest, property2, mapper, new MVELToDataWrapperTranslator());

    // Assert
    verify(ruleFieldExtractionUtility)
        .convertSimpleRuleToJson(
            isA(MVELToDataWrapperTranslator.class),
            isA(ObjectMapper.class),
            eq("Requested Value"),
            eq("nullJson"),
            isNull());
    List<Property> props2 = extractValueRequest.getProps();
    assertEquals(1, props2.size());
    Property getResult = props2.get(0);
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getName());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertEquals(property, property2);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property,
   * ObjectMapper, MVELToDataWrapperTranslator)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper,
   * MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)"
  })
  public void testExtractSimpleRule2() {
    // Arrange
    Property property = new Property();
    when(ruleFieldExtractionUtility.convertSimpleRuleToJson(
            Mockito.<MVELToDataWrapperTranslator>any(),
            Mockito.<ObjectMapper>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(property);
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            null,
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    Property property2 = new Property();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    ruleFieldPersistenceProvider.extractSimpleRule(
        extractValueRequest, property2, mapper, new MVELToDataWrapperTranslator());

    // Assert
    verify(ruleFieldExtractionUtility)
        .convertSimpleRuleToJson(
            isA(MVELToDataWrapperTranslator.class),
            isA(ObjectMapper.class),
            isNull(),
            eq("nullJson"),
            isNull());
    List<Property> props2 = extractValueRequest.getProps();
    assertEquals(1, props2.size());
    assertEquals(property, property2);
    assertSame(props, props2);
    assertSame(property, props2.get(0));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property,
   * ObjectMapper, MVELToDataWrapperTranslator)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper,
   * MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)"
  })
  public void testExtractSimpleRule3() {
    // Arrange
    when(ruleFieldExtractionUtility.convertSimpleRuleToJson(
            Mockito.<MVELToDataWrapperTranslator>any(),
            Mockito.<ObjectMapper>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new Property());
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            null,
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    ruleFieldPersistenceProvider.extractSimpleRule(
        extractValueRequest, property, mapper, new MVELToDataWrapperTranslator());

    // Assert
    verify(property).getName();
    verify(ruleFieldExtractionUtility)
        .convertSimpleRuleToJson(
            isA(MVELToDataWrapperTranslator.class),
            isA(ObjectMapper.class),
            isNull(),
            eq("NameJson"),
            isNull());
    List<Property> props2 = extractValueRequest.getProps();
    assertEquals(1, props2.size());
    Property getResult = props2.get(0);
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getName());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property,
   * ObjectMapper, MVELToDataWrapperTranslator)}.
   *
   * <ul>
   *   <li>Then calls {@link Property#setDisplayValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper,
   * MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)"
  })
  public void testExtractSimpleRule_thenCallsSetDisplayValue() {
    // Arrange
    when(ruleFieldExtractionUtility.convertSimpleRuleToJson(
            Mockito.<MVELToDataWrapperTranslator>any(),
            Mockito.<ObjectMapper>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new Property());
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    doNothing().when(property).setDisplayValue(Mockito.<String>any());
    doNothing().when(property).setValue(Mockito.<String>any());
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    ruleFieldPersistenceProvider.extractSimpleRule(
        extractValueRequest, property, mapper, new MVELToDataWrapperTranslator());

    // Assert
    verify(property).getName();
    verify(property).setDisplayValue("Display Val");
    verify(property).setValue("Requested Value");
    verify(ruleFieldExtractionUtility)
        .convertSimpleRuleToJson(
            isA(MVELToDataWrapperTranslator.class),
            isA(ObjectMapper.class),
            eq("Requested Value"),
            eq("NameJson"),
            isNull());
    List<Property> props2 = extractValueRequest.getProps();
    assertEquals(1, props2.size());
    Property getResult = props2.get(0);
    assertTrue(getResult.getMetadata() instanceof BasicFieldMetadata);
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getName());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property,
   * ObjectMapper, MVELToDataWrapperTranslator)}.
   *
   * <ul>
   *   <li>Then throw {@link PersistenceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper,
   * MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)"
  })
  public void testExtractSimpleRule_thenThrowPersistenceException() {
    // Arrange
    when(ruleFieldExtractionUtility.convertSimpleRuleToJson(
            Mockito.<MVELToDataWrapperTranslator>any(),
            Mockito.<ObjectMapper>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenThrow(new PersistenceException("An error occurred"));
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    Property property = new Property();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.extractSimpleRule(
                extractValueRequest, property, mapper, new MVELToDataWrapperTranslator()));
    verify(ruleFieldExtractionUtility)
        .convertSimpleRuleToJson(
            isA(MVELToDataWrapperTranslator.class),
            isA(ObjectMapper.class),
            eq("Requested Value"),
            eq("nullJson"),
            isNull());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property,
   * ObjectMapper, MVELToDataWrapperTranslator)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#extractSimpleRule(ExtractValueRequest, Property, ObjectMapper,
   * MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.extractSimpleRule(ExtractValueRequest, Property, ObjectMapper, MVELToDataWrapperTranslator)"
  })
  public void testExtractSimpleRule_thenThrowUnsupportedOperationException() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            42,
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    Property property = new Property();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            ruleFieldPersistenceProvider.extractSimpleRule(
                extractValueRequest, property, mapper, new MVELToDataWrapperTranslator()));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper,
   * MVELToDataWrapperTranslator)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper,
   * MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)"
  })
  public void testExtractQuantityRule() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    ArrayList<Object> objectList = new ArrayList<>();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            objectList,
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    ruleFieldPersistenceProvider.extractQuantityRule(
        extractValueRequest, mapper, new MVELToDataWrapperTranslator());

    // Assert
    verify(ruleBuilderFieldServiceFactory).createInstance(null);
    assertSame(props, extractValueRequest.getProps());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper,
   * MVELToDataWrapperTranslator)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper,
   * MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)"
  })
  public void testExtractQuantityRule2() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenThrow(new PersistenceException("An error occurred"));
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    ArrayList<Object> objectList = new ArrayList<>();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            objectList,
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.extractQuantityRule(
                extractValueRequest, mapper, new MVELToDataWrapperTranslator()));
    verify(ruleBuilderFieldServiceFactory).createInstance(null);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper,
   * MVELToDataWrapperTranslator)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper,
   * MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)"
  })
  public void testExtractQuantityRule_thenCallsGetName() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getName()).thenReturn("Name");
    when(metadata.getRuleIdentifier()).thenReturn("42");
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    ArrayList<Object> objectList = new ArrayList<>();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            objectList,
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.extractQuantityRule(
                extractValueRequest, mapper, new MVELToDataWrapperTranslator()));
    verify(metadata).getName();
    verify(metadata).getRuleIdentifier();
    verify(ruleBuilderFieldServiceFactory).createInstance("42");
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper,
   * MVELToDataWrapperTranslator)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#extractQuantityRule(ExtractValueRequest, ObjectMapper,
   * MVELToDataWrapperTranslator)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.extractQuantityRule(ExtractValueRequest, ObjectMapper, MVELToDataWrapperTranslator)"
  })
  public void testExtractQuantityRule_thenThrowUnsupportedOperationException() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            ruleFieldPersistenceProvider.extractQuantityRule(
                extractValueRequest, mapper, new MVELToDataWrapperTranslator()));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest,
   * Serializable)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"
  })
  public void testPopulateSimpleRule() throws Exception {
    // Arrange
    when(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(
            Mockito.<DataDTOToMVELTranslator>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DataWrapper>any()))
        .thenReturn("Convert Simple Match Rule Json To Mvel");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(new DataWrapper());

    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualPopulateSimpleRuleResult =
        ruleFieldPersistenceProvider.populateSimpleRule(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getName();
    verify(property).getUnHtmlEncodedValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("secret");
    verify(ruleFieldExtractionUtility)
        .convertSimpleMatchRuleJsonToMvel(
            isA(DataDTOToMVELTranslator.class), isNull(), isNull(), isA(DataWrapper.class));
    assertFalse(actualPopulateSimpleRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest,
   * Serializable)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"
  })
  public void testPopulateSimpleRule2() throws Exception {
    // Arrange
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenThrow(new PersistenceException("An error occurred"));

    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.populateSimpleRule(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(property).getName();
    verify(property).getUnHtmlEncodedValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("secret");
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest,
   * Serializable)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"
  })
  public void testPopulateSimpleRule3() throws Exception {
    // Arrange
    when(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(
            Mockito.<DataDTOToMVELTranslator>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DataWrapper>any()))
        .thenReturn("Convert Simple Match Rule Json To Mvel");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(null);

    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualPopulateSimpleRuleResult =
        ruleFieldPersistenceProvider.populateSimpleRule(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getName();
    verify(property).getUnHtmlEncodedValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("secret");
    verify(ruleFieldExtractionUtility)
        .convertSimpleMatchRuleJsonToMvel(
            isA(DataDTOToMVELTranslator.class), isNull(), isNull(), isNull());
    assertFalse(actualPopulateSimpleRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest,
   * Serializable)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"
  })
  public void testPopulateSimpleRule4() throws Exception {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenThrow(new PersistenceException("An error occurred"));
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(dataWrapper);

    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.populateSimpleRule(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(property).getName();
    verify(property).getUnHtmlEncodedValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("secret");
    verify(dataWrapper).getError();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then calls {@link BasicFieldMetadata#getRuleIdentifier()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"
  })
  public void testPopulateSimpleRule_given42_thenCallsGetRuleIdentifier() throws Exception {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("");
    when(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(
            Mockito.<DataDTOToMVELTranslator>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DataWrapper>any()))
        .thenReturn("Convert Simple Match Rule Json To Mvel");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(dataWrapper);

    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getName()).thenReturn("Name");

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getRuleIdentifier()).thenReturn("42");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualPopulateSimpleRuleResult =
        ruleFieldPersistenceProvider.populateSimpleRule(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata, atLeast(1)).getRuleIdentifier();
    verify(property, atLeast(1)).getName();
    verify(property).getUnHtmlEncodedValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("secret");
    verify(ruleFieldExtractionUtility)
        .convertSimpleMatchRuleJsonToMvel(
            isA(DataDTOToMVELTranslator.class), isNull(), eq("42"), isA(DataWrapper.class));
    verify(dataWrapper).getError();
    assertFalse(actualPopulateSimpleRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getError()} return {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"
  })
  public void testPopulateSimpleRule_givenDataWrapperGetErrorReturnAnErrorOccurred()
      throws Exception {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(dataWrapper);

    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualPopulateSimpleRuleResult =
        ruleFieldPersistenceProvider.populateSimpleRule(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    verify(property).getUnHtmlEncodedValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("secret");
    verify(dataWrapper).getError();
    assertFalse(actualPopulateSimpleRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getError()} return empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"
  })
  public void testPopulateSimpleRule_givenDataWrapperGetErrorReturnEmptyString_thenReturnFalse()
      throws Exception {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("");
    when(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(
            Mockito.<DataDTOToMVELTranslator>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DataWrapper>any()))
        .thenReturn("Convert Simple Match Rule Json To Mvel");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(dataWrapper);

    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    boolean actualPopulateSimpleRuleResult =
        ruleFieldPersistenceProvider.populateSimpleRule(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getName();
    verify(property).getUnHtmlEncodedValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("secret");
    verify(ruleFieldExtractionUtility)
        .convertSimpleMatchRuleJsonToMvel(
            isA(DataDTOToMVELTranslator.class), isNull(), isNull(), isA(DataWrapper.class));
    verify(dataWrapper).getError();
    assertFalse(actualPopulateSimpleRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Given {@link PersistenceException#PersistenceException(String)} with message is {@code An
   *       error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"
  })
  public void testPopulateSimpleRule_givenPersistenceExceptionWithMessageIsAnErrorOccurred()
      throws Exception {
    // Arrange
    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenThrow(new PersistenceException("An error occurred"));
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.populateSimpleRule(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(property).getName();
    verify(property).getUnHtmlEncodedValue();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#populateSimpleRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.populateSimpleRule(PopulateValueRequest, Serializable)"
  })
  public void testPopulateSimpleRule_thenThrowIllegalAccessException() throws Exception {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("");
    when(ruleFieldExtractionUtility.convertSimpleMatchRuleJsonToMvel(
            Mockito.<DataDTOToMVELTranslator>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<DataWrapper>any()))
        .thenReturn("Convert Simple Match Rule Json To Mvel");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(dataWrapper);

    Property property = mock(Property.class);
    when(property.getUnHtmlEncodedValue()).thenReturn("secret");
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            null,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertThrows(
        IllegalAccessException.class,
        () ->
            ruleFieldPersistenceProvider.populateSimpleRule(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(property, atLeast(1)).getName();
    verify(property).getUnHtmlEncodedValue();
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("secret");
    verify(ruleFieldExtractionUtility)
        .convertSimpleMatchRuleJsonToMvel(
            isA(DataDTOToMVELTranslator.class), isNull(), isNull(), isA(DataWrapper.class));
    verify(dataWrapper).getError();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule, EntityManager)}.
   *
   * <ul>
   *   <li>When {@link SimpleRule}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#getContainedRuleId(SimpleRule,
   * EntityManager)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long RuleFieldPersistenceProvider.getContainedRuleId(SimpleRule, EntityManager)"
  })
  public void testGetContainedRuleId_whenSimpleRule_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ruleFieldPersistenceProvider.getContainedRuleId(mock(SimpleRule.class), null));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RuleFieldPersistenceProvider.transformId(Long, Object)"})
  public void testTransformId() {
    // Arrange
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenThrow(new PersistenceException("An error occurred"));

    // Act and Assert
    assertThrows(
        PersistenceException.class, () -> ruleFieldPersistenceProvider.transformId(1L, "Rule"));
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RuleFieldPersistenceProvider.transformId(Long, Object)"})
  public void testTransformId2() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);

    // Act
    Long actualTransformIdResult = ruleFieldPersistenceProvider.transformId(1L, "Rule");

    // Assert
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
    verify(ruleFieldPersistenceProviderExtensionHandler)
        .transformId(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(1L, actualTransformIdResult.longValue());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RuleFieldPersistenceProvider.transformId(Long, Object)"})
  public void testTransformId3() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenThrow(new PersistenceException("An error occurred"));
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);

    // Act and Assert
    assertThrows(
        PersistenceException.class, () -> ruleFieldPersistenceProvider.transformId(1L, "Rule"));
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
    verify(ruleFieldPersistenceProviderExtensionHandler)
        .transformId(isA(Object.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RuleFieldPersistenceProvider.transformId(Long, Object)"})
  public void testTransformId4() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);

    // Act
    Long actualTransformIdResult = ruleFieldPersistenceProvider.transformId(1L, "Rule");

    // Assert
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
    verify(ruleFieldPersistenceProviderExtensionHandler)
        .transformId(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals(1L, actualTransformIdResult.longValue());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#transformId(Long, Object)}.
   *
   * <ul>
   *   <li>Given {@link RuleFieldPersistenceProvider} (default constructor).
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#transformId(Long, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RuleFieldPersistenceProvider.transformId(Long, Object)"})
  public void testTransformId_givenRuleFieldPersistenceProvider_thenReturnLongValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1L, new RuleFieldPersistenceProvider().transformId(1L, "Rule").longValue());
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest,
   * Serializable)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"
  })
  public void testRecursivelyExtractParent()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Object actualRecursivelyExtractParentResult =
        ruleFieldPersistenceProvider.recursivelyExtractParent(populateValueRequest, instance);

    // Assert
    assertSame(instance, actualRecursivelyExtractParentResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Given {@code Field Value}.
   *   <li>Then return {@code Field Value}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"
  })
  public void testRecursivelyExtractParent_givenFieldValue_thenReturnFieldValue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    Object actualRecursivelyExtractParentResult =
        ruleFieldPersistenceProvider.recursivelyExtractParent(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    verify(fieldManager)
        .getFieldValue(isA(Object.class), eq("org.broadleafcommerce.openadmin.dto"));
    assertEquals("Field Value", actualRecursivelyExtractParentResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"
  })
  public void testRecursivelyExtractParent_givenName_whenPropertyGetNameReturnName()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Object actualRecursivelyExtractParentResult =
        ruleFieldPersistenceProvider.recursivelyExtractParent(populateValueRequest, instance);

    // Assert
    verify(property).getName();
    assertSame(instance, actualRecursivelyExtractParentResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link FieldManager} {@link FieldManager#getFieldValue(Object, String)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"
  })
  public void testRecursivelyExtractParent_givenNull_whenFieldManagerGetFieldValueReturnNull()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    RuleFieldPersistenceProvider ruleFieldPersistenceProvider = new RuleFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(null);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata");
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Object actualRecursivelyExtractParentResult =
        ruleFieldPersistenceProvider.recursivelyExtractParent(populateValueRequest, instance);

    // Assert
    verify(property).getName();
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), Mockito.<String>any());
    assertSame(instance, actualRecursivelyExtractParentResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with name is {@code .} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#recursivelyExtractParent(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object RuleFieldPersistenceProvider.recursivelyExtractParent(PopulateValueRequest, Serializable)"
  })
  public void testRecursivelyExtractParent_whenPropertyWithNameIsDotAndValueIs42()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property(".", "42");
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Object actualRecursivelyExtractParentResult =
        ruleFieldPersistenceProvider.recursivelyExtractParent(populateValueRequest, instance);

    // Assert
    assertSame(instance, actualRecursivelyExtractParentResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#parseParentProperty(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#parseParentProperty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleFieldPersistenceProvider.parseParentProperty(String)"})
  public void testParseParentProperty_whenDot_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ruleFieldPersistenceProvider.parseParentProperty("."));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#isEmbeddable(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleFieldPersistenceProvider.isEmbeddable(Class)"})
  public void testIsEmbeddable_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(ruleFieldPersistenceProvider.isEmbeddable(clazz));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#populateQuantityRule(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then throw {@link PersistenceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#populateQuantityRule(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.populateQuantityRule(PopulateValueRequest, Serializable)"
  })
  public void testPopulateQuantityRule_givenName_thenThrowPersistenceException()
      throws IllegalAccessException, IllegalStateException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getField(Mockito.<Class<?>>any(), Mockito.<String>any()))
        .thenThrow(new PersistenceException("An error occurred"));

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.populateQuantityRule(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(property).getName();
    verify(fieldManager).getField(isA(Class.class), eq("Name"));
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenThrow(new PersistenceException("An error occurred"));
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, new ArrayList<>(), "Json Prop", "Field Service"));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson2() {
    // Arrange
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getMatchRule()).thenThrow(new PersistenceException("An error occurred"));

    ArrayList<QuantityBasedRule> quantityBasedRules = new ArrayList<>();
    quantityBasedRules.add(quantityBasedRule);

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(quantityBasedRule).getMatchRule();
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson3() {
    // Arrange
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenThrow(new PersistenceException("An error occurred"));
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getMatchRule()).thenReturn("Match Rule");

    ArrayList<QuantityBasedRule> quantityBasedRules = new ArrayList<>();
    quantityBasedRules.add(quantityBasedRule);

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(quantityBasedRule).getMatchRule();
    verify(ruleFieldExtractionUtility).unescapeSpecialCharacters("Match Rule");
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson4() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenReturn("Unescape Special Characters");

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getData()).thenThrow(new PersistenceException("An error occurred"));

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);
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
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager, atLeast(1)).getProxy();
    verify(quantityBasedRule2).getId();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule2).getMatchRule();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule2).getQuantity();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility, atLeast(1)).unescapeSpecialCharacters("Match Rule");
    verify(ruleFieldPersistenceProviderExtensionHandler, atLeast(1))
        .transformId(Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any());
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            eq("quantity"),
            eq("id"),
            eq("containedId"),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson5() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenReturn(null);

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(new ArrayList<>());

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);
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
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager, atLeast(1)).getProxy();
    verify(quantityBasedRule2).getId();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule2).getMatchRule();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule2).getQuantity();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility, atLeast(1)).unescapeSpecialCharacters("Match Rule");
    verify(ruleFieldPersistenceProviderExtensionHandler, atLeast(1))
        .transformId(Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any());
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            eq("quantity"),
            eq("id"),
            eq("containedId"),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson6() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenReturn("Unescape Special Characters");

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getData()).thenThrow(new PersistenceException((String) null));

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);
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
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager, atLeast(1)).getProxy();
    verify(quantityBasedRule2).getId();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule2).getMatchRule();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule2).getQuantity();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility, atLeast(1)).unescapeSpecialCharacters("Match Rule");
    verify(ruleFieldPersistenceProviderExtensionHandler, atLeast(1))
        .transformId(Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any());
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            eq("quantity"),
            eq("id"),
            eq("containedId"),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson7() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenReturn("Unescape Special Characters");

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getData()).thenThrow(new PersistenceException(""));

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);
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
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager, atLeast(1)).getProxy();
    verify(quantityBasedRule2).getId();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule2).getMatchRule();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule2).getQuantity();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility, atLeast(1)).unescapeSpecialCharacters("Match Rule");
    verify(ruleFieldPersistenceProviderExtensionHandler, atLeast(1))
        .transformId(Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any());
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            eq("quantity"),
            eq("id"),
            eq("containedId"),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson8() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
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
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);
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
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager, atLeast(1)).getProxy();
    verify(quantityBasedRule2).getId();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule2).getMatchRule();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule2).getQuantity();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility, atLeast(1)).unescapeSpecialCharacters("Match Rule");
    verify(ruleFieldPersistenceProviderExtensionHandler, atLeast(1))
        .transformId(Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any());
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            eq("quantity"),
            eq("id"),
            eq("containedId"),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTO} (default constructor) Condition is {@code matchRule}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson_givenDataDTOConditionIsMatchRule() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenReturn("Unescape Special Characters");

    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("matchRule");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> dataDTOList = new ArrayList<>();
    dataDTOList.add(dataDTO);

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(dataWrapper.getRawMvel()).thenReturn("Raw Mvel");
    when(dataWrapper.getData()).thenReturn(dataDTOList);

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);
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
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager, atLeast(1)).getProxy();
    verify(quantityBasedRule2).getId();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule2).getMatchRule();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule2).getQuantity();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility, atLeast(1)).unescapeSpecialCharacters("Match Rule");
    verify(ruleFieldPersistenceProviderExtensionHandler, atLeast(1))
        .transformId(Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any());
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            eq("quantity"),
            eq("id"),
            eq("containedId"),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson_givenJavaLangObject() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
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
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);

    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper mapper = builderResult.findAndAddModules().build();

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
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager, atLeast(1)).getProxy();
    verify(quantityBasedRule2).getId();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule2).getMatchRule();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule2).getQuantity();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility, atLeast(1)).unescapeSpecialCharacters("Match Rule");
    verify(ruleFieldPersistenceProviderExtensionHandler, atLeast(1))
        .transformId(Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any());
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            eq("quantity"),
            eq("id"),
            eq("containedId"),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DataWrapper#getError()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson_thenCallsGetError() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
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
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(dataWrapper);
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
    assertThrows(
        RuntimeException.class,
        () ->
            ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
                translator, mapper, quantityBasedRules, "Json Prop", "Field Service"));
    verify(ruleFieldPersistenceProviderExtensionManager, atLeast(1)).getProxy();
    verify(quantityBasedRule2).getId();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule2).getMatchRule();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule2).getQuantity();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility, atLeast(1)).unescapeSpecialCharacters("Match Rule");
    verify(ruleFieldPersistenceProviderExtensionHandler, atLeast(1))
        .transformId(Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any());
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            eq("quantity"),
            eq("id"),
            eq("containedId"),
            isA(RuleBuilderFieldService.class));
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
    verify(dataWrapper).getRawMvel();
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
  }

  /**
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <ul>
   *   <li>Then return RawValue is a string.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson_thenReturnRawValueIsAString() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenReturn("Unescape Special Characters");
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getQuantity()).thenReturn(1);
    when(quantityBasedRule.getId()).thenReturn(1L);
    when(quantityBasedRule.getMatchRule()).thenReturn("Match Rule");

    ArrayList<QuantityBasedRule> quantityBasedRules = new ArrayList<>();
    quantityBasedRules.add(quantityBasedRule);

    // Act
    Property actualConvertQuantityBasedRuleToJsonResult =
        ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
            translator, mapper, quantityBasedRules, "Json Prop", "Field Service");

    // Assert
    verify(ruleFieldPersistenceProviderExtensionManager).getProxy();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility).unescapeSpecialCharacters("Match Rule");
    verify(ruleFieldPersistenceProviderExtensionHandler)
        .transformId(isA(Object.class), isA(ExtensionResultHolder.class));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
    assertTrue(
        actualConvertQuantityBasedRuleToJsonResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Json Prop", actualConvertQuantityBasedRuleToJsonResult.getName());
    assertEquals(
        "{\"data\":[],\"error\":\"Could not parse the MVEL expression to a compatible form for the rules builder"
            + " (Unescape Special Characters)\",\"rawMvel\":\"Unescape Special Characters\"}",
        actualConvertQuantityBasedRuleToJsonResult.getRawValue());
    assertEquals(
        "{\"data\":[],\"error\":\"Could not parse the MVEL expression to a compatible form for the rules builder"
            + " (Unescape Special Characters)\",\"rawMvel\":\"Unescape Special Characters\"}",
        actualConvertQuantityBasedRuleToJsonResult.getUnHtmlEncodedValue());
    assertEquals(
        "{\"data\":[],\"error\":\"Could not parse the MVEL expression to a compatible form for the rules builder"
            + " (Unescape Special Characters)\",\"rawMvel\":\"Unescape Special Characters\"}",
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
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <ul>
   *   <li>Then return RawValue is {@code {"data":[],"error":null,"rawMvel":null}}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson_thenReturnRawValueIsDataErrorNullRawMvelNull() {
    // Arrange
    RuleFieldPersistenceProviderExtensionHandler ruleFieldPersistenceProviderExtensionHandler =
        mock(RuleFieldPersistenceProviderExtensionHandler.class);
    when(ruleFieldPersistenceProviderExtensionHandler.transformId(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(ruleFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(ruleFieldPersistenceProviderExtensionHandler);
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    when(ruleFieldExtractionUtility.unescapeSpecialCharacters(Mockito.<String>any()))
        .thenReturn("Unescape Special Characters");

    MVELToDataWrapperTranslator translator = mock(MVELToDataWrapperTranslator.class);
    when(translator.createRuleData(
            Mockito.<Entity[]>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<RuleBuilderFieldService>any()))
        .thenReturn(new DataWrapper());
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

    // Act
    Property actualConvertQuantityBasedRuleToJsonResult =
        ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
            translator, mapper, quantityBasedRules, "Json Prop", "Field Service");

    // Assert
    verify(ruleFieldPersistenceProviderExtensionManager, atLeast(1)).getProxy();
    verify(quantityBasedRule2).getId();
    verify(quantityBasedRule).getId();
    verify(quantityBasedRule2).getMatchRule();
    verify(quantityBasedRule).getMatchRule();
    verify(quantityBasedRule2).getQuantity();
    verify(quantityBasedRule).getQuantity();
    verify(ruleFieldExtractionUtility, atLeast(1)).unescapeSpecialCharacters("Match Rule");
    verify(ruleFieldPersistenceProviderExtensionHandler, atLeast(1))
        .transformId(Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Long>>any());
    verify(translator)
        .createRuleData(
            isA(Entity[].class),
            eq("matchRule"),
            eq("quantity"),
            eq("id"),
            eq("containedId"),
            isA(RuleBuilderFieldService.class));
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
    assertTrue(
        actualConvertQuantityBasedRuleToJsonResult.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("Json Prop", actualConvertQuantityBasedRuleToJsonResult.getName());
    assertEquals(
        "{\"data\":[],\"error\":null,\"rawMvel\":null}",
        actualConvertQuantityBasedRuleToJsonResult.getRawValue());
    assertEquals(
        "{\"data\":[],\"error\":null,\"rawMvel\":null}",
        actualConvertQuantityBasedRuleToJsonResult.getUnHtmlEncodedValue());
    assertEquals(
        "{\"data\":[],\"error\":null,\"rawMvel\":null}",
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
   * Test {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return RawValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator,
   * ObjectMapper, Collection, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Property RuleFieldPersistenceProvider.convertQuantityBasedRuleToJson(MVELToDataWrapperTranslator, ObjectMapper, Collection, String, String)"
  })
  public void testConvertQuantityBasedRuleToJson_whenArrayList_thenReturnRawValueIsNull() {
    // Arrange
    when(ruleBuilderFieldServiceFactory.createInstance(Mockito.<String>any()))
        .thenReturn(mock(RuleBuilderFieldService.class));
    MVELToDataWrapperTranslator translator = new MVELToDataWrapperTranslator();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    Property actualConvertQuantityBasedRuleToJsonResult =
        ruleFieldPersistenceProvider.convertQuantityBasedRuleToJson(
            translator, mapper, new ArrayList<>(), "Json Prop", "Field Service");

    // Assert
    verify(ruleBuilderFieldServiceFactory).createInstance("Field Service");
    assertTrue(
        actualConvertQuantityBasedRuleToJsonResult.getMetadata() instanceof BasicFieldMetadata);
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
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"
  })
  public void testUpdateQuantityRule() {
    // Arrange
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenThrow(new PersistenceException("An error occurred"));
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    LinkedHashSet<QuantityBasedRule> criteriaList = new LinkedHashSet<>();
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;

    Property property = new Property("Name", "42");
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.updateQuantityRule(
                null, translator, "", "", "42", criteriaList, memberType, "", "", property));
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("42");
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"
  })
  public void testUpdateQuantityRule2() {
    // Arrange
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(null);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    LinkedHashSet<QuantityBasedRule> criteriaList = new LinkedHashSet<>();
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;

    Property property = new Property("Name", "42");
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act
    boolean actualUpdateQuantityRuleResult =
        ruleFieldPersistenceProvider.updateQuantityRule(
            null, translator, "", "", "42", criteriaList, memberType, "", "", property);

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("42");
    assertFalse(actualUpdateQuantityRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"
  })
  public void testUpdateQuantityRule3() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenThrow(new PersistenceException("An error occurred"));
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(dataWrapper);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    LinkedHashSet<QuantityBasedRule> criteriaList = new LinkedHashSet<>();
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;

    Property property = new Property("Name", "42");
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.updateQuantityRule(
                null, translator, "", "", "42", criteriaList, memberType, "", "", property));
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("42");
    verify(dataWrapper).getError();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"
  })
  public void testUpdateQuantityRule4() {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("otherChangeSetProps");
    dataDTO.setContainedPk(0L);
    dataDTO.setCreatedFromSubGroup(false);
    dataDTO.setPk(0L);
    dataDTO.setPreviousContainedPk(0L);
    dataDTO.setPreviousPk(0L);
    dataDTO.setQuantity(0);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> dataDTOList = new ArrayList<>();
    dataDTOList.add(dataDTO);

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn(null);
    when(dataWrapper.getData()).thenReturn(dataDTOList);
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(dataWrapper);
    when(sandBoxHelper.isRelatedToParentCatalogIds(Mockito.<Object>any(), (Long[]) Mockito.any()))
        .thenThrow(new PersistenceException("An error occurred"));
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    LinkedHashSet<QuantityBasedRule> criteriaList = new LinkedHashSet<>();
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;

    Property property = new Property("Name", "42");
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.updateQuantityRule(
                null, translator, "", "", "42", criteriaList, memberType, "", "", property));
    verify(sandBoxHelper).isRelatedToParentCatalogIds(isA(Object.class), (Long[]) Mockito.any());
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("42");
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   *
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getError()} return {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"
  })
  public void testUpdateQuantityRule_givenDataWrapperGetErrorReturnAnErrorOccurred() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(dataWrapper);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    LinkedHashSet<QuantityBasedRule> criteriaList = new LinkedHashSet<>();
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;

    Property property = new Property("Name", "42");
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act
    boolean actualUpdateQuantityRuleResult =
        ruleFieldPersistenceProvider.updateQuantityRule(
            null, translator, "", "", "42", criteriaList, memberType, "", "", property);

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("42");
    verify(dataWrapper).getError();
    assertFalse(actualUpdateQuantityRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   *
   * <ul>
   *   <li>Given {@link DataWrapper} {@link DataWrapper#getError()} return {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"
  })
  public void testUpdateQuantityRule_givenDataWrapperGetErrorReturnAnErrorOccurred2() {
    // Arrange
    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn("An error occurred");
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(dataWrapper);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    LinkedHashSet<QuantityBasedRule> criteriaList = new LinkedHashSet<>();
    criteriaList.add(mock(QuantityBasedRule.class));
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;

    Property property = new Property("Name", "42");
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act
    boolean actualUpdateQuantityRuleResult =
        ruleFieldPersistenceProvider.updateQuantityRule(
            null, translator, "", "", "42", criteriaList, memberType, "", "", property);

    // Assert
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("42");
    verify(dataWrapper).getError();
    assertFalse(actualUpdateQuantityRuleResult);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   *
   * <ul>
   *   <li>Given {@link QuantityBasedRule}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"
  })
  public void testUpdateQuantityRule_givenQuantityBasedRule_thenReturnFalse() {
    // Arrange
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    LinkedHashSet<QuantityBasedRule> criteriaList = new LinkedHashSet<>();
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;

    Property property = new Property("Name", "42");
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act and Assert
    assertFalse(
        ruleFieldPersistenceProvider.updateQuantityRule(
            null, translator, "", "", "", criteriaList, memberType, "", "", property));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   *
   * <ul>
   *   <li>Given {@link QuantityBasedRule}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"
  })
  public void testUpdateQuantityRule_givenQuantityBasedRule_thenReturnFalse2() {
    // Arrange
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    LinkedHashSet<QuantityBasedRule> criteriaList = new LinkedHashSet<>();
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;

    Property property = new Property("Name", "42");
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act and Assert
    assertFalse(
        ruleFieldPersistenceProvider.updateQuantityRule(
            null, translator, "", "", null, criteriaList, memberType, "", "", property));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}.
   *
   * <ul>
   *   <li>Then calls {@link QuantityBasedRule#getQuantity()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#updateQuantityRule(EntityManager,
   * DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleFieldPersistenceProvider.updateQuantityRule(EntityManager, DataDTOToMVELTranslator, String, String, String, Collection, Class, Object, String, Property)"
  })
  public void testUpdateQuantityRule_thenCallsGetQuantity() {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("otherChangeSetProps");
    dataDTO.setContainedPk(0L);
    dataDTO.setCreatedFromSubGroup(false);
    dataDTO.setPk(0L);
    dataDTO.setPreviousContainedPk(0L);
    dataDTO.setPreviousPk(0L);
    dataDTO.setQuantity(0);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> dataDTOList = new ArrayList<>();
    dataDTOList.add(dataDTO);

    DataWrapper dataWrapper = mock(DataWrapper.class);
    when(dataWrapper.getError()).thenReturn(null);
    when(dataWrapper.getData()).thenReturn(dataDTOList);
    when(ruleFieldExtractionUtility.convertJsonToDataWrapper(Mockito.<String>any()))
        .thenReturn(dataWrapper);
    when(sandBoxHelper.isRelatedToParentCatalogIds(Mockito.<Object>any(), (Long[]) Mockito.any()))
        .thenReturn(true);
    DataDTOToMVELTranslator translator = new DataDTOToMVELTranslator();

    QuantityBasedRule quantityBasedRule = mock(QuantityBasedRule.class);
    when(quantityBasedRule.getQuantity()).thenThrow(new PersistenceException("An error occurred"));

    LinkedHashSet<QuantityBasedRule> criteriaList = new LinkedHashSet<>();
    criteriaList.add(quantityBasedRule);
    criteriaList.add(mock(QuantityBasedRule.class));
    Class<Object> memberType = Object.class;

    Property property = new Property("Name", "42");
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.updateQuantityRule(
                null, translator, "", "", "42", criteriaList, memberType, "", "", property));
    verify(quantityBasedRule).getQuantity();
    verify(sandBoxHelper).isRelatedToParentCatalogIds(isA(Object.class), (Long[]) Mockito.any());
    verify(ruleFieldExtractionUtility).convertJsonToDataWrapper("42");
    verify(dataWrapper).getData();
    verify(dataWrapper).getError();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String,
   * boolean, SimpleRule)}.
   *
   * <ul>
   *   <li>Then throw {@link PersistenceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#updateSimpleRule(PopulateValueRequest, String, boolean,
   * SimpleRule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleFieldPersistenceProvider.updateSimpleRule(PopulateValueRequest, String, boolean, SimpleRule)"
  })
  public void testUpdateSimpleRule_thenThrowPersistenceException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    SimpleRule rule = mock(SimpleRule.class);
    doThrow(new PersistenceException("An error occurred"))
        .when(rule)
        .setMatchRule(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            ruleFieldPersistenceProvider.updateSimpleRule(
                populateValueRequest, "Mvel", true, rule));
    verify(rule).setMatchRule("Mvel");
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType() throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property("---", "42");
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    Class<?> actualStartingValueType =
        ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType2() throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("---");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    Class<?> actualStartingValueType =
        ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(property).getName();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType3() throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("---");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            null,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertThrows(
        IllegalAccessException.class,
        () -> ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest));
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Given {@code List}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_givenJavaUtilList_thenReturnList()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getMapFieldValueClass()).thenReturn("java.util.List");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    Class<?> actualStartingValueType =
        ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(metadata).getMapFieldValueClass();
    verify(property).getName();
    Class<List> expectedStartingValueType = List.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_givenName_whenPropertyGetNameReturnName()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    Class<?> actualStartingValueType =
        ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(property).getName();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_thenThrowIllegalAccessException()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setMapFieldValueClass(null);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property("---", "42");
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            null,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertThrows(
        IllegalAccessException.class,
        () -> ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest));
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getMapFieldValueClass()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class RuleFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_whenBasicFieldMetadataGetMapFieldValueClassReturnNull()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getMapFieldValueClass()).thenReturn(null);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    Class<?> actualStartingValueType =
        ruleFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(metadata).getMapFieldValueClass();
    verify(property).getName();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link RuleFieldPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link RuleFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RuleFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.RULE, ruleFieldPersistenceProvider.getOrder());
  }
}
