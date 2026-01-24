package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdornedTargetCollectionMetadata.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CollectionMetadataDiffblueTest {
  @Autowired private CollectionMetadata collectionMetadata;

  /**
   * Test {@link CollectionMetadata#getPersistencePerspective()}.
   *
   * <p>Method under test: {@link CollectionMetadata#getPersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistencePerspective CollectionMetadata.getPersistencePerspective()"})
  public void testGetPersistencePerspective() {
    // Arrange, Act and Assert
    assertNull(new AdornedTargetCollectionMetadata().getPersistencePerspective());
  }

  /**
   * Test {@link CollectionMetadata#setPersistencePerspective(PersistencePerspective)}.
   *
   * <p>Method under test: {@link
   * CollectionMetadata#setPersistencePerspective(PersistencePerspective)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionMetadata.setPersistencePerspective(PersistencePerspective)"})
  public void testSetPersistencePerspective() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Assert
    assertSame(persistencePerspective, adornedTargetCollectionMetadata.getPersistencePerspective());
  }

  /**
   * Test {@link CollectionMetadata#getCollectionCeilingEntity()}.
   *
   * <p>Method under test: {@link CollectionMetadata#getCollectionCeilingEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CollectionMetadata.getCollectionCeilingEntity()"})
  public void testGetCollectionCeilingEntity() {
    // Arrange, Act and Assert
    assertNull(new AdornedTargetCollectionMetadata().getCollectionCeilingEntity());
  }

  /**
   * Test {@link CollectionMetadata#setCollectionCeilingEntity(String)}.
   *
   * <p>Method under test: {@link CollectionMetadata#setCollectionCeilingEntity(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionMetadata.setCollectionCeilingEntity(String)"})
  public void testSetCollectionCeilingEntity() {
    // Arrange and Act
    collectionMetadata.setCollectionCeilingEntity("Collection Ceiling Entity");

    // Assert
    assertTrue(collectionMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Collection Ceiling Entity", collectionMetadata.getCollectionCeilingEntity());
  }

  /**
   * Test {@link CollectionMetadata#isMutable()}.
   *
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor) Mutable is {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#isMutable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionMetadata.isMutable()"})
  public void testIsMutable_givenAdornedTargetCollectionMetadataMutableIsFalse_thenReturnFalse() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setMutable(false);

    // Act and Assert
    assertFalse(adornedTargetCollectionMetadata.isMutable());
  }

  /**
   * Test {@link CollectionMetadata#isMutable()}.
   *
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#isMutable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CollectionMetadata.isMutable()"})
  public void testIsMutable_givenAdornedTargetCollectionMetadata_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new AdornedTargetCollectionMetadata().isMutable());
  }

  /**
   * Test {@link CollectionMetadata#getCustomCriteria()}.
   *
   * <p>Method under test: {@link CollectionMetadata#getCustomCriteria()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] CollectionMetadata.getCustomCriteria()"})
  public void testGetCustomCriteria() {
    // Arrange, Act and Assert
    assertNull(new AdornedTargetCollectionMetadata().getCustomCriteria());
  }

  /**
   * Test {@link CollectionMetadata#setCustomCriteria(String[])}.
   *
   * <p>Method under test: {@link CollectionMetadata#setCustomCriteria(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionMetadata.setCustomCriteria(String[])"})
  public void testSetCustomCriteria() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    String[] customCriteria = new String[] {"Custom Criteria"};

    // Act
    adornedTargetCollectionMetadata.setCustomCriteria(customCriteria);

    // Assert
    assertSame(customCriteria, adornedTargetCollectionMetadata.getCustomCriteria());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   *
   * <p>Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata CollectionMetadata.populate(FieldMetadata)"})
  public void testPopulate() {
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setAdditionalMetadata(new HashMap<>());

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata.populate(metadata);

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    PersistencePerspective persistencePerspective2 =
        ((AdornedTargetCollectionMetadata) actualPopulateResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    ForeignKey[] additionalForeignKeys2 = persistencePerspective2.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(
        new String[] {"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getExcludeFields());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   *
   * <p>Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata CollectionMetadata.populate(FieldMetadata)"})
  public void testPopulate2() {
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setAdditionalMetadata(new HashMap<>());

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata.populate(metadata);

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    PersistencePerspective persistencePerspective2 =
        ((AdornedTargetCollectionMetadata) actualPopulateResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    ForeignKey[] additionalForeignKeys2 = persistencePerspective2.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(
        new String[] {"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   *
   * <p>Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata CollectionMetadata.populate(FieldMetadata)"})
  public void testPopulate3() {
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setAdditionalMetadata(new HashMap<>());

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata.populate(metadata);

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    PersistencePerspective persistencePerspective2 =
        ((AdornedTargetCollectionMetadata) actualPopulateResult).getPersistencePerspective();
    ForeignKey[] additionalForeignKeys2 = persistencePerspective2.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(
        new String[] {"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getExcludeFields());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   *
   * <p>Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata CollectionMetadata.populate(FieldMetadata)"})
  public void testPopulate4() {
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setAdditionalMetadata(new HashMap<>());

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata.populate(metadata);

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    PersistencePerspective persistencePerspective2 =
        ((AdornedTargetCollectionMetadata) actualPopulateResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertArrayEquals(
        new String[] {"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getExcludeFields());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   *
   * <p>Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata CollectionMetadata.populate(FieldMetadata)"})
  public void testPopulate5() {
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setAdditionalMetadata(new HashMap<>());

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata.populate(metadata);

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    PersistencePerspective persistencePerspective2 =
        ((AdornedTargetCollectionMetadata) actualPopulateResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    ForeignKey[] additionalForeignKeys2 = persistencePerspective2.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getExcludeFields());
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   *
   * <p>Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata CollectionMetadata.populate(FieldMetadata)"})
  public void testPopulate6() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, adornedTargetList);
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setAdditionalMetadata(new HashMap<>());

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata.populate(metadata);

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems2 =
        ((AdornedTargetCollectionMetadata) actualPopulateResult)
            .getPersistencePerspective()
            .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems2.size());
    PersistencePerspectiveItem getResult =
        persistencePerspectiveItems2.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult instanceof AdornedTargetList);
    assertEquals(adornedTargetList, getResult);
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   *
   * <p>Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata CollectionMetadata.populate(FieldMetadata)"})
  public void testPopulate7() {
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setAvailableToTypes(new String[] {"Available To Types"});
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setAdditionalMetadata(new HashMap<>());

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata.populate(metadata);

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    assertEquals(adornedTargetCollectionMetadata, metadata);
    assertEquals(adornedTargetCollectionMetadata, actualPopulateResult);
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   *
   * <p>Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata CollectionMetadata.populate(FieldMetadata)"})
  public void testPopulate8() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new ForeignKey());
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
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(new String[] {"foo"});
    persistencePerspective.setIncludeFields(new String[] {"foo"});

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setAdditionalMetadata(new HashMap<>());

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata.populate(metadata);

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems2 =
        ((AdornedTargetCollectionMetadata) actualPopulateResult)
            .getPersistencePerspective()
            .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems2.size());
    PersistencePerspectiveItem getResult =
        persistencePerspectiveItems2.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult instanceof ForeignKey);
    assertEquals(foreignKey, getResult);
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   *
   * <ul>
   *   <li>Then {@link AdornedTargetCollectionMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata CollectionMetadata.populate(FieldMetadata)"})
  public void testPopulate_thenAdornedTargetCollectionMetadata() {
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setAdditionalMetadata(new HashMap<>());

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata.populate(metadata);

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    assertEquals(adornedTargetCollectionMetadata, metadata);
    assertEquals(adornedTargetCollectionMetadata, actualPopulateResult);
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}, and {@link CollectionMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionMetadata.equals(Object)",
    "int CollectionMetadata.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 =
        new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
    assertEquals(
        adornedTargetCollectionMetadata.hashCode(), adornedTargetCollectionMetadata2.hashCode());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}, and {@link CollectionMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionMetadata.equals(Object)",
    "int CollectionMetadata.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
    assertEquals(
        adornedTargetCollectionMetadata.hashCode(), adornedTargetCollectionMetadata2.hashCode());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}, and {@link CollectionMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionMetadata.equals(Object)",
    "int CollectionMetadata.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCollectionCeilingEntity("Collection Ceiling Entity");

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setCollectionCeilingEntity("Collection Ceiling Entity");

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
    assertEquals(
        adornedTargetCollectionMetadata.hashCode(), adornedTargetCollectionMetadata2.hashCode());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionMetadata.equals(Object)",
    "int CollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AdornedTargetCollectionMetadata(), mock(AdornedTargetCollectionMetadata.class));
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionMetadata.equals(Object)",
    "int CollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionMetadata.equals(Object)",
    "int CollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCollectionCeilingEntity("Collection Ceiling Entity");

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionMetadata.equals(Object)",
    "int CollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCustomCriteria(new String[] {"Custom Criteria"});

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionMetadata.equals(Object)",
    "int CollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CollectionMetadata.equals(Object)",
    "int CollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setCollectionCeilingEntity("Collection Ceiling Entity");

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
  }
}
