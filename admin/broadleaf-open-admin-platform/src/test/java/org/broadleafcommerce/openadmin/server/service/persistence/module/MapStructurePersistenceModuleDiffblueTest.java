package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.Property;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MapStructurePersistenceModuleDiffblueTest {
  /**
   * Test {@link MapStructurePersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Given {@link MapStructurePersistenceModule} (default constructor).
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
  public void testExtractProperties_givenMapStructurePersistenceModule_thenArrayListEmpty()
      throws NumberFormatException {
    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule =
        new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, new HashMap<>());
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
    MapStructurePersistenceModule mapStructurePersistenceModule =
        new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, stringFieldMetadataMap);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, new HashMap<>());
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
  public void testExtractProperties_thenArrayListSizeIsOne2() throws NumberFormatException {
    // Arrange
    MapStructurePersistenceModule mapStructurePersistenceModule =
        new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, new HashMap<>());
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
    MapStructurePersistenceModule mapStructurePersistenceModule =
        new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("42", new AdornedTargetCollectionMetadata());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREKEY, stringFieldMetadataMap);
    mergedProperties.put(MergedPropertyType.MAPSTRUCTUREVALUE, new HashMap<>());
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
    MapStructurePersistenceModule mapStructurePersistenceModule =
        new MapStructurePersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    mapStructurePersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }
}
