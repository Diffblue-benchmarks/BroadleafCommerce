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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.broadleafcommerce.openadmin.server.service.persistence.ParentEntityPersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddFilterPropertiesRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.mockito.Mockito;

public class MediaFieldPersistenceProviderDiffblueTest {
  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
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
        mediaFieldPersistenceProvider.canHandlePersistence(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandlePersistenceResult = mediaFieldPersistenceProvider.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(populateValueRequest).getMetadata();
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(mock(EntityConfiguration.class), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertFalse(mediaFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property()));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = mediaFieldPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property());

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(extractValueRequest).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
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
        mediaFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue2() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualPopulateValueResult = mediaFieldPersistenceProvider
        .populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(populateValueRequest).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
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
        mediaFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue2() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    MetadataProviderResponse actualExtractValueResult = mediaFieldPersistenceProvider.extractValue(extractValueRequest,
        new Property());

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(extractValueRequest).getMetadata();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualExtractValueResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Json", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = mediaFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = mediaFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{property});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = mediaFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, new HashMap<>());

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    verify(property).getName();
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Json");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).setProperties(Mockito.<Property[]>any());
    when(entity.getProperties()).thenReturn(new Property[]{property});
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(entity);

    HashMap<String, FieldMetadata> properties = new HashMap<>();
    properties.put("42", new AdornedTargetCollectionMetadata());

    // Act
    MetadataProviderResponse actualFilterPropertiesResult = mediaFieldPersistenceProvider
        .filterProperties(addFilterPropertiesRequest, properties);

