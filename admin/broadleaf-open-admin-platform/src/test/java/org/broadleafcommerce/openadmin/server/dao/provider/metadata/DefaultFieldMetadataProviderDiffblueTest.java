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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromFieldTypeRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromMappingDataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.Type;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFieldMetadataProviderDiffblueTest {
  @Mock
  private BroadleafEnumerationUtility broadleafEnumerationUtility;

  @InjectMocks
  private DefaultFieldMetadataProvider defaultFieldMetadataProvider;

  @Mock
  private Map map;

  /**
   * Test {@link DefaultFieldMetadataProvider#overrideExclusionsFromXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link Map#containsKey(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#overrideExclusionsFromXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultFieldMetadataProvider.overrideExclusionsFromXml(OverrideViaXmlRequest, Map)"})
  public void testOverrideExclusionsFromXml_givenMapGetReturnHashMap_thenCallsContainsKey() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(new HashMap<>());
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    defaultFieldMetadataProvider.overrideExclusionsFromXml(overrideViaXmlRequest, new HashMap<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#overrideExclusionsFromXml(OverrideViaXmlRequest, Map)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#get(Object)} return {@code null}.</li>
   *   <li>Then calls {@link Map#containsKey(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#overrideExclusionsFromXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultFieldMetadataProvider.overrideExclusionsFromXml(OverrideViaXmlRequest, Map)"})
  public void testOverrideExclusionsFromXml_givenMapGetReturnNull_thenCallsContainsKey() {
    // Arrange
    when(map.get(Mockito.<Object>any())).thenReturn(null);
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act
    defaultFieldMetadataProvider.overrideExclusionsFromXml(overrideViaXmlRequest, new HashMap<>());

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}.
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)"})
  public void testAddMetadataFromMappingData() {
    // Arrange
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType requestedEntityType = new BigDecimalType();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    doNothing().when(metadata).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(metadata).setForeignKeyCollection(Mockito.<Boolean>any());
    doNothing().when(metadata).setMergedPropertyType(Mockito.<MergedPropertyType>any());
    doNothing().when(metadata).setMutable(Mockito.<Boolean>any());
    doNothing().when(metadata).setSecondaryType(Mockito.<SupportedFieldType>any());

    // Act
    MetadataProviderResponse actualAddMetadataFromMappingDataResult = defaultFieldMetadataProvider
        .addMetadataFromMappingData(addMetadataFromMappingDataRequest, metadata);

    // Assert
    verify(metadata).setFieldType(eq(SupportedFieldType.UNKNOWN));
    verify(metadata).setForeignKeyCollection(eq(false));
    verify(metadata).setMergedPropertyType(eq(MergedPropertyType.PRIMARY));
    verify(metadata).setMutable(eq(true));
    verify(metadata).setSecondaryType(eq(SupportedFieldType.UNKNOWN));
    assertEquals(MetadataProviderResponse.HANDLED, actualAddMetadataFromMappingDataResult);
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}.
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)"})
  public void testAddMetadataFromMappingData2() {
    // Arrange
    ArrayList<Property> componentProperties = new ArrayList<>();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, null, "Property Name",
        MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    doNothing().when(metadata).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(metadata).setForeignKeyCollection(Mockito.<Boolean>any());
    doNothing().when(metadata).setMergedPropertyType(Mockito.<MergedPropertyType>any());
    doNothing().when(metadata).setMutable(Mockito.<Boolean>any());
    doNothing().when(metadata).setSecondaryType(Mockito.<SupportedFieldType>any());

    // Act
    MetadataProviderResponse actualAddMetadataFromMappingDataResult = defaultFieldMetadataProvider
        .addMetadataFromMappingData(addMetadataFromMappingDataRequest, metadata);

    // Assert
    verify(metadata).setFieldType(eq(SupportedFieldType.UNKNOWN));
    verify(metadata).setForeignKeyCollection(eq(true));
    verify(metadata).setMergedPropertyType(eq(MergedPropertyType.PRIMARY));
    verify(metadata).setMutable(eq(true));
    verify(metadata).setSecondaryType(eq(SupportedFieldType.UNKNOWN));
    assertEquals(MetadataProviderResponse.HANDLED, actualAddMetadataFromMappingDataResult);
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}.
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)"})
  public void testAddMetadataFromMappingData3() {
    // Arrange
    Type requestedEntityType = mock(Type.class);
    when(requestedEntityType.isCollectionType()).thenReturn(true);
    ArrayList<Property> componentProperties = new ArrayList<>();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    doNothing().when(metadata).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(metadata).setForeignKeyCollection(Mockito.<Boolean>any());
    doNothing().when(metadata).setMergedPropertyType(Mockito.<MergedPropertyType>any());
    doNothing().when(metadata).setMutable(Mockito.<Boolean>any());
    doNothing().when(metadata).setSecondaryType(Mockito.<SupportedFieldType>any());

    // Act
    MetadataProviderResponse actualAddMetadataFromMappingDataResult = defaultFieldMetadataProvider
        .addMetadataFromMappingData(addMetadataFromMappingDataRequest, metadata);

    // Assert
    verify(metadata).setFieldType(eq(SupportedFieldType.UNKNOWN));
    verify(metadata).setForeignKeyCollection(eq(true));
    verify(metadata).setMergedPropertyType(eq(MergedPropertyType.PRIMARY));
    verify(metadata).setMutable(eq(true));
    verify(metadata).setSecondaryType(eq(SupportedFieldType.UNKNOWN));
    verify(requestedEntityType).isCollectionType();
    assertEquals(MetadataProviderResponse.HANDLED, actualAddMetadataFromMappingDataResult);
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}.
   * <ul>
   *   <li>Then {@link BasicFieldMetadata} (default constructor) FieldType is {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)"})
  public void testAddMetadataFromMappingData_thenBasicFieldMetadataFieldTypeIsUnknown() {
    // Arrange
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType requestedEntityType = new BigDecimalType();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    BasicFieldMetadata metadata = new BasicFieldMetadata();

    // Act
    defaultFieldMetadataProvider.addMetadataFromMappingData(addMetadataFromMappingDataRequest, metadata);

    // Assert
    assertEquals(SupportedFieldType.UNKNOWN, metadata.getFieldType());
    assertEquals(SupportedFieldType.UNKNOWN, metadata.getSecondaryType());
    assertEquals(MergedPropertyType.PRIMARY, metadata.getMergedPropertyType());
    assertTrue(metadata.getMutable());
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#setEnumerationClass(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)"})
  public void testAddMetadataFromMappingData_thenCallsSetEnumerationClass() {
    // Arrange
    when(broadleafEnumerationUtility.getEnumerationValues(Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new ArrayList<>());
    Type requestedEntityType = mock(Type.class);
    when(requestedEntityType.isCollectionType()).thenReturn(true);
    ArrayList<Property> componentProperties = new ArrayList<>();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.BROADLEAF_ENUMERATION, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getBroadleafEnumeration()).thenReturn("Broadleaf Enumeration");
    doNothing().when(metadata).setEnumerationClass(Mockito.<String>any());
    doNothing().when(metadata).setEnumerationValues(Mockito.<String[][]>any());
    doNothing().when(metadata).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(metadata).setForeignKeyCollection(Mockito.<Boolean>any());
    doNothing().when(metadata).setMergedPropertyType(Mockito.<MergedPropertyType>any());
    doNothing().when(metadata).setMutable(Mockito.<Boolean>any());
    doNothing().when(metadata).setSecondaryType(Mockito.<SupportedFieldType>any());

    // Act
    MetadataProviderResponse actualAddMetadataFromMappingDataResult = defaultFieldMetadataProvider
        .addMetadataFromMappingData(addMetadataFromMappingDataRequest, metadata);

    // Assert
    verify(metadata).getBroadleafEnumeration();
    verify(metadata).setEnumerationClass(eq("Broadleaf Enumeration"));
    verify(metadata).setEnumerationValues(isA(String[][].class));
    verify(metadata).setFieldType(eq(SupportedFieldType.BROADLEAF_ENUMERATION));
    verify(metadata).setForeignKeyCollection(eq(true));
    verify(metadata).setMergedPropertyType(eq(MergedPropertyType.PRIMARY));
    verify(metadata).setMutable(eq(true));
    verify(metadata).setSecondaryType(eq(SupportedFieldType.UNKNOWN));
    verify(broadleafEnumerationUtility).getEnumerationValues(eq("Broadleaf Enumeration"), isA(DynamicEntityDao.class));
    verify(requestedEntityType).isCollectionType();
    assertEquals(MetadataProviderResponse.HANDLED, actualAddMetadataFromMappingDataResult);
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)"})
  public void testAddMetadataFromMappingData_thenThrowRuntimeException() {
    // Arrange
    Type requestedEntityType = mock(Type.class);
    when(requestedEntityType.isCollectionType()).thenReturn(true);
    ArrayList<Property> componentProperties = new ArrayList<>();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.BROADLEAF_ENUMERATION, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getBroadleafEnumeration()).thenThrow(new IllegalArgumentException("foo"));
    doNothing().when(metadata).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(metadata).setForeignKeyCollection(Mockito.<Boolean>any());
    doNothing().when(metadata).setMergedPropertyType(Mockito.<MergedPropertyType>any());
    doNothing().when(metadata).setMutable(Mockito.<Boolean>any());
    doNothing().when(metadata).setSecondaryType(Mockito.<SupportedFieldType>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultFieldMetadataProvider.addMetadataFromMappingData(addMetadataFromMappingDataRequest, metadata));
    verify(metadata).getBroadleafEnumeration();
    verify(metadata).setFieldType(eq(SupportedFieldType.BROADLEAF_ENUMERATION));
    verify(metadata).setForeignKeyCollection(eq(true));
    verify(metadata).setMergedPropertyType(eq(MergedPropertyType.PRIMARY));
    verify(metadata).setMutable(eq(true));
    verify(metadata).setSecondaryType(eq(SupportedFieldType.UNKNOWN));
    verify(requestedEntityType).isCollectionType();
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)"})
  public void testAddMetadataFromFieldType() {
    // Arrange
    Class<Object> targetClass = Object.class;
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, null, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes,
        presentationAttribute, SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)"})
  public void testAddMetadataFromFieldType2() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getDisplayValueProperty()).thenThrow(new RuntimeException("foo"));
    when(foreignField.getForeignKeyClass()).thenReturn("Foreign Key Class");
    Class<Object> targetClass = Object.class;
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes,
        presentationAttribute, SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
    verify(foreignField).getDisplayValueProperty();
    verify(foreignField, atLeast(1)).getForeignKeyClass();
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)"})
  public void testAddMetadataFromFieldType3() {
    // Arrange
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = mock(ForeignKey.class);
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, false, 1, presentationAttributes,
        presentationAttribute, SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)"})
  public void testAddMetadataFromFieldType4() {
    // Arrange
    ForeignKey foreignField = mock(ForeignKey.class);
    when(foreignField.getDisplayValueProperty()).thenThrow(new RuntimeException("foo"));
    when(foreignField.getForeignKeyClass()).thenReturn("Foreign Key Class");
    Class<Object> targetClass = Object.class;
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes,
        presentationAttribute, null, returnedClass, new DynamicEntityDaoImpl());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
    verify(foreignField).getDisplayValueProperty();
    verify(foreignField, atLeast(1)).getForeignKeyClass();
  }

  /**
   * Test {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse DefaultFieldMetadataProvider.addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)"})
  public void testAddMetadataFromFieldType_thenReturnNotHandled() {
    // Arrange
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = mock(ForeignKey.class);
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes, null,
        SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        defaultFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
  }
}
