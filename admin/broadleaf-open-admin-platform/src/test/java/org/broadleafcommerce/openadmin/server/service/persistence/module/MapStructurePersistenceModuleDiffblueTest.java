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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MapStructure;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class MapStructurePersistenceModuleDiffblueTest {
  @InjectMocks private MapStructurePersistenceModule mapStructurePersistenceModule;

  /**
   * Test {@link MapStructurePersistenceModule#isCompatible(OperationType)}.
   *
   * <ul>
   *   <li>When {@code MAP}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapStructurePersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenMap_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(mapStructurePersistenceModule.isCompatible(OperationType.MAP));
  }

  /**
   * Test {@link MapStructurePersistenceModule#isCompatible(OperationType)}.
   *
   * <ul>
   *   <li>When {@code NONDESTRUCTIVEREMOVE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapStructurePersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenNondestructiveremove_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(mapStructurePersistenceModule.isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_givenHashMap_thenArrayListEmpty() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link HashMap#HashMap()} {@link MergedPropertyType#MAPSTRUCTUREKEY} is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_givenHashMap_whenHashMapMapstructurekeyIsHashMap()
      throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, new HashMap<>());
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, null);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_thenArrayListSizeIsOne() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_thenArrayListSizeIsTwo() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("42", new AdornedTargetCollectionMetadata());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(2, properties.size());
    assertEquals("42", properties.get(0).getName());
    Property getResult = properties.get(1);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@link MergedPropertyType#MAPSTRUCTUREKEY} is {@link
   *       HashMap#HashMap()}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_whenHashMapMapstructurekeyIsHashMap_thenArrayListSizeIsOne()
      throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, stringFieldMetadataMap);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, null);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_whenHashMap_thenArrayListEmpty() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Serializable MapStructurePersistenceModule.procureSandBoxMapValue(MapStructure, Entity)"
  })
  public void testProcureSandBoxMapValue_given42_thenThrowRuntimeException() {
    // Arrange
    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("42");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure, new Entity()));
    verify(mapStructure).getValueClassName();
  }

  /**
   * Test {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Serializable MapStructurePersistenceModule.procureSandBoxMapValue(MapStructure, Entity)"
  })
  public void testProcureSandBoxMapValue_givenNull_whenEntityFindPropertyReturnNull() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<?>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    MapStructurePersistenceModule mapStructurePersistenceModule =
        new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setPersistenceManager(persistenceManager);

    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("java.lang.String");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    Serializable actualProcureSandBoxMapValueResult =
        mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure, entity);

    // Assert
    verify(entity).findProperty(null);
    verify(mapStructure).getValueClassName();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    assertNull(actualProcureSandBoxMapValueResult);
  }

  /**
   * Test {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicEntityDaoImpl#find(Class, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Serializable MapStructurePersistenceModule.procureSandBoxMapValue(MapStructure, Entity)"
  })
  public void testProcureSandBoxMapValue_thenCallsFind() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.find(Mockito.<Class<?>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalStateException());
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<?>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    MapStructurePersistenceModule mapStructurePersistenceModule =
        new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setPersistenceManager(persistenceManager);

    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("java.lang.String");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("name", "42"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure, entity));
    verify(entity).findProperty(null);
    verify(mapStructure).getValueClassName();
    verify(dynamicEntityDao).find(isA(Class.class), isA(Object.class));
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
  }

  /**
   * Test {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Serializable MapStructurePersistenceModule.procureSandBoxMapValue(MapStructure, Entity)"
  })
  public void testProcureSandBoxMapValue_thenCallsGetValue() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<?>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    MapStructurePersistenceModule mapStructurePersistenceModule =
        new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setPersistenceManager(persistenceManager);

    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("java.lang.String");

    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new IllegalStateException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure, entity));
    verify(entity).findProperty(null);
    verify(mapStructure).getValueClassName();
    verify(property).getValue();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
  }

  /**
   * Test {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Serializable MapStructurePersistenceModule.procureSandBoxMapValue(MapStructure, Entity)"
  })
  public void testProcureSandBoxMapValue_thenReturnNull() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<?>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    MapStructurePersistenceModule mapStructurePersistenceModule =
        new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setPersistenceManager(persistenceManager);

    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("java.lang.String");

    // Act
    Serializable actualProcureSandBoxMapValueResult =
        mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure, new Entity());

    // Assert
    verify(mapStructure).getValueClassName();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    assertNull(actualProcureSandBoxMapValueResult);
  }
}
