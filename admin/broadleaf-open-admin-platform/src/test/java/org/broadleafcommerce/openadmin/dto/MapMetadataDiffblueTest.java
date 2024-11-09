/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitorAdapter;
import org.junit.Test;
import org.mockito.Mockito;

public class MapMetadataDiffblueTest {
  /**
   * Test {@link MapMetadata#accept(MetadataVisitor)}.
   * <ul>
   *   <li>When {@link MetadataVisitorAdapter}
   * {@link MetadataVisitorAdapter#visit(MapMetadata)} does nothing.</li>
   *   <li>Then calls {@link MetadataVisitorAdapter#visit(MapMetadata)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#accept(MetadataVisitor)}
   */
  @Test
  public void testAccept_whenMetadataVisitorAdapterVisitDoesNothing_thenCallsVisit() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    MetadataVisitorAdapter visitor = mock(MetadataVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<MapMetadata>any());

    // Act
    mapMetadata.accept(visitor);

    // Assert
    verify(visitor).visit(isA(MapMetadata.class));
  }

  /**
   * Test {@link MapMetadata#populate(FieldMetadata)}.
   * <p>
   * Method under test: {@link MapMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(new String[]{"foo"});
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = mapMetadata.populate(new MapMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 = ((MapMetadata) actualPopulateResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
  }

  /**
   * Test {@link MapMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}
   * PersistencePerspectiveItems is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate_givenPersistencePerspectivePersistencePerspectiveItemsIsHashMap() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = mapMetadata.populate(new MapMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 = ((MapMetadata) actualPopulateResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
  }

  /**
   * Test {@link MapMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate_thenReturnArrayLengthIsOne() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    ForeignKey foreignKey = new ForeignKey();
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[]{foreignKey});
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = mapMetadata.populate(new MapMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof MapMetadata);
    ForeignKey[] additionalForeignKeys = ((MapMetadata) actualPopulateResult).getPersistencePerspective()
        .getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertEquals(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link MapMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate_thenReturnArrayLengthIsZero() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = mapMetadata.populate(new MapMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 = ((MapMetadata) actualPopulateResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
  }

  /**
   * Test {@link MapMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return PersistencePerspective ExcludeFields is array of
   * {@link String} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate_thenReturnPersistencePerspectiveExcludeFieldsIsArrayOfStringWithFoo() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(new String[]{"foo"});
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = mapMetadata.populate(new MapMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 = ((MapMetadata) actualPopulateResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getExcludeFields());
  }

  /**
   * Test {@link MapMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return PersistencePerspective IncludeFields is array of
   * {@link String} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate_thenReturnPersistencePerspectiveIncludeFieldsIsArrayOfStringWithFoo() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(new String[]{"foo"});

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = mapMetadata.populate(new MapMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 = ((MapMetadata) actualPopulateResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(new String[]{"foo"});

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 = ((MapMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(new String[]{"foo"});
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 = ((MapMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getExcludeFields());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 = ((MapMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata4() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(new String[]{"foo"});
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 = ((MapMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata5() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    assertEquals(persistencePerspectiveItems,
        ((MapMetadata) actualCloneFieldMetadataResult).getPersistencePerspective().getPersistencePerspectiveItems());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code FOREIGNKEY} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata_givenHashMapComputeIfPresentForeignkeyAndBiFunction() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.computeIfPresent(PersistencePerspectiveItemType.FOREIGNKEY, mock(BiFunction.class));
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    assertEquals(persistencePerspectiveItems,
        ((MapMetadata) actualCloneFieldMetadataResult).getPersistencePerspective().getPersistencePerspectiveItems());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata_thenReturnArrayLengthIsOne() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    ForeignKey foreignKey = new ForeignKey();
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[]{foreignKey});
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    ForeignKey[] additionalForeignKeys = ((MapMetadata) actualCloneFieldMetadataResult).getPersistencePerspective()
        .getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertEquals(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  public void testCloneFieldMetadata_thenReturnArrayLengthIsZero() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 = ((MapMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    MapMetadata mapMetadata2 = new MapMetadata();

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    int expectedHashCodeResult = mapMetadata.hashCode();
    assertEquals(expectedHashCodeResult, mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setValueClassName("42");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setValueClassName("42");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    int expectedHashCodeResult = mapMetadata.hashCode();
    assertEquals(expectedHashCodeResult, mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMediaField("Media Field");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMediaField("Media Field");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    int expectedHashCodeResult = mapMetadata.hashCode();
    assertEquals(expectedHashCodeResult, mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyValueProperty("42");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyValueProperty("42");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    int expectedHashCodeResult = mapMetadata.hashCode();
    assertEquals(expectedHashCodeResult, mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyOptionEntityClass("Map Key Option Entity Class");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    int expectedHashCodeResult = mapMetadata.hashCode();
    assertEquals(expectedHashCodeResult, mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    int expectedHashCodeResult = mapMetadata.hashCode();
    assertEquals(expectedHashCodeResult, mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityValueField("42");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyOptionEntityValueField("42");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    int expectedHashCodeResult = mapMetadata.hashCode();
    assertEquals(expectedHashCodeResult, mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata);
    int expectedHashCodeResult = mapMetadata.hashCode();
    assertEquals(expectedHashCodeResult, mapMetadata.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapMetadata(), 1);
    assertNotEquals(new MapMetadata(), mock(AdornedTargetCollectionMetadata.class));
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setValueClassName("42");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setSimpleValue(true);

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMediaField("Media Field");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyValueProperty("42");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityValueField("42");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setValueClassName("42");

    // Act and Assert
    assertNotEquals(mapMetadata, mapMetadata2);
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMediaField("Media Field");

    // Act and Assert
    assertNotEquals(mapMetadata, mapMetadata2);
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyValueProperty("42");

    // Act and Assert
    assertNotEquals(mapMetadata, mapMetadata2);
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyOptionEntityClass("Map Key Option Entity Class");

    // Act and Assert
    assertNotEquals(mapMetadata, mapMetadata2);
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");

    // Act and Assert
    assertNotEquals(mapMetadata, mapMetadata2);
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyOptionEntityValueField("42");

    // Act and Assert
    assertNotEquals(mapMetadata, mapMetadata2);
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapMetadata(), null);
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapMetadata(), "Different type to MapMetadata");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MapMetadata}
   *   <li>{@link MapMetadata#setForceFreeFormKeys(Boolean)}
   *   <li>{@link MapMetadata#setKeys(String[][])}
   *   <li>{@link MapMetadata#setMapKeyOptionEntityClass(String)}
   *   <li>{@link MapMetadata#setMapKeyOptionEntityDisplayField(String)}
   *   <li>{@link MapMetadata#setMapKeyOptionEntityValueField(String)}
   *   <li>{@link MapMetadata#setMapKeyValueProperty(String)}
   *   <li>{@link MapMetadata#setMediaField(String)}
   *   <li>{@link MapMetadata#setSimpleValue(boolean)}
   *   <li>{@link MapMetadata#setToOneParentProperty(String)}
   *   <li>{@link MapMetadata#setToOneTargetProperty(String)}
   *   <li>{@link MapMetadata#setValueClassName(String)}
   *   <li>{@link MapMetadata#getForceFreeFormKeys()}
   *   <li>{@link MapMetadata#getKeys()}
   *   <li>{@link MapMetadata#getMapKeyOptionEntityClass()}
   *   <li>{@link MapMetadata#getMapKeyOptionEntityDisplayField()}
   *   <li>{@link MapMetadata#getMapKeyOptionEntityValueField()}
   *   <li>{@link MapMetadata#getMapKeyValueProperty()}
   *   <li>{@link MapMetadata#getMediaField()}
   *   <li>{@link MapMetadata#getToOneParentProperty()}
   *   <li>{@link MapMetadata#getToOneTargetProperty()}
   *   <li>{@link MapMetadata#getValueClassName()}
   *   <li>{@link MapMetadata#isSimpleValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MapMetadata actualMapMetadata = new MapMetadata();
    actualMapMetadata.setForceFreeFormKeys(true);
    String[][] keys = new String[][]{new String[]{"Keys"}};
    actualMapMetadata.setKeys(keys);
    actualMapMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");
    actualMapMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");
    actualMapMetadata.setMapKeyOptionEntityValueField("42");
    actualMapMetadata.setMapKeyValueProperty("42");
    actualMapMetadata.setMediaField("Media Field");
    actualMapMetadata.setSimpleValue(true);
    actualMapMetadata.setToOneParentProperty("To One Parent Property");
    actualMapMetadata.setToOneTargetProperty("To One Target Property");
    actualMapMetadata.setValueClassName("42");
    Boolean actualForceFreeFormKeys = actualMapMetadata.getForceFreeFormKeys();
    String[][] actualKeys = actualMapMetadata.getKeys();
    String actualMapKeyOptionEntityClass = actualMapMetadata.getMapKeyOptionEntityClass();
    String actualMapKeyOptionEntityDisplayField = actualMapMetadata.getMapKeyOptionEntityDisplayField();
    String actualMapKeyOptionEntityValueField = actualMapMetadata.getMapKeyOptionEntityValueField();
    String actualMapKeyValueProperty = actualMapMetadata.getMapKeyValueProperty();
    String actualMediaField = actualMapMetadata.getMediaField();
    String actualToOneParentProperty = actualMapMetadata.getToOneParentProperty();
    String actualToOneTargetProperty = actualMapMetadata.getToOneTargetProperty();
    String actualValueClassName = actualMapMetadata.getValueClassName();
    boolean actualIsSimpleValueResult = actualMapMetadata.isSimpleValue();

    // Assert that nothing has changed
    assertEquals("42", actualMapKeyOptionEntityValueField);
    assertEquals("42", actualMapKeyValueProperty);
    assertEquals("42", actualValueClassName);
    assertEquals("Map Key Option Entity Class", actualMapKeyOptionEntityClass);
    assertEquals("Map Key Option Entity Display Field", actualMapKeyOptionEntityDisplayField);
    assertEquals("Media Field", actualMediaField);
    assertEquals("To One Parent Property", actualToOneParentProperty);
    assertEquals("To One Target Property", actualToOneTargetProperty);
    assertEquals(1, actualKeys.length);
    assertTrue(actualMapMetadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualMapMetadata.isMutable());
    assertTrue(actualForceFreeFormKeys);
    assertTrue(actualIsSimpleValueResult);
    assertSame(keys, actualKeys);
    assertArrayEquals(new String[]{"Keys"}, actualKeys[0]);
  }
}
