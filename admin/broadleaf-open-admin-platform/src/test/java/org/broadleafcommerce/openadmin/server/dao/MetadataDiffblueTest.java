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
package org.broadleafcommerce.openadmin.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdornedTargetCollectionFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicEntityMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.BasicFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.DefaultFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.FieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddFieldMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromMappingDataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MetadataDiffblueTest {
  @Mock
  private BasicEntityMetadataProvider basicEntityMetadataProvider;

  @Mock
  private FieldMetadataProvider fieldMetadataProvider;

  @Mock
  private List<FieldMetadataProvider> list;

  @InjectMocks
  private Metadata metadata;

  /**
   * Test {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}.
   * <p>
   * Method under test: {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Metadata.getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)"})
  public void testGetFieldMetadataForTargetClass() {
    // Arrange
    when(fieldMetadataProvider.addMetadata(Mockito.<AddFieldMetadataRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    when(fieldMetadataProvider.addMetadata(Mockito.<AddFieldMetadataRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.NOT_HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviderList = new ArrayList<>();
    fieldMetadataProviderList.add(fieldMetadataProvider);
    when(list.iterator()).thenReturn(fieldMetadataProviderList.iterator());
    Class<Object> parentClass = Object.class;
    Class<Metadata> targetClass = Metadata.class;
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getAllFields(Mockito.<Class<Object>>any())).thenReturn(new Field[]{null});

    // Act
    Map<String, FieldMetadata> actualFieldMetadataForTargetClass = metadata.getFieldMetadataForTargetClass(parentClass,
        targetClass, dynamicEntityDao, "Prefix");

    // Assert
    verify(list).iterator();
    verify(dynamicEntityDao).getAllFields(isA(Class.class));
    verify(fieldMetadataProvider, atLeast(1)).addMetadata(Mockito.<AddFieldMetadataRequest>any(), isA(Map.class));
    assertTrue(actualFieldMetadataForTargetClass.isEmpty());
  }

  /**
   * Test {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}.
   * <p>
   * Method under test: {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Metadata.getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)"})
  public void testGetFieldMetadataForTargetClass2() {
    // Arrange
    when(fieldMetadataProvider.addMetadata(Mockito.<AddFieldMetadataRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    when(fieldMetadataProvider.addMetadata(Mockito.<AddFieldMetadataRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED_BREAK);

    ArrayList<FieldMetadataProvider> fieldMetadataProviderList = new ArrayList<>();
    fieldMetadataProviderList.add(fieldMetadataProvider);
    when(list.iterator()).thenReturn(fieldMetadataProviderList.iterator());
    Class<Object> parentClass = Object.class;
    Class<Metadata> targetClass = Metadata.class;
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getAllFields(Mockito.<Class<Object>>any())).thenReturn(new Field[]{null});

    // Act
    Map<String, FieldMetadata> actualFieldMetadataForTargetClass = metadata.getFieldMetadataForTargetClass(parentClass,
        targetClass, dynamicEntityDao, "Prefix");

    // Assert
    verify(list).iterator();
    verify(dynamicEntityDao).getAllFields(isA(Class.class));
    verify(fieldMetadataProvider, atLeast(1)).addMetadata(isA(AddFieldMetadataRequest.class), isA(Map.class));
    assertTrue(actualFieldMetadataForTargetClass.isEmpty());
  }

  /**
   * Test {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FieldMetadataProvider}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Metadata.getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)"})
  public void testGetFieldMetadataForTargetClass_givenArrayListAddFieldMetadataProvider() {
    // Arrange
    when(fieldMetadataProvider.addMetadata(Mockito.<AddFieldMetadataRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviderList = new ArrayList<>();
    fieldMetadataProviderList.add(fieldMetadataProvider);
    when(list.iterator()).thenReturn(fieldMetadataProviderList.iterator());
    Class<Object> parentClass = Object.class;
    Class<Metadata> targetClass = Metadata.class;

    // Act
    Map<String, FieldMetadata> actualFieldMetadataForTargetClass = metadata.getFieldMetadataForTargetClass(parentClass,
        targetClass, new DynamicEntityDaoImpl(), "Prefix");

    // Assert
    verify(list, atLeast(1)).iterator();
    verify(fieldMetadataProvider, atLeast(1)).addMetadata(Mockito.<AddFieldMetadataRequest>any(), isA(Map.class));
    assertTrue(actualFieldMetadataForTargetClass.isEmpty());
  }

  /**
   * Test {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}.
   * <ul>
   *   <li>Given {@link FieldMetadataProvider}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Metadata.getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)"})
  public void testGetFieldMetadataForTargetClass_givenFieldMetadataProvider() {
    // Arrange
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;

    // Act and Assert
    assertTrue(metadata.getFieldMetadataForTargetClass(parentClass, targetClass, new DynamicEntityDaoImpl(), "Prefix")
        .isEmpty());
  }

  /**
   * Test {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}.
   * <ul>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metadata#getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Metadata.getFieldMetadataForTargetClass(Class, Class, DynamicEntityDao, String)"})
  public void testGetFieldMetadataForTargetClass_thenCallsIterator() {
    // Arrange
    when(fieldMetadataProvider.addMetadata(Mockito.<AddFieldMetadataRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(fieldMetadataProviderList.iterator());
    Class<Object> parentClass = Object.class;
    Class<Metadata> targetClass = Metadata.class;

    // Act
    Map<String, FieldMetadata> actualFieldMetadataForTargetClass = metadata.getFieldMetadataForTargetClass(parentClass,
        targetClass, new DynamicEntityDaoImpl(), "Prefix");

    // Assert
    verify(list, atLeast(1)).iterator();
    verify(fieldMetadataProvider, atLeast(1)).addMetadata(Mockito.<AddFieldMetadataRequest>any(), isA(Map.class));
    assertTrue(actualFieldMetadataForTargetClass.isEmpty());
  }

  /**
   * Test {@link Metadata#getBaseTabAndGroupMetadata(Class[])}.
   * <p>
   * Method under test: {@link Metadata#getBaseTabAndGroupMetadata(Class[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Metadata.getBaseTabAndGroupMetadata(Class[])"})
  public void testGetBaseTabAndGroupMetadata() {
    // Arrange
    when(basicEntityMetadataProvider.addTabAndGroupMetadata(Mockito.<AddMetadataRequest>any(),
        Mockito.<Map<String, TabMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    Class<Object> forNameResult = Object.class;

    // Act
    Map<String, TabMetadata> actualBaseTabAndGroupMetadata = metadata
        .getBaseTabAndGroupMetadata(new Class[]{forNameResult});

    // Assert
    verify(basicEntityMetadataProvider).addTabAndGroupMetadata(isA(AddMetadataRequest.class), isA(Map.class));
    assertTrue(actualBaseTabAndGroupMetadata.isEmpty());
  }

  /**
   * Test {@link Metadata#applyTabAndGroupMetadataOverrides(Class[], Map)}.
   * <ul>
   *   <li>Then calls {@link BasicEntityMetadataProvider#overrideMetadataViaAnnotation(OverrideViaAnnotationRequest, Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metadata#applyTabAndGroupMetadataOverrides(Class[], Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Metadata.applyTabAndGroupMetadataOverrides(Class[], Map)"})
  public void testApplyTabAndGroupMetadataOverrides_thenCallsOverrideMetadataViaAnnotation() {
    // Arrange
    when(basicEntityMetadataProvider.overrideMetadataViaAnnotation(Mockito.<OverrideViaAnnotationRequest>any(),
        Mockito.<Map<String, TabMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    when(basicEntityMetadataProvider.overrideMetadataViaXml(Mockito.<OverrideViaXmlRequest>any(),
        Mockito.<Map<String, TabMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    Class<Object> forNameResult = Object.class;

    // Act
    metadata.applyTabAndGroupMetadataOverrides(new Class[]{forNameResult}, new HashMap<>());

    // Assert
    verify(basicEntityMetadataProvider).overrideMetadataViaAnnotation(isA(OverrideViaAnnotationRequest.class),
        isA(Map.class));
    verify(basicEntityMetadataProvider).overrideMetadataViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
  }

  /**
   * Test {@link Metadata#buildAdditionalTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <p>
   * Method under test: {@link Metadata#buildAdditionalTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Metadata.buildAdditionalTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)"})
  public void testBuildAdditionalTabAndGroupMetadataFromCmdProperties() {
    // Arrange
    when(basicEntityMetadataProvider.addTabAndGroupMetadataFromCmdProperties(Mockito.<ClassMetadata>any(),
        Mockito.<Map<String, TabMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(
        new org.broadleafcommerce.openadmin.dto.Property[]{new org.broadleafcommerce.openadmin.dto.Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    metadata.buildAdditionalTabAndGroupMetadataFromCmdProperties(cmd, new HashMap<>());

    // Assert
    verify(basicEntityMetadataProvider).addTabAndGroupMetadataFromCmdProperties(isA(ClassMetadata.class),
        isA(Map.class));
  }

  /**
   * Test {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.
   * <p>
   * Method under test: {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map Metadata.overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)"})
  public void testOverrideMetadata() {
    // Arrange
    when(fieldMetadataProvider.overrideViaAnnotation(Mockito.<OverrideViaAnnotationRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.NOT_HANDLED);
    when(fieldMetadataProvider.overrideViaXml(Mockito.<OverrideViaXmlRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(fieldMetadataProvider);
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    metadata.setDefaultFieldMetadataProvider(new DefaultFieldMetadataProvider());
    Class<Object> forNameResult = Object.class;
    PropertyBuilder propertyBuilder = mock(PropertyBuilder.class);
    when(propertyBuilder.execute(Mockito.<Boolean>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualOverrideMetadataResult = metadata.overrideMetadata(new Class[]{forNameResult},
        propertyBuilder, "Prefix", true, "Dr Jane Doe", "Configuration Key", new DynamicEntityDaoImpl());

    // Assert
    verify(propertyBuilder).execute(isNull());
    verify(fieldMetadataProvider).overrideViaAnnotation(isA(OverrideViaAnnotationRequest.class), isA(Map.class));
    verify(fieldMetadataProvider).overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(actualOverrideMetadataResult.isEmpty());
  }

  /**
   * Test {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.
   * <p>
   * Method under test: {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map Metadata.overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)"})
  public void testOverrideMetadata2() {
    // Arrange
    when(fieldMetadataProvider.overrideViaAnnotation(Mockito.<OverrideViaAnnotationRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED_BREAK);
    when(fieldMetadataProvider.overrideViaXml(Mockito.<OverrideViaXmlRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(fieldMetadataProvider);
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    metadata.setDefaultFieldMetadataProvider(new DefaultFieldMetadataProvider());
    Class<Object> forNameResult = Object.class;
    PropertyBuilder propertyBuilder = mock(PropertyBuilder.class);
    when(propertyBuilder.execute(Mockito.<Boolean>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualOverrideMetadataResult = metadata.overrideMetadata(new Class[]{forNameResult},
        propertyBuilder, "Prefix", true, "Dr Jane Doe", "Configuration Key", new DynamicEntityDaoImpl());

    // Assert
    verify(propertyBuilder).execute(isNull());
    verify(fieldMetadataProvider).overrideViaAnnotation(isA(OverrideViaAnnotationRequest.class), isA(Map.class));
    verify(fieldMetadataProvider).overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(actualOverrideMetadataResult.isEmpty());
  }

  /**
   * Test {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.
   * <ul>
   *   <li>Given {@link FieldMetadataProvider} {@link FieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)} return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map Metadata.overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)"})
  public void testOverrideMetadata_givenFieldMetadataProviderOverrideViaXmlReturnHandled() {
    // Arrange
    when(fieldMetadataProvider.overrideViaAnnotation(Mockito.<OverrideViaAnnotationRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    when(fieldMetadataProvider.overrideViaXml(Mockito.<OverrideViaXmlRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(fieldMetadataProvider);
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    metadata.setDefaultFieldMetadataProvider(new DefaultFieldMetadataProvider());
    Class<Object> forNameResult = Object.class;
    PropertyBuilder propertyBuilder = mock(PropertyBuilder.class);
    when(propertyBuilder.execute(Mockito.<Boolean>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualOverrideMetadataResult = metadata.overrideMetadata(new Class[]{forNameResult},
        propertyBuilder, "Prefix", true, "Dr Jane Doe", "Configuration Key", new DynamicEntityDaoImpl());

    // Assert
    verify(propertyBuilder).execute(isNull());
    verify(fieldMetadataProvider).overrideViaAnnotation(isA(OverrideViaAnnotationRequest.class), isA(Map.class));
    verify(fieldMetadataProvider).overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(actualOverrideMetadataResult.isEmpty());
  }

  /**
   * Test {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.
   * <ul>
   *   <li>Given {@link FieldMetadataProvider} {@link FieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)} return {@code HANDLED_BREAK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map Metadata.overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)"})
  public void testOverrideMetadata_givenFieldMetadataProviderOverrideViaXmlReturnHandledBreak() {
    // Arrange
    when(fieldMetadataProvider.overrideViaAnnotation(Mockito.<OverrideViaAnnotationRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    when(fieldMetadataProvider.overrideViaXml(Mockito.<OverrideViaXmlRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED_BREAK);

    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(fieldMetadataProvider);
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    metadata.setDefaultFieldMetadataProvider(new DefaultFieldMetadataProvider());
    Class<Object> forNameResult = Object.class;
    PropertyBuilder propertyBuilder = mock(PropertyBuilder.class);
    when(propertyBuilder.execute(Mockito.<Boolean>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualOverrideMetadataResult = metadata.overrideMetadata(new Class[]{forNameResult},
        propertyBuilder, "Prefix", true, "Dr Jane Doe", "Configuration Key", new DynamicEntityDaoImpl());

    // Assert
    verify(propertyBuilder).execute(isNull());
    verify(fieldMetadataProvider).overrideViaAnnotation(isA(OverrideViaAnnotationRequest.class), isA(Map.class));
    verify(fieldMetadataProvider).overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(actualOverrideMetadataResult.isEmpty());
  }

  /**
   * Test {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.
   * <ul>
   *   <li>Given {@link FieldMetadataProvider} {@link FieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)} return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map Metadata.overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)"})
  public void testOverrideMetadata_givenFieldMetadataProviderOverrideViaXmlReturnNotHandled() {
    // Arrange
    when(fieldMetadataProvider.overrideViaAnnotation(Mockito.<OverrideViaAnnotationRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    when(fieldMetadataProvider.overrideViaXml(Mockito.<OverrideViaXmlRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.NOT_HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    fieldMetadataProviders.add(fieldMetadataProvider);
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    metadata.setDefaultFieldMetadataProvider(new DefaultFieldMetadataProvider());
    Class<Object> forNameResult = Object.class;
    PropertyBuilder propertyBuilder = mock(PropertyBuilder.class);
    when(propertyBuilder.execute(Mockito.<Boolean>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualOverrideMetadataResult = metadata.overrideMetadata(new Class[]{forNameResult},
        propertyBuilder, "Prefix", true, "Dr Jane Doe", "Configuration Key", new DynamicEntityDaoImpl());

    // Assert
    verify(propertyBuilder).execute(isNull());
    verify(fieldMetadataProvider).overrideViaAnnotation(isA(OverrideViaAnnotationRequest.class), isA(Map.class));
    verify(fieldMetadataProvider).overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(actualOverrideMetadataResult.isEmpty());
  }

  /**
   * Test {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metadata#overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map Metadata.overrideMetadata(Class[], PropertyBuilder, String, Boolean, String, String, DynamicEntityDao)"})
  public void testOverrideMetadata_thenCallsOverrideViaAnnotation() {
    // Arrange
    DefaultFieldMetadataProvider defaultFieldMetadataProvider = mock(DefaultFieldMetadataProvider.class);
    when(defaultFieldMetadataProvider.overrideViaAnnotation(Mockito.<OverrideViaAnnotationRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    when(defaultFieldMetadataProvider.overrideViaXml(Mockito.<OverrideViaXmlRequest>any(),
        Mockito.<Map<String, FieldMetadata>>any())).thenReturn(MetadataProviderResponse.HANDLED);
    doNothing().when(defaultFieldMetadataProvider)
        .overrideExclusionsFromXml(Mockito.<OverrideViaXmlRequest>any(), Mockito.<Map<String, FieldMetadata>>any());

    Metadata metadata = new Metadata();
    metadata.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);
    Class<Object> forNameResult = Object.class;
    PropertyBuilder propertyBuilder = mock(PropertyBuilder.class);
    when(propertyBuilder.execute(Mockito.<Boolean>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, FieldMetadata> actualOverrideMetadataResult = metadata.overrideMetadata(new Class[]{forNameResult},
        propertyBuilder, "Prefix", true, "Dr Jane Doe", "Configuration Key", new DynamicEntityDaoImpl());

    // Assert
    verify(propertyBuilder).execute(isNull());
    verify(defaultFieldMetadataProvider).overrideViaAnnotation(isA(OverrideViaAnnotationRequest.class), isA(Map.class));
    verify(defaultFieldMetadataProvider).overrideViaXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    verify(defaultFieldMetadataProvider).overrideExclusionsFromXml(isA(OverrideViaXmlRequest.class), isA(Map.class));
    assertTrue(actualOverrideMetadataResult.isEmpty());
  }

  /**
   * Test {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)} with {@code prefix}, {@code propertyName}, {@code componentProperties}, {@code type}, {@code entityType}, {@code targetClass}, {@code presentationAttribute}, {@code mergedPropertyType}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadata Metadata.getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)"})
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromMappingData(Mockito.<AddMetadataFromMappingDataRequest>any(),
        Mockito.<FieldMetadata>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(fieldMetadataProviderList.iterator());
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();

    // Act
    FieldMetadata actualFieldMetadata = metadata.getFieldMetadata("Prefix", "Property Name", componentProperties,
        SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute, MergedPropertyType.PRIMARY,
        new DynamicEntityDaoImpl());

    // Assert
    verify(list).iterator();
    verify(fieldMetadataProvider).addMetadataFromMappingData(isA(AddMetadataFromMappingDataRequest.class),
        isA(FieldMetadata.class));
    assertEquals("Property Name", presentationAttribute.getFieldName());
    assertEquals("java.lang.Object", presentationAttribute.getInheritedFromType());
    assertEquals("java.lang.Object", presentationAttribute.getTargetClass());
    assertSame(presentationAttribute, actualFieldMetadata);
  }

  /**
   * Test {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)} with {@code prefix}, {@code propertyName}, {@code componentProperties}, {@code type}, {@code entityType}, {@code targetClass}, {@code presentationAttribute}, {@code mergedPropertyType}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadata Metadata.getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)"})
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao2() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromMappingData(Mockito.<AddMetadataFromMappingDataRequest>any(),
        Mockito.<FieldMetadata>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviderList = new ArrayList<>();
    fieldMetadataProviderList.add(fieldMetadataProvider);
    when(list.iterator()).thenReturn(fieldMetadataProviderList.iterator());
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();

    // Act
    FieldMetadata actualFieldMetadata = metadata.getFieldMetadata("Prefix", "Property Name", componentProperties,
        SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute, MergedPropertyType.PRIMARY,
        new DynamicEntityDaoImpl());

    // Assert
    verify(list).iterator();
    verify(fieldMetadataProvider).addMetadataFromMappingData(isA(AddMetadataFromMappingDataRequest.class),
        isA(FieldMetadata.class));
    assertEquals("Property Name", presentationAttribute.getFieldName());
    assertEquals("java.lang.Object", presentationAttribute.getInheritedFromType());
    assertEquals("java.lang.Object", presentationAttribute.getTargetClass());
    assertSame(presentationAttribute, actualFieldMetadata);
  }

  /**
   * Test {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)} with {@code prefix}, {@code propertyName}, {@code componentProperties}, {@code type}, {@code entityType}, {@code targetClass}, {@code presentationAttribute}, {@code mergedPropertyType}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadata Metadata.getFieldMetadata(String, String, List, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)"})
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao3() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromMappingData(Mockito.<AddMetadataFromMappingDataRequest>any(),
        Mockito.<FieldMetadata>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(fieldMetadataProviderList.iterator());
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;
    FieldMetadata presentationAttribute = mock(FieldMetadata.class);
    when(presentationAttribute.getTargetClass()).thenReturn("Target Class");
    doNothing().when(presentationAttribute).setAvailableToTypes(Mockito.<String[]>any());
    doNothing().when(presentationAttribute).setInheritedFromType(Mockito.<String>any());

    // Act
    FieldMetadata actualFieldMetadata = metadata.getFieldMetadata("Prefix", "Property Name", componentProperties,
        SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute, MergedPropertyType.PRIMARY,
        new DynamicEntityDaoImpl());

    // Assert
    verify(list).iterator();
    verify(presentationAttribute).getTargetClass();
    verify(presentationAttribute).setAvailableToTypes(isA(String[].class));
    verify(presentationAttribute).setInheritedFromType(eq("java.lang.Object"));
    verify(fieldMetadataProvider).addMetadataFromMappingData(isA(AddMetadataFromMappingDataRequest.class),
        isA(FieldMetadata.class));
    assertSame(presentationAttribute, actualFieldMetadata);
  }

  /**
   * Test {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)} with {@code prefix}, {@code propertyName}, {@code componentProperties}, {@code type}, {@code secondaryType}, {@code entityType}, {@code targetClass}, {@code presentationAttribute}, {@code mergedPropertyType}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadata Metadata.getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)"})
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeSecondaryTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromMappingData(Mockito.<AddMetadataFromMappingDataRequest>any(),
        Mockito.<FieldMetadata>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(fieldMetadataProviderList.iterator());
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();

    // Act
    FieldMetadata actualFieldMetadata = metadata.getFieldMetadata("Prefix", "Property Name", componentProperties,
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute,
        MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Assert
    verify(list).iterator();
    verify(fieldMetadataProvider).addMetadataFromMappingData(isA(AddMetadataFromMappingDataRequest.class),
        isA(FieldMetadata.class));
    assertEquals("Property Name", presentationAttribute.getFieldName());
    assertEquals("java.lang.Object", presentationAttribute.getInheritedFromType());
    assertEquals("java.lang.Object", presentationAttribute.getTargetClass());
    assertSame(presentationAttribute, actualFieldMetadata);
  }

  /**
   * Test {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)} with {@code prefix}, {@code propertyName}, {@code componentProperties}, {@code type}, {@code secondaryType}, {@code entityType}, {@code targetClass}, {@code presentationAttribute}, {@code mergedPropertyType}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadata Metadata.getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)"})
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeSecondaryTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao2() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromMappingData(Mockito.<AddMetadataFromMappingDataRequest>any(),
        Mockito.<FieldMetadata>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviderList = new ArrayList<>();
    fieldMetadataProviderList.add(fieldMetadataProvider);
    when(list.iterator()).thenReturn(fieldMetadataProviderList.iterator());
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();

    // Act
    FieldMetadata actualFieldMetadata = metadata.getFieldMetadata("Prefix", "Property Name", componentProperties,
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute,
        MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Assert
    verify(list).iterator();
    verify(fieldMetadataProvider).addMetadataFromMappingData(isA(AddMetadataFromMappingDataRequest.class),
        isA(FieldMetadata.class));
    assertEquals("Property Name", presentationAttribute.getFieldName());
    assertEquals("java.lang.Object", presentationAttribute.getInheritedFromType());
    assertEquals("java.lang.Object", presentationAttribute.getTargetClass());
    assertSame(presentationAttribute, actualFieldMetadata);
  }

  /**
   * Test {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)} with {@code prefix}, {@code propertyName}, {@code componentProperties}, {@code type}, {@code secondaryType}, {@code entityType}, {@code targetClass}, {@code presentationAttribute}, {@code mergedPropertyType}, {@code dynamicEntityDao}.
   * <p>
   * Method under test: {@link Metadata#getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "FieldMetadata Metadata.getFieldMetadata(String, String, List, SupportedFieldType, SupportedFieldType, Type, Class, FieldMetadata, MergedPropertyType, DynamicEntityDao)"})
  public void testGetFieldMetadataWithPrefixPropertyNameComponentPropertiesTypeSecondaryTypeEntityTypeTargetClassPresentationAttributeMergedPropertyTypeDynamicEntityDao3() {
    // Arrange
    when(fieldMetadataProvider.addMetadataFromMappingData(Mockito.<AddMetadataFromMappingDataRequest>any(),
        Mockito.<FieldMetadata>any())).thenReturn(MetadataProviderResponse.HANDLED);

    ArrayList<FieldMetadataProvider> fieldMetadataProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(fieldMetadataProviderList.iterator());
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType entityType = new BigDecimalType();
    Class<Object> targetClass = Object.class;
    FieldMetadata presentationAttribute = mock(FieldMetadata.class);
    when(presentationAttribute.getTargetClass()).thenReturn("Target Class");
    doNothing().when(presentationAttribute).setAvailableToTypes(Mockito.<String[]>any());
    doNothing().when(presentationAttribute).setInheritedFromType(Mockito.<String>any());

    // Act
    FieldMetadata actualFieldMetadata = metadata.getFieldMetadata("Prefix", "Property Name", componentProperties,
        SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, entityType, targetClass, presentationAttribute,
        MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Assert
    verify(list).iterator();
    verify(presentationAttribute).getTargetClass();
    verify(presentationAttribute).setAvailableToTypes(isA(String[].class));
    verify(presentationAttribute).setInheritedFromType(eq("java.lang.Object"));
    verify(fieldMetadataProvider).addMetadataFromMappingData(isA(AddMetadataFromMappingDataRequest.class),
        isA(FieldMetadata.class));
    assertSame(presentationAttribute, actualFieldMetadata);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Metadata#setDefaultFieldMetadataProvider(FieldMetadataProvider)}
   *   <li>{@link Metadata#setFieldMetadataProviders(List)}
   *   <li>{@link Metadata#getDefaultFieldMetadataProvider()}
   *   <li>{@link Metadata#getFieldMetadataProviders()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldMetadataProvider Metadata.getDefaultFieldMetadataProvider()",
      "List Metadata.getFieldMetadataProviders()",
      "void Metadata.setDefaultFieldMetadataProvider(FieldMetadataProvider)",
      "void Metadata.setFieldMetadataProviders(List)"})
  public void testGettersAndSetters() {
    // Arrange
    Metadata metadata = new Metadata();
    AdornedTargetCollectionFieldMetadataProvider defaultFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act
    metadata.setDefaultFieldMetadataProvider(defaultFieldMetadataProvider);
    ArrayList<FieldMetadataProvider> fieldMetadataProviders = new ArrayList<>();
    metadata.setFieldMetadataProviders(fieldMetadataProviders);
    FieldMetadataProvider actualDefaultFieldMetadataProvider = metadata.getDefaultFieldMetadataProvider();
    List<FieldMetadataProvider> actualFieldMetadataProviders = metadata.getFieldMetadataProviders();

    // Assert
    assertTrue(actualDefaultFieldMetadataProvider instanceof AdornedTargetCollectionFieldMetadataProvider);
    assertTrue(actualFieldMetadataProviders.isEmpty());
    assertSame(fieldMetadataProviders, actualFieldMetadataProviders);
    assertSame(defaultFieldMetadataProvider, actualDefaultFieldMetadataProvider);
  }
}
