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
import static org.junit.Assert.assertSame;
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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.value.ValueAssignable;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserAttributeImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.BasicFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddSearchMappingRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MapFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MapFieldPersistenceProviderDiffblueTest {
  @MockBean(name = "blBasicFieldPersistenceProviderExtensionManager")
  private BasicFieldPersistenceProviderExtensionManager
      basicFieldPersistenceProviderExtensionManager;

  @Autowired private MapFieldPersistenceProvider mapFieldPersistenceProvider;

  /**
   * Test {@link MapFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MapFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence_givenName_whenPropertyGetNameReturnName_thenReturnFalse() {
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
    boolean actualCanHandlePersistenceResult =
        mapFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MapFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence_thenReturnTrue() {
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
    boolean actualCanHandlePersistenceResult =
        mapFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertTrue(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MapFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_givenName_whenPropertyGetNameReturnName_thenReturnFalse() {
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

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    // Act
    boolean actualCanHandleExtractionResult =
        mapFieldPersistenceProvider.canHandleExtraction(extractValueRequest, property);

    // Assert
    verify(property).getName();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MapFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_thenReturnTrue() {
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

    // Act
    boolean actualCanHandleExtractionResult =
        mapFieldPersistenceProvider.canHandleExtraction(
            extractValueRequest, new Property("---", "42"));

    // Assert
    assertTrue(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue() {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("---");
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            null,
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
        PersistenceException.class,
        () ->
            mapFieldPersistenceProvider.populateValue(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue2() throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Property property = mock(Property.class);
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.ID);
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            false,
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
        mapFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getName();
    verify(property, atLeast(1)).setIsDirty(false);
    verify(fieldManager).getFieldValue(isA(Object.class), eq("---"));
    assertEquals(MetadataProviderResponse.HANDLED_BREAK, actualPopulateValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) MapFieldValueClass is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_given42_whenBasicFieldMetadataMapFieldValueClassIs42() {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setMapFieldValueClass("42");
    metadata.setFieldType(SupportedFieldType.BOOLEAN);
    FieldManager fieldManager = mock(FieldManager.class);
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
            mapFieldPersistenceProvider.populateValue(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(property).getName();
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code ID}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@code ID}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_givenId_whenBasicFieldMetadataFieldTypeIsId()
      throws IllegalAccessException, InstantiationException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.setFieldValue(
            Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Property property = mock(Property.class);
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.ID);
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
        mapFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getName();
    verify(property, atLeast(1)).setIsDirty(false);
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), eq("---"));
    verify(fieldManager).setFieldValue(isA(Object.class), eq("---"), isA(Object.class));
    assertEquals(MetadataProviderResponse.HANDLED_BREAK, actualPopulateValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_givenName_whenPropertyGetNameReturnName_thenReturnNotHandled() {
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
    MetadataProviderResponse actualPopulateValueResult =
        mapFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property).getName();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>When {@link FieldManager} {@link FieldManager#getFieldValue(Object, String)} return
   *       {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_givenSlash_whenFieldManagerGetFieldValueReturnSlash()
      throws IllegalAccessException, InstantiationException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.setFieldValue(
            Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(" /");

    Property property = mock(Property.class);
    when(property.getOriginalValue()).thenReturn("42");
    doNothing().when(property).setOriginalDisplayValue(Mockito.<String>any());
    doNothing().when(property).setOriginalValue(Mockito.<String>any());
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.BOOLEAN);
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
        mapFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getName();
    verify(property).getOriginalValue();
    verify(property, atLeast(1)).setIsDirty(false);
    verify(property).setOriginalDisplayValue("42");
    verify(property).setOriginalValue(" /");
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), eq("---"));
    verify(fieldManager).setFieldValue(isA(Object.class), eq("---"), isA(Object.class));
    assertEquals(MetadataProviderResponse.HANDLED_BREAK, actualPopulateValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) FieldType is {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_givenUnknown_whenBasicFieldMetadataFieldTypeIsUnknown()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Property property = mock(Property.class);
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.UNKNOWN);
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
        mapFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getName();
    verify(property, atLeast(1)).setIsDirty(false);
    verify(fieldManager).getFieldValue(isA(Object.class), eq("---"));
    assertEquals(MetadataProviderResponse.HANDLED_BREAK, actualPopulateValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) DefaultValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_whenBasicFieldMetadataDefaultValueIs42()
      throws IllegalAccessException, InstantiationException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.setFieldValue(
            Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Property property = mock(Property.class);
    when(property.getOriginalValue()).thenReturn("42");
    doNothing().when(property).setOriginalDisplayValue(Mockito.<String>any());
    doNothing().when(property).setOriginalValue(Mockito.<String>any());
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setDefaultValue("42");
    metadata.setFieldType(SupportedFieldType.BOOLEAN);
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
        mapFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getName();
    verify(property).getOriginalValue();
    verify(property, atLeast(1)).setIsDirty(Mockito.<Boolean>any());
    verify(property).setOriginalDisplayValue("42");
    verify(property).setOriginalValue("Field Value");
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), eq("---"));
    verify(fieldManager).setFieldValue(isA(Object.class), eq("---"), isA(Object.class));
    assertEquals(MetadataProviderResponse.HANDLED_BREAK, actualPopulateValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>When {@link FieldManager} {@link FieldManager#setFieldValue(Object, String, Object)}
   *       throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_whenFieldManagerSetFieldValueThrowIllegalArgumentException()
      throws IllegalAccessException, InstantiationException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.setFieldValue(
            Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.ID);
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
            mapFieldPersistenceProvider.populateValue(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(property, atLeast(1)).getName();
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), eq("---"));
    verify(fieldManager).setFieldValue(isA(Object.class), eq("---"), isA(Object.class));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>When {@link Property} {@link Property#getOriginalValue()} return {@code 42}.
   *   <li>Then calls {@link Property#getOriginalValue()}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_whenPropertyGetOriginalValueReturn42_thenCallsGetOriginalValue()
      throws IllegalAccessException, InstantiationException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.setFieldValue(
            Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn("Field Value");
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Property property = mock(Property.class);
    when(property.getOriginalValue()).thenReturn("42");
    doNothing().when(property).setOriginalDisplayValue(Mockito.<String>any());
    doNothing().when(property).setOriginalValue(Mockito.<String>any());
    doNothing().when(property).setIsDirty(Mockito.<Boolean>any());
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.BOOLEAN);
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
        mapFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getName();
    verify(property).getOriginalValue();
    verify(property, atLeast(1)).setIsDirty(false);
    verify(property).setOriginalDisplayValue("42");
    verify(property).setOriginalValue("Field Value");
    verify(fieldManager, atLeast(1)).getFieldValue(isA(Object.class), eq("---"));
    verify(fieldManager).setFieldValue(isA(Object.class), eq("---"), isA(Object.class));
    assertEquals(MetadataProviderResponse.HANDLED_BREAK, actualPopulateValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>When {@link Property} {@link Property#setIsDirty(Boolean)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_whenPropertySetIsDirtyThrowIllegalArgumentException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Property property = mock(Property.class);
    doThrow(new IllegalArgumentException()).when(property).setIsDirty(Mockito.<Boolean>any());
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.UNKNOWN);
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
            mapFieldPersistenceProvider.populateValue(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(property, atLeast(1)).getName();
    verify(property).setIsDirty(false);
    verify(fieldManager).getFieldValue(isA(Object.class), eq("---"));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>When {@link Property} {@link Property#setOriginalValue(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_whenPropertySetOriginalValueThrowIllegalArgumentException()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    Property property = mock(Property.class);
    doThrow(new IllegalArgumentException()).when(property).setOriginalValue(Mockito.<String>any());
    when(property.getName()).thenReturn("---");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.BOOLEAN);
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
            mapFieldPersistenceProvider.populateValue(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    verify(property, atLeast(1)).getName();
    verify(property).setOriginalValue("Field Value");
    verify(fieldManager).getFieldValue(isA(Object.class), eq("---"));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with name is {@code ---} and value is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_whenPropertyWithNameIsDashDashDashAndValueIs42() {
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

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            mapFieldPersistenceProvider.populateValue(
                populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@link AdminUserAttributeImpl} (default constructor) AdminUser is {@link
   *       AdminUserImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_givenAdminUserAttributeImplAdminUserIsAdminUserImpl()
      throws IllegalAccessException, PersistenceException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getToOneTargetProperty()).thenReturn("To One Target Property");
    doNothing().when(basicFieldMetadata).setFieldType(Mockito.<SupportedFieldType>any());
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);

    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("---");
    adminUserAttributeImpl.setValue("42");

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(adminUserAttributeImpl);

    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(extractValueRequest.getDisplayVal()).thenReturn("Display Val");
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");

    Property property = mock(Property.class);
    doNothing().when(property).setDisplayValue(Mockito.<String>any());
    doNothing().when(property).setValue(Mockito.<String>any());
    when(property.getName()).thenReturn("---");

    // Act
    MetadataProviderResponse actualExtractValueResult =
        mapFieldPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getToOneTargetProperty();
    verify(basicFieldMetadata).setFieldType(SupportedFieldType.UNKNOWN);
    verify(property).getName();
    verify(property).setDisplayValue("Display Val");
    verify(property).setValue("42");
    verify(fieldManager).getFieldValue(isA(Object.class), eq("To One Target Property"));
    verify(extractValueRequest).getDisplayVal();
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest, atLeast(1)).getMetadata();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getToOneTargetProperty()}
   *       return empty string.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_givenBasicFieldMetadataGetToOneTargetPropertyReturnEmptyString()
      throws PersistenceException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getToOneTargetProperty()).thenReturn("");
    doNothing().when(basicFieldMetadata).setFieldType(Mockito.<SupportedFieldType>any());
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getSimpleDateFormatter())
        .thenThrow(new IllegalArgumentException());

    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getDataFormatProvider())
        .thenReturn(adornedTargetListPersistenceModule);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("---");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> mapFieldPersistenceProvider.extractValue(extractValueRequest, property));
    verify(basicFieldMetadata).getToOneTargetProperty();
    verify(basicFieldMetadata).setFieldType(SupportedFieldType.UNKNOWN);
    verify(property, atLeast(1)).getName();
    verify(adornedTargetListPersistenceModule).getSimpleDateFormatter();
    verify(extractValueRequest).getDataFormatProvider();
    verify(extractValueRequest).getMetadata();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
  }

  /**
   * Test {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_givenName_whenPropertyGetNameReturnName_thenReturnNotHandled()
      throws PersistenceException {
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

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    // Act
    MetadataProviderResponse actualExtractValueResult =
        mapFieldPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(property).getName();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ExtractValueRequest} {@link ExtractValueRequest#getRequestedValue()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_givenNull_whenExtractValueRequestGetRequestedValueReturnNull()
      throws PersistenceException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getRequestedValue()).thenReturn(null);

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doNothing().when(basicFieldMetadata).setFieldType(Mockito.<SupportedFieldType>any());
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("---");

    // Act
    MetadataProviderResponse actualExtractValueResult =
        mapFieldPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(basicFieldMetadata).setFieldType(SupportedFieldType.UNKNOWN);
    verify(property, atLeast(1)).getName();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_thenCallsGetFieldType() throws PersistenceException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getForeignKeyCollection()).thenReturn(true);
    when(basicFieldMetadata.getToOneTargetProperty()).thenReturn(null);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    doNothing().when(basicFieldMetadata).setFieldType(Mockito.<SupportedFieldType>any());
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.getSimpleDateFormatter())
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));

    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getDisplayVal()).thenReturn("Display Val");
    when(extractValueRequest.getDataFormatProvider())
        .thenReturn(adornedTargetListPersistenceModule);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    doNothing().when(property).setDisplayValue(Mockito.<String>any());
    doNothing().when(property).setValue(Mockito.<String>any());
    when(property.getName()).thenReturn("---");

    // Act
    MetadataProviderResponse actualExtractValueResult =
        mapFieldPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getForeignKeyCollection();
    verify(basicFieldMetadata).getToOneTargetProperty();
    verify(basicFieldMetadata).setFieldType(SupportedFieldType.UNKNOWN);
    verify(property).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(property).setDisplayValue("Display Val");
    verify(property).setValue(null);
    verify(adornedTargetListPersistenceModule).getSimpleDateFormatter();
    verify(extractValueRequest).getDataFormatProvider();
    verify(extractValueRequest).getDisplayVal();
    verify(extractValueRequest, atLeast(1)).getMetadata();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminUserAttributeImpl#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_thenCallsGetValue()
      throws IllegalAccessException, PersistenceException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getToOneTargetProperty()).thenReturn("To One Target Property");
    doNothing().when(basicFieldMetadata).setFieldType(Mockito.<SupportedFieldType>any());
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);

    AdminUserAttributeImpl adminUserAttributeImpl = mock(AdminUserAttributeImpl.class);
    when(adminUserAttributeImpl.getValue()).thenThrow(new IllegalArgumentException());

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(adminUserAttributeImpl);

    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("---");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> mapFieldPersistenceProvider.extractValue(extractValueRequest, property));
    verify(basicFieldMetadata, atLeast(1)).getToOneTargetProperty();
    verify(basicFieldMetadata).setFieldType(SupportedFieldType.UNKNOWN);
    verify(property).getName();
    verify(adminUserAttributeImpl).getValue();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("To One Target Property"));
    verify(extractValueRequest).getFieldManager();
    verify(extractValueRequest, atLeast(1)).getMetadata();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
  }

  /**
   * Test {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then calls {@link Property#setDisplayValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_thenCallsSetDisplayValue() throws PersistenceException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);

    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getDisplayVal()).thenReturn("Display Val");
    when(extractValueRequest.getDataFormatProvider())
        .thenReturn(new AdornedTargetListPersistenceModule());
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");

    Property property = mock(Property.class);
    doNothing().when(property).setDisplayValue(Mockito.<String>any());
    doNothing().when(property).setValue(Mockito.<String>any());
    when(property.getName()).thenReturn("---");

    // Act
    MetadataProviderResponse actualExtractValueResult =
        mapFieldPersistenceProvider.extractValue(extractValueRequest, property);

    // Assert
    verify(property, atLeast(1)).getName();
    verify(property).setDisplayValue("Display Val");
    verify(property).setValue("Requested Value");
    verify(extractValueRequest).getDataFormatProvider();
    verify(extractValueRequest).getDisplayVal();
    verify(extractValueRequest, atLeast(1)).getMetadata();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
    assertEquals(MetadataProviderResponse.HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>When {@link Property} {@link Property#setValue(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_whenPropertySetValueThrowIllegalArgumentException()
      throws PersistenceException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);

    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getDataFormatProvider())
        .thenReturn(new AdornedTargetListPersistenceModule());
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(extractValueRequest.getRequestedValue()).thenReturn("Requested Value");

    Property property = mock(Property.class);
    doThrow(new IllegalArgumentException()).when(property).setValue(Mockito.<String>any());
    when(property.getName()).thenReturn("---");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> mapFieldPersistenceProvider.extractValue(extractValueRequest, property));
    verify(property, atLeast(1)).getName();
    verify(property).setValue("Requested Value");
    verify(extractValueRequest).getDataFormatProvider();
    verify(extractValueRequest, atLeast(1)).getMetadata();
    verify(extractValueRequest, atLeast(1)).getRequestedValue();
  }

  /**
   * Test {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"
  })
  public void testAddSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    AddSearchMappingRequest addSearchMappingRequest =
        new AddSearchMappingRequest(
            persistencePerspective,
            requestedCto,
            "Dr Jane Doe",
            mergedProperties,
            "Property Name",
            fieldManager,
            dataFormatProvider,
            new AdornedTargetListPersistenceModule(),
            mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        mapFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"
  })
  public void testAddSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    AddSearchMappingRequest addSearchMappingRequest =
        new AddSearchMappingRequest(
            persistencePerspective,
            requestedCto,
            "Dr Jane Doe",
            mergedProperties,
            "Property Name",
            fieldManager,
            dataFormatProvider,
            new AdornedTargetListPersistenceModule(),
            mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        mapFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MapFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"
  })
  public void testAddSearchMapping_whenArrayList() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    AddSearchMappingRequest addSearchMappingRequest =
        new AddSearchMappingRequest(
            persistencePerspective,
            requestedCto,
            "Dr Jane Doe",
            mergedProperties,
            "Property Name",
            fieldManager,
            dataFormatProvider,
            new AdornedTargetListPersistenceModule(),
            mock(RestrictionFactory.class));

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        mapFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>()));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MapFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.MAP_FIELD, new MapFieldPersistenceProvider().getOrder());
  }

  /**
   * Test {@link MapFieldPersistenceProvider#canHandlePopulateNull()}.
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapFieldPersistenceProvider.canHandlePopulateNull()"})
  public void testCanHandlePopulateNull() {
    // Arrange, Act and Assert
    assertTrue(mapFieldPersistenceProvider.canHandlePopulateNull());
  }

  /**
   * Test {@link MapFieldPersistenceProvider#updateAssignableValue(PopulateValueRequest,
   * Serializable, Object, Class, boolean, ValueAssignable)}.
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#updateAssignableValue(PopulateValueRequest, Serializable, Object,
   * Class, boolean, ValueAssignable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MapFieldPersistenceProvider.updateAssignableValue(PopulateValueRequest, Serializable, Object, Class, boolean, ValueAssignable)"
  })
  public void testUpdateAssignableValue()
      throws IllegalAccessException, InstantiationException, FieldNotAvailableException {
    // Arrange
    Property property = mock(Property.class);
    doThrow(new IllegalArgumentException()).when(property).setOriginalValue(Mockito.<String>any());
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
    Class<Object> valueType = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            mapFieldPersistenceProvider.updateAssignableValue(
                populateValueRequest,
                instance,
                "Parent",
                valueType,
                true,
                new AdminUserAttributeImpl()));
    verify(property, atLeast(1)).getName();
    verify(property).setOriginalValue(null);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#establishAssignableValue(PopulateValueRequest,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@link MapFieldPersistenceProvider} (default constructor).
   *   <li>Then calls {@link PersistenceManagerImpl#add(PersistencePackage)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#establishAssignableValue(PopulateValueRequest, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValueAssignable MapFieldPersistenceProvider.establishAssignableValue(PopulateValueRequest, Object)"
  })
  public void testEstablishAssignableValue_givenMapFieldPersistenceProvider_thenCallsAdd()
      throws IllegalAccessException, ServiceException, FieldNotAvailableException {
    // Arrange
    MapFieldPersistenceProvider mapFieldPersistenceProvider = new MapFieldPersistenceProvider();

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getToOneTargetProperty()).thenReturn("");

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.add(Mockito.<PersistencePackage>any()))
        .thenReturn(new PersistenceResponse());
    persistenceManager.add(new PersistencePackage());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    Class<Object> returnType = Object.class;
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

    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    // Act
    ValueAssignable actualEstablishAssignableValueResult =
        mapFieldPersistenceProvider.establishAssignableValue(
            populateValueRequest, adminUserAttributeImpl);

    // Assert
    verify(metadata).getToOneTargetProperty();
    verify(persistenceManager).add(isA(PersistencePackage.class));
    assertSame(adminUserAttributeImpl, actualEstablishAssignableValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#establishAssignableValue(PopulateValueRequest,
   * Object)}.
   *
   * <ul>
   *   <li>Then calls {@link FieldManager#getFieldValue(Object, String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#establishAssignableValue(PopulateValueRequest, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ValueAssignable MapFieldPersistenceProvider.establishAssignableValue(PopulateValueRequest, Object)"
  })
  public void testEstablishAssignableValue_thenCallsGetFieldValue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(adminUserAttributeImpl);

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getToOneTargetProperty()).thenReturn("To One Target Property");
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
    ValueAssignable actualEstablishAssignableValueResult =
        mapFieldPersistenceProvider.establishAssignableValue(populateValueRequest, "Parent");

    // Assert
    verify(metadata, atLeast(1)).getToOneTargetProperty();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("To One Target Property"));
    assertSame(adminUserAttributeImpl, actualEstablishAssignableValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getValueType(PopulateValueRequest, Class)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getToOneTargetProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#getValueType(PopulateValueRequest,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class MapFieldPersistenceProvider.getValueType(PopulateValueRequest, Class)"})
  public void testGetValueType_thenCallsGetToOneTargetProperty() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getToOneTargetProperty()).thenReturn("");
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
    Class<Object> startingValueType = Object.class;

    // Act
    Class<?> actualValueType =
        mapFieldPersistenceProvider.getValueType(populateValueRequest, startingValueType);

    // Assert
    verify(metadata).getToOneTargetProperty();
    Class<Object> expectedValueType = Object.class;
    assertEquals(expectedValueType, actualValueType);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getValueType(PopulateValueRequest, Class)}.
   *
   * <ul>
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link MapFieldPersistenceProvider#getValueType(PopulateValueRequest,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class MapFieldPersistenceProvider.getValueType(PopulateValueRequest, Class)"})
  public void testGetValueType_thenReturnObject() {
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
    Class<Object> startingValueType = Object.class;

    // Act
    Class<?> actualValueType =
        mapFieldPersistenceProvider.getValueType(populateValueRequest, startingValueType);

    // Assert
    Class<Object> expectedValueType = Object.class;
    assertEquals(expectedValueType, actualValueType);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()}.
   *   <li>Then throw {@link IllegalAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class MapFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_givenProperty_thenThrowIllegalAccessException()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setMapFieldValueClass(null);

    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(null);
    when(populateValueRequest.getProperty()).thenReturn(new Property());
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act and Assert
    assertThrows(
        IllegalAccessException.class,
        () -> mapFieldPersistenceProvider.getStartingValueType(populateValueRequest));
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getProperty();
    verify(populateValueRequest).getReturnType();
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class MapFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_thenReturnList()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setMapFieldValueClass("java.util.List");

    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Class<?> actualStartingValueType =
        mapFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(populateValueRequest).getMetadata();
    Class<List> expectedStartingValueType = List.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class MapFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_thenReturnObject()
      throws ClassNotFoundException, IllegalAccessException {
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
    Class<?> actualStartingValueType =
        mapFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }
}
