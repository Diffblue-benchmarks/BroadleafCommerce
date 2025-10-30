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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class MediaFieldPersistenceProviderDiffblueTest {
  /**
   * Test {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"})
  public void testCanHandlePersistence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
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
        mediaFieldPersistenceProvider.canHandlePersistence(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"})
  public void testCanHandlePersistence_thenCallsGetFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

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
   * Test {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction_thenCallsGetFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MediaFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
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
        mediaFieldPersistenceProvider.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MediaFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue_thenCallsGetFieldType() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MediaFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
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
        mediaFieldPersistenceProvider.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MediaFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue_thenCallsGetFieldType() throws PersistenceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MediaFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"})
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property(String, String)} with name is {@code Json} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MediaFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"})
  public void testFilterProperties_givenArrayOfPropertyWithPropertyWithNameIsJsonAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MediaFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"})
  public void testFilterProperties_givenPropertyGetNameReturnJson() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MediaFieldPersistenceProvider.filterProperties(AddFilterPropertiesRequest, Map)"})
  public void testFilterProperties_givenPropertyGetNameReturnName_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MediaFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.MEDIA, (new MediaFieldPersistenceProvider()).getOrder());
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#updateMedia(PopulateValueRequest, Media, boolean, Media)}.
   * <ul>
   *   <li>Then throw {@link ParentEntityPersistenceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#updateMedia(PopulateValueRequest, Media, boolean, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MediaFieldPersistenceProvider.updateMedia(PopulateValueRequest, Media, boolean, Media)"})
  public void testUpdateMedia_thenThrowParentEntityPersistenceException()
      throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.checkEquality(Object, Object)"})
  public void testCheckEquality_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertFalse((new MediaFieldPersistenceProvider()).checkEquality(null, "Two"));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.checkEquality(Object, Object)"})
  public void testCheckEquality_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue((new MediaFieldPersistenceProvider()).checkEquality(null, null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   * <ul>
   *   <li>When {@code One}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.checkEquality(Object, Object)"})
  public void testCheckEquality_whenOne_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertFalse((new MediaFieldPersistenceProvider()).checkEquality("One", "Two"));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   * <ul>
   *   <li>When {@code One}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.checkEquality(Object, Object)"})
  public void testCheckEquality_whenOne_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertFalse((new MediaFieldPersistenceProvider()).checkEquality("One", null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   * <ul>
   *   <li>When {@code Two}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.checkEquality(Object, Object)"})
  public void testCheckEquality_whenTwo_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue((new MediaFieldPersistenceProvider()).checkEquality("Two", "Two"));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code Alt Text}.</li>
   *   <li>When {@link MediaImpl} (default constructor) AltText is {@code Alt Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenAltText_whenMediaImplAltTextIsAltText()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code Dr}.</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#getTitle()} return {@code Dr}.</li>
   *   <li>Then calls {@link MediaImpl#getTitle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenDr_whenMediaImplGetTitleReturnDr_thenCallsGetTitle()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link MediaImpl} (default constructor).</li>
   *   <li>Then calls {@link MediaImpl#getAltText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenEmptyString_whenMediaImpl_thenCallsGetAltText()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#getUrl()} return {@code null}.</li>
   *   <li>Then calls {@link MediaImpl#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenNull_whenMediaImplGetUrlReturnNull_thenCallsGetUrl()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code Tags}.</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#getTags()} return {@code Tags}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenTags_whenMediaImplGetTagsReturnTags()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_thenThrowUnsupportedOperationException()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>When {@link MediaDto} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_whenMediaDto_thenReturnFalse()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaDto newMedia = new MediaDto();

    // Act and Assert
    assertFalse(mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>When {@link MediaImpl} {@link MediaImpl#getUrl()} return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_whenMediaImplGetUrlReturnHttpsExampleOrgExample()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>When {@link MediaImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_whenMediaImpl_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue((new MediaFieldPersistenceProvider()).establishDirtyState(mock(MediaImpl.class), null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_whenNull_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(null, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_givenBasicFieldMetadata() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.</li>
   *   <li>Then return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_givenPropertyGetNameReturnName_thenReturnObject()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_givenPropertyWithNameAndValueIs42()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_thenReturnList() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then return {@link MediaImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_thenReturnMediaImpl() throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_thenThrowIllegalAccessException()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MediaFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_thenThrowIllegalAccessException2()
      throws ClassNotFoundException, IllegalAccessException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <ul>
   *   <li>Given {@link MediaDto} (default constructor).</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#unwrap(Class)} return {@link MediaDto} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_givenMediaDto_whenMediaImplUnwrapReturnMediaDto() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <ul>
   *   <li>Given {@link MediaImpl} {@link MediaImpl#getId()} return one.</li>
   *   <li>Then calls {@link MediaImpl#getAltText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_givenMediaImplGetIdReturnOne_thenCallsGetAltText() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#unwrap(Class)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_givenNull_whenMediaImplUnwrapReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_givenUnsupportedOperationExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <ul>
   *   <li>When {@link MediaDto} (default constructor).</li>
   *   <li>Then return {@code {"id":0,"url":"","title":"","altText":"","tags":""}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson_whenMediaDto_thenReturnId0UrlTitleAltTextTags() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();

    // Act and Assert
    assertEquals("{\"id\":0,\"url\":\"\",\"title\":\"\",\"altText\":\"\",\"tags\":\"\"}",
        mediaFieldPersistenceProvider.convertMediaToJson(new MediaDto()));
  }
}