    // Assert
    verify(entity).getProperties();
    verify(entity).setProperties(isA(Property[].class));
    verify(property, atLeast(1)).getName();
    assertEquals(MetadataProviderResponse.HANDLED, actualFilterPropertiesResult);
  }

  /**
   * Method under test: {@link MediaFieldPersistenceProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.MEDIA, (new MediaFieldPersistenceProvider()).getOrder());
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#updateMedia(PopulateValueRequest, Media, boolean, Media)}
   */
  @Test
  public void testUpdateMedia() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Media newMedia = mock(Media.class);
    when(newMedia.getAltText()).thenThrow(new ParentEntityPersistenceException("An error occurred"));

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> mediaFieldPersistenceProvider.updateMedia(populateValueRequest, newMedia, true, new MediaDto()));
    verify(newMedia).getAltText();
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  public void testCheckEquality() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MediaFieldPersistenceProvider()).checkEquality("One", "Two"));
    assertTrue((new MediaFieldPersistenceProvider()).checkEquality("Two", "Two"));
    assertFalse((new MediaFieldPersistenceProvider()).checkEquality(null, "Two"));
    assertFalse((new MediaFieldPersistenceProvider()).checkEquality("One", null));
    assertTrue((new MediaFieldPersistenceProvider()).checkEquality(null, null));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaDto newMedia = new MediaDto();

    // Act and Assert
    assertFalse(mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();

    MediaImpl newMedia = new MediaImpl();
    newMedia.setAltText("Alt Text");
    newMedia.setId(1L);
    newMedia.setTags("Tags");
    newMedia.setTitle("Dr");
    newMedia.setUrl("https://example.org/example");

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState3()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(null, new MediaDto()));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState4()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getAltText()).thenReturn("Alt Text");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState5()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getTags()).thenReturn("Tags");
    when(newMedia.getAltText()).thenReturn("");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    verify(newMedia).getTags();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState6()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getTitle()).thenReturn("Dr");
    when(newMedia.getTags()).thenReturn("");
    when(newMedia.getAltText()).thenReturn("");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    verify(newMedia).getTags();
    verify(newMedia).getTitle();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState7()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getUrl()).thenReturn("https://example.org/example");
    when(newMedia.getTitle()).thenReturn("");
    when(newMedia.getTags()).thenReturn("");
    when(newMedia.getAltText()).thenReturn("");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    verify(newMedia).getTags();
    verify(newMedia).getTitle();
    verify(newMedia).getUrl();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState8()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getUrl()).thenReturn(null);
    when(newMedia.getTitle()).thenReturn("");
    when(newMedia.getTags()).thenReturn("");
    when(newMedia.getAltText()).thenReturn("");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    verify(newMedia).getTags();
    verify(newMedia).getTitle();
    verify(newMedia).getUrl();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState9()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MediaFieldPersistenceProvider()).establishDirtyState(mock(MediaImpl.class), null));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState10()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getAltText()).thenReturn("");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaImpl());

    // Assert
    verify(newMedia).getAltText();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState11()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getAltText()).thenReturn("");
    Media media = mock(Media.class);
    when(media.getAltText()).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mediaFieldPersistenceProvider.establishDirtyState(newMedia, media));
    verify(media).getAltText();
    verify(newMedia).getAltText();
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    Class<?> actualStartingValueType = mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(populateValueRequest).getProperty();
    verify(populateValueRequest).getReturnType();
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
    assertSame(forNameResult, actualStartingValueType);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType2() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(null);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act and Assert
    assertThrows(IllegalAccessException.class,
        () -> mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest));
    verify(populateValueRequest, atLeast(1)).getProperty();
    verify(populateValueRequest).getReturnType();
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType3() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(new BasicFieldMetadata());
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getProperty()).thenReturn(new Property("---", "42"));

    // Act
    Class<?> actualStartingValueType = mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest);

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
   * {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType4() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getMapFieldValueClass()).thenReturn("java.util.List");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);
    when(populateValueRequest.getProperty()).thenReturn(new Property("---", "42"));

    // Act
    Class<?> actualStartingValueType = mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(basicFieldMetadata).getMapFieldValueClass();
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getProperty();
    Class<List> expectedStartingValueType = List.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType5() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act
    Class<?> actualStartingValueType = mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest);

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
   * {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType6() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(null);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act and Assert
    assertThrows(IllegalAccessException.class,
        () -> mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest));
    verify(property, atLeast(1)).getName();
    verify(populateValueRequest, atLeast(1)).getProperty();
    verify(populateValueRequest).getReturnType();
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  public void testGetStartingValueType7() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Class<Media> forNameResult = Media.class;
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(forNameResult);
    when(populateValueRequest.getProperty()).thenReturn(property);

    // Act
    Class<?> actualStartingValueType = mediaFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(property).getName();
    verify(populateValueRequest).getProperty();
    verify(populateValueRequest).getReturnType();
    Class<MediaImpl> expectedStartingValueType = MediaImpl.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();

    // Act and Assert
    assertEquals("{\"id\":0,\"url\":\"\",\"title\":\"\",\"altText\":\"\",\"tags\":\"\"}",
        mediaFieldPersistenceProvider.convertMediaToJson(new MediaDto()));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();

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
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(new MediaDto());
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

    // Act
    String actualConvertMediaToJsonResult = mediaFieldPersistenceProvider.convertMediaToJson(media);

    // Assert
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
    assertEquals("{\"id\":0,\"url\":\"\",\"title\":\"\",\"altText\":\"\",\"tags\":\"\"}",
        actualConvertMediaToJsonResult);
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenThrow(new UnsupportedOperationException("foo"));
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
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
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl mediaImpl = mock(MediaImpl.class);
    when(mediaImpl.getId()).thenReturn(1L);
    when(mediaImpl.getAltText()).thenReturn("Alt Text");
    when(mediaImpl.getTags()).thenReturn("Tags");
    when(mediaImpl.getTitle()).thenReturn("Dr");
    when(mediaImpl.getUrl()).thenReturn("https://example.org/example");
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(mediaImpl);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);
    when(media.getId()).thenReturn(1L);
    when(media.getAltText()).thenReturn("Alt Text");
    when(media.getTags()).thenReturn("Tags");
    when(media.getTitle()).thenReturn("Dr");
    when(media.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(mediaImpl).getAltText();
    verify(mediaImpl).getId();
    verify(mediaImpl).getTags();
    verify(mediaImpl).getTitle();
    verify(mediaImpl).getUrl();
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl mediaImpl = mock(MediaImpl.class);
    when(mediaImpl.getId()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(mediaImpl);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);
    when(media.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(mediaImpl).getId();
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl mediaImpl = mock(MediaImpl.class);
    when(mediaImpl.getId()).thenThrow(new ParentEntityPersistenceException(""));
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(mediaImpl);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);
    when(media.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(mediaImpl).getId();
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Method under test:
   * {@link MediaFieldPersistenceProvider#updateMediaFields(Media, Media)}
   */
  @Test
  public void testUpdateMediaFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl oldMedia = mock(MediaImpl.class);
    doNothing().when(oldMedia).setAltText(Mockito.<String>any());
    doNothing().when(oldMedia).setTags(Mockito.<String>any());
    doNothing().when(oldMedia).setTitle(Mockito.<String>any());
    doNothing().when(oldMedia).setUrl(Mockito.<String>any());

    // Act
    mediaFieldPersistenceProvider.updateMediaFields(oldMedia, new MediaDto());

    // Assert
    verify(oldMedia).setAltText(eq(""));
    verify(oldMedia).setTags(eq(""));
    verify(oldMedia).setTitle(eq(""));
    verify(oldMedia).setUrl(eq(""));
  }
}
