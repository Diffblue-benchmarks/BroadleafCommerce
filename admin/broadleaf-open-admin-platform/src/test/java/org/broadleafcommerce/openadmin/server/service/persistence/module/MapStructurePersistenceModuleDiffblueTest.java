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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.junit.Test;
import org.mockito.Mockito;

public class MapStructurePersistenceModuleDiffblueTest {
  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MapStructurePersistenceModule()).isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
    assertTrue((new MapStructurePersistenceModule()).isCompatible(OperationType.MAP));
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertFalse(mapStructurePersistenceModule.isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties2() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties3() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, new HashMap<>());
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, null);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties4() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    Property property = new Property();
    properties.add(property);

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertSame(property, properties.get(0));
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties5() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    Property property = new Property();
    properties.add(property);
    Property property2 = new Property();
    properties.add(property2);

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(2, properties.size());
    assertSame(property, properties.get(0));
    assertSame(property2, properties.get(1));
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties6() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties7() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

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
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties8() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("42", adornedTargetCollectionMetadata);
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata2);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(2, properties.size());
    Property getResult = properties.get(0);
    assertEquals("42", getResult.getName());
    Property getResult2 = properties.get(1);
    assertEquals("foo", getResult2.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
    assertSame(adornedTargetCollectionMetadata2, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties9() throws NumberFormatException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

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
   * Method under test:
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}
   */
  @Test
  public void testProcureSandBoxMapValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("42");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure, new Entity()));
    verify(mapStructure).getValueClassName();
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}
   */
  @Test
  public void testProcureSandBoxMapValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setPersistenceManager(persistenceManager);
    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("java.lang.String");

    // Act
    Serializable actualProcureSandBoxMapValueResult = mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure,
        new Entity());

    // Assert
    verify(mapStructure).getValueClassName();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
    assertNull(actualProcureSandBoxMapValueResult);
  }

  /**
   * Method under test:
   * {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}
   */
  @Test
  public void testProcureSandBoxMapValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getIdMetadata(Mockito.<Class<Object>>any())).thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    MapStructurePersistenceModule mapStructurePersistenceModule = new MapStructurePersistenceModule();
    mapStructurePersistenceModule.setPersistenceManager(persistenceManager);
    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("java.lang.String");
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new IllegalStateException("name"));
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure, entity));
    verify(entity).findProperty(isNull());
    verify(mapStructure).getValueClassName();
    verify(property).getValue();
    verify(dynamicEntityDao).getIdMetadata(isA(Class.class));
  }
}
