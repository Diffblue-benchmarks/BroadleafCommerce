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
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.media.domain.MediaImpl;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
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
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.MediaFieldPersistenceProviderExtensionHandler;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.MediaFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddFilterPropertiesRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.broadleafcommerce.openadmin.web.service.MediaBuilderService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MediaFieldPersistenceProviderDiffblueTest {
  @Mock
  private MediaBuilderService mediaBuilderService;

  @InjectMocks
  private MediaFieldPersistenceProvider mediaFieldPersistenceProvider;

  @Mock
  private MediaFieldPersistenceProviderExtensionManager mediaFieldPersistenceProviderExtensionManager;

  @Mock
  private SandBoxHelper sandBoxHelper;

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
    // Arrange
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
    // Arrange
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
    // Arrange
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
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.MEDIA, mediaFieldPersistenceProvider.getOrder());
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
    // Arrange, Act and Assert
    assertFalse(mediaFieldPersistenceProvider.checkEquality(null, "Two"));
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
    // Arrange, Act and Assert
    assertTrue(mediaFieldPersistenceProvider.checkEquality(null, null));
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
    // Arrange, Act and Assert
    assertFalse(mediaFieldPersistenceProvider.checkEquality("One", "Two"));
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
    // Arrange, Act and Assert
    assertFalse(mediaFieldPersistenceProvider.checkEquality("One", null));
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
    // Arrange, Act and Assert
    assertTrue(mediaFieldPersistenceProvider.checkEquality("Two", "Two"));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaFieldPersistenceProviderExtensionHandler mediaFieldPersistenceProviderExtensionHandler = mock(
        MediaFieldPersistenceProviderExtensionHandler.class);
    when(mediaFieldPersistenceProviderExtensionHandler.checkDirtyState(Mockito.<Media>any(), Mockito.<Media>any(),
        Mockito.<ExtensionResultHolder<Boolean>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(mediaFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(mediaFieldPersistenceProviderExtensionHandler);
    MediaDto newMedia = new MediaDto();

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(mediaFieldPersistenceProviderExtensionManager).getProxy();
    verify(mediaFieldPersistenceProviderExtensionHandler).checkDirtyState(isA(Media.class), isA(Media.class),
        isA(ExtensionResultHolder.class));
    assertFalse(actualEstablishDirtyStateResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaFieldPersistenceProviderExtensionHandler mediaFieldPersistenceProviderExtensionHandler = mock(
        MediaFieldPersistenceProviderExtensionHandler.class);
    when(mediaFieldPersistenceProviderExtensionHandler.checkDirtyState(Mockito.<Media>any(), Mockito.<Media>any(),
        Mockito.<ExtensionResultHolder<Boolean>>any())).thenThrow(new UnsupportedOperationException("foo"));
    when(mediaFieldPersistenceProviderExtensionManager.getProxy())
        .thenReturn(mediaFieldPersistenceProviderExtensionHandler);
    MediaDto newMedia = new MediaDto();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
    verify(mediaFieldPersistenceProviderExtensionManager).getProxy();
    verify(mediaFieldPersistenceProviderExtensionHandler).checkDirtyState(isA(Media.class), isA(Media.class),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code Alt Text}.</li>
   *   <li>When {@link Media} {@link Media#getAltText()} return {@code Alt Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenAltText_whenMediaGetAltTextReturnAltText()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    Media newMedia = mock(Media.class);
    when(newMedia.getAltText()).thenReturn("Alt Text");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code Dr}.</li>
   *   <li>When {@link Media} {@link Media#getTitle()} return {@code Dr}.</li>
   *   <li>Then calls {@link Media#getTitle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenDr_whenMediaGetTitleReturnDr_thenCallsGetTitle()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    Media newMedia = mock(Media.class);
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
   *   <li>Then calls {@link Media#getAltText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenEmptyString_whenMediaImpl_thenCallsGetAltText()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    Media newMedia = mock(Media.class);
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
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then calls {@link Media#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenHttpsExampleOrgExample_thenCallsGetUrl()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    Media newMedia = mock(Media.class);
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
   *   <li>Given {@link MediaBuilderService}.</li>
   *   <li>When {@link MediaImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenMediaBuilderService_whenMediaImpl_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaImpl newMedia = new MediaImpl();

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@link MediaBuilderService}.</li>
   *   <li>When {@link Media}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenMediaBuilderService_whenMedia_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(mock(Media.class), null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@link MediaBuilderService}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenMediaBuilderService_whenNull_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(null, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@link MediaFieldPersistenceProvider} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenMediaFieldPersistenceProvider_thenReturnFalse()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaDto newMedia = new MediaDto();

    // Act and Assert
    assertFalse(mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code Tags}.</li>
   *   <li>When {@link Media} {@link Media#getTags()} return {@code Tags}.</li>
   *   <li>Then calls {@link Media#getTags()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenTags_whenMediaGetTagsReturnTags_thenCallsGetTags()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    Media newMedia = mock(Media.class);
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
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MediaFieldPersistenceProvider.establishDirtyState(Media, Media)"})
  public void testEstablishDirtyState_givenUnsupportedOperationExceptionWithFoo()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    Media newMedia = mock(Media.class);
    when(newMedia.getAltText()).thenReturn("");
    Media media = mock(Media.class);
    when(media.getAltText()).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mediaFieldPersistenceProvider.establishDirtyState(newMedia, media));
    verify(newMedia).getAltText();
    verify(media).getAltText();
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
   * <p>
   * Method under test: {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MediaFieldPersistenceProvider.convertMediaToJson(Media)"})
  public void testConvertMediaToJson2() {
    // Arrange
    MediaImpl mediaImpl = mock(MediaImpl.class);
    when(mediaImpl.getId()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(mediaImpl);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

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
    // Arrange
    MediaImpl mediaImpl = mock(MediaImpl.class);
    when(mediaImpl.getId()).thenThrow(new ParentEntityPersistenceException(""));
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(mediaImpl);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

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
    // Arrange
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
    // Arrange
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
    // Arrange, Act and Assert
    assertEquals("{\"id\":0,\"url\":\"\",\"title\":\"\",\"altText\":\"\",\"tags\":\"\"}",
        mediaFieldPersistenceProvider.convertMediaToJson(new MediaDto()));
  }
}
