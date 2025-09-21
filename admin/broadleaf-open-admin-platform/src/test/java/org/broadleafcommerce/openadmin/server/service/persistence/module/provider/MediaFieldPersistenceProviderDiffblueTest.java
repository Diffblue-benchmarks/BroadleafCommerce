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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.media.domain.MediaImpl;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.MediaFieldPersistenceProviderExtensionHandler;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.MediaFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddFilterPropertiesRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MediaFieldPersistenceProviderDiffblueTest {
  @InjectMocks private MediaFieldPersistenceProvider mediaFieldPersistenceProvider;

  @Mock
  private MediaFieldPersistenceProviderExtensionManager
      mediaFieldPersistenceProviderExtensionManager;

  /**
   * Test {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MediaFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();
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

    // Act and Assert
    assertFalse(
        mediaFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest,
   * Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MediaFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"
  })
  public void testCanHandlePersistence_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.MEDIA);
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
        mediaFieldPersistenceProvider.canHandlePersistence(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata).getFieldType();
    assertTrue(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MediaFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();
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
        mediaFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MediaFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"
  })
  public void testCanHandleExtraction_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.MEDIA);
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
        mediaFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property());

    // Assert
    verify(metadata).getFieldType();
    assertTrue(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN}.
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MediaFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_givenUnknown_thenCallsGetFieldType() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();

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
        mediaFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(metadata).getFieldType();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#populateValue(PopulateValueRequest,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MediaFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_thenReturnNotHandled() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();
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

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        mediaFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN}.
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MediaFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_givenUnknown_thenCallsGetFieldType() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();

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
        mediaFieldPersistenceProvider.extractValue(extractValueRequest, new Property());

    // Assert
    verify(metadata).getFieldType();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MediaFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_thenReturnNotHandled() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();
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
        mediaFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property(String, String)} with
   *       {@code Name} and value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MediaFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"
  })
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameAndValueIs42() {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[] {new Property("Name", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult =
        mediaFieldPersistenceProvider.filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property(String, String)} with name
   *       is {@code Json} and value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MediaFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"
  })
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameIsJsonAndValueIs42() {
    // Arrange
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[] {new Property("Json", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult =
        mediaFieldPersistenceProvider.filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MediaFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"
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
        mediaFieldPersistenceProvider.filterProperties(addFilterPropertiesRequest, properties);

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    verify(property, atLeast(1)).getName();
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MediaFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"
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
        mediaFieldPersistenceProvider.filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    verify(property).getName();
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse MediaFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"
  })
  public void testFilterProperties_thenThrowUnsupportedOperationException() {
    // Arrange
    Entity entity = mock(Entity.class);
    doThrow(new UnsupportedOperationException())
        .when(entity)
        .setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[] {new Property("Json", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            mediaFieldPersistenceProvider.filterProperties(
                addFilterPropertiesRequest, new HashMap<>()));
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MediaFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.MEDIA, mediaFieldPersistenceProvider.getOrder());
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.checkEquality(Object, Object)"})
  public void testCheckEquality_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(mediaFieldPersistenceProvider.checkEquality(null, "Two"));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.checkEquality(Object, Object)"})
  public void testCheckEquality_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(mediaFieldPersistenceProvider.checkEquality(null, null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code One}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.checkEquality(Object, Object)"})
  public void testCheckEquality_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(mediaFieldPersistenceProvider.checkEquality("One", "Two"));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code One}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.checkEquality(Object, Object)"})
  public void testCheckEquality_whenOne_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(mediaFieldPersistenceProvider.checkEquality("One", null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code Two}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.checkEquality(Object, Object)"})
  public void testCheckEquality_whenTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(mediaFieldPersistenceProvider.checkEquality("Two", "Two"));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(mediaFieldPersistenceProviderExtensionManager.getProxy())
        .thenThrow(new UnsupportedOperationException());
    MediaDto newMedia = new MediaDto();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
    verify(mediaFieldPersistenceProviderExtensionManager).getProxy();
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaFieldPersistenceProviderExtensionHandler mediaFieldPersistenceProviderExtensionHandler =
        mock(MediaFieldPersistenceProviderExtensionHandler.class);
    when(mediaFieldPersistenceProviderExtensionHandler.checkDirtyState(
            Mockito.<Media>any(),
            Mockito.<Media>any(),
            Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(mediaFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(mediaFieldPersistenceProviderExtensionHandler);
    MediaDto newMedia = new MediaDto();

    // Act
    boolean actualEstablishDirtyStateResult =
        mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto());

    // Assert
    verify(mediaFieldPersistenceProviderExtensionManager).getProxy();
    verify(mediaFieldPersistenceProviderExtensionHandler)
        .checkDirtyState(isA(Media.class), isA(Media.class), isA(ExtensionResultHolder.class));
    assertFalse(actualEstablishDirtyStateResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState3()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaFieldPersistenceProviderExtensionHandler mediaFieldPersistenceProviderExtensionHandler =
        mock(MediaFieldPersistenceProviderExtensionHandler.class);
    when(mediaFieldPersistenceProviderExtensionHandler.checkDirtyState(
            Mockito.<Media>any(),
            Mockito.<Media>any(),
            Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenThrow(new UnsupportedOperationException());
    when(mediaFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(mediaFieldPersistenceProviderExtensionHandler);
    MediaDto newMedia = new MediaDto();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
    verify(mediaFieldPersistenceProviderExtensionManager).getProxy();
    verify(mediaFieldPersistenceProviderExtensionHandler)
        .checkDirtyState(isA(Media.class), isA(Media.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>Given {@link MediaFieldPersistenceProvider} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenMediaFieldPersistenceProvider_thenReturnFalse()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();
    MediaDto newMedia = new MediaDto();

    // Act and Assert
    assertFalse(mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>Given {@code Media}.
   *   <li>When {@link MediaDto} (default constructor) AltText is {@code Media}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenMedia_whenMediaDtoAltTextIsMedia_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaDto newMedia = new MediaDto();

    MediaDto media = new MediaDto();
    media.setAltText("Media");
    media.setTags(null);
    media.setTitle(null);
    media.setUrl(null);

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(newMedia, media));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>Given {@code Media}.
   *   <li>When {@link MediaDto} (default constructor) Tags is {@code Media}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenMedia_whenMediaDtoTagsIsMedia_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaDto newMedia = new MediaDto();
    newMedia.setAltText(null);
    newMedia.setTags(null);
    newMedia.setTitle(null);
    newMedia.setUrl(null);

    MediaDto media = new MediaDto();
    media.setAltText(null);
    media.setTags("Media");
    media.setTitle(null);
    media.setUrl(null);

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(newMedia, media));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>Given {@code Media}.
   *   <li>When {@link MediaDto} (default constructor) Title is {@code Media}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenMedia_whenMediaDtoTitleIsMedia_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaDto newMedia = new MediaDto();
    newMedia.setAltText(null);
    newMedia.setTags(null);
    newMedia.setTitle(null);
    newMedia.setUrl(null);

    MediaDto media = new MediaDto();
    media.setAltText(null);
    media.setTags(null);
    media.setTitle("Media");
    media.setUrl(null);

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(newMedia, media));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>Given {@code Media}.
   *   <li>When {@link MediaDto} (default constructor) Url is {@code Media}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenMedia_whenMediaDtoUrlIsMedia_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaDto newMedia = new MediaDto();
    newMedia.setAltText(null);
    newMedia.setTags(null);
    newMedia.setTitle(null);
    newMedia.setUrl(null);

    MediaDto media = new MediaDto();
    media.setAltText(null);
    media.setTags(null);
    media.setTitle(null);
    media.setUrl("Media");

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(newMedia, media));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MediaDto} (default constructor) AltText is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenNull_whenMediaDtoAltTextIsNull_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaDto newMedia = new MediaDto();

    MediaDto media = new MediaDto();
    media.setAltText(null);
    media.setTags(null);
    media.setTitle(null);
    media.setUrl(null);

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(newMedia, media));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MediaDto} (default constructor) AltText is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenNull_whenMediaDtoAltTextIsNull_thenReturnTrue2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaDto newMedia = new MediaDto();
    newMedia.setAltText(null);
    newMedia.setTags(null);
    newMedia.setTitle(null);
    newMedia.setUrl(null);

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>Then calls {@link Media#getAltText()}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_thenCallsGetAltText()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    Media newMedia = mock(Media.class);
    when(newMedia.getAltText()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
    verify(newMedia).getAltText();
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_whenNull_thenReturnFalse()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertFalse(mediaFieldPersistenceProvider.establishDirtyState(null, null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_whenNull_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(null, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_whenNull_thenReturnTrue2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(new MediaDto(), null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();
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
        mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType2() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();

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
        mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(property).getName();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Given {@code List}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_givenJavaUtilList_thenReturnList()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();

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
        mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(metadata).getMapFieldValueClass();
    verify(property).getName();
    Class<List> expectedStartingValueType = List.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_givenName_whenPropertyGetNameReturnName()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();

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
        mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(property).getName();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_thenThrowIllegalAccessException()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();

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
        () -> mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest));
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getMapFieldValueClass()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"
  })
  public void testGetStartingValueType_whenBasicFieldMetadataGetMapFieldValueClassReturnNull()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider =
        new MediaFieldPersistenceProvider();

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
        mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(metadata).getMapFieldValueClass();
    verify(property).getName();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson() {
    // Arrange
    MediaImpl media = new MediaImpl();
    media.setAltText("Alt Text");
    media.setId(1L);
    media.setTags("Tags");
    media.setTitle("Dr");
    media.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(
        "{\"id\":1,\"url\":\"https://example.org/example\",\"title\":\"Dr\",\"altText\":\"Alt Text\",\"tags\":\"Tags\"}",
        mediaFieldPersistenceProvider.convertMediaToJson(media));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   *
   * <ul>
   *   <li>Given {@link MediaDto} (default constructor).
   *   <li>When {@link MediaImpl} {@link MediaImpl#unwrap(Class)} return {@link MediaDto} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_givenMediaDto_whenMediaImplUnwrapReturnMediaDto() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(new MediaDto());
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

    // Act
    String actualConvertMediaToJsonResult = mediaFieldPersistenceProvider.convertMediaToJson(media);

    // Assert
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
    assertEquals(
        "{\"id\":0,\"url\":\"\",\"title\":\"\",\"altText\":\"\",\"tags\":\"\"}",
        actualConvertMediaToJsonResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   *
   * <ul>
   *   <li>Given {@link MediaImpl} {@link MediaImpl#getId()} return one.
   *   <li>Then calls {@link MediaImpl#getAltText()}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_givenMediaImplGetIdReturnOne_thenCallsGetAltText() {
    // Arrange
    MediaImpl mediaImpl = mock(MediaImpl.class);
    when(mediaImpl.getId()).thenReturn(1L);
    when(mediaImpl.getAltText()).thenReturn("Alt Text");
    when(mediaImpl.getTags()).thenReturn("Tags");
    when(mediaImpl.getTitle()).thenReturn("Dr");
    when(mediaImpl.getUrl()).thenReturn("https://example.org/example");

    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(mediaImpl);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(mediaImpl).getAltText();
    verify(mediaImpl).getId();
    verify(mediaImpl).getTags();
    verify(mediaImpl).getTitle();
    verify(mediaImpl).getUrl();
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   *
   * <ul>
   *   <li>Given {@link MediaImpl} {@link MediaImpl#getId()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_givenMediaImplGetIdThrowUnsupportedOperationException() {
    // Arrange
    MediaImpl mediaImpl = mock(MediaImpl.class);
    when(mediaImpl.getId()).thenThrow(new UnsupportedOperationException());

    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(mediaImpl);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(mediaImpl).getId();
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MediaImpl} {@link MediaImpl#unwrap(Class)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_givenNull_whenMediaImplUnwrapReturnNull_thenReturnNull() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(null);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

    // Act
    String actualConvertMediaToJsonResult = mediaFieldPersistenceProvider.convertMediaToJson(media);

    // Assert
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
    assertEquals("null", actualConvertMediaToJsonResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_givenUnsupportedOperationException() {
    // Arrange
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenThrow(new UnsupportedOperationException());
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   *
   * <ul>
   *   <li>When {@link MediaDto} (default constructor).
   *   <li>Then return {@code {"id":0,"url":"","title":"","altText":"","tags":""}}.
   * </ul>
   *
   * <p>Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_whenMediaDto_thenReturnId0UrlTitleAltTextTags() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"id\":0,\"url\":\"\",\"title\":\"\",\"altText\":\"\",\"tags\":\"\"}",
        mediaFieldPersistenceProvider.convertMediaToJson(new MediaDto()));
  }
}
