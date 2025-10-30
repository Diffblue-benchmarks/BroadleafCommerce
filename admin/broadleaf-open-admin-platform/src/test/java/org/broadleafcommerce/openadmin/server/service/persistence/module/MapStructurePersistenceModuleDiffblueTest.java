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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MapStructure;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.Property;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MapStructurePersistenceModuleDiffblueTest {
  @InjectMocks
  private MapStructurePersistenceModule mapStructurePersistenceModule;

  /**
   * Test {@link MapStructurePersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>When {@code MAP}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructurePersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MapStructurePersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenMap_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(mapStructurePersistenceModule.isCompatible(OperationType.MAP));
  }

  /**
   * Test {@link MapStructurePersistenceModule#isCompatible(OperationType)}.
   * <ul>
   *   <li>When {@code NONDESTRUCTIVEREMOVE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructurePersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MapStructurePersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenNondestructiveremove_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(mapStructurePersistenceModule.isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_givenHashMap_thenArrayListEmpty() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_givenProperty_whenHashMap_thenArrayListSizeIsOne() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(new Property());

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(1, properties.size());
    assertTrue(properties.get(0).getMetadata() instanceof BasicFieldMetadata);
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_givenProperty_whenHashMap_thenArrayListSizeIsTwo() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(new Property());
    properties.add(new Property());

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertEquals(2, properties.size());
    assertTrue(properties.get(0).getMetadata() instanceof BasicFieldMetadata);
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_thenArrayListFirstNameIs42() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("42", new AdornedTargetCollectionMetadata());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, null);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

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
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_thenArrayListFirstNameIsFoo() throws NumberFormatException {
    // Arrange
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
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@link MergedPropertyType#MAPSTRUCTUREKEY} is {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_whenHashMapMapstructurekeyIsHashMap_thenArrayListEmpty()
      throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, new HashMap<>());
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, null);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MapStructurePersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_whenHashMap_thenArrayListEmpty() throws NumberFormatException {
    // Arrange
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapStructurePersistenceModule#procureSandBoxMapValue(MapStructure, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.Serializable MapStructurePersistenceModule.procureSandBoxMapValue(MapStructure, Entity)"})
  public void testProcureSandBoxMapValue_given42_thenThrowRuntimeException() {
    // Arrange
    MapStructure mapStructure = mock(MapStructure.class);
    when(mapStructure.getValueClassName()).thenReturn("42");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> mapStructurePersistenceModule.procureSandBoxMapValue(mapStructure, new Entity()));
    verify(mapStructure).getValueClassName();
  }
}
