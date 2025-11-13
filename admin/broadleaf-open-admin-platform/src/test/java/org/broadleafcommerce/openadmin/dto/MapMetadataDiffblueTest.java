package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitorAdapter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class MapMetadataDiffblueTest {
  /**
   * Test {@link MapMetadata#accept(MetadataVisitor)}.
   *
   * <ul>
   *   <li>When {@link MetadataVisitorAdapter} {@link MetadataVisitorAdapter#visit(MapMetadata)}
   *       does nothing.
   *   <li>Then calls {@link MetadataVisitorAdapter#visit(MapMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#accept(MetadataVisitor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapMetadata.accept(MetadataVisitor)"})
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
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata MapMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey foreignKey = new ForeignKey();
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {foreignKey};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(new String[] {"foo"});
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[] {new ForeignKey()});
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(new String[] {"foo"});
    persistencePerspective.setIncludeFields(null);

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 =
        ((MapMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    ForeignKey[] additionalForeignKeys2 = persistencePerspective2.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(
        new String[] {"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getExcludeFields());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata MapMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata2() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey foreignKey = new ForeignKey();
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {foreignKey};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(new String[] {"foo"});
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[] {new ForeignKey()});
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(new String[] {"foo"});

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 =
        ((MapMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    ForeignKey[] additionalForeignKeys2 = persistencePerspective2.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(
        new String[] {"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata MapMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata3() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey foreignKey = new ForeignKey();
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {foreignKey};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(new String[] {"foo"});
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[] {new ForeignKey()});
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(new String[] {"foo"});
    persistencePerspective.setIncludeFields(new String[] {"foo"});

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 =
        ((MapMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    ForeignKey[] additionalForeignKeys2 = persistencePerspective2.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(
        new String[] {"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getExcludeFields());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata MapMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata4() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(new String[] {"foo"});
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(new String[] {"foo"});
    persistencePerspective.setIncludeFields(new String[] {"foo"});

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 =
        ((MapMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertArrayEquals(
        new String[] {"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getExcludeFields());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata MapMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata5() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey foreignKey = new ForeignKey();
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {foreignKey};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[] {new ForeignKey()});
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(new String[] {"foo"});
    persistencePerspective.setIncludeFields(new String[] {"foo"});

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    PersistencePerspective persistencePerspective2 =
        ((MapMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    ForeignKey[] additionalForeignKeys2 = persistencePerspective2.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getExcludeFields());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata MapMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata6() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(new String[] {"foo"});
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[] {new ForeignKey()});
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(new String[] {"foo"});
    persistencePerspective.setIncludeFields(new String[] {"foo"});

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    assertEquals(
        persistencePerspectiveItems,
        ((MapMetadata) actualCloneFieldMetadataResult)
            .getPersistencePerspective()
            .getPersistencePerspectiveItems());
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata MapMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata7() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(new String[] {"foo"});
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[] {new ForeignKey()});
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(new String[] {"foo"});
    persistencePerspective.setIncludeFields(new String[] {"foo"});

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setAvailableToTypes(new String[] {"Available To Types"});
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    assertEquals(mapMetadata, actualCloneFieldMetadataResult);
  }

  /**
   * Test {@link MapMetadata#cloneFieldMetadata()}.
   *
   * <ul>
   *   <li>Then return {@link MapMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata MapMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata_thenReturnMapMetadata() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(new String[] {"foo"});
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[] {new ForeignKey()});
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(new String[] {"foo"});
    persistencePerspective.setIncludeFields(new String[] {"foo"});

    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = mapMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof MapMetadata);
    assertEquals(mapMetadata, actualCloneFieldMetadataResult);
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    MapMetadata mapMetadata2 = new MapMetadata();

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    assertEquals(mapMetadata.hashCode(), mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setValueClassName("42");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setValueClassName("42");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    assertEquals(mapMetadata.hashCode(), mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMediaField("Media Field");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMediaField("Media Field");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    assertEquals(mapMetadata.hashCode(), mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyValueProperty("42");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyValueProperty("42");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    assertEquals(mapMetadata.hashCode(), mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyOptionEntityClass("Map Key Option Entity Class");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    assertEquals(mapMetadata.hashCode(), mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    assertEquals(mapMetadata.hashCode(), mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityValueField("42");

    MapMetadata mapMetadata2 = new MapMetadata();
    mapMetadata2.setMapKeyOptionEntityValueField("42");

    // Act and Assert
    assertEquals(mapMetadata, mapMetadata2);
    assertEquals(mapMetadata.hashCode(), mapMetadata2.hashCode());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}, and {@link MapMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapMetadata#equals(Object)}
   *   <li>{@link MapMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapMetadata(), 1);
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setValueClassName("42");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setSimpleValue(true);

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMediaField("Media Field");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyValueProperty("42");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityClass("Map Key Option Entity Class");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityDisplayField("Map Key Option Entity Display Field");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setMapKeyOptionEntityValueField("42");

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MapMetadata mapMetadata = new MapMetadata();
    mapMetadata.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(mapMetadata, new MapMetadata());
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapMetadata(), null);
  }

  /**
   * Test {@link MapMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapMetadata.equals(Object)", "int MapMetadata.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapMetadata(), "Different type to MapMetadata");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MapMetadata.<init>()",
    "Boolean MapMetadata.getForceFreeFormKeys()",
    "String[][] MapMetadata.getKeys()",
    "String MapMetadata.getMapKeyOptionEntityClass()",
    "String MapMetadata.getMapKeyOptionEntityDisplayField()",
    "String MapMetadata.getMapKeyOptionEntityValueField()",
    "String MapMetadata.getMapKeyValueProperty()",
    "String MapMetadata.getMediaField()",
    "String MapMetadata.getToOneParentProperty()",
    "String MapMetadata.getToOneTargetProperty()",
    "String MapMetadata.getValueClassName()",
    "boolean MapMetadata.isSimpleValue()",
    "void MapMetadata.setForceFreeFormKeys(Boolean)",
    "void MapMetadata.setKeys(String[][])",
    "void MapMetadata.setMapKeyOptionEntityClass(String)",
    "void MapMetadata.setMapKeyOptionEntityDisplayField(String)",
    "void MapMetadata.setMapKeyOptionEntityValueField(String)",
    "void MapMetadata.setMapKeyValueProperty(String)",
    "void MapMetadata.setMediaField(String)",
    "void MapMetadata.setSimpleValue(boolean)",
    "void MapMetadata.setToOneParentProperty(String)",
    "void MapMetadata.setToOneTargetProperty(String)",
    "void MapMetadata.setValueClassName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MapMetadata actualMapMetadata = new MapMetadata();
    actualMapMetadata.setForceFreeFormKeys(true);
    String[][] keys = new String[][] {new String[] {"Keys"}};
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
    String actualMapKeyOptionEntityDisplayField =
        actualMapMetadata.getMapKeyOptionEntityDisplayField();
    String actualMapKeyOptionEntityValueField = actualMapMetadata.getMapKeyOptionEntityValueField();
    String actualMapKeyValueProperty = actualMapMetadata.getMapKeyValueProperty();
    String actualMediaField = actualMapMetadata.getMediaField();
    String actualToOneParentProperty = actualMapMetadata.getToOneParentProperty();
    String actualToOneTargetProperty = actualMapMetadata.getToOneTargetProperty();
    String actualValueClassName = actualMapMetadata.getValueClassName();
    boolean actualIsSimpleValueResult = actualMapMetadata.isSimpleValue();

    // Assert
    assertEquals("42", actualMapKeyOptionEntityValueField);
    assertEquals("42", actualMapKeyValueProperty);
    assertEquals("42", actualValueClassName);
    assertEquals("Map Key Option Entity Class", actualMapKeyOptionEntityClass);
    assertEquals("Map Key Option Entity Display Field", actualMapKeyOptionEntityDisplayField);
    assertEquals("Media Field", actualMediaField);
    assertEquals("To One Parent Property", actualToOneParentProperty);
    assertEquals("To One Target Property", actualToOneTargetProperty);
    assertNull(actualMapMetadata.getChildrenExcluded());
    assertNull(actualMapMetadata.getExcluded());
    assertNull(actualMapMetadata.getLazyFetch());
    assertNull(actualMapMetadata.getGroupOrder());
    assertNull(actualMapMetadata.getOrder());
    assertNull(actualMapMetadata.getTabOrder());
    assertNull(actualMapMetadata.getCollectionCeilingEntity());
    assertNull(actualMapMetadata.getAddFriendlyName());
    assertNull(actualMapMetadata.getCurrencyCodeField());
    assertNull(actualMapMetadata.getFieldName());
    assertNull(actualMapMetadata.getFriendlyName());
    assertNull(actualMapMetadata.getGroup());
    assertNull(actualMapMetadata.getInheritedFromType());
    assertNull(actualMapMetadata.getOwningClass());
    assertNull(actualMapMetadata.getOwningClassFriendlyName());
    assertNull(actualMapMetadata.getPrefix());
    assertNull(actualMapMetadata.getSecurityLevel());
    assertNull(actualMapMetadata.getShowIfProperty());
    assertNull(actualMapMetadata.getTab());
    assertNull(actualMapMetadata.getTargetClass());
    assertNull(actualMapMetadata.getCustomCriteria());
    assertNull(actualMapMetadata.getAvailableToTypes());
    assertNull(actualMapMetadata.getShowIfFieldEquals());
    assertNull(actualMapMetadata.getPersistencePerspective());
    assertEquals(1, actualKeys.length);
    assertTrue(actualMapMetadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualMapMetadata.isMutable());
    assertTrue(actualForceFreeFormKeys);
    assertTrue(actualIsSimpleValueResult);
    assertSame(keys, actualKeys);
    assertArrayEquals(new String[] {"Keys"}, actualKeys[0]);
  }
}
